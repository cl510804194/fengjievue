package com.yjf.esupplier.ws.supplier.order;

import com.yjf.esupplier.ws.order.ProcessOrder;

public class SupplierSettingOrder extends ProcessOrder {
	
	private static final long serialVersionUID = -4170819973692220991L;
	long supplierId;
	
	@Override
	public void check() {
		super.check();
		validateHasZore(supplierId, "商户id");
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplierSettingOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
