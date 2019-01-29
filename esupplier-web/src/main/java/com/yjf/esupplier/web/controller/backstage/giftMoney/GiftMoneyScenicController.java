package com.yjf.esupplier.web.controller.backstage.giftMoney;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyQueryOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

@Controller
@RequestMapping("/do/scenic/doCenter")
public class GiftMoneyScenicController extends GiftMoneyPreController {
	private  String BORROWING_MANAGE__PATH = "front/gift/";
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
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.addGiftMoney(model);
	}
	
	@RequestMapping(value = "updateGiftMoney.htm")
	public String updateGiftMoney(long giftId, Model model) {
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
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
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.pageQueryGiftMoney(queryOrder, pageParam, model);
	}
	
	@RequestMapping(value = "handGiftMoneyAssign.htm")
	public String handGiftMoneyAssign(HttpServletRequest request,Model model) {
		model.addAttribute("giveRules", giveTypes());
		model.addAttribute("UserLevelEnumList",UserLevelEnum.getAllEnum());
		return BORROWING_MANAGE__PATH + "handGiftMoney.vm";
	}
	
	@ResponseBody
	@RequestMapping("handGiftMoneyAssignSubmit.htm")
	public Object handGiftMoneyAssignSubmit(HttpServletRequest request) throws Exception {
		return super.handGiftMoneyAssignSubmit(request);
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
	
	@RequestMapping(value = "handGiftMoneyHistory.htm")
	public String handGiftMoneyHistory(HttpServletRequest request,Model model) {
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		String type = request.getParameter("giftType");
		GiftMoneyTradeQueryOrder giftMoneyTradeQueryOrder = new GiftMoneyTradeQueryOrder();
		WebUtil.setPoPropertyByRequest(giftMoneyTradeQueryOrder, request);
		PageTool page = new PageTool();
		page.setCurrentPage(pages);
		page.setPageSize(pagesize);
		giftMoneyTradeQueryOrder.setType(type);
		giftMoneyTradeQueryOrder.setPageSize(pagesize);
		giftMoneyTradeQueryOrder.setPageNumber(pages);
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		ScenicQueryResult queryResult = scenicService.queryByUserBaseId(userBaseId);
		QueryBaseBatchResult<GiftMoneyTradeInfo> queryList = null;
		if(queryResult != null){
			ScenicInfo scenicInfo = queryResult.getQueryScenicInfo();
			if(scenicInfo!=null) {
				giftMoneyTradeQueryOrder.setSendAccountCode(scenicInfo.getCode());
			}
			queryList = giftMoneyTradeQueryService.queryGiftMoneyTradeHistory(giftMoneyTradeQueryOrder);
		}
		page.setTotalRow(queryList.getTotalCount());
		String pageBar = page.getPageBar();
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("page", PageUtil.getCovertPage(queryList));
		if(GiftMoneyTypeEnum.getByCode(type) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return BORROWING_MANAGE__PATH + "handGiftMoneyHistory.vm";
		}else{
			return BORROWING_MANAGE__PATH + "handGiftRedMoneyHistory.vm";
		}
	}
}
