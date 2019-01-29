package com.yjf.esupplier.ws.lottery.order;

import org.springframework.util.Assert;

import com.yjf.esupplier.ws.lottery.enums.PrizeTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class PrizeRuleDetailOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 5203059664803764548L;
	
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
	
	@Override
	public void check() {
		validateHasText(awards, "奖项");
		validateHasText(prizeName, "奖品名称");
		validateNotNull(prizeType, "奖品类型");
		if (prizeType == PrizeTypeEnum.PHYSICAL) {
			validateGreaterThan(prizeNum, "奖品数量");
		} else {
			validateGreaterThan(prizeAmount, "面额");
		}
		Assert.isTrue(prizeNum > 0 || probability > 0, "数量和概率不能都为0");
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
	
	public long getPrizeNum() {
		return this.prizeNum;
	}
	
	public void setPrizeNum(long prizeNum) {
		this.prizeNum = prizeNum;
	}
	
	public double getProbability() {
		return this.probability;
	}
	
	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PrizeRuleDetailOrder [seqNum=");
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
		builder.append("]");
		return builder.toString();
	}
	
}
