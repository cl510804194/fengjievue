package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;

public class WchatYjfPayOrder extends YjfUserPayOrder {
	
	private static final long serialVersionUID = -6619121186433118213L;
	String payFrom;
	String uiStyle = "MOBILE_WEB";//PC_NORMAL:PC标准版;ZBJ:猪八戒版;MOBILE_WEB:手机web版
	String mutableType;
	String scanCodeImageUrl;
	Money payAmount;
	String tradeNo;
	String userEndIp;
	String paymentFlowId;
	public WchatYjfPayOrder() {
		debitCreditType = null;// CREDIT:CREDIT    DEBIT:DEBIT
		personalCorporateType = null;//CORPORATE:对公;PERSONAL:对私
	}
	
	public String getPayFrom() {
		return this.payFrom;
	}
	
	public void setPayFrom(String payFrom) {
		this.payFrom = payFrom;
	}
	
	public String getUiStyle() {
		return this.uiStyle;
	}
	
	public void setUiStyle(String uiStyle) {
		this.uiStyle = uiStyle;
	}
	
	public String getMutableType() {
		return this.mutableType;
	}
	
	public void setMutableType(String mutableType) {
		this.mutableType = mutableType;
	}
	
	@Override
	public String getBuyerUserId() {
		return null;
	}
	
	@Override
	public String getBuyerUserName() {
		return null;
	}
	
	@Override
	public String getSellerUserName() {
		return null;
	}
	
	@Override
	public String getPayerUserId() {
		return null;
	}
	
	public String getScanCodeImageUrl() {
		return this.scanCodeImageUrl;
	}
	
	public void setScanCodeImageUrl(String scanCodeImageUrl) {
		this.scanCodeImageUrl = scanCodeImageUrl;
	}
	
	public Money getPayAmount() {
		return this.payAmount;
	}
	
	public void setPayAmount(Money payAmount) {
		this.payAmount = payAmount;
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public String getUserEndIp() {
		return userEndIp;
	}
	
	public void setUserEndIp(String userEndIp) {
		this.userEndIp = userEndIp;
	}

	public String getPaymentFlowId() {
		return paymentFlowId;
	}
	
	public void setPaymentFlowId(String paymentFlowId) {
		this.paymentFlowId = paymentFlowId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WchatYjfPayOrder [payFrom=");
		builder.append(payFrom);
		builder.append(", uiStyle=");
		builder.append(uiStyle);
		builder.append(", mutableType=");
		builder.append(mutableType);
		builder.append(", scanCodeImageUrl=");
		builder.append(scanCodeImageUrl);
		builder.append(", payAmount=");
		builder.append(payAmount);
		builder.append(", tradeNo=");
		builder.append(tradeNo);
		builder.append(", userEndIp=");
		builder.append(userEndIp);
		builder.append(", paymentFlowId=");
		builder.append(paymentFlowId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
}
