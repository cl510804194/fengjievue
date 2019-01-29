package com.yjf.esupplier.domain.service.repository.impl;


import java.util.ArrayList;
import java.util.List;

import com.yjf.esupplier.dal.daointerface.GiftMoneyTemplateRuleDAO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyTemplateRuleDO;
import com.yjf.esupplier.domain.GiftMoneyTemplateRuleDomain;
import com.yjf.esupplier.domain.service.repository.GiftMoneyTemplateRuleDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;


/**
 * Created by min on 2015/2/26.
 */
@Service("giftMoneyTemplateRuleDomainRepository")
public class GiftMoneyTemplateRuleDomainRepositoryImpl extends DomainRepositoryBase implements GiftMoneyTemplateRuleDomainRepository {
    @Autowired
    GiftMoneyTemplateRuleDAO giftMoneyTemplateRuleDAO;

    @Override
    public List<GiftMoneyTemplateRuleDomain> loadByTemplateId(long templateId) {
        List<GiftMoneyTemplateRuleDO> ruleDOs = giftMoneyTemplateRuleDAO.findByTemplateId(templateId);
        if(ListUtil.isNotEmpty(ruleDOs)){
            List<GiftMoneyTemplateRuleDomain> list = new ArrayList<GiftMoneyTemplateRuleDomain>();
            for(GiftMoneyTemplateRuleDO ruleDO : ruleDOs){
                GiftMoneyTemplateRuleDomain domain = new GiftMoneyTemplateRuleDomain();
                BeanCopier.staticCopy(ruleDO, domain);
                list.add(domain);
            }
            return list;
        }
        return null;
    }

    @Override
    public void store(GiftMoneyTemplateRuleDomain domain) {
        GiftMoneyTemplateRuleDO ruleDO = new GiftMoneyTemplateRuleDO();
        BeanCopier.staticCopy(domain, ruleDO);
        giftMoneyTemplateRuleDAO.insert(ruleDO);
    }

    @Override
    public void reStore(GiftMoneyTemplateRuleDomain domain) {
        GiftMoneyTemplateRuleDO ruleDO = new GiftMoneyTemplateRuleDO();
        BeanCopier.staticCopy(domain, ruleDO);
        giftMoneyTemplateRuleDAO.insert(ruleDO);
    }


    @Override
    public void removeByTemplateId(long templateId) {
        giftMoneyTemplateRuleDAO.deleteById(templateId);
    }
}
