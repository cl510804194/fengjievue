package com.yjf.esupplier.web.controller.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.integration.industrial.api.LogisticsInfoQueryService;
import com.yjf.esupplier.integration.industrial.api.info.LogisticsFlowInfo;
import com.yjf.esupplier.integration.industrial.api.result.LogisticsInfoResult;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

@Controller
@RequestMapping("/anon")
public class LogisticsInformationController extends BaseAutowiredController {
	
	@Autowired
	LogisticsInfoQueryService logisticsInfoQueryService;
	
	@RequestMapping("loadLogisticsInformation.json")
	public String loadLogisticsInformation(HttpServletRequest request,
											HttpServletResponse response, Model model) {
		String deliveryId = request.getParameter("deliveryId");
		long logisticsId = NumberUtil.parseLong(request.getParameter("logisticsId"));
		LogisticsInfoResult infoResult = logisticsInfoQueryService.queryShunfengLogisticsInfo(
			deliveryId, getOpenApiContext());
		JSONObject jsonObject = new JSONObject();
		if (infoResult.isSuccess()) {
			jsonObject.put("code", "success");
			if (ListUtil.isNotEmpty(infoResult.getFlowInfos())) {
				JSONArray jsonArray = new JSONArray();
				for (LogisticsFlowInfo flowInfo : infoResult.getFlowInfos()) {
					Map<String, Object> map = MiscUtil.covertPoToMap(flowInfo);
					map.put("acceptTime", DateUtil.simpleFormat(flowInfo.getAcceptTime()));
					jsonArray.add(map);
				}
				jsonObject.put("list", jsonArray);
			}
			jsonObject.put("message", "加载成功");
			
		} else {
			jsonObject.put("code", "error");
			jsonObject.put("message", infoResult.getMessage());
		}
		printHttpResponse(response, jsonObject);
		return null;
	}
}
