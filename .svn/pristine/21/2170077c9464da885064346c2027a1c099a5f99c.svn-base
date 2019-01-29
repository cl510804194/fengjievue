package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;

public class DebtTransferReleaseBaseOrder extends DebtTransferBaseOrder {
	private static final long serialVersionUID = -2124396139007154845L;
	
	private long applyUserId;
	
	protected String tradeDetailId;
	/**
	 * 再次发布金额
	 */
	private Money amount = Money.zero();
	
	public Money getAmount() {
		return this.amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getTradeDetailId() {
		return this.tradeDetailId;
	}
	
	public void setTradeDetailId(String tradeDetailId) {
		this.tradeDetailId = tradeDetailId;
	}
	
	public long getApplyUserId() {
		return this.applyUserId;
	}
	
	public void setApplyUserId(long applyUserId) {
		this.applyUserId = applyUserId;
		setCurrentUserId(applyUserId);
	}
	
	@Override
	public void check() {
		validateHasZore(bizNo, "交易流水号");
		validateGreaterThan(applyUserId, "申请用户id");
		validateHasZore(super.getCurrentUserId(), "当前用户id");
		validateMoneyGreaterThanZero(amount, "转让金额");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferReleaseBaseOrder [amount=");
		builder.append(amount);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
