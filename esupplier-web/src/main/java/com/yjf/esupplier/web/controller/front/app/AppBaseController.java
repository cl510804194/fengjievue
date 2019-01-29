package com.yjf.esupplier.web.controller.front.app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.service.login.LoginService;
import com.yjf.esupplier.service.login.result.LoginResult;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.util.WebUtil;

/**
 * @name app访问入口
 * @author zhaohaibing
 * 
 * @date
 * */
@Controller
@RequestMapping("app")
public class AppBaseController extends AppChoiceFunction {
	
	@Autowired
	LoginService loginService;
	
	/**
	 * app统一入口
	 * @throws Exception
	 * */
	@ResponseBody
	@RequestMapping("{service}.htm")
	public JSONObject appService(@PathVariable String service, HttpServletRequest request,
									HttpSession session, HttpServletResponse response)
																						throws Exception {
		JSONObject json = new JSONObject();
		try {
			if (checkService(request, service, json)) {
				reqLog(request, service);
				goToFunction(request, session, response, service, json);
			}
			resultLog(json, service);
			//			if (StringUtil.equals(service, "depositResult")) {
			//				request.getRequestDispatcher(AppConstantsUtil.getHostHttpUrl() + "/app/userInfo.htm").forward(request, response);
			////				response.sendRedirect(AppConstantsUtil.getHostHttpUrl() + "/app/userInfo.htm?code="
			////										+ json.getInteger("code") + "&message="
			////										+ URLEncoder.encode(json.getString("message"), "utf-8"));
			//			}
		} catch (Exception e) {
			logger.error("app接口访问发生异常：serveice={},e={}", service, e);
			failResult(json, "服务器忙，稍后再试!");
		}
		
		return json;
		
	}
	
	/**
	 * 检查请求服务
	 * @return boolean
	 * */
	private boolean checkService(HttpServletRequest request, String service, JSONObject json) {
		if (!AppServiceEnum.isExist(service)) {
			json.put("code", "-2");
			json.put("message", "该服务[" + service + ".htm]不存在，请检查");
			return false;
		}
		return checkLogin(request, service, json);
	}
	
	/**
	 * 检测是否登录
	 * @return boolean
	 * */
	private boolean checkLogin(HttpServletRequest request, String service, JSONObject json) {
		if (ShiroSessionUtils.isLogin() || StringUtil.equals("login", service)
			|| StringUtil.equals("quickLogin", service)) {
			return true;
		}
		
		String equipmentNo = request.getParameter("equipmentNo");
		if (StringUtil.isNotBlank(equipmentNo)) {
			LoginResult loginResult = loginService.appEquipmentKeepLogin(request, equipmentNo);
			if (!loginResult.isSuccess()) {
				if (loginResult.isExist()) {
					json.put("code", -5);
					json.put("message", "您的账号在另一手机登录，您被迫下线");
				}else{
					json.put("code", -1);
					json.put("message", "未登录或登录失效");
				}
				return false;
			}
			return true;
		}
		if (AppServiceEnum.isNeedLogin(service)) {
			json.put("code", -1);
			json.put("message", "未登录或登录失效");
			return false;
		}
		
		return true;
		
	}
	
	/** 入参日志 */
	private void reqLog(HttpServletRequest request, String service) {
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap = WebUtil.getRequestMap(request);
		logger.info("app接口请求入参：service={},des={},reqMap={}", service + ".htm",
			AppServiceEnum.getMsgByservice(service), reqMap);
	}
	
	/** 结果日志 */
	private void resultLog(JSONObject json, String service) {
		String jsonStr = json.toString();
		if (!AppServiceEnum.printResultLog(service) && (int) json.get("code") == 1) {
			jsonStr = "成功响应";
		}
		logger.info("app接口请求结果：service={},des={},json={},user={}", service + ".htm", AppServiceEnum
			.getMsgByservice(service), jsonStr,
			ShiroSessionUtils.getSessionLocal() != null ? ShiroSessionUtils.getSessionLocal()
				.getUserBaseId() : "未登录");
		
	}
}
