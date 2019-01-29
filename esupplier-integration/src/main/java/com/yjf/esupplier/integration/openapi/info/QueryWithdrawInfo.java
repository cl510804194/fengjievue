/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.info;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;

/**
 *                       
 * @Filename WithdrawInfo.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *       
 * @History
 *<li>Author: qichunhai</li>
 *<li>Date: 2014-4-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class QueryWithdrawInfo {
	/** 交易时间 创建时间 yyyyMMDDHHMMSS */
	private Date	payTime;
	
	/** 用户id 会员id */
	private String	userId;
	
	/** 支付流水 */
	private String	payNo;
	
	/** 账务流水 */
	private String	accBizNo;
	
	/** 清算流水 银行流水 */
	private String	settleBizNo;
	
	/** 外部订单号 */
	private String	outBizNo;
	
	/** 支付渠道api */
	private String	payChannelApi;
	
	/** 清算api */
	private String	settleChannelApi;
	
	/** 充值账号 */
	private String	accountNo;
	
	/** 充值账户名 */
	private String	accountName;
	
	/** 银行名称 资金渠道 */
	private String	bankName;
	
	/** 银行账号 卡号 */
	private String	bankAccountNo;
	
	/** 提现金额 本金 */
	private Money	amout;
	
	/** 手续费 */
	private Money	charge;
	
	/** 提现总金额 本金+手续费 */
	private Money	amountIn;
	
	/** 提现后余额 */
	private Money	balance;
	
	/** 体现状态 */
	private String	status;
	
	/** 备注 原因 */
	private String	memo;
	
	public Date getPayTime() {
		return payTime;
	}
	
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPayNo() {
		return payNo;
	}
	
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	
	public String getAccBizNo() {
		return accBizNo;
	}
	
	public void setAccBizNo(String accBizNo) {
		this.accBizNo = accBizNo;
	}
	
	public String getSettleBizNo() {
		return settleBizNo;
	}
	
	public void setSettleBizNo(String settleBizNo) {
		this.settleBizNo = settleBizNo;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public String getPayChannelApi() {
		return payChannelApi;
	}
	
	public void setPayChannelApi(String payChannelApi) {
		this.payChannelApi = payChannelApi;
	}
	
	public String getSettleChannelApi() {
		return settleChannelApi;
	}
	
	public void setSettleChannelApi(String settleChannelApi) {
		this.settleChannelApi = settleChannelApi;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	public Money getAmout() {
		return amout;
	}
	
	public void setAmout(Money amout) {
		this.amout = amout;
	}
	
	public Money getCharge() {
		return charge;
	}
	
	public void setCharge(Money charge) {
		this.charge = charge;
	}
	
	public Money getAmountIn() {
		return amountIn;
	}
	
	public void setAmountIn(Money amountIn) {
		this.amountIn = amountIn;
	}
	
	public Money getBalance() {
		return balance;
	}
	
	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryWithdrawInfo [payTime=");
		builder.append(payTime);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", payNo=");
		builder.append(payNo);
		builder.append(", accBizNo=");
		builder.append(accBizNo);
		builder.append(", settleBizNo=");
		builder.append(settleBizNo);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", payChannelApi=");
		builder.append(payChannelApi);
		builder.append(", settleChannelApi=");
		builder.append(settleChannelApi);
		builder.append(", accountNo=");
		builder.append(accountNo);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", bankAccountNo=");
		builder.append(bankAccountNo);
		builder.append(", amout=");
		builder.append(amout);
		builder.append(", charge=");
		builder.append(charge);
		builder.append(", amountIn=");
		builder.append(amountIn);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", status=");
		builder.append(status);
		builder.append(", memo=");
		builder.append(memo);
		builder.append("]");
		return builder.toString();
	}
	
}
