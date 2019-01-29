package com.yjf.esupplier.web.controller.front.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/do/productType")
public class ProductTypeController extends FrontAutowiredBaseController {

	final static String vm_path = "front/productType/";


	@ResponseBody
	@RequestMapping("getSonType.json")
	public JSONArray getSonType(HttpServletRequest request, HttpServletResponse response, Model model) {
		SupplierInfo supplierInfo = supplierService.getCurrentSupplier();
		List<ProductTypeInfo> firstType = productTypeService.getFirstProductType(supplierInfo);
		List<ProductTypeInfo> secondType = productTypeService.getSecondProductType(supplierInfo);
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(supplierInfo);
		List<Map<String, Object>> firstTypeListMap = MiscUtil.getMapListByPoList(firstType);
		List<Map<String, Object>> secondTypeListMap = MiscUtil.getMapListByPoList(secondType);
		List<Map<String, Object>> thridTypeListMap = MiscUtil.getMapListByPoList(thridType);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(firstTypeListMap);
		jsonArray.add(secondTypeListMap);
		jsonArray.add(thridTypeListMap);
		return jsonArray;
	}

	@ResponseBody
	@RequestMapping("getSonTypeByScenic.json")
	public JSONArray getSonTypeByScenic(HttpServletRequest request, HttpServletResponse response, Model model) {
		/*取消供应商选择自己分类的限制*/
		String supplierId = (String) request.getParameter("supplierId");
		String saleType = (String) request.getParameter("saleType");
		SupplierInfo supplierInfo = supplierService.getSupplier(Long.parseLong(supplierId));
		List<Map<String, Object>> supplierMap = new ArrayList<Map<String, Object>>();
		if(supplierInfo!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			if(supplierInfo.getHotels() != null){
				map.put("hotels",supplierInfo.getHotels().getCode());
			}
			supplierMap.add(map);
		}
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		if(StringUtil.isNotEmpty(saleType)) queryOrder.setPtNotes(saleType);
		List<ProductTypeInfo> firstType = productTypeService.getFirstProductType(queryOrder);
		List<ProductTypeInfo> secondType = productTypeService.getSecondProductType(queryOrder);
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(queryOrder);
		List<Map<String, Object>> firstTypeListMap = MiscUtil.getMapListByPoList(firstType);
		List<Map<String, Object>> secondTypeListMap = MiscUtil.getMapListByPoList(secondType);
		List<Map<String, Object>> thridTypeListMap = MiscUtil.getMapListByPoList(thridType);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(firstTypeListMap);
		jsonArray.add(secondTypeListMap);
		jsonArray.add(thridTypeListMap);
		jsonArray.add(supplierMap);
		return jsonArray;
	}

	@RequestMapping("getSonType1.htm")
	public String getSonType1(HttpServletRequest request, HttpServletResponse response, Model model) {

		SupplierInfo supplier = supplierService.getCurrentSupplier();

		List<ProductTypeInfo> firstType = productTypeService.getFirstProductType(supplier);
		List<ProductTypeInfo> secondType = productTypeService.getSecondProductType(supplier);
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(supplier);

		List<Map<String, Object>> firstTypeListMap = MiscUtil.getMapListByPoList(firstType);
		List<Map<String, Object>> secondTypeListMap = MiscUtil.getMapListByPoList(secondType);
		List<Map<String, Object>> thridTypeListMap = MiscUtil.getMapListByPoList(thridType);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(firstTypeListMap);
		jsonArray.add(secondTypeListMap);
		jsonArray.add(thridTypeListMap);
		printHttpResponse(response, jsonArray);
		return null;
	}

	@RequestMapping("getThirdType.htm")
	public String getThirdType(HttpServletRequest request, HttpServletResponse response, Model model) {
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(queryOrder);
		List<Map<String, Object>> thridTypeListMap = MiscUtil.getMapListByPoList(thridType);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(thridTypeListMap);
		printHttpResponse(response, jsonArray);
		return null;
	}

	@RequestMapping("getAllTreeType.json")
	@ResponseBody
	public String getAllTreeType(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<ProductTypeInfo> typeInfoList = productTypeService.getProductTypeAll();
		return typeInfoList.toString();
	}

	@RequestMapping("getAllType.htm")
	public String getAllType(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		List<ProductTypeInfo> firstType = productTypeService.getFirstProductType(queryOrder);
		List<ProductTypeInfo> secondType = productTypeService.getSecondProductType(queryOrder);
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(queryOrder);
		model.addAllAttributes(WebUtil.getRequestMap(request));
		model.addAttribute("firstType", firstType);
		model.addAttribute("secondType", secondType);
		model.addAttribute("thridType", thridType);
		return vm_path + "selectProductType.vm";
	}
}
