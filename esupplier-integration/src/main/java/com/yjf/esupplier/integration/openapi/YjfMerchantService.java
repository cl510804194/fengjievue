package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.QueryYjfMerchantOrder;
import com.yjf.esupplier.integration.openapi.result.MerchantQueryResult;

public interface YjfMerchantService {
	
	MerchantQueryResult getUserIdYjfMerchantInfo(QueryYjfMerchantOrder merchantOrder,
													OpenApiContext openApiContext);
	
}
