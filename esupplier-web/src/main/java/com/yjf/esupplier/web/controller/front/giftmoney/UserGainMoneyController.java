package com.yjf.esupplier.web.controller.front.giftmoney;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * Created by min on 2014/12/2.
 */
@Controller
@RequestMapping("do/userGiftMoney")
public class UserGainMoneyController extends BaseAutowiredController {
	@Autowired
	GiftMoneyTradeQueryService giftMoneyTradeQueryService;
	
	/**
	 * 领取 分页查询
	 */
	@RequestMapping(value = "pageQueryGainMoney.htm")
	public String pageQueryUserGainMoneyInfo(GiftMoneyTradeQueryOrder queryOrder,
												PageParam pageParam, Model model) {
		try {
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.ORIGINAL.getCode());
			queryOrder.setUserid(sessionLocal.getUserId());
			List<String> typeList = new ArrayList<String>();
			typeList.add(GiftMoneyTypeEnum.getByCode(queryOrder.getType()).code());
			queryOrder.setTypeList(typeList);
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(page));
			model.addAttribute("giftMoneyTypeEnum", GiftMoneyTypeEnum.getAllEnum());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if(GiftMoneyTypeEnum.getByCode(queryOrder.getType()) == GiftMoneyTypeEnum.GAIN_AMOUNT){			
			return "/front/giftMoney/pageQueryUserGainMoneyInfo.vm";
		}else{
			return "/front/giftMoney/pageQueryUserRedMoneyInfo.vm";
		}
	}
	
	/**
	 * 领取 分页查询
	 */
	@RequestMapping(value = "pageQueryUseGainMoney.htm")
	public String pageQueryUserUseGainMoneyInfo(GiftMoneyTradeQueryOrder queryOrder,
												PageParam pageParam, Model model) {
		try {
			
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			queryOrder.setTradeType(GiftMoneyTradeTypeEnum.USED.getCode());
			queryOrder.setUserid(sessionLocal.getUserId());
			QueryBaseBatchResult<GiftMoneyTradeInfo> page = giftMoneyTradeQueryService
				.queryGiftMoneyTrade(queryOrder);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(page));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "/front/giftMoney/pageQueryUserUseGainMoneyInfo.vm";
	}
	
}
