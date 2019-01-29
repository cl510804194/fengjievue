package com.yjf.esupplier.ws.bill.order;

public class UpdateMealQuantityOrder extends MealBaseOrder {
	
	private static final long serialVersionUID = -4001401900774866838L;
	long orderId;
	long quantity;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(quantity, "数量");
		validateHasZore(orderId, "订单号");
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateMealQuantityOrder [orderId=");
		builder.append(orderId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
}
