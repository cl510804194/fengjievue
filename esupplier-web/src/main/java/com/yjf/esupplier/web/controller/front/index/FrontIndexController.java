/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 下午4:17:15 创建
 */
package com.yjf.esupplier.web.controller.front.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

/**
 *
 *
 * @author zhouwei
 *
 */
@Controller
public class FrontIndexController extends FrontAutowiredBaseController {
	
	final static String vm_path = "front/index/";

	@RequestMapping("/front/index.htm")
	public String backstageIdex(HttpServletRequest request, Model model) {
		return vm_path + "index.vm";
	}

	@RequestMapping("/front/anon/bannerImage.htm")
	public String bannerImage(HttpServletRequest request, Model model) {
		String imageUrl = request.getParameter("imageUrl");
		model.addAttribute("imageUrl",imageUrl);
		return vm_path + "bannerImage.vm";
	}
}
