/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: CaptchaServlet.java 
 *
 * Created: [2014-3-12 下午03:32:18] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2014-3-12 下午03:32:18
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.common.captcha;

import java.awt.image.BufferedImage;  
import java.io.IOException;  
import javax.imageio.ImageIO;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 

import com.fawns.service.common.constant.Constants;
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
 * 2014-3-12    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

 public class CaptchaServlet extends HttpServlet {  
     private static final long serialVersionUID = -124247581620199710L;  
     public static final String KEY_CAPTCHA = Constants.SessionKey.Captcha;  

     @Override 
     protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
             throws ServletException, IOException {  

         // 设置相应类型,告诉浏览器输出的内容为图片  
         resp.setContentType("image/jpeg");  

         // 不缓存此内容  
         resp.setHeader("Pragma", "No-cache");  
         resp.setHeader("Cache-Control", "no-cache");  
         resp.setDateHeader("Expire", 0);  

         try {  
             HttpSession session = req.getSession();  
             CaptchaUtil tool = new CaptchaUtil();  
             StringBuffer code = new StringBuffer();  
             BufferedImage image = tool.genRandomCodeImage(code);  
             session.removeAttribute(KEY_CAPTCHA);  
             session.setAttribute(KEY_CAPTCHA, code.toString());
             // 将内存中的图片通过流的形式输出到客户端  
             ImageIO.write(image, "JPEG", resp.getOutputStream());  
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
     }  

     @Override 
     protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
             throws ServletException, IOException {  
         doGet(req, resp);  
     }  
 } 