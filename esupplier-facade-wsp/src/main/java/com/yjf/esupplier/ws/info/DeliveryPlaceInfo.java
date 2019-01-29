package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

public class DeliveryPlaceInfo implements Serializable {
	private static final long serialVersionUID = 7808207248673930957L;
	private Integer placeId;
	private String placeName;
	private String placeDesc;
	private String isUser;
	private Long createMan;
	private Date createTime;
	private Long belongTo;
	
	public Integer getPlaceId() {
		return placeId;
	}
	
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	public String getPlaceDesc() {
		return placeDesc;
	}
	
	public void setPlaceDesc(String placeDesc) {
		this.placeDesc = placeDesc;
	}
	
	public String getIsUser() {
		return isUser;
	}
	
	public void setIsUser(String isUser) {
		this.isUser = isUser;
	}
	
	public Long getCreateMan() {
		return createMan;
	}
	
	public void setCreateMan(Long createMan) {
		this.createMan = createMan;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Long getBelongTo() {
		return belongTo;
	}
	
	public void setBelongTo(Long belongTo) {
		this.belongTo = belongTo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeliveryPlaceInfo [placeId=");
		builder.append(placeId);
		builder.append(", placeName=");
		builder.append(placeName);
		builder.append(", placeDesc=");
		builder.append(placeDesc);
		builder.append(", isUser=");
		builder.append(isUser);
		builder.append(", createMan=");
		builder.append(createMan);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", belongTo=");
		builder.append(belongTo);
		builder.append("]");
		return builder.toString();
	}
	
}
