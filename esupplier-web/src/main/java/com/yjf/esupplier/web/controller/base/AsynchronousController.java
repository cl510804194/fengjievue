package com.yjf.esupplier.web.controller.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.service.recharge.DepositFlowService;
import com.yjf.esupplier.service.recharge.WithdrawFlowService;
import com.yjf.esupplier.service.user.order.UpdateRealNameStatusOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 调用易极付相关接口的异步返回方法类
 * 
 * @author Joe
 * 
 */

@Controller
@RequestMapping("openApi")
public class AsynchronousController extends BaseAutowiredController {
	
	@Autowired
	DepositFlowService depositFlowService;
	@Autowired
	WithdrawFlowService withdrawFlowService;
	
	/**
	 * 异步返回实名结果
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("asysGetRealNameStatus.htm")
	public String asysGetRealNameStatus(HttpServletRequest request) {
		String strReturn = " ";
		
		try {
			String status = StringUtil.trim(request.getParameter("certifyStatus"));
			/**
			 * 
			 NOA:未认证 AUT:认证中 ATP:认证通过 ATN:认证失败 UPF:升级失败 UCF:更新有效期失败
			 * UCS:更新有效期成功
			 */
			String accountId = StringUtil.trim(request.getParameter("userId"));
			String message = request.getParameter("message");
			String authNo = StringUtil.trim(request.getParameter("authNo"));
			logger.info("实名异步接收到的参数信息,status=" + status + ",accountId=" + accountId + ",authNo="
						+ authNo + ",message=" + message);
			UpdateRealNameStatusOrder realNameStatusOrder = new UpdateRealNameStatusOrder();
			realNameStatusOrder.setAccountId(accountId);
			realNameStatusOrder.setMessage(message);
			if ("precess".equals(status)) {
				strReturn = "success";
			} else {
				if ("ATP".equals(status) || "UCS".equals(status)) {
					status = "success";
				} else if ("ATN".equals(status) || "UPF".equals(status) || "UCF".equals(status)) {
					status = "fail";
				}
				realNameStatusOrder.setYjfReturnStatus(status);
				EsupplierBaseResult baseResult = userBaseInfoManager
					.updateRealNameStatus(realNameStatusOrder);
				if (baseResult.isSuccess())
					strReturn = "success";
				else {
					strReturn = "{error:'" + baseResult.getMessage() + "'}";
				}
			}
			
		} catch (Exception e) {
			logger.error("异常获取参数异常", e);
		}
		return strReturn;
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			sdf.parse("2014-05-26 18:28");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
