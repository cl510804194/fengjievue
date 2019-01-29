package com.yjf.esupplier.ws.storage.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class StorageSearchOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 229593142874711530L;
	long supplierId;
	String productName;
	long productId;
	String productNumber;
	String productType;
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductNumber() {
		return this.productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public String getProductType() {
		return this.productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StorageSearchOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productNumber=");
		builder.append(productNumber);
		builder.append(", productType=");
		builder.append(productType);
		builder.append("]");
		return builder.toString();
	}
	
}
