package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.PayTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class RechargeFlowOrder extends QueryPageBase {
	private static final long serialVersionUID = 8400698679642861157L;
	Date startTime;
	Date endTime;
	String status;
	String accountId;
	PayTypeEnum payType;
	String userName;
	BooleanEnum isTradeRedundancy;
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public PayTypeEnum getPayType() {
		return this.payType;
	}
	
	public void setPayType(PayTypeEnum payType) {
		this.payType = payType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public BooleanEnum getIsTradeRedundancy() {
		return this.isTradeRedundancy;
	}
	
	public void setIsTradeRedundancy(BooleanEnum isTradeRedundancy) {
		this.isTradeRedundancy = isTradeRedundancy;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RechargeFlowOrder [startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", accountId=");
		builder.append(accountId);
		builder.append("]");
		return builder.toString();
	}
	
}
