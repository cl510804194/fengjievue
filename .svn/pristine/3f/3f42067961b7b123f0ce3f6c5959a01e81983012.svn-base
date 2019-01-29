package com.yjf.esupplier.web.util.wx;

import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.yjf.esupplier.common.util.MiscUtil;

/**
 * @FileName URLUtil.java
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
public class UrlUtils {
	
	public static Map<String, Object> getUrl(String url) {
		String result = null;
		try {
			// 根据地址获取请求
			HttpGet request = new HttpGet(url);
			// 获取当前客户端对象
			HttpClient httpClient = new DefaultHttpClient();
			// 通过请求对象获取响应对象
			HttpResponse response = httpClient.execute(request);
			
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MiscUtil.parseJSON(result);
	}
}
