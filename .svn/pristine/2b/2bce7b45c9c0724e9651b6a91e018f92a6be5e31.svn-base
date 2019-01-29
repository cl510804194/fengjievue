package com.yjf.esupplier.domain.service.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.yjf.common.domain.api.Domain;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.dal.dataobject.LotteryActivityDO;
import com.yjf.esupplier.dal.dataobject.LotteryConditionDO;
import com.yjf.esupplier.domain.lottery.LotteryActivityDomain;
import com.yjf.esupplier.domain.lottery.LotteryConditionDomain;
import com.yjf.esupplier.domain.lottery.convert.LotteryDomainConvertor;
import com.yjf.esupplier.domain.service.repository.LotteryDomainRepositoryBase;
import com.yjf.esupplier.ws.lottery.enums.LotteryTypeEnum;

@Service("lotteryActivityDomainRepository")
public class LotteryActivityDomainRepositoryImpl extends LotteryDomainRepositoryBase
																					implements
																					com.yjf.esupplier.domain.service.repository.LotteryDomainRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Domain> T load(Object domainId) {
		LotteryActivityDO lotteryActivityDO = lotteryActivityDAO.findById((long) domainId);
		if (lotteryActivityDO != null) {
			LotteryActivityDomain domain = new LotteryActivityDomain();
			LotteryDomainConvertor.convertLotteryActivityDomain(domain, lotteryActivityDO);
			List<LotteryConditionDO> conditionDOs = lotteryConditionDAO.findByLotteryId(domain
				.getId());
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
	public LotteryActivityDomain active(Object domainId, boolean isLocked) {
		if (!isLocked) {
			return load(domainId);
		} else {
			
			LotteryActivityDO lotteryActivityDO = lotteryActivityDAO
				.findByIdForUpdate((long) domainId);
			if (lotteryActivityDO != null) {
				LotteryActivityDomain domain = new LotteryActivityDomain();
				LotteryDomainConvertor.convertLotteryActivityDomain(domain, lotteryActivityDO);
				List<LotteryConditionDO> conditionDOs = lotteryConditionDAO
					.findByLotteryId((long) domainId);
				List<LotteryConditionDomain> conditionDomains = Lists.newArrayList();
				for (LotteryConditionDO conditionDO : conditionDOs) {
					LotteryConditionDomain conditionDomain = new LotteryConditionDomain();
					LotteryDomainConvertor.convertLotteryConditionDomain(conditionDomain,
						conditionDO);
					conditionDomains.add(conditionDomain);
				}
				domain.setLotteryConditionDomains(conditionDomains);
				return domain;
			}
			
		}
		return null;
	}
	
	@Override
	public void store(Domain domain) {
		LotteryActivityDomain activityDomain = (LotteryActivityDomain) domain;
		
		LotteryActivityDO lotteryActivityDO = new LotteryActivityDO();
		LotteryDomainConvertor.convertLotteryActivityDO(activityDomain, lotteryActivityDO);
		lotteryActivityDAO.insert(lotteryActivityDO);
		activityDomain.setId(lotteryActivityDO.getId());
		if (ListUtil.isNotEmpty(activityDomain.getLotteryConditionDomains())) {
			for (LotteryConditionDomain conditionDomain : activityDomain
				.getLotteryConditionDomains()) {
				LotteryConditionDO conditionDO = new LotteryConditionDO();
				LotteryDomainConvertor.convertLotteryConditionDO(conditionDomain, conditionDO);
				conditionDO.setLotteryId(lotteryActivityDO.getId());
				lotteryConditionDAO.insert(conditionDO);
			}
		}
	}
	
	@Override
	public void reStore(Domain domain) {
		LotteryActivityDomain activityDomain = (LotteryActivityDomain) domain;
		LotteryActivityDO lotteryActivityDO = new LotteryActivityDO();
		LotteryDomainConvertor.convertLotteryActivityDO(activityDomain, lotteryActivityDO);
		lotteryActivityDAO.update(lotteryActivityDO);
		lotteryConditionDAO.deleteByLotteryId(activityDomain.getId());
		if (activityDomain.getLotteryType() == LotteryTypeEnum.LOTTERY
			&& ListUtil.isNotEmpty(activityDomain.getLotteryConditionDomains())) {
			for (LotteryConditionDomain conditionDomain : activityDomain
				.getLotteryConditionDomains()) {
				LotteryConditionDO conditionDO = new LotteryConditionDO();
				LotteryDomainConvertor.convertLotteryConditionDO(conditionDomain, conditionDO);
				conditionDO.setLotteryId(activityDomain.getId());
				lotteryConditionDAO.insert(conditionDO);
			}
		}
	}
	
	@Override
	public void remove(Domain domain) {
		LotteryActivityDomain activityDomain = (LotteryActivityDomain) domain;
		lotteryConditionDAO.deleteByLotteryId(activityDomain.getId());
		lotteryActivityDAO.deleteById(activityDomain.getId());
	}
	
	@Override
	public void onlyModifyLotteryActiveDomain(LotteryActivityDomain activityDomain) {
		LotteryActivityDO lotteryActivityDO = new LotteryActivityDO();
		LotteryDomainConvertor.convertLotteryActivityDO(activityDomain, lotteryActivityDO);
		lotteryActivityDAO.update(lotteryActivityDO);
	}
}
