package com.yjf.esupplier.ws.gifamount.services;

import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.order.ElectricityGiftMoneyUseOrder;
import com.yjf.esupplier.ws.gifamount.order.GainMoneyUseOrder;
import com.yjf.esupplier.ws.gifamount.order.GiftMoneyUnUseOrder;
import com.yjf.esupplier.ws.gifamount.order.GiftMoneyUseOrder;
import com.yjf.esupplier.ws.gifamount.order.UseGainMoneyOrder;
import com.yjf.esupplier.ws.gifamount.result.UseGainMoneyResult;

import java.util.Date;
import java.util.List;

/**
 * Created by min on 2014/12/10.
 */
public interface GiftMoneyUseProcessService {
	/**
	 * 购买商品使用
	 * @param electricityGiftMoneyUseOrder
	 */
	public void buyProductUseGiftMoney(ElectricityGiftMoneyUseOrder electricityGiftMoneyUseOrder);
	
	/**
	 * 投资使用优惠券
	 * @param giftMoneyUseOrder
	 */
	public void investUseGiftMoney(GiftMoneyUseOrder giftMoneyUseOrder);
	
	public void investUnUseGiftMoney(GiftMoneyUnUseOrder GiftMoneyUnUseOrder);

	/*
	* 新增优惠券
	* */
	public void createGiftMoneyTrades(List<GiftMoneyTradeInfo> giftMoneyTrades, Date currentDate);
 	/**
	 * 使用优惠券
	 * @param giftMoneyUseOrder
	 */
	public UseGainMoneyResult investUseGainMoney(GainMoneyUseOrder giftMoneyUseOrder);
	
	public void saveGainMoney(UseGainMoneyOrder gainMoneyOrder);
	
	/**
	 * 流标，未使用优惠券
	 * @param giftMoneyUnUseOrder
	 */
	public void investUnUseGainMoney(GiftMoneyUnUseOrder giftMoneyUnUseOrder);
	
	public void preLoadValidateGiftMoney(GiftMoneyUseOrder giftMoneyUseOrder);
}
