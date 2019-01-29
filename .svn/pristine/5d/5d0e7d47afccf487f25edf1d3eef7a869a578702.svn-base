package com.yjf.esupplier.ws.bill.order;

import java.util.List;

import com.yjf.esupplier.ws.info.CartItemInfo;

public class MealOrder extends MealBaseOrder {
	
	private static final long serialVersionUID = 5183869719283096049L;
	
	/**
	 * 商户
	 */
	String supplierName;
	/**
	 * 商户NikeName
	 */
	String supplierNikeName;
	/**
	 * 商品基本项
	 */
	List<CartItemInfo> list;
	
	@Override
	public void check() {
		super.check();
		validateNotNull(list, "菜品");
		validateHasText(supplierName, "商户名称");
		//		validateHasText(supplierNikeName, "商户名称");
	}
	
	@Override
	public String getTableNumber() {
		return this.tableNumber;
	}
	
	@Override
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	@Override
	public long getPadSupplierId() {
		return this.padSupplierId;
	}
	
	@Override
	public void setPadSupplierId(long padSupplierId) {
		this.padSupplierId = padSupplierId;
	}
	
	public List<CartItemInfo> getList() {
		return this.list;
	}
	
	public void setList(List<CartItemInfo> list) {
		this.list = list;
	}
	
	public String getSupplierName() {
		return this.supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getSupplierNikeName() {
		return this.supplierNikeName;
	}
	
	public void setSupplierNikeName(String supplierNikeName) {
		this.supplierNikeName = supplierNikeName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MealOrder [tableNumber=");
		builder.append(tableNumber);
		builder.append(", padSupplierId=");
		builder.append(padSupplierId);
		builder.append(", list=");
		builder.append(list);
		builder.append("]");
		return builder.toString();
	}
	
}
