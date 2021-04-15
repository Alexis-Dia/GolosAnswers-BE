package com.golosanswers.portal.service.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class EmailException extends GolosanswersException {

	public EmailException() {

		super();
	}

	public EmailException(String message) {

		super(message);
	}

	public EmailException(String message, Throwable cause) {

		super(message, cause);
	}

	public EmailException(Throwable cause) {

		super(cause);
	}
}
