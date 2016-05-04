/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: Department.java 
 *
 * Created: [2013-12-20 下午06:06:52] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:52
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
 * 部门管理实体
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-20    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400701159073113099L;
	
	private String departmentId;
	private String name;
	private String supDepId;
	private String manager;
	private String address;
	private String telphone;
	private String mgrPhone;
	private String remark;
	private Date   createDate;
	private String createOperId;
	private Date   updateDate;
	private String updateOperId;
	private String supDepName;
	private String isEnd;
	
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSupDepId() {
		return supDepId;
	}
	public void setSupDepId(String supDepId) {
		this.supDepId = supDepId;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getMgrPhone() {
		return mgrPhone;
	}
	public void setMgrPhone(String mgrPhone) {
		this.mgrPhone = mgrPhone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getSupDepName() {
		return supDepName;
	}
	public void setSupDepName(String supDepName) {
		this.supDepName = supDepName;
	}
	public String getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}
}
