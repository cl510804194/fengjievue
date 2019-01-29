package com.yjf.esupplier.web.controller.upload;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DownThread extends Thread{
	private HttpServletResponse response;
	private HttpSession session;
	private String filePath;
	private String type;
	private String fileType;
	private String proName;
	public void run(){
		Down down = new Down();
		down.downOrPreview(response, session, filePath, type, fileType,proName);
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	
	

}
