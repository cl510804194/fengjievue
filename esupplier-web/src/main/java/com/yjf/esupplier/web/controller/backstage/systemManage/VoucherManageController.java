/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 *
 *
 * @Filename VoucherManageController.java
 *
 * @Description 担保管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-29上午11:24:12</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/voucher/")
public class VoucherManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/voucherManage/";
	
	/**
	 * 查询担保列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listAllVoucher.htm")
	public String listAllVoucher(HttpServletRequest request, Model model){
		
		
		return vm_path + "allvouch_list.vm";
		
	}

}
