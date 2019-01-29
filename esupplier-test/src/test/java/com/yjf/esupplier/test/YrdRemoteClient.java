package com.yjf.esupplier.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YrdRemoteClient {
	protected final Logger	logger	= LoggerFactory.getLogger(getClass());
	
	public String executeHttpRequestByGetType(String url, Map<String, String> keyValueMap) {
		HttpClient client = new HttpClient();
		StringBuffer sb = new StringBuffer(url);
		PostMethod postMethod = null;
		try {
			//设置请求参数 
			if (keyValueMap != null) {
				Iterator it = keyValueMap.entrySet().iterator();
				if (keyValueMap.size() > 0) {
					sb.append("?");
					while (it.hasNext()) {
						Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
						sb.append(entry.getKey() + "=" + entry.getValue() + "&");
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				
			}
			//postMethod = new PostMethod(sb.toString()); 
			postMethod = new PostMethod(url);
			//logger.debug("query uri ===============" + postMethod.getURI()); 
			if (keyValueMap != null) {
				Iterator it = keyValueMap.entrySet().iterator();
				if (keyValueMap.size() > 0) {
					while (it.hasNext()) {
						Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
						postMethod.setParameter(entry.getKey(), entry.getValue());
					}
				}
				
			}
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			//todo:设置超时时间 
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 200000);
			int statusCode = client.executeMethod(postMethod);
			if (statusCode != HttpStatus.SC_OK) {
				logger.info("request '" + url + "' failed,the status is not 200,status:"
							+ statusCode);
				System.out.println("http request error--code:" + statusCode);
				return "";
			}
			String responseBody = postMethod.getResponseBodyAsString();
			return responseBody;
		} catch (Exception e) {
			//logger.error("发生异常！请检查网络和参数", e); 
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		String url1 = "http://www.tzydb.com:8081/boot/lookup/121,119";
		//String url="http://ppm.yijifu.net:8607/yrd/gateWay.htm";
		String url = "http://127.0.0.1:8083/yrd/gateWay.htm";
		Map<String, String> reqParams = new HashMap<String, String>();
		//String inputStr = "service=doLogin&userName=tom20130323&password=asdf123";
		//String inputStr = "service=register&mobile=18680754156&userName=2355djackwollld&realName=tomKey&logPassword=asdf123&mail=cq_liuys67@163.com&certNo=500228198806076891&gender=1";
		//String inputStr = "service=appGetAllDistrictService";
		/**String inputStr = "service=inverstRecordService&pageSize=10&pageNo=1&startDate=2014-01-25&endDate=2014-02-08";
		String securityKey = "2r0e1g3i1s2t2e3d";
		
		byte[] data = securityKey.getBytes();
		byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
		AES aes = new AES(securityKey);
		String encriptData = aes.getEncrypt(inputStr);*/
		//String encriptData = AESCoder.encrypt(inputStr, securityKey);
		//byte[] content = Hex.decodeHex(encriptData.toCharArray());
		//String decodeData = AESCoder.decrypt(content, securityKey);
		//System.out.println(decodeData);
		/**	securityKey =(new BASE64Encoder()).encodeBuffer(encodedData);
			reqParams.put("securityKey", securityKey);
			reqParams.put("appKey", "6338CF87679AAA59B2107718C902F090");
			reqParams.put("encriptData", encriptData);*/
		
		while (true) {
			String httpResult = new YrdRemoteClient().executeHttpRequestByGetType(url1, reqParams);
		}
		
		//System.out.println("HTTP返回结果" + httpResult);
		
		//JSONObject result = JSONObject.parseObject(httpResult);
		//		String resSecurityKey = result.getString("securityKey");
		//		String sign = result.getString("sign");
		//		byte[] resEncodedData = (new BASE64Decoder()).decodeBuffer(resSecurityKey);
		// 验证签名
		//		boolean status = RSACoder.verify(resEncodedData, publicKey, sign);
		
		//		System.out.println("验证签名"+ status);
	}
}
