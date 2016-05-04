/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserController.java 
 *
 * Created: [2013-12-18 下午03:32:23] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-18 下午03:32:23
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fawns.service.entity.system.Role;
import com.fawns.service.entity.system.User;
import com.fawns.service.entity.system.UserRole;
import com.fawns.service.services.system.LogService;
import com.fawns.service.services.system.RoleService;
import com.fawns.service.services.system.UserRoleService;
import com.fawns.service.services.system.UserService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.common.page.Page;
import com.fawns.service.common.shiro.CustomCredentialsMatcher;
import com.fawns.service.util.DateUtil;

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
 * 2013-12-18    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	LogService logService;
	
	private static final String ADD = "system/user/add";
	private static final String EDIT = "system/user/edit";
	private static final String VIEW = "system/user/view";
	private static final String LIST = "system/user/list";
	private static final String UPDATE_PASSWORD = "system/user/updatePwd";
	
	/**
	 * 
	 * Description: 
	 * 得到用户的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request,ConditionEntity conditionEntity,@RequestParam (required=false)String flag, Model model) {
		logger.info("查询用户列表开始");
		Map<String,Object> params = new HashMap<String,Object>();
		//添加查询条件
		params.put("keywords", conditionEntity.getKeywords());
		params.put("status", conditionEntity.getStatus());
		params.put("startDate", conditionEntity.getStartDate());
		params.put("endDate", conditionEntity.getEndDate());
		//获取总条数
		Long totalCount = userService.queryUserNumByCondition(params);
		//设置分页对象
		Page page = executePage(request,totalCount);		
		//如排序
		if(page.isSort()){
			params.put("orderName",page.getSortName());	
			params.put("descAsc",page.getSortState());
		}else{
			//没有进行排序,默认排序方式
			params.put("orderName","u.createtime");	
			params.put("descAsc","desc");
		}
		//压入查询参数:开始位置与查询多少条数
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEveryPage());
		
		//查询集合		
		List<User> userList = userService.queryUserListByCondition(params);
		
		model.addAttribute("userList", userList);
		model.addAttribute("vo", conditionEntity);
		model.addAttribute("flag", flag);
		logger.info("查询用户列表结束");
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到用户添加页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		logger.info("转到用户添加页面");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("status", "1");//状态为启用的角色
		List<Role> roleList = roleService.queryRoleListByStatus(paramMap);
		
		model.addAttribute("roleList", roleList);
		return ADD;
	}
	
	/**
	 * 
	 * Description: 
	 * 检测用户信息是否存在
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/checkUser/{username}")
	public @ResponseBody Object checkUser(@PathVariable String username,Model model) {
		User user = userService.getUser(username);
		return user;
	}
	
	/**
	 * 
	 * Description: 
	 * 用户添加处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request,User user) {
		String flag = "";
		User curUser = getCurrentUser(request);
		try {
			logger.info("用户添加处理开始");
			String[] roleIds = user.getRoleIds();
			List<UserRole> userRoleList = new ArrayList<UserRole>();
			UserRole userRole = null;
			if(null!=roleIds && !"".equals(roleIds)){//不为空，说明选择了角色,格式为：(角色代码-角色名称)17-fsdaf,18-fsaf,19-fsdaf
				for(int i=0;i<roleIds.length;i++){
					userRole = new UserRole();
					userRole.setRoleId(Integer.parseInt(roleIds[i]));
					userRole.setUserId(user.getUsername());
					userRole.setCreateDate(new Date());
					userRole.setCreateOperId(curUser.getUsername());
					userRoleList.add(userRole);
				}
				//添加用户角色关系信息
				userRoleService.addUserRole(userRoleList);
			}
			//添加用户信息
			CustomCredentialsMatcher ccm = new CustomCredentialsMatcher();
			user.setPassword(ccm.encrypt(user.getPassword()));
			user.setDepartmentId(user.getDepartmentId());
			user.setCreatetime(new Date());
			user.setCreateoperator(curUser.getUsername());
			userService.addUser(user);
			flag = "addSuc";
			logService.saveLog(curUser.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, curUser.getRealname()+"在"+DateUtil.getCurrentTime()+"成功新增了["+user.getUsername()+"-"+user.getRealname()+"]的用户信息！" , "系统维护日志",curUser.getDepartmentId());
			logger.info("用户添加处理结束");
		} catch (Exception e) {
			flag = "addErr";
			logService.saveLog(curUser.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, curUser.getRealname()+"在"+DateUtil.getCurrentTime()+"新增["+user.getUsername()+"-"+user.getRealname()+"]的用户信息时失败！" , "系统维护日志",curUser.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/user/list?flag="+flag;
		}
		return "redirect:/system/user/list?flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据username得到用户信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/view/{username}", method=RequestMethod.GET)
	public String view(@PathVariable String username, Map<String, Object> map) {
		User user = userService.getUser(username);
		//得到用户所拥有的角色
		List<Role> userHaveRoleList = roleService.queryUserHaveRoleList(username);
		map.put("user", user);
		map.put("userHaveRoleList", userHaveRoleList);
		return VIEW;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据username得到用户信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/edit/{username}", method=RequestMethod.GET)
	public String edit(@PathVariable String username, Map<String, Object> map) {
		User user = userService.getUser(username);
		//得到用户所拥有的角色
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("status", "1");
		List<Role> allRoleList = roleService.queryRoleListByStatus(paramMap);
		List<Role> userHaveRoleList = roleService.queryUserHaveRoleList(username);
		map.put("user", user);
		map.put("allRoleList", allRoleList);
		map.put("userHaveRoleList", userHaveRoleList);
		return EDIT;
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
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String update(HttpServletRequest request,User user) {
		String flag = "";
		User curUser = getCurrentUser(request);
		try{
			String[] roleIds = user.getRoleIds();
			//删除用户所属于的角色
			userRoleService.deleteUserRole(user.getUsername());
			//添加修改后的角色
			String userId = user.getUsername();
			List<UserRole> userRoleList = new ArrayList<UserRole>();
			UserRole userRole = null;
			if(null!=roleIds && !"".equals(roleIds)){//不为空，说明选择了角色,格式为：(角色代码-角色名称)17-fsdaf,18-fsaf,19-fsdaf
				for(int i=0;i<roleIds.length;i++){
					userRole = new UserRole();
					userRole.setRoleId(Integer.parseInt(roleIds[i]));
					userRole.setUserId(userId);
					userRole.setCreateDate(new Date());
					userRole.setCreateOperId(curUser.getUsername());
					userRoleList.add(userRole);
				}
				//添加用户角色关系信息
				userRoleService.addUserRole(userRoleList);
			}
			//修改用户信息
			user.setDepartmentId(user.getDepartmentId());
			user.setUpdatetime(new Date());
			user.setUpdateoperator(curUser.getUsername());
			userService.editUser(user);
			flag = "editSuc";
			logService.saveLog(curUser.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, curUser.getRealname()+"在"+DateUtil.getCurrentTime()+"成功修改了["+user.getUsername()+"-"+user.getRealname()+"]的用户信息！" , "系统维护日志",curUser.getDepartmentId());
			//"用户修改成功！"
		}catch (Exception e) {
			flag = "editErr";
			logService.saveLog(curUser.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, curUser.getRealname()+"在"+DateUtil.getCurrentTime()+"修改["+user.getUsername()+"-"+user.getRealname()+"]的用户信息时失败！" , "系统维护日志",curUser.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/user/list?flag="+flag;
		}
		return "redirect:/system/user/list?flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 用户删除
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:07:05
	 */
	@RequestMapping(value="/delete/{username}", method=RequestMethod.GET)
	public String delete(HttpServletRequest request,@PathVariable String username) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("用户删除处理开始");
			//删除用户
			userService.deleteUser(username);
			//删除用户与角色对应关系
			userRoleService.deleteUserRole(username);
			//"用户删除成功！";
			flag = "deleteSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功删除了["+username+"]的用户信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("用户删除处理结束");
		} catch (Exception e) {
			flag = "deleteErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"删除["+username+"]的用户信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/user/list?flag="+flag;
		}
		return "redirect:/system/user/list?flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到密码修改页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-16 下午03:27:49
	 */
	@RequestMapping(value="/preUpdatePwd", method=RequestMethod.GET)
	public String preUpdatePwd() {
		return UPDATE_PASSWORD;
	}
	
	/**
	 * 
	 * Description: 
	 * 密码修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-16 下午03:28:00
	 */
	@RequestMapping(value="/doUpdatePwd", method=RequestMethod.POST)
	public @ResponseBody String doUpdatePwd(HttpServletRequest request, String newPassword, String confirmPassword) {
		String flag = "";
		try{
			User user = (User)request.getSession().getAttribute(Constants.SessionKey.CURRENT_USER);
			if (newPassword.equals(confirmPassword)) {
				CustomCredentialsMatcher ccm = new CustomCredentialsMatcher();
				user.setPassword(ccm.encrypt(newPassword));
				userService.updatePwd(user);
				//"密码修改成功！"
				flag = "updatePwdSuc";
			}
		}catch (Exception e) {
			flag = "updatePwdErr";
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 密码重置处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-2-12 下午08:48:05
	 */
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	public @ResponseBody Object resetPwd(@RequestParam (required=true)String username, Model model,HttpServletRequest request){
			String flag = "";
			User curUser = getCurrentUser(request);
			try {
				logger.info("密码重置处理开始");
	    		//密码重置处理
				CustomCredentialsMatcher ccm = new CustomCredentialsMatcher();
				User user = new User();
				user.setUsername(username);
				user.setPassword(ccm.encrypt("888888"));
				userService.updatePwd(user);
				//密码重置成功！
				flag = "resetPwdSuc";
				logService.saveLog(curUser.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, curUser.getRealname()+"在"+DateUtil.getCurrentTime()+"成功重置了["+username+"]的密码！" , "系统维护日志",curUser.getDepartmentId());
				logger.info("密码重置处理结束");
			} catch (Exception e) {
				flag = "resetPwdErr";
				logService.saveLog(curUser.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, curUser.getRealname()+"在"+DateUtil.getCurrentTime()+"重置["+username+"]的密码时失败！" , "系统维护日志",curUser.getDepartmentId());
				e.printStackTrace();
			}
			return flag;
	 }
}
