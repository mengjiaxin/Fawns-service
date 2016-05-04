/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: PageState.java 
 *
 * Created: [2014-3-1 下午07:32:37] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-3-1 下午07:32:37
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.page;

import org.apache.commons.lang3.StringUtils;

/** 
 *
 * Description: 
 * 分页状态类
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-3-1    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public enum PageState {
	/**
	 * 设置每页显示多少条
	 * */
	SETPAGE,
	/**
	 * 首页
	 * */
	FIRST, 
	/**
	 * 向前一页
	 * */
	PREVIOUS, 
	/**
	 * 向后一页
	 * */
	NEXT, 
	/**
	 * 末页
	 * */
	LAST, 
	/**
	 * 排序
	 * */
	SORT,
	/**
	 * 到第多少页
	 * */
	GOPAGE;

	
	/**
	 * @param value 索引名称
	 * @return 返回索引下标
	 */
	public static int getOrdinal(String value) {
		int index = -1;
		if (StringUtils.isEmpty(value)) {
			return index;
		}
		String newValue = StringUtils.trim(value).toUpperCase();
		try {
			index = valueOf(newValue).ordinal();
		} catch (IllegalArgumentException e) {}
		return index;
	}
}
