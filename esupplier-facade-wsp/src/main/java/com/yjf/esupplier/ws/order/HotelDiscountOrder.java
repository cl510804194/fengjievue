/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.order;

import com.yjf.esupplier.ws.hotel.enums.HotelTypeEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;

/**
 *
 *
 * @Filename HotelStockProductOrder.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email yunchuan@yiji.com
 *
 */
public class HotelDiscountOrder extends QueryPageBase  {

	private static final long serialVersionUID = -7241895295671953485L;
	
	private long scenicId;
	
	private HotelTypeEnum type;
	
	private String setTimeSort;

	public long getScenicId() {
		return scenicId;
	}
	
	public void setScenicId(long scenicId) {
		this.scenicId = scenicId;
	}
	
	public HotelTypeEnum getType() {
		return type;
	}
	
	public void setType(HotelTypeEnum type) {
		this.type = type;
	}
	
	public String getSetTimeSort() {
		return setTimeSort;
	}
	
	public void setSetTimeSort(String setTimeSort) {
		this.setTimeSort = setTimeSort;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HotelDiscountOrder [scenicId=");
		builder.append(scenicId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", setTimeSort=");
		builder.append(setTimeSort);
		builder.append("]");
		return builder.toString();
	}


}
