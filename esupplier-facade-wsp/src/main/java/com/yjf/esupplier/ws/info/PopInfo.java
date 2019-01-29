package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

public class PopInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	* ID
	* */
	private long popId;
	/*
	* 信息标题
	* */
	private String title;
	/*
	* 大类
	* */
	private short type;
	/*
	* 状态
	* */
	private short status;
	/*
	* 所属分类
	* */
	private long parentId;
	/*
	* 所属分类名称
	* */
	private String parentName;
	/*
	* 内容
	* */
	private String content;
	/*
	* 添加时间
	* */
	private Date addTime;
	/*
	* 修改时间
	* */
	private Date modifyTime;
	/*
	* 备注
	* */
	private String remark;
	/*
	* 图片链接
	* */
	private String rem1;
	/*
	* 排序号
	* */
	private int sortOrder;
	
	private long hits;
	/*
	* 是否热点
	* */
	private String ishot;
	/*
	* 发布时间
	* */
	private Date publicDate;
	/*
	* 发布状态
	* */
	private String publicStatus;
	
	private String isParent;
	
	/*所属景区userBaseID*/
	private String belongTo;
	
	/*所属景区*/
	private ScenicInfo scenicInfo;
	
	/*所属分类*/
	private PopModuleVOInfo popModuleVOInfo;
	/*点赞数*/
	private long agrees;
	/*收藏数*/
	private long collects;
	
	/*用户是否点赞*/
	private boolean isAgree;
	/*用户是否收藏*/
	private boolean isCollect;
	/*
	* 攻略收藏|点赞时间
	* */
	private Date popUserAddTime;
	
	public long getPopId() {
		return popId;
	}
	
	public void setPopId(long popId) {
		this.popId = popId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setStatus(short status) {
		this.status = status;
	}
	
	public long getParentId() {
		return parentId;
	}
	
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getAddTime() {
		return addTime;
	}
	
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	public Date getModifyTime() {
		return modifyTime;
	}
	
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRem1() {
		return rem1;
	}
	
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	
	public int getSortOrder() {
		return sortOrder;
	}
	
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public long getHits() {
		return hits;
	}
	
	public void setHits(long hits) {
		this.hits = hits;
	}
	
	public String getIshot() {
		return ishot;
	}
	
	public void setIshot(String ishot) {
		this.ishot = ishot;
	}
	
	public Date getPublicDate() {
		return publicDate;
	}
	
	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}
	
	public String getPublicStatus() {
		return publicStatus;
	}
	
	public void setPublicStatus(String publicStatus) {
		this.publicStatus = publicStatus;
	}
	
	public String getIsParent() {
		return this.isParent;
	}
	
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	
	public String getBelongTo() {
		return belongTo;
	}
	
	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}
	
	public short getType() {
		return type;
	}
	
	public void setType(short type) {
		this.type = type;
	}
	
	public short getStatus() {
		return status;
	}
	
	public ScenicInfo getScenicInfo() {
		return scenicInfo;
	}
	
	public void setScenicInfo(ScenicInfo scenicInfo) {
		this.scenicInfo = scenicInfo;
	}
	
	public PopModuleVOInfo getPopModuleVOInfo() {
		return popModuleVOInfo;
	}
	
	public void setPopModuleVOInfo(PopModuleVOInfo popModuleVOInfo) {
		this.popModuleVOInfo = popModuleVOInfo;
	}
	
	public long getAgrees() {
		return agrees;
	}
	
	public void setAgrees(long agrees) {
		this.agrees = agrees;
	}
	
	public long getCollects() {
		return collects;
	}
	
	public void setCollects(long collects) {
		this.collects = collects;
	}
	
	public boolean getIsAgree() {
		return isAgree;
	}
	
	public void setIsAgree(boolean isAgree) {
		this.isAgree = isAgree;
	}
	
	public boolean getIsCollect() {
		return isCollect;
	}
	
	public void setIsCollect(boolean isCollect) {
		this.isCollect = isCollect;
	}

	public Date getPopUserAddTime() {
		return popUserAddTime;
	}

	public void setPopUserAddTime(Date popUserAddTime) {
		this.popUserAddTime = popUserAddTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InstitutionsInfo [popId=");
		builder.append(popId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", type=");
		builder.append(type);
		builder.append(", status=");
		builder.append(status);
		builder.append(",parentId=");
		builder.append(parentId);
		builder.append(", parentName=");
		builder.append(parentName);
		builder.append(", content=");
		builder.append(content);
		builder.append(", publicDate=");
		builder.append(publicDate);
		builder.append(", publicStatus=");
		builder.append(publicStatus);
		builder.append("]");
		return builder.toString();
	}
	
}
