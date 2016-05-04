/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentServiceImpl.java 
 *
 * Created: [2013-12-20 下午06:06:36] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:36
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fawns.service.dao.system.RoleMapper;
import com.fawns.service.entity.system.Role;
import com.fawns.service.services.system.RoleService;

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

@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	RoleMapper roleMapper;
	
	/**
	 * Description: 
	 * 根据条件得到角色列表
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public List<Role> queryRoleListByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleListByCondition(params);
	}
	
	/**
	 * Description: 
	 * 根据条件得到角色列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public Long queryRoleNumByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleNumByCondition(params);
	}
	
	/**
	 * Description: 
	 * 角色添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.addRole(role);
	}

	/**
	 * Description: 
	 * 角色删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	@Override
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		roleMapper.deleteRole(id);
	}
	
	/**
	 * Description: 
	 * 角色修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	@Override
	public void editRole(Role role) {
		// TODO Auto-generated method stub
		roleMapper.editRole(role);
	}
	
	/**
	 * Description: 
	 * 根据id得到角色信息
	 * @param 
	 * @return Role
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	@Override
	public Role getRole(int id) {
		// TODO Auto-generated method stub
		return roleMapper.getRole(id);
	}

	/**
	 * Description: 
	 * 得到用户所拥有的角色
	 * @param 
	 * @return List<Role>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-6 下午05:52:43
	 */
	@Override
	public List<Role> queryUserHaveRoleList(String username) {
		// TODO Auto-generated method stub
		return roleMapper.queryUserHaveRoleList(username);
	}

	/**
	 * Description: 
	 * 根据角色状态得到角色信息
	 * @param 
	 * @return List<Role>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-6 下午12:57:50
	 */
	@Override
	public List<Role> queryRoleListByStatus(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleListByStatus(paramMap);
	}
}
