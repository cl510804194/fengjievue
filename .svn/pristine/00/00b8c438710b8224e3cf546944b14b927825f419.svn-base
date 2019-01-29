package com.yjf.esupplier.ws.tocard.order;

import com.yjf.esupplier.ws.bill.enums.AsynchronousApiStatusEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class ToCardProcessedOrder extends ValidateOrderBase {
	
	private static final long	serialVersionUID	= -1557699832349018785L;
	long						toCardId;
	AsynchronousApiStatusEnum	statusEnum;
	
	@Override
	public void check() {
		validateHasZore(toCardId, "外部订单明细id");
		validateNotNull(statusEnum, "状态");
	}
	
	@Override
	public void checkWithGroup(Class<?>... groups) {
		super.checkWithGroup(groups);
	}
	
	public long getToCardId() {
		return this.toCardId;
	}
	
	public void setToCardId(long toCardId) {
		this.toCardId = toCardId;
	}
	
	public AsynchronousApiStatusEnum getStatusEnum() {
		return this.statusEnum;
	}
	
	public void setStatusEnum(AsynchronousApiStatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ToCardProcessedOrder [toCardId=");
		builder.append(toCardId);
		builder.append(", statusEnum=");
		builder.append(statusEnum);
		builder.append("]");
		return builder.toString();
	}
}
