package com.yjf.esupplier.web.controller.backstage.trademanage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

@RequestMapping(value = "backstage")
@Controller
public class DataFixController extends BaseAutowiredController {
	/** 通用页面路径 */
	String VM_PATH = "/backstage/trade/";
	
	@RequestMapping("fixData")
	public String fixData(Model model) throws Exception {
		
		return VM_PATH + "fix-data.vm";
	}
	
	@RequestMapping("fixAmountFlowData")
	@ResponseBody
	public Object fixAmountFlowData(Model model) throws Exception {
		JSONObject json = new JSONObject();
		try {
			
			json.put("code", "1");
			json.put("message", "成功修复");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("message", "修复异常" + e.getMessage());
		}
		return json;
	}
}
