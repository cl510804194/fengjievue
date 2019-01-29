package com.yjf.esupplier.domain.service.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.dal.daointerface.LotteryActivityDAO;
import com.yjf.esupplier.dal.daointerface.LotteryActivityInstanceDAO;
import com.yjf.esupplier.dal.daointerface.LotteryConditionDAO;
import com.yjf.esupplier.dal.daointerface.PrizeRuleDAO;
import com.yjf.esupplier.dal.daointerface.PrizeRuleDetailDAO;

public class LotteryDomainRepositoryBase {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected LotteryActivityDAO lotteryActivityDAO;
	
	@Autowired
	protected LotteryActivityInstanceDAO lotteryActivityInstanceDAO;
	
	@Autowired
	protected LotteryConditionDAO lotteryConditionDAO;
	
	@Autowired
	protected PrizeRuleDAO prizeRuleDAO;
	
	@Autowired
	protected PrizeRuleDetailDAO prizeRuleDetailDAO;
}
