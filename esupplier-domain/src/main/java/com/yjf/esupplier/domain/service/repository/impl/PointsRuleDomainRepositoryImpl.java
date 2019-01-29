package com.yjf.esupplier.domain.service.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.daointerface.PointsRuleDAO;
import com.yjf.esupplier.dal.daointerface.PointsRuleDetailDAO;
import com.yjf.esupplier.dal.dataobject.PointsRuleDO;
import com.yjf.esupplier.domain.PointsRuleDomain;
import com.yjf.esupplier.domain.convert.DomainConvert;
import com.yjf.esupplier.domain.service.repository.PointsRuleDomainRepository;

@Service("pointsRuleDomainRepository")
public class PointsRuleDomainRepositoryImpl extends DomainRepositoryBase implements
																		PointsRuleDomainRepository {
	
	@Autowired
	PointsRuleDAO pointsRuleDAO;
	@Autowired
	PointsRuleDetailDAO pointsRuleDetailDAO;
	
	@Override
	public void store(PointsRuleDomain domain) {
		PointsRuleDO pointsRule = new PointsRuleDO();
		covertDObyDomain(domain, pointsRule);
		long pointsRuleId = pointsRuleDAO.insert(pointsRule);
		domain.setPointsRuleId(pointsRuleId);
	}
	
	private void covertDObyDomain(PointsRuleDomain domain, PointsRuleDO pointsRule) {
		DomainConvert.convertPointsRuleDO(domain, pointsRule);
	}
	
	@Override
	public void reStore(PointsRuleDomain domain) {
		PointsRuleDO pointsRule = new PointsRuleDO();
		DomainConvert.convertPointsRuleDO(domain, pointsRule);
		pointsRuleDAO.update(pointsRule);
	}
	
	@Override
	public void remove(PointsRuleDomain domain) {
		pointsRuleDAO.deleteById(domain.getPointsRuleId());
		pointsRuleDetailDAO.deleteByRuleId(domain.getPointsRuleId());
	}
	
	@Override
	public PointsRuleDomain loadById(long pointsRuleId) {
		PointsRuleDomain domain = new PointsRuleDomain();
		PointsRuleDO pointsRule = pointsRuleDAO.findById(pointsRuleId);
		if (pointsRule != null) {
			convertDomainByDO(domain, pointsRule);
		}
		return domain;
	}
	
	private void convertDomainByDO(PointsRuleDomain domain, PointsRuleDO pointsRule) {
		DomainConvert.convertPointsRuleDomain(domain, pointsRule);
	}
	
	@Override
	public List<PointsRuleDomain> loadByDomain(PointsRuleDomain domain) {
		PointsRuleDO pointsRule = new PointsRuleDO();
		BeanCopier.staticCopy(domain, pointsRule);
		if (domain.getRuleType() != null) {
			pointsRule.setRuleType(domain.getRuleType().getCode());
		}
		if (domain.getState() != null) {
			pointsRule.setState(domain.getState().getCode());
		}
		List<PointsRuleDO> recordList = pointsRuleDAO.queryList(pointsRule, 0, 10, null);
		List<PointsRuleDomain> domainList = new ArrayList<PointsRuleDomain>();
		for (PointsRuleDO rdo : recordList) {
			PointsRuleDomain pointsRuleDomain = new PointsRuleDomain();
			convertDomainByDO(pointsRuleDomain, rdo);
			domainList.add(pointsRuleDomain);
		}
		return domainList;
	}
}
