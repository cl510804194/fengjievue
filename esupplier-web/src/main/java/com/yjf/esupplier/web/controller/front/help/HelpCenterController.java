package com.yjf.esupplier.web.controller.front.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.yjf.esupplier.ws.enums.PopTypeEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.util.StringUtils;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.dal.daointerface.ExtraDAO;
import com.yjf.esupplier.service.pop.IPopModuleService;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.ws.info.PopInfo;
import com.yjf.esupplier.ws.info.PopModuleVOInfo;
import com.yjf.esupplier.ws.order.PopModuleOrder;

/**
 * 
 * 
 * @Filename HelpCenterController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History
 * <li>Author: zjl</li>
 * <li>Date: 2013-8-2</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
@RequestMapping("/front/platform/help")
public class HelpCenterController {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private String VM_PATH = "/front/help/";
	@Autowired
	IPopService popService;
	
	@Autowired
	IPopModuleService popModuleService;
	
	@Autowired
	protected ExtraDAO extraDAO;
	
	@RequestMapping("institutionIntroduction/{tree}")
	public String institutionIntroduction(	HttpSession session, @PathVariable String tree,
											Model model) {
											
		return VM_PATH + "institutionIntroduction" + tree + ".vm";
	}
	
	@RequestMapping("nopermission")
	public String hasNoPermission() {
		return VM_PATH + "nopermission.vm";
	}
	
	@RequestMapping("announcement/{popId}")
	public String announcement(HttpSession session, @PathVariable long popId, Model model) {
		PopInfo popInfo = popService.getByPopId(popId);
		model.addAttribute("popNotice", popInfo);
		if (popInfo != null) {
			Map<String, Object> conditions = new HashMap<String, Object>();
			List<Integer> types = new ArrayList<Integer>();
			types.add((int) popInfo.getType());
			conditions.put("type", types);
			conditions.put("status", 2);
			List<PopInfo> announcements = popService.getListByConditions(conditions);
			if (announcements != null) {
				for (int i = 0; i < announcements.size(); i++) {
					if (announcements.get(i).getPopId() == popInfo.getPopId()) {
						if (announcements.size() > 1) {
							if (i == 0) {
								model.addAttribute("popNoticeNext", announcements.get(i + 1));
							} else if (i == (announcements.size() - 1)) {
								model.addAttribute("popNoticeBefore", announcements.get(i - 1));
							} else {
								model.addAttribute("popNoticeBefore", announcements.get(i - 1));
								model.addAttribute("popNoticeNext", announcements.get(i + 1));
							}
						}
					}
				}
			}
			
		}
		
		return VM_PATH + "Announcement.vm";
	}
	
	@ResponseBody
	@RequestMapping("announcementIndexShow")
	public Object announcementIndexShow(Integer type) {
		JSONObject jsonobj = new JSONObject();
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(type);
		conditions.put("type", types);
		conditions.put("status", 2);
		List<PopInfo> announcements = popService.getListByConditions(conditions);
		if (announcements != null) {
			jsonobj.put("code", 1);
			jsonobj.put("announcements", announcements);
		} else {
			jsonobj.put("code", 2);
			jsonobj.put("announcements", null);
		}
		return jsonobj;
	}
	
	@RequestMapping("announcementCenter")
	public String announcementCenter(HttpSession session, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(1);
		types.add(2);
		conditions.put("type", types);
		conditions.put("status", 2);
		List<PopInfo> announcements = popService.getListByConditions(conditions);
		model.addAttribute("announcements", announcements);
		model.addAttribute("announcementCenter", "true");
		return VM_PATH + "Announcement.vm";
	}
	
	@RequestMapping("announcementCenterNew/{popType}/{size}/{page}")
	public String announcementCenterNew(@PathVariable int size, @PathVariable int page,
										@PathVariable int popType, HttpSession session, Model model,
										Long popId) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("type", popType);
		conditions.put("status", 2);
		PageParam pageParam = new PageParam();
		pageParam.setPageNo(page);
		pageParam.setPageSize(size);
		Page<PopInfo> batchResult = popService.getPageByConditionsNew2(pageParam, conditions);
		model.addAttribute("page", batchResult);
		if (popId != null) {
			model.addAttribute("popNotice", popService.getByPopId(popId));
		}
		model.addAttribute("popType", popType);
		model.addAttribute("conditions", conditions);
		model.addAttribute("popId", popId);
		return VM_PATH + "Announcement.vm";
	}
	
	//新版帮助中心前端start
	/**
	 * 在线状态的模块
	 * @param session
	 * @param model
	 * @param defaultMCode
	 * @return
	 */
	@RequestMapping("infoCenter.htm")
	public String infoCenter(HttpSession session, Model model, String defaultMCode, Long popId) {
		session.setAttribute("defaultMCode", defaultMCode);
		/*栏目列表：由于没有上下级查询排序的字段，UED设计得***，只能凑排好序的list ╮(╯▽╰)╭*/
		PopModuleOrder popModuleOrderFa = new PopModuleOrder();
		popModuleOrderFa.setLevel(1);
		popModuleOrderFa.setType(PopTypeEnum.FOOT_NEWS.getDbValue());
		popModuleOrderFa.setStatus(1);
		PopModuleOrder popModuleOrderCh = new PopModuleOrder();
		popModuleOrderCh.setLevel(2);
		popModuleOrderCh.setType(PopTypeEnum.FOOT_NEWS.getDbValue());
		popModuleOrderCh.setStatus(1);
		/*上级*/
		List<PopModuleVOInfo> moduleListFa = popModuleService.getModules(popModuleOrderFa);
		/*下级*/
		List<PopModuleVOInfo> moduleListCh = popModuleService.getModules(popModuleOrderCh);
		
		List<PopModuleVOInfo> moduleList = new ArrayList<PopModuleVOInfo>();
		for (PopModuleVOInfo infoFa : moduleListFa) {
			moduleList.add(infoFa);
			for (PopModuleVOInfo infoCh : moduleListCh) {
				if (infoFa.getModuleId() == infoCh.getParentId()) {
					moduleList.add(infoCh);
				}
			}
		}
		PopModuleVOInfo module = popModuleService.getPopModule(defaultMCode);
		model.addAttribute("moduleList", moduleList);
		model.addAttribute("moduleListSize", moduleList.size());
		/*栏目内容*/
		PopInfo popInfo = new PopInfo();
		if (module != null && module.getModuleId() > 0) {
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("type", PopTypeEnum.FOOT_NEWS.getDbValue());
			conditions.put("parentId", module.getModuleId());
			conditions.put("status", 2);//上线的
			Page<PopInfo> page = popService.getPageByConditionsNew(new PageParam(), conditions);
			List<PopInfo> list = page.getResult();
			if (list.size() > 0) {
				popInfo = list.get(0);
			}
			PopModuleVOInfo parentModule = popModuleService.getPopModule(module.getParentId());
			model.addAttribute("parentModule", parentModule);
		}
		model.addAttribute("module", module);
		model.addAttribute("popInfo", popInfo);
		return VM_PATH + "pop_info_center.vm";
	}
	
	/**
	 * ajax请求各种信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("infos")
	public Object popInfoAjax(String type, Integer parentId, String isParent, String sortOrder) {
		
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		if (StringUtil.isNotEmpty(type)) {
			String[] tps = type.split(",");
			for (String tp : tps) {
				int t = NumberUtil.parseInt(tp);
				if (t > 0)
					types.add(t);
			}
		}
		
		conditions.put("status", 2);
		if (parentId != null && parentId > 0) {
			conditions.put("parentId", parentId);
		}
		if (StringUtil.isNotEmpty(isParent)) {
			conditions.put("isParent", isParent);
		}
		if (StringUtil.isNotEmpty(sortOrder)) {
			conditions.put("sortOrder", sortOrder);
		}
		if (ListUtil.isNotEmpty(types)) {
			conditions.put("type", types);
		}
		List<PopInfo> showList = popService.getListByConditions(conditions);
		if (ListUtil.isNotEmpty(showList)) {
			return JSONObject.toJSON(showList);
		}
		return "[]";
	}
	
	@RequestMapping("infoCenter2")
	public String infoCenter2(HttpSession session, Model model, String defaultMCode, Long popId) {
		session.setAttribute("defaultMCode", defaultMCode);
		List<PopModuleVOInfo> moduleList1 = popModuleService.getOnlineModules(PopTypeEnum.TIPS.getDbValue());
		PopModuleVOInfo module = popModuleService.getPopModule(defaultMCode);
		if (module != null) {
			model.addAttribute("module", module);
		}
		model.addAttribute("moduleList1", moduleList1);
		List<PopModuleVOInfo> moduleList2 = popModuleService.getOnlineModules(PopTypeEnum.TIPS.getDbValue());
		model.addAttribute("moduleList2", moduleList2);
		
		List<PopModuleVOInfo> moduleList3 = popModuleService.getOnlineModules(PopTypeEnum.HELP.getDbValue());
		model.addAttribute("moduleList3", moduleList3);
		
		if (popId != null) {
			PopInfo popInfo = popService.getByPopId(popId);
			model.addAttribute("popId", popId);
			if (popInfo != null) {
				model.addAttribute("popInfo", popInfo);
			}
		}
		//model.addAttribute("popInfoList", popInfoList);
		return VM_PATH + "pop_info_center.vm";
	}
	
	@RequestMapping("infoCenter3")
	public String infoCenter3(	HttpSession session, Model model, String defaultMCode,
								Integer moduleType, Long popId) {
		session.setAttribute("defaultMCode", defaultMCode);
		
		PopModuleVOInfo module = popModuleService.getPopModule(defaultMCode);
		if (module != null) {
			model.addAttribute("module", module);
		}
		if (moduleType != null) {
			List<PopModuleVOInfo> moduleList = popModuleService.getOnlineModules(moduleType);
			model.addAttribute("moduleType", moduleType);
			model.addAttribute("moduleList", moduleList);
		}
		if (popId != null) {
			PopInfo popInfo = popService.getByPopId(popId);
			model.addAttribute("popId", popId);
			if (popInfo != null) {
				model.addAttribute("popInfo", popInfo);
			}
		}
		//model.addAttribute("popInfoList", popInfoList);
		return VM_PATH + "pop_info_center.vm";
	}
	
	@RequestMapping("newInfoCenter")
	public String newInfoCenter(HttpSession session, PageParam pageParam, Model model,
								String defaultMCode, Long popId) {
		session.setAttribute("defaultMCode", defaultMCode);
		List<PopModuleVOInfo> moduleList = popModuleService.getOnlineModules();
		PopModuleVOInfo module = popModuleService.getPopModule(defaultMCode);
		if (module != null) {
			model.addAttribute("module", module);
		}
		model.addAttribute("moduleList", moduleList);
		
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		if (ListUtil.isNotEmpty(moduleList)) {
			for (PopModuleVOInfo popModule : moduleList) {
				types.add(popModule.getType());
			}
			
		}
		conditions.put("type", types);
		conditions.put("status", 2);
		List<PopInfo> page = popService.getListByConditions(conditions);
		model.addAttribute("popList", page);
		if (popId != null) {
			PopInfo popInfo = popService.getByPopId(popId);
			model.addAttribute("popId", popId);
			if (popInfo != null) {
				model.addAttribute("popInfo", popInfo);
			}
		} else {
			Map<String, Object> conditions2 = new HashMap<String, Object>();
			List<Integer> types2 = new ArrayList<Integer>();
			if (module != null) {
				types2.add(module.getType());
				conditions2.put("type", types2);
			}
			conditions2.put("status", 2);
			List<PopInfo> page2 = popService.getListByConditions(conditions2);
			
			if (ListUtil.isNotEmpty(page2)) {
				model.addAttribute("popInfo", page2.get(0));
			} else {
				if (ListUtil.isNotEmpty(page)) {
					model.addAttribute("popInfo", page.get(0));
				}
			}
		}
		
		//model.addAttribute("popInfoList", popInfoList);
		return VM_PATH + "new_pop_info_center.vm";
	}
	
	/**
	 * 下线状态的模块
	 * @param session
	 * @param model
	 * @param defaultMCode
	 * @return
	 */
	@RequestMapping("offLineInfoCenter.htm")
	public String offLineInfoCenter(HttpSession session, Model model, String defaultMCode) {
		session.setAttribute("defaultMCode", defaultMCode);
		List<PopModuleVOInfo> moduleList = popModuleService.getOfflineModules();
		PopModuleVOInfo module = popModuleService.getPopModule(defaultMCode);
		if (module != null) {
			model.addAttribute("module", module);
		}
		model.addAttribute("moduleList", moduleList);
		model.addAttribute("notOnline", true);
		return VM_PATH + "pop_info_center1.vm";
	}
	
	@RequestMapping("showIndex")
	public String showIndex(HttpSession session, PageParam pageParam, Model model,
							String moduleCode) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		List<PopModuleVOInfo> moduleList = popModuleService.getOnlineModules();
		Map<String, Object> conditions = new HashMap<String, Object>();
		if (moduleInfo.getType() != 0) {
			conditions.put("type", moduleInfo.getType());
		} else {
			if (moduleList.size() != 0) {
				conditions.put("type", moduleList.get(0).getType());
			}
		}
		conditions.put("status", 2);//上线的
		
		Page<PopInfo> page = popService.getPageByConditionsNew(pageParam, conditions);
		model.addAttribute("page", page);
		return VM_PATH + "pop_info_index.vm";
	}
	
	@RequestMapping("showIndex2")
	public String showIndex2(	HttpSession session, PageParam pageParam, Model model,
								String moduleCode) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		List<PopModuleVOInfo> moduleList = popModuleService.getOnlineModules();
		Map<String, Object> conditions = new HashMap<String, Object>();
		if (moduleInfo.getModuleId() != 0) {
			conditions.put("parentId", moduleInfo.getModuleId());
		} else {
			if (moduleList.size() != 0) {
				conditions.put("parentId", moduleList.get(0).getModuleId());
			}
		}
		conditions.put("status", 2);//上线的
		
		Page<PopInfo> page = popService.getPageByConditionsNew2(pageParam, conditions);
		model.addAttribute("page", page);
		return VM_PATH + "pop_info_index.vm";
	}
	
	@RequestMapping("toModule2")
	public String toModule2(HttpSession session, PageParam pageParam, Model model,
							String moduleCode, Long popId) {
		session.setAttribute("defaultMCode", moduleCode);
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		List<PopModuleVOInfo> moduleList = popModuleService.getOnlineModules();
		Map<String, Object> conditions = new HashMap<String, Object>();
		if (moduleInfo.getType() != 0) {
			conditions.put("parentId", moduleInfo.getModuleId());
		} else {
			if (moduleList.size() != 0) {
				conditions.put("parentId", moduleList.get(0).getModuleId());
			}
		}
		
		conditions.put("status", 2);//上线的
		
		model.addAttribute("showTop", moduleInfo.getShowTop());
		Page<PopInfo> page = popService.getPageByConditionsNew2(pageParam, conditions);
		String vm = "";
		
		if ("N".equals(moduleInfo.getShowTop())) { //显示列表
			model.addAttribute("page", page);
			if (page.getResult().size() > 0) {
				model.addAttribute("fristContent", page.getResult().get(0));
			}
			PopInfo popInfo = new PopInfo();
			if (popId != null) {
				popInfo = popService.getByPopIdNew(popId);
			} else {
				if (page.getResult().size() > 0) {
					popInfo = page.getResult().get(0);
				}
			}
			model.addAttribute("popInfo", popInfo);
			
			if (StringUtils.isEmpty(moduleInfo.getVmPage())) {
				vm = "pop_info_list.vm"; //默认页面
			} else {
				vm = moduleInfo.getVmPage();
			}
			
		} else { //只显示头一条详细信息
			List<PopInfo> list = page.getResult();
			PopInfo popInfo = new PopInfo();
			if (list.size() > 0) {
				popInfo = list.get(0);
			}
			model.addAttribute("popInfo", popInfo);
			
			if (StringUtils.isEmpty(moduleInfo.getVmPage())) {
				vm = "pop_info_detail.vm"; //默认页面
			} else {
				vm = moduleInfo.getVmPage();
			}
		}
		
		return VM_PATH + vm;
	}
	
	@RequestMapping("toModule.htm")
	public String toModule(	HttpSession session, PageParam pageParam, Model model, String moduleCode,
							Long popId) {
		session.setAttribute("defaultMCode", moduleCode);
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		List<PopModuleVOInfo> moduleList = popModuleService.getOnlineModules();
		Map<String, Object> conditions = new HashMap<String, Object>();
		if (moduleInfo.getType() != 0) {
			conditions.put("type", moduleInfo.getType());
		} else {
			if (moduleList.size() != 0) {
				conditions.put("type", moduleList.get(0).getType());
			}
		}
		
		conditions.put("status", 2);//上线的
		
		model.addAttribute("showTop", moduleInfo.getShowTop());
		Page<PopInfo> page = popService.getPageByConditionsNew(pageParam, conditions);
		String vm = "";
		
		if ("N".equals(moduleInfo.getShowTop())) { //显示列表
			model.addAttribute("page", page);
			if (page.getResult().size() > 0) {
				model.addAttribute("fristContent", page.getResult().get(0));
			}
			PopInfo popInfo = new PopInfo();
			if (popId != null) {
				popInfo = popService.getByPopIdNew(popId);
			} else {
				if (page.getResult().size() > 0) {
					popInfo = page.getResult().get(0);
				}
			}
			model.addAttribute("popInfo", popInfo);
			
			if (StringUtils.isEmpty(moduleInfo.getVmPage())) {
				vm = "pop_info_list.vm"; //默认页面
			} else {
				vm = moduleInfo.getVmPage();
			}
			
		} else { //只显示头一条详细信息
			List<PopInfo> list = page.getResult();
			PopInfo popInfo = new PopInfo();
			if (list.size() > 0) {
				popInfo = list.get(0);
			}
			model.addAttribute("popInfo", popInfo);
			
			if (StringUtils.isEmpty(moduleInfo.getVmPage())) {
				vm = "pop_info_detail.vm"; //默认页面
			} else {
				vm = moduleInfo.getVmPage();
			}
		}
		return VM_PATH + vm;
	}
	
	@ResponseBody
	@RequestMapping("increaseHit")
	public Object increaseHit(HttpSession session, long popId) {
		JSONObject jsonobj = new JSONObject();
		try {
			popService.increaseHit(popId);
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
		} catch (Exception e) {
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
		
	}
	
	@RequestMapping("showDetail")
	public String showDetail(HttpSession session, long popId, String moduleCode, Model model) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		model.addAttribute("popInfo", popService.getByPopIdNew(popId));
		popService.increaseHit(popId);
		return VM_PATH + "pop_info_single.vm";
	}
	
	@RequestMapping("newShowDetail")
	public String newShowDetail(HttpSession session, PageParam pageParam, long popId,
								String moduleCode, Model model) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		model.addAttribute("popId", popId);
		model.addAttribute("popInfo", popService.getByPopIdNew(popId));
		Map<String, Object> conditions = new HashMap<String, Object>();
		if (moduleInfo != null) {
			conditions.put("type", moduleInfo.getType());
		}
		conditions.put("status", 2);
		model.addAttribute("page", popService.getPageByConditionsNew(pageParam, conditions));
		
		return VM_PATH + "pop_info_hidden_list.vm";
	}
	
	@RequestMapping("popInfoDetail.htm")
	public String popInfoDetail(HttpSession session, long popId, String moduleCode, Model model) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		model.addAttribute("showTop", moduleInfo.getShowTop());
		model.addAttribute("popInfo", popService.getByPopIdNew(popId));
		popService.increaseHit(popId);
		return VM_PATH + "pop_info_detail.vm";
	}
	
	@RequestMapping("popInfoDetail2")
	public String popInfoDetail2(HttpSession session, long popId, String moduleCode, Model model) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		model.addAttribute("showTop", moduleInfo.getShowTop());
		model.addAttribute("popInfo", popService.getByPopId(popId));
		popService.increaseHit(popId);
		return VM_PATH + "pop_info_detail.vm";
	}
	
	@RequestMapping("newPopInfoDetail")
	public String newPopInfoDetail(	HttpSession session, long popId, String moduleCode,
									Model model) {
		PopModuleVOInfo moduleInfo = popModuleService.getPopModule(moduleCode);
		model.addAttribute("moduleInfo", moduleInfo);
		model.addAttribute("showTop", moduleInfo.getShowTop());
		model.addAttribute("popInfo", popService.getByPopId(popId));
		
		popService.increaseHit(popId);
		return VM_PATH + "new_pop_info_detail.vm";
	}
	@ResponseBody
	@RequestMapping("getPopModuleList.json")
	public Object getPopModuleList(HttpSession session, Model model) {
		JSONObject jsonobj = new JSONObject();
		JSONArray jsArray = new JSONArray();
		try {
			List<PopModuleVOInfo> moduleParentInfoList = popModuleService.getLevelModules();
			List<PopModuleVOInfo> moduleInfoList = popModuleService.getAllModules();
			
			for (PopModuleVOInfo parentModule : moduleParentInfoList) {
				if (parentModule.getStatus() == 1) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("parentModule", parentModule);
					JSONArray jsonArray = new JSONArray();
					for (PopModuleVOInfo moduleVOInfo : moduleInfoList) {
						if (moduleVOInfo.getParentId() == parentModule.getModuleId()
							&& moduleVOInfo.getStatus() == 1) {
							jsonArray.add(moduleVOInfo);
						}
					}
					jsonObject.put("moduleArray", jsonArray);
					jsArray.add(jsonObject);
				}
			}
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
			jsonobj.put("moduleList", jsArray);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	//end
	
}
