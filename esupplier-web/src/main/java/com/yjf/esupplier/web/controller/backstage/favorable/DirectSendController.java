package com.yjf.esupplier.web.controller.backstage.favorable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.order.UserQueryOrder;
import com.yjf.esupplier.service.user.result.ScenicQueryResult;
import com.yjf.esupplier.service.user.result.UserQueryResult;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.directsend.DirectSendService;
import com.yjf.esupplier.ws.directsend.enums.DirectSendTypeEnum;
import com.yjf.esupplier.ws.directsend.enums.DirectTypeEnum;
import com.yjf.esupplier.ws.directsend.order.DirectSendOrder;
import com.yjf.esupplier.ws.enums.NotificationTypeEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller

public class DirectSendController extends BaseAutowiredController {
	
	@Autowired
	DirectSendService directSendService;
	
	/**
	 * 页面所在路径
	 */
	private String BORROWING_MANAGE__PATH = "/backstage/directSend/";
	
	public String getBORROWING_MANAGE__PATH() {
		return BORROWING_MANAGE__PATH;
	}

	public void setBORROWING_MANAGE__PATH(String BORROWING_MANAGE__PATH) {
		this.BORROWING_MANAGE__PATH = BORROWING_MANAGE__PATH;
	}

	public String directSend(Model model, HttpSession session) {
		
		List<DirectTypeEnum> directTypes = DirectTypeEnum.getAllEnum();
		model.addAttribute("directTypes", directTypes);
		
		List<NotificationTypeEnum> notiTypeEnums = NotificationTypeEnum.getAllEnum();
		List<NotificationTypeEnum> userTypes = new ArrayList<NotificationTypeEnum>();
		for (NotificationTypeEnum ntype : notiTypeEnums) {
			if (NotificationTypeEnum.ALL.code().equals(ntype.code())
				|| NotificationTypeEnum.GENERAL.code().equals(ntype.getCode())
				|| NotificationTypeEnum.VIP.code().equals(ntype.code())
				|| NotificationTypeEnum.GOLD.code().equals(ntype.code())
				|| NotificationTypeEnum.DIAMOND.code().equals(ntype.code())
				|| NotificationTypeEnum.PLATINUM.code().equals(ntype.code())) {
				userTypes.add(ntype);
			}
		}
		
		//---------------------------end----------------------------------------------------------------
		model.addAttribute("userTypes", userTypes);
		session.setAttribute("token", UUID.randomUUID().toString());
		
		model.addAttribute("sendType1", DirectSendTypeEnum.USERGROUP.code());
		model.addAttribute("sendType2", DirectSendTypeEnum.SINGLEUSER.code());
		model.addAttribute("sendType3", DirectSendTypeEnum.MUTIUSER.code());
		
		return BORROWING_MANAGE__PATH + "directSend.vm";
	}
	

