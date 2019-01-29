package com.yjf.esupplier.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.StringUtil;
import com.yjf.esupplier.web.util.FileUploadUtils;

public class UploadFileServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileServlet.class);
	private static final long serialVersionUID = 1L;
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
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.info("UploadFileServlet init");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,
																IOException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
																			IOException {
		uploadFile(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
																			throws ServletException,
																			IOException {
		uploadFile(req, resp);
	}
	
	protected void returnJson(HttpServletResponse response, boolean isIE, JSONObject jsonobj) {
		try {
			//response.reset();
			if (isIE) {
				response.setHeader("ContentType", "text/html");
				response.setContentType("text/html");
			} else {
				response.setHeader("ContentType", "application/json");
				response.setContentType("application/json");
			}
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonobj.toJSONString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	
	private void uploadFile(HttpServletRequest request, HttpServletResponse response) {
		
		String agent = request.getHeader("user-agent");
		boolean isIE = false;
		if (agent != null && agent.indexOf("MSIE") > -1) {
			isIE = true;
		}
		//isIE = true;
		String[] pathArray = null;
		File file = null;
		JSONObject jsonobj = new JSONObject();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();//为该请求创建一个DiskFileItemFactory对象，通过它来解析请求。执行解析后，所有的表单项目都保存在一个List中。
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = null;
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException e) {
					logger.error(e.getMessage(), e);
				}
				if (items == null) {
					jsonobj.put("code", "1");
					jsonobj.put("resData", "文件上传失败！");
					returnJson(response, isIE, jsonobj);
					return;
				}
				Iterator<FileItem> itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = itr.next();
					if (StringUtil.isNotBlank(item.getName())) {
						
						String extName = "";
						String orgName = item.getName();
						if (item.getName().lastIndexOf(".") >= 0) {
							extName = item.getName().substring(item.getName().lastIndexOf("."));
						}
						if (!fileTypeList.contains(extName.toLowerCase())) {
							
							jsonobj.put("code", "1");
							jsonobj.put("resData", "文件上传失败(文件类型不正确)！");
							returnJson(response, isIE, jsonobj);
							return;
						}
						if (".pdf".equalsIgnoreCase(extName)) {
							pathArray = FileUploadUtils.getStaticFilesPdfPath(request, orgName);
						} else {
							pathArray = FileUploadUtils.getStaticFilesImgPath(request, orgName);
						}
						String savePath = pathArray[0];
						FileOutputStream baos = null;
						try {
							file = new File(savePath);
							InputStream stream = item.getInputStream();
							baos = new FileOutputStream(savePath);
							byte[] b = new byte[1024];
							int readIndex = 0;
							while ((readIndex = stream.read(b)) > 0) {
								baos.write(b, 0, readIndex);
							}
							
							baos.close();
							stream.close();
						} catch (Exception e) {
							if (baos != null)
								try {
									baos.close();
								} catch (IOException e1) {
									logger.error(e1.getMessage(), e1);
								}
							logger.error("文件写入异常，异常信息：{}", e.toString(), e);
							jsonobj.put("code", "3");
							jsonobj.put("resData", "文件写入异常！");
							returnJson(response, isIE, jsonobj);
							return;
						}
					}
				}
			} catch (Exception e) {
				logger.error("文件上传异常，异常信息：{}", e.toString(), e);
				jsonobj.put("code", "2");
				jsonobj.put("resData", "文件上传异常！");
				returnJson(response, isIE, jsonobj);
				return;
			}
		}
		jsonobj.put("code", "0");
		jsonobj.put("resData", pathArray[1]);
		jsonobj.put("err", "");
		jsonobj.put("msg", pathArray[1]);
		jsonobj.put("serverPath", pathArray[0]);
		jsonobj.put("error", 0);
		jsonobj.put("url", pathArray[1]);
		jsonobj.put("fileName", file.getName());
		response.setContentType("text/json");
		returnJson(response, isIE, jsonobj);
	}
	
	@Override
	public String getServletInfo() {
		return null;
	}
	
	@Override
	public void destroy() {
	}
	
}
