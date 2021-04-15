package com.golosanswers.portal.domain.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class DomainException extends GolosanswersException {

	public DomainException() {

		super();
	}

	public DomainException(String message) {

		super(message);
	}

	public DomainException(String message, Throwable cause) {

		super(message, cause);
	}

	public DomainException(Throwable cause) {

		super(cause);
	}
}
