package com.yjf.esupplier.web.controller.backstage.popManage;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.ws.info.PopInfo;

@Controller
@RequestMapping("admin")
public class HelpPopCenterController extends BaseAutowiredController {
	private final String VM_PATH = "/backstage/publicNotice/helpCenter/";
	private final String NEWVM_PATH = "/backstage/publicNotice/newHelpCenter/";
	private final String FWVM_PATH = "/backstage/publicNotice/fwHelpCenter/";
	@Autowired
	IPopService popService;
	
	@RequestMapping("popHelp")
	public String helpCenter(HttpSession session, PageParam pageParam, String type, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		if (StringUtil.isNotBlank(type)) {
			String[] tps = type.split(",");
			for (String tp : tps) {
				int t = NumberUtil.parseInt(tp);
				if (t > 0) {
					types.add(t);
				}
			}
		} else {
			types.add(4);
			types.add(5);
		}
		conditions.put("type", types);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		return VM_PATH + "help-center.vm";
	}
	
	@RequestMapping("popHelp/addHelp")
	public String addHelp(HttpSession session, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(5);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		return VM_PATH + "add-help.vm";
	}
	
	/**
	 * @author wuzj @2015-11-30
	 * @return
	 */
	@RequestMapping("help/center")
	public String helpCenterNew(HttpSession session, PageParam pageParam, String types,
								String title, Integer type, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> typeList = new ArrayList<Integer>();
		if (StringUtil.isNotBlank(types)) {
			String[] tps = types.split(",");
			for (String tp : tps) {
				int t = NumberUtil.parseInt(tp);
				if (t > 0) {
					typeList.add(t);
				}
			}
		}
		if (type != null && type > 0) {
			typeList.clear();
			typeList.add(type);
		}
		
		if (StringUtil.isNotBlank(title)) {
			conditions.put("title", "%" + title + "%");
			model.addAttribute("title", title);
		}
		
		if (pageParam == null) {
			pageParam = new PageParam(1, 12);
		}
		
		conditions.put("type", typeList);
		model.addAttribute("types",types);
		model.addAttribute("type",type);
		model.addAttribute("title",title);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		return VM_PATH + "help-center.vm";
	}
	
	/**
	 * @author wuzj @2015-11-30
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("popHelp/add")
	public String addHelp(String type, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		if (StringUtil.isNotBlank(type)) {
			int t = NumberUtil.parseInt(type);
			if (t > 0) {
				types.add(t);
			}
		}
		conditions.put("isParent", "Y");
		conditions.put("parentId", 0);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		return VM_PATH + "add-help.vm";
	}
	
	/**
	 * @author wuzj @2015-11-30
	 * @param popId
	 * @param model
	 * @return
	 */
	@RequestMapping("popHelp/update")
	public String updateHelpNew(long popId, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		PopInfo info = popService.getByPopId(popId);
		model.addAttribute("info", info);
		conditions.put("isParent", "Y");
		conditions.put("parentId", 0);
		List<Integer> types = new ArrayList<Integer>();
		types.add(Integer.valueOf(info.getType()));
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		return VM_PATH + "update-help.vm";
	}
	
	/**
	 * @author wuzj @2015-11-30
	 * @param parentId
	 * @param type
	 * @param isParent
	 * @return
	 */
	@ResponseBody
	@RequestMapping("popHelp/children")
	public String children(Integer parentId, Integer type, String isParent) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		if (type != null && type > 0) {
			List<Integer> types = new ArrayList<Integer>();
			types.add(type);
			conditions.put("type", types);
		}
		if (parentId != null) {
			conditions.put("parentId", parentId);
		}
		
		conditions.put("isParent", isParent);
		List<PopInfo> pops = popService.getListByConditions(conditions);
		if (pops == null)
			return "{}";
		return JSONObject.toJSON(pops).toString();
	}
	
	@RequestMapping("popHelp/addHelpSubmit")
	@ResponseBody
	public Object addHelpSubmit(PopInfo info, HttpSession session) {
		JSONObject json = new JSONObject();
		if (5 == info.getType()) {
			info.setParentId(-1);
		}
		info.setAddTime(new Date());
		info.setModifyTime(info.getAddTime());
		try {
			popService.addNotice(info);
			json.put("code", "1");
			json.put("message", "新增成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("message", "新增失败！");
		}
		
		return json;
	}
	
	@RequestMapping("popHelp/updateHelp")
	public String updateHelp(long popId, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(5);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		model.addAttribute("info", popService.getByPopId(popId));
		return VM_PATH + "update-help.vm";
	}
	
	//新帮助中心
	@RequestMapping("newPopHelp")
	public String newHelpCenter(HttpSession session, PageParam pageParam, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(6);
		types.add(7);
		conditions.put("type", types);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		return NEWVM_PATH + "help-center.vm";
	}
	
	@RequestMapping("newPopHelp/addHelp")
	public String newAddHelp(HttpSession session, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(7);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		return NEWVM_PATH + "add-help.vm";
	}
	
	@RequestMapping("newPopHelp/updateHelp")
	public String newUpdateHelp(long popId, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(7);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		model.addAttribute("info", popService.getByPopId(popId));
		return NEWVM_PATH + "update-help.vm";
	}
	
	//end
	//服务专区fxd
	@RequestMapping("fwPopHelp")
	public String fwHelpCenter(HttpSession session, PageParam pageParam, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(8);
		types.add(9);
		conditions.put("type", types);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		return FWVM_PATH + "help-center.vm";
	}
	
	@RequestMapping("fwPopHelp/addHelp")
	public String fwAddHelp(HttpSession session, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(9);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		return FWVM_PATH + "add-help.vm";
	}
	
	@RequestMapping("fwPopHelp/updateHelp")
	public String fwUpdateHelp(long popId, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> types = new ArrayList<Integer>();
		types.add(9);
		conditions.put("type", types);
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("helpModules", modules);
		model.addAttribute("info", popService.getByPopId(popId));
		return FWVM_PATH + "update-help.vm";
	}
	
	//end
	
	@RequestMapping("popHelp/updateHelpSubmit")
	@ResponseBody
	public Object updateHelpSubmit(PopInfo info, HttpSession session) {
		JSONObject json = new JSONObject();
		info.setModifyTime(new Date());
		if (5 == info.getType()) {
			info.setParentId(-1);
		}
		try {
			PopInfo infoDO = popService.getByPopId(info.getPopId());
			if (infoDO != null) {
				info.setAddTime(infoDO.getAddTime());
			}
			popService.updateNotice(info);
			json.put("code", "1");
			json.put("message", "更新成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
			json.put("message", "更新失败！");
		}
		return json;
	}
}
