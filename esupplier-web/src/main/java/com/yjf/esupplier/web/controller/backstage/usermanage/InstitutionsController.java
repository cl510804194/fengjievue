package com.yjf.esupplier.web.controller.backstage.usermanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.service.security.info.RoleInfo;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.order.InstitutionsBaskstageRegisterOrder;
import com.yjf.esupplier.service.user.order.UpdateEnterpriseOrder;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.service.user.result.InstitutionsInfoQueryResult;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.P2PEnterpriseTypeEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.order.LoanerBaseInfoOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * 
 * @Filename InstitutionsController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-7-5</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("/admin/userManage")
public class InstitutionsController extends UserBaseInfoBaseController {
	/** 通用页面路径 */
	String USER_MANAGE_PATH = "/backstage/userManage/";
	
	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "changeLockTime" };
	}
	
	@RequestMapping("institutionManage.htm")
	public String institutionsManage(HttpServletRequest request, PageParam pageParam, Model model,
										String roleEnum) throws Exception {
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		WebUtil.setPoPropertyByRequest(roleQueryOrder, request);
		roleQueryOrder.setPageSize(pageParam.getPageSize());
		roleQueryOrder.setPageNumber(pageParam.getPageNo());
		roleQueryOrder.setType(UserTypeEnum.JG);
		if (StringUtil.isNotBlank(roleEnum)) {
			roleQueryOrder.setRoleEnum(SysUserRoleEnum.getByValue(Integer.parseInt(roleEnum)));
		}
		roleQueryOrder.setUserStateEnum(UserStateEnum.getByCode(request.getParameter("state")));
		QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
			.queryRoleUserInfo(roleQueryOrder);
		model.addAttribute("queryConditions", roleQueryOrder);
		model.addAttribute("roleEnum", roleEnum);
		model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		return USER_MANAGE_PATH + "institutionsManage.vm";
	}
	
	@RequestMapping("merchantManage.htm")
	public String merchantManage(HttpServletRequest request, PageParam pageParam, Model model)
																								throws Exception {
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		WebUtil.setPoPropertyByRequest(roleQueryOrder, request);
		roleQueryOrder.setPageSize(pageParam.getPageSize());
		roleQueryOrder.setPageNumber(pageParam.getPageNo());
		//roleQueryOrder.setType(UserTypeEnum.JG);
		roleQueryOrder.setRoleEnum(SysUserRoleEnum.SELLER);
		roleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		roleQueryOrder.setMerchantStateEnum(MerchantStateEnum.getByCode(request
			.getParameter("merchantState")));
		QueryBaseBatchResult<InstitutionsInfo> baseBatchResult = userQueryService
			.queryRoleMerchantUserInfo(roleQueryOrder);
		UserRoleQueryOrder spotQueryOrder = new UserRoleQueryOrder();
		spotQueryOrder.setPageNumber(-1);
		spotQueryOrder.setType(UserTypeEnum.JG);
		spotQueryOrder.setRoleEnum(SysUserRoleEnum.VISITOR_CENTER);
		spotQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		QueryBaseBatchResult<UserInfo> spotList = userQueryService
				.queryRoleUserInfo(spotQueryOrder);
		model.addAttribute("spotList", spotList.getPageList());
		model.addAttribute("queryConditions", roleQueryOrder);
		model.addAttribute("page", PageUtil.getCovertPage(baseBatchResult));
		return USER_MANAGE_PATH + "merchantManage.vm";
	}
	
	@RequestMapping("institutionManage/addInstitutionsUser.htm")
	public String addInstitutionsUser(Model model, String roleEnum) throws Exception {
		model.addAttribute("uploadHost", "");
		model.addAttribute("roleEnum", roleEnum);
		return USER_MANAGE_PATH + "addInstitutionsUser.vm";
	}
	
	@RequestMapping("institutionManage/addMerchantUser.htm")
	public String addMerchantUser(Model model) throws Exception {
		model.addAttribute("uploadHost", "");
		return USER_MANAGE_PATH + "addInstitutionsUser.vm";
	}
	
	@ResponseBody
	@RequestMapping("institutionManage/addInstitutionsUserSubmit.htm")
	public Object institutionsManageSubmit(HttpServletRequest request) {
		JSONObject jsonobj = new JSONObject();
		InstitutionsBaskstageRegisterOrder registerOrder = new InstitutionsBaskstageRegisterOrder();
		
		WebUtil.setPoPropertyByRequest(registerOrder, request);
		
		setRoles(request, registerOrder);
		registerOrder.setUserCustomType(UserBizTypeEnum.BUYER);
		if ("small".equals(request.getParameter("enterpriseType"))) {
			registerOrder.setEnterpriseType(P2PEnterpriseTypeEnum.SMALL_AND_MICRO);
		} else {
			registerOrder.setEnterpriseType(P2PEnterpriseTypeEnum.TICKET);
		}
		if (StringUtil.isEmpty(registerOrder.getCertFrontPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传身份证正面照片");
			return jsonobj;
		}
		
		if (StringUtil.isEmpty(registerOrder.getCertBackPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传身份证反面照片");
			return jsonobj;
		}
		
		//		if (registerOrder.getRole() == null || registerOrder.getRole().size() <= 1) {
		//			jsonobj.put("code", 0);
		//			jsonobj.put("message", "请选择机构角色");
		//			return jsonobj;
		//		}
		
		if (StringUtil.isBlank(registerOrder.getBusinessLicenseCachetPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "上传加盖公章的企业营业执照副本扫描件");
			return jsonobj;
		}
		EsupplierBaseResult baseResult = registerService
			.InstitutionsBaskstageRegister(registerOrder);
		if (baseResult.isSuccess()) {
			
			jsonobj.put("code", 1);
			jsonobj.put("message", "创建机构用户成功");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "创建机构用户失败【" + baseResult.getMessage() + "】");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("institutionManage/addMerchantUserSubmit.htm")
	public Object addMerchantUserSubmit(HttpServletRequest request) {
		JSONObject jsonobj = new JSONObject();
		InstitutionsBaskstageRegisterOrder registerOrder = new InstitutionsBaskstageRegisterOrder();
		
		WebUtil.setPoPropertyByRequest(registerOrder, request);
		
		setRoles(request, registerOrder);
		registerOrder.setUserCustomType(UserBizTypeEnum.SELLER);
		if ("small".equals(request.getParameter("enterpriseType"))) {
			registerOrder.setEnterpriseType(P2PEnterpriseTypeEnum.SMALL_AND_MICRO);
		} else {
			registerOrder.setEnterpriseType(P2PEnterpriseTypeEnum.TICKET);
		}
		/*if (StringUtil.isEmpty(registerOrder.getCertFrontPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传身份证正面照片");
			return jsonobj;
		}
		
		if (StringUtil.isEmpty(registerOrder.getCertBackPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传身份证反面照片");
			return jsonobj;
		}
		
		//		if (registerOrder.getRole() == null || registerOrder.getRole().size() <= 1) {
		//			jsonobj.put("code", 0);
		//			jsonobj.put("message", "请选择机构角色");
		//			return jsonobj;
		//		}
		
		if (StringUtil.isBlank(registerOrder.getBusinessLicenseCachetPath())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "上传加盖公章的企业营业执照副本扫描件");
			return jsonobj;
		}*/
		if (StringUtil.isEmpty(registerOrder.getMerchantPicPath1())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传商户照片1");
			return jsonobj;
		}
		if (StringUtil.isEmpty(registerOrder.getMerchantPicPath2())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传商户照片2");
			return jsonobj;
		}
		if (StringUtil.isEmpty(registerOrder.getMerchantPicPath3())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传商户照片3");
			return jsonobj;
		}
		if (StringUtil.isEmpty(registerOrder.getMerchantPicPath4())) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "请上传商户照片4");
			return jsonobj;
		}
		EsupplierBaseResult baseResult = registerService
			.InstitutionsBaskstageRegister(registerOrder);
		if (baseResult.isSuccess()) {
			
			jsonobj.put("code", 1);
			jsonobj.put("message", "创建商户成功");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "创建商户失败【" + baseResult.getMessage() + "】");
		}
		return jsonobj;
	}
	
	@RequestMapping("institutionManage/updateInstitutionsUser.htm")
	public String updateInstitutionsUser(String userBaseId, long userId, Model model,String roleEnum)
																						throws Exception {
		model.addAttribute("uploadHost", "");
		List<RoleInfo> roleList = authorityService.getRolesByUserId(userId);
		InstitutionsInfo institutionsInfo = userQueryService.queryInstitutionsInfoByBaseId(
			userBaseId).getQueryInstitutionsInfo();
		UserInfo userInfo = userQueryService.queryByUserBaseId(userBaseId).getQueryUserInfo();
		
		if (userInfo != null) {
			BeanCopier.staticCopy(userInfo, institutionsInfo);
		}
		model.addAttribute("roleEnum", roleEnum);
		model.addAttribute("roleList", roleList);
		model.addAttribute("info", institutionsInfo);
		model.addAttribute("userInfo", userInfo);
		return USER_MANAGE_PATH + "updateInstitutionsUser.vm";
	}
	
	@RequestMapping("institutionManage/merchantUserDetail.htm")
	public String merchantUserUserDetail(String supplierId, Model model) throws Exception {
		model.addAttribute("uploadHost", "");
		InstitutionsInfoQueryResult queryResult = userQueryService.queryMerchantInfoByUserId(Long.parseLong(supplierId));
		if(queryResult == null){
			queryResult = new InstitutionsInfoQueryResult();
			queryResult.setQueryInstitutionsInfo(new InstitutionsInfo());
		}
		InstitutionsInfo institutionsInfo = queryResult.getQueryInstitutionsInfo();
		//ScenicQueryResult sqr = scenicService.queryByUserBaseId(userBaseId);
		model.addAttribute("info", institutionsInfo);
		//model.addAttribute("scenic", sqr.getQueryScenicInfo());
		return USER_MANAGE_PATH + "merchantUserDetail.vm";
	}
	
	@ResponseBody
	@RequestMapping("institutionManage/updateInstitutionsUserSubmit.htm")
	public Object updateInstitutionsUserSubmit(HttpServletRequest request) throws Exception {
		UpdateEnterpriseOrder updateOrder = new UpdateEnterpriseOrder();
		LoanerBaseInfoOrder loanerOrder = new LoanerBaseInfoOrder();
		//	CommonAttachmentOrder attachment = new CommonAttachmentOrder();
		JSONObject jsonobj = new JSONObject();
		WebUtil.setPoPropertyByRequest(updateOrder, request);
		WebUtil.setPoPropertyByRequest(loanerOrder, request);
		setRoles(request, updateOrder);
		if (StringUtil.isBlank(request.getParameter("mobileBinding"))) {
			updateOrder.setMobileBinding(BooleanEnum.NO);
		} else {
			updateOrder.setMobileBinding(BooleanEnum.getByCode(request
				.getParameter("mobileBinding")));
		}
		if (StringUtil.isBlank(request.getParameter("mailBinding"))) {
			updateOrder.setMailBinding(BooleanEnum.NO);
		} else {
			updateOrder.setMailBinding(BooleanEnum.getByCode(request.getParameter("mailBinding")));
		}
		
		//		if (updateOrder.getRole() == null || updateOrder.getRole().size() <= 1) {
		//			jsonobj.put("code", 0);
		//			jsonobj.put("message", "请选择机构角色");
		//			return jsonobj;
		//		}
		//		
		UserInfo userInfo = userQueryService.queryByUserId(loanerOrder.getUserId())
			.getQueryUserInfo();
		updateOrder.setUserName(userInfo.getUserName());
		updateOrder.setIdentityName(userInfo.getIdentityName());
		EsupplierBaseResult yrdBaseResult = registerService.updateOrgBackstageRegister(updateOrder);
		
		if (yrdBaseResult.isSuccess()) {
			
			jsonobj.put("code", 1);
			jsonobj.put("message", "修改机构信息成功");
		}
		if (!yrdBaseResult.isSuccess()) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "修改机构信息失败,原因（" + yrdBaseResult.getMessage() + "）");
		}
		return jsonobj;
	}
	
	/**
	 * 后台企业实名认证
	 * @param userBaseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("institutionManage/updateInstitutionsUser/backEnterpriseRealNameAuth.htm")
	public Object backEnterpriseRealNameAuth(String userBaseId) {
		JSONObject jsonobj = new JSONObject();
		try {
			
			EsupplierBaseResult baseResult = this.realNameAuthenticationService
				.sendEnterpriseRealNameInfo(userBaseId);
			if (baseResult.isSuccess()) {
				jsonobj.put("code", 1);
				jsonobj.put("message", baseResult.getMessage());
			} else {
				jsonobj.put("code", 0);
				jsonobj.put("message", baseResult.getMessage());
			}
		} catch (Exception e) {
			logger.error("后台企业实名发送或更新实名状态异常", e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "后台企业实名发送或更新实名状态异常");
		}
		return jsonobj;
	}
	
}
