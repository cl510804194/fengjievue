package com.yjf.esupplier.web.controller.front.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.product.enums.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.dal.custom.dataobject.HotelsStockIbatisDO;
import com.yjf.esupplier.dal.dataobject.TblProductDO;
import com.yjf.esupplier.dal.dataobject.TblSupplierDO;
import com.yjf.esupplier.service.base.data.BankDataService;
import com.yjf.esupplier.service.bill.DrawerAddressService;
import com.yjf.esupplier.service.bill.OrderQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.service.hotel.HotelsStockService;
import com.yjf.esupplier.service.pay.PayService;
import com.yjf.esupplier.service.user.UserAccountDataQueryService;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.info.ProductScoreInfo;
import com.yjf.esupplier.ws.bill.order.SearchProductScoreOrder;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.MerchantTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.order.HotelStockProductOrder;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;
import com.yjf.esupplier.ws.product.order.ProductUserOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SupplierHotelQueryOrder;

@Controller
@RequestMapping("/front")
public class HotelController extends FrontAutowiredBaseController {
	
	static String path = "front/hotel/";
	@Autowired
	BankDataService bankDataService;
	@Autowired
	PayService payService;
	@Autowired
	GiftMoneyTradeQueryService giftMoneyTradeQueryService;
	@Autowired
	DrawerAddressService drawerAddressService;
	@Autowired
	UserAccountDataQueryService userAccountDataQueryService;
	@Autowired
	OrderQueryService orderQueryService;
	@Autowired
	HotelsStockService hotelsStockService;
	
