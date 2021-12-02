package com.kio.applications.validator.security;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * The Class CustomAuthenticationProvider.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);

	/**
	 * Instantiates a new custom authentication provider.
	 */
	public CustomAuthenticationProvider() {
		super();
	}

	/**
	 * Authenticate.
	 *
	 * @param authentication the authentication
	 * @return the authentication
	 * @throws AuthenticationException the authentication exception
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//TODO: buscar token en servicio de AWX 
		return new UsernamePasswordAuthenticationToken("test", "test");
	}

	/**
	 * Supports.
	 *
	 * @param authentication the authentication
	 * @return true, if successful
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}