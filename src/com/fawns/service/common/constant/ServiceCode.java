package com.fawns.service.common.constant;

/**
 * 服务器返回代码
 * 
 * @author lenovo
 *
 */
public class ServiceCode {

	/**
	 * 成功代码
	 * 
	 * @author lenovo
	 *
	 */
	public interface Success {
		/**
		 * 查询成功
		 */
		String S00001 = "S00001";

		/**
		 * 登录成功
		 */
		String S00002 = "S00002";
		
		/**
		 * 登出成功
		 */
		String S00003 = "S00003";
	}

	/**
	 * 失败代码
	 * 
	 * @author lenovo
	 *
	 */
	public interface Fail {

		/**
		 * 未知账户
		 */
		String F00001 = "F00001";

		/**
		 * 密码不正确
		 */
		String F00002 = "F00002";

		/**
		 * 账户已锁定
		 */
		String F00003 = "F00003";

		/**
		 * 用户名或密码错误次数过多
		 */
		String F00004 = "F00004";

		/**
		 * 用户名或密码不正确
		 */
		String F00005 = "F00005";
	}

}
