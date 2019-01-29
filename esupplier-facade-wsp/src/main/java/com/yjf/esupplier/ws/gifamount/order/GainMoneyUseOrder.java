package com.yjf.esupplier.ws.gifamount.order;

import java.util.Arrays;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class GainMoneyUseOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 6458169354242097117L;
	private long[] giftMoneyIds;
	
	private long userId;
	private boolean query = false;
	
	private Money investAmount;
	
	@Override
	public void check() {
		this.validateNotNull(investAmount, "交易金额");
		
	}
	
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
	
	public Money getInvestAmount() {
		return investAmount;
	}
	
	public void setInvestAmount(Money investAmount) {
		this.investAmount = investAmount;
	}
	
	public boolean isQuery() {
		return query;
	}
	
	public void setQuery(boolean query) {
		this.query = query;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GainMoneyUseOrder [giftMoneyIds=");
		builder.append(Arrays.toString(giftMoneyIds));
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", query=");
		builder.append(query);
		builder.append(", investAmount=");
		builder.append(investAmount);
		builder.append("]");
		return builder.toString();
	}
}
