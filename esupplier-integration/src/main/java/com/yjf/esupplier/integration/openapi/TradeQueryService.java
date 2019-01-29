/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.result.TradeYjfQueryResult;

/**
 *                       
 * @Filename TradeQueryService.java
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
public interface TradeQueryService {
	TradeYjfQueryResult yjfDepositQueryService(String userId, OpenApiContext openApiContext);
	
	TradeYjfQueryResult yjfWithdrawQueryService(String userId, OpenApiContext openApiContext);
	
	TradeYjfQueryResult yjfBalanceQueryService(String userId, OpenApiContext openApiContext);
}
