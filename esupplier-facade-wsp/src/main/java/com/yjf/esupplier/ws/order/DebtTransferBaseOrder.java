package com.yjf.esupplier.ws.order;

public class DebtTransferBaseOrder extends TradeProcessOrder {
	private static final long serialVersionUID = 5608185059020719974L;
	/**
	 * 交易转账数据id
	 */
	private long tradeTransferId;
	
	private long currentUserId;
	
	public long getTradeTransferId() {
		return this.tradeTransferId;
	}
	
	public void setTradeTransferId(long tradeTransferId) {
		this.tradeTransferId = tradeTransferId;
	}
	
	public long getCurrentUserId() {
		return this.currentUserId;
	}
	
	public void setCurrentUserId(long currentUserId) {
		this.currentUserId = currentUserId;
	}
	
	@Override
	public void check() {
		//super.check();
		validateHasZore(tradeTransferId, "债权转让id");
		validateHasZore(currentUserId, "当前用户id");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferBaseOrder [tradeTransferId=");
		builder.append(tradeTransferId);
		builder.append(", currentUserId=");
		builder.append(currentUserId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
