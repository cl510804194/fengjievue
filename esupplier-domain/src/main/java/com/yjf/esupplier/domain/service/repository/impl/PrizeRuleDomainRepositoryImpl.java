package com.yjf.esupplier.domain.service.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.yjf.common.domain.api.Domain;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.dal.dataobject.PrizeRuleDO;
import com.yjf.esupplier.dal.dataobject.PrizeRuleDetailDO;
import com.yjf.esupplier.domain.lottery.PrizeRuleDetailDomain;
import com.yjf.esupplier.domain.lottery.PrizeRuleDomain;
import com.yjf.esupplier.domain.lottery.convert.LotteryDomainConvertor;
import com.yjf.esupplier.domain.service.repository.DomainRepository;
import com.yjf.esupplier.domain.service.repository.LotteryDomainRepositoryBase;

@Service("prizeRuleDomainRepository")
public class PrizeRuleDomainRepositoryImpl extends LotteryDomainRepositoryBase implements
																				DomainRepository {
	
	@SuppressWarnings("unchecked")
	@Override
	public <T extends Domain> T load(Object domainId) {
		PrizeRuleDO prizeRuleDO = prizeRuleDAO.findById((long) domainId);
		if (prizeRuleDO != null) {
			PrizeRuleDomain domain = new PrizeRuleDomain();
			BeanCopier.staticCopy(prizeRuleDO, domain);
			List<PrizeRuleDetailDO> prizeRuleDetailDOs = prizeRuleDetailDAO
				.findByPrizeRuleId(domain.getPrizeRuleId());
			List<PrizeRuleDetailDomain> prizeRuleDetailDomains = Lists.newArrayList();
			for (PrizeRuleDetailDO prizeRuleDetailDO : prizeRuleDetailDOs) {
				PrizeRuleDetailDomain prizeRuleDetailDomain = new PrizeRuleDetailDomain();
				LotteryDomainConvertor.convertPrizeRuleDetailDomain(prizeRuleDetailDomain,
					prizeRuleDetailDO);
				prizeRuleDetailDomains.add(prizeRuleDetailDomain);
			}
			domain.setPrizeRuleDetailDomains(prizeRuleDetailDomains);
			return (T) domain;
		}
		return null;
	}
	
	@Override
	public void store(Domain domain) {
		PrizeRuleDomain prizeRuleDomain = (PrizeRuleDomain) domain;
		
		PrizeRuleDO prizeRuleDO = new PrizeRuleDO();
		BeanCopier.staticCopy(prizeRuleDomain, prizeRuleDO);
		prizeRuleDAO.insert(prizeRuleDO);
		if (ListUtil.isNotEmpty(prizeRuleDomain.getPrizeRuleDetailDomains())) {
			for (PrizeRuleDetailDomain prizeRuleDetailDomain : prizeRuleDomain
				.getPrizeRuleDetailDomains()) {
				PrizeRuleDetailDO prizeRuleDetailDO = new PrizeRuleDetailDO();
				LotteryDomainConvertor.convertPrizeRuleDetailDO(prizeRuleDetailDomain,
					prizeRuleDetailDO);
				prizeRuleDetailDO.setPrizeRuleId(prizeRuleDO.getPrizeRuleId());
				prizeRuleDetailDAO.insert(prizeRuleDetailDO);
			}
		}
	}
	
	@Override
	public void reStore(Domain domain) {
		PrizeRuleDomain prizeRuleDomain = (PrizeRuleDomain) domain;
		PrizeRuleDO prizeRuleDO = new PrizeRuleDO();
		BeanCopier.staticCopy(prizeRuleDomain, prizeRuleDO);
		prizeRuleDAO.update(prizeRuleDO);
		prizeRuleDetailDAO.deleteByPrizeRuleId(prizeRuleDomain.getPrizeRuleId());
		if (ListUtil.isNotEmpty(prizeRuleDomain.getPrizeRuleDetailDomains())) {
			for (PrizeRuleDetailDomain prizeRuleDetailDomain : prizeRuleDomain
				.getPrizeRuleDetailDomains()) {
				PrizeRuleDetailDO prizeRuleDetailDO = new PrizeRuleDetailDO();
				LotteryDomainConvertor.convertPrizeRuleDetailDO(prizeRuleDetailDomain,
					prizeRuleDetailDO);
				prizeRuleDetailDomain.setPrizeRuleId(prizeRuleDO.getPrizeRuleId());
				prizeRuleDetailDO.setPrizeRuleId(prizeRuleDO.getPrizeRuleId());
				prizeRuleDetailDAO.insert(prizeRuleDetailDO);
			}
		}
	}
	
	@Override
	public void remove(Domain domain) {
		PrizeRuleDomain prizeRuleDomain = (PrizeRuleDomain) domain;
		prizeRuleDetailDAO.deleteByPrizeRuleId(prizeRuleDomain.getPrizeRuleId());
		prizeRuleDAO.deleteById(prizeRuleDomain.getPrizeRuleId());
	}
	
}
