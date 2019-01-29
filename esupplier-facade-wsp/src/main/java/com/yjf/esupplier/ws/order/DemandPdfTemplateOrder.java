package com.yjf.esupplier.ws.order;

import org.springframework.util.Assert;

public class DemandPdfTemplateOrder  extends ValidateOrderBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2968606778620302644L;

	private long id;

	private long demandId;

	private String typeCode;

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

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
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
	public void check() {
		validateHasZore(demandId, "demandId不能为空");
		Assert.hasText(typeCode, "模板类别不能为空");
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

	@Override
	public boolean isCheckGid() {
		// TODO Auto-generated method stub
		return false;
	}

}
