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
 * @Filename SpecialGroupProductController.java
 *
 * @Description 特殊商品和商品分组控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-4-28下午5:09:33</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/spe/")
public class SpecialGroupProductController extends BaseAutowiredController{
	 
	private final String vm_path = "/backstage/systemManage/product/";
	
	/**
	 * 商品分组列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toProductGroupList.htm")
	public String toProductGroupList(HttpServletRequest request, Model model){
		
		
		return vm_path + "productGroupList.vm";
		
	}
	
	/**
	 * 创建商品分组
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toCreateProductGroup.htm")
	public String toCreateProductGroup(HttpServletRequest request, Model model){
		
		
		return vm_path + "createProductGroup.vm";
	}
	
	/**
	 * 创建商品分组提交
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("createProductGroup.htm")
	public String createProductGroup(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 修改商品分组
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateProductGroup.htm")
	public String toUpdateProductGroup(HttpServletRequest request, Model model){
		
		
		return vm_path + "updateProductGroup.vm";
	}
	
	/**
	 * 修改商品分组提交
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateProductGroup.htm")
	public String updateProductGroup(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 删除商品分组
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteProductGroup.htm")
	public String deleteProductGroup(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 特殊商品列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toSpecialProductList.htm")
	public String toSpecialProductList(HttpServletRequest request, Model model){
		
		
		return vm_path + "specialProductList.vm";
	}
	
	/**
	 * 所有特殊商品列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toAllSelectProductList.htm")
	public String toAllSelectProductList(HttpServletRequest request, Model model){
		
		
		return vm_path + "allSelectProductList.vm";
	}
	
	/**
	 * 添加特殊商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("addSpecialProduct.htm")
	public String addSpecialProduct(HttpServletRequest request, Model model){
		
		
		return vm_path + "addSpecialProduct.vm";
	}
	
	/**
	 * 进入修改特殊商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateSpecialProduct.htm")
	public String toUpdateSpecialProduct(HttpServletRequest request, Model model){
		
		
		return vm_path + "updateSpecialProduct.vm";
	}
	
	/**
	 * 修改特殊商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateSpecialProduct.htm")
	public String updateSpecialProduct(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 删除特殊商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteSpecialProduct.htm")
	public String deleteSpecialProduct(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	/**
	 * 修改特殊商品的序号
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("updateSnumber.htm")
	public String updateSnumber(HttpServletRequest request, Model model){
		
		
		return vm_path + " ";
	}
	
	
}
