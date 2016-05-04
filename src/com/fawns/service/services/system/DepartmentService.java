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

import com.fawns.service.entity.system.Department;

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

public interface DepartmentService {

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
	
	List getDepartmentTree(String departmentId);

	/**
	 * Description: 
	 * 根据条件得到部门列表
	 * @param 
	 * @return List<Department>
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:03
	 */
	
	List<Department> queryDepartmentListByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 根据条件得到部门列表总条数
	 * @param 
	 * @return Integer
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-25 下午06:20:24
	 */
	
	Long queryDepartmentNumByCondition(
			Map<String,Object> params);

	/**
	 * Description: 
	 * 部门添加处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-26 下午03:38:43
	 */
	
	void addDepartment(Department department);
	
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
	String getNewDepartmentIdBySupDepId(String supdepid);

	/**
	 * Description: 
	 * 添加成功后把上级部门的部门级别该为不是最后一级，也就是把isend这个字段的值更新为1
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:44:14
	 */
	
	void updateDepartmentLevel(String supDepId);

	/**
	 * Description: 
	 * 部门删除处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午04:51:11
	 */
	
	void deleteDepartment(String departmentId);

	/**
	 * Description: 
	 * 根据departmentId得到部门信息
	 * @param 
	 * @return Department
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:02:15
	 */
	
	Department getDepartment(String departmentId);

	/**
	 * Description: 
	 * 部门修改处理
	 * @param 
	 * @return void
	 * @throws Exception if has error
	 * @Author Administrator
	 * @Create Date: 2013-12-27 下午05:24:53
	 */
	
	void editDepartment(Department department);

}
