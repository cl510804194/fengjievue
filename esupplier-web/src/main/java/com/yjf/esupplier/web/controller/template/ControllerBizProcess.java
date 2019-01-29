/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * Administrator 上午11:45:15 创建
 */
package com.yjf.esupplier.web.controller.template;

import java.util.Map;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * 
 * @author Administrator
 * 
 */
public interface ControllerBizProcess {
	EsupplierBaseResult process(Map<String, String> param);
}
