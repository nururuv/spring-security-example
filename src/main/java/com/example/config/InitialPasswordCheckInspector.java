package com.example.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.domain.LoginUserDetails;

public class InitialPasswordCheckInspector implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		Authentication authentication = (Authentication)request.getUserPrincipal();
		
		if(authentication != null) {
			Object principal = authentication.getPrincipal();
			if(principal instanceof LoginUserDetails) {
				LoginUserDetails loginUserDetails = (LoginUserDetails) principal;
				if(loginUserDetails.getLoginUser().isInitialPasswordFlag()) {
					response.sendRedirect(request.getContextPath() + "/login/initial");
					return false;
				}
			}
		}
		return true;
	}

}
