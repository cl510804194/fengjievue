package com.yjf.esupplier.ws.lottery.query.result;

import java.util.List;

import com.yjf.esupplier.ws.lottery.info.PrizeRuleDetailInfo;
import com.yjf.esupplier.ws.lottery.info.PrizeRuleInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class PrizeRuleResult extends EsupplierBaseResult {
	private static final long serialVersionUID = 2404771067618295439L;
	
	PrizeRuleInfo prizeRuleInfo;
	List<PrizeRuleDetailInfo> prizeRuleDetailInfos;
	
	public PrizeRuleInfo getPrizeRuleInfo() {
		return this.prizeRuleInfo;
	}
	
	public void setPrizeRuleInfo(PrizeRuleInfo prizeRuleInfo) {
		this.prizeRuleInfo = prizeRuleInfo;
	}
	
	public List<PrizeRuleDetailInfo> getPrizeRuleDetailInfos() {
		return this.prizeRuleDetailInfos;
	}
	
	public void setPrizeRuleDetailInfos(List<PrizeRuleDetailInfo> prizeRuleDetailInfos) {
		this.prizeRuleDetailInfos = prizeRuleDetailInfos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrizeRuleResult [prizeRuleInfo=");
		builder.append(prizeRuleInfo);
		builder.append(", prizeRuleDetailInfos=");
		builder.append(prizeRuleDetailInfos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
