/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductTypeEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * 
 * @Filename ProductManageController.java
 * 
 * @Description 商品管理控制器
 * 
 * @Version 1.0
 * 
 * @Author min
 * 
 * @Email oyangnuo@yiji.com
 * 
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-28下午3:50:10</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/product/productInfo")
public class ProductManageController extends BaseAutowiredController {
	
	private final String vm_path = "/backstage/systemManage/productManage/";
	
	@Autowired
	ProductService productService;
	
	/**
	 * 商品列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAllProductList.htm")
	public String toAllProductList(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String searchName = request.getParameter("searchName");
		String searchId = request.getParameter("searchId");
		String supplierId = request.getParameter("supplierId");
		String supplierName = request.getParameter("supplierName");
		String searchType = request.getParameter("searchType");
		String saleType = request.getParameter("saleType");
		model.addAllAttributes(WebUtil.getRequestMap(request));
		
		Integer censor1 = null;
		Integer searchId1 = null;
		Integer supplierId1 = null;
		if (searchId != null && !searchId.trim().equals("")) {
			searchId1 = NumberUtil.parseInt(searchId);
		} else{
			searchId1 = 0;
		}
		if (supplierId != null && !supplierId.trim().equals("")) {
			supplierId1 = NumberUtil.parseInt(supplierId);
		} else{
			supplierId1 = 0;
		}
		
		int pageNo = NumberUtil.parseInt(request.getParameter("pageNo"), 1);
		int pageSize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		ProductSearchOrder productSearchOrder = new ProductSearchOrder();
		if(StringUtil.isNotEmpty(saleType)){
			if(saleType.equals(SaleTypeEnum.O2O.getCode())){
				productSearchOrder.setSaleTypeO2O(BooleanEnum.YES);
				model.addAttribute("productTypeName", ProductTypeEnum.PRODUCT.message());
			}else if(saleType.equals(SaleTypeEnum.HOTELS.getCode())){
				productSearchOrder.setSaleTypeHotels(BooleanEnum.YES);
				model.addAttribute("productTypeName", ProductTypeEnum.HOTELS.message());
			}
		}
		productSearchOrder.setSupplierId(supplierId1);
		productSearchOrder.setSupplierName(supplierName);
		productSearchOrder.setProductName(searchName);
		productSearchOrder.setProductId(searchId1);
		productSearchOrder.setProductType(searchType);
		productSearchOrder.setPageSize(pageSize);
		productSearchOrder.setPageNumber(pageNo);
		QueryBaseBatchResult<ProductInfo> batchResult = productService.getProductList(productSearchOrder);

		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) batchResult.getPageNumber());
		pageTool.setPageSize((int) batchResult.getPageSize());
		pageTool.setTotalRow(batchResult.getTotalCount());
		List<ProductInfo> listP = batchResult.getPageList();
		for (ProductInfo p : listP) {
			String detail = p.getProductDetail();
			String d = StringUtil.splitAndFilterString(detail, 50);
			p.setProductDetail(d);
		}
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(listP, pageTool));
		return vm_path + "allProductList.vm";
		
	}
	
	/**
	 * 设置敏感词
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("setProductCensor.htm")
	public String setProductCensor(HttpServletRequest request, Model model) {
		
		return vm_path + "allProductList.vm";
		
	}
	
	/**
	 * 审查商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("checkProduct.htm")
	public String checkProduct(HttpServletRequest request, Model model) {
		
		return vm_path + "allProductList.vm";
		
	}
	
}
