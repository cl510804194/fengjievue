package com.yjf.esupplier.web.controller.front.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjf.esupplier.service.user.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.MD5Util;
import com.yjf.esupplier.dal.dataobject.OperatorInfoDO;
import com.yjf.esupplier.integration.openapi.enums.AttributionEnum;
import com.yjf.esupplier.integration.openapi.enums.PeasonSexEnum;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.integration.openapi.order.MobileBindOrder;
import com.yjf.esupplier.integration.openapi.order.RegisterOrder;
import com.yjf.esupplier.integration.openapi.order.UserQuickCertifyOrder;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.integration.web.server.YjfLoginWebServer;
import com.yjf.esupplier.integration.web.server.impl.YjfPayPwdOrder;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.common.services.order.SystemSendMessageOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.trade.order.EBankDepositOrder;
import com.yjf.esupplier.service.user.IOperatorInfoService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.info.UserLoginLogInfo;
import com.yjf.esupplier.service.user.info.UserRelationInfo;
import com.yjf.esupplier.web.controller.base.UserAccountInfoBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CertTypeEnum;
import com.yjf.esupplier.ws.enums.RealNameAuthStatusEnum;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.enums.SysSendMessageTypeEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * 
 * @Filename UserBaseController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjil</li> <li>Date: 2013-6-11</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("/do/userManage")
public class UserBaseController extends UserAccountInfoBaseController {
	/** 返回页面路径 */
	String USER_MANAGE_PATH = "/front/user/activation/";
	String USER_MANAGE_FRIEND_PATH = "/front/user/friend/";
	private final String md5AddString = "S1as#%DF#@D*(=-@@!";
	
	@Autowired
	protected IOperatorInfoService operatorInfoService;
	@Autowired
	YjfLoginWebServer yjfLoginWebServer;
	