	public Object directSendSubmit(HttpServletRequest request, HttpSession session, Model model)
																								throws Exception {
		DirectSendOrder directSendOrder = new DirectSendOrder();
		WebUtil.setPoPropertyByRequest(directSendOrder, request);
		String token = request.getParameter("token");
		directSendOrder.setDirectType(DirectTypeEnum.getByCode(request.getParameter("directType")));
		directSendOrder.setSendType(DirectSendTypeEnum.getByCode(request.getParameter("sendType")));
		directSendOrder.setUserType(request.getParameterValues("userType"));
		directSendOrder.setS_sendValue(request.getParameter("s_sendValue"));
		directSendOrder.setSendValue(request.getParameterValues("sendValue"));
		
		String userBaseId = ShiroSessionUtils.getSessionLocal().getUserBaseId();
		ScenicQueryResult scenicQueryResult = scenicService.queryByUserBaseId(userBaseId);
		ScenicInfo scenicInfo = new ScenicInfo();
		if(scenicQueryResult != null && scenicQueryResult.getQueryScenicInfo() != null){
			scenicInfo = scenicQueryResult.getQueryScenicInfo();
			directSendOrder.setSendAccountCode(scenicInfo.getCode());
			directSendOrder.setSendAccountName(scenicInfo.getShortName());
		}else{
			directSendOrder.setSendAccountName(ShiroSessionUtils.getSessionLocal().getUserName());
		}
		String getToken = (String) session.getAttribute("token");
		JSONObject json = new JSONObject();
		if (StringUtil.equals(getToken, token)) {
			session.removeAttribute("token");
			SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
			String ken = UUID.randomUUID().toString();
			session.setAttribute("token", ken);
			if (sessionLocal == null) {
				json.put("token", ken);
				json.put("code", 0);
				json.put("message", "赠送失败,登录失效!");
				return json;
			}
			
			if (directSendOrder.getSendType() == DirectSendTypeEnum.MUTIUSER) {
				EsupplierBaseResult result = directSendService.batchDirectSend(directSendOrder);
				if (result.isSuccess()) {
					json.put("token", ken);
					json.put("code", 1);
					json.put("message", result.getMessage());
				} else {
					json.put("token", ken);
					json.put("code", 0);
					json.put("message", result.getMessage());
				}
			} else {
				EsupplierBaseResult result = directSendService.directSend(directSendOrder);
				if (result.isSuccess()) {
					json.put("token", ken);
					json.put("code", 1);
					json.put("message", "赠送成功!");
				} else {
					json.put("token", ken);
					json.put("code", 0);
					json.put("message", "赠送失败:" + result.getMessage());
				}
			}
		} else {
			json.put("token", getToken);
			json.put("code", 0);
			json.put("message", "赠送失败:重复提交");
		}
		
		return json;
	}
	

	public Object directSendVipSubmit(long activityId, long investAmount, String investTimeStart,
										String investTimeEnd, String content, Model model)
																							throws Exception {
		
		JSONObject json = new JSONObject();
		
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		if (sessionLocal == null) {
			json.put("code", 0);
			json.put("message", "赠送失败,登录失效!");
			return json;
		}
		
		//		VipActivityDirectSendOrder directSendOrder = new VipActivityDirectSendOrder();
		//		directSendOrder.setActivityId(activityId);
		//		try {
		//			directSendOrder.setInvestAmount(Money.yuan(investAmount));
		//			directSendOrder.setRemark(content);
		//			directSendOrder.setInvestTimeStart(DateUtil.simpleFormatDate(investTimeStart));
		//			directSendOrder.setInvestTimeEnd(DateUtil.simpleFormatDate(investTimeEnd));
		//		} catch (Exception e) {
		//			json.put("code", 0);
		//			json.put("message", "赠送失败,参数解析错误!");
		//			return json;
		//		}
		
		//		EsupplierBaseResult result = vipService.vipDirectSend(directSendOrder);
		//		if (result.isSuccess()) {
		//			json.put("code", 1);
		//			json.put("message", "赠送成功!");
		//		} else {
		//			json.put("code", 0);
		//			json.put("message", "赠送失败:" + result.getMessage());
		//			
		//		}
		return json;
	}
	

	public Object getRealName(String userName) throws Exception {
		JSONObject json = new JSONObject();
		if (StringUtil.isEmpty(userName)) {
			json.put("code", 0);
			return json;
		}
		
		UserQueryResult userResult = userQueryService.queryByUserName(userName);
		if (userResult == null || userResult.getQueryUserInfo() == null) {
			json.put("code", 0);
			return json;
		} else {
			json.put("code", 1);
			json.put("message", userResult.getQueryUserInfo().getRealName());
			return json;
		}
	}
	

	public Object getRealNameAndRole(String userName, int roleId) throws Exception {
		JSONObject json = new JSONObject();
		if (StringUtil.isEmpty(userName)) {
			json.put("code", 0);
			return json;
		}
		
		UserQueryResult userResult = userQueryService.queryByUserName(userName, roleId);
		if (userResult == null || userResult.getQueryUserInfo() == null) {
			json.put("code", 0);
			return json;
		} else {
			json.put("code", 1);
			json.put("realName", userResult.getQueryUserInfo().getRealName());
			
			UserQueryOrder userQueryOrder = new UserQueryOrder();
			userQueryOrder.setState(UserStateEnum.NORMAL);
			
			QueryBaseBatchResult<UserInfo> batchResult = new QueryBaseBatchResult<UserInfo>();
			
			json.put("childrenNum", batchResult.getTotalCount());
			return json;
		}
	}
	
}
