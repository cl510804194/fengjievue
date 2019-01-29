package com.yjf.esupplier.domain.lottery.convert;

import com.yjf.common.lang.beans.cglib.BeanCopier;
import com.yjf.esupplier.dal.dataobject.LotteryActivityDO;
import com.yjf.esupplier.dal.dataobject.LotteryActivityInstanceDO;
import com.yjf.esupplier.dal.dataobject.LotteryConditionDO;
import com.yjf.esupplier.dal.dataobject.LotteryWinnerDO;
import com.yjf.esupplier.dal.dataobject.PrizeRuleDetailDO;
import com.yjf.esupplier.ws.lottery.data.LotteryActivityData;
import com.yjf.esupplier.ws.lottery.data.LotteryActivityInstanceData;
import com.yjf.esupplier.ws.lottery.data.LotteryConditionData;
import com.yjf.esupplier.ws.lottery.data.LotteryWinnerData;
import com.yjf.esupplier.ws.lottery.data.PrizeRuleDetailData;
import com.yjf.esupplier.ws.lottery.enums.LotteryActivityStatusEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryConditionTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryTimesTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.LotteryTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.PrizeTypeEnum;
import com.yjf.esupplier.ws.lottery.enums.WinnerStatusEnum;

public class LotteryDomainConvertor {
	public static void convertLotteryActivityDomain(LotteryActivityData activityData,
													LotteryActivityDO activityDO) {
		BeanCopier.staticCopy(activityDO, activityData);
		activityData.setLotteryType(LotteryTypeEnum.getByCode(activityDO.getLotterType()));
		activityData.setStatus(LotteryActivityStatusEnum.getByCode(activityDO.getStatus()));
		
	}
	
	public static void convertLotteryActivityDO(LotteryActivityData activityData,
												LotteryActivityDO activityDO) {
		BeanCopier.staticCopy(activityData, activityDO);
		if (activityData.getLotteryType() != null) {
			activityDO.setLotterType(activityData.getLotteryType().code());
		}
		if (activityDO.getStatus() != null) {
			activityDO.setStatus(activityData.getStatus().code());
		}
		
	}
	
	public static void convertLotteryActivityInstanceDomain(LotteryActivityInstanceData activityData,
															LotteryActivityInstanceDO activityDO) {
		BeanCopier.staticCopy(activityDO, activityData);
		activityData.setLotteryType(LotteryTypeEnum.getByCode(activityDO.getLotteryType()));
		
	}
	
	public static void convertLotteryActivityInstanceDO(LotteryActivityInstanceData activityData,
														LotteryActivityInstanceDO activityDO) {
		BeanCopier.staticCopy(activityData, activityDO);
		if (activityData.getLotteryType() != null) {
			activityDO.setLotteryType(activityData.getLotteryType().code());
		}
		
	}
	
	public static void convertLotteryConditionDomain(LotteryConditionData conditionData,
														LotteryConditionDO conditionDO) {
		BeanCopier.staticCopy(conditionDO, conditionData);
		conditionData.setLotteryConditionType(LotteryConditionTypeEnum.getByCode(conditionDO
			.getLotteryConditionType()));
		conditionData.setLotteryTimesType(LotteryTimesTypeEnum.getByCode(conditionDO
			.getLotteryTimesType()));
		
	}
	
	public static void convertLotteryConditionDO(LotteryConditionData conditionData,
													LotteryConditionDO conditionDO) {
		BeanCopier.staticCopy(conditionData, conditionDO);
		if (conditionData.getLotteryConditionType() != null) {
			conditionDO.setLotteryConditionType(conditionData.getLotteryConditionType().code());
		}
		if (conditionData.getLotteryTimesType() != null) {
			conditionDO.setLotteryTimesType(conditionData.getLotteryTimesType().code());
		}
		
	}
	
	public static void convertPrizeRuleDetailDomain(PrizeRuleDetailData prizeRuleDetailData,
													PrizeRuleDetailDO prizeRuleDetailDO) {
		BeanCopier.staticCopy(prizeRuleDetailDO, prizeRuleDetailData);
		prizeRuleDetailData.setPrizeType(PrizeTypeEnum.getByCode(prizeRuleDetailDO.getPrizeType()));
	}
	
	public static void convertPrizeRuleDetailDO(PrizeRuleDetailData prizeRuleDetailData,
												PrizeRuleDetailDO prizeRuleDetailDO) {
		BeanCopier.staticCopy(prizeRuleDetailData, prizeRuleDetailDO);
		if (prizeRuleDetailData.getPrizeType() != null) {
			prizeRuleDetailDO.setPrizeType(prizeRuleDetailData.getPrizeType().code());
		}
		
	}
	
	public static void convertLotteryWinnerDomain(LotteryWinnerData conditionData,
													LotteryWinnerDO conditionDO) {
		BeanCopier.staticCopy(conditionDO, conditionData);
		conditionData.setPrizeType(PrizeTypeEnum.getByCode(conditionDO.getPrizeType()));
		conditionData.setStatus(WinnerStatusEnum.getByCode(conditionDO.getStatus()));
		
	}
}
