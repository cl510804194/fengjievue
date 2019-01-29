/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.service;

import javax.jws.WebService;

import com.yjf.esupplier.ws.info.OperationJournalInfo;
import com.yjf.esupplier.ws.order.OperationJournalAddOrder;
import com.yjf.esupplier.ws.result.OperationJournalServiceResult;
import com.yjf.esupplier.ws.service.query.order.OperationJournalQueryOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * @Filename OperationJournalService.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author jiajie
 * 
 * @Email hjiajie@yiji.com
 * 
 * @History <li>Author: jiajie</li> <li>Date: 2013-1-8</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@WebService
public interface OperationJournalService {
	
	/**
	 * 添加一条操作日志
	 * @param operationJournalAddOrder
	 * @return
	 */
	public OperationJournalServiceResult addOperationJournalInfo(	OperationJournalAddOrder operationJournalAddOrder);

    QueryBaseBatchResult<OperationJournalInfo> queryOperationJournalInfo(OperationJournalQueryOrder queryOrder);
	
}
