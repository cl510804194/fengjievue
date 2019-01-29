/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.integration.openapi.CustomerService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.enums.CertifyLevelEnum;
import com.yjf.esupplier.integration.openapi.enums.RealNameBusinessStatusEnum;
import com.yjf.esupplier.integration.openapi.enums.UserStatusEnum;
import com.yjf.esupplier.integration.openapi.enums.YjfUserTypeEnum;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.integration.openapi.order.BusinessCertOrder;
import com.yjf.esupplier.integration.openapi.order.MobileBindOrder;
import com.yjf.esupplier.integration.openapi.order.PersonalCertOrder;
import com.yjf.esupplier.integration.openapi.order.RegisterOrder;
import com.yjf.esupplier.integration.openapi.order.UserQuickCertifyOrder;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.integration.openapi.result.RealNameLevelResult;
import com.yjf.esupplier.integration.openapi.result.RealNameStatusResult;
import com.yjf.esupplier.integration.util.YjfDataUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename CustomerServiceImpl.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Service("customerService")
public class CustomerServiceImpl extends OpenApiServiceBase implements CustomerService {
	
	//public static final String USER_REGISTER_SERVICE = "ppmNewRuleRegisterUser";
	public static final String USER_REGISTER_SERVICE = "qftRegister";
	public static final String USER_COMMON_REGISTER_SERVICE = "userCommonRegister";
	
	public static final String MODIFY_USER_INFO_SERVICE = "modifyUserInfo";
	public static final String CHECK_USERNAME_EXIST = "checkUserNameExist";
	public static final String USER_ACCOUNT_QUERY = "userBalanceQuery";
	
	public static final String USER_INFO_QUERY = "userInfoQuery";
	public static final String REAL_NAME_CERT = "realNameCertifyPersonal";
	public static final String ENTERPRISE_REAL_NAME_CERT = "realNameCertifyCorporate";
	public static final String REAL_NAME_CERT_QUERY = "realNameCert.query";
	
	public static final String UPDATE_MOBILE_BINDING_CUSTOMER = "updateMobileBindingCustomer";
	public static final String APPLY_MOBILE_BINDING_CUSTOMER = "applyMobileBindingCustomer";
	public static final String ACCOUNT_ACTIVATE = "zbjActivate";
	public static final String FORWARD_YJF_SIT = "forwardYJFSit";
	
	public static final String USER_NAME_PARAM_NAME = "userName";
	public static final String USER_TYPE_PARAM_NAME = "userType";
	public static final String USER_ID_RETURN_PARAM_NAME = "userId";
	
	public static final String USER_REAL_NAME_AUTHENTICATION_CERTIFYLEVEL = "yzzUserCertLevelQuery";//实名认证等级查询
	public static final String USER_QUICK_CERTIFY_SERVICE = "realNameCertifySimple";
	
	public static final String USER_VALID_TIME_UPDATE = "yzzUserValidTimeUpdate";
	
