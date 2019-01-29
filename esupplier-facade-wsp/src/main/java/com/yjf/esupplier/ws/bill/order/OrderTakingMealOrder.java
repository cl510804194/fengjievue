package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class OrderTakingMealOrder extends ProcessOrder {
	
	private static final long serialVersionUID = 1401696821810137501L;
	long supplierId;
	String batchNo;
	BooleanEnum isPrintTicket = BooleanEnum.NO;
	
	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
		validateHasText(batchNo, "批次号");
		validateNotNull(isPrintTicket, "是否打印小票");
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getBatchNo() {
		return this.batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public BooleanEnum getIsPrintTicket() {
		return this.isPrintTicket;
	}
	
	public void setIsPrintTicket(BooleanEnum isPrintTicket) {
		this.isPrintTicket = isPrintTicket;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderTakingMealOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", isPrintTicket=");
		builder.append(isPrintTicket);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
