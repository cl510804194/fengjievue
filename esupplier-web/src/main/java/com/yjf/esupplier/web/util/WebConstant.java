package com.yjf.esupplier.web.util;

import com.yjf.esupplier.common.util.AppConstantsUtil;

public class WebConstant {
	
	public static String getYjfloginurl() {
		return AppConstantsUtil.getYjfUrl() + "/anon/oauth/index.htm?redirect="
				+ AppConstantsUtil.getHostHttpUrl() + "/openApi/yjfLogin.htm&registerUrl="
				+ AppConstantsUtil.getHostHttpUrl() + "/anon/investorsOpen.htm";
	}
	
	public static String getYjfloginIframeUrl() {
		return AppConstantsUtil.getYjfUrl() + "/anon/oauth/index.htm?redirect="
				+ AppConstantsUtil.getHostHttpUrl() + "/openApi/yjfIframeLogin.htm&registerUrl="
				+ AppConstantsUtil.getHostHttpUrl() + "/anon/investorsOpen.htm";
	}
	
	public static String getYjfregisterurl() {
		return AppConstantsUtil.getYjfUrl() + "/anon/oauth/index.htm?redirect="
				+ AppConstantsUtil.getHostHttpUrl() + "/openApi/yjfLogin.htm&registerUrl="
				+ AppConstantsUtil.getHostHttpUrl() + "/anon/investorsOpen.htm";
	}
	
	public static final String SESSION_KEY_PRE_PAGE_URL = "SESSION_KEY_PRE_PAGE_URL";
	public static final String SESSION_KEY_REDIRECT_URL = "redirect";
	
}
