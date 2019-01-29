package com.yjf.esupplier.integration.openapi.result;

import com.yjf.common.lang.util.money.Money;

public class WchatResult extends OpenApiResult {
	
	private static final long serialVersionUID = 5709049977447700386L;
	String tradeNo;
	Money payAmount;
	String scanCodeImageUrl;
	String returnUrl;
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public Money getPayAmount() {
		return this.payAmount;
	}
	
	public void setPayAmount(Money payAmount) {
		this.payAmount = payAmount;
	}
	
	public String getScanCodeImageUrl() {
		return this.scanCodeImageUrl;
	}
	
	public void setScanCodeImageUrl(String scanCodeImageUrl) {
		this.scanCodeImageUrl = scanCodeImageUrl;
	}
	
	public String getReturnUrl() {
		return this.returnUrl;
	}
	
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WchatResult [tradeNo=");
		builder.append(tradeNo);
		builder.append(", payAmount=");
		builder.append(payAmount);
		builder.append(", scanCodeImageUrl=");
		builder.append(scanCodeImageUrl);
		builder.append(", returnUrl=");
		builder.append(returnUrl);
		builder.append("]");
		return builder.toString();
	}
	
}
