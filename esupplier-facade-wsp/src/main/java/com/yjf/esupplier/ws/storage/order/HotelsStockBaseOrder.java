package com.yjf.esupplier.ws.storage.order;

import java.util.Date;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class HotelsStockBaseOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = -8494570192525512975L;
	protected long productId;
	protected Date beginDate;
	protected Date endDate;
	
	@Override
	public void check() {
		validateHasZore(productId, "酒店id");
		validateNotNull(beginDate, "开始时间");
		validateNotNull(endDate, "结束时间");
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelsStockBaseOrder [productId=");
		builder.append(productId);
		builder.append(", beginDate=");
		builder.append(beginDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}
	
}
