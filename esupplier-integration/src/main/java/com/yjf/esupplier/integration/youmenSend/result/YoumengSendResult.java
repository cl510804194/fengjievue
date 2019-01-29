package com.yjf.esupplier.integration.youmenSend.result;

import com.yjf.esupplier.ws.result.YrdBaseResult;

public class YoumengSendResult extends YrdBaseResult {
	
	private static final long serialVersionUID = 1499117130449274049L;
	/** android send result */
	boolean androidSend = false;
	/** ios send result */
	boolean iosSend = false;
	/** error result code */
	String error_code;
	/** androidTaskId&IosTaskId */
	String task_id;
	
	public boolean isAndroidSend() {
		return this.androidSend;
	}
	
	public void setAndroidSend(boolean androidSend) {
		this.androidSend = androidSend;
	}
	
	public boolean isIosSend() {
		return this.iosSend;
	}
	
	public void setIosSend(boolean iosSend) {
		this.iosSend = iosSend;
	}
	
	public String getError_code() {
		return this.error_code;
	}
	
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
	public String getTask_id() {
		return this.task_id;
	}
	
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YoumengSendResult [androidSend=");
		builder.append(androidSend);
		builder.append(", iosSend=");
		builder.append(iosSend);
		builder.append(", error_code=");
		builder.append(error_code);
		builder.append(", task_id=");
		builder.append(task_id);
		builder.append("]");
		return builder.toString();
	}
	
}
