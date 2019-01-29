package com.yjf.esupplier.ws.lottery.query.result;

import java.util.List;

import com.yjf.esupplier.ws.lottery.info.LotteryConditionInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class LotteryConditionResult extends EsupplierBaseResult {
	private static final long serialVersionUID = -6554276568108807051L;
	
	List<LotteryConditionInfo> conditionInfos;
	
	public List<LotteryConditionInfo> getConditionInfos() {
		return this.conditionInfos;
	}
	
	public void setConditionInfos(List<LotteryConditionInfo> conditionInfos) {
		this.conditionInfos = conditionInfos;
	}
	
}
