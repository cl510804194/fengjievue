package com.yjf.esupplier.ws.gifamount.data;

import com.yjf.esupplier.ws.gifamount.enums.GiftMoneyStatusEnum;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by min on 2014/11/17.
 */
public class GiftMoneyTemplateData implements Serializable {

    private static final long serialVersionUID = 1050206313986977458L;

    private long templateId;

    private String templateName;

    private String increase;

    private GiftMoneyStatusEnum status;

    private Date rawAddTime;

    private Date rawUpdateTime;

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getIncrease() {
        return increase;
    }

    public void setIncrease(String increase) {
        this.increase = increase;
    }

    public GiftMoneyStatusEnum getStatus() {
        return status;
    }

    public void setStatus(GiftMoneyStatusEnum status) {
        this.status = status;
    }

    public Date getRawAddTime() {
        return rawAddTime;
    }

    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GiftMoneyTemplateData{");
        sb.append("templateId=").append(templateId);
        sb.append(", templateName='").append(templateName).append('\'');
        sb.append(", increase='").append(increase).append('\'');
        sb.append(", status=").append(status);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append('}');
        return sb.toString();
    }
}
