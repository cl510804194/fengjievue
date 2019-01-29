package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

public class MealBaseOrder extends ProcessOrder {
	private static final long serialVersionUID = -8178688661666345327L;
	/**
	 * 桌号
	 */
	String tableNumber;
	/**
	 * pad点餐的商户id
	 */
	long padSupplierId;
	
	@Override
	public void check() {
		validateHasText(tableNumber, "桌号");
		validateHasZore(padSupplierId, "商户id");
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
	
}
