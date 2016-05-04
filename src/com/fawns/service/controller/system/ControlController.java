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
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.ControlService;
import com.fawns.service.services.system.LogService;
import com.fawns.service.services.system.RolePermissionService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.util.DateUtil;

/** 
 *
 * Description: 
 * 控件管理
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
@RequestMapping("/system/control")
public class ControlController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ControlController.class);
	@Autowired
	ControlService controlService;
	@Autowired
	RolePermissionService rolePermissionService;
	@Autowired
	LogService logService;
	private static final String ADD = "system/control/add";
	private static final String EDIT = "system/control/edit";
	private static final String VIEW = "system/control/view";
	private static final String LIST = "system/control/list";

	/**
	 * 
	 * Description: 
	 * 得到控件的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(ConditionEntity conditionEntity ,@RequestParam (required=true)String resourceId,@RequestParam (required=false)String flag, Model model) {
		try{
			logger.info("查询控件列表开始");
			conditionEntity.setResourceId(resourceId);
			List<Control> controlList = controlService.queryControlListByCondition(conditionEntity);
			model.addAttribute("vo", conditionEntity);
			model.addAttribute("controlList", controlList);
			model.addAttribute("flag", flag);
			logger.info("查询控件列表结束");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到控件添加页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.GET})
	public String add(@RequestParam (required=true)String resourceId,@RequestParam (required=false)String flag,Model model) {
		logger.info("转到控件添加页面");
		model.addAttribute("resourceId", resourceId);
		model.addAttribute("flag", flag);
		return ADD;
	}
	
	/**
	 * 
	 * Description: 
	 * 检测该资源下的控件信息是否存在
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/checkControl/{controlId}/{resourceId}")
	public @ResponseBody Object checkDictionary(@PathVariable String controlId,@PathVariable String resourceId,Model model) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("controlId", resourceId + ":" + controlId);
		map.put("resourceId", resourceId);
		Control control = controlService.checkControl(map);
		return control;
	}
	
	/**
	 * 
	 * Description: 
	 * 控件添加处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, Control control) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("控件添加处理开始");
			control.setCreateDate(new Date());
			control.setCreateOperId(user.getUsername());
			control.setControlId(control.getResourceId()+":"+control.getControlId()); //格式resourceId:controlId作为controlId如Role:Add
			controlService.addControl(control);
			flag = "addSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功添加了["+control.getResourceId()+"-"+control.getName()+"]的控件信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("控件添加处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "addErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"添加["+control.getResourceId()+"-"+control.getName()+"]的控件信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/control/add?resourceId="+control.getResourceId()+"&flag="+flag;
		}
		return "redirect:/system/control/list?resourceId="+control.getResourceId()+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 控件删除
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:07:05
	 */
	@RequestMapping(value="/delete/{resourceId}/{id}/{controlId}", method=RequestMethod.GET)
	public String delete(HttpServletRequest request,@PathVariable String resourceId,@PathVariable String id,@PathVariable String controlId) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("控件删除处理开始");
			//删除控件表信息
			controlService.deleteControl(Integer.parseInt(id));
			//删除控件授权对应表信息
			rolePermissionService.deleteControlPermissionByControldId(controlId);
			flag = "deleteSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功删除了["+resourceId+"-"+id+"]的控件信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("控件删除处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "deleteErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"删除["+resourceId+"-"+id+"]的控件信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/control/list?resourceId="+resourceId+"&flag="+flag;
		}
		//控件删除成功！
		return "redirect:/system/control/list?resourceId="+resourceId+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 根据controlId得到控件信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(@RequestParam (required=true)String id,Map<String, Object> map) {
		Control control = controlService.getControl(Integer.parseInt(id));
		map.put("control", control);
		return VIEW;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据controlId得到控件信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(@RequestParam (required=true)String id,@RequestParam (required=false)String flag, Map<String, Object> map) {
		Control control = controlService.getControl(Integer.parseInt(id));
		map.put("control", control);
		map.put("flag", flag);
		return EDIT;
	}
	
	/**
	 * 
	 * Description: 
	 * 控件修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:27:44
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String doEdit(HttpServletRequest request,Control control) {
		String flag = "";
		User user = getCurrentUser(request);
		try{
			logger.info("控件修改处理开始");
			control.setUpdateDate(new Date());
			control.setUpdateOperId(user.getUsername());
			controlService.editControl(control);
			flag = "editSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功修改了["+control.getResourceId()+"-"+control.getName()+"]的控件信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("控件修改处理结束");
		}catch (Exception e) {
			e.printStackTrace();
			flag = "editErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"修改["+control.getResourceId()+"-"+control.getName()+"]的控件信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/control/edit?id="+control.getId()+"&flag="+flag;
		}
		return "redirect:/system/control/list?resourceId="+control.getResourceId()+"&flag="+flag;
	}
}
