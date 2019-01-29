package com.yjf.esupplier.web.controller.front.scenicCenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.BaseController.AfterMarketBaseContorllor;

@Controller
@RequestMapping("/do/scenic")
public class ScenicAfterMarketContorllor extends AfterMarketBaseContorllor {
	

	@RequestMapping("doCenter/sellerRefundApplyCheckList.htm")
	public String sellerRefundApplyCheckList(	HttpServletRequest request,
												HttpServletResponse response, Model model) {
		return super.sellerRefundApplyCheckList(request, response, model);
	}
	
	@RequestMapping("doCenter/sellerRefundGoodsConfirmList.htm")
	public String sellerRefundGoodsConfirmList(	HttpServletRequest request,
												HttpServletResponse response, Model model) {
		return super.sellerRefundGoodsConfirmList(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("doCenter/refundApplyCheck.htm")
	public String refoundApplyCheck(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.refoundApplyCheck(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("doCenter/refundApplyCheckSubmit.htm")
	public String refundApplyCheckSubmit(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.refundApplyCheckSubmit(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("doCenter/refundConfirmGoods.htm")
	public String refundConfirmGoods(	HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.refundConfirmGoods(request, response, model);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("doCenter/refundConfirmGoodsSubmit.htm")
	public String refundConfirmGoodsSubmit(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.refundConfirmGoodsSubmit(request, response, model);
	}
	
	@RequestMapping("doCenter/sellerRefundListSearch.htm")
	public String sellerRefundListSearch(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.sellerRefundListSearch(request, response, model);
	}

}
