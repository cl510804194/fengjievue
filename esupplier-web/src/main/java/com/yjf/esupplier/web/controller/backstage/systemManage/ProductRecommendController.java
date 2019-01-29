/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.domain.ProductDomain;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 商品推荐管理
 *
 * @Filename ProductRecommendController.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-26下午4:47:21</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/admin/product/recommend")
public class ProductRecommendController extends BaseAutowiredController {
	
	private final String vm_path = "/backstage/systemManage/productRrecommend/";
	
	/**
	 * 推荐商品
	 * @param order
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("recommendProduct.json")
	public Object recommendProduct(ProductRecommendOrder order,HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject jsonobj = new JSONObject();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		order.setUserId(userId);
		if(order.getRecommendType()==null)  order.setRecommendType(ProductRecommendTypeEnum.PRODUCT_TOP);
		logger.info("商品推荐入参：{}", order);
		EsupplierBaseResult result = productRecommendService.insertProductRecommend(order);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "商品推荐成功");
			ProductDomain productDomain = productDomainRepository.active(order.getProductId(),true);
			productDomain.setRecommend(BooleanEnum.YES);
			productDomainRepository.reStore(productDomain);
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "你已推荐过该商品");
		}
		
		return jsonobj;
	}
	
	/**
	 * 查询收藏商品列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("recommendProductList.htm")
	public String recommendProductList(HttpServletRequest request, HttpServletResponse response,
			Model model){
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("pageNo"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			String productName = request.getParameter("productName");
			String recommendType = request.getParameter("recommendType");
			if (StringUtil.isEmpty(recommendType)) {
				recommendType = ProductRecommendTypeEnum.PRODUCT_TOP.getCode();
			}
			String saleType = request.getParameter("saleType");
			ProductRecommendOrder order = new ProductRecommendOrder();
			if(StringUtil.isNotEmpty(saleType)){
				if(saleType.equals(SaleTypeEnum.O2O.getCode())){
					order.setSaleTypeO2o(BooleanEnum.YES);
				}else if(saleType.equals(SaleTypeEnum.HOTELS.getCode())){
					order.setSaleTypeHotels(BooleanEnum.YES);
				}
			}
			order.setProductName(productName);
			order.setPageNumber(pages);
			order.setPageSize(pagesize);
			order.setOrderNormal("NORMAL");
			order.setRecommendType(ProductRecommendTypeEnum.getByCode(recommendType));
			if (StringUtil.isNotBlank(beginDate)) {
				order.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				order.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(endDate)));
			}
			
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productRecommendService.getProductRecommendList(order);
			
			PageTool pageTool = new PageTool();
			pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
			pageTool.setPageSize((int) baseBatchResult.getPageSize());
			pageTool.setTotalRow(baseBatchResult.getTotalCount());
			List<ProductInfo> collectionList = baseBatchResult.getPageList();
			
			model.addAttribute("page", PageUtil.getCovertPageByPageTools(collectionList, pageTool));
			model.addAttribute("productName", productName);
			model.addAttribute("recommendType", recommendType);
		} catch (Exception e) {
			logger.error("收藏商品列表查询失败" + e.getMessage(), e);
		}

		return vm_path + "recommendProductList.vm";
	}
	
	/**
	 * 取消商品推荐
	 * @param productId
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cancelRecommend.json")
	public Object cancelRecommend(long productId,HttpServletRequest request, HttpServletResponse response,
			Model model){
		
		JSONObject jsonobj = new JSONObject();
		logger.info("取消商品推荐入参：{}", productId);
		String recommendType = request.getParameter("recommendType");
		if(StringUtil.isEmpty(recommendType)) recommendType = ProductRecommendTypeEnum.PRODUCT_TOP.getCode();
		EsupplierBaseResult result = productRecommendService.deleteProductRecommend(productId,recommendType);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "已取消");
			long cnt = productRecommendService.getRecommendCount(productId,recommendType);
			if(cnt==0){
				ProductDomain productDomain = productDomainRepository.active(productId,true);
				productDomain.setRecommend(BooleanEnum.NO);
				productDomainRepository.reStore(productDomain);
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "取消失败");
		}
		
		return jsonobj;
	}

}
