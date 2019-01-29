package com.yjf.esupplier.web.controller.front.BaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.service.exception.ExceptionFactory;
import com.yjf.esupplier.service.pay.PaymentFlowService;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.google.common.collect.Lists;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.dal.daointerface.PaymentFlowDAO;
import com.yjf.esupplier.service.bill.info.RefundOrderInfo;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.enums.BillSearchOrderByEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.info.OrderItemInfo;
import com.yjf.esupplier.ws.bill.order.ConfirmReceiptRefundGoodsOrder;
import com.yjf.esupplier.ws.bill.order.QueryRefundOrder;
import com.yjf.esupplier.ws.bill.order.RefundApplyOrder;
import com.yjf.esupplier.ws.bill.order.RefundGoodsProcessOrder;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CommonAttachmentTypeEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.info.CommonAttachmentInfo;
import com.yjf.esupplier.ws.order.CommonAttachmentQueryOrder;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
public class AfterMarketBaseContorllor extends FrontAutowiredBaseController {
	
	static String vm_path = "front/platform/member/trade/";
	@Autowired
	PaymentFlowDAO paymentFlowDAO;
	@Autowired
	PaymentFlowService paymentFlowService;
	
	public String buyerRefundList(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		QueryRefundOrder queryRefundOrder = new QueryRefundOrder();
		WebUtil.setPoPropertyByRequest(queryRefundOrder, request);
		queryRefundOrder.setOrderByEnum(BillSearchOrderByEnum.ADD_DATE_ASC);
		queryRefundOrder.setBuyerUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		makePageList(request, model, queryRefundOrder);
		return vm_path + "buyerRefundList.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String refoundApply(HttpServletRequest request, HttpServletResponse response, Model model) {
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"));
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		if (orderInfo.getUserId() != ShiroSessionUtils.getSessionLocal().getUserId()) {
			return getNoAccessView();
		}
		UserInfo userInfo = userQueryService.queryByUserId(
			ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
		/*注释 不需要认证账号*/
		//		if (StringUtil.isNotBlank(userInfo.getAccountId())) {
		//			QueryAccountResult accountResult = userAccountQueryService
		//				.getAccountInfo(ShiroSessionUtils.getSessionLocal());
		//			if (!accountResult.getYjfAccountInfo().isActive()) {
		//				sendUrl(response,
		//					"/do/openPayAccount.htm?redirect=/do/aftermarket/buyer/refundApply.htm?orderId="
		//							+ orderId);
		//				return null;
		//			}
		//		} else {
		//			sendUrl(response,
		//				"/do/openPayAccount.htm?redirect=/do/aftermarket/buyer/refundApply.htm?orderId="
		//						+ orderId);
		//			return null;
		//		}
		List<OrderItemInfo> itemInfos = orderService.findOrderItemByOrderId(orderId);
		model.addAttribute("order", orderInfo);
		model.addAttribute("itemInfos", itemInfos);
		if (ListUtil.isNotEmpty(itemInfos)) {
			model.addAttribute("itemInfoOne", itemInfos.get(0));
		}
	/*	if (orderInfo.getOrderStatus() == OrderStatusEnum.YFK) {
			model.addAttribute("selectors", "true");
		}*/
		if (orderInfo.getOrderStatus() == OrderStatusEnum.JYC
				|| orderInfo.getOrderStatus() == OrderStatusEnum.YFH) {
			model.addAttribute("selectors", "true");
		}
		String token = UUID.randomUUID().toString();
		model.addAttribute("token", token);
		request.getSession().setAttribute("token", token);
		return vm_path + "refoudDetailOrderInfo.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String refundOrderInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		long currentUserId = ShiroSessionUtils.getSessionLocal().getUserId();
		String view = validateViewAccess(refundOrderInfo, currentUserId);
		if (StringUtil.isNotBlank(view)) {
			return null;
		}
		loadRefundDetail(model, refundId, refundOrderInfo);
		return vm_path + "refundOrderInfo.vm";
	}
	
	private String validateViewAccess(RefundOrderInfo refundOrderInfo, long currentUserId) {
		if (ShiroSessionUtils.getSessionLocal().getUserBizType() == UserBizTypeEnum.VISITOR_CENTER
			|| ShiroSessionUtils.getSessionLocal().getUserBizType() == UserBizTypeEnum.VISITOR_OPERATOR) {
			
			if (refundOrderInfo.getResortsBusinessId() != ShiroSessionUtils.getSessionLocal()
				.getUserId()
				&& refundOrderInfo.getResortsBusinessId() != ShiroSessionUtils.getSessionLocal()
					.getBelongTo()) {
				return getNoAccessView();
			}
		} else {
			if (refundOrderInfo.getBuyerUserId() != currentUserId
				&& refundOrderInfo.getSupplierId() != currentUserId
				&& ShiroSessionUtils.getSessionLocal().getUserBizType() != UserBizTypeEnum.ADMIN) {
				return getNoAccessView();
			}
		}
		return null;
	}
	
	private void loadRefundDetail(Model model, long refundId, RefundOrderInfo refundOrderInfo) {
		OrderInfo orderInfo = orderService.findOrderById(refundOrderInfo.getOrderId());
		OrderItemInfo itemInfo = orderService.findOrderItemById(refundOrderInfo.getOrderItemId());
		model.addAttribute("refundOrderInfo", refundOrderInfo);
		model.addAttribute("itemInfoOne", itemInfo);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("userInfo",
			userQueryService.queryByUserId(refundOrderInfo.getBuyerUserId()).getQueryUserInfo());
		CommonAttachmentQueryOrder attachmentQueryOrder = new CommonAttachmentQueryOrder();
		attachmentQueryOrder.setBizNo(String.valueOf(refundId));
		List<CommonAttachmentTypeEnum> moduleTypeList = Lists.newArrayList();
		moduleTypeList.add(CommonAttachmentTypeEnum.ORDER_REFUND_INFO);
		attachmentQueryOrder.setModuleTypeList(moduleTypeList);
		QueryBaseBatchResult<CommonAttachmentInfo> result = commonAttachmentService
			.queryCommonAttachment(attachmentQueryOrder);
		model.addAttribute("imageList", result.getPageList());
	}
	
	@SuppressWarnings("unchecked")
	public String refundApplySubmit(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		String saleTypeO2o = request.getParameter("saleTypeO2o");
		String saleTypeHotels = request.getParameter("saleTypeHotels");
		if (toToken == null || !toToken.equals(token)) {
			EsupplierBaseResult baseResult = new EsupplierBaseResult();
			baseResult.setMessage("请无重新提交！");
			model.addAttribute("result", baseResult);
			return vm_path + "refundBuyerResult.vm";
		}
		
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"));
		long orderItemId = NumberUtil.parseLong(request.getParameter("orderItemId"));
		
		RefundApplyOrder refundApplyOrder = new RefundApplyOrder();
		WebUtil.setPoPropertyByRequest(refundApplyOrder, request);
		setProcessOrder(refundApplyOrder);
		refundApplyOrder
			.setRefundType(RefundTypeEnum.getByCode(request.getParameter("refundType")));
		refundApplyOrder.setBizNo(orderId);
		refundApplyOrder.setOrderId(orderId);
		refundApplyOrder.setOrderItemId(orderItemId);
		String[] uploadImgUrls = request.getParameterValues("uploadImgUrl");
		refundApplyOrder.setUploadImgUrls(uploadImgUrls);
		EsupplierBaseResult baseResult = orderService.refundApply(refundApplyOrder);
		if (baseResult.isSuccess()) {
			if(BooleanEnum.getByCode(saleTypeO2o) == BooleanEnum.YES || BooleanEnum.getByCode(saleTypeHotels) == BooleanEnum.YES){
				baseResult.setMessage("退款成功！");
			}else{
				baseResult.setMessage("申请成功,等待卖家审核！");
			}
		}
		model.addAttribute("result", baseResult);
		return vm_path + "refundBuyerResult.vm";
	}
	
	public String sellerRefundApplyCheckList(HttpServletRequest request,
												HttpServletResponse response, Model model) {
		
		QueryRefundOrder queryRefundOrder = new QueryRefundOrder();
		QueryBaseBatchResult<InstitutionsInfo> batchResult = null;
		List<InstitutionsInfo> institutionsInfoList = null;
		WebUtil.setPoPropertyByRequest(queryRefundOrder, request);
		List<String> refundTypeEnums = new ArrayList<String>();
		refundTypeEnums.add(RefundProcessStatusEnum.REFUND_APPLY.code());
		refundTypeEnums.add(RefundProcessStatusEnum.RETURNED_PURCHASEING.code());
		queryRefundOrder.setRefundStatusList(refundTypeEnums);
		//queryRefundOrder.setStatusEnum(RefundProcessStatusEnum.REFUND_APPLY);
		//queryRefundOrder.setStatusEnum(RefundProcessStatusEnum.REFUND_APPLY);
		queryRefundOrder.setOrderByEnum(BillSearchOrderByEnum.ADD_DATE_DESC);
		makePageList(request, model, queryRefundOrder);
		return vm_path + "sellerRefundList.vm";
	}
	
	private void addSearchCondition(QueryRefundOrder queryRefundOrder) {
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		if (bizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			queryRefundOrder.setResortsBusinessId(ShiroSessionUtils.getSessionLocal().getUserId());
		} else if (bizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR) {
			queryRefundOrder
				.setResortsBusinessId(ShiroSessionUtils.getSessionLocal().getBelongTo());
		} else if (bizTypeEnum == UserBizTypeEnum.SELLER) {
			queryRefundOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}else if (bizTypeEnum == UserBizTypeEnum.BUYER) {
			queryRefundOrder.setBuyerUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
	}
	
	public String sellerRefundGoodsConfirmList(HttpServletRequest request,
												HttpServletResponse response, Model model) {
		QueryRefundOrder queryRefundOrder = new QueryRefundOrder();
		WebUtil.setPoPropertyByRequest(queryRefundOrder, request);
		queryRefundOrder.setStatusEnum(RefundProcessStatusEnum.RETURNED_PURCHASEING);
		queryRefundOrder.setOrderByEnum(BillSearchOrderByEnum.ADD_DATE_ASC);
		queryRefundOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		makePageList(request, model, queryRefundOrder);
		return vm_path + "sellerRefundGoodsConfirmList.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String refoundApplyCheck(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		long currentUserId = ShiroSessionUtils.getSessionLocal().getUserId();
		String view = validateViewAccess(refundOrderInfo, currentUserId);
		if (StringUtil.isNotBlank(view)) {
			return null;
		}
		
		loadRefundDetail(model, refundId, refundOrderInfo);
		String token = UUID.randomUUID().toString();
		model.addAttribute("orderType", SaleTypeEnum.getByCode(request.getParameter("orderType")));
		model.addAttribute("token", token);
		request.getSession().setAttribute("token", token);
		return vm_path + "refundApplyCheck.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String refundApplyCheckSubmit(HttpServletRequest request, HttpServletResponse response,
											Model model) {
		QueryBaseBatchResult<InstitutionsInfo> batchResult = null;
		List<InstitutionsInfo> institutionsInfoList = null;
		List<Long> listUserid = new ArrayList<Long>();
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		if (toToken == null || !toToken.equals(token)) {
			EsupplierBaseResult baseResult = new EsupplierBaseResult();
			baseResult.setMessage("请无重新提交！");
			model.addAttribute("result", baseResult);
			return vm_path + "refundResult.vm";
		}
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		String view = validateViewAccess(refundOrderInfo, ShiroSessionUtils.getSessionLocal()
			.getUserId());
		if (StringUtil.isNotBlank(view)) {
			return null;
		}
		//		if (refundOrderInfo.getSupplierId() != currentUserId) {
		//			return getNoAccessView();
		//		}
		ProcessOrder processOrder = new ProcessOrder();
		this.setProcessOrder(processOrder);
		processOrder.setBizNo(refundId);
		processOrder.setOrderType(request.getParameter("orderType"));
		if ("refundValueOk".equals(request.getParameter("refundValue"))) {
			processOrder.setPassFlag(BooleanEnum.YES);
		} else if ("refundValueNo".equals(request.getParameter("refundValue"))) {
			processOrder.setPassFlag(BooleanEnum.NO);
		} else {
			EsupplierBaseResult baseResult = new EsupplierBaseResult();
			baseResult.setMessage("参数不完整！");
			model.addAttribute("result", baseResult);
			return vm_path + "refundResult.vm";
		}
		EsupplierBaseResult result = orderRefundService.checkRefundApply(processOrder);
		if (result.isSuccess()) {
			if (refundOrderInfo.getRefundType() == RefundTypeEnum.REFUND)
				if (processOrder.getPassFlag() == BooleanEnum.YES) {					
					result.setMessage("审核通过,退款的钱会"+result.getMessage());
				} else {
					result.setMessage("审核不通过，驳回！");
				}
			
			else {
				if (processOrder.getPassFlag() == BooleanEnum.YES) {
					result.setMessage("审核通过,等待买家发货！");
				} else {
					result.setMessage("审核不通过，驳回！");
				}
			}
			
		}
		model.addAttribute("orderType", SaleTypeEnum.getByCode(request.getParameter("orderType")));
		model.addAttribute("result", result);
		return vm_path + "refundResult.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String refundConfirmGoods(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		long currentScenicId = ShiroSessionUtils.getSessionLocal().getBelongTo();
		
		if (refundOrderInfo.getResortsBusinessId() != currentScenicId) {
			return getNoAccessView();
		}
		loadRefundDetail(model, refundId, refundOrderInfo);
		String token = UUID.randomUUID().toString();
		model.addAttribute("token", token);
		request.getSession().setAttribute("token", token);
		return vm_path + "refundConfirmGoods.vm";
	}
	
	@SuppressWarnings("unchecked")
	public String refundConfirmGoodsSubmit(HttpServletRequest request,
											HttpServletResponse response, Model model) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		if (toToken == null || !toToken.equals(token)) {
			EsupplierBaseResult baseResult = new EsupplierBaseResult();
			baseResult.setMessage("请无重新提交！");
			model.addAttribute("result", baseResult);
			return vm_path + "refundResult.vm";
		}
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		/*景区管理员*/
		long currentScenicId = ShiroSessionUtils.getSessionLocal().getBelongTo();
		if (refundOrderInfo.getResortsBusinessId() != currentScenicId) {
			return getNoAccessView();
		}
		ConfirmReceiptRefundGoodsOrder processOrder = new ConfirmReceiptRefundGoodsOrder();
		this.setProcessOrder(processOrder);
		//		processOrder.setIsAddStock(BooleanEnum.getByCode(request.getParameter("addStockFlag")));
		if (processOrder.getIsAddStock() == BooleanEnum.YES) {
			processOrder.setAddStockQuantity(NumberUtil.parseLong(request
				.getParameter("addStockQuantity")));
		}
		processOrder.setBizNo(refundId);
		EsupplierBaseResult result = orderRefundService.confirmReceiptRefundGoods(processOrder);
		if (result.isSuccess()) {
			result.setMessage("确认退货成功！退款金额"+result.getMessage());
		}
		model.addAttribute("result", result);
		return vm_path + "refundResult.vm";
	}
	
	public String sellerRefundListSearch(HttpServletRequest request, HttpServletResponse response,
											Model model) {
		QueryRefundOrder queryRefundOrder = new QueryRefundOrder();
		WebUtil.setPoPropertyByRequest(queryRefundOrder, request);
		makePageList(request, model, queryRefundOrder);
		return vm_path + "sellerRefundListSearch.vm";
	}
	
	public String buyerConfirmReturn(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		long currentUserId = ShiroSessionUtils.getSessionLocal().getUserId();
		
		if (refundOrderInfo.getBuyerUserId() != currentUserId) {
			return getNoAccessView();
		}
		loadRefundDetail(model, refundId, refundOrderInfo);
		String token = UUID.randomUUID().toString();
		model.addAttribute("token", token);
		request.getSession().setAttribute("token", token);
		return vm_path + "buyerConfirmReturn.vm";
	}
	
	public String buyerConfirmReturnSubmit(HttpServletRequest request,
											HttpServletResponse response, Model model) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		if (toToken == null || !toToken.equals(token)) {
			EsupplierBaseResult baseResult = new EsupplierBaseResult();
			baseResult.setMessage("请无重新提交！");
			model.addAttribute("result", baseResult);
			return vm_path + "refundResult.vm";
		}
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		long currentUserId = ShiroSessionUtils.getSessionLocal().getUserId();
		if (refundOrderInfo.getBuyerUserId() != currentUserId) {
			return getNoAccessView();
		}
		RefundGoodsProcessOrder processOrder = new RefundGoodsProcessOrder();
		WebUtil.setPoPropertyByRequest(processOrder, request);
		this.setProcessOrder(processOrder);
		processOrder.setBizNo(refundId);
		EsupplierBaseResult result = orderRefundService.processRefundGoods(processOrder);
		if (result.isSuccess()) {
			result.setMessage("申请成功,请等待商家审核！");
		}
		
		model.addAttribute("result", result);
		return vm_path + "refundResult.vm";
	}
	
