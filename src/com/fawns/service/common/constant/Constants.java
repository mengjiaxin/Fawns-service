/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: Constants.java 
 *
 * Created: [2014-2-10 下午08:28:31] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-2-10 下午08:28:31
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.constant;

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
 * 2014-2-10    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public interface Constants {
	/**
	 * 
	 * <p>
	 * [功能简述] 系统模块常量类
	 * <p>
	 */
	class System {
        /** 日志类型**/
        public static final String LOGTYPE_USER = "0"; //用户日志
        public static final String LOGTYPE_BUSINESS = "1"; //业务日志
        public static final String LOGTYPE_SYS = "2"; //系统维护日志
        
	}
	
	/**
	 * 
	 * <p>
	 * [功能简述] session中的Key值
	 * <p>
	 */
	class SessionKey {
        /** 登陆用户的sessionKey**/
        public static final String CURRENT_USER = "userInfo";
        
        /**验证码的sessionKey**/
        public static final String Captcha = "captcha";
	}
}
