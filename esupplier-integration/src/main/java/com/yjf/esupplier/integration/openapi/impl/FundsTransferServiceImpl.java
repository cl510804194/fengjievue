/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import com.yjf.esupplier.common.util.Constants;
import com.yjf.esupplier.ws.bill.enums.RefundApiStatusEnum;
import org.springframework.stereotype.Service;

import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.FundsTransferService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.FundsTransferOrder;
import com.yjf.esupplier.integration.openapi.result.OpenApiResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename TradeTransferServiceImpl.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History
 * <li>Author: qichunhai</li>
 * <li>Date: 2013-3-6</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Service("fundsTransferService")
public class FundsTransferServiceImpl extends OpenApiServiceBase implements FundsTransferService {
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.FundsTransferService#tradeTransfer(com.yjf.esupplier.integration.openapi.order.FundsTransferOrder,
	 * com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public OpenApiResult tradeTransfer(FundsTransferOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		OpenApiResult result = new OpenApiResult();
		try {
			order.check();
			openApiContext.setService(ZHONGJIN_TRANSFER_SERVICE_NAME);
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(order));
			/*退款异步地址*/
			paramMap.put(Constants.NOTIFY_URL_KEY, openApiContext.getNotifyUrl() + RESULT_URI);
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			String resultCode = (String) dataMap.get("resultCode");
			if(resultCode.equals("EXECUTE_SUCCESS")){
				result.setStatus(RefundApiStatusEnum.SUCCESS);
			}else if(resultCode.equals("EXECUTE_FAILURE")){
				result.setStatus(RefundApiStatusEnum.FAIL);
			}else{
				result.setStatus(RefundApiStatusEnum.PROCESSING);
			}
			result.setBizNo((String) dataMap.get("orderNo"));
		} catch (IllegalArgumentException e) {
			logger.error(e.getLocalizedMessage(), e);
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
