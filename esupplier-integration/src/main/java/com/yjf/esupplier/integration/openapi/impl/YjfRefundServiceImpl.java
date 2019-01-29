package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import com.yjf.esupplier.ws.bill.enums.RefundApiStatusEnum;

import org.springframework.stereotype.Service;

import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.Constants;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.YjfRefundService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.RefundOrder;
import com.yjf.esupplier.integration.openapi.result.OpenApiResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Service("yjfRefundService")
public class YjfRefundServiceImpl extends OpenApiServiceBase implements YjfRefundService {
	String SERVICE_NAME_REFUND = "tradeRefund";
	String SERVICE_NAME_REFUND_WX = "weixinRefund";

	@Override
	public OpenApiResult refund(RefundOrder refundOrder, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		OpenApiResult result = new OpenApiResult();
		try {
			refundOrder.check();
			openApiContext.setService(SERVICE_NAME_REFUND);
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(refundOrder));
			/*退款异步地址*/
			paramMap.put(Constants.NOTIFY_URL_KEY, openApiContext.getNotifyUrl() + RESULT_URI);
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			result.setStatus(RefundApiStatusEnum.getByCode(String.valueOf(dataMap.get("refundStatus"))));
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

	@Override
	public OpenApiResult refundWx(RefundOrder refundOrder, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		OpenApiResult result = new OpenApiResult();
		try {
			refundOrder.check();
			openApiContext.setService(SERVICE_NAME_REFUND_WX);
			openApiContext.setOpenApiUrl(AppConstantsUtil.getIndustrialApiUrl());
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(refundOrder));
			/*退款异步地址*/
			paramMap.put(Constants.NOTIFY_URL_KEY, openApiContext.getNotifyUrl() + RESULT_URI);
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			String resultCode = (String) dataMap.get(RESULT_CODE);
			String resultValue = String.valueOf(dataMap.get(SUCCESS_VALUE));
			if (resultCode != null
				&& (resultCode.indexOf(SUCCESS) > -1 || resultCode.equals(SUCCESS_VALUE)|| resultValue.equals(SUCCESS_STRING) || resultValue
					.equalsIgnoreCase(SUCCESS_T))) {				
				result.setStatus(RefundApiStatusEnum.SUCCESS);
			}else if(resultCode != null
					&& (resultCode.indexOf(PROCESSING) > -1)){
				result.setStatus(RefundApiStatusEnum.PROCESSING);
			}else{
				result.setStatus(RefundApiStatusEnum.FAIL);
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
