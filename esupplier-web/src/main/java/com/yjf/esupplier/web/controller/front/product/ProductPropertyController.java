package com.yjf.esupplier.web.controller.front.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.enums.PropertyTypeEnum;
import com.yjf.esupplier.ws.order.ProductPropertyQueryOrder;
import com.yjf.esupplier.ws.product.info.ProductPropertyInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

@Controller
@RequestMapping("/do/productProperty")
public class ProductPropertyController extends FrontAutowiredBaseController {
	
	@ResponseBody
	@RequestMapping("getSonProperty.json")
	public JSONArray getSonType(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		long typeId = Long.parseLong(request.getParameter("productType"));
		ProductTypeInfo typeInfo = productTypeService.findById(typeId);
		JSONArray jsonArray = new JSONArray();
		if(typeInfo!=null){
			//查询属性值
			ProductPropertyQueryOrder propertyOrder = new ProductPropertyQueryOrder();
			propertyOrder.setPropertyType(PropertyTypeEnum.STYLE.code());
			propertyOrder.setProductType(typeInfo.getPtCode());
			List<ProductPropertyInfo> propertyList = productPropertyService
					.getProductPropertyListByType(propertyOrder);
			List<Map<String, Object>> propertyListMap = MiscUtil.getMapListByPoList(propertyList);
			jsonArray.add(propertyListMap);
		}
		return jsonArray;
	}
	
}
