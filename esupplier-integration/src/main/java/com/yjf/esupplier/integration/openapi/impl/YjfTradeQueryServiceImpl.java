/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yjf.esupplier.integration.openapi.YjfTradeQueryService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.result.TradeYjfQueryResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 *                       
 * @Filename TradeQueryServiceImpl.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *       
 * @History
 *<li>Author: qichunhai</li>
 *<li>Date: 2014-5-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Service("yjfTradeQueryService")
public class YjfTradeQueryServiceImpl extends OpenApiServiceBase implements YjfTradeQueryService {
	
	private static final String	PPM_BALANCE_RECORD	= "ppmBalanceRecord";
	private static final String	PPM_WITHDRAW_QUERY	= "ppmWithdrawQuery";
	private static final String	PPM_RECHARGE_QUERY	= "ppmRECHARGEQUERY";
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.TradeQueryService#yjfDepositQueryService(java.lang.String, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public TradeYjfQueryResult yjfDepositQueryService(String userId, OpenApiContext openApiContext) {
		return makeCommonUrl(userId, PPM_RECHARGE_QUERY, openApiContext);
	}
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.TradeQueryService#yjfWithdrawQueryService(java.lang.String, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public TradeYjfQueryResult yjfWithdrawQueryService(String userId, OpenApiContext openApiContext) {
		return makeCommonUrl(userId, PPM_WITHDRAW_QUERY, openApiContext);
	}
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.TradeQueryService#yjfBalanceQueryService(java.lang.String, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public TradeYjfQueryResult yjfBalanceQueryService(String userId, OpenApiContext openApiContext) {
		return makeCommonUrl(userId, PPM_BALANCE_RECORD, openApiContext);
	}
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 */
	protected TradeYjfQueryResult makeCommonUrl(String userId, String serviceName,
												OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		TradeYjfQueryResult result = new TradeYjfQueryResult();
		try {
			Assert.hasText(userId, "userId不能为空");
			openApiContext.setService(serviceName);
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
}
