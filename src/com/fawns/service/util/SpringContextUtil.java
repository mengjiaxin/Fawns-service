/* 
 * Copyright (C) 2013-2014 mawenqiang
 *
 * FileName: SpringContextUtil.java 
 *
 * Created: [2013-12-31 下午02:01:49] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-31 下午02:01:49
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * Description:
 * 
 * @author mawenqiang
 * @version 1.0
 * 
 *          <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-12-31    mawenqiang       1.0        1.0 Version
 * </pre>
 */

/**  

 * 获取spring容器，以访问容器中定义的其他bean  

 * <A class=referer href="http://my.oschina.net/arthor" target=_blank>@author</A>  lyltiger  

 * <A class=referer href="http://my.oschina.net/u/266547" target=_blank>@since</A>  MOSTsView 3.0 2009-11-16  

 */ 

public class SpringContextUtil implements ApplicationContextAware{  

    private static ApplicationContext   applicationContext;  

    /**  
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境  
     */ 

    public void setApplicationContext(ApplicationContext applicationContext){  
        SpringContextUtil.applicationContext = applicationContext;  
    }  

    public static ApplicationContext getApplicationContext(){  
        return applicationContext;  
    }  


    /**  
     * 获取对象  
     * <A class=referer href="http://my.oschina.net/u/556800" target=_blank>@return</A>  Object 一个以所给名字注册的bean的实例 (service注解方式，自动生成以首字母小写的类名为bean name)  
     */ 

    public static Object getBean(String name) throws BeansException{  
        return applicationContext.getBean(name);
    }  
} 
