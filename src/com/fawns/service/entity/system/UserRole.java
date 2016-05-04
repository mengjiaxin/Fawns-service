/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserRole.java 
 *
 * Created: [2013-12-17 下午04:39:51] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午04:39:51
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

public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1049482081724478753L;
	private int roleId;
	private String userId;
	private Date   createDate;
	private String createOperId;
	private Date   updateDate;
	private String updateOperId;
	
	private Role role;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
