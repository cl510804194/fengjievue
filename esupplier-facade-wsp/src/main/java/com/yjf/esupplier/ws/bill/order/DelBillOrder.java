package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class DelBillOrder extends ProcessOrder  {
	private static final long serialVersionUID = 7381491037203560073L;
	UserBizTypeEnum bizTypeEnum;
	
	@Override
	public void check() {
		super.check();
		validateNotNull(bizTypeEnum, "操作方");
		validateHasZore(processorId, "用户id");
		validateHasText(processName, "用户");
		
	}
	
	public UserBizTypeEnum getBizTypeEnum() {
		return this.bizTypeEnum;
	}
	
	public void setBizTypeEnum(UserBizTypeEnum bizTypeEnum) {
		this.bizTypeEnum = bizTypeEnum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DelBillOrder [bizTypeEnum=");
		builder.append(bizTypeEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
