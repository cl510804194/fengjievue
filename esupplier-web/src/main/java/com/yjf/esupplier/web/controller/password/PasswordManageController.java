package com.yjf.esupplier.web.controller.password;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.CommonUtil;
import com.yjf.esupplier.common.util.MD5Util;
import com.yjf.esupplier.common.util.MoneyUtil;
import com.yjf.esupplier.common.util.RSAUtils;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.enums.PasswordTypeEnum;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.order.PwdInfoOrder;
import com.yjf.esupplier.service.user.order.ValidForgetPasswordUrlOrder;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.controller.base.Image;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.enums.UserRegisterFromEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 *
 *
 * @Filename ForgetPassword.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author zjl
 *
 * @Email zjialin@yiji.com
 *
 * @History <li>Author: zjl</li> <li>Date: 2013-7-18</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
@Controller
@RequestMapping("PasswordManage")
public class PasswordManageController extends BaseAutowiredController {

	private final String VM_PATH = "/front/password/";
	private final String md5AddString = "S1as#%DF#@D*(=-@@!";

	@RequestMapping("newLogPasswordMail")
	public String newLogPasswordMail(HttpSession session) throws Exception {
		return VM_PATH + "newLogPasswordMail.vm";
	}

	// 找回密码
	@RequestMapping("forgetLogPassword.htm")
	public String forgetLogPassword(HttpSession session, Model model) throws Exception {
		addRandomToken(session, model);
		return VM_PATH + "forgetLogPassword.vm";
	}

	private void addRandomToken(HttpSession session, Model model) {
		String randomToken = UUID.randomUUID().toString();
		String md5 = MD5Util.getMD5_32(randomToken + md5AddString);
		session.setAttribute("randomMD5", md5);
		model.addAttribute("randomMD5", md5);
	}

	// 修改密码
	@RequestMapping("modifyPassword.htm")
	public String newPassword(HttpSession session, Model model) throws Exception {
		String randomToken = UUID.randomUUID().toString();
		String md5 = MD5Util.getMD5_32(randomToken + md5AddString);
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		UserInfo userBaseInfo = userQueryService.queryByUserId(userId).getQueryUserInfo();
		session.setAttribute("randomMD5", md5);
		model.addAttribute("randomMD5", md5);
		String md5UserBaseId = MD5Util.getMD5_32(userBaseInfo.getUserBaseId() + md5AddString
				+ randomToken);
		session.setAttribute("randomToken", randomToken);
		session.setAttribute("md5UserBaseId", md5UserBaseId);
		model.addAttribute("md5UserBaseId", md5UserBaseId);
		session.setAttribute("userBaseId", userBaseInfo.getUserBaseId());
		model.addAttribute("userBaseId", userBaseInfo.getUserBaseId());
		return VM_PATH + "modifyPassword.vm";
	}
	
	
	
	// 修改支付密码
	@RequestMapping("modifyPayPassword.htm")
	public String newPayword(HttpSession session, Model model) throws Exception {
		String randomToken = UUID.randomUUID().toString();
		String md5 = MD5Util.getMD5_32(randomToken + md5AddString);
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		UserQueryResult userQueryResult = new UserQueryResult();
		UserInfo userBaseInfo = userQueryService.queryByUserId(userId).getQueryUserInfo();
		session.setAttribute("randomMD5", md5);
		model.addAttribute("randomMD5", md5);
		String md5UserBaseId = MD5Util.getMD5_32(userBaseInfo.getUserBaseId() + md5AddString
				+ randomToken);
		session.setAttribute("randomToken", randomToken);
		session.setAttribute("md5UserBaseId", md5UserBaseId);
		model.addAttribute("md5UserBaseId", md5UserBaseId);
		session.setAttribute("userBaseId", userBaseInfo.getUserBaseId());
		model.addAttribute("userBaseId", userBaseInfo.getUserBaseId());
		return VM_PATH + "modifyPayword.vm";
	}
	
