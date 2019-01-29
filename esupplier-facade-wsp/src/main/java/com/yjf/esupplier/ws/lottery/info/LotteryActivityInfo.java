package com.yjf.esupplier.ws.lottery.info;

import java.util.List;

import com.yjf.esupplier.ws.lottery.data.LotteryActivityData;

public class LotteryActivityInfo extends LotteryActivityData {
	
	private static final long serialVersionUID = 2630318507433912079L;
	
	List<LotteryConditionInfo> conditionInfos;
	/**
	 * 活动开始事例就有值
	 */
	long lotteryActivityInstanceId;
	
	public List<LotteryConditionInfo> getConditionInfos() {
		return this.conditionInfos;
	}
	
	public void setConditionInfos(List<LotteryConditionInfo> conditionInfos) {
		this.conditionInfos = conditionInfos;
	}
	
	public long getLotteryActivityInstanceId() {
		return this.lotteryActivityInstanceId;
	}
	
	public void setLotteryActivityInstanceId(long lotteryActivityInstanceId) {
		this.lotteryActivityInstanceId = lotteryActivityInstanceId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryActivityInfo [conditionInfos=");
		builder.append(conditionInfos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
