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
 * @Filename SupplyAndPurchaseController.java
 *
 * @Description 供应和求购管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-29上午10:13:36</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/info/")
public class SupplyAndPurchaseController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/informationManage/";
	
	/**
	 * 供应列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAllSupplyInfoList.htm")
	public String toAllSupplyInfoList(HttpServletRequest request, Model model){
		
		
		return vm_path + "allSupplyInfoList.vm";
		
	}
	
	/**
	 * 设置供应商敏感词
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("setSupplyInfoCensor.htm")
	public String setSupplyInfoCensor(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
		
	}
	
	/**
	 * 审查供应商信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("checkSupplyInfo.htm")
	public String checkSupplyInfo(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
		
	}
	
	/**
	 * 求购列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAllPurchaseInfoList.htm")
	public String toAllPurchaseInfoList(HttpServletRequest request, Model model){
		
		
		return vm_path + "allPurchaseInfoList.vm";
		
	}

	/**
	 * 设置求购敏感词
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("setPurchaseInfoCensor.htm")
	public String setPurchaseInfoCensor(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
		
	}
	
	/**
	 * 审查求购信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("checkPurchaseInfo.htm")
	public String checkPurchaseInfo(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
		
	}
}
