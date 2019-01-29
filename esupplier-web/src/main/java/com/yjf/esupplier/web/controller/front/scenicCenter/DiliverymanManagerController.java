/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 上午10:08:31 创建
 */
package com.yjf.esupplier.web.controller.front.scenicCenter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.domain.ProductDomain;
import com.yjf.esupplier.domain.service.repository.ProductDomainRepository;
import com.yjf.esupplier.service.exception.ExceptionFactory;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.RegisterService;
import com.yjf.esupplier.service.user.info.DeliveryPersonInfo;
import com.yjf.esupplier.service.user.order.DeliveryPersonRegisterOrder;
import com.yjf.esupplier.service.user.order.DeliveryPersonSearchOrder;
import com.yjf.esupplier.service.user.order.UpdateDeliveryPersonOrder;
import com.yjf.esupplier.service.user.result.UserRegisterResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.userManage.enums.DeliveryPersonStatusEnum;

/**
 *
 *
 * @author zhouwei
 *
 */
@Controller
@RequestMapping("/do/scenic")
public class DiliverymanManagerController extends FrontAutowiredBaseController {
	
	final static String					path	= "front/platform/member/delivery/";
	@Autowired
	RegisterService						registerService;
	@Autowired
	protected ProductDomainRepository	productDomainRepository;
	
