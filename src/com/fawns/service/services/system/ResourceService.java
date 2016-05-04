/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentService.java 
 *
 * Created: [2013-12-20 下午06:06:22] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:22
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system;

import java.util.List;
import java.util.Map;

import com.fawns.service.entity.system.Resource;

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
 * 2013-12-20    mawenqiang       1.0        1.0 Version 
 * </pre>
 */

public interface ResourceService {

	/**
	 * 
	 * Description: 
	 * 得到资源tree
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	
	List<Resource> getResourceTree();

	/**
	 * Description: 
	 * 根据条件得到资源列表
	 * @param 
	 * @return List<resource>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:03
	 */
	
	List<Resource> queryResourceListByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 根据条件得到资源列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	
	Long queryResourceNumByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 资源添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	
	void addResource(Resource resource);
	
	/**
	 * Description: 
	 * 资源删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	
	void deleteResource(String resourceId);

	/**
	 * Description: 
	 * 根据resourceId得到资源信息
	 * @param 
	 * @return resource
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	
	Resource getResource(String resourceId);

	/**
	 * Description: 
	 * 资源修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	
	void editResource(Resource resource);

	/**
	 * Description: 
	 * 把上级资源的url更新为"#"号
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-3 上午10:36:52
	 */
	
	void updateResourceUrl(Resource resource);

	/**
	 * Description: 
	 * 组装导航菜单
	 * @param 
	 * @return Resource
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-16 下午01:57:56
	 */
	
	Resource getMenuTree(List<String> roleResourceSet);

}
