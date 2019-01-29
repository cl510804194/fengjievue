package com.yjf.esupplier.web.controller.front.BaseController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.google.common.collect.Lists;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.common.util.HTMLMaker;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StrProccessUtil;
import com.yjf.esupplier.service.base.data.BaseDataLoader;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.product.enums.DeliverAreaEnum;
import com.yjf.esupplier.ws.product.enums.PostFeeTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.enums.RefundRuleEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.info.DeliveryInfo;
import com.yjf.esupplier.ws.product.info.ProductCustomPropertyInfo;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.order.ProductInfoOrder;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;
import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import com.yjf.esupplier.ws.product.order.SupplierProductSearchOrder;
import com.yjf.esupplier.ws.product.order.UpdateProductStatusOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;

public class ProductManagerBaseController extends FrontAutowiredBaseController {
	public final static String path = "front/platform/member/product/";
	@Autowired
	protected BaseDataLoader baseDataLoader;
	
	public String toCreateProduct(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		/*获取景区商户*/
		model.addAttribute("suppliers", getScenicSuppliers(request));
		SupplierInfo supplierInfo = supplierService.getCurrentSupplier();
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		if(StringUtil.isNotEmpty(request.getParameter("saleType"))){
			if(ProductTypeEnum.HOTELS == ProductTypeEnum.getByCode(request.getParameter("saleType"))){
				model.addAttribute("productTypeName", ProductTypeEnum.HOTELS.message());
			}else{
				model.addAttribute("productTypeName", ProductTypeEnum.PRODUCT.message());
			}
		}else{
			model.addAttribute("productTypeName", ProductTypeEnum.PRODUCT.message());
		}
		model.addAttribute("userType", bizTypeEnum.getCode());
		model.addAttribute("saleType", request.getParameter("saleType"));
		model.addAttribute("supplier", supplierInfo);
		return path + "createProduct.vm";
	}
	
	public String toCreateTicket(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		/*新增景区门票*/
		SupplierInfo supplierInfo = supplierService.getCurrentSupplier();
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		model.addAttribute("userType", bizTypeEnum.getCode());
		model.addAttribute("supplier", supplierInfo);
		return path + "createTicket.vm";
	}
	
	public String toCreateYlLine(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		/*新增景区旅游线路*/
		SupplierInfo supplierInfo = supplierService.getCurrentSupplier();
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		model.addAttribute("userType", bizTypeEnum.getCode());
		model.addAttribute("supplier", supplierInfo);
		return path + "createYlLine.vm";
	}
	
