/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserService.java 
 *
 * Created: [2013-12-17 下午03:49:21] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午03:49:21
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system;

import java.util.List;
import java.util.Map;

import com.fawns.service.entity.system.Log;
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
 * 2013-12-17    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public interface LogService {
	
	/**
	 * 
	 * Description: 
	 * 根据条件得到日志列表
	 * @param 
	 * @return List<Log>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 上午10:34:34
	 */
	List<Log> queryLogListByCondition(Map<String,Object> params);

	/**
	 * 
	 * Description: 
	 * 根据条件得到日志总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-19 上午10:34:44
	 */
	Long queryLogNumByCondition(Map<String,Object> params);

	/**
	 * Description: 
	 * 日志信息清理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-23 下午05:47:13
	 */
	
	void clearLog(ConditionEntity conditionEntity);

	/**
	 * Description: 
	 * 日志保存
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-2-10 下午08:29:41
	 */
	
	void saveLog(String username, String ipAddr, String operTime,String operType,
			String logContext, String remark, String departmentId);
}
