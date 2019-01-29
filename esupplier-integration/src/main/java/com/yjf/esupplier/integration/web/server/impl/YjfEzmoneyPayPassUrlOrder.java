package com.yjf.esupplier.integration.web.server.impl;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class YjfEzmoneyPayPassUrlOrder extends ValidateOrderBase {

	private static final long serialVersionUID = 5853712204280135317L;
	String userId;
	int origCount = 1;
	String isPhone = "0";
	String platformName = "";
	String btnColor = "";

	@Override
	public void check() {
		validateHasText(userId, "userId");
		super.check();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOrigCount() {
		return origCount;
	}

	public void setOrigCount(int origCount) {
		this.origCount = origCount;
	}

	public String getIsPhone() {
		return this.isPhone;
	}

	public void setIsPhone(String isPhone) {
		this.isPhone = isPhone;
	}

	public String getPlatformName() {
		return this.platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(String btnColor) {
		this.btnColor = btnColor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfEzmoneyPayPassUrlOrder [userId=");
		builder.append(userId);
		builder.append(", origCount=");
		builder.append(origCount);
		builder.append(", isPhone=");
		builder.append(isPhone);
		builder.append(", platformName=");
		builder.append(platformName);
		builder.append(", btnColor=");
		builder.append(btnColor);
		builder.append("]");
		return builder.toString();
	}

}
