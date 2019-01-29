package com.yjf.esupplier.web.controller.front.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.yjf.esupplier.ws.enums.PopTypeEnum;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.ws.info.PopInfo;

@Controller
@RequestMapping("/front/platform/appVersion")
public class VersionController {
	@Autowired
	IPopService popService;
	
	@RequestMapping("versionManage.htm")
	public String versionManage(Model model) {
		
		
		Map<String, Object> conditionsA = new HashMap<String, Object>();
		conditionsA.put("type", PopTypeEnum.ANDROID_VERSION.getDbValue());
		List<PopInfo> popInfosA = popService.getListByConditionsNew(conditionsA);
//		Map<String, Object> conditionsI = new HashMap<String, Object>();
//		conditionsI.put("type", PopTypeEnum.IOS_VERSION.getCode());
//		List<PopInfo> popInfosI = popService.getListByConditionsNew(conditionsI);
//		if (popInfos.isEmpty()) {
//			model.addAttribute("aboutUs", "暂无内容！");
//			model.addAttribute("appLogo", "");
//		} else {
//			model.addAttribute("aboutUs", popInfos.get(0).getContent());
//			model.addAttribute("appLogo", popInfos.get(0).getRem1());
//		}
		if(popInfosA.size() > 0){
			model.addAttribute("android_version", popInfosA.get(0).getTitle());
			model.addAttribute("android", popInfosA.get(0).getRem1());
		}
//		model.addAttribute("ios_version", popInfosI.get(0).getTitle());
//		model.addAttribute("ios", popInfosI.get(0).getRem1());
		return "/front/help/wap_download.vm";
		
	}
	
}
