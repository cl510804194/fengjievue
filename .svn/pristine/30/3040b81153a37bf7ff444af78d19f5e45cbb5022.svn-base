package com.yjf.esupplier.web.controller.backstage.controller;

import com.yjf.esupplier.service.user.enums.PasswordTypeEnum;
import com.yjf.esupplier.service.user.order.PwdInfoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.RSAUtils;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PermissionUtil;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * 
 * @Filename BackstageLoginController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-8-21</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("admin")
public class BackstageLoginController extends BaseAutowiredController {
	private final String vm_path = "/backstage/";
	private static String LOGIN_MESSAGE = "用户名或者密码错误";
	private static String LOGIN_MESSAGE_DISABLE = "该用户不可用...";
	/**
	 * 账户已被锁定
	 */
	private static String LOGIN_MESSAGE_LOCKED = "此账户已被锁定，请等待解锁";
	/**
	 * 账户不存在
	 */
	private static String LOGIN_USER_UNKNOWN = "账户不存在";
	
	@SuppressWarnings("unused")
	@RequestMapping("updateGoto.htm")
	private String updateGoto(Model model) {
		String userName = ShiroSessionUtils.getSessionLocal().getUserName();
		Long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		model.addAttribute("userName", userName);
		model.addAttribute("userId", userId);
		return vm_path + "backstageLoginUpdate.vm";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("backstageIdex.htm")
	private String backstageIdex(Model model) {
		String userName = ShiroSessionUtils.getSessionLocal().getUserName();
		Long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		model.addAttribute("userName", userName);
		model.addAttribute("userId", userId);
		return vm_path + "backstageResult.vm";
	}
	
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("updateUserPassword.htm")
	private Object updateUserPassword(String newPassword, String oldPassword) {
		JSONObject json = new JSONObject();
		
		try {
			Long userId = ShiroSessionUtils.getSessionLocal().getUserId();
			UserInfo userInfo = userQueryService.queryByUserId(userId).getQueryUserInfo();
			PwdInfoOrder pwdInfoOrder = new PwdInfoOrder();
			pwdInfoOrder.setUserBaseId(userInfo.getUserBaseId());
			pwdInfoOrder.setPasswdType(PasswordTypeEnum.LOGIN_PASSWORD);
			pwdInfoOrder.setOldPwd(oldPassword);
			pwdInfoOrder.setNewPwd(newPassword);
			EsupplierBaseResult baseResult = userBaseInfoManager.updateUserPassword(pwdInfoOrder);
			if (baseResult.isSuccess()) {
				json.put("message", "修改密码成功");
			} else {
				json.put("message", baseResult.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("更新密码异常");
			json.put("message", "修改密码失败");
		}
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping("resetLogPwd.htm")
	public Object resetLogPwd(String userBaseId, String newPassword, String reNewPassword) {
		JSONObject json = new JSONObject();
		if (PermissionUtil.check("/admin/**") != 1) {
			json.put("code", 0);
			json.put("message", "您没有修改权限");
			return json;
		}
		if (!StringUtil.equals(newPassword, reNewPassword)) {
			json.put("code", 0);
			json.put("message", "两次输入的密码不一致");
			return json;
		}
		
		EsupplierBaseResult result = userBaseInfoManager.adminResetLogPwd(userBaseId,
			RSAUtils.decryptStringByJs(newPassword));
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "重置管理员密码成功");
		} else {
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		return json;
	}
}
