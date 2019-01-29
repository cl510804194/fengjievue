package com.yjf.esupplier.ws.gifamount.order;

import java.util.Arrays;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class UseGainMoneyOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 1913489967209008985L;
	long orderId;
	long[] gainMoneyIds;
	Money usedAmount;
	
	@Override
	public void check() {
		validateMoneyGreaterThanZero(usedAmount, "使用金额");
		validateHasZore(orderId, "使用金额");
		validateNotNull(gainMoneyIds, "优惠券id");
		Assert.isTrue(gainMoneyIds.length > 0, "优惠券id");
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long[] getGainMoneyIds() {
		return this.gainMoneyIds;
	}
	
	public void setGainMoneyIds(long[] gainMoneyIds) {
		this.gainMoneyIds = gainMoneyIds;
	}
	
	public Money getUsedAmount() {
		return this.usedAmount;
	}
	
	public void setUsedAmount(Money usedAmount) {
		this.usedAmount = usedAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UseGainMoneyOrder [orderId=");
		builder.append(orderId);
		builder.append(", gainMoneyIds=");
		builder.append(Arrays.toString(gainMoneyIds));
		builder.append(", usedAmount=");
		builder.append(usedAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
