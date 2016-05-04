/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: StringUtil.java 
 *
 * Created: [2013-12-26 下午02:42:22] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-26 下午02:42:22
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.util;

/** 
*
* Description: 
* 字符串工具类
* @author mawenqiang
* @version 1.0
* <pre>
* Modification History: 
* Date         Author      Version     Description 
* ------------------------------------------------------------------ 
* 2013-12-26    mawenqiang       1.0        1.0 Version 
* </pre>
*/

public class StringUtil{
	/**
	 * 判断给定的字符串是否为空,以及空字符串
	 * 
	 * @param input
	 *            输入字符串
	 * @return 是否为空,空则返回true，反之亦反
	 * @since 0.1
	 */
	public static boolean blank(String input) {
		return input == null || "".equals(input) || input.length() == 0
				|| input.trim().length() == 0;
	}
}
