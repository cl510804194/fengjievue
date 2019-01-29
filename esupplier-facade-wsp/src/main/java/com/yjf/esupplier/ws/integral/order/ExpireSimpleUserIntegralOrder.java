package com.yjf.esupplier.ws.integral.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

import java.util.Date;

public class ExpireSimpleUserIntegralOrder extends ProcessOrder {
	private static final long serialVersionUID = -4229320233616374870L;
	long userId;
	long pointsRuleId;
	private Date startTime;

	private Date endTime;
	public ExpireSimpleUserIntegralOrder() {
		
	}
	
	public ExpireSimpleUserIntegralOrder(long userId, long pointsRuleId) {
		this.userId = userId;
		this.pointsRuleId = pointsRuleId;
	}
	
	@Override
	public void check() {
		super.check();
		validateHasZore(userId, "用户id");
		validateHasZore(pointsRuleId, "积分规则id");
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getPointsRuleId() {
		return this.pointsRuleId;
	}
	
	public void setPointsRuleId(long pointsRuleId) {
		this.pointsRuleId = pointsRuleId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpireSimpleUserIntegralOrder [userId=");
		builder.append(userId);
		builder.append(", pointsRuleId=");
		builder.append(pointsRuleId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
