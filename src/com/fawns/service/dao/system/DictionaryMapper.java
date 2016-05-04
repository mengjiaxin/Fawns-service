/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentMapper.java 
 *
 * Created: [2013-12-20 下午06:07:47] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:07:47
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.dao.system;

import java.util.List;
import java.util.Map;

import com.fawns.service.entity.system.Dictionary;

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

public interface DictionaryMapper {

	/**
	 * 
	 * Description: 
	 * 得到字典tree
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	
	List getDictionaryTree();

	/**
	 * Description: 
	 * 根据条件得到字典列表
	 * @param 
	 * @return List<Dictionary>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:21:37
	 */
	
	List<Dictionary> queryDictionaryListByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 根据条件得到字典列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:21:42
	 */
	
	Long queryDictionaryNumByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 字典添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	
	void addDictionary(Dictionary dictionary);

	/**
	 * Description: 
	 * 字典删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	
	void deleteDictionary(String dictionaryId);

	/**
	 * Description: 
	 * 根据DictionaryId得到字典信息
	 * @param 
	 * @return Dictionary
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	
	Dictionary getDictionary(String dictionaryId);

	/**
	 * Description: 
	 * 字典修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	
	void editDictionary(Dictionary dictionary);

	/**
	 * Description: 
	 * 得到字典类别列表
	 * @param 
	 * @return List<Dictionary>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-30 下午02:29:25
	 */
	
	List<Dictionary> queryDictionaryTypeList();

	/**
	 * Description: 
	 * 初始化字典缓存
	 * @param 
	 * @return List<Dictionary>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-30 下午06:20:07
	 */
	
	List<Dictionary> queryDictionaryForInit(Map<String, Object> conditions);

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
	
	Dictionary checkDictionary(Map<String, String> paramMap);

}
