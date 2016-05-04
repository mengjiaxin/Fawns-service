/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: BaseController.java 
 *
 * Created: [2014-2-10 下午08:19:21] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-2-10 下午08:19:21
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.base;

import javax.servlet.http.HttpServletRequest;

import com.fawns.service.entity.system.User;
import com.fawns.service.common.constant.Constants;
import com.fawns.service.common.page.Page;
import com.fawns.service.common.page.PageState;
import com.fawns.service.common.page.PageUtil;

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

public class BaseController {
	private static final long serialVersionUID = 6718838822334455667L;
	//获得客户端真实IP地址
	public String getIpAddr(HttpServletRequest request) { 
		String ip = request.getHeader("x-forwarded-for"); 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		ip = request.getRemoteAddr(); 
		} 
		return ip; 
	} 
	
	//得到当前登录用户的信息
	public User getCurrentUser(HttpServletRequest request) { 
		User user = (User)request.getSession().getAttribute(Constants.SessionKey.CURRENT_USER);
		return user; 
	} 
	
	/**
	 * 分页语句	
	 * 子类在展现数据前,进行分页计算!
	 * @param querySql  查询的SQL语句,未进行分页
	 * @param totalCount 根据查询SQL获取的总条数
	 * @param columnNameDescOrAsc 列名+排序方式 : ID DESC or ASC
	 */
	protected Page executePage(HttpServletRequest request,Long totalCount){
		if(null == totalCount){
			totalCount = 0L;
		}
		/**页面状态,这个状态是分页自带的,与业务无关*/
		String pageAction = request.getParameter("pageAction");
		String value = request.getParameter("pageKey");
		
		/**获取下标判断分页状态*/
		int index = PageState.getOrdinal(pageAction);				
		
		Page page = null;		
		/**
		 * index < 1 只有二种状态
		 * 1 当首次调用时,分页状态类中没有值为 NULL 返回 -1
		 * 2 当页面设置每页显示多少条: index=0,当每页显示多少条时,分页类要重新计算
		 * */
		Page sessionPage = getPage(request);
		
		if(index < 1){			
			page = PageUtil.inintPage(totalCount,index,value,sessionPage);
		}else{				
			page = PageUtil.execPage(index,value,sessionPage);
		}		
		setSession(request,page);	
		return page;
	}	
	
	private Page getPage(HttpServletRequest request) {
		Page page = (Page)request.getSession().getAttribute(PageUtil.SESSION_PAGE_KEY);
		if(page == null){
			page = new Page();
		}
		return page;		
	}	
	
	private void setSession(HttpServletRequest request,Page page) {
		request.getSession().setAttribute(PageUtil.SESSION_PAGE_KEY,page);		
	}	
	
	public boolean isAdmin(User user) {
		boolean userType = false;
		if(null != user){
			String username = user.getUsername();
			if(username.toLowerCase().equals("admin")){
				userType = true;
			}else{
				userType = false;
			}
		}
		return userType;
	}	
}
