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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.fawns.service.entity.system.Department;
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.DepartmentService;
import com.fawns.service.services.system.LogService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.common.page.Page;
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
 * 2013-12-20    mawenqiang       1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/system/department")
public class DepartmentController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService departmentService;
	@Autowired
	LogService logService;
	private static final String ADD = "system/department/add";
	private static final String EDIT = "system/department/edit";
	private static final String VIEW = "system/department/view";
	private static final String LIST = "system/department/list";

	/**
	 * 
	 * Description: 
	 * ajax获取部门树
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	 @RequestMapping(value="/tree")   
	 public @ResponseBody Object tree(HttpSession session,HttpServletRequest request){   
		 	logger.info("查询部门树形结构开始");
			User user = getCurrentUser(request);
			//左侧部门树结构
			List departmentTree = departmentService.getDepartmentTree(user.getDepartmentId());
			logger.info("查询部门树形结构结束");
		 return departmentTree;
	 }   
	
	 /**
		 * 
		 * Description: 
		 * ajax获取部门树
		 * @param 
		 * @return String
		 * @throws Exception if has error
		 * @Author Administrator
		 * @Create Date: 2013-12-18 下午03:38:34
		 */
		 @RequestMapping(value="/treeWeb")   
		 public @ResponseBody Object treeWeb(HttpSession session,HttpServletRequest request){   
			 	logger.info("查询部门树形结构开始");
				//左侧部门树结构
				List departmentTree = departmentService.getDepartmentTree("");
				logger.info("查询部门树形结构结束");
			 return departmentTree;
		 } 
		 
	/**
	 * 
	 * Description: 
	 * 得到部门的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request,ConditionEntity conditionEntity ,@RequestParam (required=false)String departmentId,@RequestParam (required=false)String flag, Model model) {
		logger.info("查询部门列表开始");
		User user = getCurrentUser(request);
		String userDepartmentId = user.getDepartmentId(); //用户所属的部门ID
		Map<String,Object> params = new HashMap<String,Object>();
		//添加查询条件
		String useDepartmentId = ""; //程序所使用的部门ID
		if(null != departmentId && !"".equals(departmentId)){
			useDepartmentId = departmentId;
		}else{
			useDepartmentId = userDepartmentId;
		}
		params.put("id", useDepartmentId);
		params.put("keywords", conditionEntity.getKeywords());
		params.put("startDate", conditionEntity.getStartDate());
		params.put("endDate", conditionEntity.getEndDate());
		//获取总条数
		Long totalCount = departmentService.queryDepartmentNumByCondition(params);
		//设置分页对象
		Page page = executePage(request,totalCount);		
		//压入查询参数:开始位置与查询多少条数
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEveryPage());
		
		//查询集合		
		List<Department> departmentList = departmentService.queryDepartmentListByCondition(params);
		model.addAttribute("departmentId", useDepartmentId);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("vo", conditionEntity);
		model.addAttribute("flag", flag);
		logger.info("查询部门列表结束");
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到部门添加页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/add")
	public String add(Model model,@RequestParam (required=false)String flag) {
		logger.info("转到部门添加页面");
		model.addAttribute("flag", flag);
		return ADD;
	}
	
	/**
	 * 
	 * Description: 
	 * 部门添加处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request,Department department) {
		String supDepId = "";
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("部门添加处理开始");
			supDepId = department.getSupDepId();
			String departmentId = departmentService.getNewDepartmentIdBySupDepId(supDepId);
			department.setCreateDate(new Date());
			department.setCreateOperId(user.getUsername());
			department.setDepartmentId(departmentId);
			department.setSupDepId(supDepId);
			departmentService.addDepartment(department);
			//添加成功后把上级部门的部门级别该为不是最后一级，也就是把isend这个字段的值更新为1
			departmentService.updateDepartmentLevel(supDepId);
			flag = "addSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功添加了["+department.getName()+"]的部门信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("部门添加处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "addErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"添加["+department.getName()+"]的部门信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/department/add?flag="+flag;
		}
		return "redirect:/system/department/list?departmentId="+supDepId+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 部门删除
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:07:05
	 */
	@RequestMapping(value="/delete/{departmentId}/{supDepId}", method=RequestMethod.GET)
	public String delete(HttpServletRequest request,@PathVariable String departmentId,@PathVariable String supDepId) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("部门删除处理开始");
			departmentService.deleteDepartment(departmentId);
			flag = "deleteSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功删除了部门ID为["+departmentId+"]的部门信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("部门删除处理结束");
		} catch (Exception e) {
			flag = "deleteErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"删除部门ID为["+departmentId+"]的部门信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/department/list?departmentId="+supDepId+"&flag="+flag;
		}
		
		return "redirect:/system/department/list?departmentId="+supDepId+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 查看得到部门信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/view/{departmentId}", method=RequestMethod.GET)
	public String view(@PathVariable String departmentId, Map<String, Object> map) {
		Department department = departmentService.getDepartment(departmentId);
		map.put("department", department);
		return VIEW;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据departmentId得到部门信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(@RequestParam (required=true)String  departmentId,@RequestParam (required=false)String flag, Map<String, Object> map) {
		Department department = departmentService.getDepartment(departmentId);
		map.put("department", department);
		map.put("flag", flag);
		return EDIT;
	}
	
	/**
	 * 
	 * Description: 
	 * 部门修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:27:44
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String doEdit(HttpServletRequest request,Department department) {
		String flag = "";
		User user = getCurrentUser(request);
		try{
			department.setSupDepId(department.getSupDepId());
			department.setUpdateDate(new Date());
			department.setUpdateOperId(user.getUsername());
			departmentService.editDepartment(department);
			flag = "editSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功修改了["+department.getName()+"]的部门信息！" , "系统维护日志",user.getDepartmentId());
			//"部门修改成功！"
		}catch (Exception e) {
			flag = "editErr";
			e.printStackTrace();
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"修改了["+department.getName()+"]的部门信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/department/edit/"+department.getDepartmentId()+"/"+flag;
		}
		return "redirect:/system/department/list?departmentId="+department.getSupDepId()+"&flag="+flag;
	}
}
