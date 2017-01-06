package com.studentshowcase.restcontroller.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.token.DefaultToken;
import org.springframework.security.core.token.Token;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

	private static final Logger LOGGER = Logger.getLogger(AuthController.class);

	@RequestMapping("/user")
	public Token user(Principal user) {
		return new DefaultToken("token", System.currentTimeMillis(), user.getName());
	}
}

class UserCredentialsDTO {
	private String email;
	private String password;

	public UserCredentialsDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public UserCredentialsDTO() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
