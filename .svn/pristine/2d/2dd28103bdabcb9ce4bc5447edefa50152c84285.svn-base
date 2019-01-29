package com.yjf.esupplier.domain.service.repository;


import com.yjf.esupplier.domain.GiftMoneyTemplateRuleDomain;

import java.util.List;

public interface GiftMoneyTemplateRuleDomainRepository {

    public List<GiftMoneyTemplateRuleDomain> loadByTemplateId(long templateId);
	

	/** 新增时使用 */
	public void store(GiftMoneyTemplateRuleDomain domain);
	
	/** 修改时使用 */
	public void reStore(GiftMoneyTemplateRuleDomain domain);
	
	/** 逻辑删除时使用 */
	public void removeByTemplateId(long templateId);
}
