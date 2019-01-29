/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import com.yjf.esupplier.integration.openapi.TradeQueryService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.result.TradeYjfQueryResult;

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
public class TradeQueryServiceImpl extends OpenApiServiceBase implements TradeQueryService {
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.TradeQueryService#yjfDepositQueryService(java.lang.String, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public TradeYjfQueryResult yjfDepositQueryService(String userId, OpenApiContext openApiContext) {
		return null;
	}
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.TradeQueryService#yjfWithdrawQueryService(java.lang.String, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public TradeYjfQueryResult yjfWithdrawQueryService(String userId, OpenApiContext openApiContext) {
		return null;
	}
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.TradeQueryService#yjfBalanceQueryService(java.lang.String, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public TradeYjfQueryResult yjfBalanceQueryService(String userId, OpenApiContext openApiContext) {
		return null;
	}
	
}
