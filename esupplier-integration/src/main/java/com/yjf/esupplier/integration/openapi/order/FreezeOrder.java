/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 *                       
 * @Filename FreezeOrder.java
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
public class FreezeOrder extends ValidateOrderBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -6442650044601877300L;
	
	/** 资金帐务号 <code>accountNo</code> */
	private String				accountNo;
	/** 冻结金额 */
	private Money				freezeAmount;
	
	/** 冻结余额类型 <code>freezeType</code> */
	private String				freezeType			= "YZZ_GUARANTEE_FREEZE";
	
	/** 订单编号 <code>orderNo</code> */
	private String				orderNo;
	
	/** 冻结描述  <code>memo</code> */
	private String				memo;

    private String outBizNo ;
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public Money getFreezeAmount() {
		return freezeAmount;
	}
	
	public void setFreezeAmount(Money freezeAmount) {
		this.freezeAmount = freezeAmount;
	}
	
	public String getFreezeType() {
		return freezeType;
	}
	
	public void setFreezeType(String freezeType) {
		this.freezeType = freezeType;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    @Override
	public void check() {
		this.validateHasText(accountNo, "账务号");
		this.validateNotNull(freezeAmount, "冻结解冻金额");
		this.validateGreaterThan(freezeAmount.getCent(), "冻结解冻金额");
		this.validateHasText(freezeType, "冻结解冻类型");
		this.validateHasText(orderNo, "外部订单号");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FreezeOrder [accountNo=");
		builder.append(accountNo);
		builder.append(", freezeAmount=");
		builder.append(freezeAmount);
		builder.append(", freezeType=");
		builder.append(freezeType);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", memo=");
		builder.append(memo);
		builder.append("]");
		return builder.toString();
	}
	
}
