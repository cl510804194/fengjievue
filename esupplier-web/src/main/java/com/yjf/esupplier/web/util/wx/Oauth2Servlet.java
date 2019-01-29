package com.yjf.esupplier.web.util.wx;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjf.common.env.Env;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.AppConstantsUtil;

/**
 * 
 * 接口权限中设置 授权访问的URL
 */
public class Oauth2Servlet {
	
	/** 普通日志 */
	private static final Logger logger = LoggerFactory.getLogger(Oauth2Servlet.class);
	
	public static void toWeChat(HttpServletRequest request, HttpServletResponse response)
																							throws IOException {
		String get_code_url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
								+ "appid=APPID" + "&redirect_uri=REDIRECT_URI"
								+ "&response_type=code" + "&scope=snsapi_base"
								+ "&state=STATE#wechat_redirect";
		//TODO 修改访问地址						
		//		String returnUrl = "http://test.cqbornsoft.com/app/doWxInfo.htm";
		String returnUrl = "http://test.cqbornsoft.com/app/weixinLogin.htm";
		if (Env.isOnline()) {
			returnUrl = "http://www.cnglasswindow.com/app/weixinLogin.htm";
			//			returnUrl = "http://www.cnglasswindow.com/app/doWxInfo.htm";
		}
		get_code_url = get_code_url.replace("APPID", AppConstantsUtil.getWeixinAppId());
		get_code_url = get_code_url.replace("REDIRECT_URI", URLEncoder.encode(returnUrl, "UTF-8"));
		
		response.sendRedirect(get_code_url);
		
	}
	
	public static Map<String, Object> getOpenIdByCode(HttpServletRequest request,
														HttpServletResponse response)
																						throws ServletException,
																						IOException {
		String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
										+ "appid=APPID" + "&secret=SECRET&"
										+ "code=CODE&grant_type=authorization_code";
		
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		
		get_access_token_url = get_access_token_url.replace("APPID",
			AppConstantsUtil.getWeixinAppId());
		get_access_token_url = get_access_token_url.replace("SECRET",
			AppConstantsUtil.getWeixinAppSecret());
		get_access_token_url = get_access_token_url.replace("CODE", code);
		
		logger.info("CODE", code);
		
		Map<String, Object> returnDataMap = UrlUtils.getUrl(get_access_token_url);
		
		String access_token = (String) returnDataMap.get("access_token");
		String openid = (String) returnDataMap.get("openid");
		request.getSession().setAttribute("access_token", access_token);
		request.getSession().setAttribute("openid", openid);
		
		logger.info("微信token{}", returnDataMap);
		return returnDataMap;
	}
	
	public static Map<String, Object> getInfoByCode(HttpServletRequest request,
													HttpServletResponse response)
																					throws ServletException,
																					IOException {
		String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
										+ "appid=APPID" + "&secret=SECRET&"
										+ "code=CODE&grant_type=authorization_code";
		String get_userinfo = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		
		get_access_token_url = get_access_token_url.replace("APPID",
			AppConstantsUtil.getWeixinAppId());
		get_access_token_url = get_access_token_url.replace("SECRET",
			AppConstantsUtil.getWeixinAppSecret());
		get_access_token_url = get_access_token_url.replace("CODE", code);
		
		logger.info("CODE", code);
		
		Map<String, Object> returnDataMap = UrlUtils.getUrl(get_access_token_url);
		
		String access_token = (String) returnDataMap.get("access_token");
		String openid = (String) returnDataMap.get("openid");
		request.getSession().setAttribute("access_token", access_token);
		request.getSession().setAttribute("openid", openid);
		
		logger.info("微信token{}", returnDataMap);
		
		get_userinfo = get_userinfo.replace("ACCESS_TOKEN", access_token);
		get_userinfo = get_userinfo.replace("OPENID", openid);
		Map<String, Object> userInfoMap = UrlUtils.getUrl(get_userinfo);
		logger.info("微信用户信息{}", userInfoMap);
		return userInfoMap;
	}
	
}
