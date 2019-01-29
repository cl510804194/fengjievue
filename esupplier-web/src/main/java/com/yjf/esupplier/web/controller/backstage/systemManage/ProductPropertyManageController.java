/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.systemManage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.service.product.ProductTypeService;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductPropertyInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.util.EnumUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.PropertyTypeEnum;
import com.yjf.esupplier.ws.order.ProductPropertyAddOrder;
import com.yjf.esupplier.ws.order.ProductPropertyQueryOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * @Filename ProductPropertyManageController.java
 * @Description
 * @Version 1.0
 * @Author min
 * @Email oyangnuo@yiji.com
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-3-1上午10:53:38</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/admin/product/property")
public class ProductPropertyManageController extends BaseAutowiredController {

    private final String vm_path = "/backstage/systemManage/propertyManage/";
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    protected ProductService productService;
    /**
     * 商品属性列表
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toAllProductPropertyList.htm")
    public String toAllProductPropertyList(HttpServletRequest request, HttpServletResponse response,
                                           Model model) {

        model.addAllAttributes(WebUtil.getRequestMap(request));
        int pageNo = NumberUtil.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);

        ProductPropertyQueryOrder order = new ProductPropertyQueryOrder();
        order.setPageNumber(pageNo);
        order.setPageSize(pageSize);

        QueryBaseBatchResult<ProductPropertyInfo> baseBatchResult = productPropertyService.getProductPropertyList(order);
        PageTool pageTool = new PageTool();
        pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
        pageTool.setPageSize((int) baseBatchResult.getPageSize());
        pageTool.setTotalRow(baseBatchResult.getTotalCount());
        List<ProductPropertyInfo> listP = baseBatchResult.getPageList();
        for(ProductPropertyInfo propertyInfo:listP){
            String productType = propertyInfo.getProductType();
            ProductTypeInfo productTypeInfo = productTypeService.findByPtCode(productType);
            if(productTypeInfo!=null){
                propertyInfo.setProductTypeName(productTypeInfo.getPtTypeName());
            }
        }
        model.addAttribute("pageBar", pageTool.getPageBar());
        model.addAttribute("page", PageUtil.getCovertPageByPageTools(listP, pageTool));

        return vm_path + "allProductPropertyList.vm";
    }

    /**
     * 添加商品属性页面
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toAddProductProperty.htm")
    public String toAddProductProperty(HttpServletRequest request, HttpServletResponse response,
                                       Model model) {

        @SuppressWarnings("unchecked")
        List<PropertyTypeEnum> enumList = EnumUtil.getEnumList(PropertyTypeEnum.class);
        model.addAttribute("enumList", enumList);
//        List<ProductTypeInfo> typeInfoList = productTypeService.getProductTypeAll();
//        model.addAttribute("typeInfoList", typeInfoList.toString());
        return vm_path + "toAddProductProperty.vm";
    }

    /**
     * 添加商品属性
     *
     * @param order
     * @param request
     * @param response
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("addProductProperty.json")
    public Object addProductProperty(ProductPropertyAddOrder order, HttpServletRequest request, HttpServletResponse response,
                                     Model model) {

        JSONObject jsonobj = new JSONObject();
        logger.info("添加商品属性入参：{}", order);
        ProductPropertyInfo propertyInfo = productPropertyService.findProductPropertyByCode(order.getPropertyCode());
        if(propertyInfo!=null){
            jsonobj.put("code", 0);
            jsonobj.put("message", "新增失败，已存在相同的商品属性编码！");
            return jsonobj;
        }
        ProductPropertyInfo propertyInfoName = productPropertyService.findProductPropertyByName(order.getPropertyName());
        if(propertyInfoName!=null){
            jsonobj.put("code", 0);
            jsonobj.put("message", "新增失败，已存在相同的商品属性名称！");
            return jsonobj;
        }
        EsupplierBaseResult result = productPropertyService.addProductProperty(order);
        if (result.isSuccess()) {
            jsonobj.put("code", 1);
            jsonobj.put("message", "添加成功！");
        } else {
            jsonobj.put("code", 0);
            jsonobj.put("message", "添加失败！");
        }
        return jsonobj;
    }

    /**
     * 修改商品属性
     *
     * @param request
     * @param response
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("updateProductProperty.json")
    public Object updateProductProperty(ProductPropertyAddOrder order, HttpServletRequest request, HttpServletResponse response,
                                        Model model) {

        JSONObject jsonobj = new JSONObject();
        ProductPropertyInfo productPropertyInfo = new ProductPropertyInfo();
        productPropertyInfo.setPropertyId(NumberUtil.parseLong(request.getParameter("propertyId")));
        productPropertyInfo.setPropertyCode(request.getParameter("propertyCode"));
        productPropertyInfo.setPropertyName(request.getParameter("propertyName"));
        productPropertyInfo.setPropertyType(PropertyTypeEnum.getByCode(request.getParameter("propertyType")));
        productPropertyInfo.setProductType(request.getParameter("productType"));
        ProductPropertyInfo propertyInfo = productPropertyService.findProductPropertyByCode(productPropertyInfo.getPropertyCode());
        if(propertyInfo!=null&&productPropertyInfo.getPropertyId()!=propertyInfo.getPropertyId()){
            jsonobj.put("code", 0);
            jsonobj.put("message", "修改失败，已存在相同的商品属性编码！");
            return jsonobj;
        }        ProductPropertyInfo propertyInfoName = productPropertyService.findProductPropertyByName(productPropertyInfo.getPropertyName());
        if(propertyInfo!=null&&productPropertyInfo.getProductTypeName()!=propertyInfoName.getProductTypeName()){
            jsonobj.put("code", 0);
            jsonobj.put("message", "修改失败，已存在相同的商品属性名称！");
            return jsonobj;
        }
        EsupplierBaseResult result = productPropertyService.updateProductProperty(productPropertyInfo);
        if (result.isSuccess()) {
            jsonobj.put("code", 1);
            jsonobj.put("message", "修改成功！");
        } else {
            jsonobj.put("code", 0);
            jsonobj.put("message", "删除失败！");
        }
        return jsonobj;
    }

    /**
     * 修改商品属性页面
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("toUpdateProductProperty.htm")
    public String toUpdateProductProperty(long propertyId, HttpServletRequest request, HttpServletResponse response,
                                          Model model) {

        List<PropertyTypeEnum> enumList = EnumUtil.getEnumList(PropertyTypeEnum.class);
        model.addAttribute("enumList", enumList);
        ProductPropertyInfo productPropertyInfo = productPropertyService.findProductPropertyById(propertyId);
        model.addAttribute("property", productPropertyInfo);
        ProductTypeInfo typeInfo = productTypeService.getProductTypeByCode(productPropertyInfo.getProductType());
        model.addAttribute("typeInfo", typeInfo);
        return vm_path + "toUpdateProductProperty.vm";
    }


    /**
     * 删除商品属性
     *
     * @param propertyId
     * @param request
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("delProductProperty.json")
    public Object delProductProperty(long propertyId, HttpServletRequest request, HttpServletResponse response,
                                     Model model) {
        JSONObject jsonobj = new JSONObject();
        logger.info("删除商品属性入参：{}", propertyId);
        ProductPropertyInfo productPropertyInfo = productPropertyService.findProductPropertyById(propertyId);
        ProductSearchOrder productSearchOrder = new ProductSearchOrder();
        productSearchOrder.setProductStyle(productPropertyInfo.getPropertyName());
        QueryBaseBatchResult<ProductInfo> productList = productService.getProductList(productSearchOrder);
        if(productList.getTotalCount()>0){
            jsonobj.put("code", 0);
            jsonobj.put("message", "商品属性已被使用，删除失败！");
            return jsonobj;
        }
        EsupplierBaseResult result = productPropertyService.delProductProperty(propertyId);

        if (result.isSuccess()) {
            jsonobj.put("code", 1);
            jsonobj.put("message", "删除成功！");
        } else {
            jsonobj.put("code", 0);
            jsonobj.put("message", "删除失败！");
        }
        return jsonobj;

    }

}
