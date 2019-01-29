package com.yjf.esupplier.integration.openapi;

import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.order.QueryIncomOutcomOrder;
import com.yjf.esupplier.integration.openapi.result.QueryIncomOutcomResult;

/**
 *                       
 * @Filename IncomOutcomQueryService.java
 *
 * @Description  收支明细查询
 *
 * @Version 1.0
 *
 * @Author zhaohaibing
 *
 * @Email abing@yiji.com
 * 
 * Date:2014-09-12
 *
 */

public interface IncomOutcomQueryService {
	QueryIncomOutcomResult IncomOutcomQuery(QueryIncomOutcomOrder queryOrder,
											OpenApiContext openApiContext);
}
