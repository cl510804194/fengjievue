package com.yjf.esupplier.ws.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.enums.PDFTypeCodeEnum;
import com.yjf.esupplier.ws.enums.StateEnum;

public class PdfTemplateInfo  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5011737742227034172L;
	

	private long id;

	private String pdfName;
	
	private PDFTypeCodeEnum typeCode;

	private String xslContent;

	private String name;

	private Date rawAddTime;

	private Date rawUpdateTime;
	
	private BooleanEnum isDefault; 

	private StateEnum state;

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

	public PDFTypeCodeEnum getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(PDFTypeCodeEnum typeCode) {
		this.typeCode = typeCode;
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

	 
	public BooleanEnum getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(BooleanEnum isDefault) {
		this.isDefault = isDefault;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PdfTemplateInfo [id=");
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

	
	
	

}
