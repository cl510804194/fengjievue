/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.integration.openapi.enums.OptionEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

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
public class WithdrawOrder extends ValidateOrderBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 132666089469261258L;
	
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
	/** 资金账户id */
	protected String userId;
	/** 代扣金额 */
	protected Money amount;
	/** 备注 */
	protected String memo;
	/** 代扣订单 */
	protected String orderNo;
	/** 银行代码 */
	private String bankCode;
	/** 对公对私 */
	private OptionEnum publicTag;
	/** 银行联行号 */
	protected String bankCnapsNo;
	/** 银行卡号 和银行编码 组合 */
	protected String cardInfos;
	/** 业务编码 default 默认/samecard 同卡进出提现/ signcard 签约卡提现 */
	protected String bizType;
	/** 提现成功是否绑定卡 */
	protected String needBindCard = "N";
	
	@Override
	public void check() {
		
		Assert.hasText(provName);
		Assert.hasText(cityName);
		Assert.hasText(bankAccountNo);
		Assert.hasText(bankAccountName);
		Assert.hasText(userId);
		Assert.notNull(amount);
		Assert.hasText(orderNo);
		Assert.notNull(publicTag);
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
	
	public String getUserId() {
		return userId;
	}
	
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
	
	public OptionEnum getPublicTag() {
		return publicTag;
	}
	
	public void setPublicTag(OptionEnum publicTag) {
		this.publicTag = publicTag;
	}
	
	public String getBankCnapsNo() {
		return bankCnapsNo;
	}
	
	public void setBankCnapsNo(String bankCnapsNo) {
		this.bankCnapsNo = bankCnapsNo;
	}
	
	public String getCardInfos() {
		return this.cardInfos;
	}
	
	public void setCardInfos(String cardInfos) {
		this.cardInfos = cardInfos;
	}
	
	public String getBizType() {
		return this.bizType;
	}
	
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	
	public String getNeedBindCard() {
		return this.needBindCard;
	}
	
	public void setNeedBindCard(String needBindCard) {
		this.needBindCard = needBindCard;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WithdrawOrder [provName=");
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
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", publicTag=");
		builder.append(publicTag);
		builder.append(", bankCnapsNo=");
		builder.append(bankCnapsNo);
		builder.append(", cardInfos=");
		builder.append(cardInfos);
		builder.append(", bizType=");
		builder.append(bizType);
		builder.append(", needBindCard=");
		builder.append(needBindCard);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	
}
