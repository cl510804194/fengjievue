package com.yjf.esupplier.integration.openapi.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.yjf.common.lang.security.DigestUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.Constants;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.integration.openapi.client.mock.impl.DefaultHttpSender;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

public class OpenApiServiceBase {
	/** 普通日志 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected final Logger loggerAlert = LoggerFactory.getLogger("ALERT-APPENDER");
	protected DefaultHttpSender sender = new DefaultHttpSender();
	public final static String SUCCESS = "EXECUTE_SUCCESS";
	public final static String PROCESSING = "BIZ_PROCESSING";
	public final static String SUCCESS_VALUE = "success";
	public final static String SUCCESS_T = "T";
	public final static String SUCCESS_STRING = "true";
	public final static String RESULT_MESSAGE = "resultMessage";
	public final static String RESULT_CODE = "resultCode";
	/*退钱异步回调URI*/
	public final static String RESULT_URI = "/openApi/refundNotifyResult.htm";
	
	protected Map<String, Object> senderPost(Map<String, String> paramMap,
												OpenApiContext openApiContext) {
		Map<String, String> standardParamsMap = buildStandardParams(openApiContext);
		paramMap.putAll(standardParamsMap);
		clearNullVallue(paramMap);
		Map<String, String> postMap = digestParam(openApiContext, paramMap);
		if (logger.isInfoEnabled())
			logger.info("Open Api 入参数=" + postMap);
		HttpEntity entity = sender.producePostEntity(postMap, openApiContext.getInputCharset());
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			logger.info("短信地址url = " + openApiContext.getOpenApiUrl());
			HttpPost post = sender.buildHttpPost(openApiContext.getOpenApiUrl(), entity);
			
			HttpResponse response = sender.post(post);
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),
				"UTF-8"));
			String str = br.readLine();
			while (str != null) {
				sb.append(str);
				str = br.readLine();
			}
			
		} catch (Exception e) {
			logger.error("send openApi error", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("br close exception ", e);
				}
			}
		}
		Map<String, Object> returnDataMap = MiscUtil.parseJSON(sb.toString());
		return returnDataMap;
		
	}
	
	public String makeResposeUrl(Map<String, String> paramMap, OpenApiContext openApiContext,
									String otherField) {
		Map<String, String> standardParamsMap = buildStandardParams(openApiContext);
		paramMap.putAll(standardParamsMap);
		clearNullVallue(paramMap);
		Map<String, String> postMap = digestParam(openApiContext, paramMap);
		if (logger.isInfoEnabled())
			logger.info("Open Api 入参数=" + postMap);
		
		BufferedReader br = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(openApiContext.getOpenApiUrl()).append("?");
			StringBuffer sb1 = new StringBuffer();
			Iterator<Map.Entry<String, String>> iterator = postMap.entrySet().iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = iterator.next();
				if (i == 0) {
					if (StringUtil.isNotEmpty(otherField) && otherField.equals(entry.getKey())) {
						sb1.append(entry.getKey())
							.append("=")
							.append(
								URLEncoder.encode(entry.getValue(),
									openApiContext.getInputCharset()));
					} else {
						sb1.append(entry.getKey()).append("=").append(entry.getValue());
					}
					
				} else {
					if (StringUtil.isNotEmpty(otherField) && otherField.equals(entry.getKey())) {
						sb1.append("&")
							.append(entry.getKey())
							.append("=")
							.append(
								URLEncoder.encode(entry.getValue(),
									openApiContext.getInputCharset()));
					} else {
						sb1.append("&").append(entry.getKey()).append("=").append(entry.getValue());
					}
					
				}
				
				i++;
			}
			//sb.append(URLEncoder.encode(sb1.toString(), openApiContext.getInputCharset()));
			sb.append(sb1.toString());
			return sb.toString();
		} catch (Exception e) {
			logger.error("send openApi error", e);
		}
		return "";
		
	}
	
	public String makeResposeUrl(Map<String, String> paramMap, OpenApiContext openApiContext) {
		
		return makeResposeUrl(paramMap, openApiContext, null);
		
	}
	
	protected Map<String, Object> senderPostHttpsOnlyParam(String url) {
		
		if (logger.isInfoEnabled())
			logger.info("Open Api 入参数=" + url);
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			HttpGet getUrl = sender.buildHttpRequest(new URI(url));
			
			HttpResponse response = sender.httpsPost(getUrl);
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),
				"UTF-8"));
			String str = br.readLine();
			while (str != null) {
				sb.append(str);
				str = br.readLine();
			}
		} catch (Exception e) {
			logger.error("send openApi error", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("br close exception ", e);
				}
			}
		}
		Map<String, Object> returnDataMap = MiscUtil.parseJSON(sb.toString());
		return returnDataMap;
		
	}
	
	/**
	 * @param paramMap
	 */
	protected void clearNullVallue(Map<String, String> paramMap) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>(paramMap);
		for (Entry<String, String> entry : treeMap.entrySet()) {
			if (entry.getValue() == null) {
				paramMap.remove(entry.getKey());
			}
		}
	}
	
	protected Map<String, String> buildStandardParams(OpenApiContext openApiContext) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(Constants.ORDER_NO_KEY, openApiContext.getOpenApiBizNo());
		paramMap.put(Constants.SERVICE_TYPE_KEY, openApiContext.getService());
		paramMap.put(Constants.PARTNER_ID_KEY, openApiContext.getPartnerId());
		paramMap.put(Constants.CHARSET_KEY, openApiContext.getInputCharset());
		paramMap.put(Constants.SIGN_TYPE, openApiContext.getSignType().getName());
		return paramMap;
	}
	
	/**
	 * @param result
	 * @param dataMap
	 */
	protected void setReturnResult(EsupplierBaseResult result, Map<String, Object> dataMap) {
		result.setSuccess(isSuccess(dataMap));
		if (!result.isSuccess()) {
			result.setCreditsysResultEnum(EsupplierResultEnum.OPENAPI_ACCESS_FAILURE);
		}
		result.setMessage(getResultMessage(dataMap));
	}
	
	protected Map<String, String> digestParam(OpenApiContext openApiContext,
												Map<String, String> paramMap) {
		String sign = DigestUtil.digest(paramMap, openApiContext.getSecurityCheckKey(),
			openApiContext.getSignType());
		paramMap.put(DigestUtil.SIGN_KEY, sign);
		return paramMap;
	}
	
	protected boolean isSuccess(Map<String, Object> dataMap) {
		if (dataMap == null)
			return false;
		String resultCode = (String) dataMap.get(RESULT_CODE);
		String resultValue = String.valueOf(dataMap.get(SUCCESS_VALUE));
		if (resultCode != null
			&& (resultCode.indexOf(SUCCESS) > -1 || resultCode.equals(SUCCESS_VALUE)|| resultValue.equals(SUCCESS_STRING) || resultValue
				.equalsIgnoreCase(SUCCESS_T))) {
			logger.info("call open api success");
			return true;
		}
		return false;
	}
	
	protected boolean isSuccessStringSuccess(Map<String, Object> dataMap) {
		if (dataMap == null)
			return false;
		String success = String.valueOf(dataMap.get("success"));
		if (success != null
			&& (success.indexOf(SUCCESS_STRING) > -1 || success.indexOf(SUCCESS_T) > -1)) {
			logger.info("call open api success");
			return true;
		}
		return false;
	}
	
	protected boolean isSuccessStringSuccessZ(Map<String, Object> dataMap) {
		if (dataMap == null)
			return false;
		String success = String.valueOf(dataMap.get("success"));
		if (success != null && success.indexOf(SUCCESS_T) > -1) {
			logger.info("call open api success");
			return true;
		}
		return false;
	}
	
	protected String getResultMessage(Map<String, Object> dataMap) {
		if (dataMap == null)
			return null;
		
		if (dataMap.get(RESULT_MESSAGE) != null) {
			return (String) dataMap.get(RESULT_MESSAGE);
		} else {
			return (String) dataMap.get(RESULT_CODE);
		}
		
	}
	
	protected String getResultValue(Map<String, Object> dataMap, String key) {
		if (dataMap == null)
			return null;
		return (String) dataMap.get(key);
		
	}
	
	@SuppressWarnings("unchecked")
	protected String getResultValue(Map<String, Object> dataMap, String mapKey, String key) {
		if (dataMap == null)
			return null;
		Map<String, Object> tempMap = (Map<String, Object>) dataMap.get(mapKey);
		if (tempMap == null)
			return null;
		return (String) tempMap.get(key);
		
	}
	
	public String makeResposeUrlNotOpenApi(Map<String, String> paramMap, String url) {
		clearNullVallue(paramMap);
		if (logger.isInfoEnabled())
			logger.info("Open Api 入参数=" + paramMap);
		BufferedReader br = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(url).append("?");
			StringBuffer sb1 = new StringBuffer();
			Iterator<Map.Entry<String, String>> iterator = paramMap.entrySet().iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = iterator.next();
				
				if (i == 0)
					sb1.append(entry.getKey()).append("=").append(entry.getValue());
				else
					sb1.append("&").append(entry.getKey()).append("=").append(entry.getValue());
				i++;
			}
			sb.append(sb1.toString());
			return sb.toString();
		} catch (Exception e) {
			logger.error("send openApi error", e);
		}
		return "";
		
	}
	
	protected Map<String, Object> senderPostOnlyParam(String url) {
		
		if (logger.isInfoEnabled())
			logger.info("Open Api 入参数=" + url);
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			HttpGet getUrl = sender.buildHttpRequest(new URI(url));
			
			HttpResponse response = sender.get(getUrl);
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),
				"UTF-8"));
			String str = br.readLine();
			while (str != null) {
				sb.append(str);
				str = br.readLine();
			}
		} catch (Exception e) {
			logger.error("send openApi error", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("br close exception ", e);
				}
			}
		}
		Map<String, Object> returnDataMap = MiscUtil.parseJSON(sb.toString());
		return returnDataMap;
		
	}
}
