package com.kio.applications.validator.security;

import java.io.Serializable;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * The Class CustomAuthenticationProvider.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9172159813867557655L;

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
		return null;
	}

	/**
	 * Supports.
	 *
	 * @param authentication the authentication
	 * @return true, if successful
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}