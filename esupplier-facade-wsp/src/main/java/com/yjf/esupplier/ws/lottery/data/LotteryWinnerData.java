package com.yjf.esupplier.ws.lottery.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.lottery.enums.PrizeTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.WinnerStatusEnum;

/**
 * User: wqh Date: 2015/3/26 19:02
 */
public class LotteryWinnerData implements Serializable {
	private long winnerId;
	
	private long activityId;
	
	private String activityName;
	
	private long instanceId;
	
	private long prizeRuleDetailId;
	
	private String awards;
	
	private String prizeName;
	
	private PrizeTypeEnum prizeType;
	
	private long prizeNum;
	
	private double prizeAmount;
	
	private String prizeImage;
	
	private String description;
	
	private String memo;
	
	private long userId;
	
	private String userName;
	
	private String realName;
	
	private String moble;
	
	private WinnerStatusEnum status;
	
	private String expressNo;
	
	private String winnerMemo;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getWinnerId() {
		return winnerId;
	}
	
	public void setWinnerId(long winnerId) {
		this.winnerId = winnerId;
	}
	
	public long getActivityId() {
		return activityId;
	}
	
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public long getInstanceId() {
		return instanceId;
	}
	
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}
	
	public long getPrizeRuleDetailId() {
		return prizeRuleDetailId;
	}
	
	public void setPrizeRuleDetailId(long prizeRuleDetailId) {
		this.prizeRuleDetailId = prizeRuleDetailId;
	}
	
	public String getAwards() {
		return awards;
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	public String getPrizeName() {
		return prizeName;
	}
	
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	
	public PrizeTypeEnum getPrizeType() {
		return prizeType;
	}
	
	public void setPrizeType(PrizeTypeEnum prizeType) {
		this.prizeType = prizeType;
	}
	
	public long getPrizeNum() {
		return prizeNum;
	}
	
	public void setPrizeNum(long prizeNum) {
		this.prizeNum = prizeNum;
	}
	
	public double getPrizeAmount() {
		return prizeAmount;
	}
	
	public void setPrizeAmount(double prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	
	public String getPrizeImage() {
		return prizeImage;
	}
	
	public void setPrizeImage(String prizeImage) {
		this.prizeImage = prizeImage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getMoble() {
		return moble;
	}
	
	public void setMoble(String moble) {
		this.moble = moble;
	}
	
	public WinnerStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(WinnerStatusEnum status) {
		this.status = status;
	}
	
	public String getExpressNo() {
		return expressNo;
	}
	
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	
	public String getWinnerMemo() {
		return winnerMemo;
	}
	
	public void setWinnerMemo(String winnerMemo) {
		this.winnerMemo = winnerMemo;
	}
	
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
}
