package com.yjf.esupplier.web.controller.front.scenicCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.front.BaseController.UserOrderManagerBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.order.SaveDeliveryShipOrder;
import com.yjf.esupplier.ws.bill.order.TecBillOrder;
import com.yjf.esupplier.ws.bill.result.OrderSellerShipResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@Controller
@RequestMapping("/do/scenic")
public class ScenicUserOrderManagerController extends UserOrderManagerBaseController {
	
	@RequestMapping("doCenter/querySoldOrderList.htm")
	public String querySoldOrderList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.querySoldOrderList(request, response, model);
	}
	
	@RequestMapping("doCenter/queryDiningOrderList.htm")
	public String queryDiningOrderList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.queryDiningOrderList(request, response, model);
	}
	
	@RequestMapping("doCenter/shipConfim.htm")
	public String shipConfim(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("isCenter", true);
		return super.shipConfim(request, response, model);
	}
	
	@ResponseBody
	@RequestMapping("doCenter/shipOver.htm")
	public Object shipScenicOver(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		JSONObject json = new JSONObject();
		long orderId = NumberUtil.parseLong(request.getParameter("orderId"));
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		if (orderInfo.getResortsBusinessId() != ShiroSessionUtils.getSessionLocal().getBelongTo()) {
			return getNoAccessView();
		}
		SaveDeliveryShipOrder deliveryShipOrder = new SaveDeliveryShipOrder();
		WebUtil.setPoPropertyByRequest(deliveryShipOrder, request);
		deliveryShipOrder.setBillNo(orderId);
		OrderSellerShipResult baseResult = orderService.orderSellerShip(deliveryShipOrder);
		if (baseResult.isSuccess()) {
			json.put("code", 1);
			json.put("message", "发货成功!");
		} else {
			json.put("code", 0);
			json.put("message", "发货失败:" + baseResult.getMessage());
		}
		return json;
	}
	
	@RequestMapping("doCenter/cancelOrderBySeller.htm")
	public String cancelOrderBySeller(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		model.addAttribute("isCenter", true);
		return super.cancelOrderBySeller(request, response, model);
	}
	
	@RequestMapping("doCenter/validationQrCode.htm")
	public String validationQrCode(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.validationQrCode(request, response, model);
	}
	
	@ResponseBody
	@RequestMapping("doCenter/bookTecSubmit.json")
	public Object bookTecSubmit(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		JSONObject json = new JSONObject();
		TecBillOrder tecBillOrder = new TecBillOrder();
		WebUtil.setPoPropertyByRequest(tecBillOrder, request);
		tecBillOrder.setBizNo(NumberUtil.parseLong(request.getParameter("orderId"), 0));
		tecBillOrder.setDeliverId(NumberUtil.parseLong(request.getParameter("deliveryId"), 0));
		tecBillOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		tecBillOrder.setBizTypeEnum(ShiroSessionUtils.getSessionLocal().getUserBizType());
		EsupplierBaseResult baseResult = orderService.bookTec(tecBillOrder);
		if (baseResult.isSuccess()) {
			json.put("code", 1);
			json.put("message", "选择技师成功!");
		} else {
			json.put("code", 0);
			json.put("message", "选择技师失败:" + baseResult.getMessage());
		}
		return json;
	}
}
