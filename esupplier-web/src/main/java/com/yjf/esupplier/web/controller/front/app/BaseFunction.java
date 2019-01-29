package com.yjf.esupplier.web.controller.front.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import rop.thirdparty.org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.security.MD5Util;
import com.yjf.common.lang.util.ArrayUtil;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.ConfigParamProperty;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.dal.custom.dataobject.HotelsStockIbatisDO;
import com.yjf.esupplier.dal.dataobject.TblProductDO;
import com.yjf.esupplier.domain.ProductDomain;
import com.yjf.esupplier.integration.industrial.api.info.LogisticsFlowInfo;
import com.yjf.esupplier.integration.industrial.api.result.LogisticsInfoResult;
import com.yjf.esupplier.service.app.equipmentLogin.EquipmentLoginOrder;
import com.yjf.esupplier.service.bill.info.RefundOrderInfo;
import com.yjf.esupplier.service.biz.util.BizCommonUtil;
import com.yjf.esupplier.service.common.info.MessageReceivedInfo;
import com.yjf.esupplier.service.common.result.EmailCodeResult;
import com.yjf.esupplier.service.common.result.SmsCodeResult;
import com.yjf.esupplier.service.common.services.order.MyMessageOrder;
import com.yjf.esupplier.service.common.services.order.QueryReceviedMessageOrder;
import com.yjf.esupplier.service.common.services.result.MessageResult;
import com.yjf.esupplier.service.hotel.result.HotelLongCheckInfoResult;
import com.yjf.esupplier.service.hotel.result.HotelLongSetResult;
import com.yjf.esupplier.service.hotel.result.HotelOrderResult;
import com.yjf.esupplier.service.hotel.result.HotelRefundCheckResult;
import com.yjf.esupplier.service.login.order.UserLoginOrder;
import com.yjf.esupplier.service.login.result.LoginResult;
import com.yjf.esupplier.service.openingbank.info.ProvinceInfo;
import com.yjf.esupplier.service.pay.order.AppPayOrder;
import com.yjf.esupplier.service.pay.result.AppPayResult;
import com.yjf.esupplier.service.security.token.info.LoginData;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.tocard.order.WithdrawFlowOrder;
import com.yjf.esupplier.service.user.enums.PasswordTypeEnum;
import com.yjf.esupplier.service.user.info.DeliveryPersonInfo;
import com.yjf.esupplier.service.user.info.FeebackOptionInfo;
import com.yjf.esupplier.service.user.info.UserAccountDataInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.info.UserLevelRuleInfo;
import com.yjf.esupplier.service.user.order.AddUserNameLoginOrder;
import com.yjf.esupplier.service.user.order.DeliveryPersonSearchOrder;
import com.yjf.esupplier.service.user.order.InvestorRegisterOrder;
import com.yjf.esupplier.service.user.order.MobileBindingOrder;
import com.yjf.esupplier.service.user.order.PwdInfoOrder;
import com.yjf.esupplier.service.user.order.QuickInvestorRegisterOrder;
import com.yjf.esupplier.service.user.order.UserExtendOrder;
import com.yjf.esupplier.service.user.order.UserWeixinOrder;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.service.user.result.UserRegisterResult;
import com.yjf.esupplier.service.user.result.UserWeixinQueryResult;
import com.yjf.esupplier.web.controller.base.Image;
import com.yjf.esupplier.web.controller.front.platform.bean.Cart;
import com.yjf.esupplier.web.util.AESUtil;
import com.yjf.esupplier.web.util.AppCommonUtil;
import com.yjf.esupplier.web.util.FileUploadUtils;
import com.yjf.esupplier.web.util.QRCodeUtil;
import com.yjf.esupplier.web.util.WebSessionUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.web.util.wx.Oauth2Servlet;
import com.yjf.esupplier.web.util.wx.Sign;
import com.yjf.esupplier.ws.base.info.BankConfigInfo;
import com.yjf.esupplier.ws.bill.enums.BillSearchOrderByEnum;
import com.yjf.esupplier.ws.bill.enums.CommentLikeTypeEnum;
import com.yjf.esupplier.ws.bill.enums.OperateTypeEnum;
import com.yjf.esupplier.ws.bill.enums.OrderFlowStatus;
import com.yjf.esupplier.ws.bill.enums.OrderRefundStatusEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.bill.enums.PrintReceiptStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundProcessStatusEnum;
import com.yjf.esupplier.ws.bill.enums.RefundTypeEnum;
import com.yjf.esupplier.ws.bill.enums.TakeWaysEnum;
import com.yjf.esupplier.ws.bill.info.DeliveryShipInfo;
import com.yjf.esupplier.ws.bill.info.DiningOrderInfo;
import com.yjf.esupplier.ws.bill.info.OrderFlowStatusCountInfo;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.info.OrderItemInfo;
import com.yjf.esupplier.ws.bill.info.OrderSumInfo;
import com.yjf.esupplier.ws.bill.info.ProductScoreInfo;
import com.yjf.esupplier.ws.bill.order.BillSaveOrder;
import com.yjf.esupplier.ws.bill.order.CancelBillOrder;
import com.yjf.esupplier.ws.bill.order.CancelDiningOrder;
import com.yjf.esupplier.ws.bill.order.ClearMealOrder;
import com.yjf.esupplier.ws.bill.order.ConfirmDeliveryMealOrder;
import com.yjf.esupplier.ws.bill.order.ConfirmMealOrder;
import com.yjf.esupplier.ws.bill.order.DrawerAddressSaveOrder;
import com.yjf.esupplier.ws.bill.order.MealBaseOrder;
import com.yjf.esupplier.ws.bill.order.MealOrder;
import com.yjf.esupplier.ws.bill.order.OrderQRCodeOrder;
import com.yjf.esupplier.ws.bill.order.OrderTakingMealOrder;
import com.yjf.esupplier.ws.bill.order.PayToShopOrder;
import com.yjf.esupplier.ws.bill.order.PrintReceiptMealOrder;
import com.yjf.esupplier.ws.bill.order.ProductScoreStatisticsRsult;
import com.yjf.esupplier.ws.bill.order.QueryOrderInfoSearchOrder;
import com.yjf.esupplier.ws.bill.order.QueryRefundOrder;
import com.yjf.esupplier.ws.bill.order.RefundApplyOrder;
import com.yjf.esupplier.ws.bill.order.RefundGoodsProcessOrder;
import com.yjf.esupplier.ws.bill.order.SearchProductScoreOrder;
import com.yjf.esupplier.ws.bill.order.SendQrCodeOrder;
import com.yjf.esupplier.ws.bill.order.TradeReviewLikeOrder;
import com.yjf.esupplier.ws.bill.order.TradeReviewOrder;
import com.yjf.esupplier.ws.bill.order.UpdateMealQuantityOrder;
import com.yjf.esupplier.ws.bill.result.BillSaveResult;
import com.yjf.esupplier.ws.common.enums.PaymentTypeEnum;
import com.yjf.esupplier.ws.common.enums.SeqNameEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CollectionStateEnum;
import com.yjf.esupplier.ws.enums.CommonAttachmentTypeEnum;
import com.yjf.esupplier.ws.enums.ExtPayTypeEnum;
import com.yjf.esupplier.ws.enums.LoginFromTypeEnum;
import com.yjf.esupplier.ws.enums.LoginMethodEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.MerchantTypeEnum;
import com.yjf.esupplier.ws.enums.MessageReceivedStatusEnum;
import com.yjf.esupplier.ws.enums.PopTypeEnum;
import com.yjf.esupplier.ws.enums.PopUserTypeEnum;
import com.yjf.esupplier.ws.enums.ProductRecommendTypeEnum;
import com.yjf.esupplier.ws.enums.RealNameAuthStatusEnum;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTradeInfo;
import com.yjf.esupplier.ws.gifamount.order.GainMoneyUseOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTradeQueryOrder;
import com.yjf.esupplier.ws.gifamount.result.UseGainMoneyResult;
import com.yjf.esupplier.ws.hotel.enums.HotelRuleTypeEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.info.HotelDiscountInfo;
import com.yjf.esupplier.ws.hotel.info.HotelLongDetailInfo;
import com.yjf.esupplier.ws.hotel.info.HotelLongSetInfo;
import com.yjf.esupplier.ws.hotel.info.HotelSetRefundInfo;
import com.yjf.esupplier.ws.hotel.info.HotelStockInfo;
import com.yjf.esupplier.ws.hotel.order.HotelLongSetOrder;
import com.yjf.esupplier.ws.hotel.order.HotelOrderNumOrder;
import com.yjf.esupplier.ws.hotel.order.HotelRefundCheckOrder;
import com.yjf.esupplier.ws.hotel.order.HotelStockNumOrder;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.info.CommonAttachmentInfo;
import com.yjf.esupplier.ws.info.DrawerAddressInfo;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.PopModuleVOInfo;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.info.ToCardFlowInfo;
import com.yjf.esupplier.ws.info.UserBankInfo;
import com.yjf.esupplier.ws.messageWall.info.MessageLoveWallInfo;
import com.yjf.esupplier.ws.messageWall.info.MessageWallInfo;
import com.yjf.esupplier.ws.messageWall.order.MessageLoveWallOrder;
import com.yjf.esupplier.ws.messageWall.order.MessageWallOrder;
import com.yjf.esupplier.ws.messageWall.order.MessageWallQueryOrder;
import com.yjf.esupplier.ws.order.CommonAttachmentQueryOrder;
import com.yjf.esupplier.ws.order.HotelDiscountOrder;
import com.yjf.esupplier.ws.order.HotelSetRefundQueryOrder;
import com.yjf.esupplier.ws.order.HotelStockOrder;
import com.yjf.esupplier.ws.order.HotelStockProductOrder;
import com.yjf.esupplier.ws.order.PopUserOrder;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.order.UserBankOrder;
import com.yjf.esupplier.ws.orderfood.enums.DiningTableStatus;
import com.yjf.esupplier.ws.orderfood.info.DiningTableSituationInfo;
import com.yjf.esupplier.ws.orderfood.order.QureyDiningTableOrder;
import com.yjf.esupplier.ws.orderfood.order.SelectDiningTableOrder;
import com.yjf.esupplier.ws.orderfood.result.SelectDiningTableResult;
import com.yjf.esupplier.ws.pay.enums.PaymentFlowStatus;
import com.yjf.esupplier.ws.pay.info.PaymentFlowInfo;
import com.yjf.esupplier.ws.product.enums.DeliverAreaEnum;
import com.yjf.esupplier.ws.product.enums.PostFeeTypeEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.enums.RefundRuleEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.enums.ShopingCartTypeEnum;
import com.yjf.esupplier.ws.product.info.DeliveryInfo;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.product.info.ProductUserCollectInfo;
import com.yjf.esupplier.ws.product.order.ProductInfoOrder;
import com.yjf.esupplier.ws.product.order.ProductRecommendOrder;
import com.yjf.esupplier.ws.product.order.ProductSearchOrder;
import com.yjf.esupplier.ws.product.order.ProductTypeQueryOrder;
import com.yjf.esupplier.ws.product.order.ProductUserOrder;
import com.yjf.esupplier.ws.product.order.SupplierProductSearchOrder;
import com.yjf.esupplier.ws.product.order.UpdateProductStatusOrder;
import com.yjf.esupplier.ws.product.result.ShopingCartResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.review.order.TradeReviewCreateOrder;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.storage.info.ProductStorageInfo;
import com.yjf.esupplier.ws.supplier.enums.SupplierRunStateEnum;
import com.yjf.esupplier.ws.supplier.info.SupplierInfo;
import com.yjf.esupplier.ws.supplier.order.SearchDiningSupplierOrder;
import com.yjf.esupplier.ws.supplier.order.SearchOrderMealAddressOrder;
import com.yjf.esupplier.ws.supplier.order.SupplierHotelQueryOrder;
import com.yjf.esupplier.ws.supplier.order.TableNumberSettingOrder;
import com.yjf.esupplier.ws.userManage.enums.UserExtendEnum;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

/**
 * app接口功能
 */
public class BaseFunction extends BaseAutowiredFunction {
	
	protected void getWxSign(	HttpServletRequest request, HttpSession session,
								HttpServletResponse response, JSONObject json, String string) {
		
		String url = request.getParameter("url");
		
		Map<String, Object> tokenMap = Sign.getAccessToken();
		Map<String, Object> ticketMap = Sign.getTicket(tokenMap.get("access_token").toString());
		Map<String, String> ret = Sign.sign(ticketMap.get("ticket").toString(), url);
		session.setAttribute("access_token", tokenMap.get("access_token").toString());
		session.setAttribute("ticket", ticketMap.get("ticket").toString());
		json.put("ret", ret);
		successResult(json, "成功获取签名！");
	}
	
	/** 红包/优惠券列表查询 */
	protected void queryGift(HttpServletRequest request, JSONObject json, String string) {
		GiftMoneyTradeQueryOrder demandQueryOrder = new GiftMoneyTradeQueryOrder();
		WebUtil.setPoPropertyByRequest(demandQueryOrder, request);
		demandQueryOrder.setUserid(ShiroSessionUtils.getSessionLocal().getUserId());
		String queryType = request.getParameter("queryType");
		if (StringUtil.isNotBlank(queryType)) {
			if (queryType.indexOf(",") > -1) {
				String[] types = queryType.split(",");
				List<String> typeList = new ArrayList<>();
				for (String s : types) {
					typeList.add(s);
				}
				demandQueryOrder.setTypeList(typeList);
			} else {
				demandQueryOrder.setType(queryType);
			}
		}
		List<String> statusList = new ArrayList<>();
		statusList.add("FINISH");
		statusList.add("NORMAL");
		statusList.add("EXPIRE");
		demandQueryOrder.setStatusList(statusList);
		QueryBaseBatchResult<GiftMoneyTradeInfo> result = giftMoneyTradeQueryService
			.queryGiftMoneyTrade(demandQueryOrder);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		if (result.isSuccess()) {
			for (GiftMoneyTradeInfo info : result.getPageList()) {
				map = new HashMap<>();
				AppCommonUtil.beanToMap(info, map);
				list.add(map);
			}
			json.put("list", list);
			json.put("totalPage", result.getPageCount());
			successResult(json, "查询成功");
		} else {
			failResult(json, result.getMessage());
		}
		
	}
	
