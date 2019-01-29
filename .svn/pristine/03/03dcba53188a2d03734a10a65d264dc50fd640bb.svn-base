package com.yjf.esupplier.integration.openapi.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yjf.esupplier.integration.openapi.IncomOutcomQueryService;
import com.yjf.esupplier.integration.openapi.client.OpenApiServiceBase;
import com.yjf.esupplier.integration.openapi.context.OpenApiContext;
import com.yjf.esupplier.integration.openapi.info.IncomeOutcomeInfoList;
import com.yjf.esupplier.integration.openapi.order.QueryIncomOutcomOrder;
import com.yjf.esupplier.integration.openapi.result.QueryIncomOutcomResult;
import com.yjf.esupplier.common.util.MiscUtil;
import com.yjf.esupplier.common.util.NumberUtil;
import com.yjf.esupplier.ws.enums.IncomeOutcomeEnum;
import com.yjf.esupplier.ws.service.EsupplierResultEnum;


/**
 *                       
 * @Filename IncomOutcomQueryServiceImpl.java
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

@Service("IncomOutcomQueryService")
public class IncomOutcomQueryServiceImpl extends OpenApiServiceBase implements IncomOutcomQueryService{

	@SuppressWarnings("unchecked")
	@Override
	public QueryIncomOutcomResult IncomOutcomQuery(QueryIncomOutcomOrder queryOrder,
												OpenApiContext openApiContext) {
		
		String serviceName="incomeOutcomeQuery";
		Map<String, String> paramMap = new HashMap<String, String>();
		QueryIncomOutcomResult result = new QueryIncomOutcomResult();
		try {
			queryOrder.check();
			openApiContext.setService(serviceName);
			paramMap.put("userId", queryOrder.getUserId());
			paramMap.put("beginDate", queryOrder.getBeginDate());
			paramMap.put("endDate", queryOrder.getEndTime());
			paramMap.put("pageNo", queryOrder.getPageNo()+"");
			paramMap.put("pageSize", queryOrder.getPageSize()+"");
			
			Map<String, Object> dataMap = senderPost(paramMap, openApiContext);
			
			result.setSuccess(isSuccessStringSuccess(dataMap));
			
			if (result.isSuccess()){
				result.setTotalCount(NumberUtil.parseInt(String.valueOf(dataMap.get("totalCount"))));
				result.setCurrentPageNo(NumberUtil.parseInt(String.valueOf(dataMap.get("currentPageNo"))));
				result.setTotalPageCount(NumberUtil.parseInt(String.valueOf(dataMap.get("totalPageCount"))));
				List<Map<String, Object>> info = (List<Map<String, Object>>) dataMap
					.get("incomeOutcomeInfoList");
				List<IncomeOutcomeInfoList> incomeOutcomeInfo = new ArrayList<IncomeOutcomeInfoList>();
				for (Map<String, Object> item : info) {
					IncomeOutcomeInfoList queryInfo = new IncomeOutcomeInfoList();
					MiscUtil.setInfoPropertyByMap(item, queryInfo);
					queryInfo.setTradeType(IncomeOutcomeEnum.getByCode(item.get("tradeType")));
					incomeOutcomeInfo.add(queryInfo);
				}
				result.setIncomeOutcomeInfoList(incomeOutcomeInfo);
			}else{
				result.setMessage(String.valueOf(dataMap.get("message")));
				result.setCode(String.valueOf(dataMap.get("resultCode")));
			}
			
		} catch (IllegalArgumentException e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.INCOMPLETE_REQ_PARAM);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			result.setSuccess(false);
			result.setCreditsysResultEnum(EsupplierResultEnum.UN_KNOWN_EXCEPTION);
			logger.error(e.getLocalizedMessage(), e);
		}
		return result;
	}
	
}
