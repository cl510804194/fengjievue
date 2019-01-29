package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.bill.enums.RefundApiStatusEnum;
import com.yjf.esupplier.ws.order.TradeProcessOrder;

public class RefundProcessSuccessOrder extends TradeProcessOrder {
	
	private static final long serialVersionUID = -778071713056894519L;
	String orderNo;
	String tradeNo;
	String refundNo;
	RefundApiStatusEnum apiStatusEnum = RefundApiStatusEnum.SUCCESS;
	
	@Override
	public void check() {
		validateHasText(orderNo, "orderNo");
	}
	
	public String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public RefundApiStatusEnum getApiStatusEnum() {
		return this.apiStatusEnum;
	}
	
	public void setApiStatusEnum(RefundApiStatusEnum apiStatusEnum) {
		this.apiStatusEnum = apiStatusEnum;
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public String getRefundNo() {
		return this.refundNo;
	}
	
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundProcessSuccessOrder [orderNo=");
		builder.append(orderNo);
		builder.append(", tradeNo=");
		builder.append(tradeNo);
		builder.append(", refundNo=");
		builder.append(refundNo);
		builder.append(", apiStatusEnum=");
		builder.append(apiStatusEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
