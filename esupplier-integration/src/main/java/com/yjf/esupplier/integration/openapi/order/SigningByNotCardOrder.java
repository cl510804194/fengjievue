package com.yjf.esupplier.integration.openapi.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class SigningByNotCardOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -8349878317010218494L;
	/**
	 * 签约类型
	 */
	String subscribeType = "AUTO";//MANUAL
	/**
	 * 用户名
	 */
	String userName;
	/**
	 * 实名信息
	 */
	String realName;
	/**
	 * 身份证
	 */
	String idCard;
	/**
	 * 身份证有效期
	 */
	String validity;
	/**
	 * 手机号码
	 */
	String mobileNo;
	/**
	 * 银行卡号
	 */
	String bankCard;
	//信用卡 信用卡CVV2卡号后3位
	String cvv2;
	//格式：1801 表示2018年01月
	String bankCardValidity;
	
	@Override
	public void check() {
		super.check();
		validateHasText(subscribeType, "签约类型");
		validateHasText(idCard, "身份证");
		validateHasText(userName, "用户名");
		validateHasText(mobileNo, "手机号");
		validateHasText(bankCard, "银行卡号");
		validateHasText(realName, "用户名称");
	}
	
	public String getSubscribeType() {
		return this.subscribeType;
	}
	
	public void setSubscribeType(String subscribeType) {
		this.subscribeType = subscribeType;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getIdCard() {
		return this.idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getValidity() {
		return this.validity;
	}
	
	public void setValidity(String validity) {
		this.validity = validity;
	}
	
	public String getMobileNo() {
		return this.mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getBankCard() {
		return this.bankCard;
	}
	
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	
	public String getCvv2() {
		return this.cvv2;
	}
	
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	
	public String getBankCardValidity() {
		return this.bankCardValidity;
	}
	
	public void setBankCardValidity(String bankCardValidity) {
		this.bankCardValidity = bankCardValidity;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SigningByNotCardOrder [subscribeType=");
		builder.append(subscribeType);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", idCard=");
		builder.append(idCard);
		builder.append(", validity=");
		builder.append(validity);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", bankCard=");
		builder.append(bankCard);
		builder.append(", cvv2=");
		builder.append(cvv2);
		builder.append(", bankCardValidity=");
		builder.append(bankCardValidity);
		builder.append("]");
		return builder.toString();
	}
	
}
