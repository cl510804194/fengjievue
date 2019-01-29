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
@RequestMapping("/do/scenic/doCenter/directSend")
public class DirectSendPreController extends DirectSendController {
	
	@Autowired
	DirectSendService directSendService;
	
	/**
	 * 页面所在路径
	 */
	private  String BORROWING_MANAGE__PATH = "/front/directSend/";
	
	@RequestMapping(value = "directSend")
	public String directSend(Model model, HttpSession session) {	
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return 	super.directSend(model, session);
	}
	
	@ResponseBody
	@RequestMapping(value = "directSendSubmit")
	public Object directSendSubmit(HttpServletRequest request, HttpSession session, Model model)
																								throws Exception {
		return super.directSendSubmit(request, session, model);
	}
	
	@ResponseBody
	@RequestMapping(value = "directSendVipSubmit")
	public Object directSendVipSubmit(long activityId, long investAmount, String investTimeStart,
										String investTimeEnd, String content, Model model)
																							throws Exception {
		
		return super.directSendVipSubmit(activityId, investAmount, investTimeStart, investTimeEnd, content, model);
	}
	
	@ResponseBody
	@RequestMapping("getRealName")
	public Object getRealName(String userName) throws Exception {
		return super.getRealName(userName);
	}
	
	@ResponseBody
	@RequestMapping("getRealNameAndChildrenNum")
	public Object getRealNameAndRole(String userName, int roleId) throws Exception {
		return super.getRealNameAndRole(userName, roleId);
	}
	
}
