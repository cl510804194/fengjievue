/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.huaZhang;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 *
 *
 * @Filename HuaZhangController.java
 *
 * @Description 划账管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-4下午3:57:37</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/infoOrder/")
public class HuaZhangController extends BaseAutowiredController{
	
private final String vm_path = "/backstage/huazhangManage/";
	
	/**
	 * 划账列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toOrderList.htm")
	public String toInfoOrderList(HttpServletRequest request, Model model){
		
		
		return vm_path + "orderList.vm";
	}
	
	/**
	 * 划账操作
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("huaZhang.htm")
	public String huaZhang(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 财务报表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("downloadExcel.htm")
	public String downloadExcel(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}

}
