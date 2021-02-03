package com.kayda.security.common.property.validateImageCode;

public class ValidateImageCodeProperty {
	// 图片的宽度。 
	private static int width = 160; 
	// 图片的高度。 
	private static int height = 40; 
	// 验证码字符个数 
	private static int codeCount = 5; 
	// 验证码干扰线数 
	private static int lineCount = 150; 
	
	private int expireIn = 60;

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		ValidateImageCodeProperty.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		ValidateImageCodeProperty.height = height;
	}

	public static int getCodeCount() {
		return codeCount;
	}

	public static void setCodeCount(int codeCount) {
		ValidateImageCodeProperty.codeCount = codeCount;
	}

	public static int getLineCount() {
		return lineCount;
	}

	public static void setLineCount(int lineCount) {
		ValidateImageCodeProperty.lineCount = lineCount;
	}

	public int getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	
	

}
