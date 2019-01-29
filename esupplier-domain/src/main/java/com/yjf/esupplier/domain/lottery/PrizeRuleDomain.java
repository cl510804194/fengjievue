package com.yjf.esupplier.domain.lottery;

import java.util.List;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.lottery.data.PrizeRuleData;

public class PrizeRuleDomain extends PrizeRuleData implements Domain {
	
	private static final long serialVersionUID = -3761043809476083552L;
	
	List<PrizeRuleDetailDomain> prizeRuleDetailDomains;
	
	public List<PrizeRuleDetailDomain> getPrizeRuleDetailDomains() {
		return this.prizeRuleDetailDomains;
	}
	
	public void setPrizeRuleDetailDomains(List<PrizeRuleDetailDomain> prizeRuleDetailDomains) {
		this.prizeRuleDetailDomains = prizeRuleDetailDomains;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrizeRuleDomain [prizeRuleDetailDomains=");
		builder.append(prizeRuleDetailDomains);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void examSelf() throws Exception {
	}
	
}
