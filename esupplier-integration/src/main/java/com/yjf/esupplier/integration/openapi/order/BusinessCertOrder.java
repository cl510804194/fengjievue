/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi.order;

import java.math.BigDecimal;

import org.springframework.util.Assert;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 
 * @Filename BusinessCertOrder.java
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
public class BusinessCertOrder extends ValidateOrderBase implements Order {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4450569072786893961L;
	
	/** 城市名称 */
	private String cityname;
	
	/** 联系地址 */
	private String comAddress;
	
	/** 注册资金 */
	private BigDecimal comAmount;
	
	/** 营业期限 正常：20120911, 长期为0 */
	private Integer comCycle;
	
	/** 企业名称 **/
	private String comName;
	
	/** 营业范围 **/
	private String comScope;
	
	/** 联系人身份证号 **/
	private String conCardid;
	
	/** 传真号 */
	private String conFax;
	
	/** 手机 */
	private String conMobile;
	
	private String conName;
	
	/** 公司联系电话 */
	private String conPhone;
	
	/** 邮编 */
	private Integer conZip;
	
	/** 驳回原因 */
	private String errormsg;
	
	/** 所属行业 */
	private String industry;
	
	/** 营业执照副本 */
	private String licence;
	
	/** 营业执照副本加盖公章 */
	private String licencecopy;
	
	/** 营业执照号码 */
	private String licencenum;
	
	/** 税务登记号 **/
	private String taxAuthority;
	
	/** 真实姓名 */
	private String nickname;
	
	/** 注册机构代码 */
	private String organizationcode;
	
	/** 省份名称 */
	private String provname;
	
	/** 职位 */
	private String strPosition;
	
	/** 控股人姓名 */
	private String holdingName;//暂时用做法人
	
	/** 控股人身份证号 */
	private String holdingCardid;
	
	/**
	 * 控股人身份类型 1.一代身份证 2.二代身份证 3.临时身份证 4.回乡证 5.台胞证 6.护照 7.港澳身份证 8.台湾身份证 9.营业执照
	 * 10.其它
	 */
	private String holdingCardType;
	
	/** 控股人身份到期时间 常规：20120911, 长期为0 */
	private Integer holdingCardOff;
	
	/** 控股人身份证正面 */
	private String holdingCardPic;
	
	/** 控股人身份证背面 */
	private String holdingCardPic1;
	
	/** 法人身份证正面 */
	private String legalPersonCardPic;
	
	/** 法人身份证背面 */
	private String legalPersonCardPic1;
	
	/**
	 * 法人身份类型 1.一代身份证 2.二代身份证 3.临时身份证 4.回乡证 5.台胞证 6.护照 7.港澳身份证 8.台湾身份证 9.营业执照
	 * 10.其它
	 */
	private String legalPersonCardType;
	
	/** 法人身份到期时间 常规：20120911, 长期为0 */
	private Integer legalPersonCardOff;
	
	/** 法人身份证号 */
	private String legalPersonCardid;
	
	/** 经办人姓名 */
	private String agentPersonName;
	
	/** 经办人身份证号 */
	private String agentPersonCardid;
	
	/** 担保函 */
	private String backLetterPic;
	
	/** 是否以经办人作为实名认证 Y:是 N:否 */
	private String isLegalPerAudit;
	
	/**
	 * 经办人身份证类型 1.一代身份证 2.二代身份证 3.临时身份证 4.回乡证 5.台胞证 6.护照 7.港澳身份证 8.台湾身份证 9.营业执照
	 * 10.其它
	 */
	private String agentPersonCardType;
	
	/** 经办人身份证到期时间 常规：20120911, 长期为0 */
	private Integer agentPersonCardOff;
	
	/** 经办人身份正面图片 */
	private String agentPersonCardPic;
	
	/** 经办人身份证背面图片 */
	private String agentPersonCardPic1;
	
	/** 数据来源(1：易极付，2：猪八戒，3：新后台，4：个人版,5：企业版,6:外部引入) **/
	private String source;
	
	/** 联系人姓名 **/
	private String contextName;
	
