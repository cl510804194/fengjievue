package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class PayByNotCardOrder extends ValidateOrderBase {
	private static final long serialVersionUID = 8319886998454398726L;
	String subscribeCode;
	String sellerId;
	String payWay = "BY_DEPOSIT";//BY_BALANCE
	Money amount = new Money();
	
	@Override
	public void check() {
		super.check();
		validateHasText(subscribeCode, "签约号");
		validateHasText(sellerId, "收款方");
		validateHasText(payWay, "payWay");
		validateMoneyGreaterThanZero(amount, "金额(元)");
	}
	
	public String getSubscribeCode() {
		return this.subscribeCode;
	}
	
	public void setSubscribeCode(String subscribeCode) {
		this.subscribeCode = subscribeCode;
	}
	
	public String getSellerId() {
		return this.sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getPayWay() {
		return this.payWay;
	}
	
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayByNotCardOrder [subscribeCode=");
		builder.append(subscribeCode);
		builder.append(", sellerId=");
		builder.append(sellerId);
		builder.append(", payWay=");
		builder.append(payWay);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
}
