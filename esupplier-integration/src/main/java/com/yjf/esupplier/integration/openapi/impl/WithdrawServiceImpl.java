/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yjf.esupplier.integration.openapi.WithdrawService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.enums.BusinessCategoryEnum;
import com.yjf.esupplier.integration.openapi.enums.BusinessNoEnum;
import com.yjf.esupplier.integration.openapi.order.WithdrawOrder;
import com.yjf.esupplier.integration.openapi.result.WithdrawResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename WithdrawServiceImpl.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-6</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Service("withdrawService")
public class WithdrawServiceImpl extends OpenApiServiceBase implements WithdrawService {
	
	String WITHDRAW_SERVICE_NAME = "applyWithdraw";
	String GOTO_WITHDRAW_URL_SERVICE_NAME = "commonRedirectToWithdrawal";// ppmNewWithdraw
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.WithdrawService#applyWithdrawService(com.yjf.esupplier.integration.openapi.order.WithdrawOrder,
	 * com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public WithdrawResult applyWithdrawService(WithdrawOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		WithdrawResult result = new WithdrawResult();
		try {
			order.check();
			openApiContext.setService(WITHDRAW_SERVICE_NAME);
			paramMap.put("outBizNo", order.getOrderNo());
			paramMap.put("provName", order.getProvName());
			paramMap.put("cityName", order.getCityName());
			paramMap.put("bankAccountNo", order.getBankAccountNo());
			paramMap.put("bankAccountName", order.getBankAccountName());
			paramMap.put("memo", order.getMemo());
			paramMap.put("bizIdentity", BusinessNoEnum.WITHDRAW_EASY_TURNOVER.getBizCategory());
			paramMap.put("bizNo", BusinessNoEnum.WITHDRAW_EASY_TURNOVER.getCode());
			paramMap.put("bankCnapsNo", order.getBankCnapsNo());
			paramMap.put("owner", BusinessCategoryEnum.EASY_TURNOVER.code());
			paramMap.put("subOwner", "p2pCommonProduct");
			// TODO 根据用户真实类型选择
			paramMap.put("publicTag", order.getPublicTag().getCode());
			paramMap.put("userId", order.getUserId());
			paramMap.put("amount", order.getAmount().toString());
			paramMap.put("bankCode", order.getBankCode());
			
			paramMap.put("realName", order.getBankAccountName());
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/asynchronous/asysGetWithdrawalRsult.htm");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			result.setMemo(jsonObject.toJSONString());
			setReturnResult(result, dataMap);
			if (result.isSuccess()) {
				String withdrawId = getResultValue(dataMap, "instructionInfo", "withdrawId");
				result.setWithdrawId(withdrawId);
				String openApiErrorCode = getResultValue(dataMap, "errCodeCtx", "code");
				result.setOpenApiErrorCode(openApiErrorCode);
				if (result.isRepeat()) {
					String openApiResultCode = getResultValue(dataMap, "errCodeCtx", "message");
					if (!EsupplierResultEnum.EXECUTE_SUCCESS.code().equals(openApiResultCode)) {
						result.setSuccess(false);
						result.setOpenApiErrorCode(openApiResultCode);
					}
				}
			} else {
				String resultCode = (String) dataMap.get("resultCode");
				result.setOpenApiErrorCode(resultCode);
				//				if (!result.isRepeat()) {
				//					result.setOpenApiErrorCode(resultCode);
				//				}
			}
			result.setOutBizNo(order.getOrderNo());
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
	public WithdrawResult gotoWithdrawUrl(WithdrawOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		WithdrawResult result = new WithdrawResult();
		try {
			Assert.hasText(order.getUserId(), "userId 不能为空");
			openApiContext.setService(GOTO_WITHDRAW_URL_SERVICE_NAME);
			
			paramMap.put("userId", order.getUserId());
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/openApi/pageWithdrawReturn.htm");
			paramMap.put("returnUrl", openApiContext.getNotifyUrl() + "/do/mainHome.htm");
			paramMap.put("outOrderNo", openApiContext.getOpenApiBizNo());
			paramMap.put("status", String.valueOf(true));
			paramMap.put("containChargeAmount", String.valueOf(true));
			
			String url = makeResposeUrl(paramMap, openApiContext, null);
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
