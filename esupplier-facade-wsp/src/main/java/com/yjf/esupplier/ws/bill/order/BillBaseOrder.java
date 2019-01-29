package com.yjf.esupplier.ws.bill.order;

import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class BillBaseOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -6106777604879982601L;
	/**
	 * 优惠券
	 */
	protected String gainMoneyTradesId;
	/**
	 * 用户积分
	 */
	protected long userPoint;
	/**
	 * 用户id
	 */
	protected long userId;
	/**
	 * 买家昵称
	 */
	protected String nickname = "匿名";
	/**
	 * 交易总金额
	 */
	protected Money totalAmount = Money.zero();
	
	/**
	 * 交易总金额
	 */
	protected Money totalAmountNoPostFee = Money.zero();
	
	/**
	 * 商品基本项
	 */
	List<CartItemInfo> list;
	
	public List<CartItemInfo> getList() {
		return this.list;
	}
	
	public void setList(List<CartItemInfo> list) {
		this.list = list;
	}
	
	public String getGainMoneyTradesId() {
		return this.gainMoneyTradesId;
	}
	
	public void setGainMoneyTradesId(String gainMoneyTradesId) {
		this.gainMoneyTradesId = gainMoneyTradesId;
	}
	
	public long getUserPoint() {
		return this.userPoint;
	}
	
	public void setUserPoint(long userPoint) {
		this.userPoint = userPoint;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public Money getTotalAmount() {
		return this.totalAmount;
	}
	
	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Money getTotalAmountNoPostFee() {
		return this.totalAmountNoPostFee;
	}

	
	public void setTotalAmountNoPostFee(Money totalAmountNoPostFee) {
		this.totalAmountNoPostFee = totalAmountNoPostFee;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillBaseOrder [gainMoneyTradesId=");
		builder.append(gainMoneyTradesId);
		builder.append(", userPoint=");
		builder.append(userPoint);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
	
}
