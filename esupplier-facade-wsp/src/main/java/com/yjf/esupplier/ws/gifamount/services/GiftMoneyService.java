package com.yjf.esupplier.ws.gifamount.services;

import javax.jws.WebService;

import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@WebService
public interface GiftMoneyService {
	
	public EsupplierBaseResult addGiftMoney(CreateGiftMoneyOrder createGiftMoneyOrder);
	
	public EsupplierBaseResult updateGiftMoney(CreateGiftMoneyOrder createGiftMoneyOrder);
	
	public EsupplierBaseResult updateGiftMoneyStatus(ChangeGiftMoneyStatusOrder statusOrder);
	
	public void checkGiftMoneyExpire();
	
	/**
	 * 即将过期的优惠券
	 */
	public void checkGiftMoneyWillExpire();
	
	public void expireGiftMoneyNotify();
	
}
