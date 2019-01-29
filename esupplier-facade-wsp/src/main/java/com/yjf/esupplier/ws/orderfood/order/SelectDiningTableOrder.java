package com.yjf.esupplier.ws.orderfood.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

public class SelectDiningTableOrder extends ProcessOrder {
	
	private static final long serialVersionUID = -7224037242808208362L;
	long supplierId;
	String tableNumber;
	private long peopleNo = -1;
	
	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
		validateHasText(tableNumber, "桌号");
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public long getPeopleNo() {
		return this.peopleNo;
	}
	
	public void setPeopleNo(long peopleNo) {
		this.peopleNo = peopleNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SelectDiningTableOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", tableNumber=");
		builder.append(tableNumber);
		builder.append(", peopleNo=");
		builder.append(peopleNo);
		builder.append("]");
		return builder.toString();
	}
	
}
