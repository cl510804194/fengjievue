package com.yjf.esupplier.web.controller.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.DispatcherServlet;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.ApplicationConstant;
import com.yjf.esupplier.common.util.FilenameUtil;

@Controller
@RequestMapping("anon")
public class UploadDownload {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, HttpServletResponse response,
							String imageCategory) throws Exception {
		PrintWriter out = null;
		InputStream instr = null;
		FileOutputStream outstr = null;
		try {
			//取得上下文
			WebApplicationContext wac = (WebApplicationContext) request
				.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			//spring处理过的请求
			MultipartHttpServletRequest mtRequest = (DefaultMultipartHttpServletRequest) request;
			Iterator<String> iterFileName = mtRequest.getFileNames();
			while (iterFileName.hasNext()) {
				String fileKey = iterFileName.next();
				//上传的文件
				MultipartFile uploadFile = mtRequest.getFile(fileKey);
				//绝对路径
				String webPath = FilenameUtil.getWebAppPath(wac);
				File fileMarks = new File(ApplicationConstant.FILE_PATH_ROOT
											+ FilenameUtil.getFolderFileName("exlUrl"));
				if (!fileMarks.exists()) {
					fileMarks.mkdirs();
				}
				//上传文件名
				String fileName = FilenameUtil.getRealNameCertFileName("aaaa",
					uploadFile.getOriginalFilename());
				//上传文件相对路径
				String filePath = FilenameUtil.getFolderFileName(fileName);
				File picFile = new File(fileMarks, fileName);
				//读文件			
				outstr = new FileOutputStream(picFile);
				instr = uploadFile.getInputStream();
				byte[] bytes = new byte[1024];
				while (instr.read(bytes) > 0) {
					outstr.write(bytes);
					outstr.flush();
				}
				outstr.close();
				//写回文件路径
				out = response.getWriter();
				out.write(ApplicationConstant.HTTP_DOMAIN_URL + ApplicationConstant.HTTP_PATH_ROOT
							+ filePath);
			}
			
		} catch (UnsupportedEncodingException uex) {
			logger.error(uex.getMessage(), uex);
		} catch (IOException iex) {
			logger.error(iex.getMessage(), iex);
			iex.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (instr != null) {
				instr.close();
			}
			if (outstr != null) {
				outstr.flush();
				outstr.close();
			}
			if (out != null) {
				out.close();
			}
		}
		return null;
	}
	
}
