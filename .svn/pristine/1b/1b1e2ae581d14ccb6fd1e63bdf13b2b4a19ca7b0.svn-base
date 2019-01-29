package com.yjf.esupplier.web.controller.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.google.common.collect.Lists;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.base.data.BaseDataLoader;
import com.yjf.esupplier.service.hotel.HotelsStockService;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.service.product.ProductUserService;
import com.yjf.esupplier.service.supplier.SupplierService;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

public class SupplierBaseController extends BaseAutowiredController {
	@Autowired
	protected SupplierService supplierService;
	
	@Autowired
	protected BaseDataLoader baseDataLoader;
	
	@Autowired
	protected ProductService productService;
	
	@Autowired
	protected HotelsStockService hotelsStockService;
	@Autowired
	protected ProductUserService productUserService;
	
	protected void initProductType(Model model, SupplierInfo supplierInfo) {
		List<ProductTypeInfo> connectTypeList = Lists.newArrayList();
		String productTypeInfoString = "";
		if (supplierInfo!= null && supplierInfo.getProductType() != null) {
			List<Long> list = new ArrayList<Long>();
			String[] proArray = supplierInfo.getProductType().split(",");
			for (int i = 0; i < proArray.length; i++) {
				int productTypeId = NumberUtil.parseInt(proArray[i].trim());
				ProductTypeInfo typeInfo = baseDataLoader.getProductTypeInfoById(productTypeId);
				if (typeInfo != null) {
					if (productTypeInfoString.length() > 0) {
						productTypeInfoString = productTypeInfoString + ","
												+ typeInfo.getPtTypeName();
						
					} else {
						productTypeInfoString = typeInfo.getPtTypeName();
					}
				}
				connectTypeList.add(typeInfo);
			}
			model.addAttribute("connectTypeList", connectTypeList);
			model.addAttribute("productTypeInfoString", productTypeInfoString);
		}
	}
}
