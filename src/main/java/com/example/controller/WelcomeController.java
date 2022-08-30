package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.ChangePasswordForm;
import com.example.domain.LoginUser;
import com.example.domain.LoginUserDetails;
import com.example.service.LoginService;

@Controller
public class WelcomeController {
	@ModelAttribute("changePasswordForm")
	public ChangePasswordForm changePasswordForm() {
		return new ChangePasswordForm();
	}
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/login/success")
	public String loginSuccess() {
		return "top";
	}
	
	@GetMapping("/login/initial")
	public String loginInitial() {
		
		return "changeInitialPassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@ModelAttribute ChangePasswordForm changePasswordForm,@AuthenticationPrincipal LoginUserDetails loginUserDetails){
		
		LoginUser loginUser = loginUserDetails.getLoginUser();
		String password =  passwordEncoder.encode(changePasswordForm.getPassword());
		loginService.changePasseord(loginUser.getUserName(), password);
		
		loginUser.setPassword(password);
		loginUser.setInitialPasswordFlag(false);
		
		return "redirect:/login/success";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin_only";
	}
	
}
