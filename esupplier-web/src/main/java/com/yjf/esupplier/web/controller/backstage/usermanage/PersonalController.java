package com.yjf.esupplier.web.controller.backstage.usermanage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.integration.openapi.enums.OccupationEnum;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.service.common.order.SendNonMainlandRealNameInfoOrder;
import com.yjf.esupplier.service.security.info.RoleInfo;
import com.yjf.esupplier.service.security.query.order.RoleQueryOrder;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.PersonalInfo;
import com.yjf.esupplier.service.user.info.PersonalVOInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.order.AdminUserRegisterOrder;
import com.yjf.esupplier.service.user.order.ChangeBrokerOrder;
import com.yjf.esupplier.service.user.order.ChangeMarkettingOrder;
import com.yjf.esupplier.service.user.order.InvestorToBrokerOrder;
import com.yjf.esupplier.service.user.order.PersonalBackstageRegisterOrder;
import com.yjf.esupplier.service.user.order.UpdatePersonalOrder;
import com.yjf.esupplier.service.user.order.UpdateUserLevelOrder;
import com.yjf.esupplier.service.user.order.UserGrantStateUpdateOrder;
import com.yjf.esupplier.service.user.query.order.PersonaCommonQueryOrder;
import com.yjf.esupplier.service.user.query.order.UserQueryOrder;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.RealNameAuthStatusEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.order.LoanerBaseInfoOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * 
 * @Filename UserManageController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjil</li> <li>Date: 2013-6-11</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("/admin/userManage")
