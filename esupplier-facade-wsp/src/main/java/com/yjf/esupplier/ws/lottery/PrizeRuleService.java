/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * qch 下午3:25:34 创建
 */
package com.yjf.esupplier.ws.lottery;

import javax.jws.WebService;

import com.yjf.esupplier.ws.lottery.order.AddPrizeRuleOrder;
import com.yjf.esupplier.ws.lottery.order.UpdatePrizeRuleOrder;
import com.yjf.esupplier.ws.order.ProcessOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * 
 * @author qch
 * 
 */
@WebService
public interface PrizeRuleService {
	EsupplierBaseResult addPrizeRule(AddPrizeRuleOrder prizeRuleOrder);
	
	EsupplierBaseResult updatePrizeRule(UpdatePrizeRuleOrder prizeRuleOrder);
	
	EsupplierBaseResult removePrizeRule(ProcessOrder processOrder);
}
