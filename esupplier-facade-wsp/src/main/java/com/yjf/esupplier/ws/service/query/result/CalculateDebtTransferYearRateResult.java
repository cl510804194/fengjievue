package com.yjf.esupplier.ws.service.query.result;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class CalculateDebtTransferYearRateResult extends EsupplierBaseResult {
	private static final long serialVersionUID = -8350944200210781195L;
	double expectProfitRate = 0.0;
	
	public double getExpectProfitRate() {
		return this.expectProfitRate;
	}
	
	public void setExpectProfitRate(double expectProfitRate) {
		this.expectProfitRate = expectProfitRate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculateDebtTransferYearRateResult [expectProfitRate=");
		builder.append(expectProfitRate);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
