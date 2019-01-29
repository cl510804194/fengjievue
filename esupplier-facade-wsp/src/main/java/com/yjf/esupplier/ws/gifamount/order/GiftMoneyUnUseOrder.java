package com.yjf.esupplier.ws.gifamount.order;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

import java.util.Date;

public class GiftMoneyUnUseOrder extends ValidateOrderBase implements Order {

    private long detailDomainId;

    private long tradeDomainId;

    private Date currentDate;

    private String oderNo;

    private String orderNO2;


    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public long getDetailDomainId() {
        return detailDomainId;
    }

    public void setDetailDomainId(long detailDomainId) {
        this.detailDomainId = detailDomainId;
    }

    public long getTradeDomainId() {
        return tradeDomainId;
    }

    public void setTradeDomainId(long tradeDomainId) {
        this.tradeDomainId = tradeDomainId;
    }

    public String getOderNo() {
        return oderNo;
    }

    public void setOderNo(String oderNo) {
        this.oderNo = oderNo;
    }

    public String getOrderNO2() {
        return orderNO2;
    }

    public void setOrderNO2(String orderNO2) {
        this.orderNO2 = orderNO2;
    }
}
