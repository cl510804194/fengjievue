package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class OrderQRCodeOrder extends ProcessOrder {
	private static final long serialVersionUID = -6800299903137803600L;
	UserBizTypeEnum bizTypeEnum;
	String orderType;
	@Override
	public void check() {
		super.check();
		validateNotNull(bizTypeEnum, "操作方");
	}
	
	public UserBizTypeEnum getBizTypeEnum() {
		return this.bizTypeEnum;
	}
	
	public void setBizTypeEnum(UserBizTypeEnum bizTypeEnum) {
		this.bizTypeEnum = bizTypeEnum;
	}

	@Override
	public String getOrderType() {
		return orderType;
	}

	@Override
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "OrderQRCodeOrder{" +
				"orderType='" + orderType + '\'' +
				", bizTypeEnum=" + bizTypeEnum +
				'}';
	}

}
