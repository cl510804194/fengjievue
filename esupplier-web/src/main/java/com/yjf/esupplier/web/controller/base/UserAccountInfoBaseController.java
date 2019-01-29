/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.base;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.CommonUtil;
import com.yjf.esupplier.common.util.YrdConstants;
import com.yjf.esupplier.integration.openapi.info.YjfAccountInfo;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.info.InstitutionsInfo;
import com.yjf.esupplier.service.user.info.PersonalInfo;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.order.UpdateRealNameStatusOrder;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.CertifyStatusEnum;
import com.yjf.esupplier.ws.enums.RealNameAuthStatusEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;

/**
 * 
 * @Filename UserAccountInfoBaseController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-5-18</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 * 
 */
public class UserAccountInfoBaseController extends BaseAutowiredController {
	protected void initAccountInfo(Model model, boolean isInitUserBase) {
		if (ShiroSessionUtils.getSessionLocal() != null
			&& StringUtil.isNotEmpty(ShiroSessionUtils.getSessionLocal().getAccountId())) {
			
			YjfAccountInfo accountInfo = userAccountQueryService.getAccountInfo(
				ShiroSessionUtils.getSessionLocal()).getYjfAccountInfo();
			if (isInitUserBase)
				getUserBaseInfo(null, model);
			model.addAttribute("yjfAccountInfo", accountInfo);
			model.addAttribute("certifyLevel", ShiroSessionUtils.getSessionLocal()
				.getCertifyLevel());
		}
		
	}
	
	protected void initAccountInfo(Model model) {
		initAccountInfo(model, true);
	}
	
	protected YjfAccountInfo getAccountInfo(Model model) {
		YjfAccountInfo accountInfo = (YjfAccountInfo) model.asMap().get("yjfAccountInfo");
		if (accountInfo == null) {
			initAccountInfo(model);
			accountInfo = (YjfAccountInfo) model.asMap().get("yjfAccountInfo");
		}
		return accountInfo;
	}
	
	/**
	 * @param session
	 * @param model
	 * 
	 * @return
	 */
	
	protected UserInfo getUserBaseInfo(HttpSession session, Model model) {
		UserInfo userBaseInfo = null;
		try {
			userBaseInfo = (UserInfo) model.asMap().get("userBaseInfo");
			if (userBaseInfo != null) {
				return userBaseInfo;
			}
			if (ShiroSessionUtils.getSessionLocal() == null
				|| ShiroSessionUtils.getSessionLocal().getUserId() <= 0) {
				return null;
			}
			userBaseInfo = userQueryService.queryByUserBaseId(
				ShiroSessionUtils.getSessionLocal().getUserBaseId()).getQueryUserInfo();
			if ("JG".equals(userBaseInfo.getType())) {
				if (session != null)
					session.setAttribute("type", "JG");
				String filteredGuarantees = YrdConstants.GuaranteeAuthFilterCanstants.FILTEREDGUARANTEES;
				if (filteredGuarantees.indexOf(userBaseInfo.getRealName()) >= 0) {
					if (session != null)
						session.setAttribute("DBSH", "YES");
				}
			} else {
				if (session != null)
					session.setAttribute("type", "GR");
			}
		} catch (Exception e) {
			logger.error("未找到当前登录的用户", e);
		}
		model.addAttribute("userBaseInfo", userBaseInfo);
		try {
			queryUserInfo(session, model);
		} catch (Exception e) {
			logger.error("查询银行信息异常", e);
		}
		
		if (CommonUtil.checkEmail(userBaseInfo.getMail())) {
			model.addAttribute("mailBinding", "IS");
		} else {
			model.addAttribute("mailBinding", "NO");
		}
		return userBaseInfo;
		
	}
	
	protected void setRealSafety(HttpSession session, Model model) {
		UserInfo userInfo = getUserBaseInfo(session, model);
		int level = 0;
		if (userInfo.getRealNameAuthentication() == RealNameAuthStatusEnum.IS) {
			level++;
		}
		if (userInfo.getMailBinding() == BooleanEnum.IS
			|| userInfo.getMobileBinding() == BooleanEnum.IS) {
			level++;
		}
		model.addAttribute("safetyLevel", getSafetyName(level));
		model.addAttribute("safetyLevelValue", level);
	}
	
	private String getSafetyName(int level) {
		if (level == 0)
			return "低";
		if (level == 1)
			return "中";
		if (level == 2)
			return "高";
		return "低";
		
	}
	
