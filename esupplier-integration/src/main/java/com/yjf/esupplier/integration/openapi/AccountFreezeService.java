/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.FreezeOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 *                       
 * @Filename AccountFreezeService.java
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
 *<li>Date: 2014-4-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface AccountFreezeService {
	EsupplierBaseResult freeze(FreezeOrder order, OpenApiContext openApiContext);
	
	EsupplierBaseResult unfreeze(FreezeOrder order, OpenApiContext openApiContext);
}
