package com.yjf.esupplier.web.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rop.thirdparty.com.alibaba.fastjson.JSONObject;

import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.AESEncrypt;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.PublicKeyMap;
import com.yjf.esupplier.common.util.RSAUtils;
import com.yjf.esupplier.common.util.SessionConstant;
import com.yjf.esupplier.service.login.LoginService;
import com.yjf.esupplier.service.login.result.LoginResult;
import com.yjf.esupplier.service.security.token.info.LoginData;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.base.Image;
import com.yjf.esupplier.web.controller.front.platform.ShoppingCartBaseController;
import com.yjf.esupplier.web.util.WebConstant;
import com.yjf.esupplier.ws.enums.LoginFromTypeEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Controller
public class LoginController  extends ShoppingCartBaseController {
	@Autowired
	LoginService loginService;
	final static String vm_path = "/front/platform/login/";
	
	private static String LOGIN_MESSAGE = "用户名或者密码错误";
	private static String LOGIN_MESSAGE_DISABLE = "该用户已冻结不可用...";
	/**
	 * 账户已被锁定
	 */
	private static String LOGIN_MESSAGE_LOCKED = "此账户已被锁定，请等待解锁";
	/**
	 * 账户不存在
	 */
	private static String LOGIN_USER_UNKNOWN = "账户不存在";
	
	@SuppressWarnings("unused")
	@RequestMapping("/login/login.htm")
	private String login(String userName, String password, Model model, HttpSession session,
							HttpServletRequest request, HttpServletResponse response,
							String redirect) {
		logger.info("用户登录后台系统，入参:[username={}]{}", userName, AppConstantsUtil.getProductName());
		//		model.addAttribute("yjfUrl", WebConstant.getYjfloginurl());
		if (!StringUtil.isNotEmpty(userName)) {
			return vm_path + "login.vm";
		}
		
		redirect = checkRedirect(redirect);
		if (StringUtil.isBlank(redirect)) {
			redirect = "/do/scenic/doCenter/mainHome.htm";
		}
		//		redirect = "/do/mainHome.htm";
		LoginResult loginResult = doForntLogin(userName, password, session, request);
		session.setAttribute("sessionInvalidCheck", "31");// 未知项遗留项
		if (loginResult.isSuccess()) {
			initShopCart(loginResult.getUserInfo());
			sendUrl(response, redirect);
			return null;
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.HAVE_NOT_DATA) {
			model.addAttribute("code", 0);
			model.addAttribute("message", "用户不存在");
			return vm_path + "login.vm";
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.USER_DISABLE) {
			model.addAttribute("code", 0);
			model.addAttribute("message", LOGIN_MESSAGE_DISABLE);
			return vm_path + "login.vm";
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.USER_LOCKED) {
			model.addAttribute("code", 0);
			model.addAttribute("message", LOGIN_MESSAGE_LOCKED);
			return vm_path + "login.vm";
		} else {
			model.addAttribute("code", 1);
			model.addAttribute("message", loginResult.getMessage());
			return vm_path + "login.vm";
		}
	}
	

	private LoginResult doForntLogin(String userName, String password, HttpSession session,
										HttpServletRequest request) {
		
		String whithControl = request.getParameter("whithControl");
		if ("0".equals(whithControl)) {
			String key = (String) session.getAttribute(session.getId());
			AESEncrypt aesEncrypt = new AESEncrypt();
			aesEncrypt.setIvParameter(key);
			aesEncrypt.setsKey(key);
			try {
				
				password = aesEncrypt.decrypt(password);
			} catch (Exception e) {
				logger.error("密码解密异常---登录用户：" + userName, e);
			}
		} else {
			password = RSAUtils.decryptStringByJs(password);
		}
		
		LoginData loginData = new LoginData();
		loginData.setUsername(userName);
		loginData.setPassword(password);
		loginData.setUserAgent(request.getHeader("user-agent"));
		Session shiroSession = SecurityUtils.getSubject().getSession();
		String captchaSession = (String) session.getAttribute(SessionConstant.SESSION_KAPTCHA_KEY);
		LoginData orderData = new LoginData();
		orderData.setLoginFromTypeEnum(LoginFromTypeEnum.PC_MERCHANT);
		orderData.setUsername(userName);
		orderData.setPassword(password);
		orderData.setIpAddress(IPUtil.getIpAddr(request));
		orderData.setUserBizTypeEnum(UserBizTypeEnum.SELLER);
		//		UserLoginOrder userLoginOrder = new UserLoginOrder();
		//		userLoginOrder.setUserName(userName);
		//		userLoginOrder.setPassword(password);
		//		userLoginOrder.setIpAddress(IPUtil.getIpAddr(request));
		LoginResult loginResult = loginService.login(orderData);
		return loginResult;
	}
	

