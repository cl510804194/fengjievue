/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.infoOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

/**
 *
 *
 * @Filename InfoOrderController.java
 *
 * @Description	信息订阅管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7下午5:28:17</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/do/infoOrder")
public class InfoOrderController extends FrontAutowiredBaseController{
	
	final static String path = "front/infoOrder/";
	
	/**
	 * 信息订阅列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toInfoOrder.htm")
	public String toInfoOrder(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "infoOrder.vm";
	}
	
	/**
	 * 订阅信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("infoOrder.htm")
	public String infoOrder(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
	/**
	 * 修改接受邮箱
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("infoOrderEmail.htm")
	public String infoOrderEmail(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
	/**
	 * 取消全部订阅
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setAllCancel.htm")
	public String setAllCancel(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}

}
