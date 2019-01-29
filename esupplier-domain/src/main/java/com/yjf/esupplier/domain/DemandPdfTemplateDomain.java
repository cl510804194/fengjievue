package com.yjf.esupplier.domain;

import org.springframework.util.Assert;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.enums.PDFTypeCodeEnum;

public class DemandPdfTemplateDomain  implements Domain{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 594846116577899823L;

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



	@Override
	public void examSelf() throws Exception {
		
		Assert.isTrue(demandId > 0,"demandId不能为空");
		Assert.isTrue(pdfTemplateId > 0,"pdfTemplateId 模板ID不能为空");
		Assert.isTrue(typeCode!=null, "typeCode 模板类别不能为空");
		
	}

}
