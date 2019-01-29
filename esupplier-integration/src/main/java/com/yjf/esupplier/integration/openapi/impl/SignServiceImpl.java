package com.yjf.esupplier.integration.openapi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.SignService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.info.SignBankInfo;
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
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
@Service("signService")
public class SignServiceImpl extends OpenApiServiceBase implements SignService {
	
	public final static String PACT_SIGN_SERVICE_NAME = "signmanybank"; // 跳转签约平台，服务名
	
	public final static String PACT_QUERY_SIGN_SERVICE_NAME = "signmaybankquery"; // 查询签约银行卡
	public final static String VERIFY_BANK_CARD_SERVICE_NAME = "verifyFacade"; // 验证银行卡
	
	public final static String PACT_APPLY_SERVICE_NAME = "pactApply";// 申请银行卡签约
	
	public final static String PACT_SIGN_COMPLETE_SERVICE_NAME = "pactSign";// 申请银行卡签约
	
	public final static String PACT_BORN_BANK_CARD_LIST_QUERY = "bornBankCardListQuery";
	
	public final static String PACT_UPAYSUBSCRIBE = "upaySubscribe";
	
	public final static String PACT_UPAY_QUICK_PAY = "upayQuickPay";
	
	@Override
	public SignResult sign(SignOrder signOrder, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		SignResult result = new SignResult();
		try {
			signOrder.check();
			openApiContext.setService(PACT_SIGN_SERVICE_NAME);
			paramMap.put("userId", signOrder.getUserId());
			paramMap.put("unionBusinessNo", signOrder.getUnionBusinessNo());
			
			// paramMap.put("notifyUrl", openApiContext.getNotifyUrl() +
			// "/userManage/userHome");
			paramMap.put("returnUrl", AppConstantsUtil.getHostHttpUrl() + "/userManage/userHome");
			String url = makeResposeUrl(paramMap, openApiContext);
			result.setUrl(url);
			result.setSuccess(true);
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public SignBankResult querySignBankCard(QuerySignBankOrder querySignBankOrder,
											OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		SignBankResult result = new SignBankResult();
		try {
			querySignBankOrder.check();
			openApiContext.setService(PACT_QUERY_SIGN_SERVICE_NAME);
			paramMap.put("userId", querySignBankOrder.getUserId());
			// paramMap.put("upUserNo", querySignBankOrder.getUpUserNo());
			paramMap.put("afterStatus", querySignBankOrder.getAfterStatus());
			// paramMap.put("unionBusinessNo",
			// querySignBankOrder.getUnionBusinessNo());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			result.setSuccess(isSuccessStringSuccess(dataMap));
			if (result.isSuccess()) {
				List<SignBankInfo> signBankInfos = new ArrayList<SignBankInfo>();
				List<Map<String, Object>> mapList = (List<Map<String, Object>>) dataMap.get("list");
				for (Map<String, Object> item : mapList) {
					SignBankInfo signBankInfo = new SignBankInfo();
					MiscUtil.setInfoPropertyByMap(item, signBankInfo);
					signBankInfos.add(signBankInfo);
				}
				result.setSignBankInfos(signBankInfos);
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult verifyBankCardFacade(VerifyBankCardOrder bankCardOrder,
													OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			bankCardOrder.check();
			openApiContext.setService(VERIFY_BANK_CARD_SERVICE_NAME);
			paramMap.put("accountNo", bankCardOrder.getAccountNo());
			paramMap.put("bankCode", bankCardOrder.getBankCode());
			paramMap.put("accountName", bankCardOrder.getAccountName());
			paramMap.put("certNo", bankCardOrder.getCertNo());
			paramMap.put("phoneNo", bankCardOrder.getPhoneNo());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if ("VS".equals(dataMap.get("verifyStatus"))) {
				result.setSuccess(true);
			} else {
				result.setMessage((String) dataMap.get("errorMsg"));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public PactResult pactApply(PactApplyOrder applyOrder, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		PactResult result = new PactResult();
		try {
			applyOrder.check();
			openApiContext.setService(PACT_APPLY_SERVICE_NAME);
			paramMap.put("cardNo", applyOrder.getCardNo());
			paramMap.put("userId", applyOrder.getUserId());
			paramMap.put("userPhoneNo", applyOrder.getUserPhoneNo());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
				result.setTradeNo((String) dataMap.get("tradeNo"));
				result.setPactType((String) dataMap.get("pactType"));
			} else {
				result.setSuccess(false);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult pactSign(PactSignOrder pactSignOrder, OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			pactSignOrder.check();
			openApiContext.setService(PACT_SIGN_COMPLETE_SERVICE_NAME);
			paramMap.put("tradeNo", pactSignOrder.getTradeNo());
			paramMap.put("mobileCode", pactSignOrder.getMobileCode());
			paramMap.put("pactType", pactSignOrder.getPactType());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public SignBankResult queryMoreMerchantSignBankCard(MoreMerchantSignBankOrder querySignBankOrder,
														OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		SignBankResult result = new SignBankResult();
		try {
			querySignBankOrder.check();
			openApiContext.setService(PACT_BORN_BANK_CARD_LIST_QUERY);
			JSONArray array = new JSONArray();
			String[] strArray = querySignBankOrder.getUpUserNos().split(",");
			for (String item : strArray) {
				array.add(item);
			}
			paramMap.put("userId", querySignBankOrder.getUserId());
			paramMap.put("upUserNos", array.toJSONString());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			
			if (isSuccess(dataMap)) {
				List<SignBankInfo> signBankInfos = new ArrayList<SignBankInfo>();
				List<Map<String, Object>> mapList = (List<Map<String, Object>>) dataMap
					.get("bankCards");
				if (mapList != null) {
					for (Map<String, Object> item : mapList) {
						SignBankInfo signBankInfo = new SignBankInfo();
						MiscUtil.setInfoPropertyByMap(item, signBankInfo);
						signBankInfo.setPactNo((String) item.get("bindId"));
						signBankInfo.setBankShort((String) item.get("bankCode"));
						signBankInfo.setCardNo((String) item.get("bankCardNo"));
						signBankInfo.setStatus("PACT");
						signBankInfos.add(signBankInfo);
					}
				}
				
				result.setSuccess(true);
				result.setSignBankInfos(signBankInfos);
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public CustomerResult signingByNotCard(SigningByNotCardOrder notCardOrder,
											OpenApiContext openApiContext) {
		CustomerResult result = new CustomerResult();
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			notCardOrder.check();
			openApiContext.setService(PACT_UPAYSUBSCRIBE);
			Map<String, String> map = MiscUtil.covertPoToMapNoNullValue(notCardOrder);
			paramMap.putAll(map);
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
				result.setSubscribeCode((String) dataMap.get("subscribeCode"));
				result.setUserId((String) dataMap.get("userId"));
			} else {
				result.setSuccess(false);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
	
	@Override
	public EsupplierBaseResult payByNotCard(PayByNotCardOrder notCardOrder,
											OpenApiContext openApiContext) {
		EsupplierBaseResult result = new EsupplierBaseResult();
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			notCardOrder.check();
			openApiContext.setService(PACT_UPAY_QUICK_PAY);
			Map<String, String> map = MiscUtil.covertPoToMapNoNullValue(notCardOrder);
			paramMap.putAll(map);
			paramMap.put("amount", notCardOrder.getAmount().toString());
			paramMap.put("notifyUrl", AppConstantsUtil.getHostHttpUrl()
										+ "/openApi/payByNotCardNotify.htm");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			if (isSuccess(dataMap)) {
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
				result.setMessage((String) dataMap.get("resultMessage"));
			}
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
		}
		return result;
	}
}
