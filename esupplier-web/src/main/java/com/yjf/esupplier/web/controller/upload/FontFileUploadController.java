/**
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.upload;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;

/**
 * 
 * 
 * @Filename FontFileUploadController.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author min
 * 
 * @Email oyangnuo@yiji.com
 * 
 * @History <li>Author: oyangnuo</li> <li>Date: 2016-1-11下午7:51:12</li> <li>
 * Version: 1.0</li> <li>Content: create</li>
 */
@Controller
@RequestMapping("/do/upload/")
public class FontFileUploadController extends FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FontFileUploadController.class);
	private static List<String> fileTypeList = new ArrayList<String>();
	static {
		fileTypeList.add(".jpg");
		fileTypeList.add(".jpeg");
		fileTypeList.add(".bmp");
		fileTypeList.add(".png");
		fileTypeList.add(".pdf");
		fileTypeList.add(".docx");
		fileTypeList.add(".doc");
		fileTypeList.add(".xls");
	};
	
	@ResponseBody
	@RequestMapping(value = "/imagesUploads.htm")
	public Object imagesUploaddd(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		
		return getObject(request, response);
		
	}
	
}
