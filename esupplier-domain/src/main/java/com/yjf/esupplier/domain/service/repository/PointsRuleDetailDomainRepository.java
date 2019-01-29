package com.yjf.esupplier.domain.service.repository;

import java.util.List;

import com.yjf.esupplier.domain.PointsRuleDetailDomain;

public interface PointsRuleDetailDomainRepository {
	
	public List<PointsRuleDetailDomain> findByRuleId(long pointsRuleId);
	
	/** 新增时使用 */
	public void store(PointsRuleDetailDomain domain);
	
	/** 修改时使用 */
	public void reStore(PointsRuleDetailDomain domain);
	
	/** 逻辑删除时使用 */
	public void remove(PointsRuleDetailDomain domain);
}
