/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jiajie 上午11:32:29 创建
 */
package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * 
 * @author jiajie
 * 
 */
public class OfflineDepositOrder extends ValidateOrderBase implements Order {
	
	private static final long	serialVersionUID	= 1L;
	
	/** 交易号[1: send, 2:update] */
	private String				bizNo;
	
	public String getBizNo() {
		return bizNo;
	}
	
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	
	/** 业务标记[1: send, 2:update] */
	private String	type;
	/** 银行简称 */
	private String	bankCode;
	/** 金额 */
	private Money	amount;
	/** 银行卡号 */
	private String	bankCardNo;
	/** 所在城市 */
	private String	city		= "重庆";
	/** 会员ID */
	private String	userId;
	/** 真实姓名 */
	private String	realName;
	/** 外部订单号 */
	private String	outBizNo;
	/** 身份证号 */
	private String	certNo;
	/** 币种 */
	private String	currency	= "CNY";
	
	public String getBankCode() {
		return bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	/** 业务标记[1: send, 2:update] */
	public void setType(String type) {
		this.type = type;
	}
	
	public String getBankCardNo() {
		return bankCardNo;
	}
	
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public String getCertNo() {
		return certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OfflineDepositOrder [bizNo=");
		builder.append(bizNo);
		builder.append(", type=");
		builder.append(type);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", bankCardNo=");
		builder.append(bankCardNo);
		builder.append(", city=");
		builder.append(city);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", certNo=");
		builder.append(certNo);
		builder.append(", currency=");
		builder.append(currency);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	@Override
	public void check() {
		
		validateHasText(bizNo, "交易流水号");
		
	}
}
