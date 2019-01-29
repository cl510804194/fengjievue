package com.yjf.esupplier.web.controller.backstage.report;

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
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.common.util.DateUtil;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.common.util.rpt.common.ReportData;
import com.yjf.esupplier.common.util.rpt.common.ReportExcel;
import com.yjf.esupplier.common.util.rpt.common.ReportHead;
import com.yjf.esupplier.service.report.ReportService;
import com.yjf.esupplier.service.report.order.ReportQueryOrder;
import com.yjf.esupplier.service.report.order.ReportQueryParam;
import com.yjf.esupplier.service.security.info.RoleInfo;
import com.yjf.esupplier.service.security.query.order.RoleQueryOrder;
import com.yjf.esupplier.service.security.util.ShiroSessionUtils;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.data.ReportRuleData;
import com.yjf.esupplier.ws.info.RoleReportInfo;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

@Controller
@RequestMapping("/admin/report")
public class ReportController extends BaseAutowiredController {
	
	/** 通用页面路径 */
	String VM_PATH = "/backstage/report/";
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping("list.htm")
	public String queryAll(ReportQueryOrder reportQueryOrder, HttpServletResponse response,
							PageParam pageParam, Model model) {
		try {
			reportQueryOrder.setPageNumber(pageParam.getPageNo());
			reportQueryOrder.setPageSize(pageParam.getPageSize());
			
			QueryBaseBatchResult<ReportRuleData> page = reportService
				.getQueryRules(reportQueryOrder);
			
			model.addAttribute("page", PageUtil.getCovertPage(page));
			model.addAttribute("queryConditions", reportQueryOrder);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return VM_PATH + "reportList.vm";
	}
	
	@RequestMapping("myList.htm")
	public String queryMyAll(ReportQueryOrder reportQueryOrder, HttpServletResponse response,
								PageParam pageParam, Model model) {
		try {
			reportQueryOrder.setPageNumber(pageParam.getPageNo());
			reportQueryOrder.setPageSize(pageParam.getPageSize());
			reportQueryOrder.setUserId(ShiroSessionUtils.getSessionLocal().getUserId());
			QueryBaseBatchResult<ReportRuleData> page = reportService.getMyReport(reportQueryOrder);
			
			model.addAttribute("page", PageUtil.getCovertPage(page));
			model.addAttribute("queryConditions", reportQueryOrder);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return VM_PATH + "myReportList.vm";
	}
	
	@RequestMapping("toQuery.htm")
	public String toQuery(long reportId, HttpServletResponse response, Model model) {
		
		try {
			ReportRuleData queryRule = reportService.getQueryRule(reportId);
			model.addAttribute("queryRule", queryRule);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return VM_PATH + "reportQuery.vm";
	}
	
	@RequestMapping("toAdd.htm")
	public String toAdd(long reportId, HttpServletResponse response, Model model) {
		ReportRuleData queryRule = new ReportRuleData();
		List<RoleReportInfo> roleSelected = new ArrayList<RoleReportInfo>();
		try {
			if (reportId != 0) {
				queryRule = reportService.getQueryRule(reportId);
				roleSelected = reportService.getGrantedRoles(reportId);
			}
			RoleQueryOrder queryOrder = new RoleQueryOrder();
			queryOrder.setLimitStart(0);
			queryOrder.setPageSize(9999);
			QueryBaseBatchResult<RoleInfo> rolePagination = authorityService.getAllRoles(queryOrder);
			List<RoleInfo> roleAll = rolePagination.getPageList();
			List<RoleInfo> roleSelects = new ArrayList<RoleInfo>();
			if (ListUtil.isNotEmpty(roleAll)) {
				for (RoleInfo role : roleAll) {
					if ((role.getRoleId() > 1)) {
						continue;
					}
					roleSelects.add(role);
				}
			}
			model.addAttribute("roleSelects", roleSelects);
			model.addAttribute("roleSelected", roleSelected);
			model.addAttribute("queryRule", queryRule);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return VM_PATH + "reportAdd.vm";
	}
	
	@RequestMapping("delete.htm")
	public String doDelete(long reportId, HttpServletResponse response, Model model) {
		ReportRuleData queryRule = new ReportRuleData();
		try {
			if (reportId != 0) {
				reportService.deleteQueryRule(reportId);
			}
			model.addAttribute("queryRule", queryRule);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return sendUrl(response, "/admin/report/list.htm");
//		return "redirect:" + "/admin/report/list.htm";
	}
	
	@RequestMapping("refresh.htm")
	public String refresh(HttpServletResponse response, Model model) {
		try {
			int i = reportService.refreshData();
			logger.info("手动更新数据: " + i);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return sendUrl(response, "/admin/report/list.htm");
	}
	
	@ResponseBody
	@RequestMapping("update.json")
	public Object update(ReportRuleData reportRule, HttpServletResponse response, Model model) {
		JSONObject jsonobj = new JSONObject();
		try {
			long reportId = reportRule.getReportId();
			
			//检验json 字符串是否正确
			if (StringUtil.isNotEmpty(reportRule.getFilter1Options())) {
				MiscUtil.parseJSONWithException(reportRule.getFilter1Options());
			}
			if (StringUtil.isNotEmpty(reportRule.getFilter2Options())) {
				MiscUtil.parseJSONWithException(reportRule.getFilter2Options());
			}
			if (StringUtil.isNotEmpty(reportRule.getFilter3Options())) {
				MiscUtil.parseJSONWithException(reportRule.getFilter3Options());
			}
			if (StringUtil.isNotEmpty(reportRule.getFilter4Options())) {
				MiscUtil.parseJSONWithException(reportRule.getFilter4Options());
			}
			if (StringUtil.isNotEmpty(reportRule.getFilter5Options())) {
				MiscUtil.parseJSONWithException(reportRule.getFilter5Options());
			}
			if (StringUtil.isNotEmpty(reportRule.getFilter6Options())) {
				MiscUtil.parseJSONWithException(reportRule.getFilter6Options());
			}
			
			if (reportId != 0) {
				reportId = reportService.udpateQueryRule(reportRule);
			} else {
				reportId = reportService.addQueryRule(reportRule);
				
			}
			ReportRuleData queryRule = reportService.getQueryRule(reportId);
			model.addAttribute("queryRule", queryRule);
			
			jsonobj.put("code", 1);
			jsonobj.put("message", "保存成功！");
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonobj.put("code", 0);
			jsonobj.put("message", "保存失败！" + e.getMessage());
		}
		
		//return VM_PATH +"reportAdd.vm";
		return jsonobj;
	}
	
	@ResponseBody
	@RequestMapping("downloadResult.json")
	public Object downloadResult(HttpSession session, HttpServletResponse response,
									HttpServletRequest request, Model model,
									ReportQueryParam queryParam) {
		JSONObject jsonobj = new JSONObject();
		try {
			ReportRuleData rule = reportService.getQueryRule(queryParam.getReportId());
			
			String reportName = rule.getReportName();
			
			List<Map<String, String>> list = reportService.queryReportData(queryParam, rule);
			
			if (list.size() > 0) {
				response.addHeader(
					"Content-Disposition",
					"attachment; filename="
							+ new String(
								(reportName + DateUtil.dtSimpleFormat(new Date()) + ".xls")
									.getBytes("GB2312"), "ISO8859-1"));
				
				String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel";
				String serverRealPath = session.getServletContext().getRealPath("/");
				response.setContentType(CONTENT_TYPE_EXCEL);
				
				Map<String, String> firstRow = list.get(0);
				ReportHead head = new ReportHead();
				
				String filters = reportService.getQueryParam(queryParam, rule);
				
				head.setDate(DateUtil.simpleFormat(new Date()));
				head.setFilters(filters.toString());
				
				ReportData report = new ReportData(head, list);
				ReportExcel excel = new ReportExcel(response.getOutputStream());
				
				excel.print(report.getXMLDocument(),
					excel.getDefaultDocument(serverRealPath, reportName, firstRow));
				jsonobj.put("code", 1);
				return jsonobj;
				
			} else {
				jsonobj.put("code", 1);
				jsonobj.put("message", "未查到满足条件的数据！");
				return jsonobj;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response.setContentType("application/json");
			jsonobj.put("code", 0);
			jsonobj.put("message", e.getMessage());
		}
		return jsonobj;
		
	}
	
	@RequestMapping("queryResult.htm")
	public String queryResult(HttpSession session, HttpServletRequest request ,HttpServletResponse response, Model model,
								ReportQueryParam queryParam, String returnUrl,PageParam pageParam) {
		
		try {
			ReportRuleData rule = reportService.getQueryRule(queryParam.getReportId());
			Page<Map<String, String>> page = reportService.queryReportPage(queryParam, pageParam,
				rule);
			model.addAttribute("page", page);
			model.addAttribute("queryParam", queryParam);
			if (StringUtil.isNotEmpty(rule.getFilter1Options())) {
				model.addAttribute("filter1Options", MiscUtil.parseJSONWithOrder(rule.getFilter1Options()));
			}
			if (StringUtil.isNotEmpty(rule.getFilter2Options())) {
				model.addAttribute("filter2Options", MiscUtil.parseJSONWithOrder(rule.getFilter2Options()));
			}
			if (StringUtil.isNotEmpty(rule.getFilter3Options())) {
				model.addAttribute("filter3Options", MiscUtil.parseJSONWithOrder(rule.getFilter3Options()));
			}
			if (StringUtil.isNotEmpty(rule.getFilter4Options())) {
				model.addAttribute("filter4Options", MiscUtil.parseJSONWithOrder(rule.getFilter4Options()));
			}
			if (StringUtil.isNotEmpty(rule.getFilter5Options())) {
				model.addAttribute("filter5Options", MiscUtil.parseJSONWithOrder(rule.getFilter5Options()));
			}
			if (StringUtil.isNotEmpty(rule.getFilter6Options())) {
				model.addAttribute("filter6Options", MiscUtil.parseJSONWithOrder(rule.getFilter6Options()));
			}
			if(StringUtil.isEmpty(returnUrl)) {
				returnUrl = "/admin/report/list.htm";
			}
			model.addAttribute("queryRule", rule);
			model.addAttribute("returnUrl", returnUrl);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return VM_PATH + "reportQuery.vm";
		
	}
	
	@RequestMapping("sellStatistics.htm")
	public String sellStatistics(HttpServletResponse response, Model model){
		
		
		return "";
	}
	
	@RequestMapping("memberStatistics.htm")
	public String memberStatistics(HttpServletResponse response, Model model){
		
		
		return "";
	}
	
	@RequestMapping("test")
	public void testExcel(HttpSession session, HttpServletResponse response, Model model) {
		
		try {
			
			String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel";
			String serverRealPath = session.getServletContext().getRealPath("/");
			response.setContentType(CONTENT_TYPE_EXCEL);
			
			String extName = "Excel报表.xls";
			
			response.addHeader("Content-Disposition",
				"attachment; filename=" + new String(extName.getBytes("GB2312"), "ISO8859-1"));
			
			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			
			HashMap<String, String> date = new HashMap<String, String>();
			date.put("appointment_date", "1001");
			date.put("stand_prem", "1001");
			date.put("life_money", "1001");
			date.put("bonus_rate", "1001");
			date.put("agent_code", "1001");
			date.put("money", "1001");
			date.put("dept_id", "1001");
			date.put("real_name", "1001");
			date.put("agent_age", "1001");
			list.add(date);
			list.add(date);
			list.add(date);
			
			ReportHead head = new ReportHead();
			head.setDate("时间2014-08-28");
			
			ReportData report = new ReportData(head, list);
			ReportExcel excel = new ReportExcel(response.getOutputStream());
			excel.print(report.getXMLDocument(), excel.toDocument(serverRealPath, "example1.xml"));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
}
