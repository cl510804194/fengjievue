package com.yjf.esupplier.ws.review.order;

import java.util.Date;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class TradeReviewQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = -5908917561397428587L;
	long buyerId;
	long orderId;
	long supplierId;
	Date beginDate;
	private long productId;
	Date endDate;
	
	public long getBuyerId() {
		return this.buyerId;
	}
	
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	
	public long getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradeReviewQueryOrder [buyerId=");
		builder.append(buyerId);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}
	
}
