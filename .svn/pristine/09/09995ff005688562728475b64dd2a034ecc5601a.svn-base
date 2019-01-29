package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class RemoveUserCardOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 2858500954336996734L;
	String userId;
	String bindId;
	
	@Override
	public void check() {
		validateHasText(userId, "userId");
		validateHasText(bindId, "bindId");
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getBindId() {
		return this.bindId;
	}
	
	public void setBindId(String bindId) {
		this.bindId = bindId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RemoveUserCardOrder [userId=");
		builder.append(userId);
		builder.append(", bindId=");
		builder.append(bindId);
		builder.append("]");
		return builder.toString();
	}
	
}
