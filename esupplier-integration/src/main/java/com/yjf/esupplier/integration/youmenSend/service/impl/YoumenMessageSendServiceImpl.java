package com.yjf.esupplier.integration.youmenSend.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.integration.youmenSend.order.YoumengSendOrder;
import com.yjf.esupplier.integration.youmenSend.order.aps;
import com.yjf.esupplier.integration.youmenSend.order.body;
import com.yjf.esupplier.integration.youmenSend.order.payload;
import com.yjf.esupplier.integration.youmenSend.order.policy;
import com.yjf.esupplier.integration.youmenSend.order.youmengOrder;
import com.yjf.esupplier.integration.youmenSend.result.YoumengSendResult;
import com.yjf.esupplier.integration.youmenSend.service.YoumenMessageSendService;
import com.yjf.esupplier.ws.service.YrdResultEnum;

@Service("YoumenMessageSendService")
public class YoumenMessageSendServiceImpl implements YoumenMessageSendService {
	private static final Logger logger = LoggerFactory.getLogger(YoumenMessageSendService.class);
	private final String sendUrl = "http://msg.umeng.com/api/send";
	private final String cancelUrl = "http://msg.umeng.com/api/cancel";
	/** 推送用户ID推送字段名称 */
	private final String userId = "userId";
	/** 是否播放语音推送字段名称 */
	private final String voice = "voice";
	/*特殊参数替换*/
	private final static Map<String, String> androidParamMap = new HashMap<String, String>();
	private final static Map<String, String> iosParamMap = new HashMap<String, String>();
	static {
		iosParamMap.put("contentAvailable", "content-available");
	}
	