	@Override
	public CustomerResult gotoYjfSit(String userId, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		CustomerResult result = new CustomerResult();
		try {
			Assert.hasText(userId, "userId不能为空");
			openApiContext.setService(FORWARD_YJF_SIT);
			paramMap.put("userId", userId);
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl() + "/userManage/userHome");
			paramMap.put("returnUrl", openApiContext.getNotifyUrl() + "/userManage/userHome");
			String url = makeResposeUrl(paramMap, openApiContext);
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
	public CustomerResult applyAccountActivate(String userId, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		CustomerResult result = new CustomerResult();
		try {
			Assert.hasText(userId, "userId不能为空");
			openApiContext.setService(ACCOUNT_ACTIVATE);
			paramMap.put("userId", userId);
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl() + "/do/mainHome.htm");
			paramMap.put("returnUrl", openApiContext.getNotifyUrl() + "/do/mainHome.htm");
			String url = makeResposeUrl(paramMap, openApiContext);
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
	public CustomerResult openCapitalAccount(RegisterOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		CustomerResult result = new CustomerResult();
		try {
			order.check();
			
			openApiContext.setService(USER_REGISTER_SERVICE);
			
			paramMap.put(USER_NAME_PARAM_NAME, order.getUserName());
			paramMap.put("userType", order.getUserType());
			paramMap.put("mobile", order.getMobile());
			paramMap.put("email", order.getEmail());
			paramMap.put("partnerShopId", order.getMerchOrderNo());
			paramMap.put("partnerShopName", order.getUserName());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				result.setUserId(getResultValue(dataMap, USER_ID_RETURN_PARAM_NAME));
				result.setUserAccountName(getResultValue(dataMap, "userName"));
			}
			
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
	
	@SuppressWarnings("unchecked")
	@Override
	public EsupplierBaseResult updateMobileBinding(MobileBindOrder mobileBindOrder,
													OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			mobileBindOrder.check();
			openApiContext.setService(APPLY_MOBILE_BINDING_CUSTOMER);
			paramMap.put("userId", mobileBindOrder.getUserId());
			paramMap.put("mobile", mobileBindOrder.getMobile());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (!result.isSuccess()) {
				if ("NO_INFO".equals(getResultValue(dataMap, RESULT_CODE))
					&& mobileBindOrder.getIsNew() == BooleanEnum.NO) {
					mobileBindOrder.setIsNew(BooleanEnum.YES);
					openApiContext.setOpenApiBizNo(BusinessNumberUtil.gainOutBizNoNumber());
					result = this.updateMobileBinding(mobileBindOrder, openApiContext);
				}
			}
			
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
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryAccountResult queryUserAccount(String accountId, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		QueryAccountResult result = new QueryAccountResult();
		try {
			Assert.hasText(accountId, "accountId不能为空");
			OpenApiContext apiContext = new OpenApiContext();
			BeanCopier.staticCopy(openApiContext, apiContext);
			apiContext.setOpenApiBizNo(BusinessNumberUtil.gainOutBizNoNumber());
			result = userInfoQuery(accountId, openApiContext);
			if (!result.isSuccess()) {
				return result;
			}
			
			apiContext.setService(USER_ACCOUNT_QUERY);
			//paramMap.put("orderNo", BusinessNumberUtil.gainOutBizNoNumber());
			paramMap.put("userId", accountId);
			Map<String, Object> dataMap = senderPost(paramMap, apiContext);
			//Map<String, Object> newData = (Map<String, Object>) dataMap.get("data");
			setReturnResult(result, dataMap);
			if (result.isSuccess()) {
				YjfAccountInfo accountInfo = result.getYjfAccountInfo();
				Money money = new Money();
				money.setAmount(new BigDecimal((Double) dataMap.get("balance")));
				accountInfo.setBalance(money);
				
				Money money1 = new Money();
				money1.setAmount(new BigDecimal((Double) dataMap.get("availableBalance")));
				accountInfo.setAvailableBalance(money1);
				
				Money money2 = new Money();
				money2.setAmount(new BigDecimal((Double) dataMap.get("freezenBalance")));
				accountInfo.setFreezeAmount(money2);
				
				result.setYjfAccountInfo(accountInfo);
			} else {
				YjfAccountInfo accountInfo = new YjfAccountInfo();
				accountInfo.setUserStatus(UserStatusEnum.UNKNOWN);
				result.setYjfAccountInfo(accountInfo);
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
			YjfAccountInfo accountInfo = new YjfAccountInfo();
			accountInfo.setUserStatus(UserStatusEnum.UNKNOWN);
			result.setYjfAccountInfo(accountInfo);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
			YjfAccountInfo accountInfo = new YjfAccountInfo();
			accountInfo.setUserStatus(UserStatusEnum.UNKNOWN);
			result.setYjfAccountInfo(accountInfo);
		}
		return result;
	}
	
	@Override
	public CustomerResult checkUserNameExist(String userName, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		CustomerResult result = new CustomerResult();
		try {
			Assert.hasText(userName, "userName 不能为空");
			
			openApiContext.setService(CHECK_USERNAME_EXIST);
			paramMap.put("userName", userName);
			//paramMap.put("orderNo", BusinessNumberUtil.gainOutBizNoNumber());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				String resultCode = getResultValue(dataMap, "resultCode");
				if (StringUtil.isNotEmpty(resultCode) && resultCode.indexOf("USERNAME_EXIST") > -1) {
					result.setUserId(getResultValue(dataMap, USER_ID_RETURN_PARAM_NAME));
					result.setExsit(true);
					if (StringUtil.isNotEmpty(result.getUserId()))
						result.setSuccess(true);
				}
			} else {
				String resultCode = getResultValue(dataMap, "resultCode");
				if (StringUtil.isNotEmpty(resultCode) && resultCode.indexOf("USERNAME_EXIST") > -1) {
					result.setUserId(getResultValue(dataMap, USER_ID_RETURN_PARAM_NAME));
					result.setExsit(true);
					if (StringUtil.isNotEmpty(result.getUserId()))
						result.setSuccess(true);
				}
			}
			
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
	public QueryAccountResult userInfoQuery(String userId, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		QueryAccountResult result = new QueryAccountResult();
		try {
			Assert.hasText(userId, "userName 不能为空");
			
			openApiContext.setService(USER_INFO_QUERY);
			paramMap.put("userId", userId);
			//paramMap.put("orderNo", BusinessNumberUtil.gainOutBizNoNumber());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				YjfAccountInfo accountInfo = new YjfAccountInfo();
				MiscUtil.setInfoPropertyByMap(dataMap, accountInfo);
				accountInfo.setUserStatus(UserStatusEnum.getByCode((String) dataMap
					.get("userStatus")));
				accountInfo.setMobile((String) dataMap.get("mobileNo"));
				accountInfo.setLicenseValidTime(com.yjf.esupplier.common.util.DateUtil
					.covertLicenseValidTime(accountInfo.getLicenseValidTime()));
				
				accountInfo
					.setUserType(YjfUserTypeEnum.getByCode((String) dataMap.get("userType")));
				accountInfo.setCertifyLevel(CertifyLevelEnum.getByCertifyLevel(NumberUtil
					.parseInt((String) dataMap.get("certifyLevel"))));
				result.setYjfAccountInfo(accountInfo);
			}
			
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
	
	private EsupplierBaseResult updateCardoff(PersonalCertOrder certOrder,
												BusinessCertOrder businessCertOrder,
												OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			
			openApiContext.setService(USER_VALID_TIME_UPDATE);
			if (certOrder != null) {
				paramMap.put("userId", certOrder.getCoreCustomerUserId());
				paramMap.put("updateCertFrontPath", certOrder.getCardpic());
				paramMap.put("updateCertBackPath", certOrder.getCardpic1());
				paramMap.put("updateCertValidTime", String.valueOf(certOrder.getCardoff()));
				
			} else if (businessCertOrder != null) {
				paramMap.put("userId", businessCertOrder.getCoreCustomerUserId());
				paramMap.put("businessType", "NORMAL");
				paramMap.put("updateComCycle", String.valueOf(businessCertOrder.getComCycle()));
				paramMap.put("updateLicence", businessCertOrder.getLicence());
			}
			
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/openApi/asysGetRealNameStatus.htm");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			
			setReturnResult(result, dataMap);
			
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
	public EsupplierBaseResult realNameCertSave(PersonalCertOrder certOrder,
												OpenApiContext openApiContext) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			
			certOrder.check();
			OpenApiContext apiContext = new OpenApiContext();
			BeanCopier.staticCopy(openApiContext, apiContext);
			apiContext.setOpenApiBizNo(BusinessNumberUtil.gainOutBizNoNumber());
			if (certOrder.isPreUpdate()) { //提前升级
				return updateCardoff(certOrder, null, openApiContext);
			}
			
			QueryAccountResult levelResult = userInfoQuery(certOrder.getCoreCustomerUserId(),
				apiContext);
			if (levelResult.getYjfAccountInfo().getCertifyLevel() == CertifyLevelEnum.CERT_EXPIRE) {
				return updateCardoff(certOrder, null, openApiContext);
			}
			certOrder.setExternalId(openApiContext.getPartnerId());
			openApiContext.setService(REAL_NAME_CERT);
			
			paramMap.put("userId", certOrder.getCoreCustomerUserId());
			paramMap.put("realName", certOrder.getNickname());
			paramMap.put("certType", "Identity_Card");
			paramMap.put("certNo", certOrder.getCardid());
			paramMap.put("certValidTime", String.valueOf(certOrder.getCardoff()));
			paramMap.put("certFrontPath", certOrder.getCardpic());
			paramMap.put("certBackPath", certOrder.getCardpic1());
			/*个人认证*/
			paramMap.put("occupation", "E");
			paramMap.put("mobileNo", certOrder.getMobile());
			paramMap.put("address", YjfDataUtil.makeAddress());
			paramMap.put("attribution", "LAND");
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/openApi/asysGetRealNameStatus.htm");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			
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
	public EsupplierBaseResult realNameEnterpriseCertSave(BusinessCertOrder certOrder,
															OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			certOrder.check();
			OpenApiContext apiContext = new OpenApiContext();
			BeanCopier.staticCopy(openApiContext, apiContext);
			apiContext.setOpenApiBizNo(BusinessNumberUtil.gainOutBizNoNumber());
			QueryAccountResult levelResult = userInfoQuery(certOrder.getCoreCustomerUserId(),
				apiContext);
			if (levelResult.getYjfAccountInfo().getCertifyLevel() == CertifyLevelEnum.CERT_EXPIRE) {
				return updateCardoff(null, certOrder, openApiContext);
			}
			
			openApiContext.setService(ENTERPRISE_REAL_NAME_CERT);
			paramMap.put("userId", certOrder.getCoreCustomerUserId());
			paramMap.put("businessTypeEnum", certOrder.getBusinessTypeEnum());
			paramMap.put("comName", certOrder.getComName());
			paramMap.put("licenceNo", certOrder.getLicencenum());
			paramMap.put("licence", certOrder.getLicence());
			paramMap.put("legalPersonName", certOrder.getHoldingName());
			paramMap.put("legalPersonCertType", "Identity_Card");
			paramMap.put("legalPersonCertNo", certOrder.getLegalPersonCardid());
			
			paramMap.put("legalPersonCertValidTime",
				String.valueOf(certOrder.getLegalPersonCardOff()));
			paramMap.put("legalPersonCertFrontPath", certOrder.getLegalPersonCardPic());
			paramMap.put("legalPersonCertBackPath", certOrder.getLegalPersonCardPic1());
			paramMap.put("address", certOrder.getComAddress());
			paramMap.put("phone", certOrder.getConMobile());
			paramMap.put("provName", certOrder.getProvname());
			paramMap.put("cityName", certOrder.getCityname());
			paramMap.put("businessScope", YjfDataUtil.makeEnterpriseBusinessScope());
			paramMap.put("comCycle", String.valueOf(certOrder.getComCycle()));
			
			paramMap.put("attribution", "LAND");
			paramMap.put("organizationCode", certOrder.getOrganizationcode());
			
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/openApi/asysGetRealNameStatus.htm");
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			
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
	public RealNameStatusResult queryRealNameCert(String userId, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		RealNameStatusResult result = new RealNameStatusResult();
		try {
			Assert.hasText(userId, "accountId不能为空");
			openApiContext.setService(REAL_NAME_CERT_QUERY);
			
			paramMap.put("userId", userId);
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				result.setBusinessStatusEnum(RealNameBusinessStatusEnum.getByCode((String) dataMap
					.get("stauts")));
				result.setMsg((String) dataMap.get("msg"));
				result.setSuccess(true);
			}
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
	public RealNameLevelResult queryRealNameAuthenticationLevel(String userId,
																OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		RealNameLevelResult result = new RealNameLevelResult();
		try {
			Assert.hasText(userId, "userId不能为空");
			openApiContext.setService(USER_REAL_NAME_AUTHENTICATION_CERTIFYLEVEL);
			
			paramMap.put("userId", userId);
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				result.setMsg((String) dataMap.get("certifyRankDesc"));
				result.setCertifyLevel(CertifyLevelEnum.getByCode((String) dataMap
					.get("certifyRank")));
				result.setSuccess(true);
			} else {
				result.setCertifyLevel(CertifyLevelEnum.NO_RANK);
			}
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
	public EsupplierBaseResult checkNineElements(String accountId, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			Assert.hasText(accountId);
			openApiContext.setService("commonCheckElements");
			paramMap.put("userId", accountId);
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			//complete 用户要素齐全
			//auditing 用户要素不齐，在补全审核中
			//incomplete 用户要素不齐全
			if (dataMap != null
				&& "complete".equalsIgnoreCase((String) dataMap.get("completeStatus"))
				|| "auditing".equalsIgnoreCase((String) dataMap.get("completeStatus"))) {
				result.setSuccess(true);
			} else {
				result.setCreditsysResultEnum(EsupplierResultEnum.OPENAPI_ACCESS_FAILURE);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
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
	public EsupplierBaseResult userQuickCertify(UserQuickCertifyOrder certifyOrder,
												OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			certifyOrder.check();
			openApiContext.setService(USER_QUICK_CERTIFY_SERVICE);
			paramMap.put("realName", certifyOrder.getRealName());
			paramMap.put("certNo", certifyOrder.getCertNo());
			paramMap.put("userId", certifyOrder.getUserId());
			if (StringUtil.isEmpty(certifyOrder.getCertValidTime())) {
				paramMap.put("certValidTime", "0");
			}
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
			} else {
				result.setCreditsysResultEnum(EsupplierResultEnum.OPENAPI_ACCESS_FAILURE);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
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
	public EsupplierBaseResult fullNineElements(RegisterOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			
			openApiContext.setService("updateUserService");
			YjfDataUtil.fullRegisterOrder(order);
			paramMap.put("userId", order.getUserId());
			if ("P".equals(order.getUserType()))//个人
			{
				paramMap.put(USER_TYPE_PARAM_NAME, YjfUserTypeEnum.PERSON.code());
				paramMap.put("gender", order.getGender().code());
				paramMap.put("profession", order.getProfession());
				paramMap.put("address", order.getProvince());
				paramMap.put("country", order.getCountry());
			} else if ("B".equals(order.getUserType())) {
				paramMap.put(USER_TYPE_PARAM_NAME, YjfUserTypeEnum.BUSINESS.code());
				paramMap.put("licenseValidTime", order.getLicenseValidTime());//Other
				paramMap.put("legalCertType", order.getLegalCertType());
				paramMap.put("legalLicValidTime", order.getLegalLicValidTime());
				paramMap.put("legalPersonCertBackPath", order.getLegalPersonCertBackPath());
				paramMap.put("legalPersonCertFrontPath", order.getLegalPersonCertFrontPath());
				paramMap.put("legalPersonCertNo", order.getLegalPersonCertNo());
				paramMap.put("legalPersonName", order.getLegalPersonName());
				paramMap.put("licence", order.getLicence());
				paramMap.put("licenseValidTime", order.getLicenseValidTime());
				paramMap.put("organizationCode", order.getOrganizationCode());
				paramMap.put("regAddress", order.getRegAddress());
				paramMap.put("enterpriseBusinessScope", order.getEnterpriseBusinessScope());
				
			}
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
			} else {
				result.setCreditsysResultEnum(EsupplierResultEnum.OPENAPI_ACCESS_FAILURE);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
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
