package com.yjf.esupplier.ws.bill.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class OfflineTradeInfoOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -5753891834770778618L;
	/**
	 * 买家外部商户id
	 */
	String buyerId;
	/**
	 * 卖家外部商户id
	 */
	String sellerId;
	/**
	 * 商平基本信息
	 */
	String goodsMemo = "线下消费";
	
	/**
	 * 外部订单ID
	 */
	String orderNoId;
	/**
	 * 应付金额
	 */
	Money payableAmount = new Money(0, 0);
	/**
	 * 实付金额
	 */
	Money payedAmount = new Money(0, 0);
	/**
	 * 交易时间
	 */
	Date tradeTime = new Date();
	
	/**
	 * 优惠券金额
	 */
	Money gainMoney;
	
	@Override
	public void check() {
		validateHasText(sellerId, "卖家外部商户id");
		validateMoneyGreaterThanZero(payedAmount, "应付金额");
		validateMoneyGreaterThanZero(payableAmount, "实付金额");
	}
	
	public String getBuyerId() {
		return this.buyerId;
	}
	
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getSellerId() {
		return this.sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getGoodsMemo() {
		return this.goodsMemo;
	}
	
	public void setGoodsMemo(String goodsMemo) {
		this.goodsMemo = goodsMemo;
	}
	
	public Money getPayableAmount() {
		return this.payableAmount;
	}
	
	public void setPayableAmount(Money payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	public Money getPayedAmount() {
		return this.payedAmount;
	}
	
	public void setPayedAmount(Money payedAmount) {
		this.payedAmount = payedAmount;
	}
	
	public Date getTradeTime() {
		return this.tradeTime;
	}
	
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	
	public String getOrderNoId() {
		return orderNoId;
	}
	
	public void setOrderNoId(String orderNoId) {
		this.orderNoId = orderNoId;
	}
	
	public Money getGainMoney() {
		return gainMoney;
	}
	
	public void setGainMoney(Money gainMoney) {
		this.gainMoney = gainMoney;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OfflineTradeInfoOrder [buyerId=");
		builder.append(buyerId);
		builder.append(", sellerId=");
		builder.append(sellerId);
		builder.append(", goodsMemo=");
		builder.append(goodsMemo);
		builder.append(", payableAmount=");
		builder.append(payableAmount);
		builder.append(", payedAmount=");
		builder.append(payedAmount);
		builder.append(", tradeTime=");
		builder.append(tradeTime);
		builder.append("]");
		return builder.toString();
	}
	
}
