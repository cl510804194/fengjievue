package com.yjf.esupplier.ws.service.query.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

import java.util.Date;

public class DebtTransferRuleQueryOrder extends QueryPageBase {

    private static final long serialVersionUID = -6087031601221993057L;
    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
