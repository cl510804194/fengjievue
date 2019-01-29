package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.ContractDomain;

public interface ContractDomainRepository extends DomainRepository {
	
	public ContractDomain active(String contractId, boolean isLock);
	
	/**
	 * 激活或锁主领域
	 * @param contractId
	 * @param isLock
	 * @return
	 */
	ContractDomain activeMainDomain(String contractId, boolean isLock);
	
	/**
	 * 更新主领域
	 * @param contractDomain
	 * @return
	 */
	ContractDomain updateMainDomain(ContractDomain contractDomain);
}
