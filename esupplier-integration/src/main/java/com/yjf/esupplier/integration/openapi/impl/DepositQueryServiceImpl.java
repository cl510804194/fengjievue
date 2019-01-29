/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.integration.openapi.DepositQueryService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.enums.BusinessNoEnum;
import com.yjf.esupplier.integration.openapi.enums.PayToolAccessEnum;
import com.yjf.esupplier.integration.openapi.info.DepositInfo;
import com.yjf.esupplier.integration.openapi.order.QueryDepositOrder;
import com.yjf.esupplier.integration.openapi.result.DepositQueryResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename DepositQueryServiceImpl.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-6</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Service("depositQueryService")
public class DepositQueryServiceImpl extends OpenApiServiceBase implements DepositQueryService {
	private static final String DEPOSIT_QUERY_SERVICE_NAME = "deposit.query";
	
	/**
	 * @param userId
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.DepositQueryService#depositQueryService(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DepositQueryResult depositQueryService(QueryDepositOrder depositOrder,
													OpenApiContext openApiContext) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		DepositQueryResult result = new DepositQueryResult();
		try {
			openApiContext.setService(DEPOSIT_QUERY_SERVICE_NAME);
			if (StringUtil.isEmpty(depositOrder.getBizId())) {
				depositOrder.setBizId(BusinessNoEnum.DEPOSIT_EASY_TURNOVER.getCode());
			}
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(depositOrder));
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			result.setSuccess(isSuccessStringSuccess(dataMap));
			
			if (result.isSuccess()) {
				result.setCurrPage(NumberUtil.parseInt(String.valueOf(dataMap.get("currPage"))));
				result.setCount(NumberUtil.parseLong(String.valueOf(dataMap.get("count"))));
				result
					.setAmounts(new Money(new BigDecimal(String.valueOf(dataMap.get("amounts")))));
				result
					.setCharges(new Money(new BigDecimal(String.valueOf(dataMap.get("charges")))));
				result.setAmountsIn(new Money(new BigDecimal(String.valueOf(dataMap
					.get("amountsIn")))));
				result.setPageSize(depositOrder.getPageSize());
				List<Map<String, Object>> depositIds = (List<Map<String, Object>>) dataMap
					.get("depositInfos");
				List<DepositInfo> depositInfos = new ArrayList<DepositInfo>();
				for (Map<String, Object> item : depositIds) {
					DepositInfo depositInfo = new DepositInfo();
					MiscUtil.setInfoPropertyByMap(item, depositInfo);
					depositInfo.setApiAccess(PayToolAccessEnum.getByCode((String) item
						.get("apiAccess")));
					depositInfo.setPayTime(new Date((long) item.get("payTime")));
					depositInfos.add(depositInfo);
				}
				result.setDepositInfos(depositInfos);
			} else {
				result.setMessage((String) dataMap.get("message"));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			result.setMessage(e.getMessage());
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
		
	}
	
}
