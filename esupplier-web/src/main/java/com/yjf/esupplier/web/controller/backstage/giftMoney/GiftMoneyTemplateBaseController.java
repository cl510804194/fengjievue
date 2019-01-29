package com.yjf.esupplier.web.controller.backstage.giftMoney;

import javax.servlet.http.HttpServletRequest;

import com.yjf.esupplier.common.util.PageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.giftMoney.query.GiftMoneyTemplateQueryService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.gifamount.info.GiftMoneyTemplateInfo;
import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyTemplateStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyTemplateOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTemplateQueryOrder;
import com.yjf.esupplier.ws.gifamount.services.GiftMoneyTemplateService;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * Created by min on 2015/2/26.
 */

@Controller
public class GiftMoneyTemplateBaseController extends BaseAutowiredController {
	protected  String BORROWING_MANAGE__PATH = "/backstage/giftMoney/";
	
	@Autowired
	GiftMoneyTemplateService giftMoneyTemplateService;
	
	@Autowired
	protected GiftMoneyTemplateQueryService giftMoneyTemplateQueryService;

	public String getBORROWING_MANAGE__PATH() {
		return BORROWING_MANAGE__PATH;
	}

	public void setBORROWING_MANAGE__PATH(String BORROWING_MANAGE__PATH) {
		this.BORROWING_MANAGE__PATH = BORROWING_MANAGE__PATH;
	}

	public String pageQueryGiftMoneyTemplate(GiftMoneyTemplateQueryOrder queryOrder,
												PageParam pageParam, Model model) {
		try {
			queryOrder.setPageNumber(pageParam.getPageNo());
			queryOrder.setPageSize(pageParam.getPageSize());
			String templateName = null;
			if (StringUtil.isNotEmpty(queryOrder.getTemplateName())) {
				templateName = queryOrder.getTemplateName();
				queryOrder.setTemplateName("%" + queryOrder.getTemplateName() + "%");
			}
			QueryBaseBatchResult<GiftMoneyTemplateInfo> giftResult = giftMoneyTemplateQueryService
				.queryGiftMoneyTemplate(queryOrder);
			queryOrder.setTemplateName(templateName);
			PageTool page = new PageTool();
			page.setCurrentPage((int)queryOrder.getPageNumber());
			page.setPageSize((int)queryOrder.getPageSize());
			page.setTotalRow(giftResult.getTotalCount());
			String pageBar = page.getPageBar();
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(giftResult));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BORROWING_MANAGE__PATH + "pageQueryGiftMoneyTemplate.vm";
	}

	public String addGiftMoneyTemplate(HttpServletRequest request, Model model) {
		return BORROWING_MANAGE__PATH + "addGiftMoneyTemplate.vm";
	}
	
	@ResponseBody
	public Object addGiftMoneyTemplateSubmit(	CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder)
																											throws Exception {
		JSONObject json = new JSONObject();
		EsupplierBaseResult result = giftMoneyTemplateService
			.addGiftMoneyTemplate(createGiftMoneyTemplateOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "新增优惠券使用规则成功!");
		} else {
			json.put("code", 0);
			json.put("message", "新增优惠券使用规则失败:" + result.getMessage());
			
		}
		return json;
	}
	
	@ResponseBody
	public Object updateGiftMoneyTemplateSubmit(CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder)
																											throws Exception {
		JSONObject json = new JSONObject();
		
		EsupplierBaseResult result = giftMoneyTemplateService
			.updateGiftMoneyTemplate(createGiftMoneyTemplateOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "更新优惠券使用规则成功!");
		} else {
			json.put("code", 0);
			json.put("message", "更新优惠券使用规则失败:" + result.getMessage());
			
		}
		return json;
	}
	
	@ResponseBody
	public Object changeGiftMoneyTemplateStatus(ChangeGiftMoneyTemplateStatusOrder statusOrder)
																								throws Exception {
		JSONObject json = new JSONObject();
		EsupplierBaseResult result = giftMoneyTemplateService
			.ChangeGiftMoneyTemplateStatus(statusOrder);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "更新优惠券使用规则的状态成功!");
		} else {
			json.put("code", 0);
			json.put("message", "更新优惠券使用规则的状态失败:" + result.getMessage());
			
		}
		return json;
	}

	public String updateGiftMoneyTemplate(long templateId, Model model) {
		GiftMoneyTemplateInfo templateInfo = giftMoneyTemplateQueryService
			.queryGiftMoneyTemplateById(templateId);
		model.addAttribute("templateInfo", templateInfo);
		return BORROWING_MANAGE__PATH + "updateGiftMoneyTemplate.vm";
	}
	
}
