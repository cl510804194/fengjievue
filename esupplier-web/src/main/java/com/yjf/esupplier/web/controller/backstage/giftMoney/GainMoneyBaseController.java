package com.yjf.esupplier.web.controller.backstage.giftMoney;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.common.util.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyRuleQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTemplateQueryService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyUseTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyInfo;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyRuleInfo;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTemplateInfo;
import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyQueryOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTemplateQueryOrder;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyAssignProcessService;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyService;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
public class GainMoneyBaseController extends GiftMoneyBaseController {
	/**
	 * 页面所在路径
	 */
	private  String BORROWING_MANAGE__PATH = "/backstage/giftMoney/";
	
	@Autowired
	GiftMoneyQueryService giftMoneyQueryService;
	
	@Autowired
	GiftMoneyService giftMoneyService;
	
	@Autowired
	GiftMoneyRuleQueryService giftMoneyRuleQueryService;
	
	@Autowired
	GiftMoneyAssignProcessService giftMoneyAssignProcessService;
	@Autowired
	GiftMoneyTemplateQueryService giftMoneyTemplateQueryService;

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
	
	public String addGainMoney(Model model,String giftType) {
		List<GiftMoneyTypeEnum> types = GiftMoneyTypeEnum.getAllEnum();
		model.addAttribute("types", types);
		List<GiftMoneyGiveTypeEnum> giveTypes = GiftMoneyGiveTypeEnum.getAllEnum();
		model.addAttribute("giveTypes", giveTypes);
		List<GiftMoneyUseTypeEnum> useTypes = GiftMoneyUseTypeEnum.getAllEnum();
		model.addAttribute("useTypes", useTypes);
		GiftMoneyTemplateQueryOrder giftMoneyTemplateQueryOrder = new GiftMoneyTemplateQueryOrder();
		giftMoneyTemplateQueryOrder.setStatus("NORMAL");
		List<GiftMoneyTemplateInfo> useGainMoneyRules = giftMoneyTemplateQueryService
			.queryGiftMoneyTemplate(giftMoneyTemplateQueryOrder).getPageList();
		model.addAttribute("useGainMoneyRules", useGainMoneyRules);
		if(GiftMoneyTypeEnum.getByCode(giftType) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return BORROWING_MANAGE__PATH + "addGainAmount.vm";
		}else{
			return BORROWING_MANAGE__PATH + "addGainRedAmount.vm";
		}

	}
	
	public String updateGainMoney(long giftId, Model model,String giftType) {
		GiftMoneyInfo info = giftMoneyQueryService.findById(giftId);
		model.addAttribute("info", info);
		List<GiftMoneyTypeEnum> types = GiftMoneyTypeEnum.getAllEnum();
		model.addAttribute("types", types);
		List<GiftMoneyGiveTypeEnum> giveTypes = GiftMoneyGiveTypeEnum.getAllEnum();
		model.addAttribute("giveTypes", giveTypes);
		
		List<GiftMoneyRuleInfo> rules = giftMoneyRuleQueryService
			.queryGiftMoneyRuleByGiftId(giftId);
		model.addAttribute("rules", rules);
		GiftMoneyTemplateQueryOrder giftMoneyTemplateQueryOrder = new GiftMoneyTemplateQueryOrder();
		giftMoneyTemplateQueryOrder.setStatus("NORMAL");
		List<GiftMoneyTemplateInfo> useGainMoneyRules = giftMoneyTemplateQueryService
			.queryGiftMoneyTemplate(giftMoneyTemplateQueryOrder).getPageList();
		model.addAttribute("useTypes", useGainMoneyRules);
		if(GiftMoneyTypeEnum.getByCode(giftType) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return BORROWING_MANAGE__PATH + "updateGainAmount.vm";
		}else{
			return BORROWING_MANAGE__PATH + "updateGainRedAmount.vm";
		}

	}
	
	@ResponseBody
	public Object updateGainMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		
		if (StringUtil.isBlank(AppConstantsUtil.getPlatformRepayUserName())) {
			json.put("code", 0);
			json.put("message", "优惠券还款，必须设置还款账户!");
			return json;
		}
		fullCreateOrder(createGiftMoneyOrder, request);
		GiftMoneyQueryOrder giftMoneyQueryOrder = new GiftMoneyQueryOrder();
		giftMoneyQueryOrder.setStartDate(createGiftMoneyOrder.getStartDate());
		giftMoneyQueryOrder.setEndDate(createGiftMoneyOrder.getEndDate());
		giftMoneyQueryOrder.setGiveType(createGiftMoneyOrder.getGiveRuleType());
		giftMoneyQueryOrder.setType(GiftMoneyTypeEnum.GAIN_AMOUNT);
		giftMoneyQueryOrder.setGiftId(createGiftMoneyOrder.getGiftId());
		boolean exists = giftMoneyQueryService.checkExistsSameGiftMoney(giftMoneyQueryOrder);
		if (exists) {
			json.put("code", 0);
			json.put("message", "新增优惠券失败,同一类型的优惠券，活动时间不能重叠!");
			return json;
		}
		
