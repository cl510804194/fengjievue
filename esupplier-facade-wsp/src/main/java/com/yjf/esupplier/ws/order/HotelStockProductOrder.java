/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.esupplier.ws.hotel.enums.HotelStockStatusEnum;
import com.yjf.esupplier.ws.product.enums.ProductStatusEnum;
import com.yjf.esupplier.ws.service.query.QueryPageBase;
import org.springframework.util.Assert;

import java.util.Date;

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
public class HotelStockProductOrder extends QueryPageBase  {

	private static final long serialVersionUID = -7241895295671953485L;
	/*房型id*/
	private long productId;
	/*商户ID*/
	private long supplierId;
	/**
	 * 产品状态
	 */
	ProductStatusEnum productStatus = ProductStatusEnum.ON;
	/*状态*/
	private HotelStockStatusEnum status;
	/*开始日期*/
	private Date beginDate;
	/*结束日期*/
	private Date endDate;
	@Override
	public void check() {
		super.check();
		Assert.notNull(beginDate, "请提供查询开始日期");
		Assert.notNull(beginDate, "请提供查询开始日期");
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public HotelStockStatusEnum getStatus() {
		return status;
	}

	public void setStatus(HotelStockStatusEnum status) {
		this.status = status;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ProductStatusEnum getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatusEnum productStatus) {
		this.productStatus = productStatus;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("HotelStockProductOrder{");
		sb.append("productId=").append(productId);
		sb.append(", supplierId=").append(supplierId);
		sb.append(", productStatus=").append(productStatus);
		sb.append(", status=").append(status);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append('}');
		return sb.toString();
	}

}
