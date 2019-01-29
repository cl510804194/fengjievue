package com.yjf.esupplier.web.controller.backstage.popManage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.dal.dataobject.EmailTemplateDO;
import com.yjf.esupplier.service.mail.template.EmailTemplateService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;

@Controller
@RequestMapping("admin")
public class EmailCenterController extends BaseAutowiredController {
	private final String VM_PATH = "/backstage/publicNotice/emailCenter/";
	@Autowired
	EmailTemplateService emailTemplateService;
	
	@RequestMapping("emailCenter.htm")
	public String emailCenter(HttpSession session, PageParam pageParam, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		model.addAttribute("page", emailTemplateService.getPageByConditions(pageParam, conditions));
		return VM_PATH + "email-center.vm";
	}
	
	@RequestMapping("emailCenter/addEmailTemplate.htm")
	public String addEmailTemplate(HttpSession session, Model model) {
		return VM_PATH + "add-email-template.vm";
	}
	
	@RequestMapping("emailCenter/addEmailTemplateSubmit.json")
	@ResponseBody
	public Object addEmailTemplateSubmit(EmailTemplateDO mailTemplate, Model model) {
		JSONObject json = new JSONObject();
		try {
			mailTemplate.setAddTime(new Date());
			emailTemplateService.insertEmailTemplate(mailTemplate);
			json.put("code", "1");
			json.put("message", "保存成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("message", "保存失败");
		}
		
		return json;
	}
	
	@RequestMapping("emailCenter/setEmailTemplate.htm")
	public String setEmailTemplate(long templateId, Model model) {
		model.addAttribute("info", emailTemplateService.getById(templateId));
		return VM_PATH + "update-email-template.vm";
	}
	
	@RequestMapping("emailCenter/setEmailTemplateSubmit.json")
	@ResponseBody
	public Object setEmailTemplateSubmit(EmailTemplateDO mailTemplate, Model model) {
		JSONObject json = new JSONObject();
		try {
			mailTemplate.setUpdateTime(new Date());
			emailTemplateService.updateEmailTemplate(mailTemplate);
			json.put("code", "1");
			json.put("message", "保存成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("message", "保存失败");
		}
		return json;
	}
	
	@RequestMapping("emailCenter/emailTemplateInfo.htm")
	public String emailTemplateInfo(long templateId, Model model) {
		model.addAttribute("info", emailTemplateService.getById(templateId));
		return VM_PATH + "email-template-info.vm";
	}
	
	@RequestMapping("emailCenter/checkEmailTemlateId.json")
	@ResponseBody
	public Object checkEmailTemlateId(long id, Model model) {
		JSONObject json = new JSONObject();
		try {
			EmailTemplateDO template = emailTemplateService.getById(id);
			if (template == null) {
				json.put("code", "1");
				json.put("message", "可以使用");
			} else {
				json.put("code", "0");
				json.put("message", "不可用");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("message", "不可用");
		}
		return json;
	}
}
