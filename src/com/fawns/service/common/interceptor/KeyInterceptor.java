package com.fawns.service.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class KeyInterceptor implements WebRequestInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(KeyInterceptor.class);

	@Override
	public void afterCompletion(WebRequest webRequest, Exception exception) throws Exception {
		String key = webRequest.getParameter("key");
		logger.info("key:" + key);
	}

	@Override
	public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
		String key = webRequest.getParameter("key");
		logger.info("key:" + key);
	}

	@Override
	public void preHandle(WebRequest webRequest) throws Exception {
		String key = webRequest.getParameter("key");
		logger.info("key:" + key);
	}

}
