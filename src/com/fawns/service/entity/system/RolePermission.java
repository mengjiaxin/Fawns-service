/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: RolePermission.java 
 *
 * Created: [2014-1-9 下午01:55:06] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-9 下午01:55:06
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
 * 2014-1-9    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class RolePermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3458729425073763463L;

	private int roleId;
	private String permission;
	private Date   createDate;
	private String createOperId;
	private Date   updateDate;
	private String updateOperId;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
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
