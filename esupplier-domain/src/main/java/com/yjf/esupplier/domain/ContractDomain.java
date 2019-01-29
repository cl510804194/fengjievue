package com.yjf.esupplier.domain;

import java.util.List;

import com.yjf.common.domain.api.Domain;
import com.yjf.common.lang.util.ListUtil;
import com.yjf.esupplier.ws.data.ContractData;

public class ContractDomain extends ContractData implements Domain {
	
	private static final long serialVersionUID = -689714005756820244L;
	
	/**
	 * 商品信息
	 */
	List<LoanCommodityDomain> commodityDomains;
	/**
	 * 收货信息
	 */
	DeliverDomain deliverDomain;
	
	public List<LoanCommodityDomain> getCommodityDomains() {
		return this.commodityDomains;
	}
	
	public void setCommodityDomains(List<LoanCommodityDomain> commodityDomains) {
		this.commodityDomains = commodityDomains;
		if (ListUtil.isNotEmpty(commodityDomains)) {
			for (LoanCommodityDomain commodityDomain : this.commodityDomains) {
				commodityDomain.setContractId(getContractId());
			}
		}
		
	}
	
	public DeliverDomain getDeliverDomain() {
		return this.deliverDomain;
	}
	
	public void setDeliverDomain(DeliverDomain deliverDomain) {
		this.deliverDomain = deliverDomain;
		this.deliverDomain.setContractId(this.getContractId());
	}
	
	@Override
	public void examSelf() throws Exception {
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContractDomain [commodityDomains=");
		builder.append(commodityDomains);
		builder.append(", deliverDomain=");
		builder.append(deliverDomain);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
