package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;
import java.util.List;

import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

public class SupplierAndProductInfo implements Serializable {
	private static final long serialVersionUID = 3423160737464030118L;
	private SupplierInfo supplierInfo;
	private ProductInfo productInfo;

	public SupplierInfo getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(SupplierInfo supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
}
