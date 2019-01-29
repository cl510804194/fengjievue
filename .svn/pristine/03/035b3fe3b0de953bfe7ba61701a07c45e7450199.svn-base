package com.yjf.esupplier.web.controller.backstage.giftMoney;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;

@Controller
@RequestMapping("/do/scenic/doCenter")
public class GainMoneyTradeScenicController extends GainMoneyTradeBaseController {
	/**
	 * 页面所在路径
	 */
	private  String BORROWING_MANAGE__PATH = "front/gift/";
	
	/**
	 * 领取 分页查询
	 */
	@RequestMapping(value = "pageQueryGainMoneyTrade.htm")
	public String pageQueryGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder, PageParam pageParam,
											Model model,String giftType) {
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.pageQueryGiftMoneyTrade(queryOrder,pageParam,model,giftType);
	}
	
	/**
	 * 使用领取 分页查询
	 */
	@RequestMapping(value = "pageQueryUseGainMoneyTrade.htm")
	public String pageQueryUseGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder,
												PageParam pageParam, Model model,String giftId,String giftType) {
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.pageQueryUseGiftMoneyTrade(queryOrder, pageParam, model, giftId,giftType);
	}
	
}
