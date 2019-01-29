package com.yjf.esupplier.web.controller.front.message;

/**
 * Created by Administrator on 2015/3/10.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.page.PageParamUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.dal.daointerface.MessageReceivedDAO;
import com.yjf.esupplier.service.common.info.MessageReceivedInfo;
import com.yjf.esupplier.service.common.services.SiteMessageService;
import com.yjf.esupplier.service.common.services.order.MyMessageOrder;
import com.yjf.esupplier.service.common.services.order.QueryReceviedMessageOrder;
import com.yjf.esupplier.service.common.services.result.MessageResult;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.user.IOperatorInfoService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.MessageReceivedStatusEnum;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * @Filename MessageController.java
 * @Description 站内消息管理
 * @Version 1.0
 * @Author sxiaomeng
 * @Email sxm@yiji.com
 * @History <li>Author: sxiaomeng</li> <li>Date: 2015-3-10</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/do/message")
public class MessageController {
	
	@Autowired
	SiteMessageService siteMessageService;
	
	@Autowired
	MessageReceivedDAO messageReceivedDAO;
	@Autowired
	protected IOperatorInfoService operatorInfoService;
	
	private final String USER_MANAGE_PATH = "front/user/message/";
	
	/*
	 * 查詢消息
	 */
	@RequestMapping("messageInfoList.htm")
	public String messageInfoList(HttpSession session, HttpServletRequest request,
									PageParam pageParam, Model model, String status) {
		//    	initAccountInfo(model);
		
		//用户信息
		UserInfo userBaseInfo = new UserInfo();
		
		//操作员查询
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("userBaseId", userBaseInfo.getUserBaseId());
		conditions.put("limitStart", 0);
		conditions.put("pageSize", 9999);
		//        List<OperatorInfoDO> operatorInfos = operatorInfoService
		//                .queryOperatorsByProperties(conditions);
		//        if (operatorInfos != null && operatorInfos.size() > 0) {
		//            session.setAttribute("operator", "yes");
		//            if (2 == operatorInfos.get(0).getOperatorType()
		//                    || 3 == operatorInfos.get(0).getOperatorType()) {
		//
		//            } else {
		//                session.setAttribute("tasks", "two");
		//            }
		//        } else {
		//            session.setAttribute("operator", "no");
		//        }
		
		QueryReceviedMessageOrder queryMessageOrder = new QueryReceviedMessageOrder();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		queryMessageOrder.setMessageReceivedId(userId);
		List<MessageReceivedStatusEnum> statusList = new ArrayList<>();
		if (StringUtil.isEmpty(status)) {
			statusList.add(MessageReceivedStatusEnum.UNREAD);
			statusList.add(MessageReceivedStatusEnum.READ);
			statusList.add(MessageReceivedStatusEnum.COLLECT);
		} else {
			statusList.add(MessageReceivedStatusEnum.getByCode(status));
		}
		queryMessageOrder.setStatusList(statusList);
		queryMessageOrder.setPageNumber(pageParam.getPageNo());
		queryMessageOrder.setPageSize(pageParam.getPageSize());
		QueryBaseBatchResult<MessageReceivedInfo> messageInfoList = siteMessageService
			.findReceviedMessage(queryMessageOrder);
		List<MessageReceivedInfo> infos = messageInfoList.getPageList();
		int totalSize = (int) messageInfoList.getPageCount();
		int start = PageParamUtil.startValue(totalSize, (int) messageInfoList.getPageSize(),
			(int) messageInfoList.getPageSize());
		Page<MessageReceivedInfo> page = new Page<MessageReceivedInfo>(start, totalSize,
			(int) messageInfoList.getPageSize(), infos);
		model.addAttribute("page", PageUtil.getCovertPage(messageInfoList));
		model.addAttribute("status", status);
		return USER_MANAGE_PATH + "messageInfoList.vm";
	}
	
	/*
	 * 查詢消息
	 */
	@ResponseBody
	@RequestMapping("ajaxLoadUnReadData.json")
	public Object ajaxLoadUnReadData() {
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		QueryBaseBatchResult<MessageReceivedInfo> baseResult = siteMessageService
			.loadUnReadMyMessage(userId);
		JSONObject jsonObject = new JSONObject();
		/*     if (YrdResultEnum.EXECUTE_SUCCESS == baseResult.getYrdResultEnum()){
		         jsonObject.put("success","true");
		     }else {
		         jsonObject.put("success","false");
		     }*/
		jsonObject.put("count", baseResult.getTotalCount());
		return jsonObject;
	}
	
	/*
	 * 修改消息
	 */
	@RequestMapping("updateMessageInfo.htm")
	public ModelAndView updateMessageInfo(HttpSession session, HttpServletRequest request,
											HttpServletResponse response, Model model, String status) {
		//    	initAccountInfo(model);
		//		getUserBaseInfo(request.getSession(), model);
		MyMessageOrder myMessageOrder = new MyMessageOrder();
		MessageResult messageResult = null;
		String[] receivedId = request.getParameterValues("receivedId");
		String type = request.getParameter("type");
		WebUtil.setPoPropertyByRequest(myMessageOrder, request);
		if (type.equals(MessageReceivedStatusEnum.COLLECT.code())) {
			myMessageOrder.setMessageReceivedStatus(MessageReceivedStatusEnum.COLLECT.code());
		} else if (type.equals(MessageReceivedStatusEnum.READ.code())) {
			myMessageOrder.setMessageReceivedStatus(MessageReceivedStatusEnum.READ.code());
		}
		myMessageOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		for (String receivedIds : receivedId) {
			myMessageOrder.setReceivedId(NumberUtil.parseLong(receivedIds));
			messageResult = siteMessageService.readMessageInfo(myMessageOrder);
		}
		if (StringUtil.isNotEmpty(status)) {
			return new ModelAndView(new RedirectView("/do/message/messageInfoList.htm?status="
														+ status));
		} else {
			return new ModelAndView(new RedirectView("/do/message/messageInfoList.htm"));
		}
	}
	
	/*
	* 修改消息
	*/
	@ResponseBody
	@RequestMapping("ajaxUpdateMessageInfo.json")
	public JSONObject ajaxUpdateMessageInfo(HttpSession session, HttpServletRequest request,
											HttpServletResponse response, Model model, String status) {
		MyMessageOrder myMessageOrder = new MyMessageOrder();
		MessageResult messageResult = null;
		String[] receivedId = request.getParameterValues("receivedId");
		String type = request.getParameter("type");
		WebUtil.setPoPropertyByRequest(myMessageOrder, request);
		if (type.equals(MessageReceivedStatusEnum.COLLECT.code())) {
			myMessageOrder.setMessageReceivedStatus(MessageReceivedStatusEnum.COLLECT.code());
		} else if (type.equals(MessageReceivedStatusEnum.READ.code())) {
			myMessageOrder.setMessageReceivedStatus(MessageReceivedStatusEnum.READ.code());
		}
		myMessageOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		for (String receivedIds : receivedId) {
			myMessageOrder.setReceivedId(NumberUtil.parseLong(receivedIds));
			messageResult = siteMessageService.readMessageInfo(myMessageOrder);
		}
		JSONObject json = new JSONObject();
		/*  if (YrdResultEnum.EXECUTE_SUCCESS == messageResult.getYrdResultEnum()){
		      json.put("result",true);
		  }else {
		      json.put("result",false);
		  }*/
		return json;
	}
	
	/*
	 * 删除收到的消息
	 */
	@RequestMapping("deleteReceivedMessageInfo.htm")
	public void deleteReceivedMessageInfo(HttpSession session, HttpServletRequest request,
											HttpServletResponse response, Model model, String status) {
		MyMessageOrder myMessageOrder = new MyMessageOrder();
		MessageResult messageResult = null;
		String[] receivedId = request.getParameterValues("receivedId");
		myMessageOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
		for (String receivedIds : receivedId) {
			myMessageOrder.setReceivedId(NumberUtil.parseLong(receivedIds));
			messageResult = siteMessageService.deleteReceivedMessageInfo(myMessageOrder);
		}
		model.addAttribute("messageResult", messageResult);
		try {
			response.sendRedirect("/do/message/messageInfoList.htm");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
