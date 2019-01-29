package com.yjf.esupplier.domain.service.repository.impl;

import com.yjf.esupplier.dal.daointerface.GiftMoneyDAO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyDO;
import com.yjf.esupplier.domain.GiftMoneyDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.service.repository.GiftMoneyDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("giftMoneyDomainRepository")
public class GiftMoneyDomainRepositoryImpl extends DomainRepositoryBase implements
		GiftMoneyDomainRepository {
	@Autowired
	GiftMoneyDAO giftMoneyDAO;

	@Override
	public GiftMoneyDomain active(long giftMoneyId, boolean isLock) {
		GiftMoneyDO giftMoneyDO = null;
		if (isLock)
            giftMoneyDO = giftMoneyDAO.findByIdForUpdate(giftMoneyId);
		else
            giftMoneyDO = giftMoneyDAO.findById(giftMoneyId);
        GiftMoneyDomain giftMoneyDomain = new GiftMoneyDomain();
		if (giftMoneyDO != null) {
			DomainConvert.convertGiftMoneyDomain(giftMoneyDomain, giftMoneyDO);
		}
		return giftMoneyDomain;
	}

	@Override
	public void store(GiftMoneyDomain domain) {
        GiftMoneyDO giftMoneyDO = new GiftMoneyDO();
        DomainConvert.convertGiftMoneyDO(domain, giftMoneyDO);
		long giftMoneyId = giftMoneyDAO.insert(giftMoneyDO);
		domain.setGiftId(giftMoneyId);

	}

	@Override
	public void reStore(GiftMoneyDomain domain) {
        GiftMoneyDO giftMoneyDO = new GiftMoneyDO();
		DomainConvert.convertGiftMoneyDO(domain, giftMoneyDO);
		giftMoneyDAO.update(giftMoneyDO);
	}

	@Override
	public void remove(GiftMoneyDomain domain) {
		giftMoneyDAO.deleteById(domain.getGiftId());
	}

	@Override
	public GiftMoneyDomain loadByGiftMoneyId(long giftMoneyId) {
        GiftMoneyDO giftMoneyDO = null;
		giftMoneyDO = giftMoneyDAO.findById(giftMoneyId);
		if (giftMoneyDO == null)
			return null;
        GiftMoneyDomain giftMoneyDomain = new GiftMoneyDomain();
		DomainConvert.convertGiftMoneyDomain(giftMoneyDomain, giftMoneyDO);
		return giftMoneyDomain;
	}


}
