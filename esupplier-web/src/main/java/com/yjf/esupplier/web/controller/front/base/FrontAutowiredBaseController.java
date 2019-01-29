package com.yjf.esupplier.web.controller.front.base;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.ApplicationConstant;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.domain.service.repository.OrderDomainRepository;
import com.yjf.esupplier.integration.openapi.CustomerService;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.service.base.data.BaseDataLoader;
import com.yjf.esupplier.service.bill.OrderQueryService;
import com.yjf.esupplier.service.bill.OrderRefundService;
import com.yjf.esupplier.service.bill.OrderService;
import com.yjf.esupplier.service.common.services.DateSeqService;
import com.yjf.esupplier.service.common.services.SysParameterService;
import com.yjf.esupplier.service.hotel.HotelsDiscountService;
import com.yjf.esupplier.service.hotel.HotelsSetRefundService;
import com.yjf.esupplier.service.hotel.HotelsStockService;
import com.yjf.esupplier.service.orderfood.OrderfoodService;
import com.yjf.esupplier.service.product.DeliveryService;
import com.yjf.esupplier.service.product.FacadeService;
import com.yjf.esupplier.service.product.ProductCustomPropertyService;
import com.yjf.esupplier.service.product.ProductPropertyService;
import com.yjf.esupplier.service.product.ProductRecommendService;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.service.product.ProductTypeService;
import com.yjf.esupplier.service.product.ProductUserService;
import com.yjf.esupplier.service.product.ShopCartService;
import com.yjf.esupplier.service.product.StorageService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.ship.DeliveryShipService;
import com.yjf.esupplier.service.supplier.SupplierService;
import com.yjf.esupplier.service.supplier.SupplierSettingService;
import com.yjf.esupplier.service.user.DeliveryPersonService;
import com.yjf.esupplier.service.user.query.ScenicService;
import com.yjf.esupplier.service.user.query.UserAccountQueryService;
import com.yjf.esupplier.service.user.query.UserQueryService;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.product.enums.ShopingCartResultEnum;
import com.yjf.esupplier.ws.product.enums.ShopingCartTypeEnum;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.product.order.RemoveShopCartOrder;
import com.yjf.esupplier.ws.product.order.ShopCartItemOrder;
import com.yjf.esupplier.ws.product.result.ShopingCartResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.review.services.TradeReviewService;
import com.yjf.esupplier.ws.service.CommonAttachmentService;

public class FrontAutowiredBaseController {
	protected final Logger					logger	= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected OrderService					orderService;
	@Autowired
	protected SupplierService				supplierService;
	@Autowired
	protected ProductService				productService;
	@Autowired
	protected DeliveryService				deliveryService;
	@Autowired
	protected DeliveryPersonService			deliveryPersonService;
	@Autowired
	protected UserQueryService				userQueryService;
	@Autowired
	protected ProductCustomPropertyService	productCustomPropertyService;
	@Autowired
	protected FacadeService					facadeService;
	@Autowired
	protected ProductUserService			productUserService;
	
	@Autowired
	protected ProductTypeService			productTypeService;
	
	@Autowired
	protected ProductPropertyService		productPropertyService;
	
	@Autowired
	protected StorageService				storageService;
	
	@Autowired
	protected DateSeqService				dateSeqService;
	
	@Autowired
	protected TradeReviewService			tradeReviewService;
	
	@Autowired
	protected BaseDataLoader				baseDataLoader;
	
	@Autowired
	protected OrderRefundService			orderRefundService;
	
	@Autowired
	protected DeliveryShipService			deliveryShipService;
	@Autowired
	protected CommonAttachmentService		commonAttachmentService;
	
	@Autowired
	protected CustomerService				customerService;
	
	@Autowired
	protected SysParameterService			sysParameterService;
	
	@Autowired
	protected UserAccountQueryService		userAccountQueryService;
	
	@Autowired
	protected ProductRecommendService		productRecommendService;
	
	@Autowired
	protected ShopCartService				shopCartService;
	
	@Autowired
	protected ScenicService					scenicService;
	
	@Autowired
	protected SupplierSettingService		supplierSettingService;
	
	@Autowired
	protected OrderfoodService				orderfoodService;
	
	@Autowired
	protected OrderQueryService				orderQueryService;
	
	@Autowired
	protected HotelsStockService			hotelsStockService;
	
	@Autowired
	protected HotelsSetRefundService		hotelsSetRefundService;
	
	@Autowired
	protected HotelsDiscountService			hotelsDiscountService;
	
	@Autowired
	protected OrderDomainRepository			orderDomainRepository;
	
