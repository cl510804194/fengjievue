/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.enums.PopTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelDiscountInfo;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.order.HotelDiscountOrder;
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
@RequestMapping("/admin/hotel/discount")
public class HotelManagerController extends BaseAutowiredController {
	
	private final String vm_path = "/backstage/hotel/";
	
	/**
	 * 特殊房型列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("hotelDiscountList.htm")
	public String hotelDiscountList(HttpServletRequest request, HttpServletResponse response,
			Model model){
		HotelDiscountOrder hotelDiscountOrder = new HotelDiscountOrder();	
		QueryBaseBatchResult<HotelDiscountInfo> batchResult = hotelsDiscountService.searchHotelReleaseList(hotelDiscountOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) batchResult.getPageNumber());
		pageTool.setPageSize((int) batchResult.getPageSize());
		pageTool.setTotalRow(batchResult.getTotalCount());
		List<HotelDiscountInfo> listHotel = batchResult.getPageList();
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(listHotel, pageTool));
		return vm_path + "hotelDiscountList.vm";
	}
	/**
	 * 新增特殊房型
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("addDiscountHotel.htm")
	public String addDiscountHotel(HttpServletRequest request, HttpServletResponse response,
			Model model){
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		List<ScenicInfo> scenicList = scenicService.getScenicInfo(scenicQueryOrder).getPageList();
		Map<String,Object> conditions = new HashMap<String,Object>();
		List<String> type = new ArrayList<String>();
		int typeInt = PopTypeEnum.DISCOUNTDAY.getDbValue();
		type.add(String.valueOf(typeInt));
		conditions.put("type", type);
		conditions.put("sortDay", "title");
		List<PopInfo> popInfos = popService.getListByConditionsRem(conditions);

		model.addAttribute("hotelEnum", HotelTypeEnum.getAllEnum());
		model.addAttribute("scenicList", scenicList);
		model.addAttribute("popInfos", popInfos);
		return vm_path + "addDiscountHotel.vm";
	}
	
	/**
	 * 特殊房型提交
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addDiscountHotelSubmit.json")
	public Object addDiscountHotelSubmit(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String scenicId = request.getParameter("scenicId");
		String type = request.getParameter("type");
		String discountBegin = request.getParameter("discountBegin");
		String discountEnd = request.getParameter("discountEnd");
		if(StringUtil.isNotEmpty(discountEnd) && StringUtil.isNotEmpty(discountEnd)){
			
		}
		String setTime = request.getParameter("setTime");
		String setLongTime = request.getParameter("setLongTime");
		HotelDiscountInfo hotelDiscountInfo = new HotelDiscountInfo();
		
		hotelDiscountInfo.setScenicId(Long.parseLong(scenicId));
		hotelDiscountInfo.setType(HotelTypeEnum.getByCode(type));
		hotelDiscountInfo.setDiscountBegin(NumberUtil.parseInt(discountBegin));
		hotelDiscountInfo.setDiscountEnd(NumberUtil.parseInt(discountEnd));
		if (hotelDiscountInfo.getType() == HotelTypeEnum.LONGRENT) {
			hotelDiscountInfo.setSetTime(setLongTime);
		}
		if (hotelDiscountInfo.getType() == HotelTypeEnum.MORNING) {
			hotelDiscountInfo.setSetTime(setTime);
		}
		EsupplierBaseResult result = hotelsDiscountService.insertHotelDiscount(hotelDiscountInfo);
		if(result.isSuccess()){
			json.put("code", 1);
			json.put("message", result.getMessage());
		}else{
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		return json;
	}

	/**
	 * 修改特殊房型
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updateDiscountHotel.htm")
	public String updateDiscountHotel(HttpServletRequest request, HttpServletResponse response,
			Model model){
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		List<ScenicInfo> scenicList = scenicService.getScenicInfo(scenicQueryOrder).getPageList();
		//		Map<String,Object> conditions = new HashMap<String,Object>();
		//		int typeInt = PopTypeEnum.DISCOUNTDAY.getDbValue();
		//		List<String> type = new ArrayList<String>();
		//		type.add(String.valueOf(typeInt));
		//		conditions.put("type", type);
		//		conditions.put("sortDay", "title");
		//		List<PopInfo> popInfos = popService.getListByConditionsRem(conditions);
		String hotelDiscountId = request.getParameter("hotelDiscountId");
		HotelDiscountInfo hotelDiscountInfo = hotelsDiscountService.selectHotelDiscountById(Long.parseLong(hotelDiscountId));
		String setTime = hotelDiscountInfo.getSetTime();
		String[] setTimes = null;
		if (StringUtil.isNotBlank(setTime)) {
			setTimes = setTime.split(",");
		}
		model.addAttribute("setTimes", setTimes);
		model.addAttribute("setTime", setTime);
		model.addAttribute("hotelEnum", HotelTypeEnum.getAllEnum());
		model.addAttribute("scenicList", scenicList);
		//		model.addAttribute("popInfos", popInfos);
		model.addAttribute("hotelDiscountInfo", hotelDiscountInfo);
		return vm_path + "updateDiscountHotel.vm";
	}
	
	/**
	 * 修改特殊房型提交
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateDiscountHotelSubmit.json")
	public Object updateDiscountHotelSubmit(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String hotelDiscountId = request.getParameter("hotelDiscountId");
		String scenicId = request.getParameter("scenicId");
		String type = request.getParameter("type");
		String discountBegin = request.getParameter("discountBegin");
		String discountEnd = request.getParameter("discountEnd");
		//		String []setTime = request.getParameterValues("setTime");
		//		String setTimes = "";
		//		for(String sTime : setTime){
		//			if(StringUtil.isNotBlank(sTime)){
		//				
		//				setTimes += sTime + ','; 
		//			}
		//		}
		//		if(StringUtil.isNotBlank(setTimes)){
		//			setTimes = setTimes.substring(0, setTimes.length()-1);
		//		}
		String setTime = request.getParameter("setTime");
		String setLongTime = request.getParameter("setLongTime");
		HotelDiscountInfo hotelDiscountInfo = new HotelDiscountInfo();
		hotelDiscountInfo.setHotelDiscountId(Long.parseLong(hotelDiscountId));
		hotelDiscountInfo.setScenicId(Long.parseLong(scenicId));
		hotelDiscountInfo.setType(HotelTypeEnum.getByCode(type));
		hotelDiscountInfo.setDiscountBegin(NumberUtil.parseInt(discountBegin));
		hotelDiscountInfo.setDiscountEnd(NumberUtil.parseInt(discountEnd));
		if (hotelDiscountInfo.getType() == HotelTypeEnum.LONGRENT) {
			hotelDiscountInfo.setSetTime(setLongTime);
		}
		if (hotelDiscountInfo.getType() == HotelTypeEnum.MORNING) {
			hotelDiscountInfo.setSetTime(setTime);
		}
		EsupplierBaseResult result = hotelsDiscountService.modifyHotelDiscount(hotelDiscountInfo);
		if(result.isSuccess()){
			json.put("code", 1);
			json.put("message", result.getMessage());
		}else{
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		return json;
	}
	
	
	/**
	 * 删除特殊房型
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delDiscountHotel.json")
	public Object delDiscountHotel(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String hotelDiscountId = request.getParameter("hotelDiscountId");
		HotelDiscountInfo hotelDiscountInfo = new HotelDiscountInfo();
		hotelDiscountInfo.setHotelDiscountId(Long.parseLong(hotelDiscountId));
		EsupplierBaseResult result = hotelsDiscountService.delHotelDiscount(hotelDiscountInfo);
		if(result.isSuccess()){
			json.put("code", 1);
			json.put("message", result.getMessage());
		}else{
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		return json;
	}
	
	/**
	 * 新增时间设置
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addLongrentDay.json")
	public Object addLongrentDay(HttpServletRequest request, HttpServletResponse response,
			Model model){
		JSONObject json = new JSONObject();
		String title = request.getParameter("title");
		String hotelDiscountId = request.getParameter("hotelDiscountId");
		PopInfo popInfo = new PopInfo();
		popInfo.setTitle(title);
		popInfo.setType(Short.valueOf(String.valueOf(PopTypeEnum.DISCOUNTDAY.getDbValue())));
		try{
			 popService.addNotice(popInfo);
			 json.put("code", 1);
			 json.put("message", "增加成功");
			 json.put("title", title);
		}catch(Exception e){
			json.put("code", 0);
			json.put("message","增加失败");
		}

		return json;
	}
}
