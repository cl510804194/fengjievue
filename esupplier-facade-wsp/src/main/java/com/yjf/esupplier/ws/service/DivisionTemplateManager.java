package com.yjf.esupplier.ws.service;

import java.util.List;

import com.yjf.esupplier.ws.enums.DivisionPhaseEnum;
import com.yjf.esupplier.ws.enums.DivisionTemplateStatusEnum;
import com.yjf.esupplier.ws.info.DivisionTemplateInfo;
import com.yjf.esupplier.ws.order.DivisionTemplateOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

public interface DivisionTemplateManager {
	public List<DivisionTemplateInfo> getDivisionTemplatesByPhase(	DivisionPhaseEnum phaseEnum,
																	DivisionTemplateStatusEnum statusEnum);
	
	void deleteDivisionTemplate(long templateId);
	
	DivisionTemplateInfo getByTemplateId(long templateId);
	
	void modifyDivisionTemplate(DivisionTemplateOrder divisionTemplateOrder);
	
	EsupplierBaseResult addDivisionTemplate(DivisionTemplateOrder divisionTemplateOrder);
	
	QueryBaseBatchResult<DivisionTemplateInfo> findByCondition(	DivisionTemplateOrder divisionTemplateOrder);
	
	public void changeDivisionTemplateStatus(long templateId, String status);
	
	public boolean isUseDivisionTemplate(long templateId);
	
	public void clearCache();
}
