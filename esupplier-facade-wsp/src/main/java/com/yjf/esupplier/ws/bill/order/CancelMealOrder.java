package com.yjf.esupplier.ws.bill.order;

public class CancelMealOrder extends MealBaseOrder {
	
	private static final long serialVersionUID = 6693972548066101466L;
	
	long orderId;
	
	@Override
	public void check() {
		validateHasZore(orderId, "订单号");
	}
	
	public String getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public long getPadSupplierId() {
		return this.padSupplierId;
	}
	
	public void setPadSupplierId(long padSupplierId) {
		this.padSupplierId = padSupplierId;
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CancelMealOrder [tableNumber=");
		builder.append(tableNumber);
		builder.append(", padSupplierId=");
		builder.append(padSupplierId);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append("]");
		return builder.toString();
	}
	
}