	/**
	 * 查询酒店 2016-10-21
	 * 
	 * @throws Exception
	 * @throws Exception
	 * @author lihu
	 * @return5
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("platform/hotel/supplierHotelList.htm")
	public String supplierHotelList(HttpServletRequest request, HttpServletResponse response,
									Model model) throws Exception {
		int pageno = NumberUtil.parseInt(request.getParameter("page"), 1); //页码
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 20); //页显示量
		String merchantName = request.getParameter("merchantName");
		String merchantState = request.getParameter("merchantState");
		String merchantType = request.getParameter("merchantType");
		String roomType = StringUtil.defaultIfEmpty(request.getParameter("roomType"), "");
		String recommend = StringUtil.defaultIfEmpty(request.getParameter("recommend"), "YES");
		String scenicId = request.getParameter("scenicId");
		String productType = request.getParameter("productType"); //商品类型
		String beginPrice = request.getParameter("beginPrice");
		String endPrice = request.getParameter("endPrice");
		String saleCountSort = request.getParameter("saleCountSort");//销量排序 正序传asc 倒序desc
		String lowestPriceSort = request.getParameter("lowestPriceSort");//价格排序 正序传asc 倒序desc
		if(StringUtil.isEmpty(productType)){
			productType = "0001-0002";
		}
		model.addAllAttributes(WebUtil.getRequestMap(request));
		long belongTo = 0;
		/*所属景区*/
		if (StringUtil.isNotEmpty(scenicId)) {
			UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(scenicId);
			if (userQueryResult.getQueryUserInfo() != null) {
				belongTo = userQueryResult.getQueryUserInfo().getUserId();
			}
		}
		QueryBaseBatchResult<SupplierInfo> result = new QueryBaseBatchResult<SupplierInfo>();
		/*酒店列表查询*/
		SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
		if (StringUtil.isNotEmpty(scenicId)) {
			queryOrder.setScenicId(scenicId);
		}
		if (roomType.equals(HotelTypeEnum.MORNING.getCode())) {
			queryOrder.setMorningRoom(BooleanEnum.YES);
		}
		if (roomType.equals(HotelTypeEnum.SPECIAL.getCode())) {
			queryOrder.setSpecialRoom(BooleanEnum.YES);
		}
		if (roomType.equals(HotelTypeEnum.LONGRENT.getCode())) {
			queryOrder.setLongRentRoom(BooleanEnum.YES);
		}
		if (recommend.equals(BooleanEnum.YES.getCode())) {
			queryOrder.setRecommend(BooleanEnum.YES);
		}
		if(StringUtil.isNotEmpty(beginPrice)){
			queryOrder.setBeginPrice(new Money(beginPrice));
		}
		if(StringUtil.isNotEmpty(endPrice)){
			queryOrder.setEndPrice(new Money(endPrice));
		}
		queryOrder.setLowestPriceSort(lowestPriceSort);
		queryOrder.setAmountSort(saleCountSort);
		if(StringUtil.isNotBlank(productType)){
			ProductTypeInfo typeInfo = productTypeService.findByPtCode(productType);
			String ptTags = typeInfo.getPtTag();
			if (StringUtil.isNotBlank(ptTags)) {
				String []tags = ptTags.split("-");
				List tagList = new ArrayList();
				for(String tag : tags){
					tagList.add(tag);
				}
				model.addAttribute("ptTags", tagList);
			}
		}else{	
			model.addAttribute("ptTags", "");
		}
		
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
		}
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setSearchName(merchantName);
		queryOrder.setMerchantTypeEnum(MerchantTypeEnum.getByCode(merchantType));
		queryOrder.setMerchantStateEnum(MerchantStateEnum.getByCode(merchantState));
		queryOrder.setPageNumber(pageno);
		queryOrder.setPageSize(pagesize);
		result = supplierService.searchHotelSupplier(queryOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) result.getPageNumber());
		pageTool.setPageSize((int) result.getPageSize());
		pageTool.setTotalRow(result.getTotalCount());
		List<SupplierInfo> supplierInfoList = result.getPageList();
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(supplierInfoList, pageTool));
		model.addAttribute("supplierList", result.getPageList());
		model.addAttribute("beginDate", request.getParameter("beginDate"));
		model.addAttribute("endDate", request.getParameter("endDate"));
		return path + "supplierHotelList.vm";
	}
	
	@RequestMapping("platform/hotel/displayDetailHotel.htm")
	public String displayDetailHotel(HttpServletRequest request, HttpServletResponse response,
											Model model) {
		ProductSearchOrder productSearchOrder = new ProductSearchOrder();
		String productType = request.getParameter("productType");

		String supplierId = request.getParameter("supplierId");
		SupplierInfo hotelInfo = userQueryService
			.querySupplierInfoDetail(NumberUtil.parseLong(supplierId, 0), productSearchOrder);
		model.addAllAttributes(WebUtil.getRequestMap(request));
		SearchProductScoreOrder searchOrder = new SearchProductScoreOrder();
		searchOrder.setObjectId(NumberUtil.parseLong(supplierId, -1));
		searchOrder.setBeginScore(1);
		searchOrder.setEndScore(5);
		Boolean collectStatus = productUserService.checkCollecteStatus(null, supplierId);
		//商品评价
		List<ProductScoreInfo> commentList = orderService.queryProductScoreList(searchOrder)
			.getPageList();
		model.addAttribute("commentList", commentList);
		model.addAttribute("hotelInfo", hotelInfo);
		model.addAttribute("collectStatus", collectStatus);
		if (hotelInfo == null)
			return "error.vm";
		if (hotelInfo.getHotels() == BooleanEnum.YES) {
			HotelStockProductOrder productOrder = new HotelStockProductOrder();
			productOrder.setStatus(HotelStockStatusEnum.ON);
			productOrder.setProductStatus(ProductStatusEnum.ON);
			productOrder.setSupplierId(NumberUtil.parseLong(supplierId, 0));
			WebUtil.setPoPropertyByRequest(productOrder, request);
			String beginDate = request.getParameter("beginDate");
			if(StringUtil.isEmpty(beginDate)){
				beginDate = DateUtil.simpleFormatYmd(new Date());
			}
			String endDate = request.getParameter("endDate");
			if(StringUtil.isEmpty(endDate)){
				endDate = DateUtil.simpleFormatYmd(DateUtil.getAfterDay(new Date()));
			}
			productOrder.setBeginDate(DateUtil.parse(beginDate));
			productOrder.setEndDate(DateUtil.parse(endDate));
			QueryBaseBatchResult<HotelsStockIbatisDO> hotelsResult = hotelsStockService
				.searchHotelLeftList(productOrder);
			if (!hotelsResult.isSuccess()) {
				return "error.vm";
			}
			List <ProductInfo> productInfoList = new ArrayList<ProductInfo>();
			for (HotelsStockIbatisDO infos : hotelsResult.getPageList()) {
				ProductInfo productInfo = new ProductInfo();
				TblSupplierDO tblSupplierDO = infos.getTblSupplierDO();
				productInfoCovertDO(productInfo, infos.getTblProductDO());
				productInfo.setExecPrice(infos.getExecPrice());
				productInfo.setPayedCount(infos.getPayedCount());
				productInfoList.add(productInfo);
			}
			model.addAttribute("productInfoList", productInfoList);
			model.addAttribute("beginDate", beginDate);
			model.addAttribute("endDate", endDate);
		}
		
		return path + "hotelInfo.vm";
	}
	
	/**
	 * 收藏商户
	 * @param order
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("collectHotel.json")
	public Object collectHotel(ProductUserOrder order,HttpServletRequest request, HttpServletResponse response,
								 Model model){
		JSONObject jsonobj = new JSONObject();
		long supplierId = NumberUtil.parseLong(request.getParameter("supplierId"),0);
		if (supplierId > 0) {
			order.setSupplierId(supplierId);
			logger.info("商品收藏入参：{}", order);
			EsupplierBaseResult result = productUserService.insertProductUser(order);
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "酒店收藏成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "你已收藏过该酒店");
			}
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请登录收藏");
		}

		return jsonobj;
	}
	protected void productInfoCovertDO(ProductInfo por, TblProductDO porSrc) {
		BeanCopier.staticCopy(porSrc, por);
		por.setProductVary(ProductVaryEnum.getByCode(porSrc.getProductVary()));
		por.setPostType(PostFeeTypeEnum.getByCode(porSrc.getPostType()));
		por.setFacade(RefundRuleEnum.getByCode(porSrc.getFacade()));
		por.setProductStatus(ProductStatusEnum.getByCode(porSrc.getProductStatus()));
		por.setSaleTypeB2c(BooleanEnum.getByCode(porSrc.getSaleTypeB2c()));
		por.setSaleTypeO2o(BooleanEnum.getByCode(porSrc.getSaleTypeO2o()));
		por.setSaleTypeHotels(BooleanEnum.getByCode(porSrc.getSaleTypeHotels()));
		por.setSaleTypeOrderMeal(BooleanEnum.getByCode(porSrc.getSaleTypeOrderMeal()));
		por.setTuneMeal(BooleanEnum.getByCode(porSrc.getTuneMeal()));
		por.setRecommend(BooleanEnum.getByCode(porSrc.getRecommend()));
		por.setMorningRoom(BooleanEnum.getByCode(porSrc.getMorningRoom()));
		por.setLongRentRoom(BooleanEnum.getByCode(porSrc.getLongRentRoom()));
		por.setSpecialRoom(BooleanEnum.getByCode(porSrc.getSpecialRoom()));
		por.setCustomType1(BooleanEnum.getByCode(porSrc.getCustomType1()));
		por.setCustomType2(BooleanEnum.getByCode(porSrc.getCustomType2()));
		por.setSupplierId(porSrc.getSupplierId());
	}
}
