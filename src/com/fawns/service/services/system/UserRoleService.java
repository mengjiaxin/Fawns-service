/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserRoleService.java 
 *
 * Created: [2013-12-17 下午04:40:30] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午04:40:30
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system;

import java.util.List;

import com.fawns.service.entity.system.Role;
import com.fawns.service.entity.system.UserRole;

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

public interface UserRoleService {

	/**
	 * Description: 
	 * 添加用户角色关系信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-6 下午03:40:05
	 */
	
	void addUserRole(List<UserRole> userRoleList);

	/**
	 * Description: 
	 * 删除用户所属于的角色
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-7 下午01:48:30
	 */
	
	void deleteUserRole(String username);

	/**
	 * Description: 
	 * 根据用户名得到用户所属角色
	 * @param 
	 * @return List<UserRole>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-13 上午08:18:19
	 */
	
	List<Role> getUserRoles(String username);

	/**
	 * Description: 
	 * 删除角色与用户对应关系表信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-7 下午08:45:20
	 */
	
	void deleteRoleUser(int roleId);

}
