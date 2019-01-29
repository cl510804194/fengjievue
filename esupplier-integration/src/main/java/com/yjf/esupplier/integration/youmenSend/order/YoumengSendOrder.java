package com.yjf.esupplier.integration.youmenSend.order;

/**
 * 调用友盟接口的请求数据处理Order
 * */
public class YoumengSendOrder {
	
	/** 默认列播 */
	String type = "listcast";
	/** 设备唯一表示 */
	String device_tokens;
	String appkey;
	String timestamp;
	/** 消息内容 */
	payload payload;
	/** 发送策略 */
	policy policy;
	/** 发送消息描述 */
	String description;
	/** true/false :正式/测试模式 */
	String production_mode;

	public String getDevice_tokens() {
		return device_tokens;
	}

	public void setDevice_tokens(String device_tokens) {
		this.device_tokens = device_tokens;
	}

	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getAppkey() {
		return this.appkey;
	}
	
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	
	public String getTimestamp() {
		return this.timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public payload getPayload() {
		return this.payload;
	}
	
	public void setPayload(payload payload) {
		this.payload = payload;
	}
	
	public policy getPolicy() {
		return this.policy;
	}
	
	public void setPolicy(policy policy) {
		this.policy = policy;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String isProduction_mode() {
		return this.production_mode;
	}
	
	public void setProduction_mode(String production_mode) {
		this.production_mode = production_mode;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("YoumengSendOrder{");
		sb.append("type='").append(type).append('\'');
		sb.append(", device_tokens='").append(device_tokens).append('\'');
		sb.append(", appkey='").append(appkey).append('\'');
		sb.append(", timestamp='").append(timestamp).append('\'');
		sb.append(", payload=").append(payload);
		sb.append(", policy=").append(policy);
		sb.append(", description='").append(description).append('\'');
		sb.append(", production_mode=").append(production_mode);
		sb.append('}');
		return sb.toString();
	}

}
