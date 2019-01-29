/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.DepositDeductOrder;
import com.yjf.esupplier.integration.openapi.order.EBankDepositDeductOrder;
import com.yjf.esupplier.integration.openapi.result.DeductDepositResult;

/**
 * 
 * @Filename DeductDepositService.java
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
public interface DeductDepositService {
	DeductDepositResult applyDeductDeposit(DepositDeductOrder order, OpenApiContext openApiContext);
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	DeductDepositResult applyEBankDeposit(EBankDepositDeductOrder order,
											OpenApiContext openApiContext);
}
