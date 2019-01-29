package com.yjf.esupplier.ws.review.info;

import com.yjf.esupplier.ws.enums.ReviewTypeEnum;

public class TradeReviewInfo {
	private long reviewId = 0; //评论编号;
	private long supplierId = 0; //供应商编号;
	private long orderId = 0; //对应的订单号;
	private long buyerId = 0; //卖家编号;
	private ReviewTypeEnum type = ReviewTypeEnum.product; //评价对象;
	private String buyerName = ""; //买家名称;
	private String buyerIp = ""; //买家的IP地址;
	private int product = 0; //宣传与实物一致性评分;
	private int delivery = 0; //发货及时性评分;
	private int communication = 0; //服务态度评分;
	private String remark = ""; //评语和说明;
	//评论时间
	private String reviewTime;
	//供应商名称
	private String supplierName = "";
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public long getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getBuyerIp() {
		return buyerIp;
	}
	
	public void setBuyerIp(String buyerIp) {
		this.buyerIp = buyerIp;
	}
	
	public int getProduct() {
		return product;
	}
	
	public void setProduct(int product) {
		this.product = product;
	}
	
	public int getDelivery() {
		return delivery;
	}
	
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	
	public int getCommunication() {
		return communication;
	}
	
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	
	public String getReviewTime() {
		return reviewTime;
	}
	
	public int getAvgScore() {
		return (product + delivery + communication) / 3;
	}

	public ReviewTypeEnum getType() {
		return type;
	}

	public void setType(ReviewTypeEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("TradeReviewInfo{");
		sb.append("reviewId=").append(reviewId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", orderId=").append(orderId);
		sb.append(", buyerId=").append(buyerId);
		sb.append(", type=").append(type);
		sb.append(", buyerName='").append(buyerName).append('\'');
		sb.append(", buyerIp='").append(buyerIp).append('\'');
		sb.append(", product=").append(product);
		sb.append(", delivery=").append(delivery);
		sb.append(", communication=").append(communication);
		sb.append(", remark='").append(remark).append('\'');
		sb.append(", reviewTime='").append(reviewTime).append('\'');
		sb.append(", supplierName='").append(supplierName).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
