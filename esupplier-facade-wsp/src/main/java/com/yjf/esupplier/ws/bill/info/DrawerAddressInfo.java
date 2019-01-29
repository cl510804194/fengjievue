package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;

public class DrawerAddressInfo implements Serializable {
	
	private static final long serialVersionUID = -3276019023087880943L;
	/** 主键 */
	private String id;
	/** 会员ID */
	private long userId;
	
	private String province;
	/** 城市 */
	private String city;
	/** 地址编码 */
	private String areaCode;
	/** 详细地址 */
	private String detailAddress;
	/** 收货人姓名 */
	private String drawerName;
	/** 收取人联系电话(固定电话) */
	private String drawerNumber;
	/** 收取人联系电话(移动电话) */
	private String mobileNumber;
	/** 邮编 */
	private String zipCode;
	/** 默认地址 */
	
	private BooleanEnum isDefault = BooleanEnum.NO;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public BooleanEnum getIsDefault() {
		return this.isDefault;
	}
	
	public void setIsDefault(BooleanEnum isDefault) {
		this.isDefault = isDefault;
	}
	
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
	
	public String getProvince() {
		return this.province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
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
	
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrawerAddressInfo [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", areaCode=");
		builder.append(areaCode);
		builder.append(", detailAddress=");
		builder.append(detailAddress);
		builder.append(", drawerName=");
		builder.append(drawerName);
		builder.append(", drawerNumber=");
		builder.append(drawerNumber);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", defaultAddress=");
		builder.append(isDefault);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
}
