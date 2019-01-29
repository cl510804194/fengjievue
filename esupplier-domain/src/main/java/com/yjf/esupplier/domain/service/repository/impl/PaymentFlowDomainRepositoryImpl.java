package com.yjf.esupplier.domain.service.repository.impl;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.dal.dataobject.PaymentFlowDO;
import com.yjf.esupplier.domain.PaymentFlowDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.repository.PaymentFlowDomainRepository;

@Service("paymentFlowDomainRepository")
public class PaymentFlowDomainRepositoryImpl extends DomainRepositoryBase implements
																			PaymentFlowDomainRepository {
	
	@Override
	public void store(PaymentFlowDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		PaymentFlowDO paymentFlowDO = new PaymentFlowDO();
		DomainConvert.paymentFlowDomainCovertDO(domain, paymentFlowDO);
		paymentFlowDAO.insert(paymentFlowDO);
	}
	
	@Override
	public void reStore(PaymentFlowDomain domain) {
		if (domain == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		PaymentFlowDO paymentFlowDO = new PaymentFlowDO();
		DomainConvert.paymentFlowDomainCovertDO(domain, paymentFlowDO);
		paymentFlowDAO.update(paymentFlowDO);
	}
	
	@Override
	public PaymentFlowDomain active(String paymentFlowId, boolean isLock) {
		PaymentFlowDO paymentFlowDO = null;
		if (isLock) {
			paymentFlowDO = paymentFlowDAO.findByIdForUpdate(paymentFlowId);
		} else {
			paymentFlowDO = paymentFlowDAO.findById(paymentFlowId);
		}
		if (paymentFlowDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		PaymentFlowDomain domain = new PaymentFlowDomain();
		DomainConvert.paymentFlowDOCovertDomain(domain, paymentFlowDO);
		return domain;
	}
	
	@Override
	public void remove(PaymentFlowDomain domain) {
		paymentFlowDAO.deleteById(domain.getPaymentFlowId());
	}
	
	@Override
	public PaymentFlowDomain activeByOrderNo(String orderNo, boolean isLock) {
		PaymentFlowDO paymentFlowDO = null;
		if (isLock) {
			paymentFlowDO = paymentFlowDAO.findByOrderNoForUpdate(orderNo);
		} else {
			paymentFlowDO = paymentFlowDAO.findByOrderNo(orderNo);
		}
		if (paymentFlowDO == null) {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		PaymentFlowDomain domain = new PaymentFlowDomain();
		DomainConvert.paymentFlowDOCovertDomain(domain, paymentFlowDO);
		return domain;
	}
}
