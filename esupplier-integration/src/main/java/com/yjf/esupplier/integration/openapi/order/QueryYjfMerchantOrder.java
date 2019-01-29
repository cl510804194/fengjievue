package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class QueryYjfMerchantOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -6414063696426420468L;
	String userId;
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public void check() {
		super.check();
		validateHasText(userId, "用户易极付账户id");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryYjfMerchantOrder [userId=");
		builder.append(userId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
