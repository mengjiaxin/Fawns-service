/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: FileRenameUtil.java 
 *
 * Created: [2014-1-23 下午02:59:09] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-1-23 下午02:59:09
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/
package com.fawns.service.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * 
 * 文件重命名工具类
 * @author mawenqiang
 * #Date: 2011-8-17
 * 
 * #Title: FileRenameUtil.java
 * 
 */
public class FileRenameUtil {
	/**
	 * 
	 * Description: 
	 *
	 * @param fileName 文件名
	 * @return 新文件名
	 * @throws Exception
	 * @Author yubin
	 * Create Date: 2012-9-24 下午06:20:23
	 */
	public static String rename(String fileName) throws Exception{
		String body = "";
		String ext = "";
		Date date = new Date();

		int pot = fileName.lastIndexOf(".");
		if (pot != -1) {
			body = date.getTime() + "";
			ext = fileName.substring(pot);
		} else {
			body = (new Date()).getTime() + "";
			ext = "";
		}
		String newName = body + ext;
		// file=new File(file.getParent(),newName);
		return newName;
	}
	/**
	 * 生成新的文件名，格式：yyyyMMddHHmmssSSS
	 * @param fileName 
	 *        原文件名
	 * @return
	 */
	public static String getNewFileName(String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String newName = sdf.format(Calendar.getInstance().getTime());
		String extendName = "";
		if (fileName.lastIndexOf(".") != -1)
			extendName = fileName.substring(fileName.lastIndexOf("."));
		return newName + extendName;
	}
	
}