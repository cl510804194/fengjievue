package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

public class ScenicInfo  implements Serializable {
	
	private static final long serialVersionUID = 4279700524467612037L;


	private long id;
    /*关联机构ID*/
	private String userBaseId;
	/*编码*/
	private String code;
	/*简称*/
	private String shortName;
	/*全称*/
	private String name;
	/*省*/
	private String province;
	/*县*/
	private String county;
	/*市*/
	private String city;
	/*地址*/
	private String address;
	/*电话*/
	private String phone;
	/*联系人*/
	private String conPerson;
	/*联系人电话*/
	private String conPersonPhone;
	/*景区介绍*/
	private String detail;
	/*经度*/
	private String lng;
	/*维度*/
	private String lat;

	/*景区简介 无用*/
	private String note;
	/*景区开门时间*/
	private String openTime;
	/*景区关门时间*/
	private String closeTime;

	private String imagePath1;

	private String imagePath2;

	private String imagePath3;

	private String imagePath4;


	/*状态 无用*/
	private String status;
	/*入驻日期*/
	private String inTime;
	/*新增日期*/
	private Date rawAddTime;
	/*修改日期*/
	private Date rawUpdateTime;

	private String				userName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getConPerson() {
		return conPerson;
	}

	public void setConPerson(String conPerson) {
		this.conPerson = conPerson;
	}

	public String getConPersonPhone() {
		return conPersonPhone;
	}

	public void setConPersonPhone(String conPersonPhone) {
		this.conPersonPhone = conPersonPhone;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getImagePath1() {
		return imagePath1;
	}

	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}

	public String getImagePath2() {
		return imagePath2;
	}

	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}

	public String getImagePath3() {
		return imagePath3;
	}

	public void setImagePath3(String imagePath3) {
		this.imagePath3 = imagePath3;
	}

	public String getImagePath4() {
		return imagePath4;
	}

	public void setImagePath4(String imagePath4) {
		this.imagePath4 = imagePath4;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ScenicInfo{");
		sb.append("id=").append(id);
		sb.append(", userBaseId='").append(userBaseId).append('\'');
		sb.append(", code='").append(code).append('\'');
		sb.append(", shortName='").append(shortName).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", province='").append(province).append('\'');
		sb.append(", county='").append(county).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append(", address='").append(address).append('\'');
		sb.append(", phone='").append(phone).append('\'');
		sb.append(", conPerson='").append(conPerson).append('\'');
		sb.append(", conPersonPhone='").append(conPersonPhone).append('\'');
		sb.append(", detail='").append(detail).append('\'');
		sb.append(", lng='").append(lng).append('\'');
		sb.append(", lat='").append(lat).append('\'');
		sb.append(", note='").append(note).append('\'');
		sb.append(", openTime='").append(openTime).append('\'');
		sb.append(", closeTime='").append(closeTime).append('\'');
		sb.append(", imagePath1='").append(imagePath1).append('\'');
		sb.append(", imagePath2='").append(imagePath2).append('\'');
		sb.append(", imagePath3='").append(imagePath3).append('\'');
		sb.append(", imagePath4='").append(imagePath4).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append(", inTime='").append(inTime).append('\'');
		sb.append(", rawAddTime=").append(rawAddTime);
		sb.append(", rawUpdateTime=").append(rawUpdateTime);
		sb.append(", userName=").append(userName);
		sb.append('}');
		return sb.toString();
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
