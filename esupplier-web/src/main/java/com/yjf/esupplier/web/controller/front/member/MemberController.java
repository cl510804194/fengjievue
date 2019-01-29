/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.front.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.UserBaseInfoManager;
import com.yjf.esupplier.service.user.order.UpdateUserBaseInfoOrder;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.front.base.FrontAutowiredBaseController;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 *
 *
 * @Filename MemberController.java
 *
 * @Description 会员资料管理控制器
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2015-5-7下午5:39:33</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/do/member")
public class MemberController extends FrontAutowiredBaseController {

	final static String path = "front/member/";

	@Autowired
	protected UserBaseInfoManager userBaseInfoManager;

	/**
	 * 开通商务功能
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("enrollMember.htm")
	public String enrollMember(HttpServletRequest request, HttpServletResponse response, Model model) {

		return path + "member_mailverify.vm";
	}

	/**
	 * 修改会员信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updateMember.htm")
	public String updateMember(HttpServletRequest request, HttpServletResponse response, Model model) {

		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();

		UserQueryResult result = userQueryService.queryByUserId(sessionLocal.getUserId());

		model.addAttribute("member", result.getQueryUserInfo());

		return path + "member_update.vm";
	}

	/**
	 * 修改会员信息
	 * @param order
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateMemberSubmit.json")
	public Object updateMemberSubmit(UpdateUserBaseInfoOrder order, HttpServletRequest request,
									 HttpServletResponse response, Model model) {

		logger.info("修改会员信息，入参：{}", order);
		JSONObject json = new JSONObject();
		order.setType(UserTypeEnum.getByCode(request.getParameter("type")));
		order.setUserBaseId(ShiroSessionUtils.getSessionLocal().getUserBaseId());
		order.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		EsupplierBaseResult result = userBaseInfoManager.updateUserBaseInfo(order);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改会员信息成功");
		} else {
			json.put("code", 0);
			json.put("message", "修改会员信息失败");
		}

		return json;
	}

	/**
	 * 重新获取邮件验证编码
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("remailVerifyCode.htm")
	public String remailVerifyCode(HttpServletRequest request, HttpServletResponse response,
								   Model model) {

		return path + "member_mailverify.vm";
	}

	/**
	 * 修改邮箱
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("updateEmail.htm")
	public String updateEmail(HttpServletRequest request, HttpServletResponse response, Model model) {

		return path + "member_mailverify.vm";
	}

	/**
	 * 查询所有的企业会员信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("listEnterprise.htm")
	public String listEnterprise(HttpServletRequest request, HttpServletResponse response,
								 Model model) {

		return path + "allguarantee.vm";
	}

	/**
	 * 查询企业会员资料——根据会员名称
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("checkEnterprise.htm")
	public String checkEnterprise(HttpServletRequest request, HttpServletResponse response,
								  Model model) {

		return path + "allguarantee.vm";
	}

	/**
	 * 查询会员详细信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getMemberById.htm")
	public String getMemberById(HttpServletRequest request, HttpServletResponse response,
								Model model) {

		return path + "member_info.vm";
	}

}
