package com.yjf.esupplier.ws.friend.services;


import com.yjf.esupplier.ws.order.CreateRecommendRuleOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

import javax.jws.WebService;

@WebService
public interface RecommendRuleService {
	
	public EsupplierBaseResult addRecommendRule(CreateRecommendRuleOrder createRecommendRuleOrder);
	


}
