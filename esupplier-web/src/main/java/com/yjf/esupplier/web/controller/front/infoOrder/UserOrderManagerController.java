package com.yjf.esupplier.web.controller.front.infoOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.web.controller.front.BaseController.UserOrderManagerBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/do/infoOrder")
public class UserOrderManagerController extends UserOrderManagerBaseController {
	
	final static String vm_path = "front/platform/member/trade/";
	
	@RequestMapping("buyer/queryBuyOrder.htm")
	public String queryBuyOrder(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.queryBuyOrder(request,response,model);
	}
	
	@RequestMapping("seller/querySoldOrderList.htm")
	public String querySoldOrderList(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.querySoldOrderList(request, response, model);
	}
	
	@RequestMapping("seller/shipConfim.htm")
	public String shipConfim(HttpServletRequest request, HttpServletResponse response, Model model) {
		return super.shipConfim(request, response, model);
	}
	
	@RequestMapping("seller/shipOver.htm")
	public String shipOver(HttpServletRequest request, HttpServletResponse response, Model model) {
		return super.shipOver(request, response, model);
	}
	
	@RequestMapping("seller/cancelOrderBySeller.htm")
	public String cancelOrderBySeller(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.cancelOrderBySeller(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/cancelOrderByBuyer.htm")
	public String cancelOrderByBuyer(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.cancelOrderByBuyer(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/confirmReceipt.htm")
	public String confirmReceipt(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.confirmReceipt(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/createReview.htm")
	public String createReview(HttpServletRequest request, HttpServletResponse response, Model model) {
		return super.createReview(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/saveOrderReview.htm")
	public String saveOrderReview(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.saveOrderReview(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/tradeReviewList.htm")
	public String tradeReviewList(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.tradeReviewList(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/delCloseOrder.htm")
	public String delCloseOrder(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.delCloseOrder(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/clearDelOrder.htm")
	public String clearDelOrder(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.clearDelOrder(request, response, model);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/recoverOrder.htm")
	public String recoverOrder(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.recoverOrder(request, response, model);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("buyer/sendQrCode.htm")
	public String sendQrCode(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.sendQrCode(request, response, model);
	}
	
	@RequestMapping("buyer/myBuyOrderList.htm")
	public String queryMyBuyOrderList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.queryMyBuyOrderList(request, response, model);
	}
	
	@RequestMapping("seller/validationQrCode.htm")
	public String validationQrCode(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.validationQrCode(request, response, model);
	}
}
