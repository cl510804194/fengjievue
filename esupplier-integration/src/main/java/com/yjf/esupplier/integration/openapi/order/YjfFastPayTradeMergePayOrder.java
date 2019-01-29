/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * xuyin@yiji.com 2016-11-23 15:46 创建
 *
 */
package com.yjf.esupplier.integration.openapi.order;

/**
 * 易极付新付款接口入参
 *
 * @author xuyin@yiji.com
 */
public class YjfFastPayTradeMergePayOrder extends PayOrder {
	
	private static final long	serialVersionUID	= -655752021094880724L;
	/** 买家外部会员ID*/
	private String				outUserId;
	/** 买家易极付会员ID*/
	private String				buyerUserId;
	/** 交易信息*/
	private String				tradeInfo;
	
	public String getOutUserId() {
		return outUserId;
	}
	
	public void setOutUserId(String outUserId) {
		this.outUserId = outUserId;
	}
	
	public String getBuyerUserId() {
		return buyerUserId;
	}
	
	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	
	public String getTradeInfo() {
		return tradeInfo;
	}
	
	public void setTradeInfo(String tradeInfo) {
		this.tradeInfo = tradeInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YjfFastPayTradeMergePayOrder [outUserId=");
		builder.append(outUserId);
		builder.append(", buyerUserId=");
		builder.append(buyerUserId);
		builder.append(", tradeInfo=");
		builder.append(tradeInfo);
		builder.append("]");
		return builder.toString();
	}
}
