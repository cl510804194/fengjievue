package com.yjf.esupplier.web.controller.front.platform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.service.pop.IPopModuleService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.service.pop.impl.ComparatorPop;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebConstant;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.enums.PropertyTypeEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.order.ProductPropertyQueryOrder;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductPropertyInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;
import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import com.yjf.esupplier.ws.product.order.SupplierProductSearchOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SupplierHotelQueryOrder;

@Controller
@RequestMapping("/front")
public class ElectronicMallController extends FrontAutowiredBaseController {
	static String path = "front/platform/mall/";
	static String hotelPath = "front/hotel/";
	final static String vm_path = "/front/platform/login/";
	@Autowired
	IPopModuleService popModuleService;
	@Autowired
	IPopService popService;
	@Autowired
	ProductService productService;

	@RequestMapping("platform/mall/mallIndex.htm")
	public String mallIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		makeMainPage(request, response, model);
		//bannerNews END

		return path + "mallIndex.vm";
	}

	@RequestMapping("platform/mall/redirctIndex.htm")
	public String redirctIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
		//		makeMainPage(request, response, model);
		//bannerNews END
		String preUrl = (String) request.getSession().getAttribute(
				WebConstant.SESSION_KEY_PRE_PAGE_URL);
		if (ShiroSessionUtils.getSessionLocal() == null && preUrl != null
				&& preUrl.startsWith("/admin/")) {
			sendUrl(response, "/admin/login.htm");
			return null;
		} else {
			return vm_path + "login.vm";
		}
	}

	@SuppressWarnings("unchecked")
	private void makeMainPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		String preUrl = (String) request.getSession().getAttribute(
				WebConstant.SESSION_KEY_PRE_PAGE_URL);
		if (ShiroSessionUtils.getSessionLocal() == null && preUrl != null
				&& preUrl.startsWith("/admin/")) {
			sendUrl(response, "/admin/login.htm");
		}
		String ptypeUrl = "/front/mall/product/searchProduct-1.htm";

		model.addAttribute("ptypeUrl", ptypeUrl);

		/******* banner 查询 *********/
		ProductTypeQueryOrder order = new ProductTypeQueryOrder();
		order.setPtCode("0001");
		order.setPageSize(100);
		order.setPageNumber(1);
		QueryBaseBatchResult<ProductTypeInfo> batchResult = productTypeService
				.findByCondition(order);
		model.addAttribute("bannerList", batchResult.getPageList());
		ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
		List<ProductTypeInfo> secondProductTypes = productTypeService.getSecondProductType(queryOrder);
		List<ProductTypeInfo> thirdProductTypes = productTypeService.getThirdProductType(queryOrder);
		model.addAttribute("secondProductTypes", secondProductTypes);
		model.addAttribute("thirdProductTypes", thirdProductTypes);
		//		PopModuleVOInfo moduleInfo = popModuleService.getPopModule("index");
		//		model.addAttribute("moduleInfo", moduleInfo);
		//		Map<String, Object> conditions = new HashMap<String, Object>();
		//		conditions.put("type", moduleInfo.getModuleId());
		//		conditions.put("status", 2);//上线的
		//		PageParam pageParam = new PageParam();
		//		Page<PopInfo> page = popService.getPageByConditionsNew(pageParam, conditions);
		//		List<PopInfo> list = page.getResult();
		//		PopInfo popInfo = new PopInfo();
		//		if (list.size() > 0) {
		//			popInfo = list.get(0);
		//		}
		//		model.addAttribute("popInfo", popInfo);

		//关键词查询

		List<String> secondKeyWords = productTypeService.getSecondKeyWords();
		model.addAttribute("secondKeyWords", secondKeyWords);
		//精选商铺
		UserRoleQueryOrder commonQueryOrder = new UserRoleQueryOrder();
		commonQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
		commonQueryOrder.setMerchantStateEnum(MerchantStateEnum.IN);
		//		commonQueryOrder.setMerchantTypeEnum(MerchantTypeEnum.getByCode(request
		//			.getParameter("merchantType")));
		//		String scenicId = request.getParameter("scenicId");
		//		/*所属景区*/
		//		if (StringUtil.isNotEmpty(scenicId)) {
		//			UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(scenicId);
		//			if (userQueryResult.getQueryUserInfo() != null) {
		//				commonQueryOrder.setBelongTo(userQueryResult.getQueryUserInfo().getUserId());
		//			}
		//		}
		commonQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		commonQueryOrder.setPageSize(8);
		QueryBaseBatchResult<SupplierInfo> result = userQueryService
				.queryRoleSupplierUserInfo(commonQueryOrder);
		model.addAttribute("supplierInfos", result.getPageList());
		//分类商品拉取数量
		int totalNo = 8;
		SupplierProductSearchOrder productSearchOrder = new SupplierProductSearchOrder();
		productSearchOrder.setPageSize(totalNo);
		productSearchOrder.setProductStatus(ProductStatusEnum.ON);
		//吃一顿
		productSearchOrder.setProductType("0001-0001");
		productSearchOrder.setSaleTypeO2O(BooleanEnum.YES);
		List<ProductInfo> chiList = productService.getSupplierAndProductList(productSearchOrder)
				.getPageList();
		model.addAttribute("chiProduct", chiList);
		//住民宿
		SupplierHotelQueryOrder hotelQueryOrder = new SupplierHotelQueryOrder();
		hotelQueryOrder.setHotels(BooleanEnum.YES);
		hotelQueryOrder.setPageSize(8);
		result = supplierService.searchHotelSupplier(hotelQueryOrder);
		model.addAttribute("hotelSuppliers", result.getPageList());
		//嗨起来
		productSearchOrder.setProductType("0001-0003");
		List<ProductInfo> haiList = productService.getSupplierAndProductList(productSearchOrder)
				.getPageList();
		model.addAttribute("haiProduct", haiList);
		//买点啥
		productSearchOrder.setProductType("0001-0004");
		List<ProductInfo> maiList = productService.getSupplierAndProductList(productSearchOrder)
				.getPageList();
		model.addAttribute("maiProduct", maiList);
		//旅游攻略
		PageParam lypageParam = new PageParam();
		lypageParam.setPageNo(1);
		lypageParam.setPageSize(8);
		QueryBaseBatchResult<PopInfo> baseResult = popService.getGlListByConditionsNew(lypageParam,
				null, null, null, null, null);
		model.addAttribute("lygls", baseResult.getPageList());
		//bannerNews 首页banner图。
		Map<String, Object> conditionNews = new HashMap<String, Object>();
		PageParam bannerPageParam = new PageParam(1, 15);
		List<Integer> typesNews = new ArrayList<Integer>();
		typesNews.add(100);
		conditionNews.put("type", typesNews);
		conditionNews.put("status", 2);
		Page<PopInfo> bannerNewsPage = popService.getPageByConditions(bannerPageParam,
				conditionNews);
		List<PopInfo> bannerNews = bannerNewsPage.getResult();
		if (ListUtil.isNotEmpty(bannerNews)) {
			Collections.sort(bannerNews, new ComparatorPop());
		}
		model.addAttribute("bannerNews", bannerNews);
		PageParam pageParam = new PageParam();
		pageParam.setPageSize(50);
		pageParam.setPageNo(1);
		QueryBaseBatchResult<PopInfo> scienceResult = popService
				.getBannerListByConditionsNewPC(pageParam);
		model.addAttribute("scienceBannerList", scienceResult.getPageList());
		List<Integer> typesNews2 = new ArrayList<Integer>();
		typesNews2.add(103);
		conditionNews.put("type", typesNews2);
		Page<PopInfo> bannerNewsPage2 = popService.getPageByConditions(bannerPageParam,
				conditionNews);
		List<PopInfo> bannerNews2 = bannerNewsPage2.getResult();
		if (ListUtil.isNotEmpty(bannerNews2)) {
			Collections.sort(bannerNews2, new ComparatorPop());
		}
		model.addAttribute("bannerNews2", bannerNews2);

		List<Integer> typesNews3 = new ArrayList<Integer>();
		typesNews3.add(104);
		conditionNews.put("type", typesNews3);
		bannerPageParam = new PageParam(1, 20);
		Page<PopInfo> bannerNewsPage3 = popService.getPageByConditions(bannerPageParam,
				conditionNews);
		List<PopInfo> bannerNews3 = bannerNewsPage3.getResult();
		if (ListUtil.isNotEmpty(bannerNews3)) {
			Collections.sort(bannerNews3, new ComparatorPop());
		}
		model.addAttribute("bannerNews3", bannerNews3);

		ProductRecommendOrder recommendOrder = new ProductRecommendOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		String recommendType = StringUtil.defaultIfEmpty(request.getParameter("recommendType"),
				ProductRecommendTypeEnum.PRODUCT_TOP.getCode());
		recommendOrder.setRecommendType(ProductRecommendTypeEnum.getByCode(recommendType));
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null && sessionLocal.getUserId() != null) {
			recommendOrder.setUserId(sessionLocal.getUserId());
		}
		recommendOrder.setOrderNormal("NORMAL");
		recommendOrder.setPageSize(4);
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productRecommendService
				.getSupplierAndProductRecommendList(recommendOrder);
		model.addAttribute("recommendList", baseBatchResult.getPageList());

		PageParam pageParamGl = new PageParam();
		QueryBaseBatchResult<PopInfo> baseResultGl = popService.getGlListByConditionsNew(
				pageParamGl, "", "", "", "", "");
		model.addAttribute("strategyList", baseResultGl.getPageList());
	}

	private List<ProductInfo> getProductInfoByType(ProductRecommendOrder recommendorder) {
		QueryBaseBatchResult<ProductInfo> chiProduct = productRecommendService
				.getSupplierAndProductRecommendList(recommendorder);
		List<ProductInfo> chiList = chiProduct.getPageList();
		if (chiProduct.getTotalCount() < recommendorder.getPageSize()) {
			if (chiList == null) {
				chiList = new ArrayList<ProductInfo>();
			}
			QueryBaseBatchResult<ProductInfo> chiProductDefault = productService
					.getProductListByType(recommendorder.getProductType(), 0,
							(int) (recommendorder.getPageSize() - chiProduct.getTotalCount()),
							recommendorder.getSaleType());
			if (chiProductDefault.getPageList() != null) {
				chiList.addAll(chiProductDefault.getPageList());
			}

		}
		return chiList;
	}

	/**
	 * 商品列表搜索
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("platform/mall/mallList.htm")
	public String mallList(HttpServletRequest request, HttpServletResponse response, Model model) {
		//request请求参数
		int pageno = NumberUtil.parseInt(request.getParameter("page"), 1); //页码
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 20); //页显示量
		String productType = request.getParameter("productType"); //商品类型
		String productStyle = request.getParameter("productStyle"); //商品款式 传propertyName值
		String productTheme = request.getParameter("productTheme"); //商品题材 传propertyName值
		//		long beginPrice = NumberUtil.parseLong(request.getParameter("beginPrice")); //最低价格
		//		long endPrice = NumberUtil.parseLong(request.getParameter("endPrice"));//最高价格
		String beginPrice = request.getParameter("beginPrice");
		String endPrice = request.getParameter("endPrice");
		String saleCountSort = request.getParameter("saleCountSort");//销量排序 正序传asc 倒序desc
		String priceSort = request.getParameter("priceSort");//价格排序 正序传asc 倒序desc	
		String ptTag = request.getParameter("ptTag");
		String saleType = request.getParameter("saleType");
		model.addAllAttributes(WebUtil.getRequestMap(request));
		//查询条件
		SupplierProductSearchOrder productSearchOrder = new SupplierProductSearchOrder();
		productSearchOrder.setPageNumber(pageno);
		productSearchOrder.setPageSize(pagesize);
		productSearchOrder.setPtKeyWords(ptTag);
		if (StringUtil.isBlank(productType) && StringUtil.isBlank(saleType)) {
			productType = "0001";
			saleType = "O2O";
		}
		if (StringUtil.isNotBlank(saleType)) {
			if (SaleTypeEnum.getByCode(saleType) == SaleTypeEnum.B2C) {
				productSearchOrder.setSaleTypeB2c(BooleanEnum.YES);
			} else if (SaleTypeEnum.getByCode(saleType) == SaleTypeEnum.O2O) {
				//	productSearchOrder.setSaleTypeB2c(BooleanEnum.NO);
				productSearchOrder.setSaleTypeO2O(BooleanEnum.YES);
			}
		} else {
			//	productSearchOrder.setSaleTypeB2c(BooleanEnum.NO);
			productSearchOrder.setSaleTypeO2O(BooleanEnum.YES);
		}
		if (StringUtil.isNotBlank(productType)) {
			productSearchOrder.setProductType(productType);
		}
		if (request.getParameter("beginPrice") != null) {
			if (!("").equals(request.getParameter("beginPrice"))) {
				productSearchOrder.setBeginPrice(new Money(beginPrice));
			}
		}
		if (request.getParameter("endPrice") != null) {
			if (!("").equals(request.getParameter("endPrice"))) {
				productSearchOrder.setEndPrice(new Money(endPrice));
			}
		}
		if (StringUtil.isNotBlank(productStyle)) {
			productSearchOrder.setProductStyle(productStyle);
		}
		if (StringUtil.isNotBlank(productTheme)) {
			productSearchOrder.setProductTheme(productTheme);
		}
		productSearchOrder.setPriceSort(priceSort);
		productSearchOrder.setSaleCountSort(saleCountSort);
		productSearchOrder.setProductStatus(ProductStatusEnum.ON);
		//商品查询结果
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
				.getSupplierAndProductList(productSearchOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) baseBatchResult.getPageNumber());
		pageTool.setPageSize((int) baseBatchResult.getPageSize());
		pageTool.setTotalRow(baseBatchResult.getTotalCount());
		String pageBar = pageTool.getPageBar();
		model.addAttribute("pageBar", pageBar);
		List<ProductInfo> productList = baseBatchResult.getPageList();
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(productList, pageTool));

		//商品相关推荐
		ProductRecommendOrder order = new ProductRecommendOrder();
		order.setLimitStart(0);
		order.setPageSize(9);
		order.setProductStatus(ProductStatusEnum.ON);
		order.setRecommendType(ProductRecommendTypeEnum.PRODUCT_TOP);
		List<ProductInfo> recommendProductList = productRecommendService.getProductRecommendList(
				order).getPageList();
		model.addAttribute("recommendProductList", recommendProductList);

		//查询属性值
		ProductPropertyQueryOrder styleOrder = new ProductPropertyQueryOrder();
		styleOrder.setPropertyType(PropertyTypeEnum.STYLE.code());
		List<ProductPropertyInfo> styleList = productPropertyService
				.getProductPropertyListByType(styleOrder);
		ProductPropertyQueryOrder themeOrder = new ProductPropertyQueryOrder();
		themeOrder.setPropertyType(PropertyTypeEnum.THEME.code());
		List<ProductPropertyInfo> themeList = productPropertyService
				.getProductPropertyListByType(themeOrder);
		model.addAttribute("styleList", styleList);
		model.addAttribute("themeList", themeList);

		//产品类型
		ProductTypeInfo productTypeInfo = baseDataLoader.getProductTypeInfoByCode(productType);
		model.addAttribute("productTypeInfo", productTypeInfo);
		String ptKeyWords = "";
		if (StringUtil.isNotBlank(productType)) {
			String[] productTypes = productType.split("-");
			int i = 0;
			String type = "";
			for (String item : productTypes) {
				if (type.length() == 0) {
					type = item;
				} else {
					type = type + "-" + item;
				}
				ProductTypeInfo productTypeInfoRoot = baseDataLoader.getProductTypeInfoByCode(type);
				model.addAttribute("productTypeInfo" + i, productTypeInfoRoot);
				i++;
			}
			ptKeyWords = productTypeInfo.getPtKeyWords();
		}
		if (StringUtil.isNotBlank(productType)) {
			ProductTypeInfo typeInfo = productTypeService.findByPtCode(productType);
			String ptTags = typeInfo.getPtTag();
			if (StringUtil.isNotBlank(ptTags)) {
				String[] tags = ptTags.split("-");
				List tagList = new ArrayList();
				for (String tag : tags) {
					tagList.add(tag);
				}
				model.addAttribute("ptTags", tagList);
			}
		} else {
			model.addAttribute("ptTags", "");
		}
		QueryBaseBatchResult<SupplierInfo> result = new QueryBaseBatchResult<SupplierInfo>();
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		scenicQueryOrder.setStatus(UserStateEnum.NORMAL);
		scenicQueryOrder.setPageSize(99);
		List<ScenicInfo> scenicInfoList = scenicService.getScenicInfo(scenicQueryOrder)
				.getPageList();
		model.addAttribute("scenicInfoList", scenicInfoList);
		model.addAttribute("roomTypes", HotelTypeEnum.getAllEnum());
		SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
		queryOrder.setRecommend(BooleanEnum.YES);
		queryOrder.setHotels(BooleanEnum.YES);
		queryOrder.setPageSize(8);
		result = supplierService.searchHotelSupplier(queryOrder);
		model.addAttribute("supplierList", result.getPageList());
		model.addAttribute("beginDate", DateUtil.simpleFormatYmd(new Date()));
		model.addAttribute("endDate", DateUtil.simpleFormatYmd(DateUtil.getAfterDay(new Date())));
		if (StringUtil.equals(productType, "0001-0002")) {
			return hotelPath + "hotelSearch.vm";
		} else {
			return path + "mallList.vm";
		}
	}

	@ResponseBody
	@RequestMapping("platform/mall/getProductType.json")
	public Object getProductType() {
		JSONObject json = new JSONObject();
		try {
			//			String ptCode = request.getParameter("ptCode");
			//			ProductTypeQueryOrder productTypeQueryOrder = new ProductTypeQueryOrder();
			//			productTypeQueryOrder.setPtCode(ptCode);
			//			productTypeQueryOrder.setPageSize(99999);
			//			productTypeQueryOrder.setPageNumber(1);
			//			QueryBaseBatchResult<ProductTypeInfo> productTypeInfoList = productTypeService.findByCondition(productTypeQueryOrder);
			//			QueryBaseBatchResult<ProductTypeInfo> productTypeConverResult = new QueryBaseBatchResult<ProductTypeInfo>();
			//			List <ProductTypeInfo> productTypeConverList = new ArrayList<ProductTypeInfo>();
			//			if(productTypeInfoList != null ){
			//				productTypeConverResult = joinProductType(productTypeInfoList);
			//				productTypeConverList = productTypeConverResult.getPageList();
			//			}
			List<ProductTypeInfo> productTypeConverList = productTypeService
					.getProductTypeByFront();
			json.put("code", 1);
			json.put("message", "执行成功！");
			json.put("data", productTypeConverList);
		} catch (Exception e) {
			json.put("code", 0);
			json.put("message", "执行失败！");
		}
		return json;
	}

	@ResponseBody
	@RequestMapping("platform/mall/recommend.json")
	public Object recommend(HttpServletRequest request, HttpServletResponse response, Model model) {
		JSONObject json = new JSONObject();
		try {
			ProductRecommendOrder recommendOrder = new ProductRecommendOrder();
			String recommendType = StringUtil.defaultIfEmpty(request.getParameter("recommendType"),
					ProductRecommendTypeEnum.PRODUCT_TOP.getCode());
			recommendOrder.setRecommendType(ProductRecommendTypeEnum.getByCode(recommendType));
			recommendOrder.setPageSize(4);
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			if (sessionLocal != null) {
				recommendOrder.setUserId(sessionLocal.getUserId());
			}
			//recommendOrder.setOrderNormal("NORMAL");
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productRecommendService
					.getSupplierAndProductRecommendList(recommendOrder);
			json.put("code", 1);
			json.put("data", baseBatchResult.getPageList());
		} catch (Exception e) {
			json.put("code", 0);
			json.put("message", "执行失败！");
		}
		return json;
	}

}
