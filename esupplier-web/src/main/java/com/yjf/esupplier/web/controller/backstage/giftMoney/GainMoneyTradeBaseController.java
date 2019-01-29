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
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
public class GainMoneyTradeBaseController extends BaseAutowiredController {
	/**
	 * 页面所在路径
	 */
	private  String BORROWING_MANAGE__PATH = "/backstage/giftMoney/";
	
	@Autowired
	GiftMoneyTradeQueryService giftMoneyTradeQueryService;

	public String getBORROWING_MANAGE__PATH() {
		return BORROWING_MANAGE__PATH;
	}

	public void setBORROWING_MANAGE__PATH(String BORROWING_MANAGE__PATH) {
		this.BORROWING_MANAGE__PATH = BORROWING_MANAGE__PATH;
	}

	/**
	 * 领取 分页查询
	 */
	public String pageQueryGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder, PageParam pageParam,
											Model model,String giftType) {
		try {
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.ORIGINAL.getCode());
			String username = null;
			if (StringUtil.isNotEmpty(queryOrder.getUsername())) {
				username = queryOrder.getUsername();
				queryOrder.setUsername("%" + queryOrder.getUsername() + "%");
			}
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			queryOrder.setUsername(username);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(GiftMoneyTypeEnum.getByCode(giftType) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return BORROWING_MANAGE__PATH + "pageQueryGainMoneyTradeInfo.vm";
		}else{
			return BORROWING_MANAGE__PATH + "pageQueryGainRedMoneyTradeInfo.vm";
		}
	}
	
	/**
	 * 使用领取 分页查询
	 */
	public String pageQueryUseGiftMoneyTrade(GiftMoneyTradeQueryOrder queryOrder,
												PageParam pageParam, Model model,String giftId,String giftType) {
		try {
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			String username = null;
			if (StringUtil.isNotEmpty(queryOrder.getUsername())) {
				username = queryOrder.getUsername();
				queryOrder.setUsername("%" + queryOrder.getUsername() + "%");
			}
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.USED.getCode());
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			queryOrder.setUsername(username);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(GiftMoneyTypeEnum.getByCode(giftType) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return BORROWING_MANAGE__PATH + "pageQueryUseGainMoneyTradeInfo.vm";
		}else{
			return BORROWING_MANAGE__PATH + "pageQueryUseGainRedMoneyTradeInfo.vm";
		}
	}
	
}
