package com.yjf.esupplier.ws.bill.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.common.enums.BaseDataCommonStatusEnum;

/**
 * 物流基本信息
 * 
 * 
 * @author qch
 * 
 */
public class LogisticInfo implements Serializable {
	
	private static final long serialVersionUID = -8948499051548465054L;
	
	private long id;
	
	/**
	 * 物流公司名称
	 */
	private String name;
	/**
	 * 官网地址
	 */
	private String officialSite;
	/**
	 * 单号查询地址
	 */
	private String querySite;
	/**
	 * 公司地址
	 */
	private String address;
	/**
	 * 公司邮编
	 */
	private String postCode;
	/**
	 * 公司联系电话
	 */
	private String phones;
	/**
	 * 公司邮箱
	 */
	private String email;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * create_man
	 */
	private long createMan;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 状态
	 */
	private BaseDataCommonStatusEnum status;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOfficialSite() {
		return this.officialSite;
	}
	
	public void setOfficialSite(String officialSite) {
		this.officialSite = officialSite;
	}
	
	public String getQuerySite() {
		return this.querySite;
	}
	
	public void setQuerySite(String querySite) {
		this.querySite = querySite;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostCode() {
		return this.postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getPhones() {
		return this.phones;
	}
	
	public void setPhones(String phones) {
		this.phones = phones;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLinkMan() {
		return this.linkMan;
	}
	
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	
	public long getCreateMan() {
		return this.createMan;
	}
	
	public void setCreateMan(long createMan) {
		this.createMan = createMan;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public BaseDataCommonStatusEnum getStatus() {
		return this.status;
	}
	
	public void setStatus(BaseDataCommonStatusEnum status) {
		this.status = status;
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
		builder.append("LogisticInfo [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", officialSite=");
		builder.append(officialSite);
		builder.append(", querySite=");
		builder.append(querySite);
		builder.append(", address=");
		builder.append(address);
		builder.append(", postCode=");
		builder.append(postCode);
		builder.append(", phones=");
		builder.append(phones);
		builder.append(", email=");
		builder.append(email);
		builder.append(", linkMan=");
		builder.append(linkMan);
		builder.append(", createMan=");
		builder.append(createMan);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append("]");
		return builder.toString();
	}
	
}
