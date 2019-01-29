package com.yjf.esupplier.ws.product.order;

import java.util.Arrays;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class UpdateProductStatusOrder extends ValidateOrderBase {
	private static final long serialVersionUID = 4703457573755578408L;
	
	@Override
	public void check() {
//		validateHasZore(supplierId, "供应商id");
		validateNotNull(productId, "productId集合不能为空");
		for (long productItemId : productId) {
			validateHasZore(productItemId, "产品id");
		}
	}
	
	private long[] productId;
	
	private long supplierId;
	private long belongTo;
	
	public long[] getProductId() {
		return this.productId;
	}
	
	public void setProductId(long[] productId) {
		this.productId = productId;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public long getBelongTo() {
		return this.belongTo;
	}
	
	public void setBelongTo(long belongTo) {
		this.belongTo = belongTo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateProductStatusOrder [productId=");
		builder.append(Arrays.toString(productId));
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", belongTo=");
		builder.append(belongTo);
		builder.append("]");
		return builder.toString();
	}
	
}
