package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class PactSignOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 3597411416497070594L;
	/**
	 * 签约流水号
	 */
	String tradeNo;
	/**
	 * 验证码
	 */
	String mobileCode;
	/**
	 * 签约类型
	 */
	String pactType;
	
	@Override
	public void check() {
		validateHasText(tradeNo, "签约流水号");
		validateHasText(mobileCode, "验证码");
		validateHasText(pactType, "签约类型");
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public String getMobileCode() {
		return this.mobileCode;
	}
	
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	
	public String getPactType() {
		return this.pactType;
	}
	
	public void setPactType(String pactType) {
		this.pactType = pactType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PactSignOrder [tradeNo=");
		builder.append(tradeNo);
		builder.append(", mobileCode=");
		builder.append(mobileCode);
		builder.append(", pactType=");
		builder.append(pactType);
		builder.append("]");
		return builder.toString();
	}
	
}
