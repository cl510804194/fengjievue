package com.yjf.esupplier.integration.web.server.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.security.DigestUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.web.server.YjfLoginWebServer;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.yrd.integration.bornapi.order.YjfActiveOrder;

@Service("yjfLoginWebServer")
public class YjfLoginWebServerImpl extends OpenApiServiceBase implements YjfLoginWebServer {
	
	final String YZZ_MODIFY_PASSWORD = "yzzModifyPassword";
	
	final String COMMON_REDIRECT_USER_ACTIVE = "commonRedirectUserActive";
	final String YZZ_FORGET_PASSWORD = "yzzAppForgetPassword";
	
	@Override
	public CustomerResult loginYjfInfo(String accessToken) {
		CustomerResult result = new CustomerResult();
		try {
			
			String url = AppConstantsUtil.getYjfUrl() + "/oauth/resources;" + accessToken;
			Map<String, Object> dataMap = senderPostOnlyParam(url);
			String userId = (String) dataMap.get("userId");
			String loginId = (String) dataMap.get("loginId");
			if (StringUtil.isNotBlank(userId)) {
				result.setUserId(userId);
				result.setLoginId(StringUtil.trim(loginId));
				result.setSuccess(true);
			}
			return result;
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yjf.esupplier.integration.web.server.YjfLoginWebServer#gotoYjfModifyPayPwdUrl
	 * (com.yjf.esupplier.integration.web.server.impl.YjfPayPwdOrder,
	 * com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public EsupplierBaseResult gotoYjfModifyPayPwdUrl(YjfPayPwdOrder payPwdOrder,
														OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		
		try {
			payPwdOrder.check();
			
			paramMap.put("service", YZZ_MODIFY_PASSWORD);
			paramMap.put("partnerId", openApiContext.getPartnerId());
			paramMap.put("orderNo", openApiContext.getOpenApiBizNo());
			paramMap.put("signType", openApiContext.getSignType().toString());
			
			paramMap.put("userId", payPwdOrder.getUserId());
			paramMap.put("passwordType", payPwdOrder.getPasswordType());
			paramMap.put("sources", payPwdOrder.getSources());
			if (StringUtil.isNotEmpty(payPwdOrder.getBtnColor())) {
				paramMap.put("btnColor", payPwdOrder.getBtnColor());
			}
			paramMap.put("returnUrl",
				StringUtil.isNotEmpty(payPwdOrder.getReturnUrl()) ? payPwdOrder.getReturnUrl()
					: AppConstantsUtil.getHostHttpUrl() + "/do/mainHome.htm");
			paramMap.put(
				"errorNotifyUrl",
				StringUtil.isNotEmpty(payPwdOrder.getErrorNotifyUrl()) ? payPwdOrder
					.getErrorNotifyUrl() : AppConstantsUtil.getHostHttpUrl());
			
			String sign = DigestUtil.digest(paramMap, openApiContext.getSecurityCheckKey(),
				openApiContext.getSignType());
			paramMap.put(DigestUtil.SIGN_KEY, sign);
			String url = makeResposeUrlNotOpenApi(paramMap, "");
			result.setUrl(url);
			result.setSuccess(true);
			return result;
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult gotoYjfCheckPayTk(YjfEzmoneyCheckPaytkOrder ezmoneyPayPassUrlOrder,
													OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		
		try {
			ezmoneyPayPassUrlOrder.check();
			paramMap.put("paytk", ezmoneyPayPassUrlOrder.getPaytk());
			paramMap.put("userId", ezmoneyPayPassUrlOrder.getUserId());
			paramMap.put("partnerId", openApiContext.getPartnerId());
			paramMap.put(DigestUtil.SIGN_TYPE_KEY, "MD5");
			String sign = DigestUtil.digest(paramMap, openApiContext.getSecurityCheckKey(),
				openApiContext.getSignType());
			
			paramMap.put(DigestUtil.SIGN_KEY, sign);
			String ezmoneyHttpUrl = AppConstantsUtil.getEzmoneyHttpUrl();
			String url = makeResposeUrlNotOpenApi(paramMap, ezmoneyHttpUrl
															+ "/userptk/checkPaytk.htm");
			Map<String, Object> returnDataMap = null;
			if (StringUtil.isNotEmpty(ezmoneyHttpUrl)
				&& AppConstantsUtil.getEzmoneyHttpUrl().indexOf("https") > -1)
				returnDataMap = senderPostHttpsOnlyParam(url);
			else
				returnDataMap = senderPostOnlyParam(url);
			result.setUrl(url);
			result.setSuccess((boolean) returnDataMap.get("isSuccess"));
			return result;
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult gotoYjfValidatePayPasswordUrl(	YjfEzmoneyPayPassUrlOrder ezmoneyPayPassUrlOrder,
																OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			ezmoneyPayPassUrlOrder.check();
			
			paramMap.put("userId", ezmoneyPayPassUrlOrder.getUserId());
			paramMap.put("origCount", String.valueOf(ezmoneyPayPassUrlOrder.getOrigCount()));
			paramMap.put("partnerId", openApiContext.getPartnerId());
			paramMap.put("isPhone", ezmoneyPayPassUrlOrder.getIsPhone());
			if (StringUtil.isNotEmpty(ezmoneyPayPassUrlOrder.getBtnColor())) {
				paramMap.put("btnColor", ezmoneyPayPassUrlOrder.getBtnColor());
			}
			
			if (StringUtil.isNotEmpty(ezmoneyPayPassUrlOrder.getPlatformName())) {
				paramMap.put("platformName", ezmoneyPayPassUrlOrder.getPlatformName());
			}
			
			paramMap.put("returnUrl", AppConstantsUtil.getHostHttpUrl()
										+ "/anon/yjfPayPassewordReturnUrl.htm");
			
			paramMap.put("cancelUrl", AppConstantsUtil.getHostHttpUrl()
										+ "/anon/yjfPayPassewordCancelUrl.htm");
			
			String sign = DigestUtil.digest(paramMap, openApiContext.getSecurityCheckKey(),
				openApiContext.getSignType());
			paramMap.put(DigestUtil.SIGN_KEY, sign);
			String url = makeResposeUrlNotOpenApi(paramMap, AppConstantsUtil.getEzmoneyHttpUrl()
															+ "/userptk/main.htm");
			result.setUrl(url);
			result.setSuccess(true);
			return result;
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult commonRedirectUserActive(YjfActiveOrder yjfActiveOrder,
														OpenApiContext openApiContext) {
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			yjfActiveOrder.check();
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("service", COMMON_REDIRECT_USER_ACTIVE);
			paramMap.put("partnerId", openApiContext.getPartnerId());
			paramMap.put("orderNo", openApiContext.getOpenApiBizNo());
			paramMap.put("signType", openApiContext.getSignType().toString());
			
			paramMap.put("userName", yjfActiveOrder.getUserName());
			
			paramMap.put("title", yjfActiveOrder.getTitle());
			paramMap.put("certify", yjfActiveOrder.getCertify());
			paramMap.put("termnalType", yjfActiveOrder.getTermnalType());
			paramMap.put("isSetPassword", yjfActiveOrder.getIsSetPassword());
			paramMap.put("isPhoneValidate", yjfActiveOrder.getIsPhoneValidate());
			if (StringUtil.isNotEmpty(yjfActiveOrder.getTermnalType())
				&& "PC".equals(yjfActiveOrder.getTermnalType())) {
				paramMap.put("returnUrl", AppConstantsUtil.getHostHttpUrl()
											+ "/userManage/userHome");
				paramMap.put("errorNotifyUrl", AppConstantsUtil.getHostHttpUrl());
			} else {
				paramMap.put(
					"returnUrl",
					StringUtil.defaultIfBlank(yjfActiveOrder.getNotifyUrl(),
						AppConstantsUtil.getHostHttpUrl() + "/app/yjfActivitySuccess.htm"));
				paramMap.put(
					"errorNotifyUrl",
					StringUtil.defaultIfBlank(yjfActiveOrder.getErrorNotifyUrl(),
						AppConstantsUtil.getHostHttpUrl() + "/app/yjfActivitySuccess.htm"));
			}
			String sign = DigestUtil.digest(paramMap, openApiContext.getSecurityCheckKey(),
				openApiContext.getSignType());
			paramMap.put(DigestUtil.SIGN_KEY, sign);
			String url = makeResposeUrlNotOpenApi(paramMap, "");
			result.setUrl(url);
			result.setSuccess(true);
			return result;
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult gotoYjfForgetPayPwdUrl(YjfPayPwdOrder payPwdOrder,
														OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		
		try {
			payPwdOrder.check();
			
			paramMap.put("service", YZZ_FORGET_PASSWORD);
			paramMap.put("partnerId", openApiContext.getPartnerId());
			paramMap.put("orderNo", openApiContext.getOpenApiBizNo());
			paramMap.put("signType", openApiContext.getSignType().toString());
			
			paramMap.put("userId", payPwdOrder.getUserId());
			paramMap.put("passwordType", payPwdOrder.getPasswordType());
			paramMap.put("sources", payPwdOrder.getSources());
			if (StringUtil.isNotEmpty(payPwdOrder.getBtnColor())) {
				paramMap.put("btnColor", payPwdOrder.getBtnColor());
			}
			
			paramMap.put("returnUrl",
				StringUtil.isNotEmpty(payPwdOrder.getReturnUrl()) ? payPwdOrder.getReturnUrl()
					: AppConstantsUtil.getHostHttpUrl() + "/userManage/accountSetting");
			paramMap.put(
				"errorNotifyUrl",
				StringUtil.isNotEmpty(payPwdOrder.getErrorNotifyUrl()) ? payPwdOrder
					.getErrorNotifyUrl() : AppConstantsUtil.getHostHttpUrl());
			
			String sign = DigestUtil.digest(paramMap, openApiContext.getSecurityCheckKey(),
				openApiContext.getSignType());
			paramMap.put(DigestUtil.SIGN_KEY, sign);
			String url = makeResposeUrlNotOpenApi(paramMap, "");
			result.setUrl(url);
			result.setSuccess(true);
			return result;
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
}
