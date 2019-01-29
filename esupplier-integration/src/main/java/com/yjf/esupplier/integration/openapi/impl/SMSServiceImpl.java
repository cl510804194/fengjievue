package com.yjf.esupplier.integration.openapi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yiji.postman.PostmanClient;
import com.yiji.postman.SmsSendCallback;
import com.yiji.postman.request.SmsSendRequest;
import com.yiji.postman.response.SmsSendResponse;
import com.yjf.common.env.Env;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.CommonUtil;
import com.yjf.esupplier.integration.openapi.SMSService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.ws.enums.SmsBizType;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@Service("smsService")
public class SMSServiceImpl extends OpenApiServiceBase implements SMSService, InitializingBean {
	public final static String PHONE_NOS = "phoneNos";
	public final static String SMS_CTX = "smsContext";
	public final static String SMS_SERVICE = "poolSmsSend";
	public final static String STRATEGY = "strategy";
	
	public final static int PER_AMOUNT = 400; //每次发送最大条数 400条
	
	@Value("${sys.sms.serviceurl}")
	public String sms_service_url;
	
	@Value("${sys.sms.appkey}")
	public String sms_appkey;
	
	@Value("${sys.sms.appsecret}")
	public String sms_appsecret;
	
	@Value("${sys.sms.env}")
	public String sms_env;
	
	@Value("${sys.sms.subcode_name}")
	public String subcode_name;
	
	private static boolean isInit = false;
	private static String SMS_SERVICE_URL;
	private static String SMS_APPKEY;
	private static String SMS_APPSECRET;
	private static String SMS_ENV;
	private static String SUBCODE_NAME;
	
