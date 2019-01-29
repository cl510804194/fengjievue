package com.yjf.esupplier.ws.gifamount.services;

import com.yjf.esupplier.ws.gifamount.order.GiftMoneyAssignOrder;
import com.yjf.esupplier.ws.gifamount.order.GiftMoneyCancelAssignOrder;
import com.yjf.esupplier.ws.gifamount.order.GiftMoneyCancelPersonalOrder;
import com.yjf.esupplier.ws.gifamount.order.HandGiftMoneyOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.gifamount.result.GiftMoneyAssignResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * Created by min on 2014/11/21.
 */
public interface GiftMoneyAssignProcessService {
	/**
	 * 领优惠券
	 * @param giftMoneyAssignOrder
	 * @return
	 */
	public GiftMoneyAssignResult giftMoneyAssign(GiftMoneyAssignOrder giftMoneyAssignOrder);
	
	public EsupplierBaseResult giftMoneyAmountAssign(final GiftMoneyAssignOrder giftMoneyAssignOrder);
	
	public EsupplierBaseResult handGiftMoney(final HandGiftMoneyOrder handGiftMoneyOrder);
	
	/**
	 * 后台手动发优惠券
	 * @param handGiftMoneyOrder
	 * @return
	 */
	public EsupplierBaseResult backstageHandGiftMoney(final HandGiftMoneyOrder handGiftMoneyOrder);
	
	public EsupplierBaseResult checkHandGiftMoney(HandGiftMoneyOrder handGiftMoneyOrder);
	
	public EsupplierBaseResult giftMoneyCancelAssign(	GiftMoneyCancelAssignOrder giftMoneyUnAssignOrder);
	
	/**
	 * 取消某人虚拟体验金
	 * @param cancelPersonalOrder
	 * @return
	 */
	public EsupplierBaseResult giftMoneyCancelPersonalAssign(	GiftMoneyCancelPersonalOrder cancelPersonalOrder);
	
}
