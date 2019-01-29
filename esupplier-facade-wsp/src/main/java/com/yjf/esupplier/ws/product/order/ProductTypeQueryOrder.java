package com.yjf.esupplier.ws.product.order;

import com.yjf.esupplier.ws.service.query.QueryPageBase;

import java.util.List;

public class ProductTypeQueryOrder extends QueryPageBase {

	private static final long serialVersionUID = 4934894775433197163L;
	String ptTypeName;
	String ptCode;
	String ptNotes;
	List<String> ptCodeList;
	String searchName;

	public String getPtTypeName() {
		return this.ptTypeName;
	}

	public void setPtTypeName(String ptTypeName) {
		this.ptTypeName = ptTypeName;
	}

	public String getPtCode() {
		return this.ptCode;
	}

	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}

	public String getSearchName() {
		return this.searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List<String> getPtCodeList() {
		return ptCodeList;
	}

	public void setPtCodeList(List<String> ptCodeList) {
		this.ptCodeList = ptCodeList;
	}

	public String getPtNotes() {
		return ptNotes;
	}

	public void setPtNotes(String ptNotes) {
		this.ptNotes = ptNotes;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ProductTypeQueryOrder{");
		sb.append("ptTypeName='").append(ptTypeName).append('\'');
		sb.append(", ptCode='").append(ptCode).append('\'');
		sb.append(", ptNotes='").append(ptNotes).append('\'');
		sb.append(", ptCodeList=").append(ptCodeList);
		sb.append(", searchName='").append(searchName).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
