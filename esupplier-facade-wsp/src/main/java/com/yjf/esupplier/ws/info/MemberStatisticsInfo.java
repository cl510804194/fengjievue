/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.yjf.esupplier.ws.info;

import java.io.Serializable;

/**
 *
 *
 * @Filename MemberStatisticsInfo.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author min
 *
 * @Email oyangnuo@yiji.com
 *
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-2-25上午11:19:43</li> <li>Version: 1.0
 * </li> <li>Content: create</li>
 */
public class MemberStatisticsInfo implements Serializable {

	private static final long serialVersionUID = -1543493166020837459L;

	private String result;

	private String condition;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberStatisticsInfo [result=");
		builder.append(result);
		builder.append(", condition=");
		builder.append(condition);
		builder.append("]");
		return builder.toString();
	}
	
}
