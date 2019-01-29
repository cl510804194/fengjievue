/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.supplier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

/**
 *
 *
 * @Filename SupplierVoucherManagerController.java
 *
 * @Description	供应商企业担保管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7下午4:10:50</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/do/voucher")
public class SupplierVoucherManagerController  extends FrontAutowiredBaseController{
	
final static String path = "front/voucher/";
	
	/**
	 * 进入身份担保列表页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("listVoucher.htm")
	public String listVoucher(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "voucher_list.vm";
	}
	
	/**
	 * 修改担保状态
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updVouchState.htm")
	public String updVouchState(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return "";
	}
	
}
