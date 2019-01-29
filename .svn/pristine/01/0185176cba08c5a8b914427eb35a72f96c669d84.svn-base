package com.yjf.esupplier.web.controller.front.account;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.RSAUtils;
import com.yjf.esupplier.integration.web.server.YjfLoginWebServer;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.login.order.UserLoginOrder;
import com.yjf.esupplier.service.login.result.LoginResult;
import com.yjf.esupplier.service.security.token.info.LoginData;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.order.InvestorRegisterOrder;
import com.yjf.esupplier.service.user.result.UserRegisterResult;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.AppCommonUtil;
import com.yjf.esupplier.web.util.WebConstant;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.LoginFromTypeEnum;
import com.yjf.esupplier.ws.enums.SmsBizType;

/**
 * 
 * 
 * @Filename NewInvestorsOpenController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zhaohaibing
 * 
 * @Email abing@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-8-19</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("anon")
public class NewInvestorsOpenController extends BaseAutowiredController {
	private final String vm_path = "/front/anon/newInvestorsOpen/";
	
	@Autowired
	YjfLoginWebServer yjfLoginWebServer;
	
	@RequestMapping("brokerOpenInvestor")
	public String oldRegist(HttpSession session, String NO, Model model) {
		return newinvestorsOpen(session, NO, null, model);
	}
	
	@RequestMapping("investorsOpen.htm")
	public String investorOpenInvestor(HttpSession session, String NO, Model model) {
		return newinvestorsOpen(session, null, NO, model);
	}
	
	@RequestMapping("newInvestorsOpen.htm")
	public String newinvestorsOpen(HttpSession session, String NO, String investorNO, Model model) {
		
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		session.removeAttribute("brokerNo");
		model.addAttribute("investorNO", investorNO);
		model.addAttribute("NO", NO);
		String referees = null;
		if (StringUtil.isNotBlank(NO)) {
			referees = NO;
		}
		if (StringUtil.isNotBlank(investorNO)) {
			referees = investorNO;
		}
		model.addAttribute("referees", referees);
		SessionLocal sessionLocal = new SessionLocal();
		sessionLocal.addAttibute("appRegist", true);
		ShiroSessionUtils.setSessionLocal(sessionLocal);
		return vm_path + "newInvestorsOpen.vm";
		
	}
	
	@RequestMapping("newPerfectInfo.htm")
	public String phoneRegist(HttpServletRequest request, HttpSession session, String imgCode,
								InvestorRegisterOrder investorRegisterOrder, String token,
								String code, Model model, HttpServletResponse response)
																						throws Exception {
		
		//		if (!Image.checkImgCode(session, imgCode)) {
		//			logger.info("图片验证码错误");
		//			return vm_path + "newInvestorsOpenFail.vm" ;
		//		}
		try {
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(
				investorRegisterOrder.getMobile(), SmsBizType.REGISTER,
				request.getParameter("code"), true);
			if (!smsCodeResult.isSuccess()) {
				logger.info("验证码错误");
				return vm_path + "newInvestorsOpenFail.vm";
			}
			investorRegisterOrder.setMobileBinding(BooleanEnum.IS.code());
		} catch (NullPointerException e) {
			logger.info("未获取短信验证码");
			return vm_path + "newInvestorsOpenFail.vm";
		}
		
		String password = request.getParameter("secPassword");
		
		if (StringUtil.isNotBlank(password)) {
			password = RSAUtils.decryptStringByJs(password);
		} else {
			password = investorRegisterOrder.getLogPassword();
		}
		investorRegisterOrder.setAppRegisterFrom(AppCommonUtil.getRegistFromByRequest(request));
		investorRegisterOrder.setLogPassword(password);
		UserRegisterResult registerResult = registerService.investorRegister(investorRegisterOrder);
		if (registerResult.isSuccess()) {
			
			LoginData order = new LoginData();
			order.setUsername(investorRegisterOrder.getUserName());
			order.setPassword(password);
			order.setIpAddress(IPUtil.getIpAddr(request));
			order.setLoginFromTypeEnum(LoginFromTypeEnum.APP_USER);
			LoginResult loginResult = loginService.login(order);
			logger.info("注册成功后创建登陆状态:loginResult={}", loginResult);
//			sendUrl(response, "/front/platform/mall/mallIndex.htm");
			model.addAttribute("userName", investorRegisterOrder.getUserName());
			model.addAttribute("userId", registerResult.getUserinfo().getUserId());
			model.addAttribute("accountName", registerResult.getUserinfo().getAccountName());
			return vm_path + "newInvestorsOpenSuccess.vm";
		} else {
			logger.info("注册失败");
			return vm_path + "newInvestorsOpenFail.vm";
		}
	}
	
	@RequestMapping(value = "yjfRegisterReturnUrl.htm")
	public String yjfRegisterReturnUrl(HttpServletRequest request, HttpServletResponse response,
										ModelMap modelMap, Model model) {
		Map<String, String> param = WebUtil.getRequestMap(request);
		String redirectUrl = (String) request.getSession().getAttribute(
			WebConstant.SESSION_KEY_REDIRECT_URL);
		request.getSession().removeAttribute(WebConstant.SESSION_KEY_REDIRECT_URL);
		if (StringUtil.isNotBlank(redirectUrl)) {
			sendUrl(response, redirectUrl);
			return null;
		}
		String result = param.get("result");
		if (StringUtil.equalsIgnoreCase(result, "success")) {
			return vm_path + "newOpenAccountSunccess.vm";
		} else {
			model.addAttribute("message", param.get("masesge"));
			return vm_path + "newOpenAccountFail.vm";
		}
		
	}
	
	/**
	 * 注册成功后创建登陆状态
	 * **/
	private void createloginStatus(HttpServletRequest request, UserRegisterResult result) {
		UserLoginOrder order = new UserLoginOrder();
		order.setIpAddress(IPUtil.getIpAddr(request));
		order.setValidatePassword(false);
		order.setUserName(result.getUserinfo().getUserName());
		/*默认是用户吧，这里貌似没用这方法*/
		order.setLoginFromTypeEnum(LoginFromTypeEnum.APP_USER);
		loginService.loginOtherToLogin(order);
	}
	
}
