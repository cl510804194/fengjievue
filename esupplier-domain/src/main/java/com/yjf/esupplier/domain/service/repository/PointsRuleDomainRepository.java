package com.yjf.esupplier.domain.service.repository;

import java.util.List;

import com.yjf.esupplier.domain.PointsRuleDomain;

public interface PointsRuleDomainRepository {
	
	public List<PointsRuleDomain> loadByDomain(PointsRuleDomain domain);
	
	public PointsRuleDomain loadById(long pointsRuleId);
	
	/** 新增时使用 */
	public void store(PointsRuleDomain domain);
	
	/** 修改时使用 */
	public void reStore(PointsRuleDomain domain);
	
	/** 逻辑删除时使用 */
	public void remove(PointsRuleDomain domain);
}
