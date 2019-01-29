package com.yjf.esupplier.ws.lottery.order;

public class AddPrizeRuleOrder extends PrizeRuleBaseOrder {
	
	private static final long serialVersionUID = 1917090436120717808L;
	
	private long prizeRuleId;
	
	public long getPrizeRuleId() {
		return prizeRuleId;
	}
	
	public void setPrizeRuleId(long prizeRuleId) {
		this.prizeRuleId = prizeRuleId;
	}
}
