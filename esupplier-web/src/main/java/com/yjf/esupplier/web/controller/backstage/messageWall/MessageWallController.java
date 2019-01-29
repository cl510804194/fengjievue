/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * sxm 上午11:01:06 创建
 */
package com.yjf.esupplier.web.controller.backstage.messageWall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yjf.esupplier.common.util.PageTool;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.PageUtil;
import com.yjf.esupplier.ws.messageWall.info.MessageLoveWallInfo;
import com.yjf.esupplier.ws.messageWall.info.MessageWallInfo;
import com.yjf.esupplier.ws.messageWall.order.MessageWallQueryOrder;
import com.yjf.esupplier.ws.messageWall.services.MessageWallService;
import com.yjf.esupplier.ws.result.EsupplierBaseResult;
import com.yjf.esupplier.ws.service.query.result.QueryBaseBatchResult;

/**
 *
 *
 * @author zhouwei
 *
 */
@Controller
@RequestMapping("/admin/messageWall")
public class MessageWallController extends BaseAutowiredController {
	protected String VM__PATH = "/backstage/messageWall/";

	@Autowired
	MessageWallService messageWallService;

	@RequestMapping(value = "messageLoveWallList.htm")
	public String messageLoveWallList(MessageWallQueryOrder queryOrder,
										Model model) {
		try {


			QueryBaseBatchResult<MessageLoveWallInfo> result = messageWallService
				.findMessageLoveWallList(queryOrder);
			PageTool page = new PageTool();
			page.setCurrentPage((int) queryOrder.getPageNumber());
			page.setPageSize((int) queryOrder.getPageSize());
			page.setTotalRow(result.getTotalCount());
			String pageBar = page.getPageBar();
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(result));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return VM__PATH + "pageQueryMessageLoveWall.vm";
	}
	
	@RequestMapping(value = "deleteMessageLoveWall.htm")
	@ResponseBody
	public Object deleteMessageLoveWall(long messageId, Model model) throws Exception {
		JSONObject json = new JSONObject();
		EsupplierBaseResult result = messageWallService.deleteMessageLoveWallInfoById(messageId);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "删除成功!");
		} else {
			json.put("code", 0);
			json.put("message", "删除失败:" + result.getMessage());
			
		}
		return json;
	}
	
	@RequestMapping(value = "messageWallList.htm")
	public String messageWallList(MessageWallQueryOrder queryOrder, Model model) {
		try {
			
			QueryBaseBatchResult<MessageWallInfo> result = messageWallService
				.findMessageWallList(queryOrder);
			PageTool page = new PageTool();
			page.setCurrentPage((int) queryOrder.getPageNumber());
			page.setPageSize((int) queryOrder.getPageSize());
			page.setTotalRow(result.getTotalCount());
			String pageBar = page.getPageBar();
			model.addAttribute("pageBar", pageBar);
			model.addAttribute("queryConditions", queryOrder);
			model.addAttribute("page", PageUtil.getCovertPage(result));
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return VM__PATH + "pageQueryMessageWall.vm";
	}
	
	@RequestMapping(value = "deleteMessageWall.htm")
	@ResponseBody
	public Object deleteMessageWall(long messageId, Model model) throws Exception {
		JSONObject json = new JSONObject();
		EsupplierBaseResult result = messageWallService.deleteMessageWallInfoById(messageId);
		if (result.isSuccess()) {
			json.put("code", 1);
			json.put("message", "删除成功!");
		} else {
			json.put("code", 0);
			json.put("message", "删除失败:" + result.getMessage());
			
		}
		return json;
	}
}
