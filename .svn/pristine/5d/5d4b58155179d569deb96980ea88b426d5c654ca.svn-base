/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.product.ProductTypeService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.order.MerchantRegisterOrder;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.service.user.result.PersonalQueryResult;
import com.yjf.esupplier.service.user.result.UserRegisterResult;
import com.yjf.esupplier.web.controller.base.SupplierBaseController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.enums.SupplierApproveStateEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SearchSupplierQueryOrder;
import com.yjf.esupplier.ws.supplier.order.SupplierSettingOrder;

/**
 * 
 * 
 * @Filename SupplierManageController.java
 * 
 * @Description 供应商管理控制器
 * 
 * @Version 1.0
 * 
 * @Author min
 * 
 * @Email oyangnuo@yiji.com
 * 
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-28上午9:36:47</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/supplier/")
public class SupplierManageController extends SupplierBaseController {
	
	private final String vm_path = "/backstage/systemManage/supplierManage/";
	
	@Autowired
	ProductTypeService productTypeService;
	
	/**
	 * 查询供应商列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listSupplier.htm")
	public String listSupplier(HttpServletRequest request, Model model) {
		
		model.addAllAttributes(WebUtil.getRequestMap(request));
		String pageType = request.getParameter("pageType"); //如果是查询按钮的提交，就把页数值为初始值
		String approveState = request.getParameter("approveState");//从管理员后台首页过来的参数
		String fullName = request.getParameter("fullName");
		String supplierType = request.getParameter("supplierType");
		String runState = request.getParameter("runState");
		SupplierInfo supplier = null;
		int page = (int) NumberUtil.parseLong(request.getParameter("pageNo"), 1);
		int pageSize = (int) NumberUtil.parseLong(request.getParameter("pageSize"), 10);
		if (StringUtil.isNotBlank(approveState)) {
			supplier = new SupplierInfo();
			supplier.setApproveState(SupplierApproveStateEnum.ManualVerify);
		}
		if (pageType != null) {
			page = 1;
			pageSize = 10;
		}
		PageTool pageTool = new PageTool();
		
		SearchSupplierQueryOrder queryOrder = new SearchSupplierQueryOrder();
		queryOrder.setPageNumber(page);
		queryOrder.setPageSize(pageSize);
		queryOrder.setApproveState(SupplierApproveStateEnum.getByCode(approveState));
		queryOrder.setSupplierType(supplierType);
		queryOrder.setRunState(SupplierRunStateEnum.getByCode(runState));
		queryOrder.setSearchName(fullName);
		QueryBaseBatchResult<SupplierInfo> batchResult = supplierService.listSupplier(queryOrder);
		long count = batchResult.getTotalCount();
		pageTool.setCurrentPage((int) batchResult.getPageNumber());
		pageTool.setPageSize((int) batchResult.getPageSize());
		pageTool.setTotalRow((int) count);
		
		model.addAttribute("pageBar", pageTool.getPageBar());
		model.addAttribute("page",
			PageUtil.getCovertPageByPageTools(batchResult.getPageList(), pageTool));
		model.addAttribute("searchlist", batchResult.getPageList());
		return vm_path + "supplier_list.vm";
		
	}
	
	/**
	 * 查询供应商详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getSupplierById.htm")
	public String getSupplierById(HttpServletRequest request, Model model) {
		long id = NumberUtil.parseLong(request.getParameter("id"), -1);
		try {
			UserInfo userInfo = userQueryService.queryByUserId(id).getQueryUserInfo();
			SupplierInfo supplierInfo = supplierService.getSupplier(id);
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("supplier", supplierInfo);
			if (userInfo.getType() == UserTypeEnum.GR) {
				model.addAttribute("personalInfo",
					userQueryService.queryPersonalInfoByBaseId(userInfo.getUserBaseId())
						.getQueryPersonalInfo());
			} else {
				model.addAttribute("institutionsInfo", userQueryService
					.queryInstitutionsInfoByBaseId(userInfo.getUserBaseId())
					.getQueryInstitutionsInfo());
			}
			
			initProductType(model, supplierInfo);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return vm_path + "supplier_info.vm";
		
	}
	
	/**
	 * 审核供应商
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("adminCheckSupplier.htm")
	public String adminCheckSupplier(HttpServletRequest request, Model model) {
		
		String supplierIdset = request.getParameter("supplierIdset");
		String checktype = request.getParameter("checktype");
		
		String[] supplierIdArray = supplierIdset.split(",");
		
		for (int i = 0; i < supplierIdArray.length; i++) {
			
			supplierService.checkSupplier(NumberUtil.parseLong(supplierIdArray[i]), checktype);
		}
		
		return listSupplier(request, model);
		
	}
	
	/**
	 * 删除供应商
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("delSupplierInfo.htm")
	public String delSupplierInfo(HttpServletRequest request, Model model) {
		
		return "";
		
	}
	
	/**
	 * 供应商是否诚信
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updPromiseState.htm")
	public String updPromiseState(HttpServletRequest request, Model model) {
		
		return "";
		
	}
	
	/**
	 * 冻结、恢复供应商
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updSupplierLocked.htm")
	public String updSupplierLocked(HttpServletRequest request, Model model) {
		
		String lock = request.getParameter("lock");
		String supplierIdset = request.getParameter("supplierIdset");
		
		String[] arrySupplierID = supplierIdset.split(",");
		for (int i = 0; i < arrySupplierID.length; i++) {
			
			supplierService.lockSupplier(NumberUtil.parseLong(arrySupplierID[i]), lock);
		}
		return listSupplier(request, model);
		
	}
	
	/**
	 * 查询供应商列表--综合查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("generalListSupplier.htm")
	public String generalListSupplier(HttpServletRequest request, Model model) {
		
		return vm_path + "general_supplier_list.vm";
		
	}
	
	/**
	 * 添加供应商--进入页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAddSupplier.htm")
	public String addSupplier(HttpSession session, Model model) {
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		return vm_path + "supplier_add.vm";
		
	}
	
	/**
	 * 检查供应商BY用户名
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkSupplier.json")
	public Object checkSupplier(String userName, HttpServletRequest request, Model model) {
		
		JSONObject json = new JSONObject();
		logger.info("检查供应商操作，入参{}", userName);
		EsupplierBaseResult result = supplierService.checkSupplierByUserName(userName);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "可以开通供应商");
		} else {
			json.put("code", 0);
			json.put("message", result.getCreditsysResultEnum().message());
		}
		
		return json;
	}
	
	/**
	 * 重置商家密码（身份证后6位）
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("resetPassword.json")
	public Object resetPassword(long supplierId,HttpServletRequest request, Model model) {
		
		JSONObject json = new JSONObject();
		logger.info("重置商家密码操作，入参{}", supplierId);
		SupplierSettingOrder supplierSettingOrder = new SupplierSettingOrder();
		supplierSettingOrder.setSupplierId(supplierId);
		EsupplierBaseResult result = supplierService.resetPassword(supplierSettingOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "重置密码成功");
		} else {
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		
		return json;
	}
	
	
	/**
	 * 添加供应商--供应商私人信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("addSupplier.htm")
	public String addSupplier(String userName, HttpServletRequest request,
								HttpServletResponse response, Model model) {
		
		String userId = request.getParameter("userId");
		if (StringUtil.isNotBlank(userId)) {
			UserInfo userInfo = userQueryService.queryByUserId(NumberUtil.parseLong(userId))
				.getQueryUserInfo();
			model.addAttribute("userInfo", userInfo);
			PersonalQueryResult personalQueryResult = userQueryService
				.queryPersonalInfoByBaseId(userInfo.getUserBaseId());
			model.addAttribute("info", personalQueryResult.getQueryPersonalInfo());
			SupplierInfo supplierInfo = supplierService.getSupplier(userInfo.getUserId());
			model.addAttribute("supplierInfo", supplierInfo);
			initProductType(model, supplierInfo);
		}
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		scenicQueryOrder.setPageSize(999);
		QueryBaseBatchResult<ScenicInfo> scenicInfoResult = scenicService
			.getScenicInfo(scenicQueryOrder);
		model.addAttribute("scenicList", scenicInfoResult.getPageList());
		return vm_path + "supplier_personalinfo.vm";
		
	}
	
	/**
	 * 添加供应商--提交
	 * @param userName
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addSupplierSubmit.json")
	public Object addSupplierSubmit(String userName, HttpServletRequest request, Model model) {
		
		JSONObject json = new JSONObject();
		boolean isUpdate = true;
		UserInfo userInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (userInfo == null) {
			userInfo = new UserInfo();
			isUpdate = false;
		}
		MerchantRegisterOrder registerOrder = new MerchantRegisterOrder();
		WebUtil.setPoPropertyByRequest(registerOrder, request);
		String o2o = request.getParameter("o2o");
		if(StringUtil.isNotEmpty(o2o)){
			registerOrder.setO2o(BooleanEnum.YES);
		}else{
			registerOrder.setO2o(BooleanEnum.NO);
		}
		String hotels = request.getParameter("hotels");
		if(StringUtil.isNotEmpty(hotels)){
			registerOrder.setHotels(BooleanEnum.YES);
		}else{
			registerOrder.setHotels(BooleanEnum.NO);
		}
		registerOrder.setRunState(SupplierRunStateEnum.getByCode(request.getParameter("runState")));
		registerOrder.setUserCustomType(UserBizTypeEnum.SELLER);
		UserRegisterResult registerResult = registerService.merchantRegister(registerOrder);
		
		if (isUpdate) {
			if (registerResult.isSuccess()) {
				json.put("code", 1);
				json.put("message", "修改供应商成功");
			} else {
				json.put("code", 0);
				json.put("message", registerResult.getMessage());
			}
		} else {
			if (registerResult.isSuccess()) {
				json.put("code", 1);
				json.put("message", "添加供应商成功");
			} else {
				json.put("code", 0);
				json.put("message", registerResult.getMessage());
			}
		}
		
		return json;
	}
	
	/**
	 * 产品类型
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getAllType.htm")
	public String getAllType(HttpServletRequest request, HttpServletResponse response, Model model)
																									throws Exception {
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		List<ProductTypeInfo> firstType = productTypeService.getFirstProductType(queryOrder);
		List<ProductTypeInfo> secondType = productTypeService.getSecondProductType(queryOrder);
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(queryOrder);
		model.addAllAttributes(WebUtil.getRequestMap(request));
		model.addAttribute("firstType", firstType);
		model.addAttribute("secondType", secondType);
		model.addAttribute("thridType", thridType);
		return "front/productType/selectProductType.vm";
	}
	/**
	 * 查询供应商详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getSupplierDetailById.htm")
	public String getSupplierDetailById(HttpServletRequest request, Model model) {
		String userId = request.getParameter("userId");
		if (StringUtil.isNotBlank(userId)) {
			UserInfo userInfo = userQueryService.queryByUserId(NumberUtil.parseLong(userId))
				.getQueryUserInfo();
			model.addAttribute("userInfo", userInfo);
			PersonalQueryResult personalQueryResult = userQueryService
				.queryPersonalInfoByBaseId(userInfo.getUserBaseId());
			model.addAttribute("info", personalQueryResult.getQueryPersonalInfo());
			SupplierInfo supplierInfo = supplierService.getSupplier(userInfo.getUserId());
			model.addAttribute("supplierInfo", supplierInfo);
			initProductType(model, supplierInfo);
		}
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		scenicQueryOrder.setPageSize(999);
		QueryBaseBatchResult<ScenicInfo> scenicInfoResult = scenicService
			.getScenicInfo(scenicQueryOrder);
		model.addAttribute("scenicList", scenicInfoResult.getPageList());
		
		return vm_path + "supplier_personalinfoDetail.vm";
		
	}
}
