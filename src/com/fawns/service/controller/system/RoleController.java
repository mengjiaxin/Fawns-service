/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentController.java 
 *
 * Created: [2013-12-20 下午05:29:43] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午05:29:43
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

import com.fawns.service.entity.system.Role;
import com.fawns.service.entity.system.RolePermission;
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.LogService;
import com.fawns.service.services.system.RolePermissionService;
import com.fawns.service.services.system.RoleService;
import com.fawns.service.services.system.UserRoleService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.common.page.Page;
import com.fawns.service.util.DateUtil;

/** 
 *
 * Description: 
 * 角色管理
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-20    mawenqiang       1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	RoleService roleService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	LogService logService;
	private static final String ADD = "system/role/add";
	private static final String EDIT = "system/role/edit";
	private static final String VIEW = "system/role/view";
	private static final String LIST = "system/role/list";

	/**
	 * 
	 * Description: 
	 * 得到角色的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request,ConditionEntity conditionEntity,@RequestParam (required=false)String flag, Model model) {
		logger.info("查询角色列表开始");
		Map<String,Object> params = new HashMap<String,Object>();
		//添加查询条件
		params.put("keywords", conditionEntity.getKeywords());
		params.put("status", conditionEntity.getStatus());
		params.put("startDate", conditionEntity.getStartDate());
		params.put("endDate", conditionEntity.getEndDate());
		
		//获取总条数
		Long totalCount = roleService.queryRoleNumByCondition(params);
		//设置分页对象
		Page page = executePage(request,totalCount);		
		//如排序
		if(page.isSort()){
			params.put("orderName",page.getSortName());	
			params.put("descAsc",page.getSortState());
		}else{
			//没有进行排序,默认排序方式
			params.put("orderName","r.createtime");	
			params.put("descAsc","desc");
		}
		//压入查询参数:开始位置与查询多少条数
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEveryPage());
		
		//查询集合		
		List<Role> roleList = roleService.queryRoleListByCondition(params);
		model.addAttribute("roleList", roleList);
		model.addAttribute("vo", conditionEntity);
		model.addAttribute("flag", flag);
		logger.info("查询角色列表结束");
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到角色添加页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
	public String add(Model model) {
		logger.info("转到角色添加页面");
		return ADD;
	}
	
	/**
	 * 
	 * Description: 
	 * 角色添加处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request,Role role) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("角色添加处理开始");
			role.setCreateDate(new Date());
			role.setCreateOperId(user.getUsername());
			roleService.addRole(role);
			//角色权限关系对应数据
			String permissionIds = role.getPermissionIds();//得到添加角色时所分配的权限
			if(null != permissionIds && !"".equals(permissionIds)){ //User,User:Add,User:Delete,User:Update,User:Query
				String[] permissionId = permissionIds.split(",");
				if(null != permissionId && permissionId.length > 0){
					List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
					RolePermission rolePermissionSave = null;
					for(int i=0;i<permissionId.length;i++){
						rolePermissionSave = new RolePermission();
						rolePermissionSave.setRoleId(role.getId());
						rolePermissionSave.setCreateDate(new Date());
						rolePermissionSave.setCreateOperId(user.getUsername());
						rolePermissionSave.setPermission(permissionId[i]);
						rolePermissionList.add(rolePermissionSave);
					}
					//角色对应权限保存
					rolePermissionService.addRolePermission(rolePermissionList);
				}
			}
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功添加了["+role.getName()+"]的角色信息！" , "系统维护日志",user.getDepartmentId());
			flag = "addSuc";
			logger.info("角色添加处理结束");
		} catch (Exception e) {
			flag = "addErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"添加["+role.getName()+"]的角色信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/role/add?flag="+flag;
		}
		return "redirect:/system/role/list?flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 角色删除
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:07:05
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(HttpServletRequest request,@PathVariable String id) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("角色删除处理开始");
			//删除角色表信息
			roleService.deleteRole(Integer.parseInt(id));
			//删除角色与用户对应关系表信息
			userRoleService.deleteRoleUser(Integer.parseInt(id));
			//删除角色与权限对应关系信息
			rolePermissionService.deleteRolePermissionByRoleId(Integer.parseInt(id));
			//"角色删除成功！"
			flag = "deleteSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功删除了角色ID为["+id+"]的角色信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("角色删除处理结束");
		} catch (Exception e) {
			flag = "deleteErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"删除了角色ID为["+id+"]的角色信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/role/list?flag="+flag;
		}
		return "redirect:/system/role/list?flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 根据id得到角色信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@RequestParam (required=true)String id, Map<String, Object> map) {
		Role role = roleService.getRole(Integer.parseInt(id)); //得到角色信息
		List<RolePermission> rolePermissionList = rolePermissionService.queryPermissionByRoleId(role.getId()); //得到角色所拥有的权限
		StringBuffer rolePermissionBuf = new StringBuffer();
		String rolePermissionShow = "";
		if(null != rolePermissionList && rolePermissionList.size() > 0){
			RolePermission rolePermission = null;
			for(int i=0;i<rolePermissionList.size();i++ ){
				rolePermission = (RolePermission)rolePermissionList.get(i);
				rolePermissionBuf.append(rolePermission.getPermission());
				rolePermissionBuf.append(",");
			}
			rolePermissionShow = rolePermissionBuf.toString().substring(0,rolePermissionBuf.toString().length()-1);
		}
		map.put("role", role);
		map.put("rolePermissionShow", rolePermissionShow);
		return VIEW;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据id得到角色信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(@RequestParam (required=true)String id,@RequestParam (required=false)String flag, Map<String, Object> map) {
		Role role = roleService.getRole(Integer.parseInt(id)); //得到角色信息
		List<RolePermission> rolePermissionList = rolePermissionService.queryPermissionByRoleId(role.getId()); //得到角色所拥有的权限
		StringBuffer rolePermissionBuf = new StringBuffer();
		String rolePermissionShow = "";
		if(null != rolePermissionList && rolePermissionList.size() > 0){
			RolePermission rolePermission = null;
			for(int i=0;i<rolePermissionList.size();i++ ){
				rolePermission = (RolePermission)rolePermissionList.get(i);
				rolePermissionBuf.append(rolePermission.getPermission());
				rolePermissionBuf.append(",");
			}
			rolePermissionShow = rolePermissionBuf.toString().substring(0,rolePermissionBuf.toString().length()-1);
		}
		map.put("role", role);
		map.put("rolePermissionShow", rolePermissionShow);
		return EDIT;
	}
	
	/**
	 * 
	 * Description: 
	 * 角色修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:27:44
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String doEdit(HttpServletRequest request,Role role) {
		String flag = "";
		User user = getCurrentUser(request);
		try{
			role.setUpdateDate(new Date());
			role.setUpdateOperId(user.getUsername());
			roleService.editRole(role);
			//处理权限相关
			rolePermissionService.deleteRolePermissionByRoleId(role.getId()); //删除角色对应权限
			//添加角色对应权限
			String permissionIds = role.getPermissionIds();//得到添加角色时所分配的权限
			if(null != permissionIds && !"".equals(permissionIds)){ //User,User:Add,User:Delete,User:Update,User:Query
				String[] permissionId = permissionIds.split(",");
				if(null != permissionId && permissionId.length > 0){
					List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
					RolePermission rolePermissionSave = null;
					for(int i=0;i<permissionId.length;i++){
						rolePermissionSave = new RolePermission();
						rolePermissionSave.setRoleId(role.getId());
						rolePermissionSave.setCreateDate(new Date());
						rolePermissionSave.setCreateOperId(user.getUsername());
						rolePermissionSave.setPermission(permissionId[i]);
						rolePermissionList.add(rolePermissionSave);
					}
					//角色对应权限保存
					rolePermissionService.addRolePermission(rolePermissionList);
				}
			}
			flag = "editSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功修改了["+role.getName()+"]的角色信息！" , "系统维护日志",user.getDepartmentId());
			//"角色修改成功！"
		}catch (Exception e) {
			flag = "editErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"修改["+role.getName()+"]的角色信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/role/edit?id="+role.getId()+"&flag="+flag;
		}
		return "redirect:/system/role/list?flag="+flag;
	}
}
