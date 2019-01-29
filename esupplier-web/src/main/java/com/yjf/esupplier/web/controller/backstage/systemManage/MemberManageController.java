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
 * @Filename MemberManageController.java
 *
 * @Description 会员管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-27下午2:50:13</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/member/")
public class MemberManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/memberManage/";
	
	/**
	 * 查询会员列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listMemberByParam.htm")
	public String listMemberByParam(HttpServletRequest request, Model model){
		
		
		return vm_path + "member_list.vm";
	}
	
	/**
	 * 查询单个会员
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getMemberById.htm")
	public String getMemberById(HttpServletRequest request, Model model){
		
		
		return vm_path + "member_list.vm";
	}
	
	
	/**
	 * 检查会员
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("adminCheckMember.htm")
	public String adminCheckMember(HttpServletRequest request, Model model){
		
		
		return "";
	}
	
	/**
	 * 删除会员
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("delMemberInfo.htm")
	public String delMemberInfo(HttpServletRequest request, Model model){
		
		
		return " ";
	}
	
	/**
	 * 冻结/恢复会员
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updMemberLocked.htm")
	public String updMemberLocked(HttpServletRequest request, Model model){
		
		
		return " ";
	}
	
	/**
	 * 按条件查询商务会员列表—————— 综合查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("generalListMember.htm")
	public String generalListMember(HttpServletRequest request, Model model){
		
		
		return vm_path + "general_member_list.vm";
	}
	

}
