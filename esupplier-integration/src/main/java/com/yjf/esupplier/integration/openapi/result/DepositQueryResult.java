/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.result;

import java.util.List;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.integration.openapi.info.DepositInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 *                       
 * @Filename DepositQueryResult.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author qichunhai
 *
 * @Email qchunhai@yiji.com
 *       
 * @History
 *<li>Author: qichunhai</li>
 *<li>Date: 2013-3-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DepositQueryResult extends EsupplierBaseResult {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 4580141920460247004L;
	List<DepositInfo>			depositInfos;
	/** 当前页*/
	private int					currPage;
	
	/** 总记录数*/
	private long				count;
	
	/** 本金总金额 */
	private Money				amounts;
	
	/** 总金额  本金+手续费 */
	private Money				amountsIn;
	
	/** 手续费总金额 */
	private Money				charges;
	protected int				pageSize			= 10;
	
	public List<DepositInfo> getDepositInfos() {
		return depositInfos;
	}
	
	public void setDepositInfos(List<DepositInfo> depositInfos) {
		this.depositInfos = depositInfos;
	}
	
	public int getCurrPage() {
		return currPage;
	}
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public long getCount() {
		return count;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
	
	public Money getAmounts() {
		return amounts;
	}
	
	public void setAmounts(Money amounts) {
		this.amounts = amounts;
	}
	
	public Money getAmountsIn() {
		return amountsIn;
	}
	
	public void setAmountsIn(Money amountsIn) {
		this.amountsIn = amountsIn;
	}
	
	public Money getCharges() {
		return charges;
	}
	
	public void setCharges(Money charges) {
		this.charges = charges;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepositQueryResult [depositInfos=");
		builder.append(depositInfos);
		builder.append(", currPage=");
		builder.append(currPage);
		builder.append(", count=");
		builder.append(count);
		builder.append(", amounts=");
		builder.append(amounts);
		builder.append(", amountsIn=");
		builder.append(amountsIn);
		builder.append(", charges=");
		builder.append(charges);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
