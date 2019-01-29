package com.yjf.esupplier.ws.bill.order;

import java.util.Arrays;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

public class RefundApplyOrder extends ProcessOrder {
	private static final long serialVersionUID = 2094257920786562115L;
	/**
	 * 退款的订单号
	 */
	long orderId;
	/**
	 * 退款的订单明细
	 */
	long orderItemId;
	/**
	 * 退货数量
	 */
	private long refundQuantity;
	/**
	 * 退款类型
	 */
	private RefundTypeEnum refundType;
	/**
	 * 退款金额
	 */
	private Money refundAmount = new Money(0, 0);
	/**
	 * 退款原因
	 */
	private String refundReason;
	/**
	 * 退款描述
	 */
	private String refundDesc;
	
	private String[] uploadImgUrls;
	
	private BooleanEnum refundBackStage = BooleanEnum.NO;
	
	@Override
	public void check() {
		super.check();
//		validateHasText(refundReason, "退款原因");
		validateNotNull(refundType, "退款类型");
		validateHasZore(orderId, "订单id");
		validateHasZore(orderItemId, "订单id");
		validateMoneyGreaterThanZero(refundAmount, "退款金额");
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getRefundQuantity() {
		return this.refundQuantity;
	}
	
	public void setRefundQuantity(long refundQuantity) {
		this.refundQuantity = refundQuantity;
	}
	
	public RefundTypeEnum getRefundType() {
		return this.refundType;
	}
	
	public void setRefundType(RefundTypeEnum refundType) {
		this.refundType = refundType;
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
	
	public String getRefundDesc() {
		return this.refundDesc;
	}
	
	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}
	
	public long getOrderItemId() {
		return this.orderItemId;
	}
	
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public String[] getUploadImgUrls() {
		return this.uploadImgUrls;
	}
	
	public void setUploadImgUrls(String[] uploadImgUrls) {
		this.uploadImgUrls = uploadImgUrls;
	}
	
	public BooleanEnum getRefundBackStage() {
		return refundBackStage;
	}

	public void setRefundBackStage(BooleanEnum refundBackStage) {
		this.refundBackStage = refundBackStage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RefundApplyOrder [orderId=");
		builder.append(orderId);
		builder.append(", orderItemId=");
		builder.append(orderItemId);
		builder.append(", refundQuantity=");
		builder.append(refundQuantity);
		builder.append(", refundType=");
		builder.append(refundType);
		builder.append(", refundAmount=");
		builder.append(refundAmount);
		builder.append(", refundReason=");
		builder.append(refundReason);
		builder.append(", refundDesc=");
		builder.append(refundDesc);
		builder.append(", uploadImgUrls=");
		builder.append(Arrays.toString(uploadImgUrls));
		builder.append("]");
		return builder.toString();
	}
	
}
