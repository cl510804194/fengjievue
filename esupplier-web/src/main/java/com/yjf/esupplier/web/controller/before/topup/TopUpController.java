package com.yjf.esupplier.web.controller.before.topup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.YrdConstants;
import com.yjf.esupplier.integration.openapi.VerifyBankCardService;
import com.yjf.esupplier.integration.openapi.enums.UserStatusEnum;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.integration.openapi.order.DepositDeductOrder;
import com.yjf.esupplier.integration.openapi.result.DeductDepositResult;
import com.yjf.esupplier.integration.web.server.YjfLoginWebServer;
import com.yjf.esupplier.integration.web.server.impl.YjfEzmoneyPayPassUrlOrder;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.UserAccountInfoBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.base.info.BankConfigInfo;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CertTypeEnum;
import com.yjf.esupplier.ws.enums.DepositStatusEnum;
import com.yjf.esupplier.ws.enums.RealNameAuthStatusEnum;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyAssignProcessService;
import com.yjf.esupplier.ws.info.UserBankInfo;
import com.yjf.esupplier.ws.order.DeleteUserBankOrder;
import com.yjf.esupplier.ws.order.UserBankOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.UserBankService;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * Created by zjialin@yiji.com on 2014/4/16.
 */
@Controller
@RequestMapping("/do/userManage/topUp/")
public class TopUpController extends UserAccountInfoBaseController {
	
	@Autowired
	private UserBankService userBankService;
	
	@Autowired
	YjfLoginWebServer yjfLoginWebServer;
	
	@Autowired
	VerifyBankCardService verifyBankCardService;
	
	@Autowired
	GiftMoneyAssignProcessService giftMoneyAssignProcessService;
	
	@RequestMapping("withholdingIndex.htm")
	public String withholdingIndex(HttpServletRequest request, Model model, HttpSession session) {
		YjfAccountInfo accountInfo = this.getAccountInfo(model);
		UserInfo userBaseInfo = this.getUserBaseInfo(session, model);
		if (!"已认证".equals(accountInfo.getCertifyStatus())
			|| userBaseInfo.getRealNameAuthentication() != RealNameAuthStatusEnum.IS) {
			updateLocalAccountByRemote(userBaseInfo, accountInfo);
		}
		if (accountInfo.getUserStatus() == UserStatusEnum.NORMAL) {
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			if (StringUtil.isEmpty(sessionLocal.getRealName())) {
				if (StringUtil.isNotEmpty(userBaseInfo.getRealName())) {
					sessionLocal.setRealName(userBaseInfo.getRealName());
					ShiroSessionUtils.setSessionLocal(sessionLocal);
				}
			}
			
			List<Map<String, Object>> signBankInfos = new ArrayList<Map<String, Object>>();
			Map<String, UserBankInfo> signBankMap = new HashMap<String, UserBankInfo>();
			
			if (AppConstantsUtil.canTradeUsePayPassword()) {
				YjfEzmoneyPayPassUrlOrder ezmoneyPayPassUrlOrder = new YjfEzmoneyPayPassUrlOrder();
				ezmoneyPayPassUrlOrder.setUserId(sessionLocal.getAccountId());
				EsupplierBaseResult baseResult = yjfLoginWebServer.gotoYjfValidatePayPasswordUrl(
					ezmoneyPayPassUrlOrder, this.getOpenApiContext());
				model.addAttribute("yjfPaypassUrl", baseResult.getUrl());
			}
			
			request.getSession().setAttribute(YrdConstants.SesssionKey.SIGN_BANK_KEY, signBankMap);
			model.addAttribute("signBankInfos", signBankInfos);
			
			//			if (loaner == null) {
			//				model.addAttribute("signBankInfoCount", signBankInfos.size());
			//			} else {
			//				model.addAttribute("isLoanerUser", true);
			//				model.addAttribute("signBankInfoCount", 0);
			//			}
			model.addAttribute("signBankInfoCount", signBankInfos.size());
			model.addAttribute("accountInfo", accountInfo);
			model.addAttribute("selectBankInfos", bankDataService.loadAllBankConfigInfo());
			return returnVm("withholdingIndex.vm");
		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("isAccountNotActive", true);
			model.addAttribute("message", "支付账号未激活用户！");
			return returnVm("withholdingResult.vm");
		}
		
	}
	
