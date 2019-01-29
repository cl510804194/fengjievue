package com.yjf.esupplier.web.controller.backstage.giftMoney;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.common.util.PageTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyRuleQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.impl.UserBaseInfoBaseService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.order.UserQueryOrder;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyUseTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyInfo;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyRuleInfo;
import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;
import com.yjf.esupplier.ws.gifamount.order.HandGiftMoneyOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyQueryOrder;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyAssignProcessService;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyService;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

@Controller
public class GiftMoneyPreController extends GiftMoneyBaseController {
	/**
	 * 页面所在路径
	 */
	private String BORROWING_MANAGE__PATH = "/backstage/giftMoney/";
	
	@Autowired
	GiftMoneyQueryService giftMoneyQueryService;
	
	@Autowired
	GiftMoneyService giftMoneyService;
	
	@Autowired
	GiftMoneyRuleQueryService giftMoneyRuleQueryService;
	
	@Autowired
	GiftMoneyAssignProcessService giftMoneyAssignProcessService;
	
	@Autowired
	GiftMoneyTradeQueryService giftMoneyTradeQueryService;
	
	public String getBORROWING_MANAGE__PATH() {
		return BORROWING_MANAGE__PATH;
	}
	
	public void setBORROWING_MANAGE__PATH(String BORROWING_MANAGE__PATH) {
		this.BORROWING_MANAGE__PATH = BORROWING_MANAGE__PATH;
	}
	
	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "useStartDate", "useEndDate", "startDate", "endDate" };
	}
	
	@Override
	protected String[] getMoneyInputNameArray() {
		return new String[] { "amount", "totalAmount", "balanceAmount", "usedAmount" };
	}
	
	public String addGiftMoney(Model model) {
		List<GiftMoneyTypeEnum> types = GiftMoneyTypeEnum.getAllEnum();
		model.addAttribute("types", types);
		model.addAttribute("giveTypes", giveTypes());
		List<GiftMoneyUseTypeEnum> useTypes = GiftMoneyUseTypeEnum.getAllEnum();
		model.addAttribute("useTypes", useTypes);
		
		return BORROWING_MANAGE__PATH + "addGiftMoney.vm";
	}
	
	public String updateGiftMoney(long giftId, Model model) {
		GiftMoneyInfo info = giftMoneyQueryService.findById(giftId);
		model.addAttribute("info", info);
		List<GiftMoneyTypeEnum> types = GiftMoneyTypeEnum.getAllEnum();
		model.addAttribute("types", types);
		model.addAttribute("giveTypes", giveTypes());
		List<GiftMoneyUseTypeEnum> useTypes = GiftMoneyUseTypeEnum.getAllEnum();
		List<GiftMoneyRuleInfo> rules = giftMoneyRuleQueryService
			.queryGiftMoneyRuleByGiftId(giftId);
		List<GiftMoneyRuleInfo> registerDateRule = giftMoneyRuleQueryService
			.queryGiftMoneyRuleRegisterByGiftId(giftId);
		model.addAttribute("rules", rules);
		if (ListUtil.isNotEmpty(registerDateRule)) {
			model.addAttribute("registerDateRule", registerDateRule.get(0));
		}
		model.addAttribute("useTypes", useTypes);
		return BORROWING_MANAGE__PATH + "updateGiftMoney.vm";
	}
	
	private List<GiftMoneyGiveTypeEnum> giveTypes() {
		List<GiftMoneyGiveTypeEnum> giveTypes = GiftMoneyGiveTypeEnum.getAllEnum();
		List<GiftMoneyGiveTypeEnum> typeEnums = new ArrayList<GiftMoneyGiveTypeEnum>();
		for (GiftMoneyGiveTypeEnum typeEnum : giveTypes) {
			if (typeEnum == GiftMoneyGiveTypeEnum.REGISTER_24_TRADE
				|| typeEnum == GiftMoneyGiveTypeEnum.FIRST_DEDUCT_DEPOSIT
				|| typeEnum == GiftMoneyGiveTypeEnum.ALL_TRADE) {
				
			} else {
				typeEnums.add(typeEnum);
			}
		}
		return typeEnums;
	}
	
	@ResponseBody
	public Object updateGiftMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		fullCreateOrder(createGiftMoneyOrder, request);
		GiftMoneyQueryOrder giftMoneyQueryOrder = new GiftMoneyQueryOrder();
		giftMoneyQueryOrder.setStartDate(createGiftMoneyOrder.getStartDate());
		giftMoneyQueryOrder.setEndDate(createGiftMoneyOrder.getEndDate());
		giftMoneyQueryOrder.setGiveType(createGiftMoneyOrder.getGiveRuleType());
		giftMoneyQueryOrder.setType(createGiftMoneyOrder.getType());
		giftMoneyQueryOrder.setGiftId(createGiftMoneyOrder.getGiftId());
		boolean exists = giftMoneyQueryService.checkExistsSameGiftMoney(giftMoneyQueryOrder);
		if (exists) {
			json.put("code", 0);
			json.put("message", "新增优惠券失败,同一类型的优惠券，活动时间不能重叠!");
			return json;
		}
		
		createGiftMoneyOrder.setCreateUserid(ShiroSessionUtils.getSessionLocal().getUserId());
		createGiftMoneyOrder.setCreateUsername(ShiroSessionUtils.getSessionLocal().getUserName());
		EsupplierBaseResult result = giftMoneyService.updateGiftMoney(createGiftMoneyOrder);
		
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "更新优惠券成功!");
		} else {
			json.put("code", 0);
			json.put("message", "更新优惠券失败:" + result.getMessage());
			
		}
		return json;
	}
	
	@ResponseBody
	public Object addGiftMoneySubmit(	CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		fullCreateOrder(createGiftMoneyOrder, request);
		GiftMoneyQueryOrder giftMoneyQueryOrder = new GiftMoneyQueryOrder();
		giftMoneyQueryOrder.setStartDate(createGiftMoneyOrder.getStartDate());
		giftMoneyQueryOrder.setType(createGiftMoneyOrder.getType());
		giftMoneyQueryOrder.setEndDate(createGiftMoneyOrder.getEndDate());
		giftMoneyQueryOrder.setGiveType(createGiftMoneyOrder.getGiveRuleType());
		giftMoneyQueryOrder.setGiftId(createGiftMoneyOrder.getGiftId());
		
		boolean exists = giftMoneyQueryService.checkExistsSameGiftMoney(giftMoneyQueryOrder);
		if (exists) {
			json.put("code", 0);
			json.put("message", "新增优惠券失败,同一类型的优惠券，活动时间不能重叠!");
			return json;
		}
		
		createGiftMoneyOrder.setCreateUserid(ShiroSessionUtils.getSessionLocal().getUserId());
		createGiftMoneyOrder.setCreateUsername(ShiroSessionUtils.getSessionLocal().getUserName());
		createGiftMoneyOrder.setOutBizNo(BusinessNumberUtil.gainOutBizNoNumber());
		EsupplierBaseResult result = giftMoneyService.addGiftMoney(createGiftMoneyOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "新增优惠券成功!");
		} else {
			json.put("code", 0);
			json.put("message", "新增优惠券失败:" + result.getMessage());
			
		}
		return json;
	}
	
	@ResponseBody
	public Object checkExistsGiftName(String giftName, long giftId) throws Exception {
		JSONObject json = new JSONObject();
		if (giftMoneyQueryService.checkExistsGiftName(giftId, giftName)) {
			json.put("code", 0);
			json.put("message", "优惠券名称已经使用");
		} else {
			json.put("code", 1);
			json.put("message", "优惠券名称可以使用");
		}
		return json;
	}
	
	@ResponseBody
	public Object changeGiftMoneyRuleStatus(String status, long giftId) throws Exception {
		JSONObject json = new JSONObject();
		ChangeGiftMoneyStatusOrder statusOrder = new ChangeGiftMoneyStatusOrder();
		
		statusOrder.setCreateUserid(ShiroSessionUtils.getSessionLocal().getUserId());
		statusOrder.setCreateUsername(ShiroSessionUtils.getSessionLocal().getUserName());
		statusOrder.setGiftId(giftId);
		statusOrder.setStatus(status);
		EsupplierBaseResult result = giftMoneyService.updateGiftMoneyStatus(statusOrder);
		
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "更新优惠券状态成功!");
		} else {
			json.put("code", 0);
			json.put("message", "更新优惠券状态失败:" + result.getMessage());
		}
		return json;
	}
	
	/**
	 * 分页查询
	 */
	public String pageQueryGiftMoney(	GiftMoneyQueryOrder queryOrder, PageParam pageParam,
										Model model) {
		try {
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			String giftName = null;
			if (StringUtil.isNotEmpty(queryOrder.getGiftName())) {
				giftName = queryOrder.getGiftName();
				queryOrder.setGiftName("%" + queryOrder.getGiftName() + "%");
			}
			
			List<GiftMoneyTypeEnum> typeEnums = new ArrayList<GiftMoneyTypeEnum>();
			typeEnums.add(GiftMoneyTypeEnum.EXPERIENCE_AMOUNT);
			typeEnums.add(GiftMoneyTypeEnum.GIFT_MONEY);
			typeEnums.add(GiftMoneyTypeEnum.VIRTUAL_EXPERIENCE_AMOUNT);
			typeEnums.add(GiftMoneyTypeEnum.GIFT_MONEY_CASH);
			queryOrder.setTypeList(typeEnums);
			QueryBaseBatchResult<GiftMoneyInfo> giftResult = giftMoneyQueryService
				.queryGiftMoneyRule(queryOrder);
			queryOrder.setGiftName(giftName);
			PageTool page = new PageTool();
			page.setCurrentPage((int) queryOrder.getPageNumber());
			page.setPageSize((int) queryOrder.getPageSize());
			page.setTotalRow(giftResult.getTotalCount());
			String pageBar = page.getPageBar();
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("statusList", GiftMoneyStatusEnum.getAllEnum());
			model.addAttribute("status", queryOrder.getStatus());
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(giftResult));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BORROWING_MANAGE__PATH + "pageQueryGiftMoneyInfo.vm";
	}
	
	public String handGiftMoneyAssign(Model model, HttpServletRequest request) {
		model.addAttribute("giveRules", giveTypes());
		model.addAttribute("UserLevelEnumList", UserLevelEnum.getAllEnum());
		return BORROWING_MANAGE__PATH + "handGiftMoney.vm";
	}
	
	@ResponseBody
	public Object handGiftMoneyAssignSubmit(HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		HandGiftMoneyOrder giftMoneyOrder = new HandGiftMoneyOrder();
		WebUtil.setPoPropertyByRequest(giftMoneyOrder, request);
		giftMoneyOrder
			.setGiveType(GiftMoneyGiveTypeEnum.getByCode(request.getParameter("giveType")));
		giftMoneyOrder.setType(GiftMoneyTypeEnum.getByCode(request.getParameter("type")));
		
		String userName = request.getParameter("userName");
		if (StringUtil.isBlank(userName)) {
			json.put("code", 0);
			json.put("message", "用户名不存在");
			return json;
		}
		String[] userNameArray = userName.split(",");
		String notExsitUserName = "";
		String failUserName = "";
		long successCount = 0;
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		ScenicQueryResult scenicQueryResult = scenicService.queryByUserBaseId(userBaseId);
		ScenicInfo scenicInfo = new ScenicInfo();
		if (scenicQueryResult != null && scenicQueryResult.getQueryScenicInfo() != null) {
			scenicInfo = scenicQueryResult.getQueryScenicInfo();
			giftMoneyOrder.setSendAccountCode(scenicInfo.getCode());
			giftMoneyOrder.setSendAccountName(scenicInfo.getShortName());
		} else {
			giftMoneyOrder.setSendAccountName(ShiroSessionUtils.getSessionLocal().getUserName());
		}
		for (String userNameItem : userNameArray) {
			if (StringUtil.isBlank(userNameItem))
				continue;
			UserInfo userInfo = userQueryService.queryByUserName(userNameItem).getQueryUserInfo();
			if (userInfo == null) {
				userInfo = userQueryService.queryByMobile(userNameItem).getQueryUserInfo();
				if (userInfo == null) {
					if (notExsitUserName.length() == 0) {
						notExsitUserName = userNameItem;
					} else {
						notExsitUserName += "," + userNameItem;
					}
					continue;
				}
			}
			giftMoneyOrder.setUserId(userInfo.getUserId());
			
			EsupplierBaseResult result = giftMoneyAssignProcessService
				.backstageHandGiftMoney(giftMoneyOrder);
			if (result.isSuccess()) {
				successCount++;
			} else {
				if (failUserName.length() == 0) {
					failUserName = userNameItem + "(原因:" + result.getMessage() + ")";
				} else {
					failUserName += "," + userNameItem + "(原因:" + result.getMessage() + ")";
				}
				
			}
		}
		if (StringUtil.isNotBlank(notExsitUserName) || StringUtil.isNotBlank(failUserName)) {
			json.put("code", 0);
			String message = "成功发放" + successCount + "条";
			if (StringUtil.isNotBlank(notExsitUserName)) {
				message += ",用户(" + notExsitUserName + ")不存在";
			} else if (StringUtil.isNotBlank(failUserName)) {
				message += "," + failUserName + "发放失败";
			}
			json.put("message", message);
			return json;
		} else {
			json.put("code", 1);
			json.put("message", "手动发放优惠券成功!");
			return json;
		}
		
	}
}
