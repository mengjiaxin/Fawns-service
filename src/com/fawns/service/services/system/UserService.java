/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserService.java 
 *
 * Created: [2013-12-17 下午03:49:21] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午03:49:21
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system;

import java.util.List;
import java.util.Map;

import com.fawns.service.entity.system.User;

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

public interface UserService {
	
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
	List<User> queryUserListByCondition(Map<String,Object> params);

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
	Long queryUserNumByCondition(Map<String,Object> params);

	/**
	 * Description: 
	 * 用户添加
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午04:49:40
	 */
	
	void addUser(User user);

	/**
	 * Description: 
	 * 删除用户
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午01:55:01
	 */
	
	void deleteUser(String username);

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
	
	User getUser(String username);

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
	
	void editUser(User user);

	/**
	 * Description: 
	 * 密码修改
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-16 下午05:41:54
	 */
	
	void updatePwd(User user);

	/**
	 * Description: 
	 * 更新上次登录时间
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-8 上午01:07:09
	 */
	
	void upLastLoginTime(String username);

	/**
	 * Description: 
	 * 得到所有的用户信息
	 * @param 
	 * @return List<User>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-3-28 下午06:27:21
	 */
	
	List<User> queryAllUserList();
}
