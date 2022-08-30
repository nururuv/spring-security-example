package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.LoginUser;

@Mapper
public interface LoginMapper {
	public LoginUser login(String userName);

	public void changePassword(@Param("userName")String userName, @Param("password")String password);
}
