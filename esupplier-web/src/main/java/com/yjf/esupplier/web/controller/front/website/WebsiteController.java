package com.yjf.esupplier.web.controller.front.website;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

@Controller
@RequestMapping("/website")
public class WebsiteController  extends FrontAutowiredBaseController {
	final static String vm_path = "/website/";

	@RequestMapping("webIndex.htm")
	public String webIndex(HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		
		return vm_path+"webIndex.vm";
	}
	

	/*
	 * 通用跳转页面 *
	 */
	@RequestMapping("{funtcion}.htm")
	public String loanSystem(HttpServletRequest request,
			@PathVariable String funtcion, Model model) {
		return vm_path + funtcion + ".vm";

	}
}