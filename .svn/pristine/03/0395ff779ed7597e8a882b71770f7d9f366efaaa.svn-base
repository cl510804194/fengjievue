/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.common.util.DataBaseUtil;
import com.yjf.esupplier.dal.dataobject.TblProductTypeDO;
import com.yjf.esupplier.service.exception.ExceptionFactory;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;

import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import jxl.common.BaseUnit;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.base.data.BaseDataLoader;
import com.yjf.esupplier.service.product.ProductTypeService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import com.yjf.esupplier.ws.product.order.ProductTypeSaveOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import rop.thirdparty.org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @Filename ProductTypeManageController.java
 *
 * @Description 商品分类管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History
 * <li>Author: oyangnuo</li>
 * <li>Date: 2015-4-28下午3:28:07</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */

@Controller
@RequestMapping("/admin/product/productType")
public class ProductTypeManageController extends BaseAutowiredController {

	private final String vm_path = "/backstage/systemManage/productType/";

	@Autowired
	ProductTypeService productTypeService;
	@Autowired
	ProductService productService;
	@Autowired
	BaseDataLoader baseDataLoader;

	/**
	 * 进入商品分类表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("productTypeList.htm")
	public String productTypeList(HttpServletRequest request, Model model) {
		ProductTypeQueryOrder order = new ProductTypeQueryOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		model.addAllAttributes(WebUtil.getRequestMap(request));
		int page = (int) NumberUtil.parseLong(request.getParameter("pageNo"), 1);
		int pageSize = (int) NumberUtil.parseLong(request.getParameter("pageSize"), 10);
		order.setPageSize(pageSize);
		order.setPageNumber(page);
		QueryBaseBatchResult<ProductTypeInfo> batchResult = productTypeService
				.findByCondition(order);
		model.addAttribute("searchList", batchResult.getPageList());
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage(page);
		pageTool.setPageSize(pageSize);
		pageTool.setTotalRow((int) batchResult.getTotalCount());
		model.addAttribute("pageBar", pageTool.getPageBar());
		model.addAttribute("page",
				PageUtil.getCovertPageByPageTools(batchResult.getPageList(), pageTool));
		model.addAttribute("level1List", baseDataLoader.getLevelProductTypeInfoList(0));
		return vm_path + "productType_list.vm";

	}

	@RequestMapping("viewProductTypeInfo.htm")
	public String viewProductTypeInfo(HttpServletRequest request, Model model) {
		boolean isNew = false;
		String ptid = request.getParameter("ptid");
		ProductTypeInfo typeInfo = productTypeService.findById(NumberUtil.parseLong(ptid));
		ProductTypeInfo parentTypeInfo = null;
		if (typeInfo == null) {
			typeInfo = new ProductTypeInfo();
			isNew = true;
		} else {
			parentTypeInfo = productTypeService.findById(typeInfo.getPtParentId());
		}
		List<String> columnList = new ArrayList<String>();
		if (StringUtil.isNotEmpty(typeInfo.getPtAddColumns())) {
			String[] columns = typeInfo.getPtAddColumns().split(",");
			columnList = Arrays.asList(columns);
		}
		if (isNew) {
			model.addAttribute("isEnable", "");
		} else {
			QueryBaseBatchResult<ProductInfo> productInfoQueryBaseBatchResult = productService
					.getProductListByType(typeInfo.getPtCode(), 0, 1, null);
			model.addAttribute("isEnable",
					productInfoQueryBaseBatchResult.getTotalCount() > 0 ? "disabled" : "");
		}
		List<SaleTypeEnum> saleTypeEnumList = SaleTypeEnum.getProductTypeEnum();
		if (!isNew) {
			List<SaleTypeEnum> removeList = new ArrayList<SaleTypeEnum>();
			for (SaleTypeEnum saleTypeEnum : saleTypeEnumList) {
				if (parentTypeInfo != null
						&& !parentTypeInfo.getPtNote().contains(saleTypeEnum.getCode())) {
					removeList.add(saleTypeEnum);
				}
			}
			saleTypeEnumList.removeAll(removeList);
		}
		model.addAllAttributes(WebUtil.getRequestMap(request));
		model.addAttribute("productTypeInfo", typeInfo);
		model.addAttribute("columnList", columnList);
		model.addAttribute("saleTypeEnumList", saleTypeEnumList);
		model.addAttribute("listLen", columnList.size());
		return vm_path + "productTypeInfo.vm";

	}

	@RequestMapping("updateProductTypeInfo.htm")
	public String updateProductTypeInfo(HttpServletRequest request, HttpServletResponse response,
										Model model) throws Exception {
		boolean isNew = false;
		String ptid = request.getParameter("ptid");
		String operate = request.getParameter("operate");
		int maxCnt = Integer.parseInt(request.getParameter("maxCnt"));
		String ptAddColumns = "";
		int cnt = 0;
		for (int i = 1; i <= maxCnt; i++) { /*只有5个字段，由于可以删除，顺序会乱，全部都检查下*/
			if (cnt >= 5)
				break;
			String name = request.getParameter("addColumn" + i);
			if (StringUtil.isEmpty(name))
				continue; /*页面没有或者已经删除*/
			if (ptAddColumns.equals("")) {
				ptAddColumns = name;
			} else {
				ptAddColumns = ptAddColumns + "," + name;
			}
			cnt++;
		}
		String[] ptNotes = request.getParameterValues("ptNote");
		String ptNote = StringUtils.join(ptNotes, ",");
		ProductTypeSaveOrder saveOrder = new ProductTypeSaveOrder();
		WebUtil.setPoPropertyByRequest(saveOrder, request);
		saveOrder.setPtAddColumns(ptAddColumns);
		saveOrder.setPtNote(ptNote);
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		if (saveOrder.getPtId() == 0) {
			baseResult = productTypeService.insertType(saveOrder);
		} else {
			baseResult = productTypeService.updateType(saveOrder);
			List<ProductTypeInfo> childList = productTypeService
					.getProductTypeByFatherId(saveOrder.getPtId());
			List<SaleTypeEnum> saleTypeEnumList = SaleTypeEnum
					.getProductTypeNotEnum(saveOrder.getPtNote());
			if (childList != null) {
				for (ProductTypeInfo typeInfo : childList) {
					String _ptNote = typeInfo.getPtNote();
					if(StringUtil.isNotEmpty(_ptNote)) {
						for (SaleTypeEnum saleTypeEnum : saleTypeEnumList) {
							_ptNote = _ptNote.replace(saleTypeEnum.getCode() + ",", "");
							_ptNote = _ptNote.replace("," + saleTypeEnum.getCode(), "");
							_ptNote = _ptNote.replace(saleTypeEnum.getCode(), "");
						}
						typeInfo.setPtNote(_ptNote);
					}
					ProductTypeSaveOrder childOrder = new ProductTypeSaveOrder();
					BeanCopier.staticCopy(typeInfo, childOrder);
					productTypeService.updateType(childOrder);
				}
			}
		}
		model.addAttribute("productTypeInfo", saveOrder);
		if (baseResult.isSuccess()) {
			if ("addNew".equals(operate)) {
				sendUrl(response, "viewProductTypeInfo.htm");
			} else {
				sendUrl(response, "productTypeList.htm");
			}
			return null;
		} else {
			model.addAttribute("message", baseResult.getMessage());
		}
		return vm_path + "productTypeInfo.vm";

	}

	@RequestMapping("deleteProductTypeInfo.htm")
	public String deleteProductTypeInfo(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		String ptid = request.getParameter("ptid");
		ProductTypeInfo typeInfo = productTypeService.findById(NumberUtil.parseInt(ptid));
		if (typeInfo == null) {
			throw ExceptionFactory.newYrdException(EsupplierResultEnum.HAVE_NOT_DATA,
					"产品类型不存在,产品分类ID[" + ptid + "]");
		}
		ProductTypeSaveOrder saveOrder = new ProductTypeSaveOrder();
		BeanCopier.staticCopy(typeInfo, saveOrder);
		EsupplierBaseResult baseResult = productTypeService.deleteType(saveOrder);
		if (!baseResult.isSuccess()) {
			model.addAttribute("message", baseResult.getMessage());
		}
		return productTypeList(request, model);

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("existProductTypeCode.htm")
	public String existProductTypeCode(	HttpServletRequest request, HttpServletResponse response,
										   Model model) {
		boolean isExist = false;
		String ptid = request.getParameter("ptid");
		String code = request.getParameter("code");
		if (StringUtil.isNotEmpty(ptid)) {
			ProductTypeInfo productTypeInfo = productTypeService.findByPtCode(code);
			if (productTypeInfo != null) {
				if (StringUtil.isNotBlank(ptid)) {
					if (productTypeInfo.getPtId() != NumberUtil.parseInt(ptid)) {
						isExist = true;
					}
				} else {
					isExist = true;
				}
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", isExist ? "0" : "1");
		printHttpResponse(response, jsonObject);
		return null;

	}
}
