package com.yjf.esupplier.web.controller.front.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.common.util.SignUtil;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.web.util.WebUtil;

@Controller
@RequestMapping("openApi")
public class GxtBaseController extends GxtApiBaseFunction {
	
	@ResponseBody
	@RequestMapping("{service}")
	public JSONObject gxtApi(HttpServletRequest request, @PathVariable String service) {
		JSONObject json = new JSONObject();
		if (checkService(request, service, json)) {
			function(request, service, json);
		}
		resultLog(json, service);
		return json;
	}
	
	/**
	 * 检查请求服务
	 * @return boolean
	 * */
	@SuppressWarnings("unchecked")
	private boolean checkService(HttpServletRequest request, String service, JSONObject json) {
		Map<String, String> param = WebUtil.getRequestMap(request);
		reqLog(param, service);
		if (!GxtApiEnum.isExist(service)) {
			json.put("success", false);
			json.put("resultMessage", "该服务[" + service + "]不存在，请检查服务名");
			return false;
		}
		OpenApiContext openApiContext = getOpenApiContext();
		if (!SignUtil.validateSign(param, openApiContext.getSecurityCheckKey(),
			openApiContext.getSignType())) {
			json.put("success", false);
			json.put("resultMessage", "验证签名失败");
			return false;
		}
		return true;
		
	}
	
	/** 接口功能选择 */
	private void function(HttpServletRequest request, String service, JSONObject json) {
		switch (service) {
			case "synMerchantInfo":
				synMerchantInfo(request, json, "景区和商户信息同步");
				break;
			case "synCustomerInfo":
				synCustomerInfo(request, json, "会员信息同步");
				break;
			case "synTradeInfo":
				synTradeInfo(request, json, "交易信息同步");
				break;
			case "synPwdInfo":
				synPwdInfo(request, json, "密码同步");
				break;
			default:
				defaultResult(json);
		}
	}
	
	/** 入参日志 */
	private void reqLog(Map<String, String> reqMap, String service) {
		logger.info("真美美接口请求入参：service={},des={},reqMap={}", service,
			GxtApiEnum.getMsgByCode(service), reqMap);
	}
	
	/** 结果日志 */
	private void resultLog(JSONObject json, String service) {
		logger.info("真美美接口请求结果：service={},des={},json={}", service,
			GxtApiEnum.getMsgByCode(service), json.toString());
		
	}
}
