package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.MoreMerchantSignBankOrder;
import com.yjf.esupplier.integration.openapi.order.PactApplyOrder;
import com.yjf.esupplier.integration.openapi.order.PactSignOrder;
import com.yjf.esupplier.integration.openapi.order.PayByNotCardOrder;
import com.yjf.esupplier.integration.openapi.order.QuerySignBankOrder;
import com.yjf.esupplier.integration.openapi.order.SignOrder;
import com.yjf.esupplier.integration.openapi.order.SigningByNotCardOrder;
import com.yjf.esupplier.integration.openapi.order.VerifyBankCardOrder;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.openapi.result.PactResult;
import com.yjf.esupplier.integration.openapi.result.SignBankResult;
import com.yjf.esupplier.integration.openapi.result.SignResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
public interface SignService {
	
	/**
	 * 签约银行卡
	 * 
	 * @param signOrder
	 * @return
	 */
	SignResult sign(SignOrder signOrder, OpenApiContext openApiContext);
	
	/**
	 * 查询签约银行卡
	 * 
	 * @param querySignBankOrder
	 * @return
	 */
	SignBankResult querySignBankCard(QuerySignBankOrder querySignBankOrder,
										OpenApiContext openApiContext);
	
	/**
	 * 验证签约的银行卡
	 * @param bankCardOrder
	 * @return
	 */
	EsupplierBaseResult verifyBankCardFacade(VerifyBankCardOrder bankCardOrder,
												OpenApiContext openApiContext);
	
	/**
	 * 签约申请
	 * @param applyOrder
	 * @param openApiContext
	 * @return
	 */
	PactResult pactApply(PactApplyOrder applyOrder, OpenApiContext openApiContext);
	
	EsupplierBaseResult pactSign(PactSignOrder pactSignOrder, OpenApiContext openApiContext);
	
	SignBankResult queryMoreMerchantSignBankCard(MoreMerchantSignBankOrder querySignBankOrder,
													OpenApiContext openApiContext);
	
	/**
	 * 
	 * @param notCardOrder
	 * @param openApiContext
	 * @return
	 */
	CustomerResult signingByNotCard(SigningByNotCardOrder notCardOrder,
									OpenApiContext openApiContext);
	
	/**
	 * 扣款支付
	 * @param notCardOrder
	 * @param openApiContext
	 * @return
	 */
	EsupplierBaseResult payByNotCard(PayByNotCardOrder notCardOrder, OpenApiContext openApiContext);
	
}
