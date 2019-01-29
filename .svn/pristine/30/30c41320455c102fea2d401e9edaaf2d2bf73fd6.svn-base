package com.yjf.esupplier.domain.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.domain.GiftMoneyDomain;
import com.yjf.esupplier.domain.context.EsupplierDomainHolder;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.GiftMoneyDomainService;
import com.yjf.esupplier.domain.service.repository.GiftMoneyDomainRepository;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyInfo;
import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service("giftMoneyDomainService")
public class GiftMoneyDomainServiceImpl extends DomainServiceBase implements GiftMoneyDomainService {
	@Autowired
	GiftMoneyDomainRepository giftMoneyDomainRepository;
	
	@Override
	public EsupplierBaseResult createDomain(CreateGiftMoneyOrder domainOrder) {
		logger.info("创建领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		Date sysDate = EsupplierDomainHolder.get().getSysDate();
		GiftMoneyDomain demandDomain = new GiftMoneyDomain();
		try {
			domainOrder.check();
			MiscUtil.copyPoObject(demandDomain, domainOrder);
			demandDomain.setGiveType(domainOrder.getGiveRuleType());
			
			demandDomain.setUseType(domainOrder.getUseType());
			demandDomain.setType(domainOrder.getType());
			demandDomain.setRawAddTime(sysDate);
			demandDomain.setRawUpdateTime(sysDate);
			EsupplierDomainHolder.get().setDomain(demandDomain);
			demandDomain.setStatus(GiftMoneyStatusEnum.STOP.code());
			giftMoneyDomainRepository.store(demandDomain);
			domainOrder.setGiftId(demandDomain.getGiftId());
			if (demandDomain.getGiftId() > 0) {
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
	public EsupplierBaseResult updateDomain(CreateGiftMoneyOrder domainOrder) {
		
		logger.info("创建领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		Date sysDate = EsupplierDomainHolder.get().getSysDate();
		try {
			Assert.isTrue(domainOrder.getGiftId() > 0);
			domainOrder.check();
			GiftMoneyDomain demandDomain = giftMoneyDomainRepository.active(
				domainOrder.getGiftId(), true);
			if (StringUtil.notEquals(demandDomain.getStatus(), GiftMoneyStatusEnum.STOP.code())) {
				baseResult.setSuccess(false);
				baseResult.setMessage("已经启用不能修改");
				baseResult.setCreditsysResultEnum(EsupplierResultEnum.DO_ACTION_STATUS_ERROR);
				return baseResult;
			}
			String status = demandDomain.getStatus();
			Date rawAddTime = demandDomain.getRawAddTime();
			BeanCopier.staticCopy(domainOrder, demandDomain);
			demandDomain.setGiveType(domainOrder.getGiveRuleType());
			demandDomain.setUseType(domainOrder.getUseType());
			demandDomain.setType(domainOrder.getType());
			demandDomain.setRawAddTime(rawAddTime);
			demandDomain.setRawUpdateTime(sysDate);
			demandDomain.setStatus(status);
			giftMoneyDomainRepository.reStore(demandDomain);
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
	public EsupplierBaseResult updateDomainStatus(ChangeGiftMoneyStatusOrder statusOrder) {
		logger.info("更新领域模型状态[status={}]", statusOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		try {
			GiftMoneyDomain demandDomain = giftMoneyDomainRepository.active(
				statusOrder.getGiftId(), true);
			demandDomain.setRawUpdateTime(statusOrder.getUpdateRowDate());
			demandDomain.setCreateUserid(statusOrder.getCreateUserid());
			demandDomain.setCreateUsername(statusOrder.getCreateUsername());
			demandDomain.setStatus(statusOrder.getStatus());
			giftMoneyDomainRepository.reStore(demandDomain);
			baseResult.setSuccess(true);
			return baseResult;
		} catch (Exception e) {
			throw ExceptionDomainFactory.newDomainException(
				EsupplieDomainResultEnum.UN_KNOWN_EXCEPTION, e.getMessage());
		}
	}
	
	@Override
	public EsupplierBaseResult updateBalance(CreateGiftMoneyOrder domainOrder) {
		logger.info("创建领域模型[domainOrder={}]", domainOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		Date sysDate = EsupplierDomainHolder.get().getSysDate();
		try {
			Assert.isTrue(domainOrder.getGiftId() > 0);
			GiftMoneyDomain demandDomain = giftMoneyDomainRepository.active(
				domainOrder.getGiftId(), true);
			if (demandDomain.getType() != GiftMoneyTypeEnum.GAIN_AMOUNT) {
				if (demandDomain.getUsedAmount().compareTo(demandDomain.getTotalAmount()) == 0
					|| demandDomain.getUsedAmount().compareTo(demandDomain.getTotalAmount()) > 0) {
					throw ExceptionDomainFactory.newDomainException(
						EsupplieDomainResultEnum.DO_ACTION_STATUS_ERROR, "优惠券已经发放完");
				}
			} else {
				if (demandDomain.getUsedAmount().compareTo(demandDomain.getTotalAmount()) == 0
						|| demandDomain.getUsedAmount().compareTo(demandDomain.getTotalAmount()) > 0) {
					throw ExceptionDomainFactory.newDomainException(
						EsupplieDomainResultEnum.DO_ACTION_STATUS_ERROR, "优惠券已经发放完");
				}
			}
			
			BeanCopier.staticCopy(domainOrder, demandDomain);
			demandDomain.setRawUpdateTime(sysDate);
			giftMoneyDomainRepository.reStore(demandDomain);
			
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
	public EsupplierBaseResult updateDomain(GiftMoneyInfo giftMoneyInfo) {
		logger.info("更新领域模型[giftMoneyInfo={}]", giftMoneyInfo);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		
		try {
			GiftMoneyDomain demandDomain = giftMoneyDomainRepository.active(
				giftMoneyInfo.getGiftId(), false);
			BeanCopier.staticCopy(giftMoneyInfo, demandDomain);
			giftMoneyDomainRepository.reStore(demandDomain);
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
