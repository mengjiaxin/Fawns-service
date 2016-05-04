/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: RolePermissionServiceImpl.java 
 *
 * Created: [2014-1-9 下午01:52:17] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-9 下午01:52:17
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

import com.fawns.service.dao.system.RolePermissionMapper;
import com.fawns.service.entity.system.RolePermission;
import com.fawns.service.services.system.RolePermissionService;

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

@Service
@Transactional(readOnly=true)
public class RolePermissionServiceImpl implements RolePermissionService {
	private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);
	@Autowired
	RolePermissionMapper rolePermissionMapper;
	/**
	 * Description: 
	 * 角色对应权限保存
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-9 下午02:14:02
	 */
	@Override
	public void addRolePermission(List<RolePermission> rolePermissionList) {
		// TODO Auto-generated method stub
		rolePermissionMapper.addRolePermission(rolePermissionList);
	}
	
	/**
	 * Description: 
	 * 根据roleId得到角色所拥有的权限
	 * @param 
	 * @return RolePermission
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-9 下午03:24:17
	 */
	@Override
	public List<RolePermission> queryPermissionByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.queryPermissionByRoleId(roleId);
	}

	/**
	 * Description: 
	 * 删除角色对应权限
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-9 下午03:43:54
	 */
	@Override
	public void deleteRolePermissionByRoleId(int roleId) {
		// TODO Auto-generated method stub
		rolePermissionMapper.deleteRolePermissionByRoleId(roleId);
	}

	/**
	 * Description: 
	 * 根据角色List得到角色对拥有的权限
	 * @param 
	 * @return List<RolePermission>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-14 下午02:49:11
	 */
	@Override
	public List<RolePermission> getRolePermissions(List<Integer> rolesList) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.getRolePermissions(rolesList);
	}

	/**
	 * Description: 
	 * 删除控件授权对应表信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-8 下午04:47:05
	 */
	@Override
	public void deleteControlPermissionByControldId(String controlId) {
		// TODO Auto-generated method stub
		rolePermissionMapper.deleteControlPermissionByControldId(controlId);
	}
}
