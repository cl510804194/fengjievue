/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 上午9:37:25 创建
 */
package com.yjf.esupplier.ws.messageWall.services;

import com.yjf.esupplier.ws.messageWall.info.MessageLoveWallInfo;
import com.yjf.esupplier.ws.messageWall.info.MessageWallInfo;
import com.yjf.esupplier.ws.messageWall.order.MessageLoveWallOrder;
import com.yjf.esupplier.ws.messageWall.order.MessageWallOrder;
import com.yjf.esupplier.ws.messageWall.order.MessageWallQueryOrder;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 *
 *
 * @author zhouwei
 *
 */
public interface MessageWallService {
	
	/**
	 * 分页查询 爱的印记
	 * @param order
	 * @return
	 */
	QueryBaseBatchResult<MessageLoveWallInfo> findMessageLoveWallList(	MessageWallQueryOrder order);
	
	/**
	 * 根据Id删除爱的印记
	 * @param id
	 * @return
	 */
	EsupplierBaseResult deleteMessageLoveWallInfoById(long id);
	
	/**
	 * 新增万花筒爱的印记
	 * @param order
	 * @return
	 */
	EsupplierBaseResult addMessageLoveWallInfo(MessageLoveWallOrder order);
	
	/**
	 * 分页查询 到此一游
	 * @param order
	 * @return
	 */
	QueryBaseBatchResult<MessageWallInfo> findMessageWallList(MessageWallQueryOrder order);
	
	/**
	 * 根据Id删除 到此一游
	 * @param id
	 * @return
	 */
	EsupplierBaseResult deleteMessageWallInfoById(long id);
	
	/**
	 * 新增万花筒 到此一游
	 * @param order
	 * @return
	 */
	EsupplierBaseResult addMessageWallInfo(MessageWallOrder order);

	/**
	 * 万花筒爱的印记 详情
	 * @param order
	 * @return
	 */
	MessageLoveWallInfo findLoveWallInfoById(long id);

}
