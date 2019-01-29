package com.yjf.esupplier.domain.lottery;

import java.util.List;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.lottery.data.LotteryActivityData;

public class LotteryActivityDomain extends LotteryActivityData implements Domain {
	
	private static final long serialVersionUID = 7692223198512310457L;
	
	List<LotteryConditionDomain> lotteryConditionDomains;
	
	public List<LotteryConditionDomain> getLotteryConditionDomains() {
		return this.lotteryConditionDomains;
	}
	
	public void setLotteryConditionDomains(List<LotteryConditionDomain> lotteryConditionDomains) {
		this.lotteryConditionDomains = lotteryConditionDomains;
	}
	
	@Override
	public void examSelf() throws Exception {
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryActivityDomain [lotteryConditionDomains=");
		builder.append(lotteryConditionDomains);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
