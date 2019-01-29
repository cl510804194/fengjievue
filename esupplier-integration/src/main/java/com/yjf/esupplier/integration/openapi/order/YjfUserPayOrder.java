package com.yjf.esupplier.integration.openapi.order;

public class YjfUserPayOrder extends YjfPayOrder {
	private static final long serialVersionUID = 8625998021666660731L;
	String buyerUserId = null;
	String buyerUserName = null;
	String sellerUserId;
	String sellerUserName;
	String payerUserId;
	String chargeExtend;
	String debitCreditType = "DEBIT";// CREDIT:CREDIT    DEBIT:DEBIT
	String personalCorporateType = "PERSONAL";//CORPORATE:对公;PERSONAL:对私
	
	public String getBuyerUserId() {
		return this.buyerUserId;
	}
	
	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public String getBuyerUserName() {
		return this.buyerUserName;
	}
	
	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}
	
	public String getSellerUserId() {
		return this.sellerUserId;
	}
	
	public void setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
	}
	
	public String getSellerUserName() {
		return this.sellerUserName;
	}
	
	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}
	
	public String getPayerUserId() {
		return this.payerUserId;
	}
	
	public void setPayerUserId(String payerUserId) {
		this.payerUserId = payerUserId;
	}
	
	public String getChargeExtend() {
		return this.chargeExtend;
	}
	
	public void setChargeExtend(String chargeExtend) {
		this.chargeExtend = chargeExtend;
	}
	
	public String getDebitCreditType() {
		return this.debitCreditType;
	}
	
	public void setDebitCreditType(String debitCreditType) {
		this.debitCreditType = debitCreditType;
	}
	
	public String getPersonalCorporateType() {
		return this.personalCorporateType;
	}
	
	public void setPersonalCorporateType(String personalCorporateType) {
		this.personalCorporateType = personalCorporateType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfUserPayOrder [buyerUserId=");
		builder.append(buyerUserId);
		builder.append(", buyerUserName=");
		builder.append(buyerUserName);
		builder.append(", sellerUserId=");
		builder.append(sellerUserId);
		builder.append(", sellerUserName=");
		builder.append(sellerUserName);
		builder.append(", payerUserId=");
		builder.append(payerUserId);
		builder.append(", chargeExtend=");
		builder.append(chargeExtend);
		builder.append(", debitCreditType=");
		builder.append(debitCreditType);
		builder.append(", personalCorporateType=");
		builder.append(personalCorporateType);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
