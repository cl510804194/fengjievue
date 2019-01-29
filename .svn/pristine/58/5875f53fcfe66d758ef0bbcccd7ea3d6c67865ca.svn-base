package com.yjf.esupplier.web.controller.base;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjf.common.lang.util.StringUtil;

/**
 * 
 *                       
 * @Filename LogInterceptor.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author yhl
 *
 * @Email yhailong@yiji.com
 *       
 * @History
 *<li>Author: yhl</li>
 *<li>Date: 2013-7-11</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 * 日志拦截器
 */
public class LogInterceptor implements HandlerInterceptor {
	
	private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURL().toString();
		if(url.contains("/resources/") || url.contains("/mobile/")){
			return true;
		}
		StringBuilder stringBuilder = new StringBuilder("http请求URL：" + url + "，传入参数：{");
		Enumeration<String> names = request.getParameterNames();
		int count = 0;
		while(names.hasMoreElements()){
			String name = names.nextElement();
			if (StringUtil.isNotEmpty(name) && name.toLowerCase().indexOf("password") > -1) {
				continue;
			}
			String[] values = request.getParameterValues(name);
			if(count > 0){
				stringBuilder.append(",");
			}
			stringBuilder.append(name + "=[");
			for (int i = 0; i < values.length; i++) {
				if(i > 0){
					stringBuilder.append(",");
				}
				stringBuilder.append(values[i]);
			}
			stringBuilder.append("]");
			count++;
		}
		stringBuilder.append("}");
		logger.info(stringBuilder.toString());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
