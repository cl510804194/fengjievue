package com.yjf.esupplier.web.controller.backstage.giftMoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/admin/giftMoney")
public class GainMoneyTradeController extends GainMoneyTradeBaseController {
	/**
	 * 领取 分页查询
	 */
	@RequestMapping(value = "pageQueryGainMoneyTrade.htm")
	public String pageQueryGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder, PageParam pageParam,
											Model model,String giftType) {
		return super.pageQueryGiftMoneyTrade(queryOrder,pageParam,model,giftType);
	}
	
	/**
	 * 使用领取 分页查询
	 */
	@RequestMapping(value = "pageQueryUseGainMoneyTrade.htm")
	public String pageQueryUseGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder,
												PageParam pageParam, Model model,String giftId,String giftType) {
		return super.pageQueryUseGiftMoneyTrade(queryOrder,pageParam,model,giftId,giftType);
	}
	
}