	@Override
	public YoumengSendResult send(youmengOrder order) {
		YoumengSendResult result = new YoumengSendResult();
		try {
			order.orderCheck();
			YoumengSendOrder sendOrder = new YoumengSendOrder();
			initOrder(sendOrder, order);
			JSONObject json = new JSONObject();
			json.put(userId, order.getUserId());
			json.put(voice, order.getVoice());
			String appMasterSecret = initKey(sendOrder, "android", json);
			String jsonStr = JSONObject.toJSONString(sendOrder);
			/*特殊参数替换*/
			for (Map.Entry<String, String> entry : androidParamMap.entrySet()) {
				jsonStr = jsonStr.replace("\"" + entry.getKey() + "\":", "\"" + entry.getValue() + "\":");
			}
			YoumengSendResult androidSend = sendMessage(result, sendUrl, jsonStr, appMasterSecret);
			if (!androidSend.isSuccess()) {
				result.setMessage("android消息推送失败:error_code=" + androidSend.getError_code());
				logger.info("android向友盟发送失败error_code={}", androidSend.getError_code());
				//调取消方法
				cancel(androidSend.getTask_id(), "android");
				return result;
			}
			result.setAndroidSend(true);
			appMasterSecret = initKey(sendOrder, "ios", json);
			jsonStr = JSONObject.toJSONString(sendOrder);
			/*特殊参数替换*/
			for (Map.Entry<String, String> entry : iosParamMap.entrySet()) {
				jsonStr = jsonStr.replace("\"" + entry.getKey() + "\":", "\"" + entry.getValue() + "\":");
			}
			YoumengSendResult iosSend = sendMessage(result, sendUrl, jsonStr, appMasterSecret);
			if (!iosSend.isSuccess()) {
				result.setMessage("ios消息推送失败:error_code=" + iosSend.getError_code());
				logger.info("ios向友盟发送失败error_code={}，开始取消android已发送消息", iosSend.getError_code());
				//调取消方法
				cancel(iosSend.getTask_id(), "ios");
				return result;
			}
			result.setIosSend(true);
			result.setSuccess(true);
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setYrdResultEnum(YrdResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setYrdResultEnum(YrdResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		
		return result;
	}
	
	@Override
	public YoumengSendResult cancel(String taskId, String type) {
		YoumengSendResult result = new YoumengSendResult();
		try {
			logger.info("调用取消推送接口开始：taskId={}", taskId);
			JSONObject json = new JSONObject();
			json.put("task_id", taskId);
			json.put("timestamp", Integer.toString((int) (System.currentTimeMillis() / 1000)));
			String appMasterSecret = initKey(null, type, json);
			result = sendMessage(result, cancelUrl, json.toJSONString(), appMasterSecret);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
	private String initKey(YoumengSendOrder sendOrder, String types, JSONObject json) {
		String appkey = "";
		String appMasterSecret = "";
		try {
			if (StringUtil.equals("android", types)) {
				String[] arrStr = StringUtil.split(AppConstantsUtil.getAndroidYmKey(), "&");
				appkey = arrStr[0];
				appMasterSecret = arrStr[1];
			} else {
				String[] arrStr = StringUtil.split(AppConstantsUtil.getIosYmKey(), "&");
				appkey = arrStr[0];
				appMasterSecret = arrStr[1];
				String alert = sendOrder.getPayload().getBody().getText();
				aps aps = new aps();
				aps.setAlert(alert);
				sendOrder.getPayload().setUserId(json.getString(userId));
				sendOrder.getPayload().setVoice(json.getString(voice));
				sendOrder.getPayload().setAps(aps);
				sendOrder.getPayload().setBody(null);
				sendOrder.getPayload().setDisplay_type(null);
			}
		} catch (Exception e) {
			logger.error("推送系统参数未配置，会导致推送失败");
		}
		if (sendOrder != null) {
			sendOrder.setAppkey(appkey);
		}
		if (json != null) {
			json.put("appkey", appkey);
		}
		return appMasterSecret;
	}
	
	private void initOrder(YoumengSendOrder sendOrder, youmengOrder order) {
		Map<String, String> custom = new HashMap<>();
		custom.put(userId, order.getUserId());
		custom.put(voice, order.getVoice());
		policy policy = new policy();
		policy.setOut_biz_no("" + (new Date()).getTime());
		policy.setStart_time(order.getStart_time());
		policy.setExpire_time(order.getExpire_time());
		sendOrder.setPolicy(policy);
		
		payload payload = new payload();
		body body = new body();
		body.setTitle(order.getTitle());
		body.setText(order.getText());
		body.setTicker(order.getTicker());
		body.setCustom(custom);
		payload.setBody(body);
		if (StringUtil.equals(order.getDisplayType(), "message")) {
			payload.setDisplay_type("message");
		}
		sendOrder.setPayload(payload);
		String production_mode = "true";
//		if (Env.isTest()) {
		//			production_mode = "false";
//		}
		sendOrder.setProduction_mode(production_mode);
		sendOrder.setDevice_tokens(order.getDevice_tokens());
		sendOrder.setTimestamp(Integer.toString((int) (System.currentTimeMillis() / 1000)));
		sendOrder.setDescription(AppConstantsUtil.getProductName() + "消息推送");
		
	}
	
	public YoumengSendResult sendMessage(	YoumengSendResult sendResult, String url, String jsonStr,
											String appMasterSecret) throws Exception {
		
		try {
			HttpClient client = new DefaultHttpClient();
			String sign = DigestUtils
				.md5Hex(("POST" + url + jsonStr + appMasterSecret).getBytes("utf8"));
			url = url + "?sign=" + sign;
			logger.info("调用友盟接口开始：url={},jsonStr={}", url, jsonStr);
			HttpPost post = new HttpPost(url);
			post.setHeader("User-Agent", "Mozilla/5.0");
			StringEntity se = new StringEntity(jsonStr, "UTF-8");
			post.setEntity(se);
			HttpResponse response = client.execute(post);
			int status = response.getStatusLine().getStatusCode();
			BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			logger.info("调用友盟接口结束：result={},status={}", result.toString(), status);
			if (status == 200) {
				sendResult.setSuccess(true);
				JSONObject json = JSONObject.parseObject(result.toString());
				JSONObject dataJson = (JSONObject) json.get("data");
				String taskId = (String) dataJson.get("task_id");
				sendResult.setTask_id(StringUtil.isBlank(sendResult.getTask_id()) ? taskId
					: sendResult.getTask_id() + "&" + taskId);
			} else {
				sendResult.setSuccess(false);
				JSONObject json = JSONObject.parseObject(result.toString());
				JSONObject dataJson = (JSONObject) json.get("data");
				
				String error_code = (String) dataJson.get("error_code");
				sendResult.setError_code(error_code);
			}
		} catch (Exception e) {
			logger.error("调友盟接口异常", e);
		}
		return sendResult;
	}
	
}
