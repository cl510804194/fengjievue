package com.yjf.esupplier.web.controller.backstage.giftMoney;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/admin/giftMoney")
public class GainMoneyController extends GainMoneyBaseController {

	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "useStartDate", "useEndDate", "startDate", "endDate" };
	}
	
	@Override
	protected String[] getMoneyInputNameArray() {
		return new String[] { "amount", "totalAmount", "balanceAmount", "usedAmount" };
	}
	
	@RequestMapping(value = "addGainMoney.htm")
	public String addGainMoney(Model model,String giftType) {
		return super.addGainMoney(model,giftType);
	}
	
	@RequestMapping(value = "updateGainMoney.htm")
	public String updateGainMoney(long giftId, Model model,String giftType) {
		return super.updateGainMoney(giftId,model,giftType);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateGainMoneySubmit.htm")
	public Object updateGainMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		return super.updateGainMoneySubmit(createGiftMoneyOrder,request);
	}
	
	@ResponseBody
	@RequestMapping(value = "addGainMoneySubmit.htm")
	public Object addGainMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		return super.addGainMoneySubmit(createGiftMoneyOrder, request);
	}
	
	@ResponseBody
	@RequestMapping("checkExistsGainName.json")
	public Object checkExistsGainName(String giftName, long giftId) throws Exception {
		return super.checkExistsGainName(giftName, giftId);
	}

	@ResponseBody
	@RequestMapping("changeGainMoneyStatus.htm")
	public Object changeGainMoneyStatus(String status, long giftId) throws Exception {
		return super.changeGainMoneyStatus(status, giftId);
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value = "pageQueryGainMoney.htm")
	public String pageQueryGainMoney(GiftMoneyQueryOrder queryOrder, PageParam pageParam,
										Model model,HttpServletRequest request) {
		return super.pageQueryGainMoney(queryOrder, pageParam,model,request);
	}
	
}
