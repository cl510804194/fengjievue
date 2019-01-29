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
 * @Filename AdvertManageController.java
 *
 * @Description	广告管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-29下午2:40:06</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/advert/")
public class AdvertManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/advertManage/";

	/**
	 * 查询广告列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("listAdvert.htm")
	public String listAdvert(HttpServletRequest request, Model model){
		
		
		return vm_path + "advert_list.vm";
	}
	
	/**
	 * 查询广告详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("infoAdvert.htm")
	public String infoAdvert(HttpServletRequest request, Model model){
		
		
		return vm_path + "advert_info.vm";
	}
	
	/**
	 * 初始化添加广告
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toInsertAdvert.htm")
	public String toInsertAdvert(HttpServletRequest request, Model model){
		
		
		return vm_path + "advert_add.vm";
	}
	
	/**
	 * 添加广告
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("insertAdvert.htm")
	public String insertAdvert(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 初始化修改广告
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateAdvert.htm")
	public String toUpdateAdvert(HttpServletRequest request, Model model){
		
		
		return vm_path + "advert_update.vm";
	}
	
	/**
	 * 修改广告
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateAdvert.htm")
	public String updateAdvert(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 修改广告状态
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updAdvertStatus.htm")
	public String updAdvertStatus(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 修改广告操作状态
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updAdvertHandleStatus.htm")
	public String updAdvertHandleStatus(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
}
