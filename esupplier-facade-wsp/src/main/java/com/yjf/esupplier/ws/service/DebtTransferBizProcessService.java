package com.yjf.esupplier.ws.service;

import com.yjf.esupplier.ws.order.DebtTransferCancelOrder;
import com.yjf.esupplier.ws.order.DebtTransferOrder;
import com.yjf.esupplier.ws.order.DebtTransferReReleaseOrder;
import com.yjf.esupplier.ws.order.DebtTransferReleaseOrder;
import com.yjf.esupplier.ws.result.ValidateCanDebtTransferResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public interface DebtTransferBizProcessService {
	/**
	 * 发布债权转让交易
	 * @param releaseOrder
	 * @return
	 */
	public EsupplierBaseResult releaseDebtTransfer(DebtTransferReleaseOrder releaseOrder);
	
	/**
	 * 取消债权转让接口
	 * @param cancelOrder
	 * @return
	 */
	EsupplierBaseResult cancelDebtTransfer(DebtTransferCancelOrder cancelOrder);
	
	/**
	 * 取消后重新发布接口，可以修改转让金额
	 * @param reReleaseOrder
	 * @return
	 */
	EsupplierBaseResult reReleaselDebtTransfer(DebtTransferReReleaseOrder reReleaseOrder);
	
	/**
	 * 债权转让
	 * @param debtTransferOrder
	 * @return
	 */
	EsupplierBaseResult transferDebt(DebtTransferOrder debtTransferOrder);
	
	/**
	 * 自动取消发布债权交易
	 */
	void autoOfflineDebtTransfer();
	
	/**
	 * 验证是否可以转让，验证通过返回可以转让的相应结果
	 * @param tradeDetailId
	 * @return
	 */
	ValidateCanDebtTransferResult validateCanDebtTransfer(long tradeDetailId);
}
