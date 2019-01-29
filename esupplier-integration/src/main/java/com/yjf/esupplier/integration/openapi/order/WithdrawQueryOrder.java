/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 *                       
 * @Filename WithdrawQueryOrder.java
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
public class WithdrawQueryOrder extends ValidateOrderBase implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -6222752997902774083L;
	/**提现流水号*/
	String						payNo;
	/** 起始时间,业务发生时间 */
	protected Date				startTime;
	
	/** 终止时间,业务发生时间 */
	protected Date				endTime;
	
	/** 账户id */
	protected String			userId;
	
	/** 外部订单号 */
	protected String			outBizNo;
	
	/** 外部订单号 */
	protected String			bizId;
	
	/** 当前页 */
	protected int				currPage			= 1;
	
	/** 页大小 0 表示不分页 */
	protected int				pageSize			= 10;
	
	/** 最小金额(除去手续费的金额) */
	private Money				minAmount;
	
	/** 最大金额(除去手续费的金额) */
	private Money				maxAmount;
	
	/** 最小金额(包含手续费的金额) */
	private Money				minAmountIn;
	
	/** 最大金额(包含手续费的金额) */
	private Money				maxAmountIn;
	
	/** 资金渠道 银行名称 */
	private String				bankName;
	
	/** 状态集合 */
	private String				status;
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public int getCurrPage() {
		return currPage;
	}
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getBizId() {
		return bizId;
	}
	
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	
	public Money getMinAmount() {
		return minAmount;
	}
	
	public void setMinAmount(Money minAmount) {
		this.minAmount = minAmount;
	}
	
	public Money getMaxAmount() {
		return maxAmount;
	}
	
	public void setMaxAmount(Money maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	public Money getMinAmountIn() {
		return minAmountIn;
	}
	
	public void setMinAmountIn(Money minAmountIn) {
		this.minAmountIn = minAmountIn;
	}
	
	public Money getMaxAmountIn() {
		return maxAmountIn;
	}
	
	public void setMaxAmountIn(Money maxAmountIn) {
		this.maxAmountIn = maxAmountIn;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPayNo() {
		return payNo;
	}
	
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	
	@Override
	public void check() {
		validateHasText(userId, "userId");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WithdrawQueryOrder [startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", bizId=");
		builder.append(bizId);
		builder.append(", currPage=");
		builder.append(currPage);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", minAmount=");
		builder.append(minAmount);
		builder.append(", maxAmount=");
		builder.append(maxAmount);
		builder.append(", minAmountIn=");
		builder.append(minAmountIn);
		builder.append(", maxAmountIn=");
		builder.append(maxAmountIn);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
