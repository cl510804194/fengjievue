package com.yjf.esupplier.ws.lottery.data;

import java.io.Serializable;
import java.util.Date;

public class PrizeRuleData implements Serializable {
	
	private static final long serialVersionUID = -3721788704436310951L;
	/**
	 * 主键id
	 */
	private long prizeRuleId;
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
	 * 未中奖个数
	 */
	private long notWinningNum;
	/**
	 * 描述
	 */
	private String description;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
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
	
	public long getNotWinningNum() {
		return this.notWinningNum;
	}
	
	public void setNotWinningNum(long notWinningNum) {
		this.notWinningNum = notWinningNum;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
		builder.append("PrizeRuleData [prizeRuleId=");
		builder.append(prizeRuleId);
		builder.append(", prizeRuleName=");
		builder.append(prizeRuleName);
		builder.append(", winningRate=");
		builder.append(winningRate);
		builder.append(", prizeNum=");
		builder.append(prizeNum);
		builder.append(", notWinningNum=");
		builder.append(notWinningNum);
		builder.append(", description=");
		builder.append(description);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
