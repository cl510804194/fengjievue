package com.yjf.esupplier.ws.bill.order;

import com.yjf.common.lang.util.money.Money;

import java.util.Date;

public class PayToShopOrder extends BillBaseOrder {
	
	private static final long serialVersionUID = -5753891834770778618L;
	
	/**
	 * 商户id
	 */
	String sellerId;

	/**
	 * 商平基本信息
	 */
	String goodsMemo = "到店付";

	/**
	 *  优惠券金额
	 */
	Money gainMoney;
	/**
	 *  交易时间
	 */
	Date tradeTime;
	/**
	 * 用户积分
	 */
	long userPoint;
	
	private long productId;

	

	@Override
	public void check() {
		validateNotNull(userId, "买家id");
		validateNotNull(sellerId, "卖家id");
		validateMoneyGreaterThanZero(getTotalAmount(), "应付金额");
	}
	
	public String getSellerId() {
		return this.sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public long getUserPoint() {
		return userPoint;
	}

	@Override
	public void setUserPoint(long userPoint) {
		this.userPoint = userPoint;
	}

	@Override
	public String getGainMoneyTradesId() {
		return this.gainMoneyTradesId;
	}
	
	public String getGoodsMemo() {
		return this.goodsMemo;
	}
	
	public void setGoodsMemo(String goodsMemo) {
		this.goodsMemo = goodsMemo;
	}

	public Money getGainMoney() {
		return gainMoney;
	}

	public void setGainMoney(Money gainMoney) {
		this.gainMoney = gainMoney;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayToShopOrder [sellerId=");
		builder.append(sellerId);
		builder.append(", goodsMemo=");
		builder.append(goodsMemo);
		builder.append(", gainMoneyTradesId=");
		builder.append(gainMoneyTradesId);
		builder.append(", gainMoney=");
		builder.append(gainMoney);
		builder.append(", userPoint=");
		builder.append(userPoint);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
}
