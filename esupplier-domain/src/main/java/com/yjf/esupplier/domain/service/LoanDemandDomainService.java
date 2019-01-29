package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.ws.order.CreateLoanDemandOrder;
import com.yjf.esupplier.ws.result.AddLoanDemandResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface LoanDemandDomainService {
	
	public AddLoanDemandResult createDomain(CreateLoanDemandOrder domainOrder);
	
	public EsupplierBaseResult updateDomain(CreateLoanDemandOrder domainOrder);
	
}
