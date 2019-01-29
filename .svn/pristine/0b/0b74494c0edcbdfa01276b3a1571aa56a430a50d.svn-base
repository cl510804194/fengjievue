package com.yjf.esupplier.ws.bill.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class PostFeeOrder extends ProcessOrder {
	private static final long serialVersionUID = -6800299903137803600L;
	Money postFee;
	
	@Override
	public void check() {
		super.check();
	}

	public Money getPostFee() {
		return postFee;
	}

	public void setPostFee(Money postFee) {
		this.postFee = postFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderQRCodeOrder [postFee=");
		builder.append(postFee);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