	/** 获取memberNo */
	private String queryMemberNo() {
		UserRelationInfo relationInfo = userRelationQueryService.findUserRelationByChildId(
			ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserRelationInfo();
		return null == relationInfo ? null : relationInfo.getMemberNo();
	}
	
	/**
	 * 设置用户角色
	 * @param userId
	 * @param model
	 */
	//	private void setRole(long userId, Model model) {
	//		
	//		Pagination<Role> page = authorityService.getRolesByUserId(userId, 0, 99999);
	//		List<Role> roles = page.getResult();
	//		
	//		model.addAttribute("isBroker", false);
	//		model.addAttribute("isOperator", false);
	//		
	//		for (Role role : roles) {
	//			if ("broker".equals(role.getCode())) {
	//				model.addAttribute("isBroker", true);
	//			}
	//			
	//			if ("operator".equals(role.getCode())) {
	//				model.addAttribute("isOperator", true);
	//			}
	//			
	//			if (SysUserRoleEnum.LOANER.getRoleCode().equals(role.getCode())) {
	//				model.addAttribute("isLoaner", true);
	//			}
	//			
	//			if (SysUserRoleEnum.INVESTOR.getRoleCode().equals(role.getCode())) {
	//				model.addAttribute("isInvestor", true);
	//			}
	//		}
	//		
	//	}
	
	/** 统计总资产 */
	//	private Money statTotalAmount(final Model model, final YjfAccountInfo accountInfo, long userId) {
	//		QueryLoanTradeOrder tradeOrder = new QueryLoanTradeOrder();
	//		if (ShiroSessionUtils.getSessionLocal().getUserId() == tradeBizProcessService
	//			.getYrdUserId()) {
	//			tradeOrder.setRoleId(SysUserRoleEnum.YRD.getValue());
	//		} else {
	//			if (isRole(model, userId, SysUserRoleEnum.INVESTOR, "isInvestor")) {
	//				tradeOrder.setRoleId(SysUserRoleEnum.INVESTOR.getValue());
	//			} else if (isRole(model, userId, SysUserRoleEnum.BROKER, "isBroker")) {
	//				tradeOrder.setRoleId(SysUserRoleEnum.BROKER.getValue());
	//			}
	//		}
	//		
	//		tradeOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
	//		TradeStatisticsResult<TradeAmountStatisticsInfo> statisticsResult = tradeBizQueryService
	//			.searchLoanTradeSumCommonQuery(tradeOrder);
	//		return accountInfo.getBalance()
	//			.add(statisticsResult.getStatisticsInfo().getWaitSuccessPrincipleAmount())
	//			.add(statisticsResult.getStatisticsInfo().getWaitToPayInvestAmount());
	//	}
	
	// -----------------------------------------------------------------验证用户信息------------------------------------------------------------------------
	
	@ResponseBody
	@RequestMapping("validationUserName.htm")
	public Object validationUserName(String userName) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", userName);
		JSONObject jsonobj = new JSONObject();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		returnEnum = userBaseInfoManager.validationUserName(userName);
		// 验证用户不存在
		if (returnEnum.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "用户可以用");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户已存在");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", userName);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("getBindEmail")
	public Object getBindEmail(String userName) throws Exception {
		logger.info("获取" + AppConstantsUtil.getProductName() + "金融用户邮箱，入参：{}", userName);
		JSONObject jsonobj = new JSONObject();
		UserInfo baseUser = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (baseUser != null) {
			String mail = baseUser.getMail();
			if (!StringUtil.isEmpty(mail)) {
				String[] strMail = mail.split("@");
				
				jsonobj.put("mail", mail);
				jsonobj.put("message", strMail[0].substring(0, 3) + "********@" + strMail[1]);
				
			}
			jsonobj.put("code", 1);
			jsonobj.put("mobile", baseUser.getMobile());
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "");
		}
		logger.info("获取" + AppConstantsUtil.getProductName() + "金融用户邮箱，出参：{}", userName);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("validationIsUserName")
	public Object validationIsUserName(String userName) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户存在，入参：{}", userName);
		JSONObject jsonobj = new JSONObject();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		returnEnum = userBaseInfoManager.validationUserName(userName);
		// 验证用户已存在
		if (returnEnum.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户不存在");
		} else {
			jsonobj.put("code", 1);
			jsonobj.put("message", "用户已存在");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户存在，出参：{}", jsonobj);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("validationAccountName")
	public Object validationAccountName(String accountName) throws Exception {
		logger.info("验证易极付帐户不存在，入参：{}", accountName);
		JSONObject jsonobj = new JSONObject();
		CustomerResult returnEnum = this.customerService.checkUserNameExist(accountName,
			this.getOpenApiContext());
		if (!returnEnum.isExsit()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "用户可以用");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户已存在");
		}
		logger.info("验证易极付帐户不存在，出参：{}", jsonobj);
		return jsonobj;
	}
	
	@RequestMapping("investReserve")
	public String InvestReserve(String certifyType, String balanceType, ModelMap model) {
		model.addAttribute("certifyType", certifyType);
		model.addAttribute("balanceType", balanceType);
		return USER_MANAGE_PATH + "investReserve.vm";
	}
	
	/** 获取登录信息 */
	private void queryLoginInfo(final Model model) {
		List<UserLoginLogInfo> loginLog = userQueryService.queryUserLoginLog(ShiroSessionUtils
			.getSessionLocal().getUserId());
		
		if (loginLog != null) {
			if (loginLog.size() > 1) {
				model.addAttribute("loginAddress", loginLog.get(1).getLoginAddress());
				model.addAttribute("loginTime", loginLog.get(1).getLoginTime());
			} else if (loginLog.size() == 0) {
				model.addAttribute("noLoginLog", "true");
			} else {
				model.addAttribute("loginAddress", loginLog.get(0).getLoginAddress());
				model.addAttribute("loginTime", loginLog.get(0).getLoginTime());
				model.addAttribute("firstLogin", "true");
			}
		} else {
			model.addAttribute("noLoginLog", "true");
		}
	}
	
