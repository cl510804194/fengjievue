package com.yjf.esupplier.web.controller.front.api;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.service.base.OpenApiBaseContextServiceBase;

/**
 * 真美美接口功能入口
 * */
public class GxtApiBaseFunction extends OpenApiBaseContextServiceBase {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//TODO 功能待完善
	
	/** 景区和商户信息同步 */
	protected void synMerchantInfo(HttpServletRequest request, JSONObject json, String string) {
		defaultResult(json);
	}
	
	/** 会员信息同步 */
	protected void synCustomerInfo(HttpServletRequest request, JSONObject json, String string) {
		defaultResult(json);
	}
	
	/** 交易信息同步 */
	protected void synTradeInfo(HttpServletRequest request, JSONObject json, String string) {
		defaultResult(json);
	}
	
	/** 密码同步 */
	protected void synPwdInfo(HttpServletRequest request, JSONObject json, String string) {
		defaultResult(json);
	}
	
	/** 通用成功返回 */
	@SuppressWarnings("unchecked")
	protected void successResult(JSONObject json, String mes) {
		json.put("success", false);
		json.put("resultMessage", StringUtil.defaultIfBlank(mes, "操作成功"));
	}
	
	/** 通用失败返回信息 */
	@SuppressWarnings("unchecked")
	protected void failResult(JSONObject json, String mes) {
		json.put("success", true);
		json.put("resultMessage", StringUtil.defaultIfBlank(mes, "操作失败"));
	}
	
	/** 通用默认返回信息 */
	@SuppressWarnings("unchecked")
	protected void defaultResult(JSONObject json) {
		json.put("success", false);
		json.put("resultMessage", "功能开发中...");
	}
	
}
