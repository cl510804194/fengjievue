package com.yjf.esupplier.web.controller.backstage.bannerNews;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.service.product.ProductTypeService;
import com.yjf.esupplier.service.user.info.FeebackOptionInfo;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.product.info.ProductTypeInfo;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("admin")
public class BannerNewsCenterController extends BaseAutowiredController {
	private final String VM_PATH = "/backstage/bannerNews/";
	@Autowired
	IPopService popService;
	@Autowired
	ProductTypeService productTypeService;
	
	@RequestMapping("bannerNews.htm")
	public String bannerNews(HttpSession session, PageParam pageParam, Model model, String type) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<String> types = new ArrayList<String>();
		if (StringUtil.isNotEmpty(type)) {
			types.add(type);
		}
		conditions.put("type", types);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		model.addAttribute("type", type);
		return VM_PATH + "bannerNews-center.vm";
	}
	
	@RequestMapping("addBannerNews.htm")
	public String addBannerNews(HttpSession session, Model model, String type) {
		model.addAttribute("type", type);
		/*		model.addAttribute("bannerType", type);
				List<ProductTypeInfo> typeInfoList = productTypeService.getThirdProductType();
				model.addAttribute("typeInfoList", typeInfoList);*/
		return VM_PATH + "add-bannerNews.vm";
	}
	
	@RequestMapping("addBannerNewsSubmit.htm")
	public String addBannerNewsSubmit(	PopInfo info, HttpServletRequest request,
										HttpSession session) {
		ProductTypeInfo typeInfo = productTypeService.findById(info.getParentId());
		if (typeInfo != null) {
			info.setParentName(typeInfo.getPtTypeName());
		}
		info.setAddTime(new Date());
		info.setModifyTime(info.getAddTime());
		popService.addNotice(info);
		return VM_PATH + "add-bannerNews.vm";
	}
	
	@RequestMapping("updateBannerNews.htm")
	public String updateNotice(long popId, Model model) {
		PopInfo info = popService.getByPopId(popId);
		String type = String.valueOf(info.getType());
		model.addAttribute("type", type);
		model.addAttribute("info", info);
		return VM_PATH + "update-bannerNews.vm";
	}
	
	@RequestMapping("updateBannerNewsSubmit.htm")
	public String updateBannerNewsSubmit(	PopInfo info, HttpServletRequest request,
											HttpSession session) {
		if (info.getType() == -1 || info.getType() == -2) {
			info.setType(Short.parseShort(request.getParameter("productType")));
		}
		info.setModifyTime(new Date());
		popService.updateNotice(info);
		return VM_PATH + "update-bannerNews.vm";
	}
	
	@ResponseBody
	@RequestMapping(value = "changeBannerNewsStatus.json")
	public Object changeBannerNewsStatus(long popId, short status) throws Exception {
		JSONObject jsonobj = new JSONObject();
		PopInfo info = popService.getByPopId(popId);
		info.setStatus(status);
		try {
			popService.updateNotice(info);
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	
	@RequestMapping("feebackOption.htm")
	public String feebackOption(PageParam pageParam, Model model,String phoneEmail) {
		FeebackOptionInfo feebackInfo = new FeebackOptionInfo();
		if(StringUtil.isNotEmpty(phoneEmail)){
			feebackInfo.setPhoneEmail(phoneEmail);
		}
		feebackInfo.setPageSize(pageParam.getPageSize());
		feebackInfo.setPageNumber(pageParam.getPageNo());
		QueryBaseBatchResult<FeebackOptionInfo> baseResult = feebackOptionService.findFeebackOptionList(feebackInfo);
		model.addAttribute("page", PageUtil.getCovertPage(baseResult));
		return VM_PATH + "feebackOption.vm";
	}
}
