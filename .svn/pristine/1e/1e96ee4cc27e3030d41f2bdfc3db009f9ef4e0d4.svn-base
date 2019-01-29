/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

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
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.bill.OrderService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.order.QueryOrderInfoSearchOrder;
import com.yjf.esupplier.ws.bill.order.RefundApplyOrder;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.product.enums.ProductTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 *
 *
 * @Filename OrderManageController.java
 *
 * @Description 后台订单管理
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-30下午4:24:46</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/order/")
public class OrderManageController extends BaseAutowiredController {
	
	private final String vm_path = "/backstage/systemManage/orderManage/";
	
	@Autowired
	protected OrderService orderService;
	
	/**
	 * 订单查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("queryOrderAll.htm")
	public String queryOrderAll(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			String orderStatus = request.getParameter("orderStatus");
			Long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
			String supplierName = request.getParameter("supplierName");
			String productName = request.getParameter("productName");
			String buyerNickname = request.getParameter("buyerNickname");
			String beginDate = request.getParameter("startCreateTime");
			String endDate = request.getParameter("endCreateTime");
			String orderType = request.getParameter("orderType");
			String productVary = request.getParameter("productVary");

			QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
			orderInfoSearchOrder.setPageNumber(pages);
			orderInfoSearchOrder.setPageSize(pagesize);
			orderInfoSearchOrder.setId(orderId);
			orderInfoSearchOrder.setSupplierName(supplierName);
			orderInfoSearchOrder.setItemProductName(productName);
			orderInfoSearchOrder.setBuyerNickname(buyerNickname);
			orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
			if (StringUtil.isNotBlank(beginDate)) {
				orderInfoSearchOrder.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				orderInfoSearchOrder.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(endDate)));
			}
			if (StringUtil.isNotEmpty(orderType)) {
				if (SaleTypeEnum.O2O.code().equals(orderType)
					|| SaleTypeEnum.B2C.code().equals(orderType)) {
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.B2C) {
						orderInfoSearchOrder.setSaleTypeB2c(BooleanEnum.YES);
						orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
						model.addAttribute("orderStatusEnumList",
							OrderStatusEnum.getAllEnumWithOut(""));
					}
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.O2O) {
						orderInfoSearchOrder.setSaleTypeO2o(BooleanEnum.YES);
						orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());
						model.addAttribute("orderStatusEnumList",
							OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
					}
					model.addAttribute("productTypeName", ProductTypeEnum.PRODUCT.message());
				}
				if(SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.HOTELS){
					orderInfoSearchOrder.setSaleTypeHotels(BooleanEnum.YES);
					model.addAttribute("orderStatusEnumList",
						OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
					model.addAttribute("productTypeName", ProductTypeEnum.HOTELS.message());
				}
				if (SaleTypeEnum.OFFLINE.code().equals(orderType)) {
					orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.OFFLINE.code());
					String inCode = OrderStatusEnum.JYC.code();
					model.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnumIn(inCode));
				}
				if (SaleTypeEnum.PAY_TO_SHOP.code().equals(orderType)) {
					orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());
					String inCode = OrderStatusEnum.WFK.code() + "-" + OrderStatusEnum.JYC.code();
					model.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnumIn(inCode));
				}
			}else if(StringUtil.isNotEmpty(productVary)){
				orderInfoSearchOrder.setProductVary(ProductVaryEnum.getByCode(productVary));
				//orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
				model.addAttribute("orderStatusEnumList",
						OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
				model.addAttribute("productTypeName", ProductTypeEnum.TICKET.message());
			}
			
			QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
				.findOrderList(orderInfoSearchOrder);
			
			PageTool pageTool = new PageTool();
			pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
			pageTool.setPageSize((int) baseBatchResult.getPageSize());
			pageTool.setTotalRow(baseBatchResult.getTotalCount());
			List<OrderInfo> listP = baseBatchResult.getPageList();
			
			model.addAttribute("page", PageUtil.getCovertPageByPageTools(listP, pageTool));
			model.addAttribute("orderType", orderType);
		} catch (Exception e) {
			logger.error("订单查询失败" + e.getMessage(), e);
		}
		
		return vm_path + "searchOrderList.vm";
	}
	
	/**
	 * 订单查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("queryOrderHotel.htm")
	public String queryOrderHotel(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			String orderStatus = request.getParameter("orderStatus");
			Long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
			String supplierName = request.getParameter("supplierName");
			String productName = request.getParameter("productName");
			String buyerNickname = request.getParameter("buyerNickname");
			String beginDate = request.getParameter("createTime");
			String endDate = request.getParameter("createTime");
			long resortsBusinessId = NumberUtil.parseLong(
				request.getParameter("resortsBusinessId"), -1);
			QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
			orderInfoSearchOrder.setPageNumber(pages);
			orderInfoSearchOrder.setPageSize(pagesize);
			orderInfoSearchOrder.setId(orderId);
			orderInfoSearchOrder.setSupplierName(supplierName);
			orderInfoSearchOrder.setItemProductName(productName);
			orderInfoSearchOrder.setBuyerNickname(buyerNickname);
			orderInfoSearchOrder.setResortsBusinessId(resortsBusinessId);
			orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
			if (StringUtil.isNotBlank(beginDate)) {
				orderInfoSearchOrder.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				orderInfoSearchOrder.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(endDate)));
			}
			orderInfoSearchOrder.setSaleTypeHotels(BooleanEnum.YES);
			QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
				.findOrderList(orderInfoSearchOrder);
			PageTool pageTool = new PageTool();
			pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
			pageTool.setPageSize((int) baseBatchResult.getPageSize());
			pageTool.setTotalRow(baseBatchResult.getTotalCount());
			List<OrderInfo> listP = baseBatchResult.getPageList();
			ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
			scenicQueryOrder.setStatus(UserStateEnum.NORMAL);
			scenicQueryOrder.setPageSize(99);
			List<ScenicInfo> scenicInfoList = scenicService.getScenicInfo(scenicQueryOrder)
				.getPageList();
			model.addAttribute("scenicInfoList", scenicInfoList);
			model.addAttribute("page", PageUtil.getCovertPageByPageTools(listP, pageTool));
			
		} catch (Exception e) {
			logger.error("订单查询失败" + e.getMessage(), e);
		}
		
		return vm_path + "searchOrderHotelList.vm";
	}
	
	/**
	 * 退款提交
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("refundHotelSubmit.json")
	public Object refundHotelSubmit(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject json = new JSONObject();
		
		RefundApplyOrder refundApplyOrder = new RefundApplyOrder();
		WebUtil.setPoPropertyByRequest(refundApplyOrder, request);
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
		long orderItemId = NumberUtil.parseLong(request.getParameter("orderItemId"), -1);
		setProcessOrder(refundApplyOrder);
		refundApplyOrder
			.setRefundType(RefundTypeEnum.getByCode(request.getParameter("refundType")));
		refundApplyOrder.setBizNo(orderId);
		refundApplyOrder.setOrderId(orderId);
		refundApplyOrder.setOrderItemId(orderItemId);
		refundApplyOrder.setRefundBackStage(BooleanEnum.YES);
		EsupplierBaseResult result = orderService.refundApply(refundApplyOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "退款成功！");
		} else {
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		return json;
	}
	
	protected void setProcessOrder(RefundApplyOrder refundApplyOrder) {
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		refundApplyOrder.setProcessorId(sessionLocal.getUserId());
		refundApplyOrder.setProcessName(sessionLocal.getUserName());
		refundApplyOrder.setBelongTo(sessionLocal.getBelongTo());
	}
}
