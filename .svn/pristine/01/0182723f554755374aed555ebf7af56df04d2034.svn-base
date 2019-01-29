/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.advert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

/**
 *
 *
 * @Filename ProposerAdvertController.java
 *
 * @Description 广告管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7下午4:35:48</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/do/advert")
public class ProposerAdvertController extends FrontAutowiredBaseController{

	final static String path = "front/advert/";
	
	/**
	 * 广告列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("listAdvert.htm")
	public String listAdvert(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "proposerAdvert_list.vm";
	}
	
	/**
	 * 进入申请广告页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("applyAdvert.htm")
	public String applyAdvert(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "advert_apply.vm";
	}
	
	/**
	 * 申请广告
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("insertAdvert.htm")
	public String insertAdvert(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
	/**
	 * 取消申请广告
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("cancelProposertAdvert.htm")
	public String cancelProposertAdvert(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
}
