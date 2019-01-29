package com.yjf.esupplier.ws.order;

import java.util.Date;

import org.springframework.util.Assert;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.enums.PDFTypeCodeEnum;

public class PdfTemplateOrder implements Order{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1261360351250311286L;
	
	
	private long id;

	//生成PDF后的文件名
	private String pdfName;
	//模板类别
	private String typeCode;

	private String xslContent;
	//模板名
	private String name;

	private Date rawAddTime;

	private Date rawUpdateTime;
	
	private String isDefault;

	private String state;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	public String getXslContent() {
		return xslContent;
	}

	public void setXslContent(String xslContent) {
		this.xslContent = xslContent;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PdfTemplateOrder [id=");
		builder.append(id);
		builder.append(", pdfName=");
		builder.append(pdfName);
		builder.append(", typeCode=");
		builder.append(typeCode);
		builder.append(", xslContent=");
		builder.append(xslContent);
		builder.append(", name=");
		builder.append(name);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", isDefault=");
		builder.append(isDefault);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void check() {
		Assert.hasText(xslContent, "xsl模板内容不能为空");
		Assert.hasText(pdfName, "pdf文件名不能为空");
		Assert.hasText(typeCode, "pdf类型不能为空");
	}

	@Override
	public String getGid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGid(String gid) {
		// TODO Auto-generated method stub
		
	}

}
