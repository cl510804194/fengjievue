package com.yjf.esupplier.web.controller.front.BaseController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import rop.thirdparty.com.google.common.collect.Lists;

import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.enums.BillSearchOrderByEnum;
import com.yjf.esupplier.ws.bill.enums.OrderDeleteStatus;
import com.yjf.esupplier.ws.bill.enums.OrderFlowStatus;
import com.yjf.esupplier.ws.bill.enums.OrderRefundStatusEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.bill.info.DiningOrderInfo;
import com.yjf.esupplier.ws.bill.info.LogisticInfo;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.info.OrderItemInfo;
import com.yjf.esupplier.ws.bill.order.CancelBillOrder;
import com.yjf.esupplier.ws.bill.order.DelBillOrder;
import com.yjf.esupplier.ws.bill.order.QueryOrderInfoSearchOrder;
import com.yjf.esupplier.ws.bill.order.SaveDeliveryShipOrder;
import com.yjf.esupplier.ws.bill.order.SendQrCodeOrder;
import com.yjf.esupplier.ws.bill.order.TradeReviewOrder;
import com.yjf.esupplier.ws.bill.result.OrderSellerShipResult;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.review.info.TradeReviewInfo;
import com.yjf.esupplier.ws.review.order.TradeReviewCreateOrder;
import com.yjf.esupplier.ws.review.order.TradeReviewQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
public class UserOrderManagerBaseController extends FrontAutowiredBaseController {
	
	final static String	vm_path	= "front/platform/member/trade/";
	final static String	path	= "front/platform/member/delivery/";
	
