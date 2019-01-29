package com.yjf.esupplier.ws.order;

public class DebtTransferOrder extends DebtTransferBaseOrder {
	private static final long serialVersionUID = -7821482694720526400L;
	/**
	 * 当前接收转让用户id
	 */
	protected long recipientId;
	
	public long getRecipientId() {
		return this.recipientId;
	}
	
	public void setRecipientId(long recipientId) {
		this.recipientId = recipientId;
		setCurrentUserId(recipientId);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DebtTransferOrder [recipientId=");
		builder.append(recipientId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
