package com.yjf.esupplier.ws.lottery.order;

public class UpdateLotteryActivityOrder extends LotteryActivityBaseOrder {
	private static final long serialVersionUID = 6201146858212689248L;
	/**
	 * 主键id
	 */
	private long id;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(id, "id");
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateLotteryActivityOrder [id=");
		builder.append(id);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
