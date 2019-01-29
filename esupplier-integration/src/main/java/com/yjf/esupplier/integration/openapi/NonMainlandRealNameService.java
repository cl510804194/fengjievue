package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.NonMainlandRealNameOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface NonMainlandRealNameService {
	
	/**
	 * 非大陆实名认证
	 * @param realNameOrder
	 * @param openApiContext
	 * @return
	 */
	EsupplierBaseResult applyRealName(NonMainlandRealNameOrder realNameOrder,
								OpenApiContext openApiContext);
	
}
