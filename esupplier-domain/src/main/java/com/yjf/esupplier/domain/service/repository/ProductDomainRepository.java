package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.ProductDomain;

public interface ProductDomainRepository {
	void store(ProductDomain domain);
	
	void reStore(ProductDomain domain);
	
	ProductDomain active(long productId, boolean isLock);
	
	void remove(ProductDomain domain);
	
}
