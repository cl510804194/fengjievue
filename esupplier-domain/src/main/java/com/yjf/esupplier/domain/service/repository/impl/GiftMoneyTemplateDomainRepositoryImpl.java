package com.yjf.esupplier.domain.service.repository.impl;

import com.yjf.esupplier.dal.daointerface.GiftMoneyTemplateDAO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyTemplateDO;
import com.yjf.esupplier.domain.GiftMoneyTemplateDomain;
import com.yjf.esupplier.domain.service.repository.GiftMoneyTemplateDomainRepository;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;


/**
 * Created by min on 2015/2/26.
 */
@Service("giftMoneyTemplateDomainRepository")
public class GiftMoneyTemplateDomainRepositoryImpl extends DomainRepositoryBase implements GiftMoneyTemplateDomainRepository {

    @Autowired
    GiftMoneyTemplateDAO giftMoneyTemplateDAO;

    @Override
    public GiftMoneyTemplateDomain loadByTemplateId(long templateId) {
        GiftMoneyTemplateDO giftMoneyTemplateDO = giftMoneyTemplateDAO.findById(templateId);
        if(giftMoneyTemplateDO == null){
            return null;
        }
        GiftMoneyTemplateDomain domain = new GiftMoneyTemplateDomain();
        BeanCopier.staticCopy(giftMoneyTemplateDO, domain);
        domain.setStatus(GiftMoneyStatusEnum.getByCode(giftMoneyTemplateDO.getStatus()));
        return domain;
    }

    @Override
    public void store(GiftMoneyTemplateDomain domain) {
        GiftMoneyTemplateDO giftMoneyTemplateDO = new GiftMoneyTemplateDO();
        BeanCopier.staticCopy(domain, giftMoneyTemplateDO);
        giftMoneyTemplateDO.setStatus(domain.getStatus().getCode());
        long templateId = giftMoneyTemplateDAO.insert(giftMoneyTemplateDO);
        domain.setTemplateId(templateId);
    }

    @Override
    public void reStore(GiftMoneyTemplateDomain domain) {
        GiftMoneyTemplateDO giftMoneyTemplateDO = new GiftMoneyTemplateDO();
        BeanCopier.staticCopy(domain, giftMoneyTemplateDO);
        giftMoneyTemplateDO.setStatus(domain.getStatus().getCode());
        giftMoneyTemplateDAO.update(giftMoneyTemplateDO);
    }

    @Override
    public void remove(GiftMoneyTemplateDomain domain) {
        giftMoneyTemplateDAO.deleteById(domain.getTemplateId());
    }

    @Override
    public void changeStatus(long templateId, String status) {
        giftMoneyTemplateDAO.changeStatus(status,templateId);
    }
}
