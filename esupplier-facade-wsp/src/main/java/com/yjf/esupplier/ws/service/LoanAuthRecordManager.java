package com.yjf.esupplier.ws.service;

import java.util.List;

import com.yjf.esupplier.ws.info.LoanAuthRecordInfo;
import com.yjf.esupplier.ws.service.query.order.LoanAuthRecordQueryOrder;

public interface LoanAuthRecordManager {
	public long countLoanAuthRecordByCondition(LoanAuthRecordQueryOrder queryOrder);
	
	public List<LoanAuthRecordInfo> getLoanAuthRecordByCondition(LoanAuthRecordQueryOrder queryOrder);
}
