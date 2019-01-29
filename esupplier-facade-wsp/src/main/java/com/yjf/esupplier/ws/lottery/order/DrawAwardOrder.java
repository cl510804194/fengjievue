package com.yjf.esupplier.ws.lottery.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

public class DrawAwardOrder extends ProcessOrder {
	private static final long serialVersionUID = -5763789430888459805L;
	/**
	 * 活动事例id
	 */
	long lotteryActivityInstanceId;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(lotteryActivityInstanceId, "活动事例id");
		validateHasZore(this.processorId, "抽奖id");
	}
	
	public long getLotteryActivityInstanceId() {
		return this.lotteryActivityInstanceId;
	}
	
	public void setLotteryActivityInstanceId(long lotteryActivityInstanceId) {
		this.lotteryActivityInstanceId = lotteryActivityInstanceId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrawAwardOrder [lotteryActivityInstanceId=");
		builder.append(lotteryActivityInstanceId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
