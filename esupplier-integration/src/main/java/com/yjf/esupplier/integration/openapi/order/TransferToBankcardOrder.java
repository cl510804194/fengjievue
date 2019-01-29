/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.payengine.enums.BankCardTypeEnum;
import com.yjf.common.service.Order;
import com.yjf.esupplier.integration.openapi.enums.BusinessCategoryEnum;
import com.yjf.esupplier.integration.openapi.enums.BusinessNoEnum;
import com.yjf.esupplier.integration.openapi.enums.OptionEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * @Filename TransferToBankcardOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-7</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class TransferToBankcardOrder extends ValidateOrderBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 1815782632922857680L;
	
	/** 转到的银行卡号 */
	@NotBlank
	@Length(max = 30)
	private String bankAccountNo;
	
	/** 银行账户开户名 */
	@NotBlank
	@Length(max = 128)
	private String bankAccountName;
	
	/** 开户行地址 */
	@Length(max = 256)
	private String bankAddress;
	
	/** 银行省名 */
	@NotBlank
	@Length(max = 20)
	private String provName;
	
	/** 银行市名 */
	@NotBlank
	@Length(max = 20)
	private String cityName;
	
	/** 银行代码 */
	@NotNull
	private String bankCode;
	
	/** 银行名字 */
	private String bankName;
	
	/** 银行卡类型 */
	@NotNull
	private final BankCardTypeEnum bankCardTypeEnum = BankCardTypeEnum.DEBIT_CARD;
	
	/** 是否对公 */
	private final OptionEnum publicTag = OptionEnum.Y;
	
	/** 业务号 */
	@NotNull
	private BusinessNoEnum businessNo;
	
	/** 真实姓名 */
	@NotNull
	@Length(max = 128)
	private String realName;
	
	/** 渠道所属来源 */
	@NotNull
	private BusinessCategoryEnum owner;
	/** 手机号码 */
	private String mobile;
	/** 转账人id */
	private String buyerUserId;
	private boolean containInTradeAmount = false;
	private Money tradeAmount = Money.zero();
	private String orderNo;
	
	@Override
	public void check() {
		this.validateHasText(bankAccountNo, "转到的银行卡号");
		this.validateHasText(mobile, "手机号码");
		this.validateHasText(provName, "银行省名");
		this.validateHasText(cityName, "银行市名");
		this.validateHasText(buyerUserId, "转账人");
		this.validateHasText(orderNo, "外部订单号");
		this.validateNotNull(tradeAmount, "转账金额");
		this.validateGreaterThan(tradeAmount.getAmount(), "转账金额");
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
	
	public String getBankAddress() {
		return bankAddress;
	}
	
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
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
	
	public BusinessNoEnum getBusinessNo() {
		return businessNo;
	}
	
	public void setBusinessNo(BusinessNoEnum businessNo) {
		this.businessNo = businessNo;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public BusinessCategoryEnum getOwner() {
		return owner;
	}
	
	public void setOwner(BusinessCategoryEnum owner) {
		this.owner = owner;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getBuyerUserId() {
		return buyerUserId;
	}
	
	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public BankCardTypeEnum getBankCardTypeEnum() {
		return bankCardTypeEnum;
	}
	
	public OptionEnum getPublicTag() {
		return publicTag;
	}
	
	public boolean isContainInTradeAmount() {
		return containInTradeAmount;
	}
	
	public void setContainInTradeAmount(boolean containInTradeAmount) {
		this.containInTradeAmount = containInTradeAmount;
	}
	
	public Money getTradeAmount() {
		return tradeAmount;
	}
	
	public void setTradeAmount(Money tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransferToBankcardOrder [bankAccountNo=");
		builder.append(bankAccountNo);
		builder.append(", bankAccountName=");
		builder.append(bankAccountName);
		builder.append(", bankAddress=");
		builder.append(bankAddress);
		builder.append(", provName=");
		builder.append(provName);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", bankCardTypeEnum=");
		builder.append(bankCardTypeEnum);
		builder.append(", publicTag=");
		builder.append(publicTag);
		builder.append(", businessNo=");
		builder.append(businessNo);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", buyerUserId=");
		builder.append(buyerUserId);
		builder.append(", containInTradeAmount=");
		builder.append(containInTradeAmount);
		builder.append(", tradeAmount=");
		builder.append(tradeAmount);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append("]");
		return builder.toString();
	}
	
}
