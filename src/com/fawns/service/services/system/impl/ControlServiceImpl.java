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

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fawns.service.dao.system.ControlMapper;
import com.fawns.service.entity.system.Control;
import com.fawns.service.services.system.ControlService;
import com.fawns.service.common.entity.ConditionEntity;

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

@Service
@Transactional(readOnly=true)
public class ControlServiceImpl implements ControlService {
	private static final Logger logger = LoggerFactory.getLogger(ControlServiceImpl.class);
	@Autowired
	ControlMapper controlMapper;
	
	/**
	 * Description: 
	 * 根据条件得到控件列表
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public List<Control> queryControlListByCondition(
			ConditionEntity conditionEntity) {
		// TODO Auto-generated method stub
		return controlMapper.queryControlListByCondition(conditionEntity);
	}
	
	/**
	 * Description: 
	 * 控件添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	@Override
	public void addControl(Control control) {
		// TODO Auto-generated method stub
		controlMapper.addControl(control);
	}

	/**
	 * Description: 
	 * 控件删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	@Override
	public void deleteControl(int id) {
		// TODO Auto-generated method stub
		controlMapper.deleteControl(id);
	}
	
	/**
	 * Description: 
	 * 控件修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	@Override
	public void editControl(Control control) {
		// TODO Auto-generated method stub
		controlMapper.editControl(control);
	}
	
	/**
	 * Description: 
	 * 根据id得到控件信息
	 * @param 
	 * @return control
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	@Override
	public Control getControl(int id) {
		// TODO Auto-generated method stub
		return controlMapper.getControl(id);
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
	@Override
	public Control checkControl(Map<String, String> map) {
		// TODO Auto-generated method stub
		return controlMapper.checkControl(map);
	}

	/**
	 * Description: 
	 * 删除资源对应的control信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-8 下午01:22:39
	 */
	@Override
	public void deleteControlByResId(String resourceId) {
		// TODO Auto-generated method stub
		controlMapper.deleteControlByResId(resourceId);
	}
}