	private LoginResult doBackstageLogin(String userName, String password, HttpSession session,
											HttpServletRequest request) {
		//		String key = (String) session.getAttribute(session.getId());
		//		AESEncrypt aesEncrypt = new AESEncrypt();
		//		aesEncrypt.setIvParameter(key);
		//		aesEncrypt.setsKey(key);
		try {
			password = RSAUtils.decryptStringByJs(password);
			//			password = aesEncrypt.decrypt(password);
		} catch (Exception e) {
			logger.error("密码解密异常---登录用户：" + userName, e);
		}
		LoginData loginData = new LoginData();
		loginData.setUsername(userName);
		loginData.setPassword(password);
		
		Session shiroSession = SecurityUtils.getSubject().getSession();
		String captchaSession = (String) session.getAttribute(SessionConstant.SESSION_KAPTCHA_KEY);
		LoginData orderData = new LoginData();
		orderData.setUsername(userName);
		orderData.setPassword(password);
		orderData.setLoginFromTypeEnum(LoginFromTypeEnum.PC_ADMIN);
		orderData.setIpAddress(IPUtil.getIpAddr(request));
		orderData.setUserBizTypeEnum(UserBizTypeEnum.ADMIN);
		LoginResult loginResult = loginService.login(orderData);
		return loginResult;
	}
	
	/**
	 * 会员登录
	 * @param userName
	 * @param password
	 * @param session
	 * @param request
	 * @return
	 */
	private LoginResult doMemberLogin(String userName, String password, HttpSession session,
										HttpServletRequest request) {
		
		String whithControl = request.getParameter("whithControl");
		if ("0".equals(whithControl)) {
			String key = (String) session.getAttribute(session.getId());
			AESEncrypt aesEncrypt = new AESEncrypt();
			aesEncrypt.setIvParameter(key);
			aesEncrypt.setsKey(key);
			try {
				
				password = aesEncrypt.decrypt(password);
			} catch (Exception e) {
				logger.error("密码解密异常---登录用户：" + userName, e);
			}
		} else {
			password = RSAUtils.decryptStringByJs(password);
		}
		
		LoginData loginData = new LoginData();
		loginData.setUsername(userName);
		loginData.setPassword(password);
		loginData.setUserAgent(request.getHeader("user-agent"));
		Session shiroSession = SecurityUtils.getSubject().getSession();
		String captchaSession = (String) session.getAttribute(SessionConstant.SESSION_KAPTCHA_KEY);
		LoginData orderData = new LoginData();
		orderData.setLoginFromTypeEnum(LoginFromTypeEnum.PC_USER);
		orderData.setUsername(userName);
		orderData.setPassword(password);
		orderData.setIpAddress(IPUtil.getIpAddr(request));
		orderData.setUserBizTypeEnum(UserBizTypeEnum.BUYER);
		//		UserLoginOrder userLoginOrder = new UserLoginOrder();
		//		userLoginOrder.setUserName(userName);
		//		userLoginOrder.setPassword(password);
		//		userLoginOrder.setIpAddress(IPUtil.getIpAddr(request));
		LoginResult loginResult = loginService.login(orderData);
		return loginResult;
	}

