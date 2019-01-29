package com.yjf.esupplier.ws.gifamount.order;

import java.util.Arrays;
import java.util.Date;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyGiveTypeEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;
import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class CreateGiftMoneyOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = 8060079402917808781L;
	/**
	 * 优惠券id
	 */
	protected long giftId;
	
	protected GiftMoneyTypeEnum type;
	
	/**
	 * 优惠券名称
	 */
	protected String giftName;
	
	/**
	 * 优惠券发放金额
	 */
	protected Money totalAmount = new Money(0, 0);
	
	/**
	 * 优惠券金额
	 */
	protected Money amount = new Money(0, 0);
	/**
	 * 优惠券发放金额
	 */
	protected Money usedAmount = new Money(0, 0);
	/**
	 * 优惠券使用类型
	 */
	protected String useType;
	
	protected String useAmount;
	
	/**
	 * 优惠券使用结束日期
	 */
	protected Date endDate;
	/**
	 * 优惠券使用开始日期
	 */
	protected Date startDate;
	
	protected long personNum;
	
	protected long giftNum;
	
	protected long usedGiftNum;
	
	protected Date useStartDate;
	
	protected Date useEndDate;
	
	/**
	 * 状态
	 */
	protected GiftMoneyStatusEnum status;
	/**
	 * 优惠券创建者
	 */
	protected long createUserid;
	/**
	 * 优惠券创建者名称
	 */
	protected String createUsername;
	/**
	 * 优惠券添加时间
	 */
	protected Date rawAddTime;
	/**
	 * 红优惠券更新时间
	 */
	protected Date rawUpdateTime;
	/**
	 * 优惠券描述
	 */
	protected String description;
	
	protected GiftMoneyGiveTypeEnum giveRuleType;
	
	protected String[] giveRuleAmount;
	
	protected String[] giveAmount;
	
	protected GiftMoneyGiveTypeEnum giveType;
	
	protected String increase;
	
	protected String timeLimit;
	
	protected String outBizNo;
	
	@Override
	public void check() {
		this.validateHasText(giftName, "优惠券名称");
		if (this.getType() != GiftMoneyTypeEnum.GAIN_AMOUNT) {
			this.validateMoneyGreaterThanZero(totalAmount, "优惠券总金额");
		}
		this.validateNotNull(type, "优惠券类型");
		this.validateNotNull(useType, "优惠券使用类型");
		this.validateNotNull(startDate, "活动开始时间");
		this.validateNotNull(endDate, "活动结束时间");
		
		this.validateNotNull(giveRuleType, "发放规则类型");
		if (giveRuleType != GiftMoneyGiveTypeEnum.DIRECT) {
			this.validateNotNull(giveRuleAmount, "满足优惠券发放的金额");
		}
		if (this.getType() != GiftMoneyTypeEnum.GAIN_AMOUNT) {
			this.validateNotNull(giveAmount, "优惠券发放金额");
		}
		Assert.isTrue(new Date().before(endDate), "活动结束时间要大于当前时间");
		if (StringUtil.isEmpty(timeLimit) && useStartDate == null && useEndDate == null) {
			this.validateNotNull(timeLimit, "优惠券有效期");
		} else if (StringUtil.isEmpty(timeLimit)) {
			this.validateNotNull(useStartDate, "有效期的开始时间");
			this.validateNotNull(useEndDate, "有效期的结束时间");
			Assert.isTrue(startDate.before(useStartDate), "优惠券有效期的开始时间要大于活动的开始时间");
			Assert.isTrue(endDate.before(useEndDate), "优惠券有效期的结束时间要大于活动的结束时间");
		}
	}
	
	public long getGiftId() {
		return giftId;
	}
	
	public void setGiftId(long giftId) {
		this.giftId = giftId;
	}
	
	public String getGiftName() {
		return giftName;
	}
	
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	
	public long getPersonNum() {
		return personNum;
	}
	
	public void setPersonNum(long personNum) {
		this.personNum = personNum;
	}
	
	public long getGiftNum() {
		return giftNum;
	}
	
	public void setGiftNum(long giftNum) {
		this.giftNum = giftNum;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public Date getUseStartDate() {
		return useStartDate;
	}
	
	public void setUseStartDate(Date useStartDate) {
		this.useStartDate = useStartDate;
	}
	
	public Date getUseEndDate() {
		return useEndDate;
	}
	
	public void setUseEndDate(Date useEndDate) {
		this.useEndDate = useEndDate;
	}
	
	public String getUseType() {
		return useType;
	}
	
	public void setUseType(String useType) {
		this.useType = useType;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public GiftMoneyStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(GiftMoneyStatusEnum status) {
		this.status = status;
	}
	
	public long getCreateUserid() {
		return createUserid;
	}
	
	public void setCreateUserid(long createUserid) {
		this.createUserid = createUserid;
	}
	
	public String getCreateUsername() {
		return createUsername;
	}
	
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Money getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Money totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Money getUsedAmount() {
		return usedAmount;
	}
	
	public void setUsedAmount(Money usedAmount) {
		this.usedAmount = usedAmount;
	}
	
	public GiftMoneyTypeEnum getType() {
		return type;
	}
	
	public void setType(GiftMoneyTypeEnum type) {
		this.type = type;
	}
	
	public String getUseAmount() {
		return useAmount;
	}
	
	public void setUseAmount(String useAmount) {
		this.useAmount = useAmount;
	}
	
	public GiftMoneyGiveTypeEnum getGiveRuleType() {
		return giveRuleType;
	}
	
	public void setGiveRuleType(GiftMoneyGiveTypeEnum giveRuleType) {
		this.giveRuleType = giveRuleType;
	}
	
	public String[] getGiveRuleAmount() {
		return giveRuleAmount;
	}
	
	public void setGiveRuleAmount(String[] giveRuleAmount) {
		this.giveRuleAmount = giveRuleAmount;
	}
	
	public String[] getGiveAmount() {
		return giveAmount;
	}
	
	public void setGiveAmount(String[] giveAmount) {
		this.giveAmount = giveAmount;
	}
	
	public GiftMoneyGiveTypeEnum getGiveType() {
		return giveType;
	}
	
	public void setGiveType(GiftMoneyGiveTypeEnum giveType) {
		this.giveType = giveType;
	}
	
	public String getIncrease() {
		return increase;
	}
	
	public void setIncrease(String increase) {
		this.increase = increase;
	}
	
	public String getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public String getOutBizNo() {
		return outBizNo;
	}
	
	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}
	
	public long getUsedGiftNum() {
		return usedGiftNum;
	}
	
	public void setUsedGiftNum(long usedGiftNum) {
		this.usedGiftNum = usedGiftNum;
	}
	
	@Override
	public String toString() {
		return "CreateGiftMoneyOrder{" + "giftId=" + giftId + ", type='" + type + '\''
				+ ", giftName='" + giftName + '\'' + ", totalAmount=" + totalAmount + ", amount="
				+ amount + ", usedAmount=" + usedAmount + ", useType='" + useType + '\''
				+ ", useAmount='" + useAmount + '\'' + ", endDate=" + endDate + ", startDate="
				+ startDate + ", personNum=" + personNum + ", giftNum=" + giftNum
				+ ", usedGiftNum=" + usedGiftNum + ", useStartDate=" + useStartDate
				+ ", useEndDate=" + useEndDate + ", status='" + status + '\'' + ", createUserid="
				+ createUserid + ", createUsername='" + createUsername + '\'' + ", rawAddTime="
				+ rawAddTime + ", rawUpdateTime=" + rawUpdateTime + ", description='" + description
				+ '\'' + ", giveRuleType='" + giveRuleType + '\'' + ", giveRuleAmount="
				+ Arrays.toString(giveRuleAmount) + ", giveAmount=" + Arrays.toString(giveAmount)
				+ ", giveType='" + giveType + '\'' + ", increase='" + increase + '\''
				+ ", timeLimit='" + timeLimit + '\'' + ", outBizNo='" + outBizNo + '\'' + '}';
	}
}
