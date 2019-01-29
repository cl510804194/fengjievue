package com.yjf.esupplier.ws.service;

import com.yjf.esupplier.ws.info.RechargeFlowInfo;
import com.yjf.esupplier.ws.service.query.order.RechargeFlowOrder;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

public interface RechargeFlowManager {
	
	QueryBaseBatchResult<RechargeFlowInfo> getFlow(RechargeFlowOrder rechargeFlowOrder);

    /**
     * 后台快捷划入查询
     * @param rechargeFlowOrder
     * @return
     */
    QueryBaseBatchResult<RechargeFlowInfo> getFlowRechargeFlow(RechargeFlowOrder rechargeFlowOrder);
}
