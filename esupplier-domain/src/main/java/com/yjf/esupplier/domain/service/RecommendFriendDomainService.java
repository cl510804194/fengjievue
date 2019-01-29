package com.yjf.esupplier.domain.service;

import com.yjf.esupplier.ws.friend.order.UpdateRecommendFriendOrder;
import com.yjf.esupplier.ws.order.CreateRecommendFriendOrder;

public interface RecommendFriendDomainService {
	
	public void createDomain(CreateRecommendFriendOrder domainOrder);

    public void updateDomain(UpdateRecommendFriendOrder domainOrder);

}
