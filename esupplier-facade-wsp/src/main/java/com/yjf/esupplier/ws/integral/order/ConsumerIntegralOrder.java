package com.yjf.esupplier.ws.integral.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class ConsumerIntegralOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -4926692774065070420L;
	long userId;
	long pointValue;
	
	public ConsumerIntegralOrder() {
		
	}
	
	public ConsumerIntegralOrder(long userId, long pointValue) {
		super();
		this.userId = userId;
		this.pointValue = pointValue;
	}
	
	@Override
	public void check() {
		validateHasZore(userId, "用户id");
		validateHasZore(pointValue, "用户积分值");
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getPointValue() {
		return this.pointValue;
	}
	
	public void setPointValue(long pointValue) {
		this.pointValue = pointValue;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsumerIntegralOrder [userId=");
		builder.append(userId);
		builder.append(", pointValue=");
		builder.append(pointValue);
		builder.append("]");
		return builder.toString();
	}
	
}
