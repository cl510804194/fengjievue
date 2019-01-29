package com.yjf.esupplier.domain;

import java.util.Date;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.domain.util.DomainUtils;
import com.yjf.esupplier.ws.data.LoanDemandData;
import com.yjf.esupplier.ws.enums.LoanDemandStatusEnum;

public class LoanDemandDomain extends LoanDemandData implements Domain {
	
	private static final long serialVersionUID = -137304753657502791L;
	
	public boolean canDismiss() {
		return this.getStatus() == LoanDemandStatusEnum.PASS;
	}
	
	public boolean canCheckPass() {
		return this.getStatus() == LoanDemandStatusEnum.WITE;
	}
	
	public boolean canOnlineTrade() {
		return this.getStatus() == LoanDemandStatusEnum.OFFLINE;
	}
	
	/**
	 * 是否到达投资时间
	 * 
	 * @return
	 */
	public boolean reachInvestDate() {
		Date nowDate = DomainUtils.getNowData();
		if (nowDate.before(this.investAvlDate)) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void examSelf() throws Exception {
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoanDemandDomain [toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
