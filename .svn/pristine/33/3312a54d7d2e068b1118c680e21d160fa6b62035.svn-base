package com.yjf.esupplier.web.controller.front.scenicCenter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.service.base.data.BaseDataLoader;
import com.yjf.esupplier.service.exception.ExceptionFactory;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.service.user.result.InstitutionsInfoQueryResult;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.MerchantTypeEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.enums.SupplierApproveStateEnum;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SupplierDiningConfigOrder;

@Controller
@RequestMapping("/do/scenic")
public class MerchantManagerController extends FrontAutowiredBaseController {
	final static String path = "front/platform/member/merchant/";
	
	@Autowired
	BaseDataLoader baseDataLoader;
	
	@RequestMapping("doCenter/toUpdateMerchant.htm")
	public String toUpdateMerchant(HttpServletRequest request, HttpServletResponse response,
									PageParam pageParam, Model model) {
		model.addAttribute("uploadHost", "");
		String supplierId = request.getParameter("supplierId");
		model.addAllAttributes(WebUtil.getRequestMap(request));
		if (StringUtil.isEmpty(supplierId))
			supplierId = String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId());
		InstitutionsInfoQueryResult queryResult = userQueryService.queryMerchantInfoByUserId(Long
			.parseLong(supplierId));
		if (queryResult == null) {
			queryResult = new InstitutionsInfoQueryResult();
			queryResult.setQueryInstitutionsInfo(new InstitutionsInfo());
		}
		UserQueryResult result = userQueryService.queryByUserId(Long.parseLong(supplierId));
		UserInfo userInfo = null;
		if (result != null) {
			userInfo = result.getQueryUserInfo();
		}
		InstitutionsInfo institutionsInfo = queryResult.getQueryInstitutionsInfo();
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("info", institutionsInfo);
		model.addAttribute("foodList", AppConstantsUtil.getVarietiesOfFood());
		
