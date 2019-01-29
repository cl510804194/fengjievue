/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 下午1:54:45 创建
 */
package com.yjf.esupplier.ws.bill.order;

import com.yjf.esupplier.ws.enums.UserBizTypeEnum;
import com.yjf.esupplier.ws.order.ProcessOrder;

/**
 * 
 * app取消点餐ORDER
 * @author zhouwei
 * 
 */
public class CancelDiningOrder extends ProcessOrder{
	
	private static final long serialVersionUID = 772248720460924621L;
	
	long supplierId;
	String batchNo;
	
	UserBizTypeEnum bizTypeEnum;

	@Override
	public void check() {
		validateHasZore(supplierId, "商户id");
		validateHasText(batchNo, "批次号");
	}

	public long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public UserBizTypeEnum getBizTypeEnum() {
		return bizTypeEnum;
	}
	
	public void setBizTypeEnum(UserBizTypeEnum bizTypeEnum) {
		this.bizTypeEnum = bizTypeEnum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CancelDiningOrder [supplierId=");
		builder.append(supplierId);
		builder.append(", batchNo=");
		builder.append(batchNo);
		builder.append(", bizTypeEnum=");
		builder.append(bizTypeEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}


}
