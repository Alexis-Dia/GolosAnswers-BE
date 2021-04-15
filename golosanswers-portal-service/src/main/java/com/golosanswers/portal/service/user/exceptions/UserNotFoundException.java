package com.golosanswers.portal.service.user.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class UserNotFoundException extends GolosanswersException {

	public UserNotFoundException(String username) {

		super("Username [" + username + "] not found");
	}

	public UserNotFoundException(long id) {

		super("Username [" + id + "] not found");
	}
}
