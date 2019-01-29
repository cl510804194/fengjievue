package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.AmountFlowEnum;

public class AmountFlowTradeVOInfo implements Serializable {
	private static final long serialVersionUID = 7779515640601578769L;
	
	private long amountFlowId;
	
	private String flowCode;
	
	private long inUserId;
	
	private long outUserId;
	
	private String amountOut;
	
	private String amountIn;
	
	private String inUserName;
	
	private String outUserName;
	
	private String inUserRealName;
	
	private String outUserRealName;
	
	private Money amount = new Money(0, 0);
	
	private boolean status;
	
	private AmountFlowEnum amountFlowType;
	
	private String note;
	
	private Date rawUpdateTime;
	
	private Date rawAddTime;
	
	/**
	 * 交易id
	 */
	private final long tradeId = 0;
	
	/**
	 * 子交易ID
	 */
	private final long tradeDetailId = 0;
	
	public long getAmountFlowId() {
		return this.amountFlowId;
	}
	
	public void setAmountFlowId(long amountFlowId) {
		this.amountFlowId = amountFlowId;
	}
	
	public String getFlowCode() {
		return this.flowCode;
	}
	
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
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
	
	public boolean isStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public AmountFlowEnum getAmountFlowType() {
		return this.amountFlowType;
	}
	
	public void setAmountFlowType(AmountFlowEnum amountFlowType) {
		this.amountFlowType = amountFlowType;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AmountFlowTradeVOInfo [amountFlowId=");
		builder.append(amountFlowId);
		builder.append(", flowCode=");
		builder.append(flowCode);
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
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", amountFlowType=");
		builder.append(amountFlowType);
		builder.append(", note=");
		builder.append(note);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append("]");
		return builder.toString();
	}
	
}
