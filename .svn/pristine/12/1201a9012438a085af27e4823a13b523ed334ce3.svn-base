package com.yjf.esupplier.ws.bill.order;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import org.springframework.util.Assert;

import com.yjf.common.lang.util.ListUtil;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.bill.enums.TakeWaysEnum;
import com.yjf.esupplier.ws.info.CartItemInfo;
import com.yjf.esupplier.ws.product.enums.SaleTypeEnum;

public class BillSaveOrder extends BillBaseOrder {
	private static final long serialVersionUID = -7176436944745214207L;
	
	/**
	 * 销售模式
	 */
	SaleTypeEnum saleTypeEnum = SaleTypeEnum.O2O;
	/** 付款方式 */
	protected PaymentMethodEnum paymentMethod = PaymentMethodEnum.ONLINE;

	@Override
	public void check() {
		Assert.isTrue(ListUtil.isNotEmpty(list), "购买的商品不能为空");
		if (StringUtil.isEmpty(addressId) && saleTypeEnum == SaleTypeEnum.B2C) {
			validateHasText(drawerName, "收货人");
			validateHasText(city, "城市");
			validateHasText(province, "省份");
			validateHasText(detailAddress, "详细地址");
			validateHasText(zipCode, " 邮政编码");
			validateHasText(mobileNumber, "手机");
		}
		if (saleTypeEnum == SaleTypeEnum.ORDER_MEAL) {
			validateHasZore(receiveMealsSupplierId, "收餐的商户");
			validateNotNull(forecastReceiveMealsDate, "预计收餐时间");
		}
		for (CartItemInfo cartItemInfo : list) {
			validateHasZore(cartItemInfo.getQuantity(), "数量");
			validateHasZore(cartItemInfo.getProductId().longValue(), "产品");
			validateHasZore(cartItemInfo.getSupplierId(), "商户id");
			//validateMoneyGreaterThanZero(cartItemInfo.getPrice(), "价格");
		}
	}
	
	String[] specialExplain;
	/**
	 * 收货人
	 */
	String drawerName;
	/**
	 * 地区
	 */
	String areaInfo;
	/**
	 * 城市
	 */
	String city;
	
	String province;
	/**
	 * 地址编码 不要需要
	 */
	String str;
	/**
	 * 详细地址
	 */
	String detailAddress;
	/**
	 * 邮政编码
	 */
	String zipCode;
	/**
	 * 座机
	 */
	String drawerNumber;
	/**
	 * 手机
	 */
	String mobileNumber;
	/**
	 * 地址id
	 */
	String addressId;
	/**
	 * 邮费，按供应商id，分商品
	 */
	Map<Long, String> postFree;
	/**
	 * 总费用
	 */
	String totalFree;
	/**
	 * 送货方式 自提，或送货上门 客户提货方式
	 */
	TakeWaysEnum takeWays;
	/**
	 * 提货地点id
	 */
	long takeGoodsAddrId;
	/**
	 * 收餐的商户id
	 */
	long receiveMealsSupplierId;
	/**
	 * 收餐的商户id
	 */
	Date forecastReceiveMealsDate = new Date();

	/**
	 * 是否调餐(技师上门）
	 */
	BooleanEnum tuneMeal = BooleanEnum.NO;
	/** 配送员（技师）Id */
	long diliverymanId;
	/** 就餐时间(预订服务时间） */
	Date diningTime;
	
	public SaleTypeEnum getSaleTypeEnum() {
		return this.saleTypeEnum;
	}
	
	public void setSaleTypeEnum(SaleTypeEnum saleTypeEnum) {
		this.saleTypeEnum = saleTypeEnum;
	}
	
	public PaymentMethodEnum getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Override
	public Money getTotalAmount() {
		Money money = Money.zero();
		for (CartItemInfo cartItemInfo : this.list) {
			money.addTo(cartItemInfo.getTotalAmount());
		}
		return money;
	}
	
	public String[] getSpecialExplain() {
		return this.specialExplain;
	}
	
	public void setSpecialExplain(String[] specialExplain) {
		this.specialExplain = specialExplain;
	}
	
