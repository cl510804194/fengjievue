package com.yjf.esupplier.ws.info;

import java.io.Serializable;

import com.yjf.esupplier.ws.enums.PDFTypeCodeEnum;

public class DemandPdfTemplateInfo  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5144608133408330199L;

	private long id;

	private long demandId;

	private PDFTypeCodeEnum typeCode;

	private long pdfTemplateId;
	
	private String pdfFilePath;

	private String pdfRequestPath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDemandId() {
		return demandId;
	}

	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}

	public PDFTypeCodeEnum getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(PDFTypeCodeEnum typeCode) {
		this.typeCode = typeCode;
	}

	public long getPdfTemplateId() {
		return pdfTemplateId;
	}

	public void setPdfTemplateId(long pdfTemplateId) {
		this.pdfTemplateId = pdfTemplateId;
	}

	public String getPdfFilePath() {
		return pdfFilePath;
	}

	public void setPdfFilePath(String pdfFilePath) {
		this.pdfFilePath = pdfFilePath;
	}

	public String getPdfRequestPath() {
		return pdfRequestPath;
	}

	public void setPdfRequestPath(String pdfRequestPath) {
		this.pdfRequestPath = pdfRequestPath;
	}
	
	
	

}
