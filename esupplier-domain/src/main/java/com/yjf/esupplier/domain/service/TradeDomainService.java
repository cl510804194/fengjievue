package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.domain.LoanDemandDomain;
import com.yjf.esupplier.domain.result.TradeDomainResult;
import com.yjf.esupplier.ws.order.CreateLoanDemandOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface TradeDomainService {
	
	public TradeDomainResult createNewTradeDomain(LoanDemandDomain demandDomain);
	
	public EsupplierBaseResult updateDomain(CreateLoanDemandOrder domainOrder);
	
}
