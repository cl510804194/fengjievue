package com.yjf.esupplier.ws.supplier.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

public class TableNumberSettingOrder extends ProcessOrder {
	
	private static final long serialVersionUID = -4170819973692220991L;
	long supplierId;
	long tableNumber;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(supplierId, "商户id");
		validateHasZore(tableNumber, "商户餐桌数量");
		validateHasZore(processorId, "操作员id");
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(long tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TableNumberSettingOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", tableNumber=");
		builder.append(tableNumber);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
