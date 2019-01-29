package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.AmountFlowEnum;

public class DivisionDetailInfo implements Serializable {
	private static final long serialVersionUID = -6161750260678417257L;
	
	private long detailId;
	
	private String businessCode;
	
	private long userId;
	
	private String userName;
	
	private String realName;
	
	private long tradeId;
	
	private Money amount = new Money(0, 0);
	
	private boolean divisionStatus;
	
	private Date divisionDate;
	
	private long tradeDetailId;
	
	private String note;
	
	private String outUserName;
	
	private String outRealName;
	/**
	 * 流水类型
	 */
	private AmountFlowEnum flowType;
	
	public long getDetailId() {
		return this.detailId;
	}
	
	public void setDetailId(long detailId) {
		this.detailId = detailId;
	}
	
	public String getBusinessCode() {
		return this.businessCode;
	}
	
	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public long getTradeId() {
		return this.tradeId;
	}
	
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public boolean isDivisionStatus() {
		return this.divisionStatus;
	}
	
	public void setDivisionStatus(boolean divisionStatus) {
		this.divisionStatus = divisionStatus;
	}
	
	public Date getDivisionDate() {
		return this.divisionDate;
	}
	
	public void setDivisionDate(Date divisionDate) {
		this.divisionDate = divisionDate;
	}
	
	public long getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(long tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public String getOutUserName() {
		return this.outUserName;
	}
	
	public void setOutUserName(String outUserName) {
		this.outUserName = outUserName;
	}
	
	public String getOutRealName() {
		return this.outRealName;
	}
	
	public void setOutRealName(String outRealName) {
		this.outRealName = outRealName;
	}
	
	public AmountFlowEnum getFlowType() {
		return this.flowType;
	}
	
	public void setFlowType(AmountFlowEnum flowType) {
		this.flowType = flowType;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DivisionDetailInfo [detailId=");
		builder.append(detailId);
		builder.append(", businessCode=");
		builder.append(businessCode);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", divisionStatus=");
		builder.append(divisionStatus);
		builder.append(", divisionDate=");
		builder.append(divisionDate);
		builder.append(", tradeDetailId=");
		builder.append(tradeDetailId);
		builder.append(", note=");
		builder.append(note);
		builder.append(", outUserName=");
		builder.append(outUserName);
		builder.append(", outRealName=");
		builder.append(outRealName);
		builder.append(", flowType=");
		builder.append(flowType);
		builder.append("]");
		return builder.toString();
	}
	
}
