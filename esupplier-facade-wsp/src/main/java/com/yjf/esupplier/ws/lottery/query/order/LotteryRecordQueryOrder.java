package com.yjf.esupplier.ws.lottery.query.order;

import java.util.Date;

public class LotteryRecordQueryOrder {
	long instanceId;
	
	long userId;
	
	String userName;
	
	String realName;
	/**
	 * 抽奖开始时间
	 */
	Date beginCreateDate;
	/**
	 * 抽奖结束时间
	 */
	Date endCreateDate;
	
	public long getInstanceId() {
		return this.instanceId;
	}
	
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
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
	
	public Date getBeginCreateDate() {
		return this.beginCreateDate;
	}
	
	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return this.endCreateDate;
	}
	
	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryRecordQueryOrder [instanceId=");
		builder.append(instanceId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", beginCreateDate=");
		builder.append(beginCreateDate);
		builder.append(", endCreateDate=");
		builder.append(endCreateDate);
		builder.append("]");
		return builder.toString();
	}
	
}