	protected void queryUserInfo(HttpSession session, Model model) throws Exception {
		
		String msg = "暂无";
		
		UserInfo userBaseInfoDO = (UserInfo) model.asMap().get("userBaseInfo");
		if (userBaseInfoDO == null && ShiroSessionUtils.getSessionLocal() != null) {
			userBaseInfoDO = userQueryService.queryByUserId(
				ShiroSessionUtils.getSessionLocal().getUserId()).getQueryUserInfo();
			model.addAttribute("userBaseInfo", userBaseInfoDO);
		} else {
			return;
		}
		if (userBaseInfoDO.getRealNameAuthentication() == null) {
			model.addAttribute("realNameStatus", "N");
		} else {
			model.addAttribute("realNameStatus", userBaseInfoDO.getRealNameAuthentication());
		}
		if (userBaseInfoDO.getType() == UserTypeEnum.GR) {
			PersonalInfo personalInfo = userQueryService.queryPersonalInfoByBaseId(
				userBaseInfoDO.getUserBaseId()).getQueryPersonalInfo();
			
			model.addAttribute("info", personalInfo);
			String mobile = userBaseInfoDO.getMobile();
			if (!StringUtil.isEmpty(mobile)) {
				model.addAttribute(
					"mobile",
					mobile.substring(0, 3) + "*****"
							+ mobile.subSequence(mobile.length() - 3, mobile.length()));
			} else {
				model.addAttribute("mobile", msg);
			}
			String mail = userBaseInfoDO.getMail();
			if (!StringUtil.isEmpty(mail)) {
				String[] strMail = mail.split("@");
				model.addAttribute("mail", strMail[0].substring(0, 2) + "*******" + "@"
											+ strMail[1]);
			} else {
				model.addAttribute("mail", msg);
			}
			String certNo = personalInfo.getCertNo();
			if (!StringUtil.isEmpty(certNo)) {
				model.addAttribute(
					"certNo",
					certNo.substring(0, 2) + "**************"
							+ certNo.subSequence(certNo.length() - 2, certNo.length()));
			} else {
				model.addAttribute("certNo", msg);
			}
		}
		if (userBaseInfoDO.getType() == UserTypeEnum.JG) {
			InstitutionsInfo institutionsInfo = userQueryService.queryInstitutionsInfoByBaseId(
				userBaseInfoDO.getUserBaseId()).getQueryInstitutionsInfo();
			
			if (userBaseInfoDO != null) {
				BeanCopier.staticCopy(userBaseInfoDO, institutionsInfo);
			}
			model.addAttribute("info", institutionsInfo);
			String contactCertNo = institutionsInfo.getContactCertNo();// 联系人身份证号
			if (!StringUtil.isEmpty(contactCertNo)) {
				model.addAttribute(
					"contactCertNo",
					contactCertNo.substring(0, 2)
							+ "*************"
							+ contactCertNo.subSequence(contactCertNo.length() - 2,
								contactCertNo.length()));
			} else {
				model.addAttribute("contactCertNo", msg);
			}
			String legalCrdNo = institutionsInfo.getLegalRepresentativeCardNo();
			if (!StringUtil.isEmpty(legalCrdNo)) {
				model.addAttribute(
					"legalCrdNo",
					legalCrdNo.substring(0, 2)
							+ "**************"
							+ contactCertNo.subSequence(contactCertNo.length() - 2,
								contactCertNo.length()));
			} else {
				model.addAttribute("legalCrdNo", msg);
			}
			String mobile = userBaseInfoDO.getMobile();
			if (!StringUtil.isEmpty(mobile)) {
				model.addAttribute(
					"mobile",
					mobile.substring(0, 2) + "*******"
							+ mobile.subSequence(mobile.length() - 2, mobile.length()));
			} else {
				model.addAttribute("mobile", msg);
			}
			
			String mail = userBaseInfoDO.getMail();
			if (!StringUtil.isEmpty(mail)) {
				String[] strMail = mail.split("@");
				model.addAttribute("mail", strMail[0].substring(0, 2) + "*******" + "@"
											+ strMail[1]);
			} else {
				model.addAttribute("mail", msg);
			}
		}
		
		model.addAttribute("type", userBaseInfoDO.getType());
		
	}
	
	/**
	 * 更新本地账户的实名认证状态
	 * @param userBaseInfo
	 * @param accountInfo
	 */
	protected void updateLocalAccountByRemote(UserInfo userBaseInfo, YjfAccountInfo accountInfo) {
		if (accountInfo != null) {
			// 特殊情况 实名认证不一致 “认证成功”
			if (CertifyStatusEnum.AUTHORIZED.message().equals(accountInfo.getCertifyStatus())) {
				if (userBaseInfo.getRealNameAuthentication() == null
					|| !BooleanEnum.IS.code().equals(
						userBaseInfo.getRealNameAuthentication().code())) {
					UpdateRealNameStatusOrder order = new UpdateRealNameStatusOrder();
					order.setCertNo(accountInfo.getCertNo());
					order.setYjfReturnStatus(RealNameAuthStatusEnum.IS.getYjfStatus());
					order.setRealName(accountInfo.getRealName());
					order.setAccountId(accountInfo.getUserId());
					userBaseInfoManager.updateRealNameStatus(order);
					userBaseInfo.setRealNameAuthentication(RealNameAuthStatusEnum.IS);
				}
			}
			// 实名“认证被驳回”，同步到易八
			if (CertifyStatusEnum.REJECT.message().equals(accountInfo.getCertifyStatus())) {
				if (userBaseInfo.getRealNameAuthentication() == null
					|| !BooleanEnum.NO.code().equals(
						userBaseInfo.getRealNameAuthentication().code())) {
					UpdateRealNameStatusOrder order = new UpdateRealNameStatusOrder();
					order.setCertNo(accountInfo.getCertNo());
					order.setYjfReturnStatus(RealNameAuthStatusEnum.NO.getYjfStatus());
					order.setRealName(accountInfo.getRealName());
					order.setAccountId(accountInfo.getUserId());
					userBaseInfoManager.updateRealNameStatus(order);
					userBaseInfo.setRealNameAuthentication(RealNameAuthStatusEnum.NO);
				}
			}
			
		}
	}
}
