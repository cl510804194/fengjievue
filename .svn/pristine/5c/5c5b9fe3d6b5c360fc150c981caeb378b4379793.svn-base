package com.yjf.esupplier.web.util.wx;

/**
 * @FileName Sign.java
 * @Description
 * @Version 1.0
 * @Author liugy.
 * @Email changlu@yiji.com
 * @History <br>
 * <li>Author: liugy</li>
 * <li>Date: 2016-11-11</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.NumberUtil;

public class Sign {
	
	private static Map<String, Object>	tokenCacheMap;
										
	private static Map<String, Object>	ticketCacheMap;
										
	public static Map<String, Object> getAccessToken() {
		String get_access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
										+ AppConstantsUtil.getWeixinAppId() + "&secret="
										+ AppConstantsUtil.getWeixinAppSecret();
		if (tokenCacheMap == null|| tokenCacheMap.isEmpty()
			|| NumberUtil.parseLong(tokenCacheMap.get("createTimeTamp").toString())
				+ NumberUtil.parseLong(tokenCacheMap.get("expires_in").toString()) < NumberUtil
					.parseLong(create_timestamp())) {
			tokenCacheMap = UrlUtils.getUrl(get_access_token_url);
			String createTimeTamp = create_timestamp();
			tokenCacheMap.put("createTimeTamp", createTimeTamp);
//			if (tokenCacheMap != null) {
//				ticketCacheMap.clear();
//			}
		}
		return tokenCacheMap;
	}
	
	public static Map<String, Object> getTicket(String access_token) {
		String get_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
								+ access_token + "&type=jsapi";
		if (ticketCacheMap == null|| ticketCacheMap.isEmpty()
			|| NumberUtil.parseLong(ticketCacheMap.get("createTimeTamp").toString())
				+ NumberUtil.parseLong(ticketCacheMap.get("expires_in").toString()) < NumberUtil
					.parseLong(create_timestamp())) {
			ticketCacheMap = UrlUtils.getUrl(get_ticket_url);
			String createTimeTamp = create_timestamp();
			ticketCacheMap.put("createTimeTamp", createTimeTamp);
		}
		return ticketCacheMap;
	}
	
	public static Map<String, String> sign(String jsapi_ticket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";
		
		//注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket="+ jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp="
					+ timestamp + "&url=" + url;
		System.out.println(string1);
		
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);
		ret.put("appId", AppConstantsUtil.getWeixinAppId());
		
		return ret;
	}
	
	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}
	
	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}
	
	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
}