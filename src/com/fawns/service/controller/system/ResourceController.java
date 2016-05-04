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
import java.util.Arrays;
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

import com.fawns.service.entity.system.Control;
import com.fawns.service.entity.system.Resource;
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.ControlService;
import com.fawns.service.services.system.LogService;
import com.fawns.service.services.system.ResourceService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.common.page.Page;
import com.fawns.service.util.DateUtil;

/** 
 *
 * Description: 
 * 资源管理
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
@RequestMapping("/system/resource")
public class ResourceController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);
	@Autowired
	ResourceService resourceService;
	@Autowired
	ControlService controlService;
	@Autowired
	LogService logService;
	private static final String ADD = "system/resource/add";
	private static final String EDIT = "system/resource/edit";
	private static final String VIEW = "system/resource/view";
	private static final String LIST = "system/resource/list";

	/**
	 * 
	 * Description: 
	 * ajax得到资源tree
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	 @RequestMapping(value="/tree")   
	 public @ResponseBody Object tree(HttpSession session){   
		 List<Resource> resourceTree = resourceService.getResourceTree();
		 return resourceTree;
	 }   
	 
	/**
	 * 
	 * Description: 
	 * 得到资源的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request,ConditionEntity conditionEntity,@RequestParam (required=false)String id,@RequestParam (required=false)String flag, Model model) {
		logger.info("查询资源列表开始");
		Map<String,Object> params = new HashMap<String,Object>();
		//添加查询条件
		params.put("id", id);
		params.put("keywords", conditionEntity.getKeywords());
		//获取总条数
		Long totalCount = resourceService.queryResourceNumByCondition(params);
		//设置分页对象
		Page page = executePage(request,totalCount);		
		//压入查询参数:开始位置与查询多少条数
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEveryPage());
		
		//查询集合		
		List<Resource> resourceList = resourceService.queryResourceListByCondition(params);
		
		model.addAttribute("resourceList", resourceList);
		model.addAttribute("id", id);
		model.addAttribute("vo", conditionEntity);
		model.addAttribute("flag", flag);
		logger.info("查询资源列表结束");
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到资源添加页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
	public String add(Model model,@RequestParam (required=false)String flag) {
		logger.info("转到资源添加页面");
		model.addAttribute("flag", flag);
		return ADD;
	}
	
	/**
	 * 
	 * Description: 
	 * 检测资源信息是否存在
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/checkResource/{resourceId}")
	public @ResponseBody Object checkResource(@PathVariable String resourceId,Model model) {
		Resource resource = resourceService.getResource(resourceId);
		return resource;
	}
	
	/**
	 * 
	 * Description: 
	 * 资源添加处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request,Resource resource) {
		String parentId = "";
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("资源添加处理开始");
			resource.setCreateDate(new Date());
			resource.setCreateOperId(user.getUsername());
			resourceService.addResource(resource);
			resourceService.updateResourceUrl(resource);//把上级资源的url更新为"#"号
			flag = "addSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功添加了["+resource.getName()+"]的资源信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("资源添加处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "addErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"添加["+resource.getName()+"]的资源信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/resource/add?flag="+flag;
		}
		return "redirect:/system/resource/list?id="+parentId+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 资源删除
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:07:05
	 */
	@RequestMapping(value="/delete/{resourceId}/{parentId}", method=RequestMethod.GET)
	public String delete(HttpServletRequest request,@PathVariable String resourceId,@PathVariable String parentId) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("资源删除处理开始");
			if(resourceId.equals("Base")){
				logger.info("根模块不能删除");
				flag = "baseFlag";
				return "redirect:/system/resource/list?id="+parentId+"&flag="+flag;
			}else{
				//删除资源信息
				resourceService.deleteResource(resourceId);
				//删除资源对应的control信息
				controlService.deleteControlByResId(resourceId);
			}
			flag = "deleteSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功删除了资源ID为["+resourceId+"]的资源信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("资源删除处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "deleteErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"删除了资源ID为["+resourceId+"]的资源信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/resource/list?id="+parentId+"&flag="+flag;
		}
		return "redirect:/system/resource/list?id="+parentId+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 查看得到资源信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/view/{resourceId}", method=RequestMethod.GET)
	public String view(@PathVariable String resourceId, Map<String, Object> map) {
		Resource resource = resourceService.getResource(resourceId);
		map.put("resource", resource);
		return VIEW;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据resourceId得到资源信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(@RequestParam (required=true)String resourceId, @RequestParam (required=false)String flag, Map<String, Object> map) {
		Resource resource = resourceService.getResource(resourceId);
		map.put("resource", resource);
		map.put("flag", flag);
		return EDIT;
	}
	
	/**
	 * 
	 * Description: 
	 * 资源修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:27:44
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String doEdit(HttpServletRequest request,Resource resource) {
		String flag = "";
		User user = getCurrentUser(request);
		try{
			resource.setUpdateDate(new Date());
			resource.setUpdateOperId(user.getUsername());
			resourceService.editResource(resource);
			flag = "editSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功修改了["+resource.getName()+"]的资源信息！" , "系统维护日志",user.getDepartmentId());
			//"资源修改成功！"
		}catch (Exception e) {
			flag = "editErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"修改["+resource.getName()+"]的资源信息时失败！" , "系统维护日志",user.getDepartmentId());
			e.printStackTrace();
			return "redirect:/system/resource/edit?resourceId="+resource.getId()+"&flag="+flag;
		}
		return "redirect:/system/resource/list?resourceId="+resource.getParentId()+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * ajax得到许可(permission)tree数据
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	 @RequestMapping(value="/treePer")   
	 public @ResponseBody Object treePer(@RequestParam (required=true)String operType,@RequestParam (required=false)String rolePermission){
		 List<Resource> permissionTree = new ArrayList<Resource>();
		 List<Resource> permissionTreeShow = new ArrayList<Resource>();
		 List<Resource> resourceList = resourceService.getResourceTree(); //得到所有资源信息
		 ConditionEntity conditionEntity = new ConditionEntity();
		 conditionEntity.setStatus("1");
		 List<Control> controlList = controlService.queryControlListByCondition(conditionEntity); //得到所有启用的control信息
		 Resource resourcePer = null;
		 //组装资源与许可的关系
		 if(null != resourceList && resourceList.size() > 0){
			 Resource resource = null;
			 for(int i=0; i < resourceList.size(); i++){
				 resource = (Resource)resourceList.get(i);
				 resource.setChecked("false");//初始化为不选
				 permissionTree.add(resource);
				 if(null != controlList && controlList.size() > 0){
					 Control control = null;
					 for(int j=0; j < controlList.size(); j++){
						 control = (Control)controlList.get(j);
						 if(control.getResourceId().equals(resource.getId())){
							 resourcePer = new Resource();
							 resourcePer.setId(control.getControlId());
							 resourcePer.setName(control.getName());
							 resourcePer.setParentId(resource.getId());
							 permissionTree.add(resourcePer);
						 }
					 }
				 }
			 }
		 }
		 
		//判断权限是否选中
		 if(!operType.equals("add")){ //判断操作类型，添加/查看/修改，只有是查看，修改的时候才需要判断是否选中
			 String[] rolePermissionArr = rolePermission.split(",");
			 Resource resource = null;
			 for(int k=0;k<permissionTree.size();k++){
				 resource = permissionTree.get(k);
				 if(Arrays.asList(rolePermissionArr).contains(resource.getId())){ //判断权限是否选中
					 resource.setChecked("true");
				 }else{
					 resource.setChecked("false");
				 }
				 permissionTreeShow.add(resource);
			 }
		 }else{
			 permissionTreeShow = permissionTree;
		 }
		 
		 return permissionTreeShow;
	 }   
}
