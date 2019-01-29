/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.integration.openapi.enums.PublicTagEnum;
import com.yjf.esupplier.integration.openapi.enums.YjFPayModeEnum;
import com.yjf.esupplier.ws.enums.CertTypeEnum;

/**
 * 
 * @Filename DepositDeductOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class DepositDeductOrder extends DepositOrder implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 132666089469261258L;
	/** 证件类型 */
	
	private CertTypeEnum certType;
	/** 证件号 */
	private String certNo;
	/** 银行省名 [<农行cfca 渠道 必须] */
	private String provName;
	/** 银行市名 [农行cfca 渠道 必须] */
	private String cityName;
	/** 银行开户账户号 */
	private String bankAccountNo;
	/** 银行账户开户名 */
	private String bankAccountName;
	
	/** 手机号 */
	private String mobileNo;
	/** 账户名 */
	private String accountName;
	
	/** 代扣金额 */
	protected Money amount;
	/** 备注 */
	protected String memo;
	/** 代扣订单 */
	protected String orderNo;
	/** 银行代码 */
	private String bankCode;
	/** 银行名称 */
	private String bankName;
	/** 对公对私 */
	private PublicTagEnum publicTagEnum;
	/** 付费方式 */
	private YjFPayModeEnum payMode = null;
	/**
	 * 签约流水号
	 */
	private String pactNo;
	
	private String paytk;
	
	@Override
	public void check() {
		super.check();
		Assert.notNull(certType, "certType");
		Assert.hasText(certNo, "certNo");
		Assert.hasText(provName, "provName");
		Assert.hasText(cityName, "cityName");
		Assert.hasText(bankAccountNo, "bankAccountNo");
		Assert.hasText(bankAccountName, "bankAccountName");
		Assert.notNull(amount, "amount");
		Assert.hasText(orderNo, "orderNo");
		Assert.hasText(paytk, "paytk不能为空");
	}
	
	public PublicTagEnum getPublicTagEnum() {
		return publicTagEnum;
	}
	
	public void setPublicTagEnum(PublicTagEnum publicTagEnum) {
		this.publicTagEnum = publicTagEnum;
	}
	
	public CertTypeEnum getCertType() {
		return certType;
	}
	
	public void setCertType(CertTypeEnum certType) {
		this.certType = certType;
	}
	
	public String getCertNo() {
		return certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getProvName() {
		return provName;
	}
	
	public void setProvName(String provName) {
		this.provName = provName;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	public String getBankAccountName() {
		return bankAccountName;
	}
	
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Override
	public String getUserId() {
		return userId;
	}
	
	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public YjFPayModeEnum getPayMode() {
		return this.payMode;
	}
	
	@Override
	public void setPayMode(YjFPayModeEnum payMode) {
		this.payMode = payMode;
	}
	
	public String getPactNo() {
		return pactNo;
	}
	
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	
	public String getPaytk() {
		return paytk;
	}
	
	public void setPaytk(String paytk) {
		this.paytk = paytk;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepositDeductOrder [certType=");
		builder.append(certType);
		builder.append(", certNo=");
		builder.append(certNo);
		builder.append(", provName=");
		builder.append(provName);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", bankAccountNo=");
		builder.append(bankAccountNo);
		builder.append(", bankAccountName=");
		builder.append(bankAccountName);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", publicTagEnum=");
		builder.append(publicTagEnum);
		builder.append(", payMode=");
		builder.append(payMode);
		builder.append(", pactNo=");
		builder.append(pactNo);
		builder.append(", paytk=");
		builder.append(paytk);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	
}