	public String createProduct(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		long productId = BusinessNumberUtil.gainSeqLongNumber();
		ProductInfoOrder product = new ProductInfoOrder();
		WebUtil.setPoPropertyByRequest(product, request, "product");
		/*运费承担*/
		product.setPostType(PostFeeTypeEnum
			.getByDBValue(NumberUtil.parseInt(request.getParameter("product.postType"))));
		ProductVaryEnum productVaryEnum = ProductVaryEnum.getByCode(request.getParameter("product.productVary"));
		product.setProductVary(productVaryEnum);
		product.setProductId(productId);
		if (product.getSupplierId() != 0) {
			product.setSupplierId(product.getSupplierId());
			SupplierInfo supplierInfo = supplierService.getSupplier(product.getSupplierId());
			product.setSupplierName(supplierInfo.getStoreName());
		} else {
			Integer supplierId = supplierService.getSupplierId().intValue();
			product.setSupplierId(supplierId);
			product.setSupplierName(ShiroSessionUtils.getSessionLocal().getRealName());
		}
		product.setIpAddress(IPUtil.getIpAddr(request));
		/*团购 -没有库存*/
		product.setWareCount(999999999);
		/*商品标签*/
		String[] tags = request.getParameterValues("product.ptTag");
		String ptTag = "";
		if (tags != null) {
			for (String tag : tags) {
				if (ptTag.equals("")) {
					ptTag = tag;
				} else {
					ptTag = ptTag + "," + tag;
				}
			}
		}
		product.setPtTag(ptTag);
		/*商品关键字*/
		String[] KeyWords = request.getParameterValues("product.ptKeyWords");
		String ptKeyWords = "";
		if (KeyWords != null) {
			for (String KeyWord : KeyWords) {
				if (ptKeyWords.equals("")) {
					ptKeyWords = KeyWord;
				} else {
					ptKeyWords = ptKeyWords + "," + KeyWord;
				}
			}
		}
		product.setPtKeyWords(ptKeyWords);
		product.setProductStatus(
			ProductStatusEnum.getByCode(request.getParameter("product.productStatus")));
		String[] saleTypes = request.getParameterValues("saleType");
		
		BooleanEnum o2o = BooleanEnum.NO;
		BooleanEnum b2c = BooleanEnum.NO;
		BooleanEnum orderMeal = BooleanEnum.NO;
		BooleanEnum hotel = BooleanEnum.NO;
		String createType = null;
		if (saleTypes != null) {
			for (String saleType : saleTypes) {
				if (saleType.equals("o2o")) {
					o2o = BooleanEnum.YES;
					createType = SaleTypeEnum.O2O.code();
				} else if (saleType.equals("b2c")) {
					b2c = BooleanEnum.YES;
					createType = SaleTypeEnum.B2C.code();
				} else if (saleType.equals("orderMeal")) {
					orderMeal = BooleanEnum.YES;
					createType = SaleTypeEnum.ORDER_MEAL.code();
				} else if (saleType.equals("hotel")) {
					hotel = BooleanEnum.YES;
					createType = SaleTypeEnum.HOTELS.code();
					product.setWareCount(
						NumberUtil.parseLong(request.getParameter("product.wareCount")));
				}
				
			}
		}
		if(productVaryEnum == ProductVaryEnum.ticket){
			product.setFacade(RefundRuleEnum.ANY_TIME);
		}else{
			product.setFacade(RefundRuleEnum.CAN_NOT);
		}
		product.setSaleTypeO2o(o2o);
		product.setSaleTypeB2c(b2c);
		product.setSaleTypeHotels(hotel);
		product.setSaleTypeOrderMeal(orderMeal);
		product.setTuneMeal(BooleanEnum.getByCode(request.getParameter("tuneMeal")));
		/*自定义属性新增（取消）*/
		List<ProductCustomPropertyInfo> listPCP = Lists.newArrayList();
		//		for (int i = 0; i < 99; i++) {
		//			String listPcpName = request.getParameter("listPCP[" + i + "].propertyName");
		//			String listPcpDetail = request.getParameter("listPCP[" + i + "].propertyDetail");
		//			if (listPcpName == null) {
		//				break;
		//			}
		//			ProductCustomPropertyInfo customPropertyInfo = new ProductCustomPropertyInfo();
		//			customPropertyInfo.setPropertyDetail(listPcpDetail);
		//			customPropertyInfo.setPropertyName(listPcpName);
		//			customPropertyInfo.setProductId(productId);
		//			if (StringUtil.isNotBlank(listPcpName) && StringUtil.isNotBlank(listPcpDetail)) {
		//				listPCP.add(customPropertyInfo);
		//			}
		//		}
		/*运费处理：特殊运费*/
		List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();
		for (int i = 1; i <= 5; i++) {
			DeliveryInfo deliveryInfo = new DeliveryInfo();
			String province = request.getParameter("province" + i);
			if (i == 1) {
				province = DeliverAreaEnum.NORMAL.getCode();
			}
			if (StringUtil.isEmpty(province))
				continue;
			double postValue = NumberUtil.parseDouble(request.getParameter("postValue" + i));
			deliveryInfo.setExpress(new Money(postValue));
			deliveryInfo.setPostArea(province);
			deliveryInfo.setProductId(product.getProductId());
			deliveryList.add(deliveryInfo);
		}
		String htmlProName = StrProccessUtil.getRandom(8) + productId; //获取8位随机数+产品Id作为静态页面的名称
		product.setHtmlPath(
			AppConstantsUtil.getImageServerUrl() + "/productStatic/" + htmlProName + ".html");
		
		String originalPicPath = request.getParameter("originalPic");
		String originalPic1Path = request.getParameter("originalPic1");
		String originalPic2Path = request.getParameter("originalPic2");
		String originalPic3Path = request.getParameter("originalPic3");
		
		File originalPic = null;
		File originalPic1 = null;
		File originalPic2 = null;
		File originalPic3 = null;
		if (StringUtil.isNotBlank(originalPicPath)) {
			originalPic = new File(originalPicPath);
		}
		if (StringUtil.isNotBlank(originalPic1Path)) {
			originalPic1 = new File(originalPic1Path);
		}
		if (StringUtil.isNotBlank(originalPic2Path)) {
			originalPic2 = new File(originalPic2Path);
		}
		if (StringUtil.isNotBlank(originalPic3Path)) {
			originalPic3 = new File(originalPic3Path);
		}
		if (StringUtil.isNotBlank(originalPic3Path)) {
			originalPic3 = new File(originalPic3Path);
		}
		
		String picPath = request.getParameter("pic");
		File pic = null;
		if (StringUtil.isNotBlank(picPath)) {
			pic = new File(picPath);
		}
		
		EsupplierBaseResult baseResult = productService.insertProduct(product, listPCP, originalPic,
			originalPic1, originalPic2, originalPic3, deliveryList, pic, getWebRootPath(request));
		if (baseResult.isSuccess()) {
			model.addAttribute("tip", "商品发布成功");
		} else {
			model.addAttribute("tip", "商品发布失败:" + baseResult.getMessage());
		}
		
		HTMLMaker.makeHtml(AppConstantsUtil.getHostHttpUrl()
								+ "/front/mall/product/displayDetailProduct.action?productId="
							+ productId,
			AppConstantsUtil.getYrdUploadFolder()	+ File.separator + "/productStatic" + "/"
											+ htmlProName + ".html");
		model.addAttribute("productVaryEnum",productVaryEnum.getCode());
		model.addAttribute("createType", createType);
		return path + "productOK.vm";
	}
	
