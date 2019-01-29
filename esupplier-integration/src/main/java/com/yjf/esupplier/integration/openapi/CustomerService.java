/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.BusinessCertOrder;
import com.yjf.esupplier.integration.openapi.order.MobileBindOrder;
import com.yjf.esupplier.integration.openapi.order.PersonalCertOrder;
import com.yjf.esupplier.integration.openapi.order.RegisterOrder;
import com.yjf.esupplier.integration.openapi.order.UserQuickCertifyOrder;
import com.yjf.esupplier.integration.openapi.result.CustomerResult;
import com.yjf.esupplier.integration.openapi.result.QueryAccountResult;
import com.yjf.esupplier.integration.openapi.result.RealNameLevelResult;
import com.yjf.esupplier.integration.openapi.result.RealNameStatusResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * 
 * @Filename CustemerService.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2013-3-4</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public interface CustomerService {
	
	/**
	 * 开设资金账户
	 * @param order
	 * @param openApiContext
	 * @return
	 */
	CustomerResult openCapitalAccount(RegisterOrder order, OpenApiContext openApiContext);
	
	/**
	 * 查询用户是否存在
	 * @param userName
	 * @param openApiContext
	 * @return
	 */
	CustomerResult checkUserNameExist(String userName, OpenApiContext openApiContext);
	
	/**
	 * 查询个人账务信息
	 * @param accountId
	 * @param openApiContext
	 * @return
	 */
	QueryAccountResult queryUserAccount(String accountId, OpenApiContext openApiContext);
	
	/**
	 * 个人实名认证申请
	 * @param certOrder
	 * @param openApiContext
	 * @return
	 */
	public EsupplierBaseResult realNameCertSave(PersonalCertOrder certOrder,
												OpenApiContext openApiContext);
	
	/**
	 * 企业实名认证申请
	 * @param certOrder
	 * @param openApiContext
	 * @return
	 */
	public EsupplierBaseResult realNameEnterpriseCertSave(BusinessCertOrder certOrder,
															OpenApiContext openApiContext);
	
	/**
	 * 查询实名状态
	 * @param userId
	 * @param openApiContext
	 * @return
	 */
	RealNameStatusResult queryRealNameCert(String userId, OpenApiContext openApiContext);
	
	/**
	 * @param mobileBindOrder
	 * @param openApiContext
	 * @return
	 */
	EsupplierBaseResult updateMobileBinding(MobileBindOrder mobileBindOrder,
											OpenApiContext openApiContext);
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 */
	CustomerResult applyAccountActivate(String userId, OpenApiContext openApiContext);
	
	/**
	 * @param userId
	 * @param openApiContext
	 * @return
	 */
	CustomerResult gotoYjfSit(String userId, OpenApiContext openApiContext);
	
	/**
	 * 实名认证等级查询
	 * @param userId
	 * @param openApiContext
	 * @return
	 */
	RealNameLevelResult queryRealNameAuthenticationLevel(String userId,
															OpenApiContext openApiContext);
	
	/**
	 * 快速实名认证
	 * @param certifyOrder
	 * @param openApiContext
	 * @return
	 */
	EsupplierBaseResult userQuickCertify(UserQuickCertifyOrder certifyOrder,
											OpenApiContext openApiContext);
	
	EsupplierBaseResult fullNineElements(RegisterOrder order, OpenApiContext openApiContext);
	
	EsupplierBaseResult checkNineElements(String accountId, OpenApiContext openApiContext);
	
	QueryAccountResult userInfoQuery(String userId, OpenApiContext openApiContext);
}
