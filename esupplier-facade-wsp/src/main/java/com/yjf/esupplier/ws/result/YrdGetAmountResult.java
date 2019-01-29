/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.result;


/**
 * 
 * @Filename YrdBaseResult.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author qichunhai
 * 
 * @Email qchunhai@yiji.com
 * 
 * @History <li>Author: qichunhai</li> <li>Date: 2014-4-3</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public class YrdGetAmountResult extends EsupplierBaseResult {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 5156892170604621621L;
	/**手续费金额*/
	private String charge;

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("YrdGetAmountResult [");
		builder.append("charge=");
		builder.append(charge);
		builder.append("]");
		return builder.toString();
	}
	
}
