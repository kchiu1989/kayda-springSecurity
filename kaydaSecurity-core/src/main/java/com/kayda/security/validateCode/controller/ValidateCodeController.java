package com.kayda.security.validateCode.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kayda.security.ValidateCodeImageUtil;
import com.kayda.security.property.SecurityMultiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.kayda.security.validateCode.entity.ValidateCodeImage;

@RestController
public class ValidateCodeController {

	@Autowired
	private SecurityMultiProperties securityMultiProperties;
	
	private static final String SESSION_VALIDATE_CODE_IMAGE_KEY = "SESSION_VALIDATE_CODE_IMAGE_KEY";
	
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	@GetMapping("/code/image")
	public void createValidateCode(HttpServletRequest request
			,HttpServletResponse response) throws IOException {
		ValidateCodeImage vci = createValidateCodeImage(new ServletWebRequest(request));
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_VALIDATE_CODE_IMAGE_KEY, vci);
		ImageIO.write(vci.getImage(), "JPEG", response.getOutputStream());
		
		
	}
	
	private ValidateCodeImage createValidateCodeImage(ServletWebRequest request) {
		int width = ServletRequestUtils.getIntParameter(
				request.getRequest(),"width",securityMultiProperties.getValidateCodeConfig().getValidateImageCodeConfig().getWidth()
		);

		int height = ServletRequestUtils.getIntParameter(
				request.getRequest(),"height",securityMultiProperties.getValidateCodeConfig().getValidateImageCodeConfig().getHeight()
		);

		return ValidateCodeImageUtil.createBufferedImage(width,height,securityMultiProperties.getValidateCodeConfig().getValidateImageCodeConfig().getCodeCount(),
				securityMultiProperties.getValidateCodeConfig().getValidateImageCodeConfig().getExpireIn());
	}

}
