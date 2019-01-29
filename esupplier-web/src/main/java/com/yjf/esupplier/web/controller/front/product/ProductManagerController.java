package com.yjf.esupplier.web.controller.front.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.web.controller.front.BaseController.ProductManagerBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.ws.product.order.UpdateProductStatusOrder;

@Controller
@RequestMapping("/do/product")
public class ProductManagerController extends ProductManagerBaseController {
	
	@RequestMapping("seller/toCreateProduct.htm")
	public String toCreateProduct(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.toCreateProduct(request, response, model);
	}
	
	@RequestMapping("seller/createProduct.htm")
	public String createProduct(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.createProduct(request, response, model);
	}
	
	@RequestMapping("seller/toUpdateProduct.htm")
	public String toUpdateProduct(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		return super.toUpdateProduct(request, response, model);
	}
	
	@RequestMapping("seller/updateProduct.htm")
	public String updateProduct(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.updateProduct(request, response, model);
	}
	
	@RequestMapping("seller/checkProductNumber.htm")
	public String checkProductNumber(	HttpServletRequest request, HttpServletResponse response,
										Model model) {
		return super.checkProductNumber(request, response, model);
	}
	
	@RequestMapping("seller/toProductList.htm")
	public String toProductList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.toProductList(request, response, model);
	}
	
	@RequestMapping("seller/setProductOff.htm")
	public String setProductOff(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.setProductOff(request, response, model);
	}
	
	@RequestMapping("seller/setProductOn.htm")
	public String setProductOn(	HttpServletRequest request, HttpServletResponse response,
								Model model) {
		return super.setProductOn(request, response, model);
	}
	
	public UpdateProductStatusOrder makeUpdateSatutsOrder(String productIdString) {
		return super.makeUpdateSatutsOrder(productIdString);
	}
	
	@RequestMapping("seller/setProductDel.htm")
	public String updateProductStatusDel(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		return super.updateProductStatusDel(request, response, model);
	}
}
