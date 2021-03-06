package com.yjf.esupplier.ws.info;

import java.io.Serializable;

public class SpecialProductInfo implements Serializable {
	
	private static final long serialVersionUID = -6848325735807837457L;
	private Long id;
	private Long productId;
	private String name;
	private Double originalPrice;
	private Double newPrice;
	private String type;
	private String smallPicPath;
	private String bigPicPath;
	private String unit;
	private Integer supplierId;
	private Long snumber;
	private String productUnit = ""; //liujunwei 2010-10-23 added
	private Long groupId;
	private String htmlPath;
	private String productStatus;
	private Integer censor;
	
	public String getProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	public Integer getCensor() {
		return censor;
	}
	
	public void setCensor(Integer censor) {
		this.censor = censor;
	}
	
	public String getHtmlPath() {
		return htmlPath;
	}
	
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	
	/**
	 * @return the productUnit
	 */
	public String getProductUnit() {
		return productUnit;
	}
	
	/**
	 * @param productUnit the productUnit to set
	 */
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public Double getNewPrice() {
		return newPrice;
	}
	
	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSmallPicPath() {
		return smallPicPath;
	}
	
	public void setSmallPicPath(String smallPicPath) {
		this.smallPicPath = smallPicPath;
	}
	
	public String getBigPicPath() {
		return bigPicPath;
	}
	
	public void setBigPicPath(String bigPicPath) {
		this.bigPicPath = bigPicPath;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	public Long getSnumber() {
		return snumber;
	}
	
	public void setSnumber(Long snumber) {
		this.snumber = snumber;
	}
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpecialProductInfo [id=");
		builder.append(id);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", originalPrice=");
		builder.append(originalPrice);
		builder.append(", newPrice=");
		builder.append(newPrice);
		builder.append(", type=");
		builder.append(type);
		builder.append(", smallPicPath=");
		builder.append(smallPicPath);
		builder.append(", bigPicPath=");
		builder.append(bigPicPath);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", snumber=");
		builder.append(snumber);
		builder.append(", productUnit=");
		builder.append(productUnit);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", htmlPath=");
		builder.append(htmlPath);
		builder.append(", productStatus=");
		builder.append(productStatus);
		builder.append(", censor=");
		builder.append(censor);
		builder.append("]");
		return builder.toString();
	}
	
}