	@SuppressWarnings("unused")
	@RequestMapping("/login/iframeLogin.htm")
	private String iframeLogin(String userName, String logPassword, Model model,
								HttpSession session, HttpServletRequest request,
								HttpServletResponse response, String redirect) {
		logger.info("用户登录后台系统，入参:[username={}]{}", userName, AppConstantsUtil.getProductName());
		model.addAttribute("yjfUrl", WebConstant.getYjfloginIframeUrl());
		
		return vm_path + "iframeLogin.vm";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/login/doIframeLogin.htm")
	private String doIframeLogin(String userName, String password, Model model,
									HttpSession session, HttpServletRequest request,
									HttpServletResponse response, String redirect) {
		LoginResult loginResult = doMemberLogin(userName, password, session, request);
		if (loginResult.isSuccess()) {
			model.addAttribute("userId", ShiroSessionUtils.getSessionLocal().getUserId());
			model.addAttribute("localUrl", WebConstant.getYjfloginIframeUrl());
			return "/front/yjf/iframeLoginSuccess.vm";
		} else {
			model.addAttribute("code", 1);
			model.addAttribute("message", loginResult.getMessage());
			return vm_path + "iframeLogin.vm";
		}
		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/admin/login.htm")
	private String backstageLogin(String userName, String logPassword, Model model,
									HttpSession session, HttpServletRequest request,
									HttpServletResponse response) {
		logger.info("用户登录后台系统，入参:[username={}]{}", userName, AppConstantsUtil.getProductName());
		if (!StringUtil.isNotEmpty(userName)) {
			return "/backstage/backstageLogin.vm";
		}
		LoginResult loginResult = doBackstageLogin(userName, logPassword, session, request);
		session.setAttribute("sessionInvalidCheck", "31");// 未知项遗留项
		if (loginResult.isSuccess()) {
			sendUrl(response, "/admin/index.htm");
			return null;
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.HAVE_NOT_DATA) {
			model.addAttribute("message", "用户不存在");
			return "/backstage/backstageLogin.vm";
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.USER_DISABLE) {
			model.addAttribute("message", LOGIN_MESSAGE_DISABLE);
			return "/backstage/backstageLogin.vm";
		} else {
			model.addAttribute("message", loginResult.getMessage());
			return "/backstage/backstageLogin.vm";
		}
	}
	
	@RequestMapping(value = "/login/logout.htm")
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		return logout(request, response, "/");
		
	}
	
	@RequestMapping(value = "/login/logoutlogin.htm")
	public String logoutlogin(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		return logout(request, response, "/login/login.htm");
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response, String url) {
		Subject subject = SecurityUtils.getSubject();
		try {
			if (null != subject) {
				ShiroSessionUtils.clear();
				subject.logout();
			}
			request.getSession().invalidate();
		} catch (Exception e) {
			logger.error("登出报错", e);
		}
		if ("/".equals(url)) {
			sendUrl(response, url);
			return null;
		} else if ("/login/login.htm".equals(url)) {
			sendUrl(response, url);
			return null;
		} else if ("/front/platform/mall/mallIndex.htm".equals(url)) {
			sendUrl(response, url);
			return null;
		} else {
			return "/backstage/backstageLogin.vm";
		}
	}
	
	@RequestMapping(value = "/admin/logout.htm")
	public String adminLogout(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		return logout(request, response, "/admin/login.htm");
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/login/frontLogin.htm")
	private String frontLogin(String userName, String password, Model model, HttpSession session,
								HttpServletRequest request, HttpServletResponse response,
								String redirect) {
		logger.info("前端用户登录系统，入参:[username={}]{}", userName, AppConstantsUtil.getProductName());
		//		model.addAttribute("yjfUrl", WebConstant.getYjfloginurl());
		if (!StringUtil.isNotEmpty(userName)) {
			return vm_path + "frontLogin.vm";
		}
		
		redirect = checkRedirect(redirect);
		if (StringUtil.isBlank(redirect)) {
			redirect = "/front/platform/mall/mallIndex.htm";
		}
		//		redirect = "/do/mainHome.htm";
		LoginResult loginResult = doMemberLogin(userName, password, session, request);
		session.setAttribute("sessionInvalidCheck", "31");// 未知项遗留项
		if (loginResult.isSuccess()) {
			initShopCart(loginResult.getUserInfo());
			sendUrl(response, redirect);
			return null;
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.HAVE_NOT_DATA) {
			model.addAttribute("code", 0);
			model.addAttribute("message", "用户不存在");
			return vm_path + "frontLogin.vm";
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.USER_DISABLE) {
			model.addAttribute("code", 0);
			model.addAttribute("message", LOGIN_MESSAGE_DISABLE);
			return vm_path + "frontLogin.vm";
		} else if (loginResult.getCreditsysResultEnum() == EsupplierResultEnum.USER_LOCKED) {
			model.addAttribute("code", 0);
			model.addAttribute("message", LOGIN_MESSAGE_LOCKED);
			return vm_path + "frontLogin.vm";
		} else {
			model.addAttribute("code", 1);
			model.addAttribute("message", loginResult.getMessage());
			return vm_path + "frontLogin.vm";
		}
	}

	@RequestMapping(value = "/login/frontLogout.htm")
	public String frontLogout(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		return logout(request, response, "/front/platform/mall/mallIndex.htm");
	}
	@RequestMapping("/error.htm")
	public String errorPage(Model model) throws Exception {
		return "common/error.vm";
	}
	
	private String checkRedirect(String redirect) {
		if (redirect != null) {
			if (redirect.startsWith(AppConstantsUtil.getHostHttpUrl())) {
				return redirect;
			} else if (redirect.contains("http://") || redirect.contains("https://")) {
				return "";
			} else {
				return redirect;
			}
		}
		return redirect;
	}
	
	@ResponseBody
	@RequestMapping("/login/keyPair.json")
	public Object keyPair() {
		JSONObject json = new JSONObject();
		try {
			PublicKeyMap publicKeyMap = RSAUtils.getPublicKeyMap();
			json.put("code", 1);
			json.put("modulus", publicKeyMap.getModulus());
			json.put("exponent", publicKeyMap.getExponent());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", 0);
			json.put("message", "获取Key异常");
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/login/validateCaptcha.json")
	public Object validateCaptcha(String captcha, HttpSession session) {
		JSONObject json = new JSONObject();
		try {
			if (Image.checkImgCode(session, captcha)) {
				json.put("code", 1);
				json.put("message", "验证码正确");
			} else {
				json.put("code", 0);
				json.put("message", "验证码不正确");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", 0);
			json.put("message", "验证码校验异常");
		}
		return json;
	}
}