/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.yjf.esupplier.web.controller.kaptcha;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.SessionConstant;
import com.yjf.esupplier.common.util.ValidateCode;

/**
 * 
 * @Filename CaptchaImageCreateController.java
 * 
 * @Description 验证码生成
 * 
 * @Version 1.0
 * 
 * @Author karott
 * 
 * @Email chenlin@yiji.com
 * 
 * @History <li>Author: karott</li> <li>Date: 2011-6-2</li> <li>Version: 1.0</li>
 * <li>Content: create</li>
 * 
 */
@Controller
public class CaptchaImageCreateController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired(required = false)
	private final Producer captchaProducer4 = null;
	
	@Autowired(required = false)
	private final Producer captchaProducer6 = null;
	
	@RequestMapping("/getCaptchaImg4")
	public ModelAndView createCaptcha4(HttpServletRequest request, HttpServletResponse response)
																								throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		
		ServletOutputStream out = null;
		//调用服务接口
		try {
			String result = ValidateCode.getCode(4, 2);
			String capText = result;
			// store the text in the session   
			Session session = SecurityUtils.getSubject().getSession();
			
			session.setAttribute(SessionConstant.SESSION_KAPTCHA_KEY, capText);
			
			// create the image with the text   
			BufferedImage bi = captchaProducer4.createImage(capText);
			out = response.getOutputStream();
			// write the data out   
			ImageIO.write(bi, "jpg", out);
			if (out != null)
				out.flush();
		} catch (Exception e) {
			logger.error("remote createVerifyCode fail", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return null;
	}
	
	@RequestMapping("/getCaptchaImg6")
	public ModelAndView createCaptcha6(HttpServletRequest request, HttpServletResponse response)
																								throws Exception {
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.   
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).   
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.   
		response.setHeader("Pragma", "no-cache");
		// return a jpeg   
		response.setContentType("image/jpeg");
		// create the text for the image  
		//调用服务接口
		String result = ValidateCode.getCode(6, 2);
		String capText = result;
		// store the text in the session   
		request.getSession().setAttribute(SessionConstant.KAPTCHA_SESSION_KEY, capText);
		// create the image with the text   
		BufferedImage bi = captchaProducer6.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		// write the data out   
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
}
