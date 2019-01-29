package com.yjf.esupplier.ws.enums;

import java.util.ArrayList;
import java.util.List;

public enum PDFTypeCodeEnum {
	
	CONTRACT("contract","合同"),
	
	RECEIPT("receipt","投资凭证"),
	
	LETTER("letter","担保函");
	
	
	
	private final String	typeCode;
	private final String	typeName;
	
	private PDFTypeCodeEnum(String typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public String getTypeName() {
		return typeName;
	}
	
	
	/**
	 * 通过枚举<code>typeCode</code>获得枚举
	 * 
	 * @param typeCode
	 * @return PDFTypeCodeEnum
	 */
	public static PDFTypeCodeEnum getByTypeCode(String typeCode) {
		for (PDFTypeCodeEnum _enum : values()) {
			if (_enum.getTypeCode().equalsIgnoreCase(typeCode)) {
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
	public static List<PDFTypeCodeEnum> getAllEnum() {
		List<PDFTypeCodeEnum> list = new ArrayList<PDFTypeCodeEnum>();
		for (PDFTypeCodeEnum _enum : values()) {
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
		for (PDFTypeCodeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return typeCode;
	}

	
}