	@ResponseBody
	@RequestMapping("checkPayPasswordSubmit.json")
	public Object checkPayPasswordSubmit(String payPwd, HttpServletRequest request,
			   HttpSession session) throws Exception {
		JSONObject jsonobj = new JSONObject();
		String fk_money = request.getParameter("fk_money");
		String ykt_money = request.getParameter("ykt_money");
		Boolean canFK = MoneyUtil.compareString(ykt_money, fk_money);
		if(!canFK){
			jsonobj.put("code",0);
			jsonobj.put("message","一卡通余额不足！");
			return jsonobj;
		}
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();		
		if (StringUtil.isEmpty(payPwd)) {
			jsonobj.put("code",0);
			jsonobj.put("message","余额支付密码不能为空！");
			return jsonobj;
		}
		payPwd = MD5Util.getMD5_32(payPwd).toUpperCase();
		if (!userQueryService.checkPayPassword(userId, payPwd)) {
			jsonobj.put("code",0);
			jsonobj.put("message","余额支付密码错误,请重新输入！");
			return jsonobj;
		}else{
			jsonobj.put("code",1);
		}
		return jsonobj;
	}
	// 修改支付密码
	@ResponseBody
	@RequestMapping("modifyPayPasswordSubmit.json")
	public Object newPaywordSubmit(String oldPassword, String newPassword,
			   String newPasswordTo, String type, String userBaseId,
			   String md5UserBaseId, HttpServletRequest request,
			   HttpSession session) throws Exception {
		JSONObject jsonobj = new JSONObject();
		if (!checkRandom(request, session)) {
			jsonobj.put("code", "0");
			jsonobj.put("message", "页面缓存失效，请重试");
			return jsonobj;
		}

		if (CheckMd5UserBD.checkMd5UserBD(session, md5UserBaseId, userBaseId)) {
			EsupplierBaseResult returnEnum = new EsupplierBaseResult();
			oldPassword = RSAUtils.decryptStringByJs(oldPassword);
			newPassword = RSAUtils.decryptStringByJs(newPassword);
			newPasswordTo = RSAUtils.decryptStringByJs(newPasswordTo);
			PwdInfoOrder pwdInfoOrder = new PwdInfoOrder();
			pwdInfoOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			pwdInfoOrder.setPasswdType(PasswordTypeEnum.PAY_PASSWORD);
			pwdInfoOrder.setOldPwd(oldPassword);
			pwdInfoOrder.setNewPwd(newPassword);
			returnEnum = userBaseInfoManager.updateUserPassword(pwdInfoOrder);
			if (returnEnum.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "设置新支付密码成功");
			} else if (returnEnum.getCreditsysResultEnum() == EsupplierResultEnum.PASSWORD_ERROR) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "旧支付密码输入不正确");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", returnEnum.getMessage());
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改支付密码失败!");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("modifyPasswordSubmit.json")
	public Object modifyPasswordSubmit(String oldPassword, String newPassword,
									   String newPasswordTo, String type, String userBaseId,
									   String md5UserBaseId, HttpServletRequest request,
									   HttpSession session) throws Exception {
		JSONObject jsonobj = new JSONObject();
		if (!checkRandom(request, session)) {
			jsonobj.put("code", "0");
			jsonobj.put("message", "页面缓存失效，请重试");
			return jsonobj;
		}

		if (CheckMd5UserBD.checkMd5UserBD(session, md5UserBaseId, userBaseId)) {
			EsupplierBaseResult returnEnum = new EsupplierBaseResult();
			oldPassword = RSAUtils.decryptStringByJs(oldPassword);
			newPassword = RSAUtils.decryptStringByJs(newPassword);
			newPasswordTo = RSAUtils.decryptStringByJs(newPasswordTo);
			PwdInfoOrder pwdInfoOrder = new PwdInfoOrder();
			pwdInfoOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			pwdInfoOrder.setPasswdType(PasswordTypeEnum.LOGIN_PASSWORD);
			pwdInfoOrder.setOldPwd(oldPassword);
			pwdInfoOrder.setNewPwd(newPassword);
			returnEnum = userBaseInfoManager.updateUserPassword(pwdInfoOrder);
			if (returnEnum.isSuccess()) {
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

	private boolean checkRandom(HttpServletRequest request, HttpSession session) {
		String randomMD5 = request.getParameter("randomMD5");
		String randomMd5old = (String) session.getAttribute("randomMD5");
		if (StringUtil.isEmpty(randomMd5old) || !randomMd5old.equals(randomMD5)) {
			return false;
		}
		return true;
	}
	@RequestMapping("checkVerify.htm")
	public String checkVerify(HttpSession session, String userName, String randomMD5,
							  String imgCode, Model model, HttpServletRequest request)
			throws Exception {

		if (!Image.checkImgCode(session, imgCode)) {
			model.addAttribute("erroMes", "验证码错误");
			addRandomToken(session, model);
			return VM_PATH + "forgetLogPassword.vm";
		}
		return null;
	}

	@RequestMapping("userNameSubmit.htm")
	public String userNameSubmit(HttpSession session, String userName, String mobile ,String randomMD5,
								 String imgCode, Model model, HttpServletRequest request)
			throws Exception {

		if (!Image.checkImgCode(session, imgCode)) {
			model.addAttribute("erroMes", "验证码错误");
			addRandomToken(session, model);
			return VM_PATH + "forgetLogPassword.vm";
		}
		if(userName == null){
			userName = "";
		}
		if (userName.equals("admin")) {
			model.addAttribute("erroMes", "用户名不存在");
			addRandomToken(session, model);
			return VM_PATH + "forgetLogPassword.vm";
		}
		if (!checkRandom(request, session)) {
			model.addAttribute("erroMes", "页面缓存失效，请重试");
			addRandomToken(session, model);
			return VM_PATH + "forgetLogPassword.vm";
		}
		UserInfo userBaseInfo = userQueryService.queryByMobile(mobile).getQueryUserInfo();
//		UserInfo userBaseInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (userBaseInfo != null) {
			model.addAttribute("isExist", true);
			model.addAttribute("canGetPassword", true);
			if (StringUtil.isNotEmpty(userBaseInfo.getMobile())
					&& userBaseInfo.getMobileBinding() == BooleanEnum.IS) {
				SessionLocal sessionLocal = new SessionLocal();
				sessionLocal.addAttibute("appRegist", true);
				ShiroSessionUtils.setSessionLocal(sessionLocal);
				session.setAttribute("mobile", userBaseInfo.getMobile());
				session.setAttribute("userBaseId", userBaseInfo.getUserBaseId());
				logger.info(" CommonUtil.viewMoblie(userBaseInfo.getMobile()) = "+ CommonUtil.viewMoblie(userBaseInfo.getMobile()));
				model.addAttribute("strMobile", CommonUtil.viewMoblie(userBaseInfo.getMobile()));
				String randomToken = UUID.randomUUID().toString();
				session.setAttribute("randomToken", randomToken);
				String md5UserBaseId = MD5Util.getMD5_32(userBaseInfo.getUserBaseId()
						+ md5AddString + randomToken);
				model.addAttribute("md5UserBaseId", md5UserBaseId);
				model.addAttribute("randomMD5", randomMD5);
				model.addAttribute("userBaseId", userBaseInfo.getUserBaseId());
				return VM_PATH + "forgetLogPassword2.vm";
			}
			if (StringUtil.isNotEmpty(userBaseInfo.getMail())
					&& userBaseInfo.getMailBinding() == BooleanEnum.IS) {
				session.setAttribute("newLogPasswordChoice", userBaseInfo);
				return newLogPasswordMailOk(userName, userBaseInfo.getMail(), null, session, model,
						"mailFind");
			}

			model.addAttribute("canGetPassword", false);

		} else {
			model.addAttribute("isExist", false);
		}

		return VM_PATH + "forgetLogPassword2.vm";
	}

	/**
	 * 金交宝2种找回密码方式
	 *
	 */
	@RequestMapping("userNameSubmitJJB")
	public String userNameSubmitJJB(HttpSession session, String userName, String randomMD5,
									String imgCode, String checkType, Model model) throws Exception {

		if (!Image.checkImgCode(session, imgCode)) {
			model.addAttribute("erroMes", "验证码错误");
			return VM_PATH + "forgetLogPassword.vm";
		}
		UserInfo userBaseInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (userBaseInfo != null) {
			model.addAttribute("isExist", true);
			model.addAttribute("canGetPassword", true);
			if ("mobile".equals(checkType)) {
				if (StringUtil.isNotEmpty(userBaseInfo.getMobile())
						&& userBaseInfo.getMobileBinding() == BooleanEnum.IS) {
					SessionLocal sessionLocal = new SessionLocal();
					sessionLocal.addAttibute("appRegist", true);
					ShiroSessionUtils.setSessionLocal(sessionLocal);
					session.setAttribute("mobile", userBaseInfo.getMobile());
					session.setAttribute("userBaseId", userBaseInfo.getUserBaseId());
					model
							.addAttribute("strMobile", CommonUtil.viewMoblie(userBaseInfo.getMobile()));
					String randomToken = UUID.randomUUID().toString();
					session.setAttribute("randomToken", randomToken);
					String md5UserBaseId = MD5Util.getMD5_32(userBaseInfo.getUserBaseId()
							+ md5AddString + randomToken);
					model.addAttribute("md5UserBaseId", md5UserBaseId);
					model.addAttribute("randomMD5", randomMD5);
					model.addAttribute("userBaseId", userBaseInfo.getUserBaseId());
					return VM_PATH + "toForgetLogPassword.vm";
				} else {
					model.addAttribute("erroMes", "手机号码不存在");
					addRandomToken(session, model);
					return VM_PATH + "forgetLogPassword.vm";
				}
			} else if ("mail".equals(checkType)) {
				if (StringUtil.isNotEmpty(userBaseInfo.getMail())) {
					session.setAttribute("newLogPasswordChoice", userBaseInfo);
					return newLogPasswordMailOk(userName, userBaseInfo.getMail(), null, session,
							model, "mailFind");
				} else {
					model.addAttribute("erroMes", "邮箱不存在");
					addRandomToken(session, model);
					return VM_PATH + "forgetLogPassword.vm";
				}
			} else {
				model.addAttribute("erroMes", "请选择方式");
				model.addAttribute("canGetPassword", false);
				addRandomToken(session, model);
				return VM_PATH + "forgetLogPassword.vm";
			}

		} else {
			model.addAttribute("isExist", false);
		}

		return VM_PATH + "toForgetLogPassword.vm";
	}

	@ResponseBody
	@RequestMapping("verifySmsCodeForgetPassWord.json")
	public Object verifySmsCodeForgetPassWord(String mobile, String business, String code,
											  String randomMD5, String md5UserBaseId,
											  String userBaseId, Model model,
											  HttpSession session, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		String mobiles = (String) session.getAttribute("mobile");
		SmsCodeResult smsCodeResult = this.smsManagerService.verifySmsCode(mobiles,
				SmsBizType.ForgetLoginPassWord, code, false);
		if (smsCodeResult.isSuccess()) {
			json.put("code", "1");
			json.put("message", "验证成功");
		} else {
			json.put("code", "0");
			json.put("message", "验证码错误");
		}
		return json;
	}

	/**
	 * 校验验证码
	 *
	 */
	@RequestMapping("checSmsCode.htm")
	public Object checSmsCode(String mobile, String business, String code, String randomMD5,
							  String md5UserBaseId, String userBaseId, Model model,
							  HttpSession session, HttpServletRequest request) {
		try {

			if (!checkRandom(request, session)) {
				model.addAttribute("erroMes", "页面缓存失效，请重试");
				return VM_PATH + "forgetLogPassword.vm";
			}
			String mobiles = (String) session.getAttribute("mobile");
			SmsCodeResult smsCodeResult = this.smsManagerService.verifySmsCode(mobiles,
					SmsBizType.ForgetLoginPassWord, code, true);
			String userbaseId = (String) session.getAttribute("userBaseId");
			if (smsCodeResult.isSuccess()
					&& CheckMd5UserBD.checkMd5UserBD(session, md5UserBaseId, userbaseId)) {
				model.addAttribute("checSmsCode", true);
				model.addAttribute("md5UserBaseId", md5UserBaseId);
				model.addAttribute("randomMD5", randomMD5);
				model.addAttribute("userBaseId", userBaseId);
				session.setAttribute("checSmsCode", true);
				return VM_PATH + "forgetLogPassword3.vm";
			}

			model.addAttribute("isExist", true);
			model.addAttribute("checSmsCodeFail", true);
			model.addAttribute("strMobile", CommonUtil.viewMoblie(mobiles));
			model.addAttribute("message", smsCodeResult.getMessage());
			model.addAttribute("md5UserBaseId", md5UserBaseId);
			model.addAttribute("userBaseId", userBaseId);
		} catch (NullPointerException e) {
			model.addAttribute("message", "请先获取验证码");
		}
		return VM_PATH + "forgetLogPassword2.vm";
	}

	/**
	 * 更新密码
	 *
	 * @throws Exception
	 *
	 */
	@ResponseBody
	@RequestMapping("updatePassword.json")
	public Object updatePassword(String oldPassword, String newPassword, String newPasswordTo,
								 String randomMD5, String md5UserBaseId, String userBaseId,
								 Model model, HttpSession session, HttpServletRequest request)
			throws Exception {
		String userbaseId = (String) session.getAttribute("userBaseId");
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		JSONObject json = new JSONObject();
		try {

			if (!checkRandom(request, session)) {
				json.put("code", "0");
				json.put("message", "页面缓存失效，请重试");
				return json;
			}
			if (CheckMd5UserBD.checkMd5UserBD(session, md5UserBaseId, userbaseId)) {
				newPassword = RSAUtils.decryptStringByJs(newPassword);
				baseResult = userBaseInfoManager.forgetPassword(userbaseId, newPassword);
				if (baseResult.isSuccess()) {
					ShiroSessionUtils.clear();
					json.put("code", "1");
					json.put("message", "修改密码成功");
					return json;
				} else {
					json.put("code", "0");
					json.put("message", "修改密码失败");
					return json;
				}

			} else {
				json.put("code", "0");
				json.put("message", "用户标示失效，修改密码失败");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			json.put("code", "0");
			json.put("message", "修改密码失败");
		}
		return json;

	}

	/**
	 * 重新获取验证码
	 */
	@ResponseBody
	@RequestMapping("reGetSms.json")
	public Object reGetSms(HttpSession session, HttpServletRequest request) {
		EsupplierBaseResult baseResult = sendSmsUnLogin((String) session.getAttribute("mobile"),
				request);
		JSONObject jsonobj = new JSONObject();
		if (baseResult.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", baseResult.getMessage());
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", baseResult.getMessage());
		}
		return jsonobj;
	}

	/**
	 * 未登陆用户获取验证码
	 */

	private EsupplierBaseResult sendSmsUnLogin(String mobile, HttpServletRequest request) {
		SessionLocal sessionLocal = new SessionLocal();
		sessionLocal.addAttibute("appRegist", true);
		sessionLocal.setRemoteAddr(IPUtil.getIpAddr(request));
		ShiroSessionUtils.setSessionLocal(sessionLocal);
		EsupplierBaseResult baseResult = smsManagerService.sendSmsCode(mobile,
				SmsBizType.getByCode("ForgetLoginPassWord"), null);
		return baseResult;
	}

	@RequestMapping("newLogPasswordMailOk")
	public String newLogPasswordMailOk(String userName, String mail, String code,
									   HttpSession session, Model model, String findType)
			throws Exception {
		if (StringUtil.equals("mailFind", findType)) {// 找回方式为邮箱找回
			UserInfo userBaseInfo = (UserInfo) session.getAttribute("newLogPasswordChoice");
			if (userBaseInfo != null
					&& UserRegisterFromEnum.PLAT != userBaseInfo.getUserRegisterFrom()) {
				model.addAttribute("error", "易极付账户请到易极付或重庆银行电子银行界面找回密码");
				return VM_PATH + "newLogPassword.vm";
			}
			mail = userBaseInfo.getMail();
			userBaseInfoManager.sendForgetPassword(userBaseInfo.getUserName());
			String mainUrl = "http://mail."
					+ mail.substring(mail.lastIndexOf('@') + 1, mail.lastIndexOf("."))
					+ ".com";

			String[] strMail = mail.split("@");
			model.addAttribute("userName", userName);
			model.addAttribute("mainUrl", mainUrl);
			model.addAttribute("mail", mail);
			model.addAttribute("mailStr", strMail[0].substring(0, 3) + "********@" + strMail[1]);
			return VM_PATH + "newLogPasswordMailOk.vm";
		} else {// 找回方式为手机校验码找回
			UserInfo userBaseInfo = (UserInfo) session.getAttribute("newLogPasswordChoice");
			if (userBaseInfo.getMailBinding() == BooleanEnum.IS
					&& userBaseInfo.getMobileBinding() != BooleanEnum.IS) {
				return "common/error.htm";
			} else {
				if (StringUtil.isNotBlank(userBaseInfo.getMobile())) {
					String mobile = userBaseInfo.getMobile();
					if (mobile != null && !"".equals(mobile)) {
						model.addAttribute(
								"mobile",
								mobile.substring(0, 3) + "*****"
										+ mobile.subSequence(mobile.length() - 3, mobile.length()));
					} else {
						model.addAttribute("mobile", mobile);
					}
					session.setAttribute("validForgetPasswordMessage", "true");
					model.addAttribute("userName", userBaseInfo.getAccountName());
					model.addAttribute("findType", findType);
					return VM_PATH + "newLogPasswordMailOk.vm";
				}
			}
			return "common/error.htm";
		}
	}

	@RequestMapping("newLogPasswordChoice")
	public String newLogPasswordChoice(String userName, HttpSession session, String captcha,
									   Model model) throws Exception {
		if (Image.checkImgCode(session, captcha)) {
			UserInfo userBaseInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
			if (userBaseInfo != null) {
				model.addAttribute("userInfo", userBaseInfo);
				session.setAttribute("newLogPasswordChoice", userBaseInfo);
				if (!StringUtil.equals("", userBaseInfo.getMail())) {
					String[] strMail = userBaseInfo.getMail().split("@");
					model.addAttribute("mailStr", strMail[0].substring(0, 3) + "********@"
							+ strMail[1]);
				}
				if (!StringUtil.equals("", userBaseInfo.getMobile())) {
					String mobile = userBaseInfo.getMobile();
					model.addAttribute(
							"mobile",
							mobile.substring(0, 3) + "*****"
									+ mobile.subSequence(mobile.length() - 3, mobile.length()));
				}

				return VM_PATH + "newLogPasswordChoose.vm";

			} else {
				return VM_PATH + "newPasswordNo.vm";
			}
		} else {
			return VM_PATH + "newPasswordNo.vm";
		}
	}

	@RequestMapping("ForgetLogPassword/{md5UserBaseId},{sendTime},{userBaseId}")
	public String ForgetLogPassword(HttpSession session, @PathVariable String md5UserBaseId,
									@PathVariable String sendTime, @PathVariable String userBaseId,
									Model model) throws Exception {

		if (sendTime == null || "".equals(sendTime)) {
			model.addAttribute("reason", "邮件链接异常,请重发!");
			return VM_PATH + "sendMailNo.vm";
		}
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		ValidForgetPasswordUrlOrder urlOrder = new ValidForgetPasswordUrlOrder();
		urlOrder.setMd5Url(md5UserBaseId);
		urlOrder.setSendTime(sendTime);
		urlOrder.setUserBaseId(userBaseId);
		EsupplierBaseResult baseResult = userBaseInfoManager.validForgetPasswordUrl(urlOrder);
		if (baseResult.isSuccess()) {
			String randomToken = UUID.randomUUID().toString();
			session.setAttribute("randomToken", randomToken);
			md5UserBaseId = MD5Util.getMD5_32(userBaseId + md5AddString + randomToken);

			String randomMD5 = "00";
			session.setAttribute("userBaseId", userBaseId);
			session.setAttribute("randomMD5", "00");
			model.addAttribute("checSmsCode", true);
			model.addAttribute("md5UserBaseId", md5UserBaseId);
			model.addAttribute("randomMD5", randomMD5);
			session.setAttribute("checSmsCode", true);
			return VM_PATH + "newPssaword.vm";

		} else {
			model.addAttribute("reason", baseResult.getMessage());
			return VM_PATH + "sendMailNo.vm";
		}

	}

	@RequestMapping(value = "NewLogPassword", method = RequestMethod.POST)
	public String NewLogPassword(HttpSession session, String md5UserBaseId, String logPassword,
								 String newLogPassword, String type, String token, Model model)
			throws Exception {
		if (!StringUtil.isEmpty(type)) {
			String getToken = (String) session.getAttribute("token");
			if (getToken == null || !getToken.equalsIgnoreCase(token)) {
				return VM_PATH + "newPasswordNo.vm";// 重复提交
			}
			UserInfo userBaseInfo = (UserInfo) session.getAttribute("userInfo");
			String validForgetPasswordUrl = (String) session.getAttribute("validForgetPasswordUrl");
			if (StringUtil.equals(validForgetPasswordUrl, "true")) {
				EsupplierBaseResult baseResult = userBaseInfoManager.forgetPassword(
						userBaseInfo.getUserBaseId(), logPassword);
				if (baseResult.isSuccess()) {
					session.removeAttribute("userInfo");
					session.removeAttribute("validForgetPasswordUrl");
					return VM_PATH + "newPasswordOk.vm";
				}
			}
			return VM_PATH + "newPasswordNo.vm";// 修改登录密码出错啦
		} else {// 手机方式
			String getToken = (String) session.getAttribute("token");
			if (getToken == null || !getToken.equalsIgnoreCase(token)) {
				return VM_PATH + "newPasswordNo.vm";// 重复提交
			}
			UserInfo userBaseInfo = (UserInfo) session.getAttribute("newLogPasswordChoice");
			String validForgetPasswordUrl = (String) session
					.getAttribute("validForgetPasswordMessage");
			if (StringUtil.equals(validForgetPasswordUrl, "true")) {
				EsupplierBaseResult baseResult = userBaseInfoManager.forgetPassword(
						userBaseInfo.getUserBaseId(), logPassword);
				if (baseResult.isSuccess()) {
					session.removeAttribute("userInfo");
					session.removeAttribute("validForgetPasswordMessage");
					return VM_PATH + "newPasswordOk.vm";
				}
			}
			return VM_PATH + "newPasswordNo.vm";// 修改登录密码出错啦
		}
	}

}