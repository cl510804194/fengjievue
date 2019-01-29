package com.yjf.esupplier.ws.gifamount.query.order;

import java.util.List;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

public class GiftMoneyTradeQueryOrder extends QueryPageBase {
    private static final long serialVersionUID = 4637443397492729265L;
    private long giftId;
    /*GiftMoneyTypeEnum*/
    private String type;
    private String username;
    private String startDate;
    private String endDate;
    private List<String> typeList;
    private List<String> statusList;
    private String useType;

    private long userid;

    private String status;

    private String tradeType;

    private String outBizNo;

	private String sendAccountCode;
	
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }
    
	public String getSendAccountCode() {
		return sendAccountCode;
	}

	public void setSendAccountCode(String sendAccountCode) {
		this.sendAccountCode = sendAccountCode;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

}
