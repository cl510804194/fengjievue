package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;

public class AliFastpayOrder extends PayOrder {
	
	private static final long serialVersionUID = 1384305577613955444L;
	String userId;
	Money payAmount = new Money();
	String productName;
	String productRemark;
	String productShowUrl;
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Money getPayAmount() {
		return this.payAmount;
	}
	
	public void setPayAmount(Money payAmount) {
		this.payAmount = payAmount;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductRemark() {
		return this.productRemark;
	}
	
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
	
	public String getProductShowUrl() {
		return this.productShowUrl;
	}
	
	public void setProductShowUrl(String productShowUrl) {
		this.productShowUrl = productShowUrl;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AliFastpayOrder [userId=");
		builder.append(userId);
		builder.append(", payAmount=");
		builder.append(payAmount);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productRemark=");
		builder.append(productRemark);
		builder.append(", productShowUrl=");
		builder.append(productShowUrl);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
