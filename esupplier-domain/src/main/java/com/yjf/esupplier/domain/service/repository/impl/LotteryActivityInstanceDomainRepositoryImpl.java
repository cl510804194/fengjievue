package com.yjf.esupplier.domain.service.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.dal.dataobject.LotteryActivityInstanceDO;
import com.yjf.esupplier.dal.dataobject.LotteryConditionDO;
import com.yjf.esupplier.domain.lottery.LotteryActivityInstanceDomain;
import com.yjf.esupplier.domain.lottery.LotteryConditionDomain;
import com.yjf.esupplier.domain.lottery.convert.LotteryDomainConvertor;

@Service("lotteryActivityInstanceDomainRepository")
public class LotteryActivityInstanceDomainRepositoryImpl
														extends
														com.yjf.esupplier.domain.service.repository.LotteryDomainRepositoryBase
																																implements
																																com.yjf.esupplier.domain.service.repository.LotteryInstanceDomainRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Domain> T load(Object domainId) {
		LotteryActivityInstanceDO lotteryActivityDO = lotteryActivityInstanceDAO
			.findById((long) domainId);
		if (lotteryActivityDO != null) {
			LotteryActivityInstanceDomain domain = new LotteryActivityInstanceDomain();
			LotteryDomainConvertor.convertLotteryActivityInstanceDomain(domain, lotteryActivityDO);
			List<LotteryConditionDO> conditionDOs = lotteryConditionDAO.findByLotteryId(domain
				.getActivityId());
			List<LotteryConditionDomain> conditionDomains = Lists.newArrayList();
			for (LotteryConditionDO conditionDO : conditionDOs) {
				LotteryConditionDomain conditionDomain = new LotteryConditionDomain();
				LotteryDomainConvertor.convertLotteryConditionDomain(conditionDomain, conditionDO);
				conditionDomains.add(conditionDomain);
			}
			domain.setLotteryConditionDomains(conditionDomains);
			return (T) domain;
		}
		return null;
	}
	
	@Override
	public void store(Domain domain) {
		LotteryActivityInstanceDomain activityDomain = (LotteryActivityInstanceDomain) domain;
		
		LotteryActivityInstanceDO lotteryActivityDO = new LotteryActivityInstanceDO();
		LotteryDomainConvertor.convertLotteryActivityInstanceDO(activityDomain, lotteryActivityDO);
		lotteryActivityInstanceDAO.insert(lotteryActivityDO);
		activityDomain.setInstanceId(lotteryActivityDO.getInstanceId());
		
	}
	
	@Override
	public void reStore(Domain domain) {
		LotteryActivityInstanceDomain activityDomain = (LotteryActivityInstanceDomain) domain;
		LotteryActivityInstanceDO lotteryActivityDO = new LotteryActivityInstanceDO();
		LotteryDomainConvertor.convertLotteryActivityInstanceDO(activityDomain, lotteryActivityDO);
		lotteryActivityInstanceDAO.update(lotteryActivityDO);
		
	}
	
	@Override
	public void remove(Domain domain) {
		LotteryActivityInstanceDomain activityDomain = (LotteryActivityInstanceDomain) domain;
		lotteryActivityInstanceDAO.deleteById(activityDomain.getInstanceId());
	}
	
	@Override
	public LotteryActivityInstanceDomain active(Object domainId, boolean isLocked) {
		if (!isLocked) {
			return load(domainId);
		} else {
			List<LotteryConditionDO> conditionDOs = lotteryConditionDAO
				.findByLotteryId((long) domainId);
			List<LotteryConditionDomain> conditionDomains = Lists.newArrayList();
			for (LotteryConditionDO conditionDO : conditionDOs) {
				LotteryConditionDomain conditionDomain = new LotteryConditionDomain();
				LotteryDomainConvertor.convertLotteryConditionDomain(conditionDomain, conditionDO);
				conditionDomains.add(conditionDomain);
			}
			LotteryActivityInstanceDO lotteryActivityDO = lotteryActivityInstanceDAO
				.findByIdForUpdate((long) domainId);
			if (lotteryActivityDO != null) {
				LotteryActivityInstanceDomain domain = new LotteryActivityInstanceDomain();
				LotteryDomainConvertor.convertLotteryActivityInstanceDomain(domain,
					lotteryActivityDO);
				domain.setLotteryConditionDomains(conditionDomains);
				return domain;
			}
		}
		return null;
	}
	
	@Override
	public void removeByActiveId(long activeId) {
		LotteryActivityInstanceDO instanceDO = lotteryActivityInstanceDAO
			.findByActivityId(activeId);
		if (instanceDO != null) {
			lotteryActivityInstanceDAO.deleteById(instanceDO.getInstanceId());
		}
	}
}
