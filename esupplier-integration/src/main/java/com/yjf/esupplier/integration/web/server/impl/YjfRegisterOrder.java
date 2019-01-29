package com.yjf.esupplier.integration.web.server.impl;

import com.yjf.esupplier.integration.openapi.enums.YjfRegesterTypeEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class YjfRegisterOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 5853712204280135317L;
	String userName;
	YjfRegesterTypeEnum yjfRegesterType;
	String system = "p2p";
	String mobile;
	BooleanEnum mobileBinding;
	boolean isUserNameNoBlank = false;
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public YjfRegesterTypeEnum getYjfRegesterType() {
		return this.yjfRegesterType;
	}
	
	public void setYjfRegesterType(YjfRegesterTypeEnum yjfRegesterType) {
		this.yjfRegesterType = yjfRegesterType;
	}
	
	public String getSystem() {
		return this.system;
	}
	
	public void setSystem(String system) {
		this.system = system;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public BooleanEnum getMobileBinding() {
		return this.mobileBinding;
	}
	
	public void setMobileBinding(BooleanEnum mobileBinding) {
		this.mobileBinding = mobileBinding;
	}
	
	public boolean isUserNameNoBlank() {
		return this.isUserNameNoBlank;
	}
	
	public void setUserNameNoBlank(boolean isUserNameNoBlank) {
		this.isUserNameNoBlank = isUserNameNoBlank;
	}
	
	@Override
	public void check() {
		validateHasText(userName, "userName");
		validateNotNull(yjfRegesterType, "注册类型");
		super.check();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfRegisterOrder [userName=");
		builder.append(userName);
		builder.append(", yjfRegesterType=");
		builder.append(yjfRegesterType);
		builder.append(", system=");
		builder.append(system);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
