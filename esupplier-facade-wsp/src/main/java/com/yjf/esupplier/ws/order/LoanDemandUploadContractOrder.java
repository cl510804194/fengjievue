package com.yjf.esupplier.ws.order;

public class LoanDemandUploadContractOrder extends TradeProcessOrder {
	private static final long serialVersionUID = 2904905005749445215L;
	String uploadContractUrl = null;
	
	public String getUploadContractUrl() {
		return this.uploadContractUrl;
	}
	
	public void setUploadContractUrl(String uploadContractUrl) {
		this.uploadContractUrl = uploadContractUrl;
	}
	
	@Override
	public void check() {
		super.check();
		validateHasText(uploadContractUrl, "正式担保函地址");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandUploadContractOrder [uploadContractUrl=");
		builder.append(uploadContractUrl);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
