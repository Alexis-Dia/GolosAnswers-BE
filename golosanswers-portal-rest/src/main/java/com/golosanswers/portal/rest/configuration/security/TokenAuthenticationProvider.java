package com.golosanswers.portal.rest.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder encoder;
	private final TokenComponent tokenComponent;

	@Autowired
	public TokenAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder encoder, TokenComponent tokenComponent) {

		this.userDetailsService = userDetailsService;
		this.encoder = encoder;
		this.tokenComponent = tokenComponent;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String rawPassword = (String) authentication.getCredentials();

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (Objects.isNull(userDetails)) {
			throw new BadCredentialsException("Invalid username or password");
		}

		String encoodedPassword = userDetails.getPassword();

		boolean same = encoder.matches(rawPassword, encoodedPassword);
		if (!same) {
			throw new BadCredentialsException("Invalid username or password");
		}

		String token = tokenComponent.generateToken(username);

		return new TokenAuthentication(userDetails, token);
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
	}
}
