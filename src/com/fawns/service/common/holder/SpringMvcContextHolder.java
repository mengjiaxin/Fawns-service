/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: SpringMvcContextHolder.java 
 *
 * Created: [2013-12-30 下午06:29:48] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-30 下午06:29:48
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.holder;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** 
 *
 * Description: 
 * spring mvc 上下文持有者,类似Struts2的ServletActionContext
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-30    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public abstract class SpringMvcContextHolder {
	 /**
	  * 获取request attribute
	  * 
	  * @param name 属性名称
	  * 
	  * @return Object
	  */

	 public static <O> O getRequestAttribute(String name) {
	   return (O) currentRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_REQUEST);
	 }

	 /**
	  * 设置request attribute
	  * 
	  * @param name 属性名称
	  * @param value 值
	  */

	 public static void setRequestAttribute(String name,Object value) {
	   currentRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_REQUEST);

	 }

	 /**
	  * 获取sessiont attribute
	  * 
	  * @param name 属性名称
	  * 
	  * @return Object
	  */

	 public static <O> O getSessionAttribute(String name) {

	   return (O) currentRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);

	 }

	 /**
	  * 设置session attribute
	  * @param name 属性名称
	  * @param value 值
	  */

	 public static void setSessionAttribute(String name,Object value) {

	   currentRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_SESSION);

	 }

	 /**

	  * 获取当前RequestAttributes，该类有很多子类。如果想通过它获取request的话转型成{@link ServletRequestAttributes}.getRequest()即可

	  * 

	  * @return {@link RequestAttributes}

	  */

	 public static RequestAttributes currentRequestAttributes() {
	   return RequestContextHolder .currentRequestAttributes();

	 }
}
