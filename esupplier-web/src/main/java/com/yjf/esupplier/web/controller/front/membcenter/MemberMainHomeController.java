package com.yjf.esupplier.web.controller.front.membcenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.common.util.CommonUtil;
import com.yjf.esupplier.common.util.ConfigParamProperty;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.integration.openapi.enums.UserStatusEnum;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.integration.web.server.YjfLoginWebServer;
import com.yjf.esupplier.service.bill.OrderQueryService;
import com.yjf.esupplier.service.bill.OrderRefundService;
import com.yjf.esupplier.service.common.services.RealNameAuthenticationService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.service.product.ProductRecommendService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.RegisterService;
import com.yjf.esupplier.service.user.UserAccountDataQueryService;
import com.yjf.esupplier.service.user.UserBaseInfoManager;
import com.yjf.esupplier.service.user.info.*;
import com.yjf.esupplier.service.user.order.OpenCapitalAccountOrder;
import com.yjf.esupplier.service.user.order.OpenCapitalAccountOrder.CapitalAccountResult;
import com.yjf.esupplier.service.user.query.UserAccountQueryService;
import com.yjf.esupplier.service.user.query.UserRelationQueryService;
import com.yjf.esupplier.service.user.result.PersonalQueryResult;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("do")
public class MemberMainHomeController extends FrontAutowiredBaseController {
	static String path = "front/platform/member/userinfo/";
	@Autowired
	RegisterService registerService;
	@Autowired
	YjfLoginWebServer yjfLoginWebServer;
	@Autowired
	UserAccountQueryService accountQueryService;
	@Autowired
	RealNameAuthenticationService realNameAuthenticationService;
	@Autowired
	protected UserRelationQueryService userRelationQueryService;
	
	@Autowired
	protected UserAccountQueryService userAccountQueryService;
	@Autowired
	protected UserBaseInfoManager userBaseInfoManager;
	@Autowired
	protected ProductRecommendService productRecommendService;
	@Autowired
	protected OrderQueryService orderQueryService;
	@Autowired
	protected OrderRefundService orderRefundService;

	@Autowired
	protected GiftMoneyTradeQueryService giftMoneyTradeQueryService;
	@Autowired
	protected UserAccountDataQueryService userAccountDataQueryService;
	@RequestMapping("mainHome.htm")
	public String mainHome(HttpSession session, HttpServletRequest request,
							HttpServletResponse response, Model model) {
		
		// 编号
		model.addAttribute("userMemoNo", queryMemberNo());
		//获取登录信息
		queryLoginInfo(model);
		
		//		//用户信息
		//		UserInfo userBaseInfo = getUserBaseInfo(session, model);
		//		//yjfAccountInfo vipInfo
		//		initAccountInfo(model, false);
		
		//		//易极付帐户信息
		YjfAccountInfo accountInfo = getAccountInfo(model);
		
		//		//更新本地账户的实名认证状态
		//		realNameAuthenticationService.updateLocalAccountByRemote(userBaseInfo, accountInfo);
		//
		//		//商品相关推荐
		//		ProductRecommendOrder order = new ProductRecommendOrder();
		//		order.setLimitStart(1);
		//		order.setPageSize(8);
		//		List<ProductInfo> productList = productRecommendService.getProductRecommendList(order)
		//			.getPageList();
		//
		//		model.addAttribute("productList", productList);
		//		model.addAttribute("sessionScope", ShiroSessionUtils.getSessionLocal());
		//		model.addAttribute("accountOpen", false);
		
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UserQueryResult userQueryResult = userQueryService.queryByUserId(sessionLocal.getUserId());
		model.addAttribute("userInfo", userQueryResult.getQueryUserInfo());
		model.addAttribute("userMoney", userQueryResult.getUserMoney());
		GiftMoneyTradeQueryOrder demandQueryOrder = new GiftMoneyTradeQueryOrder();
		demandQueryOrder.setUserid(sessionLocal.getUserId());
		demandQueryOrder.setType(GiftMoneyTypeEnum.GAIN_AMOUNT.code());
		demandQueryOrder.setStatus(GiftMoneyStatusEnum.NORMAL.code());
		QueryBaseBatchResult<GiftMoneyTradeInfo> result = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(demandQueryOrder);
		model.addAttribute("giftAmountSize", result.getPageList().size());
		boolean canSeeMoney = ConfigParamProperty.getIsSeeMoney();
		UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService.getUserAccountDataInfo(sessionLocal.getUserId(),canSeeMoney);
		
		model.addAttribute("amount", userAccountDataInfo.getUserBalance().toStandardString());
		model.addAttribute("userIntegral",userAccountDataInfo.getUserIntegral());
//		model.addAttribute("giftCount", count(sessionLocal.getUserId(), GiftMoneyTypeEnum.GIFT_MONEY.code()));
		/*用户优惠券张数*/
		//map.put("gainCount", String.valueOf(accountDataInfo.getUserCouponCount()));
		model.addAttribute("gainCount", count(sessionLocal.getUserId(), GiftMoneyTypeEnum.GAIN_AMOUNT.code()));
		//		if (StringUtil.isNotBlank(userInfo.getAccountId())) {
		//			QueryAccountResult accountResult = accountQueryService.getAccountInfo(sessionLocal);
		//			realNameAuthenticationService.updateLocalAccountByRemote(userInfo,
		//				accountResult.getYjfAccountInfo());
		//
		//			if (!accountResult.getYjfAccountInfo().isActive()) {
		//				model.addAttribute("accountOpen", true);
		//				model.addAttribute("accountInfo", accountResult.getYjfAccountInfo());
		//			}
		//		}
		
		//订单状态条数
		//		OrderFlowStatusCountInfo orderCountInfo = orderQueryService.loadOrderStausCount(userInfo
		//			.getUserId());
		//		model.addAttribute("orderCountInfo", orderCountInfo);
		//		//待确认退货条数
		//		long waitRefundCount = orderRefundService
		//			.findRefundOrderCountByUserId(userInfo.getUserId());
		//		model.addAttribute("waitRefundCount", waitRefundCount);
		
		return path + "buyer_mainHome.vm";
	}
	
