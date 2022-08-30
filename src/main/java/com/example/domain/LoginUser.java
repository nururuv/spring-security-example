package com.example.domain;

import java.util.List;

import lombok.Data;

@Data
public class LoginUser{
	private String userName;
	private String password;
	private List<String> authorityList;
	private boolean initialPasswordFlag;
}
