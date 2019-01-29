package com.yjf.esupplier.web.controller.backstage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 * @author Joe
 */
@Controller
@RequestMapping("/admin/")
public class BackstageIndexController extends BaseAutowiredController {
	
	@RequestMapping("index.htm")
	public String backstageIdex(HttpServletRequest request, Model model) {
		initMainPage(request, model);
		return "/backstage/mainFrame.vm";
	}
	
	@RequestMapping("nopermission.htm")
	public String hasNoPermission() {
		return "/backstage/nopermission.vm";
	}
	
	@RequestMapping("mainIndex.htm")
	public String mainIndex(HttpServletRequest request, Model model) {
		return "/backstage/mainIndex.vm";
	}
}
