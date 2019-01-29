package com.yjf.esupplier.ws.gifamount.order;

import java.util.Arrays;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class ElectricityGiftMoneyUseOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 7746702202700166896L;
	
	private long[] giftMoneyIds;
	
	private long userId;
	
	private GiftMoneyTypeEnum type;
	
	private Money amount;
	
	public long[] getGiftMoneyIds() {
		return giftMoneyIds;
	}
	
	public void setGiftMoneyIds(long[] giftMoneyIds) {
		this.giftMoneyIds = giftMoneyIds;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ElectricityGiftMoneyUseOrder{" + "giftMoneyIds=" + Arrays.toString(giftMoneyIds)
				+ ", userId=" + userId + ", type=" + type + ", amount=" + amount + '}';
	}
}
