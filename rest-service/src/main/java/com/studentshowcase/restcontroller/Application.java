package com.studentshowcase.restcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@ComponentScan(basePackages = {"com.studentshowcase"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.studentshowcase.repository")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf()
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").hasRole("WRITER")
								.antMatchers(HttpMethod.GET, "/**").hasRole("READER")
								.anyRequest().authenticated();
	}
}
