package com.yjf.esupplier.web.controller.front.platform;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.ConfigParamProperty;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.domain.ProductDomain;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.service.base.data.BankDataService;
import com.yjf.esupplier.service.bill.DrawerAddressService;
import com.yjf.esupplier.service.bill.OrderQueryService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.service.hotel.result.HotelOrderResult;
import com.yjf.esupplier.service.pay.PayService;
import com.yjf.esupplier.service.pay.order.BalancePointOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.UserAccountDataQueryService;
import com.yjf.esupplier.service.user.info.UserAccountDataInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.web.controller.front.platform.bean.Cart;
import com.yjf.esupplier.web.controller.front.platform.bean.Cart.CartItem;
import com.yjf.esupplier.web.util.AppCommonUtil;
import com.yjf.esupplier.web.util.WebSessionUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.enums.IsBuyEnum;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.TakeWaysEnum;
import com.yjf.esupplier.ws.bill.info.DeliveryShipInfo;
import com.yjf.esupplier.ws.bill.info.OrderInfo;
import com.yjf.esupplier.ws.bill.info.OrderItemInfo;
import com.yjf.esupplier.ws.bill.order.BillSaveOrder;
import com.yjf.esupplier.ws.bill.order.OrderQRCodeOrder;
import com.yjf.esupplier.ws.bill.order.PostFeeOrder;
import com.yjf.esupplier.ws.bill.order.QueryOrderInfoSearchOrder;
import com.yjf.esupplier.ws.bill.result.BillSaveResult;
import com.yjf.esupplier.ws.common.enums.PaymentTypeEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.gifamount.order.GainMoneyUseOrder;
import com.yjf.esupplier.ws.gifamount.result.UseGainMoneyResult;
import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.hotel.order.HotelOrderNumOrder;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.info.DrawerAddressInfo;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.result.ShopingCartResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import com.yjf.esupplier.ws.storage.info.ProductStorageInfo;

@Controller
@RequestMapping("/front")
public class FrontOrderController extends FrontAutowiredBaseController {
	
	static String				path	= "front/order/";
	@Autowired
	BankDataService				bankDataService;
	@Autowired
	PayService					payService;
	@Autowired
	GiftMoneyTradeQueryService	giftMoneyTradeQueryService;
	@Autowired
	DrawerAddressService		drawerAddressService;
	@Autowired
	UserAccountDataQueryService	userAccountDataQueryService;
	@Autowired
	OrderQueryService			orderQueryService;
	
	/**
	 * 创建订单信息 2010-3-16
	 * 
	 * @throws Exception
	 * @throws Exception
	 * @author yuwenqiang
	 * @return5
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("platform/mall/toConfirmInfoPage.htm")
	public String toConfirmInfoPage(HttpServletRequest request, HttpServletResponse response,
									Model model) throws Exception {
		//    	Long[] _s_id = productIds;
		String token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
		model.addAttribute("token", token);
		return path + "newOrderConfirm.vm";
	}
	
	@ResponseBody
	@RequestMapping("updatePostFee.htm")
	public Object updateMerchantState(HttpServletRequest request, HttpServletResponse response,
										Model model) {
		JSONObject json = new JSONObject();
		String postFee = request.getParameter("postFee");
		String orderId = request.getParameter("orderId");
		EsupplierBaseResult result = null;
		PostFeeOrder postFeeOrder = new PostFeeOrder();
		postFeeOrder.setBizNo(NumberUtil.parseLong(orderId));
		postFeeOrder.setPostFee(new Money(postFee));
		postFeeOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		result = orderService.setPostFee(postFeeOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改运费成功!");
		} else {
			json.put("code", 0);
			json.put("message", "修改运费失败:" + result.getMessage());
		}
		return json;
	}
	
	@RequestMapping("infoConfirm.htm")
	public String infoConfirm(HttpServletRequest request, HttpServletResponse response,
								Model model, String proIds) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		String province = "";
		//		if (toToken == null || !toToken.endsWith(token)) {
		//			model.addAttribute("message", "请无重新提交！");
		//			return path + "orderError.vm";
		//		}
		request.getSession().removeAttribute(token);
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		Map<Long, List<CartItemInfo>> list = cart.getValue();
		Map<Long, List<CartItemInfo>> newListInfo = new HashMap<Long, List<CartItemInfo>>();
		String[] pIds = proIds.split(",");
		List<Long> supplierIds = Lists.newArrayList();
		for (Iterator<Entry<Long, List<CartItemInfo>>> it = list.entrySet().iterator(); it
			.hasNext();) {
			Map.Entry<Long, List<CartItemInfo>> entry = it.next(); //供应商ID
			if (ListUtil.isNotEmpty(entry.getValue())) {
				List<CartItemInfo> newCardItemInfos = Lists.newArrayList();
				for (CartItemInfo cartItemInfo : entry.getValue()) {
					for (int i = 0; i < pIds.length; i++) {
						if (NumberUtil.parseLong(pIds[i]) == cartItemInfo.getProductId()
							.longValue()) {
							ProductInfo productInfo = productService.findProductById(cartItemInfo
								.getProductId());
							if (!productInfo.getProductStatus().code()
								.equalsIgnoreCase(ProductStatusEnum.ON.getCode())) {
								model.addAttribute("message",
									"亲，你选购的商品:" + productInfo.getProductName() + "已经下架，请重新选购！");
								return path + "orderError.vm";
							}
							if (cartItemInfo.getSupplierId().equals(
								WebSessionUtil.getCurrentSessionLocal().getUserId())) {
								model.addAttribute("message", "亲，自己不能买自己发布的商品！");
								return path + "orderError.vm";
							}
							newCardItemInfos.add(cartItemInfo);
							break;
						}
					}
				}
				if (newCardItemInfos.size() > 0) {
					newListInfo.put(entry.getKey(), newCardItemInfos);
					supplierIds.add(entry.getKey());
				}
			}
		}
		List<CartItem> cartItems = cart.getViewCartList(newListInfo);
		List<DrawerAddressInfo> listAddresses = drawerAddressService.getAddresses(WebSessionUtil
			.getCurrentSessionLocal().getUserId());
		List<DrawerAddressInfo> drawerAddressInfos = orderService.getAddressesAndDefault(
			WebSessionUtil.getCurrentSessionLocal().getUserId(), "Y");
		if (drawerAddressInfos.size() > 0) {
			DrawerAddressInfo addressInfo = drawerAddressInfos.get(0);
			province = addressInfo.getProvince();
		}
		
		//计算实际支付的金额------------------------------------------------------------------------------
		
		UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService
			.getUserAccountDataInfo(ShiroSessionUtils.getSessionLocal().getUserId(), true);
		
		Map<Long, Money> notFreeShippingAmount = new HashMap();//每个商家不包邮的金额
		Money payPriceTotal = Money.zero(); // 实际支付金额
		//		Money postFee = Money.zero();//运费总额
		List<CartItemInfo> cartItemInfos = Lists.newArrayList();
		Map<Long, Money> amountMap = new HashMap();//每个供应商的金额
		for (CartItem cartItem : cartItems) {
			cartItemInfos.addAll(cartItem.getItemInfos());
			amountMap.put(cartItem.getSupplierId(), cartItem.getEveryPriceVal());
		}
		Map<Long, Money> feeMap = new HashMap<>();
		for (CartItemInfo cartItemInfo : cartItemInfos) {
			payPriceTotal.addTo(cartItemInfo.getTotalAmountNoShipment());
			
		}
		//		CalculatePostFeeResult postFeeResult = orderService.calculatePostFee(cartItemInfos);
		//-------------------------------------------------------------------------------------------------------------
		//		postFee = postFeeResult.getTotalAmount();
		//		orderService.calculatePostFee(cartItemInfos);
		//-------------------------------------------------------------------------------------------------------------
		//		List<InvoiceInfo> invoiceInfoList = invoiceService.findInvoiceByUserId(ShiroSessionUtils
		//			.getSessionLocal().getUserId());
		//		SupplierInvoiceResult supplierInvoiceResult = orderService.getSupplierInvoice(supplierIds,invoiceInfoList);
		//		model.addAttribute("invoiceListMap", supplierInvoiceResult.getInvoiceListMap());
		//		model.addAttribute("invoiceInfoList", invoiceInfoList);
		List<Map<String, String>> selectList = new ArrayList<>();
		/*包含运费的总费用*/
		Money totalPostFee = Money.zero();
		/*分景区存储运费*/
		Map<Long, Money> supplierMap = new HashMap<Long, Money>();
		for (Cart.CartItem info : cartItems) {
			for (CartItemInfo info0 : info.getItemInfos()) {
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
				
			}
			
		}
		
