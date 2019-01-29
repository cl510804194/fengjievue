package com.yjf.esupplier.ws.service.query.result;

import com.yjf.esupplier.ws.info.DebtTransferDetailInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class QueryDebtTransferDetailResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -992402486692087262L;
	/**
	 * 债权转让聚合信息
	 */
	DebtTransferDetailInfo debtTransferDetailInfo;
	
	public DebtTransferDetailInfo getDebtTransferDetailInfo() {
		return this.debtTransferDetailInfo;
	}
	
	public void setDebtTransferDetailInfo(DebtTransferDetailInfo debtTransferDetailInfo) {
		this.debtTransferDetailInfo = debtTransferDetailInfo;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryDebtTransferDetailResult [debtTransferDetailInfo=");
		builder.append(debtTransferDetailInfo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
