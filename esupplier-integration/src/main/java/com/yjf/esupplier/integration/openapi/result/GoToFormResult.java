package com.yjf.esupplier.integration.openapi.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yjf.esupplier.ws.result.EsupplierBaseResult;

public class GoToFormResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = 34793812719985683L;
	String url;
	String sign;
	List<FormText> formTexts;
	Map<String, String> map = new HashMap<String, String>();
	
	@Override
	public String getUrl() {
		return this.url;
	}
	
	@Override
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getSign() {
		return this.sign;
	}
	
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public List<FormText> getFormTexts() {
		return this.formTexts;
	}
	
	public void setFormTexts(List<FormText> formTexts) {
		this.formTexts = formTexts;
	}
	
	public Map<String, String> getMap() {
		return this.map;
	}
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoToFormResult [url=");
		builder.append(url);
		builder.append(", sign=");
		builder.append(sign);
		builder.append(", formTexts=");
		builder.append(formTexts);
		builder.append("]");
		return builder.toString();
	}
	
	public static final class FormText {
		
		public FormText() {
			
		}
		
		String key;
		String value;
		
		public String getKey() {
			return this.key;
		}
		
		public void setKey(String key) {
			this.key = key;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("FormText [key=");
			builder.append(key);
			builder.append(", value=");
			builder.append(value);
			builder.append("]");
			return builder.toString();
		}
		
	}
}
