package com.yjf.esupplier.web.controller.front.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.PersonalInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.SupplierBaseController;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

@Controller
@RequestMapping("/front/platform/shop/")
public class SupplierShopController extends SupplierBaseController {
	
	static String vm_path = "front/store/";
	
	/**
	 * @author qichunhai
	 * @description 企业首页信息处理
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("supplierShopSy.htm")
	public String supplierShopSy(HttpServletRequest request, HttpServletResponse response,
									Model model) throws Exception {
		
		String supplierid = request.getParameter("supplierid");
		long userId = NumberUtil.parseLong(supplierid);
		if (userId > 0) {
			UserInfo userInfo = userQueryService.queryByUserId(NumberUtil.parseLong(supplierid))
				.getQueryUserInfo();
			model.addAttribute("userInfo", userInfo);
			SupplierInfo supplierInfo = supplierService.getSupplier(new Long(supplierid));
			model.addAttribute("supplierInfo", supplierInfo);
			if (userInfo.getType() == UserTypeEnum.GR) {
				PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(
					userInfo.getUserBaseId()).getQueryPersonalInfo();
				model.addAttribute("personalInfo", personalInfo);
			} else {
				InstitutionsInfo institutionsInfo = userQueryService.queryInstitutionsInfoByBaseId(
					userInfo.getUserBaseId()).getQueryInstitutionsInfo();
				model.addAttribute("institutionsInfo", institutionsInfo);
			}
			List<ProductInfo> productSupplyList = productService
				.getProductListBySupplierId(new Integer(supplierid));
			model.addAttribute("productSupplyList", productSupplyList);
			
		}
		return "front/store/" + "storeFacade.vm";
	}
}
