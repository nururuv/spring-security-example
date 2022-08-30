
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	InitialPasswordCheckInspector initialPasswordCheckInspector() {
		return new InitialPasswordCheckInspector();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registory) {
		registory.addInterceptor(initialPasswordCheckInspector()).excludePathPatterns("/login/initial", "/login",
				"/changePassword");
	}
}
