/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: BaseConditionEntity.java 
 *
 * Created: [2013-12-19 上午10:28:34] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-19 上午10:28:34
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.entity;

/** 
 *
 * Description: 
 * 查询条件
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-19    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class ConditionEntity {
	private String id;
	private String resourceId;
	private String accessoriesId;
	private String keywords;
	private String name;
	private String status;
	private String type;
	private String startDate;
	private String endDate;
	public String getType() {
		return "".equals(type) ? null : type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccessoriesId() {
		return "".equals(accessoriesId) ? null : accessoriesId;
	}
	public void setAccessoriesId(String accessoriesId) {
		this.accessoriesId = accessoriesId;
	}
	public String getStatus() {
		return "".equals(status)? null : status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return "".equals(startDate)? null : startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return "".equals(endDate)? null : endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getKeywords() {
		return "".equals(keywords)? null : keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
}
