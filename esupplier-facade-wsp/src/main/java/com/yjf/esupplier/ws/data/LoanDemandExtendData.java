package com.yjf.esupplier.ws.data;

import java.io.Serializable;

/**
 * Created by min on 2014/12/4.
 */
public class LoanDemandExtendData   implements Serializable {
    private static final long serialVersionUID = -5465088805599671121L;

    protected long loanDemandExtendId;

    protected long loanDemandId;

    protected String propertyKey;

    protected String propertyValue;


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
