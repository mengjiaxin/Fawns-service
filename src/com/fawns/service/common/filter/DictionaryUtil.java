/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DictionaryUtil.java 
 *
 * Created: [2013-12-30 下午05:54:48] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-30 下午05:54:48
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fawns.service.entity.system.Dictionary;
import com.fawns.service.services.system.DictionaryService;
import com.fawns.service.common.holder.SpringMvcContextHolder;
import com.fawns.service.util.SpringContextUtil;

/** 
 *
 * Description: 
 * 字典初始化Servlet
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-30    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class DictionaryUtil implements Servlet {
	private static final Logger logger = LoggerFactory.getLogger(DictionaryUtil.class);
	private static DictionaryUtil instance = null;
	private static LinkedHashMap<String, LinkedHashMap<String, String>> codeMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();// 最外层的Map容器，其中包含各个类别的map
	private static LinkedHashMap<String, String> tmpMap = new LinkedHashMap<String, String>();
	private static List<Dictionary> list = null;// sys_dictionary表中的所有数据
	private ServletConfig config;
	private ServletContext context;

	/**
	 * 初始化数据字典
	 */
	private static void initDictionaryDataMap() {
		logger.info("-------------字典初始化开始-------------");
		String tmpDictionaryType = "";
		for (Dictionary dictionary : list) {
			if (!dictionary.getDictionaryType().equals(tmpDictionaryType)) {
				tmpDictionaryType = dictionary.getDictionaryType();
				tmpMap = new LinkedHashMap<String, String>();
				codeMap.put(tmpDictionaryType, tmpMap);
			}
			tmpMap.put(dictionary.getDictionaryCode(), dictionary.getRemark());
			logger.info(dictionary.getRemark());
		}
		logger.info("-------------字典初始化结束-------------");
	}

	/**
	 * 获得Application范围的codeMap
	 * 
	 * @return
	 */
	public static LinkedHashMap<String, LinkedHashMap<String, String>> getApplicationCodeMap() {
		return codeMap;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static DictionaryUtil getInstance() {
		if (instance == null) {
			instance = new DictionaryUtil();
		}
		return instance;
	}

	/**
	 * 刷新字典codeMap
	 * 
	 * @param obj
	 *            字典对象
	 * @param operate
	 *            操作 add:追加/更新, remove:移除
	 */
	@SuppressWarnings("unchecked")
	public void refresh(Dictionary obj, String operate) {
		if (obj == null)
			return;
		if (codeMap.isEmpty())
			return;
		LinkedHashMap<String, String> typeMap = null;
		if (codeMap.containsKey(obj.getDictionaryType())) {
			typeMap = codeMap.get(obj.getDictionaryType());
			if ("add".equals(operate)) {
				DictionaryService dictionaryService = (DictionaryService)SpringContextUtil.getBean("dictionaryServiceImpl");
				Map<String, Object> conditions = new HashMap<String, Object>();
				conditions.put("dictionaryType", obj.getDictionaryType());
				List<Dictionary> list = null;
				try {
					list = dictionaryService.queryDictionaryForInit(conditions);
					if (list != null && list.size() > 0) {
						typeMap.clear();
						for (Dictionary t : list) {
							typeMap.put(t.getDictionaryCode(), t.getRemark());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if ("remove".equals(operate)) {
				typeMap.remove(obj.getDictionaryCode());
				logger.info(obj.getDictionaryType() + "  移除字典    " + "(key:"
								+ obj.getDictionaryCode() + ",value:"
								+ obj.getRemark() + ")");
			}
		} else {
			typeMap = new LinkedHashMap<String, String>();
			typeMap.put(obj.getDictionaryCode(), obj.getRemark());
			logger.info("原字典中没有此类别,新增字典类别");
		}
		codeMap.put(obj.getDictionaryType(), typeMap);
		SpringMvcContextHolder.setRequestAttribute("CodeMap",
				codeMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#destroy()
	 */
	public void destroy() {
		logger.debug("-------------关闭容器-------------");
		clearMap();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		return this.config;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig arg0) throws ServletException {
		try {
			this.config = arg0;
			context = config.getServletContext();
			context.removeAttribute("CodeMap");
			clearMap();
			DictionaryService dictionaryService = (DictionaryService)SpringContextUtil.getBean("dictionaryServiceImpl");  

			Map<String, Object> conditions = new HashMap<String,Object>();
			list = dictionaryService.queryDictionaryForInit(conditions);
			initDictionaryDataMap();
			context.setAttribute("CodeMap", codeMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Description: 
	 * 刷新字典
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-11-5 下午04:59:56
	 */
	public void refreshDictionary(ServletContext servletContext) throws ServletException {
		try {
			servletContext.removeAttribute("CodeMap");
			clearMap();
			DictionaryService dictionaryService = (DictionaryService)SpringContextUtil.getBean("dictionaryServiceImpl");  
			Map<String, Object> conditions = new HashMap<String,Object>();
			list = dictionaryService.queryDictionaryForInit(conditions);			
			initDictionaryDataMap();
			servletContext.setAttribute("CodeMap", codeMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		init(getServletConfig());
	}

	/**
	 * 清空map
	 */
	private void clearMap() {
		codeMap.clear();
		tmpMap.clear();
	}
}
