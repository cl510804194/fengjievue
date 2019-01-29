package com.yjf.esupplier.ws.userManage.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class AccountWithdrawOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 2288934201435021480L;
	/**
	 * 变动金额
	 */
	private Money amount = new Money(0, 0);
	/**
	 * 描述
	 */
	private String memo;
	/**
	 * 外部订单号
	 */
	private String outBizNo;
	/**
	 * 用户id
	 */
	private long userId;
	
	@Override
	public void check() {
		validateHasZore(userId, "userId");
		validateHasText(outBizNo, "outBizNo");
		validateMoneyGreaterThanZero(amount, "amount");
	}
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountWithdrawOrder [amount=");
		builder.append(amount);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}
	
}
