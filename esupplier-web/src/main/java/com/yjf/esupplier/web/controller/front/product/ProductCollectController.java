/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.product;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.pop.PopUserService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.CollectionStateEnum;
import com.yjf.esupplier.ws.enums.PopUserTypeEnum;
import com.yjf.esupplier.ws.info.PopUserInfo;
import com.yjf.esupplier.ws.order.PopUserOrder;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.info.ProductUserCollectInfo;
import com.yjf.esupplier.ws.product.order.ProductUserOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SupplierHotelQueryOrder;

/**
 *
 *
 * @Filename ProductCollectController.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-17下午3:02:54</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/do/productCollect")
public class ProductCollectController extends FrontAutowiredBaseController {
	static String path = "front/hotel/";
	@Autowired
	PopUserService popUserService;
	final static String vm_path = "front/platform/member/collection/";
	
	/**
	 * 收藏商品
	 * @param order
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("collectProduct.json")
	public Object collectProduct(ProductUserOrder order, HttpServletRequest request,
									HttpServletResponse response, Model model) {
		JSONObject jsonobj = new JSONObject();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		if (userId > 0) {
			order.setUserId(userId);
			logger.info("商品收藏入参：{}", order);
			EsupplierBaseResult result = productUserService.insertProductUser(order);
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "商品收藏成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "你已收藏过该商品");
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请登录收藏");
		}
		
		return jsonobj;
	}
	
	/**
	 * 我收藏的商品列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("myCollectProductList.htm")
	public String myCollectProductList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			
			ProductUserOrder order = new ProductUserOrder();
			String orderColType = StringUtil.defaultIfEmpty(request.getParameter("orderColType"),
				CollectionStateEnum.PRODUCT_COL.getCode());
			order.setCollectionStateEnum(CollectionStateEnum.getByCode(orderColType));
			order.setPageNumber(pages);
			order.setPageSize(pagesize);
			order.setUserId(userId);
			if (StringUtil.isNotBlank(beginDate)) {
				order.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				order
					.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil.strToDtSimpleFormat(endDate)));
			}
			
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productUserService
				.getProductUserList(order);
			
			PageTool page = new PageTool();
			page.setCurrentPage(pages);
			page.setPageSize(pagesize);
			page.setTotalRow(baseBatchResult.getTotalCount());
			String pageBar = page.getPageBar();
			List<ProductInfo> collectionList = baseBatchResult.getPageList();
			
			model.addAttribute("list", collectionList);
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("beginTime",
				com.yjf.esupplier.common.util.DateUtil.simpleFormatYmd(new Date()));
			model.addAttribute("endTime", com.yjf.esupplier.common.util.DateUtil
				.simpleFormatYmd(com.yjf.esupplier.common.util.DateUtil.getAfterDay(new Date())));
		} catch (Exception e) {
			logger.error("我收藏的商品列表查询失败" + e.getMessage(), e);
		}
		
		return vm_path + "collectProductList.vm";
	}
	
	/**
	 * 取消收藏的商品
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cancelCollect.json")
	public Object cancelCollect(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		long productId = NumberUtil.parseLong(request.getParameter("productId"), 0);
		long supplierId = NumberUtil.parseLong(request.getParameter("supplierId"), 0);
		JSONObject jsonobj = new JSONObject();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		logger.info("取消商品收藏入参：{}", userId, productId);
		EsupplierBaseResult result = productUserService.deleteProductUser(userId, productId,
			supplierId);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "已取消");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "取消失败");
		}
		
		return jsonobj;
	}
	
	/**
	 * 检查商品的收藏状态
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkCollectState.json")
	public Object checkCollectState(String productIds, HttpServletRequest request,
									HttpServletResponse response, Model model) {
		StringBuffer productIdsRe = new StringBuffer();
		if (StringUtil.isNotBlank(productIds) && ShiroSessionUtils.getSessionLocal() != null) {
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			
			List<String> productIdList = ListUtil.toList(productIds, ",");
			List<ProductUserCollectInfo> productUserCollectInfoList = productUserService
				.getProductUserCollectList(userId, productIdList);
			for (ProductUserCollectInfo collectInfo : productUserCollectInfoList) {
				if (productIdsRe.length() == 0) {
					productIdsRe.append("," + collectInfo.getProductId() + ",");
				} else {
					productIdsRe.append(collectInfo.getProductId() + ",");
				}
			}
			logger.info("检查商品的收藏状态入参：{}", userId, productIds);
		}
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("productIdsRe", productIdsRe.toString());
		return jsonobj;
	}
	
	/**
	 * 检查商户的收藏状态
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkHotelCollectState.json")
	public Object checkHotelCollectState(String supplierIds, HttpServletRequest request,
											HttpServletResponse response, Model model) {
		StringBuffer supplierIdsRe = new StringBuffer();
		if (StringUtil.isNotBlank(supplierIds) && ShiroSessionUtils.getSessionLocal() != null) {
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			
			List<String> supplierIdList = ListUtil.toList(supplierIds, ",");
			List<ProductUserCollectInfo> productUserCollectInfoList = productUserService
				.getSupplierUserCollectList(userId, supplierIdList);
			for (ProductUserCollectInfo collectInfo : productUserCollectInfoList) {
				if (supplierIdsRe.length() == 0) {
					supplierIdsRe.append("," + collectInfo.getProductId() + ",");
				} else {
					supplierIdsRe.append(collectInfo.getProductId() + ",");
				}
			}
			logger.info("检查商户的收藏状态入参：{}", userId, supplierIds);
		}
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("supplierIdsRe", supplierIdsRe.toString());
		return jsonobj;
	}
	
	/**
	 * 收藏的商品数量
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("collectStatis.json")
	public Object collectStatis(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		
		JSONObject jsonobj = new JSONObject();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		ProductUserOrder order = new ProductUserOrder();
		order.setUserId(userId);
		order.setPageNumber(1);
		order.setPageSize(999999);
		order.setCollectionStateEnum(CollectionStateEnum.PRODUCT_COL);
		/*收藏的商品*/
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productUserService
			.getProductUserList(order);
		SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setUserId(userId);
		QueryBaseBatchResult<SupplierInfo> baseBatchSupplierResult = supplierService
			.searchCollectHotelSupplier(queryOrder);
		/*收藏的攻略*/
		PopUserOrder popUserOrder = new PopUserOrder();
		popUserOrder.setUserId(userId);
		popUserOrder.setType(PopUserTypeEnum.COLLECT);
		QueryBaseBatchResult<PopUserInfo> popAgreeInfoResult = popUserService
			.getPopUserList(popUserOrder);
		if (baseBatchResult.isSuccess() && popAgreeInfoResult.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "查询成功");
			jsonobj.put("totalCount",
				baseBatchResult.getTotalCount() + popAgreeInfoResult.getTotalCount()
						+ baseBatchSupplierResult.getTotalCount());
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "查询失败");
		}
		
		return jsonobj;
	}
	
	/**
	 * 我收藏的酒店列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("hotel/collectHotelList.htm")
	public String collectHotelList(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String type = "";
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			type = request.getParameter("type");
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			String productType = request.getParameter("productType");
			if (StringUtil.isEmpty(productType)) {
				productType = "0001-0002";
			}
			if (StringUtil.isNotBlank(productType)) {
				String[] productTypes = productType.split("-");
				int i = 0;
				String typeForProduct = "";
				for (String item : productTypes) {
					if (typeForProduct.length() == 0) {
						typeForProduct = item;
					} else {
						typeForProduct = typeForProduct + "-" + item;
					}
					ProductTypeInfo productTypeInfoRoot = baseDataLoader
						.getProductTypeInfoByCode(typeForProduct);
					model.addAttribute("productTypeInfo" + i, productTypeInfoRoot);
					i++;
				}
			}
			SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
			WebUtil.setPoPropertyByRequest(queryOrder, request);
			queryOrder.setUserId(userId);
			QueryBaseBatchResult<SupplierInfo> baseBatchResult = supplierService
				.searchCollectHotelSupplier(queryOrder);
			PageTool page = new PageTool();
			page.setCurrentPage(pages);
			page.setPageSize(pagesize);
			page.setTotalRow(baseBatchResult.getTotalCount());
			
			List<SupplierInfo> collectionList = baseBatchResult.getPageList();
			model.addAttribute("page", PageUtil.getCovertPageByPageTools(collectionList, page));
			model.addAttribute("list", collectionList);
		} catch (Exception e) {
			logger.error("我收藏的商品列表查询失败" + e.getMessage(), e);
		}
		if (StringUtil.equals(type, "HOTEL_PERSON")) {
			return path + "collectPersonHotelList.vm";
		} else {
			return path + "collectHotelList.vm";
		}
	}
	
	/**
	 * 历史入住酒店 2016-10-21
	 * 
	 * @throws Exception
	 * @throws Exception
	 * @author lihu
	 * @return5
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("hotel/toHistoryHotelList.htm")
	public String toHistoryHotelList(HttpServletRequest request, HttpServletResponse response,
										Model model) throws Exception {
		String merchantName = request.getParameter("merchantName");
		long pageNumber = NumberUtil.parseLong(request.getParameter("pageNumber"), 1);
		long pageSize = NumberUtil.parseLong(request.getParameter("pageSize"), 10);
		String productType = request.getParameter("productType");
		if (StringUtil.isEmpty(productType)) {
			productType = "0001-0002";
		}
		if (StringUtil.isNotBlank(productType)) {
			String[] productTypes = productType.split("-");
			int i = 0;
			String typeForProduct = "";
			for (String item : productTypes) {
				if (typeForProduct.length() == 0) {
					typeForProduct = item;
				} else {
					typeForProduct = typeForProduct + "-" + item;
				}
				ProductTypeInfo productTypeInfoRoot = baseDataLoader
					.getProductTypeInfoByCode(typeForProduct);
				model.addAttribute("productTypeInfo" + i, productTypeInfoRoot);
				i++;
			}
		}
		QueryBaseBatchResult<SupplierInfo> result = new QueryBaseBatchResult<SupplierInfo>();
		SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setSearchName(merchantName);
		queryOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		queryOrder.setPageNumber(pageNumber);
		queryOrder.setPageSize(pageSize);
		result = supplierService.searchBuyHotelSupplier(queryOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) result.getPageNumber());
		pageTool.setPageSize((int) result.getPageSize());
		pageTool.setTotalRow(result.getTotalCount());
		List<SupplierInfo> productList = result.getPageList();
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(productList, pageTool));
		return path + "historyHotelList.vm";
	}
	
	/**
	 * 收藏商户
	 * @param order
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("collectSupplier.json")
	public Object collectSupplier(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject jsonobj = new JSONObject();
		ProductUserOrder order = new ProductUserOrder();
		String supplierId = request.getParameter("supplierId");
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		if (userId > 0) {
			order.setUserId(userId);
			order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
			logger.info("商户收藏入参：{}", order);
			EsupplierBaseResult result = productUserService.insertProductUser(order);
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "商户收藏成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "你已收藏过该商户");
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请登录收藏");
		}
		
		return jsonobj;
	}
	
}
