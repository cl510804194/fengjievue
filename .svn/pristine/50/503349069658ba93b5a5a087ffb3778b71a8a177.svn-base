/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.util.ArrayUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.dal.custom.dataobject.HotelsStockIbatisDO;
import com.yjf.esupplier.dal.dataobject.TblProductDO;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.SupplierBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.order.HotelStockProductOrder;
import com.yjf.esupplier.ws.product.enums.PostFeeTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.RefundRuleEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductUserCollectInfo;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;
import com.yjf.esupplier.ws.product.order.SupplierProductSearchOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.enums.VouchStateEnum;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

/**
 * 
 * 
 * @Filename SupplierController.java
 * 
 * @Description 供应商资料管理控制器
 * 
 * @Version 1.0
 * 
 * @Author min
 * 
 * @Email oyangnuo@yiji.com
 * 
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7下午6:03:30</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/do/supplier")
public class SupplierController extends SupplierBaseController {
	
	final static String path = "front/supplier/";
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("enrollPersonal.htm")
	public String enrollPersonal(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		boolean isUpdate = true;
		SupplierInfo supplier = supplierService.getSupplier(ShiroSessionUtils.getSessionLocal()
			.getUserId());
		if (supplier == null) {
			supplier = new SupplierInfo();
			isUpdate = false;
		}
		
		WebUtil.setPoPropertyByRequest(supplier, request);
		String[] productTypeArray = request.getParameterValues("productType");
		supplier.setProductType(ArrayUtil.convertString(productTypeArray));
		supplier.setRunState(SupplierRunStateEnum.getByCode(request.getParameter("runState")));
		supplier.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());//supplier ID与member ID相同
		
		if (ShiroSessionUtils.getSessionLocal().getUserTypeEnum() == UserTypeEnum.GR) {
			supplier.setSupplierType(2); //供应商类型
		} else {
			supplier.setSupplierType(1); //供应商类型
		}
		
		if (StringUtil.isNotBlank(supplier.getVoucherId())) {
			supplier.setVouchState(VouchStateEnum.None);
		}
		EsupplierBaseResult result = null;
		if (isUpdate) {
			result = supplierService.updateSupplier(supplier);
		} else {
			result = supplierService.insertSupplierInfo(supplier, null, null); //添加供应商基本信息	
		}
		
		if (result.isSuccess()) {
			return path + "supplier_vouch.vm";
		} else {
			UserInfo userInfo = userQueryService.queryByUserId(
				ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("supplierInfo", supplier);
			return path + "supplier_personalinfo.vm";
		}
	}
	
	@RequestMapping("buyer/supplierRule.htm")
	public String supplierRule(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		SupplierInfo supplierInfo = supplierService.getSupplier(ShiroSessionUtils.getSessionLocal()
			.getUserId());
		if (supplierInfo == null) {
			return path + "supplier_rule.vm";
		} else {
			return updateSupplier(request, response, model);
		}
	}
	
	@RequestMapping("seller/updateSupplier.htm")
	public String updateSupplier(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		UserInfo userInfo = userQueryService.queryByUserId(
			ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
		model.addAttribute("userInfo", userInfo);
		SupplierInfo supplierInfo = supplierService.getSupplier(userInfo.getUserId());
		model.addAttribute("supplierInfo", supplierInfo);
		initProductType(model, supplierInfo);
		return path + "supplier_personalinfo.vm";
	}
	
	@RequestMapping("seller/supplierInfo.htm")
	public String supplierInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		ProductSearchOrder productSearchOrder = new ProductSearchOrder();
		String supplierId = request.getParameter("supplierId");
		SupplierInfo supplierInfo = userQueryService
			.querySupplierInfoDetail(NumberUtil.parseLong(supplierId, 0), productSearchOrder);
		Map<String, Object> map = new HashMap<String, Object>();
		if (supplierInfo != null) {
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			map = new HashMap<String, Object>();
			List<String> imgList = new ArrayList<String>();
	
			QueryBaseBatchResult<ProductInfo> baseBatchResult = new QueryBaseBatchResult<ProductInfo>();
			List<ProductInfo> productList = new ArrayList<ProductInfo>();
			if (supplierInfo.getHotels() == BooleanEnum.YES) {
				HotelStockProductOrder productOrder = new HotelStockProductOrder();
				productOrder.setStatus(HotelStockStatusEnum.ON);
				productOrder.setProductStatus(ProductStatusEnum.ON);
				productOrder.setSupplierId(NumberUtil.parseLong(supplierId, 0));
				WebUtil.setPoPropertyByRequest(productOrder, request);
				QueryBaseBatchResult<HotelsStockIbatisDO> hotelsResult = hotelsStockService
					.searchHotelLeftList(productOrder);
	
				for (HotelsStockIbatisDO infos : hotelsResult.getPageList()) {
					ProductInfo productInfo = new ProductInfo();
					productInfoCovertDO(productInfo, infos.getTblProductDO());
					productList.add(productInfo);
				}
				baseBatchResult.setTotalCount(hotelsResult.getTotalCount());
				baseBatchResult.setPageCount(hotelsResult.getPageCount());
			} else {
				SupplierProductSearchOrder order = new SupplierProductSearchOrder();
				WebUtil.setPoPropertyByRequest(order, request);
				//获取用户
				SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
				if (sessionLocal != null) {
					//游客中心
					if (sessionLocal.getUserBizType() == UserBizTypeEnum.SELLER) {
						order.setProductStatus(null);
					} else if (sessionLocal.getUserBizType() == UserBizTypeEnum.BUYER) {
						order.setProductStatus(ProductStatusEnum.ON);
					}
				} else {
					order.setProductStatus(ProductStatusEnum.ON);
				}
				order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
				if (supplierInfo.getOrderMeal() == BooleanEnum.NO) {
					order.setSaleTypeO2O(BooleanEnum.YES);
				}
				String productStatus = request.getParameter("productStatus");
				if (StringUtil.equals(productStatus, "all")) {
					order.setProductStatus(null);
				}
				baseBatchResult = productService.getSupplierAndProductList(order);
				for (ProductInfo infos : baseBatchResult.getPageList()) {
					productList.add(infos);
				}
				
			}
			List<String> supplierIdList = new ArrayList<>();
			supplierIdList.add(supplierId);
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			List<ProductUserCollectInfo> list = productUserService
				.getSupplierUserCollectList(userId, supplierIdList);
			if (ListUtil.isNotEmpty(list)) {
				model.addAttribute("collect", true);
			}else{
				model.addAttribute("collect", false);
			}
		//	map.put("isCollected", checkCollecteStatus(null, toString(supplierId)));
			model.addAttribute("productList", productList);
			model.addAttribute("productCount", baseBatchResult.getTotalCount());
		}
		return path + "supplier_info.vm";
	}
		
	protected void productInfoCovertDO(ProductInfo por, TblProductDO porSrc) {
		BeanCopier.staticCopy(porSrc, por);
		por.setProductVary(ProductVaryEnum.getByCode(porSrc.getProductVary()));
		por.setPostType(PostFeeTypeEnum.getByCode(porSrc.getPostType()));
		por.setFacade(RefundRuleEnum.getByCode(porSrc.getFacade()));
		por.setProductStatus(ProductStatusEnum.getByCode(porSrc.getProductStatus()));
		por.setSaleTypeB2c(BooleanEnum.getByCode(porSrc.getSaleTypeB2c()));
		por.setSaleTypeO2o(BooleanEnum.getByCode(porSrc.getSaleTypeO2o()));
		por.setSaleTypeHotels(BooleanEnum.getByCode(porSrc.getSaleTypeHotels()));
		por.setSaleTypeOrderMeal(BooleanEnum.getByCode(porSrc.getSaleTypeOrderMeal()));
		por.setTuneMeal(BooleanEnum.getByCode(porSrc.getTuneMeal()));
		por.setRecommend(BooleanEnum.getByCode(porSrc.getRecommend()));
		por.setMorningRoom(BooleanEnum.getByCode(porSrc.getMorningRoom()));
		por.setLongRentRoom(BooleanEnum.getByCode(porSrc.getLongRentRoom()));
		por.setSpecialRoom(BooleanEnum.getByCode(porSrc.getSpecialRoom()));
		por.setCustomType1(BooleanEnum.getByCode(porSrc.getCustomType1()));
		por.setCustomType2(BooleanEnum.getByCode(porSrc.getCustomType2()));
		por.setSupplierId(porSrc.getSupplierId());
	}
	/** 转化成字符串，防止空指针 */
	private static String toString(Object str) {
		if (str == null) {
			return "";
		}
		return String.valueOf(str);
		
	}

}
