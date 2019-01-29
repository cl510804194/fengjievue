package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;

public class ProductCustomPropertyInfo implements Serializable {
	
	private static final long serialVersionUID = -7601965870618111000L;
	private long productCPId;
	private long productId;
	private String propertyName;
	private String propertyDetail;
	
	public ProductCustomPropertyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductCustomPropertyInfo(long productCPId, long productId, String propertyName,
										String propertyDetail) {
		super();
		this.productCPId = productCPId;
		this.productId = productId;
		this.propertyName = propertyName;
		this.propertyDetail = propertyDetail;
	}
	
	public long getProductCPId() {
		return productCPId;
	}
	
	public void setProductCPId(Integer productCPId) {
		this.productCPId = productCPId;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getPropertyDetail() {
		return propertyDetail;
	}
	
	public void setPropertyDetail(String propertyDetail) {
		this.propertyDetail = propertyDetail;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductCustomPropertyInfo [productCPId=");
		builder.append(productCPId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", propertyName=");
		builder.append(propertyName);
		builder.append(", propertyDetail=");
		builder.append(propertyDetail);
		builder.append("]");
		return builder.toString();
	}
	
}
