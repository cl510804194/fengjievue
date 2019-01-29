package com.yjf.esupplier.ws.lottery.info;

import java.util.List;

import com.yjf.esupplier.ws.lottery.data.PrizeRuleData;

public class PrizeRuleInfo extends PrizeRuleData {
	
	private static final long serialVersionUID = 8641413744648416020L;
	List<PrizeRuleDetailInfo> ruleDetailInfos;
	
	public List<PrizeRuleDetailInfo> getRuleDetailInfos() {
		return this.ruleDetailInfos;
	}
	
	public void setRuleDetailInfos(List<PrizeRuleDetailInfo> ruleDetailInfos) {
		this.ruleDetailInfos = ruleDetailInfos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrizeRuleInfo [ruleDetailInfos=");
		builder.append(ruleDetailInfos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
