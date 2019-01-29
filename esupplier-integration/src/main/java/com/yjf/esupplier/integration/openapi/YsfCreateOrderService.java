package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.WchatYjfPayOrder;
import com.yjf.esupplier.integration.openapi.result.WchatResult;
import com.yjf.esupplier.integration.openapi.result.WxPayResult;
import com.yjf.esupplier.integration.openapi.result.YsfCreateOrderResult;
import com.yjf.yrd.integration.bornapi.order.WxPayCreateOrder;
import com.yjf.yrd.integration.bornapi.order.YsfCreateOrder;

public interface YsfCreateOrderService {
	/** sellerUserId 默认为平台ID */
	YsfCreateOrderResult creatOrder(YsfCreateOrder order, OpenApiContext openApiContext);
	/**
	 * 微信跳转支付
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	WxPayResult createWxPayOrder(WxPayCreateOrder order, OpenApiContext openApiContext);

	/**
	 * 微信扫描支付
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	WchatResult creatWchat(WchatYjfPayOrder order, OpenApiContext openApiContext);
}
