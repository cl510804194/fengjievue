package com.yjf.esupplier.web.controller.backstage.giftMoney;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.common.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyRuleQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTemplateQueryService;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyQueryOrder;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyAssignProcessService;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyService;

@Controller
@RequestMapping("/do/scenic/doCenter")
public class GainMoneyScenicController extends GainMoneyBaseController {

	private  String BORROWING_MANAGE__PATH = "front/gift/";
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
	public String pageQueryGainMoney(HttpServletRequest request,GiftMoneyQueryOrder queryOrder, PageParam pageParam,
										Model model) {
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		if (NumberUtil.parseLong(page) != 0) {
			queryOrder.setPageNumber(Long.parseLong(page));
			pageParam.setPageNo(Integer.parseInt(page));
		}
		if (NumberUtil.parseLong(pageSize) != 0) {
			queryOrder.setPageSize(Long.parseLong(pageSize));
			pageParam.setPageSize(Integer.parseInt(pageSize));
		}
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.pageQueryGainMoney(queryOrder, pageParam,model,request);
	}
	
}
