package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.esupplier.ws.enums.ExtPayTypeEnum;
import com.yjf.esupplier.ws.enums.ToCardFlowStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class ToCardFlowQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 8400698679642861157L;
	Date startTime;
	Date endTime;
	ToCardFlowStatusEnum status;
	ExtPayTypeEnum payType;
	String userName;
	long userId;
	private String bankAccountNo;
	
	private String bankAcountName;
	
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
	
	public ToCardFlowStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(ToCardFlowStatusEnum status) {
		this.status = status;
	}
	
	public ExtPayTypeEnum getPayType() {
		return this.payType;
	}
	
	public void setPayType(ExtPayTypeEnum payType) {
		this.payType = payType;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getBankAccountNo() {
		return this.bankAccountNo;
	}
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	public String getBankAcountName() {
		return this.bankAcountName;
	}
	
	public void setBankAcountName(String bankAcountName) {
		this.bankAcountName = bankAcountName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ToCardFlowQueryOrder [startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", payType=");
		builder.append(payType);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", bankAccountNo=");
		builder.append(bankAccountNo);
		builder.append(", bankAcountName=");
		builder.append(bankAcountName);
		builder.append("]");
		return builder.toString();
	}
	
}
