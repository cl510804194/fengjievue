package com.yjf.esupplier.ws.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.ExtPayTypeEnum;

public class UserBankOrder extends ValidateOrderBase implements Order {
	private static final long serialVersionUID = -6164707215088677049L;
	/**
	 * 主键id(修改时使用)
	 */
	private long id;
	/**
	 * user userbaseId
	 */
	private String userBaseId;
	/**
	 * 银行卡号
	 */
	private String bankCardNo;
	/**
	 * 银行CODE ICBC
	 */
	private String bankType;
	/**
	 * 银行联行号
	 */
	private String bankKey;
	/**
	 * 省（自治区）直辖市
	 */
	private String bankProvince;
	/**
	 * 城市
	 */
	private String bankCity;
	/**
	 * 是否默认
	 */
	private BooleanEnum isDefault = BooleanEnum.NO;
	/**
	 * 序号
	 */
	private int bankOrder;
	/**
	 * 签约号
	 */
	private String pactNo;
	/**
	 * 签约卡
	 */
	private BooleanEnum isPact = BooleanEnum.NO;
	
	/**
	 * 删除标记
	 */
	private BooleanEnum isDel = BooleanEnum.NO;
	/**
	 * 是否初始化卡号
	 */
	private BooleanEnum isInitCardInfo = BooleanEnum.NO;

	/**
	 * 银行账户名
	 */
	private String bankAccountName;
	/**
	 * 用户卡用途
	 */
	private ExtPayTypeEnum cardUseType;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserBaseId() {
		return this.userBaseId;
	}
	
	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}
	
	public String getBankCardNo() {
		return this.bankCardNo;
	}
	
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
	public String getBankType() {
		return this.bankType;
	}
	
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	
	public String getBankKey() {
		return this.bankKey;
	}
	
	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}
	
	public String getBankProvince() {
		return this.bankProvince;
	}
	
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	
	public String getBankCity() {
		return this.bankCity;
	}
	
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	
	public BooleanEnum getIsDefault() {
		return this.isDefault;
	}
	
	public void setIsDefault(BooleanEnum isDefault) {
		this.isDefault = isDefault;
	}
	
	public int getBankOrder() {
		return this.bankOrder;
	}
	
	public void setBankOrder(int bankOrder) {
		this.bankOrder = bankOrder;
	}
	
	public BooleanEnum getIsInitCardInfo() {
		return this.isInitCardInfo;
	}
	
	public void setIsInitCardInfo(BooleanEnum isInitCardInfo) {
		this.isInitCardInfo = isInitCardInfo;
	}
	
	public String getPactNo() {
		return this.pactNo;
	}
	
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	
	public BooleanEnum getIsDel() {
		return this.isDel;
	}
	
	public void setIsDel(BooleanEnum isDel) {
		this.isDel = isDel;
	}
	
	public BooleanEnum getIsPact() {
		return this.isPact;
	}
	
	public void setIsPact(BooleanEnum isPact) {
		this.isPact = isPact;
	}
	
	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public ExtPayTypeEnum getCardUseType() {
		return cardUseType;
	}

	public void setCardUseType(ExtPayTypeEnum cardUseType) {
		this.cardUseType = cardUseType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserBankOrder [id=");
		builder.append(id);
		builder.append(", userBaseId=");
		builder.append(userBaseId);
		builder.append(", bankCardNo=");
		builder.append(bankCardNo);
		builder.append(", bankType=");
		builder.append(bankType);
		builder.append(", bankKey=");
		builder.append(bankKey);
		builder.append(", bankProvince=");
		builder.append(bankProvince);
		builder.append(", bankCity=");
		builder.append(bankCity);
		builder.append(", isDefault=");
		builder.append(isDefault);
		builder.append(", bankOrder=");
		builder.append(bankOrder);
		builder.append(", pactNo=");
		builder.append(pactNo);
		builder.append(", isPact=");
		builder.append(isPact);
		builder.append(", isDel=");
		builder.append(isDel);
		builder.append(", isInitCardInfo=");
		builder.append(isInitCardInfo);
		builder.append(", bankAccountName=");
		builder.append(bankAccountName);
		builder.append(", cardUseType=");
		builder.append(cardUseType);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public void check() {
		this.validateHasText(this.userBaseId, "user base id");
		//this.validateGreaterThan(this.getBankOrder(), "序号不能为0");
		this.validateHasText(this.bankCardNo, "银行卡号");
		this.validateHasText(this.bankCity, "城市");
		this.validateHasText(this.bankProvince, "省份");
		this.validateHasText(this.bankType, "银行编码(ICBC)");
		this.validateNotNull(this.isDefault, "默认标记");
	}
}
