/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import java.util.Date;
import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 *                       
 * @Filename QueryDepositOrder.java
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
 *<li>Date: 2014-4-7</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class QueryDepositOrder extends ValidateOrderBase implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -5644015434898215842L;
	
	/** 当前页 */
	protected int				currPage			= 1;
	
	/** 页大小 0 表示不分页 */
	protected int				pageSize			= 10;
	
	/** 业务系统标志 ，请参考核心BusinessCategoryEnum枚举，对应的code */
	protected String			bizId;
	
	/** 账户id */
	protected String			userId;
	
	/** 外部订单号 */
	protected String			outBizNo;
	
	/** 充值流水 */
	protected String			payNo;
	
	/** 账务流水 */
	protected String			accBizNo;
	
	/** 起始时间,业务发生时间 */
	protected Date				startTime;
	
	/** 终止时间,业务发生时间 */
	protected Date				endTime;
	
	/** 清算流水 */
	protected String			settleBizNo;
	
	/** 起始时间,清算时间,上账时间 */
	protected Date				startSettleTime;
	
	/** 终止时间,清算时间,上账时间 */
	protected Date				endSettleTime;
	
	/** 金额下限,总金额 */
	protected Money				minAmountIn;
	
	/** 金额上限,总金额 */
	protected Money				maxAmountIn;
	
	/** 金额下限,本金 */
	protected Money				minAmount;
	
	/** 金额上限,本金 */
	protected Money				maxAmount;
	/** 子业务类型，请参考核心PayToolAccessEnum枚举，对应的code */
	private String				apiAccess;
	
	/** 状态集合 ，请参考核心DepositStatusEnum枚举，对应的code */
	private List<String>		status;
	
	/** 资金渠道 银行代码 */
	private String				bankCode;
	
	/** 资金渠道 银行名称 */
	private String				bankName;
	
	/** 银行账号 卡号 */
	private String				bankAccountNo;
	
	/** 清算渠道 */
	private List<String>		settleChannelApis;
	
	@Override
	public void check() {
		this.validateHasText(userId, "账户id");
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
	
	public String getSettleBizNo() {
		return settleBizNo;
	}
	
	public void setSettleBizNo(String settleBizNo) {
		this.settleBizNo = settleBizNo;
	}
	
	public Date getStartSettleTime() {
		return startSettleTime;
	}
	
	public void setStartSettleTime(Date startSettleTime) {
		this.startSettleTime = startSettleTime;
	}
	
	public Date getEndSettleTime() {
		return endSettleTime;
	}
	
	public void setEndSettleTime(Date endSettleTime) {
		this.endSettleTime = endSettleTime;
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
	
	public String getApiAccess() {
		return apiAccess;
	}
	
	public void setApiAccess(String apiAccess) {
		this.apiAccess = apiAccess;
	}
	
	public List<String> getStatus() {
		return status;
	}
	
	public void setStatus(List<String> status) {
		this.status = status;
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
	
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	public List<String> getSettleChannelApis() {
		return settleChannelApis;
	}
	
	public void setSettleChannelApis(List<String> settleChannelApis) {
		this.settleChannelApis = settleChannelApis;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryDepositOrder [currPage=");
		builder.append(currPage);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", bizId=");
		builder.append(bizId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", payNo=");
		builder.append(payNo);
		builder.append(", accBizNo=");
		builder.append(accBizNo);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", settleBizNo=");
		builder.append(settleBizNo);
		builder.append(", startSettleTime=");
		builder.append(startSettleTime);
		builder.append(", endSettleTime=");
		builder.append(endSettleTime);
		builder.append(", minAmountIn=");
		builder.append(minAmountIn);
		builder.append(", maxAmountIn=");
		builder.append(maxAmountIn);
		builder.append(", minAmount=");
		builder.append(minAmount);
		builder.append(", maxAmount=");
		builder.append(maxAmount);
		builder.append(", apiAccess=");
		builder.append(apiAccess);
		builder.append(", status=");
		builder.append(status);
		builder.append(", bankCode=");
		builder.append(bankCode);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", bankAccountNo=");
		builder.append(bankAccountNo);
		builder.append(", settleChannelApis=");
		builder.append(settleChannelApis);
		builder.append("]");
		return builder.toString();
	}
	
}
