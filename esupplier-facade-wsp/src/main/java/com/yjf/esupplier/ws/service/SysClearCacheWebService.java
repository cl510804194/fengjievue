package com.yjf.esupplier.ws.service;

import javax.jws.WebService;

/**
 * 参数webservice服务 更新集群部署的缓存
 * Created by wqh on 2014/5/22.
 */
@WebService
public interface SysClearCacheWebService {
    public void clearCache();
}
