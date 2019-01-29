package com.yjf.esupplier.integration.industrial.api;

import com.yjf.esupplier.integration.industrial.api.result.LogisticsInfoResult;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;

public interface LogisticsInfoQueryService {
	
	LogisticsInfoResult queryShunfengLogisticsInfo(String trackingNumber,
													OpenApiContext openApiContext);
	
}
