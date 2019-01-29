package com.yjf.esupplier.ws.result;

import java.util.Arrays;

import com.yjf.common.lang.util.money.Money;

public class CalculateLoanCostResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -9015021169879119808L;
	String[] roleName;
	double[] divisionRule;
	double loanInterest = 0;
	double investorInterest = 0;
	double tradeChargeRate = 0;
	Money tradeChargeAmount = Money.zero();
	
	public String[] getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(String[] roleName) {
		this.roleName = roleName;
	}
	
	public double[] getDivisionRule() {
		return this.divisionRule;
	}
	
	public void setDivisionRule(double[] divisionRule) {
		this.divisionRule = divisionRule;
	}
	
	public double getLoanInterest() {
		return this.loanInterest;
	}
	
	public void setLoanInterest(double loanInterest) {
		this.loanInterest = loanInterest;
	}
	
	public double getInvestorInterest() {
		return this.investorInterest;
	}
	
	public void setInvestorInterest(double investorInterest) {
		this.investorInterest = investorInterest;
	}
	
	public double getTradeChargeRate() {
		return this.tradeChargeRate;
	}
	
	public void setTradeChargeRate(double tradeChargeRate) {
		this.tradeChargeRate = tradeChargeRate;
	}
	
	public Money getTradeChargeAmount() {
		return this.tradeChargeAmount;
	}
	
	public void setTradeChargeAmount(Money tradeChargeAmount) {
		this.tradeChargeAmount = tradeChargeAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculateLoanCostResult [roleName=");
		builder.append(Arrays.toString(roleName));
		builder.append(", divisionRule=");
		builder.append(Arrays.toString(divisionRule));
		builder.append(", loanInterest=");
		builder.append(loanInterest);
		builder.append(", investorInterest=");
		builder.append(investorInterest);
		builder.append(", tradeChargeRate=");
		builder.append(tradeChargeRate);
		builder.append(", tradeChargeAmount=");
		builder.append(tradeChargeAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
