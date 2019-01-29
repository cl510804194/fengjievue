package com.yjf.esupplier.web.controller.backstage.withdrawalsManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.ApplicationConstant;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.service.tocard.ToCardFlowService;
import com.yjf.esupplier.service.tocard.order.WithdrawalsDenyOrder;
import com.yjf.esupplier.service.user.query.UserAccountQueryService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.ToCardFlowStatusEnum;
import com.yjf.esupplier.ws.info.ToCardFlowInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.order.ToCardFlowQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * 
 * @Filename WithdrawalsManageController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author liugy
 * 
 * @Email changlu@yiji.com
 * 
 * 
 */
@Controller
@RequestMapping("/admin/")
public class WithdrawalsManageController extends BaseAutowiredController {
	/** 通用页面路径 */
	String					WITHDRAWALS_MANAGE_PATH	= "/backstage/withdrawalsManage/";
	
	@Autowired
	ToCardFlowService		toCardFlowService;
	
	@Autowired
	UserAccountQueryService	userAccountQueryService;
	
	/**查询用户*/
	@RequestMapping("withdrawalsManage.htm")
	public String withdrawalsManage(HttpServletRequest request, HttpSession session, Model model,
									PageParam pageParam) {
		ToCardFlowQueryOrder toCardFlowQueryOrder = new ToCardFlowQueryOrder();
		
		WebUtil.setPoPropertyByRequest(toCardFlowQueryOrder, request);
		toCardFlowQueryOrder.setStatus(ToCardFlowStatusEnum.getByCode(request
			.getParameter("status")));
		
		toCardFlowQueryOrder.setPageNumber(pageParam.getPageNo());
		toCardFlowQueryOrder.setPageSize(pageParam.getPageSize());
		model.addAttribute("queryConditions", toCardFlowQueryOrder);
		QueryBaseBatchResult<ToCardFlowInfo> baseBatchResult = toCardFlowService
			.getFlow(toCardFlowQueryOrder);
		if (baseBatchResult.isSuccess()) {
			model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		}
		
		QueryAccountResult queryAccountResult = userAccountQueryService
			.getAccountYjfInfo(sysParameterService
				.getSysParameterValue(ApplicationConstant.SYS_PARAM_YJF_BUSINESS_USER_ID));
		if (queryAccountResult.isSuccess() && queryAccountResult.getYjfAccountInfo() != null) {
			model.addAttribute("availableBalance", queryAccountResult.getYjfAccountInfo()
				.getAvailableBalance());
		}
		return WITHDRAWALS_MANAGE_PATH + "withdrawalsManage.vm";
	}
	
	/**
	 * 驳回申请提现
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("withdrawalsDeny.htm")
	public Object withdrawalsDeny(HttpServletRequest request, HttpSession session, Model model) {
		JSONObject jsonObject = new JSONObject();
		String flowId = request.getParameter("flowId");
		String rem1 = request.getParameter("auditMsg");
		WithdrawalsDenyOrder withdrawalsDenyOrder = new WithdrawalsDenyOrder();
		withdrawalsDenyOrder.setFlowId(NumberUtil.parseLong(flowId));
		withdrawalsDenyOrder.setRem1(rem1);
		EsupplierBaseResult baseResult = toCardFlowService.withdrawalsDeny(withdrawalsDenyOrder);
		if (baseResult.isSuccess()) {
			logger.info("已驳回提现请求{}", flowId);
			jsonObject.put("code", 1);
			jsonObject.put("message", "已驳回提现请求");
		} else {
			logger.info("驳回提现请求失败{}", flowId);
			jsonObject.put("code", 0);
			jsonObject.put("message", "驳回提现请求失败," + baseResult.getMessage());
		}
		return jsonObject;
	}
	
	@ResponseBody
	@RequestMapping("denyMsg.json")
	public Object denyMsg(HttpServletRequest request, HttpSession session, Model model) {
		JSONObject jsonObject = new JSONObject();
		String flowId = request.getParameter("flowId");
		ToCardFlowInfo toCardFlowInfo = toCardFlowService.queryById(NumberUtil.parseLong(flowId));
		if (toCardFlowInfo != null) {
			logger.info("获取提现现信息成功", flowId);
			jsonObject.put("code", 1);
			jsonObject.put("message", "已驳回提现请求");
			jsonObject.put("auditMsg", toCardFlowInfo.getRem1());
		} else {
			logger.info("获取提现信息失败{}", flowId);
			jsonObject.put("code", 0);
			jsonObject.put("message", "获取提现信息失败");
		}
		return jsonObject;
	}
}
