package com.studentshowcase.restcontroller.security;

import com.studentshowcase.model.user.User;
import com.studentshowcase.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final static Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);

	private UserService userService;

	@Autowired
	public CustomUserDetailsService(UserService userService) {
		LOGGER.info("Initializing CustomUserDetailsService");
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		LOGGER.info("Loading user by email");

		User user = userService.getUserByEmail(email);

		if(user == null) {
			LOGGER.error("No user found with email: " + email);
			throw new UsernameNotFoundException("No user found with email: " + email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(),
																		user.getPassword(),
																		user.getIsEmailVerified(),//user.getIsActivated(), TODO: implement user activation
																		true,
																		true,
																		user.getIsActivated(),
																		getAuthorityes(user));
	}

	private List<GrantedAuthority> getAuthorityes(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		if(user.getStudentInfo() != null) {
			authorities.add(new SimpleGrantedAuthority("STUDENT"));
		}
		else if(user.getTeacherInfo() != null) {
			authorities.add(new SimpleGrantedAuthority("TEACHER"));
		}
		else if(user.getEmployerInfo() != null) {
			authorities.add(new SimpleGrantedAuthority("EMPLOYER"));
		}
		else if(user.getAdminInfo() != null) {
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
		}

		return authorities;
	}
}
