package com.yjf.esupplier.integration.openapi.result;

import com.yjf.common.lang.util.money.Money;

import java.util.HashMap;
import java.util.Map;

public class WxPayResult extends OpenApiResult {
	
	private static final long serialVersionUID = 5709049977447700386L;
	String returnUrl;
	Map<String, String> map = new HashMap<String, String>();

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}
	
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("WxPayResult{");
		sb.append("returnUrl='").append(returnUrl).append('\'');
		sb.append(", map=").append(map);
		sb.append('}');
		return sb.toString();
	}

}
