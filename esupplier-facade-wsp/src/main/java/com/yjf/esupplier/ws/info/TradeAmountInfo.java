package com.yjf.esupplier.ws.info;

import com.yjf.common.lang.util.money.Money;

public class TradeAmountInfo {
	Money payInvestorAmount = new Money();
	Money payInvestorAmountSend = new Money();
	Money payBrokerAmount = new Money();
	Money payMarkettingAmount = new Money();
	Money payGuaranteeAmount = new Money();
	Money payPlateformAmount = new Money();
	Money totalPayAmount = new Money();
	
	public Money getPayInvestorAmount() {
		return this.payInvestorAmount;
	}
	
	public void setPayInvestorAmount(Money payInvestorAmount) {
		this.payInvestorAmount = payInvestorAmount;
	}
	
	public Money getPayInvestorAmountSend() {
		return this.payInvestorAmountSend;
	}
	
	public void setPayInvestorAmountSend(Money payInvestorAmountSend) {
		this.payInvestorAmountSend = payInvestorAmountSend;
	}
	
	public Money getPayBrokerAmount() {
		return this.payBrokerAmount;
	}
	
	public void setPayBrokerAmount(Money payBrokerAmount) {
		this.payBrokerAmount = payBrokerAmount;
	}
	
	public Money getPayMarkettingAmount() {
		return this.payMarkettingAmount;
	}
	
	public void setPayMarkettingAmount(Money payMarkettingAmount) {
		this.payMarkettingAmount = payMarkettingAmount;
	}
	
	public Money getPayGuaranteeAmount() {
		return this.payGuaranteeAmount;
	}
	
	public void setPayGuaranteeAmount(Money payGuaranteeAmount) {
		this.payGuaranteeAmount = payGuaranteeAmount;
	}
	
	public Money getPayPlateformAmount() {
		return this.payPlateformAmount;
	}
	
	public void setPayPlateformAmount(Money payPlateformAmount) {
		this.payPlateformAmount = payPlateformAmount;
	}
	
	public Money getTotalPayAmount() {
		return this.totalPayAmount;
	}
	
	public void setTotalPayAmount(Money totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}
	
}
