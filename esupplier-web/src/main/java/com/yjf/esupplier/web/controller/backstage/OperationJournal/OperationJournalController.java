package com.yjf.esupplier.web.controller.backstage.OperationJournal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjf.esupplier.common.page.PageParam;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.info.OperationJournalInfo;
import com.yjf.esupplier.ws.service.OperationJournalService;
import com.yjf.esupplier.ws.service.query.order.OperationJournalQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 短信日志 Created by zhaohaibing on 2014/7/3.
 */
@Controller
@RequestMapping("admin")
public class OperationJournalController extends BaseAutowiredController {
	private final String vm_path = "/backstage/OperationJournal/";
	@Autowired
	OperationJournalService operationJournalService;
	
	/**
	 * 日志管理页面
	 */
	@RequestMapping("OperationJournal.htm")
	public String queryOperationJournalPageList(OperationJournalQueryOrder queryOrder,
												PageParam pageParam, HttpServletResponse response,
												Model model) {
		try {
			queryOrder.setPageSize(pageParam.getPageSize());
			queryOrder.setPageNumber(pageParam.getPageNo());
			QueryBaseBatchResult<OperationJournalInfo> queryBaseBatchResult = operationJournalService
				.queryOperationJournalInfo(queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(queryBaseBatchResult));
			model.addAttribute("queryConditions", queryOrder);
		} catch (Exception e) {
			logger.error("查询短信出错", e.getMessage(), e);
		}
		
		return vm_path + "OperationJournalManage.vm";
	}
	
	@Override
	protected String[] getDateInputNameArray() {
		return new String[] { "operatorTimeStart", "operatorTimeEnd" };
	}
	
}
