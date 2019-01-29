/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.domain.exception;

import com.yjf.esupplier.domain.enums.EsupplieDomainResultEnum;
import com.yjf.esupplier.domain.enums.YrdDomainResultEnum;

/**
 * 
 * @Filename ExceptionFactory.java
 * 
 * @Description
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
public class ExceptionDomainFactory {
	
	public static EsupplierDomainException newDomainException(EsupplieDomainResultEnum resultCode,
																	String errorMsg) {
		return new EsupplierDomainException(resultCode, errorMsg);
	}
	
	public static YrdDomainException newEstateDomainException(YrdDomainResultEnum resultCode,
																	String errorMsg) {
		return new YrdDomainException(resultCode, errorMsg);
	}
}
