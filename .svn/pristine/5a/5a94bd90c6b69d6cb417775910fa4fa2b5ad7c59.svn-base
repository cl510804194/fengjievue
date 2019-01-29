package com.yjf.esupplier.web.controller.front.account;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjf.esupplier.ws.enums.LoginFromTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.ip.IPUtil;
import com.yjf.esupplier.common.util.RSAUtils;
import com.yjf.esupplier.integration.openapi.CustomerService;
import com.yjf.esupplier.integration.openapi.SMSService;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.web.server.YjfLoginWebServer;
import com.yjf.esupplier.service.login.LoginService;
import com.yjf.esupplier.service.login.order.UserLoginOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.RegisterService;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.PersonalInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.order.LoadActivateUserInfoOrder;
import com.yjf.esupplier.service.user.order.UserActivateOrder;
import com.yjf.esupplier.service.user.query.UserQueryService;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.base.BaseController;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * 
 * @Filename ActivateController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-8-19</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("/anon")
public class ActivateController extends BaseController {
	private final String vm_path = "/front/anon/activate/";
	
	private static final String PHONE_VALIDATE_CODE = "PHONE_VALIDATE_CODE";
	private static final String PHONE_VALIDATE = "access_phone_validate";
	@Autowired
	RegisterService registerService;
	
	@Autowired
	YjfLoginWebServer yjfLoginWebServer;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	SMSService smsService;
	
	@Autowired
	UserQueryService userQueryService;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("userRegister.htm")
	public String investorsOpen(HttpSession session, HttpServletResponse response) {
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		// return vm_path + "investorsOpen.vm";
		EsupplierBaseResult esupplierBaseResult = registerService
			.userRegisterByOnlyRegisterYjfUser();
		sendUrl(response, esupplierBaseResult.getUrl());
		return null;
	}
	
	@RequestMapping("activate/{MD5UserBaseId}.htm")
	public String activationUser(HttpSession session, @PathVariable String MD5UserBaseId,
									Model model, HttpServletResponse response,
									HttpServletRequest request) {
		LoadActivateUserInfoOrder activateUserInfoOrder = new LoadActivateUserInfoOrder();
		activateUserInfoOrder.setDate(request.getParameter("date"));
		activateUserInfoOrder.setUserBaseId(request.getParameter("userBaseId"));
		activateUserInfoOrder.setMd5Url(MD5UserBaseId);
		UserQueryResult userQResult = this.registerService
			.getActivateUserInfo(activateUserInfoOrder);
		if (userQResult.getQueryUserInfo() == null) {
			// return 激活链接失效
			UserInfo userInfo = userQueryService.queryByUserBaseId(
				activateUserInfoOrder.getUserBaseId()).getQueryUserInfo();
			if (userInfo != null) {
				model.addAttribute("userName", userInfo.getUserName());
				model.addAttribute("reason", "激活链接失效");
			} else {
				model.addAttribute("reason", "用户信息不存在");
			}
			return vm_path + "activateFail.vm";
		} else {
			String token = UUID.randomUUID().toString();
			session.setAttribute("token", token);
			session.setAttribute("activationUser", userQResult.getQueryUserInfo());
			model.addAttribute("userName", userQResult.getQueryUserInfo().getUserName());
			model.addAttribute("token", token);
			return vm_path + "activate.vm";
		}
		
		// }
	}
	
