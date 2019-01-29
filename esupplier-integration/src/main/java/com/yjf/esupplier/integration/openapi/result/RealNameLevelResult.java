package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.integration.openapi.enums.CertifyLevelEnum;
import com.yjf.esupplier.integration.openapi.enums.RealNameBusinessStatusEnum;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class RealNameLevelResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -1269312546204247751L;
	
	RealNameBusinessStatusEnum businessStatusEnum = RealNameBusinessStatusEnum.UNAUTHERIZED;
	
	private String msg;
	
	private CertifyLevelEnum certifyLevel;
	
	public RealNameBusinessStatusEnum getBusinessStatusEnum() {
		return businessStatusEnum;
	}
	
	public void setBusinessStatusEnum(RealNameBusinessStatusEnum businessStatusEnum) {
		this.businessStatusEnum = businessStatusEnum;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CertifyLevelEnum getCertifyLevel() {
		return certifyLevel;
	}
	
	public void setCertifyLevel(CertifyLevelEnum certifyLevel) {
		this.certifyLevel = certifyLevel;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RealNameLevelResult [businessStatusEnum=");
		builder.append(businessStatusEnum);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", certifyLevel=");
		builder.append(certifyLevel);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
