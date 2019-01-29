package com.yjf.esupplier.ws.gifamount.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * Created by min on 2014/11/21.
 */
public class GiftMoneyAssignOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -681905050281849585L;
	
	private long userId;
	
	private String username;
	
	private Money investAmount = new Money(0, 0);
	
	private Date currentDate;
	
	private GiftMoneyGiveTypeEnum giveType;
	
	private String outBizNo;
	
	private GiftMoneyTypeEnum type;
	
	private long giftId;
	
	@Override
	public void check() {
		this.validateNotNull(giveType, "红包类型");
		this.validateHasZore(userId, "用户ID");
		this.validateHasText(username, "用户名");
	}
	
	public Money getInvestAmount() {
		return investAmount;
	}
	
	public void setInvestAmount(Money investAmount) {
		this.investAmount = investAmount;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public GiftMoneyGiveTypeEnum getGiveType() {
		return giveType;
	}
	
	public void setGiveType(GiftMoneyGiveTypeEnum giveType) {
		this.giveType = giveType;
	}
	
	public Date getCurrentDate() {
		return currentDate;
	}
	
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
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
	
	public long getGiftId() {
		return this.giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GiftMoneyAssignOrder [userId=");
		builder.append(userId);
		builder.append(", username=");
		builder.append(username);
		builder.append(", investAmount=");
		builder.append(investAmount);
		builder.append(", currentDate=");
		builder.append(currentDate);
		builder.append(", giveType=");
		builder.append(giveType);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", type=");
		builder.append(type);
		builder.append(", giftId=");
		builder.append(giftId);
		builder.append("]");
		return builder.toString();
	}
	
}
