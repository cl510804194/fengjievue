package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.LoanPeriodUnitEnum;

public class CalculateLoanCostOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = -1320687670498445356L;
	long templateId;
	Money loanAmount = Money.zero();
	LoanPeriodUnitEnum timeLimitUnit;
	int timeLimit = 0;
	
	public long getTemplateId() {
		return this.templateId;
	}
	
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	
	public Money getLoanAmount() {
		return this.loanAmount;
	}
	
	public void setLoanAmount(Money loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public LoanPeriodUnitEnum getTimeLimitUnit() {
		return this.timeLimitUnit;
	}
	
	public void setTimeLimitUnit(LoanPeriodUnitEnum timeLimitUnit) {
		this.timeLimitUnit = timeLimitUnit;
	}
	
	public int getTimeLimit() {
		return this.timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
}
