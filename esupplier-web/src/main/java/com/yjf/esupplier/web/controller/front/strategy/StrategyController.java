package com.yjf.esupplier.web.controller.front.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.service.pop.IPopModuleService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.service.pop.PopUserService;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.service.session.SessionLocal;
import com.yjf.esupplier.service.user.query.ScenicService;
import com.yjf.esupplier.service.user.query.order.ScenicQueryOrder;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.PopUserTypeEnum;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.PopModuleVOInfo;
import com.yjf.esupplier.ws.info.PopUserInfo;
import com.yjf.esupplier.ws.info.ScenicInfo;
import com.yjf.esupplier.ws.order.PopUserOrder;
import com.yjf.esupplier.ws.product.info.ProductInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/front/platform/strategy")
public class StrategyController {
	@Autowired
	IPopService popService;
	@Autowired
	IPopModuleService popModuleService;
	@Autowired
	ScenicService scenicService;
	@Autowired
	PopUserService popUserService;
	final static String vmPath = "front/strategy/";
	@RequestMapping("strategyDetail.htm")
	public String strategyDetail(HttpServletRequest request, HttpServletResponse response, Model model) {
		String popId = request.getParameter("popId");
		if(StringUtil.isEmpty(popId)){
			return "common/error.vm";
		}
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		long userId = 0;
		if(sessionLocal != null){
			userId = sessionLocal.getUserId();
		}
		PopUserOrder popUserOrder = new PopUserOrder();
		popUserOrder.setPopId(NumberUtil.parseLong(popId));
		popUserOrder.setType(PopUserTypeEnum.AGREE);
		QueryBaseBatchResult<PopUserInfo> popAgreeInfoResults = popUserService.getPopUserList(popUserOrder);
		model.addAttribute("agreeCount", popAgreeInfoResults.getTotalCount());
		popUserOrder.setUserId(userId);
		QueryBaseBatchResult<PopUserInfo> popAgreeInfoResult = popUserService.getPopUserList(popUserOrder);
		popUserOrder.setType(PopUserTypeEnum.COLLECT);
		QueryBaseBatchResult<PopUserInfo> popCollectInfoResult = popUserService.getPopUserList(popUserOrder);
		if(popAgreeInfoResult.getPageList().size() > 0){
			model.addAttribute("AGREE", BooleanEnum.YES.code());
		}
		if(popCollectInfoResult.getPageList().size() > 0){
			model.addAttribute("COLLECT", BooleanEnum.YES.code());
		}
		PopInfo info = popService.getByPopIdContainScenic(Long.parseLong(popId));
		model.addAttribute("popInfo", info);
		return vmPath + "strategyDetail.vm";
	}
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("strategyList.htm")
	public String strategyList(HttpServletRequest request, HttpServletResponse response, Model model) {
		PageParam pageParam = new PageParam();
		int pageno = NumberUtil.parseInt(request.getParameter("page"), 1); //页码
		int pagesize = NumberUtil.parseInt(request.getParameter("pageSize"),20); //页显示量
		String scenicId = request.getParameter("scenicId");
		String moduleId = request.getParameter("moduleId");
		String title = request.getParameter("title");
		String provinceName = request.getParameter("provinceName");
		String cityName = request.getParameter("cityName");
		String scenicName = "";
		if(StringUtil.isNotBlank(scenicId)){
			scenicName = scenicService.queryByUserBaseId(scenicId).getQueryScenicInfo().getName();
			model.addAttribute("scenicName", scenicName);
		}
		if(StringUtil.isNotBlank(moduleId)){
			PopModuleVOInfo popVOInfo = popModuleService.getPopModule(NumberUtil.parseLong(moduleId));
			model.addAttribute("moduleName", popVOInfo.getModuleName());
		}
		pageParam.setPageNo(pageno);
		pageParam.setPageSize(pagesize);
		QueryBaseBatchResult<PopInfo> baseResult = popService.getGlListByConditionsNew(pageParam,
				scenicId, moduleId, title,provinceName, cityName);
		ScenicQueryOrder scenicQueryOrder = new ScenicQueryOrder();
		scenicQueryOrder.setPageSize(20);
		model.addAttribute("popInfoList",baseResult.getPageList());
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) baseResult.getPageNumber());
		pageTool.setPageSize((int) baseResult.getPageSize());
		pageTool.setTotalRow(baseResult.getTotalCount());
		List<PopInfo> popInfoList = baseResult.getPageList();

		QueryBaseBatchResult<ScenicInfo> scenicInfos = scenicService.getScenicInfo(scenicQueryOrder);
		QueryBaseBatchResult<PopModuleVOInfo> baseGLResult = popModuleService.getOnlineModulesForGl();
		List citys = new ArrayList();
		List scenics = new ArrayList();
		List scenicsIds = new ArrayList();
		for(ScenicInfo scenicInfo : scenicInfos.getPageList()){
			if(!citys.contains(scenicInfo.getCity())){
				citys.add(scenicInfo.getCity());
			}
			if(!scenics.contains(scenicInfo.getName())){
				scenics.add(scenicInfo);
				scenicsIds.add(scenicInfo.getUserBaseId());
			}
		}
		model.addAttribute("scenicId", scenicId);
		model.addAttribute("moduleId", moduleId);
		model.addAttribute("cityName", cityName);
		model.addAttribute("gls",baseGLResult.getPageList());
		model.addAttribute("citys", citys);
		model.addAttribute("scenicsIds", scenicsIds);
		model.addAttribute("scenics", scenics);
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(popInfoList, pageTool));
		
		return vmPath + "strategyList.vm";
	}
	
	/** 旅游攻略收藏点赞 */
	@ResponseBody
	@RequestMapping("strategyCollectAgree.json")
	public Object strategyCollectAgree(HttpServletRequest request, HttpServletResponse response, Model model){
		EsupplierBaseResult result = new EsupplierBaseResult();
		JSONObject json = new JSONObject();
		String type = request.getParameter("type");
		String action = request.getParameter("action");
		String popId = request.getParameter("popId");
		SessionLocal sessionLocal = ShiroSessionUtils.getSessionLocal();
		long userId = 0;
		if(sessionLocal != null){
			userId = sessionLocal.getUserId();
		}else{
			json.put("code", 0);
			json.put("message", "请先登录!");
			return json;
		}
		PopUserTypeEnum popUserTypeEnum = PopUserTypeEnum.getByCode(type);
		if (NumberUtil.parseLong(popId) == 0) {
			json.put("code", 0);
			json.put("message", "攻略Id不能为空");
			return json;
		}
		if (popUserTypeEnum == null) {
			json.put("code", 0);
			json.put("message", "选择的操作分类不对");
			return json;
		}
		String title = popUserTypeEnum.getMessage();

		if (action.equals("DEL")) {
			result = popUserService.deletePopUser(userId, NumberUtil.parseLong(popId),
				popUserTypeEnum);
		} else if (action.equals("ADD")) {
			PopUserOrder order = new PopUserOrder();
			order.setType(popUserTypeEnum);
			order.setUserId(userId);
			order.setPopId(NumberUtil.parseLong(popId));
			order.setRawAddTime(new Date());
			result = popUserService.insertPopUser(order);
		}
		if(result.isSuccess()){
			json.put("code", 1);
			json.put("message", result.getMessage());
		}else{
			json.put("code", 0);
			json.put("message", result.getMessage());
		}
		return json;
	}
	/*攻略收藏列表*/

	@RequestMapping("strategyCollectList.htm")
	public String strategyCollectList(HttpServletRequest request, HttpServletResponse response, Model model){
		EsupplierBaseResult result = new EsupplierBaseResult();
		long userId = ShiroSessionUtils.getSessionLocal().getUserId();
		String type = request.getParameter("type");
		PopUserTypeEnum popUserTypeEnum = PopUserTypeEnum.getByCode(type);
		if (popUserTypeEnum == null) {
			return "common/error.vm";
		}
		PopUserOrder popUserOrder = new PopUserOrder();
		WebUtil.setPoPropertyByRequest(popUserOrder, request);
		popUserOrder.setUserId(userId);
		popUserOrder.setType(popUserTypeEnum);
		QueryBaseBatchResult<PopInfo> baseResult = popService
			.getPopUserContainScenic(popUserOrder);
		PageTool pageTool = new PageTool();
		pageTool.setCurrentPage((int) baseResult.getPageNumber());
		pageTool.setPageSize((int) baseResult.getPageSize());
		pageTool.setTotalRow(baseResult.getTotalCount());
		model.addAttribute("gls", baseResult.getPageList());
		model.addAttribute("page", PageUtil.getCovertPageByPageTools(baseResult.getPageList(), pageTool));
		return vmPath + "strategyCollectList.vm";
	}
	

}
