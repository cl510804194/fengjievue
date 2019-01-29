package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class PactApplyOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 8793792617103327358L;
	/**
	 * 会员号(易极付账户id)
	 */
	String userId;
	/**
	 * 银行预留手机号
	 */
	String userPhoneNo;
	
	/**
	 * 银行卡号
	 */
	String cardNo;
	
	@Override
	public void check() {
		super.check();
		validateHasText(userId, "会员号");
		validateHasText(userPhoneNo, "银行预留手机号");
		validateHasText(cardNo, "银行卡号");
		
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPhoneNo() {
		return this.userPhoneNo;
	}
	
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	
	public String getCardNo() {
		return this.cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PactApplyOrder [userId=");
		builder.append(userId);
		builder.append(", userPhoneNo=");
		builder.append(userPhoneNo);
		builder.append(", cardNo=");
		builder.append(cardNo);
		builder.append("]");
		return builder.toString();
	}
	
}
