package com.yjf.esupplier.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.domain.GiftMoneyTemplateRuleDomain;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.GiftMoneyTemplateRuleDomainService;
import com.yjf.esupplier.domain.service.repository.GiftMoneyTemplateRuleDomainRepository;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyTemplateRuleOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * Created by min on 2015/3/17.
 */
@Service("giftMoneyTemplateRuleDomainService")
public class GiftMoneyTemplateRuleDomainServiceImpl extends DomainServiceBase implements
																				GiftMoneyTemplateRuleDomainService {
	@Autowired
	GiftMoneyTemplateRuleDomainRepository giftMoneyTemplateRuleDomainRepository;
	
	@Override
	public EsupplierBaseResult createDomain(CreateGiftMoneyTemplateRuleOrder domainOrder) {
		logger.info("创建领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		GiftMoneyTemplateRuleDomain demandDomain = new GiftMoneyTemplateRuleDomain();
		try {
			domainOrder.check();
			MiscUtil.copyPoObject(demandDomain, domainOrder);
			giftMoneyTemplateRuleDomainRepository.store(demandDomain);
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
	public EsupplierBaseResult updateDomain(CreateGiftMoneyTemplateRuleOrder domainOrder) {
		logger.info("更新领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		
		try {
			Assert.isTrue(domainOrder.getTemplateId() > 0);
			domainOrder.check();
			GiftMoneyTemplateRuleDomain demandDomain = new GiftMoneyTemplateRuleDomain();
			MiscUtil.copyPoObject(demandDomain, domainOrder);
			giftMoneyTemplateRuleDomainRepository.reStore(demandDomain);
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
	public EsupplierBaseResult deleteDomain(long templateId) {
		logger.info("更新领域模型", templateId);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		
		try {
			giftMoneyTemplateRuleDomainRepository.removeByTemplateId(templateId);
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
