package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class UserQuickCertifyOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 4216683453323529596L;
	/**
	 * 用户真实姓名
	 */
	String realName;
	/**
	 * 用户证件号
	 */
	String certNo;
	/**
	 * 用户易极付id
	 */
	String userId;
	/**
	 * 有效期
	 */
	String certValidTime;
	
	@Override
	public void check() {
		validateHasText(realName, "用户真实姓名");
		validateHasText(certNo, "用户证件号码");
		validateHasText(userId, "用户易极付id");
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getCertNo() {
		return this.certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCertValidTime() {
		return this.certValidTime;
	}
	
	public void setCertValidTime(String certValidTime) {
		this.certValidTime = certValidTime;
	}
	
}
