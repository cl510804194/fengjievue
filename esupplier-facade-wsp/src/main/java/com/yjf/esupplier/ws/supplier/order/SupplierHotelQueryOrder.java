package com.yjf.esupplier.ws.supplier.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.MerchantStateEnum;
import com.yjf.esupplier.ws.enums.MerchantTypeEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

import java.util.Date;

public class SupplierHotelQueryOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 7138922679848338462L;
	/**
	 * 酒店名称
	 */
	String searchName;
	/**
	 * 景区ID
	 */
	private String scenicId;
	/**
	 * 酒店分类
	 */
	private MerchantTypeEnum merchantTypeEnum;
	/**
	 * 酒店状态
	 */
	private MerchantStateEnum merchantStateEnum;
	/*商户等级(一级 二级。。)*/
	private String shopGrade;

	//排序
	/*得分排序 */
	private String scoreSort;
	/*销量排序 */
	private String amountSort;
	/*距离排序 */
	private String distanceSort;
	/*是否支持酒店预订 */
	private BooleanEnum hotels = BooleanEnum.YES;
	/*用户经纬度*/
	/*经度*/
	private String longitude;
	/*维度*/
	private String latitude;

	/*登录用户ID*/
	private long userId;

	/** 是否有推荐房 */
	private BooleanEnum recommendRoom;

	/** 是否有特价房 */
	private BooleanEnum specialRoom;

	/** 是否有长租房 */
	private BooleanEnum longRentRoom;

	/** 凌晨房 */
	private BooleanEnum morningRoom;

	/** 是否推荐商户 */
	private BooleanEnum recommend;
	
	private Money beginPrice;
	
	private Money endPrice;
	
	/**
	 * 最低价格排序
	 */
	private String lowestPriceSort;



	public String getLowestPriceSort() {
		return lowestPriceSort;
	}

	public void setLowestPriceSort(String lowestPriceSort) {
		this.lowestPriceSort = lowestPriceSort;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getScenicId() {
		return scenicId;
	}

	public void setScenicId(String scenicId) {
		this.scenicId = scenicId;
	}

	public MerchantTypeEnum getMerchantTypeEnum() {
		return merchantTypeEnum;
	}

	public void setMerchantTypeEnum(MerchantTypeEnum merchantTypeEnum) {
		this.merchantTypeEnum = merchantTypeEnum;
	}

	public MerchantStateEnum getMerchantStateEnum() {
		return merchantStateEnum;
	}

	public void setMerchantStateEnum(MerchantStateEnum merchantStateEnum) {
		this.merchantStateEnum = merchantStateEnum;
	}

	public String getShopGrade() {
		return shopGrade;
	}

	public void setShopGrade(String shopGrade) {
		this.shopGrade = shopGrade;
	}

	public String getScoreSort() {
		return scoreSort;
	}

	public void setScoreSort(String scoreSort) {
		this.scoreSort = scoreSort;
	}

	public String getAmountSort() {
		return amountSort;
	}

	public void setAmountSort(String amountSort) {
		this.amountSort = amountSort;
	}

	public String getDistanceSort() {
		return distanceSort;
	}

	public void setDistanceSort(String distanceSort) {
		this.distanceSort = distanceSort;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public BooleanEnum getHotels() {
		return hotels;
	}

	public void setHotels(BooleanEnum hotels) {
		this.hotels = hotels;
	}

	public BooleanEnum getSpecialRoom() {
		return specialRoom;
	}

	public void setSpecialRoom(BooleanEnum specialRoom) {
		this.specialRoom = specialRoom;
	}

	public BooleanEnum getLongRentRoom() {
		return longRentRoom;
	}

	public void setLongRentRoom(BooleanEnum longRentRoom) {
		this.longRentRoom = longRentRoom;
	}

	public BooleanEnum getMorningRoom() {
		return morningRoom;
	}

	public void setMorningRoom(BooleanEnum morningRoom) {
		this.morningRoom = morningRoom;
	}

	public BooleanEnum getRecommendRoom() {
		return recommendRoom;
	}

	public void setRecommendRoom(BooleanEnum recommendRoom) {
		this.recommendRoom = recommendRoom;
	}

	public BooleanEnum getRecommend() {
		return recommend;
	}

	public void setRecommend(BooleanEnum recommend) {
		this.recommend = recommend;
	}

	public Money getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(Money beginPrice) {
		this.beginPrice = beginPrice;
	}

	public Money getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Money endPrice) {
		this.endPrice = endPrice;
	}
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("SupplierHotelQueryOrder{");
		sb.append("searchName='").append(searchName).append('\'');
		sb.append(", scenicId='").append(scenicId).append('\'');
		sb.append(", merchantTypeEnum='").append(merchantTypeEnum).append('\'');
		sb.append(", shopGrade='").append(shopGrade).append('\'');
		sb.append(", scoreSort='").append(scoreSort).append('\'');
		sb.append(", amountSort='").append(amountSort).append('\'');
		sb.append(", distanceSort='").append(distanceSort).append('\'');
		sb.append(", hotels=").append(hotels);
		sb.append(", longitude='").append(longitude).append('\'');
		sb.append(", latitude='").append(latitude).append('\'');
		sb.append(", userId=").append(userId);
		sb.append(", recommendRoom=").append(recommendRoom);
		sb.append(", specialRoom=").append(specialRoom);
		sb.append(", longRentRoom=").append(longRentRoom);
		sb.append(", morningRoom=").append(morningRoom);
		sb.append(", recommend=").append(recommend);
		sb.append(", beginPrice=").append(beginPrice);
		sb.append(", endPrice=").append(endPrice);
		sb.append(", lowestPriceSort=").append(lowestPriceSort);
		sb.append('}');
		return sb.toString();
	}
}
