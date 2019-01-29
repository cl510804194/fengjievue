package com.yjf.esupplier.ws.gifamount.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.yjf.esupplier.ws.gifamount.data.GiftMoneyTradeData;

/**
 * Created by min on 2014/11/18.
 */
public class GiftMoneyTradeInfo extends GiftMoneyTradeData implements Serializable {
	private static final long serialVersionUID = 8175964196027132138L;
	protected String phoneNum;
	/*优惠券规则*/
	protected List<String> giftMoneyTemplateDataList = new ArrayList<String>();
	public List<String> getGiftMoneyTemplateDataList() {
		return giftMoneyTemplateDataList;
	}

	public void setGiftMoneyTemplateDataList(List<String> giftMoneyTemplateDataList) {
		this.giftMoneyTemplateDataList = giftMoneyTemplateDataList;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
