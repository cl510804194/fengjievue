package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.integration.openapi.NonMainlandRealNameService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.NonMainlandRealNameOrder;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service("nonMainlandRealNameService")
public class NonMainlandRealNameServiceImpl extends OpenApiServiceBase implements
																		NonMainlandRealNameService {
	public static final String NONMAINLAND_REAL_NAME_SERVICES = "confidenceAbroadPersonal";
	
	@Override
	public EsupplierBaseResult applyRealName(NonMainlandRealNameOrder realNameOrder,
										OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			
			realNameOrder.check();
			
			openApiContext.setService(NONMAINLAND_REAL_NAME_SERVICES);
			
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(realNameOrder));
			
			paramMap.put("notifyUrl", openApiContext.getNotifyUrl()
										+ "/asynchronous/asysGetRealNameStatus");
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			
			setReturnResult(result, dataMap);
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
