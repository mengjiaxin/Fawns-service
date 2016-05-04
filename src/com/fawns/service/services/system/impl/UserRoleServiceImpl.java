/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserRoleImpl.java 
 *
 * Created: [2013-12-17 下午04:40:43] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午04:40:43
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fawns.service.dao.system.UserRoleMapper;
import com.fawns.service.entity.system.Role;
import com.fawns.service.entity.system.UserRole;
import com.fawns.service.services.system.UserRoleService;

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

@Service
@Transactional(readOnly=true)
public class UserRoleServiceImpl implements UserRoleService {
	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	@Autowired
	UserRoleMapper userRoleMapper;
	
	/**
	 * Description: 
	 * 添加用户角色关系信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-6 下午03:40:05
	 */
	@Override
	public void addUserRole(List<UserRole> userRoleList) {
		// TODO Auto-generated method stub
		userRoleMapper.addUserRole(userRoleList);
	}

	/**
	 * Description: 
	 * 删除用户所属于的角色
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-7 下午01:48:30
	 */
	@Override
	public void deleteUserRole(String username) {
		// TODO Auto-generated method stub
		userRoleMapper.deleteUserRole(username);
	}

	/**
	 * Description: 
	 * 根据用户名得到用户所属角色
	 * @param 
	 * @return List<UserRole>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-13 上午08:18:19
	 */
	@Override
	public List<Role> getUserRoles(String username) {
		// TODO Auto-generated method stub
		return userRoleMapper.getUserRoles(username);
	}

	/**
	 * Description: 
	 * 删除角色与用户对应关系表信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-7 下午08:45:20
	 */
	@Override
	public void deleteRoleUser(int roleId) {
		// TODO Auto-generated method stub
		userRoleMapper.deleteRoleUser(roleId);
	}
}
