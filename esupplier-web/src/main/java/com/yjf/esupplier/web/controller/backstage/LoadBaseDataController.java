package com.yjf.esupplier.web.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

@Controller
@RequestMapping("admin/basedata")
public class LoadBaseDataController extends BaseAutowiredController {
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "getRealName.htm")
	public Object getRealName(String userName) {
		logger.info("验证借款人，入参[{}]", userName);
		JSONObject jsonobj = new JSONObject();
		UserInfo userInfo = userQueryService.queryByUserName(userName).getQueryUserInfo();
		if (userInfo != null) {
			jsonobj.put("code", 1);
			jsonobj.put("message", userInfo.getRealName());
			jsonobj.put("userType", userInfo.getType());
			
		} else {
			jsonobj.put("code", 0);
			jsonobj.put("message", "该用户没有取款权限 ");
		}
		return jsonobj;
	}
}
