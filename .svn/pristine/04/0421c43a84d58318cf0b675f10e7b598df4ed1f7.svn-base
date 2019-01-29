package com.yjf.esupplier.ws.product.info;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.BooleanEnum;

public class ProductTypeInfo implements Serializable {
	private static final long	serialVersionUID	= 3568174657723710739L;
	private long				ptId;
	
	private String				ptCode;
	
	private String				ptTypeName;
	
	private long				ptParentId;
	
	private long				priority;
	
	private long				ptSeq;
	
	private long				productCount;
	
	private long				ptCodeLn;
	
	/**
	 * 栏目商品预留字段定义
	 */
	private String				ptAddColumns;
	/**
	 * 备用字段
	 */
	private String				ptNote;
	/**
	 * 分类商品标签
	 */
	private String				ptTag;
	/**
	 * 分类商品关键词
	 */
	private String				ptKeyWords;
	
	private Date				rawAddTime;
	
	private Date				rawUpdateTime;
	
	String						fullTypeName;
	/**
	 * 分类商品标签汇总（下级获得上级标签）
	 */
	String						fullPtTag;
	
	/**
	 * 分类商品关键词汇总（下级获得上级关键词）
	 */
	private String				fullPtKeyWords;
	
	private BooleanEnum			checkType			= BooleanEnum.NO;
	
	public BooleanEnum getCheckType() {
		return checkType;
	}
	
	public void setCheckType(BooleanEnum checkType) {
		this.checkType = checkType;
	}
	
	public long getPtId() {
		return this.ptId;
	}
	
	public void setPtId(long ptId) {
		this.ptId = ptId;
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
	
	public long getProductCount() {
		return this.productCount;
	}
	
	public void setProductCount(long productCount) {
		this.productCount = productCount;
	}
	
	public long getPtCodeLn() {
		return this.ptCodeLn;
	}
	
	public void setPtCodeLn(long ptCodeLn) {
		this.ptCodeLn = ptCodeLn;
	}
	
	public Date getRawAddTime() {
		return this.rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public Date getRawUpdateTime() {
		return this.rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	public String getFullTypeName() {
		return this.fullTypeName;
	}
	
	public void setFullTypeName(String fullTypeName) {
		this.fullTypeName = fullTypeName;
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
	
	public String getFullPtTag() {
		return fullPtTag;
	}
	
	public void setFullPtTag(String fullPtTag) {
		this.fullPtTag = fullPtTag;
	}
	
	public String getFullPtKeyWords() {
		return fullPtKeyWords;
	}
	
	public void setFullPtKeyWords(String fullPtKeyWords) {
		this.fullPtKeyWords = fullPtKeyWords;
	}
	
	public String toAllString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductTypeInfo [ptId=");
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
		builder.append(", productCount=");
		builder.append(productCount);
		builder.append(", ptCodeLn=");
		builder.append(ptCodeLn);
		builder.append(", ptAddColumns=");
		builder.append(ptAddColumns);
		builder.append(", ptNote=");
		builder.append(ptNote);
		builder.append(", ptTag=");
		builder.append(ptTag);
		builder.append(", ptKeyWords=");
		builder.append(ptKeyWords);
		builder.append(", rawAddTime=");
		builder.append(rawAddTime);
		builder.append(", rawUpdateTime=");
		builder.append(rawUpdateTime);
		builder.append(", fullTypeName=");
		builder.append(fullTypeName);
		builder.append(", checkType=");
		builder.append(checkType);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{id:");
		builder.append(ptId);
		builder.append(", code:\"");
		builder.append(ptCode);
		builder.append("\", name:\"");
		builder.append(ptTypeName);
		builder.append("\", pId:");
		builder.append(ptParentId);
		if (ptParentId == 0) {
			builder.append(",open:true");
		}
		builder.append("}");
		return builder.toString();
	}
	
}
