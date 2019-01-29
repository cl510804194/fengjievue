/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * @Filename TradeTransferOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-6</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class FundsTransferOrder extends ValidateOrderBase implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4785083019448254123L;
	
	/** 交易额 */
	Money tradeAmount = Money.zero();
	
	/** 交易备注 */
	protected String remark;
	
	/** 卖家 */
	private String sellerUserId;

	/*交易流水号*/
	private  String payNo;
	
	private int delayHours = 0;
	
	/**
	 * 
	 * @see com.yjf.common.service.Order#check()
	 */
	@Override
	public void check() {
		Assert.isTrue(tradeAmount.greaterThan(Money.zero()));
		//不需要账户，直接退银行卡
//		Assert.hasText(sellerUserId);
	}
	
	public int getDelayHours() {
		return this.delayHours;
	}
	
	public void setDelayHours(int delayHours) {
		this.delayHours = delayHours;
	}

	public Money getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(Money tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSellerUserId() {
		return this.sellerUserId;
	}
	
	public void setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FundsTransferOrder [tradeAmount=");
		builder.append(tradeAmount);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", payNo=");
		builder.append(payNo);
		builder.append(", sellerUserId=");
		builder.append(sellerUserId);
		builder.append(", delayHours=");
		builder.append(delayHours);
		builder.append("]");
		return builder.toString();
	}
	
}
