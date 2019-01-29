package com.yjf.esupplier.ws.gifamount.services;

import javax.jws.WebService;

import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyTemplateStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyTemplateOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;


@WebService
public interface GiftMoneyTemplateService {
	
	public EsupplierBaseResult addGiftMoneyTemplate(final CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder);
	
	public EsupplierBaseResult updateGiftMoneyTemplate(final CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder);

    public EsupplierBaseResult ChangeGiftMoneyTemplateStatus(final ChangeGiftMoneyTemplateStatusOrder statusOrder);

}
