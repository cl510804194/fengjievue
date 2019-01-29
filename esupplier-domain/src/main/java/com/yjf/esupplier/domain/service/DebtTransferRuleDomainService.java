package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.ws.order.CreateDebtTransferRuleOrder;

public interface DebtTransferRuleDomainService {
	
	public void createDomain(CreateDebtTransferRuleOrder domainOrder);
	
	public void updateDomain(String version);






	
}
