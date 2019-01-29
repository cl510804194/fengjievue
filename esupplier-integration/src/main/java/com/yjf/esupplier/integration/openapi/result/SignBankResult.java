package com.yjf.esupplier.integration.openapi.result;

import java.util.ArrayList;
import java.util.List;

import com.yjf.esupplier.integration.openapi.info.SignBankInfo;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
public class SignBankResult extends EsupplierBaseResult {
	
	/**
	 * 签约银行卡
	 */
	private List<SignBankInfo> signBankInfos = new ArrayList<SignBankInfo>();
	
	public List<SignBankInfo> getSignBankInfos() {
		return signBankInfos;
	}
	
	public void setSignBankInfos(List<SignBankInfo> signBankInfos) {
		this.signBankInfos = signBankInfos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SignBankResult [signBankInfos=");
		builder.append(signBankInfos);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
