/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.messageTake;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 *
 *
 * @Filename InfoOrderController.java
 *
 * @Description 信息订阅管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-4下午3:23:16</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/infoOrder/")
public class InfoOrderManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/infoOrderManage/";
	
	/**
	 * 信息订阅人列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toInfoOrderList.htm")
	public String toInfoOrderList(HttpServletRequest request, Model model){
		
		
		return vm_path + "infoOrderList.vm";
	}
	
	/**
	 * 取消信息订阅
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("setInfoOrderOff.htm")
	public String setInfoOrderOff(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 信息列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toInfoList.htm")
	public String toInfoList(HttpServletRequest request, Model model){
		
		
		return vm_path + "infoList.vm";
	}
	
	/**
	 * 信息详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getInfo.htm")
	public String getInfo(HttpServletRequest request, Model model){
		
		
		return vm_path + "info.vm";
	}

}
