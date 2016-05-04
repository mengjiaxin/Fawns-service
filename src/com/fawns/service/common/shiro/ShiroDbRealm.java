/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: ShiroDbRealm.java 
 *
 * Created: [2013-12-17 下午03:39:24] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午03:39:24
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fawns.service.entity.system.Role;
import com.fawns.service.entity.system.RolePermission;
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.RolePermissionService;
import com.fawns.service.services.system.UserRoleService;
import com.fawns.service.services.system.UserService;
import com.fawns.service.common.constant.Constants;

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

public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected UserRoleService userRoleService;
	
	@Autowired
	protected RolePermissionService rolePermissionService;
	
	/**
	 * 给ShiroDbRealm提供编码信息，用于密码密码比对
	 * 描述
	 */	
	public ShiroDbRealm() {
		super();
		//该句作用是重写shiro的密码验证，让shiro用我自己的验证   
    	setCredentialsMatcher(new CustomCredentialsMatcher());   
	}
    
	/**
	 *获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)throws AuthenticationException{
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken; 
		// 通过表单接收的用户名 
		String username = token.getUsername(); 
		if (username != null && !"".equals(username)){
			User user = userService.getUser(token.getUsername());
			if (user != null) {
				if (user.getStatus().equals("0")) {
					throw new DisabledAccountException();
				}else{
					Subject subject=SecurityUtils.getSubject();
					subject.getSession().setAttribute(Constants.SessionKey.CURRENT_USER, user);
					return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),this.getName());
				}
			} else {
				return null;
			}
		}else{
			return null;
		}
		
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.fromRealm(getName()).iterator().next();
		User user = userService.getUser(username);
		List<Role> userRoles = userRoleService.getUserRoles(user.getUsername());
		List<Integer> userRolesList = new ArrayList<Integer>();
		for (Role userRole : userRoles) {
			userRolesList.add(userRole.getId());
		}
		List<RolePermission> rolePermissions = rolePermissionService.getRolePermissions(userRolesList);
		if (!rolePermissions.isEmpty()) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			String permission = "";
			for (RolePermission rolePermission : rolePermissions) {
				//基于Permission的权限信息,shiro权限字符串为：“当前资源英文名称:操作名英文名称”
				permission = rolePermission.getPermission();
				if(permission.indexOf(":")!=-1){ //判断字符串中是否包含:号，如果包含
					info.addStringPermission(permission);
				}
			}
			return info;
		} else {
			return null;
		}
	}
	
	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
	
}

