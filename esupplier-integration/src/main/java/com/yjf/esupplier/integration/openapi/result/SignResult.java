package com.yjf.esupplier.integration.openapi.result;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

/**
 * Created by zjialin@yiji.com on 2014/4/15.
 */
public class SignResult extends EsupplierBaseResult {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2720824044634911298L;

    /**
     * 地址
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SignResult{");
        sb.append("url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
