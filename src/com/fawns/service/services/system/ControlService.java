/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentService.java 
 *
 * Created: [2013-12-20 下午06:06:22] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:22
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system;

import java.util.List;
import java.util.Map;

import com.fawns.service.entity.system.Control;
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

public interface ControlService {

	/**
	 * Description: 
	 * 根据条件得到控件列表
	 * @param 
	 * @return List<Control>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:03
	 */
	
	List<Control> queryControlListByCondition(
			ConditionEntity conditionEntity);

	/**
	 * Description: 
	 * 控件添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	
	void addControl(Control control);
	
	/**
	 * Description: 
	 * 控件删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	
	void deleteControl(int id);

	/**
	 * Description: 
	 * 根据controlId和resourceId得到控件信息
	 * @param 
	 * @return control
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	
	Control getControl(int id);

	/**
	 * Description: 
	 * 控件修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	
	void editControl(Control control);

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
	
	Control checkControl(Map<String, String> map);

	/**
	 * Description: 
	 * 删除资源对应的control信息
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-8 下午01:22:39
	 */
	
	void deleteControlByResId(String resourceId);
}
