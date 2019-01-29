package com.yjf.esupplier.integration.youmenSend.service;


import com.yjf.esupplier.integration.youmenSend.order.youmengOrder;
import com.yjf.esupplier.integration.youmenSend.result.YoumengSendResult;

/**
 * APP消息推送
 * */
public interface YoumenMessageSendService {
	/** 调用友盟推送接口 */
	YoumengSendResult send(youmengOrder order);
	
	/** 取消推送接口 */
	YoumengSendResult cancel(String taskId, String type);
}
