package com.yjf.esupplier.web.controller.openapi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.common.lang.ip.IPUtil;
import com.yjf.common.lang.security.DigestUtil.DigestALGEnum;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.common.util.BusinessNumberUtil;
import com.yjf.esupplier.common.util.CommonUtil;
import com.yjf.esupplier.common.util.IPAddressUtils;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.SignUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.dal.daointerface.UserLoginLogDAO;
import com.yjf.esupplier.dal.dataobject.UserLoginLogDO;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.service.bill.OrderRefundService;
import com.yjf.esupplier.service.bill.OrderService;
import com.yjf.esupplier.service.openapi.ReceiveOpenApiService;
import com.yjf.esupplier.service.openapi.result.YjfLoginResult;
import com.yjf.esupplier.service.pay.PayService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.controller.template.ControllerBizProcess;
import com.yjf.esupplier.web.util.AppCommonUtil;
import com.yjf.esupplier.web.util.WebConstant;
import com.yjf.esupplier.web.util.WebSessionUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.bill.order.ScanningQRcodeOrder;
import com.yjf.esupplier.ws.info.RechargeFlowInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

@Controller
public class OpenApiController extends BaseAutowiredController {
	
	@Autowired
	UserLoginLogDAO userLoginLogDAO;
	@Autowired
	ReceiveOpenApiService receiveOpenApiService;
	@Autowired
	PayService payService;
	
	@Autowired
	OrderRefundService refundService;
	@Autowired
	OrderService orderService;
	
