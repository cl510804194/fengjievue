/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.integration.openapi.VerifyBankCardService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.RemoveUserCardOrder;
import com.yjf.esupplier.integration.openapi.order.VerifyBankCardBinOrder;
import com.yjf.esupplier.integration.openapi.order.VerifyBankCardOrder;
import com.yjf.esupplier.integration.openapi.result.WithdrawResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename VerifyBankCardServiceImpl.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-9-29</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
@Service("verifyBankCardService")
public class VerifyBankCardServiceImpl extends OpenApiServiceBase implements VerifyBankCardService {
	public static final String SERVICE = "verifyFacade";
	
	public static final String CARD_BIN_SERVICE = "yzzBankCardBin";
	
	public static final String BANK_CARD_BINDING_REMOVE_SERVICE = "bankCardBindingRemove";
	
	@Override
	public EsupplierBaseResult removeUserBindingCard(RemoveUserCardOrder removeUserCardOrder,
												OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			removeUserCardOrder.check();
			openApiContext.setService(BANK_CARD_BINDING_REMOVE_SERVICE);
			paramMap.put("bindId", removeUserCardOrder.getBindId());
			paramMap.put("userId", removeUserCardOrder.getUserId());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
			}
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
	
	/**
	 * @param bankCardOrder
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.VerifyBankCardService#verifyFacade(com.yjf.esupplier.integration.openapi.order.VerifyBankCardOrder,
	 * com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public EsupplierBaseResult verifyFacade(VerifyBankCardOrder bankCardOrder,
										OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		WithdrawResult result = new WithdrawResult();
		try {
			bankCardOrder.check();
			openApiContext.setService(SERVICE);
			
			paramMap.put("bankCode", bankCardOrder.getBankCode());
			paramMap.put("accountName", bankCardOrder.getAccountName());
			paramMap.put("accountNo", bankCardOrder.getAccountNo());
			paramMap.put("cardType", bankCardOrder.getCardType());
			paramMap.put("certType", bankCardOrder.getCertType().getCoreCode());
			paramMap.put("certNo", bankCardOrder.getCertNo());
			paramMap.put("validDate", bankCardOrder.getValidDate());
			paramMap.put("cvv2", bankCardOrder.getCvv2());
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			String verifyStatus = getResultValue(dataMap, "verifyStatus");
			if (StringUtil.equals(verifyStatus, "VS")) {
				;
				//改状态还在修改中
			}
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
	public EsupplierBaseResult verifyBankCardBin(VerifyBankCardBinOrder bankCardOrder,
											OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			bankCardOrder.check();
			openApiContext.setService(CARD_BIN_SERVICE);
			
			paramMap.put("bankCardNo", bankCardOrder.getBankCardNo());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			String verifyStatus = getResultValue(dataMap, "success");
			if (StringUtil.equals(verifyStatus, "T")) {
				String bankId = getResultValue(dataMap, "bankId");
				if (StringUtil.equals(bankId, bankCardOrder.getBankCode())) {
					result.setSuccess(true);
				} else {
					result.setSuccess(false);
					result.setMessage("卡号和所属银行不匹配");
				}
			} else {
				result.setSuccess(false);
				result.setMessage("卡号输入错误");
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
