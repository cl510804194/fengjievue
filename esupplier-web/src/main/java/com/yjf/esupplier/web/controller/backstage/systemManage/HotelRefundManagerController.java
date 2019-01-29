/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.domain.ProductDomain;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.PopTypeEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelDiscountInfo;
import com.yjf.esupplier.ws.hotel.info.HotelSetRefundInfo;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.ScenicInfo;

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
import com.yjf.esupplier.service.hotel.HotelsSetRefundService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.order.HotelDiscountOrder;
import com.yjf.esupplier.ws.order.HotelSetRefundOrder;
import com.yjf.esupplier.ws.order.HotelSetRefundQueryOrder;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

/**
 * 酒店管理-退款设置
 *
 * @Filename ProductRecommendController.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author lihu
 *
 * @Email dgetian@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-10-13下午4:47:21</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/admin/hotel/refund")
public class HotelRefundManagerController extends BaseAutowiredController {
	
	private final String vm_path = "/backstage/hotel/";
	
	/**
	 * 退款设置列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setRefundHotelList.htm")
	public String setRefundHotelList(HttpServletRequest request, HttpServletResponse response,
			Model model){
		HotelSetRefundQueryOrder hotelSetRefundQueryOrder = new HotelSetRefundQueryOrder();	
		hotelSetRefundQueryOrder.setLimitStart(0);
		hotelSetRefundQueryOrder.setPageSize(10);
		QueryBaseBatchResult<HotelSetRefundInfo> batchResult = hotelsSetRefundService.searchSetHotelRefundList(hotelSetRefundQueryOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) batchResult.getPageNumber());
		pageTool.setPageSize((int) batchResult.getPageSize());
		pageTool.setTotalRow(batchResult.getTotalCount());
		List<HotelSetRefundInfo> listHotel = batchResult.getPageList();
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(listHotel, pageTool));
		return vm_path + "hotelRefundList.vm";
	}
	/**
	 * 新增退款设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("addSetRefundHotel.htm")
	public String addSetRefundHotel(HttpServletRequest request, HttpServletResponse response,
			Model model){
		model.addAttribute("userLevelEnum", UserLevelEnum.getAllEnum());
		return vm_path + "addSetRefundHotel.vm";
	}
	
	/**
	 * 提交新增退款设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addSetRefundHotelSubmit.json")
	public Object addSetRefundHotelSubmit(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String []userGradeArr = request.getParameterValues("userGrade");
		String refundTime = request.getParameter("refundTime");
		if(userGradeArr == null || StringUtil.isEmpty(refundTime)){
			json.put("code", 0);
			json.put("message", "应用等级或者退款时间不能为空");
		}
		HotelSetRefundOrder hotelSetRefundOrder = new HotelSetRefundOrder();
		hotelSetRefundOrder.setRefundTime(refundTime);
		String userGrades = "";
		for(String userGrade : userGradeArr){
			if(StringUtil.isNotBlank(userGrade)){
				userGrades += userGrade+",";
			}
		}
		userGrades = userGrades.substring(0,userGrades.length()-1);
		hotelSetRefundOrder.setUserGrades(userGrades);
		EsupplierBaseResult baseResult = hotelsSetRefundService.addSetHotelRefund(hotelSetRefundOrder);
		if(baseResult.isSuccess()){
			json.put("code", 1);
			json.put("message", "新增成功");
		}else{
			json.put("code", 0);
			json.put("message", baseResult.getMessage());
		}
		return json;
	}
	
	/**
	 * 修改退款设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("modifySetRefundHotel.htm")
	public String modifySetRefundHotel(HttpServletRequest request, HttpServletResponse response,
			Model model){
		String userGrades = request.getParameter("userGrades");
		String refundTime = request.getParameter("refundTime");
		HotelSetRefundQueryOrder hotelSetRefundQueryOrder = new HotelSetRefundQueryOrder();	
		if(StringUtil.isNotBlank(userGrades)){
			hotelSetRefundQueryOrder.setUserGrades(userGrades);
		}
		if(StringUtil.isNotBlank(refundTime)){
			hotelSetRefundQueryOrder.setRefundTime(refundTime);
		}
		QueryBaseBatchResult<HotelSetRefundInfo> batchResult = hotelsSetRefundService.searchSetHotelRefundList(hotelSetRefundQueryOrder);
		List<HotelSetRefundInfo>  hotelSetRefundInfos = batchResult.getPageList();
		if(ListUtil.isNotEmpty(hotelSetRefundInfos))
		model.addAttribute("hotelSetRefundInfo", hotelSetRefundInfos.get(0));
	//	model.addAttribute("hotelSetRefundInfos", hotelSetRefundInfos);
		model.addAttribute("userLevelEnum", UserLevelEnum.getAllEnum());
		model.addAttribute("userGrades", userGrades);
		return vm_path + "modifySetRefundHotel.vm";
	}
	
	/**
	 * 提交修改退款设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("modifySetRefundHotelSubmit.json")
	public Object modifySetRefundHotelSubmit(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String userGradeHis = request.getParameter("userGradeHis");
		String []userGradeArr = request.getParameterValues("userGrade");
		String refundTime = request.getParameter("refundTime");
		String hotelRefundId = request.getParameter("hotelRefundId");
		long hotelRefund = 0;
		if(StringUtil.isNotEmpty(hotelRefundId)){
			hotelRefund = NumberUtil.parseLong(hotelRefundId);
		}
		HotelSetRefundOrder hotelSetRefundOrder = new HotelSetRefundOrder();
		String userGrades = "";
		for(String userGrade : userGradeArr){
			if(StringUtil.isNotBlank(userGrade)){
				userGrades += userGrade+",";
			}
		}
		userGrades = userGrades.substring(0,userGrades.length()-1);
		hotelSetRefundOrder.setUserGrades(userGrades);
		hotelSetRefundOrder.setRefundTime(refundTime);
		hotelSetRefundOrder.setHotelRefundId(hotelRefund);
		hotelSetRefundOrder.setUserGradeHis(userGradeHis);
		EsupplierBaseResult batchResult = hotelsSetRefundService.modifySetHotelRefund(hotelSetRefundOrder);
		if(batchResult.isSuccess()){
			json.put("code", 1);
			json.put("message", "修改成功");
		}else{
			json.put("code", 0);
			json.put("message", batchResult.getMessage());
		}
		return json;
	}
	
	/**
	 * 删除退款设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delSetRefundHotelSubmit.json")
	public Object delSetRefundHotelSubmit(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String hotelRefundId = request.getParameter("hotelRefundId");
		HotelSetRefundInfo hotelSetRefundInfo = new HotelSetRefundInfo();
		hotelSetRefundInfo.setHotelRefundId(NumberUtil.parseLong(hotelRefundId,0));
		EsupplierBaseResult batchResult = hotelsSetRefundService.delSetHotelRefund(hotelSetRefundInfo);
		if(batchResult.isSuccess()){
			json.put("code", 1);
			json.put("message", "删除成功");
		}else{
			json.put("code", 0);
			json.put("message", batchResult.getMessage());
		}
		return json;
	}
}
