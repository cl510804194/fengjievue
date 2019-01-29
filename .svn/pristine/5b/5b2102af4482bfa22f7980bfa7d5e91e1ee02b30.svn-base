package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.ws.bill.enums.RefundApiStatusEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class OpenApiResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 6829319328788610786L;
	String bizNo;
	RefundApiStatusEnum status = RefundApiStatusEnum.FAIL;//SUCCESS 退款成功 	FAIL 退款失败 PROCESSING 处理中
	
	public boolean isProcessSuccess() {
		return status==RefundApiStatusEnum.SUCCESS;
		
	}
	
	public boolean isProcessing() {
		return status==RefundApiStatusEnum.PROCESSING;
		
	}
	
	public String getBizNo() {
		return this.bizNo;
	}
	
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public RefundApiStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RefundApiStatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OpenApiResult [bizNo=");
		builder.append(bizNo);
		builder.append(", status=");
		builder.append(status.code());
		builder.append(", success=");
		builder.append(isSuccess());
		builder.append("YrdBaseResult [estateResultEnum=");
		builder.append(super.getCreditsysResultEnum());
		builder.append("]");
		return builder.toString();
	}
	
}
