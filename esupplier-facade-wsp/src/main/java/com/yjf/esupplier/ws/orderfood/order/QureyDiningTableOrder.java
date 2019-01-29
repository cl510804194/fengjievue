package com.yjf.esupplier.ws.orderfood.order;

import java.util.List;

import org.springframework.util.Assert;

import com.yjf.esupplier.ws.orderfood.enums.DiningTableStatus;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class QureyDiningTableOrder extends QueryPageBase {
	
	private static final long serialVersionUID = 7633661742327532144L;
	
	private DiningTableStatus status;
	private long supplierId;
	private String tableNumber;
	
	private List<DiningTableStatus> statusList;

	@Override
	public void check() {
		Assert.isTrue(supplierId > 0, "商户id不能为空");
		
	}
	
	public DiningTableStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(DiningTableStatus status) {
		this.status = status;
	}
	
	public long getSupplierId() {
		return this.supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getTableNumber() {
		return this.tableNumber;
	}
	
	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public List<DiningTableStatus> getStatusList() {
		return statusList;
	}
	
	public void setStatusList(List<DiningTableStatus> statusList) {
		this.statusList = statusList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QureyDiningTableOrder [status=");
		builder.append(status);
		builder.append(", supplierId=");
		builder.append(supplierId);
		builder.append(", tableNumber=");
		builder.append(tableNumber);
		builder.append(", statusList=");
		builder.append(statusList);
		builder.append("]");
		return builder.toString();
	}

	
}