	@RequestMapping("openPayAccount.htm")
	public String openPayAccount(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		model.addAllAttributes(WebUtil.getRequestMap(request));
		String redirect = request.getParameter("redirect");
		if (StringUtil.isNotBlank(redirect)) {
			if (!redirect.startsWith("/")) {
				redirect = null;
			}
		}
		model.addAttribute("redirect", redirect);
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UserInfo userInfo = userQueryService.queryByUserId(sessionLocal.getUserId())
			.getQueryUserInfo();
		if (StringUtil.isNotEmpty(userInfo.getAccountId())) {
			QueryAccountResult accountResult = customerService.queryUserAccount(
				userInfo.getAccountId(), getOpenApiContext());
			if (accountResult.isSuccess()) {
				if (UserStatusEnum.NORMAL.code().equals(
					accountResult.getYjfAccountInfo().getStatus())) {
					EsupplierBaseResult baseResult = new EsupplierBaseResult();
					baseResult.setMessage("已经开通易极付账户！");
					model.addAttribute("result", baseResult);
					return path + "result.vm";
				} else {
					sendActiveUser(request, response, model, redirect, userInfo);
					return null;
				}
			}
		} else {
			PersonalQueryResult queryResult = userQueryService.queryPersonalInfoByBaseId(userInfo
				.getUserBaseId());
			if (queryResult.getQueryPersonalInfo() != null) {
				model
					.addAttribute("compellation", queryResult.getQueryPersonalInfo().getRealName());
				model.addAttribute("identity", queryResult.getQueryPersonalInfo().getCertNo());
			}
		}
		return path + "openPayAccount.vm";
	}
	
