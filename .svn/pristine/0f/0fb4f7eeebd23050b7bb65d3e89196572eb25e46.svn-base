/**
 * www.househood.net Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.backstage.messageManager;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.UserQueryService;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.page.PageParamUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.common.info.MessageInfo;
import com.yjf.esupplier.service.common.info.MessageReceivedInfo;
import com.yjf.esupplier.service.common.services.SiteMessageService;
import com.yjf.esupplier.service.common.services.order.MessageOrder;
import com.yjf.esupplier.service.common.services.order.QueryMessageOrder;
import com.yjf.esupplier.service.common.services.order.QueryReceviedMessageOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.NotificationTypeEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Filename MessageManagerController.java
 *
 * @Description 站内消息管理
 *
 * @Version 1.0
 *
 * @Author sxiaomeng
 *
 * @Email sxm@yiji.com
 *
 * @History
 * <li>Author: sxiaomeng</li>
 * <li>Date: 2015-3-9</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
@Controller
@RequestMapping("admin")
public class MessageManagerController {
	
	/** 通用页面路径 */
	String USER_MANAGE_PATH = "/backstage/message/";
	
	@Autowired
	SiteMessageService siteMessageService;
	@Autowired
	UserQueryService userQueryService;
	
	/*
	 * 站内信列表
	 */
	@RequestMapping("messageList.htm")
	public String messageList(	HttpSession session, HttpServletRequest request, PageParam pageParam,
								Model model) {
		QueryMessageOrder queryMessageOrder = new QueryMessageOrder();
		WebUtil.setPoPropertyByRequest(queryMessageOrder, request);
		queryMessageOrder.setPageNumber(pageParam.getPageNo());
		queryMessageOrder.setPageSize(pageParam.getPageSize());
		QueryBaseBatchResult<MessageInfo> messageInfoList = siteMessageService
			.findMessage(queryMessageOrder);
			
		List<MessageInfo> infos = messageInfoList.getPageList();
		int totalSize = (int) messageInfoList.getPageCount();
		int start = PageParamUtil.startValue(totalSize, (int) messageInfoList.getPageSize(),
			(int) messageInfoList.getPageSize());
		Page<MessageInfo> page = new Page<MessageInfo>(start, totalSize,
			(int) messageInfoList.getPageSize(), infos);
		model.addAttribute("page", PageUtil.getCovertPage(messageInfoList));
		model.addAttribute("queryMessageOrder", queryMessageOrder);
		return USER_MANAGE_PATH + "messageList.vm";
	}
	
	/*
	 * 站内信詳情
	 */
	@RequestMapping("messageInfo.htm")
	public String messageInfo(	HttpSession session, HttpServletRequest request,
								HttpServletResponse response, Model model) {
		QueryMessageOrder queryMessageOrder = new QueryMessageOrder();
		WebUtil.setPoPropertyByRequest(queryMessageOrder, request);
		QueryBaseBatchResult<MessageInfo> messageInfoList = siteMessageService
			.findMessage(queryMessageOrder);
		QueryReceviedMessageOrder queryMessageReceviedOrder = new QueryReceviedMessageOrder();
		queryMessageReceviedOrder.setMessageId(queryMessageOrder.getMessageId());
		QueryBaseBatchResult<MessageReceivedInfo> messageReceivedInfoList = siteMessageService
			.findReceviedMessage(queryMessageReceviedOrder);
		if (messageInfoList != null) {
			model.addAttribute("info", messageInfoList.getPageList().get(0));
			model.addAttribute("receivedNum", messageReceivedInfoList.getTotalCount());
		}
		return USER_MANAGE_PATH + "messagerInfo.vm";
	}
	
	/*
	 * 添加站内消息
	 */
	@RequestMapping("addMessage.htm")
	public String addMessage(Model model, String flag) {
		model.addAttribute("flag", flag);
		return USER_MANAGE_PATH + "addMessage.vm";
	}
	
	/**
	 * 保存message
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addMessage.json")
	public Object saveMessage(HttpServletRequest request) {
		JSONObject jsonobj = new JSONObject();
		
		String flag = request.getParameter("messageType");
		MessageOrder messageOrder = new MessageOrder();
		WebUtil.setPoPropertyByRequest(messageOrder, request);
		messageOrder.setIsSendMessage(BooleanEnum.YES);
		messageOrder.setMessageSenderName(ShiroSessionUtils.getSessionLocal().getRealName());
		messageOrder.setMessageSenderId(ShiroSessionUtils.getSessionLocal().getUserId());
		messageOrder.setMessageType(messageOrder.getMessageType());
		messageOrder.setNotificationType(
			NotificationTypeEnum.getByCode(request.getParameter("notificationType")));
		String userName = request.getParameter("userName");
		if (StringUtil.isBlank(userName)) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "用户名不存在");
			return jsonobj;
		}
		if (userName != null) {
			userName = userName.replaceAll("，", ",");
			String[] sendUserNames = userName.split(",");
			long[] sendUserIdLong = new long[sendUserNames.length];
			for (int i = 0; i < sendUserNames.length; i++) {
				String sendUserName = sendUserNames[i];
				UserInfo userInfo = userQueryService.queryByUserName(sendUserName)
					.getQueryUserInfo();
				if (userInfo == null) {
					jsonobj.put("code", 0);
					jsonobj.put("message", "用户ID：" + sendUserName + "无效！");
					return jsonobj;
				}
				sendUserIdLong[i] = userInfo.getUserId();
			}
			messageOrder.setSendUserId(sendUserIdLong);
		}
		if (flag != null && flag.equals("QUICK")) {
			UserRoleQueryOrder commonQueryOrder = new UserRoleQueryOrder();
			commonQueryOrder
				.setType(UserTypeEnum.getByCode(messageOrder.getNotificationType().code()));
			commonQueryOrder.setPageSize(99999999);
			QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
				.queryRoleUserInfo(commonQueryOrder);
			List<UserInfo> userInfos = baseBatchResult.getPageList();
			long[] sendUserIdLong = new long[userInfos.size()];
			for (int i = 0; i < userInfos.size(); i++) {
				UserInfo userInfo = userInfos.get(i);
				sendUserIdLong[i] = userInfo.getUserId();
			}
			messageOrder.setSendUserId(sendUserIdLong);
		}
		EsupplierBaseResult baseResult = siteMessageService.addMessageInfo(messageOrder);
		if (baseResult.isSuccess()) {
			jsonobj.put("code", 1);
			jsonobj.put("message", "发送站内信成功！");
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "发送站内信失败！");
		}
		return jsonobj;
	}
}
