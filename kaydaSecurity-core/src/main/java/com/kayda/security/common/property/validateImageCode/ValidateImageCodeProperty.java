package com.kayda.security.common.property.validateImageCode;

public class ValidateImageCodeProperty {
	// 图片的宽度。 
	private int width = 160;
	// 图片的高度。 
	private int height = 40;
	// 验证码字符个数 
	private int codeCount = 5;
	// 验证码干扰线数 
	private int lineCount = 150;
	
	private int expireIn = 60;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCodeCount() {
		return codeCount;
	}

	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
}