		createGiftMoneyOrder.setCreateUserid(ShiroSessionUtils.getSessionLocal().getUserId());
		createGiftMoneyOrder.setCreateUsername(ShiroSessionUtils.getSessionLocal().getUserName());
		createGiftMoneyOrder.setType(GiftMoneyTypeEnum.GAIN_AMOUNT);
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
	public Object addGainMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		fullCreateOrder(createGiftMoneyOrder, request);
		
		GiftMoneyQueryOrder giftMoneyQueryOrder = new GiftMoneyQueryOrder();
		giftMoneyQueryOrder.setStartDate(createGiftMoneyOrder.getStartDate());
		giftMoneyQueryOrder.setType(GiftMoneyTypeEnum.getByCode(request.getParameter("type")));
		giftMoneyQueryOrder.setEndDate(createGiftMoneyOrder.getEndDate());
		giftMoneyQueryOrder.setGiveType(createGiftMoneyOrder.getGiveRuleType());
		giftMoneyQueryOrder.setGiftId(createGiftMoneyOrder.getGiftId());
		String message = giftMoneyQueryOrder.getType().getMessage();
		boolean exists = giftMoneyQueryService.checkExistsSameGiftMoney(giftMoneyQueryOrder);
		if (exists) {
			json.put("code", 0);
			json.put("message", "新增"+message+"失败,同一类型的"+message+"，活动时间不能重叠!");
			return json;
		}
		
		createGiftMoneyOrder.setCreateUserid(ShiroSessionUtils.getSessionLocal().getUserId());
		createGiftMoneyOrder.setCreateUsername(ShiroSessionUtils.getSessionLocal().getUserName());
		createGiftMoneyOrder.setOutBizNo(BusinessNumberUtil.gainOutBizNoNumber());
		createGiftMoneyOrder.setType(GiftMoneyTypeEnum.getByCode(request.getParameter("type")));
		if(GiftMoneyTypeEnum.getByCode(request.getParameter("type")) == GiftMoneyTypeEnum.GAIN_AMOUNT){
			createGiftMoneyOrder.setUseType(request.getParameter("useGainMoneyRule"));
		}else{
			createGiftMoneyOrder.setUseType("");
		}
		EsupplierBaseResult result = giftMoneyService.addGiftMoney(createGiftMoneyOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "新增"+message+"成功!");
		} else {
			json.put("code", 0);
			json.put("message", "新增"+message+"失败:" + result.getMessage());
			
		}
		return json;
	}
	
	@ResponseBody
	public Object checkExistsGainName(String giftName, long giftId) throws Exception {
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
	public Object changeGainMoneyStatus(String status, long giftId) throws Exception {
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
	public String pageQueryGainMoney(GiftMoneyQueryOrder queryOrder, PageParam pageParam,
										Model model,HttpServletRequest request) {
		String type = "";
		try {
			type = request.getParameter("giftType");
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			queryOrder.setType(GiftMoneyTypeEnum.getByCode(type));
			String giftName = null;
			if (StringUtil.isNotEmpty(queryOrder.getGiftName())) {
				giftName = queryOrder.getGiftName();
				queryOrder.setGiftName("%" + queryOrder.getGiftName() + "%");
			}
			QueryBaseBatchResult<GiftMoneyInfo> giftResult = giftMoneyQueryService
				.queryGiftMoneyRule(queryOrder);
			queryOrder.setGiftName(giftName);
			PageTool page = new PageTool();
			page.setCurrentPage((int)queryOrder.getPageNumber());
			page.setPageSize((int)queryOrder.getPageSize());
			page.setTotalRow(giftResult.getTotalCount());
			String pageBar = page.getPageBar();
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(giftResult));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(GiftMoneyTypeEnum.getByCode(type) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return BORROWING_MANAGE__PATH + "pageQueryGainMoneyInfo.vm";
		}else{
			return BORROWING_MANAGE__PATH + "pageQueryGainRedMoneyInfo.vm";
		}
	}
	
}
