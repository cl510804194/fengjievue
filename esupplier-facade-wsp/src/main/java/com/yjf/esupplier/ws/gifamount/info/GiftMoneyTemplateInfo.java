package com.yjf.esupplier.ws.gifamount.info;

import java.io.Serializable;
import java.util.List;

import com.yjf.esupplier.ws.gifamount.data.GiftMoneyTemplateData;

/**
 * Created by min on 2014/11/18.
 */
public class GiftMoneyTemplateInfo extends GiftMoneyTemplateData implements Serializable {
	private static final long serialVersionUID = -3490284476153362451L;
	private List<GiftMoneyTemplateRuleInfo> rules;
	
	public List<GiftMoneyTemplateRuleInfo> getRules() {
		return rules;
	}
	
	public void setRules(List<GiftMoneyTemplateRuleInfo> rules) {
		this.rules = rules;
	}
}
