package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.lottery.LotteryActivityInstanceDomain;

public interface LotteryInstanceDomainRepository extends DomainRepository {
	
	LotteryActivityInstanceDomain active(Object domainId, boolean isLocked);
	
	void removeByActiveId(long activeId);
}
