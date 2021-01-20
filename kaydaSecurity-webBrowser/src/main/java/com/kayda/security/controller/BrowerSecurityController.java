package com.kayda.security.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kayda.security.common.entity.CommonReturn;
import com.kayda.security.property.SecurityMultiProperties;

/**
 * 决定返回json或者自定义html页面
 * @author kayda
 *
 */
@RestController
public class BrowerSecurityController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private RequestCache requestCache = new HttpSessionRequestCache();
	
	private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
	
	@Autowired
	private SecurityMultiProperties securityMultiProperties;
	/**
	 *  当需要身份认证时跳转到这里
	 * @param request 
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/auth/require")
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
	public CommonReturn requireAuth(HttpServletRequest request,HttpServletResponse response) throws IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if(savedRequest!=null) {
			String targetUrl = savedRequest.getRedirectUrl();
			logger.info("引发跳转的存储的请求:{}",targetUrl);
			if(StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
				redirectStrategy.sendRedirect(request, response, securityMultiProperties.getBrowserConfig().getLoginPage());
				
			}
		}
		return new CommonReturn("访问的服务需要身份认证，请引导用户到登录页面");
	}
}