	public String toUpdateYlLine(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String id = request.getParameter("productId");
		ProductInfo product = productService.getProductById(NumberUtil.parseLong(id));
		SupplierInfo supplierInfo = supplierService.getSupplier(product.getSupplierId());
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UserBizTypeEnum userBizTypeEnum = sessionLocal.getUserBizType();
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			//权限控制
			if (!validateProductScenic(product, sessionLocal.getBelongTo())) {
				return path + "productInput.vm";
			}
		} else {
			//权限控制
			if (!validateProduct(product, sessionLocal.getUserId())) {
				return path + "productInput.vm";
			}
		}
		model.addAttribute("supplier", supplierInfo);
		model.addAttribute("product", product);
		
		return path + "updateYlLine.vm";
	}
	
	public String toUpdateTicket(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String id = request.getParameter("productId");
		ProductInfo product = productService.getProductById(NumberUtil.parseLong(id));
		SupplierInfo supplierInfo = supplierService.getSupplier(product.getSupplierId());
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UserBizTypeEnum userBizTypeEnum = sessionLocal.getUserBizType();
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			//权限控制
			if (!validateProductScenic(product, sessionLocal.getBelongTo())) {
				return path + "productInput.vm";
			}
		} else {
			//权限控制
			if (!validateProduct(product, sessionLocal.getUserId())) {
				return path + "productInput.vm";
			}
		}
		model.addAttribute("supplier", supplierInfo);
		model.addAttribute("product", product);
		return path + "updateTicket.vm";
	}
	
	public String toUpdateProduct(	HttpServletRequest request, HttpServletResponse response,
									Model model) {
		String id = request.getParameter("productId");
		ProductVaryEnum productVaryEnum = null;
		String productVary = request.getParameter("productVaryEnum");
		String saleType= request.getParameter("saleType");
		if(StringUtil.isNotEmpty(productVary)){
		  productVaryEnum = ProductVaryEnum.getByCode(productVary);
		}
		ProductInfo product = productService.getProductById(NumberUtil.parseLong(id));
		SupplierInfo supplierInfo = supplierService.getSupplier(product.getSupplierId());
		/*选择分类栏目名称*/
		ProductTypeInfo productTypeInfo = baseDataLoader
			.getProductTypeInfoByCode(product.getProductType());
		/*三级分类栏目*/
		String ptNode="";
		if(product.getSaleTypeO2o()==BooleanEnum.YES){
			ptNode="O2O";
		}else if(product.getSaleTypeHotels()==BooleanEnum.YES){
			ptNode="HOTELS";
		}
		model.addAttribute("saleType", ptNode);
		List<ProductTypeInfo> firstType = new ArrayList<ProductTypeInfo>();
		List<ProductTypeInfo> secondType = new ArrayList<ProductTypeInfo>();
		List<ProductTypeInfo> thirdType = new ArrayList<ProductTypeInfo>();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UserBizTypeEnum userBizTypeEnum = sessionLocal.getUserBizType();
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			//权限控制
			if (!validateProductScenic(product, sessionLocal.getBelongTo())) {
				return path + "productInput.vm";
			}
			if (productVaryEnum == ProductVaryEnum.product) {
				ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
				queryOrder.setPtNotes(productTypeInfo.getPtNote());
				firstType = productTypeService.getFirstProductType(queryOrder);
				secondType = productTypeService.getSecondProductType(queryOrder);
				thirdType = productTypeService.getThirdProductType(queryOrder);
			}
		} else {
			//权限控制
			if (!validateProduct(product, sessionLocal.getUserId())) {
				return path + "productInput.vm";
			}
			if (productVaryEnum == ProductVaryEnum.product) {
				ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
				queryOrder.setPtNotes(saleType);				
				firstType = productTypeService.getFirstProductType(supplierInfo);
				secondType = productTypeService.getSecondProductType(queryOrder);
				thirdType = productTypeService.getThirdProductType(queryOrder);
			}
		}
		/*选择的分类*/
		String type3 = product.getProductType();
		String type1 = type3.substring(0, 4);
		String type2 = type3.substring(0, 9);
		
		model.addAttribute("type1", type1);
		model.addAttribute("type2", type2);
		model.addAttribute("type3", type3);
		String pType = null;
		if (productTypeInfo != null) {
			pType = productTypeInfo.getFullTypeName();
			String[] names = pType.split("-");
			model.addAttribute("name1", names[0]);
			model.addAttribute("name2", names[1]);
			model.addAttribute("name3", names[2]);
			
		}
		model.addAttribute("pType", pType);
		model.addAttribute("productTypeInfo", productTypeInfo);
		List<ProductCustomPropertyInfo> listPCP = productCustomPropertyService
			.getProductCustomPropertyList(product.getProductId());
		List<DeliveryInfo> deliveryInfoList = deliveryService.getDelivery(product.getProductId());
		int i = 1;
		for (DeliveryInfo delivery : deliveryInfoList) {
			model.addAttribute("delivery" + i, delivery);
			i++;
		}
		model.addAttribute("firstType", firstType);
		model.addAttribute("secondType", secondType);
		model.addAttribute("secondTypeSize", secondType.size());
		model.addAttribute("thirdType", thirdType);
		model.addAttribute("thirdTypeSize", thirdType.size());
		model.addAttribute("supplier", supplierInfo);
		model.addAttribute("product", product);
		model.addAttribute("listPCP", listPCP);
		
		if (productVaryEnum == ProductVaryEnum.ticket) {
			return path + "updateTicket.vm";
		} else if (productVaryEnum == ProductVaryEnum.line) {
			return path + "updateYlLine.vm";
		}
		return path + "updateProduct.vm";
	}
	
	public String updateProduct(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		ProductInfo oldInfo = productService
			.getProductById(NumberUtil.parseLong(request.getParameter("product.productId")));
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UserBizTypeEnum userBizTypeEnum = sessionLocal.getUserBizType();
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			//权限控制
			if (!validateProductScenic(oldInfo, sessionLocal.getBelongTo())) {
				return path + "productInput.vm";
			}
		} else {
			//权限控制
			if (!validateProduct(oldInfo, sessionLocal.getUserId())) {
				return path + "productInput.vm";
			}
		}
		ProductInfoOrder product = new ProductInfoOrder();
		BeanCopier.staticCopy(oldInfo, product);
		ProductVaryEnum productVaryEnum = ProductVaryEnum.getByCode(request.getParameter("product.productVary"));
		WebUtil.setPoPropertyByRequest(product, request, "product");
		product.setProductStatus(
			ProductStatusEnum.getByCode(request.getParameter("product.productStatus")));
		product.setFacade(RefundRuleEnum.getByCode(request.getParameter("product.facade")));
		product.setPostType(PostFeeTypeEnum
			.getByDBValue(NumberUtil.parseInt(request.getParameter("product.postType"))));
		product.setProductVary(productVaryEnum);
		product.setIpAddress(IPUtil.getIpAddr(request));
		/*商品标签*/
		String[] tags = request.getParameterValues("product.ptTag");
		String ptTag = "";
		if (tags != null) {
			for (String tag : tags) {
				if (ptTag.equals("")) {
					ptTag = tag;
				} else {
					ptTag = ptTag + "," + tag;
				}
			}
		}
		product.setPtTag(ptTag);
		/*商品关键字*/
		String[] KeyWords = request.getParameterValues("product.ptKeyWords");
		String ptKeyWords = "";
		if (KeyWords != null) {
			for (String KeyWord : KeyWords) {
				if (ptKeyWords.equals("")) {
					ptKeyWords = KeyWord;
				} else {
					ptKeyWords = ptKeyWords + "," + KeyWord;
				}
			}
		}
		product.setPtKeyWords(ptKeyWords);
		product.setProductStatus(
			ProductStatusEnum.getByCode(request.getParameter("product.productStatus")));
		String[] saleTypes = request.getParameterValues("saleType");
		
		BooleanEnum o2o = BooleanEnum.NO;
		BooleanEnum b2c = BooleanEnum.NO;
		BooleanEnum orderMeal = BooleanEnum.NO;
		BooleanEnum hotel = BooleanEnum.NO;
		String createType = null;
		if (saleTypes != null) {
			for (String saleType : saleTypes) {
				if (saleType.equals("o2o")) {
					o2o = BooleanEnum.YES;
					createType = SaleTypeEnum.O2O.code();
				} else if (saleType.equals("b2c")) {
					b2c = BooleanEnum.YES;
					createType = SaleTypeEnum.B2C.code();
				} else if (saleType.equals("orderMeal")) {
					orderMeal = BooleanEnum.YES;
					createType = SaleTypeEnum.ORDER_MEAL.code();
				} else if (saleType.equals("hotel")) {
					hotel = BooleanEnum.YES;
					createType = SaleTypeEnum.HOTELS.code();
				}
				
			}
		}
		product.setSaleTypeO2o(o2o);
		product.setSaleTypeB2c(b2c);
		product.setSaleTypeHotels(hotel);
		product.setSaleTypeOrderMeal(orderMeal);
		product.setTuneMeal(BooleanEnum.getByCode(request.getParameter("tuneMeal")));
		List<ProductCustomPropertyInfo> listPCP = Lists.newArrayList();
		String delPic1 = request.getParameter("delPic1");
		if (delPic1 != null && delPic1.equals("del")) {
			product.setBigPicPath(null);
			product.setSmallPicPath(null);
		}
		String delPic2 = request.getParameter("delPic2");
		if (delPic2 != null && delPic2.equals("del")) {
			product.setBigPicPath1(null);
			product.setSmallPicPath1(null);
		}
		String delPic3 = request.getParameter("delPic3");
		if (delPic3 != null && delPic3.equals("del")) {
			product.setBigPicPath2(null);
			product.setSmallPicPath2(null);
		}
		String delPic4 = request.getParameter("delPic4");
		if (delPic4 != null && delPic4.equals("del")) {
			product.setBigPicPath3(null);
			product.setSmallPicPath3(null);
		}
		
		String originalPicPath = request.getParameter("originalPic");
		String originalPic1Path = request.getParameter("originalPic1");
		String originalPic2Path = request.getParameter("originalPic2");
		String originalPic3Path = request.getParameter("originalPic3");
		
		File originalPic = null;
		File originalPic1 = null;
		File originalPic2 = null;
		File originalPic3 = null;
		if (StringUtil.isNotBlank(originalPicPath)) {
			originalPic = new File(originalPicPath);
		}
		if (StringUtil.isNotBlank(originalPic1Path)) {
			originalPic1 = new File(originalPic1Path);
		}
		if (StringUtil.isNotBlank(originalPic2Path)) {
			originalPic2 = new File(originalPic2Path);
		}
		if (StringUtil.isNotBlank(originalPic3Path)) {
			originalPic3 = new File(originalPic3Path);
		}
		if (StringUtil.isNotBlank(originalPic3Path)) {
			originalPic3 = new File(originalPic3Path);
		}
		
		String picPath = request.getParameter("pic");
		File pic = null;
		if (StringUtil.isNotBlank(picPath)) {
			pic = new File(picPath);
		}
		
		/*运费处理：特殊运费*/
		List<DeliveryInfo> deliveryList = new ArrayList<DeliveryInfo>();
		for (int i = 1; i <= 5; i++) {
			DeliveryInfo deliveryInfo = new DeliveryInfo();
			String province = request.getParameter("province" + i);
			if (i == 1) {
				province = DeliverAreaEnum.NORMAL.getCode();
			}
			if (StringUtil.isEmpty(province))
				continue;
			double postValue = NumberUtil.parseDouble(request.getParameter("postValue" + i));
			deliveryInfo.setExpress(new Money(postValue));
			deliveryInfo.setPostArea(province);
			deliveryInfo.setProductId(product.getProductId());
			deliveryList.add(deliveryInfo);
		}
		
		String htmlProName = StrProccessUtil.getRandom(8) + product.getProductId(); //获取8位随机数+产品Id作为静态页面的名称
		//判断页面是否已经生成
		if (product.getHtmlPath() == null) {
			product.setHtmlPath("/product/" + htmlProName + ".html");
		} else {
			htmlProName = product.getHtmlPath().substring(9, product.getHtmlPath().indexOf("."));
		}
		
		productService.updateProduct(product, listPCP, originalPic, originalPic1, originalPic2,
			originalPic3, deliveryList, pic, getWebRootPath(request));
		
		HTMLMaker.makeHtml(AppConstantsUtil.getHostHttpUrl()
								+ "/front/mall/product/displayDetailProduct.htm?productId="
							+ product.getProductId(),
			AppConstantsUtil.getYrdUploadFolder()		+ File.separator + "/productStatic" + "/"
														+ htmlProName + ".html");
		
		model.addAttribute("tip", "商品修改成功");
		model.addAttribute("productVaryEnum",productVaryEnum.getCode());
		model.addAttribute("createType", createType);
		return path + "productOK.vm";
	}
	
	//product权限控制
	protected boolean validateProduct(ProductInfo product, long supplierId) {
		long id = product.getSupplierId();
		if (id == supplierId) {
			return true;
		}
		return false;
	}
	
	protected boolean validateProductScenic(ProductInfo product, long resortsBusinessId) {
		long id = product.getResortsBusinessId();
		if (id == resortsBusinessId) {
			return true;
		}
		return false;
	}
	
	public String checkProductNumber(	HttpServletRequest request, HttpServletResponse response,
										Model model) {
		String supplierId = request.getParameter("supplierId");
		String productNumber = request.getParameter("productNumber");
		String productId = request.getParameter("productId");
		boolean back = productService.checkExistProductNumber(NumberUtil.parseLong(supplierId),
			productNumber, productId);
		if (back) {
			printHttpResponse(response, "yes");
		} else {
			printHttpResponse(response, "no");
		}
		return null;
	}
	
	public String toOtherList(	HttpServletRequest request, HttpServletResponse response, Model model,
								ProductVaryEnum productVaryEnum) {
		String productStatus = request.getParameter("productStatus");
		String sName = request.getParameter("searchName");
		String sNumber = request.getParameter("searchNumber");
		UserBizTypeEnum userBizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		int intPage = 1;
		int intPageSize = 10;
		if (StringUtil.isNotBlank(page)) {
			intPage = NumberUtil.parseInt(page);
		}
		if (StringUtil.isNotBlank(pageSize)) {
			intPageSize = NumberUtil.parseInt(pageSize);
		}
		if (StringUtil.isBlank(productStatus)) {
			if (request.getAttribute("productStatus") != null) {
				productStatus = String.valueOf(request.getAttribute("productStatus"));
			}
			if (StringUtil.isBlank(productStatus)) {
				productStatus = "ON";
			}
		}
		
		String searchType = request.getParameter("searchType");
		
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage(intPage);
		pageTool.setPageSize(intPageSize);
		QueryBaseBatchResult<ProductInfo> listP = new QueryBaseBatchResult<ProductInfo>();
		SupplierProductSearchOrder searchOrder = new SupplierProductSearchOrder();
		/*商品扩展属性*/
		searchOrder.setProductVaryEnum(productVaryEnum);
		if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
			|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
			searchOrder.setResortsBusinessId(ShiroSessionUtils.getSessionLocal().getBelongTo());
		} else {
			searchOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		final SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		searchOrder.setResortsBusinessId(sessionLocal.getBelongToUserInfo().getUserId());
		searchOrder.setProductNumber(sNumber);
		searchOrder.setProductStatus(ProductStatusEnum.getByCode(productStatus));
		searchOrder.setProductName(sName);
		searchOrder.setProductType(searchType);
		searchOrder.setPageSize(pageTool.getPageSize());
		searchOrder.setPageNumber(pageTool.getCurrentPage());
		/*关联的是景区，没有供应商，不添加供应商条件*/
		searchOrder.setApproveState("");
		searchOrder.setMerchantState("");
		listP = productService.getSupplierAndProductList(searchOrder);
		
		for (ProductInfo p : listP.getPageList()) {
			ProductTypeInfo typeInfo = baseDataLoader.getProductTypeInfoByCode(p.getProductType());
			if (typeInfo != null) {
				String pType = typeInfo.getPtTypeName();
				p.setProductType(pType);
			}
		}
		pageTool.setCurrentPage((int) listP.getPageNumber());
		pageTool.setPageSize((int) listP.getPageSize());
		pageTool.setTotalRow(listP.getTotalCount());
		String pageBar = pageTool.getPageBar();
		model.addAttribute("searchName", sName);
		model.addAttribute("searchNumber", sNumber);
		model.addAttribute("productStatus", productStatus);
		model.addAttribute("searchType", searchType);
		model.addAttribute("listP", listP.getPageList());
		model.addAttribute("pageBar", pageBar);
		if (productVaryEnum == ProductVaryEnum.ticket) {
			return path + "ticketList.vm";
		} else if (productVaryEnum == ProductVaryEnum.line) {
			return path + "ylLineList.vm";
		} else {
			return path + "ticketList.vm";
		}
	}
	
	public String toProductList(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		String supplierName = request.getParameter("supplierName");
		String sName = request.getParameter("searchName");
		String sNumber = request.getParameter("searchNumber");
		String censor = request.getParameter("censor");
		String productStatus = request.getParameter("productStatus");
		String recommendType = request.getParameter("recommendType");
		String saleType = request.getParameter("saleType");
		UserBizTypeEnum userBizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		int intPage = 1;
		int intPageSize = 10;
		if (StringUtil.isNotBlank(page)) {
			intPage = NumberUtil.parseInt(page);
		}
		if (StringUtil.isNotBlank(pageSize)) {
			intPageSize = NumberUtil.parseInt(pageSize);
		}
		if (StringUtil.isBlank(productStatus)) {
			if (request.getAttribute("productStatus") != null) {
				productStatus = String.valueOf(request.getAttribute("productStatus"));
			}
			if (StringUtil.isBlank(productStatus)) {
				productStatus = "ON";
			}
		}
		
		String searchType = request.getParameter("searchType");
		
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage(intPage);
		pageTool.setPageSize(intPageSize);
		QueryBaseBatchResult<ProductInfo> listP = new QueryBaseBatchResult<ProductInfo>();
		/*推荐商品列表*/
		if (productStatus.equalsIgnoreCase("COT") || productStatus.equalsIgnoreCase("COP")) {
			ProductRecommendOrder recommendOrder = new ProductRecommendOrder();
			if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
				|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
				recommendOrder
					.setResortsBusinessId(ShiroSessionUtils.getSessionLocal().getBelongTo());
			} else {
				recommendOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
			}
			if (StringUtil.isNotEmpty(supplierName)) {
				recommendOrder.setSupplierName(supplierName);
			}
			final SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			recommendOrder.setResortsBusinessId(sessionLocal.getBelongToUserInfo().getUserId());
			recommendOrder.setProductNumber(sNumber);
			recommendOrder.setProductStatus(ProductStatusEnum.ON);
			recommendOrder.setProductName(sName);
			recommendOrder.setProductType(searchType);
			recommendOrder.setPageSize(pageTool.getPageSize());
			recommendOrder.setPageNumber(pageTool.getCurrentPage());
			recommendOrder.setOrderNormal("NORMAL");
			recommendOrder.setRecommendType(ProductRecommendTypeEnum.getByCode(recommendType));
			listP = productRecommendService.getProductRecommendList(recommendOrder);
			for (ProductInfo p : listP.getPageList()) {
				ProductTypeInfo typeInfo = baseDataLoader
					.getProductTypeInfoByCode(p.getProductType());
				if (typeInfo != null) {
					String pType = typeInfo.getPtTypeName();
					p.setProductType(pType);
				}
			}
		} else { /*正常列表*/
			
			SupplierProductSearchOrder searchOrder = new SupplierProductSearchOrder();
			if (userBizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR
				|| userBizTypeEnum == UserBizTypeEnum.VISITOR_CENTER) {
				searchOrder.setResortsBusinessId(ShiroSessionUtils.getSessionLocal().getBelongTo());
			} else {
				searchOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
			}
			if (StringUtil.isNotEmpty(supplierName)) {
				searchOrder.setSupplierName(supplierName);
			}
			if(StringUtil.isNotEmpty(saleType)){
				if(saleType.equals(SaleTypeEnum.O2O.getCode())){
					searchOrder.setSaleTypeO2O(BooleanEnum.YES);
					model.addAttribute("productTypeName", ProductTypeEnum.PRODUCT.message());
				}else if(saleType.equals(SaleTypeEnum.HOTELS.getCode())){
					searchOrder.setSaleTypeHotels(BooleanEnum.YES);
					model.addAttribute("productTypeName", ProductTypeEnum.HOTELS.message());
				}else{
					searchOrder.setSaleTypeO2O(BooleanEnum.YES);
					model.addAttribute("productTypeName", ProductTypeEnum.PRODUCT.message());
				}
			}
			final SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			searchOrder.setResortsBusinessId(sessionLocal.getBelongToUserInfo().getUserId());
			searchOrder.setProductNumber(sNumber);
			searchOrder.setProductStatus(ProductStatusEnum.getByCode(productStatus));
			searchOrder.setProductName(sName);
			searchOrder.setProductType(searchType);
			searchOrder.setPageSize(pageTool.getPageSize());
			searchOrder.setPageNumber(pageTool.getCurrentPage());
			listP = productService.getSupplierAndProductList(searchOrder);
			//			listP = productService.getProductSearchList(supplierId, supplierName,
			//					productStatus, sName, sNumber, pageTool.getCurrentPage(), pageTool.getPageSize(),
			//					searchType);
			for (ProductInfo p : listP.getPageList()) {
				ProductTypeInfo typeInfo = baseDataLoader
					.getProductTypeInfoByCode(p.getProductType());
				if (typeInfo != null) {
					String pType = typeInfo.getPtTypeName();
					p.setProductType(pType);
				}
			}
		}
		
		pageTool.setCurrentPage((int) listP.getPageNumber());
		pageTool.setPageSize((int) listP.getPageSize());
		pageTool.setTotalRow(listP.getTotalCount());
		String pageBar = pageTool.getPageBar();
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		queryOrder.setPtNotes(saleType);
		List<ProductTypeInfo> thridType = productTypeService.getThirdProductType(queryOrder);
		model.addAttribute("supplierName", supplierName);
		model.addAttribute("searchName", sName);
		model.addAttribute("searchNumber", sNumber);
		model.addAttribute("censor", censor);
		model.addAttribute("productStatus", productStatus);
		model.addAttribute("recommendType", recommendType);
		model.addAttribute("searchType", searchType);
		model.addAttribute("thridType", thridType);
		model.addAttribute("listP", listP.getPageList());
		model.addAttribute("pageBar", pageBar);
		model.addAttribute("saleType", saleType);
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		model.addAttribute("userType", bizTypeEnum.getCode());
		return path + "productList.vm";
	}
	
	public String setProductOff(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		String productIdString = request.getParameter("productIds");
		if (StringUtil.isNotBlank(productIdString)) {
			UpdateProductStatusOrder productStatusOrder = makeUpdateSatutsOrder(productIdString);
			
			productService.updateProductStatusOff(productStatusOrder);
			
		}
		//返回ON页
		request.setAttribute("productStatus", ProductStatusEnum.ON.code());
		ProductVaryEnum productVaryEnum = (ProductVaryEnum) request.getAttribute("productVaryEnum");
		if (productVaryEnum != ProductVaryEnum.product) {
			return toOtherList(request, response, model, productVaryEnum);
		}
		return toProductList(request, response, model);
	}
	
	public String setProductOn(	HttpServletRequest request, HttpServletResponse response,
								Model model) {
		String productIdString = request.getParameter("productIds");
		if (StringUtil.isNotBlank(productIdString)) {
			UpdateProductStatusOrder productStatusOrder = makeUpdateSatutsOrder(productIdString);
			productService.updateProductStatusOn(productStatusOrder);
		}
		//返回OFF页
		request.setAttribute("productStatus", ProductStatusEnum.OFF.code());
		ProductVaryEnum productVaryEnum = (ProductVaryEnum) request.getAttribute("productVaryEnum");
		if (productVaryEnum != ProductVaryEnum.product) {
			return toOtherList(request, response, model, productVaryEnum);
		}
		return toProductList(request, response, model);
	}
	
	protected UpdateProductStatusOrder makeUpdateSatutsOrder(String productIdString) {
		List<Long> productIdList = Lists.newArrayList();
		String[] productIds = productIdString.split(",");
		for (String productId : productIds) {
			if (StringUtil.isNotBlank(productId)) {
				productIdList.add(NumberUtil.parseLong(productId));
			}
		}
		long[] productIdArray = new long[productIdList.size()];
		for (int i = 0; i < productIdList.size(); i++) {
			productIdArray[i] = productIdList.get(i);
		}
		UpdateProductStatusOrder productStatusOrder = new UpdateProductStatusOrder();
		//		productStatusOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		productStatusOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		productStatusOrder.setProductId(productIdArray);
		return productStatusOrder;
	}
	
	public String updateProductStatusDel(	HttpServletRequest request, HttpServletResponse response,
											Model model) {
		String productIdString = request.getParameter("productIds");
		if (StringUtil.isNotBlank(productIdString)) {
			UpdateProductStatusOrder productStatusOrder = makeUpdateSatutsOrder(productIdString);
			productService.updateProductStatusDel(productStatusOrder);
		}
		//返回OFF页
		request.setAttribute("productStatus", ProductStatusEnum.OFF.code());
		ProductVaryEnum productVaryEnum = (ProductVaryEnum) request.getAttribute("productVaryEnum");
		if (productVaryEnum != ProductVaryEnum.product) {
			return toOtherList(request, response, model, productVaryEnum);
		}
		return toProductList(request, response, model);
	}
	
	/*
	* 获取景区所有在线商户
	* */
	public List<SupplierInfo> getScenicSuppliers(HttpServletRequest request) {
		String saleType = request.getParameter("saleType");
		UserRoleQueryOrder userRoleQueryOrder = new UserRoleQueryOrder();
		if (StringUtil.isNotEmpty(saleType)) {
			if (saleType.indexOf(SaleTypeEnum.O2O.getCode()) >= 0
				|| saleType.indexOf(SaleTypeEnum.B2C.getCode()) >= 0)
				userRoleQueryOrder.setO2o(BooleanEnum.YES);
			else if (saleType.indexOf(SaleTypeEnum.ORDER_MEAL.getCode()) >= 0)
				userRoleQueryOrder.setOrderMeal(BooleanEnum.YES);
			else if (saleType.indexOf(SaleTypeEnum.HOTELS.getCode()) >= 0)
				userRoleQueryOrder.setHotels(BooleanEnum.YES);
			
		}
		userRoleQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
		userRoleQueryOrder.setMerchantStateEnum(MerchantStateEnum.IN);
		UserInfo userInfo = ShiroSessionUtils.getSessionLocal().getUserInfo();
		if (userInfo.getUserBizType() == UserBizTypeEnum.VISITOR_CENTER
			|| userInfo.getUserBizType() == UserBizTypeEnum.VISITOR_OPERATOR) {
			userRoleQueryOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		} else {
			userRoleQueryOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		}
		userRoleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		userRoleQueryOrder.setPageNumber(-1);
		QueryBaseBatchResult<SupplierInfo> userInfos = userQueryService
			.queryRoleSupplierUserInfo(userRoleQueryOrder);
		List<SupplierInfo> suppliers = userInfos.getPageList();
		return suppliers;
	}
}
