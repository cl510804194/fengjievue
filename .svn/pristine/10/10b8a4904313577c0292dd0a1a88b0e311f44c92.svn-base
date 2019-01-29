package com.yjf.esupplier.ws.lottery.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.lottery.enums.LotteryConditionTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryTimesTypeEnum;

public class LotteryConditionData implements Serializable {
	private static final long serialVersionUID = 591466323835671766L;
	/**
	 * 主键id
	 */
	private long lotteryConditionId;
	/**
	 * 活动id
	 */
	private long lotteryId;
	/**
	 * 条件序号
	 */
	private long seqNum;
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
	 * 次数
	 */
	private long time;
	
	/**
	 * 项目期间（开始值）
	 */
	private int startPeriod = -1;
	/**
	 * 项目期间（结束值）
	 */
	private int endPeriod = -1;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getLotteryConditionId() {
		return this.lotteryConditionId;
	}
	
	public void setLotteryConditionId(long lotteryConditionId) {
		this.lotteryConditionId = lotteryConditionId;
	}
	
	public long getLotteryId() {
		return this.lotteryId;
	}
	
	public void setLotteryId(long lotteryId) {
		this.lotteryId = lotteryId;
	}
	
	public long getSeqNum() {
		return this.seqNum;
	}
	
	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
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
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
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
		builder.append("LotteryConditionData [lotteryConditionId=");
		builder.append(lotteryConditionId);
		builder.append(", lotteryId=");
		builder.append(lotteryId);
		builder.append(", seqNum=");
		builder.append(seqNum);
		builder.append(", lotteryConditionType=");
		builder.append(lotteryConditionType);
		builder.append(", conditionValue=");
		builder.append(conditionValue);
		builder.append(", lotteryTimesType=");
		builder.append(lotteryTimesType);
		builder.append(", time=");
		builder.append(time);
		builder.append(", startPeriod=");
		builder.append(startPeriod);
		builder.append(", endPeriod=");
		builder.append(endPeriod);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
