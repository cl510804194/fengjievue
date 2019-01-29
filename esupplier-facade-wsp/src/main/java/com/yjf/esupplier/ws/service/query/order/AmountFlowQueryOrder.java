package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class AmountFlowQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 2656805185236453500L;
	long tradeId;
	Date startDate;
	Date endDate;
	private long inUserId;
	
	private long outUserId;
	
	private String amountOut;
	
	private String amountIn;
	
	private String inUserName;
	
	private String outUserName;
	
	private String inUserRealName;
	
	private String outUserRealName;
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public long getInUserId() {
		return this.inUserId;
	}
	
	public void setInUserId(long inUserId) {
		this.inUserId = inUserId;
	}
	
	public long getOutUserId() {
		return this.outUserId;
	}
	
	public void setOutUserId(long outUserId) {
		this.outUserId = outUserId;
	}
	
	public String getAmountOut() {
		return this.amountOut;
	}
	
	public void setAmountOut(String amountOut) {
		this.amountOut = amountOut;
	}
	
	public String getAmountIn() {
		return this.amountIn;
	}
	
	public void setAmountIn(String amountIn) {
		this.amountIn = amountIn;
	}
	
	public String getInUserName() {
		return this.inUserName;
	}
	
	public void setInUserName(String inUserName) {
		this.inUserName = inUserName;
	}
	
	public String getOutUserName() {
		return this.outUserName;
	}
	
	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}
	
	public String getInUserRealName() {
		return this.inUserRealName;
	}
	
	public void setInUserRealName(String inUserRealName) {
		this.inUserRealName = inUserRealName;
	}
	
	public String getOutUserRealName() {
		return this.outUserRealName;
	}
	
	public void setOutUserRealName(String outUserRealName) {
		this.outUserRealName = outUserRealName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AmountFlowQueryOrder [tradeId=");
		builder.append(tradeId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", inUserId=");
		builder.append(inUserId);
		builder.append(", outUserId=");
		builder.append(outUserId);
		builder.append(", amountOut=");
		builder.append(amountOut);
		builder.append(", amountIn=");
		builder.append(amountIn);
		builder.append(", inUserName=");
		builder.append(inUserName);
		builder.append(", outUserName=");
		builder.append(outUserName);
		builder.append(", inUserRealName=");
		builder.append(inUserRealName);
		builder.append(", outUserRealName=");
		builder.append(outUserRealName);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
