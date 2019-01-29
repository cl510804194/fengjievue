package com.yjf.esupplier.integration.youmenSend.order;

import com.yjf.esupplier.ws.enums.BooleanEnum;
import com.yjf.esupplier.ws.order.ValidateOrderBase;

/**
 * 请求order
 */
public class youmengOrder extends ValidateOrderBase {
	
	private static final long serialVersionUID = 7153121480795150861L;
	/** 标题 */
	String title;
	/** 通知文字描述：内容 */
	String text;
	/** 通知栏提示文字 */
	String ticker = "广播";
	/** 定时发送 */
	String start_time;
	/** 有效期 */
	String expire_time;
	/** 推送用户ID */
	String userId;
	/** 是否播放语音 */
	String voice = BooleanEnum.YES.getCode();
	/** 设备唯一表示 */
	String device_tokens;
	/** message消息 notification通知 */
	String displayType = "message";

	public void orderCheck() {
		validateHasText(title, "标题");
		validateHasText(text, "通知文字描述");
		validateHasText(ticker, "通知栏提示文字 ");
	}

	public String getDevice_tokens() {
		return device_tokens;
	}

	public void setDevice_tokens(String device_tokens) {
		this.device_tokens = device_tokens;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getStart_time() {
		return this.start_time;
	}
	
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	public String getExpire_time() {
		return this.expire_time;
	}
	
	public void setExpire_time(String expire_time) {
		this.expire_time = expire_time;
	}
	
	public String getTicker() {
		return this.ticker;
	}
	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getVoice() {
		return voice;
	}
	
	public void setVoice(String voice) {
		this.voice = voice;
	}
	
	public String getDisplayType() {
		return displayType;
	}
	
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("youmengOrder{");
		sb.append("title='").append(title).append('\'');
		sb.append(", text='").append(text).append('\'');
		sb.append(", ticker='").append(ticker).append('\'');
		sb.append(", start_time='").append(start_time).append('\'');
		sb.append(", expire_time='").append(expire_time).append('\'');
		sb.append(", userId='").append(userId).append('\'');
		sb.append(", voice='").append(voice).append('\'');
		sb.append(", device_tokens='").append(device_tokens).append('\'');
		sb.append(", displayType='").append(displayType).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
