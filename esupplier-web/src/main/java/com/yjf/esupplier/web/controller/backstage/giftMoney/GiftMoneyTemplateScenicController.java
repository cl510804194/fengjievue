package com.yjf.esupplier.web.controller.backstage.giftMoney;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.ws.gifamount.order.ChangeGiftMoneyTemplateStatusOrder;
import com.yjf.esupplier.ws.gifamount.order.CreateGiftMoneyTemplateOrder;
import com.yjf.esupplier.ws.gifamount.query.order.GiftMoneyTemplateQueryOrder;

/**
 * Created by min on 2015/2/26.
 */

@Controller
@RequestMapping("/do/scenic/doCenter")
public class GiftMoneyTemplateScenicController extends GiftMoneyTemplateBaseController {
	protected String BORROWING_MANAGE__PATH = "front/gift/";
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value = "pageQueryGiftMoneyTemplate.htm")
	public String pageQueryGiftMoneyTemplate(	HttpServletRequest request,
												GiftMoneyTemplateQueryOrder queryOrder,
												PageParam pageParam, Model model) {
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		if (NumberUtil.parseLong(page) != 0) {
			queryOrder.setPageNumber(Long.parseLong(page));
			pageParam.setPageNo(Integer.parseInt(page));
		}
		if (NumberUtil.parseLong(pageSize) != 0) {
			queryOrder.setPageSize(Long.parseLong(pageSize));
			pageParam.setPageSize(Integer.parseInt(pageSize));
		}
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.pageQueryGiftMoneyTemplate(queryOrder, pageParam, model);
	}
	
	@RequestMapping(value = "addGiftMoneyTemplate.htm")
	public String addGiftMoneyTemplate(HttpServletRequest request, Model model) {
		setBORROWING_MANAGE__PATH(BORROWING_MANAGE__PATH);
		return super.addGiftMoneyTemplate(request, model);
	}
	
	@ResponseBody
	@RequestMapping(value = "addGiftMoneyTemplateSubmit.htm")
	public Object addGiftMoneyTemplateSubmit(CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder) throws Exception {
		return super.addGiftMoneyTemplateSubmit(createGiftMoneyTemplateOrder);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateGiftMoneyTemplateSubmit.htm")
	public Object updateGiftMoneyTemplateSubmit(CreateGiftMoneyTemplateOrder createGiftMoneyTemplateOrder) throws Exception {
		return super.updateGiftMoneyTemplateSubmit(createGiftMoneyTemplateOrder);
	}
	
	@ResponseBody
	@RequestMapping(value = "changeGiftMoneyTemplateStatus.htm")
	public Object changeGiftMoneyTemplateStatus(ChangeGiftMoneyTemplateStatusOrder statusOrder) throws Exception {
		return super.changeGiftMoneyTemplateStatus(statusOrder);
	}
	
	@RequestMapping(value = "updateGiftMoneyTemplate.htm")
	public String updateGiftMoneyTemplate(long templateId, Model model) {
		return super.updateGiftMoneyTemplate(templateId, model);
	}
	
}