	protected OpenApiContext getOpenApiContext() {
		OpenApiContext openApiContext = new OpenApiContext();
		openApiContext.setPartnerId(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_YJF_BUSINESS_USER_ID));
		openApiContext.setSecurityCheckKey(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_SECURITY_CHECK_KEY));
		openApiContext.setOpenApiUrl(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_OPEN_API_URL_KEY));
		
		openApiContext.setNotifyUrl(sysParameterService
			.getSysParameterValue(ApplicationConstant.SYS_PARAM_RETURN_URL_KEY));
		openApiContext.setOpenApiBizNo(BusinessNumberUtil.gainOutBizNoNumber());
		return openApiContext;
	}

	
	protected void printHttpResponse(HttpServletResponse response, JSONAware json) {
		try {
			
			response.setContentType("json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(json.toJSONString());
		} catch (IOException e) {
			logger.error("response. getWriter print error ", e);
		}
	}
	
	protected void printHttpResponse(HttpServletResponse response, String printStr) {
		try {
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(printStr);
		} catch (IOException e) {
			logger.error("response. getWriter print error ", e);
		}
	}
	
	protected void sendUrl(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	protected static String getWebRootPath(HttpServletRequest request) {
		WebApplicationContext wac = (WebApplicationContext) request
			.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		ServletContext context = wac.getServletContext();
		return context.getRealPath("");
	}
	
	protected static String getNoAccessView() {
		return "front/platform/member/product/" + "input.vm";
	}
	
	protected void setProcessOrder(ProcessOrder billOrder) {
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		billOrder.setProcessorId(sessionLocal.getUserId());
		billOrder.setProcessName(sessionLocal.getUserName());
		billOrder.setBelongTo(sessionLocal.getBelongTo());
	}
	
	protected EsupplierBaseResult persistenceShopCart(ProductInfo productInfo,
														ShopingCartResult cartResult,
														ShopingCartTypeEnum shopingCartType) {
		EsupplierBaseResult result = new EsupplierBaseResult();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null && sessionLocal.getUserId() != null
			&& sessionLocal.getUserId() > 0) {
			if (cartResult.isSuccess()) {
				if (cartResult.getShopingCartResultEnum() == ShopingCartResultEnum.UPDTAE) {
					ShopCartItemOrder cartItemOrder = new ShopCartItemOrder();
					cartItemOrder.setPicPath(productInfo.getSmallPicPath());
					cartItemOrder.setProductId(productInfo.getProductId());
					cartItemOrder.setProductName(productInfo.getProductName());
					cartItemOrder.setQuantity(cartResult.getCartItemInfo().getQuantity());
					cartItemOrder.setPrice(cartResult.getCartItemInfo().getPrice());
					cartItemOrder.setTotalPrice(cartItemOrder.getPrice().multiply(
						cartItemOrder.getQuantity()));
					cartItemOrder.setProductUnit(productInfo.getProductUnit());
					cartItemOrder.setUserId(sessionLocal.getUserId());
					cartItemOrder.setSupplierId(productInfo.getSupplierId());
					cartItemOrder.setSupplierName(productInfo.getSupplierName());
					cartItemOrder.setUserName(sessionLocal.getUserName());
					cartItemOrder.setUserNikename(sessionLocal.getNickname());
					cartItemOrder.setSaleType(shopingCartType.code());
					result = shopCartService.updateShopCartItem(cartItemOrder);
				} else if (cartResult.getShopingCartResultEnum() == ShopingCartResultEnum.DELETE) {
					RemoveShopCartOrder removeShopCartOrder = new RemoveShopCartOrder();
					removeShopCartOrder.setUserId(sessionLocal.getUserId());
					removeShopCartOrder.setProductId(productInfo.getProductId());
					removeShopCartOrder.setSaleType(shopingCartType);
					result = shopCartService.removeShopCartItem(removeShopCartOrder);
				} else if (cartResult.getShopingCartResultEnum() == ShopingCartResultEnum.ADD) {
					ShopCartItemOrder cartItemOrder = new ShopCartItemOrder();
					cartItemOrder.setPicPath(productInfo.getSmallPicPath());
					cartItemOrder.setProductId(productInfo.getProductId());
					cartItemOrder.setProductName(productInfo.getProductName());
					cartItemOrder.setQuantity(cartResult.getCartItemInfo().getQuantity());
					cartItemOrder.setPrice(cartResult.getCartItemInfo().getPrice());
					cartItemOrder.setTotalPrice(cartItemOrder.getPrice().multiply(
						cartItemOrder.getQuantity()));
					cartItemOrder.setSupplierId(productInfo.getSupplierId());
					cartItemOrder.setSupplierName(productInfo.getSupplierName());
					cartItemOrder.setUserId(sessionLocal.getUserId());
					cartItemOrder.setUserName(sessionLocal.getUserName());
					cartItemOrder.setUserNikename(sessionLocal.getNickname());
					cartItemOrder.setProductUnit(productInfo.getProductUnit());
					cartItemOrder.setSaleType(shopingCartType.code());
					result = shopCartService.addShopCartItem(cartItemOrder);
				}
			}
		}
		return result;
	}
}
