package com.yjf.esupplier.web.controller.backstage.giftMoney;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
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
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/admin/giftMoney")
public class GiftMoneyController extends GiftMoneyPreController {

	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "useStartDate", "useEndDate", "startDate", "endDate" };
	}
	
	@Override
	protected String[] getMoneyInputNameArray() {
		return new String[] { "amount", "totalAmount", "balanceAmount", "usedAmount" };
	}
	
	@RequestMapping(value = "addGiftMoney.htm")
	public String addGiftMoney(Model model) {
		return super.addGiftMoney(model);
	}
	
	@RequestMapping(value = "updateGiftMoney.htm")
	public String updateGiftMoney(long giftId, Model model) {
		return super.updateGiftMoney(giftId,model);
	}

	
	@ResponseBody
	@RequestMapping(value = "updateGiftMoneySubmit.htm")
	public Object updateGiftMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		return super.updateGiftMoneySubmit(createGiftMoneyOrder,request);
	}
	
	@ResponseBody
	@RequestMapping(value = "addGiftMoneySubmit.htm")
	public Object addGiftMoneySubmit(CreateGiftMoneyOrder createGiftMoneyOrder,
										HttpServletRequest request) throws Exception {
		return super.addGiftMoneySubmit(createGiftMoneyOrder, request);
	}
	
	@ResponseBody
	@RequestMapping("checkExistsGiftName.json")
	public Object checkExistsGiftName(String giftName, long giftId) throws Exception {
		return super.checkExistsGiftName(giftName, giftId);
	}
	
	@ResponseBody
	@RequestMapping("changeGiftMoneyStatus.htm")
	public Object changeGiftMoneyRuleStatus(String status, long giftId) throws Exception {
		return super.changeGiftMoneyRuleStatus(status, giftId);
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value = "pageQueryGiftMoney.htm")
	public String pageQueryGiftMoney(GiftMoneyQueryOrder queryOrder, PageParam pageParam,
										Model model) {
		return super.pageQueryGiftMoney(queryOrder, pageParam, model);
	}
	
	@RequestMapping(value = "handGiftMoneyAssign.htm")
	public String handGiftMoneyAssign(HttpServletRequest request,Model model) {
		return super.handGiftMoneyAssign(model,request);
	}
	
	@ResponseBody
	@RequestMapping("handGiftMoneyAssignSubmit.htm")
	public Object handGiftMoneyAssignSubmit(HttpServletRequest request) throws Exception {
		return super.handGiftMoneyAssignSubmit(request);
	}
}
