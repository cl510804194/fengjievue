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
 * @Filename AdPicManageController.java
 *
 * @Description 广告图片管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-28下午1:41:49</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/adPic/")
public class AdPicManageController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/adpicManage/";
	
	/**
	 * 广告图片列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getAdPicType.htm")
	public String getAdPicType(HttpServletRequest request, Model model){
		
		
		return vm_path + "picManage.vm";
	}
	
	/**
	 * 新增广告图片
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("addPic.htm")
	public String addPic(HttpServletRequest request, Model model){
		
		
		return vm_path + "addPic.vm";
	}
	
	/**
	 * 删除广告图片
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("delAdPicType.htm")
	public String delAdPicType(HttpServletRequest request, Model model){
		
		
		return "";
	}
	
	/**
	 * 修改广告图片
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("getUpAdPic.htm")
	public String getUpAdPic(HttpServletRequest request, Model model){
		
		
		return vm_path + "picManage.vm";
	}

}
