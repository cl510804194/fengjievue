package com.yjf.esupplier.integration.industrial.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import rop.thirdparty.com.google.common.collect.Lists;

import com.yjf.common.lang.util.DateUtil;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.integration.industrial.api.LogisticsInfoQueryService;
import com.yjf.esupplier.integration.industrial.api.info.LogisticsFlowInfo;
import com.yjf.esupplier.integration.industrial.api.result.LogisticsInfoResult;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service
public class LogisticsInfoQueryServiceImpl extends OpenApiServiceBase implements
																		LogisticsInfoQueryService {
	public static String SHUN_FENG_SERVICE = "poolSfRouteQuery";
	
	@Override
	public LogisticsInfoResult queryShunfengLogisticsInfo(String trackingNumber,
															OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		LogisticsInfoResult result = new LogisticsInfoResult();
		try {
			openApiContext.setService(SHUN_FENG_SERVICE);
			paramMap.put("trackingNumber", trackingNumber);
			openApiContext.setOpenApiUrl(AppConstantsUtil.getIndustrialApiUrl());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			result.setSuccess(isSuccess(dataMap));
			
			if (result.isSuccess()) {
				result.setTrackingNumber((String) dataMap.get("trackingNumber"));
				List<Map<String, Object>> dataList = (List<Map<String, Object>>) dataMap
					.get("list");
				List<LogisticsFlowInfo> flowInfos = Lists.newArrayList();
				for (Map<String, Object> item : dataList) {
					LogisticsFlowInfo logisticsFlowInfo = new LogisticsFlowInfo();
					logisticsFlowInfo.setAcceptTime(DateUtil.simpleFormatDate((String) item
						.get("accept_time")));
					logisticsFlowInfo.setAcceptAddress((String) item.get("accept_address"));
					logisticsFlowInfo.setRemark((String) item.get("remark"));
					logisticsFlowInfo.setOpcode((String) item.get("opcode"));
					flowInfos.add(logisticsFlowInfo);
				}
				result.setFlowInfos(flowInfos);
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
