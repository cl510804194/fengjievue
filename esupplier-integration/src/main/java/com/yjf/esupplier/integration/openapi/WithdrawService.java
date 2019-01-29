/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.WithdrawOrder;
import com.yjf.esupplier.integration.openapi.result.WithdrawResult;

/**
 *                       
 * @Filename WithdrawService.java
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
 *<li>Date: 2013-3-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface WithdrawService {
	WithdrawResult applyWithdrawService(WithdrawOrder order, OpenApiContext openApiContext);
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	WithdrawResult gotoWithdrawUrl(WithdrawOrder order, OpenApiContext openApiContext);
}