	public String getDrawerName() {
		return this.drawerName;
	}
	
	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}
	
	public String getAreaInfo() {
		return this.areaInfo;
	}
	
	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}
	
	public String getStr() {
		return this.str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public String getDetailAddress() {
		return this.detailAddress;
	}
	
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getDrawerNumber() {
		return this.drawerNumber;
	}
	
	public void setDrawerNumber(String drawerNumber) {
		this.drawerNumber = drawerNumber;
	}
	
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getAddressId() {
		return this.addressId;
	}
	
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public Map<Long, String> getPostFree() {
		return this.postFree;
	}
	
	public void setPostFree(Map<Long, String> postFree) {
		this.postFree = postFree;
	}
	
	public String getTotalFree() {
		return this.totalFree;
	}
	
	public void setTotalFree(String totalFree) {
		this.totalFree = totalFree;
	}
	
	public TakeWaysEnum getTakeWays() {
		return this.takeWays;
	}
	
	public void setTakeWays(TakeWaysEnum takeWays) {
		this.takeWays = takeWays;
	}
	
	public long getTakeGoodsAddrId() {
		return this.takeGoodsAddrId;
	}
	
	public void setTakeGoodsAddrId(long takeGoodsAddrId) {
		this.takeGoodsAddrId = takeGoodsAddrId;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Override
	public String getGainMoneyTradesId() {
		return this.gainMoneyTradesId;
	}
	
	@Override
	public void setGainMoneyTradesId(String gainMoneyTradesId) {
		this.gainMoneyTradesId = gainMoneyTradesId;
	}
	
	@Override
	public long getUserPoint() {
		return this.userPoint;
	}
	
	@Override
	public void setUserPoint(long userPoint) {
		this.userPoint = userPoint;
	}
	
	public long getReceiveMealsSupplierId() {
		return this.receiveMealsSupplierId;
	}
	
	public void setReceiveMealsSupplierId(long receiveMealsSupplierId) {
		this.receiveMealsSupplierId = receiveMealsSupplierId;
	}
	
	public Date getForecastReceiveMealsDate() {
		return this.forecastReceiveMealsDate;
	}
	
	public void setForecastReceiveMealsDate(Date forecastReceiveMealsDate) {
		this.forecastReceiveMealsDate = forecastReceiveMealsDate;
	}

	public BooleanEnum getTuneMeal() {
		return tuneMeal;
	}

	public void setTuneMeal(BooleanEnum tuneMeal) {
		this.tuneMeal = tuneMeal;
	}

	public long getDiliverymanId() {
		return diliverymanId;
	}

	public void setDiliverymanId(long diliverymanId) {
		this.diliverymanId = diliverymanId;
	}

	public Date getDiningTime() {
		return diningTime;
	}

	public void setDiningTime(Date diningTime) {
		this.diningTime = diningTime;
	}

	@Override
	public Money getTotalAmountNoPostFee() {
		Money money = Money.zero();
		for (CartItemInfo cartItemInfo : this.list) {
			money.addTo(cartItemInfo.getTotalAmountNoShipment());
		}
		return money;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillSaveOrder [list=");
		builder.append(list);
		builder.append(", saleTypeEnum=");
		builder.append(saleTypeEnum);
		builder.append(", specialExplain=");
		builder.append(Arrays.toString(specialExplain));
		builder.append(", drawerName=");
		builder.append(drawerName);
		builder.append(", areaInfo=");
		builder.append(areaInfo);
		builder.append(", city=");
		builder.append(city);
		builder.append(", province=");
		builder.append(province);
		builder.append(", str=");
		builder.append(str);
		builder.append(", detailAddress=");
		builder.append(detailAddress);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", drawerNumber=");
		builder.append(drawerNumber);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", postFree=");
		builder.append(postFree);
		builder.append(", totalFree=");
		builder.append(totalFree);
		builder.append(", takeWays=");
		builder.append(takeWays);
		builder.append(", takeGoodsAddrId=");
		builder.append(takeGoodsAddrId);
		builder.append(", gainMoneyTradesId=");
		builder.append(gainMoneyTradesId);
		builder.append(", userPoint=");
		builder.append(userPoint);
		builder.append("]");
		return builder.toString();
	}
	
}
