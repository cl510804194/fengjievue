package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.integration.openapi.enums.GatewayTypeEnum;

public class YjfPayGatewayOrder extends YjfUserPayOrder {
	
	private static final long serialVersionUID = -8186848153615347503L;
	
	String bankCode = "";
	
	String buyerMobile = null;
	
	GatewayTypeEnum gatewayType = GatewayTypeEnum.NETBANK;//NETBANK=网银网关 QUICK=快捷网关
	
	String uiStyle = "PC_NORMAL";
	
	public String getBankCode() {
		return this.bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getBuyerMobile() {
		return this.buyerMobile;
	}
	
	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}
	
	public GatewayTypeEnum getGatewayType() {
		return this.gatewayType;
	}
	
	public void setGatewayType(GatewayTypeEnum gatewayType) {
		this.gatewayType = gatewayType;
	}
	
	public String getUiStyle() {
		return this.uiStyle;
	}
	
	public void setUiStyle(String uiStyle) {
		this.uiStyle = uiStyle;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfPayGatewayOrder [bankCode=");
		builder.append(bankCode);
		builder.append(", buyerMobile=");
		builder.append(buyerMobile);
		builder.append(", gatewayType=");
		builder.append(gatewayType);
		builder.append(", uiStyle=");
		builder.append(uiStyle);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