	/** 操作员查询 */
	private void queryOperatorInfo(HttpSession session, String userBaseId) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("userBaseId", userBaseId);
		conditions.put("limitStart", 0);
		conditions.put("pageSize", 9999);
		List<OperatorInfoDO> operatorInfos = operatorInfoService
			.queryOperatorsByProperties(conditions);
		if (ListUtil.isNotEmpty(operatorInfos)) {
			session.setAttribute("operator", "yes");
			if (2 == operatorInfos.get(0).getOperatorType()
				|| 3 == operatorInfos.get(0).getOperatorType()) {
				
			} else {
				session.setAttribute("tasks", "two");
			}
		} else {
			session.setAttribute("operator", "no");
		}
	}
	
	//	/** 投资详情页的统计投资金额方式 */
	//	private Money queryInvestedAmount() {
	//		TradeDetailQueryOrder queryOrder = new TradeDetailQueryOrder();
	//		queryOrder.setUserId(SessionLocalManager.getSessionLocal().getUserId());
	//		
	//		List<Long> roleIds = new ArrayList<Long>();
	//		roleIds.add((long) SysUserRoleEnum.INVESTOR.getValue());
	//		queryOrder.setRoleIds(roleIds);
	//		queryOrder.setTransferPhase(DivisionPhaseEnum.ORIGINAL_PHASE.code());
	//		TradeDetailBatchResult<TradeDetailVOInfo> batchResult = tradeBizQueryService
	//			.searchTradeDetailTotalAmount(queryOrder);
	//		return batchResult.getTotalAmount();
	//	}
	
	/** 易发二合一页面 */
	private void queryYFtwoToOnePage(final HttpSession session, final Model model) {
		YjfPayPwdOrder payPwdOrder = new YjfPayPwdOrder();
		payPwdOrder.setUserId(ShiroSessionUtils.getSessionLocal().getAccountId());
		
		EsupplierBaseResult EsupplierBaseResult = yjfLoginWebServer.gotoYjfModifyPayPwdUrl(
			payPwdOrder, this.getOpenApiContext());
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		String randomToken = UUID.randomUUID().toString();
		String md5UserBaseId = MD5Util.getMD5_32(userBaseId + md5AddString + randomToken);
		session.setAttribute("userBaseId", userBaseId);
		session.setAttribute("randomToken", randomToken);
		model.addAttribute("modifyPayPwdUrl", EsupplierBaseResult.getUrl());
		model.addAttribute("md5UserBaseId", md5UserBaseId);
		model
			.addAttribute("confirmUserBaseId", ShiroSessionUtils.getSessionLocal().getUserBaseId());
	}
	
	/** 获取积分信息 */
	//	private void queryPointInfo(final Model model, final UserInfo userBaseInfo) {
	//		if (AppConstantsUtil.getISUserPoints()) {
	//			AddPointsOrder addPointsOrder = new AddPointsOrder();
	//			addPointsOrder.setUserId(userBaseInfo.getUserId());
	//			addPointsOrder.setRuleTimeCheck(true);
	//			//			//强实名送积分
	//			//			userPointsByRuleTypeService.addAuthenticationPouints(addPointsOrder);
	//			//			//激活第三方账户送积分
	//			userPointsByRuleTypeService.addAccountPouints(addPointsOrder);
	//			//			//绑定银行卡送积分
	//			//			userPointsByRuleTypeService.addBankcardPouints(addPointsOrder);
	//			
	//			UserPointInfo pointInfo = new UserPointInfo();
	//			PointsQueryConditions pointsQueryConditions = new PointsQueryConditions();
	//			pointsQueryConditions.setUserName(userBaseInfo.getUserName());
	//			PageParam pageParam = new PageParam();
	//			pageParam.setPageNo(1);
	//			pageParam.setPageSize(1);
	//			Page<UserPointInfo> userPointInfo = userPointsService.queryList(pointsQueryConditions,
	//				pageParam);
	//			if (userPointInfo != null && userPointInfo.getTotalCount() > 0) {
	//				pointInfo = userPointInfo.getResult().get(0);
	//			}
	//			model.addAttribute("pointInfo", pointInfo);
	//		}
	//	}
	//	
	
	// ------------------------------------------------------------跳转收银台----------------------------------------------------------------------------
	@RequestMapping("rechargePage.htm")
	public String rechargePage(HttpSession session, HttpServletResponse response)
																					throws UnsupportedEncodingException {
		String userId = ShiroSessionUtils.getSessionLocal().getAccountId();
		session.setAttribute("current", 1);
		EBankDepositOrder deductOrder = new EBankDepositOrder();
		deductOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		deductOrder.setYjfAccountId(userId);
		deductOrder.setSessionId(session.getId());
		EsupplierBaseResult depositResult = deductYrdService.applyEBankDeposit(deductOrder);
		
		try {
			response.sendRedirect(depositResult.getUrl());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
		return null;
	}
	
	// ------------------------------------------------------------账户基本资料查询----------------------------------------------------------------------------
	
	@RequestMapping("userBasicInfo")
	public String userBasicInfo(HttpSession session, Model model) {
		session.setAttribute("current", 1);
		try {
			this.queryUserInfo(session, model);
		} catch (Exception e) {
			logger.error("查询银行信息异常", e);
		}
		return USER_MANAGE_PATH + "userBasicInfo.vm";
	}
	
	@RequestMapping("userRealNameInfo.htm")
	public String userRealNameInfo(Model model, HttpSession session) throws Exception {
		this.queryUserInfo(session, model);
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		String userBaseId = sessionLocal.getUserBaseId();
		UserInfo userBaseInfoDO = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		this.initAccountInfo(model);
		sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (userBaseInfoDO.getRealNameAuthentication() != RealNameAuthStatusEnum.IS) {
			QueryAccountResult statusResult = this.customerService.userInfoQuery(
				userBaseInfoDO.getAccountId(), this.getOpenApiContext());
			if (statusResult.getYjfAccountInfo().getCertifyLevel().getCertifyLevel() >= 3) {
				UpdateRealNameStatusOrder realNameStatusOrder = new UpdateRealNameStatusOrder();
				realNameStatusOrder.setAccountId(userBaseInfoDO.getAccountId());
				realNameStatusOrder.setYjfReturnStatus(RealNameAuthStatusEnum.IS.getYjfStatus());
				userBaseInfoManager.updateRealNameStatus(realNameStatusOrder);
			}
		}
		
		model.addAttribute("uploadHost", "");
		model.addAttribute("certifyLevel", sessionLocal.getCertifyLevel());
		if (userBaseInfoDO.getRealNameAuthentication() != null) {
			model
				.addAttribute("realNameAuthentication", userBaseInfoDO.getRealNameAuthentication());
		}
		
		session.setAttribute("token", UUID.randomUUID().toString());
		
		if (userBaseInfoDO.getType() == UserTypeEnum.GR) {
			
			return USER_MANAGE_PATH + "userRealNameInfo.vm";
		} else {
			
			return USER_MANAGE_PATH + "enterpriseInfo.vm";
		}
	}
	
	@RequestMapping("updateEnterpriseInfo.htm")
	public Object updateEnterpriseInfo(Model model, HttpServletRequest request, HttpSession session)
																									throws Exception {
		UpdateEnterpriseOrder updateOrder = new UpdateEnterpriseOrder();
		JSONObject jsonobj = new JSONObject();
		WebUtil.setPoPropertyByRequest(updateOrder, request);
		updateOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		EsupplierBaseResult yrdBaseResult = registerService.updateOrgBackstageRegister(updateOrder);
		
		if (yrdBaseResult.isSuccess()) {
			EsupplierBaseResult baseResult = this.realNameAuthenticationService
				.sendEnterpriseRealNameInfo(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			if (baseResult.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "实名认证申请成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "修改机构成功,实名申请失败");
			}
			
		}
		if (!yrdBaseResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改机构信息失败,原因（" + yrdBaseResult.getMessage() + "）");
		}
		return jsonobj;
	}
	
	// ------------------------------------------------------------账户首页----------------------------------------------------------------------------
	@RequestMapping("userHome.htm")
	public String userHome(HttpSession session, Model model, HttpServletRequest request) {
		//编号
		//		model.addAttribute("userMemoNo", queryMemberNo());
		//获取登录信息
		queryLoginInfo(model);
		
		//yjfAccountInfo vipInfo
		initAccountInfo(model, false);
		
		//易极付帐户信息
		YjfAccountInfo accountInfo = getAccountInfo(model);
		//用户信息
		UserInfo userBaseInfo = getUserBaseInfo(session, model);
		//操作员信息
		//		queryOperatorInfo(session, userBaseInfo.getUserBaseId());
		//更新本地账户的实名认证状态
		updateLocalAccountByRemote(userBaseInfo, accountInfo);
		//投资详情页的统计投资金额方式
		//		model.addAttribute("allAmount", queryInvestedAmount());
		
		//积分信息
		//		queryPointInfo(model, userBaseInfo);
		
		//		try {
		//			setRole(userBaseInfo.getUserId(), model);
		//			countInvestAndLoan(session, model);
		//			setCommissionList(session, model);
		//		} catch (Exception e) {
		//			logger.error("countInvestAndLoan errror", e);
		//		}
		//统计总资产
		//		model.addAttribute("totolAmount",
		//			statTotalAmount(model, accountInfo, userBaseInfo.getUserId()));
		//易发的二合一页面
		queryYFtwoToOnePage(session, model);
		
		model.addAttribute("sessionScope", ShiroSessionUtils.getSessionLocal());
		return USER_MANAGE_PATH + "userHome1.vm";
	}
	
	@RequestMapping("accountSetting.htm")
	public String userBankInfo(HttpServletRequest request, HttpServletResponse response,
								Model model, HttpSession session) {
		
		try {
			initAccountInfo(model);
			String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
			
			String randomToken = UUID.randomUUID().toString();
			String md5UserBaseId = MD5Util.getMD5_32(userBaseId + md5AddString + randomToken);
			session.setAttribute("userBaseId", userBaseId);
			session.setAttribute("randomToken", randomToken);
			model.addAttribute("md5UserBaseId", md5UserBaseId);
			model.addAttribute("userBaseId", userBaseId);
			model.addAttribute("confirmUserBaseId", ShiroSessionUtils.getSessionLocal()
				.getUserBaseId());
			
		} catch (Exception e) {
			logger.error("initAccountInfo error", e);
		}
		
		return USER_MANAGE_PATH + "accountSetting.vm";
	}
	
	@RequestMapping("forgetPwd")
	public void forgetPwd(HttpServletRequest request, HttpServletResponse response,
							HttpSession session) {
		try {
			YjfPayPwdOrder payPwdOrder = new YjfPayPwdOrder();
			payPwdOrder.setSources("PC");
			payPwdOrder.setUserId(ShiroSessionUtils.getSessionLocal().getAccountId());
			EsupplierBaseResult EsupplierBaseResult = yjfLoginWebServer.gotoYjfModifyPayPwdUrl(
				payPwdOrder, this.getOpenApiContext());
			if (StringUtil.isNotEmpty(EsupplierBaseResult.getUrl())) {
				response.sendRedirect(EsupplierBaseResult.getUrl());
			}
		} catch (Exception e) {
			logger.error("forgetPwd error", e);
		}
		
	}
	
	@RequestMapping("modifyPayPwd")
	public void modifyPayPwd(HttpServletRequest request, HttpServletResponse response,
								HttpSession session) {
		try {
			YjfPayPwdOrder payPwdOrder = new YjfPayPwdOrder();
			payPwdOrder.setUserId(ShiroSessionUtils.getSessionLocal().getAccountId());
			
			EsupplierBaseResult EsupplierBaseResult = yjfLoginWebServer.gotoYjfModifyPayPwdUrl(
				payPwdOrder, this.getOpenApiContext());
			if (StringUtil.isNotEmpty(EsupplierBaseResult.getUrl())) {
				response.sendRedirect(EsupplierBaseResult.getUrl());
			}
		} catch (Exception e) {
			logger.error("modifyPayPwd error", e);
		}
		
	}
	
	@RequestMapping("userBankInfo")
	public String userBankInfo(HttpSession session, Model model) {
		try {
			this.queryUserInfo(session, model);
		} catch (Exception e) {
			logger.error("查询银行信息异常", e);
		}
		return USER_MANAGE_PATH + "userBankInfo.vm";
	}
	
	// ------------------------------------------------------------账户基本资料修改----------------------------------------------------------------------------
	
	@ResponseBody
	@RequestMapping("updateUserRealNameInfo.json")
	public Object updateUserRealNameInfo(HttpServletRequest request, HttpSession session,
											String realName, String certNo, String businessPeriod,
											String conCertNo, String certFrontPath,
											String certBackPath, String token) throws Exception {
		
		JSONObject jsonobj = new JSONObject();
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		// Map<String,Object> resultMap = new HashMap<String, Object>();
		String getToken = (String) session.getAttribute("token");
		if (userBaseInfo.getType() == UserTypeEnum.GR && token.equals(getToken)) {
			session.removeAttribute("token");
			// 个人的时候需要同步更新user_base_info的真实名称
			ApplyRealNameOrder order = new ApplyRealNameOrder();
			order.setUserBaseId(userBaseId);
			// 改变值
			order.setRealName(realName);
			order.setCertNo(certNo);
			
			order.setBusinessPeriod(businessPeriod);
			order.setCertFrontPath(certFrontPath);
			order.setCertBackPath(certBackPath);
			// personalInfo.setCertFrontPath("http://192.168.45.212:30000//uploadfile/images/2014-06/03/110_2039062487.png");
			// personalInfo.setCertBackPath("http://192.168.45.212:30000//uploadfile/images/2014-06/03/110_2048199935.png");
			// 调用修改方法
			
			EsupplierBaseResult EsupplierBaseResult = null;
			//			if ("Y".equals(request.getParameter("preUpdate"))) {
			//				EsupplierBaseResult = realNameAuthenticationService.updateLicenseValidTime(order);
			//			} else {
			//				EsupplierBaseResult = realNameAuthenticationService.applyRealName(order);
			//			}
			EsupplierBaseResult = realNameAuthenticationService.applyRealName(order);
			if (EsupplierBaseResult.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "实名认证发送成功");
			} else {
				jsonobj.put("code", 0);
				if (EsupplierBaseResult.getCreditsysResultEnum() == EsupplierResultEnum.DO_ACTION_STATUS_ERROR) {
					jsonobj.put("message", "你已经提交了申请，请不要重复提交");
				} else {
					jsonobj.put("message", "实名认证发送失败[" + EsupplierBaseResult.getMessage() + "]");
				}
				
			}
			
			// 更新SessionLocal
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			sessionLocal.setRealName(realName);
			ShiroSessionUtils.setSessionLocal(sessionLocal);
			
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("updateWeakUserRealNameInfo.json")
	public Object updateWeakUserRealNameInfo(HttpSession session, UserQuickCertifyOrder order,
												String token) throws Exception {
		
		JSONObject jsonobj = new JSONObject();
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		// Map<String,Object> resultMap = new HashMap<String, Object>();
		String getToken = (String) session.getAttribute("token");
		if (userBaseInfo.getType() == UserTypeEnum.GR && token.equals(getToken)) {
			session.removeAttribute("token");
			order.setUserId(userBaseInfo.getAccountId());
			EsupplierBaseResult EsupplierBaseResult = realNameAuthenticationService
				.applyUserQuickCertifyOrder(order);
			if (EsupplierBaseResult.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "实名认证发送成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "实名认证发送失败");
			}
			
			// 更新SessionLocal
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			sessionLocal.setRealName(order.getRealName());
			ShiroSessionUtils.setSessionLocal(sessionLocal);
			
		}
		return jsonobj;
	}
	
	/**
	 * 发送实名认证
	 * @param activaStep
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("sendRealNameAuthentication.json")
	public Object sendRealNameAuthentication(String activaStep, HttpServletResponse response)
																								throws Exception {
		JSONObject jsonobj = new JSONObject();
		
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		
		if (UserTypeEnum.JG.equals(userBaseInfo.getType())) {// 机构企业用户
			baseResult = realNameAuthenticationService.sendEnterpriseRealNameInfo(userBaseId);
		} else if (UserTypeEnum.GR.equals(userBaseInfo.getType())) {// 个人用户
			baseResult = this.realNameAuthenticationService.sendPersonalRealNameInfo(userBaseId);
		}
		
		if (baseResult.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", baseResult.getMessage());
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", baseResult.getMessage());
		}
		if ((Integer) jsonobj.get("code") == 1) {
			// 通知实名认证客服
			StringBuffer message = new StringBuffer();
			message.append("客户--" + userBaseInfo.getRealName() + ", 已申请实名认证，提交时间："
							+ DateUtil.simpleFormat(new Date()) + ", 请及时处理！");
		}
		if ("activating".equals(activaStep))
			jsonobj.put("activaStep", 0);// 激活时实名
		else
			jsonobj.put("activaStep", 1);// 登录后实名
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("updateRealNameAuthenticationInfo.json")
	public Object updateRealNameAuthenticationInfo(HttpSession session, String regionType,
													String realName, String certNo,
													String businessPeriod, String conCertNo,
													String sex, String address,
													String certFrontPath, String certBackPath,
													String token, HttpServletRequest request)
																								throws Exception {
		
		JSONObject jsonobj = new JSONObject();
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		// Map<String,Object> resultMap = new HashMap<String, Object>();
		String getToken = (String) session.getAttribute("token");
		if (userBaseInfo.getType() == UserTypeEnum.GR && token.equals(getToken)) {
			session.removeAttribute("token");
			
			if (regionType.equals("DL")) {
				
				// 个人的时候需要同步更新user_base_info的真实名称
				ApplyRealNameOrder order = new ApplyRealNameOrder();
				order.setUserBaseId(userBaseId);
				// 改变值
				order.setRealName(realName);
				order.setCertNo(certNo);
				
				order.setBusinessPeriod(businessPeriod);
				order.setCertFrontPath(certFrontPath);
				order.setCertBackPath(certBackPath);
				// 调用修改方法
				
				EsupplierBaseResult EsupplierBaseResult = null;/*= realNameAuthenticationService.applyRealName(order);*/
				//				if ("Y".equals(request.getParameter("preUpdate"))) {
				//					EsupplierBaseResult = realNameAuthenticationService.updateLicenseValidTime(order);
				//				} else {
				//					EsupplierBaseResult = realNameAuthenticationService.applyRealName(order);
				//				}
				EsupplierBaseResult = realNameAuthenticationService.applyRealName(order);
				if (EsupplierBaseResult.isSuccess()) {
					jsonobj.put("code", 1);
					jsonobj.put("message", "实名认证发送成功");
				} else {
					jsonobj.put("code", 0);
					if (EsupplierBaseResult.getCreditsysResultEnum() == EsupplierResultEnum.DO_ACTION_STATUS_ERROR) {
						jsonobj.put("message", "你已经提交了申请，请不要重复提交");
					} else {
						jsonobj.put("message", "实名认证发送失败");
					}
				}
			} else {
				NonMainlandRealAuthenticateOrder order = new NonMainlandRealAuthenticateOrder();
				order.setUserBaseId(userBaseId);
				order.setRealName(realName);
				order.setSex(PeasonSexEnum.getByCode(sex));
				order.setCertTypeEnum(CertTypeEnum.Other);
				order.setAttribution(AttributionEnum.getByCode(regionType));
				order.setCertNo(certNo);
				order.setBusinessPeriod(businessPeriod);
				order.setCertFrontPath(certFrontPath);
				order.setCertBackPath(certBackPath);
				order.setAddress(address);
				EsupplierBaseResult EsupplierBaseResult = realNameAuthenticationService
					.applyNonMainlandRealName(order);
				
				if (EsupplierBaseResult.isSuccess()) {
					jsonobj.put("code", 1);
					jsonobj.put("message", "实名认证发送成功");
				} else {
					jsonobj.put("code", 0);
					jsonobj.put("message", EsupplierBaseResult.getMessage());
				}
			}
			
			// 更新SessionLocal
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			sessionLocal.setRealName(realName);
			ShiroSessionUtils.setSessionLocal(sessionLocal);
			
		}
		return jsonobj;
	}
	
	@RequestMapping("changeEmail")
	public String changeEmail(HttpSession session, Model model) {
		initAccountInfo(model);
		return USER_MANAGE_PATH + "changeEmail.vm";
	}
	
	@RequestMapping("changeEmailSubmit")
	@ResponseBody
	public JSONObject changeEmailSubmit(HttpSession session, HttpServletRequest request, Model model) {
		JSONObject jsonobj = new JSONObject();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
			ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
		String code = request.getParameter("code");
		String newMail = request.getParameter("newMail");
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(userBaseInfo.getMobile(),
			SmsBizType.PERSONAL, code, true);
		if (!smsCodeResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "验证码校验失败");
			return jsonobj;
		}
		
		RegisterOrder order = new RegisterOrder();
		order.setUserId(userBaseInfo.getAccountId());
		order.setEmail(newMail);
		CustomerResult customerResult = customerService.openCapitalAccount(order,
			this.getOpenApiContext());
		if (!customerResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改邮箱失败");
		}
		returnEnum = userBaseInfoManager.mailBinding(userBaseInfo.getUserBaseId(), newMail);
		if (returnEnum.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改邮箱成功");
			
			/** 发送站内信 **/
			SystemSendMessageOrder systemSendMessageOrder = new SystemSendMessageOrder();
			systemSendMessageOrder.setType(SysSendMessageTypeEnum.EMAIL_CHANGE);
			systemSendMessageOrder.setUserName(userBaseInfo.getUserName());
			systemMessageService.systemSendMessage(systemSendMessageOrder);
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改邮箱失败");
		}
		return jsonobj;
	}
	
	@RequestMapping("changeMobile")
	public String changeMobile(HttpSession session, PageParam pageParam, Model model) {
		initAccountInfo(model);
		return USER_MANAGE_PATH + "changeMobile.vm";
	}
	
	@RequestMapping("changeMobileSubmit")
	@ResponseBody
	public JSONObject changeMobileSubmit(HttpSession session, HttpServletRequest request,
											Model model) {
		JSONObject jsonObject = new JSONObject();
		try {
			String code = request.getParameter("code");
			String newMobile = request.getParameter("newMobile");
			UserInfo userBaseInfo = userQueryService.queryByUserBaseId(
				ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(userBaseInfo.getMobile(),
				SmsBizType.CELLPHONE, code, true);
			
			if (!smsCodeResult.isSuccess()) {
				jsonObject.put("code", 0);
				jsonObject.put("message", "验证码校验失败");
			}
			
			userBaseInfo.setMobile(newMobile);
			MobileBindOrder mobileBindOrder = new MobileBindOrder();
			mobileBindOrder.setUserId(userBaseInfo.getAccountId());
			mobileBindOrder.setMobile(newMobile);
			mobileBindOrder.setIsNew(BooleanEnum.NO);
			EsupplierBaseResult baseResult = this.customerService.updateMobileBinding(
				mobileBindOrder, this.getOpenApiContext());
			if (baseResult.isSuccess()) {
				MobileBindingOrder mobileBindingOrder = new MobileBindingOrder();
				mobileBindingOrder.setUserBaseId(userBaseInfo.getUserBaseId());
				mobileBindingOrder.setMobile(newMobile);
				EsupplierBaseResult returnEnum = userBaseInfoManager.mobileBinding(mobileBindingOrder);
				if (returnEnum.isSuccess()) {
					jsonObject.put("code", 1);
					jsonObject.put("message", "修改手机成功");
					
				}
			}
		} catch (Exception e) {
			logger.error("修改手机", e);
		}
		
		return jsonObject;
	}
	
}
