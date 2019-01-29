package com.yjf.esupplier.domain.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.domain.GiftMoneyTemplateDomain;
import com.yjf.esupplier.domain.context.EsupplierDomainHolder;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.GiftMoneyTemplateDomainService;
import com.yjf.esupplier.domain.service.repository.GiftMoneyTemplateDomainRepository;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyTemplateStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyTemplateOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@Service("giftMoneyTemplateDomainService")
public class GiftMoneyTemplateDomainServiceImpl extends DomainServiceBase implements
																			GiftMoneyTemplateDomainService {
	@Autowired
	GiftMoneyTemplateDomainRepository giftMoneyTemplateDomainRepository;
	
	@Override
	public EsupplierBaseResult createDomain(CreateGiftMoneyTemplateOrder domainOrder) {
		logger.info("创建领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		Date sysDate = EsupplierDomainHolder.get().getSysDate();
		GiftMoneyTemplateDomain demandDomain = new GiftMoneyTemplateDomain();
		try {
			domainOrder.check();
			MiscUtil.copyPoObject(demandDomain, domainOrder);
			demandDomain.setRawAddTime(sysDate);
			demandDomain.setRawUpdateTime(sysDate);
			EsupplierDomainHolder.get().setDomain(demandDomain);
			demandDomain.setStatus(GiftMoneyStatusEnum.NORMAL);
			giftMoneyTemplateDomainRepository.store(demandDomain);
			domainOrder.setTemplateId(demandDomain.getTemplateId());
			if (demandDomain.getTemplateId() > 0) {
				baseResult.setSuccess(true);
			} else {
				baseResult.setSuccess(false);
				baseResult.setMessage("插入数据报错");
			}
		} catch (IllegalArgumentException e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.INCOMPLETE_REQ_PARAM, e.getMessage());
		} catch (Exception e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.UN_KNOWN_EXCEPTION, e.getMessage());
		}
		return baseResult;
	}
	
	@Override
	public EsupplierBaseResult updateDomain(CreateGiftMoneyTemplateOrder domainOrder) {
		logger.info("更新领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		
		try {
			Assert.isTrue(domainOrder.getTemplateId() > 0);
			domainOrder.check();
			Date sysDate = EsupplierDomainHolder.get().getSysDate();
			GiftMoneyTemplateDomain demandDomain = new GiftMoneyTemplateDomain();
			MiscUtil.copyPoObject(demandDomain, domainOrder);
			demandDomain.setRawUpdateTime(sysDate);
			demandDomain.setStatus(GiftMoneyStatusEnum.getByCode(domainOrder.getStatus()));
			giftMoneyTemplateDomainRepository.reStore(demandDomain);
			baseResult.setSuccess(true);
			return baseResult;
		} catch (IllegalArgumentException e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.INCOMPLETE_REQ_PARAM, e.getMessage());
		} catch (Exception e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.UN_KNOWN_EXCEPTION, e.getMessage());
		}
		
	}
	
	@Override
	public EsupplierBaseResult updateDomainStatus(ChangeGiftMoneyTemplateStatusOrder domainOrder) {
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		try {
			Assert.isTrue(domainOrder.getTemplateId() > 0);
			domainOrder.check();
			giftMoneyTemplateDomainRepository.changeStatus(domainOrder.getTemplateId(),
				domainOrder.getStatus());
			baseResult.setSuccess(true);
			return baseResult;
		} catch (IllegalArgumentException e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.INCOMPLETE_REQ_PARAM, e.getMessage());
		} catch (Exception e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.UN_KNOWN_EXCEPTION, e.getMessage());
		}
	}
}
