/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.information;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;

/**
 *
 *
 * @Filename SupplyInfoController.java
 *
 * @Description 供应信息管理控制器  	
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7上午10:15:20</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/do/info")
public class SupplyInfoController extends FrontAutowiredBaseController {
	
	final static String path = "front/information/";
	
	/**
	 * 进入发布供应信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toCreateSupplyInfo.htm")
	public String toCreateSupplyInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "createSupplyInfo.vm";
	}
	
	/**
	 * 发布供应信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("createSupplyInfo.htm")
	public String createSupplyInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "infoOK.vm";
	}
	
	/**
	 * 进入修改供应信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateSupplyInfo.htm")
	public String toUpdateSupplyInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "updateSupplyInfo.vm";
	}
	
	/**
	 * 修改供应信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updateSupplyInfo.htm")
	public String updateSupplyInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "infoOK.vm";
	}
	
	/**
	 * 已发布上网供应信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toSupplyInfoListOn.htm")
	public String toSupplyInfoListOn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "supplyInfoListOn.vm";
	}
	
	/**
	 * 未发布上网供应信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toSupplyInfoListOff.htm")
	public String toSupplyInfoListOff(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "supplyInfoListOff.vm";
	}
	
	/**
	 * 查询已发布上网供应信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("searchSupplyInfoListOn.htm")
	public String searchSupplyInfoListOn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "searchSupplyInfoListOn.vm";
	}
	
	/**
	 * 查询未发布上网供应信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("searchSupplyInfoListOff.htm")
	public String searchSupplyInfoListOff(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "searchSupplyInfoListOff.vm";
	}
	
	/**
	 * 供应信息--取消发布操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setSupplyInfoOff.htm")
	public String setSupplyInfoOff(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + " ";
	}
	
	/**
	 * 供应信息--发布上网操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setSupplyInfoOn.htm")
	public String setSupplyInfoOn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + " ";
	}
	
	/**
	 * 供应信息--永久删除操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setSupplyInfoDel.htm")
	public String setSupplyInfoDel(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + " ";
	}
	
	
}
