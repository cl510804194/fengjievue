package com.yjf.esupplier.ws.info;

import java.io.Serializable;

public class Discount2productInfo implements Serializable {
	
	private static final long serialVersionUID = -3416118633689413939L;
	private Integer activityId;
	private Integer productId;
	private Integer supplierId;
	private Integer amount;
	private Double price;
	private Integer orderAmount;
	
	public Integer getActivityId() {
		return activityId;
	}
	
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getOrderAmount() {
		return orderAmount;
	}
	
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Discount2product [activityId=");
		builder.append(activityId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", price=");
		builder.append(price);
		builder.append(", orderAmount=");
		builder.append(orderAmount);
		builder.append("]");
		return builder.toString();
	}
	
}
