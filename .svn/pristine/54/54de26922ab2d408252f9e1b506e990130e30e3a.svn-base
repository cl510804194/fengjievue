package com.yjf.esupplier.ws.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;

public class DebtTransferCancelOrder extends DebtTransferBaseOrder {
	private static final long serialVersionUID = 1618324711132801900L;
	/**
	 * 当前登录用户id
	 */
	private long cancelUserId;
	private BooleanEnum isSystem = BooleanEnum.NO;
	
	public long getCancelUserId() {
		return this.cancelUserId;
	}
	
	public void setCancelUserId(long cancelUserId) {
		this.cancelUserId = cancelUserId;
		setCurrentUserId(cancelUserId);
	}
	
	public BooleanEnum getIsSystem() {
		return this.isSystem;
	}
	
	public void setIsSystem(BooleanEnum isSystem) {
		this.isSystem = isSystem;
	}
	
	@Override
	public void check() {
		validateHasZore(cancelUserId, "取消用户id");
		validateHasZore(super.getTradeTransferId(), "债权转让id");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferCancelOrder [cancelUserId=");
		builder.append(cancelUserId);
		builder.append(", isSystem=");
		builder.append(isSystem);
		builder.append("]");
		return builder.toString();
	}
	
}
