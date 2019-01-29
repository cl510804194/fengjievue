package com.yjf.esupplier.web.controller.backstage.popManage;

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
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.service.pop.IPopService;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.WebUtil;
import com.yjf.esupplier.ws.info.PopInfo;

@Controller
@RequestMapping("admin")
public class NoticePopCenterController extends BaseAutowiredController {
	private final String VM_PATH = "/backstage/publicNotice/noticeCenter/";
	private final String POP_VM_PATH = "/backstage/publicNotice/popCenter/";
	@Autowired
	IPopService popService;
	
	@RequestMapping("noticeCenter.htm")
	public String noticeCenter(HttpSession session, String title, Integer type, String types,
								PageParam pageParam, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> typeList = new ArrayList<Integer>();
		
		if (StringUtil.isNotBlank(types)) {
			String[] ts = types.split(",");
			for (String t : ts) {
				int num = NumberUtil.parseInt(t);
				if (num > 0)
					typeList.add(num);
			}
		} else {
			typeList.add(1);
			typeList.add(2);
			typeList.add(3);
			typeList.add(10);
			typeList.add(11);
			typeList.add(12);
			//倍倍利团队介绍
//			if(ConfigParamProperty.isPlatformFeatureCode(PlatformFeatureEnum.BEI_BEI_LI.getCode())){
//				typeList.add(13);
//			}
		}
		
		conditions.put("type", typeList);
		if (StringUtil.isNotBlank(title)) {
			conditions.put("title", "%" + title + "%");
			model.addAttribute("title", title);
		}
		
		if (type != null) {
			List<Integer> list = new ArrayList<>();
			list.add(type);
			conditions.put("type", list);
			model.addAttribute("type", type);
		}
		model.addAttribute("conditions", conditions);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		return VM_PATH + "notice-center.vm";
	}
	
	@RequestMapping("noticeCenter/addNotice")
	public String addNotice(HttpSession session) {
		return VM_PATH + "add-notice.vm";
	}
	
	/**
	 * @author wuzj @2015-12-3
	 * @return
	 */
	@RequestMapping("popInfo/center.htm")
	public String noticeCenterNew(HttpSession session, String title, Integer type, String types,
									PageParam pageParam, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		List<Integer> typeList = new ArrayList<Integer>();
		if (StringUtil.isNotBlank(types)) {
			String[] ts = types.split(",");
			for (String t : ts) {
				int num = NumberUtil.parseInt(t);
				if (num > 0)
					typeList.add(num);
			}
		}
		
		if (StringUtil.isNotBlank(title)) {
			conditions.put("title", "%" + title + "%");
			model.addAttribute("title", title);
		}
		if (type != null) {
			typeList.clear();
			typeList.add(type);
			model.addAttribute("type", type);
		}
		
		conditions.put("type", typeList);
		
		if (pageParam == null) {
			pageParam = new PageParam(1, 12);
		}
		
		model.addAttribute("types", types);
		model.addAttribute("type", type);
		model.addAttribute("title", title);
		model.addAttribute("page", popService.getPageByConditions(pageParam, conditions));
		return POP_VM_PATH + "notice-center.vm";
	}
	
	/**
	 * @author wuzj @2015-12-3
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("popInfo/add.htm")
	public String addInfo(String type, Model model) {
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
		model.addAttribute("infoModules", modules);
		return POP_VM_PATH + "add-notice.vm";
	}
	
	/**
	 * @author wuzj @2015-12-3
	 * @param popId
	 * @param model
	 * @return
	 */
	@RequestMapping("popInfo/update.htm")
	public String updateInfo(long popId, Model model) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		PopInfo info = popService.getByPopId(popId);
		model.addAttribute("info", info);
		conditions.put("isParent", "Y");
		conditions.put("parentId", 0);
		List<Integer> types = new ArrayList<Integer>();
		types.add(Integer.valueOf(info.getType()));
		List<PopInfo> modules = popService.getListByConditions(conditions);
		model.addAttribute("infoModules", modules);
		return POP_VM_PATH + "update-notice.vm";
	}
	
	/**
	 * @author wuzj @2015-12-3
	 */
	@RequestMapping("popInfo/addSubmit.json")
	@ResponseBody
	public Object addInfoSubmit(PopInfo info, HttpSession session) {
		JSONObject json = new JSONObject();
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
	
	/**
	 * @author wuzj @2015-12-3
	 */
	@RequestMapping("popInfo/updateSubmit.json")
	@ResponseBody
	public Object updateInfoSubmit(PopInfo info, HttpSession session) {
		JSONObject json = new JSONObject();
		info.setModifyTime(new Date());
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
	
	/**
	 * @author wuzj @2015-11-30
	 * @param parentId
	 * @param type
	 * @param isParent
	 * @return
	 */
	@ResponseBody
	@RequestMapping("popInfo/children.htm")
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
	
	@RequestMapping("noticeCenter/addNoticeSubmit.htm")
	public String addNoticeSubmit(PopInfo info,HttpSession session) {
		info.setAddTime(new Date());
		info.setModifyTime(info.getAddTime());
		popService.addNotice(info);
		return VM_PATH + "add-notice.vm";
	}
	
	@RequestMapping("noticeCenter/updateNotice.htm")
	public String updateNotice(long popId, Model model) {
		model.addAttribute("info", popService.getByPopId(popId));
		return VM_PATH + "update-notice.vm";
	}
	
	//	@RequestMapping("noticeCenter/delNotice")
	//	public String delNotice(long popId, Model model) {
	//
	//		return VM_PATH + "update-notice.vm";
	//	}	
	
	@RequestMapping("noticeCenter/updateNoticeSubmit.htm")
	public String updateNoticeSubmit(HttpServletRequest request, HttpSession session) {
		PopInfo info = new PopInfo();
		WebUtil.setPoPropertyByRequest(info, request);
		info.setModifyTime(new Date());
		PopInfo infoDO = popService.getByPopId(info.getPopId());
		if (infoDO != null && request.getParameter("addTime") == null) {
			info.setAddTime(infoDO.getAddTime());
			info.setPublicDate(infoDO.getPublicDate());
			info.setPublicStatus("N");
			popService.updateNotice(info);
			return VM_PATH + "update-notice.vm";
		} else {
			//info.setAddTime(request.getParameter("addTime"));
			info.setPublicDate(infoDO.getPublicDate());
			info.setPublicStatus("N");
			popService.updateNoticeAddTime(info);
			return VM_PATH + "update-notice.vm";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "noticeCenter/changeStatus.json")
	public Object changeStatus(long popId, short status) throws Exception {
		JSONObject jsonobj = new JSONObject();
		PopInfo info = popService.getByPopId(popId);
		info.setStatus(status);
		try {
			if (status == 3) {
				info.setPublicDate(null);
				info.setPublicStatus("N");
			} else {
				info.setPublicDate(new Date());
				info.setPublicStatus("Y");
			}
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
	@RequestMapping(value = "noticeCenter/publicDate.json")
	public Object publicDate(long popId, String publicDate) throws Exception {
		JSONObject jsonobj = new JSONObject();
		PopInfo info = popService.getByPopId(popId);
		info.setPublicDate(DateUtil.string2DateTime(publicDate));
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
	@RequestMapping(value = "noticeCenter/delNotice.json")
	public Object delNotice(long popId, short status) throws Exception {
		JSONObject jsonobj = new JSONObject();
		
		try {
			popService.delNotice(popId);
			jsonobj.put("code", 1);
			jsonobj.put("message", "执行成功！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "执行失败！");
		}
		return jsonobj;
	}
	
}
