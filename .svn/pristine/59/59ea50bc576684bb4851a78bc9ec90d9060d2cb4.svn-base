package com.yjf.esupplier.domain.service.repository;

import com.yjf.common.domain.api.Domain;

public interface DomainRepository {
	/** 新增时使用 */
	public <T extends Domain> T load(Object domainId);
	
	/** 新增时使用 */
	public void store(Domain domain);
	
	/** 修改时使用 */
	public void reStore(Domain domain);
	
	/** 逻辑删除时使用 */
	public void remove(Domain domain);
}
