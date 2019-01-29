package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.PaymentFlowDomain;

public interface PaymentFlowDomainRepository {
	void store(PaymentFlowDomain domain);
	
	void reStore(PaymentFlowDomain domain);
	
	PaymentFlowDomain active(String paymentFlowId, boolean isLock);
	
	PaymentFlowDomain activeByOrderNo(String orderNo, boolean isLock);
	
	void remove(PaymentFlowDomain domain);
}
