package com.kayda.security.common.property.browser;

import com.kayda.security.property.LoginType;

public class BrowserProperties {
	
	private String loginPage = "/security/login/loginIn.html";

	private LoginType loginType=LoginType.JSON;
	
	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
	
	
	
}
