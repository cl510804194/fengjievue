package com.yjf.esupplier.ws.result;

import com.yjf.esupplier.ws.info.CommonAttachmentInfo;

public class CommonAttachmentResult extends EsupplierBaseResult {
	
	private static final long serialVersionUID = -8894712705496167696L;
	CommonAttachmentInfo attachmentInfo;
	
	public CommonAttachmentInfo getAttachmentInfo() {
		return this.attachmentInfo;
	}
	
	public void setAttachmentInfo(CommonAttachmentInfo attachmentInfo) {
		this.attachmentInfo = attachmentInfo;
	}
	
}
