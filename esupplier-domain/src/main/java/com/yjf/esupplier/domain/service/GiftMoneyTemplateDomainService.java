package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyTemplateStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyTemplateOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface GiftMoneyTemplateDomainService {
	
	public EsupplierBaseResult createDomain(CreateGiftMoneyTemplateOrder domainOrder);
	
	public EsupplierBaseResult updateDomain(CreateGiftMoneyTemplateOrder domainOrder);
	
	public EsupplierBaseResult updateDomainStatus(ChangeGiftMoneyTemplateStatusOrder domainOrder);
}
