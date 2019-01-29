/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.infocenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

/**
 *
 *
 * @Filename InfoCenterController.java
 *
 * @Description 信息中心管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7下午4:18:21</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/do/infoc")
public class InfoCenterController extends FrontAutowiredBaseController{
	
	final static String path = "front/infoCenter/";
	
	/**
	 * 进入新建信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toCreateInfoCenter.htm")
	public String toCreateInfoCenter(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "createInfoCenter.vm";
	}
	
	/**
	 * 新建信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("createInfoCenter.htm")
	public String createInfoCenter(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
	/**
	 * 更改信息状态
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setInfoCenterStatus.htm")
	public String setInfoCenterStatus(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
	/**
	 * 信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toInfoCenterList.htm")
	public String toInfoCenterList(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "infoCenterList.vm";
	}
	
	/**
	 * 进入修改信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateInfoCenter.htm")
	public String toUpdateInfoCenter(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "updateInfoCenter.vm";
	}
	
	/**
	 * 修改信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updateInfoCenter.htm")
	public String updateInfoCenter(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
	/**
	 * 删除信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteInfoCenter.htm")
	public String deleteInfoCenter(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "";
	}
	
}
