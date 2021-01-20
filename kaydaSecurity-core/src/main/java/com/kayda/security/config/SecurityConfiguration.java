package com.kayda.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.kayda.security.property.SecurityMultiProperties;

@Configuration
@EnableConfigurationProperties(SecurityMultiProperties.class)
public class SecurityConfiguration {

}
