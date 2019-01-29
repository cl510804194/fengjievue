package com.yjf.esupplier.integration.web.server.impl;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class YjfEzmoneyCheckPaytkOrder extends ValidateOrderBase {
	private static final long serialVersionUID = 8420015819753113382L;
	String userId;
	String paytk;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPaytk() {
		return paytk;
	}
	
	public void setPaytk(String paytk) {
		this.paytk = paytk;
	}
	
	@Override
	public void check() {
		validateHasText(userId, "userId");
		super.check();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfEzmoneyCheckPaytk [userId=");
		builder.append(userId);
		builder.append(", paytk=");
		builder.append(paytk);
		builder.append("]");
		return builder.toString();
	}
}
