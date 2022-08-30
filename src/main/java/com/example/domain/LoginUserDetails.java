package com.example.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// UserDetailsをimplementsする
public class LoginUserDetails implements UserDetails {

	private final LoginUser loginUser;
	private final Collection<? extends GrantedAuthority> authorities;

	public LoginUserDetails(LoginUser loginUser) {
		this.loginUser = loginUser;
		this.authorities = loginUser.getAuthorityList().stream().map(role -> new SimpleGrantedAuthority(role)).toList();
	}

	public LoginUser getLoginUser() {
		return this.loginUser;
	}

	@Override
	public String getUsername() {
		return this.loginUser.getUserName();
	}

	@Override
	public String getPassword() {
		return this.loginUser.getPassword();
	}

	@Override // ユーザーが持つrole一覧を返す
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override // ユーザーが認証切れでなければtrueを返す
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override // ユーザーがロックされていなければtrueを返す
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override // ユーザーのパスワードが認証切れでなければtrueを返す
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override // ユーザーが有効であればtrueを返す
	public boolean isEnabled() {
		return true;
	}

}
