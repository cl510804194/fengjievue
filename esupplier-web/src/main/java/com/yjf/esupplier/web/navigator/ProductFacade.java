/**
 * 
 */
package com.yjf.esupplier.web.navigator;

/**
 * product facade
 * @author Ken Liu Kunyun
 */

public class ProductFacade {
	private String ptCode;		//分类编码
	private String name;		//立面名称
	private String options;		//可选项，多个选项之间用分号分隔
	private String defineId;		//立面定义ID
	private String value;		//取值
	
	public ProductFacade(String name, String defineId, String value){
		this.name=name;
		this.defineId=defineId;
		this.value=value;
	}
	
	public ProductFacade(){
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
	
	
}
