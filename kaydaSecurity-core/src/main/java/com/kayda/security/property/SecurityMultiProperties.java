package com.kayda.security.property;

import com.kayda.security.common.property.browser.BrowserProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="kayda.security")
public class SecurityMultiProperties {
	BrowserProperties browserConfig = new BrowserProperties();

	public BrowserProperties getBrowserConfig() {
		return browserConfig;
	}

	public void setBrowserConfig(BrowserProperties browserConfig) {
		this.browserConfig = browserConfig;
	}
	
	
}
