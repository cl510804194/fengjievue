package com.yjf.esupplier.ws.order;

import com.yjf.common.service.Order;

public class CreateLoanDemandExtendOrder extends ValidateOrderBase implements Order {

	private static final long serialVersionUID = 7770200593230659105L;
    private long loanDemandExtendId;

    private long loanDemandId;

    private String propertyKey;

    private String propertyValue;

    public long getLoanDemandExtendId() {
        return loanDemandExtendId;
    }

    public void setLoanDemandExtendId(long loanDemandExtendId) {
        this.loanDemandExtendId = loanDemandExtendId;
    }

    public long getLoanDemandId() {
        return loanDemandId;
    }

    public void setLoanDemandId(long loanDemandId) {
        this.loanDemandId = loanDemandId;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
