package com.yjf.esupplier.ws.lottery.order;

import org.springframework.util.Assert;

import com.yjf.esupplier.ws.lottery.enums.LotteryConditionTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryTimesTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class LotteryConditionOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -9072320702350701395L;
	
	/**
	 * 条件类型
	 */
	private LotteryConditionTypeEnum lotteryConditionType;
	/**
	 * 条件值
	 */
	private String conditionValue;
	/**
	 * 次数限制
	 */
	private LotteryTimesTypeEnum lotteryTimesType;
	/**
	 * 项目期间（开始值）
	 */
	private int startPeriod = -1;
	/**
	 * 项目期间（结束值）
	 */
	private int endPeriod = -1;
	
	/**
	 * 次数
	 */
	private long time;
	
	@Override
	public void check() {
		super.check();
		validateNotNull(lotteryConditionType, "抽奖条件");
		validateNotNull(lotteryTimesType, "次数限制类型");
		validateHasZore(time, "次数");
		if (lotteryConditionType == LotteryConditionTypeEnum.INVESTMENT) {
			validateNotNull(conditionValue, "抽奖条件值");
		}
		Assert.isTrue(endPeriod >= startPeriod, "结束项目期间，不能小于开始项目期间");
	}
	
	public LotteryConditionTypeEnum getLotteryConditionType() {
		return this.lotteryConditionType;
	}
	
	public void setLotteryConditionType(LotteryConditionTypeEnum lotteryConditionType) {
		this.lotteryConditionType = lotteryConditionType;
	}
	
	public String getConditionValue() {
		return this.conditionValue;
	}
	
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}
	
	public LotteryTimesTypeEnum getLotteryTimesType() {
		return this.lotteryTimesType;
	}
	
	public void setLotteryTimesType(LotteryTimesTypeEnum lotteryTimesType) {
		this.lotteryTimesType = lotteryTimesType;
	}
	
	public long getTime() {
		return this.time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public int getStartPeriod() {
		return this.startPeriod;
	}
	
	public void setStartPeriod(int startPeriod) {
		this.startPeriod = startPeriod;
	}
	
	public int getEndPeriod() {
		return this.endPeriod;
	}
	
	public void setEndPeriod(int endPeriod) {
		this.endPeriod = endPeriod;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryConditionOrder [lotteryConditionType=");
		builder.append(lotteryConditionType);
		builder.append(", conditionValue=");
		builder.append(conditionValue);
		builder.append(", lotteryTimesType=");
		builder.append(lotteryTimesType);
		builder.append(", startPeriod=");
		builder.append(startPeriod);
		builder.append(", endPeriod=");
		builder.append(endPeriod);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}
	
}
