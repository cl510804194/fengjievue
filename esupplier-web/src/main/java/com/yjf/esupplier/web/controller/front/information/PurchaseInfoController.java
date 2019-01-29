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
 * @Filename PurchaseInfoController.java
 *
 * @Description 求购信息管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7上午11:11:31</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/do/info")
public class PurchaseInfoController extends FrontAutowiredBaseController{
	
	final static String path = "front/information/";
	
	/**
	 * 进入发布求购信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toCreatePurchaseInfo.htm")
	public String toCreatePurchaseInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "createPurchaseInfo.vm";
	}
	
	/**
	 * 发布求购信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("createPurchaseInfo.htm")
	public String createPurchaseInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "infoOK.vm";
	}
	
	/**
	 * 进入修改求购信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdatePurchaseInfo.htm")
	public String toUpdatePurchaseInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "updatePurchaseInfo.vm";
	}
	
	/**
	 * 修改求购信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updatePurchaseInfo.htm")
	public String updatePurchaseInfo(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		return path + "infoOK.vm";
	}
	
	/**
	 * 已发布上网求购信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toPurchaseInfoListOn.htm")
	public String toPurchaseInfoListOn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "purchaseInfoListOn.vm";
	}
	
	/**
	 * 未发布上网求购信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("toPurchaseInfoListOff.htm")
	public String toPurchaseInfoListOff(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "purchaseInfoListOff.vm";
	}
	
	/**
	 * 查询已发布上网求购信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("searchPurchaseInfoListOn.htm")
	public String searchPurchaseInfoListOn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "searchPurchaseInfoListOn.vm";
	}
	
	/**
	 * 查询未发布上网求购信息列表
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("searchPurchaseInfoListOff.htm")
	public String searchPurchaseInfoListOff(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + "searchPurchaseInfoListOff.vm";
	}
	
	/**
	 * 求购信息--取消发布操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setPurchaseInfoOff.htm")
	public String setPurchaseInfoOff(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + " ";
	}
	
	/**
	 * 求购信息--发布上网操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setPurchaseInfoOn.htm")
	public String setPurchaseInfoOn(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + " ";
	}
	
	/**
	 * 求购信息--永久删除操作
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("setPurchaseInfoDel.htm")
	public String setPurchaseInfoDel(HttpServletRequest request, HttpServletResponse response,
									Model model) {
		
		
		return path + " ";
	}

}
