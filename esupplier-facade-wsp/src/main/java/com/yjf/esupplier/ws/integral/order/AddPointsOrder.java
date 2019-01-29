package com.yjf.esupplier.ws.integral.order;

import java.util.Date;

import com.yjf.common.lang.util.DateUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.integral.enums.PointsTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.userManage.enums.UserLevelRuleType;

/**
 * 按规则发放积分order
 * 
 * 
 * @author qch
 * 
 */
public class AddPointsOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = 703872127852215528L;
	
	/** 用户id */
	protected long userId;
	/** 积分规则类型 */
	protected PointsTypeEnum pointsTypeEnum;
	/**
	 * 调用时不需要传入
	 */
	private UserLevelRuleType valueType = UserLevelRuleType.POINT;
	/**
	 * 交易金额
	 */
	private Money tradeMoney = Money.zero();
	/**
	 * 订单号，评价号等
	 */
	protected String outBizNo;
	/**
	 * 交易积分倍数
	 */
	protected double tradeIntegralMultiples = 1.0;
	
	@Override
	public void check() {
		validateHasZore(userId, "用户userId");
		validateNotNull(pointsTypeEnum, "积分规则类型");
		if (pointsTypeEnum == PointsTypeEnum.REGISTER) {
			outBizNo = String.valueOf(userId);
		}
		if (pointsTypeEnum == PointsTypeEnum.LOGIN) {
			outBizNo = String.valueOf(userId) + "_" + DateUtil.dtSimpleFormat(new Date());
		}
		if (pointsTypeEnum == PointsTypeEnum.UPLOAD_AVATAR) {
			outBizNo = String.valueOf(userId);
		}
		if (pointsTypeEnum == PointsTypeEnum.BINDING_MAILBOX) {
			outBizNo = String.valueOf(userId);
		}
		if (pointsTypeEnum == PointsTypeEnum.SINGLE_CONSUME_COMPLETE
			|| pointsTypeEnum == PointsTypeEnum.SINGLE_CONSUME_PAY) {
			validateMoneyGreaterThanZero(tradeMoney, "交易金额");
			
		}
		validateHasText(outBizNo, "交易订单id");
		
	}
	
	public long getUserId() {
		return this.userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public PointsTypeEnum getPointsTypeEnum() {
		return this.pointsTypeEnum;
	}
	
	public void setPointsTypeEnum(PointsTypeEnum pointsTypeEnum) {
		this.pointsTypeEnum = pointsTypeEnum;
	}
	
	public Money getTradeMoney() {
		return this.tradeMoney;
	}
	
	public void setTradeMoney(Money tradeMoney) {
		this.tradeMoney = tradeMoney;
	}
	
	public UserLevelRuleType getValueType() {
		return this.valueType;
	}
	
	public void setValueType(UserLevelRuleType valueType) {
		this.valueType = valueType;
	}
	
	public String getOutBizNo() {
		return this.outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public double getTradeIntegralMultiples() {
		return this.tradeIntegralMultiples;
	}
	
	public void setTradeIntegralMultiples(double tradeIntegralMultiples) {
		this.tradeIntegralMultiples = tradeIntegralMultiples;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddPointsOrder [userId=");
		builder.append(userId);
		builder.append(", pointsTypeEnum=");
		builder.append(pointsTypeEnum);
		builder.append(", valueType=");
		builder.append(valueType);
		builder.append(", tradeMoney=");
		builder.append(tradeMoney);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", tradeIntegralMultiples=");
		builder.append(tradeIntegralMultiples);
		builder.append("]");
		return builder.toString();
	}
	
}
