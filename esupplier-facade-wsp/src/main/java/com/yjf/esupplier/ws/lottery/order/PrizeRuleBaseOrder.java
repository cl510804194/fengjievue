package com.yjf.esupplier.ws.lottery.order;

import java.util.List;

import org.springframework.util.Assert;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class PrizeRuleBaseOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 5923499626544659231L;
	
	/**
	 * 规则名称
	 */
	private String prizeRuleName;
	/**
	 * 中奖率
	 */
	private double winningRate;
	/**
	 * 总共可抽奖数
	 */
	private long prizeNum;
	/**
	 * 描述
	 */
	private String description;
	
	List<PrizeRuleDetailOrder> prizeRuleDetailOrders;
	
	@Override
	public void check() {
		validateHasText(prizeRuleName, "奖品设置名称");
		validateGreaterThan(winningRate, "中奖率");
		validateGreaterThan(prizeNum, "可抽奖数");
		validateNotNull(prizeRuleDetailOrders, "奖品规则");
		Assert.isTrue(prizeNum <= 100000, "可抽奖总数不能大于10万");
		for (PrizeRuleDetailOrder ruleDetailOrder : prizeRuleDetailOrders) {
			ruleDetailOrder.check();
		}
	}
	
	public String getPrizeRuleName() {
		return this.prizeRuleName;
	}
	
	public void setPrizeRuleName(String prizeRuleName) {
		this.prizeRuleName = prizeRuleName;
	}
	
	public double getWinningRate() {
		return this.winningRate;
	}
	
	public void setWinningRate(double winningRate) {
		this.winningRate = winningRate;
	}
	
	public long getPrizeNum() {
		return this.prizeNum;
	}
	
	public void setPrizeNum(long prizeNum) {
		this.prizeNum = prizeNum;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<PrizeRuleDetailOrder> getPrizeRuleDetailOrders() {
		return this.prizeRuleDetailOrders;
	}
	
	public void setPrizeRuleDetailOrders(List<PrizeRuleDetailOrder> prizeRuleDetailOrders) {
		this.prizeRuleDetailOrders = prizeRuleDetailOrders;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrizeRuleBaseOrder [prizeRuleName=");
		builder.append(prizeRuleName);
		builder.append(", winningRate=");
		builder.append(winningRate);
		builder.append(", prizeNum=");
		builder.append(prizeNum);
		builder.append(", description=");
		builder.append(description);
		builder.append(", prizeRuleDetailOrders=");
		builder.append(prizeRuleDetailOrders);
		builder.append("]");
		return builder.toString();
	}
	
}
