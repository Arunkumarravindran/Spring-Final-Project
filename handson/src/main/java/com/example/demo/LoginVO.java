package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class LoginVO {
	String User_id;
	String Password;
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	}

