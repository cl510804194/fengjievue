package com.yjf.esupplier.integration.youmenSend.order;

/**
 * IOS消息体
 * */
public class aps {
	/** 内容 */
	String alert;
	String badge = "1";
	/** 自定义通知声音 */
	String sound = "diancanmp3.caf";

	String contentAvailable = "1";
	public String getAlert() {
		return this.alert;
	}
	
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
	public String getBadge() {
		return this.badge;
	}
	
	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getContentAvailable() {
		return contentAvailable;
	}

	public void setContentAvailable(String contentAvailable) {
		this.contentAvailable = contentAvailable;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("aps{");
		sb.append("alert='").append(alert).append('\'');
		sb.append(", badge='").append(badge).append('\'');
		sb.append(", sound='").append(sound).append('\'');
		sb.append(", contentAvailable='").append(contentAvailable).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
