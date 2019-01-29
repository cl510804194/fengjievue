package com.yjf.esupplier.web.controller.backstage.giftMoney;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/admin/giftMoneyTemplate")
public class GiftMoneyTemplateController extends GiftMoneyTemplateBaseController {

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "pageQueryGiftMoneyTemplate.htm")
	public String pageQueryGiftMoneyTemplate(GiftMoneyTemplateQueryOrder queryOrder,
												PageParam pageParam, Model model) {
		return super.pageQueryGiftMoneyTemplate(queryOrder,pageParam,model);
	}
	
	@RequestMapping(value = "addGiftMoneyTemplate.htm")
	public String addGiftMoneyTemplate(HttpServletRequest request, Model model) {
		return super.addGiftMoneyTemplate(request,model);
	}
	
	@ResponseBody
	@RequestMapping(value = "addGiftMoneyTemplateSubmit.htm")
	public Object addGiftMoneyTemplateSubmit(	CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder)
																											throws Exception {
		return super.addGiftMoneyTemplateSubmit(createGiftMoneyTemplateOrder);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateGiftMoneyTemplateSubmit.htm")
	public Object updateGiftMoneyTemplateSubmit(CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder)
																											throws Exception {
		return super.updateGiftMoneyTemplateSubmit(createGiftMoneyTemplateOrder);
	}
	
	@ResponseBody
	@RequestMapping(value = "changeGiftMoneyTemplateStatus.htm")
	public Object changeGiftMoneyTemplateStatus(ChangeGiftMoneyTemplateStatusOrder statusOrder)
																								throws Exception {
		return super.changeGiftMoneyTemplateStatus(statusOrder);
	}

	@RequestMapping(value = "updateGiftMoneyTemplate.htm")
	public String updateGiftMoneyTemplate(long templateId, Model model) {
		return super.updateGiftMoneyTemplate(templateId,model);
	}
	
}