	@RequestMapping("openPayAccountSubmit.htm")
	public String openPayAccountSubmit(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		String redirect = request.getParameter("redirect");
		if (StringUtil.isNotBlank(redirect)) {
			if (!redirect.startsWith("/")) {
				redirect = null;
			}
		}
		OpenCapitalAccountOrder capitalAccountOrder = new OpenCapitalAccountOrder();
		capitalAccountOrder.setCertNo(request.getParameter("identity"));
		capitalAccountOrder.setRealName(request.getParameter("compellation"));
		capitalAccountOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		CapitalAccountResult accountResult = registerService
			.openCapitalAccountIfNotExist(capitalAccountOrder);
		
		if (accountResult.isSuccess()) {
			accountResult.setMessage("开通支付账户成功");
			UserInfo userInfo = userQueryService.queryByUserId(
				ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
			sendActiveUser(request, response, model, redirect, userInfo);
			return null;
		}
		
		model.addAttribute("result", accountResult);
		return path + "result.vm";
	}
	
	private void sendActiveUser(HttpServletRequest request, HttpServletResponse response,
								Model model, String redirect, UserInfo userInfo) {
		
	}
	
	/** 获取登录信息 */
	private void queryLoginInfo(final Model model) {
		
		if (ShiroSessionUtils.getSessionLocal().getLastDate() == null) {
			model.addAttribute("loginAddress", ShiroSessionUtils.getSessionLocal()
				.getLastRemoteAddr());
			model.addAttribute("loginTime", ShiroSessionUtils.getSessionLocal().getLastDate());
			model.addAttribute("firstLogin", "true");
			model.addAttribute("noLoginLog", "true");
		} else {
			model.addAttribute("loginAddress", ShiroSessionUtils.getSessionLocal()
				.getLastRemoteAddr());
			model.addAttribute("loginTime", ShiroSessionUtils.getSessionLocal().getLastDate());
		}
		Calendar today = Calendar.getInstance();
		int hour = today.get(Calendar.HOUR_OF_DAY);
		if (hour >= 4 && hour < 12) {
			model.addAttribute("titleAsk", "早上");
		} else if (hour >= 12 && hour < 14) {
			model.addAttribute("titleAsk", "中午");
		} else if (hour >= 14 && hour <= 19) {
			model.addAttribute("titleAsk", "下午");
		} else {
			model.addAttribute("titleAsk", "晚上");
		}
		
	}
	
	/**
	 * @param session
	 * @param model
	 * 
	 * @return
	 */
	
	protected UserInfo getUserBaseInfo(HttpSession session, Model model) {
		UserInfo userBaseInfo = null;
		try {
			userBaseInfo = (UserInfo) model.asMap().get("userBaseInfo");
			if (userBaseInfo != null) {
				return userBaseInfo;
			}
			if (ShiroSessionUtils.getSessionLocal() == null
				|| ShiroSessionUtils.getSessionLocal().getUserId() <= 0) {
				return null;
			}
			userBaseInfo = userQueryService.queryByUserBaseId(
				ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
			
		} catch (Exception e) {
			logger.error("未找到当前登录的用户", e);
		}
		model.addAttribute("userBaseInfo", userBaseInfo);
		try {
			queryUserInfo(session, model);
		} catch (Exception e) {
			logger.error("查询银行信息异常", e);
		}
		
		if (CommonUtil.checkEmail(userBaseInfo.getMail())) {
			model.addAttribute("mailBinding", "IS");
		} else {
			model.addAttribute("mailBinding", "NO");
		}
		return userBaseInfo;
	}
	
	protected void queryUserInfo(HttpSession session, Model model) throws Exception {
		
		String msg = "暂无";
		
		UserInfo userBaseInfoDO = (UserInfo) model.asMap().get("userBaseInfo");
		if (userBaseInfoDO != null && ShiroSessionUtils.getSessionLocal() != null) {
			userBaseInfoDO = userQueryService.queryByUserId(
				ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
		} else {
			return;
		}
		if (userBaseInfoDO.getRealNameAuthentication() == null) {
			model.addAttribute("realNameStatus", "N");
		} else {
			model.addAttribute("realNameStatus", userBaseInfoDO.getRealNameAuthentication());
		}
		if (userBaseInfoDO.getType() == UserTypeEnum.GR) {
			PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(
				userBaseInfoDO.getUserBaseId()).getQueryPersonalInfo();
			
			model.addAttribute("info", personalInfo);
			String mobile = userBaseInfoDO.getMobile();
			if (!StringUtil.isEmpty(mobile)) {
				model.addAttribute(
					"mobile",
					mobile.substring(0, 3) + "*****"
							+ mobile.subSequence(mobile.length() - 3, mobile.length()));
			} else {
				model.addAttribute("mobile", msg);
			}
			String mail = userBaseInfoDO.getMail();
			if (!StringUtil.isEmpty(mail)) {
				model.addAttribute("mail", StringUtil.subString(mail, 1, "****"));
			} else {
				model.addAttribute("mail", msg);
			}
			String certNo = personalInfo.getCertNo();
			if (!StringUtil.isEmpty(certNo)) {
				model.addAttribute(
					"certNo",
					certNo.substring(0, 2) + "**************"
							+ certNo.subSequence(certNo.length() - 2, certNo.length()));
			} else {
				model.addAttribute("certNo", msg);
			}
		}
		if (userBaseInfoDO.getType() == UserTypeEnum.JG) {
			InstitutionsInfo institutionsInfo = userQueryService.queryInstitutionsInfoByBaseId(
				userBaseInfoDO.getUserBaseId()).getQueryInstitutionsInfo();
			
			if (userBaseInfoDO != null) {
				BeanCopier.staticCopy(userBaseInfoDO, institutionsInfo);
			}
			model.addAttribute("info", institutionsInfo);
			String contactCertNo = institutionsInfo.getContactCertNo();// 联系人身份证号
			if (!StringUtil.isEmpty(contactCertNo)) {
				model.addAttribute(
					"contactCertNo",
					contactCertNo.substring(0, 2)
							+ "*************"
							+ contactCertNo.subSequence(contactCertNo.length() - 2,
								contactCertNo.length()));
			} else {
				model.addAttribute("contactCertNo", msg);
			}
			String legalCrdNo = institutionsInfo.getLegalRepresentativeCardNo();
			if (!StringUtil.isEmpty(legalCrdNo)) {
				model.addAttribute(
					"legalCrdNo",
					legalCrdNo.substring(0, 2)
							+ "**************"
							+ contactCertNo.subSequence(contactCertNo.length() - 2,
								contactCertNo.length()));
			} else {
				model.addAttribute("legalCrdNo", msg);
			}
			String mobile = userBaseInfoDO.getMobile();
			if (!StringUtil.isEmpty(mobile)) {
				model.addAttribute(
					"mobile",
					mobile.substring(0, 2) + "*******"
							+ mobile.subSequence(mobile.length() - 2, mobile.length()));
			} else {
				model.addAttribute("mobile", msg);
			}
			
			String mail = userBaseInfoDO.getMail();
			if (!StringUtil.isEmpty(mail)) {
				String[] strMail = mail.split("@");
				model.addAttribute("mail", strMail[0].substring(0, 2) + "*******" + "@"
											+ strMail[1]);
			} else {
				model.addAttribute("mail", msg);
			}
		}
	}
	
	protected void initAccountInfo(Model model, boolean isInitUserBase) {
		model.addAttribute("openAccount", false);
		if (ShiroSessionUtils.getSessionLocal() != null
			&& StringUtil.isNotEmpty(ShiroSessionUtils.getSessionLocal().getAccountId())) {
			
			YjfAccountInfo accountInfo = userAccountQueryService.getAccountInfo(
				ShiroSessionUtils.getSessionLocal()).getYjfAccountInfo();
			if (isInitUserBase)
				getUserBaseInfo(null, model);
			model.addAttribute("yjfAccountInfo", accountInfo);
			model.addAttribute("certifyLevel", ShiroSessionUtils.getSessionLocal()
				.getCertifyLevel());
			model.addAttribute("openAccount", accountInfo.isActive());
		}
		
	}
	
	protected YjfAccountInfo getAccountInfo(Model model) {
		YjfAccountInfo accountInfo = (YjfAccountInfo) model.asMap().get("yjfAccountInfo");
		if (accountInfo == null) {
			initAccountInfo(model);
			accountInfo = (YjfAccountInfo) model.asMap().get("yjfAccountInfo");
		}
		return accountInfo;
	}
	
	protected void initAccountInfo(Model model) {
		initAccountInfo(model, true);
	}
	
	/** 获取memberNo */
	private String queryMemberNo() {
		UserRelationInfo relationInfo = userRelationQueryService.findUserRelationByChildId(
			ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserRelationInfo();
		return null == relationInfo ? null : relationInfo.getMemberNo();
	}
	
	/** 统计红包或优惠券个数 */
	private String count(long userId, String type) {
		long count = 0;
		List<String> typeList = new ArrayList<String>();
		if (StringUtil.equals("GIFT_MONEY", type)) {
			typeList.add(GiftMoneyTypeEnum.GIFT_MONEY.getCode());
		} else if (StringUtil.equals("GAIN_AMOUNT", type)) {
			typeList.add(GiftMoneyTypeEnum.GAIN_AMOUNT.getCode());
		}
		List<String> statusList = new ArrayList<String>();
		statusList.add("FINISH");
		statusList.add("NORMAL");
		statusList.add("EXPIRE");
		GiftMoneyTradeQueryOrder demandQueryOrder = new GiftMoneyTradeQueryOrder();
		demandQueryOrder.setPageSize(1);
		demandQueryOrder.setUserid(userId);
		demandQueryOrder.setTypeList(typeList);
		// demandQueryOrder.setStatus("NORMAL");
		demandQueryOrder.setStatusList(statusList);
		QueryBaseBatchResult<GiftMoneyTradeInfo> result = giftMoneyTradeQueryService
			.queryGiftMoneyTradeNum(demandQueryOrder);
		if (result.isSuccess()) {
			count = result.getTotalCount();
		}
		return String.valueOf(count);
	}
}
