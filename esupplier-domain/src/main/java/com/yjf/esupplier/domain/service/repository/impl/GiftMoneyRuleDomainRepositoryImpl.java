package com.yjf.esupplier.domain.service.repository.impl;

import java.util.List;

import com.yjf.esupplier.dal.daointerface.GiftMoneyRuleDAO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyRuleDO;
import com.yjf.esupplier.domain.GiftMoneyRuleDomain;
import com.yjf.esupplier.domain.service.repository.GiftMoneyRuleDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;

@Service("giftMoneyRuleDomainRepository")
public class GiftMoneyRuleDomainRepositoryImpl extends DomainRepositoryBase implements
        GiftMoneyRuleDomainRepository {

    @Autowired
    GiftMoneyRuleDAO giftMoneyRuleDAO;

	@Override
	public void store(List<GiftMoneyRuleDomain> domains) {
        if(ListUtil.isNotEmpty(domains)){
            for(GiftMoneyRuleDomain domain : domains){
                GiftMoneyRuleDO giftMoneyRuleDO = new GiftMoneyRuleDO();
                BeanCopier.staticCopy(domain, giftMoneyRuleDO);
                long giftMoneyRuleId = giftMoneyRuleDAO.insert(giftMoneyRuleDO);
                domain.setGiftRuleId(giftMoneyRuleId);
            }
        }


	}


	@Override
	public void remove(GiftMoneyRuleDomain domain) {
        giftMoneyRuleDAO.deleteById(domain.getGiftRuleId());
	}

    @Override
    public void removeByGiftId(long giftId) {
        giftMoneyRuleDAO.deleteByGiftId(giftId);
    }


}
