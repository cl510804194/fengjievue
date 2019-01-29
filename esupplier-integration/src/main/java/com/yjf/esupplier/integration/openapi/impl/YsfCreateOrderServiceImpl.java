package com.yjf.esupplier.integration.openapi.impl;

import java.util.HashMap;
import java.util.Map;

import com.yjf.esupplier.integration.openapi.result.WxPayResult;
import com.yjf.yrd.integration.bornapi.order.WxPayCreateOrder;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.YsfCreateOrderService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.WchatYjfPayOrder;
import com.yjf.esupplier.integration.openapi.result.WchatResult;
import com.yjf.esupplier.integration.openapi.result.YsfCreateOrderResult;
import com.yjf.esupplier.ws.bill.enums.RefundApiStatusEnum;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.yrd.integration.bornapi.order.YsfCreateOrder;

@Service("ysfCreateOrderService")
public class YsfCreateOrderServiceImpl extends OpenApiServiceBase implements YsfCreateOrderService {
	
	private static String SERVICENAME = "createTradeOrder";
	private static String SERVICENAME_COMMONWCHATTRADE = "commonWchatTrade";
	/*跳转微信支付*/
	private static String SERVICENAME_WEIXIN_PAY = "weixinOfficeAccountPay";
	
	@Override
	public YsfCreateOrderResult creatOrder(YsfCreateOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		YsfCreateOrderResult result = new YsfCreateOrderResult();
		try {
			order.check();
			openApiContext.setService(SERVICENAME);
			openApiContext.setOpenApiUrl(AppConstantsUtil.getYjfOpenApiUrl());
			paramMap.put("sellerUserId", openApiContext.getPartnerId());
			paramMap.put("tradeName", order.getTradeName());
			paramMap.put("tradeAmount", order.getTradeAmount());
			paramMap.put("partnerUserId", order.getPartnerUserId());
			paramMap.put("notifyUrl", AppConstantsUtil.getHostHttpUrl() + "/app/depositResult.htm");
			paramMap.put("returnUrl", AppConstantsUtil.getHostHttpUrl() + "/app/depositResult.htm");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if (dataMap == null) {
				result.setCreditsysResultEnum(EsupplierResultEnum.OPENAPI_ACCESS_FAILURE);
				return result;
			} else {
				String resultCode = (String) dataMap.get(RESULT_CODE);
				if (resultCode != null && resultCode.indexOf(SUCCESS) > -1) {
					result.setTradeNo((String) dataMap.get("tradeNo"));
					result.setSuccess(true);
				} else {
					result.setSuccess(false);
					result.setMessage((String) dataMap.get("resultMessage"));
				}
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
	
	@Override
	public WxPayResult createWxPayOrder(WxPayCreateOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		WxPayResult result = new WxPayResult();
		try {
			order.check();
			openApiContext.setService(SERVICENAME_WEIXIN_PAY);
			openApiContext.setOpenApiUrl(AppConstantsUtil.getIndustrialApiUrl());
			paramMap.put("orderNo", order.getOrderNo());
			paramMap.put("title", order.getTitle());
			paramMap.put("payAmount", order.getTradeAmount());
			paramMap.put("desc", order.getDesc());
			paramMap.put("notifyUrl", AppConstantsUtil.getHostHttpUrl() + "/app/depositResult.htm");
			if(StringUtil.isNotEmpty(order.getReturnUrl())){
				paramMap.put("returnUrl", order.getReturnUrl());
			}else{				
				paramMap.put("returnUrl", AppConstantsUtil.getHostHttpUrl() + "/app/depositResult.htm");
			}
			Map<String, String> standardParamsMap = buildStandardParams(openApiContext);
			paramMap.putAll(standardParamsMap);
			clearNullVallue(paramMap);
			Map<String, String> postMap = digestParam(openApiContext, paramMap);
			result.setMap(postMap);
			result.setSuccess(true);
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
	
	@Override
	public WchatResult creatWchat(WchatYjfPayOrder order, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		WchatResult result = new WchatResult();
		try {
			order.check();
			openApiContext.setService(SERVICENAME_COMMONWCHATTRADE);
			paramMap.putAll(MiscUtil.covertPoToMapNoNullValue(order));
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			setReturnResult(result, dataMap);
			if (result.isSuccess()) {
				result.setStatus(RefundApiStatusEnum.getByCode((String) dataMap.get("status")));
				result.setBizNo((String) dataMap.get("bizNo"));
				result.setPayAmount(new Money((double) dataMap.get("payAmount")));
				result.setScanCodeImageUrl((String) dataMap.get("scanCodeImageUrl"));
				result.setTradeNo((String) dataMap.get("tradeNo"));
				result.setReturnUrl((String) dataMap.get("returnUrl"));
			}
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
