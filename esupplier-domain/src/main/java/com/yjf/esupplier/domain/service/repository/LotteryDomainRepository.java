package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.lottery.LotteryActivityDomain;

public interface LotteryDomainRepository extends DomainRepository {
	void onlyModifyLotteryActiveDomain(LotteryActivityDomain activityDomain);
	
	LotteryActivityDomain active(Object domainId, boolean isLocked);
}
