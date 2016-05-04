/* 
 * Copyright (C) 2013-2013 mawenqiang
 *
 * FileName: DepartmentServiceImpl.java 
 *
 * Created: [2013-12-20 下午06:06:36] by mawenqiang 
 *
 * Author:Administrator
 *
 * Date:2013-12-20 下午06:06:36
 * 
 * ProjectName: IMS 
 * 
 * Description: 
 **/

package com.fawns.service.services.system.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fawns.service.dao.system.ResourceMapper;
import com.fawns.service.entity.system.Resource;
import com.fawns.service.services.system.ResourceService;

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

@Service
@Transactional(readOnly=true)
public class ResourceServiceImpl implements ResourceService {
	private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);
	@Autowired
	ResourceMapper resourceMapper;

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
	@Override
	public List getResourceTree() {
		// TODO Auto-generated method stub
		return resourceMapper.getResourceTree();
	}

	/**
	 * Description: 
	 * 根据条件得到资源列表
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public List<Resource> queryResourceListByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return resourceMapper.queryResourceListByCondition(params);
	}

	/**
	 * Description: 
	 * 根据条件得到资源列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public Long queryResourceNumByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return resourceMapper.queryResourceNumByCondition(params);
	}

	/**
	 * Description: 
	 * 资源添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	@Override
	public void addResource(Resource resource) {
		// TODO Auto-generated method stub
		resourceMapper.addResource(resource);
	}

	/**
	 * Description: 
	 * 资源删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	@Override
	public void deleteResource(String resourceId) {
		// TODO Auto-generated method stub
		resourceMapper.deleteResource(resourceId);
	}

	/**
	 * Description: 
	 * 根据resourceId得到资源信息
	 * @param 
	 * @return resource
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	@Override
	public Resource getResource(String resourceId) {
		// TODO Auto-generated method stub
		return resourceMapper.getResource(resourceId);
	}

	/**
	 * Description: 
	 * 资源修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	@Override
	public void editResource(Resource resource) {
		// TODO Auto-generated method stub
		resourceMapper.editResource(resource);
	}

	/**
	 * Description: 
	 * 把上级资源的url更新为"#"号
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-3 上午10:36:52
	 */
	@Override
	public void updateResourceUrl(Resource resource) {
		// TODO Auto-generated method stub
		resourceMapper.updateResourceUrl(resource);
	}

	/**
	 * Description: 
	 * 组装导航菜单
	 * @param 
	 * @return Resource
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2014-1-16 下午01:57:56
	 */
	@Override
	public Resource getMenuTree(List<String> roleResourceSet) {
		// TODO Auto-generated method stub
		List<Resource> list = resourceMapper.getMenuTree(roleResourceSet);
		
		List<Resource> rootList = makeMenuTree(list);
				
		return rootList.get(0);
	}
	
	private List<Resource> makeMenuTree(List<Resource> list) {
		List<Resource> parent = new ArrayList<Resource>();
		// get parentId = null;
		for (Resource e : list) {
			if (e.getParentId() == null) {
				e.setChildren(new ArrayList<Resource>(0));
				parent.add(e);
			}
		}
		// 删除parentId = null;
		list.removeAll(parent);
		
		makeChildren(parent, list);
		
		return parent;
	}
	
	private void makeChildren(List<Resource> parent, List<Resource> children) {
		if (children.isEmpty()) {
			return ;
		}
		
		List<Resource> tmp = new ArrayList<Resource>();
		for (Resource c1 : parent) {
			for (Resource c2 : children) {
				c2.setChildren(new ArrayList<Resource>(0));
				if (c1.getId().equals(c2.getParentId())) {
					c1.getChildren().add(c2);
					tmp.add(c2);
				}
			}
		}
		children.removeAll(tmp);
		makeChildren(tmp, children);
	}

}
