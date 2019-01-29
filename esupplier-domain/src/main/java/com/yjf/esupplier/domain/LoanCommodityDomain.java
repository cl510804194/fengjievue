package com.yjf.esupplier.domain;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.data.LoanCommodityData;

public class LoanCommodityDomain extends LoanCommodityData implements Domain {
	
	private static final long serialVersionUID = 2476345859977595309L;
	
	boolean isDelete = false;
	
	public boolean isDelete() {
		return this.isDelete;
	}
	
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	@Override
	public void examSelf() throws Exception {
	}
	
}
