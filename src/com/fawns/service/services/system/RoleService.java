/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentService.java 
 *
 * Created: [2013-12-20 下午06:06:22] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:22
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system;

import java.util.List;
import java.util.Map;

import com.fawns.service.entity.system.Role;

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
 * 2013-12-20    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public interface RoleService {

	/**
	 * Description: 
	 * 根据条件得到角色列表
	 * @param 
	 * @return List<Control>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:03
	 */
	
	List<Role> queryRoleListByCondition(
			Map<String,Object> params);
	
	/**
	 * Description: 
	 * 根据条件得到角色列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	
	Long queryRoleNumByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 角色添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	
	void addRole(Role role);
	
	/**
	 * Description: 
	 * 角色删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	
	void deleteRole(int id);

	/**
	 * Description: 
	 * 根据roleId和resourceId得到角色信息
	 * @param 
	 * @return role
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	
	Role getRole(int id);

	/**
	 * Description: 
	 * 角色修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	
	void editRole(Role role);

	/**
	 * Description: 
	 * 得到用户所拥有的角色
	 * @param 
	 * @return List<Role>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-6 下午05:52:43
	 */
	
	List<Role> queryUserHaveRoleList(String username);

	/**
	 * Description: 
	 * 根据角色状态得到角色信息
	 * @param 
	 * @return List<Role>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-6 下午12:57:50
	 */
	
	List<Role> queryRoleListByStatus(Map<String, Object> paramMap);
}
