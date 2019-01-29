package com.yjf.esupplier.ws.order;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;

public class CustomRepayOrder extends TradeProcessOrder implements Order {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6722570032622008012L;
	long repayUserId;
	Money repayMoney = Money.zero();
	double rateInvestor;
	double rateGuarantee;
	double ratePlat;
	
	@Override
	public void check() {
		// TODO Auto-generated method stub
		Assert.isTrue(repayUserId > 0, "repayUserId is not exsit");
		Assert.isTrue(rateInvestor > 0 || rateGuarantee > 0 || ratePlat > 0, "rate is not exsit");
		validateMoneyGreaterThanZero(repayMoney, "还款金额");
		
	}
	
	public long getRepayUserId() {
		return repayUserId;
	}
	
	public void setRepayUserId(long repayUserId) {
		this.repayUserId = repayUserId;
	}
	
	public double getRateInvestor() {
		return rateInvestor;
	}
	
	public void setRateInvestor(double rateInvestor) {
		this.rateInvestor = rateInvestor;
	}
	
	public double getRateGuarantee() {
		return this.rateGuarantee;
	}
	
	public void setRateGuarantee(double rateGuarantee) {
		this.rateGuarantee = rateGuarantee;
	}
	
	public double getRatePlat() {
		return ratePlat;
	}
	
	public void setRatePlat(double ratePlat) {
		this.ratePlat = ratePlat;
	}
	
	public Money getRepayMoney() {
		return this.repayMoney;
	}
	
	public void setRepayMoney(Money repayMoney) {
		this.repayMoney = repayMoney;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomRepayOrder [repayUserId=");
		builder.append(repayUserId);
		builder.append(", repayMoney=");
		builder.append(repayMoney);
		builder.append(", rateInvestor=");
		builder.append(rateInvestor);
		builder.append(", rateGuarantee=");
		builder.append(rateGuarantee);
		builder.append(", ratePlat=");
		builder.append(ratePlat);
		builder.append("]");
		return builder.toString();
	}
	
}
