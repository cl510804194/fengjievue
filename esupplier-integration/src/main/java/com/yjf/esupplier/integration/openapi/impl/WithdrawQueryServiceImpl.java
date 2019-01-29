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
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.integration.openapi.WithdrawQueryService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.enums.BusinessNoEnum;
import com.yjf.esupplier.integration.openapi.info.QueryWithdrawInfo;
import com.yjf.esupplier.integration.openapi.order.WithdrawQueryOrder;
import com.yjf.esupplier.integration.openapi.result.WithdrawQueryResult;
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
@Service("withdrawQueryService")
public class WithdrawQueryServiceImpl extends OpenApiServiceBase implements WithdrawQueryService {
	private static final String WITHDRAW_QUERY_SERVICE_NAME = "withdraw.query";
	
	/**
	 * @param userId
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.DepositQueryService#depositQueryService(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public WithdrawQueryResult queryWithdrawService(WithdrawQueryOrder order,
													OpenApiContext openApiContext) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		WithdrawQueryResult result = new WithdrawQueryResult();
		try {
			openApiContext.setService(WITHDRAW_QUERY_SERVICE_NAME);
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(order));
			if (StringUtil.isEmpty(order.getBizId())) {
				order.setBizId(BusinessNoEnum.DEPOSIT_EASY_TURNOVER.getCode());
			}
			if (order.getStartTime() != null) {
				paramMap.put("startTime",
					DateUtil.getFormat(DateUtil.dtSimpleYmdhms).format(order.getStartTime()));
				
			}
			if (order.getEndTime() != null) {
				paramMap.put("endTime",
					DateUtil.getFormat(DateUtil.dtSimpleYmdhms).format(order.getEndTime()));
			}
			
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
				result.setPageSize(order.getPageSize());
				List<Map<String, Object>> withdrawInfos = (List<Map<String, Object>>) dataMap
					.get("withdrawInfos");
				List<QueryWithdrawInfo> queryWithdrawInfos = new ArrayList<QueryWithdrawInfo>();
				for (Map<String, Object> item : withdrawInfos) {
					QueryWithdrawInfo queryWithdrawInfo = new QueryWithdrawInfo();
					MiscUtil.setInfoPropertyByMap(item, queryWithdrawInfo);
					queryWithdrawInfo.setPayTime(new Date((long) item.get("payTime")));
					queryWithdrawInfos.add(queryWithdrawInfo);
				}
				result.setWithdrawInfos(queryWithdrawInfos);
			} else {
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
