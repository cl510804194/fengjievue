package com.yjf.esupplier.web.controller.backstage.giftMoney;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;

public class GiftMoneyBaseController extends BaseAutowiredController {
	public void fullCreateOrder(CreateGiftMoneyOrder createGiftMoneyOrder,
								HttpServletRequest request) {
		createGiftMoneyOrder.setGiveRuleType(GiftMoneyGiveTypeEnum.getByCode(request
			.getParameter("giveRuleType")));
		createGiftMoneyOrder.setType(GiftMoneyTypeEnum.getByCode(request.getParameter("type")));
		createGiftMoneyOrder
			.setStatus(GiftMoneyStatusEnum.getByCode(request.getParameter("status")));
		createGiftMoneyOrder.setGiveType(GiftMoneyGiveTypeEnum.getByCode("giveType"));
		if(request.getParameterValues("giveAmount") == null){
			createGiftMoneyOrder.setGiveAmount(new String[0]);
		}else{
			createGiftMoneyOrder.setGiveAmount(request.getParameterValues("giveAmount"));
		}
	}
}
