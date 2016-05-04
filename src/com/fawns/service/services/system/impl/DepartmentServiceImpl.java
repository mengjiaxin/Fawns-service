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

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fawns.service.dao.system.DepartmentMapper;
import com.fawns.service.entity.system.Department;
import com.fawns.service.services.system.DepartmentService;

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
public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	@Autowired
	DepartmentMapper departmentMapper;

	/**
	 * 
	 * Description: 
	 * 得到部门tree
	 * @param 
	 * @return Object
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-24 上午11:21:09
	 */
	@Override
	public List getDepartmentTree(String departmentId) {
		// TODO Auto-generated method stub
		return departmentMapper.getDepartmentTree(departmentId);
	}

	/**
	 * Description: 
	 * 根据条件得到部门列表
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public List<Department> queryDepartmentListByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return departmentMapper.queryDepartmentListByCondition(params);
	}

	/**
	 * Description: 
	 * 根据条件得到部门列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	@Override
	public Long queryDepartmentNumByCondition(
			Map<String,Object> params) {
		// TODO Auto-generated method stub
		return departmentMapper.queryDepartmentNumByCondition(params);
	}

	/**
	 * Description: 
	 * 部门添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.addDepartment(department);
	}

	/**
	 * 
	 * Description: 
	 *  根据上级部门得到新部门的部门代码
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午03:44:21
	 */
	@Override
	public String getNewDepartmentIdBySupDepId(String supdepid){
		String newdepcode = "";//新部门代码
		String maxdepcode = "";//上级部门所管辖的下级部门中最大的部门代码
		maxdepcode = departmentMapper.getNewDepartmentIdBySupDepId(supdepid);
		if(null!=maxdepcode&&maxdepcode!=""){
			String depbegin = maxdepcode.substring(0, maxdepcode.length()-2);//截取最大部门代码前几位
			String dependtwo = maxdepcode.substring(maxdepcode.length()-2, maxdepcode.length());//截取最大部门代码的后两位
			
			int dependtwoint = Integer.parseInt(dependtwo);
			if(dependtwoint>=10){//如果部门代码的后两位大于10，说明后两位的第一位不为0
				newdepcode = depbegin+String.valueOf((dependtwoint+1));
			}else{ //如果小于10，说明后两位的第一位为0
				if((dependtwoint+1)>=10){
					newdepcode = depbegin+String.valueOf((dependtwoint+1));
				}else{
					newdepcode = depbegin+"0"+String.valueOf((dependtwoint+1));
				}
			}
		}else{
			newdepcode = supdepid+"01";
		}
		return newdepcode;
	}

	/**
	 * 
	 * Description: 
	 * 添加成功后把上级部门的部门级别该为不是最后一级，也就是把isend这个字段的值更新为1
	 * @param 
	 * @return String
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午03:44:21
	 */
	@Override
	public void updateDepartmentLevel(String supDepId) {
		// TODO Auto-generated method stub
		departmentMapper.updateDepartmentLevel(supDepId);
	}


	/**
	 * Description: 
	 * 部门删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	@Override
	public void deleteDepartment(String departmentId) {
		// TODO Auto-generated method stub
		departmentMapper.deleteDepartment(departmentId);
	}

	/**
	 * Description: 
	 * 根据departmentId得到部门信息
	 * @param 
	 * @return Department
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	@Override
	public Department getDepartment(String departmentId) {
		// TODO Auto-generated method stub
		return departmentMapper.getDepartment(departmentId);
	}

	/**
	 * Description: 
	 * 部门修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	@Override
	public void editDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.editDepartment(department);
	}

}
