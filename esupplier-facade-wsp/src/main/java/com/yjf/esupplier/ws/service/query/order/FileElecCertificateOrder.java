package com.yjf.esupplier.ws.service.query.order;

import java.util.Date;

import com.yjf.common.service.Order;
import com.yjf.esupplier.ws.order.TradeProcessOrder;

public class FileElecCertificateOrder extends TradeProcessOrder implements Order{
	
	

	private static final long serialVersionUID = -4794275595039064067L;
	
	private static String CONTRACT_PREFIX="c_"; 
	
	private static String LETTER_PREFIX="l_";
	
	private static String RECEIPT_PREFIX="r_";

	private String fileKey;

	private String preservationId;

	private String docHash;

	private String link;

	private Date rawAddTime;

	private Date preservationTime;

	private Date linkExpireTime;

	private String localLink;
	
	long pageSize = 10;
	long pageNumber = 1;
	long limitStart = 0;
	


	@Override
	public void check() {
		validateHasText(fileKey, "源文件Key");
		validateHasText(preservationId, "数字证书备案号");
		validateHasText(link, "数字证书下载地址");
		super.check();
		
	}

	@Override
	public String getGid() {
		return null;
	}

	@Override
	public void setGid(String gid) {
	}

	public String getFileKey() {
		return this.fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getPreservationId() {
		return this.preservationId;
	}

	public void setPreservationId(String preservationId) {
		this.preservationId = preservationId;
	}


	public String getDocHash() {
		return this.docHash;
	}

	public void setDocHash(String docHash) {
		this.docHash = docHash;
	}

	public Date getPreservationTime() {
		return this.preservationTime;
	}

	public void setPreservationTime(Date preservationTime) {
		this.preservationTime = preservationTime;
	}

	public Date getLinkExpireTime() {
		return this.linkExpireTime;
	}

	public void setLinkExpireTime(Date linkExpireTime) {
		this.linkExpireTime = linkExpireTime;
	}

	public String getLocalLink() {
		return this.localLink;
	}

	public void setLocalLink(String localLink) {
		this.localLink = localLink;
	}

	public long getLimitStart() {
		return this.limitStart;
	}

	public void setLimitStart(long limitStart) {
		this.limitStart = limitStart;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getRawAddTime() {
		return this.rawAddTime;
	}

	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public static String newContractFileKey(long tradeId) {
		return CONTRACT_PREFIX+tradeId;
	}
	
	public static String newLetterFileKey(long tradeId) {
		return LETTER_PREFIX+tradeId;
	}
	
	public static String newReceiptFileKey(long tradeId,long tradeDetailId) {
		return RECEIPT_PREFIX+tradeId+"_"+tradeDetailId;
	}
	
}
