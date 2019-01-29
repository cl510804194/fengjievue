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
 * @Filename CensorAndKeywordController.java
 *
 * @Description 敏感词和关键字管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-28下午3:04:08</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/ck/")
public class CensorAndKeywordController extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/systemManage/ckManage/";
	
	/**
	 * 敏感词表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toCensorTable.htm")
	public String getAdPicType(HttpServletRequest request, Model model){
		
		
		return vm_path + "censorTable.vm";
	}
	
	/**
	 * 修改敏感词
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateCensorword.htm")
	public String updateCensorword(HttpServletRequest request, Model model){
		
		
		return "";
	}
	
	/**
	 * 关键字表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toKeywordTable.htm")
	public String toKeywordTable(HttpServletRequest request, Model model){
		
		
		return vm_path + "keywordTable.vm";
	}
	
	/**
	 * 修改关键字
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateKeyword.htm")
	public String updateKeyword(HttpServletRequest request, Model model){
		
		
		return "";
	}
	

}