public class PersonalController extends UserBaseInfoBaseController {
	/** 通用页面路径 */
	String USER_MANAGE_PATH = "/backstage/userManage/";
	
	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "changeLockTime", "startCreateTime", "endCreateTime",
								"startUpdateTime", "endUpdateTime" };
	}
	
	@RequestMapping("personalManage.htm")
	public String personalManage(HttpServletRequest request, PageParam pageParam,
									HttpServletResponse response, Model model) {
		PersonaCommonQueryOrder commonQueryOrder = new PersonaCommonQueryOrder();
		WebUtil.setPoPropertyByRequest(commonQueryOrder, request);
		commonQueryOrder.setState(UserStateEnum.getByCode(request.getParameter("state")));
		String role = request.getParameter("role");
		if (StringUtil.isNotEmpty(role)) {
			commonQueryOrder.setRoleId(Integer.valueOf(role));
		}
		
		pageParam.setPageSize(20);
		commonQueryOrder.setPageSize(pageParam.getPageSize());
		commonQueryOrder.setPageNumber(pageParam.getPageNo());
		QueryBaseBatchResult<PersonalVOInfo> baseBatchResult = userQueryService
			.commonQueryPersonalInfo(commonQueryOrder);
		Page<PersonalVOInfo> page = PageUtil.getCovertPage(baseBatchResult);
		model.addAttribute("queryConditions", commonQueryOrder);
		
		model.addAttribute("page", page);
		response.setHeader("Pragma", "No-cache");
		return USER_MANAGE_PATH + "personalManage.vm";
	}
	
	@ResponseBody
	@RequestMapping("sendActiveUrl.htm")
	public Object sendActiveUrl(HttpServletRequest request, String userBaseId,
								HttpServletResponse response, Model model) {
		
		JSONObject jsonobj = new JSONObject();
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		if (userInfo == null) {
			jsonobj.put("code", "0");
			jsonobj.put("message", "用户不存在");
			return jsonobj;
		}
		EsupplierBaseResult activeResult = registerService.resendEmail(userBaseId);
		if (activeResult.isSuccess()) {
			jsonobj.put("code", "1");
			jsonobj.put("message", "发送激活邮件成功");
		} else {
			jsonobj.put("code", "0");
			jsonobj.put("message", "发送激活邮件失败");
		}
		return jsonobj;
	}
	
	@RequestMapping("unRealNamePass.htm")
	public String unRealNamePass(HttpServletRequest request, PageParam pageParam, Model model)
																								throws Exception {
		PersonaCommonQueryOrder commonQueryOrder = new PersonaCommonQueryOrder();
		WebUtil.setPoPropertyByRequest(commonQueryOrder, request);
		commonQueryOrder.setRealNameAuthentication(RealNameAuthStatusEnum.getByCode(request
			.getParameter("realNameAuthentication")));
		commonQueryOrder.setPageSize(pageParam.getPageSize());
		commonQueryOrder.setPageNumber(pageParam.getPageNo());
		QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
			.commonQueryUserInfo(commonQueryOrder);
		Page<UserInfo> page = PageUtil.getCovertPage(baseBatchResult);
		model.addAttribute("queryConditions", commonQueryOrder);
		model.addAttribute("page", page);
		return USER_MANAGE_PATH + "unRealNamePass.vm";
	}
	
	@RequestMapping("unRealNamePassFDL/addGuarantor.htm")
	public String addGuarantor(HttpServletRequest request, Model model) throws Exception {
		List<OccupationEnum> guaranteeOccupation = OccupationEnum.getAllEnum();
		model.addAttribute("guaranteeOccupation", guaranteeOccupation);
		return USER_MANAGE_PATH + "addGuarantor.vm";
	}
	
	@ResponseBody
	@RequestMapping("unRealNamePassFDL/rejectedGuarante.htm")
	public JSONObject rejectedGuarante(HttpServletRequest request,
										SendNonMainlandRealNameInfoOrder nonMainlandRealNameOrder,
										Model model) throws Exception {
		
		JSONObject json = new JSONObject();
		if (com.yjf.esupplier.common.util.StringUtil.isNotEmpty(nonMainlandRealNameOrder
			.getUserBaseId())) {
			EsupplierBaseResult baseResult = realNameAuthenticationService
				.rejectNonMainlandRealName(nonMainlandRealNameOrder.getUserBaseId());
			
			logger.info("非大陆实名认证驳回，入参{}", baseResult);
			
			if (baseResult.isSuccess()) {
				json.put("code", 1);
				json.put("message", "操作成功");
			} else {
				json.put("code", 0);
				json.put("message", "操作失败");
			}
		}
		return json;
		
	}
	
	@RequestMapping("personalManage/addPersonalUser.htm")
	public String addPersonalUser(long parentId, Model model) throws Exception {
		model.addAttribute("parentId", parentId);
		model.addAttribute("uploadHost", "");
		if (parentId == 1) {
			return USER_MANAGE_PATH + "addAdmin.vm";
		} else {
			return USER_MANAGE_PATH + "addPersonalUser.vm";
		}
	}
	
	@RequestMapping("personalManage/updatePersonalUser.htm")
	public String updatePersonalUser(String userBaseId, long userId, Model model) throws Exception {
		model.addAttribute("uploadHost", "");
		UserInfo userBase = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		if (userBase.getType() == UserTypeEnum.JG) {
			return updateInstitutionsUser(userBaseId, userId, model);
		} else {
			PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(userBaseId)
				.getQueryPersonalInfo();
			
			BeanCopier.staticCopy(userBase, personalInfo);
			List<RoleInfo> roleList = authorityService.getRolesByUserId(userId);
			
			model.addAttribute("info", personalInfo);
			model.addAttribute("roleList", roleList);
			if (userBase.getRealNameAuthentication() == null
				|| userBase.getRealNameAuthentication() == RealNameAuthStatusEnum.NO) {
				model.addAttribute("personlRealNameStatus", "N");
				return USER_MANAGE_PATH + "updatePersonalUser.vm";
			} else {
				
				return USER_MANAGE_PATH + "personalUserInfo.vm";
			}
		}
	}
	
	//港澳台，查看详情
	@RequestMapping("personalManage/updateunRealNamePassFDL.htm")
	public String updateunRealNamePassFDL(String userBaseId, long userId, Model model)
																						throws Exception {
		model.addAttribute("uploadHost", "");
		UserInfo userBase = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(userBaseId)
			.getQueryPersonalInfo();
		
		BeanCopier.staticCopy(userBase, personalInfo);
		List<RoleInfo> roleList = authorityService.getRolesByUserId(userId);
		
		model.addAttribute("info", personalInfo);
		model.addAttribute("roleList", roleList);
		return USER_MANAGE_PATH + "personalUserInfoFDL.vm";
		
	}
	
	public String updateInstitutionsUser(String userBaseId, long userId, Model model)
																						throws Exception {
		model.addAttribute("uploadHost", "");
		List<RoleInfo> roleList = authorityService.getRolesByUserId(userId);
		InstitutionsInfo institutionsInfo = userQueryService.queryInstitutionsInfoByBaseId(
			userBaseId).getQueryInstitutionsInfo();
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		BeanCopier.staticCopy(userInfo, institutionsInfo);
		model.addAttribute("roleList", roleList);
		model.addAttribute("info", institutionsInfo);
		return USER_MANAGE_PATH + "updateInstitutionsUser.vm";
	}
	
	@RequestMapping("personalManage/detailPersonalInfo.htm")
	public String detailPersonalInfo(String userBaseId, long userId, String memberNo, Model model)
																									throws Exception {
		model.addAttribute("uploadHost", "");
		PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(userBaseId)
			.getQueryPersonalInfo();
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		BeanCopier.staticCopy(userInfo, personalInfo);
		List<RoleInfo> roleList = authorityService.getRolesByUserId(userId);
		
		UserInfo userBase = userQueryService.queryByUserId(userId).getQueryUserInfo();
		
		model.addAttribute("info", personalInfo);
		model.addAttribute("roleList", roleList);
		return USER_MANAGE_PATH + "detailPersonalInfo.vm";
	}
	
	@ResponseBody
	@RequestMapping("personalManage/addPersonalUserSubmit.htm")
	public Object addPersonalUserSubmit(HttpServletRequest request) {
		PersonalBackstageRegisterOrder registerOrder = new PersonalBackstageRegisterOrder();
		LoanerBaseInfoOrder loanerOrder = new LoanerBaseInfoOrder();
		WebUtil.setPoPropertyByRequest(registerOrder, request);
		WebUtil.setPoPropertyByRequest(loanerOrder, request);
		setRoles(request, registerOrder);
		JSONObject jsonobj = new JSONObject();
		/*if (StringUtil.isEmpty(registerOrder.getCertFrontPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传身份证正面照片");
			return jsonobj;
		}
		
		if (StringUtil.isEmpty(registerOrder.getCertBackPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传身份证反面照片");
			return jsonobj;
		}*/
		String userName = null;
		EsupplierBaseResult result = null;
		if(StringUtil.isNotEmpty(registerOrder.getUserName())){
			userName = registerOrder.getUserName();
			result = userBaseInfoManager.validationUserName(userName);
			if (!result.isSuccess()) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "用户名已存在");
				return jsonobj;
			} 
		}
		if(StringUtil.isNotEmpty(registerOrder.getMail())){
			userName = registerOrder.getMail();
			result = userBaseInfoManager.validationUserName(userName);
			if (!result.isSuccess()) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "邮箱已存在");
				return jsonobj;
			} 
		}
		if(StringUtil.isNotEmpty(registerOrder.getMobile())){
			userName = registerOrder.getMobile();
			result = userBaseInfoManager.validationUserName(userName);
			if (!result.isSuccess()) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "手机号已存在");
				return jsonobj;
			} 
		}

		EsupplierBaseResult baseResult = registerService.personalBackstageRegister(registerOrder);
		if (baseResult.isSuccess()) {
			UserInfo userInfo = userQueryService.queryByUserName(registerOrder.getUserName())
				.getQueryUserInfo();
			for (SysUserRoleEnum roleEnum : registerOrder.getRole()) {
				if (roleEnum == SysUserRoleEnum.SELLER) {
					loanerOrder.setUserId(userInfo.getUserId());
					loanerOrder.setLoanerUserName(request.getParameter("userName"));
					loanerOrder.setLoanerRealName(request.getParameter("realName"));
					// addAttachfile(userInfo.getUserBaseId(), request);
				}
			}
			jsonobj.put("code", 1);
			jsonobj.put("message", "个人开户成功");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", baseResult.getMessage());
			
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("personalManage/updatePersonalUserSubmit.htm")
	public Object updatePersonalUserSubmit(HttpServletRequest request) throws Exception {
		UpdatePersonalOrder updatePersonalOrder = new UpdatePersonalOrder();
		LoanerBaseInfoOrder loanerOrder = new LoanerBaseInfoOrder();
		// CommonAttachmentOrder attachment = new CommonAttachmentOrder();
		JSONObject jsonobj = new JSONObject();
		WebUtil.setPoPropertyByRequest(updatePersonalOrder, request);
		WebUtil.setPoPropertyByRequest(loanerOrder, request);
		UserInfo userInfo = userQueryService.queryByUserId(loanerOrder.getUserId())
			.getQueryUserInfo();
		updatePersonalOrder.setUserName(userInfo.getUserName());
		loanerOrder.setLoanerUserName(userInfo.getUserName());
		loanerOrder.setLoanerRealName(userInfo.getRealName());
		if (StringUtil.isBlank(request.getParameter("mobileBinding"))) {
			updatePersonalOrder.setMobileBinding(BooleanEnum.NO);
		} else {
			updatePersonalOrder.setMobileBinding(BooleanEnum.getByCode(request
				.getParameter("mobileBinding")));
		}
		if (StringUtil.isBlank(request.getParameter("mailBinding"))) {
			updatePersonalOrder.setMailBinding(BooleanEnum.NO);
		} else {
			updatePersonalOrder.setMailBinding(BooleanEnum.getByCode(request
				.getParameter("mailBinding")));
		}
		setRoles(request, updatePersonalOrder);
		String mobile = null;
		if (StringUtil.isEmpty(updatePersonalOrder.getMobile())) {
			mobile = userInfo.getMobile();
		} else {
			mobile = updatePersonalOrder.getMobile();
		}
		
		String mail = null;
		if (StringUtil.isEmpty(updatePersonalOrder.getMobile())) {
			mail = userInfo.getMail();
		} else {
			mail = updatePersonalOrder.getMail();
		}
		
		updatePersonalOrder.setMobile(mobile);
		updatePersonalOrder.setMail(mail);
		EsupplierBaseResult baseResult = registerService
			.updateBackstageRegister(updatePersonalOrder);
		if (baseResult.isSuccess()) {
			
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改个人用户信息成功");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改个人用户信息失败,原因[" + baseResult.getMessage() + "]");
		}
		return jsonobj;
	}
	
	@RequestMapping("userBaseInfoManage.htm")
	public String userBaseInfoManage(HttpServletRequest request, PageParam pageParam, Model model)
																									throws Exception {
		UserQueryOrder queryOrder = new UserQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setPageSize(pageParam.getPageSize());
		queryOrder.setPageNumber(pageParam.getPageNo());
		String state = request.getParameter("state");
		queryOrder.setState(UserStateEnum.getByCode(state));
		QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
			.commonQueryUserInfo(queryOrder);
		model.addAttribute("queryConditions", queryOrder);
		model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		return USER_MANAGE_PATH + "userManage.vm";
	}
	
	@RequestMapping("userBaseInfoManage/updateUserRole.htm")
	public String updateUserRole(String userBaseId, long userId, Model model,
									HttpServletRequest request) throws Exception {
		UserInfo baseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		List<RoleInfo> roleList = authorityService.getRolesByUserId(userId);
		if (baseInfo.getType() == UserTypeEnum.GR) {
			PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(userBaseId)
				.getQueryPersonalInfo();
			if (personalInfo != null) {
				model.addAttribute("referees", personalInfo.getReferees());
			}
			
		}
		RoleQueryOrder queryOrder = new RoleQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setPageSize(10000);
		List<RoleInfo> roleAll = authorityService.getAllRoles(queryOrder).getPageList();
		
		List<RoleInfo> roleSelects = new ArrayList<RoleInfo>();
		if (ListUtil.isNotEmpty(roleAll)) {
			for (RoleInfo role : roleAll) {
				if (role.getRoleId() == 1 || (role.getRoleId() >= 7 && role.getRoleId() <= 14)) {
					continue;
				}
				roleSelects.add(role);
			}
		}
		model.addAttribute("roleSelects", roleSelects);
		
		model.addAttribute("info", baseInfo);
		model.addAttribute("roleList", roleList);
		return USER_MANAGE_PATH + "userBaseInfoUpdate.vm";
	}
	
	@ResponseBody
	@RequestMapping("userBaseInfoManage/updateUserRoleSubmit.htm")
	public Object updateUserRoleSubmit(String userBaseId, String type, String state, int... roleIds)
																									throws Exception {
		JSONObject jsonobj = new JSONObject();
		UserInfo userBaseInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		UserGrantStateUpdateOrder stateUpdateOrder = new UserGrantStateUpdateOrder();
		stateUpdateOrder.setUserBaseId(userBaseId);
		stateUpdateOrder.setRoleIds(roleIds);
		stateUpdateOrder.setUserStateEnum(UserStateEnum.getByCode(state));
		EsupplierBaseResult result = userBaseInfoManager.updateUserGrantAndState(stateUpdateOrder);
		if (userBaseInfo.getType() == UserTypeEnum.JG) {
			
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "修改机构信息成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "修改机构信息失败");
			}
		} else {
			
			if (result.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", "修改个人用户信息成功");
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", "修改个人用户信息失败");
			}
		}
		
		return jsonobj;
	}
	
	@RequestMapping("userBaseInfoManage/addAdmin.htm")
	public String addAdmin(long parentId, Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("parentId", parentId);
		model.addAttribute("uploadHost", "");
		RoleQueryOrder queryOrder = new RoleQueryOrder();
		WebUtil.setPoPropertyByRequest(queryOrder, request);
		queryOrder.setPageSize(1000);
		List<RoleInfo> roleAll = authorityService.getAllRoles(queryOrder).getPageList();
		List<RoleInfo> roleSelects = new ArrayList<RoleInfo>();
		if (ListUtil.isNotEmpty(roleAll)) {
			for (RoleInfo role : roleAll) {
				if (role.getRoleId() == 2) {
					continue;
				}
				roleSelects.add(role);
			}
		}
		model.addAttribute("roleSelects", roleSelects);
		return USER_MANAGE_PATH + "addAdmin.vm";
	}
	
	/**
	 * 添加后台管理员
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("userBaseInfoManage/addAdminSubmit.htm")
	public Object addAdminSubmit(HttpSession session, HttpServletRequest request, int... roleIds) {
		AdminUserRegisterOrder userRegisterOrder = new AdminUserRegisterOrder();
		WebUtil.setPoPropertyByRequest(userRegisterOrder, request);
		JSONObject json = new JSONObject();
		try {
			userRegisterOrder.setRoles(roleIds);
			EsupplierBaseResult baseResult = registerService.adminUserRegister(userRegisterOrder);
			if (baseResult.isSuccess()) {
				json.put("code", 1);
				json.put("message", "新增管理员成功");
			} else {
				json.put("code", 0);
				json.put("message", baseResult.getCreditsysResultEnum().getMessage());
			}
		} catch (Exception e) {
			logger.error("新增管理员异常", e);
			json.put("code", 0);
			json.put("message", "新增管理员异常");
		}
		return json;
	}
	
	@RequestMapping("changeBroker.htm")
	public String changeBroker(HttpSession session, Model model) {
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
		UserRoleQueryOrder userRoleQueryOrder = new UserRoleQueryOrder();
		userRoleQueryOrder.setPageSize(99999999);
		userRoleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		userRoleQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
		List<UserInfo> users = userQueryService.queryRoleUserInfo(userRoleQueryOrder).getPageList();
		model.addAttribute("users", users);
		return USER_MANAGE_PATH + "changeBroker.vm";
	}
	
	@ResponseBody
	@RequestMapping("changeBrokerSubmit.json")
	public Object changeBrokerSubmit(String userName, String borkerNo, String token,
										HttpSession session) {
		String getToken = (String) session.getAttribute("token");
		
		JSONObject json = new JSONObject();
		
		try {
			if (token != null && token.equals(getToken)) {
				session.removeAttribute("token");
				UserInfo userInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
				ChangeBrokerOrder changeBrokerOrder = new ChangeBrokerOrder();
				changeBrokerOrder.setChildId(userInfo.getUserId());
				changeBrokerOrder.setReferees(borkerNo);
				EsupplierBaseResult result = new EsupplierBaseResult();
				if (result.isSuccess()) {
					json.put("code", 1);
					json.put("message", "更改成功");
				} else {
					json.put("code", 0);
					json.put("message", "更改失败");
				}
			} else {
				json.put("code", 0);
				json.put("message", "重复提交");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", 0);
			json.put("message", "更改失败");
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("changeInvestorToBroker.json")
	public Object changeInvestorToBroker(HttpServletRequest request, String token,
											HttpSession session) {
		String getToken = (String) session.getAttribute("token");
		
		JSONObject json = new JSONObject();
		
		try {
			if (token != null && token.equals(getToken)) {
				session.removeAttribute("token");
				String userName = request.getParameter("userName");
				String orgId = request.getParameter("orgId");
				UserInfo userInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
				InvestorToBrokerOrder changeBrokerOrder = new InvestorToBrokerOrder();
				changeBrokerOrder.setInvestorId(userInfo.getUserId());
				changeBrokerOrder.setOrgId(Long.valueOf(orgId));
				EsupplierBaseResult result = new EsupplierBaseResult();
				if (result.isSuccess()) {
					json.put("code", 1);
					json.put("message", "更改成功");
				} else {
					json.put("code", 0);
					json.put("message", "更改失败");
				}
			} else {
				json.put("code", 0);
				json.put("message", "重复提交");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", 0);
			json.put("message", "更改失败");
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("changeMarkettingSubmit.json")
	public Object changeMarkettingSubmit(String brokerUserName, String markettingUserName,
											String token, HttpSession session) {
		String getToken = (String) session.getAttribute("token");
		
		JSONObject json = new JSONObject();
		try {
			if (token != null && token.equals(getToken)) {
				session.removeAttribute("token");
				ChangeMarkettingOrder changeMarkettingOrder = new ChangeMarkettingOrder();
				changeMarkettingOrder.setMarkettingUserName(markettingUserName);
				changeMarkettingOrder.setBrokerUserName(brokerUserName);
				EsupplierBaseResult result = new EsupplierBaseResult();
				if (result.isSuccess()) {
					json.put("code", 1);
					json.put("message", "更改成功");
				} else {
					json.put("code", 0);
					json.put("message", "更改失败");
				}
			} else {
				json.put("code", 0);
				json.put("message", "重复提交");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", 0);
			json.put("message", "更改失败");
		}
		return json;
	}
	
	/**
	 * 后台实名认证
	 * 
	 * @param userBaseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "backRealNameAut.json")
	public JSONObject backRealNameAut(String userBaseId) {
		JSONObject jsonobj = new JSONObject();
		try {
			EsupplierBaseResult baseResult = realNameAuthenticationService
				.sendPersonalRealNameInfo(userBaseId);
			if (baseResult.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", baseResult.getMessage());
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", baseResult.getMessage());
			}
		} catch (Exception e) {
			logger.error("后台个人实名发送异常", e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "后台个人实名发送异常");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("userBaseInfoManage/queryBalance.htm")
	public Object queryBalance(String userBaseId, Model model) throws Exception {
		JSONObject json = new JSONObject();
		UserQueryResult queryResult = userQueryService.queryByUserBaseId(userBaseId);
		UserInfo userInfo = queryResult.getQueryUserInfo();
		// yrd资金资料
		QueryAccountResult accountResult = userAccountQueryService.getAccountInfo(userInfo
			.getUserId());
		YjfAccountInfo accountServiceInfo = accountResult.getYjfAccountInfo();
		logger.info("调用open查找资金账户返回，{}", accountServiceInfo);
		if (accountServiceInfo != null) {
			// 不可以余额
			json.put("code", "1");
			json.put("freezeAmount", accountServiceInfo.getFreezeAmount().toStandardString());
			json.put("availableBalance", accountServiceInfo.getAvailableBalance()
				.toStandardString());
			json.put("balance", accountServiceInfo.getBalance().toStandardString());
			return json;
		}
		json.put("code", "0");
		return json;
	}
	
	@ResponseBody
	@RequestMapping("updateState.json")
	public Object updateState(String userBaseId, String state) throws Exception {
		JSONObject jsonobj = new JSONObject();
		
		UserStateEnum stateEnum = UserStateEnum.getByCode(state);
		EsupplierBaseResult baseResult = userBaseInfoManager.updateUserState(userBaseId, stateEnum);
		if (baseResult.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改用户状态成功");
		}
		if (!baseResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改用户状态失败[" + baseResult.getMessage() + "]");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("updateUserLevel.htm")
	public Object updateUserLevel(UpdateUserLevelOrder levelOrder) throws Exception {
		JSONObject json = new JSONObject();
		
		EsupplierBaseResult baseResult = userBaseInfoManager.updateUserLevel(levelOrder);
		if (baseResult.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改用户等级成功");
		}
		if (!baseResult.isSuccess()) {
			json.put("code", 0);
			json.put("message", "修改用户等级失败[" + baseResult.getMessage() + "]");
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("common/validationAccountName.json")
	public Object validationAccountName(String accountName) throws Exception {
		logger.info("验证易极付帐户不存在，入参：{}", accountName);
		JSONObject jsonobj = new JSONObject();
		CustomerResult returnEnum = this.customerService.checkUserNameExist(accountName,
			this.getOpenApiContext());
		if (!returnEnum.isExsit()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "用户可以用");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户已存在");
		}
		logger.info("验证易极付帐户不存在，出参：{}", jsonobj);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("common/validationUserName.json")
	public Object validationUserName(String userName,String mail,String mobile) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", userName);
		JSONObject jsonobj = new JSONObject();
		if(StringUtil.isNotEmpty(mail)){
			userName = mail;
		}
		if(StringUtil.isNotEmpty(mobile)){
			userName = mobile;
		}
		EsupplierBaseResult result = userBaseInfoManager.validationUserName(userName);
		// 验证用户不存在
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "用户可以用");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户已存在");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", userName);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("common/validationMail.json")
	public Object validationUserMail(String mail) throws Exception {
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", mail);
		JSONObject jsonobj = new JSONObject();
		
		EsupplierBaseResult result = userBaseInfoManager.validationUserName(mail);
		// 验证用户不存在
		if (result.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "用户可以用");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户已存在");
		}
		logger.info("验证" + AppConstantsUtil.getProductName() + "金融用户不存在，入参：{}", mail);
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("common/validationReferees.json")
	public Object validationReferees(String referees) throws Exception {
		
		JSONObject jsonobj = new JSONObject();
		EsupplierBaseResult returnEnum = new EsupplierBaseResult();
		if (returnEnum.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "该推荐人可用");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "该推荐人不可用");
		}
		return jsonobj;
	}
	
}
