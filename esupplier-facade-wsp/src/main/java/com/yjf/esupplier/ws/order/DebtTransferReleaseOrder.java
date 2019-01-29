package com.yjf.esupplier.ws.order;

public class DebtTransferReleaseOrder extends DebtTransferReleaseBaseOrder {
	private static final long serialVersionUID = -4139916798270647102L;
	
	private String tradeName;
	
	public String getTradeName() {
		return tradeName;
	}
	
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	
	@Override
	public void check() {
        validateGreaterThan(this.getApplyUserId(), "申请用户id");
        validateHasZore(super.getCurrentUserId(), "当前用户id");
        validateMoneyGreaterThanZero(this.getAmount(), "转让金额");
		validateHasText(tradeDetailId, "交易明细id");
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferReleaseOrder [tradeName=");
		builder.append(tradeName);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
