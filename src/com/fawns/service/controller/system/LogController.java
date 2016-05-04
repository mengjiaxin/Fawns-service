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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fawns.service.entity.system.Log;
import com.fawns.service.services.system.LogService;
import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.entity.ConditionEntity;
import com.fawns.service.common.page.Page;

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
@RequestMapping("/system/log")
public class LogController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	@Autowired
	LogService logService;
	
	private static final String LIST = "system/log/list";
	private static final String CLEAR = "system/log/clear";
	/**
	 * 
	 * Description: 
	 * 得到日志的列表
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(HttpServletRequest request,ConditionEntity conditionEntity ,Model model) {
		logger.info("查询日志列表开始");
		Map<String,Object> params = new HashMap<String,Object>();
		//添加查询条件
		params.put("keywords", conditionEntity.getKeywords());
		params.put("type", conditionEntity.getType());
		if(null != conditionEntity.getStartDate() && !"".equals(conditionEntity.getStartDate())){
			params.put("startDate", conditionEntity.getStartDate()+" 00:00:00");
		}
		if(null != conditionEntity.getEndDate() && !"".equals(conditionEntity.getEndDate())){
			params.put("endDate", conditionEntity.getEndDate()+" 23:59:59");
		}
		//获取总条数
		Long totalCount = logService.queryLogNumByCondition(params);
		//设置分页对象
		Page page = executePage(request,totalCount);		
		//如排序
		if(page.isSort()){
			params.put("orderName",page.getSortName());	
			params.put("descAsc",page.getSortState());
		}else{
			//没有进行排序,默认排序方式
			params.put("orderName","l.oper_time");	
			params.put("descAsc","desc");
		}
		//压入查询参数:开始位置与查询多少条数
		params.put("startIndex", page.getBeginIndex());
		params.put("endIndex", page.getEveryPage());
		
		//查询集合		
		List<Log> logList = logService.queryLogListByCondition(params);
		
		model.addAttribute("logList", logList);
		model.addAttribute("vo", conditionEntity);
		logger.info("查询日志列表结束");
		return LIST;
	}
	
	/**
	 * 
	 * Description: 
	 * 转到日志信息清理页面
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 下午03:39:30
	 */
	@RequestMapping("/toClear")
	public String toClear(Model model) {
		logger.info("转到日志信息清理页面");
		return CLEAR;
	}
	
	/**
	 * 
	 * Description: 
	 * 日志信息清理
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-18 下午03:38:34
	 */
	@RequestMapping("/doClear")
	public @ResponseBody Object doClear(ConditionEntity conditionEntity, Model model) {
		String flag = "";
		try {
			logger.info("日志信息清理开始");
			logService.clearLog(conditionEntity);
			flag = "clearSuc";
			logger.info("日志信息清理结束");
		} catch (Exception e) {
			e.printStackTrace();
			flag = "clearErr";
		}
		return flag;
	}
}
