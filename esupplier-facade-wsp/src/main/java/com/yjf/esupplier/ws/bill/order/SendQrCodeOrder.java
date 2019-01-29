package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class SendQrCodeOrder extends ProcessOrder  {
	private static final long serialVersionUID = 7381491037203560073L;
	UserBizTypeEnum bizTypeEnum;
	private String qrCode;
	private long orderId;
	/** 发布商品会员ID */
	private long supplierId;
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

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendQrCodeOrder [bizTypeEnum=");
		builder.append(bizTypeEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
