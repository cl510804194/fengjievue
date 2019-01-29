package com.yjf.esupplier.web.controller.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.service.base.data.OpeningDistrictService;
import com.yjf.esupplier.service.openingbank.info.ProvinceInfo;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.base.info.BankBasicInfo;

@Controller
@RequestMapping("/anon/dropDownData")
public class DropDownDataController extends BaseAutowiredController {
	
	@Autowired
	OpeningDistrictService openingDistrictService;
	
	/** 查询所有银行渠道信息 */
	@ResponseBody
	@RequestMapping("getAllBank.json")
	public Object getAllBank() {
		JSONObject jsonobj = new JSONObject();
		List<BankBasicInfo> bankBasicInfos = this.bankDataService.getBankBasicInfos();
		if (bankBasicInfos.size() <= 0) {
			jsonobj.put("code", 0);
			jsonobj.put("data", bankBasicInfos);
		} else {
			jsonobj.put("code", 1);
			jsonobj.put("data", bankBasicInfos);
		}
		return jsonobj;
	}
	
	/** 查询所有省、市 */
	@ResponseBody
	@RequestMapping("getAllDistrict.json")
	public Object getAllDistrict() {
		logger.debug("【查询所有省、市】");
		JSONObject jsonobj = new JSONObject();
		List<ProvinceInfo> provinceList = openingDistrictService.getAllDistrict()
			.getProvinceInfos();
		if (provinceList.size() <= 0) {
			jsonobj.put("code", 0);
			jsonobj.put("data", provinceList);
		} else {
			jsonobj.put("code", 1);
			jsonobj.put("data", provinceList);
		}
		return jsonobj;
	}
}
