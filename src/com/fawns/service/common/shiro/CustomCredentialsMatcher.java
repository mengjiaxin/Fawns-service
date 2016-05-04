/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: CustomCredentialsMatcher.java 
 *
 * Created: [2014-3-13 下午05:47:33] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-3-13 下午05:47:33
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.shiro;

import java.text.ParseException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;

/** 
 *
 * Description: 
 * 自定义 密码验证类
 * @author mawenqiang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-3-13    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher{
	 @Override  
     public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {   
         UsernamePasswordToken token = (UsernamePasswordToken) authcToken;   
         Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));   
         Object accountCredentials = getCredentials(info);   
         //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false   
         return equals(tokenCredentials, accountCredentials);   
     }   

     //将传进来密码加密方法   
     public String encrypt(String data) {   
         String sha384Hex = new Sha384Hash(data).toBase64();//这里可以选择自己的密码验证方式 比如 md5或者sha256等   
         return sha384Hex;   
     }
     
     public static void main(String[] args) throws ParseException{
    	 CustomCredentialsMatcher a =  new CustomCredentialsMatcher();
    	 System.out.println(a.encrypt("888888"));
     }
}
