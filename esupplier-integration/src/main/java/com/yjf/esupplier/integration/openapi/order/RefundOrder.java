package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class RefundOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -760027093898858606L;
	String tradeNo;
	String outOrderNo;
	Money refundAmount = Money.zero();
	String refundReason;
	String memo;
	
	@Override
	public void check() {
		validateHasText(tradeNo, "交易号");
		validateHasText(outOrderNo, "外部订单号");
		validateMoneyGreaterThanZero(refundAmount, "退款金额");
		
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	
	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}
	
	public Money getRefundAmount() {
		return this.refundAmount;
	}
	
	public void setRefundAmount(Money refundAmount) {
		this.refundAmount = refundAmount;
	}
	
	public String getRefundReason() {
		return this.refundReason;
	}
	
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundOrder [tradeNo=");
		builder.append(tradeNo);
		builder.append(", outOrderNo=");
		builder.append(outOrderNo);
		builder.append(", refundAmount=");
		builder.append(refundAmount);
		builder.append(", refundReason=");
		builder.append(refundReason);
		builder.append(", memo=");
		builder.append(memo);
		builder.append("]");
		return builder.toString();
	}
	
}
