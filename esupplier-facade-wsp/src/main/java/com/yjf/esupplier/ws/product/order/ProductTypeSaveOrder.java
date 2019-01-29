package com.yjf.esupplier.ws.product.order;

import org.springframework.util.Assert;

import com.yjf.esupplier.ws.order.ValidateOrderBase;

public class ProductTypeSaveOrder extends ValidateOrderBase {
	private static final long serialVersionUID = -6059888546279446588L;
	private long ptId;
	/**
	 * 编码
	 */
	private String ptCode;
	/**
	 * 项目名称
	 */
	private String ptTypeName;
	/**
	 * 父id
	 */
	private long ptParentId;
	/**
	 * 优先级
	 */
	private long priority;
	/**
	 * 序号
	 */
	private long ptSeq;
	/**
	 * 栏目商品预留字段定义
	 */
	private String ptAddColumns;
	/**
	 * 备用字段
	 */
	private String ptNote;
	/**
	 * 分类商品标签
	 */
	private String ptTag;
	/**
	 * 分类商品关键词
	 */
	private String ptKeyWords;
	@Override
	public void check() {
		validateHasText(ptCode, "产品类型编码");
		validateHasText(ptTypeName, "产品类型名称");
		validateHasText(ptNote, "发布类型");
		String[] array = ptCode.split("-");
		for (String item : array) {
			Assert.isTrue(item.length() == 4, "产品类型编码格式不正确(xxxx,xxxx-xxxx,xxxx-xxxx-xxxx)");
		}
		
	}
	
	public String getPtCode() {
		return this.ptCode;
	}
	
	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}
	
	public String getPtTypeName() {
		return this.ptTypeName;
	}
	
	public void setPtTypeName(String ptTypeName) {
		this.ptTypeName = ptTypeName;
	}
	
	public long getPtParentId() {
		return this.ptParentId;
	}
	
	public void setPtParentId(long ptParentId) {
		this.ptParentId = ptParentId;
	}
	
	public long getPriority() {
		return this.priority;
	}
	
	public void setPriority(long priority) {
		this.priority = priority;
	}
	
	public long getPtSeq() {
		return this.ptSeq;
	}
	
	public void setPtSeq(long ptSeq) {
		this.ptSeq = ptSeq;
	}
	
	public long getPtId() {
		return this.ptId;
	}
	
	public void setPtId(long ptId) {
		this.ptId = ptId;
	}

	public String getPtAddColumns() {
		return ptAddColumns;
	}

	public void setPtAddColumns(String ptAddColumns) {
		this.ptAddColumns = ptAddColumns;
	}

	public String getPtNote() {
		return ptNote;
	}

	public void setPtNote(String ptNote) {
		this.ptNote = ptNote;
	}

	public String getPtTag() {
		return ptTag;
	}

	public void setPtTag(String ptTag) {
		this.ptTag = ptTag;
	}

	public String getPtKeyWords() {
		return ptKeyWords;
	}

	public void setPtKeyWords(String ptKeyWords) {
		this.ptKeyWords = ptKeyWords;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductTypeSaveOrder [ptId=");
		builder.append(ptId);
		builder.append(", ptCode=");
		builder.append(ptCode);
		builder.append(", ptTypeName=");
		builder.append(ptTypeName);
		builder.append(", ptParentId=");
		builder.append(ptParentId);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", ptSeq=");
		builder.append(ptSeq);
		builder.append(", ptAddColumns=");
		builder.append(ptAddColumns);
		builder.append(", ptNote=");
		builder.append(ptNote);
		builder.append(", ptTag=");
		builder.append(ptTag);
		builder.append(", ptKeyWords=");
		builder.append(ptKeyWords);
		builder.append("]");
		return builder.toString();
	}
	
}
