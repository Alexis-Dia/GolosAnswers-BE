package com.golosanswers.portal.rest.controller.authentication;

import com.golosanswers.portal.RestNavigation;
import com.golosanswers.portal.dto.authentication.AuthenticationDto;
import com.golosanswers.portal.dto.authentication.HandshakeDto;
import com.golosanswers.portal.dto.user.UserDto;
import com.golosanswers.portal.rest.configuration.security.TokenAuthentication;
import com.golosanswers.portal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final UserService userService;

	@Autowired
	public AuthenticationController(AuthenticationManager authenticationManager, UserService userService) {

		this.authenticationManager = authenticationManager;
		this.userService = userService;
	}

	@PostMapping(RestNavigation.AUTHENTICATE)
	public HandshakeDto authenticate(@RequestBody AuthenticationDto authenticationDto) {

		String username = authenticationDto.getUsername();
		String password = authenticationDto.getPassword();

		TokenAuthentication authentication = (TokenAuthentication) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		UserDto user = userService.getUser(username);

		return new HandshakeDto(authentication.getToken(), user.getRole().access(), user.getUsername(), user.getLanguage());
	}
}