	/**
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	protected void openApiReturnTemplate(HttpServletRequest request, HttpServletResponse response,
											ControllerBizProcess controllerBizProcess) {
		Map<String, String> param = WebUtil.getRequestMap(request);
		logger.info("进入openApiReturnTemplate的param方法!添加一条日志信息,入参: {}", param);
		EsupplierBaseResult result = new EsupplierBaseResult();
		if (controllerBizProcess != null) {
			result = controllerBizProcess.process(param);
		}
		logger.info("进入OpenApiBackController的param方法!添加一条日志信息,结果: {}", result);
		response.setCharacterEncoding("utf-8");
		JSONObject json = new JSONObject();
		String userAgent = request.getHeader("user-agent");
		boolean isMobile = AppCommonUtil.check(userAgent);
		if (result.isSuccess()) {
			json.put("resultCode", EsupplierResultEnum.EXECUTE_SUCCESS.code());
			json.put("resultMessage", result.getMessage());
			json.put("code", result.getCreditsysResultEnum().code());
			json.put("message", result.getMessage());
			if (isMobile) {
				json.put("message", "消费成功");
				json.put("code", 1);
			}
		} else {
			if (result.getCreditsysResultEnum() == EsupplierResultEnum.OPENAPI_REPEAT_NOTIFY) {
				json.put("resultCode", EsupplierResultEnum.EXECUTE_SUCCESS.code());
				json.put("resultMessage", result.getMessage());
				json.put("code", result.getCreditsysResultEnum().code());
				
			} else {
				json.put("resultCode", result.getCreditsysResultEnum().code());
				json.put("resultMessage", result.getMessage());
				json.put("code", result.getCreditsysResultEnum().code());
			}
			if (isMobile) {
				json.put("message", result.getMessage());
				json.put("code", 0);
			}
		}
		
		this.printHttpResponse(response, json);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/openApi/returnEBankDepositResult.htm")
	public String returnEBankDepositResult(HttpServletRequest request,
											HttpServletResponse response, ModelMap modelMap)
																							throws ServletException {
		openApiReturnTemplate(request, response, new ControllerBizProcess() {
			
			@Override
			public EsupplierBaseResult process(Map<String, String> param) {
				return receiveOpenApiService.netBankDepositComplete(param);
			}
		});
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/openApi/merchantScanCode.htm")
	public String merchantScanCode(HttpServletRequest request, HttpServletResponse response,
									ModelMap modelMap) throws ServletException {
		openApiReturnTemplate(request, response, new ControllerBizProcess() {
			
			@Override
			public EsupplierBaseResult process(Map<String, String> param) {
				EsupplierBaseResult backResult = new EsupplierBaseResult();
				ScanningQRcodeOrder qRcodeOrder = new ScanningQRcodeOrder();
				String merchantId = param.remove("merchantId");
				String bizNo = param.get("bizNo");
				OpenApiContext openApiContext = getOpenApiContext();
				if (!SignUtil.validateSign(param, openApiContext.getSecurityCheckKey(),
					openApiContext.getSignType())) {
					backResult.setCreditsysResultEnum(EsupplierResultEnum.ILLEGAL_SIGN);
					backResult.setSuccess(false);
					backResult.setMessage("验证签名失败");
				}
				long lngMerchantId = NumberUtil.parseLong(merchantId);
				qRcodeOrder.setBelongTo(lngMerchantId);
				qRcodeOrder.setMerchantId(lngMerchantId);
				qRcodeOrder.setBizNo(Long.parseLong(bizNo));
				try {
					qRcodeOrder.setCreateDate(DateUtil.parseDateNoTime(param.get("date"),
						DateUtil.dtLong));
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
				qRcodeOrder.setProcessorId(lngMerchantId);
				return orderService.scanningQRcode(qRcodeOrder);
			}
		});
		//TODO 显示页面
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/openApi/paymentNotifyResult.htm")
	public String paymentNotifyResult(HttpServletRequest request, HttpServletResponse response,
										ModelMap modelMap) throws ServletException {
		openApiReturnTemplate(request, response, new ControllerBizProcess() {
			
			@Override
			public EsupplierBaseResult process(Map<String, String> param) {
				return payService.paymentProcess(param);
			}
		});
		return null;
	}
	
	/**
	 * 
	 * 退款异步回调
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/openApi/refundNotifyResult.htm")
	public String refundNotifyResult(HttpServletRequest request, HttpServletResponse response,
										ModelMap modelMap) throws ServletException {
		openApiReturnTemplate(request, response, new ControllerBizProcess() {
			
			@Override
			public EsupplierBaseResult process(Map<String, String> param) {
				logger.info("refundProcess:"+param.toString());
				return refundService.refundProcess(param);
			}
		});
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/openApi/yjfRegisterNotifyUrl.htm")
	public String yjfRegisterNotifyUrl(HttpServletRequest request, HttpServletResponse response,
										ModelMap modelMap) {
		openApiReturnTemplate(request, response, new ControllerBizProcess() {
			
			@Override
			public EsupplierBaseResult process(Map<String, String> param) {
				String accountName = param.get("userName");
				String accountId = param.get("userId");
				return receiveOpenApiService.updateYjfAccountId(accountId, accountName); //更新易极付账户ID
			}
		});
		return null;
	}
	
	/**
	 * 异步返回提现结果
	 * 
	 * @param request
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/openApi/asysGetWithdrawalRsult.htm")
	public String sysGetWithdrawalRsult(HttpServletRequest request) {
		String strReturn = "success";
		//		try {
		//			String payType = request.getParameter("payType");
		//			String amount = request.getParameter("amount");
		//			String outBizNo = request.getParameter("outBizNo");
		//			String success = request.getParameter("success");
		//			logger.info("提现异步返回结果:payType=" + payType + ",amount=" + amount + ",outBizNo="
		//						+ outBizNo + ",isSuccess=" + success);
		//			
		//			WithdrawFlowOrder depositFlowOrder = new WithdrawFlowOrder();
		//			depositFlowOrder.setAmount(new Money(amount));
		//			depositFlowOrder.setOutBizNo(outBizNo);
		//			RechargeFlowInfo rechargeFlow = withdrawFlowService.queryByOutBizNo(outBizNo);
		//			if ("true".equals(success)) {
		//				depositFlowOrder.setStatus(1);
		//				logger.info("提现成功");
		//			} else {
		//				depositFlowOrder.setStatus(0);
		//				logger.info("提现失败");
		//			}
		//			int flow = withdrawFlowService.update(depositFlowOrder);
		//			if (flow >= 0) {
		//				strReturn = "success";
		//			} else {
		//				strReturn = "";
		//				logger.error("用户:" + rechargeFlow.getOutUserId() + "的" + rechargeFlow.getOutBizNo()
		//								+ "划出更新状态失败");
		//			}
		//		} catch (Exception e) {
		//			logger.error("提现异步返回时,参数异常", e);
		//		}
		return strReturn;
	}
	
	@ResponseBody
	@RequestMapping("/openApi/asysGetWithdrawalRsultByToBank.htm")
	public String asysGetWithdrawalRsultByToBank(HttpServletRequest request) {
		String strReturn = "";
		int status = 0;
		try {
			String payType = request.getParameter("payType");
			String amount = request.getParameter("amount");
			String outBizNo = request.getParameter("outBizNo");
			String success = request.getParameter("success");
			logger.info("提现异步返回结果:payType=" + payType + ",amount=" + amount + ",outBizNo="
						+ outBizNo + ",isSuccess=" + success);
			RechargeFlowInfo rechargeFlow = rechargeFlowService.queryByOutBizNo(outBizNo);
			if ("true".equals(success)) {
				status = 1;
				rechargeFlow.setStatus(1);
				logger.info("提现成功");
			} else {
				status = 0;
				rechargeFlow.setStatus(0);
				logger.info("提现失败");
			}
			int flow = rechargeFlowService.update(rechargeFlow);
			strReturn = "success";
			if (flow <= 0) {
				strReturn = "";
				logger.error("用户:" + rechargeFlow.getOutUserId() + "的" + rechargeFlow.getOutBizNo()
								+ "划出更新状态失败");
			}
			
		} catch (Exception e) {
			logger.error("提现异步返回时,参数异常", e);
		}
		return strReturn;
	}
	
	/**
	 * 异步返回充值结果
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/openApi/asysGetDeductResult.htm")
	public String asysGetDeductResult(HttpServletRequest request) {
		String strReturn = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date notifyTime = null;
			try {
				notifyTime = sdf.parse(request.getParameter("notifyTime"));
			} catch (Exception e) {
				logger.error("e==" + e.getMessage(), e);
				notifyTime = new Date();
			}
			
			String signType = request.getParameter("signType");
			String sign = request.getParameter("sign");
			String resultCode = request.getParameter("resultCode");
			String resultMessage = request.getParameter("resultMessage");
			String payNo = request.getParameter("payNo");
			String outBizNo = request.getParameter("outBizNo");
			String amount = request.getParameter("amount");
			String amountIn = request.getParameter("amountIn");
			String success = request.getParameter("success");
			String message = request.getParameter("message");
			logger.info("充值异步返回结果信息:notifyTime=" + notifyTime + ",signType=" + signType + ",sign="
						+ sign + ",resultCode=" + resultCode + ",resultMessage=" + resultMessage
						+ ",payNo=" + payNo + ",outBizNo=" + outBizNo + ",amount=" + amount
						+ ",success=" + success + ",message=" + message);
			
			strReturn = "success";
			
		} catch (Exception e) {
			logger.error("充值异步调用方法参数或网络异常", e);
		}
		return strReturn;
	}
	
	/**
	 * 异步调用转账到卡结果
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/openApi/asysGetTransferBankAccountResult.htm")
	public String asysGetTransferBankAccountResult(HttpServletRequest request) {
		String strReturn = "";
		try {
			String sign = request.getParameter("sign");
			String notifyTime = request.getParameter("notifyTime");
			String tradeSimpleInfos = request.getParameter("tradeSimpleInfos");
			logger.info("转账到卡异步调用方法返回参数:sign=" + sign + ",notifyTime=" + notifyTime
						+ ",tradeSimpleInfos" + tradeSimpleInfos);
			strReturn = "success";
		} catch (Exception e) {
			logger.error("转账到卡异步调用方法参数或网络异常", e);
		}
		return strReturn;
	}
	
	@RequestMapping(value = "/openApi/yjfLogin.htm")
	public String yjfLoginOpenApi(HttpServletRequest request, HttpServletResponse response,
									ModelMap modelMap) throws ServletException {
		Map<String, String> param = WebUtil.getRequestMap(request);
		logger.info("进入OpenApiBackController的yjfLoginOpenApi方法!添加一条日志信息,入参: {}", param);
		String accessToken = request.getParameter("accessToken");
		if (StringUtil.isNotBlank(accessToken)) {
			YjfLoginResult loginResult = receiveOpenApiService.yjfLogin(accessToken);
			logger.info("进入OpenApiBackController的yjfLoginOpenApi方法!添加一条日志信息,结果: {}", loginResult);
			try {
				if (loginResult.isSuccess()) {
					loginSuccess(request, modelMap, loginResult);
					modelMap.put("localUrl", AppConstantsUtil.getHostHttpUrl());
					return "front/yjf/loginSuccess.vm";
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
		}
		String yjfLoginUrl = WebConstant.getYjfloginurl();
		try {
			response.sendRedirect(yjfLoginUrl);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	@RequestMapping(value = "/openApi/yjfIframeLogin.htm")
	public String yjfIframeLoginOpenApi(HttpServletRequest request, HttpServletResponse response,
										ModelMap modelMap) throws ServletException {
		Map<String, String> param = WebUtil.getRequestMap(request);
		logger.info("进入OpenApiBackController的yjfLoginOpenApi方法!添加一条日志信息,入参: {}", param);
		String accessToken = request.getParameter("accessToken");
		if (StringUtil.isNotBlank(accessToken)) {
			YjfLoginResult loginResult = receiveOpenApiService.yjfLogin(accessToken);
			logger.info("进入OpenApiBackController的yjfLoginOpenApi方法!添加一条日志信息,结果: {}", loginResult);
			try {
				if (loginResult.isSuccess()) {
					loginSuccess(request, modelMap, loginResult);
					modelMap.put("userId", ShiroSessionUtils.getSessionLocal().getUserId());
					modelMap.put("localUrl", WebConstant.getYjfloginIframeUrl());
					return "/front/yjf/iframeLoginSuccess.vm";
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			
		}
		String yjfLoginUrl = WebConstant.getYjfloginIframeUrl();
		try {
			response.sendRedirect(yjfLoginUrl);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	private void loginSuccess(HttpServletRequest request, ModelMap modelMap,
								YjfLoginResult loginResult) {
		UserInfo baseInfoDO = loginResult.getUserInfo();
		SessionLocal local = new SessionLocal(authorityService.getPermissionsByUserId(baseInfoDO
			.getUserId()), baseInfoDO.getUserId(), baseInfoDO.getUserBaseId(),
			baseInfoDO.getAccountId(), baseInfoDO.getAccountName(), baseInfoDO.getRealName(),
			baseInfoDO.getUserName(), authorityService.rolesNameByUserId(baseInfoDO.getUserId()),baseInfoDO.getMobile());
		local.setRemoteAddr(IPUtil.getIpAddr(request));
		local.setUserTypeEnum(baseInfoDO.getType());
		ShiroSessionUtils.setSessionLocal(local);
		
		String ip = CommonUtil.getIp(request);
		String externalId = BusinessNumberUtil.gainNumber();
		try {
			String address = IPAddressUtils.getAddresses("ip=" + ip, "utf-8");
			UserLoginLogDO userLoginLog = new UserLoginLogDO();
			userLoginLog.setTblBaseId(externalId);
			userLoginLog.setLoginAddress(address);
			userLoginLog.setLoginIp(ip);
			userLoginLog.setUserId(baseInfoDO.getUserId());
			userLoginLog.setLoginTime(new Date());
			userLoginLogDAO.insert(userLoginLog);
		} catch (Exception e) {
			logger.error("新增用户登录信息异常", e);
		}
		modelMap.put("sessionScope", ShiroSessionUtils.getSessionLocal());
		modelMap.put("webSessionUtil", new WebSessionUtil(ShiroSessionUtils.getSessionLocal()));
	}
	
	public static void main(String[] args) {
		//{amount=[10.00],sign=[bd0df6295b074ad4d36440c14ab5cffe],batchNo=[123456789987654321],userId=[investorId],partnerId=[20130304020004233676],sendTime=[2014-06-05 18:45:44],period=[6],annualRate=[95]}
		Map<String, String> param = new HashMap<String, String>();
		param.put("amount", "10.00");
		param.put("batchNo", "123456789987654321");
		param.put("userId", "investorId");
		param.put("partnerId", "20130304020004233676");
		param.put("sendTime", "2014-06-05 18:45:44");
		param.put("period", "6");
		param.put("annualRate", "95");
		param.put("sign", "bd0df6295b074ad4d36440c14ab5cffe");
		SignUtil.validateSign(param, "10b5d040fbc300331b94150d8b670c6e", DigestALGEnum.MD5);
	}
	
}
