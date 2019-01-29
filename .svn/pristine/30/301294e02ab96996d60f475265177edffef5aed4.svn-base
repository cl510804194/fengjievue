package com.yjf.esupplier.domain.lottery;

import java.util.List;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.lottery.data.LotteryActivityInstanceData;

public class LotteryActivityInstanceDomain extends LotteryActivityInstanceData implements Domain {
	
	private static final long serialVersionUID = 1151897881799031491L;
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
	
}