	/** 联系人电话 **/
	private String contextPhone;
	
	/** 核心用户id */
	private String coreCustomerUserId;
	
	/** 核心用户名 **/
	private String coreCustomerUserName;
	
	/**
	 * 外部商户id 注：目前只有openapi接入外部商户做实名认证，则其他系统不用关注该字段
	 */
	private String externalId;
	private String businessTypeEnum = "NORMAL"; //NORMAL:普通企业// INDIVIDUAL:个体户
	
	@Override
	public void check() {
		Assert.hasText(StringUtil.trim(nickname), "真实姓名不能为空！");
		Assert.hasText(comName, "企业名称不能为空！");
		Assert.notNull(conCardid, "身份证号不能为空！");
		Assert.notNull(licencenum, "营业执照不能为空！");
		Assert.notNull(licence, "营业执照图片不能为空！");
		Assert.notNull(coreCustomerUserId, "核心用户id不能为空！");
		//Assert.notNull("source", "数据来源不能为空！");
		Assert.notNull(isLegalPerAudit, "是否以经办人作为实名认证不能为空");
		
		Assert.notNull(holdingName, "控股人姓名不能为空");
		Assert.notNull(holdingCardid, "控股人身份证号不能为空");
		Assert.notNull(holdingCardType, "控股人身份类型不能为空");
		Assert.notNull(holdingCardOff, "控股人身份到期时间不能为空");
		Assert.notNull(holdingCardPic, "控股人身份证正面不能为空");
		Assert.notNull(holdingCardPic1, "控股人身份证背面不能为空");
		if (StringUtil.equals(isLegalPerAudit, "Y")) {
			Assert.notNull(agentPersonCardType, "经办人身份证类型不能为空！");
		} else {
			Assert.notNull(legalPersonCardType, "法人身份证类型不能为空！");
		}
	}
	
