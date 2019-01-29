package com.yjf.esupplier.web.controller.front.platform;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.ip.IPUtil;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.HToken;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.dal.custom.dataobject.HotelsStockIbatisDO;
import com.yjf.esupplier.service.hotel.result.HotelLongCheckInfoResult;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.util.PageCreator;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.info.ProductScoreInfo;
import com.yjf.esupplier.ws.bill.order.ProductScoreStatisticsRsult;
import com.yjf.esupplier.ws.bill.order.SearchProductScoreOrder;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelDiscountInfo;
import com.yjf.esupplier.ws.hotel.info.HotelSetRefundInfo;
import com.yjf.esupplier.ws.hotel.info.HotelStockInfo;
import com.yjf.esupplier.ws.hotel.order.HotelOrderNumOrder;
import com.yjf.esupplier.ws.order.HotelSetRefundQueryOrder;
import com.yjf.esupplier.ws.order.HotelStockOrder;
import com.yjf.esupplier.ws.order.HotelStockProductOrder;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.info.DeliveryInfo;
import com.yjf.esupplier.ws.product.info.ProductCustomPropertyInfo;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.storage.info.ProductStorageInfo;

@Controller
@RequestMapping("/front")
public class FrontProductController extends FrontAutowiredBaseController {
	final static String vmPath = "front/product/";
	final static String hotelPath = " front/hotel/";
	
	@RequestMapping("platform/mall/product/displayDetailProduct.htm")
	public String displayDetailProductInfo(HttpServletRequest request,
											HttpServletResponse response, Model model,
											String productId) {
		ProductInfo product = productService.findSupplierProductById(NumberUtil
			.parseLong(productId));
		if (product == null)
			return "error.vm";
		model.addAllAttributes(WebUtil.getRequestMap(request));
		long lngProductId = new Long(productId);
		List<DeliveryInfo> deliveryInfoList = deliveryService.getDelivery(product.getProductId());
		int i = 1;
		for (DeliveryInfo delivery : deliveryInfoList) {
			long deliveryId = BusinessNumberUtil.gainSeqLongNumber();
			delivery = new DeliveryInfo();
			delivery.setDeliveryId(deliveryId);
			model.addAttribute("delivery" + i, delivery);
			i++;
		}
		//+++ 添加图片前缀 by hooxin
		
		//+++添加商品点击率 by hooxin
		HToken ht = HToken.getHToken(
			"pdtInfo_" + product.getProductId() + "_" + IPUtil.getIpAddr(request), 4000, request);
		String saleType = request.getParameter("saleType");
		BooleanEnum saleTypeB2c = product.getSaleTypeB2c();
		BooleanEnum saleTypeO2o = product.getSaleTypeO2o();
		BooleanEnum saleTypeHotels = product.getSaleTypeHotels();
		//		if(SaleTypeEnum.getByCode(payType) == SaleTypeEnum.B2C){
		//			if(saleTypeB2c == BooleanEnum.YES){
		//				model.addAttribute("payTypeShow", payType);
		//			}
		//			if(saleTypeO2o == BooleanEnum.YES){
		//				model.addAttribute("payTypeNext", SaleTypeEnum.O2O.code());
		//			}
		//		}else if(SaleTypeEnum.getByCode(payType) == SaleTypeEnum.O2O){	
		//			if(saleTypeO2o == BooleanEnum.YES){
		//				model.addAttribute("payTypeShow", payType);
		//			}
		//			if(saleTypeB2c == BooleanEnum.YES){
		//				model.addAttribute("payTypeNext", SaleTypeEnum.B2C.code());
		//			}
		//		}else{
		if (saleTypeHotels == BooleanEnum.YES) {
			model.addAttribute("payTypeShow", SaleTypeEnum.HOTELS.code());
		} else {
			if (SaleTypeEnum.getByCode(saleType) == SaleTypeEnum.B2C) {
				if (saleTypeB2c == BooleanEnum.YES) {
					model.addAttribute("payTypeShow", saleType);
				}
				if (saleTypeO2o == BooleanEnum.YES) {
					model.addAttribute("payTypeNext", SaleTypeEnum.O2O.code());
				}
			} else {
				if (saleTypeO2o == BooleanEnum.YES) {
					model.addAttribute("payTypeShow", SaleTypeEnum.O2O.code());
					if (saleTypeB2c == BooleanEnum.YES) {
						model.addAttribute("payTypeNext", SaleTypeEnum.B2C.code());
					}
				} else if (saleTypeB2c == BooleanEnum.YES) {
					model.addAttribute("payTypeShow", SaleTypeEnum.B2C.code());
					if (saleTypeO2o == BooleanEnum.YES) {
						model.addAttribute("payTypeNext", SaleTypeEnum.O2O.code());
					}
				}
			}
		}
		
		//		}
		//相关产品
		ProductRecommendOrder productRecommendOrder = new ProductRecommendOrder();
		productRecommendOrder.setProductStatus(ProductStatusEnum.ON);
		productRecommendOrder.setProductType(product.getProductType());
		productRecommendOrder.setProductId(product.getProductId());
		productRecommendOrder.setPageNumber(1);
		productRecommendOrder.setPageSize(4);
		productRecommendOrder.setRecommendType(ProductRecommendTypeEnum.PRODUCT_TOP);
		List<ProductInfo> otherTypeProduct = productRecommendService.getProductRecommendList(
			productRecommendOrder).getPageList();
		
		//显示供应商评价
		UserInfo supplier = userQueryService.queryByUserId(product.getSupplierId())
			.getQueryUserInfo();
		//			licenseList = LicenseService.getLicenseById(product.getSupplierId());
		
		//前台节省金额显示
		if (product.getMarketPrice() != null) {
			String saveMoney = product.getMarketPrice().subtract(product.getPrice1())
				.toStandardString();
			model.addAttribute("saveMoney", saveMoney);
		}
		List<ProductCustomPropertyInfo> listProperty = productCustomPropertyService
			.getProductCustomPropertyList((int) lngProductId);
		
		SearchProductScoreOrder searchOrder = new SearchProductScoreOrder();
		searchOrder.setObjectId(lngProductId);
		searchOrder.setBeginScore(1);
		searchOrder.setEndScore(5);
		//商品评价
		List<ProductScoreInfo> commentList = orderService.queryProductScoreList(searchOrder)
			.getPageList();
		//		for (ProductScoreInfo productScoreInfo : commentList) {
		//			UserQueryResult userQueryResult = userQueryService
		//				.queryByUserId(productScoreInfo.getMemberId());
		//			if (userQueryResult != null && userQueryResult.getQueryUserInfo() != null) {
		//				String userName = userQueryResult.getQueryUserInfo().getUserName();
		//				if(StringUtil.isNotEmpty(userName)){
		//					if(userName.length()<=5&&userName.length()>2){
		//						userName = userName.replaceFirst(userName.substring(2,userName.length()),"***");
		//					}else if(userName.length()>5){
		//						userName = userName.replaceFirst(userName.substring(2,5),"***");
		//					}else{
		//						userName = userName.replaceFirst(userName.substring(1,userName.length()),"*");
		//					}
		//				}
		//				productScoreInfo.setUserName(userName);
		//			}
		//		}
		ProductScoreStatisticsRsult scoreStatisticsRsult = orderService
			.statisticsProductScoreList(searchOrder);
		
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null && sessionLocal.getUserId() != null) {
			UserQueryResult result = userQueryService.queryByUserId(sessionLocal.getUserId());
			model.addAttribute("member", result.getQueryUserInfo());
		}
		ProductTypeInfo productTypeInfo = baseDataLoader.getProductTypeInfoByCode(product
			.getProductType());
		//		ProductPropertyInfo propertyInfo = productPropertyService
		//			.findProductPropertyByName(product.getProductStyle());
		ProductStorageInfo storageInfo = storageService.getStorageInfo(product.getProductId());
		