		return path + "updateMerchant.vm";
	}
	
	@RequestMapping("doCenter/toUpdateMerchantType.htm")
	public String toUpdateMerchantTyte(HttpServletRequest request, HttpServletResponse response,
									PageParam pageParam, Model model) {
		model.addAttribute("uploadHost", "");
		String supplierId = request.getParameter("supplierId");
		model.addAllAttributes(WebUtil.getRequestMap(request));
		if (StringUtil.isEmpty(supplierId))
			supplierId = String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId());
		InstitutionsInfoQueryResult queryResult = userQueryService.queryMerchantInfoByUserId(Long
			.parseLong(supplierId));
		if (queryResult == null) {
			queryResult = new InstitutionsInfoQueryResult();
			queryResult.setQueryInstitutionsInfo(new InstitutionsInfo());
		}
		UserQueryResult result = userQueryService.queryByUserId(Long.parseLong(supplierId));
		UserInfo userInfo = null;
		if (result != null) {
			userInfo = result.getQueryUserInfo();
		}
		InstitutionsInfo institutionsInfo = queryResult.getQueryInstitutionsInfo();
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("info", institutionsInfo);
		model.addAttribute("foodList", AppConstantsUtil.getVarietiesOfFood());
		
		return path + "updateMerchantType.vm";
	}
	
	
	@RequestMapping("doCenter/updateMerchant.htm")
	public String updateMerchant(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String supplierId = request.getParameter("supplierInfo.supplierId");
		EsupplierBaseResult result = null;
		String merchantState = request.getParameter("supplierInfo.merchantStateEnum");
		String runState = request.getParameter("supplierInfo.runState");
		String diningRunState = request.getParameter("supplierInfo.diningRunState");
		String toShop = request.getParameter("supplierInfo.toShop");
		String productDiscount = request.getParameter("supplierInfo.productDiscount");
		String[] cooperationType = request.getParameterValues("cooperationType");
		BooleanEnum orderMeal = BooleanEnum.NO;
		BooleanEnum hotels = BooleanEnum.NO;
		BooleanEnum o2o = BooleanEnum.NO;
		BooleanEnum dining = BooleanEnum.NO;
		if (cooperationType != null) {
			for (String string : cooperationType) {
				if (string.equals("orderMeal")) {
					orderMeal = BooleanEnum.YES;
				} else if (string.equals("hotels")) {
					hotels = BooleanEnum.YES;
				} else if (string.equals("o2o")) {
					o2o = BooleanEnum.YES;
				} else if (string.equals("dining")) {
					dining = BooleanEnum.YES;
				}
			}
		}
		if (StringUtil.isEmpty(merchantState)) {
			merchantState = MerchantStateEnum.NOT_IN.code();
		}
		if (StringUtil.isEmpty(runState)) {
			runState = SupplierRunStateEnum.Closed.code();
		}
		if (StringUtil.isEmpty(diningRunState)) {
			diningRunState = SupplierRunStateEnum.Opening.code();
		}
		SupplierInfo supplierInfo = supplierService.getSupplier(Long.parseLong(supplierId));
		if (supplierInfo == null) {
			supplierInfo = new SupplierInfo();
			WebUtil.setPoPropertyByRequest(supplierInfo, request, "supplierInfo");
			supplierInfo.setSupplierId(Long.parseLong(supplierId));
			supplierInfo.setSupplierId(supplierInfo.getSupplierId());
			supplierInfo.setMerchantStateEnum(MerchantStateEnum.getByCode(merchantState));
			supplierInfo.setRunState(SupplierRunStateEnum.getByCode(runState));
			supplierInfo.setDiningRunState(SupplierRunStateEnum.getByCode(diningRunState));
			supplierInfo.setApproveState(SupplierApproveStateEnum.Completed);
			supplierInfo.setToShop(BooleanEnum.getByCode(toShop));
			supplierInfo.setOrderMeal(orderMeal);
			supplierInfo.setProductDiscount(NumberUtil.parseDouble(productDiscount));
			supplierInfo.setHotels(hotels);
			supplierInfo.setO2o(o2o);
			supplierInfo.setDining(dining);
			supplierService.insertSupplierInfo(supplierInfo);
		} else {
			WebUtil.setPoPropertyByRequest(supplierInfo, request, "supplierInfo");
			supplierInfo.setToShop(BooleanEnum.getByCode(toShop));
			supplierInfo.setMerchantStateEnum(MerchantStateEnum.IN);
			supplierInfo.setRunState(SupplierRunStateEnum.getByCode(runState));
			supplierInfo.setDiningRunState(SupplierRunStateEnum.getByCode(diningRunState));
			supplierInfo.setApproveState(SupplierApproveStateEnum.Completed);
			supplierInfo.setOrderMeal(orderMeal);
			supplierInfo.setHotels(hotels);
			supplierInfo.setO2o(o2o);
			supplierInfo.setProductDiscount(NumberUtil.parseDouble(productDiscount));
			supplierInfo.setDining(dining);
			result = supplierService.updateSupplier(supplierInfo);
		}
		if (!result.isSuccess()) {
			throw ExceptionFactory.newYrdException(EsupplierResultEnum.EXECUTE_FAILURE, "商户修改失败");
		}
		
		model.addAttribute("tip", "修改成功");
		return path + "merchantOK.vm";
	}
	
	@ResponseBody
	@RequestMapping("doCenter/updateMerchantState.htm")
	public Object updateMerchantState(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		JSONObject json = new JSONObject();
		String state = request.getParameter("state");
		String supplierId = request.getParameter("supplierId");
		EsupplierBaseResult result = null;
		//SupplierInfo supplierInfo = supplierService.getSupplierByUserId(supplierId);
		SupplierInfo supplierInfo = supplierService.getSupplier(Long.parseLong(supplierId));
		supplierInfo.setMerchantStateEnum(MerchantStateEnum.getByCode(state));
		result = supplierService.updateSupplier(supplierInfo, state);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "更新商户成功!");
		} else {
			json.put("code", 0);
			json.put("message", "更新商户失败:" + result.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("doCenter/updateMerchantGrade.htm")
	public Object updateMerchantGrade(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		JSONObject json = new JSONObject();
		String chgGrade = request.getParameter("chgGrade");
		String supplierId = request.getParameter("supplierId");
		EsupplierBaseResult result = null;
		result = supplierService.updateSupplierGrade(NumberUtil.parseLong(supplierId), chgGrade);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "更新商户等级成功!");
		} else {
			json.put("code", 0);
			json.put("message", "更新商户等级失败:" + result.getMessage());
		}
		return json;
		
	}
	
	@RequestMapping("doCenter/toMerchantList.htm")
	public String toMerchantList(HttpServletRequest request, HttpServletResponse response,
									PageParam pageParam, Model model) {
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		WebUtil.setPoPropertyByRequest(roleQueryOrder, request);
		SessionLocal local = ShiroSessionUtils.getSessionLocal();
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		String userBaseId = local.getUserBaseId();
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		roleQueryOrder.setPageSize(pagesize);
		roleQueryOrder.setPageNumber(pages);
		//roleQueryOrder.setType(UserTypeEnum.JG);
		roleQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
		roleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		roleQueryOrder.setMerchantStateEnum(MerchantStateEnum.getByCode(request
			.getParameter("merchantState")));
		roleQueryOrder.setMerchantTypeEnum(MerchantTypeEnum.getByCode(request
			.getParameter("merchantTypeEnum")));
		roleQueryOrder.setBelongTo(userInfo.getUserId());
		PageTool page = new PageTool();
		page.setCurrentPage(pages);
		page.setPageSize(pagesize);
		QueryBaseBatchResult<InstitutionsInfo> baseBatchResult = userQueryService
			.queryRoleMerchantUserInfo(roleQueryOrder);
		UserRoleQueryOrder spotQueryOrder = new UserRoleQueryOrder();
		spotQueryOrder.setPageNumber(-1);
		spotQueryOrder.setType(UserTypeEnum.JG);
		spotQueryOrder.setRoleEnum(SysUserRoleEnum.VISITOR_CENTER);
		spotQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		//		QueryBaseBatchResult<UserInfo> spotList = userQueryService
		//				.queryRoleUserInfo(spotQueryOrder);
		page.setTotalRow(baseBatchResult.getTotalCount());
		String pageBar = page.getPageBar();
		//		model.addAttribute("spotList", spotList.getPageList());
		model.addAttribute("queryConditions", roleQueryOrder);
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		return path + "merchantList.vm";
		
	}
	
	@RequestMapping("doCenter/toMerchantDiningConfig.htm")
	public String toMerchantDiningConfig(HttpServletRequest request, HttpServletResponse response,
											PageParam pageParam, Model model) {
		
		String supplierId = request.getParameter("supplierId");
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		SessionLocal local = ShiroSessionUtils.getSessionLocal();
		String userBaseId = local.getUserBaseId();
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		roleQueryOrder.setPageSize(1);
		roleQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
		roleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		roleQueryOrder.setBelongTo(userInfo.getUserId());
		roleQueryOrder.setOrderMeal(BooleanEnum.YES);
		roleQueryOrder.setLoadAll(true);
		QueryBaseBatchResult<SupplierInfo> result = userQueryService
			.queryRoleSupplierUserInfo(roleQueryOrder);
		List<SupplierInfo> supplierInfos = Lists.newArrayList();
		for (SupplierInfo supplierInfo : result.getPageList()) {
			if (supplierInfo.getSupplierId() != Long.valueOf(supplierId)) {
				supplierInfos.add(supplierInfo);
			}
		}
		model.addAttribute("supplierInfos", supplierInfos);
		List<Long> supplierIdsList = supplierService.findAvailableSupplierIds(Long
			.valueOf(supplierId));
		
		model.addAttribute("supplierIds", supplierIdsList);
		model.addAttribute("supplierId", supplierId);
		return path + "merchantDiningConfig.vm";
		
	}
	
	@RequestMapping("doCenter/merchantDiningConfig.htm")
	public String merchantDiningConfig(HttpServletRequest request, HttpServletResponse response,
										PageParam pageParam, Model model) {
		
		String supplierId = request.getParameter("supplierId");
		String[] availableSupplierIds = request.getParameterValues("availableSupplierId");
		SupplierDiningConfigOrder order = new SupplierDiningConfigOrder();
		order.setSupplierId(Long.valueOf(supplierId));
		if (availableSupplierIds != null) {
			List<Long> list = Lists.newArrayList();
			for (String str : availableSupplierIds) {
				list.add(Long.valueOf(str));
			}
			order.setAvailableSupplierIds(list);
		}
		
		EsupplierBaseResult result = supplierService.updateSupplierDiningConfig(order);
		if (!result.isSuccess()) {
			throw ExceptionFactory.newYrdException(EsupplierResultEnum.EXECUTE_FAILURE, "调餐商户配置失败");
		}
		model.addAttribute("tip", "调餐商户配置成功");
		return path + "merchantOK.vm";
		
	}
	
}
