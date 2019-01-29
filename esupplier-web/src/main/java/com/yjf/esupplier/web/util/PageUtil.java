package com.yjf.esupplier.web.util;

import java.util.List;

import com.yjf.esupplier.common.page.Page;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

public class PageUtil {
	public static <T> Page<T> getCovertPage(QueryBaseBatchResult<T> batchResult) {
		long start = (batchResult.getPageNumber() - 1) * batchResult.getPageSize();
		Page<T> newPage = new Page<T>(start, batchResult.getTotalCount(),
			(int) batchResult.getPageSize(), batchResult.getPageList());
		return newPage;
	}
	
	public static <T> Page<T> getCovertPageByPageTools(List<T> pageList, PageTool pageTool) {
		long start = (pageTool.getCurrentPage() - 1) * pageTool.getPageSize();
		Page<T> newPage = new Page<T>(start, pageTool.getTotalRow(), pageTool.getPageSize(),
			pageList);
		return newPage;
	}
}
