/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: UserServiceImpl.java 
 *
 * Created: [2013-12-17 下午03:49:41] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-17 下午03:49:41
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

import com.fawns.service.dao.system.LogMapper;
import com.fawns.service.entity.system.Log;
import com.fawns.service.services.system.LogService;
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

@Service
@Transactional(readOnly=true)
public class LogServiceImpl implements LogService {
	private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
	@Autowired
	LogMapper logMapper;
	
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
	public List<Log> queryLogListByCondition(Map<String,Object> params) {
		List<Log> logList = logMapper.queryLogListByCondition(params);
		return logList;
	}

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
	public Long queryLogNumByCondition(Map<String,Object> params) {
		Long count = logMapper.queryLogNumByCondition(params);
		return count;
	}

	/**
	 * Description: 
	 * 日志信息清理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-23 下午05:47:13
	 */
	@Override
	public void clearLog(ConditionEntity conditionEntity) {
		// TODO Auto-generated method stub
		logMapper.clearLog(conditionEntity);
	}

	/**
	 * Description: 
	 * 日志保存
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-2-10 下午08:29:41
	 */
	@Override
	public void saveLog(String username, String ipAddr,String operTime,
			String operType, String logContext, String remark,
			String departmentId) {
		// TODO Auto-generated method stub
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("operatorId", username);
		paramMap.put("operatorIp", ipAddr);
		paramMap.put("operatorTime", operTime);
		paramMap.put("operType", operType);
		paramMap.put("content", logContext);
		paramMap.put("remark", remark);
		paramMap.put("departmentId", departmentId);
		logMapper.saveLog(paramMap);
	}
}
