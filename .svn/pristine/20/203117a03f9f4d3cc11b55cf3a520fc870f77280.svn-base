package com.yjf.esupplier.web.controller.backstage.popManage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.service.pop.IPopModuleService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.service.user.info.UserInfo;
import com.yjf.esupplier.service.user.query.order.UserRoleQueryOrder;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.enums.PopTypeEnum;
import com.yjf.esupplier.ws.enums.SysUserRoleEnum;
import com.yjf.esupplier.ws.enums.UserStateEnum;
import com.yjf.esupplier.ws.enums.UserTypeEnum;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.PopModuleVOInfo;
import com.yjf.esupplier.ws.order.PopModuleOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("admin")
public class PopModuleCenterController extends BaseAutowiredController {
	private final String VM_PATH = "/backstage/publicNotice/popCenter/";
	private final String MODULE_VM_PATH = "/backstage/publicNotice/popModule/";
	@Autowired
	IPopService popService;
	
	@Autowired
	IPopModuleService popModuleService;
	
	@RequestMapping("popModuleCenter.htm")
	public String popModuleCenter(HttpSession session, PageParam pageParam, Model model,
									HttpServletRequest request) {
		PopInfo order = new PopInfo();
		WebUtil.setPoPropertyByRequest(order, request, "");
		Map<String, Object> conditions = new HashMap<String, Object>();
		PopModuleOrder popModuleOrder = new PopModuleOrder();
		popModuleOrder.setType(order.getType());
		List<PopModuleVOInfo> moduleTypes = popModuleService.getModules(popModuleOrder);
		model.addAttribute("moduleTypes", moduleTypes);//模块类型下拉框
		model.addAttribute("type", order.getType());
		if (order.getParentId() > 0) { /*查询时*/
			PopModuleVOInfo popModuleVOInfo = popModuleService.getPopModule(order.getParentId());
			conditions.put("parentId", order.getParentId());
			model.addAttribute("parentId", order.getParentId());
			model.addAttribute("parentName", popModuleVOInfo.getModuleName());
		} else {/*没有查询时*/
			model.addAttribute("parentId", -1);
			model.addAttribute("parentName", "无");
		}
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		roleQueryOrder.setPageNumber(-1);
		roleQueryOrder.setType(UserTypeEnum.JG);
		roleQueryOrder.setRoleEnum(SysUserRoleEnum.VISITOR_CENTER);
		roleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
			.queryRoleUserInfo(roleQueryOrder);
		model.addAttribute("scenicList", baseBatchResult.getPageList());
		/*列表查询*/
		conditions.put("type", order.getType());
		conditions.put("status", order.getStatus());
		conditions.put("title", order.getTitle());
		if (StringUtil.isNotEmpty(order.getBelongTo())) {
			conditions.put("belongTo", order.getBelongTo());
		}
		model.addAttribute("order", order);
		model.addAttribute("page", popService.getPageByConditionsNew(pageParam, conditions));
		return VM_PATH + "notice-center.vm";
	}
	