	public String getCityname() {
		return cityname;
	}
	
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	public String getComAddress() {
		return comAddress;
	}
	
	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}
	
	public BigDecimal getComAmount() {
		return comAmount;
	}
	
	public void setComAmount(BigDecimal comAmount) {
		this.comAmount = comAmount;
	}
	
	public Integer getComCycle() {
		return comCycle;
	}
	
	public void setComCycle(Integer comCycle) {
		this.comCycle = comCycle;
	}
	
	public String getComName() {
		return comName;
	}
	
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	public String getComScope() {
		return comScope;
	}
	
	public void setComScope(String comScope) {
		this.comScope = comScope;
	}
	
	public String getConCardid() {
		return conCardid;
	}
	
	public void setConCardid(String conCardid) {
		this.conCardid = conCardid;
	}
	
	public String getConFax() {
		return conFax;
	}
	
	public void setConFax(String conFax) {
		this.conFax = conFax;
	}
	
	public String getConMobile() {
		return conMobile;
	}
	
	public void setConMobile(String conMobile) {
		this.conMobile = conMobile;
	}
	
	public String getConName() {
		return conName;
	}
	
	public void setConName(String conName) {
		this.conName = conName;
	}
	
	public String getConPhone() {
		return conPhone;
	}
	
	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}
	
	public Integer getConZip() {
		return conZip;
	}
	
	public void setConZip(Integer conZip) {
		this.conZip = conZip;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public String getIndustry() {
		return industry;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getLicence() {
		return licence;
	}
	
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	public String getLicencecopy() {
		return licencecopy;
	}
	
	public void setLicencecopy(String licencecopy) {
		this.licencecopy = licencecopy;
	}
	
	public String getLicencenum() {
		return licencenum;
	}
	
	public void setLicencenum(String licencenum) {
		this.licencenum = licencenum;
	}
	
	public String getTaxAuthority() {
		return taxAuthority;
	}
	
	public void setTaxAuthority(String taxAuthority) {
		this.taxAuthority = taxAuthority;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getOrganizationcode() {
		return organizationcode;
	}
	
	public void setOrganizationcode(String organizationcode) {
		this.organizationcode = organizationcode;
	}
	
	public String getProvname() {
		return provname;
	}
	
	public void setProvname(String provname) {
		this.provname = provname;
	}
	
	public String getStrPosition() {
		return strPosition;
	}
	
	public void setStrPosition(String strPosition) {
		this.strPosition = strPosition;
	}
	
	public String getHoldingName() {
		return holdingName;
	}
	
	public void setHoldingName(String holdingName) {
		this.holdingName = holdingName;
	}
	
	public String getHoldingCardid() {
		return holdingCardid;
	}
	
	public void setHoldingCardid(String holdingCardid) {
		this.holdingCardid = holdingCardid;
	}
	
	public String getHoldingCardType() {
		return holdingCardType;
	}
	
	public void setHoldingCardType(String holdingCardType) {
		this.holdingCardType = holdingCardType;
	}
	
	public Integer getHoldingCardOff() {
		return holdingCardOff;
	}
	
	public void setHoldingCardOff(Integer holdingCardOff) {
		this.holdingCardOff = holdingCardOff;
	}
	
	public String getHoldingCardPic() {
		return holdingCardPic;
	}
	
	public void setHoldingCardPic(String holdingCardPic) {
		this.holdingCardPic = holdingCardPic;
	}
	
	public String getHoldingCardPic1() {
		return holdingCardPic1;
	}
	
	public void setHoldingCardPic1(String holdingCardPic1) {
		this.holdingCardPic1 = holdingCardPic1;
	}
	
	public String getLegalPersonCardPic() {
		return legalPersonCardPic;
	}
	
	public void setLegalPersonCardPic(String legalPersonCardPic) {
		this.legalPersonCardPic = legalPersonCardPic;
	}
	
	public String getLegalPersonCardPic1() {
		return legalPersonCardPic1;
	}
	
	public void setLegalPersonCardPic1(String legalPersonCardPic1) {
		this.legalPersonCardPic1 = legalPersonCardPic1;
	}
	
	public String getLegalPersonCardType() {
		return legalPersonCardType;
	}
	
	public void setLegalPersonCardType(String legalPersonCardType) {
		this.legalPersonCardType = legalPersonCardType;
	}
	
	public Integer getLegalPersonCardOff() {
		return legalPersonCardOff;
	}
	
	public void setLegalPersonCardOff(Integer legalPersonCardOff) {
		this.legalPersonCardOff = legalPersonCardOff;
	}
	
	public String getLegalPersonCardid() {
		return legalPersonCardid;
	}
	
	public void setLegalPersonCardid(String legalPersonCardid) {
		this.legalPersonCardid = legalPersonCardid;
	}
	
	public String getAgentPersonName() {
		return agentPersonName;
	}
	
	public void setAgentPersonName(String agentPersonName) {
		this.agentPersonName = agentPersonName;
	}
	
	public String getAgentPersonCardid() {
		return agentPersonCardid;
	}
	
	public void setAgentPersonCardid(String agentPersonCardid) {
		this.agentPersonCardid = agentPersonCardid;
	}
	
	public String getBackLetterPic() {
		return backLetterPic;
	}
	
	public void setBackLetterPic(String backLetterPic) {
		this.backLetterPic = backLetterPic;
	}
	
	public String getIsLegalPerAudit() {
		return isLegalPerAudit;
	}
	
	public void setIsLegalPerAudit(String isLegalPerAudit) {
		this.isLegalPerAudit = isLegalPerAudit;
	}
	
	public String getAgentPersonCardType() {
		return agentPersonCardType;
	}
	
	public void setAgentPersonCardType(String agentPersonCardType) {
		this.agentPersonCardType = agentPersonCardType;
	}
	
	public Integer getAgentPersonCardOff() {
		return agentPersonCardOff;
	}
	
	public void setAgentPersonCardOff(Integer agentPersonCardOff) {
		this.agentPersonCardOff = agentPersonCardOff;
	}
	
	public String getAgentPersonCardPic() {
		return agentPersonCardPic;
	}
	
	public void setAgentPersonCardPic(String agentPersonCardPic) {
		this.agentPersonCardPic = agentPersonCardPic;
	}
	
	public String getAgentPersonCardPic1() {
		return agentPersonCardPic1;
	}
	
	public void setAgentPersonCardPic1(String agentPersonCardPic1) {
		this.agentPersonCardPic1 = agentPersonCardPic1;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getContextName() {
		return contextName;
	}
	
	public void setContextName(String contextName) {
		this.contextName = contextName;
	}
	
	public String getContextPhone() {
		return contextPhone;
	}
	
	public void setContextPhone(String contextPhone) {
		this.contextPhone = contextPhone;
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
	
	public String getBusinessTypeEnum() {
		return this.businessTypeEnum;
	}
	
	public void setBusinessTypeEnum(String businessTypeEnum) {
		this.businessTypeEnum = businessTypeEnum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessCertOrder [cityname=");
		builder.append(cityname);
		builder.append(", comAddress=");
		builder.append(comAddress);
		builder.append(", comAmount=");
		builder.append(comAmount);
		builder.append(", comCycle=");
		builder.append(comCycle);
		builder.append(", comName=");
		builder.append(comName);
		builder.append(", comScope=");
		builder.append(comScope);
		builder.append(", conCardid=");
		builder.append(conCardid);
		builder.append(", conFax=");
		builder.append(conFax);
		builder.append(", conMobile=");
		builder.append(conMobile);
		builder.append(", conName=");
		builder.append(conName);
		builder.append(", conPhone=");
		builder.append(conPhone);
		builder.append(", conZip=");
		builder.append(conZip);
		builder.append(", errormsg=");
		builder.append(errormsg);
		builder.append(", industry=");
		builder.append(industry);
		builder.append(", licence=");
		builder.append(licence);
		builder.append(", licencecopy=");
		builder.append(licencecopy);
		builder.append(", licencenum=");
		builder.append(licencenum);
		builder.append(", taxAuthority=");
		builder.append(taxAuthority);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", organizationcode=");
		builder.append(organizationcode);
		builder.append(", provname=");
		builder.append(provname);
		builder.append(", strPosition=");
		builder.append(strPosition);
		builder.append(", holdingName=");
		builder.append(holdingName);
		builder.append(", holdingCardid=");
		builder.append(holdingCardid);
		builder.append(", holdingCardType=");
		builder.append(holdingCardType);
		builder.append(", holdingCardOff=");
		builder.append(holdingCardOff);
		builder.append(", holdingCardPic=");
		builder.append(holdingCardPic);
		builder.append(", holdingCardPic1=");
		builder.append(holdingCardPic1);
		builder.append(", legalPersonCardPic=");
		builder.append(legalPersonCardPic);
		builder.append(", legalPersonCardPic1=");
		builder.append(legalPersonCardPic1);
		builder.append(", legalPersonCardType=");
		builder.append(legalPersonCardType);
		builder.append(", legalPersonCardOff=");
		builder.append(legalPersonCardOff);
		builder.append(", legalPersonCardid=");
		builder.append(legalPersonCardid);
		builder.append(", agentPersonName=");
		builder.append(agentPersonName);
		builder.append(", agentPersonCardid=");
		builder.append(agentPersonCardid);
		builder.append(", backLetterPic=");
		builder.append(backLetterPic);
		builder.append(", isLegalPerAudit=");
		builder.append(isLegalPerAudit);
		builder.append(", agentPersonCardType=");
		builder.append(agentPersonCardType);
		builder.append(", agentPersonCardOff=");
		builder.append(agentPersonCardOff);
		builder.append(", agentPersonCardPic=");
		builder.append(agentPersonCardPic);
		builder.append(", agentPersonCardPic1=");
		builder.append(agentPersonCardPic1);
		builder.append(", source=");
		builder.append(source);
		builder.append(", contextName=");
		builder.append(contextName);
		builder.append(", contextPhone=");
		builder.append(contextPhone);
		builder.append(", coreCustomerUserId=");
		builder.append(coreCustomerUserId);
		builder.append(", coreCustomerUserName=");
		builder.append(coreCustomerUserName);
		builder.append(", externalId=");
		builder.append(externalId);
		builder.append("]");
		return builder.toString();
	}
	
}
