/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.integration.openapi.AccountFreezeService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.FreezeOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 *                       
 * @Filename AccountFreezeServiceImpl.java
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
 *<li>Author: qichunhai</li>
 *<li>Date: 2014-4-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Service("accountFreezeService")
public class AccountFreezeServiceImpl extends OpenApiServiceBase implements AccountFreezeService {
	
	public static final String	YZZ_ACCOUNT_FREEZE		= "yzzAccountFreeze";
	public static final String	YZZ_ACCOUNT_UNFREEZE	= "yzzAccountUnfreeze";
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.AccountFreezeService#freeze(com.yjf.accounttrans.service.order.freeze.FreezeOrder, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	
	@Override
	public EsupplierBaseResult freeze(FreezeOrder order, OpenApiContext openApiContext) {
		
		return callOpenApi(order, openApiContext, YZZ_ACCOUNT_FREEZE);
		
	}
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	protected EsupplierBaseResult callOpenApi(FreezeOrder order, OpenApiContext openApiContext,
										String serviceName) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			order.check();
			openApiContext.setService(serviceName);
			
			paramMap.put("accountNo", order.getAccountNo());
			paramMap.put("orderNo", order.getOrderNo());
			paramMap.put("freezeAmount", order.getFreezeAmount().toString());
			paramMap.put("freezeType", order.getFreezeType());
			paramMap.put("memo", order.getMemo());
            paramMap.put("outBizNo",order.getOutBizNo());
			// TODO 根据用户真实类型选择
			
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
	
	/**
	 * @param order
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.AccountFreezeService#unfreeze(com.yjf.accounttrans.service.order.freeze.FreezeOrder, com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	
	@Override
	public EsupplierBaseResult unfreeze(FreezeOrder order, OpenApiContext openApiContext) {
		return callOpenApi(order, openApiContext, YZZ_ACCOUNT_UNFREEZE);
	}
	
}
