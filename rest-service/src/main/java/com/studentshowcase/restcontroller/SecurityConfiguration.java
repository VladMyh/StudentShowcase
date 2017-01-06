package com.studentshowcase.restcontroller;

import com.studentshowcase.restcontroller.security.CustomUserDetailsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@ComponentScan(basePackages = "com.studentshowcase.restcontroller.security")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = Logger.getLogger(SecurityConfiguration.class);

	private CustomUserDetailsService userDetailsService;

	@Autowired
	public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/auth").permitAll()
					.anyRequest().authenticated()
				.and()
				.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}
}
