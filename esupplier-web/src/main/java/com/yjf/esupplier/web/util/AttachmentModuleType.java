package com.yjf.esupplier.web.util;

import java.util.ArrayList;
import java.util.List;

import com.yjf.esupplier.ws.enums.CommonAttachmentTypeEnum;
import com.yjf.esupplier.ws.info.CommonAttachmentInfo;

public class AttachmentModuleType {
	CommonAttachmentTypeEnum moduleType;
	List<CommonAttachmentInfo> attachmentInfos=new ArrayList<CommonAttachmentInfo>();
	public CommonAttachmentTypeEnum getModuleType() {
		return moduleType;
	}
	public void setModuleType(CommonAttachmentTypeEnum moduleType) {
		this.moduleType = moduleType;
	}
	public List<CommonAttachmentInfo> getAttachmentInfos() {
		return attachmentInfos;
	}
	public void setAttachmentInfos(List<CommonAttachmentInfo> attachmentInfos) {
		this.attachmentInfos = attachmentInfos;
	}
	
}
