package com.yjf.esupplier.ws.service.query.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

/**
 * Created by wqh on 2014/5/21.
 */
public class SysParamQueryOrder extends QueryPageBase {
    private static final long serialVersionUID = -4239124486323136636L;
    /** 参数名称*/
    private String paramName;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
