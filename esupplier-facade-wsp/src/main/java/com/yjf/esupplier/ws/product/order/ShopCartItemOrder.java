package com.yjf.esupplier.ws.product.order;

import java.util.Date;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class ShopCartItemOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 7057920601043982699L;
	
	private long productId;
	
	private String productName;
	
	private String picPath;
	
	private Money price = new Money(0, 0);
	
	private long quantity;
	
	private Money totalPrice = new Money(0, 0);
	
	private String isDelete;
	
	private Date putinDate;
	
	private long userId;
	
	private String userName;
	
	private String userNikename;
	
	private long supplierId;
	
	private String supplierName;
	
	private String productUnit;
	
	private String saleType;

	@Override
	public void check() {
		validateMoneyGreaterThanZero(price, "单价");
		validateMoneyGreaterThanZero(totalPrice, "单价");
		validateHasZore(userId, "用户id");
		validateHasZore(productId, "产品id");
		validateHasZore(supplierId, "供应商id");
		validateHasText(saleType, "购物车类型");
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getSupplierName() {
		return this.supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public long getProductId() {
		return this.productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getPicPath() {
		return this.picPath;
	}
	
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	public long getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	public String getIsDelete() {
		return this.isDelete;
	}
	
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	public Date getPutinDate() {
		return this.putinDate;
	}
	
	public void setPutinDate(Date putinDate) {
		this.putinDate = putinDate;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserNikename() {
		return this.userNikename;
	}
	
	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}
	
	public Money getPrice() {
		return this.price;
	}
	
	public Money getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setPrice(Money price) {
		this.price = price;
	}
	
	public void setTotalPrice(Money totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getProductUnit() {
		return this.productUnit;
	}
	
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	public String getSaleType() {
		return saleType;
	}
	
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopCartItemOrder [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", picPath=");
		builder.append(picPath);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", isDelete=");
		builder.append(isDelete);
		builder.append(", putinDate=");
		builder.append(putinDate);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userNikename=");
		builder.append(userNikename);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", supplierName=");
		builder.append(supplierName);
		builder.append(", productUnit=");
		builder.append(productUnit);
		builder.append(", saleType=");
		builder.append(saleType);
		builder.append("]");
		return builder.toString();
	}

	
}
