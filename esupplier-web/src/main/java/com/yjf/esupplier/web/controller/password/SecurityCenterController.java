package com.yjf.esupplier.web.controller.password;

import javax.servlet.http.HttpSession;

import com.yjf.esupplier.service.user.enums.PasswordTypeEnum;
import com.yjf.esupplier.service.user.order.MobileBindingOrder;
import com.yjf.esupplier.service.user.order.PwdInfoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.RSAUtils;
import com.yjf.esupplier.integration.openapi.order.MobileBindOrder;
import com.yjf.esupplier.integration.openapi.order.RegisterOrder;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.common.services.order.SystemSendMessageOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.enums.SysSendMessageTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Controller
@RequestMapping("/do/security")
public class SecurityCenterController extends BaseAutowiredController {
	
	private final String VM_PATH = "/front/security/";
	
	@ResponseBody
	@RequestMapping("updatePassword.json")
	public Object updatePassword(String password, String newPassword, String newPasswordTo,
									String type, String userBaseId, String md5UserBaseId,
									HttpSession session) throws Exception {
		JSONObject jsonobj = new JSONObject();
		if (CheckMd5UserBD.checkMd5UserBD(session, md5UserBaseId, userBaseId)) {
			EsupplierBaseResult returnEnum = new EsupplierBaseResult();
			password = RSAUtils.decryptStringByJs(password);
			newPassword = RSAUtils.decryptStringByJs(newPassword);
			newPasswordTo = RSAUtils.decryptStringByJs(newPasswordTo);
			PwdInfoOrder pwdInfoOrder = new PwdInfoOrder();
			pwdInfoOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			pwdInfoOrder.setPasswdType(PasswordTypeEnum.LOGIN_PASSWORD);
			pwdInfoOrder.setOldPwd(password);
			pwdInfoOrder.setNewPwd(newPassword);
			returnEnum = userBaseInfoManager.updateUserPassword(pwdInfoOrder);
			if (returnEnum.isSuccess()) {
				ShiroSessionUtils.clear();
				jsonobj.put("code", 1);
				jsonobj.put("message", "设置新密码成功");
			} else if (returnEnum.getCreditsysResultEnum() == EsupplierResultEnum.PASSWORD_ERROR) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "旧密码输入不正确");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", returnEnum.getMessage());
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改密码失败!");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("boundMobile.json")
	public JSONObject boundMobile(String mobile, String code) throws Exception {
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		JSONObject jsonobj = new JSONObject();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
			ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(mobile,
			SmsBizType.NEWCELLPHONE, code, true);
		if (!smsCodeResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "验证码校验失败");
			return jsonobj;
		}
		
		userBaseInfo.setMobile(mobile);
		MobileBindingOrder mobileBindingOrder = new MobileBindingOrder();
		mobileBindingOrder.setUserBaseId(userBaseInfo.getUserBaseId());
		mobileBindingOrder.setMobile(mobile);
		returnEnum = userBaseInfoManager.mobileBinding(mobileBindingOrder);
		if (returnEnum.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改绑定手机成功");
			
			/** 发送站内信 **/
			SystemSendMessageOrder systemSendMessageOrder = new SystemSendMessageOrder();
			systemSendMessageOrder.setType(SysSendMessageTypeEnum.PHONE_CHANGE);
			//			systemSendMessageOrder.setUserId(userBaseInfo.getUserId());
			systemMessageService.systemSendMessage(systemSendMessageOrder);
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改绑定手机失败");
		}
		
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("updateBoundMobile.json")
	public Object updateBoundMobile(String confirmUserBaseId, String code, HttpSession session,
									String userBaseId, String md5UserBaseId) throws Exception {
		JSONObject jsonobj = new JSONObject();
		if (CheckMd5UserBD.checkMd5UserBD(session, md5UserBaseId, userBaseId)) {
			session.removeAttribute("updateBoundMobileValid");
			if (!StringUtil.equalsIgnoreCase(ShiroSessionUtils.getSessionLocal().getUserBaseId(),
				confirmUserBaseId)) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "亲！页面已经过期，请刷新页面");
				return jsonobj;
			}
			
			UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
				ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(userBaseInfo.getMobile(),
				SmsBizType.CELLPHONE, code, true);
			
			if (!smsCodeResult.isSuccess()) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "验证码校验失败");
			} else {
				session.setAttribute("updateBoundMobileValid", "true");
				jsonobj.put("code", 1);
				jsonobj.put("message", "验证码校验成功");
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "验证码校验失败");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("updateBoundMobileSecond.json")
	public Object updateBoundMobileSecond(String confirmUserBaseId, String newMobile,
											String codeSecond, HttpSession session)
																					throws Exception {
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		JSONObject jsonobj = new JSONObject();
		if (!StringUtil.equalsIgnoreCase(ShiroSessionUtils.getSessionLocal().getUserBaseId(),
			confirmUserBaseId)) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "亲！页面已经过期，请刷新页面");
			return jsonobj;
		}
		if (!"true".equals(session.getAttribute("updateBoundMobileValid"))) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "亲！页面已经过期，请刷新页面");
			return jsonobj;
		}
		session.removeAttribute("updateBoundMobileValid");
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
			ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(newMobile,
			SmsBizType.NEWCELLPHONE, codeSecond, true);
		if (!smsCodeResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "验证码校验失败");
			return jsonobj;
		}
		
		userBaseInfo.setMobile(newMobile);
		MobileBindOrder mobileBindOrder = new MobileBindOrder();
		mobileBindOrder.setUserId(userBaseInfo.getAccountId());
		mobileBindOrder.setMobile(newMobile);
		mobileBindOrder.setIsNew(BooleanEnum.NO);
		EsupplierBaseResult baseResult = this.customerService.updateMobileBinding(mobileBindOrder,
			this.getOpenApiContext());
		if (baseResult.isSuccess()) {
			MobileBindingOrder mobileBindingOrder = new MobileBindingOrder();
			mobileBindingOrder.setUserBaseId(userBaseInfo.getUserBaseId());
			mobileBindingOrder.setMobile(newMobile);
			returnEnum = userBaseInfoManager.mobileBinding(mobileBindingOrder);
			if (returnEnum.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "修改绑定手机成功");
				
				/** 发送站内信 **/
				SystemSendMessageOrder systemSendMessageOrder = new SystemSendMessageOrder();
				systemSendMessageOrder.setType(SysSendMessageTypeEnum.PHONE_CHANGE);
				//				systemSendMessageOrder.setUserId(userBaseInfo.getUserId());
				systemMessageService.systemSendMessage(systemSendMessageOrder);
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "修改绑定手机失败");
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改绑定手机失败");
		}
		
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("boundUpdateMail.json")
	public Object boundUpdateMail(String newMail, String mailCode) throws Exception {
		JSONObject jsonobj = new JSONObject();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
			ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
		
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(userBaseInfo.getMobile(),
			SmsBizType.PERSONAL, mailCode, true);
		if (!smsCodeResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "验证码校验失败");
			return jsonobj;
		}
		
		RegisterOrder order = new RegisterOrder();
		order.setUserId(userBaseInfo.getAccountId());
		order.setEmail(newMail);
		EsupplierBaseResult customerResult = customerService.openCapitalAccount(order,
			this.getOpenApiContext());
		if (!customerResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改绑定邮箱失败");
		}
		returnEnum = userBaseInfoManager.mailBinding(userBaseInfo.getUserBaseId(), newMail);
		if (returnEnum.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改绑定邮箱成功");
			
			/** 发送站内信 **/
			SystemSendMessageOrder systemSendMessageOrder = new SystemSendMessageOrder();
			systemSendMessageOrder.setType(SysSendMessageTypeEnum.EMAIL_CHANGE);
			//			systemSendMessageOrder.setUserId(userBaseInfo.getUserId());
			systemMessageService.systemSendMessage(systemSendMessageOrder);
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改绑定邮箱失败");
		}
		return jsonobj;
	}
	
	@RequestMapping("boundPhone")
	public String boundPhone(HttpSession session, Model model) throws Exception {
		session.setAttribute("current", 4);
		return VM_PATH + "boundPhone.vm";
	}
	
}
