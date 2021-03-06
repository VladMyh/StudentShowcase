package com.studentshowcase.restcontroller.controller;

import com.studentshowcase.model.user.User;
import com.studentshowcase.restcontroller.security.jwt.JwtAuthenticationRequest;
import com.studentshowcase.restcontroller.security.jwt.JwtAuthenticationResponse;
import com.studentshowcase.restcontroller.security.jwt.JwtTokenUtil;
import com.studentshowcase.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

	private static final Logger LOGGER = Logger.getLogger(AuthController.class);

	@Value("${jwt.header}")
	private String tokenHeader;

	private AuthenticationManager authenticationManager;
	private JwtTokenUtil jwtTokenUtil;
	private UserDetailsService userDetailsService;
	private UserService userService;

	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Autowired
	public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Autowired
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/user")
	public ResponseEntity<?> user(@RequestBody JwtAuthenticationRequest authenticationRequest) {
		LOGGER.info("Trying to authenticate user");

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authenticationRequest.getEmail(),
						authenticationRequest.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtAuthenticationResponse(token, userDetails.getAuthorities().iterator().next().toString()));
	}

	@RequestMapping(value = "/user/me", method = RequestMethod.GET)
	public ResponseEntity<?> getCurrentUserInfo(@RequestHeader("Authorization") String token) {
		LOGGER.info("Getting info about current user");

		String email = jwtTokenUtil.getUsernameFromToken(token);
		User user = userService.getUserByEmail(email);
		user.setPassword(null);

		return ResponseEntity.ok(user);
	}
}
