package com.yjf.esupplier.ws.lottery.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.lottery.enums.LotteryTypeEnum;

public class LotteryActivityInstanceData extends LotteryActivityData implements Serializable {
	
	private static final long serialVersionUID = 2881213760396707901L;
	/**
	 * 主键id
	 */
	private long instanceId;
	/**
	 * 活动id
	 */
	private long activityId;
	/**
	 * 活动名称
	 */
	private String name;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 活动类型
	 */
	private LotteryTypeEnum lotteryType;
	/**
	 * 条件开始时间
	 */
	private Date conditionBeginDate;
	/**
	 * 条件结束时间
	 */
	private Date conditionEndDate;
	/**
	 * 奖品设置id
	 */
	private long prizeRuleId;
	/**
	 * 奖品设置模版名称
	 */
	private String prizeRuleName;
	/**
	 * 活动人数
	 */
	private long peopleNum;
	/**
	 * 已抽奖人数
	 */
	private long lotteryNum;
	/**
	 * 剩余抽奖数据
	 */
	private long surplusNum;
	/**
	 * 剩余奖项
	 */
	private long tobeWinnerNum;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getInstanceId() {
		return this.instanceId;
	}
	
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}
	
	public long getActivityId() {
		return this.activityId;
	}
	
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Date getStartTime() {
		return this.startTime;
	}
	
	@Override
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public Date getEndTime() {
		return this.endTime;
	}
	
	@Override
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public LotteryTypeEnum getLotteryType() {
		return this.lotteryType;
	}
	
	@Override
	public void setLotteryType(LotteryTypeEnum lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	@Override
	public Date getConditionBeginDate() {
		return this.conditionBeginDate;
	}
	
	@Override
	public void setConditionBeginDate(Date conditionBeginDate) {
		this.conditionBeginDate = conditionBeginDate;
	}
	
	@Override
	public Date getConditionEndDate() {
		return this.conditionEndDate;
	}
	
	@Override
	public void setConditionEndDate(Date conditionEndDate) {
		this.conditionEndDate = conditionEndDate;
	}
	
	@Override
	public long getPrizeRuleId() {
		return this.prizeRuleId;
	}
	
	@Override
	public void setPrizeRuleId(long prizeRuleId) {
		this.prizeRuleId = prizeRuleId;
	}
	
	@Override
	public String getPrizeRuleName() {
		return this.prizeRuleName;
	}
	
	@Override
	public void setPrizeRuleName(String prizeRuleName) {
		this.prizeRuleName = prizeRuleName;
	}
	
	@Override
	public long getPeopleNum() {
		return this.peopleNum;
	}
	
	@Override
	public void setPeopleNum(long peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	public long getLotteryNum() {
		return this.lotteryNum;
	}
	
	public void setLotteryNum(long lotteryNum) {
		this.lotteryNum = lotteryNum;
	}
	
	public long getSurplusNum() {
		return this.surplusNum;
	}
	
	public void setSurplusNum(long surplusNum) {
		this.surplusNum = surplusNum;
	}
	
	public long getTobeWinnerNum() {
		return this.tobeWinnerNum;
	}
	
	public void setTobeWinnerNum(long tobeWinnerNum) {
		this.tobeWinnerNum = tobeWinnerNum;
	}
	
	@Override
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	@Override
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	@Override
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	@Override
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryActivityInstanceData [instanceId=");
		builder.append(instanceId);
		builder.append(", activityId=");
		builder.append(activityId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", lotteryType=");
		builder.append(lotteryType);
		builder.append(", conditionBeginDate=");
		builder.append(conditionBeginDate);
		builder.append(", conditionEndDate=");
		builder.append(conditionEndDate);
		builder.append(", prizeRuleId=");
		builder.append(prizeRuleId);
		builder.append(", prizeRuleName=");
		builder.append(prizeRuleName);
		builder.append(", peopleNum=");
		builder.append(peopleNum);
		builder.append(", lotteryNum=");
		builder.append(lotteryNum);
		builder.append(", surplusNum=");
		builder.append(surplusNum);
		builder.append(", tobeWinnerNum=");
		builder.append(tobeWinnerNum);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
