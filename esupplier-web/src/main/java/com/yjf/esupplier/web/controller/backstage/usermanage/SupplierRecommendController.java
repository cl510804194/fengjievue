/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.usermanage;

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
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.SupplierRecommendTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SupplierRecommendOrder;

/**
 * 商户推荐管理
 *
 * @Filename SupplierRecommendController.java
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
@RequestMapping("/admin/supplier/recommend")
public class SupplierRecommendController extends BaseAutowiredController {
	
	private final String vm_path = "/backstage/userManage/";
	
	/**
	 * 推荐商户
	 * @param order
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("recommendSupplier.json")
	public Object recommendSupplier(SupplierRecommendOrder order,HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject jsonobj = new JSONObject();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		order.setUserId(userId);
		order.setSupplierId(NumberUtil.parseLong(request.getParameter("supplierId")));
		if(order.getRecommendType()==null)  order.setRecommendType(SupplierRecommendTypeEnum.SUPPLIER_TOP);
		logger.info("商户推荐入参：{}", order);
		EsupplierBaseResult result = supplierRecommendService.insertSupplierRecommend(order);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "商户推荐成功");
			supplierService.updateRecommend(order.getSupplierId(), BooleanEnum.YES.getCode());
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "你已推荐过该商户");
		}
		
		return jsonobj;
	}
	
	/**
	 * 查询收藏商户列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("recommendSupplierList.htm")
	public String recommendSupplierList(HttpServletRequest request, HttpServletResponse response,
			Model model){
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("pageNo"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			long supplierId = NumberUtil.parseLong(request.getParameter("supplierId"));
			String recommendType = request.getParameter("recommendType");
			SupplierRecommendOrder order = new SupplierRecommendOrder();
			order.setSupplierId(supplierId);
			order.setPageNumber(pages);
			order.setPageSize(pagesize);
			order.setOrderNormal("NORMAL");
			order.setRecommendType(SupplierRecommendTypeEnum.getByCode(recommendType));
			if (StringUtil.isNotBlank(beginDate)) {
				order.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				order.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(endDate)));
			}
			QueryBaseBatchResult<SupplierInfo> baseBatchResult = supplierRecommendService.getSupplierRecommendList(order);
			PageTool pageTool = new PageTool();
			pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
			pageTool.setPageSize((int) baseBatchResult.getPageSize());
			pageTool.setTotalRow(baseBatchResult.getTotalCount());
			List<SupplierInfo> collectionList = baseBatchResult.getPageList();
			
			model.addAttribute("page", PageUtil.getCovertPageByPageTools(collectionList, pageTool));
			model.addAttribute("recommendType", recommendType);
		} catch (Exception e) {
			logger.error("收藏商户列表查询失败" + e.getMessage(), e);
		}

		return vm_path + "recommendSupplierList.vm";
	}
	
	/**
	 * 取消商户推荐
	 * @param supplierId
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cancelRecommend.json")
	public Object cancelRecommend(long supplierId,HttpServletRequest request, HttpServletResponse response,
			Model model){
		
		JSONObject jsonobj = new JSONObject();
		logger.info("取消商户推荐入参：{}", supplierId);
		String recommendType = request.getParameter("recommendType");
		if(StringUtil.isEmpty(recommendType)) recommendType = SupplierRecommendTypeEnum.SUPPLIER_TOP.getCode();
		EsupplierBaseResult result = supplierRecommendService.deleteSupplierRecommend(supplierId, recommendType);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "已取消");
			long cnt = supplierRecommendService.getRecommendCount(supplierId,recommendType);
			if(cnt==0){
				supplierService.updateRecommend(supplierId, BooleanEnum.NO.getCode());
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "取消失败");
		}
		
		return jsonobj;
	}

}