	@RequestMapping("popModuleCenter2.htm")
	public String popModuleCenter2(HttpSession session, PageParam pageParam, Model model,
									PopInfo order) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<PopModuleVOInfo> moduleTypes = popModuleService.getAllModules();
		model.addAttribute("moduleTypes", moduleTypes);//模块类型下拉框
		if (order.getParentId() != 0) {
			conditions.put("parentId", order.getParentId());
		}
		conditions.put("status", order.getStatus());
		conditions.put("type", order.getType());
		model.addAttribute("order", order);
		model.addAttribute("page", popService.getPageByConditionsNew2(pageParam, conditions));
		return VM_PATH + "notice-center.vm";
	}
	
	@RequestMapping("popModuleCenter/addNotice.htm")
	public String addNotice(HttpSession session, Model model, String type) {
		PopModuleOrder popModuleOrder = new PopModuleOrder();
		popModuleOrder.setType(Integer.parseInt(type));
		List<PopModuleVOInfo> moduleTypes = popModuleService.getModules(popModuleOrder);
		model.addAttribute("moduleTypes", moduleTypes);//模块类型下拉框
		model.addAttribute("type", type);
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		roleQueryOrder.setPageNumber(-1);
		roleQueryOrder.setType(UserTypeEnum.JG);
		roleQueryOrder.setRoleEnum(SysUserRoleEnum.VISITOR_CENTER);
		roleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
			.queryRoleUserInfo(roleQueryOrder);
		model.addAttribute("scenicList", baseBatchResult.getPageList());
		return VM_PATH + "add-notice.vm";
	}
	
	@RequestMapping("popModuleCenter/addNoticeSubmit.htm")
	public String addNoticeSubmit(PopInfo info, HttpSession session, Model model) {
		info.setAddTime(new Date());
		popService.addNotice(info);
		List<PopModuleVOInfo> moduleTypes = popModuleService.getAllModules();
		model.addAttribute("moduleTypes", moduleTypes);
		return VM_PATH + "add-notice.vm";
	}
	
	@RequestMapping("popModuleCenter/updateNotice.htm")
	public String updateNotice(Model model, HttpServletRequest request) {
		return updateNoticeBranch(model, request);
	}
	
	@RequestMapping("popModuleCenter/appVersion.htm")
	public String appVersion(Model model, HttpServletRequest request) {
		return updateNoticeBranch(model, request);
	}
	
	private String updateNoticeBranch(Model model, HttpServletRequest request) {
		int type = NumberUtil.parseInt(request.getParameter("type"));
		long popId = NumberUtil.parseLong(request.getParameter("popId"));
		model.addAttribute("type", type);
		UserRoleQueryOrder roleQueryOrder = new UserRoleQueryOrder();
		roleQueryOrder.setPageNumber(-1);
		roleQueryOrder.setType(UserTypeEnum.JG);
		roleQueryOrder.setRoleEnum(SysUserRoleEnum.VISITOR_CENTER);
		roleQueryOrder.setUserStateEnum(UserStateEnum.NORMAL);
		QueryBaseBatchResult<UserInfo> baseBatchResult = userQueryService
			.queryRoleUserInfo(roleQueryOrder);
		model.addAttribute("scenicList", baseBatchResult.getPageList());
		
		PopModuleOrder popModuleOrder = new PopModuleOrder();
		popModuleOrder.setType(type);
		List<PopModuleVOInfo> moduleTypes = popModuleService.getModules(popModuleOrder);
		model.addAttribute("moduleTypes", moduleTypes);//模块类型下拉框
		
		PopInfo infoDO = new PopInfo();
		PopModuleVOInfo popModuleVOInfo = new PopModuleVOInfo();
		if (popId != 0) {
			infoDO = popService.getByPopId(popId);
		}
		/*单条数据维护*/
		if (type == PopTypeEnum.SUMMARY.getDbValue()
			|| type == PopTypeEnum.ANDROID_VERSION.getDbValue()
			|| type == PopTypeEnum.IOS_VERSION.getDbValue()
			|| type == PopTypeEnum.SELLER_VERSION.getDbValue()
			|| type == PopTypeEnum.DILIVERY_VERSION.getDbValue()
			|| type == PopTypeEnum.PAD_VERSION.getDbValue()) {
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("type", type);
			PageParam pageParam = new PageParam();
			Page<PopInfo> PopInfoPage = popService.getPageByConditionsNew(pageParam, conditions);
			if (PopInfoPage.getResult().size() > 0) {
				infoDO = PopInfoPage.getResult().get(0);
			}
		}
		model.addAttribute("info", infoDO);
		model.addAttribute("type", type);
		if (type == PopTypeEnum.ANDROID_VERSION.getDbValue()
			|| type == PopTypeEnum.IOS_VERSION.getDbValue()
			|| type == PopTypeEnum.SELLER_VERSION.getDbValue()
			|| type == PopTypeEnum.DILIVERY_VERSION.getDbValue()
			|| type == PopTypeEnum.PAD_VERSION.getDbValue()) {
			return VM_PATH + "update-version.vm";
		}
		return VM_PATH + "update-notice.vm";
	}
	
	@RequestMapping("popModuleCenter/updateNoticeSubmit.htm")
	public String updateNoticeSubmit(PopInfo info, String addTime2, HttpSession session, Model model) {
		info.setModifyTime(new Date());
		try {
			info.setAddTime(DateUtil.simpleFormatDate(addTime2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (info.getPopId() == 0) {
			popService.addNotice(info);
		} else {
			popService.updateNotice(info);
		}
		List<PopModuleVOInfo> moduleTypes = popModuleService.getAllModules();
		model.addAttribute("moduleTypes", moduleTypes);
		return VM_PATH + "update-notice.vm";
	}
	
	@ResponseBody
	@RequestMapping(value = "popModuleCenter/changeStatus.json")
	public Object changeStatus(long popId, short status) throws Exception {
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
	
	@ResponseBody
	@RequestMapping(value = "popModuleCenter/changeStatus2")
	public Object changeStatus2(long popId, short status) throws Exception {
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
	
	@RequestMapping("popModuleList.htm")
	public String popModuleList(HttpSession session, PageParam pageParam, Model model,
								PopModuleOrder popModuleOrder) {
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(1);
		statusList.add(2);
		Page<PopModuleVOInfo> page = popModuleService.getPageByConditions(pageParam, statusList,
			popModuleOrder);
		model.addAttribute("page", page);
		model.addAttribute("type", popModuleOrder.getType());
		return MODULE_VM_PATH + "pop_module_list.vm";
	}
	
	@RequestMapping("popModule/toModify.htm")
	public String popModuleToModify(HttpSession session, Model model, long moduleId, String type) {
		PopModuleVOInfo popModule = new PopModuleVOInfo();
		PopModuleVOInfo parentModule = new PopModuleVOInfo();
		PopModuleOrder popModuleOrder = new PopModuleOrder();
		popModuleOrder.setLevel(1);
		popModuleOrder.setStatus(1);
		List<PopModuleVOInfo> modules = popModuleService.getModules(popModuleOrder);
		if (moduleId != 0) {
			popModule = popModuleService.getPopModule(moduleId);
			if (popModule != null && popModule.getParentId() != 0) {
				parentModule = popModuleService.getPopModule(popModule.getParentId());
				type = String.valueOf(popModule.getType());
			}
		} else if (StringUtil.isNotEmpty(type)) {
			popModule.setType(Integer.parseInt(type));
			popModule.setShowTop("Y");
			popModule.setVmPage("pop_info_detail.vm");
		}
		String title = "模板管理";
		if (type != null && type.equals("2")) {
			title = "攻略管理";
		} else if (type != null && type.equals("3")) {
			title = "帮助中心管理";
		}
		model.addAttribute("parentModule", parentModule);
		model.addAttribute("popModule", popModule);
		model.addAttribute("modules", modules);
		model.addAttribute("type", type);
		model.addAttribute("title", title);
		return MODULE_VM_PATH + "pop_module_add.vm";
	}
	
	@ResponseBody
	@RequestMapping("popModule/doModify.json")
	public Object popModuleModify(HttpSession session, PageParam pageParam, Model model,
									PopModuleOrder popModuleOrder) {
		
		JSONObject jsonobj = new JSONObject();
		try {
			long moduleId = popModuleOrder.getModuleId();
			if (moduleId == 0) {/*新增*/
				PopModuleVOInfo popModuleVOInfo = popModuleService.getPopModule(popModuleOrder
					.getModuleCode());
				if (popModuleVOInfo != null && popModuleVOInfo.getModuleId() != 0) {
					jsonobj.put("code", 0);
					jsonobj.put("message", "编码重复，新增失败！");
					return jsonobj;
				}
				if (popModuleOrder.getParentId() == 0) {
					popModuleOrder.setLevel(1);
					popModuleOrder.setLevelCode("0");
				} else {
					PopModuleVOInfo parentModule = popModuleService.getPopModule(popModuleOrder
						.getParentId());
					popModuleOrder.setLevel(parentModule.getLevel() + 1);
					popModuleOrder.setLevelCode(parentModule.getLevelCode() + "-"
												+ String.valueOf(parentModule.getModuleId()));
				}
				popModuleOrder.setType(popModuleOrder.getType());
				popModuleService.addPopModule(popModuleOrder);
				
			} else {/*修改*/
				PopModuleVOInfo popModuleVOInfo = popModuleService.getPopModule(popModuleOrder
					.getModuleCode());
				if (popModuleVOInfo != null
					&& popModuleVOInfo.getModuleId() == popModuleOrder.getParentId()) {
					jsonobj.put("code", 0);
					jsonobj.put("message", "上级模块不能选择自己，新增失败！");
					return jsonobj;
				}
				if (popModuleVOInfo != null && popModuleVOInfo.getParentId() == 0
					&& popModuleOrder.getParentId() != 0) {
					jsonobj.put("code", 0);
					jsonobj.put("message", "顶级模板不允许修改上级模板，新增失败！");
					return jsonobj;
				}
				if (popModuleVOInfo != null && popModuleVOInfo.getModuleId() != 0
					&& popModuleVOInfo.getModuleId() != moduleId) {
					jsonobj.put("code", 0);
					jsonobj.put("message", "编码重复，修改失败！");
					return jsonobj;
				}
				if (popModuleOrder.getParentId() == 0) {
					popModuleOrder.setLevel(1);
				} else {
					popModuleOrder.setLevel(2);
				}
				popModuleService.updatePopModule(popModuleOrder);
			}
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("popModule/online.json")
	public Object popModuleOnline(HttpSession session, Model model, long moduleId) {
		JSONObject jsonobj = new JSONObject();
		try {
			popModuleService.onlinePopModule(moduleId);
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("popModule/offline.json")
	public Object popModuleOffline(HttpSession session, Model model, long moduleId) {
		JSONObject jsonobj = new JSONObject();
		try {
			popModuleService.offlinePopModule(moduleId);
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	
	/*
	* 查询攻略模块信息
	* */
	@ResponseBody
	@RequestMapping("popModule/getModule.json")
	public String getAllTreeType(HttpServletRequest request, HttpServletResponse response,
									Model model, String type, String canNull) {
		PopModuleOrder popModuleOrder = new PopModuleOrder();
		if (StringUtil.isNotEmpty(type)) {
			popModuleOrder.setType(Integer.parseInt(type));
		}
		List<PopModuleVOInfo> list = new ArrayList<PopModuleVOInfo>();
		if (StringUtil.isNotEmpty(canNull) && canNull.equals("Y")) {
			PopModuleVOInfo info = new PopModuleVOInfo();
			info.setModuleId(0);
			info.setModuleCode("");
			info.setModuleName("无");
			info.setParentId(0);
			list.add(info);
		}
		List<PopModuleVOInfo> moduleList = popModuleService.getModules(popModuleOrder);
		list.addAll(moduleList);
		return list.toString();
	}
	
	@ResponseBody
	@RequestMapping("popModule/delete.json")
	public Object popModuleDelete(HttpSession session, Model model, long moduleId) {
		JSONObject jsonobj = new JSONObject();
		try {
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("parentId_sub", moduleId);
			PageParam pageParam = new PageParam();
			pageParam.setPageNo(1);
			pageParam.setPageSize(1);
			Page<PopInfo> page = popService.getPageByConditionsNew(pageParam, conditions);
			if (page.getTotalCount() > 0) {
				jsonobj.put("code", 0);
				jsonobj.put("message", "该模块存在关联信息，不能删除！");
			} else {
				popModuleService.deletePopModule(moduleId);
				jsonobj.put("code", 1);
				jsonobj.put("message", "执行成功！");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	
}
