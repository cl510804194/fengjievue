package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;

import com.yjf.common.lang.util.money.Money;

public class DeliveryInfo implements Serializable {
	private static final long serialVersionUID = -6075324442798492421L;
	private long deliveryId;
	private long productId;
	private Money post = new Money(0, 0);
	private Money express = new Money(0, 0);
	private Money ems = new Money(0, 0);
	private String postArea;
	
	public DeliveryInfo() {
		super();
	}
	
	public DeliveryInfo(long deliveryId, long productId, Money post, Money express, Money ems,
						String postArea) {
		super();
		this.deliveryId = deliveryId;
		this.productId = productId;
		this.post = post;
		this.express = express;
		this.ems = ems;
		this.postArea = postArea;
	}
	
	public long getDeliveryId() {
		return deliveryId;
	}
	
	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public Money getPost() {
		return post;
	}
	
	public void setPost(Money post) {
		this.post = post;
	}
	
	public Money getExpress() {
		return express;
	}
	
	public void setExpress(Money express) {
		this.express = express;
	}
	
	public Money getEms() {
		return ems;
	}
	
	public void setEms(Money ems) {
		this.ems = ems;
	}
	
	public String getPostArea() {
		return postArea;
	}
	
	public void setPostArea(String postArea) {
		this.postArea = postArea;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryInfo [deliveryId=");
		builder.append(deliveryId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", post=");
		builder.append(post);
		builder.append(", express=");
		builder.append(express);
		builder.append(", ems=");
		builder.append(ems);
		builder.append(", postArea=");
		builder.append(postArea);
		builder.append("]");
		return builder.toString();
	}
	
}
