package com.yjf.esupplier.domain.service.repository;


import com.yjf.esupplier.domain.GiftMoneyTemplateDomain;

public interface GiftMoneyTemplateDomainRepository {

    public GiftMoneyTemplateDomain loadByTemplateId(long templateId);
	

	/** 新增时使用 */
	public void store(GiftMoneyTemplateDomain domain);
	
	/** 修改时使用 */
	public void reStore(GiftMoneyTemplateDomain domain);
	
	/** 逻辑删除时使用 */
	public void remove(GiftMoneyTemplateDomain domain);


    public void changeStatus(long templateId, String status);


}