	/** 验证当前消费可使用优惠券 */
	protected void queryGiftCanUse(HttpServletRequest request, JSONObject json, String string) {
		String amount = request.getParameter("amount");
		if (StringUtil.isBlank(amount)) {
			failResult(json, "消费金额不能为空");
			return;
		}
		GainMoneyUseOrder order = new GainMoneyUseOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setInvestAmount(Money.amout(amount));
		order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		UseGainMoneyResult result = giftMoneyTradeQueryService.queryGainMoneyCanUseByTrade(order);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (GiftMoneyTradeInfo info : result.getGainMoneyTrades()) {
			map = new HashMap<String, String>();
			AppCommonUtil.beanToMap(info, map);
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", 1);
		successResult(json, "查询优惠券成功");
	}
	
	/** 生成消费二维码 */
	protected void makeQrCode(HttpServletRequest request, JSONObject json, String string) {
		String bizNo = request.getParameter("id");
		String orderType = request.getParameter("orderType");
		if (StringUtil.isBlank(bizNo)) {
			failResult(json, "订单号不能为空");
			return;
		}
		OrderQRCodeOrder processOrder = new OrderQRCodeOrder();
		processOrder.setBizNo(Long.parseLong(bizNo));
		processOrder.setOrderType(orderType);
		processOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		processOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		processOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		EsupplierBaseResult result = orderService.makeQRcodeUrl(processOrder);
		OrderInfo orderInfo = orderService.findOrderById(Long.parseLong(bizNo));
		if (result.isSuccess()) {
			successResult(json, "消费二维码生成成功");
			json.put("url", result.getUrl());
			json.put("qrCode", orderInfo.getQrCode());
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 商家使用消费码 */
	protected void useQrCode(HttpServletRequest request, JSONObject json, String string) {
		SendQrCodeOrder processOrder = new SendQrCodeOrder();
		WebUtil.setPoPropertyByRequest(processOrder, request);
		processOrder.setBizTypeEnum(UserBizTypeEnum.SELLER);
		processOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		processOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		processOrder.setProcessName(ShiroSessionUtils.getSessionLocal().getUserName());
		EsupplierBaseResult result = orderService.useQrCode(processOrder);
		if (result.isSuccess()) {
			successResult(json, "消费成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 景区列表查询 */
	protected void scenicList(HttpServletRequest request, JSONObject json, String string) {
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		QueryBaseBatchResult<ScenicInfo> result = scenicService.getScenicInfo(scenicQueryOrder);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (ScenicInfo info : result.getPageList()) {
			map = new HashMap<>();
			map.put("scenicId", toString(info.getId()));
			map.put("name", info.getName());
			map.put("note", info.getNote());
			map.put("note", info.getNote());
			map.put("imagePath1", info.getImagePath1());
			map.put("closeTime", info.getCloseTime());
			map.put("cityName", info.getCity());
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", result.getPageCount());
		successResult(json, "景区列表查询成功");
	}
	
	/** 景区详情查询 */
	protected void scenicInfo(HttpServletRequest request, JSONObject json, String string) {
		
		String scenicId = request.getParameter("scenicId");
		if (StringUtil.isEmpty(scenicId)) {
			failResult(json, "请提供景区ID");
			return;
		}
		ScenicQueryResult result = scenicService.queryById(Long.parseLong(scenicId));
		if (result.isSuccess() && result.getQueryScenicInfo() != null) {
			ScenicInfo scenicInfo = result.getQueryScenicInfo();
			json.put("name", scenicInfo.getName());
			json.put("phone", scenicInfo.getPhone());
			json.put("longitude", scenicInfo.getLng());
			json.put("latitude", scenicInfo.getLat());
			json.put("scenicId", String.valueOf(scenicInfo.getId()));
			json.put("imagePath1", scenicInfo.getImagePath1());
			json.put("openTime", scenicInfo.getOpenTime());
			json.put("closeTime", scenicInfo.getCloseTime());
			json.put("scenicMap", scenicInfo.getNote());
			json.put("detail", scenicInfo.getDetail());
			json.put("note", scenicInfo.getNote());
			json.put("address",  scenicInfo.getAddress());
			SupplierProductSearchOrder order = new SupplierProductSearchOrder();
			WebUtil.setPoPropertyByRequest(order, request);
			order.setProductStatus(ProductStatusEnum.ON);
			order.setProductVaryEnum(ProductVaryEnum.ticket);
			order.setApproveState(null);
			order.setMerchantState(null);
			order.setResortsBusinessId(scenicInfo.getId());
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
				.getSupplierAndProductList(order);
			List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
			if (baseBatchResult.isSuccess()) {
				Map<String, Object> productMap = null;
				for (ProductInfo info : baseBatchResult.getPageList()) {
					
					productMap = new HashMap<>();
					setList(productMap, info);
					productList.add(productMap);
				}
			}
			json.put("ticketList", productList);
			json.put("totalPage", baseBatchResult.getPageCount());
			successResult(json, "获取景区信息成功");
		} else {
			failResult(json, "未查询到景区信息");
		}
		
	}
	
	/** 版本信息 */
	protected void appUpdateInfo(HttpServletRequest request, JSONObject json, String string) {
		
		PopInfo infos = null;
		String type = request.getParameter("type");
		if (StringUtil.equalsIgnoreCase("IOS", type)) {
			infos = popService.getIOSVersion();
		} else if (StringUtil.equalsIgnoreCase("ANDROID", type)) {
			infos = popService.getAndroidVersion();
		} else if (StringUtil.equalsIgnoreCase("SELLER", type)) {
			infos = popService.getSellerVersion();
		} else if (StringUtil.equalsIgnoreCase("DELIVERY", type)) {
			infos = popService.getDiliveryVersion();
		} else if (StringUtil.equalsIgnoreCase("PAD", type)) {
			infos = popService.getPadVersion();
		} else {
			failResult(json, "未知的type类型");
			return;
		}
		if (infos != null) {
			Map<String, String> map = new HashMap<>();
			map.put("vesionCode", infos.getTitle());
			map.put("updateUrl", infos.getRem1());
			map.put("optionalUpdateCode", infos.getBelongTo());
			map.put("forceUpdateCode", infos.getRemark());
			map.put("updateInfo", infos.getContent());
			json.put("info", AppCommonUtil.cleanNull(map));
			successResult(json, "获取最新版本成功");
		} else {
			failResult(json, "未查询到版本信息");
		}
		
	}
	
	/** 修改邮箱 */
	protected void updateMail(HttpServletRequest request, JSONObject json, String string) {
		
		UserQueryResult baseResult = userQueryService
			.queryByUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		String code = request.getParameter("code");
		if (StringUtil.isBlank(code)) {
			failResult(json, "验证码不能为空");
			return;
		}
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(
			baseResult.getQueryUserInfo().getMobile(), SmsBizType.PERSONAL, code, true);
		if (!smsCodeResult.isSuccess()) {
			failResult(json, smsCodeResult.getMessage());
			return;
		}
		String newMail = request.getParameter("newMail");
		
		if (StringUtil.isBlank(newMail)) {
			failResult(json, "邮箱不能为空");
			return;
		}
		EsupplierBaseResult result = userBaseInfoManager
			.mailBinding(ShiroSessionUtils.getSessionLocal().getUserBaseId(), newMail);
		if (result.isSuccess()) {
			successResult(json, "修改绑定邮箱成功");
		} else {
			failResult(json, "修改绑定邮箱失败");
		}
		
	}
	
	/** 商户详情 */
	protected void supplierInfo(HttpServletRequest request, JSONObject json, String string) {
		ProductSearchOrder productSearchOrder = new ProductSearchOrder();
		String supplierId = request.getParameter("supplierId");
		String saleType = request.getParameter("saleType");
		if (StringUtil.isBlank(supplierId)) {
			failResult(json, "商户Id不能为空");
			return;
		}
		SupplierInfo supplierInfo = userQueryService
			.querySupplierInfoDetail(NumberUtil.parseLong(supplierId, 0), productSearchOrder);
		Map<String, Object> map = new HashMap<String, Object>();
		if (supplierInfo != null) {
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			map = new HashMap<String, Object>();
			List<String> imgList = new ArrayList<String>();
			if (StringUtil.isNotBlank(latitude)) {
				Long distance = BizCommonUtil.getDistance(NumberUtil.parseDouble(latitude),
					NumberUtil.parseDouble(longitude),
					NumberUtil.parseDouble(supplierInfo.getLatitude()),
					NumberUtil.parseDouble(supplierInfo.getLongitude()));
				map.put("distance", toString(distance));
			}
			map.put("supplierId", toString(supplierId));
			map.put("rateSum", supplierInfo.getRateSum());
			map.put("productSum", supplierInfo.getProductSum());
			map.put("storeName", supplierInfo.getStoreName());
			map.put("nickName", supplierInfo.getNickname());
			map.put("address", supplierInfo.getAddress());
			map.put("productDiscount", supplierInfo.getProductDiscount());
			map.put("mobile", supplierInfo.getMobile());
			map.put("spendPer", supplierInfo.getSpendPer().toStandardString());
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath1())) {
				imgList.add(supplierInfo.getMerchantPicPath1());
			}
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath2())) {
				imgList.add(supplierInfo.getMerchantPicPath2());
			}
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath3())) {
				imgList.add(supplierInfo.getMerchantPicPath3());
			}
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath4())) {
				imgList.add(supplierInfo.getMerchantPicPath4());
			}
			map.put("reviewAverage", toString(supplierInfo.getReviewAverageDefault()));
			map.put("imgList", imgList);
			map.put("merchantType", supplierInfo.getMerchantType());
			map.put("openTime", supplierInfo.getOpenTime());
			map.put("closeTime", supplierInfo.getCloseTime());
			map.put("scenicName", supplierInfo.getScenicName());
			map.put("toShop",
				supplierInfo.getToShop() == null ? "" : supplierInfo.getToShop().getCode());
			map.put("shopGrade", supplierInfo.getShopGrade());
			map.put("introduction", supplierInfo.getIntroduction());
			map.put("aroundLine",supplierInfo.getAroundLine());
			QueryBaseBatchResult<ProductInfo> baseBatchResult = new QueryBaseBatchResult<ProductInfo>();
			List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
			boolean isSupplierSelf = false;
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			if (sessionLocal != null) {
				UserBizTypeEnum userBizTypeEnum = sessionLocal.getUserInfo().getUserBizType();
				if (userBizTypeEnum != null && userBizTypeEnum == UserBizTypeEnum.SELLER) {
					isSupplierSelf = true;
				}
			}
			if (SaleTypeEnum.getByCode(saleType) == SaleTypeEnum.HOTELS 
				&&!isSupplierSelf) {
				/*
				HotelStockProductOrder productOrder = new HotelStockProductOrder();
				productOrder.setStatus(HotelStockStatusEnum.ON);
				productOrder.setProductStatus(ProductStatusEnum.ON);
				productOrder.setSupplierId(NumberUtil.parseLong(supplierId, 0));
				WebUtil.setPoPropertyByRequest(productOrder, request);
				String beginDate = request.getParameter("beginDate");
				if (StringUtil.isEmpty(beginDate)) {
					beginDate = DateUtil.simpleFormatYmd(new Date());
				}
				String endDate = request.getParameter("endDate");
				if (StringUtil.isEmpty(endDate)) {
					endDate = DateUtil.simpleFormatYmd(DateUtil.getAfterDay(new Date()));
				}
				productOrder.setBeginDate(DateUtil.parse(beginDate));
				productOrder.setEndDate(DateUtil.parse(endDate));
				QueryBaseBatchResult<HotelsStockIbatisDO> hotelsResult = hotelsStockService
					.searchHotelLeftList(productOrder);
				if (!hotelsResult.isSuccess()) {
					failResult(json, "查询失败:" + hotelsResult.getMessage());
					return;
				}
				for (HotelsStockIbatisDO infos : hotelsResult.getPageList()) {
					Map<String, Object> productMap = new HashMap<>();
					ProductInfo productInfo = new ProductInfo();
					productInfoCovertDO(productInfo, infos.getTblProductDO());
					setList(productMap, productInfo);
					productMap.put("execPrice", infos.getExecPrice().toStandardString());
					productMap.put("payedCount", infos.getPayedCount());
					productList.add(productMap);
				}
				baseBatchResult.setTotalCount(hotelsResult.getTotalCount());
				baseBatchResult.setPageCount(hotelsResult.getPageCount());
				*/
				SupplierProductSearchOrder order = new SupplierProductSearchOrder();
				WebUtil.setPoPropertyByRequest(order, request);
				if (sessionLocal != null) {
					//游客中心
					if (sessionLocal.getUserBizType() == UserBizTypeEnum.SELLER) {
						order.setProductStatus(null);
					} else if (sessionLocal.getUserBizType() == UserBizTypeEnum.BUYER) {
						order.setProductStatus(ProductStatusEnum.ON);
					}
				} else {
					order.setProductStatus(ProductStatusEnum.ON);
				}
				order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
				order.setSaleTypeHotels(BooleanEnum.YES);			
				String productStatus = request.getParameter("productStatus");
				if (StringUtil.equals(productStatus, "all")) {
					order.setProductStatus(null);
				}
				baseBatchResult = productService.getSupplierAndProductList(order);
				for (ProductInfo infos : baseBatchResult.getPageList()) {
					Map<String, Object> productMap = new HashMap<>();
					setList(productMap, infos);
					productList.add(productMap);
				}
			} else if(SaleTypeEnum.getByCode(saleType) == SaleTypeEnum.O2O 
					&&!isSupplierSelf){
				SupplierProductSearchOrder order = new SupplierProductSearchOrder();
				WebUtil.setPoPropertyByRequest(order, request);
				if (sessionLocal != null) {
					//游客中心
					if (sessionLocal.getUserBizType() == UserBizTypeEnum.SELLER) {
						order.setProductStatus(null);
					} else if (sessionLocal.getUserBizType() == UserBizTypeEnum.BUYER) {
						order.setProductStatus(ProductStatusEnum.ON);
					}
				} else {
					order.setProductStatus(ProductStatusEnum.ON);
				}
				order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
				order.setSaleTypeO2O(BooleanEnum.YES);			
				String productStatus = request.getParameter("productStatus");
				if (StringUtil.equals(productStatus, "all")) {
					order.setProductStatus(null);
				}
				baseBatchResult = productService.getSupplierAndProductList(order);
				for (ProductInfo infos : baseBatchResult.getPageList()) {
					Map<String, Object> productMap = new HashMap<>();
					setList(productMap, infos);
					productList.add(productMap);
				}
			}else{
				SupplierProductSearchOrder order = new SupplierProductSearchOrder();
				WebUtil.setPoPropertyByRequest(order, request);
				if (sessionLocal != null) {
					//游客中心
					if (sessionLocal.getUserBizType() == UserBizTypeEnum.SELLER) {
						order.setProductStatus(null);
					} else if (sessionLocal.getUserBizType() == UserBizTypeEnum.BUYER) {
						order.setProductStatus(ProductStatusEnum.ON);
					}
				} else {
					order.setProductStatus(ProductStatusEnum.ON);
				}
				order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
				/*商户自己查看自己全部商品*/
				if (!isSupplierSelf) {
				//	order.setSaleTypeO2OAndB2C(BooleanEnum.YES);
				//	order.setSaleTypeO2OAndHotels(BooleanEnum.YES);
				}
				String productStatus = request.getParameter("productStatus");
				if (StringUtil.equals(productStatus, "all")) {
					order.setProductStatus(null);
				}
				baseBatchResult = productService.getSupplierAndProductList(order);
				for (ProductInfo infos : baseBatchResult.getPageList()) {
					Map<String, Object> productMap = new HashMap<>();
					setList(productMap, infos);
					productList.add(productMap);
				}
				
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			map.put("producList", productList);
			map.put("productCount", baseBatchResult.getTotalCount());
			map.put("isCollected", checkCollecteStatus(null, toString(supplierId)));
			json.put("info", map);
			successResult(json, "商户详情查询成功");
		} else {
			failResult(json, "查询失败");
		}
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
	
	/** 商户列表 */
	protected void supplierList(HttpServletRequest request, JSONObject json, String string) {
		String merchantName = request.getParameter("merchantName");
		String merchantState = request.getParameter("merchantState");
		String merchantType = request.getParameter("merchantType");
		String saleType = StringUtil.defaultIfEmpty(request.getParameter("saleType"), "");
		String roomType = StringUtil.defaultIfEmpty(request.getParameter("roomType"), "");
		String recommend = StringUtil.defaultIfEmpty(request.getParameter("recommend"), "");
		String scenicId = request.getParameter("scenicId");
		long belongTo = 0;
		/*所属景区*/
		if (StringUtil.isNotEmpty(scenicId)) {
			UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(scenicId);
			if (userQueryResult.getQueryUserInfo() != null) {
				belongTo = userQueryResult.getQueryUserInfo().getUserId();
			}
		}
		QueryBaseBatchResult<SupplierInfo> result = new QueryBaseBatchResult<SupplierInfo>();
		if (saleType.equals(SaleTypeEnum.HOTELS.getCode())) { /*酒店列表查询*/
//			SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
//			if (StringUtil.isNotEmpty(scenicId)) {
//				queryOrder.setScenicId(scenicId);
//			}
//			if (roomType.equals(HotelTypeEnum.MORNING.getCode())) {
//				queryOrder.setMorningRoom(BooleanEnum.YES);
//			}
//			if (roomType.equals(HotelTypeEnum.SPECIAL.getCode())) {
//				queryOrder.setSpecialRoom(BooleanEnum.YES);
//			}
//			if (roomType.equals(HotelTypeEnum.LONGRENT.getCode())) {
//				queryOrder.setLongRentRoom(BooleanEnum.YES);
//			}
//			if (recommend.equals(BooleanEnum.YES.getCode())) {
//				queryOrder.setRecommend(BooleanEnum.YES);
//			}
//			WebUtil.setPoPropertyByRequest(queryOrder, request);
//			queryOrder.setSearchName(merchantName);
//			queryOrder.setMerchantTypeEnum(MerchantTypeEnum.getByCode(merchantType));
//			queryOrder.setMerchantStateEnum(MerchantStateEnum.getByCode(merchantState));
//			result = supplierService.searchHotelSupplier(queryOrder);
//			json.put("roomType", roomType);
//			json.put("beginDate", request.getParameter("beginDate"));
//			json.put("endDate", request.getParameter("endDate"));
			UserRoleQueryOrder commonQueryOrder = new UserRoleQueryOrder();
			if (belongTo > 0) {
				commonQueryOrder.setBelongTo(belongTo);
			}
			WebUtil.setPoPropertyByRequest(commonQueryOrder, request);
			commonQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
			commonQueryOrder.setMerchantStateEnum(MerchantStateEnum.getByCode(merchantState));
			commonQueryOrder.setMerchantTypeEnum(MerchantTypeEnum.getByCode(merchantType));
			commonQueryOrder.setHotels(BooleanEnum.YES);
			commonQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
			if(recommend.equals(BooleanEnum.YES.getCode())) commonQueryOrder.setRecommend(BooleanEnum.YES);
			result = userQueryService.queryRoleSupplierUserInfo(commonQueryOrder);

		} else { /*其他商户列表查询*/
			UserRoleQueryOrder commonQueryOrder = new UserRoleQueryOrder();
			if (belongTo > 0) {
				commonQueryOrder.setBelongTo(belongTo);
			}
			WebUtil.setPoPropertyByRequest(commonQueryOrder, request);
			commonQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
			commonQueryOrder.setMerchantStateEnum(MerchantStateEnum.getByCode(merchantState));
			commonQueryOrder.setMerchantTypeEnum(MerchantTypeEnum.getByCode(merchantType));
			commonQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
			//查询支持团购邮购的商户
			if(saleType.equals(SaleTypeEnum.O2O.getCode())) {
				commonQueryOrder.setO2o(BooleanEnum.YES);
			}
			if(recommend.equals(BooleanEnum.YES.getCode())) commonQueryOrder.setRecommend(BooleanEnum.YES);
			result = userQueryService.queryRoleSupplierUserInfo(commonQueryOrder);
		}
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (SupplierInfo info : result.getPageList()) {
			map = new HashMap<>();
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("merchantPicPath1", info.getMerchantPicPath1());
			map.put("storeName", info.getStoreName());
			map.put("nickName", info.getNickname());
			map.put("reviewAverage", toString(info.getReviewAverageDefault()));
			map.put("scenicName", info.getScenicName());
			map.put("merchantType", info.getMerchantType());
			map.put("distance", String.valueOf(info.getDistance()));
			map.put("toShop", info.getToShop() == null ? "" : info.getToShop().getCode());
			map.put("shopGrade", info.getShopGrade());
			map.put("isCollected", checkCollecteStatus(null, toString(info.getSupplierId())));
			map.put("roomLowestPrice", info.getRoomLowestPrice().equals(new Money(0)) ? ""
				: info.getRoomLowestPrice().toStandardString());
			map.put("spendPer", info.getSpendPer().toStandardString());
			map.put("recommend",
				info.getRecommend() == null ? "NO" : info.getRecommend().getCode());
			map.put("specialRoom",
				info.getSpecialRoom() == null ? "NO" : info.getSpecialRoom().getCode());
			map.put("recommend",
				info.getRecommend() == null ? "NO" : info.getRecommend().getCode());
			map.put("longRentRoom",
				info.getLongRentRoom() == null ? "NO" : info.getLongRentRoom().getCode());
			map.put("morningRoom",
				info.getMorningRoom() == null ? "NO" : info.getMorningRoom().getCode());
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", result.getPageCount());
		successResult(json, "商户列表查询成功");
	}
	
	/*商户分类列表*/
	protected void supplierType(HttpServletRequest request, JSONObject json, String string) {
		String isHotel = StringUtil.defaultIfEmpty(request.getParameter("isHotel"), "");
		boolean hotel = isHotel.equals(BooleanEnum.YES.getCode()) ? true : false;
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		if (hotel) {
			mapList = MerchantTypeEnum.getAllEnumList(false, hotel);
		} else {
			mapList = MerchantTypeEnum.getAllEnumList(true, false);
		}
		json.put("mapList", mapList);
		json.put("mapListCount", mapList.size());
		successResult(json, "商户分类查询成功");
	}
	
	/** 酒店历史入住列表 */
	protected void hotelHistoryList(HttpServletRequest request, JSONObject json, String string) {
		String merchantName = request.getParameter("merchantName");
		QueryBaseBatchResult<SupplierInfo> result = new QueryBaseBatchResult<SupplierInfo>();
		SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setSearchName(merchantName);
		queryOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		result = supplierService.searchBuyHotelSupplier(queryOrder);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (SupplierInfo info : result.getPageList()) {
			map = new HashMap<>();
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("merchantPicPath1", info.getMerchantPicPath1());
			map.put("storeName", info.getStoreName());
			map.put("nickName", info.getNickname());
			map.put("reviewProduct", toString(info.getReviewProduct()));
			map.put("scenicName", info.getScenicName());
			map.put("merchantType", info.getMerchantType());
			map.put("distance", String.valueOf(info.getDistance()));
			map.put("toShop", info.getToShop() == null ? "" : info.getToShop().getCode());
			map.put("shopGrade", info.getShopGrade());
			map.put("isCollected", checkCollecteStatus(null, toString(info.getSupplierId())));
			map.put("roomLowestPrice", info.getRoomLowestPrice().equals(new Money(0)) ? ""
				: info.getRoomLowestPrice().toStandardString());
			map.put("recommend", info.getRecommend() == null ? "" : info.getRecommend().getCode());
			map.put("specialRoom",
				info.getSpecialRoom() == null ? "" : info.getSpecialRoom().getCode());
			map.put("longRentRoom",
				info.getLongRentRoom() == null ? "" : info.getLongRentRoom().getCode());
			map.put("morningRoom",
				info.getMorningRoom() == null ? "" : info.getMorningRoom().getCode());
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", result.getPageCount());
		successResult(json, "酒店历史入住列表查询成功");
	}
	
	/**
	 * 订餐商户列表
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void orderMealSupplierList(	HttpServletRequest request, JSONObject json,
											String string) {
		SearchDiningSupplierOrder commonQueryOrder = new SearchDiningSupplierOrder();
		WebUtil.setPoPropertyByRequest(commonQueryOrder, request);
		commonQueryOrder.setMerchantStateEnum(
			MerchantStateEnum.getByCode(request.getParameter("merchantState")));
		commonQueryOrder
			.setMerchantTypeEnum(MerchantTypeEnum.getByCode(request.getParameter("merchantType")));
		String scenicId = request.getParameter("scenicId");
		/*所属景区*/
		if (StringUtil.isNotEmpty(scenicId)) {
			UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(scenicId);
			if (userQueryResult.getQueryUserInfo() != null) {
				commonQueryOrder.setBelongTo(userQueryResult.getQueryUserInfo().getUserId());
			}
		}
		String loadSelf = request.getParameter("loadSelf");
		if (StringUtil.isNotBlank(loadSelf)) {
			commonQueryOrder.setLoadSelf(BooleanEnum.getByCode(loadSelf));
		}
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		//获取用户
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null) {
			//游客中心
			if (sessionLocal.getUserBizType() == UserBizTypeEnum.SELLER) {
				commonQueryOrder.setDiningSupplierId(sessionLocal.getUserId());
			} else if (sessionLocal.getUserBizType() == UserBizTypeEnum.BUYER) {
				commonQueryOrder.setDiningSupplierId(cart.getDiningAddressId());
			}
		} else {
			commonQueryOrder.setDiningSupplierId(cart.getDiningAddressId());
		}
		String orderMeal = request.getParameter("orderMeal");
		if (StringUtil.isNotBlank(orderMeal)) {
			//点餐
			commonQueryOrder.setOrderMeal(BooleanEnum.getByCode(orderMeal));
		}
		String hotels = request.getParameter("hotels");
		if (StringUtil.isNotBlank(hotels)) {
			//酒店
			commonQueryOrder.setHotels(BooleanEnum.getByCode(hotels));
		}
		QueryBaseBatchResult<SupplierInfo> result = supplierService
			.searchDiningSupplierList(commonQueryOrder);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (SupplierInfo info : result.getPageList()) {
			map = new HashMap<>();
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("merchantPicPath1", info.getMerchantPicPath1());
			map.put("storeName", info.getStoreName());
			map.put("nickName", info.getNickname());
			map.put("reviewProduct", toString(info.getReviewProduct()));
			map.put("scenicName", info.getScenicName());
			map.put("merchantType", info.getMerchantType());
			map.put("distance", String.valueOf(info.getDistance()));
			map.put("toShop", info.getToShop() == null ? "" : info.getToShop().getCode());
			map.put("shopGrade", info.getShopGrade());
			//map.put("isCollected", checkCollecteStatus(null, toString(info.getSupplierId())));
			//处理成整数
			long yuan = info.getLowestHandselAmount().getCent() / 100;
			map.put("lowestHandselAmount", toString(yuan));
			map.put("openTime", info.getOpenTime());
			map.put("closeTime", info.getCloseTime());
			map.put("serviceChargeRate", toString(info.getServiceChargeRate()));
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", result.getPageCount());
		successResult(json, "商户列表查询成功");
	}
	
	/** 点餐商户详情和产品列表 */
	protected void orderMealSupplierInfo(	HttpServletRequest request, JSONObject json,
											String string) {
		ProductSearchOrder productSearchOrder = new ProductSearchOrder();
		String supplierId = request.getParameter("supplierId");
		String terminalType = request.getParameter("terminalType");
		if (StringUtil.isBlank(supplierId)) {
			failResult(json, "商户Id不能为空");
			return;
		}
		SupplierInfo supplierInfo = userQueryService
			.querySupplierInfoDetail(NumberUtil.parseLong(supplierId, 0), productSearchOrder);
		Map<String, Object> map = new HashMap<String, Object>();
		if (supplierInfo != null) {
			map = new HashMap<String, Object>();
			List<String> imgList = new ArrayList<String>();
			
			map.put("supplierId", toString(supplierId));
			map.put("storeName", supplierInfo.getStoreName());
			map.put("nickName", supplierInfo.getNickname());
			map.put("address", supplierInfo.getAddress());
			map.put("mobile", supplierInfo.getMobile());
			map.put("spendPer", supplierInfo.getSpendPer().toStandardString());
			map.put("serviceChargeRate", toString(supplierInfo.getServiceChargeRate()));
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath1())) {
				imgList.add(supplierInfo.getMerchantPicPath1());
			}
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath2())) {
				imgList.add(supplierInfo.getMerchantPicPath2());
			}
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath3())) {
				imgList.add(supplierInfo.getMerchantPicPath3());
			}
			if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath4())) {
				imgList.add(supplierInfo.getMerchantPicPath4());
			}
			map.put("reviewAverage", toString(supplierInfo.getReviewAverageDefault()));
			map.put("imgList", imgList);
			map.put("merchantType", supplierInfo.getMerchantType());
			map.put("scenicName", supplierInfo.getScenicName());
			map.put("toShop",
				supplierInfo.getToShop() == null ? "" : supplierInfo.getToShop().getCode());
			map.put("shopGrade", supplierInfo.getShopGrade());
			long yuan = supplierInfo.getLowestHandselAmount().getCent() / 100;
			map.put("lowestHandselAmount", toString(yuan));
			//map.put("lowestHandselAmount", supplierInfo.getLowestHandselAmount().toString());
			map.put("openTime", supplierInfo.getOpenTime());
			map.put("closeTime", supplierInfo.getCloseTime());
			SupplierProductSearchOrder order = new SupplierProductSearchOrder();
			WebUtil.setPoPropertyByRequest(order, request);
			order.setProductStatus(ProductStatusEnum.ON);
			order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
			
			//获取用户
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
			if (sessionLocal != null) {
				//商户
				if (sessionLocal.getUserBizType() == UserBizTypeEnum.SELLER) {
					//不相等 是调餐
					if (sessionLocal.getUserId() != NumberUtil.parseLong(supplierId)) {
						order.setTuneMeal(BooleanEnum.YES);
					}
				} else if (sessionLocal.getUserBizType() == UserBizTypeEnum.BUYER) {
					if (cart.getDiningAddressId() != NumberUtil.parseLong(supplierId)) {
						order.setTuneMeal(BooleanEnum.YES);
						map.put("diningSupplier", "NO");
					} else {
						map.put("diningSupplier", "YES");
					}
				}
			}
			
			String orderMeal = request.getParameter("orderMeal");
			if (StringUtil.isNotBlank(orderMeal)) {
				//点餐
				order.setSaleTypeOrderMeal(BooleanEnum.getByCode(orderMeal));
			}
			String hotels = request.getParameter("hotels");
			if (StringUtil.isNotBlank(hotels)) {
				//酒店
				order.setSaleTypeHotels(BooleanEnum.getByCode(hotels));
			}
			if (StringUtil.equals(terminalType, "pad")) {
				order.setPageSize(1000);
			}
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
				.getSupplierAndProductList(order);
			List<Map<String, Object>> productList = new ArrayList<Map<String, Object>>();
			for (ProductInfo infos : baseBatchResult.getPageList()) {
				Map<String, Object> productMap = new HashMap<>();
				setList(productMap, infos);
				productMap.put("postFee", infos.getPrice1()
					.multiply(supplierInfo.getServiceChargeRate()).divide(100).toString());
				productList.add(productMap);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			map.put("producList", productList);
			map.put("productCount", baseBatchResult.getTotalCount());
			map.put("isCollected", checkCollecteStatus(null, toString(supplierId)));
			json.put("info", map);
			successResult(json, "商户详情查询成功");
		} else {
			failResult(json, "查询失败");
		}
	}
	
	/** 旅游攻略分类 */
	protected void glfl(HttpServletRequest request, JSONObject json, String string) {
		QueryBaseBatchResult<PopModuleVOInfo> baseResult = popModuleService.getOnlineModulesForGl();
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (PopModuleVOInfo info : baseResult.getPageList()) {
			map = new HashMap<>();
			map.put("moduleId", toString(info.getModuleId()));
			map.put("moduleName", info.getModuleName());
			list.add(map);
		}
		json.put("list", list);
		successResult(json, "攻略类型查询成功");
	}
	
	/** 旅游攻略 */
	protected void lygl(HttpServletRequest request, JSONObject json, String string) {
		
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		String scenicId = request.getParameter("scenicId");
		String moduleId = request.getParameter("moduleId");
		String title = request.getParameter("title");
		String provinceName = request.getParameter("provinceName");
		String cityName = request.getParameter("cityName");
		PageParam pageParam = new PageParam();
		pageParam.setPageNo(NumberUtil.parseInt(pageNumber, 1));
		pageParam.setPageSize(NumberUtil.parseInt(pageSize, 1));
		QueryBaseBatchResult<PopInfo> baseResult = popService.getGlListByConditionsNew(pageParam,
			scenicId, moduleId, title, provinceName, cityName);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (PopInfo info : baseResult.getPageList()) {
			map = new HashMap<>();
			AppCommonUtil.beanToMap(info, map);
			map.remove("scenicInfo");
			if (info.getScenicInfo() != null) {
				map.put("name", info.getScenicInfo().getName());
				map.put("address", info.getScenicInfo().getAddress());
				map.put("detail", info.getScenicInfo().getDetail());
			} else {
				map.put("name", "");
				map.put("address", "");
				map.put("detail", "");
			}
			map.remove("popModuleVOInfo");
			if (info.getPopModuleVOInfo() != null) {
				map.put("parentName", info.getPopModuleVOInfo().getModuleName());
			} else {
				map.put("parentName", "");
			}
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", baseResult.getPageCount());
		successResult(json, "攻略列表查询成功");
		
	}
	
	/** 旅游攻略收藏点赞 */
	protected void glCollectAgree(HttpServletRequest request, JSONObject json, String string) {
		EsupplierBaseResult result = new EsupplierBaseResult();
		String type = request.getParameter("type");
		String action = request.getParameter("action");
		String popId = request.getParameter("popId");
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		PopUserTypeEnum popUserTypeEnum = PopUserTypeEnum.getByCode(type);
		if (NumberUtil.parseLong(popId) == 0) {
			failResult(json, "攻略Id不能为空");
			return;
		}
		if (popUserTypeEnum == null) {
			failResult(json, "选择的操作分类不对");
			return;
		}
		String title = popUserTypeEnum.getMessage();
		/*收藏*/
		if (action.equals("DEL")) {
			result = popUserService.deletePopUser(userId, NumberUtil.parseLong(popId),
				popUserTypeEnum);
		} else if (action.equals("ADD")) {
			PopUserOrder order = new PopUserOrder();
			order.setType(popUserTypeEnum);
			order.setUserId(userId);
			order.setPopId(NumberUtil.parseLong(popId));
			order.setRawAddTime(new Date());
			result = popUserService.insertPopUser(order);
		}
		if (result.isSuccess()) {
			successResult(json, title + "提交成功");
		} else {
			failResult(json, result.getMessage());
		}
		
	}
	
	/** 帮助中心分类 */
	protected void helpType(HttpServletRequest request, JSONObject json, String string) {
		QueryBaseBatchResult<PopModuleVOInfo> baseResult = popModuleService
			.getOnlineModulesForHelp();
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (PopModuleVOInfo info : baseResult.getPageList()) {
			map = new HashMap<>();
			map.put("moduleId", toString(info.getModuleId()));
			map.put("moduleName", info.getModuleName());
			list.add(map);
		}
		json.put("list", list);
		successResult(json, "帮助类型查询成功");
	}
	
	/** 帮助中心 */
	protected void helpList(HttpServletRequest request, JSONObject json, String string) {
		
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		
		PageParam pageParam = new PageParam();
		pageParam.setPageNo(NumberUtil.parseInt(pageNumber, 1));
		pageParam.setPageSize(NumberUtil.parseInt(pageSize, 10));
		QueryBaseBatchResult<PopInfo> baseResult = popService.getHelpListByConditionsNew(pageParam);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (PopInfo info : baseResult.getPageList()) {
			map = new HashMap<>();
			AppCommonUtil.beanToMap(info, map);
			map.remove("scenicInfo");
			list.add(map);
		}
		json.put("list", list);
		json.put("totalPage", baseResult.getPageCount());
		successResult(json, "帮助中心列表查询成功");
	}
	
	/** 旅游攻略、帮助中心详情 */
	protected void infoDetail(HttpServletRequest request, JSONObject json, String string) {
		String popId = request.getParameter("popId");
		if (StringUtil.isBlank(popId)) {
			failResult(json, "查询Id不能为空");
			return;
		}
		PopInfo info = popService.getByPopIdContainScenic(Long.parseLong(popId));
		Map<String, String> map = AppCommonUtil.beanToMap(info);
		StringBuffer content = new StringBuffer();
		StringBuffer contentText = new StringBuffer(info.getContent());
		content.append(contentText);
		map.put("content", content.toString());
		map.put("detail", info.getScenicInfo().getDetail());
		map.remove("scenicInfo");
		json.put("info", map);
		successResult(json, "详情查询成功");
	}
	
	/** 真美美简介 */
	protected void summary(HttpServletRequest request, JSONObject json, String string) {
		PopInfo info = popService.getSummary();
		if (info != null) {
			Map<String, String> map = new HashMap<>();
			map.put("title", info.getTitle());
			map.put("content", info.getContent());
			json.put("info", map);
			successResult(json, "查询成功");
		} else {
			failResult(json, "暂无简介");
		}
	}
	
	/** 意见反馈 */
	protected void feebackOption(HttpServletRequest request, JSONObject json, String string) {
		FeebackOptionInfo feebackInfo = new FeebackOptionInfo();
		WebUtil.setPoPropertyByRequest(feebackInfo, request);
		if (StringUtils.isBlank(feebackInfo.getOptions())) {
			failResult(json, "反馈内容不能为空");
		}
		EsupplierBaseResult result = feebackOptionService.saveFeebackOption(feebackInfo);
		if (result.isSuccess()) {
			successResult(json, "意见提交成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 验证用户名是否存在
	 *
	 * @param
	 */
	protected void verifyUser(	HttpServletRequest request, JSONObject json,
								String des) throws Exception {
		String userName = request.getParameter("userName");
		if (StringUtil.isBlank(userName)) {
			failResult(json, "用户名不能为空");
			return;
		}
		EsupplierBaseResult queryResult = userBaseInfoManager.validationUserName(userName);
		if (queryResult.isSuccess()) {
			successResult(json, "用户名可用");
		} else {
			failResult(json, "用户名存在");
		}
	}
	
	/**
	 * 注册提交
	 *
	 * @param @短信验证码
	 *
	 */
	protected void registerSubmit(	HttpServletRequest request, HttpSession session, JSONObject json,
									String des) throws Exception {
		
		InvestorRegisterOrder investorRegisterOrder = new InvestorRegisterOrder();
		WebUtil.setPoPropertyByRequest(investorRegisterOrder, request);
		try {
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(
				investorRegisterOrder.getMobile(), SmsBizType.REGISTER,
				request.getParameter("code"), true);
			if (!smsCodeResult.isSuccess()) {
				failResult(json, smsCodeResult.getMessage());
				return;
			}
			investorRegisterOrder.setMobileBinding(BooleanEnum.IS.code());
		} catch (NullPointerException e) {
			failResult(json, "未获取短信验证码");
			return;
		}
		String imgCode = request.getParameter("imgCode");
		if (!Image.checkImgCode(session, imgCode)) {
			failResult(json, "图片验证码错误");
			return;
		}
		LoginFromTypeEnum loginFromTypeEnum = LoginFromTypeEnum
			.getByCode(investorRegisterOrder.getLoginFromType());
		if (loginFromTypeEnum == null) {
			loginFromTypeEnum = LoginFromTypeEnum.APP_USER;
		}
		String password = investorRegisterOrder.getLogPassword();
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			password = AESUtil.decode(password);
		}
		investorRegisterOrder.setAppRegisterFrom(AppCommonUtil.getRegistFromByRequest(request));
		investorRegisterOrder.setLogPassword(password);
		UserRegisterResult registerResult = registerService.investorRegister(investorRegisterOrder);
		if (registerResult.isSuccess()) {
			json.clear();
			if (registerResult.isGiftMoneySuccess()) {
				json.put("giftMoney", 1);
				json.put("giftMoneyMessage", registerResult.getGiftMoneyMessage());
			} else {
				json.put("giftMoney", 0);
				json.put("giftMoneyMessage", "无优惠券信息");
			}
			successResult(json, "注册成功");
			UserLoginOrder order = new UserLoginOrder();
			order.setUserName(investorRegisterOrder.getUserName());
			order.setPassword("注册成功后信任登陆");
			order.setIpAddress(IPUtil.getIpAddr(request));
			order.setLoginFromTypeEnum(loginFromTypeEnum);
			LoginResult loginResult = loginService.loginOtherToLogin(order);
			logger.info("注册成功后创建登陆状态:loginResult={}", loginResult);
		} else {
			failResult(json,
				StringUtil.isNotBlank(registerResult.getMessage())
								&& registerResult.getMessage().indexOf("数据库") > -1 ? "系统繁忙,稍后重试！"
									: registerResult.getMessage());
			
		}
		
	}
	
	protected void weixin(	HttpServletRequest request, HttpSession session,
							HttpServletResponse response, JSONObject json,
							String string) throws IOException {
		if (ShiroSessionUtils.isLogin()) {
			EsupplierBaseResult baseResult = userWeixinService
				.findByUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			if (baseResult.isSuccess()) {
				successResult(json, "账号已绑定微信！");
			} else {
				Oauth2Servlet.toWeChat(request, response);
			}
		} else {
			Oauth2Servlet.toWeChat(request, response);
		}
	}
	
	protected void weixinLogin(	HttpServletRequest request, HttpSession session,
								HttpServletResponse response, JSONObject json,
								String string) throws IOException {
		
		String code = request.getParameter("code");
		if (com.yjf.esupplier.common.util.StringUtil.isEmpty(code)) {
			failResult(json, "未授权登陆");
		}
		try {
			Map<String, Object> openIdMap = Oauth2Servlet.getOpenIdByCode(request, response);
			UserWeixinQueryResult userWeixinQueryResult = userWeixinService
				.findByOpenId((String) openIdMap.get("openid"));
			//			 已绑定账号，则自动登录。未绑定则判断登录状态，已登录则绑定账号，未登录则不处理
			/** 已绑定 */
			if (userWeixinQueryResult.isSuccess()) {
				UserQueryResult userQueryResult = userQueryService
					.queryByUserId(userWeixinQueryResult.getQueryUserWeixinInfo().getUserId());
				if (userQueryResult.isSuccess()) {
					LoginData loginData = new LoginData();
					loginData.setLoginFromTypeEnum(LoginFromTypeEnum.WEIXIN_USER);
					loginData.setUsername(userQueryResult.getQueryUserInfo().getUserName());
					loginData.setIpAddress(IPUtil.getIpAddr(request));
					if (ShiroSessionUtils.isLogin()) {
						Cart cart = WebSessionUtil.getStaticCurrentCart();
						cart.clear();
					}
					LoginResult loginResult = loginService.login(loginData);
					if (loginResult.isSuccess() && loginResult
						.getCreditsysResultEnum() == EsupplierResultEnum.EXECUTE_SUCCESS) {
						if (loginResult.getUserInfo() != null) {
							json.put("userId", loginResult.getUserInfo().getUserId());
							json.put("realName", loginResult.getUserInfo().getRealName());
							json.put("userType", loginResult.getUserInfo().getType());
							successResult(json, "微信账号已绑定,自动登录成功");
							initShopCart(loginResult.getUserInfo());
						} else {
							failResult(json, loginResult.getMessage());
						}
					} else {
						failResult(json, loginResult.getMessage());
					}
				}
			} else {
				/** 已登录 */
				if (ShiroSessionUtils.isLogin()) {
					UserWeixinOrder weixinOrder = new UserWeixinOrder();
					weixinOrder.setOpenId((String) openIdMap.get("openid"));
					weixinOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
					EsupplierBaseResult baseResult = userWeixinService.bindWeixin(weixinOrder);
					if (baseResult.isSuccess()) {
						successResult(json, "绑定微信账号成功");
					} else {
						failResult(json, baseResult.getMessage());
					}
				} else {
					failResult(json, "未登录，不能绑定账号！");
				}
			}
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/** 退出登录 */
	protected void logOut(HttpServletRequest request, JSONObject json, String string) {
		Subject subject = SecurityUtils.getSubject();
		try {
			if (null != subject) {
				UserWeixinQueryResult weixinQueryResult = userWeixinService
					.findByUserId(ShiroSessionUtils.getSessionLocal().getUserId());
				if (weixinQueryResult.isSuccess()) {
					/** 解除微信账号绑定 */
					UserWeixinOrder weixinOrder = new UserWeixinOrder();
					weixinOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
					EsupplierBaseResult baseResult = userWeixinService.unbindWeixin(weixinOrder);
					if (baseResult.isSuccess()) {
						logger.info("微信账号解绑成功");
					} else {
						successResult(json, baseResult.getMessage());
					}
				}
				ShiroSessionUtils.clear();
				subject.logout();
			}
			request.getSession().invalidate();
			successResult(json, "退出登录成功");
		} catch (Exception e) {
			logger.error("登出报错", e);
			successResult(json, "退出登录出现异常");
		}
	}
	
	/** 登录 */
	protected void doLogin(	HttpServletRequest request, JSONObject json,
							String des) throws Exception {
		String passWord = request.getParameter("passWord");
		String userName = request.getParameter("userName");
		String loginFromType = request.getParameter("loginFromType");
		String equipmentNo = request.getParameter("equipmentNo");
		String equipmentCardNo = request.getParameter("equipmentCardNo");
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			passWord = AESUtil.decode(AppCommonUtil.decodeCheck(passWord));
		}
		if (StringUtil.isNotEmpty(equipmentCardNo)) {
			equipmentCardNo = AESUtil.decode(AppCommonUtil.decodeCheck(equipmentCardNo));
		}
		LoginFromTypeEnum loginFromTypeEnum = LoginFromTypeEnum.getByCode(loginFromType);
		if (loginFromTypeEnum == null) {
			loginFromTypeEnum = LoginFromTypeEnum.APP_USER;
		}
		LoginData loginDate = new LoginData();
		loginDate.setLoginFromTypeEnum(loginFromTypeEnum);
		loginDate.setUsername(userName);
		loginDate.setPassword(passWord);
		loginDate.setIpAddress(IPUtil.getIpAddr(request));
		LoginResult loginResult = loginService.login(loginDate);
		if (loginResult.isSuccess()
			&& loginResult.getCreditsysResultEnum() == EsupplierResultEnum.EXECUTE_SUCCESS) {
			if (loginResult.getUserInfo() != null) {
				json.put("userId", loginResult.getUserInfo().getUserId());
				json.put("realName", loginResult.getUserInfo().getRealName());
				json.put("userType", loginResult.getUserInfo().getType());
				successResult(json, "登录成功");
				if (StringUtil.isNotBlank(equipmentNo)) {
					EquipmentLoginOrder equipmentLoginOrder = new EquipmentLoginOrder();
					equipmentLoginOrder.setEquipmentNo(equipmentNo);
					equipmentLoginOrder.setUserId(loginResult.getUserInfo().getUserId());
					equipmentLoginOrder.setUserName(userName);
					equipmentLoginOrder.setEquipmentCardNo(equipmentCardNo);
					equipmentLoginService.updateLoginInfo(equipmentLoginOrder);
				}
				initShopCart(loginResult.getUserInfo());
			} else {
				failResult(json, loginResult.getMessage());
			}
			
		} else {
			failResult(json, loginResult.getMessage());
		}
	}
	
	/** 手机号码快捷登录 */
	protected void quickLogin(	HttpServletRequest request, HttpSession session, JSONObject json,
								String string) {
		
		String mobile = request.getParameter("mobile");
		String code = request.getParameter("code");
		String loginFromType = request.getParameter("loginFromType");
		String equipmentNo = request.getParameter("equipmentNo");
		try {
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(mobile, SmsBizType.LOGIN,
				code, true);
			if (!smsCodeResult.isSuccess()) {
				failResult(json, smsCodeResult.getMessage());
				return;
			}
		} catch (NullPointerException e) {
			failResult(json, "未获取短信验证码");
			return;
		}
		LoginFromTypeEnum loginFromTypeEnum = LoginFromTypeEnum.getByCode(loginFromType);
		if (loginFromTypeEnum == null) {
			loginFromTypeEnum = LoginFromTypeEnum.APP_USER;
		}
		QuickInvestorRegisterOrder quickInvestorRegisterOrder = new QuickInvestorRegisterOrder();
		quickInvestorRegisterOrder.setIpAddress(IPUtil.getIpAddr(request));
		quickInvestorRegisterOrder.setLoginMethodEnum(LoginMethodEnum.FAST);
		quickInvestorRegisterOrder.setRealName(mobile);
		quickInvestorRegisterOrder.setMobile(mobile);
		quickInvestorRegisterOrder.setLoginFromTypeEnum(loginFromTypeEnum);
		quickInvestorRegisterOrder.setEquipmentNo(equipmentNo);
		quickInvestorRegisterOrder.setLogPassword(String.valueOf(UUID.randomUUID()));
		quickInvestorRegisterOrder.setMailBinding(BooleanEnum.NO.code());
		quickInvestorRegisterOrder.setMobileBinding(BooleanEnum.IS.code());
		quickInvestorRegisterOrder
			.setAppRegisterFrom(AppCommonUtil.getRegistFromByRequest(request));
		LoginResult loginResult = loginService.fastLogin(quickInvestorRegisterOrder);
		if (loginResult.isExecuted()) {
			Map<String, String> map = new HashMap<String, String>();
			if (!loginResult.isExist()) {
				String changePwd = MD5Util
					.encodeByMD5(ShiroSessionUtils.getSessionLocal().getUserBaseId());
				map.put("setPwd", "1");
				map.put("changePwd", changePwd);
				session.setAttribute("changePwd", changePwd);
			} else {
				map.put("setPwd", "0");
				map.put("changePwd", "");
			}
			json.put("info", map);
			successResult(json, "登录成功");
			if (StringUtil.isNotBlank(equipmentNo)) {
				EquipmentLoginOrder equipmentLoginOrder = new EquipmentLoginOrder();
				equipmentLoginOrder.setEquipmentNo(equipmentNo);
				equipmentLoginOrder.setUserId(loginResult.getUserInfo().getUserId());
				equipmentLoginOrder.setUserName(mobile);
				equipmentLoginService.updateLoginInfo(equipmentLoginOrder);
			}
		} else {
			failResult(json, "登录失败");
		}
		
	}
	
	/** 快捷登陆设置登录密码 */
	protected void setPwd(	HttpServletRequest request, HttpSession session, JSONObject json,
							String string) {
		String password = request.getParameter("password");
		if (StringUtil.isBlank(password)) {
			failResult(json, "登陆密码不能为空！");
			return;
		}
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			password = AESUtil.decode(password);
		}
		String changePwd = request.getParameter("changePwd");
		String SessionChangePwd = (String) session.getAttribute("changePwd");
		if (StringUtil.isNotBlank(changePwd) && StringUtil.equals(changePwd, SessionChangePwd)) {
			EsupplierBaseResult baseResult = userBaseInfoManager
				.forgetPassword(ShiroSessionUtils.getSessionLocal().getUserBaseId(), password);
			if (baseResult.isSuccess()) {
				successResult(json, "密码设置成功");
			} else {
				failResult(json, baseResult.getMessage());
			}
		} else {
			failResult(json, "修改权限验证失败");
		}
		
	}
	
	/** 忘记密码，验证用户名 */
	protected void forgetLoginPwd(	HttpServletRequest request, HttpSession session, JSONObject json,
									String des) throws Exception {
		
		String userName = request.getParameter("userName");
		UserQueryResult baseResult = userQueryService.queryUserLogin(userName);
		if (baseResult.getQueryUserInfo() != null) {
			if ("IS".equals(baseResult.getQueryUserInfo().getMobileBinding().code())) {
				try {
					SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
					sessionLocal.setSessionMobileSend(null);
					ShiroSessionUtils.setSessionLocal(sessionLocal);
				} catch (NullPointerException e) {
					logger.info("忘记密码提交用户名时清除session中的SmsCode");
				}
				session.setAttribute("mobile", baseResult.getQueryUserInfo().getMobile());
				session.setAttribute("userBaseId", baseResult.getQueryUserInfo().getUserBaseId());
				session.setAttribute("userName", baseResult.getQueryUserInfo().getUserName());
				json.put("mobile", baseResult.getQueryUserInfo().getMobile());
				successResult(json, "获取电话号码成功");
			} else {
				failResult(json, "当前用户未绑定手机号码");
			}
			
		} else {
			failResult(json, "用户不存在");
		}
		
	}
	
	/**
	 * 忘记密码-提交新密码
	 */
	protected void forgetLoginPwdSub(	HttpServletRequest request, HttpSession session,
										JSONObject json, String des) throws Exception {
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		try {
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(
				(String) session.getAttribute("mobile"), SmsBizType.ForgetLoginPassWord,
				request.getParameter("code"), true);
			if (smsCodeResult.isSuccess()) {
				String newPassword = request.getParameter("newPassword");
				if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
					newPassword = AESUtil.decode(newPassword);
				}
				baseResult = userBaseInfoManager
					.forgetPassword((String) session.getAttribute("userBaseId"), newPassword);
			} else {
				failResult(json, "短信验证码错误");
				return;
			}
		} catch (NullPointerException e) {
			failResult(json, "请获取短信验证码");
			return;
		}
		if (baseResult.isSuccess()) {
			successResult(json, "设置新密码成功");
		} else {
			failResult(json, "忘记密码：设置新密码失败:" + baseResult.getMessage());
		}
		json.put("user", session.getAttribute("userName"));
		session.removeAttribute("mobile");
		session.removeAttribute("userBaseId");
		session.removeAttribute("userName");
		
	}
	
	/**
	 * 忘记密码-提交新密码
	 */
	protected void forgetLoginPwdByEmail(	HttpServletRequest request, HttpSession session,
											JSONObject json, String des) throws Exception {
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		try {
			EmailCodeResult smsCodeResult = smsEmailManagerService.verifyEmailCode(
				(String) session.getAttribute("email"), SmsBizType.ForgetLoginPassWord,
				request.getParameter("code"), true);
			if (smsCodeResult.isSuccess()) {
				String newPassword = request.getParameter("newPassword");
				if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
					newPassword = AESUtil.decode(newPassword);
				}
				baseResult = userBaseInfoManager
					.forgetPassword((String) session.getAttribute("userBaseId"), newPassword);
			} else {
				failResult(json, "验证码错误");
				return;
			}
		} catch (NullPointerException e) {
			failResult(json, "请获取验证码");
			return;
		}
		if (baseResult.isSuccess()) {
			successResult(json, "设置新密码成功");
		} else {
			failResult(json, "忘记密码：设置新密码失败:" + baseResult.getMessage());
		}
		json.put("user", session.getAttribute("userName"));
		session.removeAttribute("email");
		session.removeAttribute("userBaseId");
		session.removeAttribute("userName");
		
	}
	
	/** 修改登陆密码 */
	protected void appChangePwd(HttpServletRequest request, JSONObject json,
								String des) throws Exception {
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		String passwords = request.getParameter("password");
		String newPasswords = request.getParameter("newPassword");
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			passwords = AESUtil.decode(passwords);
			newPasswords = AESUtil.decode(newPasswords);
		}
		if (StringUtil.isNotEmpty(passwords) && StringUtil.isNotEmpty(newPasswords)) {
			PwdInfoOrder pwdInfoOrder = new PwdInfoOrder();
			pwdInfoOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			pwdInfoOrder.setPasswdType(PasswordTypeEnum.LOGIN_PASSWORD);
			pwdInfoOrder.setOldPwd(passwords);
			pwdInfoOrder.setNewPwd(newPasswords);
			returnEnum = userBaseInfoManager.updateUserPassword(pwdInfoOrder);
		} else {
			failResult(json, "对密码格式验证后再提交吧！");
			return;
		}
		if (returnEnum.isSuccess()) {
			successResult(json, "修改密码成功，请重新登录");
		} else if (returnEnum.getCreditsysResultEnum() == EsupplierResultEnum.PASSWORD_ERROR) {
			failResult(json, "旧密码输入不正确");
		} else {
			failResult(json, returnEnum.getMessage());
		}
	}
	
	/** 修改支付密码 */
	protected void changePayPwd(HttpServletRequest request, JSONObject json, String string) {
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		String passwords = request.getParameter("password");
		String newPasswords = request.getParameter("newPassword");
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			passwords = AESUtil.decode(passwords);
			newPasswords = AESUtil.decode(newPasswords);
		}
		if (StringUtil.isEmpty(passwords))
			passwords = "";
		if (StringUtil.isNotEmpty(newPasswords)) {
			PwdInfoOrder pwdInfoOrder = new PwdInfoOrder();
			pwdInfoOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			pwdInfoOrder.setPasswdType(PasswordTypeEnum.PAY_PASSWORD);
			pwdInfoOrder.setOldPwd(passwords);
			pwdInfoOrder.setNewPwd(newPasswords);
			returnEnum = userBaseInfoManager.updateUserPassword(pwdInfoOrder);
		} else {
			failResult(json, "对密码格式验证后再提交吧！");
			return;
		}
		if (returnEnum.isSuccess()) {
			if (StringUtil.isEmpty(passwords)) {
				successResult(json, "设置支付密码成功");
			} else {
				successResult(json, "修改支付密码成功");
			}
		} else if (returnEnum.getCreditsysResultEnum() == EsupplierResultEnum.PASSWORD_ERROR) {
			failResult(json, "旧密码输入不正确");
		} else {
			failResult(json, returnEnum.getMessage());
		}
	}
	
	/** 校验邮箱发送密码链接 */
	protected void checkMail(HttpServletRequest request, JSONObject json, String string) {
		String email = request.getParameter("email");
		if (StringUtil.isBlank(email)) {
			failResult(json, "邮箱不能为空");
			return;
		}
		if (ShiroSessionUtils.getSessionLocal().getUserInfo() == null) {
			failResult(json, "请重新登录");
			return;
		}
		String userEmail = ShiroSessionUtils.getSessionLocal().getUserInfo().getMail();
		String realName = ShiroSessionUtils.getSessionLocal().getUserInfo().getRealName();
		if (!userEmail.equals(email)) {
			failResult(json, "邮箱输入不正确");
			return;
		}
		
		EsupplierBaseResult result = smsEmailManagerService.sendEmail(userEmail, realName,
			SmsBizType.ForgetLoginPassWord);
		if (!result.isSuccess()) {
			failResult(json, result.getMessage());
			return;
		} else {
			successResult(json, result.getMessage());
		}
		
	}
	
	/** 忘记支付密码 */
	protected void forgetPayPwd(HttpServletRequest request, JSONObject json, String string) {
		String payPassword = request.getParameter("payPassword");
		if (StringUtil.isBlank(payPassword)) {
			failResult(json, "支付密码不能为空");
			return;
		}
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		try {
			SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(
				ShiroSessionUtils.getSessionLocal().getSessionMobileSend().getMoblie(),
				SmsBizType.ForgetPayPassWord, request.getParameter("code"), true);
			if (smsCodeResult.isSuccess()) {
				if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
					payPassword = AESUtil.decode(payPassword);
				}
				baseResult = userBaseInfoManager.forgetPayPassword(
					ShiroSessionUtils.getSessionLocal().getUserBaseId(), payPassword);
				if (baseResult.isSuccess()) {
					successResult(json, "修改成功");
				} else {
					failResult(json, baseResult.getMessage());
				}
			} else {
				failResult(json, "短信验证码错误");
				return;
			}
		} catch (NullPointerException e) {
			failResult(json, "请获取短信验证码");
			return;
		}
	}
	
	/**
	 * 修改手机号码-验证原手机号 type=cellphone v
	 *
	 * @param
	 * @Param newPhone
	 */
	protected void appChangeMobile(	HttpServletRequest request, HttpSession session, JSONObject json,
									String des) throws Exception {
		
		String code = request.getParameter("code");
		UserQueryResult baseResult = userQueryService
			.queryByUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(
			baseResult.getQueryUserInfo().getMobile(), SmsBizType.CELLPHONE, code, true);
		if (smsCodeResult.isSuccess()) {
			successResult(json, "旧手机号校验成功");
			json.put("md5UserBaseId",
				AppCommonUtil.getMD5(session, ShiroSessionUtils.getSessionLocal().getUserBaseId()));
			
		} else {
			failResult(json, smsCodeResult.getMessage());
		}
		
	}
	
	/**
	 * 19.修改手机号 type=cellphone v
	 */
	protected void appChangeToNewPhone(	HttpServletRequest request, HttpSession session,
										JSONObject json, String des) throws Exception {
		String newMobile = request.getParameter("newMobile");
		SmsCodeResult smsCodeResult = smsManagerService.verifySmsCode(newMobile,
			SmsBizType.NEWCELLPHONE, request.getParameter("code"), true);
		if (!smsCodeResult.isSuccess()) {
			failResult(json, "验证码校验失败");
			return;
		}
		if (!AppCommonUtil.checkMD5(session, request.getParameter("md5UserBaseId"))) {
			failResult(json, "md5UserBaseId错误");
			return;
		}
		MobileBindingOrder mobileBindingOrder = new MobileBindingOrder();
		mobileBindingOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		mobileBindingOrder.setMobile(newMobile);
		EsupplierBaseResult result = userBaseInfoManager.mobileBinding(mobileBindingOrder);
		if (result.isSuccess()) {
			successResult(json, "修改绑定手机成功");
		} else {
			failResult(json, result.getMessage());
		}
		
	}
	
	/** 获取用户基本信息 */
	protected void userInfo(HttpServletRequest request, JSONObject json, String des) {
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		String seeMoney = request.getParameter("seeMoney");
		boolean canSeeMoney = StringUtil.defaultIfEmpty(seeMoney, "NO").equals("YES");
		UserBizTypeEnum userBizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		UserQueryResult result = userQueryService.queryByUserId(userId);
		Map<String, String> map = new HashMap<String, String>();
		AppCommonUtil.beanToMap(result.getQueryUserInfo(), map);
		map.put("userName", result.getQueryUserInfo().getOriginalUserName());
		OrderFlowStatusCountInfo orderCountInfo = orderQueryService.loadOrderStausCount(userId);
		AppCommonUtil.beanToMap(orderCountInfo, map);
		UserAccountDataInfo accountDataInfo = userAccountDataQueryService
			.getUserAccountDataInfo(userId, canSeeMoney);
		/*用户余额*/
		if (canSeeMoney) {
			map.put("amount", accountDataInfo.getUserBalance().toStandardString());
		} else {
			map.put("amount", "0");
			map.put("cardUseState", "");
		}
		/*红包*/
		//map.put("giftCount", accountDataInfo.getUserGiftAmount().toStandardString());
		map.put("giftCount", count(userId, GiftMoneyTypeEnum.GIFT_MONEY.code()));
		/*用户优惠券张数*/
		//map.put("gainCount", String.valueOf(accountDataInfo.getUserCouponCount()));
		map.put("gainCount", count(userId, GiftMoneyTypeEnum.GAIN_AMOUNT.code()));
		/*积分*/
		map.put("userIntegral", String.valueOf(accountDataInfo.getUserIntegral()));
		/*商户等级*/
		if (userBizTypeEnum == UserBizTypeEnum.SELLER) {
			SupplierInfo supplierInfo = supplierService.getSupplier(userId);
			map.put("userLevel", supplierInfo == null ? ""
				: StringUtil.defaultIfEmpty(supplierInfo.getShopGrade(), ""));
			if (supplierInfo.getOrderMeal() != null) {
				map.put("orderMeal", supplierInfo.getOrderMeal().code());
			} else {
				map.put("orderMeal", BooleanEnum.NO.code());
			}
			if (supplierInfo.getDiningRunState() != null) {
				map.put("runState", supplierInfo.getDiningRunState().code());
			}
			map.put("tableNumber", toString(supplierInfo.getTableNumber()));
			map.put("hotels",
				supplierInfo.getHotels() == null ? "NO" : supplierInfo.getHotels().getCode());
		} else {/*用户等级*/
			UserLevelEnum userLevelEnum = result.getQueryUserInfo().getUserLevel();
			map.put("userLevel", String.valueOf(userLevelEnum.getCode()));
			List<UserLevelRuleInfo> levelNowRuleInfos = userLevelQueryService
				.getUserLevelRulesByUserLevel(userLevelEnum);
			/* 当前等级最大广行值*/
			if (levelNowRuleInfos.size() > 0) {
				map.put("userLevelMax",
					String.valueOf(levelNowRuleInfos.get(0).getPointEndValue()
									/ ConfigParamProperty.getgGrowthValueCoefficient()));
			} else {
				map.put("userLevelMax", "");
			}
			/*下一等级*/
			List<UserLevelRuleInfo> levelNextRuleInfos = userLevelQueryService
				.getUserLevelRulesByUserLevel(
					UserLevelEnum.getByLevel(userLevelEnum.getLevel() + 1));
			if (levelNextRuleInfos.size() > 0) {
				long nextDays = NumberUtil.parseLong(levelNextRuleInfos.get(0).getRuleTypeParam1());
				long nowTradeDay = accountDataInfo.getUserTradeDay();
				long syDay = nextDays > nowTradeDay ? nextDays - nowTradeDay : 0;
				map.put("userLevelDayNum", String.valueOf(syDay));
			} else {
				map.put("userLevelDayNum", "0");
			}
		}
		/*积分成长值*/
		map.put("userGrowthValue",
			NumberUtil.formatDouble(accountDataInfo.getViewUserGrowthValue()));
		map.put("jfen", "0");// TODO 无功能，默认0
		map.remove("userBaseId");
		// map.remove("userId");
		map.remove("logPassword");
		map.remove("payPassword");
		map.remove("rowAddTime");
		map.remove("accountId");
		map.remove("rowUpdateTime");
		map.put("hasPayPassword",
			result.getQueryUserInfo().getPayPassword()
				.equalsIgnoreCase(com.yjf.esupplier.common.util.MD5Util.getMD5_32(""))
					? BooleanEnum.NO.getCode() : BooleanEnum.YES.getCode());
		json.put("info", map);
		successResult(json, "获取用户基本信息成功");
	}
	
	/** 统计红包或优惠券个数 */
	private String count(long userId, String type) {
		long count = 0;
		List<String> typeList = new ArrayList<String>();
		if (StringUtil.equals("GIFT_MONEY", type)) {
			typeList.add(GiftMoneyTypeEnum.GIFT_MONEY.getCode());
		} else if (StringUtil.equals("GAIN_AMOUNT", type)) {
			typeList.add(GiftMoneyTypeEnum.GAIN_AMOUNT.getCode());
		}
		List<String> statusList = new ArrayList<String>();
		statusList.add("FINISH");
		statusList.add("NORMAL");
		statusList.add("EXPIRE");
		GiftMoneyTradeQueryOrder demandQueryOrder = new GiftMoneyTradeQueryOrder();
		demandQueryOrder.setPageSize(1);
		demandQueryOrder.setUserid(userId);
		demandQueryOrder.setTypeList(typeList);
		// demandQueryOrder.setStatus("NORMAL");
		demandQueryOrder.setStatusList(statusList);
		QueryBaseBatchResult<GiftMoneyTradeInfo> result = giftMoneyTradeQueryService
			.queryGiftMoneyTradeNum(demandQueryOrder);
		if (result.isSuccess()) {
			count = result.getTotalCount();
		}
		return String.valueOf(count);
	}
	
	/** 修改用户基本信息 */
	protected void updateUserInfo(HttpServletRequest request, JSONObject json, String des) {
		
		String userName = request.getParameter("userName");
		String userCustomType2 = request.getParameter("userCustomType2");
		if (StringUtil.isNotBlank(userName)) {
			AddUserNameLoginOrder nameLoginOrder = new AddUserNameLoginOrder();
			nameLoginOrder.setUserName(userName);
			nameLoginOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
			EsupplierBaseResult result = userBaseInfoManager.setUserName(nameLoginOrder);
			if (result.isSuccess()) {
				successResult(json, "修改用户名成功");
				if (StringUtil.isBlank(ShiroSessionUtils.getSessionLocal().getNickname())) {
					ShiroSessionUtils.getSessionLocal().setNickname(userName);
				}
				return;
			} else {
				failResult(json, result.getMessage());
				return;
			}
		} else if (StringUtil.isNotBlank(userCustomType2)) {
			EsupplierBaseResult result = userBaseInfoManager.updateUserName(
				String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId()), userCustomType2);
			if (result.isSuccess()) {
				successResult(json, "修改会员信息成功");
			} else {
				failResult(json, "修改会员信息失败");
			}
			return;
		} else {
			failResult(json, "修改信息不能为空");
		}
		
	}
	
	/** 收货地址列表 */
	protected void addressesList(HttpServletRequest request, JSONObject json, String des) {
		List<DrawerAddressInfo> addressesInfos = orderService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		for (DrawerAddressInfo info : addressesInfos) {
			map = new HashMap<>();
			AppCommonUtil.beanToMap(info, map);
			list.add(map);
		}
		successResult(json, "收货地址查询成功");
		json.put("list", list);
	}
	
	/** 增加/修改收货地址 */
	protected void saveAddress(HttpServletRequest request, JSONObject json, String des) {
		DrawerAddressSaveOrder order = new DrawerAddressSaveOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setAreaCode(order.getProvince() + order.getCity());
		order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		/** 一个用户只能有一个默认收货地址 */
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		List<DrawerAddressInfo> addressesInfos = orderService
			.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
		if (StringUtil.equals("Y", request.getParameter("setDefaultAddress"))) {
			if (addressesInfos.size() > 0) {
				for (DrawerAddressInfo addressInfo : addressesInfos) {
					if (StringUtil.isNotEmpty(addressInfo.getDefaultAddress())
						&& addressInfo.getDefaultAddress().equals("Y")) {
						DrawerAddressSaveOrder orders = new DrawerAddressSaveOrder();
						BeanCopier.staticCopy(addressInfo, orders);
						orders.setIsDefault("N");
						baseResult = orderService.updateDrawerAddress(orders);
						if (!baseResult.isSuccess()) {
							failResult(json, baseResult.getMessage());
							return;
						}
						break;
					}
				}
			}
			order.setIsDefault("Y");
		} else {
			order.setIsDefault("N");
		}
		/*第一个默认是默认地址*/
		if (addressesInfos.size() == 0) {
			order.setIsDefault("Y");
		}
		
		if (StringUtil.isNotBlank(order.getId())) {
			baseResult = orderService.updateDrawerAddress(order);
		} else {
			/*返回order 需要ID值*/
			order.setId(String.valueOf(dateSeqService.getNextSeqNumber(SeqNameEnum.ADDRESS_SEQ)));
			baseResult = orderService.saveDrawerAddress(order);
		}
		if (baseResult.isSuccess()) {
			Map<String, String> map = new HashMap<>();
			AppCommonUtil.beanToMap(order, map);
			json.put("info", AppCommonUtil.cleanNull(map));
			successResult(json, "增加/修改收货地址成功");
		} else {
			failResult(json, baseResult.getMessage());
		}
		
	}
	
	/** 删除收货地址 */
	protected void deletAddress(HttpServletRequest request, JSONObject json, String des) {
		try {
			String id = request.getParameter("id");
			orderService.deleteAddressById(id);
			List<DrawerAddressInfo> addressesInfos = orderService
				.getAddresses(ShiroSessionUtils.getSessionLocal().getUserId());
			if (addressesInfos.size() > 0) {
				boolean haveDefault = false;
				for (DrawerAddressInfo addressInfo : addressesInfos) {
					if (StringUtil.isNotEmpty(addressInfo.getDefaultAddress())
						&& addressInfo.getDefaultAddress().equals("Y")) {
						haveDefault = true;
						break;
					}
				}
				if (!haveDefault) {
					DrawerAddressSaveOrder orders = new DrawerAddressSaveOrder();
					BeanCopier.staticCopy(addressesInfos.get(0), orders);
					orders.setIsDefault("Y");
					orderService.updateDrawerAddress(orders);
				}
			}
			successResult(json, "删除收货地址成功");
		} catch (Exception e) {
			failResult(json, "删除失败");
			logger.error("删除收货地址出现异常", e);
		}
		
	}
	
	/** 设置默认收货地址 */
	protected void setDefaultAddress(HttpServletRequest request, JSONObject json, String string) {
		String id = request.getParameter("id");
		if (StringUtil.isBlank(id)) {
			failResult(json, "收货人不能为空");
			return;
		}
		EsupplierBaseResult result = orderService.setDefaultAddress(id);
		if (result.isSuccess()) {
			successResult(json, "设置成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 默认用餐地址列表 */
	protected void defaultAddressesList(HttpServletRequest request, JSONObject json, String des) {
		SearchOrderMealAddressOrder order = new SearchOrderMealAddressOrder();
		List<Long> choseList = new ArrayList<>();
		order.setChoseList(choseList);
		order.setDefaultAddressId(0);
		WebUtil.setPoPropertyByRequest(order, request);
		order.setStoreName(null);
		QueryBaseBatchResult<SupplierInfo> baseBatchResult = supplierService
			.searchOrderMealAddress(order);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		for (SupplierInfo info : baseBatchResult.getPageList()) {
			map = new HashMap<>();
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("address", info.getAddress());
			map.put("storeName", info.getStoreName());
			map.put("nickName", info.getNickname());
			if (info.getSupplierId() == order.getDefaultAddressId()) {
				map.put("default", "Y");
			} else {
				map.put("default", "N");
			}
			list.add(map);
		}
		successResult(json, " 默认用餐地址查询成功");
		json.put("list", list);
	}
	
	/** 用餐地址列表 */
	protected void searchAddressesList(HttpServletRequest request, JSONObject json, String des) {
		SearchOrderMealAddressOrder order = new SearchOrderMealAddressOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		QueryBaseBatchResult<SupplierInfo> baseBatchResult = supplierService
			.searchOrderMealAddress(order);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		for (SupplierInfo info : baseBatchResult.getPageList()) {
			map = new HashMap<>();
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("address", info.getAddress());
			map.put("storeName", info.getStoreName());
			map.put("nickName", info.getNickname());
			map.put("distance", toString(info.getDistance()));
			if (cart.getDiningAddressId() == info.getSupplierId()) {
				map.put("isDefault", "YES");
			} else {
				map.put("isDefault", "NO");
			}
			list.add(map);
		}
		successResult(json, "用餐地址查询成功");
		json.put("list", list);
		json.put("totalCount", baseBatchResult.getTotalCount());
		json.put("totalPage", baseBatchResult.getPageCount());
	}
	
	/** 设置用餐地址 */
	protected void setDiningAddress(HttpServletRequest request, JSONObject json, String des) {
		String supplierIdStr = request.getParameter("supplierId");
		String setType = request.getParameter("setType");
		long supplierId = Long.valueOf(supplierIdStr);
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		List<Long> supplierIds = supplierService.findAvailableSupplierIds(supplierId);
		if (supplierIds == null) {
			supplierIds = Lists.newArrayList();
		}
		//把商户自己添加进去
		supplierIds.add(supplierId);
		long oldAddressId = cart.getDiningAddressId();
		boolean setSuccess = true;
		for (Cart.CartItem info : cart.getViewCartList()) {
			
			if (!supplierIds.contains(info.getSupplierId())) {
				setSuccess = false;
				if (StringUtil.equals(setType, "force")) {
					setSuccess = true;
					//地址变更后 移除不支持调餐的商户菜品
					for (CartItemInfo cartItemInfo : info.getItemInfos()) {
						ProductInfo productInfo = productService
							.findProductById(cartItemInfo.getProductId());
						ShopingCartResult cartResult = cart.removeCartItemInfo(cartItemInfo);
						persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
					}
				} else {
					json.put("tipMessage",
						info.getSupplierFullName() + "不支持此地址送餐，确认更改地址将移除该商户下菜品！");
					break;
				}
			}
		}
		if (setSuccess) {
			cart.setDiningAddressId(supplierId);
			json.put("setSuccess", "1");
		} else {
			json.put("setSuccess", "0");
		}
		
		successResult(json, "设置用餐地址成功");
	}
	
	/** 物流查询 */
	protected void wuliu(HttpServletRequest request, JSONObject json, String des) {
		String id = request.getParameter("id");
		if (StringUtil.isBlank(id)) {
			failResult(json, "订单Id不能为空");
			return;
		}
		DeliveryShipInfo info = deliveryShipService.getDeliveryByOrderId(NumberUtil.parseLong(id));
		if (info != null) {
			json.put("logisticsName", info.getLogisticsName());
			json.put("deliveryId", info.getDeliveryId());
			json.put("status", info.getStatus());
			LogisticsInfoResult infoResult = logisticsInfoQueryService
				.queryShunfengLogisticsInfo(info.getDeliveryId(), getOpenApiContext());
			JSONArray jsonArray = new JSONArray();
			if (infoResult.isSuccess()) {
				for (LogisticsFlowInfo flowInfo : infoResult.getFlowInfos()) {
					Map<String, Object> map = MiscUtil.covertPoToMap(flowInfo);
					map.put("acceptTime", DateUtil.simpleFormat(flowInfo.getAcceptTime()));
					jsonArray.add(map);
				}
			}
			successResult(json, infoResult.getMessage());
			json.put("list", jsonArray);
		} else {
			failResult(json, "未查到物流信息");
		}
	}
	
	/** 收货确认 */
	protected void confirmRecieve(HttpServletRequest request, JSONObject json, String string) {
		ProcessOrder billOrder = new ProcessOrder();
		String id = request.getParameter("id");
		billOrder.setBizNo(NumberUtil.parseLong(id));
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.confirmReceipt(billOrder);
		if (baseResult.isSuccess()) {
			successResult(json, "确认收货成功");
		} else {
			failResult(json, "确认收货失败(" + baseResult.getMessage() + ")");
		}
	}
	
	/** 获取省列表 */
	protected void provinceList(HttpServletRequest request, JSONObject json, String string) {
		List<ProvinceInfo> provinceList = openingDistrictService.getAllDistrict()
			.getProvinceInfos();
		List<String> list = new ArrayList<>();
		for (ProvinceInfo info : provinceList) {
			list.add(info.getProvinceName());
		}
		json.put("list", list);
		successResult(json, "获取省列表成功");
	}
	
	/** 获取市列表 */
	protected void cityList(HttpServletRequest request, JSONObject json, String string) {
		String province = request.getParameter("province");
		if (StringUtil.isBlank(province)) {
			failResult(json, "省不能为空");
			return;
		}
		List<String> list = openingDistrictService.getCitysByProvinceName(province);
		successResult(json, "获取城市列表成功");
		json.put("list", list);
	}
	
	/** 获取用户订单汇总信息 */
	protected void supplierOrderSum(HttpServletRequest request, JSONObject json, String des) {
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		try {
			List<String> statusList = new ArrayList<String>();
			statusList.add(OrderStatusEnum.JYC.getCode());
			OrderSumInfo orderSumInfo = orderIbatisService.getSupplierOrderSum(userId, statusList);
			Map<String, String> map = new HashMap<String, String>();
			AppCommonUtil.beanToMap(orderSumInfo, map);
			map.put("today", DateUtil.dtSimpleFormat(new Date()));
			map.put("sevenStart", DateUtil.getDiffDate(new Date(), -7));
			map.put("monthStart", DateUtil.getDiffDate(new Date(), -30));
			json.put("info", map);
			successResult(json, "获取用户订单汇总信息成功");
		} catch (Exception e) {
			failResult(json, "获取订单汇总出错：" + e.getMessage());
			return;
		}
	}
	
	/** 订单列表查询 */
	protected void orderList(HttpServletRequest request, JSONObject json, String des) {
		QueryOrderInfoSearchOrder orderInfoorder = new QueryOrderInfoSearchOrder();
		WebUtil.setPoPropertyByRequest(orderInfoorder, request);
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String orderStatus = request.getParameter("orderStatus");
		String orderType = request.getParameter("orderType");
		String refundStatus = request.getParameter("refundStatus");
		String productVary = request.getParameter("productVary");
		if(StringUtil.isNotEmpty(productVary)){
			orderInfoorder.setProductVary(ProductVaryEnum.getByCode(productVary));
		}else{
			//查询全部订单
			orderInfoorder.setProductVary(null);
			orderInfoorder.setSaleTypeO2o(null);
		}
		orderInfoorder
			.setWorkflowStatus(OrderFlowStatus.getByCode(request.getParameter("workflowStatus")));
		if (StringUtil.equals(orderStatus, OrderStatusEnum.JYC.code())) {
			List<OrderStatusEnum> statusList = new ArrayList<>();
			statusList.add(OrderStatusEnum.JYC);
			//			statusList.add(OrderStatusEnum.YGB);
			//			statusList.add(OrderStatusEnum.YQX);
			orderInfoorder.setStatusList(statusList);
		} else {
			orderInfoorder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		}
		/* 订单类型 */
		if (StringUtil.isNotEmpty(orderType)) {
			if (StringUtil.isNotEmpty(orderType)) {
				if (SaleTypeEnum.O2O.code().equals(orderType)
						|| SaleTypeEnum.B2C.code().equals(orderType)
					|| SaleTypeEnum.HOTELS.code().equals(orderType)) {	
					orderInfoorder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());					
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.B2C) {
						orderInfoorder.setSaleTypeB2c(BooleanEnum.YES);
					}
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.O2O) {
						orderInfoorder.setSaleTypeO2o(BooleanEnum.YES);
					}
					if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.HOTELS) {
						orderInfoorder.setSaleTypeHotels(BooleanEnum.YES);
					}
				}
				if (SaleTypeEnum.OFFLINE.code().equals(orderType)) {	
					orderInfoorder.setPaymentMethod(PaymentMethodEnum.OFFLINE.code());					
					orderInfoorder.setSaleTypeO2o(null);
					orderInfoorder.setSaleTypeB2c(null);
				}
				if (SaleTypeEnum.PAY_TO_SHOP.code().equals(orderType)) {
					orderInfoorder.setPaymentMethod(PaymentMethodEnum.PAY_TO_SHOP.code());
					orderInfoorder.setSaleTypeO2o(null);
					orderInfoorder.setSaleTypeB2c(null);
				}
				
			}
		}
		
		if (StringUtil.equals(refundStatus, OrderRefundStatusEnum.ALL.code())) {
			List<OrderRefundStatusEnum> refundList = new ArrayList<>();
			refundList.add(OrderRefundStatusEnum.REFUND_FAIL);
			refundList.add(OrderRefundStatusEnum.REFUND_SUCCESS);
			refundList.add(OrderRefundStatusEnum.REFUNDING);
			orderInfoorder.setRefundStatusList(refundList);
		}
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		if (bizTypeEnum == UserBizTypeEnum.BUYER) {
			orderInfoorder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (bizTypeEnum == UserBizTypeEnum.SELLER) {
			orderInfoorder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (bizTypeEnum == UserBizTypeEnum.VISITOR_CENTER
			|| bizTypeEnum == UserBizTypeEnum.VISITOR_OPERATOR) {
			orderInfoorder.setBelongTo(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (bizTypeEnum == UserBizTypeEnum.TEC) {
			orderInfoorder.setDiliveryId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		
		if (StringUtil.isNotBlank(beginDate)) {
			orderInfoorder.setBeginDate(
				DateUtil.getStartTimeOfTheDate(DateUtil.strToDtSimpleFormat(beginDate)));
		}
		if (StringUtil.isNotBlank(endDate)) {
			orderInfoorder
				.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil.strToDtSimpleFormat(endDate)));
		}
		QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
			.findOrderList(orderInfoorder);
		if (baseBatchResult.isSuccess()) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			UserLevelEnum userLevelEnum = ShiroSessionUtils.getSessionLocal().getUserInfo()
				.getUserLevel();
			HotelSetRefundInfo hotelSetRefundInfo = hotelsSetRefundService
				.searchSetHotelRefundByGrade(userLevelEnum.getLevel());
			for (OrderInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<>();
				AppCommonUtil.beanToMap(info, map);
				
				map.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
									+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
				map.put("productTheme", "");
				map.put("productStyle", "");
				map.put("qrCode", StringUtil.defaultIfEmpty(info.getQrCode(), ""));
				SupplierInfo supplierInfo = supplierService.getSupplier(info.getSupplierId());
				if (supplierInfo != null) {
					map.put("supplierAddress", supplierInfo.getAddress());
					map.put("supplierTel", supplierInfo.getMobile());
				}
				UserQueryResult userQueryResult = userQueryService.queryByUserId(info.getUserId());
				if (userQueryResult.isSuccess()) {
					map.put("buyerTel", userQueryResult.getQueryUserInfo().getMobile());
				}
				OrderItemInfo is = info.getOrderItemInfo();
				if (is != null) {
					ProductInfo info0 = productService
						.findProductById(info.getOrderItemInfo().getItemProductId());
					if (info0 != null) {
						map.put("productTheme", info0.getProductTheme());
						map.put("productStyle", info0.getProductStyle());
						map.put("productName", info0.getProductName());
					}else{
						map.put("productName", is.getItemProductName());
					}
					map.put("price", is.getProPrice().toStandardString());
					map.put("quantity", toString(is.getQuantity()));
					map.put("picPath", is.getPicPath());
					map.put("beginDate", DateUtil.simpleFormatYmd(is.getBeginTime()));
					map.put("endDate", DateUtil.simpleFormatYmd(is.getEndTime()));
					map.put("days", String.valueOf(is.getDays()));
					map.put("totalAmount", info.getTotalAmount().toStandardString());
					map.put("payAmount", info.getPayAmount().toStandardString());
					map.put("orderItemId", toString(is.getId()));
					if (is.getRoomType() != null) {
						map.put("roomType", is.getRoomType().code());
					} else {
						map.put("roomType", "");
					}
					map.put("isShop", is.getItemProductId() >0?"YES":"NO");
					//酒店退款按钮特殊处理
					//酒店预订
					if (info.getSaleTypeHotels() == BooleanEnum.YES
						&& StringUtil.equals(orderStatus, OrderStatusEnum.YFK.code())) {
						if (ShiroSessionUtils.getSessionLocal()
							.getUserBizType() == UserBizTypeEnum.BUYER) {
							Date inDay = DateUtil
								.getStartTimeOfTheDate(info.getOrderItemInfo().getBeginTime());
							HotelRefundCheckOrder refundCheckOrder = new HotelRefundCheckOrder();
							refundCheckOrder.setInDate(inDay);
							refundCheckOrder.setUserLevelEnum(userLevelEnum);
							refundCheckOrder.setHotelSetRefundInfo(hotelSetRefundInfo);
							refundCheckOrder
								.setHotelTypeEnum(info.getOrderItemInfo().getRoomType());
							HotelRefundCheckResult refundCheckResult = hotelsSetRefundService
								.checkCanRefund(refundCheckOrder);
							if (!refundCheckResult.isSuccess()) {
								failResult(json,
									StringUtil.defaultIfBlank(refundCheckResult.getMessage(),
										"查询失败:" + refundCheckResult.getMessage()));
								return;
							}
							map.put("canRefund", refundCheckResult.getRefund().getCode());
						}
					}
				}
				map.remove("orderItemInfo");
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "订单列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/**
	 * 技师首页查询
	 * @param request
	 * @param json
	 * @param des
	 */
	protected void tecOrderIndex(HttpServletRequest request, JSONObject json, String des) {
		String queryDate = request.getParameter("queryDate");
		String orderStatus = request.getParameter("orderStatus");
		QueryOrderInfoSearchOrder orderInfoorder = new QueryOrderInfoSearchOrder();
		orderInfoorder.setPageSize(9999);
		orderInfoorder.setDiningTime(DateUtil.strToDtSimpleFormat(queryDate));
		if (StringUtil.isNotEmpty(orderStatus)) {
			orderInfoorder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		} else {
			orderInfoorder.setOrderStatus(OrderStatusEnum.YFK);
		}
		orderInfoorder.setRefundStatus(OrderRefundStatusEnum.EMPTY);
		orderInfoorder.setSaleTypeO2o(BooleanEnum.YES);
		orderInfoorder.setDiliveryId(ShiroSessionUtils.getSessionLocal().getUserId());
		QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
			.findOrderList(orderInfoorder);
		/*查询所有订单数*/
		orderInfoorder.setDiningTime(null);
		Long count = orderService.findOrderListCount(orderInfoorder);
		if (baseBatchResult.isSuccess()) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			for (OrderInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<>();
				AppCommonUtil.beanToMap(info, map);
				map.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
									+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
				map.put("qrCode", StringUtil.defaultIfEmpty(info.getQrCode(), ""));
				UserQueryResult userQueryResult = userQueryService.queryByUserId(info.getUserId());
				if (userQueryResult.isSuccess()) {
					map.put("buyerTel", userQueryResult.getQueryUserInfo().getMobile());
					map.put("buyerName", userQueryResult.getQueryUserInfo().getRealName());
				}
				OrderItemInfo is = info.getOrderItemInfo();
				if (is != null) {
					ProductInfo info0 = productService
						.findProductById(info.getOrderItemInfo().getItemProductId());
					if (info0 != null) {
						map.put("productName", info0.getProductName());
					}
					map.put("price", is.getProPrice().toStandardString());
					map.put("quantity", toString(is.getQuantity()));
					map.put("picPath", is.getPicPath());
					map.put("orderItemId", toString(is.getId()));
				}
				map.remove("orderItemInfo");
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			json.put("orderCount", count);
			successResult(json, "技师首页查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
		
	}
	
	/**
	 * 点餐订单列表查询
	 * @param request
	 * @param json
	 * @param des
	 */
	protected void orderMealOrderList(HttpServletRequest request, JSONObject json, String des) {
		QueryOrderInfoSearchOrder orderInfoorder = new QueryOrderInfoSearchOrder();
		WebUtil.setPoPropertyByRequest(orderInfoorder, request);
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String orderStatus = request.getParameter("orderStatus");
		//终端类型 pad app
		String terminalType = request.getParameter("terminalType");
		//String refundStatus = request.getParameter("refundStatus");
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		orderInfoorder
			.setWorkflowStatus(OrderFlowStatus.getByCode(request.getParameter("workflowStatus")));
		if (StringUtil.equals(orderStatus, OrderStatusEnum.JYC.code())) {
			List<OrderStatusEnum> statusList = new ArrayList<>();
			statusList.add(OrderStatusEnum.JYC);
			statusList.add(OrderStatusEnum.YGB);
			//statusList.add(OrderStatusEnum.YQX);
			orderInfoorder.setStatusList(statusList);
			
		} else if (StringUtil.equals(orderStatus, OrderStatusEnum.WFK.code())) {
			List<OrderStatusEnum> statusList = new ArrayList<>();
			
			//pad端待付款
			if (StringUtil.equals(terminalType, "pad")) {
				statusList.add(OrderStatusEnum.PAD_ORDER_CONFIRM);
				orderInfoorder.setStatusList(statusList);
			} else {
				//app待付款
				if (bizTypeEnum == UserBizTypeEnum.BUYER) {
					orderInfoorder.setOrderStatus(OrderStatusEnum.WFK);
				} else if (ShiroSessionUtils.getSessionLocal()
					.getUserBizType() == UserBizTypeEnum.SELLER) {
					statusList.add(OrderStatusEnum.PAD_ORDER_CONFIRM);
					statusList.add(OrderStatusEnum.WFK);
					orderInfoorder.setStatusList(statusList);
				}
			}
			
		} //待接单
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.YFK.code())) {
			List<OrderStatusEnum> statusList = new ArrayList<>();
			if (bizTypeEnum == UserBizTypeEnum.SELLER) {
				statusList.add(OrderStatusEnum.PAD_ORDER_CONFIRM);
				statusList.add(OrderStatusEnum.YFK);
				orderInfoorder.setStatusList(statusList);
			} else {
				orderInfoorder.setOrderStatus(OrderStatusEnum.YFK);
			}
		}
		//待出餐
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.MERCHANT_ORDERS.code())) {
			orderInfoorder.setOrderStatus(OrderStatusEnum.MERCHANT_ORDERS);
			
		}
		//配送中
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.YFH.code())) {
			orderInfoorder.setOrderStatus(OrderStatusEnum.YFH);
			
		} else {
			//TODO 其它订单状态判断
			orderInfoorder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		}
		//排序
		orderInfoorder.setOrderByEnum(BillSearchOrderByEnum.DINING_TIME_ASC);
		/* 订单类型 */
		orderInfoorder.setSaleTypeOrderMeal(BooleanEnum.YES);
		orderInfoorder.setTuneMeal(BooleanEnum.YES);
		//		if (StringUtil.equals(refundStatus, OrderRefundStatusEnum.ALL.code())) {
		//			List<OrderRefundStatusEnum> refundList = new ArrayList<>();
		//			refundList.add(OrderRefundStatusEnum.REFUND_FAIL);
		//			refundList.add(OrderRefundStatusEnum.REFUND_SUCCESS);
		//			refundList.add(OrderRefundStatusEnum.REFUNDING);
		//			orderInfoorder.setRefundStatusList(refundList);
		//		}
		if (bizTypeEnum == UserBizTypeEnum.BUYER) {
			orderInfoorder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (bizTypeEnum == UserBizTypeEnum.SELLER) {
			orderInfoorder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (ShiroSessionUtils.getSessionLocal()
			.getUserBizType() == UserBizTypeEnum.DELIVERY_PERSON) {
			orderInfoorder.setDiliverymanId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (StringUtil.isNotBlank(beginDate)) {
			orderInfoorder.setBeginDate(
				DateUtil.getStartTimeOfTheDate(DateUtil.strToDtSimpleFormat(beginDate)));
		}
		if (StringUtil.isNotBlank(endDate)) {
			orderInfoorder
				.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil.strToDtSimpleFormat(endDate)));
		}
		QueryBaseBatchResult<DiningOrderInfo> batchResult = orderService
			.findDiningOrderList(orderInfoorder);
		Date date = new Date();
		if (batchResult.isSuccess()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			for (DiningOrderInfo diningInfo : batchResult.getPageList()) {
				
				map = new HashMap<>();
				map.put("remainDiningTime",
					DateUtil.getBetweenTimes(date, diningInfo.getDiningTime()));
				map.put("supplierName", diningInfo.getSupplierName());
				map.put("supplierId", toString(diningInfo.getSupplierId()));
				map.put("consumeTime", DateUtil.simpleFormat(diningInfo.getConsumeTime()));
				map.put("deliverTime", DateUtil.simpleFormat(diningInfo.getDeliverTime()));
				map.put("diningTime", DateUtil.simpleFormat(diningInfo.getDiningTime()));
				map.put("receiptTime", DateUtil.simpleFormat(diningInfo.getReceiptTime()));
				map.put("batchNo", toString(diningInfo.getBatchNo()));
				map.put("diningAddress", diningInfo.getDiningAddress());
				map.put("diliverymanPhone", diningInfo.getDiliverymanPhone());
				map.put("totalPrice", diningInfo.getTotalAmount().toString());
				map.put("totalGainMoney", diningInfo.getTotalGainMoney().toString());
				map.put("totalUserPointMoney", diningInfo.getTotalUserPointMoney().toString());
				map.put("totalGiftMoney", diningInfo.getTotalGiftMoney().toString());
				map.put("totalPayAmount", diningInfo.getTotalPayAmont().toString());
				map.put("orderStatus", diningInfo.getOrderStatus().code());
				if (ShiroSessionUtils.getSessionLocal()
					.getUserBizType() == UserBizTypeEnum.SELLER) {
					OrderInfo orderInfo = diningInfo.getOrderInfos().get(0);
					if (orderInfo.getSupplierId() == orderInfo.getTakegoodsId()) {
						map.put("diningSupplierName", diningInfo.getSupplierName());
					} else {
						SupplierInfo supplierInfo = supplierService
							.getSupplier(orderInfo.getTakegoodsId());
						if (supplierInfo != null) {
							map.put("diningSupplierName", supplierInfo.getRealName());
						} else {
							map.put("diningSupplierName", "");
						}
					}
				}
				List<Map<String, String>> childList = new ArrayList<Map<String, String>>();
				for (OrderInfo info : diningInfo.getOrderInfos()) {
					map.put("diliverymanName", info.getDiliverymanName());
					map.put("tableNumber", info.getTableNumber());
					map.put("tableNumberSeq", info.getTableNumberSeq());
					if (info.getPrintReceipt() != null) {
						map.put("printReceipt", info.getPrintReceipt().code());
					}
					if (info.getWorkflowStatus() != null) {
						map.put("workflowStatus", info.getWorkflowStatus().code());
					}
					Map<String, String> childMap = new HashMap<>();
					AppCommonUtil.beanToMap(info, childMap);
					
					childMap
						.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
										+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
					childMap.put("productTheme", "");
					childMap.put("productStyle", "");
					childMap.put("qrCode", StringUtil.defaultIfEmpty(info.getQrCode(), ""));
					
					List<OrderItemInfo> orderItemInfos = orderService
						.findOrderItemByOrderId(info.getId());
					if (ListUtil.isNotEmpty(orderItemInfos)) {
						ProductInfo info0 = productService
							.findProductById(orderItemInfos.get(0).getItemProductId());
						OrderItemInfo is = info.getOrderItemInfo();
						if (info0 != null) {
							childMap.put("productTheme", info0.getProductTheme());
							childMap.put("productStyle", info0.getProductStyle());
							childMap.put("productName", info0.getProductName());
							childMap.put("price", is.getProPrice().toStandardString());
							childMap.put("quantity", toString(is.getQuantity()));
							childMap.put("picPath", is.getPicPath());
							childMap.put("totalAmount", is.getTotalAmount().toStandardString());
							childMap.put("payAmount", info.getPayAmount().toStandardString());
							childMap.put("orderItemId", toString(is.getId()));
						}
					}
					childMap.remove("orderItemInfo");
					childList.add(childMap);
				}
				map.put("orderList", childList);
				list.add(map);
			}
			json.put("totalPage", batchResult.getPageCount());
			json.put("list", list);
			successResult(json, "订单列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(batchResult.getMessage(), "查询失败"));
		}
	}
	
	/**
	 * 点餐订单详情查询
	 * @param request
	 * @param json
	 * @param des
	 */
	protected void diningOrderDetail(HttpServletRequest request, JSONObject json, String des) {
		
		QueryOrderInfoSearchOrder orderInfoorder = new QueryOrderInfoSearchOrder();
		String orderStatus = request.getParameter("orderStatus");
		//终端类型 pad app
		String terminalType = request.getParameter("terminalType");
		
		//批次号
		String batchNo = request.getParameter("batchNo");
		
		//商户号
		String supplierId = request.getParameter("supplierId");
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		if (StringUtil.isBlank(batchNo)) {
			json.put("code", 0);
			json.put("message", "订单批次号batchNo不能为空");
			return;
		}
		if (StringUtil.isBlank(supplierId)) {
			json.put("code", 0);
			json.put("message", "订单商户号supplierId不能为空");
			return;
		}
		orderInfoorder.setSupplierId(NumberUtil.parseLong(supplierId));
		orderInfoorder.setBatchNo(batchNo);
		if (StringUtil.equals(orderStatus, OrderStatusEnum.JYC.code())) {
			List<OrderStatusEnum> statusList = new ArrayList<>();
			statusList.add(OrderStatusEnum.JYC);
			//			statusList.add(OrderStatusEnum.YGB);
			//			statusList.add(OrderStatusEnum.YQX);
			orderInfoorder.setStatusList(statusList);
			
		}
		//待支付
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.WFK.code())) {
			List<OrderStatusEnum> statusList = new ArrayList<>();
			
			//pad端待付款
			if (StringUtil.equals(terminalType, "pad")) {
				statusList.add(OrderStatusEnum.PAD_ORDER_CONFIRM);
				orderInfoorder.setStatusList(statusList);
			} else {
				//app待付款
				if (bizTypeEnum == UserBizTypeEnum.BUYER) {
					orderInfoorder.setOrderStatus(OrderStatusEnum.WFK);
				} else if (ShiroSessionUtils.getSessionLocal()
					.getUserBizType() == UserBizTypeEnum.SELLER) {
					statusList.add(OrderStatusEnum.PAD_ORDER_CONFIRM);
					statusList.add(OrderStatusEnum.WFK);
					orderInfoorder.setStatusList(statusList);
				}
			}
			
		} //待接单
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.YFK.code())) {
			orderInfoorder.setOrderStatus(OrderStatusEnum.YFK);
		}
		//待出餐
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.MERCHANT_ORDERS.code())) {
			orderInfoorder.setOrderStatus(OrderStatusEnum.MERCHANT_ORDERS);
			
		}
		//配送中
		else if (StringUtil.equals(orderStatus, OrderStatusEnum.YFH.code())) {
			orderInfoorder.setOrderStatus(OrderStatusEnum.YFH);
			
		} else {
			//TODO 其它订单状态判断
			orderInfoorder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		}
		DiningOrderInfo diningInfo = orderService.findDiningOrderInfoByBatchNo(orderInfoorder);
		if (diningInfo != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("supplierName", diningInfo.getSupplierName());
			map.put("supplierId", toString(diningInfo.getSupplierId()));
			map.put("batchNo", toString(diningInfo.getBatchNo()));
			map.put("diningAddress", diningInfo.getDiningAddress());
			map.put("diliverymanPhone", diningInfo.getDiliverymanPhone());
			map.put("totalPrice", diningInfo.getTotalAmount().toString());
			map.put("totalGainMoney", diningInfo.getTotalGainMoney().toString());
			map.put("totalUserPointMoney", diningInfo.getTotalUserPointMoney().toString());
			map.put("totalGiftMoney", diningInfo.getTotalGiftMoney().toString());
			map.put("totalPayAmount", diningInfo.getTotalPayAmont().toString());
			map.put("orderStatus", diningInfo.getOrderStatus().code());
			map.put("consumeTime", DateUtil.simpleFormat(diningInfo.getConsumeTime()));
			map.put("deliverTime", DateUtil.simpleFormat(diningInfo.getDeliverTime()));
			map.put("diningTime", DateUtil.simpleFormat(diningInfo.getDiningTime()));
			map.put("receiptTime", DateUtil.simpleFormat(diningInfo.getReceiptTime()));
			map.put("totalPostFee", diningInfo.getTotalPostFee().toString());
			map.put("totalDiliveryFee", diningInfo.getTotalDiliveryFee().toString());
			OrderInfo orderInfo = diningInfo.getOrderInfos().get(0);
			if (orderInfo.getSupplierId() == orderInfo.getTakegoodsId()) {
				map.put("diningSupplierName", diningInfo.getSupplierName());
			} else {
				SupplierInfo supplierInfo = supplierService.getSupplier(orderInfo.getTakegoodsId());
				if (supplierInfo != null) {
					map.put("diningSupplierName", supplierInfo.getRealName());
				} else {
					map.put("diningSupplierName", "");
				}
			}
			List<Map<String, String>> childList = new ArrayList<Map<String, String>>();
			for (OrderInfo info : diningInfo.getOrderInfos()) {
				map.put("diliverymanName", info.getDiliverymanName());
				map.put("tableNumber", info.getTableNumber());
				map.put("tableNumberSeq", info.getTableNumberSeq());
				if (info.getPrintReceipt() != null) {
					map.put("printReceipt", info.getPrintReceipt().code());
				}
				if (info.getWorkflowStatus() != null) {
					map.put("workflowStatus", info.getWorkflowStatus().code());
				}
				Map<String, String> childMap = new HashMap<>();
				AppCommonUtil.beanToMap(info, childMap);
				
				childMap.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
										+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
				childMap.put("productTheme", "");
				childMap.put("productStyle", "");
				childMap.put("qrCode", StringUtil.defaultIfEmpty(info.getQrCode(), ""));
				
				List<OrderItemInfo> orderItemInfos = orderService
					.findOrderItemByOrderId(info.getId());
				if (ListUtil.isNotEmpty(orderItemInfos)) {
					ProductInfo info0 = productService
						.findProductById(orderItemInfos.get(0).getItemProductId());
					OrderItemInfo is = info.getOrderItemInfo();
					if (info0 != null) {
						childMap.put("productTheme", info0.getProductTheme());
						childMap.put("productStyle", info0.getProductStyle());
						childMap.put("productName", info0.getProductName());
						childMap.put("price", is.getProPrice().toStandardString());
						childMap.put("quantity", toString(is.getQuantity()));
						childMap.put("picPath", is.getPicPath());
						childMap.put("totalAmount", is.getTotalAmount().toStandardString());
						childMap.put("payAmount", info.getPayAmount().toStandardString());
						childMap.put("orderItemId", toString(is.getId()));
					}
				}
				childMap.remove("orderItemInfo");
				childList.add(childMap);
			}
			map.put("orderList", childList);
			json.put("info", map);
			successResult(json, "订单详情查询成功");
		} else {
			failResult(json, "未查到该订单");
		}
	}
	
	/** 订单详情查询 */
	protected void orderDetail(HttpServletRequest request, JSONObject json, String des) {
		String id = request.getParameter("id");
		if (StringUtil.isBlank(id)) {
			json.put("code", 0);
			json.put("message", "订单id不能为空");
			return;
		}
		OrderInfo info = orderService.findOrderById(NumberUtil.parseLong(id));
		if (info != null) {
			Map<String, String> map = new HashMap<>();
			AppCommonUtil.beanToMap(info, map);
			map.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
								+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
			map.put("productTheme", "");
			map.put("productStyle", "");
			map.put("qrCode", info.getQrCode());
			map.put("saleTypeO2o", info.getSaleTypeO2o().getCode());
			map.put("saleTypeB2c", info.getSaleTypeB2c().getCode());
			map.put("saleTypeHotels", info.getSaleTypeHotels().getCode());
			map.put("payAmount", String.valueOf(info.getPayAmount()));
			map.put("totalAmount", String.valueOf(info.getTotalAmount()));
			map.put("gainMoney", String.valueOf(info.getGainMoney()));
			map.put("userPointAmount", String.valueOf(info.getUserPointAmount()));
			DeliveryShipInfo deliveryShipInfo = info.getDeliveryShipInfo();
			if (deliveryShipInfo != null) {
				json.put("logisticsName", deliveryShipInfo.getLogisticsName());
				json.put("deliveryId", deliveryShipInfo.getDeliveryId());
			}
			SupplierInfo supplierInfo = supplierService.getSupplier(info.getSupplierId());
			if (supplierInfo != null) {
				map.put("supplierAddress", supplierInfo.getAddress());
				map.put("supplierTel", supplierInfo.getMobile());
			}
			UserQueryResult userQueryResult = userQueryService.queryByUserId(info.getUserId());
			if (userQueryResult.isSuccess()) {
				map.put("buyerTel", userQueryResult.getQueryUserInfo().getMobile());
			}
			List<OrderItemInfo> orderItemInfos = orderService
				.findOrderItemByOrderId(NumberUtil.parseLong(id));
			if (ListUtil.isNotEmpty(orderItemInfos)) {
				ProductInfo info0 = productService
					.findProductById(orderItemInfos.get(0).getItemProductId());
				OrderItemInfo itemInfo = orderItemInfos.get(0);
				map.put("isShop", itemInfo.getItemProductId() >0?"YES":"NO");
				if (info0 != null) {
					map.put("productTheme", info0.getProductTheme());
					map.put("productStyle", info0.getProductStyle());
					map.put("productName", info0.getProductName());
					map.put("price", itemInfo.getProPrice().toStandardString());
					map.put("quantity", toString(itemInfo.getQuantity()));
					map.put("beginDate", toString(itemInfo.getBeginTime()));
					map.put("endDate", toString(itemInfo.getEndTime()));
					map.put("days", toString(itemInfo.getDays()));
					if (itemInfo.getRoomType() != null) {
						map.put("roomType", itemInfo.getRoomType().getCode());
						map.put("roomTypeName", itemInfo.getRoomType().getMessage());
					} else {
						map.put("roomType", "");
						map.put("roomTypeName", "");
					}
					map.put("picPath", itemInfo.getPicPath());
					map.put("orderItemId", toString(itemInfo.getId()));
					//酒店退款按钮特殊处理
					//酒店预订
					UserLevelEnum userLevelEnum = ShiroSessionUtils.getSessionLocal().getUserInfo()
						.getUserLevel();
					HotelSetRefundInfo hotelSetRefundInfo = hotelsSetRefundService
						.searchSetHotelRefundByGrade(userLevelEnum.getLevel());
					if (info.getSaleTypeHotels() == BooleanEnum.YES && StringUtil
						.equals(info.getOrderStatus().getCode(), OrderStatusEnum.YFK.code())) {
						if (ShiroSessionUtils.getSessionLocal()
							.getUserBizType() == UserBizTypeEnum.BUYER) {
							Date inDay = DateUtil.getStartTimeOfTheDate(itemInfo.getBeginTime());
							HotelRefundCheckOrder refundCheckOrder = new HotelRefundCheckOrder();
							refundCheckOrder.setInDate(inDay);
							refundCheckOrder.setUserLevelEnum(userLevelEnum);
							refundCheckOrder.setHotelSetRefundInfo(hotelSetRefundInfo);
							refundCheckOrder.setHotelTypeEnum(itemInfo.getRoomType());
							HotelRefundCheckResult refundCheckResult = hotelsSetRefundService
								.checkCanRefund(refundCheckOrder);
							if (!refundCheckResult.isSuccess()) {
								failResult(json,
									StringUtil.defaultIfBlank(refundCheckResult.getMessage(),
										"查询失败:" + refundCheckResult.getMessage()));
								return;
							}
							map.put("canRefund", refundCheckResult.getRefund().getCode());
						}
					}
				}
			}
			json.put("info", map);
			successResult(json, "订单详情查询成功");
		} else {
			failResult(json, "未查到该订单");
		}
		
	}
	
	/** 订单确认 */
	protected void confirmOrder(HttpServletRequest request, JSONObject json, String string) {
		String proIds = request.getParameter("productIds");/*商品ID*/
		String addressId = request.getParameter("addressId");/*邮购地址ID*/
		if (StringUtil.isBlank(proIds)) {
			failResult(json, "选择的商品productIds不能为空");
			return;
		}
		if (proIds.indexOf("，") > -1) {
			proIds = proIds.replaceAll("，", ",");
		}
		String count = request.getParameter("counts");
		String[] pIds = proIds.split(",");
		
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		if (StringUtil.isNotBlank(count)) {
			String[] counts = count.split(",");
			int i = 0;
			for (String s : counts) {
				long productId = Long.parseLong(pIds[i]);
				ProductInfo info = productService.findProductById(productId);
				if (info != null) {
					CartItemInfo item = new CartItemInfo(productId, info.getSupplierId(),
						Long.parseLong(s));
					long fcount = cart.preAddCartItemQuantity(item);
					String operType = "add";
					if (fcount > Long.parseLong(s)) {
						operType = "update";
					}
					request.setAttribute("operType", operType);
					request.setAttribute("productId", pIds[i]);
					request.setAttribute("count", s);
					shoppingCarUpdate(request, json, string);
					if (json.getInteger("code") != 1) {
						return;
					}
				} else {
					failResult(json, "商品号：" + productId + "不存在");
					return;
				}
				
				i++;
			}
		}
		Map<Long, List<CartItemInfo>> list = cart.getValue();
		Map<Long, List<CartItemInfo>> newListInfo = new HashMap<Long, List<CartItemInfo>>();
		
		List<Long> supplierIds = Lists.newArrayList();
		for (Iterator<Map.Entry<Long, List<CartItemInfo>>> it = list.entrySet().iterator(); it
			.hasNext();) {
			Map.Entry<Long, List<CartItemInfo>> entry = it.next(); // 供应商ID
			if (ListUtil.isNotEmpty(entry.getValue())) {
				List<CartItemInfo> newCardItemInfos = Lists.newArrayList();
				for (CartItemInfo cartItemInfo : entry.getValue()) {
					if (ArrayUtil.contains(pIds, String.valueOf(cartItemInfo.getProductId()))) {
						
						ProductInfo productInfo = productService
							.findProductById(cartItemInfo.getProductId());
						if (StringUtil.notEquals(productInfo.getProductStatus().code(),
							ProductStatusEnum.ON.getCode())) {
							failResult(json,
								"亲，你选购的商品(" + productInfo.getProductName() + ")已经下架，请重新选购！");
							return;
						}
						for (int i = 0; i < pIds.length; i++) {
							
							if (NumberUtil.parseLong(pIds[i]) == cartItemInfo.getProductId()
								.longValue()) {
								if (cartItemInfo.getSupplierId() == WebSessionUtil
									.getCurrentSessionLocal().getUserId()) {
									failResult(json,
										"亲，自己不能买自己发布商品(" + productInfo.getProductName() + ")！");
									return;
								}
								newCardItemInfos.add(cartItemInfo);
								break;
							}
						}
						
					}
				}
				if (newCardItemInfos.size() > 0) {
					newListInfo.put(entry.getKey(), newCardItemInfos);
					supplierIds.add(entry.getKey());
				}
			}
		}
		String province = "";
		if (StringUtil.isEmpty(addressId)) {
			List<DrawerAddressInfo> drawerAddressInfos = orderService
				.getAddressesAndDefault(WebSessionUtil.getCurrentSessionLocal().getUserId(), "Y");
			if (drawerAddressInfos.size() > 0) {
				DrawerAddressInfo addressInfo = drawerAddressInfos.get(0);
				province = addressInfo.getProvince();
			}
		} else {
			DrawerAddressInfo addressInfo = orderService.findDrawerAddressById(addressId);
			if (addressInfo != null) {
				province = addressInfo.getProvince();
			}
		}
		List<Cart.CartItem> cartItems = cart.getViewCartList(newListInfo);
		List<Map<String, String>> selectList = new ArrayList<>();
		Map<String, String> map = null;
		/*包含运费的总费用*/
		Money totalPostFee = Money.zero();
		/*分景区存储运费*/
		Map<Long, Money> supplierMap = new HashMap<Long, Money>();
		for (Cart.CartItem info : cartItems) {
			for (CartItemInfo info0 : info.getItemInfos()) {
				map = new HashMap<>();
				map = AppCommonUtil.beanToMap(info0, map);
				ProductInfo info1 = productService.findProductById(info0.getProductId());
				String productTheme = "";
				String productStyle = "";
				String wareCount = "0";
				String productStatus = "x";
				if (info1 != null) {
					productTheme = info1.getProductTheme();
					productStyle = info1.getProductStyle();
					wareCount = String.valueOf(info1.getWareCount());
					productStatus = info1.getProductStatus().getCode();
					if (StringUtil.isNotEmpty(province)) {
						ProductDomain productDomain = new ProductDomain();
						productDomain.setProductId(info1.getProductId());
						productDomain.setPostType(info1.getPostType());
						productDomain.setResortsBusinessId(info1.getResortsBusinessId());
						orderService.setPostFeeAndItem(productDomain, supplierMap, totalPostFee,
							province);
					}
				}
				map.put("resortsBusinessId", String.valueOf(info1.getResortsBusinessId()));
				map.put("productTheme", productTheme);
				map.put("productStyle", productStyle);
				map.put("wareCount", wareCount);
				map.put("productStatus", productStatus);
				selectList.add(map);
			}
			
		}
		json.put("selectList", selectList);
		json.put("postFeeMap", supplierMap);
		json.put("totalPostFee", totalPostFee.toStandardString());
		json.put("selectTotalAmount",
			cart.getSelectTotalAmount().add(totalPostFee).toStandardString());
		
		GainMoneyUseOrder order = new GainMoneyUseOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setInvestAmount(cart.getSelectTotalAmount());
		order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		UseGainMoneyResult result = giftMoneyTradeQueryService.queryGainMoneyCanUseByTrade(order);
		List<Map<String, String>> giftList = new ArrayList<>();
		Map<String, String> giftMap = null;
		for (GiftMoneyTradeInfo info : result.getGainMoneyTrades()) {
			giftMap = new HashMap<String, String>();
			AppCommonUtil.beanToMap(info, giftMap);
			giftList.add(giftMap);
		}
		json.put("giftList", giftList);
		
		List<DrawerAddressInfo> listAddresses = orderService
			.getAddresses(WebSessionUtil.getCurrentSessionLocal().getUserId());
		List<Map<String, String>> addresslist = new ArrayList<Map<String, String>>();
		for (DrawerAddressInfo info : listAddresses) {
			map = new HashMap<>();
			AppCommonUtil.beanToMap(info, map);
			addresslist.add(map);
		}
		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
		json.put("token", token);
		json.put("listAddresses", addresslist);
		request.getSession().setAttribute("newConfirmListInfo", cartItems);
		request.getSession().setAttribute("listAddresses", listAddresses);
		successResult(json, "待确认订单信息查询成功");
	}
	
	/**
	 * app确认点餐订单
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void confirmOrderMealOrder(	HttpServletRequest request, JSONObject json,
											String string) {
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		SupplierInfo addrSupplierInfo = supplierService.getSupplier(cart.getDiningAddressId());
		if (addrSupplierInfo != null) {
			json.put("address", addrSupplierInfo.getStoreName());
		} else {
			failResult(json, "获取收餐地址失败，请重新选取收餐地址！");
			return;
		}
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;
		List<Map<String, String>> childList = null;
		Map<String, String> childMap = null;
		//总的服务费
		Money totalPostFee = Money.zero();
		for (Cart.CartItem info : cart.getViewCartList()) {
			childList = new ArrayList<>();
			map = new HashMap<>();
			Money postFee = Money.zero();
			SupplierInfo supplierInfo = supplierService.getSupplier(info.getSupplierId());
			if (supplierInfo == null) {
				failResult(json, "系统繁忙，请稍后再试！");
				return;
			}
			if (supplierInfo.getLowestHandselAmount().greaterThan(info.getEveryPriceVal())) {
				failResult(json, info.getSupplierFullName() + "的订单金额小于最低起送价！");
				return;
			}
			for (CartItemInfo info0 : info.getItemInfos()) {
				childMap = new HashMap<>();
				childMap = AppCommonUtil.beanToMap(info0, childMap);
				ProductInfo info1 = productService.findProductById(info0.getProductId());
				String productTheme = "";
				String productStyle = "";
				String wareCount = "0";
				String productStatus = "x";
				if (info1 != null) {
					productTheme = info1.getProductTheme();
					productStyle = info1.getProductStyle();
					wareCount = String.valueOf(info1.getWareCount());
					productStatus = info1.getProductStatus().getCode();
				}
				childMap.put("productTheme", productTheme);
				childMap.put("productStyle", productStyle);
				childMap.put("wareCount", wareCount);
				childMap.put("productStatus", productStatus);
				childList.add(childMap);
				map.put("productList", childList);
			}
			//调餐计算服务费
			if (addrSupplierInfo.getSupplierId() != info.getSupplierId()) {
				postFee = info.getEveryPriceVal().multiply(supplierInfo.getServiceChargeRate())
					.divide(100);
			}
			totalPostFee.addTo(postFee);
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("supplierName", info.getSupplierFullName());
			map.put("supplierTotalAmount", info.getEveryPriceVal().toString());
			list.add(map);
		}
		json.put("supplierList", list);
		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
		json.put("token", token);
		Money totalPrice = cart.getTotalPrice().add(totalPostFee);
		json.put("totalPrice", totalPrice.toString());
		json.put("totalPostFee", totalPostFee.toString());
		successResult(json, "待确认订单信息查询成功");
	}
	
	/** 可用技师列表 **/
	protected void deliveryList(HttpServletRequest request, JSONObject json, String string) {
		String productId = request.getParameter("productId");
		ProductDomain productDomain = productDomainRepository
			.active(NumberUtil.parseLong(productId), false);
		if (productDomain == null) {
			failResult(json, "无效商品！");
			return;
		}
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		String userType = bizTypeEnum.getCode();
		DeliveryPersonSearchOrder searchOrder = new DeliveryPersonSearchOrder();
		if (userType.equals(UserBizTypeEnum.SELLER.getCode())) {
			searchOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getUserId());
		} else if (userType.equals(UserBizTypeEnum.VISITOR_CENTER.getCode())
					|| userType.equals(UserBizTypeEnum.VISITOR_OPERATOR.getCode())) {
			searchOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		List<String> serviceTypeList = new ArrayList<String>();
		if (StringUtil.isEmpty(productDomain.getProductType())) {
			failResult(json, "商品所属分类有误！");
			return;
		}
		String[] productTypes = productDomain.getProductType().split("-");
		String preType = "";
		for (int i = 0; i < productTypes.length; i++) {
			if (i != 0)
				serviceTypeList.add(preType + productTypes[i]);
			preType = productTypes[i] + "-";
		}
		searchOrder.setServiceType(serviceTypeList);
		QueryBaseBatchResult<DeliveryPersonInfo> deliveryResult = deliveryPersonService
			.getPersonList(searchOrder);
		if (!deliveryResult.isSuccess()) {
			failResult(json, deliveryResult.getMessage());
			return;
		}
		json.put("deliveryPersonList", deliveryResult.getPageList());
		successResult(json, "获取可用技师列表成功");
	}
	
	/** 生成订单 **/
	protected void confirmOrderSub(HttpServletRequest request, JSONObject json, String string) {
		
		String mobile = request.getParameter("mobile");
		String counts = request.getParameter("counts");
		String[] specialExplain = request.getParameterValues("specialExplain");
		String gainMoneyTradesId = request.getParameter("gainMoneyTradesId");
		String productId = request.getParameter("productId");
		String payType = request.getParameter("payType");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String roomType = request.getParameter("roomType");
		/*技师ID*/
		String diliverymanId = request.getParameter("diliverymanId");
		/*预订服务时间*/
		String diningTime = request.getParameter("diningTime");
		/*地址ID*/
		String addressId = request.getParameter("id");
		/*是否需要上门*/
		String tuneMeal = request.getParameter("tuneMeal");
		long userPoint = NumberUtil.parseLong(request.getParameter("userPoint"));
		if (StringUtil.isBlank(mobile)) {
			UserQueryResult result = userQueryService
				.queryByUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			if (result.isSuccess() && result.getQueryUserInfo() != null) {
				mobile = result.getQueryUserInfo().getMobile();
			}
		}
		ProductInfo productInfo = productService
			.findSupplierProductById(NumberUtil.parseLong(productId));
		if (productInfo == null) {
			failResult(json, "未找到该商品");
			return;
		}
		BillSaveOrder billSaveOrder = new BillSaveOrder();
		List<CartItemInfo> cartItemInfos = Lists.newArrayList();
		CartItemInfo info = new CartItemInfo();
		if (productInfo.getCustomType2() == BooleanEnum.YES) {
			if (tuneMeal.equals(BooleanEnum.YES.getCode())) {
				if (StringUtil.isEmpty(addressId)) {
					failResult(json, "上门需提供上门地址");
					return;
				}
				billSaveOrder.setTuneMeal(BooleanEnum.YES);
				billSaveOrder.setAddressId(addressId);
				DrawerAddressInfo address = orderService.findDrawerAddressById(addressId);
				billSaveOrder.setDrawerName(address.getDrawerName());
				billSaveOrder.setAreaInfo(address.getProvince() + address.getCity());
				billSaveOrder.setCity(address.getCity());
				billSaveOrder.setProvince(address.getProvince());
				billSaveOrder.setDetailAddress(address.getDetailAddress());
				billSaveOrder.setZipCode(address.getZipCode());
				billSaveOrder.setDrawerNumber(address.getDrawerNumber());
				billSaveOrder.setMobileNumber(address.getMobileNumber());
				billSaveOrder.setDiningTime(DateUtil.strToDtSimpleFormat(diningTime));
			} else {
				billSaveOrder.setTuneMeal(BooleanEnum.NO);
			}
		} else {
			billSaveOrder.setTuneMeal(BooleanEnum.NO);
		}
		info.setProductId(Long.parseLong(productId));
		info.setQuantity(Integer.parseInt(counts));
		if (payType.equals(SaleTypeEnum.HOTELS.getCode())
			&& StringUtil.isNotEmpty(roomType)) { /*酒店预订*/
			HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
			orderNumOrder.setProductId(productInfo.getProductId());
			orderNumOrder.setCheckNum(Integer.parseInt(counts));
			orderNumOrder.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
			orderNumOrder.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
			HotelTypeEnum hotelTypeEnum = HotelTypeEnum.getByCode(roomType);
			if (hotelTypeEnum == null) {
				failResult(json, "房间价格类型无效");
				return;
			}
			orderNumOrder.setHotelTypeEnum(hotelTypeEnum);
			HotelOrderResult hotelOrderResult = hotelsStockService
				.getHotelOrderCheckInfo(orderNumOrder);
			if (!hotelOrderResult.isSuccess()) {
				failResult(json, hotelOrderResult.getMessage());
				return;
			}
			long days = DateUtil.countDaysBetweenTwoDays(DateUtil.strToDtSimpleFormat(beginDate),
				DateUtil.strToDtSimpleFormat(endDate));
			info.setDays(days);
			info.setRoomType(hotelTypeEnum);
			info.setPrice(hotelOrderResult.getExecPrice());
		} else {
			info.setPrice(productInfo.getPrice1());
			info.setDays(0);
		}
		info.setSupplierId(productInfo.getSupplierId());
		info.setSupplierName(productInfo.getSupplierName());
		info.setName(productInfo.getProductName());
		
		if(productInfo.getProductVary() == ProductVaryEnum.ticket){
			ScenicQueryResult scenicResult = scenicService.queryById(productInfo.getResortsBusinessId());
			if(scenicResult.getQueryScenicInfo() != null){
				info.setImage(scenicResult.getQueryScenicInfo().getImagePath1());
			}
		}
		//info.setImage(productInfo.getSmallPicPath());
		info.setBeginTime(DateUtil.strToDtSimpleFormat(beginDate));
		info.setEndTime(DateUtil.strToDtSimpleFormat(endDate));
		cartItemInfos.add(info);
		billSaveOrder.setSpecialExplain(specialExplain);
		billSaveOrder.setGainMoneyTradesId(gainMoneyTradesId);
		billSaveOrder.setList(cartItemInfos);
		billSaveOrder.setMobileNumber(mobile);
		billSaveOrder.setUserPoint(userPoint);
		if (StringUtil.isNotBlank(payType)) {
			billSaveOrder.setSaleTypeEnum(SaleTypeEnum.getByCode(payType));
		}
		billSaveOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		billSaveOrder.setNickname(ShiroSessionUtils.getSessionLocal().getNickname());
		BillSaveResult result = orderService.saveOrderInfo(billSaveOrder);
		
		if (result.isSuccess()) {
			Map<String, String> map = new HashMap<>();
			OrderInfo orderInfo = result.getOrderInfos().get(0);
			AppCommonUtil.beanToMap(orderInfo, map);
			json.put("info", map);
			/*全积分支付*/
			if (!orderInfo.getPayAmount().greaterThan(Money.zero())) {
				AppPayOrder order = new AppPayOrder();
				order.setPayWay(PaymentTypeEnum.POINT_PAYMENT.getCode());
				order.setIds(String.valueOf(orderInfo.getId()));
				order.setTradeName(orderInfo.getProductName());
				order.setAmount(orderInfo.getUserPointAmount());
				appPayService.creatPayOrder(order, getOpenApiContext());
			}
			successResult(json, "订单生成成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 生成邮购订单 **/
	protected void confirmOrderB2c(HttpServletRequest request, JSONObject json, String string) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		if (toToken == null || !toToken.endsWith(token)) {
			failResult(json, "请勿重新提交！");
			return;
		}
		request.getSession().removeAttribute("token");
		String addressId = request.getParameter("id");
		String[] specialExplain = request.getParameterValues("specialExplain");
		String drawerName = request.getParameter("drawerName");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String detailAddress = request.getParameter("detailAddress");
		String zipCode = request.getParameter("zipCode");
		String drawerNumber = request.getParameter("drawerNumber");
		String mobileNumber = request.getParameter("mobileNumber");
		String takeWays = request.getParameter("takeWays");
		String takeGoodsAddr = request.getParameter("takeGoodsAddr");
		String gainMoneyTradesId = request.getParameter("gainMoneyTradesId");
		long userPoint = NumberUtil.parseLong(request.getParameter("userPoint"));
		String productIds = request.getParameter("productIds");
		String counts = request.getParameter("counts");
		String payType = request.getParameter("payType");
		List<Cart.CartItem> newListInfo = refreshOrder(productIds, counts, json);
		if (json.getInteger("code") == 0) {
			return;
		} else {
			json.clear();
		}
		
		List<CartItemInfo> cartItemInfos = Lists.newArrayList();
		
		for (Cart.CartItem cartItem : newListInfo) {
			cartItemInfos.addAll(cartItem.getItemInfos());
		}
		BillSaveOrder billSaveOrder = new BillSaveOrder();
		billSaveOrder.setSpecialExplain(specialExplain);
		billSaveOrder.setGainMoneyTradesId(gainMoneyTradesId);
		billSaveOrder.setUserPoint(userPoint);
		billSaveOrder.setTakeGoodsAddrId(NumberUtil.parseLong(takeGoodsAddr));
		billSaveOrder.setTakeWays(TakeWaysEnum.getByCode(takeWays));
		if (billSaveOrder.getTakeWays() == null)
			billSaveOrder.setTakeWays(TakeWaysEnum.DELIVERY);
		billSaveOrder.setList(cartItemInfos);
		List<OrderInfo> listOrder = null;
		BillSaveResult result = null;
		billSaveOrder.setAddressId(addressId);
		if (StringUtil.isNotBlank(payType)) {
			billSaveOrder.setSaleTypeEnum(SaleTypeEnum.getByCode(payType));
		}
		billSaveOrder.setNickname(ShiroSessionUtils.getSessionLocal().getNickname());
		billSaveOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		if (StringUtil.equals(addressId, "-1")) {
			billSaveOrder.setDrawerName(drawerName);
			billSaveOrder.setCity(city);
			billSaveOrder.setProvince(province);
			billSaveOrder.setAreaInfo(province + city);
			billSaveOrder.setDetailAddress(detailAddress);
			billSaveOrder.setZipCode(zipCode);
			billSaveOrder.setDrawerNumber(drawerNumber);
			billSaveOrder.setMobileNumber(mobileNumber);
			result = orderService.saveOrderInfo(billSaveOrder);
			
		} else {
			DrawerAddressInfo address = orderService.findDrawerAddressById(addressId);
			billSaveOrder.setDrawerName(address.getDrawerName());
			billSaveOrder.setAreaInfo(address.getProvince() + address.getCity());
			billSaveOrder.setCity(address.getCity());
			billSaveOrder.setProvince(address.getProvince());
			billSaveOrder.setDetailAddress(address.getDetailAddress());
			billSaveOrder.setZipCode(address.getZipCode());
			billSaveOrder.setDrawerNumber(address.getDrawerNumber());
			billSaveOrder.setMobileNumber(address.getMobileNumber());
			result = orderService.saveOrderInfo(billSaveOrder);
		}
		if (result.isSuccess()) {
			// 订单创建成功之后要对之前session中的数据进行清除
			// productIds是选择的商品的ID
			listOrder = result.getOrderInfos();
			Money totalAmount = new Money(0);
			Money preferentialAmount = new Money(0);
			Money payAmount = new Money(0);
			String orderIds = "";
			String[] orderArray = new String[listOrder.size()];
			int i = 0;
			for (OrderInfo orderInfo : listOrder) {
				totalAmount.addTo(orderInfo.getTotalAmount());
				preferentialAmount.addTo(orderInfo.getPreferentialAmount());
				payAmount.addTo(orderInfo.getPayAmount());
				if (orderIds.length() == 0) {
					orderIds += orderInfo.getId();
				} else {
					orderIds += orderInfo.getId() + ",";
				}
				orderArray[i] = String.valueOf(orderInfo.getId());
				String strOrderProductName = orderInfo.getOrderItemInfo().getItemProductName();
				long productId = orderInfo.getOrderItemInfo().getItemProductId();
				
				orderInfo.setProductName(strOrderProductName);
				orderInfo.setProductId(productId);
				i++;
			}
			Cart cart = WebSessionUtil.getStaticCurrentCart();
			
			for (Cart.CartItem cartItem : newListInfo) {
				for (CartItemInfo cartItemInfo : cartItem.getItemInfos()) {
					ProductInfo productInfo = productService
						.findProductById(cartItemInfo.getProductId());
					ShopingCartResult cartResult = cart.removeCartItemInfo(cartItemInfo);
					persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
				}
			}
			// 订单列表
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			String ids = "";
			String products = "";
			for (OrderInfo info : listOrder) {
				map = new HashMap<>();
				AppCommonUtil.beanToMap(info, map);
				map.put("address", info.getCity() + info.getDetailAddress());
				map.put("productTheme", "");
				map.put("productStyle", "");
				List<OrderItemInfo> orderItemInfos = orderService
					.findOrderItemByOrderId(info.getId());
				if (ListUtil.isNotEmpty(orderItemInfos)) {
					ProductInfo info0 = productService
						.findProductById(orderItemInfos.get(0).getItemProductId());
					if (info0 != null) {
						map.put("productTheme", info0.getProductTheme());
						map.put("productStyle", info0.getProductStyle());
					}
				}
				if (StringUtil.isEmpty(ids)) {
					ids = String.valueOf(info.getId());
					products = String.valueOf(info.getProductName());
				} else {
					ids = ids + "," + String.valueOf(info.getId());
					products = products + "," + String.valueOf(info.getProductName());
				}
				list.add(map);
			}
			json.put("orderList", list);
			json.put("totalAmount", totalAmount.toStandardString());
			json.put("preferentialAmount", preferentialAmount.toStandardString());
			json.put("payAmount", payAmount.toStandardString());
			/*全积分支付*/
			if (!payAmount.greaterThan(Money.zero())) {
				AppPayOrder order = new AppPayOrder();
				order.setPayWay(PaymentTypeEnum.POINT_PAYMENT.getCode());
				order.setIds(ids);
				order.setTradeName(products);
				order.setAmount(new Money(
					userPoint / ConfigParamProperty.getIntegralDeductionCoefficient() * 100));
				appPayService.creatPayOrder(order, getOpenApiContext());
			}
			successResult(json, "订单生成成功");
		} else {
			failResult(json, result.getMessage());
			
		}
	}
	
	/**
	 * 生成App点餐订单
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void confirmOrderMeal(HttpServletRequest request, JSONObject json, String string) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		if (toToken == null || !toToken.endsWith(token)) {
			failResult(json, "请勿重新提交！");
			return;
		}
		request.getSession().removeAttribute("token");
		//		String[] specialExplain = request.getParameterValues("specialExplain");
		String gainMoneyTradesId = request.getParameter("gainMoneyTradesId");
		long userPoint = NumberUtil.parseLong(request.getParameter("userPoint"));
		//		String productIds = request.getParameter("productIds");
		//		String counts = request.getParameter("counts");
		
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		
		List<CartItemInfo> cartItemInfos = Lists.newArrayList();
		for (Cart.CartItem info : cart.getViewCartList()) {
			cartItemInfos.addAll(info.getItemInfos());
		}
		
		BillSaveOrder billSaveOrder = new BillSaveOrder();
		WebUtil.setPoPropertyByRequest(billSaveOrder, request);
		//		billSaveOrder.setSpecialExplain(specialExplain);
		billSaveOrder.setGainMoneyTradesId(gainMoneyTradesId);
		billSaveOrder.setUserPoint(userPoint);
		billSaveOrder.setList(cartItemInfos);
		List<OrderInfo> listOrder = null;
		BillSaveResult result = null;
		billSaveOrder.setSaleTypeEnum(SaleTypeEnum.ORDER_MEAL);
		billSaveOrder.setNickname(ShiroSessionUtils.getSessionLocal().getNickname());
		billSaveOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		billSaveOrder.setMobileNumber(ShiroSessionUtils.getSessionLocal().getMobile());
		billSaveOrder.setReceiveMealsSupplierId(cart.getDiningAddressId());
		//	billSaveOrder.setForecastReceiveMealsDate(forecastReceiveMealsDate);
		result = orderService.saveOrderInfo(billSaveOrder);
		
		if (result.isSuccess()) {
			// 订单创建成功之后要对之前session中的数据进行清除
			// productIds是选择的商品的ID
			listOrder = result.getOrderInfos();
			Money totalAmount = new Money(0);
			Money preferentialAmount = new Money(0);
			Money payAmount = new Money(0);
			String orderIds = "";
			String[] orderArray = new String[listOrder.size()];
			int i = 0;
			for (OrderInfo orderInfo : listOrder) {
				totalAmount.addTo(orderInfo.getTotalAmount());
				preferentialAmount.addTo(orderInfo.getPreferentialAmount());
				payAmount.addTo(orderInfo.getPayAmount());
				if (orderIds.length() == 0) {
					orderIds += orderInfo.getId();
				} else {
					orderIds += orderInfo.getId() + ",";
				}
				orderArray[i] = String.valueOf(orderInfo.getId());
				String strOrderProductName = orderInfo.getOrderItemInfo().getItemProductName();
				long productId = orderInfo.getOrderItemInfo().getItemProductId();
				
				orderInfo.setProductName(strOrderProductName);
				orderInfo.setProductId(productId);
				i++;
			}
			for (Cart.CartItem cartItem : cart.getViewCartList()) {
				for (CartItemInfo cartItemInfo : cartItem.getItemInfos()) {
					ProductInfo productInfo = productService
						.findProductById(cartItemInfo.getProductId());
					ShopingCartResult cartResult = cart.removeCartItemInfo(cartItemInfo);
					persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
				}
			}
			cart.setDiningAddressId(0);
			// 订单列表
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			String ids = "";
			String products = "";
			for (OrderInfo info : listOrder) {
				map = new HashMap<>();
				AppCommonUtil.beanToMap(info, map);
				map.put("address", info.getCity() + info.getDetailAddress());
				map.put("productTheme", "");
				map.put("productStyle", "");
				List<OrderItemInfo> orderItemInfos = orderService
					.findOrderItemByOrderId(info.getId());
				if (ListUtil.isNotEmpty(orderItemInfos)) {
					ProductInfo info0 = productService
						.findProductById(orderItemInfos.get(0).getItemProductId());
					if (info0 != null) {
						map.put("productTheme", info0.getProductTheme());
						map.put("productStyle", info0.getProductStyle());
					}
				}
				if (StringUtil.isEmpty(ids)) {
					ids = String.valueOf(info.getId());
					products = String.valueOf(info.getProductName());
				} else {
					ids = ids + "," + String.valueOf(info.getId());
					products = products + "," + String.valueOf(info.getProductName());
				}
				list.add(map);
			}
			json.put("orderList", list);
			json.put("totalAmount", totalAmount.toStandardString());
			json.put("preferentialAmount", preferentialAmount.toStandardString());
			json.put("payAmount", payAmount.toStandardString());
			/*全积分支付*/
			if (!payAmount.greaterThan(Money.zero())) {
				AppPayOrder order = new AppPayOrder();
				order.setPayWay(PaymentTypeEnum.POINT_PAYMENT.getCode());
				order.setIds(ids);
				order.setTradeName(products);
				order.setAmount(new Money(
					userPoint / ConfigParamProperty.getIntegralDeductionCoefficient() * 100));
				appPayService.creatPayOrder(order, getOpenApiContext());
			}
			successResult(json, "订单生成成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 在订单确认界面修改数量后更新 */
	private List<Cart.CartItem> refreshOrder(String proIds, String counts, JSONObject json) {
		String[] pIds = proIds.split(",");
		String[] cnts = counts.split(",");
		if (pIds.length != cnts.length) {
			failResult(json, "商品和数量参数有误！");
			return null;
		}
		json.put("code", 1);
		/*只取实例里面的方法，不改变购物车*/
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		Map<Long, List<CartItemInfo>> newListInfo = new HashMap<Long, List<CartItemInfo>>();
		for (int i = 0; i < pIds.length; i++) {
			ProductInfo productInfo = productService.findProductById(NumberUtil.parseLong(pIds[i]));
			if (productInfo == null) {
				failResult(json, "商品不存在！");
				return null;
			}
			if (StringUtil.notEquals(productInfo.getProductStatus().code(),
				ProductStatusEnum.ON.getCode())) {
				failResult(json, "亲，你选购的商品(" + productInfo.getProductName() + ")已经下架，请重新选购！");
				return null;
			}
			if (productInfo.getSupplierId() == WebSessionUtil.getCurrentSessionLocal()
				.getUserId()) {
				failResult(json, "亲，自己不能买自己发布商品(" + productInfo.getProductName() + ")！");
				return null;
			}
			List<CartItemInfo> newCardItemInfos = Lists.newArrayList();
			CartItemInfo cartItemInfo = new CartItemInfo();
			cartItemInfo.setQuantity(NumberUtil.parseLong(cnts[i]));
			cartItemInfo.setName(productInfo.getProductName());
			cartItemInfo.setProductId(productInfo.getProductId());
			cartItemInfo.setSupplierId(productInfo.getSupplierId());
			cartItemInfo.setSupplierName(productInfo.getSupplierName());
			cartItemInfo.setPrice(productInfo.getPrice1());
			cartItemInfo.setPriceOriginal(productInfo.getMarketPrice());
			cartItemInfo.setUnit(productInfo.getProductUnit());
			cartItemInfo.setImage(productInfo.getSmallPicPath());
			if (newListInfo.containsKey(productInfo.getSupplierId())) {
				newCardItemInfos = newListInfo.get(productInfo.getSupplierId());
				newCardItemInfos.add(cartItemInfo);
				newListInfo.put(productInfo.getSupplierId(), newCardItemInfos);
			} else {
				newCardItemInfos.add(cartItemInfo);
				newListInfo.put(productInfo.getSupplierId(), newCardItemInfos);
			}
		}
		return cart.getViewCartList(newListInfo);
	}
	
	/** 在订单确认界面修改数量后更新 */
	private List<Cart.CartItem> refreshOrderByCart(String proIds, JSONObject json) {
		String[] pIds = proIds.split(",");
		json.put("code", 1);
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		Map<Long, List<CartItemInfo>> list = cart.getValue();
		Map<Long, List<CartItemInfo>> newListInfo = new HashMap<Long, List<CartItemInfo>>();
		
		List<Long> supplierIds = Lists.newArrayList();
		for (Iterator<Map.Entry<Long, List<CartItemInfo>>> it = list.entrySet().iterator(); it
			.hasNext();) {
			Map.Entry<Long, List<CartItemInfo>> entry = it.next(); // 供应商ID
			if (ListUtil.isNotEmpty(entry.getValue())) {
				List<CartItemInfo> newCardItemInfos = Lists.newArrayList();
				for (CartItemInfo cartItemInfo : entry.getValue()) {
					if (ArrayUtil.contains(pIds, String.valueOf(cartItemInfo.getProductId()))) {
						
						ProductInfo productInfo = productService
							.findProductById(cartItemInfo.getProductId());
						if (StringUtil.notEquals(productInfo.getProductStatus().code(),
							ProductStatusEnum.ON.getCode())) {
							failResult(json,
								"亲，你选购的商品(" + productInfo.getProductName() + ")已经下架，请重新选购！");
							return null;
						}
						for (int i = 0; i < pIds.length; i++) {
							
							if (NumberUtil.parseLong(pIds[i]) == cartItemInfo.getProductId()
								.longValue()) {
								if (cartItemInfo.getSupplierId() == WebSessionUtil
									.getCurrentSessionLocal().getUserId()) {
									failResult(json,
										"亲，自己不能买自己发布商品(" + productInfo.getProductName() + ")！");
									return null;
								}
								newCardItemInfos.add(cartItemInfo);
								break;
							}
						}
						
					}
				}
				if (newCardItemInfos.size() > 0) {
					newListInfo.put(entry.getKey(), newCardItemInfos);
					supplierIds.add(entry.getKey());
				}
			}
		}
		return cart.getViewCartList(newListInfo);
	}
	
	/** 去付款 */
	protected void gotoPay(HttpServletRequest request, JSONObject json, String string) {
		AppPayOrder order = new AppPayOrder();
		/* 订单ID */
		String ids = request.getParameter("ids");
		/* 支付方式 */
		String payWay = request.getParameter("payWay");
		/* 余额支付的支付密码 */
		String payPwd = request.getParameter("payPwd");
		
		String returnUrl = request.getParameter("returnUrl");
		if (StringUtil.equals("exn", request.getParameter("exn"))) {
			payPwd = AESUtil.decode(payPwd);
		}
		if (StringUtil.isBlank(ids)) {
			failResult(json, "付款订单号不能为空");
			return;
		}
		order.setTradeName("商品付款");
		order.setIds(ids);
		order.setPayWay(payWay);
		order.setPayPwd(payPwd);
		order.setReturnUrl(returnUrl);
		order.setPartnerUserId(String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId()));
		
		AppPayResult result = appPayService.creatPayOrder(order, getOpenApiContext());
		if (result.isSuccess()) {
			if (StringUtil.equals(PaymentTypeEnum.BALANCE_PAYMENT.getCode(), payWay)) {
				successResult(json, "支付成功");
			} else if (StringUtil.equals(PaymentTypeEnum.YI_SHOU_FU.getCode(), payWay)) {
				json.put("url", result.getUrl());
				successResult(json, "获取支付链接成功");
			} else if (StringUtil.equals(PaymentTypeEnum.WECHATS_PAY.getCode(), payWay)) {
				json.put("map", result.getMap());
				json.put("url", result.getUrl());
				successResult(json, "获取支付链接成功");
			} else {
				successResult(json, "支付成功");
			}
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 点餐付款
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void diningToPay(HttpServletRequest request, JSONObject json, String string) {
		AppPayOrder order = new AppPayOrder();
		/* 订单ID */
		String ids = null;
		String orderIds = request.getParameter("ids");
		String tableNumbers = request.getParameter("tableNumbers");
		if (orderIds != null || tableNumbers != null) {
			if (StringUtil.isNotBlank(orderIds)) {
				ids = orderIds;
			} else if (StringUtil.isNotBlank(tableNumbers)) {
				String[] tableNumberspit = tableNumbers.split(",");
				ids = "";
				for (String tableNumber : tableNumberspit) {
					QureyDiningTableOrder diningTableOrder = new QureyDiningTableOrder();
					diningTableOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
					diningTableOrder.setTableNumber(tableNumber);
					DiningTableSituationInfo tableSituationInfo = orderfoodService
						.getUseingDiningTable(diningTableOrder);
					if (tableSituationInfo != null) {
						QueryOrderInfoSearchOrder infoSearchOrder = new QueryOrderInfoSearchOrder();
						infoSearchOrder.setTableNumberSeq(tableSituationInfo.getTableNumberSeq());
						//infoSearchOrder.setSupplierId(diningTableOrder.getSupplierId());
						infoSearchOrder.setPageSize(5000);
						QueryBaseBatchResult<OrderInfo> batchResult = orderQueryService
							.findOrderList(infoSearchOrder);
						for (OrderInfo orderInfo : batchResult.getPageList()) {
							if (orderInfo.getIsPayed() != BooleanEnum.YES) {
								if (orderInfo.getOrderStatus() == OrderStatusEnum.WFK
										|| orderInfo
										.getOrderStatus() == OrderStatusEnum.PAD_ORDER_CONFIRM
									|| (ShiroSessionUtils.getSessionLocal().getUserId() == orderInfo
										.getTakegoodsId()
											&& orderInfo.getTuneMeal() == BooleanEnum.YES
										&& OrderStatusEnum.PAD_ORDER != orderInfo
											.getOrderStatus())) {
									ids = ids + orderInfo.getId() + ",";
								}
								
							}
						}
					}
				}
				if (StringUtil.isNotBlank(ids)) {
					ids = ids.substring(0, ids.length() - 1);
				}
			}
			/* 支付方式 */
			String payWay = request.getParameter("payWay");
			/* 余额支付的支付密码 */
			String payPwd = request.getParameter("payPwd");
			if (StringUtil.equals("exn", request.getParameter("exn"))) {
				payPwd = AESUtil.decode(payPwd);
			}
			if (StringUtil.isBlank(ids)) {
				failResult(json, "付款订单号不能为空");
				return;
			}
			order.setTradeName("商品付款");
			order.setIds(ids);
			order.setPayWay(payWay);
			order.setPayPwd(payPwd);
			order.setPartnerUserId(String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId()));
			order.setUserEndIp(IPUtil.getIpAddr(request));
			AppPayResult result = appPayService.creatPayOrder(order, getOpenApiContext());
			if (result.isSuccess()) {
				if (StringUtil.equals("BALANCE_PAYMENT", payWay)) {
					successResult(json, "支付成功");
				} else if (StringUtil.equals("WECHATS_SANCODE_APP", payWay)) {
					json.put("info", result.getMap());
					successResult(json, "获取微信二维码成功");
				} else if (StringUtil.equals("CASH_PAYMENT", payWay)) {
					successResult(json, "支付成功");
				} else if (StringUtil.equals("APP_SANCODE", payWay)) {
					
					Map<String, String> map = result.getMap();
					String url = AppConstantsUtil.getHostHttpUrl()
										+ "/app/getPadQrCode.htm?tableNumbers=" + tableNumbers
									+ "&supplierId="
									+ ShiroSessionUtils.getSessionLocal().getUserId() + "&time="
									+ new Date().getTime();
					map.put("scanCodeImageUrl", url);
					map.put("tableNumbers", tableNumbers);
					json.put("info", map);
					successResult(json, "获取App二维码成功");
				} else {
					json.put("url", result.getUrl());
					successResult(json, "获取支付链接成功");
				}
				
			} else {
				failResult(json, result.getMessage());
			}
		} else {
			failResult(json, "付款订单号不能为空");
		}
		
	}
	
	/**
	 * 查询付款结果
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void queryDepositResult(HttpServletRequest request, JSONObject json, String string) {
		
		String paymentFlowId = request.getParameter("paymentFlowId");
		if (StringUtil.isBlank(paymentFlowId)) {
			failResult(json, "付款流水号不能为空");
		}
		PaymentFlowInfo flowInfo = paymentFlowService.findByPaymentFlowId(paymentFlowId);
		if (flowInfo != null) {
			successResult(json, "查询成功");
			json.put("paymentFlowStatus", flowInfo.getStatus().code());
		} else {
			failResult(json, "查询失败，没有此流水数据");
		}
		
	}
	
	/**
	 * PAd查询app扫码付款结果
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void queryAppScanPayResult(	HttpServletRequest request, JSONObject json,
											String string) {
		
		String tableNumbers = request.getParameter("tableNumbers");
		if (StringUtil.isBlank(tableNumbers)) {
			failResult(json, "桌号不能为空");
		}
		//		String supplierIdStr = request.getParameter("supplierId");
		long supplierId = ShiroSessionUtils.getSessionLocal().getUserId();
		String[] tableNumberspit = tableNumbers.split(",");
		boolean payed = true;
		for (String tableNumber : tableNumberspit) {
			QureyDiningTableOrder diningTableOrder = new QureyDiningTableOrder();
			//				ShiroSessionUtils.getSessionLocal().getUserId()
			diningTableOrder.setSupplierId(supplierId);
			diningTableOrder.setTableNumber(tableNumber);
			DiningTableSituationInfo tableSituationInfo = orderfoodService
				.getUseingDiningTable(diningTableOrder);
			if (tableSituationInfo != null) {
				QueryOrderInfoSearchOrder infoSearchOrder = new QueryOrderInfoSearchOrder();
				infoSearchOrder.setTableNumberSeq(tableSituationInfo.getTableNumberSeq());
				//infoSearchOrder.setSupplierId(diningTableOrder.getSupplierId());
				infoSearchOrder.setPageSize(5000);
				QueryBaseBatchResult<OrderInfo> batchResult = orderQueryService
					.findOrderList(infoSearchOrder);
				for (OrderInfo orderInfo : batchResult.getPageList()) {
					if (orderInfo.getIsPayed() != BooleanEnum.YES) {
						payed = false;
						break;
					}
				}
			}
			
		}
		successResult(json, "查询成功");
		if (payed) {
			json.put("paymentFlowStatus", PaymentFlowStatus.SUCCESS.code());
		} else {
			json.put("paymentFlowStatus", PaymentFlowStatus.INIT.code());
		}
		
	}
	
	/*酒店房间分类列表*/
	protected void hotelRoomType(HttpServletRequest request, JSONObject json, String string) {
		List<Map<String, String>> mapList = HotelTypeEnum.getAllEnumList();
		json.put("mapList", mapList);
		json.put("mapListCount", mapList.size());
		successResult(json, "房间分类查询成功");
	}
	
	/*酒店房间列表*/
	protected void supplierHotelList(HttpServletRequest request, JSONObject json, String string) {
		String searchDate = request.getParameter("searchDate");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		HotelStockOrder order = new HotelStockOrder();
		try {
			if (StringUtil.isNotEmpty(searchDate)) {
				order.setPriceDate(DateUtil.string2Date(searchDate));
			}
			if (StringUtil.isNotEmpty(beginDate)) {
				order.setBeginDate(DateUtil.string2Date(beginDate));
			}
			if (StringUtil.isNotEmpty(endDate)) {
				order.setEndDate(DateUtil.string2Date(endDate));
			}
		} catch (ParseException e) {
			failResult(json, "日期格式有误");
			return;
		}
		order.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		order.setProductStatus(ProductStatusEnum.ON);
		QueryBaseBatchResult<HotelStockInfo> baseBatchResult = hotelsStockService
			.getHotelStockList(order);
		// 订单列表
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, String> map = null;
		if (!baseBatchResult.isSuccess()) {
			failResult(json, "数据查询失败：" + baseBatchResult.getMessage());
			return;
		}
		if (baseBatchResult.getPageList() != null) {
			for (HotelStockInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<>();
				Map<String, Object> obMap = new HashMap<String, Object>();
				AppCommonUtil.beanToMap(info, map);
				obMap.putAll(map);
				obMap.put("leftNum",
					String.valueOf(info.getAvailableStock() - info.getOrdainNum()));
				obMap.put("maxMorSetNum",
					String.valueOf(info.getAvailableStock()	- info.getSpecialRoomTotalNum()
									- info.getNormalOrdain()));
				obMap.put("maxSpeSetNum",
					String.valueOf(info.getAvailableStock()	- info.getMorningRoomTotalNum()
									- info.getNormalOrdain()));
				obMap.put("maxLongSetNum", toString(info.getInStock()));
				//查询长包房数量
				HotelLongSetResult longSetResult = hotelsSetLongRoomSerivce
					.findInfoBySupplierIdAndProductId(info.getSupplierId(), info.getProductId());
				if (longSetResult.isSuccess()) {
					obMap.put("longRoomTotalNum",
						toString(longSetResult.getHotelLongSetInfo().getRoomNum()));
					if (longSetResult.isSuccess()) {
						HotelLongSetInfo hotelLongSetInfo = longSetResult.getHotelLongSetInfo();
						obMap.put("ruleType", hotelLongSetInfo.getRuleType().code());
						List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
						for (HotelLongDetailInfo hotelLongDetailInfo : hotelLongSetInfo
							.getHotelLongDetailInfos()) {
							Map<String, String> childmap = new HashMap<>();
							childmap.put("day", toString(hotelLongDetailInfo.getDays()));
							childmap.put("discount",
								toString(hotelLongDetailInfo.getDiscount() / 100));
							childmap.put("amount", hotelLongDetailInfo.getAmount().toString());
							listMap.add(childmap);
						}
						obMap.put("longDetailInfo", listMap);
					}
				} else {
					obMap.put("longRoomTotalNum", "0");
				}
				list.add(obMap);
			}
		}
		json.put("orderList", list);
		successResult(json, "房间信息查询成功");
	}
	
	/*酒店房间状态管理*/
	protected void hotelStatus(HttpServletRequest request, JSONObject json, String string) {
		long hotelId = NumberUtil.parseLong(request.getParameter("hotelId"));
		String status = request.getParameter("status");
		HotelStockStatusEnum hotelStockStatusEnum = HotelStockStatusEnum.getByCode(status);
		if (hotelStockStatusEnum == null) {
			failResult(json, "房间状态编码无效");
			return;
		}
		EsupplierBaseResult baseResult = hotelsStockService.chgStockStatus(hotelId,
			hotelStockStatusEnum);
		if (!baseResult.isSuccess()) {
			failResult(json, "房间状态设置失败：" + baseResult.getMessage());
			return;
		}
		successResult(json, "房间状态设置成功");
	}
	
	/*酒店房间可用数量管理*/
	protected void hotelStockInfo(HttpServletRequest request, JSONObject json, String string) {
		long hotelId = NumberUtil.parseLong(request.getParameter("hotelId"));
		long stockNum = NumberUtil.parseLong(request.getParameter("stockNum"));
		String roomType = request.getParameter("roomType");
		String price = request.getParameter("price");
		String userBaseId = ShiroSessionUtils.getSessionLocal().getBelongToUserInfo()
			.getUserBaseId();
		HotelTypeEnum hotelTypeEnum = HotelTypeEnum.getByCode(roomType);
		if (hotelTypeEnum == null) {
			failResult(json, "房间类型编码无效");
			return;
		}
		ScenicQueryResult result = scenicService.queryByUserBaseId(userBaseId);
		if (!result.isSuccess() || result.getQueryScenicInfo() == null) {
			failResult(json, "商户景区无效");
			return;
		}
		long scenicId = result.getQueryScenicInfo().getId();
		EsupplierBaseResult baseResult = null;
		if (hotelTypeEnum == HotelTypeEnum.LONGRENT) {
			String productId = request.getParameter("productId");
			String ruleType = request.getParameter("ruleType");
			String days = request.getParameter("days");
			String discount = request.getParameter("discount");
			String amount = request.getParameter("amount");
			HotelLongSetOrder order = new HotelLongSetOrder();
			order.setProductId(NumberUtil.parseLong(productId));
			order.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
			order.setRoomNum(stockNum);
			order.setRuleType(HotelRuleTypeEnum.getByCode(ruleType));
			if (StringUtil.isNotBlank(days)) {
				String[] day = days.split(",");
				String[] value = null;
				if (order.getRuleType() == HotelRuleTypeEnum.DISCOUNT) {
					value = discount.split(",");
				} else {
					value = amount.split(",");
				}
				List<HotelLongDetailInfo> detailInfos = Lists.newArrayList();
				for (int i = 0; i < day.length; i++) {
					HotelLongDetailInfo detailInfo = new HotelLongDetailInfo();
					detailInfo.setDays(NumberUtil.parseLong(day[i]));
					if (order.getRuleType() == HotelRuleTypeEnum.DISCOUNT) {
						double dis = NumberUtil.parseDouble(value[i]) * 100;
						detailInfo.setDiscount((long) dis);
					} else {
						detailInfo.setAmount(new Money(value[i]));
					}
					detailInfos.add(detailInfo);
				}
				order.setHotelLongDetailInfos(detailInfos);
			}
			order.setScenicKeyId(scenicId);
			baseResult = hotelsSetLongRoomSerivce.setLongHotelRoom(order);
		} else {
			HotelStockNumOrder hotelStockNumOrder = new HotelStockNumOrder();
			hotelStockNumOrder.setId(hotelId);
			hotelStockNumOrder.setStockNum(stockNum);
			hotelStockNumOrder.setScenicId(scenicId);
			hotelStockNumOrder.setPrice(new Money(NumberUtil.parseDouble(price)));
			hotelStockNumOrder.setHotelTypeEnum(hotelTypeEnum);
			baseResult = hotelsStockService.chgStockInfo(hotelStockNumOrder);
		}
		if (!baseResult.isSuccess()) {
			failResult(json, "房间可用数量设置失败：" + baseResult.getMessage());
			return;
		}
		successResult(json, "房间可用数量设置成功");
	}
	
	/*酒店房间数量变化*/
	protected void hotelOrderNumCheck(HttpServletRequest request, JSONObject json, String string) {
		long productId = NumberUtil.parseLong(request.getParameter("productId"));
		long checkNum = NumberUtil.parseLong(request.getParameter("checkNum"));
		String roomType = request.getParameter("roomType");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		HotelTypeEnum hotelTypeEnum = HotelTypeEnum.getByCode(roomType);
		if (hotelTypeEnum == null) {
			failResult(json, "房间价格类型无效");
			return;
		}
		HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
		orderNumOrder.setHotelTypeEnum(hotelTypeEnum);
		orderNumOrder.setProductId(productId);
		orderNumOrder.setCheckNum(checkNum);
		orderNumOrder.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
		orderNumOrder.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
		HotelOrderResult hotelOrderResult = hotelsStockService
			.getHotelOrderCheckInfo(orderNumOrder);
		if (!hotelOrderResult.isSuccess()) {
			failResult(json, "预订房间数量更新失败：" + hotelOrderResult.getMessage());
			return;
		}
		json.put("sumExecPrice", hotelOrderResult.getSumExecPrice().toStandardString());
		json.put("execPrice", hotelOrderResult.getExecPrice().toStandardString());
		json.put("sumMarketPrice", hotelOrderResult.getSumMarketPrice().toStandardString());
		json.put("maxHotelNum", hotelOrderResult.getMaxHotelNum());
		successResult(json, "预订房间数量更新成功");
	}
	
	/** 到店付款 */
	protected void shopOrScanPay(HttpServletRequest request, JSONObject json, String string) {
		String mobile = request.getParameter("mobile");
		String counts = request.getParameter("counts");
		/* 订单类型 */
		String payType = request.getParameter("payType");
		/* 扫码付参数 */
		String productId = request.getParameter("productId");
		/* 到店付需要参数 */
		String supplierId = request.getParameter("supplierId");
		String amount = request.getParameter("amount");
		/* 支付方式 */
		String payWay = request.getParameter("payWay");
		/* 余额支付密码 */
		String payPwd = request.getParameter("payPwd");
		
		String returnUrl = request.getParameter("returnUrl");
		if (StringUtil.equals("exn", request.getParameter("exn"))) {
			payPwd = AESUtil.decode(payPwd);
		}
		if (StringUtil.isEmpty(payType)
			|| (!payType.equals(SaleTypeEnum.O2O.getCode())
				&& !payType.equals(SaleTypeEnum.PAY_TO_SHOP.getCode()))) {
			failResult(json, "订单类型有误");
			return;
		}
		if (StringUtil.isBlank(mobile)) {
			UserQueryResult result = userQueryService
				.queryByUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			if (result.isSuccess() && result.getQueryUserInfo() != null) {
				mobile = result.getQueryUserInfo().getMobile();
			}
		}
		if (StringUtil.isEmpty(counts)) {
			counts = "1";
		}
		AppPayOrder order = new AppPayOrder();
		OrderInfo orderInfo = null;
		/* 扫码付款--团购 */
		if (payType.equals(SaleTypeEnum.O2O.getCode())) {
			ProductInfo productInfo = productService
				.findSupplierProductById(NumberUtil.parseLong(productId));
			if (productInfo == null) {
				failResult(json, "未找到该商品");
				return;
			}
			List<CartItemInfo> cartItemInfos = Lists.newArrayList();
			CartItemInfo info = new CartItemInfo();
			info.setProductId(Long.parseLong(productId));
			info.setQuantity(Integer.parseInt(counts));
			info.setPrice(productInfo.getPrice1());
			info.setSupplierId(productInfo.getSupplierId());
			info.setSupplierName(productInfo.getSupplierName());
			info.setName(productInfo.getProductName());
			info.setImage(productInfo.getSmallPicPath());
			cartItemInfos.add(info);
			BillSaveOrder billSaveOrder = new BillSaveOrder();
			billSaveOrder.setList(cartItemInfos);
			billSaveOrder.setMobileNumber(mobile);
			billSaveOrder.setSaleTypeEnum(SaleTypeEnum.getByCode(payType));
			billSaveOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			billSaveOrder.setNickname(ShiroSessionUtils.getSessionLocal().getNickname());
			BillSaveResult billSaveResult = orderService.saveOrderInfo(billSaveOrder);
			if (!billSaveResult.isSuccess()) {
				failResult(json, billSaveResult.getMessage());
				return;
			}
			orderInfo = billSaveResult.getOrderInfos().get(0);
			order.setTradeName("扫码付款");
		} else if (payType.equals(SaleTypeEnum.PAY_TO_SHOP.getCode())) { /* 到店付 */
			PayToShopOrder shopOrder = new PayToShopOrder();
			shopOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			shopOrder.setSellerId(supplierId);
			shopOrder.setTotalAmount(new Money(NumberUtil.parseDouble(amount)));
			BillSaveResult billSaveResult = orderService.payToShop(shopOrder);
			if (!billSaveResult.isSuccess()) {
				failResult(json, billSaveResult.getMessage());
				return;
			}
			orderInfo = billSaveResult.getOrderInfos().get(0);
			order.setTradeName("到店付款");
		}
		order.setIds(String.valueOf(orderInfo.getId()));
		order.setPayWay(payWay);
		order.setPayPwd(payPwd);
		order.setPartnerUserId(String.valueOf(ShiroSessionUtils.getSessionLocal().getUserId()));
		order.setReturnUrl(returnUrl);
		AppPayResult result = appPayService.creatPayOrder(order, getOpenApiContext());
		if (result.isSuccess()) {
			if (StringUtil.equals("BALANCE_PAYMENT", payWay)) {
				successResult(json, "支付成功");
			} else if (StringUtil.equals(PaymentTypeEnum.WECHATS_PAY.getCode(), payWay)) {
				json.put("map", result.getMap());
				json.put("url", result.getUrl());
				successResult(json, "获取支付链接成功");
			} else {
				json.put("url", result.getUrl());
				successResult(json, "获取支付链接成功");
			}
			
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 付款结果处理 */
	protected void depositResult(HttpServletRequest request, JSONObject json, String string) {
		
		Map<String, String> param = WebUtil.getRequestMap(request);
		String resultCode = param.get("resultCode");
		String executeStatus = param.get("executeStatus");
		if (StringUtil.equals("EXECUTE_SUCCESS", resultCode)
			|| StringUtil.equals("true", executeStatus)) {
			EsupplierBaseResult esupplierBaseResult = payService.paymentProcess(param);
			if (esupplierBaseResult.isSuccess()) {
				logger.info("支付成功_orderNo：" + param.get("orderNo"));
				json.put("success", "true");
				successResult(json, "支付成功");
			} else {
				if (StringUtil.isNotBlank(esupplierBaseResult.getMessage())
					&& esupplierBaseResult.getMessage().indexOf("已经处理") > -1) {
					json.put("success", "true");
				}
				failResult(json, esupplierBaseResult.getMessage());
			}
		} else {
			failResult(json, param.get("resultMessage"));
		}
		
	}
	
	/** 取消订单 **/
	protected void cancelOrder(HttpServletRequest request, JSONObject json, String string) {
		CancelBillOrder billOrder = new CancelBillOrder();
		String id = request.getParameter("id");
		if (StringUtil.isBlank(id)) {
			failResult(json, "订单号不能为空");
			return;
		}
		billOrder.setBizNo(NumberUtil.parseLong(id));
		billOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.cancelOrder(billOrder);
		if (baseResult.isSuccess()) {
			successResult(json, "取消订单成功");
		} else {
			failResult(json, baseResult.getMessage());
		}
	}
	
	/** 批量取消订单 **/
	protected void cancelBatchOrder(HttpServletRequest request, JSONObject json, String string) {
		CancelBillOrder billOrder = new CancelBillOrder();
		String batchNo = request.getParameter("batchNo");
		if (StringUtil.isBlank(batchNo)) {
			failResult(json, "订单号批次号不能为空");
			return;
		}
		billOrder.setBatchNo(batchNo);
		billOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		setProcessOrder(billOrder);
		EsupplierBaseResult baseResult = orderService.cancelBatchOrder(billOrder);
		if (baseResult.isSuccess()) {
			successResult(json, "取消订单成功");
		} else {
			failResult(json, baseResult.getMessage());
		}
	}
	
	/** 根据地址算运费 */
	protected void postFeeByArea(HttpServletRequest request, JSONObject json, String string) {
		String productId = request.getParameter("productId");
		String areaName = request.getParameter("areaName");
		if (StringUtil.isNotBlank(productId)) {
			DeliveryInfo deliveryInfo = deliveryService
				.getDeliveryByArea(NumberUtil.parseLong(productId), areaName);
			Map<String, Object> map = new HashMap<String, Object>();
			if (deliveryInfo != null) {
				map.put("postFee", deliveryInfo.getExpress());
				map.put("productId", productId);
				map.put("areaName", areaName);
				json.put("info", map);
				successResult(json, "查询运费成功");
			} else {
				DeliveryInfo normal = deliveryService.getDeliveryByArea(
					NumberUtil.parseLong(productId), DeliverAreaEnum.NORMAL.getCode());
				if (normal != null) {
					map.put("postFee", normal.getExpress());
					map.put("productId", productId);
					map.put("areaName", areaName);
					json.put("info", map);
					successResult(json, "查询运费成功");
				} else {
					failResult(json, "未查到商品信息");
				}
			}
		} else {
			failResult(json, "商品id不能为空");
		}
	}
	
	/** 退款/货列表 */
	protected void refundList(HttpServletRequest request, JSONObject json, String string) {
		QueryRefundOrder queryRefundOrder = new QueryRefundOrder();
		WebUtil.setPoPropertyByRequest(queryRefundOrder, request);
		queryRefundOrder.setOrderByEnum(BillSearchOrderByEnum.ADD_DATE_DESC);
		String userType = ShiroSessionUtils.getSessionLocal().getUserBizType().getCode();
		if (userType.equals(UserBizTypeEnum.BUYER.getCode())) {
			queryRefundOrder.setBuyerUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		} else if (userType.equals(UserBizTypeEnum.SELLER.getCode())) {
			queryRefundOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		String orderType = request.getParameter("orderType");
		if (StringUtil.isNotEmpty(orderType)) {
			if (StringUtil.isNotEmpty(orderType)) {
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.B2C) {
					queryRefundOrder.setSaleTypeB2c(BooleanEnum.YES);
					queryRefundOrder.setSaleTypeO2o(BooleanEnum.NO);
				}
				if (SaleTypeEnum.getByCode(orderType) == SaleTypeEnum.O2O) {
					queryRefundOrder.setSaleTypeB2c(BooleanEnum.NO);
					queryRefundOrder.setSaleTypeO2o(BooleanEnum.YES);
				}
			}
		}
		int pages = NumberUtil.parseInt(request.getParameter("pageNumber"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 10);
		queryRefundOrder.setPageNumber(pages);
		queryRefundOrder.setPageSize(pagesize);
		if (queryRefundOrder.getStatusEnum() == null) {
			queryRefundOrder.setStatusEnum(
				RefundProcessStatusEnum.getByCode(request.getParameter("statusEnum")));
		}
		if (queryRefundOrder.getRefundTypeEnum() == null) {
			queryRefundOrder.setRefundTypeEnum(
				RefundTypeEnum.getByCode(request.getParameter("refundTypeEnum")));
		}
		QueryBaseBatchResult<RefundOrderInfo> baseBatchResult = orderRefundService
			.queryRefundCondition(queryRefundOrder);
		if (baseBatchResult.isSuccess()) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			for (RefundOrderInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<>();
				//				OrderInfo orderInfo = orderService.findOrderById(info.getOrderId());
				//				if (orderInfo != null) {
				//					map.put("payAmount", orderInfo.getPayAmount().toString());
				//				}
				map.put("refundId", toString(info.getRefundId()));
				map.put("orderId", toString(info.getOrderId()));
				map.put("productId", toString(info.getProductId()));
				map.put("productName", toString(info.getProductName()));
				map.put("picPath", toString(info.getPicPath()));
				map.put("price", toString(info.getPrice()));
				map.put("quantity", toString(info.getQuantity()));
				map.put("oldQuantity", toString(info.getOldQuantity()));
				map.put("refundAmount", toString(info.getRefundAmount()));
				map.put("totalAmount", toString(info.getTotalAmount()));
				map.put("refundTypeEnum", info.getRefundType().getCode());
				map.put("statusEnum", info.getStatus().getCode());
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("info", list);
			successResult(json, "退款/货列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/** 退款.退货详情查询 */
	protected void refundInfo(HttpServletRequest request, JSONObject json, String des) {
		String refundId = request.getParameter("refundId");
		if (StringUtil.isBlank(refundId)) {
			json.put("code", 0);
			json.put("message", "订单id不能为空");
			return;
		}
		RefundOrderInfo info = orderRefundService.findById(NumberUtil.parseLong(refundId));
		long currentUserId = ShiroSessionUtils.getSessionLocal().getUserId();
		if (info != null) {
			if (info.getBuyerUserId() != currentUserId	&& info.getSupplierId() != currentUserId
				&& ShiroSessionUtils.getSessionLocal().getUserBizType() != UserBizTypeEnum.ADMIN) {
				json.put("code", 0);
				json.put("message", "无权限操作");
				return;
			}
			Map<String, Object> map = new HashMap<>();
			CommonAttachmentQueryOrder attachmentQueryOrder = new CommonAttachmentQueryOrder();
			attachmentQueryOrder.setBizNo(String.valueOf(refundId));
			List<CommonAttachmentTypeEnum> moduleTypeList = Lists.newArrayList();
			moduleTypeList.add(CommonAttachmentTypeEnum.ORDER_REFUND_INFO);
			attachmentQueryOrder.setModuleTypeList(moduleTypeList);
			QueryBaseBatchResult<CommonAttachmentInfo> result = commonAttachmentService
				.queryCommonAttachment(attachmentQueryOrder);
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for (CommonAttachmentInfo attachmentInfo : result.getPageList()) {
				Map<String, String> attachMap = new HashMap<>();
				attachMap.put("requestPath", attachmentInfo.getRequestPath());
				list.add(attachMap);
			}
			//			OrderInfo orderInfo = orderService.findOrderById(info.getOrderId());
			//			if (orderInfo != null) {
			//				map.put("payAmount", orderInfo.getPayAmount().toString());
			//			}
			map.put("attachmentInfo", list);
			map.put("applyDate", toString(DateUtil.simpleFormat(info.getApplyDate())));
			map.put("refundDesc", toString(info.getRefundDesc()));
			map.put("arriveDate", DateUtil.simpleFormat(info.getArriveDate()));
			map.put("refundId", toString(info.getRefundId()));
			map.put("orderId", toString(info.getOrderId()));
			map.put("productId", toString(info.getProductId()));
			map.put("productName", toString(info.getProductName()));
			map.put("picPath", toString(info.getPicPath()));
			map.put("logisticsCompanies", toString(info.getLogisticsCompanies()));
			map.put("logisticsNo", toString(info.getLogisticsNo()));
			map.put("refundAmount", toString(info.getRefundAmount()));
			map.put("totalAmount", toString(info.getTotalAmount()));
			map.put("refundTypeEnum", info.getRefundType().getCode());
			map.put("quantity", info.getQuantity());
			map.put("refundStatus", info.getStatus());
			json.put("info", map);
			successResult(json, "订单详情查询成功");
		} else {
			failResult(json, "未查到该订单");
		}
		
	}
	
	/** 退款申请 */
	protected void refundApply(HttpServletRequest request, JSONObject json, String string) {
		//	String[] uploadImgUrls = request.getParameterValues("uploadImgUrls");  真美美APP只能传字符串
		String uploadImgUrlsStr = request.getParameter("uploadImgUrls");
		uploadImgUrlsStr = StringUtil.replaceChars(uploadImgUrlsStr, "\"", "");
		uploadImgUrlsStr = StringUtil.replaceChars(uploadImgUrlsStr, "(", "");
		uploadImgUrlsStr = StringUtil.replaceChars(uploadImgUrlsStr, ")", "");
		String id = request.getParameter("id");
		String refundType = request.getParameter("refundType");
		RefundApplyOrder processOrder = new RefundApplyOrder();
		WebUtil.setPoPropertyByRequest(processOrder, request);
		if (StringUtil.isNotBlank(uploadImgUrlsStr)) {
			String[] uploadImgUrls = uploadImgUrlsStr.split(",");
			processOrder.setUploadImgUrls(uploadImgUrls);
		}
		processOrder.setOrderId(NumberUtil.parseLong(id, 0));
		processOrder.setRefundType(RefundTypeEnum.getByCode(refundType));
		processOrder.setBizNo(NumberUtil.parseLong(id, 0));
		processOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		if (!processOrder.getRefundAmount().greaterThan(new Money())) {
			failResult(json, "退款金额必须大于0");
			return;
		}
		EsupplierBaseResult result = orderService.refundApply(processOrder);
		if (result.isSuccess()) {
			successResult(json, "提交成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 退货确认 */
	protected void refundGoodsConfirm(HttpServletRequest request, JSONObject json, String string) {
		long refundId = NumberUtil.parseLong(request.getParameter("refundId"));
		RefundOrderInfo refundOrderInfo = orderRefundService.findById(refundId);
		long currentUserId = ShiroSessionUtils.getSessionLocal().getUserId();
		if (refundOrderInfo.getBuyerUserId() != currentUserId) {
			failResult(json, "无权限操作他人数据");
			return;
		}
		RefundGoodsProcessOrder processOrder = new RefundGoodsProcessOrder();
		WebUtil.setPoPropertyByRequest(processOrder, request);
		this.setProcessOrder(processOrder);
		processOrder.setBizNo(refundId);
		EsupplierBaseResult result = orderRefundService.processRefundGoods(processOrder);
		if (result.isSuccess()) {
			successResult(json, "提交成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/** 取消收藏 */
	protected void deletCollect(HttpServletRequest request, JSONObject json, String string) {
		String productId = request.getParameter("productId");
		String supplierId = request.getParameter("supplierId");
		if (StringUtil.isNotBlank(productId) || StringUtil.isNotBlank(supplierId)) {
			EsupplierBaseResult result = productUserService.deleteProductUser(
				ShiroSessionUtils.getSessionLocal().getUserId(), NumberUtil.parseLong(productId, 0),
				NumberUtil.parseLong(supplierId, 0));
			if (result.isSuccess()) {
				successResult(json, "成功取消收藏");
			} else {
				failResult(json, "没找到该收藏商品");
			}
		} else {
			failResult(json, "收藏商品的Id不能为空");
		}
	}
	
	/** 收藏 列表 */
	protected void collectList(HttpServletRequest request, JSONObject json, String string) {
		
		CollectionStateEnum collectionStateEnum = CollectionStateEnum
			.getByCode(request.getParameter("type"));
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		/*收藏数*/
		PopUserOrder userOrder = new PopUserOrder();
		userOrder.setType(PopUserTypeEnum.COLLECT);
		userOrder.setUserId(userId);
		long collectCount = popUserService.countPopInfo(userOrder);
		json.put("countTasteCollect", collectCount);
		/*点赞数*/
		userOrder.setType(PopUserTypeEnum.AGREE);
		long agreeCount = popUserService.countPopInfo(userOrder);
		json.put("countTasteAgree", agreeCount);
		/*商户商品收藏数*/
		productUserService.countCollect(userId, json);
		if (collectionStateEnum == CollectionStateEnum.HOTEL_COL) {
			SupplierHotelQueryOrder queryOrder = new SupplierHotelQueryOrder();
			WebUtil.setPoPropertyByRequest(queryOrder, request);
			queryOrder.setUserId(userId);
			QueryBaseBatchResult<SupplierInfo> baseBatchResult = supplierService
				.searchCollectHotelSupplier(queryOrder);
			if (baseBatchResult.isSuccess()) {
				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
				Map<String, String> map = null;
				for (SupplierInfo supplierInfo : baseBatchResult.getPageList()) {
					map = new HashMap<>();
					map.put("supplierId", toString(supplierInfo.getSupplierId()));
					map.put("merchantPicPath1", supplierInfo.getMerchantPicPath1());
					map.put("storeName", supplierInfo.getStoreName());
					map.put("nickName", supplierInfo.getNickname());
					map.put("reviewProduct", toString(supplierInfo.getReviewProduct()));
					map.put("scenicName", supplierInfo.getScenicName());
					map.put("merchantType", supplierInfo.getMerchantType());
					map.put("distance", String.valueOf(supplierInfo.getDistance()));
					map.put("toShop",
						supplierInfo.getToShop() == null ? "" : supplierInfo.getToShop().getCode());
					map.put("shopGrade", supplierInfo.getShopGrade());
					map.put("roomLowestPrice",
						supplierInfo.getRoomLowestPrice().equals(new Money(0)) ? ""
							: supplierInfo.getRoomLowestPrice().toStandardString());
					map.put("specialRoom", supplierInfo.getSpecialRoom() == null ? ""
						: supplierInfo.getSpecialRoom().getCode());
					map.put("recommendRoom", supplierInfo.getRecommendRoom() == null ? ""
						: supplierInfo.getRecommendRoom().getCode());
					map.put("longRentRoom", supplierInfo.getLongRentRoom() == null ? ""
						: supplierInfo.getLongRentRoom().getCode());
					map.put("morningRoom", supplierInfo.getMorningRoom() == null ? ""
						: supplierInfo.getMorningRoom().getCode());
					map.put("runState", toString(supplierInfo.getRunState()));
					list.add(map);
				}
				json.put("totalPage", baseBatchResult.getPageCount());
				json.put("list", list);
				successResult(json, "收藏列表查询成功");
			} else {
				failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
			}
		} else if (collectionStateEnum == CollectionStateEnum.PRODUCT_COL
						|| collectionStateEnum == CollectionStateEnum.SERVICE_COL
					|| collectionStateEnum == CollectionStateEnum.SUPPLIER_COL) {
			ProductUserOrder order = new ProductUserOrder();
			WebUtil.setPoPropertyByRequest(order, request);
			order.setUserId(userId);
			order.setHotels(BooleanEnum.NO);
			order.setCollectionStateEnum(collectionStateEnum);
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productUserService
				.getProductUserList(order);
			if (baseBatchResult.isSuccess()) {
				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
				Map<String, String> map = null;
				for (ProductInfo info : baseBatchResult.getPageList()) {
					map = new HashMap<>();
					SupplierInfo supplierInfo = info.getSupplierInfo();
					if (supplierInfo != null) {
						map.put("supplierId", toString(supplierInfo.getSupplierId()));
						map.put("merchantPicPath", supplierInfo.getMerchantPicPath1());
						map.put("storeName", supplierInfo.getStoreName());
						map.put("nickName", supplierInfo.getNickname());
						map.put("scenicName", supplierInfo.getScenicName());
						map.put("merchantType", supplierInfo.getMerchantType());
						
						map.put("runState", toString(supplierInfo.getRunState()));
					} else {
						map.put("supplierId", "");
						map.put("merchantPicPath", "");
						map.put("storeName", "");
						map.put("nickName", "");
						map.put("scenicName", "");
						map.put("merchantType", "");
					}			
					if(collectionStateEnum == CollectionStateEnum.PRODUCT_COL){
						map.put("saleTypeO2o", info.getSaleTypeO2o().code());
						map.put("saleTypeHotels", info.getSaleTypeHotels().code());
					}
					if(collectionStateEnum == CollectionStateEnum.SUPPLIER_COL){
						map.put("saleTypeO2o", info.getSupplierInfo().getO2o().code());
						map.put("saleTypeHotels", info.getSupplierInfo().getHotels().code());
					}
					map.put("productId", toString(info.getProductId()));
					map.put("productStatus", toString(info.getProductStatus()));
					map.put("productName", info.getProductName());
					map.put("pSmallPicPath", info.getSmallPicPath());
					map.put("groupBuyDetail", info.getGroupBuyDetail());
					map.put("price1",
						info.getPrice1() != null ? info.getPrice1().toStandardString() : "");
					list.add(map);
				}
				json.put("totalPage", baseBatchResult.getPageCount());
				json.put("list", list);
				successResult(json, "收藏列表查询成功");
			} else {
				failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
			}
		} else if (collectionStateEnum == CollectionStateEnum.COLLECT
					|| collectionStateEnum == CollectionStateEnum.AGREE) { /*攻略收藏和点赞*/
			EsupplierBaseResult result = new EsupplierBaseResult();
			String type = request.getParameter("type");
			PopUserTypeEnum popUserTypeEnum = PopUserTypeEnum.getByCode(type);
			if (popUserTypeEnum == null) {
				failResult(json, "选择的操作分类不对");
				return;
			}
			PopUserOrder popUserOrder = new PopUserOrder();
			WebUtil.setPoPropertyByRequest(popUserOrder, request);
			popUserOrder.setUserId(userId);
			popUserOrder.setType(popUserTypeEnum);
			QueryBaseBatchResult<PopInfo> baseResult = popService
				.getPopUserContainScenic(popUserOrder);
			if (baseResult.isSuccess()) {
				List<Map<String, String>> list = new ArrayList<>();
				Map<String, String> map = null;
				for (PopInfo info : baseResult.getPageList()) {
					map = new HashMap<>();
					AppCommonUtil.beanToMap(info, map);
					map.remove("scenicInfo");
					if (info.getScenicInfo() != null) {
						map.put("name", info.getScenicInfo().getName());
						map.put("address", info.getScenicInfo().getAddress());
						map.put("detail", info.getScenicInfo().getDetail());
					} else {
						map.put("name", "");
						map.put("address", "");
						map.put("detail", "");
					}
					map.remove("popModuleVOInfo");
					if (info.getPopModuleVOInfo() != null) {
						map.put("parentName", info.getPopModuleVOInfo().getModuleName());
					} else {
						map.put("parentName", "");
					}
					list.add(map);
				}
				json.put("list", list);
				json.put("totalPage", baseResult.getPageCount());
				successResult(json, "攻略收藏|点赞列表查询成功");
			} else {
				failResult(json, StringUtil.defaultIfBlank(result.getMessage(), "查询失败"));
			}
		}
		
	}
	
	/** 平台关键词 */
	protected void keyWords(HttpServletRequest request, JSONObject json, String string) {
		json.put("list", productTypeService.getSecondKeyWords());
		successResult(json, "关键词查询成功");
	}
	
	/** 加入收藏 */
	protected void collect(HttpServletRequest request, JSONObject json, String string) {
		String productId = request.getParameter("productId");
		String supplierId = request.getParameter("supplierId");
		if (StringUtil.isNotBlank(productId)) {
			ProductUserOrder order = new ProductUserOrder();
			ProductDomain productDomain = productDomainRepository
				.active(NumberUtil.parseLong(productId), false);
			if (productDomain != null && productDomain.getSaleTypeB2c() == BooleanEnum.YES) {
				order.setCollectionStateEnum(CollectionStateEnum.PRODUCT_COL);
			} else {
				order.setCollectionStateEnum(CollectionStateEnum.SERVICE_COL);
			}
			order.setProductId(NumberUtil.parseLong(productId));
			
			order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			EsupplierBaseResult result = productUserService.insertProductUser(order);
			if (result.isSuccess()) {
				successResult(json, "成功加入收藏");
			} else {
				failResult(json, "该商品已收藏，请勿重复");
			}
		} else if (StringUtil.isNotBlank(supplierId)) {
			ProductUserOrder order = new ProductUserOrder();
			order.setSupplierId(NumberUtil.parseLong(supplierId));
			order.setCollectionStateEnum(CollectionStateEnum.SUPPLIER_COL);
			order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			EsupplierBaseResult result = productUserService.insertProductUser(order);
			if (result.isSuccess()) {
				successResult(json, "成功加入收藏");
			} else {
				failResult(json, "该商户已收藏，请勿重复");
			}
		} else {
			failResult(json, "收藏Id不能为空");
		}
		
	}
	
	/** 评价商品 */
	protected void pingjiaSub(HttpServletRequest request, JSONObject json, String string) {
		long id = NumberUtil.parseLong(request.getParameter("id"));
		TradeReviewCreateOrder trCreateOrder = new TradeReviewCreateOrder();
		WebUtil.setPoPropertyByRequest(trCreateOrder, request);
		TradeReviewOrder reviewOrder = new TradeReviewOrder();
		reviewOrder.setReviewCreateOrder(trCreateOrder);
		reviewOrder.setBizNo(id);
		setProcessOrder(reviewOrder);
		trCreateOrder.setBuyerId(ShiroSessionUtils.getSessionLocal().getUserId());
		trCreateOrder.setBuyerIp(IPUtil.getIpAddr(request));
		trCreateOrder.setBuyerName(ShiroSessionUtils.getSessionLocal().getUserName());
		trCreateOrder.setOrderId(reviewOrder.getBizNo());
		// trCreateOrder.setBuyerRealName(ShiroSessionUtils.getSessionLocal().getRealName());
		// trCreateOrder.setBuyerNickName(ShiroSessionUtils.getSessionLocal().getNickname());
		EsupplierBaseResult baseResult = orderService.tradeReview(reviewOrder);
		if (baseResult.isSuccess()) {
			successResult(json, "评价成功");
		} else {
			failResult(json, "评价失败：" + baseResult.getMessage());
		}
	}
	
	/** 评价商品点赞 */
	protected void pingjiaLike(HttpServletRequest request, JSONObject json, String string) {
		long commentId = NumberUtil.parseLong(request.getParameter("commentId"));
		String operateType = request.getParameter("operateType");
		String commentLikeType = request.getParameter("commentLikeType");
		TradeReviewLikeOrder likeOrder = new TradeReviewLikeOrder();
		WebUtil.setPoPropertyByRequest(likeOrder, request);
		CommentLikeTypeEnum likeTypeEnum = CommentLikeTypeEnum.getByCode(commentLikeType);
		if (likeTypeEnum == null) {
			likeTypeEnum = CommentLikeTypeEnum.product;
		}
		likeOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		likeOrder.setProcessName(ShiroSessionUtils.getSessionLocal().getRealName());
		likeOrder.setCommentLikeTypeEnum(likeTypeEnum);
		likeOrder.setOperateTypeEnum(OperateTypeEnum.getByCode(operateType));
		EsupplierBaseResult baseResult = orderService.tradeReviewLike(likeOrder);
		if (baseResult.isSuccess()) {
			successResult(json, likeTypeEnum.getMessage() + "点赞成功");
		} else {
			failResult(json, likeTypeEnum.getMessage() + "评价失败：" + baseResult.getMessage());
		}
	}
	
	/** 获取团购商品类型 */
	protected void productType(HttpServletRequest request, JSONObject json, String string) {
		successResult(json, "获取商品类型成功");
		String ptCode = request.getParameter("ptCode");
		String scenicId = request.getParameter("scenicId");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		if (StringUtil.isNotBlank(ptCode)) {
			ProductTypeQueryOrder order = new ProductTypeQueryOrder();
			order.setPtCode(ptCode);
			order.setPageSize(100);
			order.setPageNumber(1);
			QueryBaseBatchResult<ProductTypeInfo> batchResult = productTypeService
				.findByCondition(order);
			for (ProductTypeInfo info : batchResult.getPageList()) {
				ProductInfoOrder productOrder = new ProductInfoOrder();
				productOrder.setProductType(info.getPtCode());
				productOrder.setSaleTypeO2o(BooleanEnum.YES);
				productOrder.setSaleTypeB2c(null);
				productOrder.setProductStatus(ProductStatusEnum.ON);
				/*所属景区*/
				if (StringUtil.isNotEmpty(scenicId)) {
					UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(scenicId);
					if (userQueryResult.getQueryUserInfo() != null) {
						productOrder
							.setResortsBusinessId(userQueryResult.getQueryUserInfo().getUserId());
					}
				}
				long productCount = productService.getProductCount(productOrder);
				map = new HashMap<String, String>();
				map.put("ptCode", info.getPtCode());
				map.put("ptTypeName", info.getPtTypeName());
				map.put("productCount", String.valueOf(productCount));
				list.add(map);
			}
		} else {
			ProductTypeQueryOrder queryOrder = new ProductTypeQueryOrder();
			List<ProductTypeInfo> list0 = productTypeService.getSecondProductType(queryOrder);
			for (ProductTypeInfo info : list0) {
				ProductInfoOrder productOrder = new ProductInfoOrder();
				productOrder.setProductType(info.getPtCode());
				productOrder.setSaleTypeO2o(BooleanEnum.YES);
				productOrder.setProductStatus(ProductStatusEnum.ON);
				long productCount = productService.getProductCount(productOrder);
				map = new HashMap<String, String>();
				map.put("ptCode", info.getPtCode());
				map.put("ptTypeName", info.getPtTypeName());
				map.put("productCount", String.valueOf(productCount));
				list.add(map);
			}
		}
		
		json.put("list", list);
		
		successResult(json, "获取产品列表成功");
	}
	
	/** 热卖商品 */
	protected void indexRecommend(HttpServletRequest request, JSONObject json, String string) {
		ProductRecommendOrder order = new ProductRecommendOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		String recommendType = StringUtil.defaultIfEmpty(request.getParameter("recommendType"),
			ProductRecommendTypeEnum.PRODUCT_TOP.getCode());
		order.setRecommendType(ProductRecommendTypeEnum.getByCode(recommendType));
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null) {
			order.setUserId(sessionLocal.getUserId());
		}
		String saleType = request.getParameter("saleType");
		SaleTypeEnum saleTypeEnum = SaleTypeEnum.getByCode(saleType);
		if (SaleTypeEnum.O2O == saleTypeEnum) {
			order.setSaleTypeO2o(BooleanEnum.YES);
		} else if (SaleTypeEnum.B2C == saleTypeEnum) {
			order.setSaleTypeB2c(BooleanEnum.YES);
		} else {
			order.setSaleTypeO2oAndB2c(BooleanEnum.YES);
		}
		order.setOrderNormal("NORMAL");
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productRecommendService
			.getSupplierAndProductRecommendList(order);
		//			.getProductRecommendList(order);
		if (baseBatchResult.isSuccess()) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			for (ProductInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<String, String>();
				map.put("productId", toString(info.getProductId()));
				map.put("productName", info.getProductName());
				map.put("smallPicPath", info.getSmallPicPath());
				map.put("bigPicPath", info.getBigPicPath());
				map.put("groupBuyDetail", info.getGroupBuyDetail());
				map.put("price1", info.getPrice1().toStandardString());
				map.put("marketPrice", info.getMarketPrice().toStandardString());
				map.put("payedCount", toString(info.getPayedCount()));
				map.put("isEnshrine", toString(info.getIsEnshrine()));
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "收藏列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
		
	}
	
	/** 猜你喜欢 */
	protected void indexRecommend2(HttpServletRequest request, JSONObject json, String string) {
		SupplierProductSearchOrder order = new SupplierProductSearchOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setSaleTypeO2OAndB2C(BooleanEnum.YES);
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
			.getSupplierAndProductList(order);
		if (baseBatchResult.isSuccess()) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			for (ProductInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<String, String>();
				map.put("productId", toString(info.getProductId()));
				map.put("productName", info.getProductName());
				map.put("smallPicPath", info.getSmallPicPath());
				map.put("price1", info.getPrice1().toStandardString());
				if (info.getSaleTypeB2c() != null) {
					map.put("saleTypeB2c", info.getSaleTypeB2c().getCode());
				}
				map.put("marketPrice", info.getMarketPrice().toStandardString());
				map.put("groupBuyDetail", info.getGroupBuyDetail());
				map.put("payedCount", toString(info.getPayedCount()));
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "猜你喜欢列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
		
	}
	
	/** 团购商品列表 */
	protected void productList(HttpServletRequest request, JSONObject json, String string) {
		SupplierProductSearchOrder order = new SupplierProductSearchOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setProductStatus(ProductStatusEnum.ON);
		
		String beginPrice = request.getParameter("beginPrice");
		String endPrice = request.getParameter("endPrice");
		String firstRecord = request.getParameter("lastRecord");
		String scenicId = request.getParameter("scenicId");
		long fontSupplierId = NumberUtil.parseLong(request.getParameter("fontSupplierId"), 0);
		boolean next = fontSupplierId > 0;
		long lastRecord = NumberUtil.parseLong(firstRecord, 0);
		if (StringUtil.isNotBlank(beginPrice)) {
			order.setBeginPrice(Money.amout(beginPrice));
		}
		if (StringUtil.isNotBlank(endPrice)) {
			order.setEndPrice(Money.amout(endPrice));
		}
		order.setSaleTypeO2O(BooleanEnum.YES);
		order.setFirstRecord(NumberUtil.parseLong(firstRecord, 0));
		order.setPageSize(50);
		/*所属景区*/
		if (StringUtil.isNotEmpty(scenicId)) {
			UserQueryResult userQueryResult = userQueryService.queryByUserBaseId(scenicId);
			if (userQueryResult.getQueryUserInfo() != null) {
				order.setResortsBusinessId(userQueryResult.getQueryUserInfo().getUserId());
			}
		}
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
			.getSupplierAndProductList(order);
		Map<Long, Object> keyMap = new HashMap<>();
		if (baseBatchResult.isSuccess()) {
			// 返回数据结构：每个商户一条数据，
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			
			List<Map<String, Object>> productList = null;
			Map<String, Object> productMap = null;
			long supplierId = 0;
			int index = 0;
			for (ProductInfo info : baseBatchResult.getPageList()) {
				lastRecord++;
				SupplierInfo supplierInfo = info.getSupplierInfo();
				if (next && fontSupplierId == supplierInfo.getSupplierId()) {
					logger.info("前一页已有该商户{}的数据，跳过", fontSupplierId);
					continue;
				}
				if (keyMap.containsKey(info.getSupplierId())) {
					Map<String, Object> preMap = (Map<String, Object>) keyMap
						.get(info.getSupplierId());
					if (((List<Map<String, Object>>) preMap.get("producList")).size() >= 2) {
						preMap.put("more", "1");
						continue;
					} else {
						List<Map<String, Object>> thisProductList = (List<Map<String, Object>>) preMap
							.get("producList");
						productMap = new HashMap<String, Object>();
						setList(productMap, info);
						thisProductList.add(productMap);
						
					}
				} else {
					
					map = new HashMap<String, Object>();
					List<String> imgList = new ArrayList<String>();
					supplierId = supplierInfo.getSupplierId();
					map.put("supplierId", toString(supplierId));
					map.put("storeName", supplierInfo.getStoreName());
					map.put("nickName", supplierInfo.getNickname());
					map.put("address", supplierInfo.getAddress());
					map.put("mobile", supplierInfo.getMobile());
					map.put("spendPer", supplierInfo.getSpendPer().toStandardString());
					if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath1())) {
						imgList.add(supplierInfo.getMerchantPicPath1());
					}
					if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath2())) {
						imgList.add(supplierInfo.getMerchantPicPath2());
					}
					if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath3())) {
						imgList.add(supplierInfo.getMerchantPicPath3());
					}
					if (StringUtil.isNotBlank(supplierInfo.getMerchantPicPath4())) {
						imgList.add(supplierInfo.getMerchantPicPath4());
					}
					map.put("reviewAverage", toString(supplierInfo.getReviewAverageDefault()));
					map.put("imgList", imgList);
					map.put("merchantType", supplierInfo.getMerchantType());
					map.put("scenicName", supplierInfo.getScenicName());
					map.put("toShop", supplierInfo.getToShop().getCode());
					map.put("shopGrade", supplierInfo.getShopGrade());
					map.put("distance", String.valueOf(supplierInfo.getDistance()));
					productList = new ArrayList<Map<String, Object>>();
					productMap = new HashMap<>();
					setList(productMap, info);
					productList.add(productMap);
					map.put("producList", productList);
					map.put("more", "0");
					list.add(map);
					index++;
					keyMap.put(info.getSupplierId(), map);
				}
				if (list.size() >= 10) {
					break;
				}
			}
			json.put("lastRecord", lastRecord);
			json.put("totalCount", baseBatchResult.getTotalCount());
			json.put("list", list);
			successResult(json, "商品列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/** 邮购商品列表 */
	protected void b2cProductList(HttpServletRequest request, JSONObject json, String string) {
		SupplierProductSearchOrder order = new SupplierProductSearchOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setProductStatus(ProductStatusEnum.ON);
		String beginPrice = request.getParameter("beginPrice");
		String endPrice = request.getParameter("endPrice");
		String saleType = request.getParameter("saleType");
		SaleTypeEnum saleTypeEnum = SaleTypeEnum.getByCode(saleType);
		if (saleTypeEnum == null) {
//			successResult(json, "商品类型有误！");
//			return;
			order.setSaleTypeO2OAndHotels(BooleanEnum.YES);
		}
		String scenicId = request.getParameter("scenicId");
		if (StringUtil.isNotEmpty(scenicId)) {
			if (scenicId.length() == 20) {
				UserQueryResult queryResult = userQueryService.queryByUserBaseId(scenicId);
				if (queryResult.getQueryUserInfo() != null) {
					order.setResortsBusinessId(queryResult.getQueryUserInfo().getUserId());
				}
			} else {
				order.setResortsBusinessId(Long.parseLong(request.getParameter("scenicId")));
			}
		}
		if (StringUtil.isNotBlank(beginPrice)) {
			order.setBeginPrice(Money.amout(beginPrice));
		}
		if (StringUtil.isNotBlank(endPrice)) {
			order.setEndPrice(Money.amout(endPrice));
		}
		if (saleTypeEnum == SaleTypeEnum.O2O) {
			order.setSaleTypeO2O(BooleanEnum.YES);
		}
		if (saleTypeEnum == SaleTypeEnum.B2C) {
			order.setSaleTypeB2c(BooleanEnum.YES);
		}
		if(saleTypeEnum == SaleTypeEnum.HOTELS){
			order.setSaleTypeHotels(BooleanEnum.YES);
		}
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
			.getSupplierAndProductList(order);
		Map<Long, Object> keyMap = new HashMap<>();
		if (baseBatchResult.isSuccess()) {
			// 返回数据结构：每个商户一条数据，
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			long supplierId = 0;
			for (ProductInfo info : baseBatchResult.getPageList()) {
				SupplierInfo supplierInfo = info.getSupplierInfo();
				map = new HashMap<String, Object>();
				supplierId = supplierInfo.getSupplierId();
				map.put("supplierId", toString(supplierId));
				map.put("storeName", supplierInfo.getStoreName());
				map.put("nickName", supplierInfo.getNickname());
				map.put("address", supplierInfo.getAddress());
				map.put("mobile", supplierInfo.getMobile());
				map.put("spendPer", supplierInfo.getSpendPer().toStandardString());
				map.put("reviewAverage", toString(supplierInfo.getReviewAverageDefault()));
				map.put("merchantType", supplierInfo.getMerchantType());
				map.put("scenicName", supplierInfo.getScenicName());
				setList(map, info);
				list.add(map);
				keyMap.put(info.getSupplierId(), map);
			}
			json.put("totalCount", baseBatchResult.getTotalCount());
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "邮购商品列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/** 旅游线路列表 */
	protected void lineList(HttpServletRequest request, JSONObject json, String string) {
		SupplierProductSearchOrder order = new SupplierProductSearchOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setProductStatus(ProductStatusEnum.ON);
		String beginPrice = request.getParameter("beginPrice");
		String endPrice = request.getParameter("endPrice");
		
		if (StringUtil.isNotBlank(beginPrice)) {
			order.setBeginPrice(Money.amout(beginPrice));
		}
		if (StringUtil.isNotBlank(endPrice)) {
			order.setEndPrice(Money.amout(endPrice));
		}
		order.setProductVaryEnum(ProductVaryEnum.line);
		order.setApproveState(null);
		order.setMerchantState(null);
		QueryBaseBatchResult<ProductInfo> baseBatchResult = productService
			.getSupplierAndProductList(order);
		Map<Long, Object> keyMap = new HashMap<>();
		if (baseBatchResult.isSuccess()) {
			// 返回数据结构：每个商户一条数据，
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			long supplierId = 0;
			for (ProductInfo info : baseBatchResult.getPageList()) {
				SupplierInfo supplierInfo = info.getSupplierInfo();
				map = new HashMap<String, Object>();
				map.put("scenicName", supplierInfo.getScenicName());
				setList(map, info);
				list.add(map);
				keyMap.put(info.getSupplierId(), map);
			}
			json.put("totalCount", baseBatchResult.getTotalCount());
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "旅游线路列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/** 产品list */
	private void setList(Map<String, Object> productMap, ProductInfo info) {
		productMap.put("productNumber", info.getProductNumber());
		productMap.put("productId", toString(info.getProductId()));
		productMap.put("productName", info.getProductName());
		productMap.put("saleTypeB2c", info.getSaleTypeB2c().getCode());
		productMap.put("saleTypeO2o", info.getSaleTypeO2o().getCode());
		productMap.put("customType1",
			info.getCustomType1() == null ? "" : info.getCustomType1().getCode());
		productMap.put("customType2",
			info.getCustomType2() == null ? "" : info.getCustomType2().getCode());
		if (info.getSaleTypeOrderMeal() != null) {
			productMap.put("saleTypeOrderMeal", info.getSaleTypeOrderMeal().getCode());
		}
		if (info.getSaleTypeHotels() != null) {
			productMap.put("saleTypeHotels", info.getSaleTypeHotels().getCode());
		}
		productMap.put("productStatus",
			info.getProductStatus() != null ? info.getProductStatus().getCode() : "");
		productMap.put("groupBuyDetail", info.getGroupBuyDetail());
		productMap.put("marketPrice", info.getMarketPrice().toStandardString());
		productMap.put("price1", info.getPrice1().toStandardString());
		productMap.put("payedCount", toString(info.getPayedCount()));
		productMap.put("productDetail", info.getProductDetail());
		productMap.put("groupBuyDetail", info.getGroupBuyDetail());
		productMap.put("facade", info.getFacade() != null ? info.getFacade().getCode() : "");
		productMap.put("commentCount", toString(info.getCommentCount()));
		productMap.put("date",
			DateUtil.dtSimpleChineseFormat(info.getGroupPurchaseBeginTime())	+ "至"
								+ DateUtil.dtSimpleChineseFormat(info.getGroupPurchaseEndTime()));
		productMap.put("wholesaleDetail", info.getWholesaleDetail());
		productMap.put("transportDetail", info.getTransportDetail());
		productMap.put("morningRoom",
			info.getMorningRoom() == null ? "" : info.getMorningRoom().getCode());
		productMap.put("longRentRoom",
			info.getLongRentRoom() == null ? "" : info.getLongRentRoom().getCode());
		productMap.put("specialRoom",
			info.getSpecialRoom() == null ? "" : info.getSpecialRoom().getCode());
		productMap.put("recommend",
			info.getRecommend() == null ? "" : info.getRecommend().getCode());
		productMap.put("transportDetail", info.getTransportDetail());
		productMap.put("isCollected", checkCollecteStatus(toString(info.getProductId()), null));
		List<String> productImg = new ArrayList<>();
		List<String> middleProductImg = new ArrayList<>();
		List<String> bigProductImg = new ArrayList<>();
		if (StringUtil.isNotBlank(info.getSmallPicPath())) {
			productImg.add(info.getSmallPicPath());
			middleProductImg.add(info.getMiddlePicPath());
			bigProductImg.add(info.getBigPicPath());
		}
		if (StringUtil.isNotBlank(info.getSmallPicPath1())) {
			productImg.add(info.getSmallPicPath1());
			middleProductImg.add(info.getMiddlePicPath1());
			bigProductImg.add(info.getBigPicPath1());
		}
		if (StringUtil.isNotBlank(info.getSmallPicPath2())) {
			productImg.add(info.getSmallPicPath2());
			middleProductImg.add(info.getMiddlePicPath2());
			bigProductImg.add(info.getBigPicPath2());
		}
		if (StringUtil.isNotBlank(info.getSmallPicPath3())) {
			productImg.add(info.getSmallPicPath3());
			middleProductImg.add(info.getMiddlePicPath3());
			bigProductImg.add(info.getBigPicPath3());
		}
		productMap.put("productImg", productImg);
		productMap.put("middleProductImg", middleProductImg);
		productMap.put("bigProductImg", bigProductImg);
	}
	
	/** 商品详情 */
	protected void productDetail(	HttpServletRequest request, JSONObject json,
									String string) throws ParseException {
		String productId = request.getParameter("productId");
		if (StringUtil.isNotBlank(productId)) {
			ProductInfo info = productService
				.findSupplierProductById(NumberUtil.parseLong(productId));
			if (info != null) {
				successResult(json, "查询商品详情成功");
				Map<String, Object> map = new HashMap<String, Object>();
				SupplierInfo supplierInfo = info.getSupplierInfo();
				logger.info("商品详情：商户信息={}", supplierInfo);
				List<String> imgList = new ArrayList<String>();
				map.put("supplierId", toString(supplierInfo.getSupplierId()));
				map.put("storeName", supplierInfo.getStoreName());
				map.put("nickName", supplierInfo.getNickname());
				map.put("address", supplierInfo.getAddress());
				map.put("mobile", supplierInfo.getMobile());
				map.put("spendPer", supplierInfo.getSpendPer().toStandardString());
				map.put("productDiscount",supplierInfo.getProductDiscount()==null?null:supplierInfo.getProductDiscount()/100);
				if (StringUtil.isNotBlank(info.getBigPicPath())) {
					imgList.add(info.getBigPicPath());
				}
				if (StringUtil.isNotBlank(info.getBigPicPath1())) {
					imgList.add(info.getBigPicPath1());
				}
				if (StringUtil.isNotBlank(info.getBigPicPath2())) {
					imgList.add(info.getBigPicPath2());
				}
				if (StringUtil.isNotBlank(info.getBigPicPath3())) {
					imgList.add(info.getBigPicPath3());
				}
				map.put("reviewAverage", toString(supplierInfo.getReviewAverageDefault()));
				map.put("imgList", imgList);
				map.put("merchantType", supplierInfo.getMerchantType());
				map.put("scenicName", supplierInfo.getScenicName());
				
				map.put("productId", toString(info.getProductId()));
				map.put("productName", info.getProductName());
				map.put("productStatus", toString(info.getProductStatus()));
				map.put("groupBuyDetail", info.getGroupBuyDetail());
				map.put("marketPrice", info.getMarketPrice().toStandardString());
				map.put("price1", info.getPrice1().toStandardString());
				map.put("payedCount", toString(info.getPayedCount()));
				StringBuffer productDetail = new StringBuffer();
				if(StringUtil.isNotEmpty(info.getProductDetail())){
					StringBuffer contentText = new StringBuffer(info.getProductDetail());
					productDetail.append(contentText);
					map.put("productDetail", productDetail.toString());
				}
				map.put("saleTypeB2c", info.getSaleTypeB2c().getCode());
				map.put("saleTypeO2o", info.getSaleTypeO2o().getCode());
				map.put("groupBuyDetail", info.getGroupBuyDetail());
				map.put("facade", toString(info.getFacade()));
				map.put("commentCount", toString(info.getCommentCount()));
				map.put("date",
					DateUtil.dtSimpleChineseFormat(info.getGroupPurchaseBeginTime())	+ "至"
								+ DateUtil.dtSimpleChineseFormat(info.getGroupPurchaseEndTime()));
				StringBuffer wholesaleDetail = new StringBuffer();
				wholesaleDetail.append(info.getWholesaleDetail());
				map.put("wholesaleDetail", wholesaleDetail.toString());
				StringBuffer transportDetail = new StringBuffer();
				transportDetail.append(info.getTransportDetail());
				map.put("transportDetail", transportDetail.toString());
				map.put("isCollected", checkCollecteStatus(toString(info.getProductId()), null));
				if (info.getSaleTypeHotels() == BooleanEnum.YES) {
					String beginDate = request.getParameter("beginDate");
					if (StringUtil.isEmpty(beginDate)) {
						beginDate = DateUtil.simpleFormatYmd(new Date());
					}
					String endDate = request.getParameter("endDate");
					if (StringUtil.isEmpty(endDate)) {
						endDate = DateUtil.simpleFormatYmd(DateUtil.getAfterDay(new Date()));
					}
					int dateLen = DateUtil.calculateDecreaseDate(beginDate, endDate);
					json.put("beginDate", beginDate);
					json.put("endDate", endDate);
					json.put("days", dateLen);
					HotelStockProductOrder productOrder = new HotelStockProductOrder();
					productOrder.setStatus(HotelStockStatusEnum.ON);
					productOrder.setProductStatus(ProductStatusEnum.ON);
					productOrder.setProductId(NumberUtil.parseLong(productId, 0));
					productOrder.setBeginDate(DateUtil.parse(beginDate));
					productOrder.setEndDate(DateUtil.parse(endDate));
					QueryBaseBatchResult<HotelsStockIbatisDO> hotelsResult = hotelsStockService
						.searchHotelLeftList(productOrder);
					if (!hotelsResult.isSuccess()) {
						failResult(json, "房间详情失败：" + hotelsResult.getMessage());
						return;
					}
					UserQueryResult userQueryResult = userQueryService
						.queryByUserId(info.getResortsBusinessId());
					if (!userQueryResult.isSuccess()) {
						failResult(json, "商品所属景区有误：" + userQueryResult.getMessage());
						return;
					}
					if (userQueryResult.getQueryUserInfo() == null) {
						failResult(json, "商品所属景区有误!");
						return;
					}
					ScenicQueryResult scenicQueryResult = scenicService
						.queryByUserBaseId(userQueryResult.getQueryUserInfo().getUserBaseId());
					if (!scenicQueryResult.isSuccess()) {
						failResult(json, "商品所属景区有误：" + scenicQueryResult.getMessage());
						return;
					}
					if (scenicQueryResult.getQueryScenicInfo() == null) {
						failResult(json, "商品所属景区有误!");
						return;
					}
					HotelSetRefundQueryOrder hotelSetRefundQueryOrder = new HotelSetRefundQueryOrder();
					QueryBaseBatchResult<HotelSetRefundInfo> hotelSetResult = hotelsSetRefundService
						.searchSetHotelRefundList(hotelSetRefundQueryOrder);
					List<String> refundMessageList = new ArrayList<String>();
					if (hotelSetResult.isSuccess() && hotelSetResult.getPageList() != null) {
						for (HotelSetRefundInfo hotelSetRefundInfo : hotelSetResult.getPageList()) {
							StringBuffer refundMessage = new StringBuffer();
							refundMessage.append(hotelSetRefundInfo.getShowUserGrades())
								.append("级会员，").append(hotelSetRefundInfo.getRefundTime())
								.append("之前全退");
							refundMessageList.add(refundMessage.toString());
						}
						map.put("refundMessageList", refundMessageList);
					} else {
						map.put("refundMessageList", refundMessageList);
					}
					if (hotelsResult.getPageList() != null
						&& hotelsResult.getPageList().size() == 1) {
						HotelsStockIbatisDO hotelsStockIbatisDO = hotelsResult.getPageList().get(0);
						List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
						if (hotelsStockIbatisDO.getMorningNum() > 0 && dateLen == 1) {
							HotelDiscountInfo hotelDiscountInfo = hotelsDiscountService
								.selectHotelByScenicIdAndRoomType(
									scenicQueryResult.getQueryScenicInfo().getId(),
									HotelTypeEnum.MORNING);
							if (hotelDiscountInfo != null) {
								String timeStr = hotelDiscountInfo.getSetTime();
								Date nowDate = new Date();
								Date minTimeDate = new Date();
								if (timeStr.compareTo("12:00") > 0) {
									minTimeDate = DateUtil
										.simpleFormatDate(beginDate + " " + timeStr);
								} else {
									minTimeDate = DateUtil.increaseDate(
										DateUtil.simpleFormatDate(beginDate + " " + timeStr), 1);
								}
								if (hotelDiscountInfo != null
									&& nowDate.getTime() >= minTimeDate.getTime()) {
									Map<String, Object> roomMap = new HashMap<>();
									roomMap.put("roomType", HotelTypeEnum.MORNING.getCode());
									roomMap.put("name", HotelTypeEnum.MORNING.getMessage());
									roomMap.put("price",
										hotelsStockIbatisDO.getMorningPrice().toStandardString());
									roomMap.put("leftNum", hotelsStockIbatisDO.getMorningNum());
									roomList.add(roomMap);
								}
							}
						}
						if (hotelsStockIbatisDO.getSpecialNum() > 0) {
							Map<String, Object> roomMap = new HashMap<>();
							roomMap.put("roomType", HotelTypeEnum.SPECIAL.getCode());
							roomMap.put("name", HotelTypeEnum.SPECIAL.getMessage());
							roomMap.put("price",
								hotelsStockIbatisDO.getSpecialPrice().toStandardString());
							roomMap.put("leftNum", hotelsStockIbatisDO.getSpecialNum());
							roomList.add(roomMap);
						}
						if (hotelsStockIbatisDO.getNormalNumCus() > 0) {
							Map<String, Object> roomMap = new HashMap<>();
							roomMap.put("roomType", HotelTypeEnum.NORMAL.getCode());
							roomMap.put("name", HotelTypeEnum.NORMAL.getMessage());
							roomMap.put("price",
								hotelsStockIbatisDO.getNormalPrice().toStandardString());
							roomMap.put("leftNum", hotelsStockIbatisDO.getNormalNumCus());
							roomList.add(roomMap);
						}
						
						HotelStockOrder order = new HotelStockOrder();
						order.setProductId(info.getProductId());
						order.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
						order.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
						QueryBaseBatchResult<HotelStockInfo> baseBatchResult = hotelsStockService
							.getHotelStockList(order);
						if (!baseBatchResult.isSuccess()) {
							failResult(json, "未查到房间信息:" + baseBatchResult.getMessage());
							return;
						}
						HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
						orderNumOrder.setProductId(info.getProductId());
						orderNumOrder.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
						orderNumOrder.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
						orderNumOrder.setStockInfoList(baseBatchResult.getPageList());
						HotelLongCheckInfoResult longCheckInfoResult = hotelsStockService
							.checkLongRoomInfo(orderNumOrder);
						if (longCheckInfoResult.getLongHotelNum() > 0) {
							Map<String, Object> roomMap = new HashMap<>();
							roomMap.put("roomType", HotelTypeEnum.LONGRENT.getCode());
							roomMap.put("name", HotelTypeEnum.LONGRENT.getMessage());
							roomMap.put("price",
								longCheckInfoResult.getExecPrice().toStandardString());
							roomMap.put("leftNum", longCheckInfoResult.getLongHotelNum());
							roomList.add(roomMap);
						}
						map.put("roomList", roomList);
					}
				}
				List<String> productImg = new ArrayList<>();
				List<String> middleProductImg = new ArrayList<>();
				if (StringUtil.isNotBlank(info.getBigPicPath())) {
					productImg.add(info.getBigPicPath());
					middleProductImg.add(info.getMiddlePicPath());
				}
				if (StringUtil.isNotBlank(info.getBigPicPath1())) {
					productImg.add(info.getBigPicPath1());
					middleProductImg.add(info.getMiddlePicPath1());
				}
				if (StringUtil.isNotBlank(info.getBigPicPath2())) {
					productImg.add(info.getBigPicPath2());
					middleProductImg.add(info.getMiddlePicPath2());
				}
				if (StringUtil.isNotBlank(info.getBigPicPath3())) {
					productImg.add(info.getBigPicPath3());
					middleProductImg.add(info.getMiddlePicPath3());
				}
				map.put("productImg", productImg);
				map.put("middleProductImg", middleProductImg);
				//服务时长
				map.put("serviceTime", info.getCustomValue1());
				json.put("info", map);
			} else {
				failResult(json, "未查到商品信息");
			}
		} else {
			failResult(json, "商品id不能为空");
		}
	}
	
	/** 商品评价 */
	protected void pingjia(HttpServletRequest request, JSONObject json, String string) {
		String productId = request.getParameter("productId");
		String supplierId =request.getParameter("supplierId");
		String discussType = request.getParameter("discussType");
		SearchProductScoreOrder order = new SearchProductScoreOrder();
		order.setObjectId(NumberUtil.parseLong(productId));
		order.setSupplierId(NumberUtil.parseLong(supplierId, 0));
		if (StringUtil.equals(discussType, "good")) {
			order.setBeginScore(5);
			order.setEndScore(5);
		}
		if (StringUtil.equals(discussType, "all")) {
			order.setBeginScore(1);
			order.setEndScore(5);
		}
		if (StringUtil.equals(discussType, "normal")) {
			order.setBeginScore(3);
			order.setEndScore(4);
		}
		if (StringUtil.equals(discussType, "bad")) {
			order.setBeginScore(1);
			order.setEndScore(2);
		}
		
		/* 评价统计 */
		ProductScoreStatisticsRsult scoreStatisticsRsult = orderService
			.statisticsProductScoreList(order);
		Map<String, String> countMap = new HashMap<>();
		countMap.put("totalCount", toString(scoreStatisticsRsult.getTotalCount()));
		countMap.put("goodCount", toString(scoreStatisticsRsult.getGoodCount()));
		countMap.put("midCount", toString(scoreStatisticsRsult.getMidCount()));
		countMap.put("poorCount", toString(scoreStatisticsRsult.getPoorCount()));
		json.put("countMap", countMap);
		/* 评价列表 */
		QueryBaseBatchResult<ProductScoreInfo> baseBatchResult = orderService
			.queryProductScoreList(order);
		if (baseBatchResult.isSuccess()) {
			ProductInfo info0 = productService.findProductById(NumberUtil.parseLong(productId));
			String productTheme = "";
			String productStyle = "";
			if (info0 != null) {
				productTheme = info0.getProductTheme();
				productStyle = info0.getProductStyle();
			}
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			for (ProductScoreInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<>();
				AppCommonUtil.beanToMap(info, map);
				map.put("userName", AppCommonUtil.viewStr(info.getUserName(), "userName"));
				map.put("realName", "");
				map.put("productTheme", productTheme);
				map.put("productStyle", productStyle);
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "评价列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/** 商品推荐 */
	protected void recommendProduct(HttpServletRequest request, JSONObject json, String string) {
		String productId = request.getParameter("productId");
		String saleType = request.getParameter("saleType");
		SaleTypeEnum saleTypeEnum = SaleTypeEnum.getByCode(saleType);
		String recommendType = StringUtil.defaultIfEmpty(request.getParameter("recommendType"),
			ProductRecommendTypeEnum.PRODUCT_TOP.getCode());
		if (StringUtil.isNotBlank(productId)) {
			ProductInfo product = productService.findProductById(NumberUtil.parseLong(productId));
			if (product == null) {
				failResult(json, "关联商品Id不存在");
				return;
			}
			ProductRecommendOrder order = new ProductRecommendOrder();
			WebUtil.setPoPropertyByRequest(order, request);
			if (saleTypeEnum != null) {
				if (saleTypeEnum == SaleTypeEnum.O2O) {
					order.setSaleTypeO2o(BooleanEnum.YES);
					order.setProductVaryEnum(ProductVaryEnum.product);
				} else if (saleTypeEnum == SaleTypeEnum.B2C) {
					order.setSaleTypeB2c(BooleanEnum.YES);
					order.setProductVaryEnum(ProductVaryEnum.product);
				} else if (saleTypeEnum == SaleTypeEnum.TICKET) {
					order.setProductVaryEnum(ProductVaryEnum.ticket);
				}
			} else {
				order.setProductVaryEnum(ProductVaryEnum.product);
			}
			order.setProductStatus(ProductStatusEnum.ON);
			order.setProductType(product.getProductType());
			order.setProductId(product.getProductId());
			order.setRecommendType(ProductRecommendTypeEnum.getByCode(recommendType));
			order.setOrderNormal("NORMAL");
			QueryBaseBatchResult<ProductInfo> baseBatchResult = productRecommendService
				.getProductRecommendList(order);
			if (baseBatchResult.isSuccess()) {
				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
				Map<String, String> map = null;
				for (ProductInfo info : baseBatchResult.getPageList()) {
					map = new HashMap<>();
					map.put("productId", toString(info.getProductId()));
					map.put("productName", info.getProductName());
					map.put("smallPicPath", info.getSmallPicPath());
					map.put("middlePicPath", info.getMiddlePicPath());
					map.put("bigPicPath", info.getBigPicPath());
					map.put("price1", info.getPrice1().toStandardString());
					map.put("marketPrice", info.getMarketPrice().toStandardString());
					map.put("isCollected",
						checkCollecteStatus(toString(info.getProductId()), null));
					list.add(map);
				}
				json.put("totalPage", baseBatchResult.getPageCount());
				json.put("list", list);
				successResult(json, "推荐列表查询成功");
			} else {
				failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
			}
			
		} else {
			failResult(json, "相关推荐产品Id不能为空");
		}
		
	}
	
	/** 验证身份证是否已使用 */
	protected void verifyCertNoRegist(HttpServletRequest request, JSONObject json, String string) {
		String certNo = request.getParameter("certNo");
		Long count = realNameAuthenticationService.countCertNoUsed(certNo);
		json.put("count", count);
		if (count > 0) {
			failResult(json, "该用户已注册，请更换姓名和身份证号码");
		} else {
			successResult(json, "身份证可用");
		}
	}
	
	/** 校验短信验证码是否正确 */
	protected void verifySmsCode(HttpServletRequest request, JSONObject json, String string) {
		try {
			String business = request.getParameter("business");
			String code = request.getParameter("code");
			String mobile = request.getParameter("mobile");
			logger.info("验证短信sessionId={}，mobile={}", request.getSession().getId(), mobile);
			SmsCodeResult smsCodeResult = this.smsManagerService.verifySmsCode(mobile,
				SmsBizType.getByCode(business), code, false);
			if (smsCodeResult.isSuccess()) {
				successResult(json, "验证手机验证码成功");
			} else {
				failResult(json, smsCodeResult.getMessage());
			}
		} catch (NullPointerException e) {
			failResult(json, "请先获取验证码");
		}
	}
	
	protected void getImgCode(	HttpServletRequest request, HttpSession session,
								HttpServletResponse response, JSONObject json,
								String string) throws IOException {
		BufferedImage bufferedImage = Image.creatImage(session);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bufferedImage, "jpg", out);
		successResult(json, "获取验证码成功");
		out.flush();
		out.close();
	}
	
	protected void verifyImgCode(	HttpServletRequest request, HttpSession session, JSONObject json,
									String string) {
		String sCode = (String) request.getSession().getAttribute("imgCode");
		String imgCode = request.getParameter("imgCode");
		if (StringUtil.isBlank(sCode)) {
			failResult(json, "请先获取图片验证码");
			return;
		}
		if (StringUtil.isBlank(imgCode)) {
			failResult(json, "验证码不能为空");
			return;
		}
		if (Image.checkImgCode(session, imgCode)) {
			successResult(json, "验证码正确");
		} else {
			failResult(json, "验证码错误");
		}
	}
	
	/**
	 * 爱的印记列表页查询
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void messageLoveWallList(HttpServletRequest request, JSONObject json, String string) {
		MessageWallQueryOrder queryOrder = new MessageWallQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		QueryBaseBatchResult<MessageLoveWallInfo> result = messageWallService
			.findMessageLoveWallList(queryOrder);
		if (result.isSuccess()) {
			List<Map<String, String>> maps = new ArrayList<>();
			Map<String, String> map = null;
			for (MessageLoveWallInfo info : result.getPageList()) {
				map = new HashMap<>();
				map.put("id", toString(info.getId()));
				map.put("boy", info.getBoy());
				map.put("girl", info.getGirl());
				map.put("message", info.getMessage());
				map.put("image", info.getImage());
				map.put("day", DateUtil.simpleDate(info.getRawAddTime()));
				maps.add(map);
			}
			json.put("totalPage", result.getPageCount());
			json.put("list", maps);
			successResult(json, "");
		} else {
			failResult(json, "获取爱的印记列表失败");
		}
	}
	
	/**
	 * 爱的印记详情页查询
	 * @param request
	 * @param json
	 */
	protected void messageLoveWallInfo(HttpServletRequest request, JSONObject json, String string) {
		String id = request.getParameter("id");
		if (StringUtil.isEmpty(id)) {
			failResult(json, "ID错误,获取爱的印记列表失败");
			return;
		}
		MessageLoveWallInfo info = messageWallService
			.findLoveWallInfoById(NumberUtil.parseLong(id));
		if(info==null){
			failResult(json, "数据不存在,获取爱的印记列表失败");
			return;
		}
		Map<String, String> map = new HashMap<>();
		map.put("id", toString(info.getId()));
		map.put("boy", info.getBoy());
		map.put("girl", info.getGirl());
		map.put("message", info.getMessage());
		map.put("image", info.getImage());
		map.put("day", DateUtil.simpleDate(info.getRawAddTime()));
		
		json.put("info", map);
		successResult(json, "获取详情成功");
	}
	
	/**
	 * 新增爱的印记
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void addMessageLoveWall(HttpServletRequest request, JSONObject json, String string) {
		MessageLoveWallOrder order = new MessageLoveWallOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		order.setUserName(ShiroSessionUtils.getSessionLocal().getUserName());
		EsupplierBaseResult result = messageWallService.addMessageLoveWallInfo(order);
		if (result.isSuccess()) {
			successResult(json, "新增爱的印记成功");
		} else {
			failResult(json, "新增爱的印记失败");
		}
	}
	
	/**
	 * 到此一游列表页查询
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void messageWallList(HttpServletRequest request, JSONObject json, String string) {
		MessageWallQueryOrder queryOrder = new MessageWallQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		QueryBaseBatchResult<MessageWallInfo> result = messageWallService
			.findMessageWallList(queryOrder);
		if (result.isSuccess()) {
			List<Map<String, String>> maps = new ArrayList<>();
			Map<String, String> map = null;
			for (MessageWallInfo info : result.getPageList()) {
				map = new HashMap<>();
				map.put("title", info.getTitle());
				map.put("day", DateUtil.simpleDate(info.getRawAddTime()));
				maps.add(map);
			}
			json.put("totalPage", result.getPageCount());
			json.put("list", maps);
			successResult(json, "");
		} else {
			failResult(json, "获取到此一游列表失败");
		}
	}
	
	/**
	 * 新增到此一游
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void addMessageWall(HttpServletRequest request, JSONObject json, String string) {
		MessageWallOrder order = new MessageWallOrder();
		WebUtil.setPoPropertyByRequest(order, request);
		order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		order.setUserName(ShiroSessionUtils.getSessionLocal().getUserName());
		EsupplierBaseResult result = messageWallService.addMessageWallInfo(order);
		if (result.isSuccess()) {
			successResult(json, "新增留言成功");
		} else {
			failResult(json, "新增留言失败");
		}
	}
	
	/**
	 * 发送短信
	 */
	protected void sendSmsCode(	HttpServletRequest request, HttpSession session, JSONObject json,
								String string) {
		String business = request.getParameter("business");
		String mobile = request.getParameter("mobile");
		if (StringUtil.isBlank(mobile)) {
			failResult(json, "电话号码不能为空");
			return;
		}
		logger.info("发送短信sessionId={},mobile={}", request.getSession().getId(), mobile);
		if (StringUtil.equals(business, "login")	|| "register".equals(business)
			|| "ForgetLoginPassWord".equals(business)) {
			if ((StringUtil.equals(business, "register")) && AppConstantsUtil.registNeedImgCode()) {
				String sCode = (String) request.getSession().getAttribute("imgCode");
				String imgCode = request.getParameter("imgCode");
				if (StringUtil.isBlank(sCode)) {
					failResult(json, "请先获取图片验证码");
					return;
				}
				if (StringUtil.isBlank(imgCode)) {
					failResult(json, "图片验证码不能为空");
					return;
				}
				if (!Image.checkImgCode(session, imgCode)) {
					failResult(json, "验证码错误");
					return;
				}
			}
			SessionLocal sessionLocal = new SessionLocal();
			sessionLocal.setRemoteAddr(IPUtil.getIpAddr(request));
			sessionLocal.addAttibute("appRegist", true);
			ShiroSessionUtils.setSessionLocal(sessionLocal);
			EsupplierBaseResult EsupplierBaseResult = smsManagerService.sendSmsCode(mobile,
				SmsBizType.getByCode(business), null);
			if (EsupplierBaseResult.isSuccess()) {
				successResult(json, "发送手机验证码成功");
			} else {
				failResult(json, EsupplierBaseResult.getMessage());
			}
			return;
		}
		EsupplierBaseResult EsupplierBaseResult = smsManagerService.sendSmsCode(mobile,
			SmsBizType.getByCode(business), null);
		if (EsupplierBaseResult.isSuccess()) {
			successResult(json, "发送手机验证码成功");
		} else {
			failResult(json, EsupplierBaseResult.getMessage());
		}
	}
	
	/** 获取首页广告图 */
	protected void indexImg(HttpServletRequest request, JSONObject json, String string) {
		String type = request.getParameter("type");
		PageParam pageParam = new PageParam();
		pageParam.setPageSize(50);
		pageParam.setPageNo(1);
		PopTypeEnum typeEnum = PopTypeEnum.getByCode(type);
		if (typeEnum == null) {
			failResult(json, "获取类型有误！");
			return;
		}
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("type", typeEnum.getDbValue());
		conditions.put("status", 2);
		QueryBaseBatchResult<PopInfo> result = popService.getBannerListByConditionsNew(pageParam,
			conditions);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (PopInfo info : result.getPageList()) {
			map = new HashMap<String, String>();
			String linkUrlForImg = info.getRemark();
			// 得到文件的扩展名
			if (StringUtil.isNotEmpty(linkUrlForImg)) {
				List<String> fileTypeList = new ArrayList<String>();
				fileTypeList.add(".jpg");
				fileTypeList.add(".jpeg");
				fileTypeList.add(".gif");
				fileTypeList.add(".bmp");
				fileTypeList.add(".png");
				String extName = "";
				if (linkUrlForImg.lastIndexOf(".") >= 0) {
					extName = linkUrlForImg.substring(linkUrlForImg.lastIndexOf("."));
				}
				if (fileTypeList.contains(extName)) {
					linkUrlForImg = AppConstantsUtil.getHostHttpUrl()
									+ "/front/anon/bannerImage.htm?imageUrl=" + info.getRemark();
				}
			}
			map.put("imgUrl", info.getRem1());
			map.put("linkUrl", linkUrlForImg);
			map.put("title", info.getTitle());
			list.add(AppCommonUtil.cleanNull(map));
		}
		json.put("list", list);
		successResult(json, "获取广告图成功");
	}
	
	/** 图片上传 */
	protected void imagesUpload(HttpServletRequest request, JSONObject json, String string) {
		String[] pathArray = null;
		File file = null;
		DefaultMultipartHttpServletRequest mulRequest = null;
		if (request instanceof DefaultMultipartHttpServletRequest) {
			mulRequest = (DefaultMultipartHttpServletRequest) request;
		}
		if (mulRequest == null) {
			failResult(json, "文件上传失败(文件类型不正确)！");
			return;
		}
		MultipartFile multipartFile = null;
		multipartFile = FileUploadUtils.getMultipartFile(mulRequest.getFileMap());
		// 解析文件
		String name = multipartFile.getOriginalFilename();
		try {
			// 得到文件的扩展名
			String extName = "";
			if (name.lastIndexOf(".") >= 0) {
				extName = name.substring(name.lastIndexOf("."));
			}
			if (!fileTypeList.contains(extName.toLowerCase())) {
				failResult(json, "文件上传失败(文件类型不正确)！");
				return;
			}
			if (".pdf".equalsIgnoreCase(extName)) {
				pathArray = FileUploadUtils.getStaticFilesPdfPath(request, name);
			} else {
				pathArray = FileUploadUtils.getStaticFilesImgPath(request, name);
			}
			String savePath = pathArray[0];
			FileOutputStream baos = null;
			try {
				file = new File(savePath);
				InputStream stream = multipartFile.getInputStream();
				baos = new FileOutputStream(savePath);
				byte[] b = new byte[1024];
				int readIndex = 0;
				while ((readIndex = stream.read(b)) > 0) {
					baos.write(b, 0, readIndex);
				}
				baos.close();
				stream.close();
			} catch (Exception e) {
				logger.error("文件写入异常，异常信息：{}", e.toString(), e);
				failResult(json, "文件写入异常");
				return;
			}
			
		} catch (Exception e) {
			logger.error("文件上传异常，异常信息：{}", e.toString(), e);
			failResult(json, "文件上传异常");
			return;
		}
		json.put("serverPath", pathArray[1]);
		successResult(json, "文件上传成功");
	}
	
	/** 商品/商户收藏状态 */
	private String checkCollecteStatus(String productId, String supplierId) {
		Long userId = null;
		try {
			userId = ShiroSessionUtils.getSessionLocal().getUserId();
		} catch (Exception e) {
			
		}
		if (userId == null) {
			return "0";
		}
		if (StringUtil.isNotBlank(productId)) {
			List<String> productIdList = new ArrayList<>();
			productIdList.add(productId);
			List<ProductUserCollectInfo> list = productUserService.getProductUserCollectList(userId,
				productIdList);
			if (ListUtil.isNotEmpty(list)) {
				return "1";
			}
		} else if (StringUtil.isNotBlank(supplierId)) {
			List<String> supplierIdList = new ArrayList<>();
			supplierIdList.add(supplierId);
			List<ProductUserCollectInfo> list = productUserService
				.getSupplierUserCollectList(userId, supplierIdList);
			if (ListUtil.isNotEmpty(list)) {
				return "1";
			}
		}
		
		return "0";
	}
	
	/** 添加到购物车 */
	private void addShoppingCar(long productId, long count, JSONObject json) {
		// 查询产品的信息
		ProductInfo productInfo = productService.findProductById(productId);
		long supplierId = productInfo.getSupplierId();
		UserInfo supplierInfo = userQueryService.queryByUserId(supplierId).getQueryUserInfo();
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		CartItemInfo item = new CartItemInfo(productId, supplierId, (int) count);
		item.setName(productInfo.getProductName());
		item.setPrice(productInfo.getPrice1());
		item.setImage(productInfo.getSmallPicPath());
		item.setSupplierName(supplierInfo.getRealName());
		item.setUnit(productInfo.getProductUnit());
		item.setPriceOriginal(productInfo.getMarketPrice());
		if (productInfo.getPostType() != null)
			item.setPostType(productInfo.getPostType().getDbValue());
		else
			item.setPostType(0);
		/*邮费单独计算*/
		item.setDeliveryInfo(null);
		ProductStorageInfo productStorageInfo = storageService
			.getStorageInfo(productInfo.getProductId());
		long addAfterQuantity = cart.preAddCartItemQuantity(item);
		if (addAfterQuantity > productStorageInfo.getStockAmount()
								- productStorageInfo.getPayedCount()) {
			failResult(json, "库存不足，不能增加购买数量");
			return;
		}
		ShopingCartResult cartResult = cart.addCartItemInfo(item);
		persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
		if (cartResult.isSuccess()) {
			successResult(json, "添加商品成功");
		} else {
			failResult(json, cartResult.getMessage());
		}
	}
	
	/** 修改购物车商品数量 */
	private void upShoppingCar(long productId, int count, JSONObject json) {
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		ProductInfo productInfo = productService.findProductById(productId);
		long supplierId = productInfo.getSupplierId();
		ProductStorageInfo productStorageInfo = storageService
			.getStorageInfo(productInfo.getProductId());
		if (count != 0
			&& count > productStorageInfo.getStockAmount() - productStorageInfo.getPayedCount()) {
			failResult(json, "库存不足，不能增加购买数量");
			return;
		}
		
		ShopingCartResult cartResult = cart.setQuantity(supplierId, productId, count);
		persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
		successResult(json, "修改成功");
	}
	
	/** 购物车 */
	protected void shoppingCar(HttpServletRequest request, JSONObject json, String string) {
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (Cart.CartItem info : cart.getViewCartList()) {
			for (CartItemInfo info0 : info.getItemInfos()) {
				map = new HashMap<>();
				map = AppCommonUtil.beanToMap(info0, map);
				ProductInfo info1 = productService.findProductById(info0.getProductId());
				String productTheme = "";
				String productStyle = "";
				String wareCount = "0";
				String productStatus = "x";
				if (info1 != null) {
					productTheme = info1.getProductTheme();
					productStyle = info1.getProductStyle();
					wareCount = String.valueOf(info1.getWareCount());
					productStatus = info1.getProductStatus().getCode();
					if (info1.getProductStatus() != null) {
						map.put("productStatus", info1.getProductStatus().code());
					}
				}
				map.put("productTheme", productTheme);
				map.put("productStyle", productStyle);
				map.put("wareCount", wareCount);
				map.put("productStatus", productStatus);
				list.add(map);
			}
			
		}
		json.put("list", list);
		successResult(json, "查询购物车成功");
	}
	
	/** 强制刷新购物车 */
	protected void refreshShoppingCar(HttpServletRequest request, JSONObject json, String string) {
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null && StringUtil.isNotBlank(sessionLocal.getUserName())) {
			Cart cart = WebSessionUtil.getStaticCurrentCart();
			cart.clear();
			initShopCart(sessionLocal.getUserInfo());
		}
		shoppingCar(request, json, string);
	}
	
	/** 修改购物车 */
	protected void shoppingCarUpdate(HttpServletRequest request, JSONObject json, String string) {
		String operType = request.getParameter("operType");
		String setOperType = (String) request.getAttribute("operType");
		String productIds = "";
		String counts = "";
		if (StringUtil.isNotBlank(operType)) {
			productIds = request.getParameter("productId");
			counts = request.getParameter("count");
		} else if (StringUtil.isNotBlank(setOperType)) {
			productIds = (String) request.getAttribute("productId");
			counts = (String) request.getAttribute("count");
			operType = setOperType;
		} else {
			failResult(json, "操作类型不能为空");
			return;
		}
		
		if (StringUtil.isBlank(productIds) || StringUtil.isBlank(counts)) {
			failResult(json, "检查请求参数是否完整");
		}
		long productId = NumberUtil.parseLong(productIds);
		int count = NumberUtil.parseInt(counts);
		if (StringUtil.equals(operType, "add")) {
			addShoppingCar(productId, count, json);
			if (json.getInteger("code") != 1) {
				return;
			}
		} else if (StringUtil.equals(operType, "update")) {
			upShoppingCar(productId, count, json);
			if (json.getInteger("code") != 1) {
				return;
			}
		} else {
			failResult(json, "未知操作类型：operType=" + operType);
		}
	}
	
	/** 批量删除购物车商品 */
	protected void shoppingCarDel(HttpServletRequest request, JSONObject json, String string) {
		
		String productIds = request.getParameter("productIds");
		if (StringUtil.isBlank(productIds)) {
			failResult(json, "批量删除productIds不能为空");
			return;
		}
		if (productIds.indexOf("，") > -1) {
			productIds = productIds.replaceAll("，", ",");
		}
		String[] list = productIds.split(",");
		for (String s : list) {
			if (StringUtil.isEmpty(s))
				continue;
			long productId = NumberUtil.parseLong(s);
			Cart cart = WebSessionUtil.getStaticCurrentCart();
			ProductInfo productInfo = productService.findProductById(productId);
			if (productInfo == null)
				continue;
			long supplierId = productInfo.getSupplierId();
			try {
				ShopingCartResult cartResult = cart.setQuantity(supplierId, productId, 0);
				persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
			} catch (NullPointerException e) {
				logger.error("批量删除购物车商品：商品productId={}不存在", s);
			}
			
		}
		
		successResult(json, "批量删除成功");
	}
	
	/**
	 * 点餐购物车
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void orderMealShoppingCar(HttpServletRequest request, JSONObject json,
										String string) {
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;
		List<Map<String, String>> childList = null;
		Map<String, String> childMap = null;
		long count = 0;
		for (Cart.CartItem info : cart.getViewCartList()) {
			childList = new ArrayList<>();
			map = new HashMap<>();
			for (CartItemInfo info0 : info.getItemInfos()) {
				childMap = new HashMap<>();
				count += info0.getQuantity();
				childMap = AppCommonUtil.beanToMap(info0, childMap);
				ProductInfo info1 = productService.findProductById(info0.getProductId());
				String productTheme = "";
				String productStyle = "";
				String wareCount = "0";
				String productStatus = "x";
				if (info1 != null) {
					productTheme = info1.getProductTheme();
					productStyle = info1.getProductStyle();
					wareCount = String.valueOf(info1.getWareCount());
					productStatus = info1.getProductStatus().getCode();
				}
				childMap.put("productTheme", productTheme);
				childMap.put("productStyle", productStyle);
				childMap.put("wareCount", wareCount);
				childMap.put("productStatus", productStatus);
				childList.add(childMap);
				map.put("productList", childList);
			}
			map.put("supplierId", toString(info.getSupplierId()));
			map.put("supplierName", info.getSupplierFullName());
			map.put("supplierTotalAmount", info.getEveryPriceVal().toString());
			list.add(map);
		}
		json.put("supplierList", list);
		json.put("totalPrice", cart.getTotalPrice().toString());
		json.put("productCount", cart.getCount());
		json.put("totalCount", count);
		
		successResult(json, "查询购物车成功");
	}
	
	/**
	 * 强制刷新点餐购物车
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void refreshOrderMealShoppingCar(	HttpServletRequest request, JSONObject json,
												String string) {
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null && StringUtil.isNotBlank(sessionLocal.getUserName())) {
			Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
			cart.clear();
			initShopCart(sessionLocal.getUserInfo(), ShopingCartTypeEnum.ORDER_MEAL);
		}
		orderMealShoppingCar(request, json, string);
	}
	
	/**
	 * 修改点餐购物车
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void orderMealShoppingCarUpdate(	HttpServletRequest request, JSONObject json,
												String string) {
		String operType = request.getParameter("operType");
		String setOperType = (String) request.getAttribute("operType");
		String productIds = "";
		String counts = "";
		if (StringUtil.isNotBlank(operType)) {
			productIds = request.getParameter("productId");
			counts = request.getParameter("count");
		} else if (StringUtil.isNotBlank(setOperType)) {
			productIds = (String) request.getAttribute("productId");
			counts = (String) request.getAttribute("count");
			operType = setOperType;
		} else {
			failResult(json, "操作类型不能为空");
			return;
		}
		
		if (StringUtil.isBlank(productIds) || StringUtil.isBlank(counts)) {
			failResult(json, "检查请求参数是否完整");
		}
		long productId = NumberUtil.parseLong(productIds);
		int count = NumberUtil.parseInt(counts);
		if (StringUtil.equals(operType, "add")) {
			addOrderMealShoppingCar(productId, count, json);
			if (json.getInteger("code") != 1) {
				return;
			}
		} else if (StringUtil.equals(operType, "update")) {
			upOrderMealShoppingCar(productId, count, json);
			if (json.getInteger("code") != 1) {
				return;
			}
		} else {
			failResult(json, "未知操作类型：operType=" + operType);
		}
	}
	
	/**
	 * 批量删除点餐购物车菜品
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void orderMealShoppingCarDel(	HttpServletRequest request, JSONObject json,
											String string) {
		
		String productIds = request.getParameter("productIds");
		if (StringUtil.isBlank(productIds)) {
			failResult(json, "批量删除productIds不能为空");
			return;
		}
		if (productIds.indexOf("，") > -1) {
			productIds = productIds.replaceAll("，", ",");
		}
		String[] list = productIds.split(",");
		for (String s : list) {
			if (StringUtil.isEmpty(s))
				continue;
			long productId = NumberUtil.parseLong(s);
			Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
			ProductInfo productInfo = productService.findProductById(productId);
			if (productInfo == null)
				continue;
			long supplierId = productInfo.getSupplierId();
			try {
				ShopingCartResult cartResult = cart.setQuantity(supplierId, productId, 0);
				persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
			} catch (NullPointerException e) {
				logger.error("批量删除购物车商品：商品productId={}不存在", s);
			}
			
		}
		
		successResult(json, "批量删除成功");
	}
	
	/**
	 * 获取点餐购物车商品数量和总价
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void getOrderMealShoppingCarCounts(	HttpServletRequest request, JSONObject json,
													String string) {
		
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		long count = 0;
		for (Cart.CartItem info : cart.getViewCartList()) {
			for (CartItemInfo info0 : info.getItemInfos()) {
				count += info0.getQuantity();
			}
		}
		json.put("totalPrice", cart.getTotalPrice().toString());
		json.put("productCount", cart.getCount());
		json.put("totalCount", count);
		successResult(json, "查询购物车商品数量成功");
		
	}
	
	/** 添加到购物车 */
	private void addOrderMealShoppingCar(long productId, long count, JSONObject json) {
		// 查询产品的信息
		ProductInfo productInfo = productService.findProductById(productId);
		long supplierId = productInfo.getSupplierId();
		UserInfo supplierInfo = userQueryService.queryByUserId(supplierId).getQueryUserInfo();
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		CartItemInfo item = new CartItemInfo(productId, supplierId, (int) count);
		item.setName(productInfo.getProductName());
		item.setPrice(productInfo.getPrice1());
		item.setImage(productInfo.getSmallPicPath());
		item.setSupplierName(supplierInfo.getRealName());
		item.setUnit(productInfo.getProductUnit());
		item.setPriceOriginal(productInfo.getMarketPrice());
		if (productInfo.getPostType() != null)
			item.setPostType(productInfo.getPostType().getDbValue());
		else
			item.setPostType(0);
		/*邮费单独计算*/
		item.setDeliveryInfo(null);
		//		ProductStorageInfo productStorageInfo = storageService.getStorageInfo(productInfo
		//			.getProductId());
		//		long addAfterQuantity = cart.preAddCartItemQuantity(item);
		//		if (addAfterQuantity > productStorageInfo.getStockAmount()
		//								- productStorageInfo.getPayedCount()) {
		//			failResult(json, "库存不足，不能增加购买数量");
		//			return;
		//		}
		ShopingCartResult cartResult = cart.addCartItemInfo(item);
		persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
		if (cartResult.isSuccess()) {
			successResult(json, "添加商品成功");
			json.put("productCount", cart.getCount());
		} else {
			failResult(json, cartResult.getMessage());
		}
	}
	
	/** 修改购物车商品数量 */
	private void upOrderMealShoppingCar(long productId, int count, JSONObject json) {
		Cart cart = WebSessionUtil.getStaticCurrentOrderMealCart();
		ProductInfo productInfo = productService.findProductById(productId);
		long supplierId = productInfo.getSupplierId();
		//		ProductStorageInfo productStorageInfo = storageService.getStorageInfo(productInfo
		//			.getProductId());
		//		if (count != 0
		//			&& count > productStorageInfo.getStockAmount() - productStorageInfo.getPayedCount()) {
		//			failResult(json, "库存不足，不能增加购买数量");
		//			return;
		//		}
		
		ShopingCartResult cartResult = cart.setQuantity(supplierId, productId, count);
		persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
		json.put("productCount", cart.getCount());
		successResult(json, "修改成功");
	}
	
	/** 消息列表查询 */
	protected void messageList(HttpServletRequest request, JSONObject json, String string) {
		QueryReceviedMessageOrder queryMessageOrder = new QueryReceviedMessageOrder();
		WebUtil.setPoPropertyByRequest(queryMessageOrder, request);
		queryMessageOrder.setMessageReceivedId(ShiroSessionUtils.getSessionLocal().getUserId());
		String type = request.getParameter("type");
		if (StringUtil.isNotEmpty(type)) {
			List<MessageReceivedStatusEnum> enums = Lists.newArrayList();
			enums.add(MessageReceivedStatusEnum.getByCode(type));
			queryMessageOrder.setStatusList(enums);
		}
		QueryBaseBatchResult<MessageReceivedInfo> baseBatchResult = siteMessageService
			.findReceviedMessage(queryMessageOrder);
		if (baseBatchResult.isSuccess()) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			for (MessageReceivedInfo info : baseBatchResult.getPageList()) {
				map = new HashMap<>();
				map.put("messageId", String.valueOf(info.getMessageId()));
				map.put("title", info.getMessageTitle());
				map.put("content", info.getMessageContent());
				map.put("senderName", info.getMessageSenderName());
				map.put("receivedId", String.valueOf(info.getReceivedId()));
				map.put("sendDate", DateUtil.simpleFormat(info.getMessageSendDate()));
				map.put("messageReceivedStatus", info.getMessageReceivedStatus().getCode());
				list.add(map);
			}
			json.put("totalPage", baseBatchResult.getPageCount());
			json.put("list", list);
			successResult(json, "消息列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(baseBatchResult.getMessage(), "查询失败"));
		}
	}
	
	/** 消息详情 */
	protected void messageInfo(HttpServletRequest request, JSONObject json, String string) {
		String messageId = request.getParameter("messageId");
		if (StringUtil.isNotBlank(messageId)) {
			QueryReceviedMessageOrder queryMessageReceviedOrder = new QueryReceviedMessageOrder();
			WebUtil.setPoPropertyByRequest(queryMessageReceviedOrder, request);
			queryMessageReceviedOrder
				.setMessageReceivedId(ShiroSessionUtils.getSessionLocal().getUserId());
			queryMessageReceviedOrder.setMessageId(NumberUtil.parseLong(messageId));
			QueryBaseBatchResult<MessageReceivedInfo> messageReceivedInfoList = siteMessageService
				.findReceviedMessage(queryMessageReceviedOrder);
			if (messageReceivedInfoList != null
				&& messageReceivedInfoList.getPageList().size() > 0) {
				MessageReceivedInfo info = messageReceivedInfoList.getPageList().get(0);
				MyMessageOrder myMessageOrder = new MyMessageOrder();
				myMessageOrder.setReceivedId(info.getReceivedId());
				myMessageOrder.setUserId(info.getMessageReceivedId());
				myMessageOrder.setMessageReceivedStatus(MessageReceivedStatusEnum.READ.getCode());
				siteMessageService.readMessageInfo(myMessageOrder);
				successResult(json, "查询消息详情成功");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("receivedId", info.getReceivedId());
				map.put("messageId", info.getMessageId());
				map.put("title", info.getMessageTitle());
				map.put("content", info.getMessageContent());
				map.put("senderName", info.getMessageSenderName());
				map.put("messageReceivedStatus", info.getMessageReceivedStatus().getCode());
				map.put("sendDate", DateUtil.simpleFormat(info.getMessageSendDate()));
				json.put("info", map);
			} else {
				failResult(json, "未查到消息详情");
			}
		} else {
			failResult(json, "消息id不能为空");
		}
	}
	
	/** 删除接收到的消息 */
	protected void deleteReceivedMessageInfo(	HttpServletRequest request, JSONObject json,
												String string) {
		String receivedId = request.getParameter("receivedId");
		if (StringUtil.isNotBlank(receivedId)) {
			MyMessageOrder myMessageOrder = new MyMessageOrder();
			myMessageOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			myMessageOrder.setReceivedId(NumberUtil.parseLong(receivedId));
			MessageResult result = siteMessageService.deleteReceivedMessageInfo(myMessageOrder);
			if (result.isSuccess()) {
				successResult(json, "删除消息成功");
			} else {
				failResult(json, result.getMessage());
			}
		} else {
			failResult(json, "接收消息id不能为空");
		}
	}
	
	/**
	 * 上传头像
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void uploadHeaderImg(HttpServletRequest request, JSONObject json, String string) {
		UserExtendOrder order = new UserExtendOrder();
		order.setUserId(NumberUtil.parseLong(request.getParameter("userId")));
		order.setUserExtendEnum(UserExtendEnum.USER_HEADER_IMG);
		userBaseInfoManager.saveOrUpdateUserExtendInfo(order);
		successResult(json, "操作成功");
	}
	
	/**
	 * 设置商家餐桌数
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void setSupplierTableNumber(	HttpServletRequest request, JSONObject json,
											String string) {
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		String tableNumber = request.getParameter("tableNumber");
		if (StringUtil.isNotEmpty(tableNumber)) {
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			TableNumberSettingOrder order = new TableNumberSettingOrder();
			order.setTableNumber(NumberUtil.parseLong(tableNumber));
			order.setSupplierId(sessionLocal.getUserId());
			order.setBelongTo(sessionLocal.getUserId());
			order.setProcessorId(sessionLocal.getUserId());
			returnEnum = supplierSettingService.setTableNumber(order);
		} else {
			failResult(json, "餐桌数不能为空！");
			return;
		}
		if (returnEnum.isSuccess()) {
			successResult(json, "设置餐桌数成功");
		} else {
			failResult(json, returnEnum.getMessage());
		}
	}
	
	/**
	 * 查询餐位
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void qureyDiningTable(HttpServletRequest request, JSONObject json, String string) {
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		
		//		List<DiningTableSituationInfo> diningTableSituationInfos = orderfoodService
		//			.qureyActiveDiningTable(sessionLocal.getUserId());
		QureyDiningTableOrder diningTableOrder = new QureyDiningTableOrder();
		List<DiningTableStatus> statusList = Lists.newArrayList();
		statusList.add(DiningTableStatus.UNWANTED);
		statusList.add(DiningTableStatus.USING);
		diningTableOrder.setSupplierId(sessionLocal.getUserId());
		diningTableOrder.setStatusList(statusList);
		diningTableOrder.setTableNumber(request.getParameter("tableNumber"));
		List<DiningTableSituationInfo> diningTableSituationInfos = orderfoodService
			.qureyDiningTableByCondition(diningTableOrder);
		
		if (ListUtil.isNotEmpty(diningTableSituationInfos)) {
			List<Map<String, String>> list = Lists.newArrayList();
			Map<String, String> map = null;
			for (DiningTableSituationInfo info : diningTableSituationInfos) {
				map = new HashMap<>();
				//餐桌号
				map.put("tableNumber", info.getTableNumber());
				
				//消费金额
				map.put("consumeAmount", info.getConsumeAmount().toString());
				
				//已点餐数量
				map.put("orderCount", toString(info.getOrderCount()));
				
				//已结算金额
				map.put("settleAccountsAmount", info.getSettleAccountsAmount().toString());
				
				//人数
				map.put("peopleNo", toString(info.getPeopleNo()));
				
				//状态
				map.put("status", info.getStatus().code());
				//使用中
				if (info.getStatus() == DiningTableStatus.USING) {
					if (info.getCanSettle() == null) {
						String canSettle = "YES";
						QueryOrderInfoSearchOrder searchOrder = new QueryOrderInfoSearchOrder();
						searchOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
						searchOrder.setTableNumberSeq(info.getTableNumberSeq());
						searchOrder.setPageSize(500);
						searchOrder.setSaleTypeOrderMeal(BooleanEnum.YES);
						QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
							.findOrderList(searchOrder);
						if (baseBatchResult.isSuccess()) {
							if (ListUtil.isEmpty(baseBatchResult.getPageList())) {
								canSettle = "NO";
							} else {
								for (OrderInfo orderinfo : baseBatchResult.getPageList()) {
									if (orderinfo.getOrderStatus() == OrderStatusEnum.PAD_ORDER) {
										canSettle = "NO";
										break;
									}
								}
							}
						}
						map.put("canSettle", canSettle);
					} else {
						map.put("canSettle", info.getCanSettle().code());
					}
				}
				//餐桌流水号
				map.put("tableNumberSeq", info.getTableNumberSeq());
				list.add(map);
			}
			json.put("list", list);
			successResult(json, "查询餐位成功");
		} else {
			failResult(json, "商户未设置餐位！");
		}
	}
	
	/**
	 * 选择餐位
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void selectDiningTable(HttpServletRequest request, JSONObject json, String string) {
		SelectDiningTableResult returnEnum = new SelectDiningTableResult();
		String tableNumber = request.getParameter("tableNumber");
		if (StringUtil.isNotEmpty(tableNumber)) {
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			SelectDiningTableOrder order = new SelectDiningTableOrder();
			order.setTableNumber(tableNumber);
			order.setSupplierId(sessionLocal.getUserId());
			order.setBelongTo(sessionLocal.getUserId());
			order.setProcessorId(sessionLocal.getUserId());
			returnEnum = orderfoodService.selectTableNumber(order);
		} else {
			failResult(json, "餐位不能为空！");
			return;
		}
		if (returnEnum.isSuccess()) {
			successResult(json, "选择餐位成功");
		} else {
			failResult(json, returnEnum.getMessage());
		}
	}
	
	/**
	 * 清除餐位（设置空闲）
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void clearTableNumber(HttpServletRequest request, JSONObject json, String string) {
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		String tableNumber = request.getParameter("tableNumber");
		if (StringUtil.isNotEmpty(tableNumber)) {
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			ClearMealOrder order = new ClearMealOrder();
			order.setTableNumber(tableNumber);
			order.setPadSupplierId(sessionLocal.getUserId());
			order.setBelongTo(sessionLocal.getUserId());
			order.setProcessorId(sessionLocal.getUserId());
			returnEnum = orderService.clearTableNumber(order);
		} else {
			failResult(json, "餐位不能为空！");
			return;
		}
		if (returnEnum.isSuccess()) {
			successResult(json, "取消餐位成功");
		} else {
			failResult(json, returnEnum.getMessage());
		}
	}
	
	/**
	 * pad点菜
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void padMealOrder(HttpServletRequest request, JSONObject json, String string) {
		
		String counts = request.getParameter("counts");
		String tableNumber = request.getParameter("tableNumber");
		String productId = request.getParameter("productId");
		ProductInfo productInfo = productService
			.findSupplierProductById(NumberUtil.parseLong(productId));
		if (productInfo == null) {
			failResult(json, "未找到该商品");
			return;
		}
		QureyDiningTableOrder diningTableOrder = new QureyDiningTableOrder();
		diningTableOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		diningTableOrder.setTableNumber(tableNumber);
		DiningTableSituationInfo tableSituationInfo = orderfoodService
			.getUseingDiningTable(diningTableOrder);
		long orderId = 0;
		long quantity = 0;
		if (tableSituationInfo != null) {
			QueryOrderInfoSearchOrder searchOrder = new QueryOrderInfoSearchOrder();
			//searchOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
			searchOrder.setTableNumberSeq(tableSituationInfo.getTableNumberSeq());
			searchOrder.setPageSize(500);
			searchOrder.setSaleTypeOrderMeal(BooleanEnum.YES);
			QueryBaseBatchResult<OrderInfo> baseBatchResult = orderService
				.findOrderList(searchOrder);
			if (baseBatchResult.isSuccess()) {
				for (OrderInfo info : baseBatchResult.getPageList()) {
					if (info.getOrderItemInfo().getItemProductId() == productInfo.getProductId()
						&& info.getOrderStatus() == OrderStatusEnum.PAD_ORDER) {
						orderId = info.getId();
						quantity = info.getOrderItemInfo().getQuantity();
					}
				}
			}
		}
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		//更新
		if (orderId > 0) {
			UpdateMealQuantityOrder quantityOrder = new UpdateMealQuantityOrder();
			quantityOrder.setTableNumber(tableNumber);
			quantityOrder.setPadSupplierId(sessionLocal.getUserId());
			quantityOrder.setProcessorId(sessionLocal.getUserId());
			quantityOrder.setOrderId(orderId);
			quantityOrder.setQuantity(NumberUtil.parseLong(counts) + quantity);
			EsupplierBaseResult result = orderService.updateQuantityMealOrder(quantityOrder);
			if (result.isSuccess()) {
				successResult(json, "点餐成功");
			} else {
				failResult(json, result.getMessage());
			}
		} else {
			List<CartItemInfo> cartItemInfos = Lists.newArrayList();
			CartItemInfo info = new CartItemInfo();
			info.setProductId(Long.parseLong(productId));
			info.setQuantity(Integer.parseInt(counts));
			info.setPrice(productInfo.getPrice1());
			info.setSupplierId(productInfo.getSupplierId());
			info.setSupplierName(productInfo.getSupplierName());
			info.setName(productInfo.getProductName());
			info.setImage(productInfo.getSmallPicPath());
			cartItemInfos.add(info);
			
			SupplierInfo supplierInfo = supplierService.getSupplier(sessionLocal.getUserId());
			MealOrder mealOrder = new MealOrder();
			mealOrder.setTableNumber(tableNumber);
			mealOrder.setList(cartItemInfos);
			mealOrder.setPadSupplierId(sessionLocal.getUserId());
			mealOrder.setProcessorId(sessionLocal.getUserId());
			mealOrder.setSupplierName(supplierInfo.getStoreName());
			mealOrder.setSupplierNikeName(supplierInfo.getNickname());
			BillSaveResult result = orderService.mealOrder(mealOrder);
			if (result.isSuccess()) {
				Map<String, String> map = new HashMap<>();
				OrderInfo orderInfo = result.getOrderInfos().get(0);
				AppCommonUtil.beanToMap(orderInfo, map);
				json.put("info", map);
				successResult(json, "点餐成功");
			} else {
				failResult(json, result.getMessage());
			}
		}
	}
	
	/**
	 * pad更新点餐数据
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void padUpdateQuantityMealOrder(	HttpServletRequest request, JSONObject json,
												String string) {
		
		String counts = request.getParameter("counts");
		String tableNumber = request.getParameter("tableNumber");
		String orderId = request.getParameter("orderId");
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		UpdateMealQuantityOrder quantityOrder = new UpdateMealQuantityOrder();
		quantityOrder.setTableNumber(tableNumber);
		quantityOrder.setPadSupplierId(sessionLocal.getUserId());
		quantityOrder.setProcessorId(sessionLocal.getUserId());
		quantityOrder.setOrderId(NumberUtil.parseLong(orderId));
		quantityOrder.setQuantity(NumberUtil.parseLong(counts));
		EsupplierBaseResult result = orderService.updateQuantityMealOrder(quantityOrder);
		if (result.isSuccess()) {
			successResult(json, "更新点餐数据成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * pad确认点餐
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void padConfirmMealOrder(HttpServletRequest request, JSONObject json, String string) {
		
		String tableNumber = request.getParameter("tableNumber");
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		ConfirmMealOrder mealOrder = new ConfirmMealOrder();
		mealOrder.setTableNumber(tableNumber);
		mealOrder.setPadSupplierId(sessionLocal.getUserId());
		mealOrder.setProcessorId(sessionLocal.getUserId());
		BillSaveResult result = orderService.confirmMealOrder(mealOrder);
		if (result.isSuccess()) {
			json.put("batchNo", result.getBatchNo());
			json.put("ordersTime", DateUtil.simpleDate(result.getOrdersTime()));
			successResult(json, "确认点餐成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 确人派单
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void confirmDeliveryMealOrder(HttpServletRequest request, JSONObject json,
											String string) {
		
		String batchNo = request.getParameter("batchNo");
		String isComplete = request.getParameter("isComplete");
		ConfirmDeliveryMealOrder order = new ConfirmDeliveryMealOrder();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setBatchNo(batchNo);
		order.setSupplierId(sessionLocal.getUserId());
		order.setProcessorId(sessionLocal.getUserId());
		if (StringUtil.isNotBlank(isComplete)) {
			order.setIsComplete(BooleanEnum.getByCode(isComplete));
		}
		EsupplierBaseResult result = orderService.confirmDeliveryMealOrder(order);
		if (result.isSuccess()) {
			if (order.getIsComplete() == BooleanEnum.YES) {
				successResult(json, "确认完成成功");
			} else {
				successResult(json, "确认派单成功");
			}
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 商户接单
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void orderTakingMealOrder(HttpServletRequest request, JSONObject json,
										String string) {
		
		String batchNo = request.getParameter("batchNo");
		String isPrintTicket = request.getParameter("isPrintTicket");
		OrderTakingMealOrder order = new OrderTakingMealOrder();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setBatchNo(batchNo);
		order.setSupplierId(sessionLocal.getUserId());
		order.setProcessorId(sessionLocal.getUserId());
		if (StringUtil.isNotBlank(isPrintTicket)) {
			order.setIsPrintTicket(BooleanEnum.getByCode(isPrintTicket));
		}
		EsupplierBaseResult result = orderService.orderTakingMealOrder(order);
		if (result.isSuccess()) {
			successResult(json, "接单成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 商户申请打印小票
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void printReceiptMealOrder(	HttpServletRequest request, JSONObject json,
											String string) {
		
		String batchNo = request.getParameter("batchNo");
		PrintReceiptMealOrder order = new PrintReceiptMealOrder();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setBatchNo(batchNo);
		order.setSupplierId(sessionLocal.getUserId());
		order.setProcessorId(sessionLocal.getUserId());
		EsupplierBaseResult result = orderService.applyPrintReceiptMealOrder(order);
		if (result.isSuccess()) {
			successResult(json, "申请打印小票成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 商户打印小票成功
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void printReceiptComplete(HttpServletRequest request, JSONObject json,
										String string) {
		
		String batchNo = request.getParameter("batchNo");
		PrintReceiptMealOrder order = new PrintReceiptMealOrder();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setBatchNo(batchNo);
		order.setSupplierId(sessionLocal.getUserId());
		order.setProcessorId(sessionLocal.getUserId());
		EsupplierBaseResult result = orderService.printReceiptComplete(order);
		if (result.isSuccess()) {
			successResult(json, "打印小票成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 待打印小票列表查询
	 * @param request
	 * @param json
	 * @param des
	 */
	protected void printReceiptList(HttpServletRequest request, JSONObject json, String des) {
		QueryOrderInfoSearchOrder orderInfoorder = new QueryOrderInfoSearchOrder();
		WebUtil.setPoPropertyByRequest(orderInfoorder, request);
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		UserBizTypeEnum bizTypeEnum = ShiroSessionUtils.getSessionLocal().getUserBizType();
		//排序
		orderInfoorder.setOrderByEnum(BillSearchOrderByEnum.RECEIPT_TIME_ASC);
		/* 订单类型 */
		orderInfoorder.setSaleTypeOrderMeal(BooleanEnum.YES);
		
		//		if (StringUtil.equals(refundStatus, OrderRefundStatusEnum.ALL.code())) {
		//			List<OrderRefundStatusEnum> refundList = new ArrayList<>();
		//			refundList.add(OrderRefundStatusEnum.REFUND_FAIL);
		//			refundList.add(OrderRefundStatusEnum.REFUND_SUCCESS);
		//			refundList.add(OrderRefundStatusEnum.REFUNDING);
		//			orderInfoorder.setRefundStatusList(refundList);
		//		}
		if (bizTypeEnum == UserBizTypeEnum.BUYER) {
			orderInfoorder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (bizTypeEnum == UserBizTypeEnum.SELLER) {
			orderInfoorder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		}
		if (StringUtil.isNotBlank(beginDate)) {
			orderInfoorder.setBeginDate(
				DateUtil.getStartTimeOfTheDate(DateUtil.strToDtSimpleFormat(beginDate)));
		}
		if (StringUtil.isNotBlank(endDate)) {
			orderInfoorder
				.setEndDate(DateUtil.getEndTimeOfTheDate(DateUtil.strToDtSimpleFormat(endDate)));
		}
		orderInfoorder.setReceiptStatusEnum(PrintReceiptStatusEnum.TO_BE_PRINTED);
		QueryBaseBatchResult<DiningOrderInfo> batchResult = orderService
			.findDiningOrderList(orderInfoorder);
		if (batchResult.isSuccess()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			for (DiningOrderInfo diningInfo : batchResult.getPageList()) {
				map = new HashMap<>();
				map.put("supplierName", diningInfo.getSupplierName());
				map.put("supplierId", toString(diningInfo.getSupplierId()));
				map.put("consumeTime", DateUtil.simpleDate(diningInfo.getConsumeTime()));
				map.put("batchNo", toString(diningInfo.getBatchNo()));
				map.put("diningAddress", diningInfo.getDiningAddress());
				map.put("diliverymanPhone", diningInfo.getDiliverymanPhone());
				map.put("totalPrice", diningInfo.getTotalAmount().toString());
				map.put("orderStatus", diningInfo.getOrderStatus().code());
				OrderInfo orderInfo = diningInfo.getOrderInfos().get(0);
				if (orderInfo.getSupplierId() == orderInfo.getTakegoodsId()) {
					map.put("diningSupplierName", diningInfo.getSupplierName());
				} else {
					SupplierInfo supplierInfo = supplierService
						.getSupplier(orderInfo.getTakegoodsId());
					if (supplierInfo != null) {
						map.put("diningSupplierName", supplierInfo.getRealName());
					} else {
						map.put("diningSupplierName", "");
					}
				}
				List<Map<String, String>> childList = new ArrayList<Map<String, String>>();
				for (OrderInfo info : diningInfo.getOrderInfos()) {
					map.put("diliverymanName", info.getDiliverymanName());
					map.put("tableNumber", info.getTableNumber());
					map.put("tableNumberSeq", info.getTableNumberSeq());
					map.put("printReceipt", info.getPrintReceipt().code());
					Map<String, String> childMap = new HashMap<>();
					AppCommonUtil.beanToMap(info, childMap);
					
					childMap
						.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
										+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
					childMap.put("productTheme", "");
					childMap.put("productStyle", "");
					childMap.put("qrCode", StringUtil.defaultIfEmpty(info.getQrCode(), ""));
					if (info.getPrintReceipt() != null) {
						childMap.put("printReceipt", info.getPrintReceipt().code());
					}
					List<OrderItemInfo> orderItemInfos = orderService
						.findOrderItemByOrderId(info.getId());
					if (ListUtil.isNotEmpty(orderItemInfos)) {
						ProductInfo info0 = productService
							.findProductById(orderItemInfos.get(0).getItemProductId());
						OrderItemInfo is = info.getOrderItemInfo();
						if (info0 != null) {
							childMap.put("productTheme", info0.getProductTheme());
							childMap.put("productStyle", info0.getProductStyle());
							childMap.put("productName", info0.getProductName());
							childMap.put("price", is.getProPrice().toStandardString());
							childMap.put("quantity", toString(is.getQuantity()));
							childMap.put("picPath", is.getPicPath());
							childMap.put("totalAmount", is.getTotalAmount().toStandardString());
							childMap.put("payAmount", info.getPayAmount().toStandardString());
							childMap.put("orderItemId", toString(is.getId()));
						}
					}
					childMap.remove("orderItemInfo");
					childList.add(childMap);
				}
				map.put("orderList", childList);
				list.add(map);
			}
			json.put("totalPage", batchResult.getPageCount());
			json.put("list", list);
			successResult(json, "订单列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(batchResult.getMessage(), "查询失败"));
		}
	}
	
	/**
	 * 配送完成
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void completeDelivery(HttpServletRequest request, JSONObject json, String string) {
		
		String batchNo = request.getParameter("batchNo");
		String isComplete = request.getParameter("isComplete");
		String supplierId = request.getParameter("supplierId");
		ConfirmDeliveryMealOrder order = new ConfirmDeliveryMealOrder();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setBatchNo(batchNo);
		order.setSupplierId(NumberUtil.parseLong(supplierId));
		order.setProcessorId(sessionLocal.getUserId());
		if (StringUtil.isNotBlank(isComplete)) {
			order.setIsComplete(BooleanEnum.getByCode(isComplete));
		}
		EsupplierBaseResult result = orderService.completeDelivery(order);
		if (result.isSuccess()) {
			successResult(json, "配送完成操作成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * pad已点餐订单列表查询
	 * @param request
	 * @param json
	 * @param des
	 */
	protected void padOrderMealList(HttpServletRequest request, JSONObject json, String des) {
		
		MealBaseOrder order = new MealBaseOrder();
		String tableNumber = request.getParameter("tableNumber");
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setTableNumber(tableNumber);
		order.setPadSupplierId(sessionLocal.getUserId());
		QueryBaseBatchResult<DiningOrderInfo> batchResult = orderQueryService
			.findPadDiningOrderList(order);
		if (batchResult.isSuccess()) {
			Money totalMoney = Money.zero();
			Money totalPostMoney = Money.zero();
			long totalCount = 0;
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = null;
			for (DiningOrderInfo diningInfo : batchResult.getPageList()) {
				map = new HashMap<>();
				map.put("supplierName", diningInfo.getSupplierName());
				map.put("supplierId", toString(diningInfo.getSupplierId()));
				map.put("consumeTime", DateUtil.simpleDate(diningInfo.getConsumeTime()));
				map.put("batchNo", toString(diningInfo.getBatchNo()));
				map.put("diningAddress", diningInfo.getDiningAddress());
				map.put("diliverymanPhone", diningInfo.getDiliverymanPhone());
				map.put("totalPrice", diningInfo.getTotalAmount().toString());
				map.put("totalPostFee", diningInfo.getTotalPostFee().toString());
				map.put("serviceChargeRate", toString(diningInfo.getServiceChargeRate()));
				totalPostMoney.addTo(diningInfo.getTotalPostFee());
				totalMoney.addTo(diningInfo.getTotalAmount());
				map.put("orderStatus", diningInfo.getOrderStatus().code());
				List<Map<String, String>> childList = new ArrayList<Map<String, String>>();
				for (OrderInfo info : diningInfo.getOrderInfos()) {
					map.put("diliverymanName", info.getDiliverymanName());
					map.put("tableNumber", info.getTableNumber());
					map.put("tableNumberSeq", info.getTableNumberSeq());
					Map<String, String> childMap = new HashMap<>();
					AppCommonUtil.beanToMap(info, childMap);
					childMap
						.put("address", StringUtil.defaultIfEmpty(info.getCity(), "")
										+ StringUtil.defaultIfEmpty(info.getDetailAddress(), ""));
					childMap.put("productTheme", "");
					childMap.put("productStyle", "");
					childMap.put("qrCode", StringUtil.defaultIfEmpty(info.getQrCode(), ""));
					
					List<OrderItemInfo> orderItemInfos = orderService
						.findOrderItemByOrderId(info.getId());
					if (ListUtil.isNotEmpty(orderItemInfos)) {
						ProductInfo info0 = productService
							.findProductById(orderItemInfos.get(0).getItemProductId());
						OrderItemInfo is = info.getOrderItemInfo();
						if (info0 != null) {
							childMap.put("productTheme", info0.getProductTheme());
							childMap.put("productStyle", info0.getProductStyle());
							childMap.put("productName", info0.getProductName());
							childMap.put("price", is.getProPrice().toStandardString());
							childMap.put("quantity", toString(is.getQuantity()));
							totalCount = totalCount + is.getQuantity();
							childMap.put("picPath", is.getPicPath());
							childMap.put("totalAmount", is.getTotalAmount().toStandardString());
							childMap.put("payAmount", info.getPayAmount().toStandardString());
							childMap.put("orderItemId", toString(is.getId()));
						}
					}
					childMap.remove("orderItemInfo");
					childList.add(childMap);
				}
				map.put("orderList", childList);
				list.add(map);
			}
			json.put("list", list);
			json.put("totalAmount", totalMoney.toString());
			json.put("totalPostAmount", totalPostMoney.toString());
			json.put("totalCount", totalCount);
			successResult(json, "订单列表查询成功");
		} else {
			failResult(json, StringUtil.defaultIfBlank(batchResult.getMessage(), "查询失败"));
		}
	}
	
	/**
	 * app取消订单
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void cancelDiningOrder(HttpServletRequest request, JSONObject json, String string) {
		
		String batchNo = request.getParameter("batchNo");
		String supplierId = request.getParameter("supplierId");
		CancelDiningOrder order = new CancelDiningOrder();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		order.setBatchNo(batchNo);
		order.setSupplierId(sessionLocal.getUserId());
		order.setProcessorId(sessionLocal.getUserId());
		order.setBizTypeEnum(sessionLocal.getUserBizType());
		order.setBelongTo(sessionLocal.getBelongTo());
		order.setSupplierId(NumberUtil.parseLong(supplierId));
		EsupplierBaseResult result = orderService.cancelDiningOrder(order);
		if (result.isSuccess()) {
			successResult(json, "订单取消成功");
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 商品上下架
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void updateProductStatus(HttpServletRequest request, JSONObject json, String string) {
		
		String productId = request.getParameter("productId");
		String productStatus = request.getParameter("productStatus");
		if (StringUtil.isBlank(productId)) {
			failResult(json, "商品ID不能为空");
			return;
		}
		long[] productIdArray = new long[1];
		productIdArray[0] = NumberUtil.parseLong(productId);
		UpdateProductStatusOrder productStatusOrder = new UpdateProductStatusOrder();
		//		productStatusOrder.setSupplierId(ShiroSessionUtils.getSessionLocal().getUserId());
		productStatusOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		productStatusOrder.setProductId(productIdArray);
		EsupplierBaseResult result = null;
		if (StringUtil.equals("ON", productStatus)) {
			result = productService.updateProductStatusOn(productStatusOrder);
		} else if (StringUtil.equals("OFF", productStatus)) {
			result = productService.updateProductStatusOff(productStatusOrder);
		} else {
			failResult(json, "商品状态不正确");
			return;
		}
		if (result.isSuccess()) {
			if (StringUtil.equals("ON", productStatus)) {
				successResult(json, "上架成功！");
			} else {
				successResult(json, "下架成功！");
			}
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 商户运营和关闭
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void updateSupplierRunState(	HttpServletRequest request, JSONObject json,
											String string) {
		
		String runState = request.getParameter("runState");
		
		SupplierRunStateEnum runStateEnum = SupplierRunStateEnum.getByCode(runState);
		if (StringUtil.isBlank(runState) || runStateEnum == null) {
			failResult(json, "营业状态不能为空");
			return;
		}
		EsupplierBaseResult result = supplierService.updateSupplierDiningRunState(
			ShiroSessionUtils.getSessionLocal().getUserId(), runStateEnum);
		if (result.isSuccess()) {
			if (StringUtil.equals("Opening", runState)) {
				successResult(json, "开店成功！");
			} else {
				successResult(json, "关店成功！");
			}
		} else {
			failResult(json, result.getMessage());
		}
	}
	
	/**
	 * 获取菜系列表
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void getDiningTypeList(HttpServletRequest request, JSONObject json, String string) {
		
		json.put("list", AppConstantsUtil.getVarietiesOfFood());
		successResult(json, "获取菜系列表成功");
		
	}
	
	/**
	 * 获取配送员当日配送数
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void getDeliverHomePage(HttpServletRequest request, JSONObject json, String string) {
		
		QueryOrderInfoSearchOrder orderInfoorder = new QueryOrderInfoSearchOrder();
		/* 订单类型 */
		orderInfoorder.setSaleTypeOrderMeal(BooleanEnum.YES);
		orderInfoorder.setTuneMeal(BooleanEnum.YES);
		orderInfoorder.setOrderStatus(OrderStatusEnum.JYC);
		orderInfoorder.setDiliverymanId(ShiroSessionUtils.getSessionLocal().getUserId());
		long count = orderQueryService.findDayDeliverCount(orderInfoorder);
		json.put("dayCount", count);
		json.put("day", DateUtil.dtSimpleFormat(new Date()));
		orderInfoorder.setOrderStatus(OrderStatusEnum.YFH);
		QueryBaseBatchResult<DiningOrderInfo> batchResult = orderService
			.findDiningOrderList(orderInfoorder);
		if (batchResult.isSuccess() && ListUtil.isNotEmpty(batchResult.getPageList())) {
			DiningOrderInfo diningInfo = batchResult.getPageList().get(0);
			OrderInfo orderInfo = diningInfo.getOrderInfos().get(0);
			Map<String, String> map = new HashMap<>();
			map.put("supplierName", diningInfo.getSupplierName());
			map.put("supplierId", toString(diningInfo.getSupplierId()));
			map.put("batchNo", toString(diningInfo.getBatchNo()));
			map.put("diningAddress", diningInfo.getDiningAddress());
			SupplierInfo supplierInfo = supplierService.getSupplier(orderInfo.getTakegoodsId());
			if (supplierInfo != null) {
				map.put("diningSupplierName", supplierInfo.getRealName());
				map.put("diningSupplierId", toString(supplierInfo.getSupplierId()));
				if (orderInfo.getUserId() == 0) {
					map.put("moblieNumber", supplierInfo.getMobile());
				}
			}
			if (orderInfo.getUserId() > 0) {
				UserQueryResult queryResult = userQueryService.queryByUserId(orderInfo.getUserId());
				if (queryResult.isSuccess() && queryResult.getQueryUserInfo() != null) {
					map.put("moblieNumber", queryResult.getQueryUserInfo().getMobile());
				}
			}
			map.put("tableNumber", orderInfo.getTableNumber());
			json.put("info", map);
		}
		
		successResult(json, "获取配送员首页信息成功");
		
	}
	
	/**
	 * 设置操作密码
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void setOperatePwd(HttpServletRequest request, JSONObject json, String string) {
		String password = request.getParameter("password");
		if (StringUtil.isBlank(password)) {
			failResult(json, "密码不能为空！");
			return;
		}
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			password = AESUtil.decode(password);
		}
		
		EsupplierBaseResult baseResult = userBaseInfoManager
			.setOperatePassword(ShiroSessionUtils.getSessionLocal().getUserBaseId(), password);
		if (baseResult.isSuccess()) {
			successResult(json, "密码设置成功");
		} else {
			failResult(json, "密码设置失败");
		}
		
	}
	
	/**
	 * 验证操作密码
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void validationOperatePwd(HttpServletRequest request, JSONObject json,
										String string) {
		String password = request.getParameter("password");
		if (StringUtil.isBlank(password)) {
			failResult(json, "密码不能为空！");
			return;
		}
		if (StringUtil.notEquals("ex", request.getParameter("ex"))) {
			password = AESUtil.decode(password);
		}
		
		EsupplierBaseResult baseResult = userBaseInfoManager.validationOperatePassword(
			ShiroSessionUtils.getSessionLocal().getUserBaseId(), password);
		if (baseResult.isSuccess()) {
			successResult(json, "密码正确");
		} else {
			failResult(json, "密码错误");
		}
		
	}
	
	/**
	 * pad点餐二维码
	 * @param request
	 * @param response
	 * @param json
	 * @param string
	 * @throws Exception
	 */
	public void getPadQrCode(	HttpServletRequest request, HttpServletResponse response,
								JSONObject json, String string) throws Exception {
		String tableNumbers = request.getParameter("tableNumbers");
		String supplierIdStr = request.getParameter("supplierId");
		if (StringUtil.isNotBlank(tableNumbers)) {
			String text = "";
			long supplierId = 0;
			if (ShiroSessionUtils.getSessionLocal() == null) {
				supplierId = NumberUtil.parseLong(supplierIdStr);
			} else {
				supplierId = ShiroSessionUtils.getSessionLocal().getUserId();
			}
			String[] tableNumberspit = tableNumbers.split(",");
			List<Long> ids = Lists.newArrayList();
			String orderIds = "";
			Money amount = Money.zero();
			for (String tableNumber : tableNumberspit) {
				QureyDiningTableOrder diningTableOrder = new QureyDiningTableOrder();
				//				ShiroSessionUtils.getSessionLocal().getUserId()
				diningTableOrder.setSupplierId(supplierId);
				diningTableOrder.setTableNumber(tableNumber);
				DiningTableSituationInfo tableSituationInfo = orderfoodService
					.getUseingDiningTable(diningTableOrder);
				if (tableSituationInfo != null) {
					QueryOrderInfoSearchOrder infoSearchOrder = new QueryOrderInfoSearchOrder();
					infoSearchOrder.setTableNumberSeq(tableSituationInfo.getTableNumberSeq());
					//infoSearchOrder.setSupplierId(diningTableOrder.getSupplierId());
					infoSearchOrder.setPageSize(5000);
					QueryBaseBatchResult<OrderInfo> batchResult = orderQueryService
						.findOrderList(infoSearchOrder);
					for (OrderInfo orderInfo : batchResult.getPageList()) {
						if (orderInfo.getIsPayed() != BooleanEnum.YES) {
							if (orderInfo.getOrderStatus() == OrderStatusEnum.WFK
									|| orderInfo.getOrderStatus() == OrderStatusEnum.PAD_ORDER_CONFIRM
								|| (supplierId == orderInfo.getTakegoodsId()
										&& orderInfo
										.getTuneMeal() == BooleanEnum.YES
									&& OrderStatusEnum.PAD_ORDER != orderInfo.getOrderStatus())) {
								ids.add(orderInfo.getId());
								orderIds = orderIds + orderInfo.getId() + ",";
								amount.addTo(orderInfo.getPayAmount());
							}
							
						}
					}
				}
				
			}
			if (StringUtil.isNotBlank(orderIds)) {
				orderIds = orderIds.substring(0, orderIds.length() - 1);
			}
			JSONObject jsonnew = new JSONObject();
			jsonnew.put("orderIds", orderIds);
			jsonnew.put("amount", amount.toString());
			jsonnew.put("codeType", "padDining");
			text = jsonnew.toJSONString();
			HttpSession session = request.getSession();
			BufferedImage bufferedImage = Image.creatImage(session);
			ServletOutputStream outputStream = response.getOutputStream();
			try {
				QRCodeUtil.encodeOutStream(text, null, outputStream, true);
				ImageIO.write(bufferedImage, "jpg", outputStream);
				outputStream.flush();
				outputStream.close();
			} catch (Exception e) {
			} finally {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			}
			successResult(json, "加载二维码成功");
		}
	}
	
	/**
	 * 获取长包房设置信息
	 * @param request
	 * @param json
	 * @param string
	 */
	protected void getLongRoomSetInfo(HttpServletRequest request, JSONObject json, String string) {
		
		String userBaseId = ShiroSessionUtils.getSessionLocal().getBelongToUserInfo()
			.getUserBaseId();
		
		ScenicQueryResult result = scenicService.queryByUserBaseId(userBaseId);
		if (!result.isSuccess() || result.getQueryScenicInfo() == null) {
			failResult(json, "商户景区无效");
			return;
		}
		String productId = request.getParameter("productId");
		long scenicId = result.getQueryScenicInfo().getId();
		HotelDiscountOrder hotelDiscountOrder = new HotelDiscountOrder();
		hotelDiscountOrder.setScenicId(scenicId);
		hotelDiscountOrder.setType(HotelTypeEnum.LONGRENT);
		hotelDiscountOrder.setPageSize(500);
		hotelDiscountOrder.setSetTimeSort("setTimeSort");
		QueryBaseBatchResult<HotelDiscountInfo> batchResult = hotelsDiscountService
			.searchHotelReleaseList(hotelDiscountOrder);
		if (batchResult.isSuccess()) {
			List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
			for (HotelDiscountInfo discountInfo : batchResult.getPageList()) {
				Map<String, String> map = new HashMap<>();
				String day = "";
				if (StringUtil.isNotBlank(discountInfo.getSetTime())) {
					day = discountInfo.getSetTime().replaceAll("天", "");
				}
				map.put("day", day);
				map.put("discount", toString(discountInfo.getDiscountBegin()));
				maps.add(map);
			}
			json.put("infos", maps);
			if (StringUtil.isNotBlank(productId)) {
				HotelLongSetResult longSetResult = hotelsSetLongRoomSerivce
					.findInfoBySupplierIdAndProductId(
						ShiroSessionUtils.getSessionLocal().getUserId(),
						NumberUtil.parseLong(productId));
				if (longSetResult.isSuccess()) {
					Map<String, Object> setMap = new HashMap<>();
					HotelLongSetInfo hotelLongSetInfo = longSetResult.getHotelLongSetInfo();
					setMap.put("ruleType", hotelLongSetInfo.getRuleType().code());
					setMap.put("roomNum", toString(hotelLongSetInfo.getRoomNum()));
					setMap.put("productId", toString(hotelLongSetInfo.getProductId()));
					setMap.put("supplierId", toString(hotelLongSetInfo.getSupplierId()));
					List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
					for (HotelLongDetailInfo hotelLongDetailInfo : hotelLongSetInfo
						.getHotelLongDetailInfos()) {
						Map<String, String> map = new HashMap<>();
						map.put("day", toString(hotelLongDetailInfo.getDays()));
						map.put("discount", toString(hotelLongDetailInfo.getDiscount() / 100));
						map.put("amount", hotelLongDetailInfo.getAmount().toString());
						listMap.add(map);
					}
					setMap.put("detailInfo", listMap);
					json.put("setInfo", setMap);
				}
			}
			successResult(json, "查询长包房配置条件成功");
		} else {
			failResult(json, "查询长包房配置条件失败");
		}
	}
	
	/**
	 * 提现到银行卡所有信息
	 */
	protected void accountWithdrawals(	HttpServletRequest request, JSONObject json,
										String desc) throws Exception {
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService
			.getUserAccountDataInfo(userId, false);
		List<BankConfigInfo> bankConfigInfoList = bankDataService.loadAllBankConfigInfo();
		UserQueryResult queryResult = userQueryService.queryByUserId(userId);
		UserInfo userInfo = queryResult.getQueryUserInfo();
		QueryBaseBatchResult accountResult = userBankService
			.queryUserBankInfo(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		if (userInfo.getRealNameAuthentication() == RealNameAuthStatusEnum.IS) {
			json.put("realName", userInfo.getRealName());
			json.put("realNameAuthentication", userInfo.getRealNameAuthentication().code());
			successResult(json, "提现账户已认证");
		} else {
			json.put("realName", "");
			json.put("realNameAuthentication", RealNameAuthStatusEnum.N.code());
			failResult(json, StringUtil.defaultIfBlank(accountResult.getMessage(), "提现账户未认证"));
		}
		json.put("bankConfigInfoList", bankConfigInfoList);
		json.put("userAccountDataInfo", userAccountDataInfo);
		
		List<UserBankInfo> tempList = accountResult.getPageList();
		List<Map> userBankInfoList = new ArrayList<>();
		
		for (UserBankInfo info : tempList) {
			Map map = new HashMap<>();
			AppCommonUtil.beanToMap(info, map);
			map.put("bankCardNo", AppCommonUtil.viewStr(info.getBankCardNo(), "idCard"));
			userBankInfoList.add(map);
		}
		
		json.put("userBankInfoList", userBankInfoList);
	}
	
	/**
	 * 保存 添加或修改银行卡
	 */
	protected void saveBankCard(HttpServletRequest request, JSONObject json,
								String desc) throws Exception {
		UserBankOrder userBankOrder = new UserBankOrder();
		String bankAccountName = request.getParameter("bankAccountName");
		userBankOrder.setBankAccountName(bankAccountName);
		String bankCardNo = request.getParameter("bankCardNo");
		userBankOrder.setBankCardNo(bankCardNo);
		String bankType = request.getParameter("bankType");
		userBankOrder.setBankType(bankType);
		BankConfigInfo bankConfigInfo = bankDataService.loadBankConfigInfo(bankType);
		userBankOrder.setBankKey(bankConfigInfo.getBankName());
		String p = request.getParameter("p");
		String c = request.getParameter("c");
		if (ShiroSessionUtils.getSessionLocal().getUserTypeEnum() == UserTypeEnum.JG) {
			userBankOrder.setBankProvince(p);
			userBankOrder.setBankCity(c);
		}
		userBankOrder.setCardUseType(ExtPayTypeEnum.WITHDRAW);
		String defaultBankCard = request.getParameter("defaultBankCard");
		if (StringUtil.isNotEmpty(defaultBankCard)) {
			userBankOrder.setIsDefault(BooleanEnum.getByCode(defaultBankCard));
		} else {
			userBankOrder.setIsDefault(BooleanEnum.NO);
		}
		userBankOrder.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		/** 一个用户只能有一个默认银行卡,传入id则更新银行卡，没传则添加银行卡 */
		EsupplierBaseResult baseResult = new EsupplierBaseResult();
		String id = request.getParameter("id");
		if (StringUtil.isNotBlank(id)) {
			userBankOrder.setId(NumberUtil.parseLong(id));
			baseResult = userBankService.updateUserBankInfo(userBankOrder);
		} else {
			
			/**
			 * 一个用户不能出现两withdrawFlowOrder.setAmount(new
			 * Money(withdrawalsMoney));张卡相同卡号
			 */
			UserBankInfo userBankInfo = userBankService.loadUserWithdrawCardInfo(
				userBankOrder.getUserBaseId(), userBankOrder.getBankCardNo());
			if (userBankInfo != null) {
				logger.info("保存银行卡信息失败");
				failResult(json, "保存银行卡信息失败,您已保存此银行卡");
				return;
			}
			baseResult = userBankService.addUserBankInfo(userBankOrder);
		}
		if (baseResult.isSuccess()) {
			logger.info("保存银行卡信息成功");
			successResult(json, "保存银行卡信息成功");
		} else {
			logger.info("保存银行卡信息失败");
			failResult(json, "保存银行卡信息失败");
		}
	}
	
	/**
	 * 修改银行卡 入口
	 */
	protected void updateBankCard(	HttpServletRequest request, JSONObject json,
									String desc) throws Exception {
		String id = request.getParameter("id");
		UserBankInfo userBankInfo = userBankService.loadUserBankInfo(NumberUtil.parseLong(id));
		if (userBankInfo == null) {
			failResult(json, "没有该数据");
			return;
		}
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		if (!com.yjf.common.lang.util.StringUtil.equals(userBankInfo.getUserBaseId(),
			ShiroSessionUtils.getSessionLocal().getUserBaseId())) {
			failResult(json, "无权限访问该数据");
			return;
		}
		json.put("userBankInfo", userBankInfo);
		json.put("id", String.valueOf(id));
		UserQueryResult queryResult = userQueryService.queryByUserId(userId);
		UserInfo userInfo = queryResult.getQueryUserInfo();
		if (userInfo.getRealNameAuthentication() == RealNameAuthStatusEnum.IS) {
			json.put("realName", userInfo.getRealName());
			json.put("realNameAuthentication", userInfo.getRealNameAuthentication().code());
		} else {
			json.put("realName", "");
			json.put("realNameAuthentication", RealNameAuthStatusEnum.N.code());
		}
		UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService
			.getUserAccountDataInfo(userId, false);
		List<BankConfigInfo> bankConfigInfoList = bankDataService.loadAllBankConfigInfo();
		
		QueryBaseBatchResult accountResult = userBankService
			.queryUserBankInfo(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		json.put("bankConfigInfoList", bankConfigInfoList);
		json.put("userAccountDataInfo", userAccountDataInfo);
		json.put("userBankInfoList", accountResult.getPageList());
		successResult(json, "修改银行卡信息查询成功");
	}
	
	/**
	 * 提现到银行卡
	 */
	protected void withdrawalToCard(HttpServletRequest request, JSONObject json,
									String desc) throws Exception {
		accountWithdrawals(request, json, "提现到银行卡所有信息");
		
		String id = request.getParameter("bankInfoId");
		UserBankInfo userBankInfo = userBankService.loadUserBankInfo(NumberUtil.parseLong(id));
		String withdrawalsMoney = request.getParameter("withdrawalsMoney");
		WithdrawFlowOrder withdrawFlowOrder = new WithdrawFlowOrder();
		BeanCopier.staticCopy(userBankInfo, withdrawFlowOrder);
		withdrawFlowOrder.setAmount(new Money(withdrawalsMoney));
		if (!withdrawFlowOrder.getAmount()
			.greaterThan(new Money(AppConstantsUtil.getWithdrawDepositCost()))) {
			logger.info("用户申请提现失败，提现金额不能小于等于" + AppConstantsUtil.getWithdrawDepositCost());
			failResult(json, "用户申请提现失败，提现金额不能小于等于" + AppConstantsUtil.getWithdrawDepositCost());
			return;
		}
		if (ShiroSessionUtils.getSessionLocal().getUserTypeEnum() == UserTypeEnum.GR) {
			withdrawFlowOrder.setPublicTag(BooleanEnum.NO);
		} else {
			withdrawFlowOrder.setPublicTag(BooleanEnum.YES);
		}
		withdrawFlowOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		withdrawFlowOrder.setUserName(ShiroSessionUtils.getSessionLocal().getUserName());
		withdrawFlowOrder.setUserRealName(userBankInfo.getBankAccountName());
		withdrawFlowOrder.setBankCode(userBankInfo.getBankType());
		withdrawFlowOrder.setBankAccountNo(userBankInfo.getBankCardNo());
		withdrawFlowOrder.setBankAcountName(userBankInfo.getBankAccountName());
		EsupplierBaseResult baseResult = toCardFlowService.withdrawApply(withdrawFlowOrder);
		if (baseResult.isSuccess()) {
			logger.info("用户申请提现成功，待管理员审核");
			successResult(json, "用户申请提现成功，待管理员审核");
		} else {
			logger.info("用户申请提现失败，原因{}", baseResult.getMessage());
			failResult(json, "用户申请提现失败");
		}
	}
	
	/**
	 * 选择银行卡
	 */
	protected void chooseCard(	HttpServletRequest request, JSONObject json,
								String desc) throws Exception {
		accountWithdrawals(request, json, "提现到银行卡所有信息");
	}
	
	/**
	 * 提现详情
	 */
	protected void withdrawalsInfo(	HttpServletRequest request, JSONObject json,
									String desc) throws Exception {
		String id = request.getParameter("userBankInfoId");
		ToCardFlowInfo toCardFlowInfo = toCardFlowService.queryById(NumberUtil.parseLong(id));
		if (toCardFlowInfo != null) {
			Date rawAddTime = toCardFlowInfo.getRawAddTime();
			toCardFlowInfo.setApplyTime(rawAddTime);
			json.put("toCardFlowInfo", toCardFlowInfo);
			json.put("statusMsg", toCardFlowInfo.getStatus().getMessage());
			successResult(json, "提现详情查询成功");
		} else {
			failResult(json, "提现详情查询失败");
		}
	}
	
	protected void doWxInfo(HttpServletRequest request, HttpSession session,
			HttpServletResponse response, JSONObject json,
			String string) throws IOException {
			
		String code = request.getParameter("code");
		if (StringUtil.isEmpty(code)) {
			failResult(json, "未授权登陆");
		}
		try {
			Map<String, Object> userInfoMap = Oauth2Servlet.getInfoByCode(request, response);
			logger.info("获取信息成功");
			json.put("userInfoMap", userInfoMap);
			successResult(json, "获取用户信息成功！");
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 转化成字符串，防止空指针 */
	private static String toString(Object str) {
		if (str == null) {
			return "";
		}
		return String.valueOf(str);
		
	}
	
	public static void main(String[] args) {
		for (int x = 0; x <= 10; x++) {
			// 影响轨迹
			for (int z = 9; z >= x; z--) {
				System.out.print(" ");
			}
			// 这是控制左边的坐标
			for (int y = 1; y <= x + 1; y++) {
				System.out.print("*");
			}
			// 这个是控制右边的坐标
			for (int y = 1; y < x + 1; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/** -------------接口调用功能------------------- **/
	/** 通用成功返回 */
	protected void successResult(JSONObject json, String mes) {
		json.put("code", 1);
		json.put("message", StringUtil.defaultIfBlank(mes, "操作成功"));
	}
	
	/** 通用失败返回信息 */
	protected void failResult(JSONObject json, String mes) {
		json.put("code", 0);
		json.put("message", StringUtil.defaultIfBlank(mes, "操作失败"));
	}
	
}
