package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class TecBillOrder extends ProcessOrder {
	
	private static final long	serialVersionUID	= 7381491037203560073L;
	UserBizTypeEnum				bizTypeEnum;
	long						deliverId;
	
	@Override
	public void check() {
		super.check();
		validateNotNull(bizTypeEnum, "操作方");
		validateHasZore(processorId, "用户id");
		validateHasZore(bizNo, "订单id");
		validateHasZore(deliverId, "技师id");
	}
	
	public UserBizTypeEnum getBizTypeEnum() {
		return this.bizTypeEnum;
	}
	
	public void setBizTypeEnum(UserBizTypeEnum bizTypeEnum) {
		this.bizTypeEnum = bizTypeEnum;
	}
	
	public long getDeliverId() {
		return deliverId;
	}
	
	public void setDeliverId(long deliverId) {
		this.deliverId = deliverId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CancelBillOrder [bizTypeEnum=");
		builder.append(bizTypeEnum);
		builder.append("deliverId=" + deliverId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
