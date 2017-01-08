package com.studentshowcase.restcontroller.security.jwt;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger LOGGER = Logger.getLogger(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest httpServletRequest,
						 HttpServletResponse httpServletResponse,
						 AuthenticationException e) throws IOException, ServletException {
		LOGGER.info("Unauthorized request from " + httpServletRequest.getRemoteAddr());

		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized request");
	}
}
