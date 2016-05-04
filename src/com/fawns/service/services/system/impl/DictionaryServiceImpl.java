/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentServiceImpl.java 
 *
 * Created: [2013-12-20 下午06:06:36] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:36
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fawns.service.dao.system.DictionaryMapper;
import com.fawns.service.entity.system.Dictionary;
import com.fawns.service.services.system.DictionaryService;

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

@Service("dictionaryServiceImpl")
@Transactional(readOnly=true)
public class DictionaryServiceImpl implements DictionaryService {
	private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);
	@Autowired
	DictionaryMapper dictionaryMapper;

	/**
	 * 
	 * Description: 
	 * 字典部门tree
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	@Override
	public List getDictionaryTree() {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionaryTree();
	}

	/**
	 * Description: 
	 * 根据条件得到字典列表
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public List<Dictionary> queryDictionaryListByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return dictionaryMapper.queryDictionaryListByCondition(params);
	}

	/**
	 * Description: 
	 * 根据条件得到字典列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public Long queryDictionaryNumByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return dictionaryMapper.queryDictionaryNumByCondition(params);
	}

	/**
	 * Description: 
	 * 部门添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	@Override
	public void addDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		dictionaryMapper.addDictionary(dictionary);
	}

	/**
	 * Description: 
	 * 部门删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	@Override
	public void deleteDictionary(String dictionaryId) {
		// TODO Auto-generated method stub
		dictionaryMapper.deleteDictionary(dictionaryId);
	}

	/**
	 * Description: 
	 * 根据DictionaryId字典部门信息
	 * @param 
	 * @return Dictionary
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	@Override
	public Dictionary getDictionary(String dictionaryId) {
		// TODO Auto-generated method stub
		return dictionaryMapper.getDictionary(dictionaryId);
	}

	/**
	 * Description: 
	 * 部门修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	@Override
	public void editDictionary(Dictionary dictionary) {
		// TODO Auto-generated method stub
		dictionaryMapper.editDictionary(dictionary);
	}

	/**
	 * Description: 
	 * 得到字典类别列表
	 * @param 
	 * @return List<Dictionary>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-30 下午02:29:25
	 */
	@Override
	public List<Dictionary> queryDictionaryTypeList() {
		// TODO Auto-generated method stub
		return dictionaryMapper.queryDictionaryTypeList();
	}

	/**
	 * Description: 
	 * 系统初始化时提供字典数据信息
	 * @param 
	 * @return List<Dictionary>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-31 下午02:07:06
	 */
	@Override
	/**
	 * Description: 
	 * 初始化字典缓存
	 * @param 
	 * @return List<Dictionary>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-30 下午06:20:07
	 */
	public List<Dictionary> queryDictionaryForInit(Map<String, Object> conditions) {
		// TODO Auto-generated method stub
		return dictionaryMapper.queryDictionaryForInit(conditions);
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
	@Override
	public Dictionary checkDictionary(String dictionaryType,
			String dictionaryCode) {
		// TODO Auto-generated method stubg
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("dictionaryType", dictionaryType);
		paramMap.put("dictionaryCode", dictionaryCode);
		return dictionaryMapper.checkDictionary(paramMap);
	}

}
