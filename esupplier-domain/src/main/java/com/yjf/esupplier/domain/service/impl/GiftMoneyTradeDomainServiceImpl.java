package com.yjf.esupplier.domain.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.domain.GiftMoneyTradeDomain;
import com.yjf.esupplier.domain.UserAccountDataDomain;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.GiftMoneyTradeDomainService;
import com.yjf.esupplier.domain.service.repository.GiftMoneyTradeDomainRepository;
import com.yjf.esupplier.domain.service.repository.UserAccountDataDomainRepository;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTradeTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@Service("giftMoneyTradeDomainService")
public class GiftMoneyTradeDomainServiceImpl extends DomainServiceBase implements
																		GiftMoneyTradeDomainService {
	
	@Autowired
	GiftMoneyTradeDomainRepository giftMoneyTradeDomainRepository;
	@Autowired
	UserAccountDataDomainRepository userAccountDataDomainRepository;
	
	@Override
	public EsupplierBaseResult createDomain(GiftMoneyTradeDomain giftMoneyTradeDomain) {
		//TODO
		logger.info("创建领域模型[demandDomain={}]", giftMoneyTradeDomain);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		try {
			giftMoneyTradeDomain.setRawAddTime(new Date());
			giftMoneyTradeDomainRepository.store(giftMoneyTradeDomain);
			UserAccountDataDomain userAccountDataDomain = userAccountDataDomainRepository.active(
				giftMoneyTradeDomain.getUserid(), true);
			if (giftMoneyTradeDomain.getType() == GiftMoneyTypeEnum.GIFT_MONEY) {
				if (giftMoneyTradeDomain.getTradeType() == GiftMoneyTradeTypeEnum.ORIGINAL) {
					userAccountDataDomain.getUserGiftAmount().addTo(
						giftMoneyTradeDomain.getAmount());
					userAccountDataDomain.getUserGiftAmountGrandTotal().addTo(
						giftMoneyTradeDomain.getAmount());
				} else if (giftMoneyTradeDomain.getTradeType() == GiftMoneyTradeTypeEnum.USED) {
					userAccountDataDomain.getUserGiftAmount().subtractFrom(
						giftMoneyTradeDomain.getAmount());
				}
			} else if (giftMoneyTradeDomain.getType() == GiftMoneyTypeEnum.GIFT_MONEY_CASH) {
				if (giftMoneyTradeDomain.getTradeType() == GiftMoneyTradeTypeEnum.ORIGINAL) {
					userAccountDataDomain.getUserGiftAmountCash().addTo(
						giftMoneyTradeDomain.getAmount());
					userAccountDataDomain.getUserGiftAmountCashGrandTotal().addTo(
						giftMoneyTradeDomain.getAmount());
				} else if (giftMoneyTradeDomain.getTradeType() == GiftMoneyTradeTypeEnum.USED) {
					userAccountDataDomain.getUserGiftAmountCash().subtractFrom(
						giftMoneyTradeDomain.getAmount());
				}
			} else if (giftMoneyTradeDomain.getType() == GiftMoneyTypeEnum.GAIN_AMOUNT) {
				if (giftMoneyTradeDomain.getTradeType() == GiftMoneyTradeTypeEnum.ORIGINAL) {
					userAccountDataDomain.addUserCouponCount();
					userAccountDataDomain.addUserCouponCountGrandTotal();
					userAccountDataDomain.getUserCouponAmount().addTo(
						giftMoneyTradeDomain.getAmount());
					userAccountDataDomain.getUserCouponAmountGrandTotal().addTo(
						giftMoneyTradeDomain.getAmount());
				} else if (giftMoneyTradeDomain.getTradeType() == GiftMoneyTradeTypeEnum.USED) {
					userAccountDataDomain.removeUserCouponCount();
					userAccountDataDomain.getUserCouponAmount().subtractFrom(
						giftMoneyTradeDomain.getAmount());
				}
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
	public EsupplierBaseResult updateDomain(GiftMoneyTradeInfo giftMoneyTradeInfo) {
		
		logger.info("更新领域模型[giftMoneyTradeDomain={}]", giftMoneyTradeInfo);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		
		try {
			GiftMoneyTradeDomain demandDomain = giftMoneyTradeDomainRepository
				.loadByGiftTradeId(giftMoneyTradeInfo.getGiftTradeId());
			BeanCopier.staticCopy(giftMoneyTradeInfo, demandDomain);
			demandDomain.setUseType(giftMoneyTradeInfo.getUseType());
			demandDomain.setTradeType(giftMoneyTradeInfo.getTradeType());
			demandDomain.setType(giftMoneyTradeInfo.getType());
			giftMoneyTradeDomainRepository.reStore(demandDomain);
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
