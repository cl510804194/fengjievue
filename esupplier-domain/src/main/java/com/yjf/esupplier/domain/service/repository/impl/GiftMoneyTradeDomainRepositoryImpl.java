package com.yjf.esupplier.domain.service.repository.impl;

import com.yjf.esupplier.dal.daointerface.GiftMoneyTradeDAO;
import com.yjf.esupplier.dal.dataobject.GiftMoneyTradeDO;
import com.yjf.esupplier.domain.GiftMoneyTradeDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.service.repository.GiftMoneyTradeDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("giftMoneyTradeDomainRepository")
public class GiftMoneyTradeDomainRepositoryImpl extends DomainRepositoryBase implements
		GiftMoneyTradeDomainRepository {
	@Autowired
	GiftMoneyTradeDAO giftMoneyTradeDAO;

	@Override
	public void store(GiftMoneyTradeDomain domain) {
        GiftMoneyTradeDO giftMoneyTradeDO = new GiftMoneyTradeDO();
        DomainConvert.convertGiftMoneyTradeDO(domain, giftMoneyTradeDO);
		long giftTradeMoneyId = giftMoneyTradeDAO.insert(giftMoneyTradeDO);
		domain.setGiftTradeId(giftTradeMoneyId);

	}

	@Override
	public void reStore(GiftMoneyTradeDomain domain) {
        GiftMoneyTradeDO giftMoneyTradeDO = new GiftMoneyTradeDO();
		DomainConvert.convertGiftMoneyTradeDO(domain, giftMoneyTradeDO);
		giftMoneyTradeDAO.update(giftMoneyTradeDO);
	}

	@Override
	public void remove(GiftMoneyTradeDomain domain) {
		giftMoneyTradeDAO.deleteById(domain.getGiftTradeId());
	}

	@Override
	public GiftMoneyTradeDomain loadByGiftTradeId(long giftMoneyId) {
        GiftMoneyTradeDO giftMoneyTradeDO = null;
		giftMoneyTradeDO = giftMoneyTradeDAO.findById(giftMoneyId);
		if (giftMoneyTradeDO == null)
			return null;
        GiftMoneyTradeDomain giftMoneyTradeDomain = new GiftMoneyTradeDomain();
		DomainConvert.convertGiftMoneyTradeDomain(giftMoneyTradeDomain, giftMoneyTradeDO);
		return giftMoneyTradeDomain;
	}


}
