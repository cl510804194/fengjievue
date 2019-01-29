package com.yjf.esupplier.web.controller.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.domain.service.repository.ProductDomainRepository;
import com.yjf.esupplier.service.supplier.SupplierRecommendService;
import com.yjf.esupplier.service.supplier.SupplierService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.ApplicationConstant;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.integration.openapi.CustomerService;
import com.yjf.esupplier.integration.openapi.DeductDepositService;
import com.yjf.esupplier.integration.openapi.DepositQueryService;
import com.yjf.esupplier.integration.openapi.FundsTransferService;
import com.yjf.esupplier.integration.openapi.SMSService;
import com.yjf.esupplier.integration.openapi.WithdrawQueryService;
import com.yjf.esupplier.integration.openapi.WithdrawService;
import com.yjf.esupplier.integration.openapi.YjfTradeQueryService;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.service.base.data.BankDataService;
import com.yjf.esupplier.service.certificate.FileCertificateService;
import com.yjf.esupplier.service.common.services.BankBaseInfoService;
import com.yjf.esupplier.service.common.services.RealNameAuthenticationService;
import com.yjf.esupplier.service.common.services.SmsManagerService;
import com.yjf.esupplier.service.common.services.SysFunctionConfigService;
import com.yjf.esupplier.service.common.services.SysParameterService;
import com.yjf.esupplier.service.common.services.SystemMessageService;
import com.yjf.esupplier.service.common.services.YrdMessageService;
import com.yjf.esupplier.service.hotel.HotelsDiscountService;
import com.yjf.esupplier.service.hotel.HotelsSetRefundService;
import com.yjf.esupplier.service.login.LoginService;
import com.yjf.esupplier.service.mail.IMailSendService;
import com.yjf.esupplier.service.pdf.template.PdfTemplateService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.service.product.ProductPropertyService;
import com.yjf.esupplier.service.product.ProductRecommendService;
import com.yjf.esupplier.service.recharge.RechargeFlowService;
import com.yjf.esupplier.service.security.AuthorityService;
import com.yjf.esupplier.service.trade.DeductYrdService;
import com.yjf.esupplier.service.user.FeebackOptionService;
import com.yjf.esupplier.service.user.RegisterService;
import com.yjf.esupplier.service.user.UserBaseInfoManager;
import com.yjf.esupplier.service.user.query.ScenicService;
import com.yjf.esupplier.service.user.query.UserAccountQueryService;
import com.yjf.esupplier.service.user.query.UserQueryService;
import com.yjf.esupplier.service.user.query.UserRelationQueryService;

public class BaseAutowiredController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** ZJL */
	
	@Autowired
	protected UserBaseInfoManager userBaseInfoManager;

	@Autowired
	protected SupplierRecommendService supplierRecommendService;
	@Autowired
	protected IMailSendService mailService;
	
	@Autowired
	protected BankBaseInfoService bankBaseInfoService;
	/** YHL */
	@Autowired
	protected AuthorityService authorityService;
	
	@Autowired
	protected LoginService loginService;
	
	@Autowired
	protected RegisterService registerService;
	
	/** PPMService */
	
	@Autowired
	protected YrdMessageService yrdMessageService;
	
	@Autowired
	protected RechargeFlowService rechargeFlowService;
	
	@Autowired
	protected DeductYrdService deductYrdService;
	
	@Autowired
	protected SysParameterService sysParameterService;
	@Autowired
	protected CustomerService customerService;
	
	@Autowired
	protected UserAccountQueryService userAccountQueryService;
	
	@Autowired
	protected RealNameAuthenticationService realNameAuthenticationService;
	@Autowired
	protected FundsTransferService fundsTransferService;
	@Autowired
	protected BankDataService bankDataService;
	@Autowired
	protected WithdrawQueryService withdrawQueryService;
	
	@Autowired
	protected WithdrawService withdrawService;
	
	@Autowired
	protected DepositQueryService depositQueryService;
	
	@Autowired
	protected SmsManagerService smsManagerService;
	
	@Autowired
	protected SMSService sMSService;
	
	@Autowired
	protected DeductDepositService deductDepositService;
	@Autowired
	protected YjfTradeQueryService yjfTradeQueryService;
	
	@Autowired
	protected FileCertificateService fileCertificateService;
	
	@Autowired
	protected SysFunctionConfigService sysFunctionConfigService;
	
	@Autowired
	protected UserQueryService userQueryService;
	
	@Autowired
	protected PdfTemplateService pdfTemplateService;
	
	@Autowired
	protected SystemMessageService systemMessageService;
	
	@Autowired
	protected UserRelationQueryService userRelationQueryService;
	
	@Autowired
	protected ProductRecommendService productRecommendService;
	
	@Autowired
	protected ProductPropertyService productPropertyService;
	@Autowired
	protected ProductDomainRepository productDomainRepository;
	@Autowired
	protected SupplierService supplierService;
	@Autowired
	protected ScenicService scenicService;
	@Autowired
	protected FeebackOptionService feebackOptionService;
	@Autowired
	protected HotelsDiscountService hotelsDiscountService;
	@Autowired
	protected IPopService popService;
	@Autowired
	protected HotelsSetRefundService hotelsSetRefundService;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		String[] nameArray = getDateInputNameArray();
		if (nameArray != null && nameArray.length > 0) {
			for (int i = 0; i < nameArray.length; i++) {
				binder.registerCustomEditor(Date.class, nameArray[i], new CustomDateEditor(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
				
			}
		}
		String[] dateDayNameArray = getDateInputDayNameArray();
		if (dateDayNameArray != null && dateDayNameArray.length > 0) {
			for (int i = 0; i < dateDayNameArray.length; i++) {
				binder.registerCustomEditor(Date.class, dateDayNameArray[i], new CustomDateEditor(
					new SimpleDateFormat("yyyy-MM-dd"), true));
				
			}
		}
		String[] moneyNameArray = getMoneyInputNameArray();
		if (dateDayNameArray != null && moneyNameArray.length > 0) {
			for (int i = 0; i < moneyNameArray.length; i++) {
				binder.registerCustomEditor(Money.class, moneyNameArray[i],
					new CommonBindingInitializer());
			}
		}
	}
	
	protected String[] getDateInputNameArray() {
		return new String[0];
	}
	
	protected String[] getDateInputDayNameArray() {
		return new String[0];
	}
	
	protected String[] getMoneyInputNameArray() {
		return new String[0];
	}
	
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
	
	protected void printHttpResponse(HttpServletResponse response, JSONObject json) {
		try {
			
			response.setContentType("json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(json.toJSONString());
		} catch (IOException e) {
			logger.error("response. getWriter print error ", e);
		}
	}
	
	protected void printHttpResponse(HttpServletResponse response,
										com.alibaba.fastjson.JSONObject json) {
		try {
			
			response.setContentType("json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(json.toJSONString());
		} catch (IOException e) {
			logger.error("response. getWriter print error ", e);
		}
	}
	
	protected String sendUrl(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	protected void initMainPage(HttpServletRequest request, Model model) {
		//		int twoPathIndex = request.getRequestURI().indexOf("/", 1);
		//		int twoPathEndIndex = request.getRequestURI().indexOf("/", twoPathIndex + 1);
		//		String module = request.getRequestURI().substring(twoPathIndex + 1, twoPathEndIndex);
		//		model.addAttribute("module", module);
		//		model.addAttribute("contentUrl", request.getParameter("contentUrl"));
	}
}
