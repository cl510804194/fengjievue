package com.yjf.esupplier.ws.info;

import java.util.List;

import com.yjf.esupplier.ws.data.DivisionTemplateData;

public class DivisionTemplateInfo extends DivisionTemplateData {
	
	private static final long serialVersionUID = -2171483129535185329L;
	List<DivisionRuleInfo> rules;
	
	public List<DivisionRuleInfo> getRules() {
		return this.rules;
	}
	
	public void setRules(List<DivisionRuleInfo> rules) {
		this.rules = rules;
	}
	
}
