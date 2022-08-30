package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.LoginUser;
import com.example.domain.LoginUserDetails;
import com.example.mapper.LoginMapper;

// UserDetailsServiceをimplementsする
@Service
public class LoginService implements UserDetailsService{
	
	@Autowired
	LoginMapper loginMapper;

	/**
	 *  ログイン認証処理
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser loginUser =  loginMapper.login(username);
		if(loginUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new LoginUserDetails(loginUser);
	}
	
	public void changePasseord(String username, String password) {
		loginMapper.changePassword(username, password);
	}

}
