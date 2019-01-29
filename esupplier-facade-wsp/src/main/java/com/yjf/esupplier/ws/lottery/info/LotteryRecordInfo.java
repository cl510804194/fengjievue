package com.yjf.esupplier.ws.lottery.info;

import java.io.Serializable;
import java.util.Date;

public class LotteryRecordInfo implements Serializable {
	
	private static final long serialVersionUID = 3054018972853476833L;
	/**
	 * 主键id
	 */
	private long recordId;
	/**
	 * 活动id
	 */
	private long activityId;
	/**
	 * 活动事例id
	 */
	private long instanceId;
	/**
	 * 外部订单号，用作唯一标识
	 */
	private String outBizNo;
	/**
	 * 抽奖用户
	 */
	private long userId;
	/**
	 * 用户名
	 */
	private long userName;
	/**
	 * 真实姓名
	 */
	private long realName;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getRecordId() {
		return this.recordId;
	}
	
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	
	public long getActivityId() {
		return this.activityId;
	}
	
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	
	public long getInstanceId() {
		return this.instanceId;
	}
	
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getUserName() {
		return this.userName;
	}
	
	public void setUserName(long userName) {
		this.userName = userName;
	}
	
	public long getRealName() {
		return this.realName;
	}
	
	public void setRealName(long realName) {
		this.realName = realName;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryRecordInfo [recordId=");
		builder.append(recordId);
		builder.append(", activityId=");
		builder.append(activityId);
		builder.append(", instanceId=");
		builder.append(instanceId);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", realName=");
		builder.append(realName);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
