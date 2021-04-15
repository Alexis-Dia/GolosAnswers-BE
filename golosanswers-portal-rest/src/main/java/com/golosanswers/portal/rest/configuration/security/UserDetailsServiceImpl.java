package com.golosanswers.portal.rest.configuration.security;

import com.golosanswers.portal.dto.user.UserDto;
import com.golosanswers.portal.dto.user.Role;
import com.golosanswers.portal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public UserDetailsServiceImpl(UserService userService) {

		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {

			UserDto user = userService.getUser(username);
			return new GolosanswersUserDetails(user);

		} catch (Exception e) {

			throw new UsernameNotFoundException("Username not found", e);
		}
	}
}
