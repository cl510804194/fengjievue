/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.result;

import com.yjf.common.lang.result.ResultBase;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;

/**
 * 
 * @Filename YrdBaseResult.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-3</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class EsupplierBaseResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 5156892170604621621L;
	/** 返回结果码 */
	EsupplierResultEnum microbankResultEnum = EsupplierResultEnum.UN_KNOWN_EXCEPTION;
	
	private String url;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public boolean isExecuted() {
		
		return EsupplierResultEnum.EXECUTE_SUCCESS == microbankResultEnum ? true : false;
	}
	
	public EsupplierResultEnum getCreditsysResultEnum() {
		return microbankResultEnum;
	}
	
	public void setCreditsysResultEnum(EsupplierResultEnum esupplierResultEnum) {
		this.microbankResultEnum = esupplierResultEnum;
		if (this.microbankResultEnum != null) {
			if (StringUtil.isEmpty(this.getMessage())) {
				this.setMessage(this.microbankResultEnum.getMessage());
			}
			
		}
	}
	
	@Override
	public void setSuccess(boolean success) {
		super.setSuccess(success);
		if (success)
			microbankResultEnum = EsupplierResultEnum.EXECUTE_SUCCESS;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YrdBaseResult [estateResultEnum=");
		builder.append(microbankResultEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
