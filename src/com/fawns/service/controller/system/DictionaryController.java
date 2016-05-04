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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.fawns.service.entity.system.Dictionary;
import com.fawns.service.entity.system.User;
import com.fawns.service.services.system.DictionaryService;
import com.fawns.service.services.system.LogService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.common.filter.DictionaryUtil;
import com.fawns.service.common.page.Page;
import com.fawns.service.util.DateUtil;
import com.fawns.service.util.UUIDGenerator;

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
@RequestMapping("/system/dictionary")
public class DictionaryController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);
	@Autowired
	DictionaryService dictionaryService;
	@Autowired
	LogService logService;
	private static final String ADD = "system/dictionary/add";
	private static final String EDIT = "system/dictionary/edit";
	private static final String VIEW = "system/dictionary/view";
	private static final String LIST = "system/dictionary/list";

	/**
	 * 
	 * Description: 
	 * ajax得到字典tree
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	 @RequestMapping(value="/tree")   
	 public @ResponseBody Object tree(HttpSession session){   
		 List dictionaryTree = dictionaryService.getDictionaryTree();
		 return dictionaryTree;
	 }   
	 
	/**
	 * 
	 * Description: 
	 * 得到字典的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request,ConditionEntity conditionEntity,@RequestParam (required=false) String id,@RequestParam (required=false) String flag, Model model) {
		logger.info("查询字典列表开始");
		Map<String,Object> params = new HashMap<String,Object>();
		//添加查询条件
		params.put("id", id);
		params.put("keywords", conditionEntity.getKeywords());
		//获取总条数
		Long totalCount = dictionaryService.queryDictionaryNumByCondition(params);
		Page page = executePage(request,totalCount);		
		//压入查询参数:开始位置与查询多少条数
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEveryPage());
		//查询集合		
		List<Dictionary> dictionaryList = dictionaryService.queryDictionaryListByCondition(params);
		
		model.addAttribute("dictionaryList", dictionaryList);
		model.addAttribute("vo", conditionEntity);
		model.addAttribute("id", id);
		model.addAttribute("flag", flag);
		logger.info("查询字典列表结束");
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到字典添加页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/add")
	public String add(Model model) {
		logger.info("转到字典添加页面");
		List<Dictionary> dictionaryTypeList = dictionaryService.queryDictionaryTypeList();
		model.addAttribute("dictionaryTypeList",dictionaryTypeList);
		return ADD;
	}
	
	/**
	 * 
	 * Description: 
	 * 检测字典信息是否存在
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/checkDictionary/{dictionaryType}/{dictionaryCode}")
	public @ResponseBody Object checkDictionary(@PathVariable String dictionaryType,@PathVariable String dictionaryCode,Model model) {
		Dictionary dictionary = dictionaryService.checkDictionary(dictionaryType,dictionaryCode);
		return dictionary;
	}
	
	/**
	 * 
	 * Description:
	 * 字典添加处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request,Dictionary dictionary, String dictionaryTypeOption,String newDictionaryType) {
		String flag = "";
		User user = getCurrentUser(request);
		try {
			logger.info("字典添加处理开始");
			UUIDGenerator uuid = new UUIDGenerator();
			String id = uuid.generate().toString();
			dictionary.setId(id);
			dictionary.setParentId(dictionary.getParentId());
			if(dictionaryTypeOption.equals("0")){
				dictionary.setDictionaryType(newDictionaryType);
			}
			dictionary.setCreateDate(new Date());
			dictionary.setCreateOperId(user.getUsername());
			dictionaryService.addDictionary(dictionary);
			flag = "addSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功新增了["+dictionary.getName()+"]的字典信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("字典添加处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "addErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"新增["+dictionary.getName()+"]的字典信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/dictionary/add?flag="+flag;
		}
		//"字典添加成功"
		return "redirect:/system/dictionary/list?id="+dictionary.getId()+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 字典删除
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
			logger.info("字典删除处理开始");
			dictionaryService.deleteDictionary(id);
			flag = "deleteSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功删除了ID为["+id+"]的字典信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("字典删除处理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "deleteErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"删除ID为["+id+"]的字典信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/dictionary/list?flag="+flag;
		}
		return "redirect:/system/dictionary/list?flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 根据DictionaryId得到字典信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String view(@PathVariable String id, Map<String, Object> map) {
		Dictionary dictionary = dictionaryService.getDictionary(id);
		map.put("dictionary", dictionary);
		List<Dictionary> dictionaryTypeList = dictionaryService.queryDictionaryTypeList();
		map.put("dictionaryTypeList",dictionaryTypeList);
		return VIEW;
	}
	
	/**
	 * 
	 * Description: 
	 * 修改前根据DictionaryId得到字典信息
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:14:34
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable String id, Map<String, Object> map) {
		Dictionary dictionary = dictionaryService.getDictionary(id);
		map.put("dictionary", dictionary);
		List<Dictionary> dictionaryTypeList = dictionaryService.queryDictionaryTypeList();
		map.put("dictionaryTypeList",dictionaryTypeList);
		return EDIT;
	}
	
	/**
	 * 
	 * Description: 
	 * 字典修改处理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-20 下午04:27:44
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	public String doEdit(HttpServletRequest request, Dictionary dictionary) {
		String flag = "";
		User user = getCurrentUser(request);
		try{
			dictionary.setParentId(dictionary.getParentId());
			dictionary.setUpdateDate(new Date());
			dictionary.setUpdateOperId(user.getUsername());
			dictionaryService.editDictionary(dictionary);
			flag = "editSuc";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功修改了["+dictionary.getName()+"]的字典信息！" , "系统维护日志",user.getDepartmentId());
			//"字典修改成功！"
		}catch (Exception e) {
			e.printStackTrace();
			flag = "editErr";
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"修改["+dictionary.getName()+"]的字典信息时失败！" , "系统维护日志",user.getDepartmentId());
			return "redirect:/system/dictionary/edit/"+dictionary.getId()+"&flag="+flag;
		}
		return "redirect:/system/dictionary/list?id="+dictionary.getId()+"&flag="+flag;
	}
	
	/**
	 * 
	 * Description: 
	 * 刷新字典缓存
	 * @param 
	 * @return String
	 * @throws ServletException 
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/refresh")
	public @ResponseBody Object refresh(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		String flag = "";
		User user = getCurrentUser(request);
		try{
			logger.info("刷新字典开始");
			DictionaryUtil.getInstance().refreshDictionary(request.getSession().getServletContext());
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"成功刷新了字典信息！" , "系统维护日志",user.getDepartmentId());
			logger.info("刷新字典结束");
			//"字典刷新成功！"
			flag = "refreshSuc";
		}catch (Exception e) {
			e.printStackTrace();
			logService.saveLog(user.getUsername(), getIpAddr(request), DateUtil.getCurrentTime(), Constants.System.LOGTYPE_SYS, user.getRealname()+"在"+DateUtil.getCurrentTime()+"刷新字典信息时失败！" , "系统维护日志",user.getDepartmentId());
			flag = "refreshErr";
		}
		return flag;
	}
	
}