	private void makePageList(HttpServletRequest request, Model model,
								QueryRefundOrder queryRefundOrder) {
		model.addAllAttributes(WebUtil.getRequestMap(request));
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		String orderType = request.getParameter("orderType");
		queryRefundOrder.setPageNumber(pages);
		queryRefundOrder.setPageSize(pagesize);
		if (queryRefundOrder.getStatusEnum() == null) {
			queryRefundOrder.setStatusEnum(RefundProcessStatusEnum.getByCode(request
				.getParameter("statusEnum")));
		}
		
		if (queryRefundOrder.getRefundTypeEnum() == null) {
			queryRefundOrder.setRefundTypeEnum(RefundTypeEnum.getByCode(request
				.getParameter("refundTypeEnum")));
		}
		if (StringUtil.isNotEmpty(orderType)) {
			if (StringUtil.isNotEmpty(orderType)) {
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.B2C) {
					queryRefundOrder.setSaleTypeB2c(BooleanEnum.YES);
					queryRefundOrder.setSaleTypeO2o(BooleanEnum.NO);
				}
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.O2O) {
					queryRefundOrder.setSaleTypeB2c(BooleanEnum.NO);
					queryRefundOrder.setSaleTypeO2o(BooleanEnum.YES);
				}
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.TICKET) {
					queryRefundOrder.setProductVaryEnum(ProductVaryEnum.ticket);
				}
			}
		}
		List<RefundProcessStatusEnum>refundProcessStatusEnumList = new ArrayList<RefundProcessStatusEnum>();
		for(RefundProcessStatusEnum refundProcessStatusEnum : RefundProcessStatusEnum.getAllEnum()){
			if(refundProcessStatusEnum.isO2o()){
				refundProcessStatusEnumList.add(refundProcessStatusEnum);
			}
		}
		/*添加景区或用户限制条件*/
		addSearchCondition(queryRefundOrder);
		QueryBaseBatchResult<RefundOrderInfo> baseBatchResult = orderRefundService
			.queryRefundCondition(queryRefundOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage(pages);
		pageTool.setPageSize(pagesize);
		pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
		pageTool.setPageSize((int) baseBatchResult.getPageSize());
		pageTool.setTotalRow(baseBatchResult.getTotalCount());
		String pageBar = pageTool.getPageBar();
		model.addAttribute("list", baseBatchResult.getPageList());
		model.addAttribute("baseBatchResult", baseBatchResult.getTotalCount());
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("orderType", SaleTypeEnum.getByCode(orderType));
		model.addAttribute("refundProcessStatusEnumList", refundProcessStatusEnumList);
	}
}
