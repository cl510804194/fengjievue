/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.DeductDepositService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.info.DepositInfo;
import com.yjf.esupplier.integration.openapi.order.DepositDeductOrder;
import com.yjf.esupplier.integration.openapi.order.EBankDepositDeductOrder;
import com.yjf.esupplier.integration.openapi.result.DeductDepositResult;
import com.yjf.esupplier.ws.enums.DepositStatusEnum;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename DeductDepositServiceImpl.java
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
@Service("deductDepositService")
public class DeductDepositServiceImpl extends OpenApiServiceBase implements DeductDepositService {
	
	private static final String DEDUCT_DEPOSIT_SERVICE_NAME = "yzzNewDeduct";
	private static final String APPLY_EBANK_DEPOSIT_SERVICE_NAME = "deposit";
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.DeductDepositService#applyDeductDeposit(com.yjf.payengine.deposit.service.order.DepositDeductOrder,
	 * com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DeductDepositResult applyDeductDeposit(DepositDeductOrder order,
													OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		DeductDepositResult result = new DeductDepositResult();
		try {
			order.check();
			openApiContext.setService(DEDUCT_DEPOSIT_SERVICE_NAME);
			paramMap.put("outBizNo", order.getOrderNo());
			paramMap.put("bankProvName", order.getProvName());
			paramMap.put("bankCityName", order.getCityName());
			paramMap.put("bankAccountNo", order.getBankAccountNo());
			paramMap.put("bankAccountName", order.getBankAccountName());
			paramMap.put("memo", order.getMemo());
			paramMap.put("owner", "yjf");
			paramMap.put("subOwner", "easy_eight");
			if (order.getPayMode() != null) {
				paramMap.put("payMode", order.getPayMode().code());
			}
			paramMap.put("userId", order.getUserId());
			//paramMap.put("amount", order.getAmount().toString());
			paramMap.put("money", order.getAmount().toString());
			paramMap.put("bankCode", order.getBankCode());
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/openApi/returnDeductDepositResult.htm");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(dataMap);
			result.setMemo(jsonObject.toJSONString());
			setReturnResult(result, dataMap);
			if (result.isSuccess()) {
				String depositId = (String) dataMap.get("depositId");
				result.setDepositId(depositId);
				try {
					DepositInfo depositInfo = new DepositInfo();
					MiscUtil.setInfoPropertyByMap(dataMap, depositInfo);
					if (dataMap.get("rawAddTime") != null) {
						Date tempDate = DateUtil.parse((String) dataMap.get("rawAddTime"));
						depositInfo.setRawAddTime(tempDate);
					}
					result.setDepositInfo(depositInfo);
					result
						.setDepositStatusEnum(DepositStatusEnum.getByCode(depositInfo.getStatus()));
					
				} catch (Exception e) {
					logger.error("dataMap.get(\"instructionInfo\") is error", e);
				}
				result.setDepositStatusEnum(DepositStatusEnum.SUCCESS);
			} else {
				String resultCode = (String) dataMap.get("resultCode");
				if ("BIZ_PROCESSING".equals(resultCode)) {
					result.setSuccess(true);
					result.setDepositStatusEnum(DepositStatusEnum.SUBMIT_SETTLED);
				} else {
					result.setOpenApiErrorCode(resultCode);
					String message = getResultValue(dataMap, "errCodeCtx", "message");
					String memo = getResultValue(dataMap, "errCodeCtx", "memo");
					if (message == null) {
						message = getResultValue(dataMap, "resultMessage");
						memo = getResultValue(dataMap, "resultCode");
					}
					result.setMessage(message);
					result.setMemo(memo);
					result.setDepositStatusEnum(DepositStatusEnum.FAILURE);
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
	public DeductDepositResult applyEBankDeposit(EBankDepositDeductOrder order,
													OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		DeductDepositResult result = new DeductDepositResult();
		try {
			order.check();
			openApiContext.setService(APPLY_EBANK_DEPOSIT_SERVICE_NAME);
			if (order.getPayMode() != null) {
				paramMap.put("payMode", order.getPayMode().code());
			}
			paramMap.put("userId", order.getUserId());
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/openApi/returnEBankDepositResult.htm");
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
}
