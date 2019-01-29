package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.integration.openapi.YjfInvestApiService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.InvestNofityOrder;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service("yjfInvestApiService")
public class YjfInvestApiServiceImpl extends OpenApiServiceBase implements YjfInvestApiService {
	public static final String INVEST_API_SERVICE = "investNotifyApiService";
	
	@Override
	public EsupplierBaseResult investNofity(InvestNofityOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		CustomerResult result = new CustomerResult();
		try {
			order.check();
			openApiContext.setService(INVEST_API_SERVICE);
			Map<String, String> orderMap = MiscUtil.covertPoToMapNoNullValue(order);
			paramMap.putAll(orderMap);
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			
			if ("true".equals(dataMap.get("status"))) {
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
				result.setMessage(String.valueOf(dataMap.get("message")));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
}
