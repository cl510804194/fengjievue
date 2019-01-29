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
 * @Filename GroupPurchaseManageController.java
 *
 * @Description 团购管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-29下午4:23:50</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/groupPurchase/")
public class GroupPurchaseManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/groupPurchase/";
	
	/**
	 * 团购信息列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listGroupPurchase.htm")
	public String listGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + "groupPurchase_list.vm";
	}
	
	/**
	 * 团购信息详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("displayGroupPD.htm")
	public String displayGroupPD(HttpServletRequest request, Model model){
		
		
		return vm_path + "groupPurchaseDetail.vm";
	}
	
	/**
	 * 删除团购信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("removeGroupPurchase.htm")
	public String removeGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 修改团购信息状态
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("statusGroupPurchase.htm")
	public String statusGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 团购成员详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getMemberBuyDetail.htm")
	public String getMemberBuyDetail(HttpServletRequest request, Model model){
		
		
		return vm_path + "getMemberBuyDetail.vm";
	}
	
	/**
	 * 使团购成员团购有效
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("mkgMemberValid.htm")
	public String mkgMemberValid(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 使团购成员团购无效
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("mkgMemberInvalid.htm")
	public String mkgMemberInvalid(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	
	/**
	 * 进入添加团购详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toCreateGroupPurchase.htm")
	public String toCreateGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + "createGroupPurchase.vm";
	}
	
	/**
	 * 添加团购详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("appendGroupPurchase.htm")
	public String appendGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 进入修改团购信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateGroupPurchase.htm")
	public String toUpdateGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + "updateGroupPurchase.vm";
	}
	
	/**
	 * 修改团购详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("modifyGroupPurchase.htm")
	public String modifyGroupPurchase(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
}
