/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @Filename GeoLocManageController.java
 *
 * @Description 地区维护管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-28下午2:45:25</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/geoLocManage/")
public class GeoLocManageController {
	
	private final String vm_path = "/backstage/systemManage/geoLocManage/";
	
	/**
	 * 地区表维护
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toView.htm")
	public String toView(HttpServletRequest request, Model model){
		
		
		return vm_path + "geoLocManage.vm";
	}
	
	/**
	 * 修改地区表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("doUpdate.htm")
	public String doUpdate(HttpServletRequest request, Model model){
		
		
		return "";
	}

}
