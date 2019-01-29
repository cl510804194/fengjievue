package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.RefundOrder;
import com.yjf.esupplier.integration.openapi.result.OpenApiResult;

public interface RefundService {
	OpenApiResult refund(RefundOrder refundOrder, OpenApiContext openApiContext);
	OpenApiResult refundWx(RefundOrder refundOrder, OpenApiContext openApiContext);
}
