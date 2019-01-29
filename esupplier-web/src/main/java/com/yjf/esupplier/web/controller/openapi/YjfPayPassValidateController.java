package com.yjf.esupplier.web.controller.openapi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("anon")
public class YjfPayPassValidateController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "yjfPayPassewordReturnUrl.htm")
	public String yjfPayPassewordReturnUrl(HttpServletRequest request,
											HttpServletResponse response, ModelMap modelMap) {
		String paytk = request.getParameter("paytk");
		modelMap.put("paytk", paytk);
		return "/paypage/payPassSuccess.vm";
		
	}
	
	@RequestMapping(value = "yjfPayPassewordCancelUrl.htm")
	public String yjfPayPassewordCancelUrl(HttpServletRequest request,
											HttpServletResponse response, ModelMap modelMap) {
		
		return "/paypage/payPassCancel.vm";
		
	}
}
