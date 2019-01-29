package com.yjf.esupplier.ws.bill.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.RefundSyncStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class RefundSyncOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 5181795297293019541L;

	private long infId;
	/*退款ID*/
	private long refundId;
	/** 退款商户ID **/
	private long merchantNo;
	/** 用户ID **/
	private String customerId;
	/** 订单号 **/
	private String orderNo;
	/** 退款金额 **/
	private Money refundAmount = new Money(0, 0);
	/** 退款时间 **/
	private String refundTime;
	/** 退款类型:balance(余额)、other **/
	private String refundType;
	/** 商品信息 **/
	private String goodsInfo;
	/*退款状态*/
	private RefundSyncStatusEnum status;

	public long getInfId() {
		return infId;
	}

	public void setInfId(long infId) {
		this.infId = infId;
	}

	public long getRefundId() {
		return refundId;
	}

	public void setRefundId(long refundId) {
		this.refundId = refundId;
	}

	public long getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(long merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Money getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Money refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public String getRefundType() {
		return refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public RefundSyncStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RefundSyncStatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryRefundOrder [refundId=");
		builder.append(refundId);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", refundAmount=");
		builder.append(refundAmount);
		builder.append(", refundTime=");
		builder.append(refundTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", goodsInfo=");
		builder.append(goodsInfo);
		builder.append(", refundType=");
		builder.append(refundType);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", merchantNo=");
		builder.append(merchantNo);
		builder.append("]");
		return builder.toString();
	}
}
