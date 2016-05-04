/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: PageUtil.java 
 *
 * Created: [2014-3-1 下午07:33:28] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-3-1 下午07:33:28
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.page;

/** 
 *
 * Description: 
 * 分页工具类
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-3-1    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class PageUtil {
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	public static final String PAGE_DESC = "↓";
	public static final String PAGE_ASC = "↑";
	public static final String PAGE_NULL = "&nbsp;&nbsp;";	
	public static final String SESSION_PAGE_KEY = "page";	
	
	
	/**
	 * 初始化分页类
	 * @param initPageSql  未分页的查询SQL
	 * @param totalCount   总行数
	 * @param index        分页状态
	 * @param value        只有在设置每页显示多少条时,值不会NULL,其它为NULL
	 */
	public  static Page inintPage(Long totalCount,Integer index,String value,Page sessionPage){	
		Page page = null;
		if(index < 0){
			 page = new Page(totalCount);
		}else{
			 /**每页显示多少条*/
			 Long everPage = null == value ? 10 : Long.parseLong(value);
			 /**获取Session中的分页类,方便保存页面分页状态*/
			 page = sessionPage;			 
			 page.setEveryPage(everPage);
			 page.setTotalCount(totalCount);			
		}	
		return page;		
	}
	
	

	
	/**
	 * 当页点击：首页,前一页,后一页,末页,排序,到第多少页时进行分页操作
	 * @param index 分页状态
	 * @param value 排序字段名或者到第多少页
	 */
	public static Page execPage(int  index,String value,Page sessionPage){	
		Page page = sessionPage;			
		/**调用方法进行分页计算*/
		page.pageState(index,value);		
		return page;		
	}
}
