package com.studentshowcase.restcontroller.security.jwt;

public class JwtAuthenticationResponse {
	private final String token;
	private final String role;

	public JwtAuthenticationResponse(String token, String role) {
		this.token = token;
		this.role = role;
	}

	public String getToken() {
		return this.token;
	}

	public String getRole() {
		return role;
	}
}
