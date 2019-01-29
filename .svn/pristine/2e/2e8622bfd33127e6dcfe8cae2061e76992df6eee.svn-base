package com.yjf.esupplier.ws.order;

public class TradeRepayOrder extends TradeProcessOrder {
	
	private static final long serialVersionUID = -2230192932430584158L;
	long repayPlanId;
	long repayUserId;
	
	public long getRepayPlanId() {
		return this.repayPlanId;
	}
	
	public void setRepayPlanId(long repayPlanId) {
		this.repayPlanId = repayPlanId;
	}
	
	public long getRepayUserId() {
		return this.repayUserId;
	}
	
	public void setRepayUserId(long repayUserId) {
		this.repayUserId = repayUserId;
	}
	
	@Override
	public void check() {
		validateHasZore(repayUserId, "还款人用户Id");
		super.check();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeRepayOrder [repayPlanId=");
		builder.append(repayPlanId);
		builder.append(", repayUserId=");
		builder.append(repayUserId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
