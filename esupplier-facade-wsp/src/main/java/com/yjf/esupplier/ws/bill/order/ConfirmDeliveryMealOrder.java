package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class ConfirmDeliveryMealOrder extends ProcessOrder {
	private static final long serialVersionUID = 640774878305327559L;
	long supplierId;
	String batchNo;
	BooleanEnum isComplete = BooleanEnum.NO;
	
	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
		validateHasText(batchNo, "批次号");
		validateNotNull(isComplete, "是否完成");
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
	
	public BooleanEnum getIsComplete() {
		return this.isComplete;
	}
	
	public void setIsComplete(BooleanEnum isComplete) {
		this.isComplete = isComplete;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfirmDeliveryMealOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", isComplete=");
		builder.append(isComplete);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
