package com.yjf.esupplier.ws.lottery.query.result;

import java.util.List;

import com.yjf.esupplier.ws.lottery.info.LotteryActivityInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class LotteryResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -4057035912380656649L;
	LotteryActivityInfo lotteryActivityInfo;
	List<LotteryActivityInfo> lotteryActivityInfos;
	
	public LotteryActivityInfo getLotteryActivityInfo() {
		return this.lotteryActivityInfo;
	}
	
	public void setLotteryActivityInfo(LotteryActivityInfo lotteryActivityInfo) {
		this.lotteryActivityInfo = lotteryActivityInfo;
	}
	
	public List<LotteryActivityInfo> getLotteryActivityInfos() {
		return this.lotteryActivityInfos;
	}
	
	public void setLotteryActivityInfos(List<LotteryActivityInfo> lotteryActivityInfos) {
		this.lotteryActivityInfos = lotteryActivityInfos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryResult [lotteryActivityInfo=");
		builder.append(lotteryActivityInfo);
		builder.append(", lotteryActivityInfos=");
		builder.append(lotteryActivityInfos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
