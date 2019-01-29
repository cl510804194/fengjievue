package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class YsfCreateOrderResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -4828525395492431488L;
	String tradeNo;
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YsfCreateOrderResult [tradeNo=");
		builder.append(tradeNo);
		builder.append("]");
		return builder.toString();
	}
	
}
