/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.quotationManage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

/**
 *
 *
 * @Filename QuotationManageControl.java
 *
 * @Description 行情和行情市场管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-4上午9:39:15</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/quotation/")
public class QuotationManageControl extends BaseAutowiredController{
	
	private final String vm_path = "/backstage/quotationManage/";
	
	/**
	 * 行情查询列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!toView")
	public String toViewlist(HttpServletRequest request, Model model){
		
		
		return vm_path + "quotation_viewlist.vm";
	}
	
	/**
	 * 行情新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!toNew")
	public String toNew(HttpServletRequest request, Model model){
		
		
		return vm_path + "quotation_new.vm";
	}
	
	/**
	 * 执行 行情新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!doNew")
	public String doNew(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 行情修改初始化，通过 行情编号快速定位 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!toUpdate")
	public String toUpdate(HttpServletRequest request, Model model){
		
		
		return vm_path + "quotation_update.vm";
	}
	
	/**
	 * 执行 行情修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!doUpdate")
	public String doUpdate(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 行情修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!toUpdate2")
	public String toUpdate2(HttpServletRequest request, Model model){
		
		
		return vm_path + "quotation_update.vm";
	}
	
	/**
	 * 执行 行情删除
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!doDelete")
	public String doDelete(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 行情批量新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!toNews")
	public String toNews(HttpServletRequest request, Model model){
		
		
		return vm_path + "quotation_news.vm";
	}
	
	/**
	 * 执行 批量新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!doNews")
	public String doNews(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 行情预览
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("quotation-control.htm!doPreview")
	public String doPreview(HttpServletRequest request, Model model){
		
		
		return vm_path + "quotation_preview.vm";
	}
	
	/**
	 * 行情市场列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("initMarketView.htm")
	public String initMarketView(HttpServletRequest request, Model model){
		
		
		return vm_path + "quoMarketViewList.vm";
	}
	
	/**
	 * 新增行情市场
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAddMarket.htm")
	public String toAddMarket(HttpServletRequest request, Model model){
		
		
		return vm_path + "quoMarket.vm";
	}
	
	/**
	 * 行情产品列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toQuoPdtView.htm")
	public String toQuoPdtView(HttpServletRequest request, Model model){
		
		
		return vm_path + "quoPdtViewList.vm";
	}
	
	/**
	 * 行情产品列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAddQuoPdt.htm")
	public String toAddQuoPdt(HttpServletRequest request, Model model){
		
		
		return vm_path + "quoPdt.vm";
	}
	
	/**
	 * 行情产品类型列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toQuoPTView.htm")
	public String toQuoPTView(HttpServletRequest request, Model model){
		
		
		return vm_path + "quoPTViewList.vm";
	}
	
	/**
	 * 新增行情产品类型
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAddQuoPT.htm")
	public String toAddQuoPT(HttpServletRequest request, Model model){
		
		
		return vm_path + "quoPT.vm";
	}
	
	/**
	 * 删除行情市场
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("delMarket.htm")
	public String delMarket(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}
	
	/**
	 * 删除行情产品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("delPdt.htm")
	public String delPdt(HttpServletRequest request, Model model){
		
		
		return vm_path + "";
	}

}
