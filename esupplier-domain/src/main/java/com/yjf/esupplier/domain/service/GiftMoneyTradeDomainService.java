package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.domain.GiftMoneyTradeDomain;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface GiftMoneyTradeDomainService {
	
	public EsupplierBaseResult createDomain(GiftMoneyTradeDomain giftMoneyTradeDomain);
	
	public EsupplierBaseResult updateDomain(GiftMoneyTradeInfo giftMoneyTradeInfo);
	
}
