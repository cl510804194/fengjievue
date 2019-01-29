package com.yjf.esupplier.integration.localService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.ws.service.SysClearCacheWebService;

/**
 * Created by wqh on 2014/5/22.
 */
@Service("sysClearCacheServiceClient")
public class SysClearCacheServiceClientImpl
											implements
											com.yjf.esupplier.integration.localService.SysClearCacheServiceClient {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SysClearCacheWebService sysClearCacheWebServiceClientOne;
	@Autowired
	SysClearCacheWebService sysClearCacheWebServiceClientTwo;
	
	@Autowired
	SysClearCacheWebService sysClearCacheWebService;
	
	@Override
	public void clearCache() {
		try {
			//本地清理两次缓存
			sysClearCacheWebService.clearCache();
			sysClearCacheWebServiceClientOne.clearCache();
			sysClearCacheWebServiceClientTwo.clearCache();
		} catch (Exception ce) {
			logger.error("未知异常:e={}", ce.getMessage(), ce);
			
		}
	}
}
