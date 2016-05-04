/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: Role.java 
 *
 * Created: [2013-12-17 下午03:48:15] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午03:48:15
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
 *
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-17    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3123755206720561805L;
	private int id;
	private String name;
	private String description;
	private String status;
	private Date   createDate;
	private String createOperId;
	private Date   updateDate;
	private String updateOperId;
	private String permissionIds; //选择权限所需
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
}
