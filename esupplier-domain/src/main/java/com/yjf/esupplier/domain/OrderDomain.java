package com.yjf.esupplier.domain;

import java.util.Calendar;
import java.util.Date;

import com.yjf.common.domain.api.Domain;
import com.yjf.esupplier.ws.bill.data.OrderData;
import com.yjf.esupplier.ws.bill.enums.OrderStatusEnum;
import com.yjf.esupplier.ws.bill.enums.PaymentMethodEnum;
import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.product.enums.ProductVaryEnum;
import com.yjf.esupplier.ws.product.enums.RefundRuleEnum;

public class OrderDomain extends OrderData implements Domain {
	
	private static final long serialVersionUID = -5811385421156462447L;
	
	OrderItemDomain orderItemDomain;
	
	ProductDomain productDomain;
	
	public OrderItemDomain getOrderItemDomain() {
		return this.orderItemDomain;
	}
	
	public void setOrderItemDomain(OrderItemDomain orderItemDomain) {
		this.orderItemDomain = orderItemDomain;
	}
	
	public ProductDomain getProductDomain() {
		return this.productDomain;
	}
	
	public void setProductDomain(ProductDomain productDomain) {
		this.productDomain = productDomain;
	}
	
	@Override
	public void examSelf() throws Exception {
	}
	
	public boolean isCanRefund() {
		if (!orderStatus.isCanRefound())
			return false;
		if (facade == RefundRuleEnum.CAN_NOT) {
			return false;
		}
		if (paymentMethod != PaymentMethodEnum.ONLINE) {
			return false;
		}
		if (saleTypeB2c == BooleanEnum.YES) {
			if (facade == RefundRuleEnum.SEVEN_AFTER) {
				if (confirmReceiptTime == null)
					return true;
				return expireDate(confirmReceiptTime, 7);
			} else {
				return true;
			}
		} else if (saleTypeO2o == BooleanEnum.YES) {
			if (orderStatus == OrderStatusEnum.JYC) {
				return false;
			}
			if (facade == RefundRuleEnum.ANY_TIME) {
				return true;
			}
			if (facade == RefundRuleEnum.SEVEN_AFTER) {
				return expireDate(payedTime, 7);
			}
			if (facade == RefundRuleEnum.EXPIRED) {
				return expireDate(groupPurchaseEndTime, 0);
			}
		} else if(saleTypeHotels == BooleanEnum.YES){
			if (orderStatus == OrderStatusEnum.YFK) {
				return true;
			}
			//			if (facade == RefundRuleEnum.ANY_TIME) {
			//				return true;
			//			}
			//			if (facade == RefundRuleEnum.SEVEN_AFTER) {
			//				return expireDate(payedTime, 7);
			//			}
			//			if (facade == RefundRuleEnum.EXPIRED) {
			//				return expireDate(groupPurchaseEndTime, 0);
			//			}
		}
		if(productVary == ProductVaryEnum.ticket){
			return true;
		}
		return false;
		
	}

	
	private boolean expireDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (day != 0)
			c.add(Calendar.DATE, day);
		Date lastRefundDate = c.getTime();
		if ((new Date()).after(lastRefundDate)) {
			return false;
		} else {
			return true;
		}
	}
}
