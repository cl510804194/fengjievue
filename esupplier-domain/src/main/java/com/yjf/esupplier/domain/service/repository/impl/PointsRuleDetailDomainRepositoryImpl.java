package com.yjf.esupplier.domain.service.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.daointerface.PointsRuleDetailDAO;
import com.yjf.esupplier.dal.dataobject.PointsRuleDetailDO;
import com.yjf.esupplier.domain.PointsRuleDetailDomain;
import com.yjf.esupplier.domain.service.repository.PointsRuleDetailDomainRepository;

@Service("pointsRuleDetailDomainRepository")
public class PointsRuleDetailDomainRepositoryImpl extends DomainRepositoryBase implements
																				PointsRuleDetailDomainRepository {
	
	PointsRuleDetailDAO pointsRuleDetailDAO;
	
	@Override
	public void store(PointsRuleDetailDomain domain) {
		PointsRuleDetailDO pointsRuleDetail = new PointsRuleDetailDO();
		BeanCopier.staticCopy(domain, pointsRuleDetail);
		long pointsRuleDetailId = pointsRuleDetailDAO.insert(pointsRuleDetail);
		domain.setPointsRuleDetailId(pointsRuleDetailId);
	}
	
	@Override
	public void reStore(PointsRuleDetailDomain domain) {
		PointsRuleDetailDO pointsRuleDetail = new PointsRuleDetailDO();
		BeanCopier.staticCopy(domain, pointsRuleDetail);
		pointsRuleDetailDAO.update(pointsRuleDetail);
	}
	
	@Override
	public void remove(PointsRuleDetailDomain domain) {
		pointsRuleDetailDAO.deleteById(domain.getPointsRuleDetailId());
	}
	
	@Override
	public List<PointsRuleDetailDomain> findByRuleId(long pointsRuleId) {
		List<PointsRuleDetailDO> details = pointsRuleDetailDAO.findByRuleId(pointsRuleId);
		List<PointsRuleDetailDomain> domains = new ArrayList<PointsRuleDetailDomain>();
		for (PointsRuleDetailDO pdo : details) {
			PointsRuleDetailDomain domain = new PointsRuleDetailDomain();
			BeanCopier.staticCopy(pdo, domain);
			domains.add(domain);
		}
		return domains;
	}
	
}
