package com.yjf.esupplier.domain.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.common.lang.util.ArrayUtil;
import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.domain.PointsRuleDetailDomain;
import com.yjf.esupplier.domain.PointsRuleDomain;
import com.yjf.esupplier.domain.context.EsupplierDomainHolder;
import com.yjf.esupplier.domain.enums.YrdDomainResultEnum;
import com.yjf.esupplier.domain.exception.ExceptionDomainFactory;
import com.yjf.esupplier.domain.service.PointsRuleDomainService;
import com.yjf.esupplier.domain.service.repository.PointsRuleDetailDomainRepository;
import com.yjf.esupplier.domain.service.repository.PointsRuleDomainRepository;
import com.yjf.esupplier.ws.integral.enums.PointsRuleStateEnum;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.integral.order.CreatePointsRuleOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;
import com.yjf.esupplier.ws.userManage.enums.UserLevelEnum;

@Service("pointsRuleDomainService")
public class PointsRuleDomainServiceImpl extends DomainServiceBase implements
																	PointsRuleDomainService {
	
	@Autowired
	PointsRuleDomainRepository pointsRuleDomainRepository;
	@Autowired
	PointsRuleDetailDomainRepository pointsRuleDetailDomainRepository;
	
	@Override
	public EsupplierBaseResult addPointsRule(CreatePointsRuleOrder createPointsRuleOrder) {
		EsupplierBaseResult result = new EsupplierBaseResult();
		
		try {
			String errMsg = checkCreateOrder(createPointsRuleOrder);
			if (StringUtil.isNotEmpty(errMsg)) {
				result.setSuccess(false);
				result.setMessage(errMsg);
				return result;
			}
			
			PointsRuleDomain domain = initPointsRuleDomain(createPointsRuleOrder);
			pointsRuleDomainRepository.store(domain);
			long pointsRuleId = domain.getPointsRuleId();
			createPointsRuleOrder.setPointsRuleId(pointsRuleId);
			PointsRuleDetailDomain[] ruleDetails = initPointsRuleDetailDomain(createPointsRuleOrder);
			if (ruleDetails != null) {
				for (PointsRuleDetailDomain detailDomain : ruleDetails) {
					pointsRuleDetailDomainRepository.store(detailDomain);
				}
			}
			
			result.setSuccess(true);
		} catch (Exception e) {
			throw ExceptionDomainFactory.newEstateDomainException(
				YrdDomainResultEnum.UN_KNOWN_EXCEPTION, e.getMessage());
		}
		
		return result;
	}
	
	@Override
	public EsupplierBaseResult updatePointsRule(CreatePointsRuleOrder createPointsRuleOrder) {
		
		EsupplierBaseResult result = new EsupplierBaseResult();
		
		try {
			if (createPointsRuleOrder.getPointsRuleId() <= 0) {
				result.setSuccess(false);
				result.setMessage("积分规则ID必须大于零！");
				result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
				return result;
			}
			String errMsg = checkCreateOrder(createPointsRuleOrder);
			if (StringUtil.isNotEmpty(errMsg)) {
				result.setSuccess(false);
				result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
				result.setMessage(errMsg);
				return result;
			}
			
			long pointsRuleId = createPointsRuleOrder.getPointsRuleId();
			PointsRuleDomain pointsRule = pointsRuleDomainRepository.loadById(pointsRuleId);
			if (PointsRuleStateEnum.WAIT != pointsRule.getState()) {
				result.setSuccess(false);
				result.setCreditsysResultEnum(EsupplierResultEnum.DO_ACTION_STATUS_ERROR);
				result.setMessage("规则状态已更新，无法修改！");
				return result;
			}
			pointsRule = initUpdatePointsRuleDomain(createPointsRuleOrder);
			pointsRuleDomainRepository.reStore(pointsRule);
			
			List<PointsRuleDetailDomain> oldDetails = pointsRuleDetailDomainRepository
				.findByRuleId(pointsRuleId);
			if (oldDetails != null) {
				for (PointsRuleDetailDomain oldDetail : oldDetails) {
					pointsRuleDetailDomainRepository.remove(oldDetail);
				}
			}
			PointsRuleDetailDomain[] newDetails = initPointsRuleDetailDomain(createPointsRuleOrder);
			if (newDetails != null) {
				for (PointsRuleDetailDomain newDetail : newDetails) {
					pointsRuleDetailDomainRepository.store(newDetail);
				}
			}
			result.setSuccess(true);
		} catch (Exception e) {
			throw ExceptionDomainFactory.newEstateDomainException(
				YrdDomainResultEnum.UN_KNOWN_EXCEPTION, e.getMessage());
		}
		
		return result;
		
	}
	
	private String checkCreateOrder(CreatePointsRuleOrder createOrder) throws ParseException {
		String errMsg = null;
		
		long pointsRuleId = createOrder.getPointsRuleId();
		
		if (pointsRuleId <= 0) { //新增
			PointsRuleDomain domain = new PointsRuleDomain();
			domain.setRuleType(createOrder.getRuleType());
			List<PointsRuleDomain> recordList = pointsRuleDomainRepository.loadByDomain(domain);
			for (PointsRuleDomain record : recordList) {
				if (PointsRuleStateEnum.STOP != record.getState()) {
					return errMsg = "已存在有效的同一类型积分规则！";
				}
			}
		}
		
		PointsRuleDomain domain = new PointsRuleDomain();
		domain.setRuleName(createOrder.getRuleName());
		List<PointsRuleDomain> recordList = pointsRuleDomainRepository.loadByDomain(domain);
		if (pointsRuleId <= 0) {
			if (recordList != null && !recordList.isEmpty()) {
				return errMsg = "该规则名称已存在！";
			}
		} else {
			if (recordList != null && !recordList.isEmpty()
				&& recordList.get(0).getPointsRuleId() != pointsRuleId) {
				return errMsg = "该规则名称已存在！";
			}
		}
		
		PointsTypeEnum ruleType = createOrder.getRuleType();
		if (PointsTypeEnum.SINGLE_CONSUME_PAY == ruleType
			|| ruleType == PointsTypeEnum.SINGLE_CONSUME_COMPLETE) {//支付完成送积分/成长值
			if (ArrayUtil.isEmpty(createOrder.getTradeAmount())
				|| (ArrayUtil.isEmpty(createOrder.getPointsValue()) && ArrayUtil
					.isEmpty(createOrder.getPointsValue()))) {
				return errMsg = "请输入交易金额，或对应积分值或系数！";
			}
			
		} else {
			double pointsValue = createOrder.getPointValue();
			if (pointsValue <= 0.0) {
				return errMsg = "请输入积分值！";
			}
		}
		return errMsg;
	}
	
	private PointsRuleDomain initPointsRuleDomain(CreatePointsRuleOrder createPointsRuleOrder)
																								throws ParseException {
		Date nowDate = EsupplierDomainHolder.get().getSysDate();
		PointsRuleDomain pointsRule = new PointsRuleDomain();
		setDomainData(createPointsRuleOrder, nowDate, pointsRule);
		pointsRule.setRawAddTime(nowDate);
		return pointsRule;
	}
	
	private void setDomainData(CreatePointsRuleOrder createPointsRuleOrder, Date nowDate,
								PointsRuleDomain pointsRule) throws ParseException {
		BeanCopier.staticCopy(createPointsRuleOrder, pointsRule);
		String r_time = createPointsRuleOrder.getR_time();
		if ("time2".equalsIgnoreCase(r_time)) {//录入次日起长期有效
			Date nextDate = DateUtil.increaseDate(DateUtil.getStartTimeOfTheDate(nowDate), 1);
			pointsRule.setStartTime(nextDate);
			pointsRule.setEndTime(null);
		} else {
			pointsRule.setStartTime(DateUtil.string2DateTime(createPointsRuleOrder.getStartTime()));
			if (StringUtil.isNotEmpty(createPointsRuleOrder.getEndTime())) {
				pointsRule.setEndTime(DateUtil.string2DateTime(createPointsRuleOrder.getEndTime()));
			}
		}
	}
	
	private PointsRuleDomain initUpdatePointsRuleDomain(CreatePointsRuleOrder createPointsRuleOrder)
																									throws ParseException {
		long pointsRuleId = createPointsRuleOrder.getPointsRuleId();
		PointsRuleDomain pointsRule = pointsRuleDomainRepository.loadById(pointsRuleId);
		Date nowDate = EsupplierDomainHolder.get().getSysDate();
		setDomainData(createPointsRuleOrder, nowDate, pointsRule);
		return pointsRule;
	}
	
	private PointsRuleDetailDomain[] initPointsRuleDetailDomain(CreatePointsRuleOrder createPointsRuleOrder) {
		
		PointsRuleDetailDomain[] ruleDetails = null;
		long pointsRuleId = createPointsRuleOrder.getPointsRuleId();
		PointsTypeEnum ruleType = createPointsRuleOrder.getRuleType();
		if (PointsTypeEnum.SINGLE_CONSUME_PAY == ruleType
			|| PointsTypeEnum.SINGLE_CONSUME_COMPLETE == ruleType) {//消费（付款\交易完成）
			String[] pointsValues = createPointsRuleOrder.getPointsValue();
			String[] coefficient = createPointsRuleOrder.getCoefficient();
			String[] userLevel = createPointsRuleOrder.getUserLevel();
			String[] tradeAmount = createPointsRuleOrder.getTradeAmount();
			ruleDetails = new PointsRuleDetailDomain[pointsValues.length];
			for (int i = 0; i < tradeAmount.length; i++) {
				PointsRuleDetailDomain pointsRuleDetail = new PointsRuleDetailDomain();
				pointsRuleDetail.setPointsRuleId(pointsRuleId);
				pointsRuleDetail.setPriority((i + 1) * 10);
				pointsRuleDetail.setAmount(new Money(tradeAmount[i]));
				if (ArrayUtil.isNotEmpty(userLevel)) {
					pointsRuleDetail.setUserLevel(UserLevelEnum.getByCode(userLevel[i]));
				}
				if (ArrayUtil.isNotEmpty(pointsValues)) {
					if (StringUtil.isNotEmpty(pointsValues[i])) {
						pointsRuleDetail.setPointsValue(NumberUtil.parseLong(pointsValues[i]));
					}
				} else if (ArrayUtil.isNotEmpty(coefficient)) {
					if (StringUtil.isNotEmpty(coefficient[i])) {
						pointsRuleDetail.setCoefficient(NumberUtil.parseDouble(coefficient[i]));
					}
				}
				ruleDetails[i] = pointsRuleDetail;
			}
		}
		
		return ruleDetails;
	}
}
