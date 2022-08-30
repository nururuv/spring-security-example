package com.example.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login  // フォーム認証の設定記述開始
				.loginPage("/login") //ログインページの指定
				.loginProcessingUrl("/login/process") //ログイン処理のパス（このURLにリクエストが送られると認証処理が実行される）
				.usernameParameter("user") // ログインページのユーザー名入力欄のname属性に指定する値
				.passwordParameter("pass") // ログインページのパスワード入力欄のname属性に指定する値
				.defaultSuccessUrl("/login/success", true)
				.permitAll()) // ログイン成功後のリダイレクト先URL 
			.authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()) 
					.permitAll()  // /css/**などはログイン無しでアクセス可能
				.mvcMatchers("/admin")
					.hasRole("AUTHORITY2")
				.anyRequest().authenticated()); // その他は認証が必要

		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}