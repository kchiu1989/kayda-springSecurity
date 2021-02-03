package com.kayda.security.property;

import com.kayda.security.common.property.ValidateCodeProperties;
import com.kayda.security.common.property.browser.BrowserProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="kayda.security")
public class SecurityMultiProperties {
	private BrowserProperties browserConfig = new BrowserProperties();

	private ValidateCodeProperties validateCodeConfig = new ValidateCodeProperties();

	public BrowserProperties getBrowserConfig() {
		return browserConfig;
	}

	public void setBrowserConfig(BrowserProperties browserConfig) {
		this.browserConfig = browserConfig;
	}

	public ValidateCodeProperties getValidateCodeConfig() {
		return validateCodeConfig;
	}

	public void setValidateCodeConfig(ValidateCodeProperties validateCodeConfig) {
		this.validateCodeConfig = validateCodeConfig;
	}
}