		model.addAttribute("productTypeInfo", productTypeInfo);
		if (storageInfo != null) {
			storageInfo.setStockAmount(storageInfo.getStockAmount() - storageInfo.getPayedCount());
			model.addAttribute("storageInfo", storageInfo);
			model.addAttribute("payedCount", storageInfo.getSaleingAllCount());
		}
		if (product.getSaleTypeHotels() == BooleanEnum.YES) {
			String beginDate = request.getParameter("beginDate");
			if (StringUtil.isEmpty(beginDate)) {
				beginDate = DateUtil.simpleFormatYmd(new Date());
			}
			String endDate = request.getParameter("endDate");
			if (StringUtil.isEmpty(endDate)) {
				endDate = DateUtil.simpleFormatYmd(DateUtil.getAfterDay(new Date()));
			}
			int dateLen = 0;
			try {
				dateLen = DateUtil.calculateDecreaseDate(beginDate, endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HotelStockProductOrder productOrder = new HotelStockProductOrder();
			productOrder.setStatus(HotelStockStatusEnum.ON);
			productOrder.setProductStatus(ProductStatusEnum.ON);
			productOrder.setProductId(NumberUtil.parseLong(productId, 0));
			productOrder.setBeginDate(DateUtil.parse(beginDate));
			productOrder.setEndDate(DateUtil.parse(endDate));
			QueryBaseBatchResult<HotelsStockIbatisDO> hotelsResult = hotelsStockService
				.searchHotelLeftList(productOrder);
			if (!hotelsResult.isSuccess()) {
				return hotelPath + "error.vm";
			}
			UserQueryResult userQueryResult = userQueryService.queryByUserId(product
				.getResortsBusinessId());
			if (!userQueryResult.isSuccess()) {
				return hotelPath + "error.vm";
			}
			if (userQueryResult.getQueryUserInfo() == null) {
				return hotelPath + "error.vm";
			}
			ScenicQueryResult scenicQueryResult = scenicService.queryByUserBaseId(userQueryResult
				.getQueryUserInfo().getUserBaseId());
			if (!scenicQueryResult.isSuccess()) {
				return hotelPath + "error.vm";
			}
			if (scenicQueryResult.getQueryScenicInfo() == null) {
				return hotelPath + "error.vm";
			}
			HotelSetRefundQueryOrder hotelSetRefundQueryOrder = new HotelSetRefundQueryOrder();
			QueryBaseBatchResult<HotelSetRefundInfo> hotelSetResult = hotelsSetRefundService
				.searchSetHotelRefundList(hotelSetRefundQueryOrder);
			List<String> refundMessageList = new ArrayList<String>();
			if (hotelSetResult.isSuccess() && hotelSetResult.getPageList() != null) {
				for (HotelSetRefundInfo hotelSetRefundInfo : hotelSetResult.getPageList()) {
					StringBuffer refundMessage = new StringBuffer();
					refundMessage.append(hotelSetRefundInfo.getUserGrades()).append("级会员，")
						.append(hotelSetRefundInfo.getRefundTime()).append("之前全退");
					refundMessageList.add(refundMessage.toString());
				}
				model.addAttribute("refundMessageList", refundMessageList);
			} else {
				model.addAttribute("refundMessageList", refundMessageList);
			}
			if (hotelsResult.getPageList() != null && hotelsResult.getPageList().size() == 1) {
				HotelsStockIbatisDO hotelsStockIbatisDO = hotelsResult.getPageList().get(0);
				List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
				if (hotelsStockIbatisDO.getMorningNum() > 0 && dateLen == 1) {
					HotelDiscountInfo hotelDiscountInfo = hotelsDiscountService
						.selectHotelByScenicIdAndRoomType(scenicQueryResult.getQueryScenicInfo()
							.getId(), HotelTypeEnum.MORNING);
					if (hotelDiscountInfo != null) {
						String timeStr = hotelDiscountInfo.getSetTime();
						Date nowDate = new Date();
						Date minTimeDate = new Date();
						if (timeStr.compareTo("12:00") > 0) {
							try {
								minTimeDate = DateUtil.simpleFormatDate(beginDate + " " + timeStr);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							try {
								minTimeDate = DateUtil.increaseDate(
									DateUtil.simpleFormatDate(beginDate + " " + timeStr), 1);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if (hotelDiscountInfo != null && minTimeDate.getTime() <= nowDate.getTime()) {
							Map<String, Object> roomMap = new HashMap<>();
							roomMap.put("roomType", HotelTypeEnum.MORNING.getCode());
							roomMap.put("name", HotelTypeEnum.MORNING.getMessage());
							roomMap.put("price", hotelsStockIbatisDO.getMorningPrice()
								.toStandardString());
							roomMap.put("leftNum", hotelsStockIbatisDO.getMorningNum());
							roomList.add(roomMap);
						}
					}
				}
				if (hotelsStockIbatisDO.getSpecialNum() > 0) {
					Map<String, Object> roomMap = new HashMap<>();
					roomMap.put("roomType", HotelTypeEnum.SPECIAL.getCode());
					roomMap.put("name", HotelTypeEnum.SPECIAL.getMessage());
					roomMap.put("price", hotelsStockIbatisDO.getSpecialPrice().toStandardString());
					roomMap.put("leftNum", hotelsStockIbatisDO.getSpecialNum());
					roomList.add(roomMap);
				}
				if (hotelsStockIbatisDO.getNormalNumCus() > 0) {
					Map<String, Object> roomMap = new HashMap<>();
					roomMap.put("roomType", HotelTypeEnum.NORMAL.getCode());
					roomMap.put("name", HotelTypeEnum.NORMAL.getMessage());
					roomMap.put("price", hotelsStockIbatisDO.getNormalPrice().toStandardString());
					roomMap.put("leftNum", hotelsStockIbatisDO.getNormalNumCus());
					roomList.add(roomMap);
				}
				
				HotelStockOrder order = new HotelStockOrder();
				order.setProductId(product.getProductId());
				order.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
				order.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
				QueryBaseBatchResult<HotelStockInfo> baseBatchResult = hotelsStockService
					.getHotelStockList(order);
				if (!baseBatchResult.isSuccess()) {
					return hotelPath + "error.vm";
				}
				HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
				orderNumOrder.setProductId(product.getProductId());
				orderNumOrder.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
				orderNumOrder.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
				orderNumOrder.setStockInfoList(baseBatchResult.getPageList());
				HotelLongCheckInfoResult longCheckInfoResult = hotelsStockService
					.checkLongRoomInfo(orderNumOrder);
				if (longCheckInfoResult.getLongHotelNum() > 0) {
					Map<String, Object> roomMap = new HashMap<>();
					roomMap.put("roomType", HotelTypeEnum.LONGRENT.getCode());
					roomMap.put("name", HotelTypeEnum.LONGRENT.getMessage());
					roomMap.put("price", longCheckInfoResult.getExecPrice().toStandardString());
					roomMap.put("leftNum", longCheckInfoResult.getLongHotelNum());
					roomList.add(roomMap);
				}
				product.setRoomList(roomList);
			}
		}
		HotelSetRefundQueryOrder hotelSetRefundQueryOrder = new HotelSetRefundQueryOrder();
		QueryBaseBatchResult<HotelSetRefundInfo> hotelSetResult = hotelsSetRefundService
			.searchSetHotelRefundList(hotelSetRefundQueryOrder);
		List<String> refundMessageList = new ArrayList<String>();
		if (hotelSetResult.isSuccess() && hotelSetResult.getPageList() != null) {
			for (HotelSetRefundInfo hotelSetRefundInfo : hotelSetResult.getPageList()) {
				StringBuffer refundMessage = new StringBuffer();
				refundMessage.append(hotelSetRefundInfo.getUserGrades()).append("级会员，")
					.append(hotelSetRefundInfo.getRefundTime()).append("之前全退");
				refundMessageList.add(refundMessage.toString());
			}
			product.setRefundMessageList(refundMessageList);
		}
		model.addAttribute("commentList", commentList);
		model.addAttribute("listProperty", listProperty);
		model.addAttribute("product", product);
		model.addAttribute("supplier", supplier);
		model.addAttribute("otherTypeProduct", otherTypeProduct);
		model.addAttribute("scoreStatisticsRsult", scoreStatisticsRsult);
		
		return vmPath + "productInfo.vm";
	}
	
	@ResponseBody
	@RequestMapping("platform/mall/product/displayScoreCount.json")
	public Object displayCount(HttpServletRequest request, HttpServletResponse response,
								Model model, String productId, String discussType, String pageSize,
								String currentPage) {
		long lngProductId = new Long(productId);
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonOj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		SearchProductScoreOrder searchOrder = new SearchProductScoreOrder();
		searchOrder.setObjectId(lngProductId);
		if (discussType.equals("good")) {
			searchOrder.setBeginScore(4);
			searchOrder.setEndScore(5);
		}
		if (discussType.equals("all")) {
			searchOrder.setBeginScore(1);
			searchOrder.setEndScore(5);
		}
		if (discussType.equals("normal")) {
			searchOrder.setBeginScore(3);
			searchOrder.setEndScore(3);
		}
		if (discussType.equals("bad")) {
			searchOrder.setBeginScore(1);
			searchOrder.setEndScore(2);
		}
		List<ProductScoreInfo> commentList = orderService.queryProductScoreList(searchOrder)
			.getPageList();
		PageCreator pc = new PageCreator();
		pc.setTotalRow(commentList.size());
		for (ProductScoreInfo productScoreInfo : commentList) {
			JSONObject json = new JSONObject();
			json.put("PComment", productScoreInfo.getPComment());
			String userName = "匿名";
			UserQueryResult userQueryResult = userQueryService.queryByUserId(productScoreInfo
				.getMemberId());
			if (userQueryResult != null && userQueryResult.getQueryUserInfo() != null) {
				userName = userQueryResult.getQueryUserInfo().getUserName();
				if (StringUtil.isNotEmpty(userName)) {
					if (StringUtil.isNotEmpty(userName)) {
						if (userName.length() <= 5 && userName.length() > 2) {
							userName = userName.replaceFirst(
								userName.substring(2, userName.length()), "***");
						} else if (userName.length() > 5) {
							userName = userName.replaceFirst(userName.substring(2, 5), "***");
						} else {
							userName = userName.replaceFirst(
								userName.substring(1, userName.length()), "*");
						}
					}
				}
			}
			json.put("userName", userName);
			json.put("createTime", DateUtil.simpleFormatYmd(productScoreInfo.getCreateTime()));
			jsonArray.add(json);
		}
		jsonObject.put("code", "1");
		jsonObject.put("success", true);
		jsonOj.put("list", jsonArray);
		jsonOj.put("totalPage", pc.getTotalPage());
		jsonOj.put("totalItem", pc.getTotalRow());
		jsonObject.put("data", jsonOj);
		return jsonObject;
	}
}
