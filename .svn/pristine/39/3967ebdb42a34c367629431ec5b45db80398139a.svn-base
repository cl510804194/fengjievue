package com.yjf.esupplier.integration.web.server;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.web.server.impl.YjfEzmoneyCheckPaytkOrder;
import com.yjf.esupplier.integration.web.server.impl.YjfEzmoneyPayPassUrlOrder;
import com.yjf.esupplier.integration.web.server.impl.YjfPayPwdOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.yrd.integration.bornapi.order.YjfActiveOrder;

public interface YjfLoginWebServer {
	
	EsupplierBaseResult commonRedirectUserActive(YjfActiveOrder yjfActiveOrder,
													OpenApiContext openApiContext);
	
	EsupplierBaseResult gotoYjfForgetPayPwdUrl(YjfPayPwdOrder payPwdOrder,
												OpenApiContext openApiContext);
	
	CustomerResult loginYjfInfo(String accessToken);
	
	EsupplierBaseResult gotoYjfValidatePayPasswordUrl(	YjfEzmoneyPayPassUrlOrder ezmoneyPayPassUrlOrder,
														OpenApiContext openApiContext);
	
	EsupplierBaseResult gotoYjfCheckPayTk(YjfEzmoneyCheckPaytkOrder ezmoneyPayPassUrlOrder,
											OpenApiContext openApiContext);
	
	EsupplierBaseResult gotoYjfModifyPayPwdUrl(YjfPayPwdOrder payPwdOrder,
												OpenApiContext openApiContext);
}
