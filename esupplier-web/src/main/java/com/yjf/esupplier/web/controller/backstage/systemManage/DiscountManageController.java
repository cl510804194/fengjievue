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
 * @Filename DiscountManageController.java
 *
 * @Description 折扣管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-29下午1:48:04</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/discount/")
public class DiscountManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/discountManage/";
	
	/**
	 * 查询折扣列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listAdminDiscount.htm")
	public String listAdminDiscount(HttpServletRequest request, Model model){
		
		
		return vm_path + "discount_list.vm";
		
	}
	
	/**
	 * 新增折扣活动
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toInsertAdminDiscount.htm")
	public String toInsertAdminDiscount(HttpServletRequest request, Model model){
		
		
		return vm_path + "discount_Admin_add.vm";
		
	}
	
	/**
	 * 新增折扣活动提交
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("insertAdminDiscount.htm")
	public String insertAdminDiscount(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
		
	}
	
	/**
	 * 删除折扣活动
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("delAdminDiscount.htm")
	public String delAdminDiscount(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
		
	}
	
	/**
	 * 初始化修改折扣活动
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateAdminDiscount.htm")
	public String toUpdateAdminDiscount(HttpServletRequest request, Model model){
		
		
		return vm_path + "discount_update.vm";
		
	}
	
	/**
	 * 修改折扣活动
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateAdminDiscount.htm")
	public String updateAdminDiscount(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
		
	}

	
	/**
	 * 查看折扣活动详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listAdminSupplierJoinInfo.htm")
	public String listAdminSupplierJoinInfo(HttpServletRequest request, Model model){
		
		
		return vm_path + "discount_info.vm";
		
	}
}