		model.addAttribute("newConfirmListInfo", cartItems);
		model.addAttribute("selectTotalAmount", cart.getSelectTotalAmount());
		model.addAttribute("payPriceTotal", payPriceTotal.add(totalPostFee));
		model.addAttribute("postFee", totalPostFee);
		model.addAttribute("totalAmount", payPriceTotal);
		request.getSession().setAttribute("newConfirmListInfo", cartItems);
		request.getSession().setAttribute("listAddresses", listAddresses);
		request.getSession().setAttribute("listAddressesCount", listAddresses.size());
		token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
		GainMoneyUseOrder gainMoneyUseOrder = new GainMoneyUseOrder();
		gainMoneyUseOrder.setInvestAmount(payPriceTotal);
		supplierIds.add(0L);
		//		gainMoneyUseOrder.setSupplierIdList(supplierIds);
		//		gainMoneyUseOrder.setAmountMap(amountMap);
		gainMoneyUseOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		UseGainMoneyResult gainMoneyResult = giftMoneyTradeQueryService
			.queryGainMoneyCanUseByTrade(gainMoneyUseOrder);
		model.addAttribute("token", token);
		model.addAttribute("payType", SaleTypeEnum.B2C);
		//		request.getSession().setAttribute("isBuy", IsBuyEnum.YES.code());
		model.addAttribute("gainMoneyTrades", gainMoneyResult.getGainMoneyTrades());
		//		model.addAttribute("gainMoneyListMap", gainMoneyResult.getGiftMoneyTradeInfosMap());
		model.addAttribute("userAccountDataInfo", userAccountDataInfo);
		//积分抵扣系数
		model.addAttribute("integralDeductionCoefficient",
			ConfigParamProperty.getIntegralDeductionCoefficient());
		return path + "orderConfirm.vm";
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param proIds
	 * @param quantity
	 * @param isBuy buy为YES为立即购买 NO则为获取样品
	 * @return
	 */
	@RequestMapping("buyNow.htm")
	public String buyNow(HttpServletRequest request, HttpServletResponse response, Model model,
							String proIds, String quantity, String isBuy) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		String payType = request.getParameter("payType");
		List<Long> supplierIds = Lists.newArrayList();
		Map<Long, Money> amountMap = new HashedMap();
		String province = "";
		request.getSession().removeAttribute(token);
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		String[] pIds = proIds.split(",");
		List<ProductInfo> productInfoList = new ArrayList<>();
		for (String pId : pIds) {
			ProductInfo productInfo = productService.findProductById(NumberUtil.parseLong(pId));
			productInfoList.add(productInfo);
			if (StringUtil.isNotEmpty(payType)) {
				model.addAttribute("payType", payType);
			} else {
				if (productInfo.getSaleTypeB2c() == BooleanEnum.YES) {
					model.addAttribute("payType", SaleTypeEnum.B2C);
				} else {
					model.addAttribute("payType", SaleTypeEnum.O2O);
				}
			}
		}
		List<CartItem> cartItems = new ArrayList<>();
		for (ProductInfo productInfo : productInfoList) {
			CartItem cartItem = new CartItem();
			List<CartItemInfo> cartItemInfoList = new ArrayList<>();
			CartItemInfo cartItemInfo = new CartItemInfo();
			
			BeanCopier.staticCopy(productInfo, cartItemInfo);
			cartItemInfo.setIsBuy(IsBuyEnum.getByCode(isBuy));
			cartItemInfo.setProductId(productInfo.getProductId());
			cartItemInfo.setSupplierId(productInfo.getSupplierId());
			cartItemInfo.setQuantity(NumberUtil.parseLong(quantity));
			cartItemInfo.setName(productInfo.getProductName());
			cartItemInfo.setImage(productInfo.getBigPicPath());
			//			if (ConfigParamProperty.isEnablePrice()) {
			//				Money price = ProductPriceUtil.getLevelPrice(productInfo,
			//					ShiroSessionUtils.getSessionLocal());
			//				cartItemInfo.setPrice(price.multiplyBy(productInfo.getProductMarketScale()));
			//			} else {
			//				cartItemInfo.setPrice(productInfo.getPrice1());
			//			}
			cartItemInfo.setPrice(productInfo.getPrice1());
			cartItemInfo.setPriceOriginal(productInfo.getPrice1());
			cartItemInfo.setSupplierName(productInfo.getSupplierName());
			cartItemInfo.setUnit(productInfo.getProductUnit());
			cartItemInfo.setPostType(productInfo.getPostType().getDbValue());
			cartItemInfo.setHtmlPath(productInfo.getHtmlPath());
			/*	List<DeliveryInfo> deliverys = deliveryService.getDelivery(productInfo.getProductId());
				DeliveryInfo deliveryInfo = deliverys.get(0);
				cartItemInfo.setDeliveryInfo(deliveryInfo);
				*/
			cartItemInfoList.add(cartItemInfo);
			cartItem.setItemInfos(cartItemInfoList);
			cartItem.setSupplierFullName(cartItemInfo.getSupplierName());
			cartItem.setSupplierId(cartItemInfo.getSupplierId());
			cartItems.add(cartItem);
		}
		if (SaleTypeEnum.getByCode(payType) == SaleTypeEnum.HOTELS) {
			long productId = NumberUtil.parseLong(proIds);
			long checkNum = NumberUtil.parseLong(request.getParameter("checkNum"), 1);
			String roomType = request.getParameter("roomType");
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			HotelTypeEnum hotelTypeEnum = HotelTypeEnum.getByCode(roomType);
			
			HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
			orderNumOrder.setHotelTypeEnum(hotelTypeEnum);
			orderNumOrder.setProductId(productId);
			orderNumOrder.setCheckNum(checkNum);
			orderNumOrder.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
			orderNumOrder.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
			HotelOrderResult hotelOrderResult = hotelsStockService
				.getHotelOrderCheckInfo(orderNumOrder);
			if (!hotelOrderResult.isSuccess()) {
				model.addAttribute("message", hotelOrderResult.getMessage());
				return path + "orderConfirmError.vm";
			}
			GainMoneyUseOrder gainMoneyUseOrder = new GainMoneyUseOrder();
			gainMoneyUseOrder.setInvestAmount(hotelOrderResult.getSumExecPrice());
			gainMoneyUseOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			//			UseGainMoneyResult gainMoneyResult = giftMoneyTradeQueryService
			//				.queryGainMoneyCanUseByTrade(gainMoneyUseOrder);
			for (CartItem cartItem : cartItems) {
				for (CartItemInfo cartItemInfo : cartItem.getItemInfos()) {
					cartItemInfo.setPrice(hotelOrderResult.getExecPrice());
					cartItemInfo.setPriceOriginal(hotelOrderResult.getExecPrice());
					cartItemInfo.setQuantity(checkNum);
					cartItemInfo.setBeginTime(DateUtil.parse(beginDate));
					//cartItemInfo.setMaxHotelNum(hotelOrderResult.getMaxHotelNum());
					cartItemInfo.setEndTime(DateUtil.parse(endDate));
					cartItemInfo.setRoomType(hotelTypeEnum);
					cartItemInfo.setDays(DateUtil.countDaysBetweenTwoDays(
						DateUtil.parse(beginDate), DateUtil.parse(endDate)));
				}
			}
			model.addAttribute("maxHotelNum", hotelOrderResult.getMaxHotelNum());
			model
				.addAttribute("avgTotalAmount", hotelOrderResult.getExecPrice().toStandardString());
			model.addAttribute("productId", productId);
			model.addAttribute("roomType", roomType);
			model.addAttribute("checkNum", checkNum);
			model.addAttribute("beginDate", beginDate);
			model.addAttribute("endDate", endDate);
			model.addAttribute("payType", payType);
			//			model.addAttribute("newConfirmListInfo", cartItems);
			//			request.getSession().setAttribute("newConfirmListInfo", cartItems);
		}//else{
		
