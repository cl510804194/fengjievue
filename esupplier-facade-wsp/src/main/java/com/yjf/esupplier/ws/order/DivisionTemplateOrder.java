package com.yjf.esupplier.ws.order;

import java.io.Serializable;
import java.util.Date;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

/**
 * 
 * 
 * @Filename DivisionTemplate.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author yhl
 * 
 * @Email yhailong@yiji.com
 * 
 * @History <li>Author: yhl</li> <li>Date: 2013-6-17</li> <li>Version: 1.0</li>
 * <li>Content: create</li> 分润模版表(division_template)实体类
 */
public class DivisionTemplateOrder extends QueryPageBase implements Serializable, Order {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long divisionTemplateId;
	
	private String templateName;
	
	private String divisionPhase;
	
	private String divisionWay;
	
	private String templateStatus;
	
	private Date createDate;
	
	private Date modifyDate;
	
	private String templateNote;
	/** 角色 */
	int[] roleIds;
	/** 比率 */
	double[] percentages;
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public int[] getRoleIds() {
		return this.roleIds;
	}
	
	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}
	
	public double[] getPercentages() {
		return this.percentages;
	}
	
	public void setPercentages(double[] percentages) {
		this.percentages = percentages;
	}
	
	public long getDivisionTemplateId() {
		return this.divisionTemplateId;
	}
	
	public void setDivisionTemplateId(long divisionTemplateId) {
		this.divisionTemplateId = divisionTemplateId;
	}
	
	public String getTemplateName() {
		return this.templateName;
	}
	
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	public String getDivisionPhase() {
		return this.divisionPhase;
	}
	
	public void setDivisionPhase(String divisionPhase) {
		this.divisionPhase = divisionPhase;
	}
	
	public String getDivisionWay() {
		return this.divisionWay;
	}
	
	public void setDivisionWay(String divisionWay) {
		this.divisionWay = divisionWay;
	}
	
	public String getTemplateStatus() {
		return this.templateStatus;
	}
	
	public void setTemplateStatus(String templateStatus) {
		this.templateStatus = templateStatus;
	}
	
	public String getTemplateNote() {
		return this.templateNote;
	}
	
	public void setTemplateNote(String templateNote) {
		this.templateNote = templateNote;
	}
	
	@Override
	public void check() {
	}
	
	@Override
	public String getGid() {
		return null;
	}
	
	@Override
	public void setGid(String gid) {
	}
}
