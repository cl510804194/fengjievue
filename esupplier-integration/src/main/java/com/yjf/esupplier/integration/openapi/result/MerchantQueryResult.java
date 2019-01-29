package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class MerchantQueryResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 8989431614808824024L;
	String merchantId;
	String registerFrom;
	
	public String getMerchantId() {
		return this.merchantId;
	}
	
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	public String getRegisterFrom() {
		return this.registerFrom;
	}
	
	public void setRegisterFrom(String registerFrom) {
		this.registerFrom = registerFrom;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MerchantQueryResult [merchantId=");
		builder.append(merchantId);
		builder.append(", registerFrom=");
		builder.append(registerFrom);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
