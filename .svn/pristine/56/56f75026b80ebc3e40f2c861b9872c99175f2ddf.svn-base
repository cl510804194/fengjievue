package com.yjf.esupplier.ws.lottery.order;

import java.util.Date;
import java.util.List;

import org.springframework.util.Assert;

import com.yjf.esupplier.ws.lottery.enums.LotteryTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class LotteryActivityBaseOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -2782976729084925871L;
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
	 * 抽奖条件
	 */
	List<LotteryConditionOrder> conditionOrders;
	
	@Override
	public void check() {
		validateHasText(name, "活动名称");
		validateNotNull(startTime, "活动开始时间");
		validateNotNull(endTime, "活动结束时间");
		Assert.isTrue(startTime.getTime() <= endTime.getTime(), "活动开始时间小于活动结束时间");
		validateNotNull(lotteryType, "活动类型");
		if (lotteryType == LotteryTypeEnum.LOTTERY) {
			validateNotNull(conditionOrders, "活动条件");
			for (LotteryConditionOrder conditionOrder : conditionOrders) {
				conditionOrder.check();
			}
		} else {
			validateHasZore(peopleNum, "人数");
		}
		
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
	
	public List<LotteryConditionOrder> getConditionOrders() {
		return this.conditionOrders;
	}
	
	public void setConditionOrders(List<LotteryConditionOrder> conditionOrders) {
		this.conditionOrders = conditionOrders;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LotteryActivityBaseOrder [name=");
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
		builder.append(", conditionOrders=");
		builder.append(conditionOrders);
		builder.append("]");
		return builder.toString();
	}
	
}
