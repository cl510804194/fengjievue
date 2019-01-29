package com.yjf.esupplier.ws.gifamount.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * Created by min on 2014/11/21.
 */
public class HandGiftMoneyOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -681905050281849585L;
	/**
	 * 发放的用户
	 */
	private long userId;
	/**
	 * 发放的金额
	 */
	private Money amount = new Money(0,0);
	
	private double yearOfRate;
	
	/**
     *
     */
	private GiftMoneyGiveTypeEnum giveType;
	
	private String outBizNo;
	
	private GiftMoneyTypeEnum type;
	
	private long gainMoneyNum;
	
	private String description;
	
	private long giftId;

	private String sendAccountCode;

	private String sendAccountName;
	
	private String sendReason;
	@Override
	public void check() {
		this.validateHasZore(userId, "用户ID");
		
	}
	
	public long getGainMoneyNum() {
		return gainMoneyNum;
	}
	
	public void setGainMoneyNum(long gainMoneyNum) {
		this.gainMoneyNum = gainMoneyNum;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public GiftMoneyGiveTypeEnum getGiveType() {
		return giveType;
	}
	
	public void setGiveType(GiftMoneyGiveTypeEnum giveType) {
		this.giveType = giveType;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getYearOfRate() {
		return yearOfRate;
	}
	
	public void setYearOfRate(double yearOfRate) {
		this.yearOfRate = yearOfRate;
	}
	
	public long getGiftId() {
		return this.giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	public String getSendAccountCode() {
		return sendAccountCode;
	}

	public void setSendAccountCode(String sendAccountCode) {
		this.sendAccountCode = sendAccountCode;
	}

	public String getSendAccountName() {
		return sendAccountName;
	}

	public void setSendAccountName(String sendAccountName) {
		this.sendAccountName = sendAccountName;
	}
	
	public String getSendReason() {
		return sendReason;
	}

	public void setSendReason(String sendReason) {
		this.sendReason = sendReason;
	}
	@Override
	public String toString() {
		return "HandGiftMoneyOrder{" + "userId=" + userId + ", amount=" + amount + ", yearOfRate="
				+ yearOfRate + ", giveType=" + giveType + ", outBizNo='" + outBizNo + '\''
				+ ", type=" + type + ", gainMoneyNum=" + gainMoneyNum + ", description='"
				+ description + '\'' + ", giftId=" + giftId + ",sendAccountCode="
				+ sendAccountCode +",sendAccountName="+ sendAccountName +",sendReason="+sendReason+'}';
	}

}
