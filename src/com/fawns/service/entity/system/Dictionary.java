/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: Dictionary.java 
 *
 * Created: [2013-12-30 上午10:21:19] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-30 上午10:21:19
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.entity.system;

import java.io.Serializable;
import java.util.Date;

/** 
 *
 * Description: 
 * 字典管理实体
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-30    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class Dictionary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1606488923915646601L;
	private String id;
	private String dictionaryType;
	private String dictionaryCode;
	private String status;
	private String name;
	private String remark;
	private String parentId;
	private String parentName;
	private int sort;
	private Date   createDate;
	private String createOperId;
	private Date   updateDate;
	private String updateOperId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDictionaryType() {
		return dictionaryType;
	}
	public void setDictionaryType(String dictionaryType) {
		this.dictionaryType = dictionaryType;
	}
	
	public String getDictionaryCode() {
		return dictionaryCode;
	}
	public void setDictionaryCode(String dictionaryCode) {
		this.dictionaryCode = dictionaryCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
}
