/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.client.mock.impl;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import com.yjf.esupplier.integration.openapi.client.mock.HttpSender;
import com.yjf.esupplier.integration.openapi.client.mock.HttpSenderBase;



/**
 * 
 * @Version 1.0
 *
 * @Author karott
 *
 * @Email chenlin@yiji.com
 *       
 * @History
 *<li>Author: karott</li>
 *<li>Date: 2012-12-5</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DefaultHttpSender extends HttpSenderBase implements HttpSender {
	
	@Override
	public HttpResponse get(HttpUriRequest request) {
		defaultClient = new DefaultHttpClient();
		HttpResponse response = null;
		
		try {
			response = defaultClient.execute(request);
		} catch (ClientProtocolException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		
		return response;
	}
	
	@Override
	public HttpResponse httpsPost(HttpUriRequest request) {
		defaultClient = wrapClient(new DefaultHttpClient());
		HttpResponse response = null;
		
		try {
			response = defaultClient.execute(request);
		} catch (ClientProtocolException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		
		return response;
	}
	
	@Override
	public HttpResponse post(HttpUriRequest request) {
		defaultClient = new DefaultHttpClient();
		HttpResponse response = null;
		
		try {
			response = defaultClient.execute(request);
		} catch (ClientProtocolException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		
		return response;
	}
	
	public HttpClient wrapClient(HttpClient base) {
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			X509TrustManager tm = new X509TrustManager() {
				
				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				
				@Override
				public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
												String authType) throws CertificateException {
				}
				
				@Override
				public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
												String authType) throws CertificateException {
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx);
			ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			ClientConnectionManager ccm = base.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			//设置要使用的端口，默认是443
			sr.register(new Scheme("https", ssf, 443));
			return new DefaultHttpClient(ccm, base.getParams());
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
	}
	
}
