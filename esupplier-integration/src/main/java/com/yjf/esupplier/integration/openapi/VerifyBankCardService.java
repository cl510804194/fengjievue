/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.RemoveUserCardOrder;
import com.yjf.esupplier.integration.openapi.order.VerifyBankCardBinOrder;
import com.yjf.esupplier.integration.openapi.order.VerifyBankCardOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * @Filename VerifyBankCardService.java
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
public interface VerifyBankCardService {
	EsupplierBaseResult verifyFacade(VerifyBankCardOrder bankCardOrder, OpenApiContext openApiContext);
	
	EsupplierBaseResult verifyBankCardBin(VerifyBankCardBinOrder bankCardOrder,
									OpenApiContext openApiContext);
	
	/**
	 * 删除卡
	 * @param removeUserCardOrder
	 * @param openApiContext
	 * @return
	 */
	EsupplierBaseResult removeUserBindingCard(RemoveUserCardOrder removeUserCardOrder,
										OpenApiContext openApiContext);
}
