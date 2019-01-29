package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.ProductTypeDomain;

public interface ProductTypeDomainRepository {
	void store(ProductTypeDomain domain);
	
	void reStore(ProductTypeDomain domain);

	ProductTypeDomain active(String productTypeCode, boolean isLock);

}
