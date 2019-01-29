package com.yjf.esupplier.ws.data;

import java.io.Serializable;
import java.util.Date;

import com.yjf.esupplier.ws.enums.DivisionPhaseEnum;
import com.yjf.esupplier.ws.enums.DivisionTemplateStatusEnum;
import com.yjf.esupplier.ws.enums.DivisionWayEnum;

public class DivisionTemplateData implements Serializable {
	protected static final long serialVersionUID = -6250502451269450796L;
	/** 分润模版ID */
	protected long divisionTemplateId;
	/** 模版名称 */
	protected String templateName;
	/** 分润阶段,invest:投资阶段,repay:还款阶段 */
	protected DivisionPhaseEnum divisionPhase;
	
	/** 分润方式,sit:每笔投资分润,month:每月分 */
	protected DivisionWayEnum divisionWay;
	/** 模板状态 */
	protected DivisionTemplateStatusEnum templateStatus;
	/** 创建时间 */
	protected Date createDate;
	/** 修改时间 */
	protected Date modifyDate;
	/** 描述 */
	protected String templateNote;
	
	public long getDivisionTemplateId() {
		return this.divisionTemplateId;
	}
	
	public void setDivisionTemplateId(long divisionTemplateId) {
		this.divisionTemplateId = divisionTemplateId;
	}
	
	public String getTemplateName() {
		return this.templateName;
	}
	
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	public DivisionPhaseEnum getDivisionPhase() {
		return this.divisionPhase;
	}
	
	public void setDivisionPhase(DivisionPhaseEnum divisionPhase) {
		this.divisionPhase = divisionPhase;
	}
	
	public DivisionWayEnum getDivisionWay() {
		return this.divisionWay;
	}
	
	public void setDivisionWay(DivisionWayEnum divisionWay) {
		this.divisionWay = divisionWay;
	}
	
	public DivisionTemplateStatusEnum getTemplateStatus() {
		return this.templateStatus;
	}
	
	public void setTemplateStatus(DivisionTemplateStatusEnum templateStatus) {
		this.templateStatus = templateStatus;
	}
	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getModifyDate() {
		return this.modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public String getTemplateNote() {
		return this.templateNote;
	}
	
	public void setTemplateNote(String templateNote) {
		this.templateNote = templateNote;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DivisionTemplateData [divisionTemplateId=");
		builder.append(divisionTemplateId);
		builder.append(", templateName=");
		builder.append(templateName);
		builder.append(", divisionPhase=");
		builder.append(divisionPhase);
		builder.append(", divisionWay=");
		builder.append(divisionWay);
		builder.append(", templateStatus=");
		builder.append(templateStatus);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", modifyDate=");
		builder.append(modifyDate);
		builder.append(", templateNote=");
		builder.append(templateNote);
		builder.append("]");
		return builder.toString();
	}
	
}
