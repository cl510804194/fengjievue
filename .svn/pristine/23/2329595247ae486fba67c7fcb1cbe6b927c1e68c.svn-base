/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.web.interceptor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.util.WebSessionUtil;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;

/**
 * 
 * @Filename LoginInterceptorAdapter.java
 * 
 * @Description 登录拦截器
 * 
 * @Version 1.0
 * 
 * @Author peigen
 * 
 * @Email peigen@yiji.com
 * 
 * @History
 * <li>Author: peigen</li>
 * <li>Date: 2012-5-30</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@SuppressWarnings("unused")
public class LoginInterceptorAdapter implements HandlerInterceptor {
	
	String ignoreUrlStr = "";
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 正则${:}
	 */
	protected static Pattern pattern = Pattern
		.compile("\\$\\{[a-zA-Z0-9.]{1,}:[a-zA-Z0-9.]{1,}\\}");
	/**
	 * 权限验证器
	 */
	protected DefaultWebAppAuthorityVerifier webAppAuthorityVerifier = new DefaultWebAppAuthorityVerifier();
	
	protected static final String DEDUCT_OPERATE = "/deduct/*";
	
	private static final String[] urls = {	"/bank/", "/anon/", "/resources/", "/styles/",
											"/mobile/", "/app/", "/openApi/", "/pic/",
											"/admin/upload/", "/front/platform/",
											"/admin/nopermission.htm", "/admin/basedata/",
											"/index.htm", "/login/", "/PasswordManage/",
											"/security/", "/admin/login.htm", "/admin/loginout.htm",
											"/error.htm", "/admin/updateGoto.htm",
											"/admin/updateUserPassword.htm","/front/anon/bannerImage.htm","/website/" };
											
	/**
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(	HttpServletRequest request, HttpServletResponse response,
								Object handler) throws Exception {
								
		String uri = request.getServletPath();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		for (String s : urls) {
			if (uri.startsWith(s)) {
				return true;
			}
		}
		String newUrl = uri;
		if (uri.indexOf("?") > 0) {
			newUrl = newUrl.substring(0, uri.indexOf("?"));
		}
		if (newUrl.endsWith(".json")) {
			return true;
		}
		if (webAppAuthorityVerifier.checkPermission(request)) {
			Pattern p = Pattern.compile(DEDUCT_OPERATE.replace("*", ".*").replace("?", "\\?"));
			Matcher matcher = p.matcher(uri);
			if (matcher.matches()) {
				SessionLocal local = ShiroSessionUtils.getSessionLocal();
				if (local != null) {
					if (uri.indexOf("/seller/") >= 0) {
						if (local.getUserBizType() == UserBizTypeEnum.SELLER) {
							return true;
						} else {
							response.sendRedirect("error.htm");
						}
					} else {
						return true;
					}
					
				} else {
					String backOperate = webAppAuthorityVerifier.getBackOperate(request);
					if (backOperate == null || backOperate.length() < 1) {
						backOperate = webAppAuthorityVerifier.getDefault();
					}
					response.sendRedirect(backOperate);
				}
			} else {
				SessionLocal local = ShiroSessionUtils.getSessionLocal();
				if (local != null) {
					if (uri.indexOf("/seller/") >= 0) {
						if (local.getUserBizType() == UserBizTypeEnum.SELLER) {
							return true;
						} else {
							response.sendRedirect("error.htm");
						}
					} else {
						return true;
					}
					
				}
			}
		} else {
			String backOperate = webAppAuthorityVerifier.getBackOperate(request);
			if (backOperate == null || backOperate.length() < 1) {
				backOperate = webAppAuthorityVerifier.getDefault();
			}
			response.sendRedirect(backOperate);
		}
		return true;
	}
	
	/**
	 * @param request
	 * @param userInfo
	 */
	private boolean validateUserType(HttpServletRequest request, UserInfo userInfo) {
		return true;
	}
	
	/**
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(	HttpServletRequest request, HttpServletResponse response, Object handler,
							ModelAndView modelAndView) throws Exception {
		try {
			if (modelAndView != null && modelAndView.getModelMap() != null) {
				modelAndView.getModelMap().put("sessionLocal", ShiroSessionUtils.getSessionLocal());
				modelAndView.getModelMap().put("sessionID", request.getSession().getId());
				/*登录方式：前台登录、后台登录*/
				String loginModel = (String) ShiroSessionUtils.getSessionValue("loginModel");
				/*因为存在购物车信息，不能因为登陆人去砍掉购物车缓存：照成admin在前端页面登陆显示*/
				modelAndView.getModelMap().put("webSessionUtil", new WebSessionUtil(ShiroSessionUtils.getSessionLocal()));
				modelAndView.getModelMap().put("sessionScope",
						ShiroSessionUtils.getSessionLocal());
			}
			//			if (ShiroSessionUtils.getSessionLocal() != null
			//				&& ShiroSessionUtils.getSessionLocal().getUserId() != null) {
			//			}
			//			response.setHeader("Pragma", "no-cache");
			//			response.addHeader("Cache-Control", "must-revalidate");
			//			response.addHeader("Cache-Control", "no-cache");
			//			response.addHeader("Cache-Control", "no-store");
			//			response.setDateHeader("Expires", 0);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object handler, Exception ex) throws Exception {
								
	}
	
	public void setIgnoreUrlStr(String ignoreUrlStr) {
		this.ignoreUrlStr = ignoreUrlStr;
	}
	
}
