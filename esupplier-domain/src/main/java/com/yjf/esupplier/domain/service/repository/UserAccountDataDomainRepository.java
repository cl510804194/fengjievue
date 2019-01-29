package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.UserAccountDataDomain;

public interface UserAccountDataDomainRepository {
	void store(UserAccountDataDomain domain);
	
	void reStore(UserAccountDataDomain domain);
	
	UserAccountDataDomain active(long userId, boolean isLock);
	
}
