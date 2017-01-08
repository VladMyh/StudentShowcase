package com.studentshowcase.restcontroller.security.jwt;

public class JwtAuthenticationResponse {
	private final String token;

	public JwtAuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}
