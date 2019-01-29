package com.yjf.esupplier.web.controller.front.infoOrder;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.dal.daointerface.PaymentFlowDAO;
import com.yjf.esupplier.web.controller.front.BaseController.AfterMarketBaseContorllor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.service.bill.info.RefundOrderInfo;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
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
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/do/aftermarket")
public class AfterMarketContorllor extends AfterMarketBaseContorllor {
	
	@RequestMapping("buyer/buyerRefundList.htm")
	public String buyerRefundList(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.buyerRefundList(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/refundApply.htm")
	public String refoundApply(	HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.refoundApply(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/refundOrderInfo.htm")
	public String refundOrderInfo(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.refundOrderInfo(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/refundApplySubmit.htm")
	public String refundApplySubmit(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.refundApplySubmit(request, response, model);
	}
	
	@RequestMapping("seller/sellerRefundApplyCheckList.htm")
	public String sellerRefundApplyCheckList(	HttpServletRequest request,
												HttpServletResponse response, Model model) {
		return super.sellerRefundApplyCheckList(request, response, model);
	}
	
	@RequestMapping("seller/sellerRefundGoodsConfirmList.htm")
	public String sellerRefundGoodsConfirmList(	HttpServletRequest request,
												HttpServletResponse response, Model model) {
		return super.sellerRefundGoodsConfirmList(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("seller/refundApplyCheck.htm")
	public String refoundApplyCheck(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.refoundApplyCheck(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("seller/refundApplyCheckSubmit.htm")
	public String refundApplyCheckSubmit(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.refundApplyCheckSubmit(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("seller/refundConfirmGoods.htm")
	public String refundConfirmGoods(	HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.refundConfirmGoods(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("seller/refundConfirmGoodsSubmit.htm")
	public String refundConfirmGoodsSubmit(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.refundConfirmGoodsSubmit(request, response, model);
	}
	
	@RequestMapping("seller/sellerRefundListSearch.htm")
	public String sellerRefundListSearch(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.sellerRefundListSearch(request, response, model);
	}
	
	@RequestMapping("buyer/buyerConfirmReturn.htm")
	public String buyerConfirmReturn(	HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.buyerConfirmReturn(request, response, model);
	}
	
	@RequestMapping("buyer/buyerConfirmReturnSubmit.htm")
	public String buyerConfirmReturnSubmit(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.buyerConfirmReturnSubmit(request, response, model);
	}
	
}
