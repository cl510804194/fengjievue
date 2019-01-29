/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.FundsTransferOrder;
import com.yjf.esupplier.integration.openapi.result.OpenApiResult;

/**
 * 
 * @Filename TradeTransferService.java
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
public interface FundsTransferService {
	/*中金支付退款接口名称*/
	static final String ZHONGJIN_TRANSFER_SERVICE_NAME = "poolZjApplyRefund";
	/**
	 * 买家卖家支付
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	public OpenApiResult tradeTransfer(FundsTransferOrder order, OpenApiContext openApiContext);
	
}
