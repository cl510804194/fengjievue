package com.yjf.esupplier.web.controller.front.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yjf.esupplier.domain.service.repository.ProductDomainRepository;
import com.yjf.esupplier.integration.industrial.api.LogisticsInfoQueryService;
import com.yjf.esupplier.service.app.equipmentLogin.EquipmentLoginService;
import com.yjf.esupplier.service.base.data.BankDataService;
import com.yjf.esupplier.service.base.data.OpeningDistrictService;
import com.yjf.esupplier.service.bill.OrderIbatisService;
import com.yjf.esupplier.service.bill.OrderQueryService;
import com.yjf.esupplier.service.bill.OrderService;
import com.yjf.esupplier.service.common.services.RealNameAuthenticationService;
import com.yjf.esupplier.service.common.services.SiteMessageService;
import com.yjf.esupplier.service.common.services.SmsEmailManagerService;
import com.yjf.esupplier.service.common.services.SmsManagerService;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTradeQueryService;
import com.yjf.esupplier.service.hotel.HotelsDiscountService;
import com.yjf.esupplier.service.hotel.HotelsSetLongRoomSerivce;
import com.yjf.esupplier.service.hotel.HotelsSetRefundService;
import com.yjf.esupplier.service.hotel.HotelsStockService;
import com.yjf.esupplier.service.login.LoginService;
import com.yjf.esupplier.service.pay.AppPayService;
import com.yjf.esupplier.service.pay.PayService;
import com.yjf.esupplier.service.pay.PaymentFlowService;
import com.yjf.esupplier.service.pop.IPopModuleService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.service.pop.PopUserService;
import com.yjf.esupplier.service.product.DeliveryService;
import com.yjf.esupplier.service.product.ProductService;
import com.yjf.esupplier.service.product.ProductUserService;
import com.yjf.esupplier.service.product.StorageService;
import com.yjf.esupplier.service.tocard.ToCardFlowService;
import com.yjf.esupplier.service.user.DeliveryPersonService;
import com.yjf.esupplier.service.user.FeebackOptionService;
import com.yjf.esupplier.service.user.RegisterService;
import com.yjf.esupplier.service.user.UserAccountDataQueryService;
import com.yjf.esupplier.service.user.UserBaseInfoManager;
import com.yjf.esupplier.service.user.UserWeixinService;
import com.yjf.esupplier.service.user.query.ScenicService;
import com.yjf.esupplier.service.user.query.UserLevelQueryService;
import com.yjf.esupplier.service.user.query.UserQueryService;
import com.yjf.esupplier.web.controller.front.platform.ShoppingCartBaseController;
import com.yjf.esupplier.ws.messageWall.services.MessageWallService;
import com.yjf.esupplier.ws.service.UserBankService;

public class BaseAutowiredFunction extends ShoppingCartBaseController {
	protected static List<String>			fileTypeList	= new ArrayList<String>();
	
	static {
		fileTypeList.add(".jpg");
		fileTypeList.add(".jpeg");
		fileTypeList.add(".bmp");
		fileTypeList.add(".png");
	};
	@Autowired
	protected ScenicService					scenicService;
	@Autowired
	protected EquipmentLoginService			equipmentLoginService;
	@Autowired
	protected OrderService					orderService;
	@Autowired
	protected OrderQueryService				orderQueryService;
	@Autowired
	protected ProductUserService			productUserService;
	@Autowired
	protected ProductService				productService;
	@Autowired
	protected DeliveryService				deliveryService;
	@Autowired
	protected StorageService				storageService;
	@Autowired
	protected UserBaseInfoManager			userBaseInfoManager;
	@Autowired
	protected SmsManagerService				smsManagerService;
	@Autowired
	protected RegisterService				registerService;
	@Autowired
	protected LoginService					loginService;
	@Autowired
	protected RealNameAuthenticationService	realNameAuthenticationService;
	@Autowired
	protected OpeningDistrictService		openingDistrictService;
	@Autowired
	protected IPopService					popService;
	@Autowired
	protected PayService					payService;
	
	@Autowired
	protected PaymentFlowService			paymentFlowService;
	@Autowired
	protected IPopModuleService				popModuleService;
	@Autowired
	protected FeebackOptionService			feebackOptionService;
	@Autowired
	protected UserQueryService				userQueryService;
	@Autowired
	protected AppPayService					appPayService;
	@Autowired
	protected GiftMoneyTradeQueryService	giftMoneyTradeQueryService;
	@Autowired
	protected UserAccountDataQueryService	userAccountDataQueryService;
	
	@Autowired
	protected LogisticsInfoQueryService		logisticsInfoQueryService;
	@Autowired
	SiteMessageService						siteMessageService;
	@Autowired
	protected OrderIbatisService			orderIbatisService;
	@Autowired
	protected PopUserService				popUserService;
	@Autowired
	UserLevelQueryService					userLevelQueryService;
	@Autowired
	protected HotelsStockService			hotelsStockService;
	
	@Autowired
	protected HotelsSetLongRoomSerivce		hotelsSetLongRoomSerivce;
	
	@Autowired
	protected HotelsSetRefundService		hotelsSetRefundService;
	
	@Autowired
	protected HotelsDiscountService			hotelsDiscountService;
	@Autowired
	protected SmsEmailManagerService		smsEmailManagerService;
	@Autowired
	protected BankDataService				bankDataService;
	@Autowired
	protected UserBankService				userBankService;
	@Autowired
	protected ToCardFlowService				toCardFlowService;
	
	@Autowired
	protected UserWeixinService				userWeixinService;
	@Autowired
	protected ProductDomainRepository  productDomainRepository;
	@Autowired
	protected DeliveryPersonService deliveryPersonService;
	
	@Autowired
	protected MessageWallService messageWallService;

}
