/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.client.mock;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

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
public interface HttpSender {
	
	HttpResponse get(HttpUriRequest request);
	
	HttpResponse post(HttpUriRequest request);
	
	HttpResponse httpsPost(HttpUriRequest request);
}
