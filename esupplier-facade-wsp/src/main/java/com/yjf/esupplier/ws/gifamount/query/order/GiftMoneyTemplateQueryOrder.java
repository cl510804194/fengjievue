package com.yjf.esupplier.ws.gifamount.query.order;


import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class GiftMoneyTemplateQueryOrder extends QueryPageBase {

    private static final long serialVersionUID = 760995802970640428L;
    private String templateName;

    private String status ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
