package com.yjf.esupplier.web.controller.front.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

@Controller
@RequestMapping("/do/discount")
public class DiscountManagerContoller extends FrontAutowiredBaseController {
	final static String path = "front/platform/member/product/";
	
	@RequestMapping("discount_index.htm")
	public String discountIndex(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		
		return path + "discount_index.vm";
	}
}