	public String queryBuyOrder(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		int count = 0;
		String delStatus = OrderDeleteStatus.NO.getCode();
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			String orderStatus = request.getParameter("orderStatus");
			Long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
			String workflowStatus = request.getParameter("workflowStatus");
			String supplierName = request.getParameter("supplierName");
			String productName = request.getParameter("productName");
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			String takeWays = request.getParameter("takeWays");
			String displayAndNone = request.getParameter("displayAndNone");
			String refundStatus = request.getParameter("refundStatus");
			delStatus = StringUtil.defaultIfEmpty(request.getParameter("delStatus"),
				OrderDeleteStatus.NO.getCode());
			String orderType = request.getParameter("orderType");
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			List<String> batchIds = new ArrayList<String>();
			PageTool page = new PageTool();
			page.setCurrentPage(pages);
			page.setPageSize(pagesize);
			QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
			orderInfoSearchOrder.setWorkflowStatus(OrderFlowStatus.getByCode(request
				.getParameter("workflowStatus")));
			if (StringUtil.equals(orderStatus, OrderStatusEnum.JYC.code())) {
				List<OrderStatusEnum> statusList = new ArrayList<>();
				statusList.add(OrderStatusEnum.JYC);
				statusList.add(OrderStatusEnum.YGB);
				statusList.add(OrderStatusEnum.YQX);
				orderInfoSearchOrder.setStatusList(statusList);
			} else {
				orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
			}
			if (StringUtil.isNotEmpty(orderType)) {
				if (SaleTypeEnum.O2O.code().equals(orderType)
					|| SaleTypeEnum.B2C.code().equals(orderType)) {
					orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.B2C) {
						orderInfoSearchOrder.setSaleTypeB2c(BooleanEnum.YES);
						model.addAttribute("orderStatusEnumList",
							OrderStatusEnum.getAllEnumWithOut(""));
					}
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.O2O) {
						orderInfoSearchOrder.setSaleTypeO2o(BooleanEnum.YES);
						model.addAttribute("orderStatusEnumList",
							OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
					}
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
				if (SaleTypeEnum.HOTELS.code().equals(orderType)) {
					orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());
					orderInfoSearchOrder.setSaleTypeHotels(BooleanEnum.YES);
				}
			} else {
				orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
				orderInfoSearchOrder.setSaleTypeO2o(BooleanEnum.YES);
				model.addAttribute("orderStatusEnumList",
					OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
			}
			if (StringUtil.equals(refundStatus, OrderRefundStatusEnum.ALL.code())) {
				List<OrderRefundStatusEnum> refundList = new ArrayList<>();
				refundList.add(OrderRefundStatusEnum.REFUND_FAIL);
				refundList.add(OrderRefundStatusEnum.REFUND_SUCCESS);
				refundList.add(OrderRefundStatusEnum.REFUNDING);
				orderInfoSearchOrder.setRefundStatusList(refundList);
			}
			orderInfoSearchOrder.setPageNumber(pages);
			orderInfoSearchOrder.setPageSize(pagesize);
			orderInfoSearchOrder.setOrderId(request.getParameter("orderId"));
			orderInfoSearchOrder.setSupplierName(supplierName);
			orderInfoSearchOrder.setItemProductName(productName);
			orderInfoSearchOrder.setTakeWays(takeWays);
			orderInfoSearchOrder.setUserId(userId);
			//	orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
			orderInfoSearchOrder.setWorkflowStatus(OrderFlowStatus.getByCode(workflowStatus));
			orderInfoSearchOrder.setDelStatus(delStatus);
			if (StringUtil.isNotBlank(beginDate)) {
				orderInfoSearchOrder.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				orderInfoSearchOrder.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(endDate)));
			}
			QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
				.findOrderList(orderInfoSearchOrder);
			
			page.setTotalRow(baseBatchResult.getTotalCount());
			String pageBar = page.getPageBar();
			List<OrderInfo> orderList = baseBatchResult.getPageList();
			covertOrderInfo(orderList);
			
			//评价
			int i = 0;
			int[] reviewed = new int[orderList.size()];
			List<OrderInfo> newOrderList = Lists.newArrayList();
			if (ListUtil.isNotEmpty(orderList)) {
				//	orderStatus != null && orderStatus.equals("JYC") &&
				OrderInfo lastOrder = null;
				for (OrderInfo orderInfo : orderList) {
					if (lastOrder == null) {
						lastOrder = orderInfo;
						List<OrderItemInfo> items = Lists.newArrayList();
						items.add(orderInfo.getOrderItemInfo());
						orderInfo.setOrderItems(items);
						newOrderList.add(orderInfo);
					} else {
						if (lastOrder.getId() == orderInfo.getId()) {
							lastOrder.getOrderItems().add(orderInfo.getOrderItemInfo());
						} else {
							List<OrderItemInfo> items = Lists.newArrayList();
							items.add(orderInfo.getOrderItemInfo());
							orderInfo.setOrderItems(items);
							newOrderList.add(orderInfo);
							lastOrder = orderInfo;
							newOrderList.add(orderInfo);
						}
					}
					//if (orderInfo.getOrderStatus() == OrderStatusEnum.JYC) {
					if (orderInfo.getOrderStatus() == OrderStatusEnum.YFK) {
						if (userId == orderInfo.getSupplierId()) {
							reviewed[i] = 2;
						} else {
							TradeReviewQueryOrder queryOrder = new TradeReviewQueryOrder();
							queryOrder.setBuyerId(userId);
							queryOrder.setOrderId(orderInfo.getId());
							List<TradeReviewInfo> tradeReviewInfos = tradeReviewService
								.queryTradeReview(queryOrder).getPageList();
							if (ListUtil.isNotEmpty(tradeReviewInfos)) {
								reviewed[i] = 1;
							} else {
								reviewed[i] = 0;
							}
						}
						
					} else {
						reviewed[i] = -1;
					}
					
					i++;
				}
			}
			model.addAttribute("orderType", orderType);
			model.addAttribute("orderList", orderList);
			model.addAttribute("reviewed", reviewed);
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnum());
		} catch (Exception e) {
			logger.error("前台订单查询失败" + e.getMessage(), e);
		}
		if (StringUtil.equals("YES", delStatus)) {
			return vm_path + "recycleOrder.vm";
		} else {
			return vm_path + "queryBuyOrder.vm";
		}
	}
	
	public String querySoldOrderList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		model.addAllAttributes(WebUtil.getRequestMap(request));
		UserBizTypeEnum userBizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		
		String orderStatus = request.getParameter("orderStatus");
		//		long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
		List<String> batchIds = new ArrayList<String>();
		String buyerName = request.getParameter("buyerName");
		String productName = request.getParameter("productName");
		String supplierName = request.getParameter("supplierName");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String takeWays = request.getParameter("takeWays");
		String orderType = request.getParameter("orderType");
		
		PageTool page = new PageTool();
		page.setCurrentPage(pages);
		page.setPageSize(pagesize);
		QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
		orderInfoSearchOrder.setPageNumber(pages);
		orderInfoSearchOrder.setPageSize(pagesize);
		//		orderInfoSearchOrder.setId(orderId);
		orderInfoSearchOrder.setOrderId(request.getParameter("orderId"));
		orderInfoSearchOrder.setBuyerNickname(buyerName);
		orderInfoSearchOrder.setItemProductName(productName);
		orderInfoSearchOrder.setSupplierName(supplierName);
		orderInfoSearchOrder.setTakeWays(takeWays);
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			orderInfoSearchOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		} else {
			orderInfoSearchOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (StringUtil.isNotEmpty(orderType)) {
			if (SaleTypeEnum.O2O.code().equals(orderType)
				|| SaleTypeEnum.B2C.code().equals(orderType)) {
				//orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
				orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.B2C) {
					orderInfoSearchOrder.setSaleTypeB2c(BooleanEnum.YES);
					model
						.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnumWithOut(""));
				}
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.O2O) {
					orderInfoSearchOrder.setSaleTypeO2o(BooleanEnum.YES);
					model.addAttribute("orderStatusEnumList",
						OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
				}
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
			if (SaleTypeEnum.ORDER_MEAL.code().equals(orderType)) {
				orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
				orderInfoSearchOrder.setSaleTypeOrderMeal(BooleanEnum.YES);
				String inCode = OrderStatusEnum.YQX.code() + "-" + OrderStatusEnum.YGB.code();
				model
					.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnumWithOut(inCode));
			}
			if (SaleTypeEnum.HOTELS.code().equals(orderType)) {
				orderInfoSearchOrder.setSaleTypeHotels(BooleanEnum.YES);
				orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());
				model.addAttribute("orderStatusEnumList",
					OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
			}
			if (SaleTypeEnum.TICKET.code().equals(orderType)) {
				orderInfoSearchOrder.setProductVary(ProductVaryEnum.ticket);
				//orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
				model.addAttribute("orderStatusEnumList",
						OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
			}
		} else {
			orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
			orderInfoSearchOrder.setSaleTypeO2o(BooleanEnum.YES);
			model.addAttribute("orderStatusEnumList",
				OrderStatusEnum.getAllEnumWithOut(OrderStatusEnum.YFH.code()));
		}
		orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		if (orderInfoSearchOrder.getOrderStatus() == OrderStatusEnum.YFK) {
			orderInfoSearchOrder.setOrderByEnum(BillSearchOrderByEnum.PAY_TIEM_DESC);
		}
		if (StringUtil.isNotBlank(beginDate)) {
			orderInfoSearchOrder.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
				.strToDtSimpleFormat(beginDate)));
		}
		if (StringUtil.isNotBlank(endDate)) {
			orderInfoSearchOrder.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
				.strToDtSimpleFormat(endDate)));
		}
		QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
			.findOrderList(orderInfoSearchOrder);
		List<OrderInfo> orderList = baseBatchResult.getPageList();
		covertOrderInfo(orderList);
		page.setTotalRow(baseBatchResult.getTotalCount());
		String pageBar = page.getPageBar();
		model.addAttribute("orderList", baseBatchResult.getPageList());
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("titleName", SaleTypeEnum.getByCode(orderType).getMessage());
		return vm_path + "mySoldOrderList.vm";
	}
	
	private void covertOrderInfo(List<OrderInfo> orderList) {
		for (OrderInfo orderInfo : orderList) {
			/**点餐订单告警**/
			if (orderInfo.getSaleTypeOrderMeal() == BooleanEnum.YES) {
				Date orderLastOperateTime = orderInfo.getRawUpdateTime();
				if (orderLastOperateTime == null) {
					orderLastOperateTime = orderInfo.getRawAddTime();
				}
				BooleanEnum warningRedEnum = BooleanEnum.NO;
				warningRedEnum = warningRed(orderLastOperateTime, orderInfo.getOrderStatus());
				BooleanEnum warningOrangeEnum = BooleanEnum.NO;
				if (warningRedEnum != BooleanEnum.YES) {
					warningOrangeEnum = warningOrange(orderLastOperateTime,
						orderInfo.getOrderStatus());
				}
				if (orderInfo.getCreateTime() == null) {
					orderInfo.setCreateTime(orderInfo.getOrdersTime());
				}
				orderInfo.setRedWarning(warningRedEnum);
				orderInfo.setOrangeWarning(warningOrangeEnum);
			}
			List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
			String batchNo = orderInfo.getBatchNo();
			if (StringUtil.isBlank(batchNo) || batchNo.equals("0")) {
				batchNo = gainBatchNoByCreateTime(orderInfo.getCreateTime());
				orderService.updateBatchNoByOrderId(orderInfo.getId(), Long.parseLong(batchNo));
				orderInfo.setBatchNo(batchNo);
			}
		}
	}
	
	/**
	 * 点餐订单查询
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	public String queryDiningOrderList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		model.addAllAttributes(WebUtil.getRequestMap(request));
		UserBizTypeEnum userBizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		
		String orderStatus = request.getParameter("orderStatus");
		//		long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
		String buyerName = request.getParameter("buyerName");
		String productName = request.getParameter("productName");
		String supplierName = request.getParameter("supplierName");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String takeWays = request.getParameter("takeWays");
		String orderType = request.getParameter("orderType");
		
		PageTool page = new PageTool();
		page.setCurrentPage(pages);
		page.setPageSize(pagesize);
		QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
		orderInfoSearchOrder.setPageNumber(pages);
		orderInfoSearchOrder.setPageSize(pagesize);
		//		orderInfoSearchOrder.setId(orderId);
		orderInfoSearchOrder.setOrderId(request.getParameter("orderId"));
		orderInfoSearchOrder.setBuyerNickname(buyerName);
		orderInfoSearchOrder.setItemProductName(productName);
		orderInfoSearchOrder.setSupplierName(supplierName);
		orderInfoSearchOrder.setTakeWays(takeWays);
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			orderInfoSearchOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		} else {
			orderInfoSearchOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		
		orderInfoSearchOrder.setPaymentMethod(PaymentMethodEnum.ONLINE.code());
		orderInfoSearchOrder.setSaleTypeOrderMeal(BooleanEnum.YES);
		String inCode = OrderStatusEnum.YQX.code() + "-" + OrderStatusEnum.YGB.code();
		model.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnumWithOut(inCode));
		
		orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		if (orderInfoSearchOrder.getOrderStatus() == OrderStatusEnum.YFK) {
			orderInfoSearchOrder.setOrderByEnum(BillSearchOrderByEnum.PAY_TIEM_DESC);
		}
		if (StringUtil.isNotBlank(beginDate)) {
			orderInfoSearchOrder.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
				.strToDtSimpleFormat(beginDate)));
		}
		if (StringUtil.isNotBlank(endDate)) {
			orderInfoSearchOrder.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
				.strToDtSimpleFormat(endDate)));
		}
		
		QueryBaseBatchResult<DiningOrderInfo> baseBatchResult = orderService
			.findDiningOrderList(orderInfoSearchOrder);
		List<DiningOrderInfo> orderList = baseBatchResult.getPageList();
		//		NavigableMap orderInfoMap = covertToOrderMap(orderList);
		page.setTotalRow(baseBatchResult.getTotalCount());
		String pageBar = page.getPageBar();
		model.addAttribute("orderList", baseBatchResult.getPageList());
		//		model.addAttribute("orderInfoMap", orderInfoMap);
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("titleName", SaleTypeEnum.getByCode(orderType).getMessage());
		return vm_path + "myDiningOrderList.vm";
	}
	
	public String shipConfim(HttpServletRequest request, HttpServletResponse response, Model model) {
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"));
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		/*是否景区中心，景区中心可以代供应商管理，取消权限控制*/
		Boolean isCenter = model.containsAttribute("isCenter");
		if (!isCenter
			&& orderInfo.getSupplierId() != ShiroSessionUtils.getSessionLocal().getUserId()) {
			return getNoAccessView();
		}
		List<OrderItemInfo> itemInfos = orderService.findOrderItemByOrderId(orderId);
		List<LogisticInfo> logisticsList = deliveryService.loadAllEnableLogisticsList();
		model.addAttribute("order", orderInfo);
		model.addAttribute("itemInfos", itemInfos);
		model.addAttribute("logisticsList", logisticsList);
		return vm_path + "shipConfim.vm";
	}
	
	public String shipOver(HttpServletRequest request, HttpServletResponse response, Model model) {
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"));
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		if (orderInfo.getSupplierId() != ShiroSessionUtils.getSessionLocal().getUserId()) {
			return getNoAccessView();
		}
		SaveDeliveryShipOrder deliveryShipOrder = new SaveDeliveryShipOrder();
		WebUtil.setPoPropertyByRequest(deliveryShipOrder, request);
		deliveryShipOrder.setBillNo(orderId);
		LogisticInfo logisticInfo = deliveryService.loadLogisticsById(deliveryShipOrder
			.getLogisticsId());
		deliveryShipOrder.setLogisticsName(logisticInfo.getName());
		OrderSellerShipResult baseResult = orderService.orderSellerShip(deliveryShipOrder);
		if (baseResult.isSuccess()) {
			model.addAttribute("message", "恭喜您，操作成功");
		} else {
			model.addAttribute("message", baseResult.getMessage());
		}
		
		List<OrderItemInfo> itemInfos = orderService.findOrderItemByOrderId(orderId);
		model.addAttribute("order", orderInfo);
		model.addAttribute("itemInfos", itemInfos);
		model.addAttribute("delivery", baseResult.getDeliveryShipInfo());
		return vm_path + "shipSuccess.vm";
	}
	
	public String cancelOrderBySeller(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		JSONObject jsonObject = new JSONObject();
		/*是否景区中心，景区中心可以代供应商管理，取消权限控制*/
		Boolean isCenter = model.containsAttribute("isCenter");
		CancelBillOrder billOrder = new CancelBillOrder();
		billOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
		if (isCenter) {
			billOrder.setBizTypeEnum(UserBizTypeEnum.VISITOR_OPERATOR);
		} else {
			billOrder.setBizTypeEnum(UserBizTypeEnum.SELLER);
		}
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.cancelOrder(billOrder);
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "取消订单成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "取消订单失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String cancelOrderByBuyer(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		JSONObject jsonObject = new JSONObject();
		CancelBillOrder billOrder = new CancelBillOrder();
		String batchNo = request.getParameter("batchNo");
		QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
		orderInfoSearchOrder.setBatchNo(batchNo);
		orderInfoSearchOrder.setPageSize(99);
		orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.WFK);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		QueryBaseBatchResult<OrderInfo> orderInfos = orderQueryService
			.findOrderList(orderInfoSearchOrder);
		if (orderInfos.getPageList() != null) {
			for (OrderInfo orderInfo : orderInfos.getPageList()) {
				billOrder.setBizNo(orderInfo.getId());
				billOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
				setProcessOrder(billOrder);
				baseResult = orderService.cancelOrder(billOrder);
				if (!baseResult.isSuccess()) {
					jsonObject.put("code", "0");
					jsonObject.put("message", "取消订单失败(" + baseResult.getMessage() + ")");
					break;
				}
			}
			if (baseResult.isSuccess()) {
				jsonObject.put("code", "1");
				jsonObject.put("message", "取消订单成功(" + baseResult.getMessage() + ")");
				jsonObject.put("cancelNum", orderInfos.getPageList().size());
			} else {
				jsonObject.put("code", "0");
				jsonObject.put("message", "取消订单失败(" + baseResult.getMessage() + ")");
			}
		} else {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String confirmReceipt(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject jsonObject = new JSONObject();
		ProcessOrder billOrder = new ProcessOrder();
		billOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.confirmReceipt(billOrder);
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "确认收货成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "确认收货失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String createReview(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject jsonObject = new JSONObject();
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"));
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		if (orderInfo.getUserId() != ShiroSessionUtils.getSessionLocal().getUserId()) {
			return getNoAccessView();
		}
		List<OrderItemInfo> itemInfos = orderService.findOrderItemByOrderId(orderId);
		String productName = "";
		String picPath = "";
		String productId = "";
		for (OrderItemInfo itemInfo : itemInfos) {
			if (productName.length() == 0 || picPath.length() == 0) {
				productName = itemInfo.getItemProductName();
				picPath = itemInfo.getPicPath();
				productId = String.valueOf(itemInfo.getItemProductId());
			} else {
				productName += "," + itemInfo.getItemProductName();
				picPath += "," + itemInfo.getPicPath();
				productId += "," + String.valueOf(itemInfo.getItemProductId());
			}
		}
		model.addAttribute("productId", productId);
		model.addAttribute("order", orderInfo);
		model.addAttribute("productName", productName);
		model.addAttribute("picPath", picPath);
		return vm_path + "createReview.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String saveOrderReview(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject jsonObject = new JSONObject();
		TradeReviewCreateOrder trCreateOrder = new TradeReviewCreateOrder();
		WebUtil.setPoPropertyByRequest(trCreateOrder, request);
		TradeReviewOrder reviewOrder = new TradeReviewOrder();
		reviewOrder.setReviewCreateOrder(trCreateOrder);
		reviewOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
		setProcessOrder(reviewOrder);
		trCreateOrder.setBuyerId(ShiroSessionUtils.getSessionLocal().getUserId());
		trCreateOrder.setBuyerIp(IPUtil.getIpAddr(request));
		trCreateOrder.setBuyerName(ShiroSessionUtils.getSessionLocal().getNickname());
		trCreateOrder.setOrderId(reviewOrder.getBizNo());
		EsupplierBaseResult baseResult = orderService.tradeReview(reviewOrder);
		if (baseResult.isSuccess()) {
			model.addAttribute("message", "评价成功");
		} else {
			model.addAttribute("message", "评价失败");
		}
		
		//sendUrl(response, "tradeReviewList.htm?orderId=" + reviewOrder.getBizNo());
		return vm_path + "createReviewOk.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String tradeReviewList(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 15);
		
		TradeReviewQueryOrder searchOrder = new TradeReviewQueryOrder();
		searchOrder.setOrderId(NumberUtil.parseLong(request.getParameter("orderId")));
		searchOrder.setProductId(NumberUtil.parseLong(request.getParameter("productId")));
		searchOrder.setPageNumber(pages);
		searchOrder.setPageSize(pagesize);
		PageTool page = new PageTool();
		QueryBaseBatchResult<TradeReviewInfo> baseResult = tradeReviewService
			.queryTradeReview(searchOrder);
		page.setCurrentPage((int) baseResult.getPageNumber());
		page.setPageSize((int) baseResult.getPageSize());
		page.setTotalRow(baseResult.getTotalCount());
		String pageBar = page.getPageBar();
		model.addAttribute("batchResult", baseResult);
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnum());
		return vm_path + "tradeReviewList.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String delCloseOrder(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		JSONObject jsonObject = new JSONObject();
		DelBillOrder billOrder = new DelBillOrder();
		String batchNo = request.getParameter("batchNo");
		//		String orderId = request.getParameter("orderId");
		//		List<OrderStatusEnum> orderStatusList = new ArrayList<OrderStatusEnum>();
		//		orderStatusList.add(OrderStatusEnum.JYC);
		//		orderStatusList.add(OrderStatusEnum.YGB);
		//		orderStatusList.add(OrderStatusEnum.YQX);
		QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
		orderInfoSearchOrder.setBatchNo(batchNo);
		//		orderInfoSearchOrder.setOrderId(orderId);
		orderInfoSearchOrder.setPageSize(99);
		//		orderInfoSearchOrder.setCompStatusList(orderStatusList);
		QueryBaseBatchResult<OrderInfo> orderInfos = orderQueryService
			.findOrderList(orderInfoSearchOrder);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		if (orderInfos.getPageList() != null) {
			
			for (OrderInfo orderInfo : orderInfos.getPageList()) {
				billOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
				billOrder.setBizNo(orderInfo.getId());
				billOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
				setProcessOrder(billOrder);
				baseResult = orderService.delOrder(billOrder);
				if (!baseResult.isSuccess()) {
					jsonObject.put("code", "0");
					jsonObject.put("message", "删除订单失败(" + baseResult.getMessage() + ")");
					break;
				}
			}
		} else {
			throw ExceptionDomainFactory.newDomainException(EsupplieDomainResultEnum.HAVE_NOT_DATA,
				"模型对象不能为空");
		}
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "删除订单成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "删除订单失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String clearDelOrder(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		JSONObject jsonObject = new JSONObject();
		DelBillOrder billOrder = new DelBillOrder();
		billOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
		billOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.clearDelOrder(billOrder);
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "永久删除订单成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "永久删除订单失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String recoverOrder(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject jsonObject = new JSONObject();
		DelBillOrder billOrder = new DelBillOrder();
		billOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
		billOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.recoverDelOrder(billOrder);
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "恢复订单成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "恢复订单失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String sendQrCode(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject jsonObject = new JSONObject();
		SendQrCodeOrder sendQrCodeOrder = new SendQrCodeOrder();
		sendQrCodeOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId")));
		sendQrCodeOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		setProcessOrder(sendQrCodeOrder);
		EsupplierBaseResult baseResult = orderService.sendQrCode(sendQrCodeOrder);
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "发送优惠码成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "发送优惠码失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	public String queryMyBuyOrderList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		int count = 0;
		try {
			model.addAllAttributes(WebUtil.getRequestMap(request));
			int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
			int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
			String orderStatus = request.getParameter("orderStatus");
			Long orderId = NumberUtil.parseLong(request.getParameter("orderId"), -1);
			String workflowStatus = request.getParameter("workflowStatus");
			String supplierName = request.getParameter("supplierName");
			String productName = request.getParameter("productName");
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			String takeWays = request.getParameter("takeWays");
			String displayAndNone = request.getParameter("displayAndNone");
			long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			PageTool page = new PageTool();
			page.setCurrentPage(pages);
			page.setPageSize(pagesize);
			QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
			orderInfoSearchOrder.setPageNumber(pages);
			orderInfoSearchOrder.setPageSize(pagesize);
			orderInfoSearchOrder.setId(orderId);
			orderInfoSearchOrder.setOrderId(request.getParameter("orderId"));
			orderInfoSearchOrder.setSupplierName(supplierName);
			orderInfoSearchOrder.setItemProductName(productName);
			orderInfoSearchOrder.setTakeWays(takeWays);
			orderInfoSearchOrder.setUserId(userId);
			orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
			orderInfoSearchOrder.setWorkflowStatus(OrderFlowStatus.getByCode(workflowStatus));
			if (StringUtil.isNotBlank(beginDate)) {
				orderInfoSearchOrder.setBeginDate(DateUtil.getStartTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(beginDate)));
			}
			if (StringUtil.isNotBlank(endDate)) {
				orderInfoSearchOrder.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil
					.strToDtSimpleFormat(endDate)));
			}
			QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
				.findMyBuyOrderList(orderInfoSearchOrder);
			
			page.setTotalRow(baseBatchResult.getTotalCount());
			String pageBar = page.getPageBar();
			List<OrderInfo> orderList = baseBatchResult.getPageList();
			
			//评价 
			int i = 0;
			int[] reviewed = new int[orderList.size()];
			List<OrderInfo> newOrderList = Lists.newArrayList();
			if (ListUtil.isNotEmpty(orderList)) {
				//	orderStatus != null && orderStatus.equals("JYC") &&
				OrderInfo lastOrder = null;
				for (OrderInfo orderInfo : orderList) {
					if (lastOrder == null) {
						lastOrder = orderInfo;
						List<OrderItemInfo> items = Lists.newArrayList();
						items.add(orderInfo.getOrderItemInfo());
						orderInfo.setOrderItems(items);
						newOrderList.add(orderInfo);
					} else {
						if (lastOrder.getId() == orderInfo.getId()) {
							lastOrder.getOrderItems().add(orderInfo.getOrderItemInfo());
						} else {
							List<OrderItemInfo> items = Lists.newArrayList();
							items.add(orderInfo.getOrderItemInfo());
							orderInfo.setOrderItems(items);
							newOrderList.add(orderInfo);
							lastOrder = orderInfo;
							newOrderList.add(orderInfo);
						}
					}
					//if (orderInfo.getOrderStatus() == OrderStatusEnum.JYC) {
					if (orderInfo.getOrderStatus() == OrderStatusEnum.YFK) {
						if (userId == orderInfo.getSupplierId()) {
							reviewed[i] = 2;
						} else {
							TradeReviewQueryOrder queryOrder = new TradeReviewQueryOrder();
							queryOrder.setBuyerId(userId);
							queryOrder.setOrderId(orderInfo.getId());
							List<TradeReviewInfo> tradeReviewInfos = tradeReviewService
								.queryTradeReview(queryOrder).getPageList();
							if (ListUtil.isNotEmpty(tradeReviewInfos)) {
								reviewed[i] = 1;
							} else {
								reviewed[i] = 0;
							}
						}
						
					} else {
						reviewed[i] = -1;
					}
					i++;
				}
			}
			model.addAttribute("orderList", orderList);
			model.addAttribute("reviewed", reviewed);
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("orderStatusEnumList", OrderStatusEnum.getAllEnum());
		} catch (Exception e) {
			logger.error("前台订单查询失败" + e.getMessage(), e);
		}
		return vm_path + "myBuyOrderList.vm";
	}
	
	public String validationQrCode(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject jsonObject = new JSONObject();
		SendQrCodeOrder processOrder = new SendQrCodeOrder();
		WebUtil.setPoPropertyByRequest(processOrder, request);
		processOrder.setBizTypeEnum(UserBizTypeEnum.SELLER);
		processOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		processOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		processOrder.setProcessName(ShiroSessionUtils.getSessionLocal().getUserName());
		EsupplierBaseResult baseResult = orderService.useQrCode(processOrder);
		if (baseResult.isSuccess()) {
			jsonObject.put("code", "1");
			jsonObject.put("message", "验证成功");
		} else {
			jsonObject.put("code", "0");
			jsonObject.put("message", "验证失败(" + baseResult.getMessage() + ")");
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
	
	private NavigableMap covertToOrderMap(List<OrderInfo> orderList) {
		TreeMap<Long, List<OrderInfo>> orderInfoMap = new TreeMap<Long, List<OrderInfo>>();
		/** 同一批次号归类进map **/
		int index = 0;
		while (index < orderList.size()) {
			OrderInfo orderInfo = orderList.get(index);
			/**点餐订单告警**/
			if (orderInfo.getSaleTypeOrderMeal() == BooleanEnum.YES) {
				Date orderLastOperateTime = orderInfo.getRawUpdateTime();
				if (orderLastOperateTime == null) {
					orderLastOperateTime = orderInfo.getRawAddTime();
				}
				BooleanEnum warningRedEnum = BooleanEnum.NO;
				warningRedEnum = warningRed(orderLastOperateTime, orderInfo.getOrderStatus());
				BooleanEnum warningOrangeEnum = BooleanEnum.NO;
				if (warningRedEnum != BooleanEnum.YES) {
					warningOrangeEnum = warningOrange(orderLastOperateTime,
						orderInfo.getOrderStatus());
				}
				if (orderInfo.getCreateTime() == null) {
					orderInfo.setCreateTime(orderInfo.getOrdersTime());
				}
				orderInfo.setRedWarning(warningRedEnum);
				orderInfo.setOrangeWarning(warningOrangeEnum);
			}
			List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
			String batchNo = orderList.get(index).getBatchNo();
			if (StringUtil.isBlank(batchNo) || batchNo.equals("0")) {
				batchNo = gainBatchNoByCreateTime(orderList.get(index).getCreateTime());
				orderService.updateBatchNoByOrderId(orderList.get(index).getId(),
					Long.parseLong(batchNo));
				orderList.get(index).setBatchNo(batchNo);
			}
			long batchNoPre = Long.parseLong(batchNo);
			int index_in = 0;
			for (int i = index; i < orderList.size(); i++) {
				String batchNo_I = orderList.get(i).getBatchNo();
				if (StringUtil.isBlank(batchNo_I) || batchNo_I.equals("0")) {
					batchNo_I = gainBatchNoByCreateTime(orderList.get(i).getCreateTime());
					orderService.updateBatchNoByOrderId(orderList.get(i).getId(),
						Long.parseLong(batchNo_I));
				}
				long batchNoCur = Long.parseLong(batchNo_I);
				if (batchNoPre == batchNoCur) {
					orderInfoList.add(orderList.get(i));
					orderInfoMap.put(batchNoCur, orderInfoList);
					index_in++;
				} else {
					break;
				}
			}
			
			index = index + index_in;
		}
		return orderInfoMap.descendingMap();
	}
	
	private BooleanEnum warningOrange(Date orderLastOperateTime, OrderStatusEnum orderStatus) {
		long lRtn = DateUtil.getDateBetween(orderLastOperateTime, new Date());
		long lastOperateRtn = 0;
		if (orderStatus == OrderStatusEnum.YFK) {
			lastOperateRtn = 10 * 60 * 1000;
			if (lRtn > lastOperateRtn) {
				return BooleanEnum.YES;
			}
		}
		
		if (orderStatus == OrderStatusEnum.WFK) {
			lastOperateRtn = 2 * 60 * 1000;
			if (lRtn > lastOperateRtn) {
				return BooleanEnum.YES;
			}
		}
		if (orderStatus == OrderStatusEnum.YFH) {
			lastOperateRtn = 3 * 60 * 1000;
			if (lRtn > lastOperateRtn) {
				return BooleanEnum.YES;
			}
		}
		
		return BooleanEnum.NO;
	}
	
	private BooleanEnum warningRed(Date orderLastOperateTime, OrderStatusEnum orderStatus) {
		long lRtn = DateUtil.getDateBetween(orderLastOperateTime, new Date());
		long lastOperateRtn = 0;
		
		if (orderStatus == OrderStatusEnum.YFK) {
			lastOperateRtn = 20 * 60 * 1000;
			if (lRtn > lastOperateRtn) {
				return BooleanEnum.YES;
			}
		}
		
		if (orderStatus == OrderStatusEnum.WFK) {
			lastOperateRtn = 5 * 60 * 1000;
			if (lRtn > lastOperateRtn) {
				return BooleanEnum.YES;
			}
		}
		
		if (orderStatus == OrderStatusEnum.YFH) {
			lastOperateRtn = 5 * 60 * 1000;
			if (lRtn > lastOperateRtn) {
				return BooleanEnum.YES;
			}
		}
		return BooleanEnum.NO;
	}
	
	private String gainBatchNoByCreateTime(Date createTime) {
		StringBuffer number = new StringBuffer();
		//String outBizNo = "0987";//AppConstantsUtil.getOutBizNumber();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HHmmssSSS");
		Date nowDate = createTime;
		number.append(simpleDateFormat.format(nowDate)).append(simpleTimeFormat.format(nowDate));
		int a = (int) (Math.random() * 1000);
		String aString = String.valueOf(a);
		while (aString.length() < 3) {
			aString = "0" + aString;
		}
		number.append(aString);
		return number.toString();
	}
}
