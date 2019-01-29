package com.yjf.yrd.integration.bornapi.order;

import com.yjf.esupplier.integration.openapi.order.PayOrder;

public class YsfPayOrder extends PayOrder {
	private static final long serialVersionUID = -6230800525989520150L;
	String tradeNo;
	
	@Override
	public void check() {
		validateHasText(tradeNo, "交易号");
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	@Override
	public String toString() {
		return "YsfPayOrder [tradeNo=" + tradeNo + ", toString()=" + super.toString() + "]";
	}
	
}
