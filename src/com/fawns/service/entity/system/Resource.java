/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: Resource.java 
 *
 * Created: [2014-1-2 下午02:11:03] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-2 下午02:11:03
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.entity.system;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

/** 
 *
 * Description: 
 *
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-1-2    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3725922651475084671L;
	
	private String id;
	private String description;
	private String name;
	private String action;
	private String parentId;
	private String parentName;
	private String iconUrl;
	private int sort;
	private Date   createDate;
	private String createOperId;
	private Date   updateDate;
	private String updateOperId;
	private String checked;//选择标识true选中，false没选中
	
	private List<Resource> children = Lists.newArrayList();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateOperId() {
		return createOperId;
	}
	public void setCreateOperId(String createOperId) {
		this.createOperId = createOperId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateOperId() {
		return updateOperId;
	}
	public void setUpdateOperId(String updateOperId) {
		this.updateOperId = updateOperId;
	}
	
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public List<Resource> getChildren() {
		return children;
	}
	public void setChildren(List<Resource> children) {
		this.children = children;
	}
}
