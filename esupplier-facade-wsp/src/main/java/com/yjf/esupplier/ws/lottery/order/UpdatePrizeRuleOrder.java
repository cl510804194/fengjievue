package com.yjf.esupplier.ws.lottery.order;

public class UpdatePrizeRuleOrder extends PrizeRuleBaseOrder {
	
	private static final long serialVersionUID = 4163774854092990407L;
	
	private long prizeRuleId;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(prizeRuleId, "抽奖规则id");
	}
	
	public long getPrizeRuleId() {
		return this.prizeRuleId;
	}
	
	public void setPrizeRuleId(long prizeRuleId) {
		this.prizeRuleId = prizeRuleId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdatePrizeRuleOrder [prizeRuleId=");
		builder.append(prizeRuleId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