	/*技师列表*/
	@RequestMapping("doCenter/toDeliveryPersonList.htm")
	public String toDeliveryPersonList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		DeliveryPersonSearchOrder personSearchOrder = new DeliveryPersonSearchOrder();
		WebUtil.setPoPropertyByRequest(personSearchOrder, request);
		SessionLocal local = ShiroSessionUtils.getSessionLocal();
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		String nickName = request.getParameter("nickName"); /*编号*/
		String realName = request.getParameter("realName"); /*姓名*/
		personSearchOrder.setPageSize(pagesize);
		personSearchOrder.setPageNumber(pages);
		if (local.getUserBizType() == UserBizTypeEnum.VISITOR_CENTER) {
			personSearchOrder.setBelongTo(local.getUserId());
		} else {
			personSearchOrder.setBelongTo(local.getBelongTo());
		}
		personSearchOrder.setNickName(nickName);
		personSearchOrder.setRealName(realName);
		personSearchOrder.setStatus(DeliveryPersonStatusEnum.getByCode(request
			.getParameter("status")));
		PageTool page = new PageTool();
		page.setCurrentPage(pages);
		page.setPageSize(pagesize);
		QueryBaseBatchResult<DeliveryPersonInfo> baseBatchResult = deliveryPersonService
			.getPersonList(personSearchOrder);
		page.setTotalRow(baseBatchResult.getTotalCount());
		String pageBar = page.getPageBar();
		model.addAttribute("queryConditions", personSearchOrder);
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		return path + "deliveryPersonList.vm";
	}
	
	/*技师编辑*/
	@RequestMapping("doCenter/deliveryPersonEdit.htm")
	public String deliveryPersonEdit(HttpServletRequest request, HttpServletResponse response,
										PageParam pageParam, Model model) {
		DeliveryPersonInfo personInfo = new DeliveryPersonInfo();
		String userId = request.getParameter("userId"); /*ID*/
		if (StringUtil.isNotEmpty(userId)) {
			personInfo = deliveryPersonService.getPersonInfo(NumberUtil.parseLong(userId));
		}
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		List<ProductTypeInfo> productTypeInfoList = productTypeService.getSecondProductType(queryOrder);
		String[] serviceTypes = personInfo.getServiceType().split(",");
		for (ProductTypeInfo typeInfo : productTypeInfoList) {
			for (String type : serviceTypes) {
				if (typeInfo.getPtCode().equals(type)) {
					typeInfo.setCheckType(BooleanEnum.YES);
				}
			}
			
		}
		personInfo.setProductTypeInfoList(productTypeInfoList);
		model.addAttribute("personInfo", personInfo);
		return path + "deliveryPersonEdit.vm";
	}
	
	/*技师状态修改*/
	@ResponseBody
	@RequestMapping("doCenter/statusSubmit.json")
	public Object statusSubmit(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject jsonobj = new JSONObject();
		long userId = NumberUtil.parseLong(request.getParameter("userId"));
		if (userId <= 0) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "配送员信息有误");
			return jsonobj;
		}
		String status = request.getParameter("status");
		UpdateDeliveryPersonOrder deliveryPersonOrder = new UpdateDeliveryPersonOrder();
		DeliveryPersonStatusEnum statusEnum = DeliveryPersonStatusEnum.getByCode(status);
		if (statusEnum == null) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "配送员状态有误");
			return jsonobj;
		}
		deliveryPersonOrder.setUserId(userId);
		deliveryPersonOrder.setStatus(statusEnum);
		logger.info("配送员状态设置入参：{}", deliveryPersonOrder);
		EsupplierBaseResult result = deliveryPersonService
			.updateDeliveryPersonStatus(deliveryPersonOrder);
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "配送员状态设置成功");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", result.getMessage());
		}
		
		return jsonobj;
	}
	
	/*技师编辑*/
	@RequestMapping("doCenter/deliveryPersonAdd.htm")
	public String deliveryPersonAdd(HttpServletRequest request, HttpServletResponse response,
									PageParam pageParam, Model model) {
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		List<ProductTypeInfo> productTypeInfoList = productTypeService.getSecondProductType(queryOrder);
		model.addAttribute("productTypeInfoList", productTypeInfoList);
		return path + "deliveryPersonAdd.vm";
	}
	
	/*技师信息提交*/
	@ResponseBody
	@RequestMapping("doCenter/deliveryPersonSubmit.json")
	public Object deliveryPersonSubmit(HttpServletRequest request, HttpServletResponse response,
										PageParam pageParam, Model model) {
		JSONObject json = new JSONObject();
		DeliveryPersonInfo personInfo = new DeliveryPersonInfo();
		WebUtil.setPoPropertyByRequest(personInfo, request, "personInfo");
		String mobile = request.getParameter("mobile");
		if (StringUtil.isEmpty(mobile) || mobile.length() < 7) {
			throw ExceptionFactory.newYrdException(EsupplierResultEnum.INCOMPLETE_REQ_PARAM,
				"手机号输入有误");
		}
		String[] serviceTypeArr = request.getParameterValues("serviceTypes");
		String serviceTypes = "";
		if (serviceTypeArr != null) {
			for (String serviceType : serviceTypeArr) {
				serviceTypes += serviceType + ",";
			}
			
			if (StringUtil.isNotBlank(serviceTypes)) {
				serviceTypes = serviceTypes.substring(0, serviceTypes.length() - 1);
			}
			personInfo.setServiceType(serviceTypes);
		}
		if (personInfo.getUserId() != 0) {/*修改*/
			
		} else {/*新增*/
			DeliveryPersonRegisterOrder registerOrder = new DeliveryPersonRegisterOrder();
			registerOrder.setMobile(mobile);
			registerOrder.setParentId(ShiroSessionUtils.getSessionLocal().getBelongTo());
			registerOrder.setNikeName(personInfo.getNickName());
			registerOrder.setRealName(personInfo.getRealName());
			registerOrder.setUserName(personInfo.getUserName());
			registerOrder.setLogPassword(mobile.substring(mobile.length() - 6, mobile.length()));
			registerOrder.setPayPassword(mobile.substring(mobile.length() - 6, mobile.length()));
			registerOrder.setServiceType(serviceTypes);
			registerOrder.setLevel(personInfo.getLevel());
			UserRegisterResult registerResult = registerService
				.registerDeliveryPerson(registerOrder);
			if (registerResult.isSuccess() && registerResult.getUserinfo() != null) {
				json.put("code", 1);
				json.put("message", "新增技师成功");
			} else {
				json.put("code", 0);
				json.put("message", "新增技师失败:"+registerResult.getMessage());
			}
			
			//return json;
		}
		return json;
		
	}
	
	/*技师信息提交*/
	@ResponseBody
	@RequestMapping("doCenter/deliveryPersonModify.json")
	public Object deliveryPersonModify(HttpServletRequest request, HttpServletResponse response,
										PageParam pageParam, Model model) {
		
		UpdateDeliveryPersonOrder deliveryPersonOrder = new UpdateDeliveryPersonOrder();
		WebUtil.setPoPropertyByRequest(deliveryPersonOrder, request, "personInfo");
		String[] serviceTypeArr = request.getParameterValues("serviceTypes");
		String serviceTypes = "";
		for (String serviceType : serviceTypeArr) {
			serviceTypes += serviceType + ",";
		}
		if (StringUtil.isNotBlank(serviceTypes)) {
			serviceTypes = serviceTypes.substring(0, serviceTypes.length() - 1);
		}
		deliveryPersonOrder.setServiceType(serviceTypes);
		deliveryPersonOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getUserId());
		JSONObject json = new JSONObject();
		
		EsupplierBaseResult result = deliveryPersonService
			.updateDeliveryPerson(deliveryPersonOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改技师成功");
		} else {
			json.put("code", 0);
			json.put("message", "修改技师失败");
		}
		
		return json;
	}
	
	/*技师信息提交*/
	@ResponseBody
	@RequestMapping("doCenter/findTecForOrder.json")
	public Object findTecForOrder(HttpServletRequest request, HttpServletResponse response,
									PageParam pageParam, Model model) {
		JSONObject json = new JSONObject();
		String productId = request.getParameter("productId");
		String orderId = request.getParameter("orderId");
		ProductDomain productDomain = productDomainRepository.active(
			NumberUtil.parseLong(productId), false);
		if (productDomain == null) {
			json.put("code", 0);
			json.put("message", "无效商品");
			return json;
		}
		String userType = ShiroSessionUtils.getSessionLocal().getUserBizType().getCode();
		DeliveryPersonSearchOrder searchOrder = new DeliveryPersonSearchOrder();
		if (userType.equals(UserBizTypeEnum.SELLER.getCode())) {
			searchOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getUserId());
		} else if (userType.equals(UserBizTypeEnum.VISITOR_CENTER.getCode())
					|| userType.equals(UserBizTypeEnum.VISITOR_OPERATOR.getCode())) {
			searchOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		List<String> serviceTypeList = new ArrayList<String>();
		if (StringUtil.isEmpty(productDomain.getProductType())) {
			json.put("code", 0);
			json.put("message", "商品所属分类有误！");
			return json;
		}
		String[] productTypes = productDomain.getProductType().split("-");
		String preType = "";
		for (int i = 0; i < productTypes.length; i++) {
			if (i != 0)
				serviceTypeList.add(preType + productTypes[i]);
			preType = productTypes[i] + "-";
		}
		searchOrder.setServiceType(serviceTypeList);
		searchOrder.setStatus(DeliveryPersonStatusEnum.UNWANTED);
		QueryBaseBatchResult<DeliveryPersonInfo> deliveryResult = deliveryPersonService
			.getPersonList(searchOrder);
		String optionStr = "";
		if (ListUtil.isNotEmpty(deliveryResult.getPageList())) {
			optionStr = convertToOption(deliveryResult.getPageList());
		}
		if (deliveryResult.isSuccess()) {
			json.put("code", 1);
			json.put("message", "查询技师成功");
			json.put("optionStr", optionStr);
			json.put("orderId", orderId);
		} else {
			json.put("code", 0);
			json.put("message", "查询技师失败");
		}
		
		return json;
	}
	
	private String convertToOption(List<DeliveryPersonInfo> deliveryList) {
		StringBuffer returnDeliveryBuffer = new StringBuffer();
		for (DeliveryPersonInfo deliveryPersonInfo : deliveryList) {
			returnDeliveryBuffer.append("<option value=" + deliveryPersonInfo.getUserId() + ">"
										+ deliveryPersonInfo.getNickName() + "</option>");
		}
		return returnDeliveryBuffer.toString();
	}
}
