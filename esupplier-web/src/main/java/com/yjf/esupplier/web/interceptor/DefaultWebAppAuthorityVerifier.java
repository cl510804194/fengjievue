package com.yjf.esupplier.web.interceptor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import rop.thirdparty.com.google.common.collect.Lists;

import com.yjf.esupplier.service.security.impl.AuthorityServiceImpl;
import com.yjf.esupplier.service.security.info.PermissionInfo;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;

/**
 * 
 * 
 * @Filename DefaultWebAppAuthorityVerifier.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author yhl
 * 
 * @Email yhailong@yiji.com
 * 
 * @History <li>Author: yhl</li> <li>Date: 2013-6-8</li> <li>Version: 1.0</li>
 * <li>Content: create</li> 默认的web应用权限验证器
 */
public class DefaultWebAppAuthorityVerifier {
	
	/**
	 * 正则${:}
	 */
	protected static Pattern pattern = Pattern
		.compile("\\$\\{[a-zA-Z0-9.]{1,}:[a-zA-Z0-9.]{1,}\\}");
	
	public boolean checkPermission(HttpServletRequest request) {
		String uri = request.getServletPath();
		return checkPermission(uri);
	}
	
	public String getBackOperate(HttpServletRequest request) {
		String uri = request.getServletPath();
		String backOperate = getBackOperate(uri);
		return analyze(backOperate, request);
	}
	
	public String getDefault() {
		return "/index.htm";
	}
	
	/**
	 * 解析回执操作的URL
	 * @param backOperate
	 * @return
	 */
	private String analyze(String backOperate, HttpServletRequest request) {
		String temp = backOperate;
		int index = temp.indexOf('?');
		if (index == -1) {
			return temp;
		}
		Matcher matcher = null;
		while ((matcher = pattern.matcher(temp)).find()) {
			temp = matcher.replaceFirst(build(matcher.group(), request));
		}
		return temp;
	}
	
	/**
	 * 获取回执操作的url
	 * @return
	 */
	private String getBackOperate(String uri) {
		List<PermissionInfo> permissons = AuthorityServiceImpl.getAllPermissions();
		for (PermissionInfo permission : permissons) {
			if (match(uri, permission)) {
				return permission.getPermissionCallback();
			}
		}
		return "";
	}
	
	/**
	 * 验证权限
	 * @return
	 */
	private boolean checkPermission(String uri) {
		List<PermissionInfo> permissons = getPermission();
		for (PermissionInfo permission : permissons) {
			if (match(uri, permission)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<PermissionInfo> getPermission() {
		List<PermissionInfo> permissons = Lists.newArrayList();
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal != null && sessionLocal.getUserId() != null
			&& sessionLocal.getUserId() > 0) {
			permissons = sessionLocal.getPermissions();
		} else {
			permissons = AuthorityServiceImpl.getPulicPermissions();
		}
		return permissons;
	}
	
	/**
	 * 匹配
	 * @param uri
	 * @param permission
	 * @return
	 */
	private boolean match(String uri, PermissionInfo permission) {
		Pattern p = Pattern.compile(permission.getPermissionOperate().replace("*", ".*")
			.replace("?", "\\?"));
		Matcher matcher = p.matcher(uri);
		return matcher.matches();
	}
	
	/**
	 * 根据el表达式构造参数
	 * @param el ${}
	 * @param request
	 * @return
	 */
	private String build(String el, HttpServletRequest request) {
		String temp = el.substring(2, el.length() - 1);
		String[] s = temp.split(":");
		return s[0] + "=" + getValue(s[1], request);
	}
	
	/**
	 * 获取值
	 * @param key
	 * @param request
	 * @return
	 */
	private String getValue(String key, HttpServletRequest request) {
		if (key.equalsIgnoreCase("RequestURL")) {
			return request.getRequestURL().toString();
		} else if (key.equalsIgnoreCase("RequestURI")) {
			return request.getRequestURI();
		} else if (key.equalsIgnoreCase("ServletPath")) {
			return request.getServletPath();
		} else {
			String value = request.getParameter(key);
			if (value != null) {
				return value;
			} else {
				return "";
			}
		}
	}
}
