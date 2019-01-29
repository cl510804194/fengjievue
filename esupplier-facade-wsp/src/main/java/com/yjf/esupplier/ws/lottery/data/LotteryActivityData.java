package com.yjf.esupplier.ws.lottery.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.lottery.enums.LotteryActivityStatusEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryTypeEnum;

public class LotteryActivityData implements Serializable {
	private static final long serialVersionUID = 3387022860027786018L;
	/**
	 * 主键id
	 */
	private long id;
	/**
	 * 活动名称
	 */
	private String name;
	/**
	 * 活动开始时间
	 */
	private Date startTime;
	/**
	 * 活动结束时间
	 */
	private Date endTime;
	/**
	 * 活动类型
	 */
	private LotteryTypeEnum lotteryType;
	/**
	 * 参加活动的条件开始时间
	 */
	private Date conditionBeginDate;
	/**
	 * 参加活动的条件结束开始时间
	 */
	private Date conditionEndDate;
	/**
	 * 产品设置id
	 */
	private long prizeRuleId;
	/**
	 * 产品设置名称
	 */
	private String prizeRuleName;
	/**
	 * 参加报名人数
	 */
	private long peopleNum;
	/**
	 * 活动状态
	 */
	private LotteryActivityStatusEnum status;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public LotteryTypeEnum getLotteryType() {
		return this.lotteryType;
	}
	
	public void setLotteryType(LotteryTypeEnum lotteryType) {
		this.lotteryType = lotteryType;
	}
	
	public Date getConditionBeginDate() {
		return this.conditionBeginDate;
	}
	
	public void setConditionBeginDate(Date conditionBeginDate) {
		this.conditionBeginDate = conditionBeginDate;
	}
	
	public Date getConditionEndDate() {
		return this.conditionEndDate;
	}
	
	public void setConditionEndDate(Date conditionEndDate) {
		this.conditionEndDate = conditionEndDate;
	}
	
	public long getPrizeRuleId() {
		return this.prizeRuleId;
	}
	
	public void setPrizeRuleId(long prizeRuleId) {
		this.prizeRuleId = prizeRuleId;
	}
	
	public String getPrizeRuleName() {
		return this.prizeRuleName;
	}
	
	public void setPrizeRuleName(String prizeRuleName) {
		this.prizeRuleName = prizeRuleName;
	}
	
	public long getPeopleNum() {
		return this.peopleNum;
	}
	
	public void setPeopleNum(long peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	public LotteryActivityStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(LotteryActivityStatusEnum status) {
		this.status = status;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryActivityData [id=");
		builder.append(id);
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
		builder.append(", status=");
		builder.append(status);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
