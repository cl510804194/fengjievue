package com.yjf.esupplier.ws.service;

import java.util.List;

import com.yjf.esupplier.ws.enums.LoanDemandExpendEnum;
import com.yjf.esupplier.ws.info.LoanDemandExtendInfo;
import com.yjf.esupplier.ws.order.CreateLoanDemandExtendOrder;

/**
 * 
 * @Filename ReleaseManager.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author zjl
 * 
 * @Email zjialin@yiji.com
 * 
 * @History <li>Author: zjl</li> <li>Date: 2013-6-7</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public interface LoanDemandExtendService {
	
	public void addLoanDemandExtend(CreateLoanDemandExtendOrder loanDemandExtend);
	
	public void updateByDemandIdAndProperty(CreateLoanDemandExtendOrder loanDemandExtend);
	
	public void deleteByDemandIdAndProperty(long loanDemandId, String propertyKey);
	
	public void deleteByDemandIdAndPropertyLike(long loanDemandId, String propertyKey);
	
	public LoanDemandExtendInfo findByDemandIdAndProperty(long loanDemandId, String propertyKey);
	
	public List<LoanDemandExtendInfo> findByDemandIdAndPropertyLike(long loanDemandId,
																	String propertyKey);
	
	public List<LoanDemandExtendInfo> findByDemandId(long loanDemandId);
	
	LoanDemandExtendInfo findByDemandIdAndProperty(long loanDemandId,
													LoanDemandExpendEnum demandExpendEnum);
}
