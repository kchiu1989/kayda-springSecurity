package com.kayda.security.common.property;

import com.kayda.security.common.property.validateImageCode.ValidateImageCodeProperty;

public class ValidateCodeProperties {
	private ValidateImageCodeProperty validateImageCodeConfig = new ValidateImageCodeProperty();

	public ValidateImageCodeProperty getValidateImageCodeConfig() {
		return validateImageCodeConfig;
	}

	public void setValidateImageCodeConfig(ValidateImageCodeProperty validateImageCodeConfig) {
		this.validateImageCodeConfig = validateImageCodeConfig;
	}
}
