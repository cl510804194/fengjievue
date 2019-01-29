package com.yjf.esupplier.ws.enums;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class UpdateRealNameStatusResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 2048005992889083077L;
	int certifyLevel = -1;
	
	public int getCertifyLevel() {
		return this.certifyLevel;
	}
	
	public void setCertifyLevel(int certifyLevel) {
		this.certifyLevel = certifyLevel;
	}
	
}
