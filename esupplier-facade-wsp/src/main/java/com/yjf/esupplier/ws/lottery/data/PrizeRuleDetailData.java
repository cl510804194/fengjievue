package com.yjf.esupplier.ws.lottery.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.lottery.enums.PrizeTypeEnum;

public class PrizeRuleDetailData implements Serializable {
	private static final long serialVersionUID = 4599581087418277400L;
	/**
	 * 规则明细id
	 */
	private long prizeRuleDetailId;
	/**
	 * 所属规则id
	 */
	private long prizeRuleId;
	/**
	 * 序号
	 */
	private long seqNum;
	/**
	 * 奖项
	 */
	private String awards;
	/**
	 * 奖品名称
	 */
	private String prizeName;
	/**
	 * 奖品类型
	 */
	private PrizeTypeEnum prizeType;
	/**
	 * 奖品数量
	 */
	private long prizeNum;
	/**
	 * 面额
	 */
	private double prizeAmount;
	/**
	 * 产品图标
	 */
	private String prizeImage;
	/**
	 * 中奖概率
	 */
	private double probability;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 备注
	 */
	private String memo;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getPrizeRuleDetailId() {
		return this.prizeRuleDetailId;
	}
	
	public void setPrizeRuleDetailId(long prizeRuleDetailId) {
		this.prizeRuleDetailId = prizeRuleDetailId;
	}
	
	public long getPrizeRuleId() {
		return this.prizeRuleId;
	}
	
	public void setPrizeRuleId(long prizeRuleId) {
		this.prizeRuleId = prizeRuleId;
	}
	
	public long getSeqNum() {
		return this.seqNum;
	}
	
	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}
	
	public String getAwards() {
		return this.awards;
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	public String getPrizeName() {
		return this.prizeName;
	}
	
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	
	public PrizeTypeEnum getPrizeType() {
		return this.prizeType;
	}
	
	public void setPrizeType(PrizeTypeEnum prizeType) {
		this.prizeType = prizeType;
	}
	
	public long getPrizeNum() {
		return this.prizeNum;
	}
	
	public void setPrizeNum(long prizeNum) {
		this.prizeNum = prizeNum;
	}
	
	public double getPrizeAmount() {
		return this.prizeAmount;
	}
	
	public void setPrizeAmount(double prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	
	public String getPrizeImage() {
		return this.prizeImage;
	}
	
	public void setPrizeImage(String prizeImage) {
		this.prizeImage = prizeImage;
	}
	
	public double getProbability() {
		return this.probability;
	}
	
	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
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
		builder.append("PrizeRuleDetailData [prizeRuleDetailId=");
		builder.append(prizeRuleDetailId);
		builder.append(", prizeRuleId=");
		builder.append(prizeRuleId);
		builder.append(", seqNum=");
		builder.append(seqNum);
		builder.append(", awards=");
		builder.append(awards);
		builder.append(", prizeName=");
		builder.append(prizeName);
		builder.append(", prizeType=");
		builder.append(prizeType);
		builder.append(", prizeNum=");
		builder.append(prizeNum);
		builder.append(", prizeAmount=");
		builder.append(prizeAmount);
		builder.append(", prizeImage=");
		builder.append(prizeImage);
		builder.append(", probability=");
		builder.append(probability);
		builder.append(", description=");
		builder.append(description);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
