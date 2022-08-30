package com.example.config;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class LoginEventListener {

	/**
	 * 認証失敗時に呼ばれるメソッド（メソッド名はなんでもいい）
	 * @param event
	 */
	@EventListener
	public void authenticationFailureBadCredentialsEvent(AuthenticationFailureBadCredentialsEvent event) {
		System.out.println("認証失敗");
	}
	
	/**
	 * 認証成功時に呼ばれるメソッド（メソッド名はなんでもいい）
	 * @param event
	 */
	@EventListener
	public void authenticationSuccessEvent(AuthenticationSuccessEvent event) {
		System.out.println("認証成功");
	}
	/**
	 * その他
	 * AuthenticationFailureBadCredentialsEvent	BadCredentialsException	認証失敗
	 * AuthenticationFailureDisabledEvent	DisabledException	アカウント無効
	 * AuthenticationFailureLockedEvent	LockedException	アカウントロック
	 * AuthenticationFailureExpiredEvent	AccountExpiredException	アカウント有効期限切れ
	 * AuthenticationFailureCredentialsExpiredEvent	CredentialsExpiredException	資格情報の有効期限切れ
	 * AuthenticationFailureServiceExceptionEvent	AuthenticationServiceException	認証処理異常
	 */
}
