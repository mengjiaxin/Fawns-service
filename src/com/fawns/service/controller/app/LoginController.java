package com.fawns.service.controller.app;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fawns.service.common.base.BaseController;
import com.fawns.service.common.constant.ServiceCode;
import com.fawns.service.common.entity.ResultEntity;

public class LoginController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/member_login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, Map<String, Object> map) {
		ResultEntity resultEntity = new ResultEntity();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);

		Subject currentUser = SecurityUtils.getSubject();
		try {
			logger.info("对用户[" + username + "]进行登录验证..验证开始");
			currentUser.login(token);
			logger.info("对用户[" + username + "]进行登录验证..验证通过");
		} catch (UnknownAccountException uae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
			resultEntity.setCode(ServiceCode.Fail.F00001);
		} catch (IncorrectCredentialsException ice) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
			resultEntity.setCode(ServiceCode.Fail.F00002);
		} catch (LockedAccountException lae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
			resultEntity.setCode(ServiceCode.Fail.F00003);
		} catch (ExcessiveAttemptsException eae) {
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
			resultEntity.setCode(ServiceCode.Fail.F00004);
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			resultEntity.setCode(ServiceCode.Fail.F00005);
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			resultEntity.setCode(ServiceCode.Success.S00002);
		} else {
			token.clear();
		}
	}
}