	@Override
	public EsupplierBaseResult sendValidateCode(SmsBizType bizCode, String code,
												String mobileNumber, String extendMessage,
												OpenApiContext openApiContext) {
		EsupplierBaseResult resultBase = new EsupplierBaseResult();
		if (!CommonUtil.checkMobile(mobileNumber)) {
			resultBase.setMessage("电话号码不正确");
			return resultBase;
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append("您本次").append(bizCode.getMessage()).append("的验证码为：").append(code)
			.append(StringUtil.defaultIfBlank(extendMessage, ""))
			.append("（为了您的资金安全，请勿将验证码转告他人），如非本人操作请致电")
			.append(AppConstantsUtil.getCustomerServicePhone());
		
		Map<String, String> paramMap = new HashMap<String, String>();
		openApiContext.setOpenApiUrl(AppConstantsUtil.getIndustrialApiUrl());
		//		if (Env.isOnline()) {
			openApiContext.setService(SMS_SERVICE);
			paramMap.put("operateType", "1");
			paramMap.put("mobile", mobileNumber);
			paramMap.put("templateName", bizCode.getTemplateName());
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("validateCode", code);
			jsonObject.put("ServicePhone", AppConstantsUtil.getCustomerServicePhone());
			paramMap.put("jsonParam", jsonObject.toJSONString());
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			resultBase.setSuccess(isSuccessStringSuccess(dataMap));
		//		} else {
		//			logger.info(sb.toString());
		//			resultBase.setSuccess(true);
		//		}
		
		return resultBase;
	}
	@Override
	public EsupplierBaseResult sendSmsText(String mobileNumber, String text,
												OpenApiContext openApiContext) {
		EsupplierBaseResult resultBase = new EsupplierBaseResult();
		if (!CommonUtil.checkMobile(mobileNumber)) {
			resultBase.setMessage("电话号码不正确");
			return resultBase;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		//"【中工惠康医疗产品】您的订单已支付成功,凭此短信优惠码7700可进行消费"
		Map<String, String> paramMap = new HashMap<String, String>();
		openApiContext.setOpenApiUrl(AppConstantsUtil.getIndustrialApiUrl());
		//if (Env.isOnline()) {

			openApiContext.setService(SMS_SERVICE);
			paramMap.put("operateType", "1");
			paramMap.put("mobile", mobileNumber);
			paramMap.put("content", text);
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			resultBase.setSuccess(isSuccessStringSuccessZ(dataMap));
	//	} else {
			logger.info(openApiContext.getOpenApiUrl());
			logger.info(sb.toString());
			resultBase.setSuccess(true);
	//	}
		
		return resultBase;
	}
	/**
	 * @param mobileNumber
	 * @param smsContent
	 * @param openApiContext
	 * @return
	 * @see com.yjf.esupplier.integration.openapi.SMSService#sendSMS(java.lang.String,
	 * java.lang.String,
	 * com.yjf.esupplier.integration.openapi.context.OpenApiContext)
	 */
	@Override
	public EsupplierBaseResult sendSMS(String mobileNumber, String smsContent,
										OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		EsupplierBaseResult resultBase = new EsupplierBaseResult();
		try {
			if (Env.isOnline()) {
				openApiContext.setPartnerId("20150204020003988490");
				openApiContext.setSecurityCheckKey("9c3f9ed1c9ec2e2136f2a2abd7c839c0");
				
			}
			openApiContext.setService(SMS_SERVICE);
			paramMap.put(PHONE_NOS, mobileNumber);
			paramMap.put(SMS_CTX, smsContent);
			paramMap.put(STRATEGY, "smsExpand");
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			resultBase.setSuccess(isSuccessStringSuccess(dataMap));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		
		return resultBase;
	}
	
	@Override
	public EsupplierBaseResult sendBroadcastSMS(String[] Allmoiles, String smsContent) {
		EsupplierBaseResult resultBase = new EsupplierBaseResult();
		try {
			List<String> allMoilesList = Lists.newArrayList(Allmoiles);
			List<String> subList = new ArrayList<String>();
			int totalpage = allMoilesList.size() / PER_AMOUNT;
			for (int i = 0; i <= totalpage; i++) {
				int beginRowNO = i * PER_AMOUNT;
				int endRowNO = i * PER_AMOUNT + PER_AMOUNT;
				if (endRowNO >= allMoilesList.size()) {
					endRowNO = allMoilesList.size();
				}
				subList = allMoilesList.subList(beginRowNO, endRowNO);
				logger.info("批量发送短信：第" + beginRowNO + "-" + endRowNO + "条");
				sendPerPageSMS(smsContent, subList);
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("message", "发送短信申请成功");
			resultMap.put("success", "true");
			resultBase.setSuccess(isSuccessStringSuccess(resultMap));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			resultBase.setMessage(e.getMessage());
			resultBase.setSuccess(false);
		}
		
		return resultBase;
	}
	
	private void sendPerPageSMS(String smsContent, List<String> subList) {
		
		if (subList.size() == 0 || subList.size() > PER_AMOUNT) {
			return;
		}
		
		PostmanClient client = new PostmanClient(SMS_SERVICE_URL, SMS_APPKEY, SMS_APPSECRET,
			SMS_ENV);
		final SmsSendRequest request = new SmsSendRequest();
		//设置子号码名称，子号码名称由信息中心分配，子号码名称对应子号码，短信通道需要子号码区别不同的签名。
		//设置了这个字段就明确了该条短信发出的签名
		//注意不能直接写成签名，需要写成信息中心分配的subCodeName:正常的，非祝福、邀请，广播类短信使用touziwuyou ;发送大量的广播类性质的短信使用touziwuyou_broadcast
		request.setSubCodeName(SUBCODE_NAME);
		//短信内容
		request.setContent(smsContent);
		//易极付全局GID
		request.setGid("DEVOPS234890234098");
		//短信模板名称，如果没有模板则以下不应该填写
		/*request.setTemplateName("yiji");
		Map<String,String> templateParams = Maps.newHashMap();
		templateParams.put("hello","world");
		templateParams.put("abc","efd");
		request.setTemplateParam(templateParams);*/
		//短信接收者
		request.setTo(subList);
		
		logger.info("准备发送短信，request:" + JSON.toJSONString(request));
		
		//调用客户端发送短信，带发送回调
		client.sendSms(request, new SmsSendCallback() {
			@Override
			public void doResult(SmsSendResponse smsSendResponse) {
				if (!smsSendResponse.isSuccess()) {
					logger.error("发送短信发生了错误，request:" + JSON.toJSONString(request) + ",response:"
									+ JSON.toJSONString(smsSendResponse));
				} else {
					logger.info("发送短信成功，request:" + JSON.toJSONString(request));
					
				}
			}
		});
		//注:如果不需要后续处理，可直接调用client.sendSms(request)即可。
	}
	
	@Override
	public synchronized void afterPropertiesSet() throws Exception {
		if (!isInit) {
			isInit = true;
			SMS_SERVICE_URL = sms_service_url;
			SMS_APPKEY = sms_appkey;
			SMS_APPSECRET = sms_appsecret;
			SMS_ENV = sms_env;
			SUBCODE_NAME = subcode_name;
		}
	}
}
