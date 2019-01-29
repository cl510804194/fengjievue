package com.yjf.esupplier.ws.service.query.result;

import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.base.PageComponent;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class QueryBaseBatchResult<T> extends EsupplierBaseResult {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 420002915574977408L;
	long totalCount = 0;
	long wfkCount = 0;
	long dpjCount = 0;
	
	Money totalMoney = new Money(0);
	long pageSize = 10;
	long pageNumber = 1;
	long pageCount = 1;
	List<T> pageList;
	
	public void initPageParam(PageComponent component) {
		this.setTotalCount(component.getRowCount());
		this.setWfkCount(component.getWfkCount());
		this.setDpjCount(component.getDpjCount());
		this.setPageSize(component.getPageSize());
		this.setPageNumber(component.getCurPage());
		this.pageCount = component.getPageCount();
	}
	
	public List<T> getPageList() {
		return pageList;
	}
	
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	public long getWfkCount() {
		return wfkCount;
	}
	
	public void setWfkCount(long wfkCount) {
		this.wfkCount = wfkCount;
	}
	
	public long getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public long getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public Money getTotalMoney() {
		return this.totalMoney;
	}
	
	public void setTotalMoney(Money totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public long getPageCount() {
		return this.pageCount;
	}
	
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	
	public long getDpjCount() {
		return dpjCount;
	}
	
	public void setDpjCount(long dpjCount) {
		this.dpjCount = dpjCount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryBaseBatchResult [totalCount=");
		builder.append(totalCount);
		builder.append(", wfkCount=");
		builder.append(wfkCount);
		builder.append(", dpjCount=");
		builder.append(dpjCount);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append(", pageList=");
		builder.append(pageList);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