	@RequestMapping("activateSubmit.htm")
	public String activateSubmit(HttpSession session, String token, String userBaseId,
									String logPassword, String business, String mobile,
									String code, Model model, HttpServletRequest request)
																							throws Exception {
		String getToken = (String) session.getAttribute("token");
		UserInfo userBaseInfo = null;
		logPassword = RSAUtils.decryptStringByJs(logPassword);
		if (getToken != null && getToken.equals(token)) {
			session.removeAttribute("token");
			userBaseInfo = (UserInfo) session.getAttribute("activationUser");
			model.addAttribute("userName", userBaseInfo.getUserName());
			userBaseInfo.setMobile(mobile);
			userBaseInfo.setMobileBinding(BooleanEnum.IS);
			UserActivateOrder activateOrder = new UserActivateOrder();
			activateOrder.setLogPassword(logPassword);
			activateOrder.setMobile(mobile);
			activateOrder.setUserBaseId(userBaseInfo.getUserBaseId());
			EsupplierBaseResult yrdBaseResult = registerService.userActivate(activateOrder);
			if (yrdBaseResult.isSuccess()) {
				UserLoginOrder order = new UserLoginOrder();
				order.setIpAddress(IPUtil.getIpAddr(request));
				order.setUserName(userBaseInfo.getUserName());
				order.setLoginFromTypeEnum(LoginFromTypeEnum.PC_CENTER);
				order.setValidatePassword(false);
				order.setPassword(logPassword);
				loginService.loginOtherToLogin(order);
				model.addAttribute("userType", userBaseInfo.getType());
				model.addAttribute("userName", userBaseInfo.getUserName());
				return vm_path + "activateSuccess.vm";
			} else {
				model.addAttribute("userName", userBaseInfo.getUserName());
				model.addAttribute("reason", "激活处理失败");
				return vm_path + "activateFail.vm";
			}
		} else {
			userBaseInfo = (UserInfo) session.getAttribute("activationUser");
			model.addAttribute("reason", "重复提交");
			if (userBaseInfo != null) {
				model.addAttribute("userName", userBaseInfo.getUserName());
			}
			return vm_path + "activateFail.vm";
		}
		
	}
	
	@RequestMapping("realNameAuth.htm")
	public String realNameAuth(Model model, HttpSession session) {
		if (ShiroSessionUtils.getSessionLocal() == null) {
			return "/help/nopermission";
		}
		UserInfo userBaseInfo = null;
		try {
			this.queryUserInfo(model);
			userBaseInfo = userQueryService.queryByUserBaseId(
				ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
		} catch (Exception e) {
			logger.error("查询银行信息异常", e);
		}
		session.setAttribute("token", UUID.randomUUID().toString());
		if (userBaseInfo.getType() == UserTypeEnum.GR)
			return vm_path + "realNameAuthentication.vm";
		else
			return vm_path + "enterpriserealNameAuthentication.vm";
	}
	
	@RequestMapping("goto3Acount.htm")
	public String goto3Acount(Model model, HttpSession session, HttpServletResponse response) {
		if (ShiroSessionUtils.getSessionLocal() == null) {
			return "/help/nopermission";
		}
		UserInfo userBaseInfo = null;
		try {
			userBaseInfo = userQueryService.queryByUserBaseId(
				ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
			CustomerResult customerResult = this.customerService.gotoYjfSit(
				userBaseInfo.getAccountId(), this.getOpenApiContext());
			response.sendRedirect(customerResult.getUrl());
		} catch (Exception e) {
			logger.error("查询银行信息异常", e);
		}
		return null;
	}
	
	@RequestMapping("allFlowSuccess.htm")
	public String allFlowSuccess(HttpSession session, Model model) throws Exception {
		if (ShiroSessionUtils.getSessionLocal() == null) {
			return "/help/nopermission";
		}
		model.addAttribute("allFlowSuccess", "true");
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
			ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
		model.addAttribute("userName", userBaseInfo.getUserName());
		return vm_path + "activateSuccess.vm";
	}
	
	private void queryUserInfo(Model model) throws Exception {
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfoDO = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		if (userBaseInfoDO.getRealNameAuthentication() == null) {
			model.addAttribute("realNameStatus", "N");
		} else {
			model.addAttribute("realNameStatus", userBaseInfoDO.getRealNameAuthentication().code());
		}
		
		if (userBaseInfoDO.getType() == UserTypeEnum.GR) {
			PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(userBaseId)
				.getQueryPersonalInfo();
			
			model.addAttribute("info", personalInfo);
		}
		if (userBaseInfoDO.getType() == UserTypeEnum.JG) {
			InstitutionsInfo institutionsInfo = userQueryService.queryInstitutionsInfoByBaseId(
				userBaseId).getQueryInstitutionsInfo();
			model.addAttribute("info", institutionsInfo);
		}
		
		model.addAttribute("type", userBaseInfoDO.getType());
	}
	
	@RequestMapping("signBankCard.htm")
	public String signBankCard(Model model) throws Exception {
		if (ShiroSessionUtils.getSessionLocal() == null) {
			return "/help/nopermission";
		}
		return vm_path + "signBankCard.vm";
	}
	
}
