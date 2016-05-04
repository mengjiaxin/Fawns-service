/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserServiceImpl.java 
 *
 * Created: [2013-12-17 下午03:49:41] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午03:49:41
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

import com.fawns.service.dao.system.UserMapper;
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.UserService;
import com.fawns.service.common.shiro.ShiroDbRealm;

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
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	private ShiroDbRealm shiroRealm;
	
	/**
	 * 
	 * Description: 
	 * 根据条件得到用户列表
	 * @param 
	 * @return List<User>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 上午10:34:34
	 */
	public List<User> queryUserListByCondition(Map<String,Object> params) {
		List<User> userList = userMapper.queryUserListByCondition(params);
		return userList;
	}

	/**
	 * 
	 * Description: 
	 * 根据条件得到用户总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 上午10:34:44
	 */
	public Long queryUserNumByCondition(Map<String,Object> params) {
		Long count = userMapper.queryUserNumByCondition(params);
		return count;
	}

	/**
	 * 
	 * Description: 
	 * 用户添加
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 上午10:34:44
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
		shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
	}

	/**
	 * Description: 
	 * 删除用户
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午01:55:01
	 */
	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(username);
	}

	/**
	 * 
	 * Description: 
	 * 根据username得到用户信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.getUser(username);
	}

	/**
	 * 
	 * Description: 
	 * 用户修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:27:44
	 */
	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		userMapper.editUser(user);
		shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
	}

	/**
	 * Description: 
	 * 密码修改
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-16 下午05:41:54
	 */
	@Override
	public void updatePwd(User user) {
		// TODO Auto-generated method stub
		userMapper.updatePwd(user);
	}

	/**
	 * Description: 
	 * 更新上次登录时间
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-8 上午01:07:09
	 */
	@Override
	public void upLastLoginTime(String username) {
		// TODO Auto-generated method stub
		userMapper.upLastLoginTime(username);
	}

	/**
	 * Description: 
	 * 得到所有的用户信息
	 * @param 
	 * @return List<User>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-28 下午06:27:21
	 */
	@Override
	public List<User> queryAllUserList() {
		// TODO Auto-generated method stub
		return userMapper.queryAllUserList();
	}
}
