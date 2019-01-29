package com.yjf.esupplier.web.controller.openapi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.integration.openapi.FormGotoGatewayService;
import com.yjf.esupplier.integration.openapi.result.GoToFormResult;
import com.yjf.esupplier.service.bill.OrderQueryService;
import com.yjf.esupplier.service.bill.OrderService;
import com.yjf.esupplier.service.orderfood.OrderfoodService;
import com.yjf.esupplier.service.pay.PayService;
import com.yjf.esupplier.service.pay.order.BalancePointOrder;
import com.yjf.esupplier.service.pay.order.PayOrderInfosOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.order.QueryOrderInfoSearchOrder;
import com.yjf.esupplier.ws.common.enums.PaymentTypeEnum;
import com.yjf.esupplier.ws.orderfood.info.DiningTableSituationInfo;
import com.yjf.esupplier.ws.orderfood.order.QureyDiningTableOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("openApi")
public class PaymentGatewayController extends BaseAutowiredController {
	
	@Autowired
	FormGotoGatewayService formGotoGatewayService;
	
	@Autowired
	PayService payService;
	@Autowired
	OrderfoodService orderfoodService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderQueryService orderQueryService;
	
	/***
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("yjfOnlineBankingPay.htm")
	public String gotoYijifuPay(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		String[] orderIds = request.getParameterValues("orderIds");
		String[] tableNumbers = request.getParameterValues("tableNumbers");
		if (orderIds != null || tableNumbers != null) {
			Long[] lngOrderIds = null;
			if (orderIds != null) {
				lngOrderIds = new Long[orderIds.length];
				
				for (int i = 0; i < lngOrderIds.length; i++) {
					lngOrderIds[i] = NumberUtil.parseLong(orderIds[i]);
				}
			} else if (tableNumbers != null) {
				List<Long> orderIdsList = Lists.newArrayList();
				for (String tableNumber : tableNumbers) {
					QureyDiningTableOrder diningTableOrder = new QureyDiningTableOrder();
					diningTableOrder.setSupplierId(ShiroSessionUtils.getSessionLocal()
						.getBelongTo());
					diningTableOrder.setTableNumber(tableNumber);
					DiningTableSituationInfo tableSituationInfo = orderfoodService
						.getUseingDiningTable(diningTableOrder);
					if (tableSituationInfo != null) {
						QueryOrderInfoSearchOrder infoSearchOrder = new QueryOrderInfoSearchOrder();
						infoSearchOrder.setTableNumberSeq(tableSituationInfo.getTableNumberSeq());
						infoSearchOrder.setSupplierId(diningTableOrder.getSupplierId());
						infoSearchOrder.setPageSize(5000);
						QueryBaseBatchResult<OrderInfo> batchResult = orderQueryService
							.findOrderList(infoSearchOrder);
						for (OrderInfo orderInfo : batchResult.getPageList()) {
							if (orderInfo.getOrderStatus() == OrderStatusEnum.WFK
								|| orderInfo.getOrderStatus() == OrderStatusEnum.PAD_ORDER_CONFIRM) {
								orderIdsList.add(orderInfo.getId());
							}
						}
					}
				}
				lngOrderIds = (Long[]) orderIdsList.toArray();
				
			}
			
			PayOrderInfosOrder orderInfosOrder = new PayOrderInfosOrder();
			orderInfosOrder.setOrderIds(lngOrderIds);
			orderInfosOrder.setBankCode(request.getParameter("bankCode"));
			orderInfosOrder.setCardType(request.getParameter("cardType"));
			PaymentTypeEnum paymentType = PaymentTypeEnum
				.getByCode(request.getParameter("payType"));
			orderInfosOrder.setGatewayType(paymentType);
			if (paymentType == PaymentTypeEnum.BALANCE_PAYMENT) {
				BalancePointOrder order = new BalancePointOrder();
				order.setPayPwd(request.getParameter("payPwd"));
				convertBalanceOrder(orderInfosOrder, order);
				EsupplierBaseResult result = payService.creatBalancePointOrder(order,
					getOpenApiContext());
				if (result.isSuccess()) {
					if (StringUtil.equals("BALANCE_PAYMENT", paymentType.code())) {
						modelMap.addAttribute("message", "支付成功");
						return "front/order/paymentOk.vm";
					}
				} else {
					modelMap.addAttribute("message", result.getMessage());
					return "front/order/paymentOk.vm";
				}
			}
			GoToFormResult formResult = payService.gotoYijifuPay(orderInfosOrder);
			if (!formResult.isSuccess()) {
				modelMap.addAttribute("result", formResult);
				return "paypage/gotoPayError.vm";
			}
			if (paymentType != PaymentTypeEnum.WECHATS_SANCODE_APP) {
				modelMap.addAttribute("formTextList", formResult.getFormTexts());
				modelMap.addAttribute("gotoUrl", formResult.getUrl());
				
				return "paypage/gotoPayForm.vm";
			} else {
				modelMap.addAttribute("scanCodeImageUrl",
					formResult.getMap().get("scanCodeImageUrl"));
				modelMap.addAttribute("tradeNo", formResult.getMap().get("tradeNo"));
				modelMap.addAttribute("payAmount", new Money(formResult.getMap().get("payAmount")));
				modelMap.addAttribute("returnUrl", formResult.getMap().get("returnUrl"));
				return "paypage/wechatScan.vm";
			}
		} else {
			EsupplierBaseResult baseResult = new EsupplierBaseResult();
			baseResult.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			
			modelMap.addAttribute("result", baseResult);
			return "paypage/gotoPayError.vm";
		}
		
	}
	
	private void convertBalanceOrder(PayOrderInfosOrder orderInfosOrder, BalancePointOrder order) {
		
		order.setTradeName("商品付款");
		String ids = "";
		for (int i = 0; i < orderInfosOrder.getOrderIds().length; i++) {
			ids += orderInfosOrder.getOrderIds()[i] + ",";
		}
		StringUtil.substring(ids, 0, ids.length() - 1);
		order.setIds(ids);
		order.setPayType(orderInfosOrder.getGatewayType().code());
		order.setPartnerUserId(String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId()));
	}
	
}
