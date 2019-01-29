/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Filename SmsBizType.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-9</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public enum PDFTypeEnum {
	
	CONTRACT_MAIN("contract","guarantee_contract.xsl","主干-担保合同","投资权益回购履约担保合同.pdf"),
	
	LETTER_MAIN("letter","guarantee_letter.xsl", "主干-担保函","担保函.pdf"),
	
    CONTRACT_E8("contract_e8","guarantee_contract_e8.xsl","易八-担保合同","借款与服务合同.pdf"),
	
	LETTER_E8("letter_e8","commitment_letter_e8.xsl", "易八-承诺函","承诺函.pdf"),
	
    CONTRACT_BHD("contract_bhd","guarantee_contract_bhd.xsl","百合贷-担保合同","投融资及担保合同.pdf"),
    
    CONTRACT_EYD("contract_eyd","guarantee_contract_eyd.xsl","e元贷-个人借款协议","个人借款协议.pdf"),
    
    CONTRACT_EYD2("contract_eyd2","guarantee_contract_eyd2.xsl","个人借款及担保协议（e收贷）","个人借款及担保协议（e收贷）.pdf"),
	
	LETTER_BHD("letter_bhd","commitment_letter_bhd.xsl", "百合贷-承诺函","承诺函.pdf");

	
	private  String	code;
	private final String	xslfileName;
	private final String		note;
	private final String		pdfFileName;
	
	private PDFTypeEnum(String code, String xslfileName, String note,String pdfFileName) {
		this.code = code;
		this.xslfileName = xslfileName;
		this.note = note;
		this.pdfFileName = pdfFileName;
	}
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getXslfileName() {
		return xslfileName;
	}


	public String getPdfFileName() {
		return pdfFileName;
	}


	public String getNote() {
		return note;
	}


	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return LogResultEnum
	 */
	public static PDFTypeEnum getByCode(String code) {
		for (PDFTypeEnum _enum : values()) {
			if (_enum.getCode().equalsIgnoreCase(code)) {
				return _enum;
			}
		}
		return null;
	}
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LogResultEnum>
	 */
	public List<PDFTypeEnum> getAllEnum() {
		List<PDFTypeEnum> list = new ArrayList<PDFTypeEnum>();
		for (PDFTypeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (PDFTypeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
}
