package com.yjf.esupplier.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.web.interceptor.DefaultWebAppAuthorityVerifier;
import com.yjf.esupplier.web.util.WebConstant;

public class RequestLogFilter implements Filter {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void destroy() {
		
	}
	
	protected DefaultWebAppAuthorityVerifier webAppAuthorityVerifier = new DefaultWebAppAuthorityVerifier();
	
	private static final String[] urls = { "/resources/", "/mobile/", "/favicon.ico", "/styles/",
											"/login/" };
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
																						throws IOException,
																						ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String uri = request.getServletPath();
		
		for (String s : urls) {
			if (uri.startsWith(s)) {
				chain.doFilter(request, response);
				return;
			}
		}
		logger.info("请求的URI:" + uri);
		if (uri.equals("/index.htm") || uri.equals("/index.html") || uri.equals("//index.htm")) {
			response.sendRedirect("/login/login.htm");
			return;
		}
		if (uri.equals("/backstage/nopermission")) {
			request.getSession().removeAttribute(WebConstant.SESSION_KEY_PRE_PAGE_URL);
			response.sendRedirect("/admin/login.htm");
			return;
		}
		String newUrl = uri;
		if (uri.indexOf("?") > 0) {
			newUrl = newUrl.substring(0, uri.indexOf("?"));
		}
		if (newUrl.endsWith(".htm") && !uri.equals("/front/platform/mall/redirctIndex.htm")) {
			request.getSession().setAttribute(WebConstant.SESSION_KEY_PRE_PAGE_URL, uri);
		} else if (uri.equals("/front/platform/mall/redirctIndex.htm")) {
			String oldUrl = (String) request.getSession().getAttribute(
				WebConstant.SESSION_KEY_PRE_PAGE_URL);
			if (oldUrl != null) {
				if (oldUrl.indexOf("/do/scenic/") > -1) {
					response.sendRedirect("/login/login.htm");
				} else if (oldUrl.indexOf("/admin/") > -1) {
					request.getSession().removeAttribute(WebConstant.SESSION_KEY_PRE_PAGE_URL);
					response.sendRedirect("/admin/login.htm");
				} else if (oldUrl.indexOf("/do/") > -1) {
					response.sendRedirect("/login/frontLogin.htm");
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder("http请求URL：" + uri + "，传入参数：{");
		Enumeration<String> names = request.getParameterNames();
		int count = 0;
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			if (StringUtil.isNotEmpty(name) && name.toLowerCase().indexOf("password") > -1) {
				continue;
			}
			String[] values = request.getParameterValues(name);
			if (count > 0) {
				stringBuilder.append(",");
			}
			stringBuilder.append(name + "=[");
			for (int i = 0; i < values.length; i++) {
				if (i > 0) {
					stringBuilder.append(",");
				}
				if (values[i].length() <= 50)
					stringBuilder.append(values[i]);
			}
			stringBuilder.append("]");
			count++;
		}
		stringBuilder.append("}");
		logger.info(stringBuilder.toString());
		if (StringUtil.isNotBlank(request.getParameter("leftMemberOrder"))) {
			request.getSession().setAttribute("leftMemberOrder",
				request.getParameter("leftMemberOrder"));
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}
}
