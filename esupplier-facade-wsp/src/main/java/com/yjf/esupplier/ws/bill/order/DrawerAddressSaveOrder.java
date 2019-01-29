package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class DrawerAddressSaveOrder extends ValidateOrderBase {
	//========== properties ==========

	private static final long serialVersionUID = -698761636412418421L;

	@Override
	public void check() {
		validateHasText(city, "城市");
		validateHasText(province, "省份");
		validateHasText(detailAddress, "详细地址");
		validateHasText(drawerName, "收货人");
		validateHasText(mobileNumber, "联系手机");
		//validateHasText(drawerNumber, "收货电话");
	}

	private String id;
	/**
	 * 用户id
	 */
	private long userId;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 地区编码
	 */
	private String areaCode;
	/**
	 * 详细地址
	 */
	private String detailAddress;
	/**
	 * 收货人
	 */
	private String drawerName;
	/**
	 * 收货人电话
	 */
	private String drawerNumber;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 手机
	 */
	private String mobileNumber;
	/**
	 * 是否设置为默认收货地址（Y/N）
	 */
	private String isDefault;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDetailAddress() {
		return this.detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getDrawerName() {
		return this.drawerName;
	}

	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}

	public String getDrawerNumber() {
		return this.drawerNumber;
	}

	public void setDrawerNumber(String drawerNumber) {
		this.drawerNumber = drawerNumber;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrawerAddressSaveOrder [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", city=");
		builder.append(city);
		builder.append(", province=");
		builder.append(province);
		builder.append(", areaCode=");
		builder.append(areaCode);
		builder.append(", detailAddress=");
		builder.append(detailAddress);
		builder.append(", drawerName=");
		builder.append(drawerName);
		builder.append(", drawerNumber=");
		builder.append(drawerNumber);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", isDefault=");
		builder.append(isDefault);
		builder.append("]");
		return builder.toString();
	}

}
