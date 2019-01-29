package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.PayOrder;
import com.yjf.esupplier.integration.openapi.result.GoToFormResult;

public interface FormGotoGatewayService {
	public final static String SERVICE_COMMONGATEWAYTRADEPAY = "commonGatewayTradePay";
	public final static String SERVICE_COMMONTRADEPAY = "commonTradePay";
	public final static String SERVICE_COMMONWCHATTRADEREDIRECT = "commonWchatTradeRedirect";
	public final static String SERVICE_COMMONWCHATTRADE = "commonWchatTrade";
	public final static String SERVICE_COMMONUNIONCASHIERPAY = "commonUnionCashierPay";
	/*中金支付接口服务名称*/
	public final static String SERVICE_COMMONUNIONZHONGJINPAY = "poolZjForwardPayment";
	public final static String SERVICE_COMMONUNIONQIFUTONGPAY = "qftIntegratedPayment";
	/* 易极付最新交易付款接口 */
	public final static String SERVICE_FASTPAYTRADEMERGEPAY = "fastPayTradeMergePay";
	GoToFormResult getFormTextList(PayOrder payOrder, OpenApiContext openApiContext);
}
