package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.integration.openapi.enums.YjFPayModeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class DepositOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -1244684037991013493L;
	/** 付费方式 */
	private YjFPayModeEnum payMode = null;
	/** 资金账户id */
	protected String userId;
	
	public YjFPayModeEnum getPayMode() {
		return this.payMode;
	}
	
	public void setPayMode(YjFPayModeEnum payMode) {
		this.payMode = payMode;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public void check() {
		super.check();
		this.validateHasText(userId, "资金账户id");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepositOrder [payMode=");
		builder.append(payMode);
		builder.append("]");
		return builder.toString();
	}
	
}
