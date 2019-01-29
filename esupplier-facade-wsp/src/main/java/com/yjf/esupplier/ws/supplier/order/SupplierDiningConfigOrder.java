/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 上午10:42:30 创建
 */
package com.yjf.esupplier.ws.supplier.order;

import java.util.List;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 *
 *
 * @author zhouwei
 *
 */
public class SupplierDiningConfigOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 1291133617245593162L;
	
	private long supplierId;
	
	private List<Long> availableSupplierIds;
	
	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public List<Long> getAvailableSupplierIds() {
		return availableSupplierIds;
	}
	
	public void setAvailableSupplierIds(List<Long> availableSupplierIds) {
		this.availableSupplierIds = availableSupplierIds;
	}
	
	@Override
	public void check() {
		validateHasZore(supplierId, "商户ID不能为空");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierDiningConfigOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", availableSupplierIds=");
		builder.append(availableSupplierIds);
		builder.append("]");
		return builder.toString();
	}
	
}
