package com.yjf.esupplier.web.controller.backstage.systemSet;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.page.PageParamUtil;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.dal.dataobject.BankBaseInfoDO;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

@Controller
@RequestMapping("admin")
public class SysBankMaintanceController extends BaseAutowiredController {
	private final String vm_path = "/backstage/systemSet/";
	
	@RequestMapping("sysBankInfoManage.htm")
	public String sysBankInfoManage(HttpServletRequest request, Page<BankBaseInfoDO> page,
									PageParam pageParam, BankBaseInfoDO bankBaseInfoDO,
									HttpServletResponse response, Model model, String bankCodeSearch) {
		List<BankBaseInfoDO> list = null;
		bankBaseInfoDO.setBankCode(bankCodeSearch);
		list = bankBaseInfoService.findBankWithCondition(bankBaseInfoDO,
			(pageParam.getPageNo() - 1) * pageParam.getPageSize(), pageParam.getPageSize());
		int totalSize = (int) bankBaseInfoService.searchDataCountWithCondition(bankBaseInfoDO);
		int start = PageParamUtil.startValue(totalSize, pageParam.getPageSize(),
			pageParam.getPageNo());
		page = new Page<BankBaseInfoDO>(start, totalSize, pageParam.getPageSize(), list);
		model.addAttribute("page", page);
		model.addAttribute("bankCodeSearchTest", bankCodeSearch);
		response.setHeader("Pragma", "No-cache");
		return vm_path + "sysBankInfoManage.vm";
	}
	
	@RequestMapping("sysBankInfoManage/editSysBankInfo.htm")
	public String editBankInfo(String bankCode, Model model) {
		
		BankBaseInfoDO bankBaseInfoDO = bankBaseInfoService.findById(bankCode);
		model.addAttribute("info", bankBaseInfoDO);
		return vm_path + "editSysBankBaseInfo.vm";
	}
	
	@ResponseBody
	@RequestMapping("sysBankInfoManage/updateSysBankInfo.json")
	public Object updateSysBankInfo(String bankCode, String bankName, String singleDeductLimit,
									String singleWithdrawalLimit, String signedWay, String isStop,
									String logoUrl, String memo, String rawAddTime,
									String dayWithholdingAmount) {
		JSONObject json = new JSONObject();
		try {
			
			BankBaseInfoDO bankBaseInfoDO = new BankBaseInfoDO();
			bankBaseInfoDO.setBankCode(bankCode);
			if (bankCode == null) {
				throw new SQLException("bankCode is null!");
			}
			bankBaseInfoDO.setBankName(bankName);
			bankBaseInfoDO.setIsStop(isStop);
			bankBaseInfoDO.setLogoUrl(logoUrl);
			bankBaseInfoDO.setMemo(memo);
			if (rawAddTime == null || ("").equals(rawAddTime)) {
				rawAddTime = DateUtil.getNewFormatDateString(new Date());
			}
			bankBaseInfoDO.setRawAddTime(DateUtil.parse(rawAddTime));
			bankBaseInfoDO.setRawUpdateTime(DateUtil.parse(DateUtil
				.getNewFormatDateString(new Date())));
			bankBaseInfoDO.setSignedWay(signedWay);
			if (singleWithdrawalLimit == null || ("").equals(singleWithdrawalLimit)) {
				singleWithdrawalLimit = "0";
			}
			if (singleDeductLimit == null || ("").equals(singleDeductLimit)) {
				singleDeductLimit = "0";
			}
			bankBaseInfoDO.setWithdrawAmount(new Money(singleWithdrawalLimit));
			bankBaseInfoDO.setWithholdingAmount(new Money(singleDeductLimit));
			if (StringUtil.isNotBlank(dayWithholdingAmount)) {
				bankBaseInfoDO.setDayWithholdingAmount(new Money(dayWithholdingAmount));
			}
			
			bankBaseInfoService.update(bankBaseInfoDO);
			json.put("message", "修改银行信息成功");
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			json.put("message", "修改银行信息失败");
		}
		
		return json;
	}
	
	@ResponseBody
	@RequestMapping("sysBankInfoManage/delSysBankInfo.json")
	public Object delSysBankInfo(String bankCode) {
		
		JSONObject json = new JSONObject();
		
		try {
			bankBaseInfoService.deleteById(bankCode);
			json.put("message", "删除银行信息成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			json.put("message", "删除银行信息失败");
		}
		return json;
	}
	
	@RequestMapping("sysBankInfoManage/addBankVM.htm")
	public String addBankVM(Model model) {
		
		//    	List<BankBasicInfo> bankList = bankDataService.getBankBasicInfos();//获取所有银行
		//    	List<BankBaseInfoDO> bankList = bankBaseInfoService.checkNotExistBankInfo(bankBaseInfoService.findAllBankConfigIgnoredStatus());
		//		model.addAttribute("bankList", bankList);
		return vm_path + "addSysBankBaseInfo.vm";
	}
	
	@ResponseBody
	@RequestMapping("sysBankInfoManage/addSysBankBaseInfoSubmit.json")
	public Object addSysBankBaseInfoSubmit(String bankCode, String bankName,
											String singleDeductLimit, String singleWithdrawalLimit,
											String signedWay, String isStop, String logoUrl,
											String memo, String dayWithholdingAmount) {
		
		JSONObject json = new JSONObject();
		try {
			BankBaseInfoDO bankBaseInfoDO = new BankBaseInfoDO();
			bankBaseInfoDO.setBankCode(bankCode);
			bankBaseInfoDO.setBankName(bankName);
			bankBaseInfoDO.setIsStop(isStop);
			bankBaseInfoDO.setLogoUrl(logoUrl);
			bankBaseInfoDO.setMemo(memo);
			String rawAddTime = DateUtil.getNewFormatDateString(new Date());
			bankBaseInfoDO.setRawAddTime(DateUtil.parse(rawAddTime));
			bankBaseInfoDO.setRawUpdateTime(DateUtil.parse(DateUtil
				.getNewFormatDateString(new Date())));
			bankBaseInfoDO.setSignedWay(signedWay);
			if (singleWithdrawalLimit == null || ("").equals(singleWithdrawalLimit)) {
				singleWithdrawalLimit = "0";
			}
			if (singleDeductLimit == null || ("").equals(singleDeductLimit)) {
				singleDeductLimit = "0";
			}
			bankBaseInfoDO.setWithdrawAmount(new Money(singleWithdrawalLimit));
			bankBaseInfoDO.setWithholdingAmount(new Money(singleDeductLimit));
			if (StringUtil.isNotBlank(dayWithholdingAmount)) {
				bankBaseInfoDO.setDayWithholdingAmount(new Money(dayWithholdingAmount));
			}
			
			bankBaseInfoService.insert(bankBaseInfoDO);
			json.put("message", "添加银行信息成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			json.put("message", "添加银行信息失败");
		}
		return json;
	}
	
}
