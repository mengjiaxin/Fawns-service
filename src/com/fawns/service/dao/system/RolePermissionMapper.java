/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: RolePermissionMapper.java 
 *
 * Created: [2014-1-9 下午01:53:09] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-9 下午01:53:09
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.dao.system;

import java.util.List;

import com.fawns.service.entity.system.RolePermission;

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

public interface RolePermissionMapper {

	/**
	 * Description: 
	 * 角色对应权限保存
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-9 下午02:14:02
	 */
	
	void addRolePermission(List<RolePermission> rolePermissionList);

	/**
	 * Description: 
	 * 根据roleId得到角色所拥有的权限
	 * @param 
	 * @return RolePermission
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-9 下午03:24:17
	 */
	
	List<RolePermission> queryPermissionByRoleId(int roleId);

	/**
	 * Description: 
	 * 删除角色对应权限
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-9 下午03:43:54
	 */
	
	void deleteRolePermissionByRoleId(int roleId);

	/**
	 * Description: 
	 * 根据角色List得到角色对拥有的权限
	 * @param 
	 * @return List<RolePermission>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-14 下午02:49:11
	 */
	
	List<RolePermission> getRolePermissions(List<Integer> rolesList);

	/**
	 * Description: 
	 * 删除控件授权对应表信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-8 下午04:47:49
	 */
	
	void deleteControlPermissionByControldId(String controlId);

}
