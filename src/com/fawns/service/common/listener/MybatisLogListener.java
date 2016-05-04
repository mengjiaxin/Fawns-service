/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: MybatisLogSetListener.java 
 *
 * Created: [2014-1-13 下午07:57:07] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-13 下午07:57:07
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
 * 2014-1-13    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class MybatisLogListener implements ServletContextListener{
	public MybatisLogListener() {  
		
	} 
	
	/**
	 * 设置mybatis默认使用日志为log4j
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging(); 
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
}
