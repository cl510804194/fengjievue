/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.ws.service;

import java.util.List;

import com.yjf.esupplier.ws.enums.CheckStatusEnum;
import com.yjf.esupplier.ws.enums.CommonAttachmentTypeEnum;
import com.yjf.esupplier.ws.info.CommonAttachmentInfo;
import com.yjf.esupplier.ws.order.CommonAttachmentDeleteOrder;
import com.yjf.esupplier.ws.order.CommonAttachmentOrder;
import com.yjf.esupplier.ws.order.CommonAttachmentQueryOrder;
import com.yjf.esupplier.ws.result.CommonAttachmentResult;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 * 
 * @Filename CommonAttachmentService.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author jiajie
 * 
 * @Email hjiajie@yiji.com
 * 
 * @History <li>Author: jiajie</li> <li>Date: 2013-6-19</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
public interface CommonAttachmentService {
	
	/**
	 * 群查图片信息
	 * @param order
	 * @return
	 */
	QueryBaseBatchResult<CommonAttachmentInfo> queryCommonAttachment(	CommonAttachmentQueryOrder order);
	
	/**
	 * 单插图片信息
	 * @param order
	 * @return
	 */
	EsupplierBaseResult insert(CommonAttachmentOrder order);
	
	/**
	 * 群插图片信息
	 * @param CommonAttachments
	 * @return
	 */
	EsupplierBaseResult insertAll(List<CommonAttachmentOrder> CommonAttachments);
	
	/**
	 * 通过id删除图片
	 * @param id
	 * @return
	 */
	EsupplierBaseResult deleteById(long id);
	
	/**
	 * 通过id删除图片(同时删除未审核的所有同张图片)
	 * @param id
	 * @return
	 */
	CommonAttachmentResult deleteByIdAllSame(long id);
	
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	CommonAttachmentResult deletePicture(CommonAttachmentDeleteOrder order);
	
	/**
	 * 通过id查找图片信息
	 * @param id
	 * @return
	 */
	CommonAttachmentResult findById(long id);
	
	/**
	 * 通过id更新图片信息
	 * @param Id
	 * @return
	 */
	EsupplierBaseResult updateStatus(long id, CheckStatusEnum status);
	
	/**
	 * 通过bizNo和主状态更新所有符合条件的图片信息(更新状态)
	 * @param Id
	 * @return
	 */
	EsupplierBaseResult updateStatus(String bizNo, CommonAttachmentTypeEnum moduleType,
								CheckStatusEnum status);
}
