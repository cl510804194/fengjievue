package com.yjf.esupplier.integration.openapi.result;

import java.util.List;

import com.yjf.esupplier.integration.openapi.info.IncomeOutcomeInfoList;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 收支明细查询结果集
 * */

public class QueryIncomOutcomResult  extends EsupplierBaseResult{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -5329266660035554845L;
	
	/** 本页记录  */
	List<IncomeOutcomeInfoList>			incomeOutcomeInfoList;
		
	/** 总记录数*/
	private int							totalCount;
	
	/** 总页数*/
	private int 						totalPageCount;
	
	/** 当前页 */
	private int							currentPageNo;
	
	/** code */
	private String						code;

	public List<IncomeOutcomeInfoList> getIncomeOutcomeInfoList() {
		return incomeOutcomeInfoList;
	}

	public void setIncomeOutcomeInfoList(
			List<IncomeOutcomeInfoList> incomeOutcomeInfoList) {
		this.incomeOutcomeInfoList = incomeOutcomeInfoList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "QueryIncomOutcomResult [incomeOutcomeInfoList="
				+ incomeOutcomeInfoList + ", totalCount=" + totalCount
				+ ", totalPageCount=" + totalPageCount + ", currentPageNo="
				+ currentPageNo + ", code=" + code + "]";
	}

	
	
}
