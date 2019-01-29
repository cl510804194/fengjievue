package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.InvestNofityOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface YjfInvestApiService {
	EsupplierBaseResult investNofity(InvestNofityOrder order, OpenApiContext openApiContext);
}
