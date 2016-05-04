/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: FileOperateUtil.java 
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

import java.io.UnsupportedEncodingException;
/**
 * 
 * @author mawenqiang
 *
 */
public class CharactorFromDataBase {
	public static String transform(String data) throws UnsupportedEncodingException{
		if(data==null) return "";
		byte[] b=data.getBytes("iso-8859-1");
		String s=new String(b,"utf-8");
		return s;
	}
	public static String transformIsoGbk(String data) throws UnsupportedEncodingException{
		if(data==null) return "";
		byte[] b=data.getBytes("GBK");
		String s=new String(b,"iso-8859-1");
		return s;
	}
	public static String transFromUtf(String data) throws UnsupportedEncodingException{
		if(data==null) return "";
		byte[] b=data.getBytes("utf-8");
		String s=new String(b,"iso-8859-1");
		return s;
	}
	public static String transFromGbk(String data) throws UnsupportedEncodingException{
		if(data==null) return "";
		byte[] b=data.getBytes("GBK");
		String s=new String(b,"UTF-8");
		return s;
	}
	public static String transFromUtf2(String data) throws UnsupportedEncodingException{
		if(data==null) return "";
		byte[] b=data.getBytes("utf-8");
		String s=new String(b,"gbk");
		return s;
	}
	public static String transFromAll(String data) throws UnsupportedEncodingException{
		if(data==null) return "";
		byte[] b=data.getBytes("utf-8");
		String s=new String(b,"iso-8859-1");
		return s;
	}
	
	public static String toUtf8String(String s){   
		if(s==null) return "";
		StringBuffer sb = new StringBuffer();   
        for (int i=0;i<s.length();i++){   
            char c = s.charAt(i);   
            if (c >= 0 && c <= 255){sb.append(c);}   
            else{   
                byte[] b;   
                try { b = Character.toString(c).getBytes("utf-8");}   
                catch (Exception ex) {   
//                    System.out.println(ex);   
                    b = new byte[0];   
                }   
                for (int j = 0; j < b.length; j++) {   
                    int k = b[j];   
                    if (k < 0) k += 256;   
                    sb.append("%" + Integer.toHexString(k).toUpperCase());   
                }   
            }   
        }   
        return sb.toString();   
    }  

}
