package com.yjf.esupplier.web.controller.front.product;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.product.ProductTypeService;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageCreator;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.product.info.ProductBeanInfo;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;
import com.yjf.esupplier.ws.product.order.SupplierProductSearchOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/front/platform/mall/")
public class SearchProductController extends FrontAutowiredBaseController {

    @Autowired
    ProductTypeService productTypeService;

    final static String path = "front/product/";

    @RequestMapping("product/searchProduct-1.htm")
    public String searchProduct(HttpServletRequest request, HttpServletResponse response,
                                Model model, String template, String areaCode, String type,
                                String facade, String oldfacade, String startPrice,
                                String endPrice, String quantityBegin, String postTime,
                                String searchkey, String pageSize, String priceOrder, String flag, String thePage) {
        makeList(request, model, template, areaCode, type, facade, oldfacade, startPrice, endPrice,
                quantityBegin, postTime, searchkey, pageSize, priceOrder, flag, thePage);
        return path + "product_pic_list.vm";
    }

    private void makeList(HttpServletRequest request, Model model, String template,
                          String areaCode, String type, String facade, String oldfacade,
                          String startPrice, String endPrice, String quantityBegin,
                          String postTime, String searchkey, String pageSize, String priceOrder,
                          String flag, String thePage) {
        try {
            Map<String, String> requestMap = WebUtil.getRequestMap(request);
            model.addAllAttributes(requestMap);
            String url = "/front/mall/product/searchProduct-1.htm";
            String userPara = "";
            if (template != null && template.trim().length() > 0)
                userPara += "template=" + template + "&";
            if (areaCode != null && areaCode.trim().length() > 0)
                userPara += "areaCode=" + areaCode + "&";
            if (userPara.length() > 0)
                userPara = userPara.substring(0, userPara.length() - 1);

            if (type != null && type.equals("")) {
                type = null;
            }
            //+++立面历史信息
            if (oldfacade == null)
                oldfacade = "";
            else {
                oldfacade = URLDecoder.decode(oldfacade, "UTF-8");
                oldfacade = URLDecoder.decode(oldfacade, "UTF-8");
            }

            if (facade == null)
                facade = "";
            else {
                facade = URLDecoder.decode(facade, "UTF-8");
                facade = URLDecoder.decode(facade, "UTF-8");
            }

            String[] temp = facade.split("::");

            //如果立面类型包含同一种类，就返回原查询立面
            if (temp.length > 1 && oldfacade.indexOf(temp[0] + "::") == -1)
                facade = oldfacade + facade;

            oldfacade = new String(facade);

            //~~~~~
            //+++ add by hooxin
            if (facade != null) {
                facade = URLDecoder.decode(facade, "UTF-8");
                facade = URLDecoder.decode(facade, "UTF-8");
            }
            //facade 数组
            String facadeA[] = null;
            if (facade != null && facade.equals("") != true) {
                facadeA = new String[facade.split("##").length];
                for (int i = 0; i < facade.split("##").length; i++)
                    facadeA[i] = facade.split("##")[i] + "##";
            }

//            ProductSearchOrder productSearchOrder = new ProductSearchOrder();
//            productSearchOrder.setProductType(type);
//            if (StringUtil.isNotBlank(startPrice)) {
//                productSearchOrder.setBeginPrice(new Money(startPrice));
//            }
//            if (StringUtil.isNotBlank(endPrice)) {
//                productSearchOrder.setEndPrice(new Money(endPrice));
//            }
//            productSearchOrder.setProductName(searchkey);
//            productSearchOrder.setProductStatus(ProductStatusEnum.ON);
//            String pageBox = request.getParameter("pageBox");
//            int page = 1;
//            if (thePage != null) {
//                page = Integer.parseInt(thePage);
//            }
//            if (pageBox != null && !pageBox.trim().equals("")) {
//                page = Integer.parseInt(pageBox);
//            }
//            productSearchOrder.setPageNumber(page);
//            productSearchOrder.setPageSize(NumberUtil.parseLong(pageSize, 20));
//            QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
//                    .getProductList(productSearchOrder);
            SupplierProductSearchOrder order = new SupplierProductSearchOrder();
    		WebUtil.setPoPropertyByRequest(order, request);
    		order.setProductStatus(ProductStatusEnum.ON);
    		order.setProductName(searchkey);
    		if (StringUtil.isNotBlank(startPrice)) {
    			order.setBeginPrice(Money.amout(startPrice));
    		}
    		if (StringUtil.isNotBlank(endPrice)) {
    			order.setEndPrice(Money.amout(endPrice));
    		}
    		String saleType = request.getParameter("saleType");
    		if(StringUtil.isBlank(saleType)){
    			order.setSaleTypeO2O(BooleanEnum.YES);
    		}
    		if(SaleTypeEnum.B2C == SaleTypeEnum.getByCode(saleType)){
    			order.setSaleTypeB2c(BooleanEnum.YES);
    		}
    		if(SaleTypeEnum.O2O == SaleTypeEnum.getByCode(saleType)){
    			order.setSaleTypeO2O(BooleanEnum.YES);
    		}
//    		order.setSaleTypeB2c(BooleanEnum.YES);
//    		order.setSaleTypeO2O(BooleanEnum.YES);
            String pageBox = request.getParameter("pageBox");
            int page = 1;
            if (thePage != null) {
               page = Integer.parseInt(thePage);
            }
            if (pageBox != null && !pageBox.trim().equals("")) {
                page = Integer.parseInt(pageBox);
            }
            order.setPageNumber(page);
            order.setPageSize(NumberUtil.parseLong(pageSize, 40));
    		QueryBaseBatchResult<ProductInfo> baseBatchResult =  productService.getSupplierAndProductList(order);
            PageCreator pc = new PageCreator();
            pc.setPageSize((int) baseBatchResult.getPageSize());

            pc.setCurrentPage(page);
            pc.setTotalRow((int) baseBatchResult.getTotalCount());
            String pageBar0 = pc.getPageBar();

            //pageBar=pc.getPageBar();
            int startCount = (page - 1) * pc.getPageSize();
            int endCount = page * pc.getPageSize();
            Assert.isTrue(page <= pc.getTotalPage(), "无效分页参数");
            //+++添加立面查询支持 by hooxin
            List<ProductBeanInfo> list = Lists.newArrayList();
            for (ProductInfo productInfo : baseBatchResult.getPageList()) {
                ProductBeanInfo beanInfo = new ProductBeanInfo();
                beanInfo.setSupId(String.valueOf(productInfo.getSupplierId()));
                beanInfo.setGroupBuyDetail(productInfo.getGroupBuyDetail());
                beanInfo.setProvince(productInfo.getProvince());
                beanInfo.setCity(productInfo.getCity());
                beanInfo.setSupName(productInfo.getSupplierName());
                beanInfo.setProduct(productInfo);
                beanInfo.setMarketPrice(productInfo.getMarketPrice());
                beanInfo.setProductUnit(productInfo.getProductUnit());
                list.add(beanInfo);
            }
            if (list == null) {
                flag = "N";
            }

            model.addAttribute("list", list);
            model.addAttribute("flag", flag);
            
            String addUrla = "";
            if (template != null && template.trim().length() > 0)
                addUrla = "&template=" + template;
            model.addAttribute("addUrla", addUrla);
            model.addAttribute("pageBar0", pageBar0);
            model.addAttribute("selectors", "noselectors");
        } catch (Exception e) {
            logger.error("search product error:" + e.toString(), e);
        }
    }

    @RequestMapping("product/searchProduct-2.htm")
    public String searchProduct2(HttpServletRequest request, HttpServletResponse response,
                                 Model model, String template, String areaCode, String type,
                                 String facade, String oldfacade, String startPrice,
                                 String endPrice, String quantityBegin, String postTime,
                                 String searchkey, String pageSize, String priceOrder,
                                 String flag, String thePage) {
        makeList(request, model, template, areaCode, type, facade, oldfacade, startPrice, endPrice,
                quantityBegin, postTime, searchkey, pageSize, priceOrder, flag, thePage);
        return path + "product_word_list.vm";
    }
}