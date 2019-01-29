package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.GiftMoneyRuleDomain;

import java.util.List;



public interface GiftMoneyRuleDomainRepository {


	/** 新增时使用 */
	public void store(List<GiftMoneyRuleDomain> domains);


	
	/** 逻辑删除时使用 */
	public void remove(GiftMoneyRuleDomain domain);

    public void removeByGiftId(long giftId);
}
