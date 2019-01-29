package com.yjf.esupplier.domain.service.repository;


import com.yjf.esupplier.domain.GiftMoneyTradeDomain;

public interface GiftMoneyTradeDomainRepository {


	
	public GiftMoneyTradeDomain loadByGiftTradeId(long giftTradeId);
	
	/** 新增时使用 */
	public void store(GiftMoneyTradeDomain domain);
	
	/** 修改时使用 */
	public void reStore(GiftMoneyTradeDomain domain);
	
	/** 逻辑删除时使用 */
	public void remove(GiftMoneyTradeDomain domain);
}
