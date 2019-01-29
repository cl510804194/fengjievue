package com.yjf.esupplier.ws.order;

import com.yjf.common.service.Order;

public class PopModuleOrder  extends ValidateOrderBase  implements Order {

	
	private static final long serialVersionUID = -2798633197665680243L;
	
	private long moduleId;

	/**模块名称*/
	private String moduleName;
	
	private String moduleCode;

	/**排列顺序*/
	private int sortOrder;

	/**是否只显示第一条（N：显示该模块下所有记录）**/
	private String showTop;

	/**点击次数*/
	private long hits;

	/**模块对应的前台展示页面*/
	private String vmPage;

	/**状态（1启用,2下线,0删除）*/
	private int status;

	/**模块类型 */
	private int type;

	private int level;

	private long parentId;

	/*module上下级关系*/
	private String levelCode;

	public long getModuleId() {
		return moduleId;
	}



	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}



	public String getModuleName() {
		return moduleName;
	}



	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}



	public String getModuleCode() {
		return moduleCode;
	}



	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}



	public int getSortOrder() {
		return sortOrder;
	}



	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}



	public String getShowTop() {
		return showTop;
	}



	public void setShowTop(String showTop) {
		this.showTop = showTop;
	}



	public long getHits() {
		return hits;
	}



	public void setHits(long hits) {
		this.hits = hits;
	}



	public String getVmPage() {
		return vmPage;
	}



	public void setVmPage(String vmPage) {
		this.vmPage = vmPage;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

	public int getType() {
		return this.type;
	}



	public void setType(int type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}


	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	 

}
