package com.yjf.esupplier.ws.order;

public class DebtTransferReReleaseOrder extends DebtTransferReleaseBaseOrder {
	private static final long serialVersionUID = -2813328324751964769L;
	/**
	 * 当前登录用户id
	 */
	private long reReleaseUserId;
	
	public long getReReleaseUserId() {
		return this.reReleaseUserId;
	}
	
	public void setReReleaseUserId(long reReleaseUserId) {
		this.reReleaseUserId = reReleaseUserId;
		setCurrentUserId(reReleaseUserId);
	}
	
	@Override
	public void check() {
		validateHasZore(reReleaseUserId, "再发布用户id");
		validateHasZore(super.getTradeTransferId(), "债权转让id");
        validateGreaterThan(this.getApplyUserId(), "申请用户id");
        validateHasZore(super.getCurrentUserId(), "当前用户id");
        validateMoneyGreaterThanZero(this.getAmount(), "转让金额");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferReReleaseOrder [reReleaseUserId=");
		builder.append(reReleaseUserId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
