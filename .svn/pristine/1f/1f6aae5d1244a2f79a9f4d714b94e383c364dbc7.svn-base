package com.yjf.yrd.integration.bornapi.order;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.lang.util.money.MoneyUtil;
import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class WxPayCreateOrder extends ValidateOrderBase implements Order {
	
	private static final long serialVersionUID = -1964286333080617113L;
	String orderNo;
	String title;
	Money payAmount;
	String desc;
	String returnUrl;

	@Override
	public void check() {
		validateNotNull(orderNo, "交易订单号");
		validateHasText(title, "交易名");
		validateMoneyGreaterThanZero(payAmount, "交易金额");
	}

	public String getReturnUrl() {
		return returnUrl;
	}
	
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Money getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Money payAmount) {
		this.payAmount = payAmount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTradeAmount() {
		String m = MoneyUtil.format(getPayAmount());
		if (m.indexOf(",") > -1) {
			m = m.replaceAll(",", "");
		}
		return m;
	}


	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("WxPayCreateOrder{");
		sb.append("title='").append(title).append('\'');
		sb.append(", payAmount=").append(payAmount);
		sb.append(", desc='").append(desc).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
