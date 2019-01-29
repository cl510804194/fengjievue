/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.reportManage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 *
 *
 * @Filename ReportDetailController.java
 *
 * @Description 订单信息详情控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-4下午4:56:39</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/orderReport/")
public class ReportDetailController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/reportManage/";
	
	/**
	 * 订单统计
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getReportDetail.htm")
	public String getReportDetail(HttpServletRequest request, Model model){
		
		
		return vm_path + "orderReport.vm";
	}
	
	/**
	 * 得到到账金额
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getInAccountMoney.htm")
	public String getInAccountMoney(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}

}
