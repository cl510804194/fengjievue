package com.yjf.esupplier.ws.result;

import java.math.BigDecimal;

import com.yjf.esupplier.ws.info.LoanDemandInfo;

public class LoanDemandCalculateResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 8981929296980585611L;
	LoanDemandInfo loanDemandInfo;
	BigDecimal brokerInterest;
	
	public LoanDemandInfo getLoanDemandInfo() {
		return this.loanDemandInfo;
	}
	
	public void setLoanDemandInfo(LoanDemandInfo loanDemandInfo) {
		this.loanDemandInfo = loanDemandInfo;
	}
	
	public BigDecimal getBrokerInterest() {
		return this.brokerInterest;
	}
	
	public void setBrokerInterest(BigDecimal brokerInterest) {
		this.brokerInterest = brokerInterest;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandCalculateResult [loanDemandInfo=");
		builder.append(loanDemandInfo);
		builder.append(", brokerInterest=");
		builder.append(brokerInterest);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