		List<DrawerAddressInfo> listAddresses = drawerAddressService.getAddresses(WebSessionUtil
			.getCurrentSessionLocal().getUserId());
		List<DrawerAddressInfo> drawerAddressInfos = orderService.getAddressesAndDefault(
			WebSessionUtil.getCurrentSessionLocal().getUserId(), "Y");
		if (drawerAddressInfos.size() > 0 && StringUtil.equals(payType, SaleTypeEnum.B2C.code())) {
			DrawerAddressInfo addressInfo = drawerAddressInfos.get(0);
			province = addressInfo.getProvince();
		}
		
		Money payPriceTotal = Money.zero(); // 实际支付金额
		//		Money postFee = Money.zero();//运费总额
		List<CartItemInfo> cartItemInfos = Lists.newArrayList();
		for (CartItem cartItem : cartItems) {
			cartItemInfos.addAll(cartItem.getItemInfos());
			supplierIds.add(cartItem.getSupplierId());
			amountMap.put(cartItem.getSupplierId(), cartItem.getEveryPriceVal());
		}
		
		for (CartItemInfo cartItemInfo : cartItemInfos) {
			payPriceTotal.addTo(cartItemInfo.getTotalAmountNoShipment());
			/** 计算运费，取同一商户中商品最大的运费 */
		}
		//		CalculatePostFeeResult postFeeResult = orderService.calculatePostFee(cartItemInfos);
		//		//-------------------------------------------------------------------------------------------------------------
		//        List<InvoiceInfo> invoiceInfoList = invoiceService.findInvoiceByUserId(ShiroSessionUtils
		//                .getSessionLocal().getUserId());
		//		SupplierInvoiceResult supplierInvoiceResult = orderService.getSupplierInvoice(supplierIds,invoiceInfoList);
		//		model.addAttribute("invoiceListMap", supplierInvoiceResult.getInvoiceListMap());
		//		model.addAttribute("invoiceInfoList", invoiceInfoList);
		
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
				selectList.add(map);
			}
			
		}
		
		//        postFee = postFeeResult.getTotalAmount();
		
		//		CalculatePostFeeResult postFeeResult = orderService.calculatePostFee(cartItemInfos);
		//		//-------------------------------------------------------------------------------------------------------------
		//        List<InvoiceInfo> invoiceInfoList = invoiceService.findInvoiceByUserId(ShiroSessionUtils
		//                .getSessionLocal().getUserId());
		//		SupplierInvoiceResult supplierInvoiceResult = orderService.getSupplierInvoice(supplierIds,invoiceInfoList);
		//		model.addAttribute("invoiceListMap", supplierInvoiceResult.getInvoiceListMap());
		//		model.addAttribute("invoiceInfoList", invoiceInfoList);
		
		//        postFee = postFeeResult.getTotalAmount();
		
		model.addAttribute("newConfirmListInfo", cartItems);
		model.addAttribute("selectTotalAmount", cart.getSelectTotalAmount());
		if (IsBuyEnum.YES.code().equals(isBuy)) {
			model.addAttribute("payPriceTotal", payPriceTotal.add(totalPostFee));
			model.addAttribute("postFee", totalPostFee);
			model.addAttribute("totalAmount", payPriceTotal);
		} else {
			model.addAttribute("payPriceTotal", Money.zero());
			model.addAttribute("postFee", Money.zero());
			model.addAttribute("totalAmount", Money.zero());
		}
		request.getSession().setAttribute("newConfirmListInfo", cartItems);
		request.getSession().setAttribute("listAddresses", listAddresses);
		request.getSession().setAttribute("listAddressesCount", listAddresses.size());
		
		GainMoneyUseOrder gainMoneyUseOrder = new GainMoneyUseOrder();
		gainMoneyUseOrder.setInvestAmount(payPriceTotal);
		supplierIds.add(0L);
		gainMoneyUseOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		UseGainMoneyResult gainMoneyResult = giftMoneyTradeQueryService
			.queryGainMoneyCanUseByTrade(gainMoneyUseOrder);
		model.addAttribute("gainMoneyTrades", gainMoneyResult.getGainMoneyTrades());
		
		//	}
		//计算实际支付的金额------------------------------------------------------------------------------
		UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService
			.getUserAccountDataInfo(ShiroSessionUtils.getSessionLocal().getUserId(), false);
		model.addAttribute("userAccountDataInfo", userAccountDataInfo);
		//积分抵扣系数
		model.addAttribute("integralDeductionCoefficient",
			ConfigParamProperty.getIntegralDeductionCoefficient());
		token = UUID.randomUUID().toString();
		request.getSession().setAttribute("token", token);
		request.getSession().setAttribute("isBuy", IsBuyEnum.getByCode(isBuy).code());
		model.addAttribute("token", token);
		return path + "orderConfirm.vm";
	}
	
	@ResponseBody
	@RequestMapping("buyNowRefresh.json")
	public Object buyNowRefresh(HttpServletRequest request, HttpServletResponse response,
								Model model) {
		List<CartItem> cartItems = new ArrayList<>();
		cartItems = (List<CartItem>) request.getSession().getAttribute("newConfirmListInfo");
		
		JSONObject json = new JSONObject();
		long productId = NumberUtil.parseLong(request.getParameter("productId"));
		long checkNum = NumberUtil.parseLong(request.getParameter("checkNum"));
		String roomType = request.getParameter("roomType");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		HotelTypeEnum hotelTypeEnum = HotelTypeEnum.getByCode(roomType);
		for (CartItem cartItem : cartItems) {
			for (CartItemInfo cartItemInfo : cartItem.getItemInfos()) {
				cartItemInfo.setQuantity(checkNum);
			}
		}
		HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
		orderNumOrder.setHotelTypeEnum(hotelTypeEnum);
		orderNumOrder.setProductId(productId);
		orderNumOrder.setCheckNum(checkNum);
		orderNumOrder.setBeginDate(DateUtil.strToDtSimpleFormat(beginDate));
		orderNumOrder.setEndDate(DateUtil.strToDtSimpleFormat(endDate));
		HotelOrderResult hotelOrderResult = hotelsStockService
			.getHotelOrderCheckInfo(orderNumOrder);
		
		GainMoneyUseOrder gainMoneyUseOrder = new GainMoneyUseOrder();
		gainMoneyUseOrder.setInvestAmount(hotelOrderResult.getSumExecPrice());
		gainMoneyUseOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		
		UseGainMoneyResult gainMoneyResult = giftMoneyTradeQueryService
			.queryGainMoneyCanUseByTrade(gainMoneyUseOrder);
		if (hotelOrderResult.isSuccess()) {
			json.put("gainMoneyTrades", gainMoneyResult.getGainMoneyTrades());
			json.put("maxHotelNum", hotelOrderResult.getMaxHotelNum());
			json.put("avgTotalAmount", hotelOrderResult.getExecPrice().toStandardString());
			json.put("payPriceTotal", hotelOrderResult.getSumExecPrice().toStandardString());
			json.put("totalAmount", hotelOrderResult.getSumExecPrice().toStandardString());
			json.put("totalAmount", hotelOrderResult.getSumExecPrice().toStandardString());
			json.put("code", 1);
		} else {
			json.put("code", 0);
			json.put("message", hotelOrderResult.getMessage());
		}
		
		return json;
	}
	
	@RequestMapping("saveOrderInfo.htm")
	public String saveOrderInfo(HttpServletRequest request, HttpServletResponse response,
								Model model, String addressId) {
		String token = request.getParameter("token");
		String toToken = (String) request.getSession().getAttribute("token");
		//	String isBuy = (String) request.getSession().getAttribute("isBuy");
		if (toToken == null || !toToken.endsWith(token)) {
			model.addAttribute("message", "请勿重新提交！");
			return path + "orderError.vm";
		}
		request.getSession().removeAttribute("token");
		String[] specialExplain = request.getParameterValues("specialExplain");
		String drawerName = request.getParameter("drawerName");
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String detailAddress = request.getParameter("detailAddress");
		String zipCode = request.getParameter("zipCode");
		String drawerNumber = request.getParameter("drawerNumber");
		String mobileNumber = request.getParameter("mobileNumber");
		Map<Long, String> postFree = new HashMap<Long, String>();
		//request.getParameter("postFree");
		String totalFree = request.getParameter("totalFree");
		String userPoint = request.getParameter("userPoint");
		/**
		 *
		 */
		String takeWays = request.getParameter("takeWays");
		String takeGoodsAddr = request.getParameter("takeGoodsAddr");
		String gainMoneyTradesId = request.getParameter("gainMoneyTradesId");
		String payType = request.getParameter("payType");
		List<CartItem> newListInfo = (List<CartItem>) request.getSession().getAttribute(
			"newConfirmListInfo");
		List<CartItemInfo> cartItemInfos = Lists.newArrayList();
		
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		boolean canSeeMoney = ConfigParamProperty.getIsSeeMoney();
		UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService
			.getUserAccountDataInfo(sessionLocal.getUserId(), canSeeMoney);
		/*用户余额*/
		model.addAttribute("amount", userAccountDataInfo.getUserBalance().toStandardString());
		
		//判断库存是否足够
		int m = 0;
		for (CartItem cartItem : newListInfo) {
			for (CartItemInfo itemInfo : cartItem.getItemInfos()) {
				//				String postFreeValue = request.getParameter("postFree[" + m + "]");
				//				if (postFreeValue != null) {
				//					String postMode = postFreeValue.split(";")[0];
				postFree.put(itemInfo.getProductId(), "express");
				//				}
				m++;
			}
			cartItemInfos.addAll(cartItem.getItemInfos());
		}
		BillSaveOrder billSaveOrder = new BillSaveOrder();
		if (StringUtil.isNotEmpty(userPoint)) {
			billSaveOrder.setUserPoint(Long.parseLong(userPoint));
		} else {
			billSaveOrder.setUserPoint(0);
		}
		billSaveOrder.setSpecialExplain(specialExplain);
		billSaveOrder.setGainMoneyTradesId(gainMoneyTradesId);
		billSaveOrder.setPostFree(postFree);
		billSaveOrder.setTakeGoodsAddrId(NumberUtil.parseLong(takeGoodsAddr));
		billSaveOrder.setTakeWays(TakeWaysEnum.getByCode(takeWays));
		if (billSaveOrder.getTakeWays() == null)
			billSaveOrder.setTakeWays(TakeWaysEnum.DELIVERY);
		billSaveOrder.setList(cartItemInfos);
		billSaveOrder.setTotalFree(totalFree);
		List<OrderInfo> listOrder = null;
		BillSaveResult result = null;
		billSaveOrder.setAddressId(addressId);
		if (StringUtil.isNotBlank(payType)) {
			billSaveOrder.setSaleTypeEnum(SaleTypeEnum.getByCode(payType));
		}
		billSaveOrder.setNickname(ShiroSessionUtils.getSessionLocal().getNickname());
		billSaveOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		//		billSaveOrder.setIsBuy(IsBuyEnum.getByCode(isBuy));
		if (billSaveOrder.getSaleTypeEnum() == SaleTypeEnum.B2C) {
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
				DrawerAddressInfo address = drawerAddressService.findDrawerAddressById(addressId);
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
		} else {
			result = orderService.saveOrderInfo(billSaveOrder);
		}
		if (result.isSuccess()) {
			//订单创建成功之后要对之前session中的数据进行清除
			//productIds是选择的商品的ID
			listOrder = result.getOrderInfos();
			Money totalAmount = new Money(0);
			Money preferentialAmount = new Money(0);
			Money payAmount = new Money(0);
			String orderIds = "";
			String orderProductName = "";
			String[] orderArray = new String[listOrder.size()];
			int i = 0;
			/**
			 * 付款金额为0标识
			 */
			//			boolean feeZero = false;
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
				orderProductName += strOrderProductName;
				orderInfo.setProductName(strOrderProductName);
				orderInfo.setProductId(productId);
				i++;
				//				if (orderInfo.getOrderStatus() == OrderStatusEnum.YFK) {
				//					feeZero = true;
				//				}
			}
			
			/**
			 * 付款金额为零，则跳转到支付成功页面
			 */
			//			if (feeZero) {
			//				ProductRecommendOrder order = new ProductRecommendOrder();
			//				order.setProductStatus(ProductStatusEnum.ON);
			//				List<ProductInfo> recommendProductList = productRecommendService
			//					.getProductRecommendList(order).getPageList();
			//				model.addAttribute("recommendProductList", recommendProductList);
			//				
			//				model.addAttribute("message", "支付成功");
			//				model.addAttribute("paymentAmount", payAmount);
			//				return path + "paymentOk.vm";
			/*全积分支付*/
			if (!payAmount.greaterThan(Money.zero())) {
				BalancePointOrder order = new BalancePointOrder();
				order.setPayType(PaymentTypeEnum.POINT_PAYMENT.getCode());
				order.setIds(orderIds);
				order.setTradeName(orderProductName);
				order.setAmount(new Money(NumberUtil.parseLong(userPoint)
											/ ConfigParamProperty.getIntegralDeductionCoefficient()
											* 100));
				payService.creatBalancePointOrder(order, getOpenApiContext());
				
				model.addAttribute("message", "支付成功");
				return path + "paymentOk.vm";
				
			}
			//			}
			Cart cart = WebSessionUtil.getStaticCurrentCart();
			
			for (CartItem cartItem : newListInfo) {
				for (CartItemInfo cartItemInfo : cartItem.getItemInfos()) {
					ProductInfo productInfo = productService.findProductById(cartItemInfo
						.getProductId());
					ShopingCartResult cartResult = cart.removeCartItemInfo(cartItemInfo);
					persistenceShopCart(productInfo, cartResult, cart.getShopingCartType());
				}
			}
			model.addAttribute("orderArray", orderArray);
			model.addAttribute("totalAmount", totalAmount);
			model.addAttribute("preferentialAmount", preferentialAmount);
			model.addAttribute("payAmount", payAmount);
			model.addAttribute("listOrder", listOrder);
			model.addAttribute("orderIds", orderIds);
			model.addAttribute("bankList", bankDataService.loadAllBankConfigInfo());
			addAccountInfo(model);
			return path + "orderOk.vm";
		} else {
			model.addAttribute("message", result.getMessage());
			return path + "orderError.vm";
		}
		
	}
	
	@RequestMapping("mergeOrderPay.htm")
	public String mergeOrderPay(HttpServletRequest request, HttpServletResponse response,
								Model model) throws Exception {
		String orderIds = request.getParameter("proIds");
		String[] orderArray = orderIds.split(",");
		Money preferentialAmount = new Money(0);
		Money payAmount = new Money(0);
		Money totalAmount = new Money();
		boolean isCanPay = true;
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		for (int i = 0; i < orderArray.length; i++) {
			OrderInfo orderInfo = orderService.findOrderById(new Long(orderArray[i]));
			List<OrderItemInfo> items = orderService.findOrderItemByOrderId(new Long(orderInfo
				.getId()));
			if (orderInfo.getOrderStatus() != OrderStatusEnum.WFK) {
				isCanPay = false;
				break;
			}
			/*判断酒店预订库存*/
			if (orderInfo.getSaleTypeHotels() == BooleanEnum.YES && items.size() > 0) { /*酒店预订*/
				OrderItemInfo orderItemInfo = items.get(0);
				HotelOrderNumOrder orderNumOrder = new HotelOrderNumOrder();
				orderNumOrder.setProductId(orderItemInfo.getItemProductId());
				orderNumOrder.setCheckNum(orderItemInfo.getQuantity());
				orderNumOrder.setBeginDate(orderItemInfo.getBeginTime());
				orderNumOrder.setEndDate(orderItemInfo.getEndTime());
				orderNumOrder.setHotelTypeEnum(orderItemInfo.getRoomType());
				HotelOrderResult hotelOrderResult = hotelsStockService
					.getHotelOrderCheckInfo(orderNumOrder);
				if (!hotelOrderResult.isSuccess()) {
					model.addAttribute("message", hotelOrderResult.getMessage());
					return path + "orderError.vm";
				}
			}
			String strOrderProductName = "";
			for (OrderItemInfo oi : items) {
				strOrderProductName += " " + oi.getItemProductName();
				
			}
			totalAmount.addTo(orderInfo.getTotalAmount());
			preferentialAmount.addTo(orderInfo.getPreferentialAmount());
			
			payAmount.addTo(orderInfo.getPayAmount());
			
			orderInfo.setProductName(strOrderProductName);
			orderInfo.setOrderItems(items);
			list.add(orderInfo);
			
			boolean canSeeMoney = ConfigParamProperty.getIsSeeMoney();
			UserAccountDataInfo userAccountDataInfo = userAccountDataQueryService
				.getUserAccountDataInfo(ShiroSessionUtils.getSessionLocal().getUserId(),
					canSeeMoney);
			/*用户余额*/
			model.addAttribute("amount", userAccountDataInfo.getUserBalance().toStandardString());
			
		}
		if (isCanPay) {
			model.addAttribute("totalAmount", totalAmount);
			model.addAttribute("preferentialAmount", preferentialAmount);
			model.addAttribute("payAmount", payAmount);
			model.addAttribute("listOrder", list);
			model.addAttribute("orderArray", orderArray);
			model.addAttribute("bankList", bankDataService.loadAllBankConfigInfo());
			addAccountInfo(model);
			return path + "orderOk.vm";
		} else {
			model.addAttribute("message", "订单已经支付，不能重复支付");
			return path + "orderError.vm";
		}
		
	}
	
	private void addAccountInfo(Model model) {
		UserInfo userInfo = userQueryService.queryByUserId(
			ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
		if (StringUtil.isNotBlank(userInfo.getAccountId())) {
			QueryAccountResult accountResult = userAccountQueryService
				.getAccountInfo(ShiroSessionUtils.getSessionLocal());
			if (accountResult.getYjfAccountInfo().isActive()) {
				model.addAttribute("accountOpen", true);
				model.addAttribute("accountInfo", accountResult.getYjfAccountInfo());
			}
		}
	}
	
	/**
	 * 根据订单ID查询订单的详细信息 2010-4-14
	 * 
	 * @return
	 * @author yuwenqiang
	 */
	@RequestMapping("findOrderById.htm")
	public String findOrderById(HttpServletRequest request, HttpServletResponse response,
								Model model, Long orderId) {
		Money totalAmount = new Money();
		Money preferentialAmount = new Money(0);
		Money payAmount = new Money(0);
		OrderInfo order = orderService.findOrderById(orderId);
		model.addAttribute("order", order);
		List<OrderItemInfo> orderItemInfos = orderService.findOrderItemByOrderId(order.getId());
		totalAmount.addTo(order.getTotalAmount());
		preferentialAmount.addTo(order.getPreferentialAmount());
		payAmount.addTo(order.getPayAmount());
		model.addAttribute("orderItemInfos", orderItemInfos);
		//订单状态为Y时表示是查询卖家的详细信息
		//不为Y的时候表示是查询买家的详细信息
		//delivery = DeliveryService.getDeliveryByOrderId(orderId); //物流查询
		DeliveryShipInfo deliveryShipInfo = deliveryShipService.getDeliveryByOrderId(order.getId());
		model.addAttribute("deliveryShipInfo", deliveryShipInfo);
		model.addAttribute("sellerUserInfo", userQueryService.queryByUserId(order.getSupplierId())
			.getQueryUserInfo());
		model.addAttribute("editStatus", request.getParameter("editStatus"));
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("preferentialAmount", preferentialAmount);
		model.addAttribute("payAmount", payAmount);
		return path + "buyDetailOrderInfo.vm";
	}
	
	/**
	 * 根据订单ID查询订单的详细信息 2010-4-14
	 * 
	 * @return
	 * @author yuwenqiang
	 */
	@RequestMapping("findOrderDeliveryById.htm")
	public String findOrderDeliveryById(HttpServletRequest request, HttpServletResponse response,
										Model model, Long orderId) {
		OrderInfo order = orderService.findOrderById(orderId);
		model.addAttribute("order", order);
		List<OrderItemInfo> orderItemInfos = orderService.findOrderItemByOrderId(order.getId());
		model.addAttribute("orderItemInfos", orderItemInfos);
		//订单状态为Y时表示是查询卖家的详细信息
		//不为Y的时候表示是查询买家的详细信息
		//delivery = DeliveryService.getDeliveryByOrderId(orderId); //物流查询
		//    	if(orderStatus.equals("Y")){
		//    		return SUCCESS;
		//    	}else{
		//    		return INPUT;
		//    	}
		DeliveryShipInfo deliveryShipInfo = deliveryShipService.getDeliveryByOrderId(order.getId());
		model.addAttribute("deliveryShipInfo", deliveryShipInfo);
		model.addAttribute("sellerUserInfo", userQueryService.queryByUserId(order.getSupplierId())
			.getQueryUserInfo());
		model.addAttribute("orderStatus", request.getParameter("orderStatus"));
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("model", model);
			logger.info("json object " + jsonObject.toJSONString());
			PrintWriter pw = response.getWriter();
			pw.write(jsonObject.toJSONString());
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return null;
	}
	
	@RequestMapping("onceAgainPutShopCart.htm")
	public String onceAgainPutShopCart(HttpServletRequest request, HttpServletResponse response,
										Model model, Long orderId) {
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		List<OrderItemInfo> items = orderService.findOrderItemByOrderId(orderId);
		Cart cart = WebSessionUtil.getStaticCurrentCart();
		JSONObject jsonObject = new JSONObject();
		for (OrderItemInfo itemInfo : items) {
			
			ProductInfo productInfo = productService.getProductById(itemInfo.getItemProductId());
			ProductStorageInfo pro = storageService.getStorageInfo(productInfo.getProductId());
			Long kcNum = pro.getStockAmount() - pro.getPayedCount();
			if (kcNum <= 0) {
				jsonObject.put("result", false);
				jsonObject.put("message", "亲，商品:" + productInfo.getProductName() + " 数量不足！");
				printHttpResponse(response, jsonObject);
				return null;
			}
			if (!productInfo.getProductStatus().code().equals("on")) {
				jsonObject.put("result", false);
				jsonObject.put("message", "亲，你选购的商品:" + productInfo.getProductName()
											+ " 已经下架，请重新选购！");
				printHttpResponse(response, jsonObject);
				return null;
			}
			CartItemInfo cartItemInfo = new CartItemInfo(new Long(productInfo.getProductId()),
				new Long(productInfo.getSupplierId()), itemInfo.getQuantity());
			cartItemInfo.setSupplierName(orderInfo.getSupplierName());
			cartItemInfo.setSupplierId(orderInfo.getSupplierId());
			cartItemInfo.setName(productInfo.getProductName());
			cartItemInfo.setPrice(productInfo.getPrice1());
			cartItemInfo.setImage(productInfo.getSmallPicPath());
			cartItemInfo.setSupplierName(orderInfo.getSupplierName());
			cartItemInfo.setUnit(productInfo.getProductUnit());
			cartItemInfo.setPriceOriginal(productInfo.getMarketPrice());
			cartItemInfo.setPostType(productInfo.getPostType().getDbValue());
			/*邮费单独计算*/
			cartItemInfo.setDeliveryInfo(null);
			cart.addCartItemInfo(cartItemInfo);
		}
		//        sendUrl(response, "/front/platform/mall/toConfirmInfoPage.htm");
		jsonObject.put("result", true);
		printHttpResponse(response, jsonObject);
		return null;
		//return path + "newOrderConfirm.vm";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("mall/soConfirmInfoPage.htm")
	public String saveOrderInfo1(HttpServletRequest request, HttpServletResponse response,
									Model model) throws Exception {
		//    	Long[] _s_id = productIds;
		//		Cart cart = WebSessionUtil.getStaticCurrentCart();
		//		//    	newListInfo=new Hashtable<Long, Hashtable<Long, CartItem>>();
		//		//    	Hashtable<Long, CartItem> new_list_info=new Hashtable<Long, CartItem>();
		//		//    	Hashtable<Long, CartItem> old_list_info=table.get(supplierId);
		//		//    	for(int i=0;i<_s_id.length;i++){
		//		//        	for(Iterator it=old_list_info.keySet().iterator();it.hasNext();){
		//		//        		Long _key=(Long)it.next();
		//		//        		if(_key.compareTo(_s_id[i])==0){
		//		//        			CartItem item=old_list_info.get(_key);
		//		//        			new_list_info.put(supplierId, item);
		//		//        		}
		//		//        	}
		//		//    	}
		//		//    	newListInfo.put(supplierId, new_list_info);
		//
		//		newListInfo = (Hashtable<Long, Hashtable<Long, CartItem>>) this
		//			.session("newConfirmListInfo");
		//
		//		List<CartItemInfo> saveList = Lists.newArrayList();
		//		//判断库存是否足够
		//		for (Iterator<Entry<Long, List<CartItemInfo>>> it = cart.getValue().entrySet().iterator(); it
		//			.hasNext();) {
		//			Entry<Long, List<CartItemInfo>> entry = it.next();
		//			List<CartItemInfo> cartItemInfos = entry.getValue(); //每条订单信息
		//			for (CartItemInfo cartItemInfo : cartItemInfos) {
		//				ProductInfo product = displayProductService.findProductInfo(cartItemInfo
		//					.getProductId());
		//				if (product.getDiscount2Product().getActivityId() == null) {
		//					if ((product.getWareCount() - cartItemInfo.getQuantity()) < 0
		//						|| product.getWareCount() == 0) {
		//						model.addAttribute("productName_wareCount", cartItemInfo.getName());
		//						return "fail";
		//					}
		//				} else {
		//					cartItemInfo.setPriceType("1"); //产品参与的是活动，库存应该加活动库存
		//					cartItemInfo.setActivityId(product.getDiscount2Product().getActivityId());
		//					if (((product.getDiscount2Product().getAmount() - product.getDiscount2Product()
		//						.getOrderAmount()) - cartItemInfo.getQuantity()) < 0) {
		//						model.addAttribute("productName_wareCount", cartItemInfo.getName());
		//						return "fail";
		//					}
		//				}
		//				saveList.add(cartItemInfo);
		//			}
		//		}
		//		long addressId = -1;
		//		if (addressId <= 0) {
		//			listOrder = orderService.saveOrderInfo(saveList, specialExplain, drawerName, area,
		//				null, detailAddress, zipCode, drawerNumber, mobileNumber, postFree, totalFree,
		//				takeWays, takeGoodsAddr);
		//
		//		} else {
		//			DrawerAddressInfo address = orderService.findDrawerAddressById(addressId);
		//			listOrder = orderService.saveOrderInfo(newListInfo, specialExplain,
		//				address.getDrawerName(), address.getCity(), address.getAreaCode(),
		//				address.getDetailAddress(), address.getZipCode(), address.getDrawerNumber(),
		//				address.getMobileNumber(), postFree, totalFree, takeWays, takeGoodsAddr);
		//		}
		//		//订单创建成功之后要对之前session中的数据进行清除
		//		//productIds是选择的商品的ID
		//
		//		List<Long> listKey = new ArrayList<Long>();
		//		for (Iterator it = list.keySet().iterator(); it.hasNext();) {
		//			Long key = (Long) it.next(); //供应商ID
		//			listKey.add(key);
		//		}
		//		for (int i = 0; i < listKey.size(); i++) {
		//			try {
		//				for (Long pro_id : productIds) {
		//					this.loadCart().setQuantity(listKey.get(i), pro_id, 0);
		//				}
		//			} catch (Exception e) {
		//				throw new ActionException(e);
		//			}
		//		}
		
		return "";
	}
	
	@RequestMapping("platform/mall/paymentNotifyResult.htm")
	public String paymentNotifyResult(HttpServletRequest request, HttpServletResponse response,
										Model model) throws Exception {
		Map<String, String> param = WebUtil.getRequestMap(request);
		EsupplierBaseResult esupplierBaseResult = payService.paymentProcess(param);
		if (esupplierBaseResult.isSuccess()) {
			if (esupplierBaseResult.getCreditsysResultEnum() == EsupplierResultEnum.EXECUTE_SUCCESS) {
				model.addAttribute("message", "支付成功");
				return path + "paymentOk.vm";
			} else {
				String tradeStatus = param.get("tradeStatus");
				if ("wait_buyer_pay".equals(tradeStatus)) {
					model.addAttribute("message", "支付未完成，等待支付");
				} else if ("trade_closed".equals(tradeStatus)) {
					model.addAttribute("message", "交易已经关闭");
				} else {
					model.addAttribute("message", esupplierBaseResult.getMessage());
				}
				return path + "paymentOk.vm";
			}
			
		} else {
			model.addAttribute("message", esupplierBaseResult.getMessage());
			return path + "paymentOk.vm";
		}
		
	}
	
	/**
	 * 查看码卷
	 * 
	 * @return
	 * @author lihu
	 */
	@RequestMapping("findQrCodeById.htm")
	public String findQrCodeById(HttpServletRequest request, HttpServletResponse response,
									Model model, Long orderId) {
		OrderQRCodeOrder processOrder = new OrderQRCodeOrder();
		processOrder.setBizNo(orderId);
		processOrder.setBizTypeEnum(UserBizTypeEnum.BUYER);
		processOrder.setBelongTo(ShiroSessionUtils.getSessionLocal().getBelongTo());
		processOrder.setProcessorId(ShiroSessionUtils.getSessionLocal().getUserId());
		EsupplierBaseResult result = orderService.makeQRcodeUrl(processOrder);
		OrderInfo orderInfo = orderService.findOrderById(orderId);
		if (result.isSuccess()) {
			model.addAttribute("qrCodeUrl", result.getUrl());
		}
		if (orderInfo != null) {
			model.addAttribute("qrCode", orderInfo.getQrCode());
		}
		return path + "buyDetailQrCodeInfo.vm";
	}
	
	/**
	 * 根据批次号获取同一批次的未付款的订单
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("getOrderIdsByBatchNo.htm")
	public Object getOrderIdsByBatchNo(HttpServletRequest request, HttpServletResponse response,
										Model model) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String batchNo = request.getParameter("ip");
		String orderStatus = request.getParameter("orderStatus");
		int pages = NumberUtil.parseInt(request.getParameter("page"), 1);
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"), 9999999);
		QueryOrderInfoSearchOrder orderInfoSearchOrder = new QueryOrderInfoSearchOrder();
		orderInfoSearchOrder.setBatchNo(batchNo);
		orderInfoSearchOrder.setOrderStatus(OrderStatusEnum.getByCode(orderStatus));
		orderInfoSearchOrder.setPageNumber(pages);
		orderInfoSearchOrder.setPageSize(pagesize);
		
		QueryBaseBatchResult<OrderInfo> baseBatchResult = orderQueryService
			.findOrderList(orderInfoSearchOrder);
		if (baseBatchResult.isSuccess()) {
			StringBuilder sb = new StringBuilder();
			int m = 0;
			for (OrderInfo orderInfo : baseBatchResult.getPageList()) {
				sb.append(orderInfo.getId());
				m++;
				if (m < baseBatchResult.getPageList().size()) {
					sb.append(",");
				}
			}
			jsonObject.put("orderIds", sb);
		}
		return jsonObject;
		
	}
	
	public static String gainBatchNoByCreateTime(Date createTime) {
		StringBuffer number = new StringBuffer();
		//String outBizNo = "0987";//AppConstantsUtil.getOutBizNumber();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HHmmssSSS");
		Date nowDate = createTime;
		number.append(simpleDateFormat.format(nowDate)).append(simpleTimeFormat.format(nowDate));
		int a = (int) (Math.random() * 1000);
		String aString = String.valueOf(a);
		while (aString.length() < 3) {
			aString = "0" + aString;
		}
		number.append(aString);
		return number.toString();
	}
}
