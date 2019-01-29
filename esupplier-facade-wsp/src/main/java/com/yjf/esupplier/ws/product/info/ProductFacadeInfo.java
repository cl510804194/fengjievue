package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;

public class ProductFacadeInfo implements Serializable {
	private static final long serialVersionUID = -5882796825248068600L;
	private String ptCode; //分类编码
	private String name; //立面名称
	private String options; //可选项，多个选项之间用分号分隔
	private String defineId; //立面定义ID
	private String value; //取值
	
	public ProductFacadeInfo(String name, String defineId, String value) {
		this.name = name;
		this.defineId = defineId;
		this.value = value;
	}
	
	public ProductFacadeInfo() {
	}
	
	public String getPtCode() {
		return ptCode;
	}
	
	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOptions() {
		return options;
	}
	
	public void setOptions(String options) {
		this.options = options;
	}
	
	public String getDefineId() {
		return defineId;
	}
	
	public void setDefineId(String defineId) {
		this.defineId = defineId;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductFacadeInfo [ptCode=");
		builder.append(ptCode);
		builder.append(", name=");
		builder.append(name);
		builder.append(", options=");
		builder.append(options);
		builder.append(", defineId=");
		builder.append(defineId);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
}
