package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.FormGotoGatewayService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.PayOrder;
import com.yjf.esupplier.integration.openapi.result.GoToFormResult;
import com.yjf.esupplier.integration.openapi.result.GoToFormResult.FormText;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service("formGotoGatewayService")
public class FormGotoGatewayServiceImpl extends OpenApiServiceBase implements
																	FormGotoGatewayService {
	
	@Override
	public GoToFormResult getFormTextList(PayOrder gatewayOrder, OpenApiContext openApiContext) {
		GoToFormResult formResult = new GoToFormResult();
		try {
			logger.info("gatewayOrder==={}", gatewayOrder);
			gatewayOrder.check();
			Map<String, String> map = MiscUtil.covertPoToMapNoNullValue(gatewayOrder);
			map.remove("serviceName");
			openApiContext.setService(gatewayOrder.getServiceName());
			Map<String, String> standardParamsMap = buildStandardParams(openApiContext);
			map.putAll(standardParamsMap);
			clearNullVallue(map);
			Map<String, String> postMap = digestParam(openApiContext, map);
			TreeMap<String, String> treeMap = new TreeMap<String, String>(postMap);
			Map<String, String> paramMap = new HashMap<String, String>();
			List<GoToFormResult.FormText> formTexts = Lists.newArrayList();
			for (Entry<String, String> entry : treeMap.entrySet()) {
				FormText formText = new FormText();
				formText.setKey(entry.getKey());
				formText.setValue(entry.getValue());
				formTexts.add(formText);
				paramMap.put(entry.getKey(), entry.getValue());
			}
			formResult.setFormTexts(formTexts);
			formResult.setSuccess(true);
			formResult.setUrl(openApiContext.getOpenApiUrl());
			formResult.setMap(paramMap);
		} catch (IllegalArgumentException e) {
			formResult.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			formResult.setSuccess(false);
		}
		return formResult;
	}
}
