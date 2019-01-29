package com.yjf.esupplier.domain.service.repository;

import com.yjf.esupplier.domain.RefundOrderDomain;

public interface RefundOrderDomainRepository {
	void store(RefundOrderDomain domain);
	
	void reStore(RefundOrderDomain domain);
	
	RefundOrderDomain active(long refundId, boolean isLock);
	
	RefundOrderDomain activeByOrderId(long orderId);
	
	void remove(RefundOrderDomain domain);
}
