package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.integration.openapi.YjfMerchantService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.QueryYjfMerchantOrder;
import com.yjf.esupplier.integration.openapi.result.MerchantQueryResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service("yjfMerchantService")
public class YjfMerchantServiceImpl extends OpenApiServiceBase implements YjfMerchantService {
	
	public static final String YJF_MERCHANT_QUERY = "findUserSpecialInfoByUserId";
	
	@Override
	public MerchantQueryResult getUserIdYjfMerchantInfo(QueryYjfMerchantOrder merchantOrder,
														OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		MerchantQueryResult result = new MerchantQueryResult();
		try {
			merchantOrder.check();
			openApiContext.setService(YJF_MERCHANT_QUERY);
			paramMap.put("userId", merchantOrder.getUserId());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (result.isSuccess()) {
				result.setMerchantId((String) dataMap.get("userId"));
				result.setRegisterFrom((String) dataMap.get("registerFrom"));
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
