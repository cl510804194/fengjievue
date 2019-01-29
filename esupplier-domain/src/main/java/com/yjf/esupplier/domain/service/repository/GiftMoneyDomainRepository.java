package com.yjf.esupplier.domain.service.repository;


import com.yjf.esupplier.domain.GiftMoneyDomain;

public interface GiftMoneyDomainRepository {
	/** 激活领域模型 */
	public GiftMoneyDomain active(long giftId, boolean isLock);
	
	public GiftMoneyDomain loadByGiftMoneyId(long giftMoneyId);
	
	/** 新增时使用 */
	public void store(GiftMoneyDomain domain);
	
	/** 修改时使用 */
	public void reStore(GiftMoneyDomain domain);
	
	/** 逻辑删除时使用 */
	public void remove(GiftMoneyDomain domain);


}
