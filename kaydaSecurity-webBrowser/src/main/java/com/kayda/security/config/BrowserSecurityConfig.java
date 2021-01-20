package com.kayda.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kayda.security.property.SecurityMultiProperties;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SecurityMultiProperties securityMultiProperties;
	@Autowired
	private AuthenticationSuccessHandler kaydaBrowserAuthenticationSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler kaydaBrowserAuthenticationFailureHandler;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		//.loginPage("/security/login/loginIn.html")//指定自定义登录页面
		.loginPage("/auth/require")
		.loginProcessingUrl("/authentication/form")//使用自己的登录页面请求，替换原来过滤器的默认请求
		.successHandler(kaydaBrowserAuthenticationSuccessHandler)//登录成功如何处理
		.failureHandler(kaydaBrowserAuthenticationFailureHandler)//登录失败如何处理
			.and()
			.authorizeRequests()
			//.antMatchers("/security/login/loginIn.html").permitAll()//允许访问的资源，不需身份认证
			.antMatchers("/auth/require",
					securityMultiProperties.getBrowserConfig().getLoginPage()).permitAll()
			.anyRequest()
			.authenticated()
			.and().csrf().disable();
	}
}
