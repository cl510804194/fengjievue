package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class PactResult extends EsupplierBaseResult {
	private static final long serialVersionUID = 8492509229681211728L;
	/**
	 * 签约号
	 */
	String tradeNo;
	/**
	 * 签约类型
	 */
	String pactType;
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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
		builder.append("PactResult [tradeNo=");
		builder.append(tradeNo);
		builder.append(", pactType=");
		builder.append(pactType);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
