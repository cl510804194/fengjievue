package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class PayOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -6061936767314429303L;
	
	String returnUrl;
	
	String notifyUrl;
	
	String serviceName;
	
	String version = "1.0";
	
	public String getReturnUrl() {
		return this.returnUrl;
	}
	
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	
	public String getNotifyUrl() {
		return this.notifyUrl;
	}
	
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
	public String getServiceName() {
		return this.serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayOrder [returnUrl=");
		builder.append(returnUrl);
		builder.append(", notifyUrl=");
		builder.append(notifyUrl);
		builder.append(", serviceName=");
		builder.append(serviceName);
		builder.append("]");
		return builder.toString();
	}
	
}
