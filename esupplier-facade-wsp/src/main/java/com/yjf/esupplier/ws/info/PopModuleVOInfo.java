package com.yjf.esupplier.ws.info;

import com.yjf.esupplier.ws.data.PopModuleData;

public class PopModuleVOInfo extends PopModuleData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3295232777610369024L;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{id:\"");
		builder.append(getModuleId());
		builder.append("\", code:\"");
		builder.append(getModuleCode());
		builder.append("\", name:\"");
		builder.append(getModuleName());
		builder.append("\", pId:");
		builder.append(getParentId());
		if(getParentId()==0){
			builder.append(",open:true");
		}
		builder.append("}");
		return builder.toString();
	}

}
