package com.yjf.esupplier.web.controller.backstage.bankInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rop.thirdparty.com.google.common.collect.Lists;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.AttachmentModuleType;
import com.yjf.esupplier.ws.base.info.BankBasicInfo;
import com.yjf.esupplier.ws.enums.CommonAttachmentTypeEnum;
import com.yjf.esupplier.ws.info.CommonAttachmentInfo;
import com.yjf.esupplier.ws.order.CommonAttachmentOrder;
import com.yjf.esupplier.ws.order.CommonAttachmentQueryOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.CommonAttachmentService;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/backstage")
public class BankInfoController extends BaseAutowiredController {
	/** 页面所在路径 */
	private final String _PATH = "/admin/bank/";
	@Autowired
	CommonAttachmentService commonAttachmentService;
	
	@RequestMapping(value = "bankInfoManage/add_vm.html")
	public String add_vm(Model model) {
		List<BankBasicInfo> bankList = this.bankDataService.getBankBasicInfos();//获取所有银行
		model.addAttribute("bankList", bankList);
		String s = "bankInfo.vm";
		return _PATH + s;
	}
	
	@RequestMapping(value = "uploadImages2Front.html")
	public String uploadImages2Front(Model model) {
		String uploadHost = AppConstantsUtil.getYrdUploadFolder();
		model.addAttribute("uploadHost", "");
		
		// 前台首页图片
		CommonAttachmentQueryOrder attachmentQueryOrder = new CommonAttachmentQueryOrder();
		attachmentQueryOrder.setBizNo("0000");
		QueryBaseBatchResult<CommonAttachmentInfo> batchResult = commonAttachmentService
			.queryCommonAttachment(attachmentQueryOrder);
		List<AttachmentModuleType> attachmentModuleTypeList = new ArrayList<AttachmentModuleType>();
		for (CommonAttachmentInfo attachmentInfo : batchResult.getPageList()) {
			boolean isExist = false;
			for (AttachmentModuleType attachmentModuleType : attachmentModuleTypeList) {
				if (attachmentInfo.getModuleType() == attachmentModuleType.getModuleType()) {
					attachmentModuleType.getAttachmentInfos().add(attachmentInfo);
					isExist = true;
					break;
				}
			}
			if (!isExist) {
				AttachmentModuleType attachmentModuleType = new AttachmentModuleType();
				attachmentModuleType.setModuleType(attachmentInfo.getModuleType());
				attachmentModuleType.getAttachmentInfos().add(attachmentInfo);
				attachmentModuleTypeList.add(attachmentModuleType);
			}
		}
		model.addAttribute("list", attachmentModuleTypeList);
		return "/admin/upload/uploadFile.vm";
	}
	
	@ResponseBody
	@RequestMapping("updateFontImg")
	public Object updateImgUrlA(HttpServletResponse response, HttpServletRequest request)
																							throws Exception {
		
		EsupplierBaseResult baseResult = addAttachfile("0000", request);
		
		JSONObject json = new JSONObject();
		logger.info("修改附件，入参{}", baseResult);
		
		if (baseResult.isSuccess()) {
			json.put("code", 1);
			json.put("message", "修改成功");
		} else {
			json.put("code", 0);
			json.put("message", "修改失败");
		}
		return json;
		
	}
	
	private EsupplierBaseResult addAttachfile(String param_id, HttpServletRequest request) {
		List<CommonAttachmentOrder> orders = new ArrayList<CommonAttachmentOrder>();
		List<CommonAttachmentTypeEnum> list = Lists.newArrayList();
		for (int i = 0; i < list.size(); i++) {
			CommonAttachmentTypeEnum itemEnum = list.get(i);
			String pathValues = request.getParameter("pathName_" + itemEnum.code());
			if (StringUtil.isNotBlank(pathValues)) {
				String[] attachPaths = pathValues.split(";");
				int j = 1;
				for (String path : attachPaths) {
					String[] paths = path.split(",");
					if (paths.length > 1) {
						CommonAttachmentOrder commonAttachmentOrder = new CommonAttachmentOrder();
						commonAttachmentOrder.setBizNo(param_id);
						commonAttachmentOrder.setModuleType(itemEnum);
						commonAttachmentOrder.setIsort(j++);
						commonAttachmentOrder.setFilePhysicalPath(paths[1]);
						commonAttachmentOrder.setRequestPath(paths[0]);
						orders.add(commonAttachmentOrder);
					}
				}
			}
			
		}
		
		EsupplierBaseResult baseResult = commonAttachmentService.insertAll(orders);
		return baseResult;
	}
	
}