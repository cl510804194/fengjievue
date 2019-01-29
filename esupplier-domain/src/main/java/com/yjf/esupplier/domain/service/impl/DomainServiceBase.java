package com.yjf.esupplier.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.dal.daointerface.ExtraDAO;

public class DomainServiceBase {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected ExtraDAO extraDAO;
	/** 事务模板 */
	@Autowired
	protected TransactionTemplate transactionTemplate;
	
}
