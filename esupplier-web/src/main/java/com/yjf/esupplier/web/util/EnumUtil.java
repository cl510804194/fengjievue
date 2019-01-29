package com.yjf.esupplier.web.util;

import java.util.ArrayList;
import java.util.List;

import com.yjf.common.lang.util.StringUtil;
import com.yjf.esupplier.ws.enums.CommonAttachmentTypeEnum;

public class EnumUtil extends com.yjf.esupplier.common.util.EnumUtil {
	
	public static List<CommonAttachmentTypeEnum> getAttachmentByLoanerInfo() {
		List<CommonAttachmentTypeEnum> list = new ArrayList<CommonAttachmentTypeEnum>();
		for (CommonAttachmentTypeEnum item : CommonAttachmentTypeEnum.values()) {
			if (StringUtil.equals(item.getIndustryType(),
				CommonAttachmentTypeEnum.LOANER_INFO.getIndustryType())) {
				list.add(item);
			}
		}
		return list;
	}
	
	public static List<CommonAttachmentTypeEnum> getAttachmentByLoanNote() {
		List<CommonAttachmentTypeEnum> list = new ArrayList<CommonAttachmentTypeEnum>();
		for (CommonAttachmentTypeEnum item : CommonAttachmentTypeEnum.values()) {
			if (StringUtil.equals(item.getIndustryType(),
				CommonAttachmentTypeEnum.LOAN_NOTE.getIndustryType())) {
				list.add(item);
			}
		}
		return list;
	}
	
	public static List<CommonAttachmentTypeEnum> getAttachmentByGuarantyInfo() {
		List<CommonAttachmentTypeEnum> list = new ArrayList<CommonAttachmentTypeEnum>();
		for (CommonAttachmentTypeEnum item : CommonAttachmentTypeEnum.values()) {
			if (StringUtil.equals(item.getIndustryType(),
				CommonAttachmentTypeEnum.GUARANTY_INFO.getIndustryType())) {
				list.add(item);
			}
		}
		return list;
	}
}
