package com.yjf.esupplier.ws.lottery.query.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class PrizeRuleQueryOrder extends QueryPageBase {
	private static final long serialVersionUID = 8020213516362724195L;
	String prizeRuleName;
	
	public String getPrizeRuleName() {
		return this.prizeRuleName;
	}
	
	public void setPrizeRuleName(String prizeRuleName) {
		this.prizeRuleName = prizeRuleName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrizeRuleQueryOrder [prizeRuleName=");
		builder.append(prizeRuleName);
		builder.append("]");
		return builder.toString();
	}
	
}
