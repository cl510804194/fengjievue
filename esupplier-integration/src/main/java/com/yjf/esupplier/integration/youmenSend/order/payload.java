package com.yjf.esupplier.integration.youmenSend.order;

public class payload {
	
	/** 默认为通知 */
	String display_type = "notification";
	/** 消息体 */
	body body;
	/** ios消息体 */
	aps aps;
	/** 推送用户ID */
	String userId;
	/** 是否播放语音 */
	String voice;
	public String getDisplay_type() {
		return this.display_type;
	}
	
	public void setDisplay_type(String display_type) {
		this.display_type = display_type;
	}
	
	public body getBody() {
		return this.body;
	}
	
	public void setBody(body body) {
		this.body = body;
	}
	
	public aps getAps() {
		return this.aps;
	}
	
	public void setAps(aps aps) {
		this.aps = aps;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("payload{");
		sb.append("display_type='").append(display_type).append('\'');
		sb.append(", body=").append(body);
		sb.append(", aps=").append(aps);
		sb.append(", userId='").append(userId).append('\'');
		sb.append(", voice='").append(voice).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
