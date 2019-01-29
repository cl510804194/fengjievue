package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface SMSService {
	EsupplierBaseResult sendValidateCode(SmsBizType bizCode, String code, String mobileNumber,String extendMessage,
									OpenApiContext openApiContext);
	
	EsupplierBaseResult sendSMS(String mobileNumber, String smsContent, OpenApiContext openApiContext);
	
	/**
	 * 通过群发通道发短信
	 * @param moilesArray
	 * @param smsContent
	 * @return
	 */
	public EsupplierBaseResult sendBroadcastSMS(String[] moilesArray, String smsContent);

	EsupplierBaseResult sendSmsText(String mobileNumber, String text,
			OpenApiContext openApiContext);
}
