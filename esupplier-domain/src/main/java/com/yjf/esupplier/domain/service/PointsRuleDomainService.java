package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.ws.integral.order.CreatePointsRuleOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface PointsRuleDomainService {
	
	public EsupplierBaseResult addPointsRule(CreatePointsRuleOrder createPointsRuleOrder);
	
	public EsupplierBaseResult updatePointsRule(CreatePointsRuleOrder createPointsRuleOrder);
	
}
