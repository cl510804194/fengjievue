package com.yjf.esupplier.web.controller.front.business.withdrawals;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.integration.openapi.enums.UserStatusEnum;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.trade.WithdrawYrdService;
import com.yjf.esupplier.service.trade.order.PPMWithdrawOrder;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.UserAccountInfoBaseController;
import com.yjf.esupplier.ws.enums.RealNameAuthStatusEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

@Controller
@RequestMapping("/do/withdrawals")
public class WithdrawalsController extends UserAccountInfoBaseController {
	
	private final String VM_PATH = "/front/withdrawals/";
	
	@Autowired
	WithdrawYrdService withdrawYrdService;
	
	@RequestMapping("launchWithdrawals.htm")
	public String launchWithdrawals(HttpSession session, Model model, HttpServletResponse response)
																									throws Exception {
		this.initAccountInfo(model);
		session.setAttribute("current", 1);
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		YjfAccountInfo accountInfo = this.getAccountInfo(model);
		if (userBaseInfo.getRealNameAuthentication() == null) {
			model.addAttribute("userType", userBaseInfo.getType());
			model.addAttribute("fail", "亲，请实名认证！");
			return VM_PATH + "launchWithdrawals.vm";
		}
		if (accountInfo.getUserStatus() == UserStatusEnum.UNACTIVATED) {
			model.addAttribute("userType", userBaseInfo.getType());
			model.addAttribute("fail", "亲，支付账户未激活！");
			model.addAttribute("noInactive", "支付账户未激活！");
			return VM_PATH + "launchWithdrawals.vm";
		}
		if (userBaseInfo.getRealNameAuthentication() != RealNameAuthStatusEnum.IS) {
			model.addAttribute("userType", userBaseInfo.getType());
			model.addAttribute("fail", "实名认证未通过！");
			return VM_PATH + "launchWithdrawals.vm";
		}
		if (userBaseInfo.getRealNameAuthentication() == RealNameAuthStatusEnum.IN) {
			model.addAttribute("userType", userBaseInfo.getType());
			model.addAttribute("isRealNameAuth", "实名审核中！");
			return VM_PATH + "launchWithdrawals.vm";
		}
		if (userBaseInfo.getState() != UserStateEnum.NORMAL) {
			model.addAttribute("fail", "帐户状态异常,无法提现申请！");
			return VM_PATH + "launchWithdrawals.vm";
		}
		
		PPMWithdrawOrder order = new PPMWithdrawOrder();
		order.setUserId(userBaseInfo.getUserId());
		EsupplierBaseResult withdrawResult = withdrawYrdService.applyPPMWithdraw(order);
		model.addAttribute("withdrawUrl", withdrawResult.getUrl());
		return VM_PATH + "launchWithdrawals.vm";
	}
	
}
