package com.yjf.esupplier.integration.web.server.impl;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class YjfPayPwdOrder extends ValidateOrderBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2239163432106791906L;

	String service;
	String orderNo;

	String returnUrl;
	String errorNotifyUrl;

	String userId;
	String passwordType = "payPwd";

	String sources = "";
	String btnColor = "";

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getErrorNotifyUrl() {
		return errorNotifyUrl;
	}

	public void setErrorNotifyUrl(String errorNotifyUrl) {
		this.errorNotifyUrl = errorNotifyUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(String passwordType) {
		this.passwordType = passwordType;
	}

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(String btnColor) {
		this.btnColor = btnColor;
	}

	@Override
	public String toString() {
		return "YjfPayPwdOrder [service=" + service + ", orderNo=" + orderNo
				+ ", returnUrl=" + returnUrl + ", errorNotifyUrl="
				+ errorNotifyUrl + ", userId=" + userId + ", passwordType="
				+ passwordType + ", sources=" + sources + ", btnColor="
				+ btnColor + "]";
	}

}
