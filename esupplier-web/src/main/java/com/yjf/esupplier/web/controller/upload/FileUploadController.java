package com.yjf.esupplier.web.controller.upload;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.yjf.common.lang.util.StringUtil;
import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.esupplier.common.util.AppConstantsUtil;
import com.yjf.esupplier.web.controller.base.BaseAutowiredController;
import com.yjf.esupplier.web.util.FileUploadUtils;
import com.yjf.esupplier.ws.info.LoanDemandInfo;

@Controller
@RequestMapping("/admin/upload")
public class FileUploadController extends BaseAutowiredController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
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
		fileTypeList.add(".apk");
		fileTypeList.add(".ipa");
	};
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "imagesUpload2Front.htm")
	public Object imagesUpload2Front(String fileName, HttpServletRequest request,
										HttpServletResponse response) {
		//		fileName = fileName.split(";")[0];
		JSONObject jsonobj = new JSONObject();
		
		DefaultMultipartHttpServletRequest mulRequest = (DefaultMultipartHttpServletRequest) request;
		MultipartFile multipartFile = null;
		try {
			multipartFile = FileUploadUtils.getMultipartFile(mulRequest.getFileMap());
			
			if (multipartFile == null) {
				return "{\"code\":\"1\",\"resData\":\"" + "文件接收异常！" + "\"}";
			}
			// 解析文件  
			String name = multipartFile.getOriginalFilename();
			if (name == null || name.trim().equals("")) {
				return "{\"code\":\"1\",\"resData\":\"" + "文件接收异常！" + "\"}";
			}
			
			String extName = "";
			// 得到文件的扩展名  
			if (name.lastIndexOf(".") >= 0) {
				extName = name.substring(name.lastIndexOf("."));
			}
			if (!fileTypeList.contains(extName.toLowerCase())) {
				jsonobj.put("code", "1");
				jsonobj.put("message", "文件上传失败(文件类型不正确)！");
				return jsonobj.toJSONString();
			}
			File file = null;
			
			String imgDir = FileUploadUtils.getStaticFilesImgDir();
			
			String savePath = imgDir + File.separator + name;
			
			logger.info("imagesUpload2Front  savePath:" + savePath);
			
			FileOutputStream baos = null;
			try {
				InputStream stream = multipartFile.getInputStream();
				baos = new FileOutputStream(savePath);
				byte[] b = new byte[1024];
				int readIndex = 0;
				while ((readIndex = stream.read(b)) > 0) {
					baos.write(b, 0, readIndex);
				}
			} catch (FileNotFoundException e) {
				logger.error("上传图片失败", e);
				return null;
			} catch (Exception e) {
				logger.error("write file faild", e);
			} finally {
				if (baos != null) {
					try {
						baos.close();
					} catch (IOException e) {
						//do nothing
					}
				}
				
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return "{\"code\":\"1\",\"resData\":\"" + "文件接收异常！" + "\"}";
		}
		//validateFikeExsit(fileName);
		jsonobj.put("code", "0");
		response.setContentType("text/json");
		jsonobj.put("resData", fileName);
		return jsonobj.toJSONString();
	}
	
	protected void validateFikeExsit(String fileName) {
		try {
			String urlString = null;
			if (StringUtil.isNotBlank(fileName)) {
				if (fileName.startsWith("/")) {
					urlString = AppConstantsUtil.getHostHttpUrl() + fileName;
				} else {
					urlString = fileName;
				}
			}
			URL url = new URL(urlString);
			URLConnection urlConnection = url.openConnection();
			if (urlConnection.getContentLengthLong() > 0) {
				logger.info("文件上传成功文件名={}，长度={}", urlString, urlConnection.getContentLengthLong());
			} else {
				logger.info("文件上传失败文件名={}，长度={}", urlString, urlConnection.getContentLengthLong());
			}
		} catch (Exception e) {
			logger.error("检验文件存在异常={}", e, e);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/imagesUpload.htm")
	public Object imagesUpload(HttpServletRequest request, HttpServletResponse response,
								ModelMap modelMap) {
		return getObject(request, response);
	}
	
	protected Object getObject(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println(ShiroSessionUtils.getSessionLocal());
		String[] pathArray = null;
		File file = null;
		JSONObject jsonobj = new JSONObject();
		DefaultMultipartHttpServletRequest mulRequest = null;
		if (request instanceof DefaultMultipartHttpServletRequest) {
			mulRequest = (DefaultMultipartHttpServletRequest) request;
		}
		String agent = request.getHeader("user-agent");
		boolean isIE = false;
		if (agent != null && (agent.indexOf("MSIE") > -1 || agent.indexOf("rv:") > -1)) {
			isIE = true;
		}
		if (isIE) {
			response.setHeader("ContentType", "text/html");
			response.setContentType("text/html");
		} else {
			response.setHeader("ContentType", "application/json");
			response.setContentType("application/json");
		}
		if (mulRequest == null) {
			jsonobj.put("code", "1");
			jsonobj.put("message", "文件上传失败(文件类型不正确)！");
			//			returnJson(response, isIE, jsonobj);
			return jsonobj.toJSONString();
		}
		MultipartFile multipartFile = null;
		multipartFile = FileUploadUtils.getMultipartFile(mulRequest.getFileMap());
		
		//		if (multipartFile == null) {
		//            return "{\"code\":\"1\",\"resData\":\"" + "文件接收异常！" + "\"}";
		//        }
		// 解析文件
		String name = multipartFile.getOriginalFilename();
		
		try {
			// 得到文件的扩展名
			String extName = "";
			if (name.lastIndexOf(".") >= 0) {
				extName = name.substring(name.lastIndexOf("."));
			}
			if (!fileTypeList.contains(extName.toLowerCase())) {
				jsonobj.put("code", "1");
				jsonobj.put("message", "文件上传失败(文件类型不正确)！");
				return jsonobj.toJSONString();
			}
			if (".pdf".equalsIgnoreCase(extName)) {
				pathArray = FileUploadUtils.getStaticFilesPdfPath(request, name);
			} else {
				pathArray = FileUploadUtils.getStaticFilesImgPath(request, name);
			}
			String savePath = pathArray[0];
			FileOutputStream baos = null;
			try {
				file = new File(savePath);
				InputStream stream = multipartFile.getInputStream();
				baos = new FileOutputStream(savePath);
				byte[] b = new byte[1024];
				int readIndex = 0;
				while ((readIndex = stream.read(b)) > 0) {
					baos.write(b, 0, readIndex);
				}
				baos.close();
				stream.close();
				//						if (".jpg".equalsIgnoreCase(extName) || ".bmp".equalsIgnoreCase(extName)
				//							|| ".png".equalsIgnoreCase(extName)) {
				//							boolean pass = this.compressPic(savePath, savePath);
				//							if (!pass) {
				//								logger.info("文件压缩异常");
				//								return "{\"code\":\"2\",\"resData\":\"" + "文件压缩异常" + "\"}";
				//							}
				//						}
			} catch (Exception e) {
				
				logger.error("文件写入异常，异常信息：{}", e.toString(), e);
				jsonobj.put("code", "3");
				jsonobj.put("resData", "文件写入异常");
				//				returnJson(response, isIE, jsonobj);
				return jsonobj.toJSONString();
				//						return "{\"code\":\"3\",\"resData\":\"" + "文件写入异常" + "\"}";
			}
			//				}
			//			}
		} catch (Exception e) {
			logger.error("文件上传异常，异常信息：{}", e.toString(), e);
			jsonobj.put("code", "2");
			jsonobj.put("resData", "文件上传异常");
			//			returnJson(response, isIE, jsonobj);
			return jsonobj.toJSONString();
			//			return "{\"code\":\"2\",\"resData\":\"" + "文件上传异常" + "\"}";
		}
		//validateFikeExsit(pathArray[1]);
		jsonobj.put("code", "0");
		jsonobj.put("resData", pathArray[1]);
		jsonobj.put("err", "");
		jsonobj.put("msg", pathArray[1]);
		jsonobj.put("serverPath", pathArray[0]);
		jsonobj.put("error", 0);
		jsonobj.put("url", pathArray[1]);
		jsonobj.put("fileName", file.getName());
		//		returnJson(response, isIE, jsonobj);
		return jsonobj.toJSONString();
	}
	
	protected void returnJson(HttpServletResponse response, boolean isIE, JSONObject jsonobj) {
		try {
			//			response.reset();
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
	
	@ResponseBody
	@RequestMapping("getUploadImages.htm")
	public Object getUploadImages(HttpServletResponse response, String imagePath, ModelMap modelMap)
																									throws IOException {
		response.sendRedirect(imagePath);
		return "";
		//		InputStream inputStream = null;
		//		try {
		//			inputStream = new FileInputStream(new File(imagePath));
		//			if (!"".equals(imagePath) && imagePath != null) {
		//				String imageExtNameWithOutDot = imagePath.substring(imagePath.lastIndexOf(".") + 1);
		//				ImageIO.setUseCache(false);
		//				BufferedImage image = ImageIO.read(inputStream);
		//				String imageExtName = "";
		//				if ("jpg".equalsIgnoreCase(imageExtNameWithOutDot)) {
		//					imageExtName = "jpeg";
		//					imageExtNameWithOutDot = "jpg";
		//				} else if ("jpeg".equalsIgnoreCase(imageExtNameWithOutDot)
		//							|| "jpe".equalsIgnoreCase(imageExtNameWithOutDot)) {
		//					imageExtName = "jpeg";
		//				} else if ("png".equalsIgnoreCase(imageExtNameWithOutDot)) {
		//					imageExtName = "x-png";
		//				} else if ("gif".equalsIgnoreCase(imageExtNameWithOutDot)) {
		//					imageExtName = "gif";
		//				} else if ("bmp".equalsIgnoreCase(imageExtNameWithOutDot)) {
		//					imageExtName = "x-ms-bmp";
		//				}
		//				response.setContentType("image/" + imageExtName);
		//				ServletOutputStream out = response.getOutputStream();
		//				ImageIO.write(image, imageExtNameWithOutDot, out);
		//				out.flush();
		//				out.close();
		//			}
		//		} catch (Exception e) {
		//			logger.error(e.getMessage());
		//			return "";
		//		} finally {
		//			if (inputStream != null) {
		//				inputStream.close();
		//			}
		//		}
		//		return "";
	}
	
	@RequestMapping("downLoadFile.htm")
	public void downLoadFile(HttpServletResponse response, HttpSession session, long demandId,
								String type, String fileType) {
		//String[] path = filePath.split("=");
		LoanDemandInfo loan = null;
		DownThread downThread = new DownThread();
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			logger.error(e.getMessage(), e);
		}
		downThread.setResponse(response);
		downThread.setSession(session);
		downThread.setType(type);
		downThread.setFileType(fileType);
		downThread.run();
	}
	
	public boolean compressPic(String srcFilePath, String descFilePath) {
		ImageIO.setUseCache(false);
		File file = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;
		
		// 指定写图片的方式为 jpg
		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
		// 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
		imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
		// 这里指定压缩的程度，参数qality是取值0~1范围内，
		imgWriteParams.setCompressionQuality(1);
		imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
		ColorModel colorModel = ColorModel.getRGBdefault();
		// 指定压缩时使用的色彩模式
		imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel,
			colorModel.createCompatibleSampleModel(16, 16)));
		
		try {
			if (StringUtil.isBlank(srcFilePath)) {
				return false;
			} else {
				file = new File(srcFilePath);
				src = ImageIO.read(file);
				out = new FileOutputStream(descFilePath);
				
				imgWrier.reset();
				// 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何 OutputStream构造
				imgWrier.setOutput(ImageIO.createImageOutputStream(out));
				// 调用write方法，就可以向输入流写图片
				imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}
}
