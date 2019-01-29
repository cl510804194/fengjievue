/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * @Filename PersonalCertOrder.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-7</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class PersonalCertOrder extends ValidateOrderBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 5202554061677220301L;
	
	/** 真实姓名 **/
	private String nickname;
	
	/***
	 * 身份证类型 1.一代身份证 2.二代身份证 3.临时身份证 4.回乡证 5.台胞证 6.护照 7.港澳身份证 8.台湾身份证 9.营业执照
	 * 10.其它
	 **/
	private String cardtype;
	
	/*** 身份证号 **/
	private String cardid;
	
	/** 身份证正面 **/
	private String cardpic;
	
	/** 身份证背面 **/
	private String cardpic1;
	
	/*** 电话 **/
	private String phone;
	
	/*** 手机 **/
	private String mobile;
	
	/*** 联系地址 **/
	private String address;
	
	/** 身份证到期时间 正常：20120911, 长期为0 **/
	private Integer cardoff;
	
	/** 数据来源(1：易极付，2：猪八戒，3：新后台，4：个人版,5：企业版,6:外部引入) **/
	private String source;
	
	/** 核心用户id */
	private String coreCustomerUserId;
	
	/** 核心用户名 **/
	private String coreCustomerUserName;
	
	/**
	 * 外部商户id 注：目前只有openapi接入外部商户做实名认证，则其他不用关注该字段
	 */
	private String externalId;
	/**
	 * 提前认证升级标识
	 */
	private boolean preUpdate;
	
	@Override
	public void check() {
		this.validateHasText(nickname, "真实姓名");
		this.validateHasText(cardtype, "身份证类型 ");
		this.validateHasText(cardid, "证件号");
		this.validateHasText(cardpic, "身份证件正面");
		this.validateHasText(cardpic1, "身份证件背面");
		//this.validateHasText(source, "数据来源");
		this.validateHasText(coreCustomerUserId, "核心用户id");
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getCardtype() {
		return cardtype;
	}
	
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	public String getCardid() {
		return cardid;
	}
	
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	
	public String getCardpic() {
		return cardpic;
	}
	
	public void setCardpic(String cardpic) {
		this.cardpic = cardpic;
	}
	
	public String getCardpic1() {
		return cardpic1;
	}
	
	public void setCardpic1(String cardpic1) {
		this.cardpic1 = cardpic1;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getCardoff() {
		return cardoff;
	}
	
	public void setCardoff(Integer cardoff) {
		this.cardoff = cardoff;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getCoreCustomerUserId() {
		return coreCustomerUserId;
	}
	
	public void setCoreCustomerUserId(String coreCustomerUserId) {
		this.coreCustomerUserId = coreCustomerUserId;
	}
	
	public String getCoreCustomerUserName() {
		return coreCustomerUserName;
	}
	
	public void setCoreCustomerUserName(String coreCustomerUserName) {
		this.coreCustomerUserName = coreCustomerUserName;
	}
	
	public String getExternalId() {
		return externalId;
	}
	
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	public boolean isPreUpdate() {
		return preUpdate;
	}
	
	public void setPreUpdate(boolean preUpdate) {
		this.preUpdate = preUpdate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonalCertOrder [nickname=");
		builder.append(nickname);
		builder.append(", cardtype=");
		builder.append(cardtype);
		builder.append(", cardid=");
		builder.append(cardid);
		builder.append(", cardpic=");
		builder.append(cardpic);
		builder.append(", cardpic1=");
		builder.append(cardpic1);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", address=");
		builder.append(address);
		builder.append(", cardoff=");
		builder.append(cardoff);
		builder.append(", source=");
		builder.append(source);
		builder.append(", coreCustomerUserId=");
		builder.append(coreCustomerUserId);
		builder.append(", coreCustomerUserName=");
		builder.append(coreCustomerUserName);
		builder.append(", externalId=");
		builder.append(externalId);
		builder.append(", preUpdate=");
		builder.append(preUpdate);
		builder.append("]");
		return builder.toString();
	}
	
}
