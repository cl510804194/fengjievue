/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.domain.exception;

import com.yjf.common.lang.exception.ApplicationNestException;
import com.yjf.esupplier.domain.enums.YrdDomainResultEnum;

/**
 * 
 * @Filename EstateDomainException.java
 * 
 * @Description 领域模型异常
 * 
 * @Version 1.0
 * 
 * @Author peigen
 * 
 * @Email peigen@yiji.com
 * 
 * @History <li>Author: peigen</li> <li>Date: 2013-2-3</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class YrdDomainException extends ApplicationNestException {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -2527668261623906864L;
	
	private YrdDomainResultEnum domainResult;
	
	private String errorMsg;
	
	/**
	 * 构建一个<code>EstateDomainException.java</code>
	 */
	public YrdDomainException() {
		super();
	}
	
	/**
	 * 构建一个<code>EstateDomainException.java</code>
	 * @param domainResult
	 * @param errorMsg
	 */
	public YrdDomainException(YrdDomainResultEnum domainResult, String errorMsg) {
		super(errorMsg);
		this.domainResult = domainResult;
		this.errorMsg = errorMsg;
	}
	
	/**
	 * 构建一个<code>EstateDomainException.java</code>
	 * @param message
	 */
	public YrdDomainException(String message) {
		super(message);
	}
	
	/**
	 * 构建一个<code>EstateDomainException.java</code>
	 * @param cause
	 */
	public YrdDomainException(Throwable cause) {
		super(cause);
	}
	
	public YrdDomainResultEnum getDomainResult() {
		return domainResult;
	}
	
	public void setDomainResult(YrdDomainResultEnum domainResult) {
		this.domainResult = domainResult;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstateDomainException [domainResult=");
		builder.append(domainResult);
		builder.append(", errorMsg=");
		builder.append(errorMsg);
		builder.append("]");
		return builder.toString();
	}
	
}