	@RequestMapping("bankManage.htm")
	public String bankManage(HttpServletRequest request, Model model, HttpSession session) {
		YjfAccountInfo accountInfo = this.getAccountInfo(model);
		UserInfo userBaseInfo = this.getUserBaseInfo(session, model);
		if (!"已认证".equals(accountInfo.getCertifyStatus())
			|| userBaseInfo.getRealNameAuthentication() != RealNameAuthStatusEnum.IS) {
			updateLocalAccountByRemote(userBaseInfo, accountInfo);
		}
		if (accountInfo.getUserStatus() == UserStatusEnum.NORMAL) {
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			if (StringUtil.isEmpty(sessionLocal.getRealName())) {
				if (StringUtil.isNotEmpty(userBaseInfo.getRealName())) {
					sessionLocal.setRealName(userBaseInfo.getRealName());
					ShiroSessionUtils.setSessionLocal(sessionLocal);
				}
			}
			String accountId = sessionLocal.getAccountId();
			
			List<Map<String, Object>> signBankInfos = new ArrayList<Map<String, Object>>();
			Map<String, UserBankInfo> signBankMap = new HashMap<String, UserBankInfo>();
			
			request.getSession().setAttribute(YrdConstants.SesssionKey.SIGN_BANK_KEY, signBankMap);
			model.addAttribute("signBankInfos", signBankInfos);
			
			//			if (loaner == null) {
			//				model.addAttribute("signBankInfoCount", signBankInfos.size());
			//			} else {
			//				model.addAttribute("isLoanerUser", true);
			//				model.addAttribute("signBankInfoCount", 0);
			//			}
			model.addAttribute("signBankInfoCount", signBankInfos.size());
			model.addAttribute("accountInfo", accountInfo);
			model.addAttribute("selectBankInfos", bankDataService.loadAllBankConfigInfo());
			return returnVm("bankManage.vm");
		} else {
			model.addAttribute("isSuccess", false);
			model.addAttribute("isAccountNotActive", true);
			model.addAttribute("message", "支付账号未激活用户！");
			return returnVm("bankManage.vm");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("addUserBank.htm")
	public String addUserBank(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject json = new JSONObject();
		
		UserBankOrder order = new UserBankOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setBankType(request.getParameter("bankCode"));
		order.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		EsupplierBaseResult baseResult = userBankService.addUserBankInfo(order);
		if (baseResult.isSuccess()) {
			json.put("code", "1");
			json.put("message", "添加成功");
		} else {
			json.put("code", "0");
			json.put("message", baseResult.getMessage());
		}
		this.printHttpResponse(response, json);
		return null;
	}
	
	/**
	 * 删除银行
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("deleteUserBank.htm")
	public String deleteUserBank(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject json = new JSONObject();
		
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		String userBaseId = sessionLocal.getUserBaseId();
		
		String bankId = request.getParameter("bankId");
		DeleteUserBankOrder deleteUserBankOrder = new DeleteUserBankOrder();
		deleteUserBankOrder.setId(NumberUtil.parseLong(bankId));
		deleteUserBankOrder.setUserBaseId(userBaseId);
		EsupplierBaseResult baseResult = userBankService.removeUserBankInfo(deleteUserBankOrder);
		if (baseResult.isSuccess()) {
			json.put("code", "1");
			json.put("message", "删除成功");
		} else {
			json.put("code", "0");
			json.put("message", baseResult.getMessage());
		}
		this.printHttpResponse(response, json);
		return null;
	}
	
	@RequestMapping("withholdingSubmit.htm")
	public String withholdingIndex(String rechargeAmount, String bankCode, String validateCode,
									String paytk, Model model, HttpSession session) {
		Money money = new Money(rechargeAmount);
		initAccountInfo(model);
		if (AppConstantsUtil.canTradeUsePayPassword()) {
			
		} else {
			UserInfo userBaseInfo = (UserInfo) model.asMap().get("userBaseInfo");
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(userBaseInfo.getMobile(),
				SmsBizType.DEPOSIT, validateCode, true);
			if (!smsCodeResult.isSuccess()) {
				model.addAttribute("isSuccess", false);
				model.addAttribute("message", smsCodeResult.getMessage());
				return returnVm("withholdingResult.vm");
			}
		}
		deduct(money, bankCode, model, session, paytk);
		return returnVm("withholdingResult.vm");
	}
	
	@SuppressWarnings("unchecked")
	public void deduct(Money money, String bankCode, Model model, HttpSession session, String paytk) {
		SessionLocal local = ShiroSessionUtils.getSessionLocal();
		Map<String, UserBankInfo> signBankMap = (Map<String, UserBankInfo>) session
			.getAttribute(YrdConstants.SesssionKey.SIGN_BANK_KEY);
		if (signBankMap == null) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("message", "未签约银行");
			return;
		}
		UserBankInfo signBankInfo = signBankMap.get(bankCode);
		if (signBankInfo == null) {
			model.addAttribute("isSuccess", false);
			model.addAttribute("message", "未知的银行bankCode=" + bankCode);
			return;
		}
		
		DepositDeductOrder deductOrder = new DepositDeductOrder();
		deductOrder.setAmount(money);
		deductOrder.setAccountName(local.getAccountName());
		deductOrder.setBankAccountName(local.getRealName());
		deductOrder.setBankAccountNo(signBankInfo.getBankCardNo());
		deductOrder.setBankCode(signBankInfo.getBankType());
		deductOrder.setCertType(CertTypeEnum.Identity_Card);
		deductOrder.setProvName("重庆市");
		deductOrder.setCityName("重庆市");
		deductOrder.setUserId(local.getAccountId());
		deductOrder.setMemo("快捷充值");
		deductOrder.setPactNo(signBankInfo.getPactNo());
		deductOrder.setPaytk(paytk);
		BankConfigInfo bankConfigInfo = bankDataService.loadBankConfigInfo(signBankInfo
			.getBankType());
		deductOrder.setBankName(bankConfigInfo.getBankName());
		
		DeductDepositResult baseResult = new DeductDepositResult();
		try {
			baseResult = this.deductYrdService.deductDeposit(deductOrder);
			if (baseResult.isSuccess()
				&& baseResult.getDepositStatusEnum() == DepositStatusEnum.SUCCESS) {
				model.addAttribute("isSuccess", baseResult.isSuccess());
				initAccountInfo(model, false);
				
			} else if (baseResult.isSuccess()) {
				model.addAttribute("isProcessing", true);
			} else {
				model.addAttribute("message", baseResult.getMessage());
			}
			
		} catch (Exception e) {
			logger.error("deductDeposit Exception", e);
			model.addAttribute("isSuccess", false);
			model.addAttribute("message", "系统异常");
		}
		
	}
	
	private String returnVm(String vm) {
		String fullVm = "/before/topup/";
		return fullVm + vm;
	}
	
	@RequestMapping("signRedirect.htm")
	public String redirect(HttpServletResponse response, Model model) {
		String accountId = ShiroSessionUtils.getSessionLocal().getAccountId();
		
		try {
			UserInfo userInfo = userQueryService.queryByUserId(
				ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
			QueryBaseBatchResult<UserBankInfo> batchResult = userBankService
				.queryUserBankInfo(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			boolean isHasBank = false;
			for (UserBankInfo info : batchResult.getPageList()) {
				if (info.getIsDel() == BooleanEnum.NO) {
					isHasBank = true;
				}
			}
			if (userInfo != null) {
				if (userInfo.getRealNameAuthentication() != RealNameAuthStatusEnum.IS) {
					model.addAttribute("userType", userInfo.getType());
					model.addAttribute("realName", "error");
					return "/before/topup/signbank.vm";
				}
				if (isHasBank) {
					model.addAttribute("cardNumber", "error");
					return "/before/topup/signbank.vm";
				}
			}
		} catch (Exception e) {
			logger.error("查询用户信息出错:e={}", e.getMessage(), e);
		}
		String url = rechargeFlowService.getSignUrl(accountId);
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.error("" + e.getMessage(), e);
		}
		return null;
	}
	
}
