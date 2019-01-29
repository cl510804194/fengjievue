package com.yjf.esupplier.ws.lottery.info;

import com.yjf.esupplier.ws.lottery.data.LotteryWinnerData;

/**
 * User: wqh Date: 2015/3/26 19:02
 */
public class LotteryWinnerInfo extends LotteryWinnerData {
	private PrizeRuleDetailInfo prizeRuleDetailInfo;
	
	public PrizeRuleDetailInfo getPrizeRuleDetailInfo() {
		return prizeRuleDetailInfo;
	}
	
	public void setPrizeRuleDetailInfo(PrizeRuleDetailInfo prizeRuleDetailInfo) {
		this.prizeRuleDetailInfo = prizeRuleDetailInfo;
	}
}
